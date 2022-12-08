package ru.myx.ae3.vfs;

import ru.myx.ae3.AbstractSAPI;
import ru.myx.ae3.Engine;
import ru.myx.ae3.base.BaseList;
import ru.myx.ae3.binary.TransferCopier;
import ru.myx.ae3.exec.Exec;
import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.vfs.ars.ArsArray;
import ru.myx.ae3.vfs.ars.ArsRecord;
import ru.myx.ae3.vfs.ars.ArsReference;
import ru.myx.ae3.vfs.ars.ArsStorageImpl;

/** @author myx */
public class Storage extends AbstractSAPI {

	private static final String SLASH = "/";

	/** path: / intentionally container, use casting to EntryVirtual to mount */
	static final EntryVfsRoot ROOT;

	/** path: /public, mount for %PUBLIC% */
	public static final EntryContainer PUBLIC;

	/** %PUBLIC%/resources */
	public static final EntryContainer PUBLIC_RESOURCES;

	/** %PUBLIC%/resources/lib */
	public static final EntryContainer PUBLIC_LIB;

	/** %PUBLIC%/settings */
	public static final EntryContainer PUBLIC_SETTINGS;

	/** path: /protected, mount for %PROTECTED% */
	public static final EntryContainer PROTECTED;

	/** %PROTECTED%/resources */
	public static final EntryContainer PROTECTED_RESOURCES;

	/** %PROTECTED%/resources/lib */
	public static final EntryContainer PROTECTED_LIB;

	/** %PROTECTED%/settings */
	public static final EntryContainer PROTECTED_SETTINGS;

	/** path: /private, mount for %PRIVATE% */
	public static final EntryContainer PRIVATE;

	/** path: /shared, mount for %SHARED% */
	public static final EntryContainer SHARED;

	/** path: /union, mount for %UNION% */
	public static final EntryContainer UNION;

	/** %UNION%/resources */
	public static final EntryContainer UNION_RESOURCES;

	/** %UNION%/resources/lib */
	public static final EntryContainer UNION_LIB;

	/** %UNION%/settings */
	public static final EntryContainer UNION_SETTINGS;

	private static final AbstractStorageImpl IMPL;

	static {
		/** this block should go last */
		{
			IMPL = AbstractSAPI.createObject("ru.myx.ae3.vfs.ImplementStorage");
		}
	}

