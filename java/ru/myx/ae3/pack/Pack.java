package ru.myx.ae3.pack;

import ru.myx.ae3.vfs.Entry;

/**
 * @author myx
 * 
 */
public interface Pack {
	/**
	 * @return
	 */
	public String getName();
	
	/**
	 * @return
	 */
	public Entry getRoot();
}
