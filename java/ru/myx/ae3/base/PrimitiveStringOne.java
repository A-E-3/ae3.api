package ru.myx.ae3.base;

import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/** @author myx */
@ReflectionDisable
final class PrimitiveStringOne extends BasePrimitiveString {
	
	private final String value;
	
	PrimitiveStringOne() {
		
		this.value = "1".intern();
	}
	
	@Override
	public BasePrimitiveNumber baseToInt32() {
		
		return BasePrimitiveNumber.ONE;
	}
	
	@Override
	public BasePrimitiveNumber baseToInteger() {
		
		return BasePrimitiveNumber.ONE;
	}
	
	@Override
	@ReflectionHidden
	public boolean baseToJavaBoolean() {
		
		return true;
	}
	
	@Override
	@ReflectionHidden
	public int baseToJavaInteger() {
		
		return 1;
	}
	
	@Override
	@ReflectionHidden
	public long baseToJavaLong() {
		
		return 1L;
	}
	
	@Override
	@ReflectionHidden
	public String baseToJavaString() {
		
		return this.value;
	}
	
	@Override
	public BasePrimitiveNumber baseToNumber() {
		
		return BasePrimitiveNumber.ONE;
	}
	
	@Override
	public final String baseValue() {
		
		return this.value;
	}
	
	@Override
	public double doubleValue() {
		
		return 1;
	}
	
	@Override
	public boolean equals(final Object o) {
		
		if (o == this || o == this.value) {
			return true;
		}
		if (o instanceof final BaseObject object) {
			if (object.baseIsPrimitive()) {
				if (object.baseIsPrimitiveString()) {
					return this.value.equals(object.baseToJavaString());
				}
				if (object.baseIsPrimitiveNumber()) {
					return object == BasePrimitiveNumber.ONE;
				}
				if (object.baseIsPrimitiveBoolean()) {
					return object.baseToNumber() == BasePrimitiveNumber.ONE;
				}
				return false;
			}
			final Object base = object.baseValue();
			if (base != null && base != object) {
				return base == this || base instanceof CharSequence && this.value.equals(base);
			}
		}
		return o instanceof CharSequence && this.value.equals(o);
	}
	
	@Override
	public int indexOf(final String search, final int fromIndex) {
		
		return this.value.indexOf(search, fromIndex);
	}
	
	@Override
	public int intValue() {
		
		return 1;
	}
	
	@Override
	public final boolean isEmpty() {
		
		return false;
	}
	
	@Override
	public final int length() {
		
		return 1;
	}
	
	@Override
	public long longValue() {
		
		return 1L;
	}
	
	@Override
	public final String stringValue() {
		
		return this.value;
	}
	
	@Override
	public final String toString() {
		
		return this.value;
	}
	
	@Override
	public final BasePrimitiveString trim() {
		
		return this;
	}
	
}