	static {
		final EntryVfsRoot root = Storage.IMPL.getRoot();
		final EntryContainer real = root.toContainer();
		ROOT = root;

		Exec.getRootProcess().fldVfsRoot = root;

		assert root.getParent() == null : "Root entry should have no parent!";
		{
			PUBLIC = Storage.mount(root, "public", TreeLinkType.PUBLIC_TREE_REFERENCE, Storage.IMPL.createFileSystemRoot(Engine.PATH_PUBLIC, true)).toContainer();

			assert Storage.PUBLIC.isExist() : "/public path doesn't exists: " + Storage.PUBLIC;
			assert Storage.PUBLIC.isContainer() : "/public is not a container: " + Storage.PUBLIC;
			assert Storage.PUBLIC.getParent() == real : "/public parent expected to be ROOT, but: " + Storage.PUBLIC.getParent();

			PUBLIC_RESOURCES = Storage.PUBLIC.relative("resources", TreeLinkType.PUBLIC_TREE_REFERENCE).toContainer();
			/** public is read-only and its contents are predefined */
			// Storage.PUBLIC_RESOURCES.doSetContainer().baseValue();

			PUBLIC_LIB = Storage.PUBLIC_RESOURCES.relative("lib", TreeLinkType.PUBLIC_TREE_REFERENCE).toContainer();
			/** public is read-only and its contents are predefined */
			// Storage.PUBLIC_LIB.doSetContainer().baseValue();

			PUBLIC_SETTINGS = Storage.PUBLIC.relative("settings", TreeLinkType.PUBLIC_TREE_REFERENCE).toContainer();
			/** public is read-only and its contents are predefined */
			// Storage.PUBLIC_SETTINGS.doSetContainer().baseValue();
		}
		{
			PROTECTED = Storage.mount(root, "protected", TreeLinkType.PUBLIC_TREE_REFERENCE, Storage.IMPL.createFileSystemRoot(Engine.PATH_PROTECTED, false)).toContainer();

			/** doesn't work and should anyway be created by Engine */
			// Storage.PROTECTED.doSetContainer().baseValue();

			assert Storage.PROTECTED.isExist() : "/protected path doesn't exists: " + Storage.PROTECTED;
			assert Storage.PROTECTED.isContainer() : "/protected is not a container: " + Storage.PROTECTED;
			assert Storage.PROTECTED.getParent() == real : "/protected parent expected to be ROOT, but: " + Storage.PROTECTED.getParent();

			PROTECTED_RESOURCES = Storage.PROTECTED.relative("resources", TreeLinkType.PUBLIC_TREE_REFERENCE).toContainer();
			Storage.PROTECTED_RESOURCES.doSetContainer().baseValue();

			PROTECTED_LIB = Storage.PROTECTED_RESOURCES.relative("lib", TreeLinkType.PUBLIC_TREE_REFERENCE).toContainer();
			Storage.PROTECTED_LIB.doSetContainer().baseValue();

			PROTECTED_SETTINGS = Storage.PROTECTED.relative("settings", TreeLinkType.PUBLIC_TREE_REFERENCE).toContainer();
			Storage.PROTECTED_SETTINGS.doSetContainer().baseValue();

		}
		{
			PRIVATE = Storage.mount(root, "private", TreeLinkType.PUBLIC_TREE_REFERENCE, Storage.IMPL.createFileSystemRoot(Engine.PATH_PRIVATE, false)).toContainer();

			/** doesn't work and should anyway be created by Engine */
			// Storage.PRIVATE.doSetContainer().baseValue();

			assert Storage.PRIVATE.isExist() : "/private path doesn't exists: " + Storage.PRIVATE;
			assert Storage.PRIVATE.isContainer() : "/private is not a container: " + Storage.PRIVATE;
			assert Storage.PRIVATE.getParent() == real : "/private parent expected to be ROOT, but: " + Storage.PRIVATE.getParent();

		}
		{
			SHARED = Storage.mount(root, "shared", TreeLinkType.PUBLIC_TREE_REFERENCE, Storage.IMPL.createFileSystemRoot(Engine.PATH_SHARED, false)).toContainer();

			/** doesn't work and should anyway be created by Engine */
			// Storage.SHARED.doSetContainer().baseValue();

			assert Storage.SHARED.isExist() : "/shared path doesn't exists: " + Storage.SHARED;
			assert Storage.SHARED.isContainer() : "/shared is not a container: " + Storage.SHARED;
			assert Storage.SHARED.getParent() == real : "/shared parent expected to be ROOT, but: " + Storage.SHARED.getParent();

			// assert Storage.SHARED == Storage.getAbsolute( "/shared", null ) :
			// "/shared is not equal: expected="
			// + Storage.SHARED
			// + ", observed="
			// + Storage.getAbsolute( "/shared", null );
		}
		{
			final EntryContainer[] stack = new EntryContainer[]{//
					Storage.PRIVATE, //
					Storage.SHARED, //
					Storage.PROTECTED, //
					Storage.PUBLIC, //
			};

			UNION = Storage.mount(
					root, //
					"union",
					TreeLinkType.PUBLIC_TREE_REFERENCE,
					Storage.IMPL.createUnionRoot(stack)).toContainer();

			/** doesn't work and should anyway be created by Engine */
			// Storage.UNION.doSetContainer().baseValue();

			assert Storage.UNION.isExist() : "/union path doesn't exists: " + Storage.UNION;
			assert Storage.UNION.isContainer() : "/union is not a container: " + Storage.UNION;
			assert Storage.UNION.getParent() == real : "/union parent expected to be ROOT, but: " + Storage.UNION.getParent();

			UNION_RESOURCES = Storage.UNION.relative("resources", TreeLinkType.PUBLIC_TREE_REFERENCE).toContainer();
			// Storage.UNION_RESOURCES.doSetContainer().baseValue();

			UNION_LIB = Storage.UNION_RESOURCES.relative("lib", TreeLinkType.PUBLIC_TREE_REFERENCE).toContainer();
			// Storage.UNION_LIB.doSetContainer().baseValue();

			UNION_SETTINGS = Storage.UNION.relative("settings", TreeLinkType.PUBLIC_TREE_REFERENCE).toContainer();
			// Storage.UNION_SETTINGS.doSetContainer().baseValue();

		}

		Storage.IMPL.postInit();
	}

