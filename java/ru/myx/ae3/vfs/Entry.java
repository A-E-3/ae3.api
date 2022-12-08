package ru.myx.ae3.vfs;

import java.nio.file.Path;
import java.util.StringTokenizer;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseDate;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.base.BaseString;
import ru.myx.ae3.binary.Transfer;
import ru.myx.ae3.binary.TransferCopier;
import ru.myx.ae3.common.Value;
import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.reflect.Reflect;
import ru.myx.ae3.reflect.ReflectionExplicit;
import ru.myx.ae3.reflect.ReflectionHidden;
import ru.myx.ae3.reflect.ReflectionManual;

/** @author myx */
@ReflectionManual
public interface Entry extends EntryChange /* FIXME: temporarily, decouple later */ {

	/**
	 *
	 */
	@ReflectionExplicit
	static BaseObject PROTOTYPE = Reflect.classToBasePrototype(Entry.class);

	/** - empty path returns not 'this' but 'null';
	 *
	 * - paths starting with '/' return 'null' if share is null
	 *
	 * @param share
	 * @param focus
	 * @param path
	 * @param mode
	 * @return */
	@ReflectionHidden
	static Entry relative(final Entry share, final Entry focus, final String path, final TreeLinkType mode) {

		if (path == null) {
			throw new NullPointerException("'path' is null!");
		}
		if (path.length() == 0) {
			return null;
		}
		Entry current;

		if (path.charAt(0) == '/') {
			if (share == null) {
				return null;
			}
			current = share;
		} else {
			current = focus;
		}

		if (!current.isContainer()) {
			if (mode == null) {
				return null;
			}
			throw new IllegalArgumentException(
					(current.isExist()
						? "Not a container: "
						: "Doesn't exist: ") + current.getLocation());
		}
		for (final StringTokenizer tokenizer = new StringTokenizer(path, "/"); tokenizer.hasMoreTokens();) {
			final String part = tokenizer.nextToken();
			final int length = part.length();
			if (length == 0) {
				continue;
			}
			if (length == 1 && '.' == part.charAt(0)) {
				continue;
			}
			if (length == 2 && '.' == part.charAt(0) && '.' == part.charAt(1)) { // "..".equals(part)
				if (current == share) {
					if (mode == null) {
						return null;
					}
					throw new IllegalArgumentException("Cannot go upper than share!");
				}
				current = current.getParent();
				assert current != null : "NULL parent is unexpected!";
				if (!current.isExist()) {
					if (mode == null) {
						return null;
					}
					throw new IllegalArgumentException("doesn't exist: " + current.getLocation());
				}
			} else {
				if (mode != null && !current.isContainer() && current.isExist()) {
					throw new IllegalArgumentException("Not a container: " + current.getLocation());
				}
				final Value<? extends Entry> element = current.toContainer().getContentElement(part, mode);
				if (mode != null && element instanceof Entry && !tokenizer.hasMoreTokens()) {
					return (Entry) element;
				}
				current = element.baseValue();
				assert mode == null || current != null : "Should not create NULL entries when mode is not NULL";
				if (current == null) {
					return null;
				}
				if (mode == null && !current.isExist()) {
					return null;
				}
			}
		}
		return current;

	}

	/** TODO replace with createChange(EntryChange parentChange);
	 *
	 * Returns ability to make changes in given node.
	 *
	 * @return */
	@ReflectionExplicit
	boolean canWrite();

	/** Creates cloned entry with parent equal to passed one
	 *
	 * @param parent
	 * @param key
	 * @param mode
	 *
	 * @return */
	@ReflectionExplicit
	Entry clone(Entry parent, String key, TreeLinkType mode);

	/** moves/renames given entry.
	 *
	 * @param newEntry
	 *
	 * @return succeeds only if both entries are located in the same storage. */
	@ReflectionExplicit
	Value<Boolean> doMoveRename(Entry newEntry);

	/** renames given entry. Equivalent to:
	 *
	 * <pre>
	 * entry.getParent().toContainer().setContentRename(entry.getKey(), newKey)
	 * </pre>
	 *
	 * @param newKey
	 *
	 * @return */
	@ReflectionExplicit
	Value<Boolean> doRename(String newKey);

