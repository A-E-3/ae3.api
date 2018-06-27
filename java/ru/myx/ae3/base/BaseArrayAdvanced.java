package ru.myx.ae3.base;

import java.util.Iterator;

import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/**
 * 
 * Basically, it is an array with generic typing
 * 
 * @author myx
 * @param <T>
 *            java array element type
 * 
 */
@ReflectionDisable
public interface BaseArrayAdvanced<T extends Object> extends Iterable<T>, BaseArray {
	
	
	/**
	 * For compatibility with java list - have to unwrap objects here cause
	 * otherwise there is no way to provide customers with proper types.
	 *
	 * Narrows return type
	 * 
	 * @param i
	 * @return object
	 */
	@Override
	T get(int i);
	
	/**
	 * @return
	 */
	@Override
	default Iterator<T> iterator() {
		
		
		return new IteratorBaseArrayValueJava<>(this);
	}
	
	/**
	 * It is already known to be an instance of ArrayAdvanced!
	 * 
	 * @return this by default
	 */
	@Deprecated
	@Override
	@ReflectionHidden
	default BaseArrayAdvanced<? extends T> baseArrayAdvanced() {
		
		
		return this;
	}
}
