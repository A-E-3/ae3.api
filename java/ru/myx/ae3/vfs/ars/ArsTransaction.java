package ru.myx.ae3.vfs.ars;

import ru.myx.ae3.common.Transaction;

/**
 * @author myx
 * @param <O>
 * @param <R>
 * @param <A>
 * 
 */
public interface ArsTransaction<O extends ArsRecord, R extends ArsReference<O>, A extends ArsArray<R>> extends
		ArsInterface<O, R, A>, Transaction {
	/**
	 * @throws Exception
	 */
	@Override
	void cancel() throws Exception;
	
	/**
	 * @throws Exception
	 */
	@Override
	void commit() throws Exception;
}
