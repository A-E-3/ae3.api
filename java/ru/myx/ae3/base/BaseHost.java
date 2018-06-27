package ru.myx.ae3.base;

import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/**
 * Represents built-in host provided objects, that are originally instances of
 * BaseObject, so they should not be wrapped.
 * 
 * BaseHostObject's baseValue() method MUST return 'this'.
 * 
 * @author myx
 * 
 */
@ReflectionDisable
public interface BaseHost extends BaseObject {
	
	
	@Override
	@ReflectionHidden
	default String baseClass() {
		
		
		return this.getClass().getSimpleName();
	}
	
	@Override
	@ReflectionHidden
	default BasePrimitiveString baseToString() {
		
		
		return Base.forString(this.toString());
	}
	
}
