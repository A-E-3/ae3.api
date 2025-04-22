package ru.myx.ae3.i3;

import java.net.URI;

import ru.myx.ae3.vfs.Entry;

/**
 * @author myx
 * 
 */
public interface TargetInterface extends RequestHandler {
	/**
	 * @return
	 */
	Entry getBase();
	
	/**
	 * @return
	 */
	Entry getRoot();
	
	/**
	 * @param entry
	 * @return
	 */
	URI resolveEntry(Entry entry);
	
	/**
	 * 
	 * abstract:
	 * 
	 * @param locator
	 * @return
	 */
	Entry resolveEntry(String locator);
	
	/**
	 * 
	 * @param uri
	 * @return
	 */
	Entry resolveEntry(URI uri);
}
