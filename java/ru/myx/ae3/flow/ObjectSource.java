/*
 * Created on 01.12.2005
 */
package ru.myx.ae3.flow;

/**
 * @author myx
 *
 * @param <T>
 */
public interface ObjectSource<T> {

	/**
	 *
	 */
	public static final ObjectSource<?> NUL_SOURCE = new NulSource();

	/**
	 * Returns <b>true </b> to indicate that there are no more objects to be
	 * ever retrieved via any of nextXXX methods.
	 *
	 * @return boolean
	 */
	default boolean isExhausted() {

		return false;
	}

	/**
	 * Returns <b>true </b> to indicate that there is at least one object to be
	 * retrieved via one of nextXXX methods.
	 *
	 * @return boolean
	 */
	default boolean isReady() {

		return true;
	}

	/**
	 * Returns next available object.
	 *
	 * @return object
	 */
	T next();
}
