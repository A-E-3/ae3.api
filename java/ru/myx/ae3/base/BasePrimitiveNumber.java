/**
 *
 */
package ru.myx.ae3.base;

import ru.myx.ae3.AbstractSAPI;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/** @author myx */
// JAVA NATURE: public abstract class BasePrimitiveNumber extends
// BasePrimitive<Number> {
@ReflectionDisable
public abstract class BasePrimitiveNumber extends Number implements BaseNumber<Number>, BasePrimitive<Number>, BaseObjectNoOwnProperties {

	private static final long serialVersionUID = -8440077818682500467L;

	/**
	 *
	 */
	public static final BasePrimitiveNumber E;

	/**
	 *
	 */
	public static final BasePrimitiveNumber LN10;

	/**
	 *
	 */
	public static final BasePrimitiveNumber LN2;

	/**
	 *
	 */
	public static final BasePrimitiveNumber LOG10E;

	/**
	 *
	 */
	public static final BasePrimitiveNumber LOG2E;

	/**
	 *
	 */
	public static final BasePrimitiveNumber MAX_VALUE;

	/**
	 *
	 */
	public static final BasePrimitiveNumber MIN_VALUE;

	/**
	 *
	 */
	public static final BasePrimitiveNumber MONE;

	/**
	 *
	 */
	public static final BasePrimitiveNumber NAN;

	/**
	 *
	 */
	public static final BasePrimitiveNumber NINF;

	/**
	 *
	 */
	public static final BasePrimitiveNumber ONE;

	/**
	 *
	 */
	public static final BasePrimitiveNumber PI;

	/**
	 *
	 */
	public static final BasePrimitiveNumber PINF;

	/**
	 *
	 */
	public static final BasePrimitiveNumber SQRT1_2;

	/**
	 *
	 */
	public static final BasePrimitiveNumber SQRT2;

	/**
	 *
	 */
	public static final BasePrimitiveNumber ZERO;

	static {
		assert AbstractSAPI.logDebug("BasePrimitiveNumber: static init...");

		E = new PrimitiveNumberTrue(Math.E);

		LN10 = new PrimitiveNumberTrue(Math.log(10.0d));

		LN2 = new PrimitiveNumberTrue(Math.log(2.0d));

		LOG10E = new PrimitiveNumberTrue(Math.log10(Math.E));

		LOG2E = new PrimitiveNumberTrue(Math.log(Math.E) / Math.log(2));

		MAX_VALUE = new PrimitiveNumberTrue(Double.MAX_VALUE);

		MIN_VALUE = new PrimitiveNumberTrue(Double.MIN_VALUE);

		MONE = new PrimitiveNumberTrueInteger(-1);

		NAN = new PrimitiveNumberNan();

		NINF = new PrimitiveNumberNegativeInfinity();

		ONE = new PrimitiveNumberOne();

		PI = new PrimitiveNumberTrue(Math.PI);

		PINF = new PrimitiveNumberPositiveInfinity();

		SQRT1_2 = new PrimitiveNumberTrue(Math.sqrt(0.5d));

		SQRT2 = new PrimitiveNumberTrue(Math.sqrt(2.0d));

		ZERO = new PrimitiveNumberZero();

		assert AbstractSAPI.logDebug("BasePrimitiveNumber: static init: done.");
	}

	/** non-public method */
	BasePrimitiveNumber() {
		
		//
	}

	/** it is not ok to use this method while knowing that this object is actually a number. */
	@Deprecated
	@Override
	public final boolean baseIsPrimitiveNumber() {
		
		return true;
	}

	@Override
	public final BaseObject basePrototype() {
		
		return BaseNumber.PROTOTYPE;
	}

	/** @param digits
	 * @return */
	public String baseToFixed(final int digits) {
		
		return NumberFormatter.formatFixed(this.doubleValue(), digits);
	}

	@Override
	@ReflectionHidden
	public boolean baseToJavaBoolean() {
		
		return this.doubleValue() != 0;
	}

	@Override
	@ReflectionHidden
	public abstract int baseToJavaInteger();

	@Override
	@ReflectionHidden
	public abstract long baseToJavaLong();

	@Override
	@ReflectionHidden
	public abstract String baseToJavaString();

	/** it is not ok to use this method while knowing that this object is actually a number. */
	@Deprecated
	@Override
	public final BasePrimitiveNumber baseToNumber() {
		
		return this;
	}

	/** @param digits
	 * @return */
	public String baseToPrecision(final int digits) {
		
		return NumberFormatter.formatPrecision(this.doubleValue(), digits);
	}

	@SuppressWarnings("deprecation")
	@Override
	public BasePrimitiveNumber baseToPrimitive(final ToPrimitiveHint hint) {
		
		return this;
	}

	/** @return string */
	@Override
	public abstract BasePrimitiveString baseToString();

