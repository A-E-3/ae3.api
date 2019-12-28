/**
 *
 */
package ru.myx.ae3.base;

import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/**
 * @author myx
 *
 */
@ReflectionDisable
final class PrimitiveNumberTrueInteger extends PrimitiveNumberIntegerAbstract {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 874681045645090180L;

	private final Number number;

	PrimitiveNumberTrueInteger(final int value) {
		assert value != 0 : "Must not be zero";
		assert value != 1 : "Must not be one";
		this.number = Integer.valueOf(value);
	}

	/**
	 * no checks
	 *
	 * @param number
	 */
	PrimitiveNumberTrueInteger(final CacheNumber number) {
		this.number = number;
	}

	PrimitiveNumberTrueInteger(final Number number) {
		assert number != null : "Must not be NULL";
		assert !Double.isNaN(number.doubleValue()) : "Must not be NaN: immutable";
		assert number.doubleValue() == number.intValue() : "Must be an integer: immutable";
		assert number.intValue() != 0 : "Must not be zero: immutable";
		assert number.intValue() != 1 : "Must not be one: immutable";
		assert !Double.isInfinite(number.doubleValue()) : "Must be finite: immutable";
		this.number = number;
	}

	@Override
	public final BasePrimitiveString baseToString() {
		
		return Base.forString(this.number.intValue());
	}

	@Override
	public final BasePrimitiveString baseToStringIfReady() {
		
		return null;
	}

	@Override
	public final Number baseValue() {
		
		return this.number;
	}

	@Override
	public double doubleValue() {
		
		return this.number.doubleValue();
	}

	@Override
	public float floatValue() {
		
		return this.number.floatValue();
	}

	/**
	 * java Long's hash code!
	 */
	@Override
	public int hashCode() {
		
		return this.number.intValue();
	}

	@Override
	public int intValue() {
		
		return this.number.intValue();
	}

	@Override
	@ReflectionHidden
	public int baseToJavaInteger() {
		
		return this.number.intValue();
	}

	@Override
	@ReflectionHidden
	public long baseToJavaLong() {
		
		return this.number.longValue();
	}

	@Override
	@ReflectionHidden
	public boolean baseToJavaBoolean() {
		
		return true;
	}

	@Override
	public long longValue() {
		
		return this.number.longValue();
	}

	@Override
	@ReflectionHidden
	public String baseToJavaString() {
		
		return Integer.toString(this.number.intValue());
	}

	@Override
	public final String stringValue() {
		
		return Integer.toString(this.number.intValue());
	}
}
