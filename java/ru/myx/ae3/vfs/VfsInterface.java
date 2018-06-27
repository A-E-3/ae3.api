package ru.myx.ae3.vfs;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.know.Guid;

/**
 * 
 * @author myx
 * 
 */
public interface VfsInterface {
	/**
	 * 
	 * @return
	 */
	TransactionVfs createTransaction();
	
	
	/**
	 * 
	 * @param entry
	 */
	void doUnlink(
			Entry entry);
	
	
	/**
	 * 
	 * @param container
	 * @param key
	 */
	void doUnlink(
			Entry container,
			BaseObject key);
	
	
	/**
	 * 
	 * @param container
	 * @param key
	 */
	void doUnlink(
			Entry container,
			Guid key);
	
	
	/**
	 * 
	 * @param container
	 * @param key
	 */
	void doUnlink(
			Entry container,
			String key);
	
	
	/**
	 * 
	 * @param share
	 * @param focus
	 * @param path
	 * @param mode
	 * @return
	 */
	Entry getRelative(
			Entry share,
			Entry focus,
			String path,
			TreeLinkType mode);
	
	
	/**
	 * 
	 * @param root
	 * @param path
	 * @param mode
	 * @return
	 */
	Entry getRelative(
			Entry root,
			String path,
			TreeLinkType mode);
}
