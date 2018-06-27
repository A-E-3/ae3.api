package ru.myx.ae3.base;

import ru.myx.ae3.reflect.ReflectionHidden;

/**
 * 
 * @author myx
 * 		
 * @param <T>
 */
public interface BaseStringObject<T extends CharSequence> extends BaseString<T>, BaseMap {
	
	/**
	 * Not a 'string' anymore
	 */
	@Override
	@ReflectionHidden
	default String baseClass() {
		
		return "object";
	}
	
	@Override
	default boolean isEmpty() {
		
		return this.length() == 0 && this.size() == 0;
	}
}
