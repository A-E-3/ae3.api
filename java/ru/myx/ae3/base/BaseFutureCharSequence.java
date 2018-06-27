package ru.myx.ae3.base;

import ru.myx.ae3.reflect.ReflectionHidden;

/**
 * 
 * @author myx
 * @param <V>
 * 
 */
public interface BaseFutureCharSequence<V extends CharSequence> extends BaseFuture<V>, BaseString<V> {
	
	
	@Override
	V baseValue();
	
	@Override
	@ReflectionHidden
	default BaseObject basePrototype() {
		
		
		return BaseString.PROTOTYPE;
	}
	
	@Override
	@ReflectionHidden
	default BasePrimitiveBoolean baseToBoolean() {
		
		
		if (!this.baseAwait()) {
			return BaseObject.FALSE;
		}
		final CharSequence value = this.baseValue();
		if (value == null) {
			return BaseObject.FALSE;
		}
		assert value != this : "Future base value is THIS, class: " + this.getClass().getName();
		return value.length() == 0
			? BaseObject.FALSE
			: BaseObject.TRUE;
	}
	
	@Override
	@ReflectionHidden
	default BasePrimitiveString baseToString() {
		
		
		return Base.forString(this.baseValue());
	}
}
