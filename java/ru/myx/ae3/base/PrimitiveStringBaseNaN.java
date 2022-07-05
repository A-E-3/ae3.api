package ru.myx.ae3.base;

import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/** @author myx */
@ReflectionDisable
final class PrimitiveStringBaseNaN extends BasePrimitiveString {
	
	private static final boolean assertNotANumber(final String value) {
		
		try {
			return Double.isNaN(Double.parseDouble(value));
		} catch (final Throwable t) {
			return true;
		}
	}

	private final String value;

	PrimitiveStringBaseNaN(final String value) {
		
		assert value != null : "Must not be NULL";
		assert value.length() != 0 : "Must not be empty";
		assert !"0".equals(value) : "Must not be '0'";
		assert !"1".equals(value) : "Must not be '1'";
		assert PrimitiveStringBaseNaN.assertNotANumber(value);
		this.value = value;
	}

	@Override
	public final BasePrimitiveNumber baseToInt32() {
		
		return BasePrimitiveNumber.ZERO;
	}

	@Override
	public final BasePrimitiveNumber baseToInteger() {
		
		return BasePrimitiveNumber.ZERO;
	}

	@Override
	@ReflectionHidden
	public boolean baseToJavaBoolean() {
		
		return true;
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
	public String baseToJavaString() {
		
		return this.value;
	}

	/** 9.3.1 ToNumber Applied to the String Type ToNumber applied to strings applies the following
	 * grammar to the input string. If the grammar cannot interpret the string as an expansion of
	 * StringNumericLiteral, then the result of ToNumber is NaN.
	 * <p>
	 *
	 * Base strings are not numbers. */
	@Override
	public final BasePrimitiveNumber baseToNumber() {
		
		return BasePrimitiveNumber.NAN;
	}

	@Override
	public final String baseValue() {
		
		return this.value;
	}

	@Override
	public final double doubleValue() {
		
		return Double.NaN;
	}

	@Override
	public boolean equals(final Object o) {
		
		if (o == this || o == this.value) {
			return true;
		}
		if (o instanceof CharSequence) {
			return this.value.equals(o.toString());
		}
		if (o instanceof final BaseObject object) {
			if (object.baseIsPrimitive()) {
				/** string is checked above as CharSequence
				 *
				 * <code>
				if (object.baseIsPrimitiveString()) {
					return this.value.equals(object.baseToJavaString());
				}
				 * </code> */
				/** always false: NaN != NaN all the time
				 *
				 * <code>
				if (object.baseIsPrimitiveNumber()) {
					return object == this.baseToNumber();
				}
				</code> */
				/** always false: '0' and '1' are not present by this class
				 *
				 * <code>
				if (object.baseIsPrimitiveBoolean()) {
					return object.baseToNumber() == this.baseToNumber();
				}
				</code> */
				return false;
			}
			final Object base = object.baseValue();
			if (base != null && base != object) {
				return base == this || base == this.value || base.equals(this.value);
				// return base == this || base instanceof CharSequence
				// && base.equals(this.value);
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		
		return this.value.hashCode();
	}

	@Override
	public int indexOf(final String search, final int fromIndex) {
		
		return this.value.indexOf(search, fromIndex);
	}

	@Override
	public final int intValue() {
		
		return 0;
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
	public long longValue() {
		
		return 0L;
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