	/** Tries to return binary content for any possible type of entry.
	 *
	 * If entry is character - the UTF-8 character set is used.
	 *
	 * @return
	 * @throws UnsupportedOperationException */
	@ReflectionExplicit
	default Value<? extends TransferCopier> getBinaryContent() throws UnsupportedOperationException {

		if (this.isBinary()) {
			final EntryBinary binary = this.toBinary();
			if (binary != null) {
				return binary.getBinaryContent();
			}
		}
		if (this.isCharacter()) {
			final EntryCharacter character = this.toCharacter();
			if (character != null) {
				return Transfer.createCopierUtf8(character.getText());
			}
		}
		if (this.isPrimitive()) {
			final EntryPrimitive primitive = this.toPrimitive();
			if (primitive != null) {
				final Object object = primitive.getPrimitiveValue();
				if (object instanceof BaseObject) {
					return Transfer.createCopierUtf8(((BaseObject) object).baseToJavaString());
				}
				return Transfer.createCopierUtf8(String.valueOf(object));
			}
		}
		if (this.isFile()) {
			final EntryBinary binary = this.toBinary();
			if (binary != null) {
				return binary.getBinaryContent();
			}
			/** <code>
			} else// if(this.isFolder())
			{
			final EntryBinary binary = this.relativeBinary("$value");
			if (binary != null) {
				return binary.getBinaryContent();
			}
			</code> */
		}
		throw new UnsupportedOperationException("Can't produce binary content, entryClass: " + this.getClass().getSimpleName());
	}

	/** Returns entry key. Returns NULL when this entry is a root entry.
	 *
	 * @return key */
	@ReflectionExplicit
	String getKey();

	/** Returns 'last-modified' date of given link.
	 *
	 * @return */
	@ReflectionExplicit
	long getLastModified();

	/** Returns location path in hierarchy. '' for root entry and so on separated by '/'.
	 *
	 * @return location */
	@ReflectionExplicit
	String getLocation();

	/** @return */
	@ReflectionExplicit
	TreeLinkType getMode();

	/** Returns parent entry of this entry. Returns NULL when this entry is a root entry.
	 *
	 * @return parent entry */
	@ReflectionExplicit
	Entry getParent();

	/** Works when isPrimitive() method returns TRUE.
	 *
	 * Value is always immediately available, so return type is Object.
	 *
	 * @return */
	@ReflectionHidden
	default Object getPrimitiveValue() {

		return null;
	}

	/** Version for scripting
	 *
	 * @param ctx
	 * @return */
	@ReflectionExplicit
	default BaseObject getPrimitiveValue(final ExecProcess ctx) {

		return BaseObject.UNDEFINED;
	}

	/** Tries to return text content for any possible type of entry.
	 *
	 * If entry is binary - the UTF-8 character set is used.
	 *
	 * @return
	 * @throws UnsupportedOperationException */
	@ReflectionExplicit
	default Value<? extends CharSequence> getTextContent() throws UnsupportedOperationException {

		if (this.isCharacter()) {
			final EntryCharacter character = this.toCharacter();
			if (character != null) {
				return character.getTextContent();
			}
		}
		if (this.isBinary()) {
			final EntryBinary binary = this.toBinary();
			if (binary != null) {
				return Base.forString(binary.getBinary().toStringUtf8());
			}
		}
		if (this.isPrimitive()) {
			final EntryPrimitive primitive = this.toPrimitive();
			if (primitive != null) {
				final Object object = primitive.getPrimitiveValue();
				if (object instanceof BaseString) {
					return (BaseString<?>) object;
				}
				if (object instanceof BaseObject) {
					return ((BaseObject) object).baseToString();
				}
				return Base.forString(String.valueOf(object));
			}
		}
		if (this.isFile()) {
			final EntryCharacter character = this.toCharacter();
			if (character != null) {
				return character.getTextContent();
			}
			/** <code>
			} else// if(this.isFolder())
			{
			final CharSequence text = this.relativeText("$value");
			if (text != null) {
				return Base.forString(text);
			}
			</code> */
		}
		throw new UnsupportedOperationException("Can't produce text content, entryClass: " + this.getClass().getSimpleName());
	}

	/** Returns the 'value' of the entry. For primitive entries (isPrimitive() returns true) the
	 * value is it's primitive value. For binary entries the value returned is 'isBinary' value.
	 *
	 * For entries that are not known to have meaningful 'value' (like container entries) an
	 * Exception must be thrown.
	 *
	 * TODO: make 'container' entries return BaseVfsFolderObject with recursive properties by
	 * getValue().
	 *
	 * @return */
	@ReflectionExplicit
	default Object getValue() {

		if (this.isPrimitive()) {
			return this.getPrimitiveValue();
		}
		if (this.isCharacter()) {
			return this.getTextContent();
		}
		if (this.isBinary()) {
			return this.getBinaryContent();
		}
		throw new UnsupportedOperationException("Entry doesn't have meaningful value: " + this);
	}

