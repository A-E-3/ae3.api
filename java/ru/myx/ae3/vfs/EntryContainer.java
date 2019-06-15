package ru.myx.ae3.vfs;

import ru.myx.ae3.base.BaseList;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.base.BaseString;
import ru.myx.ae3.binary.TransferCopier;
import ru.myx.ae3.common.Value;
import ru.myx.ae3.know.Guid;
import ru.myx.ae3.reflect.Reflect;
import ru.myx.ae3.reflect.ReflectionExplicit;
import ru.myx.ae3.reflect.ReflectionManual;

/** @author myx */
@ReflectionManual
public interface EntryContainer extends Entry {

	/**
	 *
	 */
	@ReflectionExplicit
	static BaseObject PROTOTYPE = Reflect.classToBasePrototype(EntryContainer.class);

	/** @param key
	 * @return */
	@ReflectionExplicit
	Value<? extends TransferCopier> getContentAsBinary(final String key);

	/** @param key
	 * @return */
	@ReflectionExplicit
	default Value<? extends CharSequence> getContentAsText(final String key) {

		return this.getContentAsText(key, BaseString.EMPTY);
	}

	/** @param key
	 * @param defaultValue
	 * @return */
	@ReflectionExplicit
	Value<? extends CharSequence> getContentAsText(final String key, final CharSequence defaultValue);

	/** Works when isCollection() method returns TRUE.
	 *
	 * Should return NULL when isCollection() method returns FALSE.
	 *
	 * @param type
	 *
	 * @return */
	@ReflectionExplicit
	Value<? extends BaseList<Entry>> getContentCollection(final TreeReadType type);

	/** Works when isCollection() method returns TRUE.
	 *
	 * When "defaultMode" argument is NULL or canWrite is FALSE, should return NULL when given
	 * content element doesn't exist. Otherwise, valid entry will be returned and isExist() method
	 * can be used instead.
	 *
	 * Should return NULL when isCollection() method returns FALSE.
	 *
	 * @param key
	 * @param defaultMode
	 * @return */
	@ReflectionExplicit
	Value<? extends Entry> getContentElement(final String key, final TreeLinkType defaultMode);

	/** @param key
	 * @return */
	@ReflectionExplicit
	default BaseObject getContentPrimitive(final String key) {

		return this.getContentPrimitive(key, BaseObject.UNDEFINED);
	}

	/** @param key
	 * @param defaultValue
	 * @return */
	@ReflectionExplicit
	BaseObject getContentPrimitive(final String key, final BaseObject defaultValue);

	/** Works when isCollection() method returns TRUE.
	 *
	 * Should return NULL when isCollection() method returns FALSE.
	 *
	 * @param keyStart
	 *            scan from (including)
	 * @param keyStop
	 *            scan until (excluding)
	 * @param limit
	 *
	 * @param backwards
	 *            when 'true' the 'keyStart' parameter is supposed to be greater than 'keyStop'
	 *
	 * @param type
	 *
	 * @return */
	@ReflectionExplicit
	Value<? extends BaseList<Entry>> getContentRange(final String keyStart, final String keyStop, final int limit, final boolean backwards, final TreeReadType type);

	/** @param key
	 * @return */
	@ReflectionExplicit
	BaseObject getContentValue(final String key);

	@Override
	default boolean isContainer() {

		return true;
	}

	/** Returns TRUE when given container doesn't contain persistent (not cache nor product)
	 * entries.
	 *
	 * @return */
	@ReflectionExplicit
	boolean isContainerEmpty();

	/** @param key
	 * @param mode
	 * @param binary
	 * @return */
	@ReflectionExplicit
	Value<?> setContentBinary(final String key, final TreeLinkType mode, final TransferCopier binary);

	/** @param key
	 * @param entry
	 * @return */
	@ReflectionExplicit
	Value<?> setContentCachedHardlink(final String key, final Entry entry);

	/** Not every value can be primitive. Applicable only to values that can be stored in-line.
	 *
	 * @param key
	 * @param primitive
	 * @return */
	@ReflectionExplicit
	Value<?> setContentCachedPrimitive(final String key, final Object primitive);

	/** Creates container (directory) child entry.
	 *
	 * @param key
	 * @param mode
	 * @return */
	@ReflectionExplicit
	Value<?> setContentContainer(final String key, final TreeLinkType mode);

	/** @param key
	 * @param mode
	 * @param entry
	 * @return */
	@ReflectionExplicit
	Value<?> setContentHardlink(final String key, final TreeLinkType mode, final Entry entry);

	/** Not every value can be primitive. Applicable only to values that can be stored in-line.
	 *
	 * @param key
	 * @param mode
	 * @param primitive
	 * @return */
	@ReflectionExplicit
	Value<?> setContentPrimitive(final String key, final TreeLinkType mode, final Object primitive);

