/**
 *
 */
package ru.myx.ae3.base;

import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/** @author myx */
@ReflectionDisable
final class PrimitiveStringEmpty extends BasePrimitiveString {
	
	private final String value;
	
	PrimitiveStringEmpty() {
		
		this.value = "".intern();
	}
	
	/** The result is false if the argument is the empty string (its length is zero); otherwise the
	 * result is true. */
	@Override
	public final BasePrimitiveBoolean baseToBoolean() {
		
		return BaseObject.FALSE;
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
		
		return this.value;
	}
	
	/** A StringNumericLiteral that is empty or contains only white space is converted to +0.
	 * <p>
	 *
	 * String is empty */
	@Override
	public final BasePrimitiveNumber baseToNumber() {
		
		return BasePrimitiveNumber.ZERO;
	}
	
	@Override
	public final String baseValue() {
		
		return this.value;
	}
	
	@Override
	public double doubleValue() {
		
		/** The MV of StringNumericLiteral ::: [empty] is 0. */
		return 0;
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
	public final boolean equals(final Object o) {
		
		if (o == this || o == this.value) {
			return true;
		}
		if (o instanceof final BaseObject object) {
			if (object.baseIsPrimitive()) {
				if (object.baseIsPrimitiveString()) {
					return object.baseToJavaString().length() == 0;
				}
				if (object.baseIsPrimitiveNumber()) {
					return this.baseToNumber().equals(o);
				}
				if (object.baseIsPrimitiveBoolean()) {
					return this.baseToNumber().equals(object.baseToNumber());
				}
				return false;
			}
			final Object base = object.baseValue();
			if (base != null && base != object) {
				return base == this || base instanceof final CharSequence charSequence && charSequence.length() == 0;
			}
		}
		return o instanceof final CharSequence charSequence && charSequence.length() == 0;
	}
	
	@Override
	public int hashCode() {
		
		return this.value.hashCode();
	}
	
	@Override
	public int indexOf(final String search, final int fromIndex) {
		
		return -1;
	}
	
	@Override
	public int intValue() {
		
		return 0;
	}
	
	@Override
	public final boolean isEmpty() {
		
		return true;
	}
	
	@Override
	public final int length() {
		
		return 0;
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

	@Override
	public final BasePrimitiveString trim() {
		
		return this;
	}

}
