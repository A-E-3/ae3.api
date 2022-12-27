package ru.myx.ae3.console;

/** @author myx */
public interface ConsoleLogger {

	/** 'log', 'info', 'warn' and 'error' methods are different from sendXXX and readXXX methods in
	 * that the are logging methods not input/output methods.
	 *
	 * @param message */
	void debug(String message);

	/** @param format
	 * @param arguments */
	default void debug(final String format, final Object... arguments) {

		this.debug(String.format(format, arguments));
	}

	/** 'log', 'info', 'warn' and 'error' methods are different from sendXXX and readXXX methods in
	 * that the are logging methods not input/output methods.
	 *
	 * @param message */
	void error(String message);

	/** @param format
	 * @param arguments */
	default void error(final String format, final Object... arguments) {

		this.error(String.format(format, arguments));
	}

	/** 'log', 'info', 'warn' and 'error' methods are different from sendXXX and readXXX methods in
	 * that the are logging methods not input/output methods.
	 *
	 * @param message */
	void info(String message);

	/** @param format
	 * @param arguments */
	default void info(final String format, final Object... arguments) {

		this.info(String.format(format, arguments));
	}

	/** 'log', 'info', 'warn' and 'error' methods are different from sendXXX and readXXX methods in
	 * that the are logging methods not input/output methods.
	 *
	 * @param message */
	void log(String message);

	/** @param format
	 * @param arguments */
	default void log(final String format, final Object... arguments) {

		this.log(String.format(format, arguments));
	}

	/** 'log', 'info', 'warn' and 'error' methods are different from sendXXX and readXXX methods in
	 * that the are logging methods not input/output methods.
	 *
	 * @param message */
	void warn(String message);

	/** @param format
	 * @param arguments */
	default void warn(final String format, final Object... arguments) {

		this.warn(String.format(format, arguments));
	}
}
