package ru.myx.ae3.vfs.ars;

import ru.myx.ae3.vfs.TreeLinkType;

/**
 * @author myx
 * 
 * @param <O>
 */
public interface ArsReference<O extends ArsRecord> {
	/**
	 * @return
	 */
	O getKey();
	
	/**
	 * @return
	 */
	String getKeyString();
	
	/**
	 * @return
	 */
	long getLastModified();
	
	/**
	 * @return
	 */
	TreeLinkType getLinkageMode();
	
	/**
	 * @return
	 */
	O getSource();
	
	/**
	 * @return
	 */
	O getTarget();
	
	/**
	 * @return
	 */
	boolean isExist();
}