	/** @param key
	 * @param binary
	 * @return */
	@ReflectionExplicit
	default Value<?> setContentPublicTreeBinary(final String key, final TransferCopier binary) {

		return this.setContentBinary(key, TreeLinkType.PUBLIC_TREE_REFERENCE, binary);
	}

	/** @param key
	 * @param primitive
	 * @return */
	@ReflectionExplicit
	default Value<?> setContentPublicTreeBoolean(final String key, final Object primitive) {

		return this.setContentPrimitive(key, TreeLinkType.PUBLIC_TREE_REFERENCE, primitive);
	}

	/** @param key
	 * @param primitive
	 * @return */
	@ReflectionExplicit
	default Value<?> setContentPublicTreeDate(final String key, final Object primitive) {

		return this.setContentPrimitive(key, TreeLinkType.PUBLIC_TREE_REFERENCE, primitive);
	}

	/** @param key
	 * @param entry
	 * @return */
	@ReflectionExplicit
	default Value<?> setContentPublicTreeHardlink(final String key, final Entry entry) {

		return this.setContentHardlink(key, TreeLinkType.PUBLIC_TREE_REFERENCE, entry);
	}

	/** @param key
	 * @param primitive
	 * @return */
	@ReflectionExplicit
	default Value<?> setContentPublicTreeNumber(final String key, final Object primitive) {

		return this.setContentPrimitive(key, TreeLinkType.PUBLIC_TREE_REFERENCE, primitive);
	}

	/** Not every value can be primitive. Applicable only to values that can be stored in-line.
	 *
	 * @param key
	 * @param primitive
	 * @return */
	@ReflectionExplicit
	default Value<?> setContentPublicTreePrimitive(final String key, final Object primitive) {

		return this.setContentPrimitive(key, TreeLinkType.PUBLIC_TREE_REFERENCE, primitive);
	}

	/** @param key
	 * @param primitive
	 * @return */
	@ReflectionExplicit
	default Value<?> setContentPublicTreeString(final String key, final Object primitive) {

		return this.setContentPrimitive(key, TreeLinkType.PUBLIC_TREE_REFERENCE, primitive);
	}

	/** @param key
	 * @param value
	 * @return */
	@ReflectionExplicit
	default Value<?> setContentPublicTreeValue(final String key, final Object value) {

		if (value == BaseObject.UNDEFINED || value == null) {
			return this.setContentUndefined(key);
		}
		if (value instanceof CharSequence) {
			return this.setContentText(key, TreeLinkType.PUBLIC_TREE_REFERENCE, (CharSequence) value);
		}
		if (value instanceof TransferCopier) {
			return this.setContentBinary(key, TreeLinkType.PUBLIC_TREE_REFERENCE, (TransferCopier) value);
		}

		final Guid guid = value instanceof Guid
			? (Guid) value
			: Guid.forUnknown(value);
		if (guid != null && guid.isInline()) {
			return this.setContentPrimitive(key, TreeLinkType.PUBLIC_TREE_REFERENCE, guid);
		}

		throw new IllegalArgumentException("Don't know how to store, class: " + value.getClass().getName());
	}

	/** @param key
	 * @param mode
	 * @param text
	 * @return */
	@ReflectionExplicit
	Value<?> setContentText(final String key, final TreeLinkType mode, final CharSequence text);

	/** Deletes child entry.
	 *
	 * @param key
	 * @param mode
	 * @return */
	@ReflectionExplicit
	Value<?> setContentUndefined(final String key);

	@Override
	default EntryContainer toContainer() {

		return this;
	}

	/** @return */
	@ReflectionExplicit
	default boolean unlinkRecursive() {

		String keyStart = null;
		main : for (;;) {
			final BaseList<Entry> children = this.getContentRange(keyStart, null, 1024, false, TreeReadType.PERSISTENT).baseValue();

			final int length = children.length();
			if (length == 0) {
				break main;
			}
			for (int index = 0;; ++index) {
				final Entry child = children.get(index);
				assert child != this : "Entry contains itself as a child, entry=" + this;
				assert child.isExist() : "Should exist here!";
				if (child.isContainer()) {
					if (!child.toContainer().unlinkRecursive()) {
						return false;
					}
				} else {
					if ((index & 0x100) == 0) {
						/** avoid queue clogging */
						child.doUnlink().baseValue();
					} else {
						child.doUnlink();
					}
				}
				/* length is 1 - last element */
				if (index >= length - 2) {
					if (length == 1) {
						break main;
					}
					keyStart = children.get(index + 1).getKey();
					continue main;
				}
			}
		}
		return this.doUnlink().baseValue().booleanValue();
	}
}
