package ru.myx.ae3.e4.act;

import ru.myx.ae3.common.FutureValue;

/**
 * FIXME: TODO:
 * 
 * @author myx
 * 
 * @param <V>
 */
public interface Task<V> extends FutureValue<V> {
	/**
	 * Return short description of a task.
	 * 
	 * @return
	 */
	@Override
	String toString();
}
