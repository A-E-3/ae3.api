package ru.myx.ae3.vfs.ars;

/** @author myx
 *
 *         The actual real storage instance (not a transaction, not a virtual ars-storage over other
 *         some ars-storage...), includes all of the ArsInterface
 * 		
 * @param <O>
 * @param <R>
 * @param <A> */
public interface ArsStorage<O extends ArsRecord, R extends ArsReference<O>, A extends ArsArray<R>> extends ArsInterface<O, R, A> {
	
	/** @return */
	R getRootReference();
	
	/** @throws Exception */
	void shutdown() throws Exception;
	
}
