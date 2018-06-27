package ru.myx.ae3.produce;

/**
 * @author myx
 * 
 */
public interface Reproducible {
	/**
	 * 32-char limit.
	 * 
	 * @return string
	 */
	public String restoreFactoryIdentity();
	
	/**
	 * 255-char limit.
	 * 
	 * @return string
	 */
	public String restoreFactoryParameter();
}