	/** @param source
	 * @param target
	 * @return */
	public static final//
	boolean copy(final Entry source, final Entry target) {

		if (!source.isExist()) {
			return false;
		}
		if (source.isContainer()) {
			if (!target.isContainer()) {
				target.doSetContainer().baseValue();
			}
			final EntryContainer container = source.toContainer();
			assert container != null : "Container is null!";
			ls : for (String starting = null;;) {
				final BaseList<Entry> records = container.getContentRange(
						starting, //
						null,
						1024,
						false,
						TreeReadType.ANY).baseValue();
				if (records == null) {
					return true;
				}
				final int length = records.length();
				if (length == 0) {
					return true;
				}
				for (int i = 0;; ++i) {
					final Entry child = records.get(i);

					assert child.isExist() : "Should exist here!";
					final Entry newTarget = child.isContainer()
						? target.relativeFolder(child.getKey())
						: target.relativeFile(child.getKey());
					Storage.copy(child.toContainer(), newTarget);

					/* length is 1 - last element */
					if (i >= length - 2) {
						if (length == 1) {
							return true;
						}
						starting = records.get(i + 1).getKey();
						continue ls;
					}
				}
			}
		}
		/** actual copy */
		if (source.isBinary()) {
			target.doSetBinary(source.toBinary().getBinaryContent().baseValue()).baseValue();
			return true;
		}
		if (source.isPrimitive()) {
			target.doSetPrimitive(source.toPrimitive().getPrimitiveValue()).baseValue();
			return true;
		}
		{
			assert false : "Unknown source type: " + source;
			return false;
		}
	}

	/** @param <O>
	 * @param <R>
	 * @param <A>
	 * @param impl
	 * @return */
	public static final <O extends ArsRecord, R extends ArsReference<O>, A extends ArsArray<R>> //
	EntryContainer createRoot(final ArsStorageImpl<O, R, A> impl) {

		return Storage.IMPL.createRoot(impl);
	}

	/** @param entry
	 * @return */
	public static final//
	Entry createRoot(final Entry entry) {

		return entry.clone(null, entry.getKey(), entry.getMode());
	}

	/** Returns new root or nested transaction
	 *
	 * @param ctx
	 * @return */
	public static final//
	TransactionVfs createTransaction(final ExecProcess ctx) {

		return Storage.IMPL.createTransaction(ctx);
	}

	/** @param root
	 * @return */
	public static final//
	EntryVfsRoot createVfsRoot(final Entry root) {

		return root instanceof EntryVfsRoot
			? (EntryVfsRoot) root
			: Storage.IMPL.createVfsRoot(root.toContainer());
	}

	/** Returns new root transaction or null when context is already running inside a transaction
	 *
	 * @param ctx
	 * @return */
	public static final//
	TransactionVfs ensureTransaction(final ExecProcess ctx) {

		return Storage.IMPL.ensureTransaction(ctx);
	}

