package ru.myx.ae3.exec;

/**
 * @author myx
 * 		
 */
public enum ExecProcessState {
	/**
	 * Inactive
	 */
	INA,
	/**
	 * Running
	 */
	RUN,
	/**
	 * Doing a call
	 */
	CLL,
	/**
	 * Running - Finalizer
	 */
	FIN,
	/**
	 * Waiting notification
	 */
	WNT,
	/**
	 * Waiting input
	 */
	WIN,
	/**
	 * 
	 */
	;
}
