package ru.myx.ae3.base;

import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/** @author myx */
@ReflectionDisable
final class PrimitiveBooleanFalse extends BasePrimitiveBoolean {

	/** @param value */
	PrimitiveBooleanFalse() {
		
		//
	}
	
	@Override
	public BasePrimitiveBoolean baseToBooleanXorTrue() {

		return BaseObject.TRUE;
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

		return false;
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

		return BaseString.STR_FALSE.baseToJavaString();
	}
	
	@Override
	public final BasePrimitiveNumber baseToNumber() {

		return BasePrimitiveNumber.ZERO;
	}
	
	@Override
	public final BasePrimitiveString baseToString() {

		return BaseString.STR_FALSE;
	}
	
	@Override
	public final BasePrimitiveString baseToStringIfReady() {

		return BaseString.STR_FALSE;
	}
	
	@Override
	public final Boolean baseValue() {

		return Boolean.FALSE;
	}
	
	@Override
	public final Boolean baseValueXorTrue() {

		return Boolean.TRUE;
	}
	
	@Override
	public final boolean booleanValue() {

		return false;
	}
	
	@Override
	public boolean booleanValueXorTrue() {

		return true;
	}
	
	@Override
	public double doubleValue() {

		return 0.0;
	}
	
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
	public boolean equals(final Object o) {

		return o == this || o instanceof final Boolean booleanObject && !booleanObject.booleanValue();
	}
	
	@Override
	public int hashCode() {

		return 0;
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
	public String stringValue() {

		return BaseString.STR_FALSE.stringValue();
	}
	
	@Override
	public String toString() {

		return BaseString.STR_FALSE.toString();
	}
}
