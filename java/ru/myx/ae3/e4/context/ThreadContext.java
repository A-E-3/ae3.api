package ru.myx.ae3.e4.context;

/**
 * processes start threads
 * 
 * @author myx
 * 		
 */
public interface ThreadContext {
	
	/**
	 * 
	 * @return
	 */
	ProcessContext getParentProcess();
}