	/** @param path
	 * @param type
	 *            - NULL type will not create anything and may return null
	 * @return */
	public static final//
	Entry getAbsolute(final String path, final TreeLinkType type) {

		return Storage.getRelative(Storage.ROOT, Storage.ROOT, path, type);
	}

	/** @param entry
	 * @return */
	public static final//
	String getAbsolutePath(final Entry entry) {

		final Entry parent = entry.getParent();
		if (parent == null) {
			return Storage.SLASH;
		}
		final String path = Storage.getAbsolutePath(parent);
		return path == Storage.SLASH
			? path + entry.getKey()
			: path + '/' + entry.getKey();
	}

	/** Calls getRelative(root, focus, path, TreeLinkType.PUBLIC_TREE_REFERENCE ), then creates an
	 * empty file if it does not exist yet.
	 *
	 * @param root
	 * @param focus
	 * @param path
	 * @return */
	public static final//
	Entry getCreateRelativeTreeFile(final Entry root, final Entry focus, final String path) {

		final Entry result = Storage.getRelative(root, focus, path, TreeLinkType.PUBLIC_TREE_REFERENCE);
		if (!result.isExist() && result.doSetBinary(TransferCopier.NUL_COPIER).baseValue() != Boolean.TRUE) {
			throw new RuntimeException("Can't create an empty file: " + result);
		}
		return result;
	}

	/** @param root
	 * @param path
	 * @return */
	@Deprecated
	public static final//
	Entry getCreateRelativeTreeFile(final Entry root, final String path) {

		return root.relativeFileEnsure(path);
	}

	/** Calls getRelative(ctx, path, TreeLinkType.PUBLIC_TREE_REFERENCE ), then creates an empty
	 * file if it does not exist yet.
	 *
	 * @param ctx
	 * @param path
	 * @return */
	public static final//
	Entry getCreateRelativeTreeFile(final ExecProcess ctx, final String path) {

		final Entry result = Storage.getRelative(ctx, path, TreeLinkType.PUBLIC_TREE_REFERENCE);
		if (!result.isExist() && result.doSetBinary(TransferCopier.NUL_COPIER).baseValue() != Boolean.TRUE) {
			throw new RuntimeException("Can't create an empty file: " + result);
		}
		return result;
	}

	/** Calls getRelative(root, focus, path, TreeLinkType.PUBLIC_TREE_REFERENCE ).toContainer();
	 *
	 * @param root
	 * @param focus
	 * @param path
	 * @return */
	public static final//
	EntryContainer getCreateRelativeTreeFolder(final Entry root, final Entry focus, final String path) {

		final EntryContainer result = Storage.getRelative(root, focus, path, TreeLinkType.PUBLIC_TREE_REFERENCE).toContainer();
		if (!result.isExist() && result.doSetContainer().baseValue() != Boolean.TRUE) {
			throw new RuntimeException("Can't create a folder: " + result);
		}
		return result;
	}

	/** @param root
	 * @param path
	 * @return */
	@Deprecated
	public static final//
	EntryContainer getCreateRelativeTreeFolder(final Entry root, final String path) {

		return root.relativeFolderEnsure(path);
	}

	/** Calls getRelative(ctx, path, TreeLinkType.PUBLIC_TREE_REFERENCE ).toContainer();
	 *
	 * @param ctx
	 * @param path
	 * @return */
	public static final//
	EntryContainer getCreateRelativeTreeFolder(final ExecProcess ctx, final String path) {

		final Entry result = Storage.getRelative(ctx, path, TreeLinkType.PUBLIC_TREE_REFERENCE);
		if (!result.isContainer() && result.doSetContainer().baseValue() != Boolean.TRUE) {
			throw new RuntimeException("Can't create a folder: " + result);
		}
		return result.toContainer();
	}

