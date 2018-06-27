package ru.myx.ae3.vfs;

import java.util.Map;

/**
 * 
 * @author myx
 * 
 */
interface VfsStorage {
	
	/**
	 * @param entry
	 * @param key
	 * @return
	 */
	Entry getMountedByKey(final Entry entry, final String key);
	
	/**
	 * @param entry
	 * @return
	 */
	Map<String, Entry> getMountedMap(final Entry entry);
	
	/**
	 * 
	 * @return
	 */
	EntryVfsRoot getRoot();
}