	/** @return */
	@Override
	public abstract double doubleValue();

	/**
	 * <pre>
	 * 11.9.1 The Equals Operator ( == )
	 * The production EqualityExpression : EqualityExpression == RelationalExpression is evaluated as follows:
	 * 1. Evaluate EqualityExpression.
	 * 2. Call GetValue(Result(1)).
	 * 3. Evaluate RelationalExpression.
	 * 4. Call GetValue(Result(3)).
	 * 5. Perform the comparison Result(4) == Result(2). (Section 11.9.3.)
	 * 6. Return Result(5).
	 * </pre>
	 *
	 * <pre>
	 * 11.9.3 The Abstract Equality Comparison Algorithm
	 * The comparison x == y, where x and y are values, produces true or false. Such a comparison is performed as
	 * follows:
	 * 1. If Type(x) is different from Type(y), go to step 14.
	 * 2. If Type(x) is Undefined, return true.
	 * 3. If Type(x) is Null, return true.
	 * 4. If Type(x) is not Number, go to step 11.
	 * 5. If x is NaN, return false.
	 * 6. If y is NaN, return false.
	 * 7. If x is the same number value as y, return true.
	 * 8. If x is +0 and y is −0, return true.
	 * 9. If x is −0 and y is +0, return true.
	 * 10. Return false.
	 * 11. If Type(x) is String, then return true if x and y are exactly the same sequence of characters (same length and
	 * same characters in corresponding positions). Otherwise, return false.
	 * 12. If Type(x) is Boolean, return true if x and y are both true or both false. Otherwise, return false.
	 * 13. Return true if x and y refer to the same object or if they refer to objects joined to each other (section 13.1.2).
	 * Otherwise, return false.
	 * 14. If x is null and y is undefined, return true.
	 * 15. If x is undefined and y is null, return true.
	 * 16. If Type(x) is Number and Type(y) is String,
	 * return the result of the comparison x == ToNumber(y).
	 * 17. If Type(x) is String and Type(y) is Number,
	 * return the result of the comparison ToNumber(x) == y.
	 * 18. If Type(x) is Boolean, return the result of the comparison ToNumber(x) == y.
	 * 19. If Type(y) is Boolean, return the result of the comparison x == ToNumber(y).
	 * 20. If Type(x) is either String or Number and Type(y) is Object,
	 * return the result of the comparison x == ToPrimitive(y).
	 * 21. If Type(x) is Object and Type(y) is either String or Number,
	 * return the result of the comparison ToPrimitive(x) == y.
	 * 22. Return false.
	 * </pre>
	 *
	 * NOTE Given the above definition of equality:<br>
	 * String comparison can be forced by: &quot;&quot; + a ==&quot;&quot; +b. <br>
	 * Numeric comparison can be forced by: a - 0== b- 0. <br>
	 * Boolean comparison can be forced by: !a == !b.
	 * <p>
	 * The equality operators maintain the following invariants:<br>
	 * 1. A != B is equivalent to !(A == B). <br>
	 * 2. A == B is equivalent to B == A, except in the order of evaluation of A and B.<br>
	 * The equality operator is not always transitive. For example, there might be two distinct
	 * String objects, each representing the same string value; each String object would be
	 * considered equal to the string value by the == operator, but the two String objects would not
	 * be equal to each other.
	 * <p>
	 * Comparison of strings uses a simple equality test on sequences of code point value values.
	 * There is no attempt to use the more complex, semantically oriented definitions of character
	 * or string equality and collating order defined in the Unicode 2.0 specification. Therefore
	 * strings that are canonically equal according to the Unicode standard could test as unequal.
	 * In effect this algorithm assumes that both strings are already in normalised form.
	 * <p>
	 *
	 * Type x is this and is an object of any type. */
	@Override
	public final boolean equals(final Object o) {
		
		if (o == this) {
			return true;
		}
		if (o instanceof final BaseObject baseObject) {
			return baseObject.baseToNumber().baseValue().equals(this.baseValue());
		}
		if (o instanceof Number) {
			final Object baseValue = this.baseValue();
			if (baseValue != this) {
				return o.equals(baseValue);
			}
			return ((Number) o).doubleValue() == this.doubleValue();
		}
		return false;
	}

	/** @return */
	@Override
	public abstract float floatValue();

	@Override
	public abstract int hashCode();

	/** Ecma: ToInt32
	 *
	 * @return */
	@Override
	public abstract int intValue();

	/** Ecma: ToInt64 (ToInteger rules are not compatible with java long)
	 *
	 * @return */
	@Override
	public abstract long longValue();

	@Override
	public String stringValue() {
		
		return this.baseToString().stringValue();
	}

	/** Yes - this way only
	 *
	 * return this.stringValue() */
	@Override
	public final String toString() {
		
		return this.stringValue();
	}

}
