package ru.myx.ae3.e4.context;

import ru.myx.ae3.exec.ExecResultVisibility;
import ru.myx.ae3.exec.ExecStateCode;

/**
 * 
 * @author myx
 * @param <R>
 *
 */
public interface CallContext<R> {
	
	
	/**
	 * 
	 * @return
	 */
	ExecResultVisibility callResultVisibility();
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	ExecStateCode callReturn(R x);
	
}
