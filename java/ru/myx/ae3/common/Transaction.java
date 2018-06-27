package ru.myx.ae3.common;

/**
 * @author myx
 * 
 */
public interface Transaction {
	/**
	 * @throws Exception
	 */
	void cancel() throws Exception;
	
	/**
	 * @throws Exception
	 */
	void commit() throws Exception;
}
