package ru.myx.ae3.common;

import ru.myx.ae3.reflect.ReflectionDisable;

/**
 * @author myx
 *
 * @param <V>
 *            result
 */
@ReflectionDisable
public interface Value<V> {

	/**
	 * Retrieves the current value
	 *
	 * @return value
	 * @throws WaitTimeoutException
	 *             this maskable exception is for those cases when this method
	 *             is backed by some kind of asynchronous system and timed out.
	 */
	V baseValue() throws WaitTimeoutException;

	/**
	 *
	 * @return class of value to be returned by baseValue() method or NULL if
	 *         unknown? Or Object.class when unknown?
	 */
	// Class<V> baseValueClass();
}
