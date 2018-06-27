package ru.myx.ae3.console;

import ru.myx.ae3.reflect.ReflectionHidden;

/**
 * 
 * @author myx
 * 		
 */
public interface ConsoleLogger {
	
	/**
	 * 
	 * @param format
	 * @param arguments
	 */
	@ReflectionHidden
	default void debug(String format, Object... arguments) {
		
		this.debug(String.format(format, arguments));
	}
	
	/**
	 * 'log', 'info', 'warn' and 'error' methods are different from sendXXX and
	 * readXXX methods in that the are logging methods not input/output methods.
	 * 
	 * @param message
	 */
	void debug(String message);
	
	/**
	 * 
	 * @param format
	 * @param arguments
	 */
	@ReflectionHidden
	default void error(String format, Object... arguments) {
		
		this.error(String.format(format, arguments));
	}
	
	/**
	 * 'log', 'info', 'warn' and 'error' methods are different from sendXXX and
	 * readXXX methods in that the are logging methods not input/output methods.
	 * 
	 * @param message
	 */
	void error(String message);
	
	/**
	 * 
	 * @param format
	 * @param arguments
	 */
	@ReflectionHidden
	default void info(String format, Object... arguments) {
		
		this.info(String.format(format, arguments));
	}
	
	/**
	 * 'log', 'info', 'warn' and 'error' methods are different from sendXXX and
	 * readXXX methods in that the are logging methods not input/output methods.
	 * 
	 * @param message
	 */
	void info(String message);
	
	/**
	 * 
	 * @param format
	 * @param arguments
	 */
	@ReflectionHidden
	default void log(String format, Object... arguments) {
		
		this.log(String.format(format, arguments));
	}
	
	/**
	 * 'log', 'info', 'warn' and 'error' methods are different from sendXXX and
	 * readXXX methods in that the are logging methods not input/output methods.
	 * 
	 * @param message
	 */
	void log(String message);
	
	/**
	 * 
	 * @param format
	 * @param arguments
	 */
	@ReflectionHidden
	default void warn(String format, Object... arguments) {
		
		this.warn(String.format(format, arguments));
	}
	
	/**
	 * 'log', 'info', 'warn' and 'error' methods are different from sendXXX and
	 * readXXX methods in that the are logging methods not input/output methods.
	 * 
	 * @param message
	 */
	void warn(String message);
}