	/** @param share
	 * @param focus
	 * @param path
	 * @param mode
	 *            - NULL type will not create anything and may return null
	 * @return */
	public static final//
	Entry getRelative(final Entry share, final Entry focus, final String path, final TreeLinkType mode) {

		return Entry.relative(share, focus, path, mode);
	}

	/** Calls getRelative(root, root, path, mode);
	 *
	 * @param root
	 * @param path
	 * @param mode
	 *            - NULL type will not create anything and may return null
	 * @return */
	@Deprecated
	public static final//
	Entry getRelative(final Entry root, final String path, final TreeLinkType mode) {

		return Entry.relative(root, root, path, mode);
	}

	/** Calls getRelative(ctx.share, ctx.focus, path, mode);
	 *
	 * @param ctx
	 * @param path
	 * @param mode
	 *            - NULL type will not create anything and may return null
	 * @return */
	// non entry specific - do not move to Entry interface default method
	public static final//
	Entry getRelative(final ExecProcess ctx, final String path, final TreeLinkType mode) {

		return Storage.getRelative(ctx.fldVfsShare, ctx.fldVfsFocus, path, mode);
	}

	/** @param root
	 * @param entry
	 * @return */
	public static final//
	String getRelativePath(final Entry root, final Entry entry) {

		final Entry parent = entry.getParent();
		if (parent == null) {
			if (root != null) {
				throw new IllegalArgumentException("Not in the hierarchy!");
			}
			return Storage.SLASH;
		}
		if (parent == root) {
			return Storage.SLASH;
		}
		final String path = Storage.getRelativePath(root, parent);
		return path == Storage.SLASH
			? path + entry.getKey()
			: path + '/' + entry.getKey();
	}

	/** Calls getRelative(root, focus, path, TreeLinkType.PUBLIC_TREE_REFERENCE );
	 *
	 * @param root
	 * @param focus
	 * @param path
	 * @return */
	public static final//
	Entry getRelativeTreeFile(final Entry root, final Entry focus, final String path) {

		return Storage.getRelative(root, focus, path, TreeLinkType.PUBLIC_TREE_REFERENCE);
	}

	/** @param root
	 * @param path
	 * @return */
	@Deprecated
	public static final//
	Entry getRelativeTreeFile(final Entry root, final String path) {

		return root.relativeFile(path);
	}

	/** Calls getRelative(ctx, path, TreeLinkType.PUBLIC_TREE_REFERENCE );
	 *
	 * @param ctx
	 * @param path
	 * @return */
	public static final//
	Entry getRelativeTreeFile(final ExecProcess ctx, final String path) {

		return Storage.getRelative(ctx, path, TreeLinkType.PUBLIC_TREE_REFERENCE);
	}

	/** Calls getRelative(root, focus, path, TreeLinkType.PUBLIC_TREE_REFERENCE ).toContainer();
	 *
	 * @param root
	 * @param focus
	 * @param path
	 * @return */
	public static final//
	EntryContainer getRelativeTreeFolder(final Entry root, final Entry focus, final String path) {
		
		return Storage.getRelative(root, focus, path, TreeLinkType.PUBLIC_TREE_REFERENCE).toContainer();
	}

	/** @param root
	 * @param path
	 * @return */
	@Deprecated
	public static final//
	EntryContainer getRelativeTreeFolder(final Entry root, final String path) {

		return root.relativeFolder(path);
	}

	/** Calls getRelative(ctx, path, TreeLinkType.PUBLIC_TREE_REFERENCE ).toContainer();
	 *
	 * @param ctx
	 * @param path
	 * @return */
	public static final//
	EntryContainer getRelativeTreeFolder(final ExecProcess ctx, final String path) {

		return Storage.getRelative(ctx, path, TreeLinkType.PUBLIC_TREE_REFERENCE).toContainer();
	}

	/** @param ctx
	 * @return */
	public static EntryVfsRoot getRoot(final ExecProcess ctx) {

		return ctx == null
			? Storage.ROOT
			: ctx.fldVfsRoot;
	}

