package ru.myx.ae3.vfs.ars;

/**
 * @author myx
 * 
 * @param <O>
 * @param <R>
 * @param <A>
 */
public interface ArsStorageImpl<O extends ArsRecord, R extends ArsReference<O>, A extends ArsArray<R>> extends
		ArsInterface<O, R, A> {
	
	/**
	 * @return
	 */
	R getRootReference();
	
	/**
	 * 
	 * @throws Exception
	 */
	void shutdown() throws Exception;
	
}
