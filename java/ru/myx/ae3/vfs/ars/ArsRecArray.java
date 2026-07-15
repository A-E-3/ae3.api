package ru.myx.ae3.vfs.ars;

/** The list of references
 *
 * @author myx
 *
 * @param <O> */
public interface ArsRecArray<O extends ArsRecord> {

	/** @param i
	 * @return */
	O get(final int i);

	/** @return */
	int size();
}