	/** Indicates whether this Entry is exist and has binary content.
	 *
	 * @return */
	@ReflectionExplicit
	default boolean isBinary() {

		return false;
	}

	/** Indicates whether this Entry is exist and has text content. (not all storages support
	 * explicit text content).
	 *
	 * Which is either isPrimitive and the primitive is an instance of String or BinaryText with
	 * known charset encoding.
	 *
	 * @return */
	@ReflectionExplicit
	default boolean isCharacter() {

		return false;
	}

	/** Indicates whether this Entry is exist and is a collection.
	 *
	 * @return */
	@ReflectionExplicit
	default boolean isContainer() {

		return false;
	}

	/** Indicates whether this Entry exists on persistent storage.
	 *
	 * @return */
	@ReflectionExplicit
	default boolean isExist() {

		return false;
	}

	/** Indicates whether this Entry is exist and is a file (primitive or binary), not a collection.
	 *
	 * @return */
	@ReflectionExplicit
	default boolean isFile() {

		return false;
	}

	/** Indicates whether this Entry is hidden.
	 *
	 * @return */
	@ReflectionExplicit
	default boolean isHidden() {

		return false;
	}

	/** Indicates whether this Entry is a mount.
	 *
	 * @return */
	@ReflectionExplicit
	default boolean isMount() {

		return false;
	}

	/** Indicates whether this Entry is exist and has primitive content.
	 *
	 * @return */
	@ReflectionExplicit
	default boolean isPrimitive() {

		return false;
	}

	/** @param path
	 * @return */
	@ReflectionExplicit
	default Entry relative(final String path) {

		return this.relative(path, null);
	}

	/** - empty path returns not 'this' but 'null';
	 *
	 * - paths starting with '/' are still relative to 'this' entry.
	 *
	 * @param path
	 * @param mode
	 * @return */
	@ReflectionExplicit
	default Entry relative(final String path, final TreeLinkType mode) {

		return Entry.relative(this, this, path, mode);
	}

	/** TODO: add default value and make use of java/async
	 *
	 * @param ctx
	 *
	 * @param path
	 * @return */
	@ReflectionExplicit
	default Value<? extends TransferCopier> relativeBinary(final ExecProcess ctx, final String path) {

		return this.relativeFile(path).getBinaryContent();
	}

	/** TODO: add default value and make use of java/async
	 *
	 * @param ctx
	 *
	 * @param path
	 * @return */
	@ReflectionHidden
	default TransferCopier relativeBinary(final String path) {

		return this.relativeFile(path).toBinary().getBinary();
	}

	/** @param path
	 * @return */
	@ReflectionExplicit
	default Entry relativeFile(final String path) {

		return this.relative(path, TreeLinkType.PUBLIC_TREE_REFERENCE);
	}

	/** Cannot traverse above 'this'.
	 *
	 * @param path
	 * @return */
	@ReflectionHidden
	default Entry relativeFileEnsure(final Path path) {

		return null;
	}

	/** Cannot traverse above 'this'.
	 *
	 * @param path
	 * @return */
	@ReflectionExplicit
	default Entry relativeFileEnsure(final String path) {

		final Entry result = this.relative(path, TreeLinkType.PUBLIC_TREE_REFERENCE);
		if (!result.isExist() && result.doSetBinary(TransferCopier.NUL_COPIER).baseValue() != Boolean.TRUE) {
			throw new RuntimeException("Can't create an empty file: " + result);
		}
		return result;
	}

	/** @param path
	 * @return */
	@ReflectionExplicit
	default EntryContainer relativeFolder(final String path) {

		return this.relative(path, TreeLinkType.PUBLIC_TREE_REFERENCE).toContainer();
	}

	/** Cannot traverse above 'this'.
	 *
	 * @param path
	 * @return */
	@ReflectionHidden
	default EntryContainer relativeFolderEnsure(final Path path) {

		return null;
	}

	/** Cannot traverse above 'this'.
	 *
	 * @param path
	 * @return */
	@ReflectionExplicit
	default EntryContainer relativeFolderEnsure(final String path) {

		final EntryContainer result = this.relative(path, TreeLinkType.PUBLIC_TREE_REFERENCE).toContainer();
		if (!result.isExist() && result.doSetContainer().baseValue() != Boolean.TRUE) {
			throw new RuntimeException("Can't create a folder: " + result);
		}
		return result;
	}

	/** TODO: add default value and make use of java/async
	 *
	 * @param ctx
	 *
	 * @param path
	 * @return */
	@ReflectionExplicit
	default Object relativePrimitive(final ExecProcess ctx, final String path) {

		return this.relativeFile(path).toPrimitive().getPrimitiveValue(ctx);
	}

