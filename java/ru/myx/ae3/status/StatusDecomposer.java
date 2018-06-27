/*
 * Created on 22.03.2006
 */
package ru.myx.ae3.status;

/**
 * @author myx
 * 
 */
public interface StatusDecomposer {
	/**
	 * @return providers
	 */
	public StatusProvider[] statusDecomposition();
}
