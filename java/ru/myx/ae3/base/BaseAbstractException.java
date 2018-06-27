package ru.myx.ae3.base;

import ru.myx.ae3.reflect.ReflectionDisable;

/**
 * Correct property support.
 * 
 * @author myx
 * 
 */
@ReflectionDisable
public abstract class BaseAbstractException extends RuntimeException implements BaseError {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 85952158101027976L;
	
	/**
	 */
	protected BaseAbstractException() {
		
		//
	}
	
	/**
	 * @param message
	 * 
	 */
	protected BaseAbstractException(final String message) {
		
		super(message);
	}
	
	/**
	 * @param message
	 * @param cause
	 * 
	 */
	public BaseAbstractException(final String message, final Throwable cause) {
		
		super(message, cause);
	}
	
	/**
	 * @param cause
	 * 
	 */
	public BaseAbstractException(final Throwable cause) {
		
		super(cause);
	}
	
	@Override
	public abstract String toString();
	
	@Override
	public boolean equals(final Object o) {
		
		
		return BaseObject.equalsGeneric(this, o);
	}
	
	@Override
	public int hashCode() {
		
		
		return BaseObject.hashCodeGeneric(this);
	}
	
	@Override
	public Object getMessageContent() {
		
		
		return this.getMessage();
	}
}
