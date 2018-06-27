package ru.myx.ae3.e4.logic;

/**
 * 
 * @author myx
 * @param <V>
 * 			
 */
public interface LogicValue<V> extends LogicToken {
	
	/**
	 * 
	 * @return or NULL when no constant value.
	 */
	V toConstantValue();
}
