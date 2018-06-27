package ru.myx.ae3.base;

import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/**
 * @author myx
 * 
 */
@ReflectionDisable
final class PrimitiveStringBaseNumber extends BasePrimitiveString {
	
	
	private static final boolean assertANumber(final String value, final double number) {
		
		
		try {
			return Double.parseDouble(value) == number;
		} catch (final Throwable t) {
			return false;
		}
	}
	
	private final String value;
	
	private final double number;
	
	PrimitiveStringBaseNumber(final String value, final double number) {
		assert value != null : "Must not be NULL";
		assert value.length() != 0 : "Must not be empty";
		assert !"0".equals(value) : "Must not be '0'";
		assert !"1".equals(value) : "Must not be '1'";
		assert PrimitiveStringBaseNumber.assertANumber(value, number);
		this.value = value;
		this.number = number;
	}
	
	@Override
	public final BasePrimitiveNumber baseToInt32() {
		
		
		return Base.forInteger((int) this.number);
	}
	
	@Override
	public final BasePrimitiveNumber baseToInteger() {
		
		
		return Base.forLong((long) this.number);
	}
	
	/**
	 * 9.3.1 ToNumber Applied to the String Type ToNumber applied to strings
	 * applies the following grammar to the input string. If the grammar cannot
	 * interpret the string as an expansion of StringNumericLiteral, then the
	 * result of ToNumber is NaN.
	 * <p>
	 * 
	 * Base strings are not numbers.
	 */
	@Override
	public final BasePrimitiveNumber baseToNumber() {
		
		
		return Base.forDouble(this.number);
	}
	
	@Override
	public final String baseValue() {
		
		
		return this.value;
	}
	
	@Override
	public double doubleValue() {
		
		
		return this.number;
	}
	
	@Override
	public int hashCode() {
		
		
		return this.value.hashCode();
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
					return object == this.baseToNumber();
				}
				/**
				 * always false: '0' and '1' are not present by this class
				 * 
				 * <code>
				if (object.baseIsPrimitiveBoolean()) {
					return object.baseToNumber() == this.baseToNumber();
				}
				</code>
				 */
				return false;
			}
			final Object base = object.baseValue();
			if (base != null && base != object) {
				return base == this || base instanceof CharSequence && this.value.equals(base.toString());
			}
		}
		return o instanceof CharSequence && this.value.equals(o.toString());
	}
	
	@Override
	public int indexOf(final String search, final int fromIndex) {
		
		
		return this.value.indexOf(search, fromIndex);
	}
	
	@Override
	public int intValue() {
		
		
		return (int) this.number;
	}
	
	@Override
	public long longValue() {
		
		
		return (long) this.number;
	}
	
	@Override
	public final boolean isEmpty() {
		
		
		return false;
	}
	
	@Override
	public int length() {
		
		
		return this.value.length();
	}
	
	@Override
	@ReflectionHidden
	public int baseToJavaInteger() {
		
		
		return (int) this.number;
	}
	
	@Override
	@ReflectionHidden
	public long baseToJavaLong() {
		
		
		return (long) this.number;
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
}
