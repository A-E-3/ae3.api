package ru.myx.ae3.e4.logic;

import ru.myx.ae3.base.BaseObject;

/**
 * Creates standard basic logic blocks
 * 
 * @author myx
 * @param <V>
 * 			
 */
public interface LogicFactory<V> {
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	LogicValue<V> constantValue(final BaseObject value);
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	LogicValue<V> constantInteger(final long value);
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	LogicValue<V> constantString(final String value);
}
