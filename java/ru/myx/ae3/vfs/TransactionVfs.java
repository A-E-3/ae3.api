package ru.myx.ae3.vfs;

import ru.myx.ae3.common.Transaction;

/**
 * @author myx
 * 
 */
public interface TransactionVfs extends Transaction, VfsInterface {
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
