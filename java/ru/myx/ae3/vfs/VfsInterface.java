package ru.myx.ae3.vfs;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.know.Guid;

/** @author myx */
public interface VfsInterface {

	/** @return */
	TransactionVfs createTransaction();

	/** @param entry */
	void doUnlink(Entry entry);

	/** @param container
	 * @param key */
	void doUnlink(Entry container, BaseObject key);

	/** @param container
	 * @param key */
	void doUnlink(Entry container, Guid key);

	/** @param container
	 * @param key */
	void doUnlink(Entry container, String key);

	/** @param share
	 * @param focus
	 * @param path
	 * @param mode
	 * @return */
	default Entry getRelative(final Entry share, final Entry focus, final String path, final TreeLinkType mode) {

		return Entry.relative(share, focus, path, mode);
	}

	/** @param root
	 * @param path
	 * @param mode
	 * @return */
	default Entry getRelative(final Entry root, final String path, final TreeLinkType mode) {

		return Entry.relative(root, root, path, mode);

	}
}
