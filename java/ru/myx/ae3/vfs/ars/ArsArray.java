package ru.myx.ae3.vfs.ars;

/** The list of references
 *
 * @author myx
 *
 * @param <R> */
public interface ArsArray<R extends ArsReference<?>> {

	/** @param i
	 * @return */
	R get(final int i);

	/** @return */
	int size();
}
