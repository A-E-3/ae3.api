package ru.myx.ae3.e4.act;

import java.util.function.Function;

/**
 * FIXME: TODO: remove?
 * 
 * @author myx
 * 
 * @param <T>
 */
public interface Worker<T extends Task<?>> extends Function<T, Object> {
	/**
	 * No unchecked exceptions. (Workers supposed to handle them)
	 * 
	 * 
	 * @param task
	 * @return
	 */
	@Override
	Object apply(T task);
	
	/**
	 * Return short description of worker's type and state.
	 * 
	 * @return
	 */
	@Override
	String toString();
}
