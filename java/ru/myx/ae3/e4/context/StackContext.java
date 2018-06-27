package ru.myx.ae3.e4.context;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;

/**
 * 
 * @author myx
 * 
 */
public interface StackContext {
	
	
	/**
	 * <code>this.fldStack[pointer - 1]</code>
	 * 
	 * @return topmost stack object
	 */
	BaseObject stackPeek();
	
	/**
	 * <code>this.fldStack[pointer - 1 - more]</code>
	 * 
	 * @param more
	 * @return stack object
	 */
	BaseObject stackPeek(int more);
	
	/**
	 * @return topmost stack object
	 */
	BaseObject stackPop();
	
	/**
	 * Push accumulator
	 */
	void stackPush();
	
	/**
	 * @param value
	 */
	void stackPush(BaseObject value);
	
	/**
	 * @param value
	 */
	default void stackPush(final double value) {
		
		
		this.stackPush(Base.forDouble(value));
	}
	
	/**
	 * @param value
	 */
	default void stackPush(final int value) {
		
		
		this.stackPush(Base.forInteger(value));
	}
	
	/**
	 * @param value
	 */
	default void stackPush(final long value) {
		
		
		this.stackPush(Base.forLong(value));
	}
	
	/**
	 * @param value
	 */
	@Deprecated
	default void stackPush(final Object value) {
		
		
		this.stackPush(Base.forUnknown(value));
	}
	
	/**
	 * @param value
	 */
	default void stackPush(final String value) {
		
		
		this.stackPush(Base.forString(value));
	}
}