	/** @param path
	 * @return */
	@ReflectionHidden
	default Object relativePrimitive(final String path) {

		return this.relativeFile(path).toPrimitive().getPrimitiveValue();
	}

	/** @param path
	 * @return */
	@ReflectionExplicit
	default Entry relativeField(final String path) {

		return this.relative(path, TreeLinkType.PUBLIC_FIELD_REFERENCE);
	}

	/** TODO: add default value and make use of java/async
	 *
	 * @param ctx
	 *
	 * @param path
	 * @return */
	@ReflectionExplicit
	default Value<? extends CharSequence> relativeText(final ExecProcess ctx, final String path) {

		return this.relativeFile(path).getTextContent();
	}

	/** TODO: add default value and make use of java/async
	 *
	 * @param ctx
	 *
	 * @param path
	 * @return */
	@ReflectionHidden
	default CharSequence relativeText(final String path) {

		return this.relativeFile(path).toCharacter().getText();
	}

	/** Works when isBinary() method returns TRUE.
	 *
	 * Returns binary entry instance.
	 *
	 * NOTE: use this method, "instanceof EntryBinary" will not work well, since implementation is
	 * free to implement any interfaces on actual entry for it's own purposes and/or memory
	 * utilization optimization.
	 *
	 * @return */
	@ReflectionExplicit
	default EntryBinary toBinary() {

		return null;
	}

	/** Works when isText() method returns TRUE.
	 *
	 * Returns a text entry instance.
	 *
	 * NOTE: use this method, "instanceof EntryText" will not work well, since implementation is
	 * free to implement any interfaces on actual entry for it's own purposes and/or memory
	 * utilization optimization. `
	 *
	 * @return */
	@ReflectionExplicit
	default EntryCharacter toCharacter() {

		return null;
	}

	/** Works when isContainer() method returns TRUE.
	 *
	 * Returns container entry instance.
	 *
	 * NOTE: use this method, "instanceof EntryContainer" will not work well, since implementation
	 * is free to implement any interfaces on actual entry for it's own purposes and/or memory
	 * utilization optimization.
	 *
	 * @return */
	@ReflectionExplicit
	default EntryContainer toContainer() {

		return null;
	}

	/** Works when isMount() method returns TRUE.
	 *
	 * Returns mount entry instance.
	 *
	 * NOTE: use this method, "instanceof EntryMount" will not work well, since implementation is
	 * free to implement any interfaces on actual entry for it's own purposes and/or memory
	 * utilization optimization.
	 *
	 * @return */
	@ReflectionExplicit
	default EntryMount toMount() {

		return null;
	}

	/** Works when isPrimitive() method returns TRUE.
	 *
	 * Returns primitive entry instance.
	 *
	 * NOTE: use this method, "instanceof EntryPrimitive" will not work well, since implementation
	 * is free to implement any interfaces on actual entry for it's own purposes and/or memory
	 * utilization optimization. `
	 *
	 * @return */
	@ReflectionExplicit
	default EntryPrimitive toPrimitive() {

		return null;
	}

	/** TODO: add default value and make use of java/async
	 *
	 * @param ctx
	 *
	 * @param path
	 * @param primitive
	 * @return */
	@ReflectionExplicit
	default Object updateRelativeDate(final ExecProcess ctx, final String path, final Object primitive) {

		final Entry e = this.relativeFile(path);
		if (e.isPrimitive() && BaseDate.equalsGeneric(primitive, e.toPrimitive().getPrimitiveValue(ctx))) {
			return primitive;
		}
		e.doSetDate(primitive);
		return primitive;
	}

	/** TODO: add default value and make use of java/async
	 *
	 * @param ctx
	 *
	 * @param path
	 * @param primitive
	 * @return */
	@ReflectionExplicit
	default Object updateRelativePrimitive(final ExecProcess ctx, final String path, final BaseObject primitive) {

		final Entry e = this.relativeFile(path);
		if (e.isPrimitive() && primitive == e.toPrimitive().getPrimitiveValue(ctx)) {
			return primitive;
		}
		e.doSetPrimitive(primitive);
		return primitive;
	}

	/** TODO: add default value and make use of java/async
	 *
	 * @param ctx
	 *
	 * @param path
	 * @param text
	 * @return */
	@ReflectionExplicit
	default Object updateRelativeText(final String path, final CharSequence text) {

		final Entry e = this.relativeFile(path);
		if (e.isPrimitive() && text.equals(e.toCharacter().getText())) {
			return text;
		}
		e.doSetText(text);
		return text;
	}

}
