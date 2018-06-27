package ru.myx.ae3.e4.context;

/**
 * processes produce tasks.
 * 
 * @author myx
 *
 */
public interface TaskContext {
	/**
	 * 
	 * @return
	 */
	ProcessContext getParentProcess();
}
