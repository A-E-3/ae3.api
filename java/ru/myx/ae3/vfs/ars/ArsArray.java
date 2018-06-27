package ru.myx.ae3.vfs.ars;

/**
 * @author myx
 * 
 * @param <R>
 */
public interface ArsArray<R extends ArsReference<?>> {
	/**
	 * @param i
	 * @return
	 */
	R get(final int i);
	
	/**
	 * @return
	 */
	int size();
}