	/** Example: 'arr.filter(vfs.isContainer)'
	 *
	 *
	 * @param entry
	 * @return */
	public static final//
	boolean isContainer(final Entry entry) {

		return entry != null && entry.isContainer();
	}

	/** Example: 'arr.filter(vfs.isContainerEmpty)'
	 *
	 *
	 * @param entry
	 * @return */
	public static final//
	boolean isContainerEmpty(final Entry entry) {

		return entry != null && entry.isContainer() && entry.toContainer().isContainerEmpty();
	}

	/** Example: 'arr.filter(vfs.isContainerNonEmpty)'
	 *
	 *
	 * @param entry
	 * @return */
	public static final//
	boolean isContainerNonEmpty(final Entry entry) {

		return entry != null && entry.isContainer() && !entry.toContainer().isContainerEmpty();
	}

	/** Example: 'arr.filter(vfs.isExist)'
	 *
	 * @param entry
	 * @return */
	public static final//
	boolean isExist(final Entry entry) {

		return entry != null && entry.isExist();
	}

	/** Example: 'arr.filter(vfs.isFile)'
	 *
	 * @param entry
	 * @return */
	public static final//
	boolean isFile(final Entry entry) {

		return entry != null && (entry.isPrimitive() || entry.isBinary());
	}

	/** Example: 'arr.filter(vfs.isHidden)'
	 *
	 *
	 * @param entry
	 * @return */
	public static final//
	boolean isHidden(final Entry entry) {

		return entry != null && entry.isHidden();
	}

	/** Example: 'arr.filter(vfs.isNotHidden)'
	 *
	 *
	 * @param entry
	 * @return */
	public static final//
	boolean isNotHidden(final Entry entry) {

		return entry != null && !entry.isHidden();
	}

	/** Example: 'arr.filter(vfs.isPrimitive)'
	 *
	 *
	 * @param entry
	 * @return */
	public static final//
	boolean isPrimitive(final Entry entry) {

		return entry != null && entry.isPrimitive();
	}

	/** Example: 'arr.map(vfs.mapEntryToKey)'
	 *
	 *
	 * @param entry
	 * @return */
	public static final//
	String mapEntryToKey(final Entry entry) {

		return entry == null
			? null
			: entry.getKey();
	}

	/** @param container
	 * @param key
	 * @param target
	 * @return */
	public static final//
	Entry mount(final Entry container, final String key, final Entry target) {

		return Storage.IMPL.mount(container.toContainer(), key, target);
	}

	/** @param container
	 * @param key
	 * @param mode
	 * @param target
	 * @return */
	public static final//
	Entry mount(final Entry container, final String key, final TreeLinkType mode, final Entry target) {

		return Storage.IMPL.mount(container.toContainer(), key, mode, target);
	}

	/** @param source
	 * @param target
	 * @return */
	public static final//
	boolean move(final Entry source, final Entry target) {

		if (!source.isExist()) {
			return false;
		}
		if (target.isExist()) {
			return false;
		}
		{
			final Entry sourceParent = source.getParent();
			final Entry targetParent = target.getParent();
			if (sourceParent != targetParent) {
				final boolean result = source.doMoveRename(target).baseValue() == Boolean.TRUE;
				if (result) {
					return true;
				}
				/** TODO: move */
				throw new UnsupportedOperationException("move is not supported!");
			}
		}
		{
			return source.doRename(target.getKey()).baseValue() == Boolean.TRUE;
		}
	}

	/** @param container
	 * @return */
	@Deprecated
	public static final//
	boolean unlinkRecursive(final EntryContainer container) {

		assert container != null : "Container is null!";
		return container.unlinkRecursive();
	}

	/** @param mounted
	 * @return */
	public static final//
	boolean unmount(final EntryMount mounted) {

		return Storage.IMPL.unmount(mounted);
	}

}
