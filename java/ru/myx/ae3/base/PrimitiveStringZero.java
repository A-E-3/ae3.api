package ru.myx.ae3.base;

import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/**
 * @author myx
 *
 */
@ReflectionDisable
final class PrimitiveStringZero extends BasePrimitiveString {
	
	
	private final String value;

	PrimitiveStringZero() {
		this.value = "0".intern();
	}

	@Override
	public BasePrimitiveNumber baseToInt32() {
		
		
		return BasePrimitiveNumber.ZERO;
	}

	@Override
	public BasePrimitiveNumber baseToInteger() {
		
		
		return BasePrimitiveNumber.ZERO;
	}

	@Override
	public BasePrimitiveNumber baseToNumber() {
		
		
		return BasePrimitiveNumber.ZERO;
	}

	@Override
	public final String baseValue() {
		
		
		return this.value;
	}

	@Override
	public double doubleValue() {
		
		
		return 0;
	}

	@Override
	public boolean equals(final Object o) {
		
		
		if (o == this || o == this.value) {
			return true;
		}
		if (o instanceof BaseObject) {
			final BaseObject object = (BaseObject) o;
			if (object.baseIsPrimitive()) {
				if (object.baseIsPrimitiveString()) {
					return this.value.equals(object.baseToJavaString());
				}
				if (object.baseIsPrimitiveNumber()) {
					return object == BasePrimitiveNumber.ZERO;
				}
				if (object.baseIsPrimitiveBoolean()) {
					return object.baseToNumber() == BasePrimitiveNumber.ZERO;
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
		
		
		return 0;
	}

	@Override
	public long longValue() {
		
		
		return 0L;
	}

	@Override
	public final boolean isEmpty() {
		
		
		return false;
	}

	@Override
	public int length() {
		
		
		return 1;
	}

	@Override
	@ReflectionHidden
	public int baseToJavaInteger() {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public long baseToJavaLong() {
		
		
		return 0L;
	}

	@Override
	@ReflectionHidden
	public boolean baseToJavaBoolean() {
		
		
		return true;
	}

	@Override
	@ReflectionHidden
	public String baseToJavaString() {
		
		
		return this.value;
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
