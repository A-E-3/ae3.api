/**
 *
 */
package ru.myx.ae3.base;

import java.util.Iterator;



import ru.myx.ae3.common.FutureValue;
import ru.myx.ae3.e4.vm.VmReflected;
import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;
import ru.myx.ae3.report.Report;

/** @author myx */
@ReflectionDisable
public interface BaseObject extends VmReflected
// extends Value<T>
/* , Comparable<BaseObject> - conflicts with JDK */
/* , Comparable<Object> - conflicts with JDK */
/* , Iterable<String> - conflicts with collections */
/* , Map< String , Object > - too complicated */ {

	/** BaseObject PROTOTYPE - root prototype has no prototype */
	@ReflectionHidden
	BaseObject PROTOTYPE = BaseObject.createObject(null);

	/** FALSE */
	@ReflectionHidden
	BasePrimitiveBoolean FALSE = new PrimitiveBooleanFalse();

	/** TRUE */
	@ReflectionHidden
	BasePrimitiveBoolean TRUE = new PrimitiveBooleanTrue();

	/** UNDEFINED */
	@ReflectionHidden
	BasePrimitiveUndefined UNDEFINED = new BasePrimitiveUndefined();

	/** NULL */
	@ReflectionHidden
	BasePrimitiveNull NULL = new BasePrimitiveNull();
	/** iterator() method should not ever return NULL, return this value at least. */
	@SuppressWarnings("unchecked")
	@ReflectionHidden
	Iterator<String> ITERATOR_EMPTY = (Iterator<String>) IteratorEmpty.INSTANCE;

	/** iterator() method should not ever return NULL, return this value at least. */
	@SuppressWarnings("unchecked")
	@ReflectionHidden
	Iterator<BasePrimitive<?>> ITERATOR_EMPTY_PRIMITIVE = (Iterator<BasePrimitive<?>>) IteratorEmpty.INSTANCE;

	/** constant, read only */
	@ReflectionHidden
	SealedEmptyObject SEALED_EMPTY_OBJECT = SealedEmptyObject.INSTANCE;

	/**
	 * <pre>
	 * 11.8.5 The Abstract Relational Comparison Algorithm
	 * </pre>
	 *
	 * @param o1
	 * @param o2
	 * @return */
	@ReflectionHidden
	static int compareGeneric(final BaseObject o1, final BaseObject o2) {

		if (o1 == o2) {
			return 0;
		}
		if (o1 == BasePrimitiveNumber.NAN) {
			return -1;
		}
		if (o2 == BasePrimitiveNumber.NAN) {
			return 1;
		}

		/** 1. If the LeftFirst flag is true, then<br>
		 * a. Let px be the result of calling ToPrimitive(x, hint Number).<br>
		 * b. Let py be the result of calling ToPrimitive(y, hint Number).<br>
		 * 2. Else the order of evaluation needs to be reversed to preserve left to right evaluation
		 * <br>
		 * a. Let py be the result of calling ToPrimitive(y, hint Number).<br>
		 * b. Let px be the result of calling ToPrimitive(x, hint Number).<br>
		 */

		final BasePrimitive<?> px = o1.baseToPrimitive(ToPrimitiveHint.NUMBER);
		final BasePrimitive<?> py = o2.baseToPrimitive(ToPrimitiveHint.NUMBER);

		if (!(px instanceof CharSequence && py instanceof CharSequence)) {
			/** 3. If it is not the case that both Type(px) is String and Type(py) is String,
			 * then */
			/** a. Let nx be the result of calling ToNumber(px). Because px and py are primitive
			 * values evaluation order is not important. <br>
			 * b. Let ny be the result of calling ToNumber(py).<br>
			 */
			// final BasePrimitiveNumber nx = px.baseToNumber();
			final double nx = px.doubleValue();
			// final BasePrimitiveNumber ny = py.baseToNumber();
			final double ny = py.doubleValue();
			/** c. If nx is NaN, return undefined. <br>
			 * d. If ny is NaN, return undefined.<br>
			 */
			// if (nx == BasePrimitiveNumber.NAN || ny ==
			// BasePrimitiveNumber.NAN) {
			if (Double.isNaN(nx)) {
				// return nx == ny
				return Double.isNaN(nx) && Double.isNaN(ny)
					? 0
					: -1;
			}
			if (Double.isNaN(ny)) {
				// return nx == ny
				return 1;
			}
			/** e. If nx and ny are the same Number value, return false.<br>
			 * f. If nx is +0 and ny is −0, return false.<br>
			 * g. If nx is −0 and ny is +0, return false.<br>
			 */
			if (nx == ny) {
				return 0;
			}
			/** h. If nx is +∞, return false.<br>
			 * i. If ny is +∞, return true.<br>
			 * j. If ny is −∞, return false.<br>
			 * k. If nx is −∞, return true.<br>
			 */
			// if (nx == BasePrimitiveNumber.PINF) {
			if (Double.isInfinite(nx) && nx > 0) {
				return 1;
			}
			// if (ny == BasePrimitiveNumber.PINF) {
			if (Double.isInfinite(ny) && nx > 0) {
				return -1;
			}
			// if (ny == BasePrimitiveNumber.NINF) {
			if (Double.isInfinite(ny) && nx < 0) {
				return 1;
			}
			// if (nx == BasePrimitiveNumber.NINF) {
			if (Double.isInfinite(nx) && nx < 0) {
				return -1;
			}
			/** l. If the mathematical value of nx is less than the mathematical value of ny —note
			 * that these mathematical values are both finite and not both zero—return true.
			 * Otherwise, return false. */
			// final double compare = nx.doubleValue() - ny.doubleValue();
			final double compare = nx - ny;
			return compare == 0
				/** cant be, by the way */
				? 0
				: compare > 0
					? 1
					: -1;
		}
		{
			/** 4. Else, both px and py are Strings */
			/** a. If py is a prefix of px, return false. (A String value p is a prefix of String
			 * value q if q can be the result of concatenating p and some other String r. Note that
			 * any String is a prefix of itself, because r may be the empty String.) <br>
			 *
			 * b. If px is a prefix of py, return true.<br>
			 *
			 * c. Let k be the smallest nonnegative integer such that the character at position k
			 * within px is different from the character at position k within py. (There must be
			 * such a k, for neither String is a prefix of the other.)<br>
			 *
			 * d. Let m be the integer that is the code unit value for the character at position k
			 * within px.<br>
			 *
			 * e. Let n be the integer that is the code unit value for the character at position k
			 * within py.<br>
			 *
			 * f. If m < n, return true. Otherwise, return false. */
			/** definitely strings, so .toString() instead of baseToJavaString() */
			return px.stringValue().compareTo(py.stringValue());
		}
	}

	/** Creates default extensible unsealed array object just like '[]' will do in the script
	 *
	 *
	 *
	 * Alias for BaseList.create();
	 *
	 * @return */
	// @SuppressWarnings("unchecked")
	@ReflectionHidden
	static <T> BaseList<T> createArray() {

		return Base.OBJECT_FACTORY.createArray();
		/** try { return (BaseList<T>) Base.OF_CLS_BASE_LIST.newInstance(); } catch
		 * (InstantiationException | IllegalAccessException e) { throw new
		 * RuntimeException("BaseObject: array factory failure", e); } */
	}

	/** Creates default extensible unsealed array object just like '[]' will do in the script
	 *
	 *
	 *
	 * Alias for BaseList.create();
	 *
	 * @param populate
	 * @return */
	// @SuppressWarnings("unchecked")
	@ReflectionHidden
	static <T> BaseList<T> createArray(final BaseArray populate) {

		final int length = populate.length();
		final BaseList<T> result = Base.OBJECT_FACTORY.createArray(length);
		for (int i = 0; i < length; ++i) {
			result.baseDefaultPush(populate.baseGet(i, BaseObject.UNDEFINED));
		}
		return result;
		/** try { return (BaseList<T>) Base.OF_CLS_BASE_LIST.newInstance(); } catch
		 * (InstantiationException | IllegalAccessException e) { throw new
		 * RuntimeException("BaseObject: array factory failure", e); } */
	}

	/** Creates default extensible unsealed array object just like '[]' will do in the script
	 *
	 *
	 *
	 * Alias for BaseList.create();
	 *
	 * @param expectedLength
	 * @return */
	// @SuppressWarnings("unchecked")
	@ReflectionHidden
	static <T> BaseList<T> createArray(final int expectedLength) {

		return Base.OBJECT_FACTORY.createArray(expectedLength);
		/** try { return (BaseList<T>) Base.OF_CLS_BASE_LIST.newInstance(); } catch
		 * (InstantiationException | IllegalAccessException e) { throw new
		 * RuntimeException("BaseObject: array factory failure", e); } */
	}

	/** Creates default extensible unsealed object just like '{}' will do in the script
	 *
	 *
	 *
	 * Alias for BaseMap.create();
	 *
	 * @return */
	@ReflectionHidden
	static BaseMapEditable createObject() {

		return Base.OBJECT_FACTORY.createObject();
		/** try { return Base.OF_CLS_BASE_MAP.newInstance(); } catch (InstantiationException |
		 * IllegalAccessException e) { throw new RuntimeException("BaseObject: BaseMap factory
		 * failure", e); } */
	}

	/** Creates default extensible unsealed object just like '{}' will do in the script but with
	 * given prototype.
	 *
	 * @param prototype
	 *
	 * @return */
	@ReflectionHidden
	static BaseMapEditable createObject(final BaseObject prototype) {

		return Base.OBJECT_FACTORY.createObject(prototype);
		/** try { return Base.OF_CNS_BASE_MAP.newInstance(prototype); } catch
		 * (InvocationTargetException e) { throw new RuntimeException( "BaseObject: BaseMap factory
		 * failure", e.getCause()); } catch (InstantiationException | IllegalAccessException |
		 * IllegalArgumentException e) { throw new RuntimeException( "BaseObject: BaseMap factory
		 * failure", e); } */
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
	 * ECMAScript Language Specification   Edition 3   24-Mar-00
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
	 * Type x is this and is an object of any type.
	 *
	 *
	 * @param b
	 * @param o
	 * @return */
	@ReflectionHidden
	static boolean equalsGeneric(final BaseObject b, final Object o) {

		if (b == null || o == null) {
			return false;
		}
		/** Fits here, booleans, undefined and null are fixed:<br>
		 * 2. If Type(x) is Undefined, return true.<br>
		 * 3. If Type(x) is Null, return true. 12. If Type(x) is Boolean, return true if x and y are
		 * both true or both false. Otherwise, return false. */
		if (b == o) {
			return true;
		}
		/** instanceof is always false on NULL object */
		if (!(o instanceof BaseObject)) {
			return false;
		}
		if (o == BasePrimitiveNumber.NAN) {
			return false;
		}
		final BaseObject object = (BaseObject) o;
		if (b.baseIsPrimitiveNumber()) {
			assert false : "PrimitiveNumber object should have it's own equals method implementation!";
			/** 7. If x is the same number value as y, return true.<br>
			 * 8. If x is +0 and y is −0, return true.<br>
			 * 9. If x is −0 and y is +0, return true.<br>
			 * 10. Return false. <br>
			 */
			if (object.baseIsPrimitiveNumber()) {
				return b.baseValue().equals(object.baseValue());
			}
			/** 16. If Type(x) is Number and Type(y) is String,<br>
			 * return the result of the comparison x == ToNumber(y). */
			if (object.baseIsPrimitiveString()) {
				return b.baseValue().equals(object.baseToNumber().baseValue());
			}
			/** 20. If Type(x) is either String or Number and Type(y) is Object, <br>
			 * return the result of the comparison x == ToPrimitive(y). */
			if (!object.baseIsPrimitive()) {
				return b.equals(object.baseToPrimitive(ToPrimitiveHint.NUMBER));
			}
		}
		if (b.baseIsPrimitiveString()) {
			assert false : "PrimitiveString object should have it's own equals method implementation!";
			/** 11. If Type(x) is String, then return true if x and y are exactly the same sequence
			 * of characters (same length and same characters in corresponding positions).
			 * Otherwise, return false. */
			if (object.baseIsPrimitiveString()) {
				return b.baseValue().equals(object.baseValue());
			}
			/** 17. If Type(x) is String and Type(y) is Number,<br>
			 * return the result of the comparison ToNumber(x) == y. */
			if (object.baseIsPrimitiveNumber()) {
				return b.baseToNumber().baseValue().equals(object.baseValue());
			}
			/** 20. If Type(x) is either String or Number and Type(y) is Object, <br>
			 * return the result of the comparison x == ToPrimitive(y). */
			if (!object.baseIsPrimitive()) {
				return b.equals(object.baseToPrimitive(ToPrimitiveHint.STRING));
			}
		}
		/** !!!SKIPPED:<br>
		 * 13. Return true if x and y refer to the same object or if they refer to objects joined to
		 * each other (section 13.1.2). Otherwise, return false. */
		/** 14. If x is null and y is undefined, return true.<br>
		 * 15. If x is undefined and y is null, return true. <br>
		 */
		if (o == BaseObject.UNDEFINED || o == BaseObject.NULL) {
			return false;
		}
		/** 18. If Type(x) is Boolean,<br>
		 * return the result of the comparison ToNumber(x) == y. */
		assert !b.baseIsPrimitiveBoolean() : "PrimitiveBoolean object must have it's own equals method implementation!";
		/** 19. If Type(y) is Boolean,<br>
		 * return the result of the comparison x == ToNumber(y). */
		if (object.baseIsPrimitiveBoolean()) {
			return b.equals(object.baseToNumber());
		}
		/** 21. If Type(x) is Object and Type(y) is either String or Number,<br>
		 * return the result of the comparison ToPrimitive(x) == y. */
		if (!b.baseIsPrimitive()) {
			if (object.baseIsPrimitiveString()) {
				return b.baseToPrimitive(ToPrimitiveHint.STRING).equals(object);
			}
			if (object.baseIsPrimitiveNumber()) {
				return b.baseToPrimitive(ToPrimitiveHint.NUMBER).equals(object);
			}
		}
		/** 22. Return false. */
		return false;
	}

	/** ECMA EQU comparison is not the same as ECMA.compare() == 0. {a:5} is not equal to {a:5}. It
	 * doesn't do any 'valueOf' and 'toString' calls.
	 *
	 *
	 *
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
	 *
	 * @param o1
	 * @param o2
	 * @return */
	@ReflectionHidden
	static boolean equalsNative(final BaseObject o1, final BaseObject o2) {

		if (o1 == BasePrimitiveNumber.NAN || o2 == BasePrimitiveNumber.NAN) {
			return false;
		}
		if (o1 == o2) {
			return true;
		}

		/** False exact
		 *
		 * FIXME: js should do: '000' == false */
		{
			if (o1 == null || o1 == BaseObject.UNDEFINED || o1 == BaseObject.NULL) {
				return o2 == null || o2 == BaseObject.UNDEFINED || o2 == BaseObject.NULL;
			}

			if (o2 == null || o2 == BaseObject.UNDEFINED || o2 == BaseObject.NULL) {
				return false/* o1 == null || o1 == BaseObject.UNDEFINED || o1 == BaseObject.NULL */;
			}

			if (o1 == BaseObject.FALSE) {
				return !o2.baseToJavaBoolean();
			}

			if (o2 == BaseObject.FALSE) {
				return !o1.baseToJavaBoolean();
			}
		}

		/** True exact */
		{
			if (o1 == BaseObject.TRUE) {
				return /* o2 != null && */ o2 == BaseObject.TRUE || o2.baseToJavaBoolean();
			}

			if (o2 == BaseObject.TRUE) {
				return /* o1 != null && */ o1.baseToJavaBoolean();
			}
		}

		/** False-alike */
		{
			if ((o1 == BasePrimitiveNumber.ZERO || o1 == BaseString.EMPTY) && (o2 == BasePrimitiveNumber.ZERO || o2 == BaseString.EMPTY)) {
				return true;
			}
		}

		// assert o1 != null && o2 != null : "should not get there ^^^^^";

		/** 11. If Type(x) is String, then return true if x and y are exactly the same sequence of
		 * characters (same length and same characters in corresponding positions). Otherwise,
		 * return false.
		 *
		 * (for context/temporary objects)
		 *
		 * already done earlier: <code>
			 if (o1.baseIsPrimitiveString() && o2.baseIsPrimitiveString()) {
				 return o1.baseToJavaString()
				 .compareTo( o2.baseToPrimitive( ToPrimitiveHint.STRING
				 ).baseToJavaString() ) == 0;
			 }
		 * </code> */
		if (o1 instanceof CharSequence && o2 instanceof CharSequence) {
			final String s1 = o1.toString();
			final String s2 = o2.toString();
			return s1 == null
				? s2 == null
				: s2 == null
					? false
					: s1.equals(s2);
		}
		/** Number vs Number, equals was earlier, but still need to compare.
		 *
		 * (for context/temporary objects)
		 *
		 * already done earlier: <code>
			if (o1.baseIsPrimitiveNumber() && o2.baseIsPrimitiveNumber()) {
				return Double.doubleToLongBits( o1.baseToPrimitive( null ).doubleValue() ) //
				== Double.doubleToLongBits( o2.baseToPrimitive( null ).doubleValue() );
			}
		 * </code>
		 *
		 * TODO: re-check, clean up */
		if (o1 instanceof Number && o2 instanceof Number) {
			return Double.doubleToLongBits(((Number) o1).doubleValue()) //
			== Double.doubleToLongBits(((Number) o2).doubleValue());
		}
		/** 16. If Type(x) is Number and Type(y) is String, return the result of the comparison x ==
		 * ToNumber(y). */
		if (o1.baseIsPrimitiveNumber() && o2.baseIsPrimitiveString()) {
			/** for fakes */
			// return o1 == o2.baseToNumber();
			return Double.doubleToLongBits(o1.baseToPrimitive(null).doubleValue()) //
			== Double.doubleToLongBits(o2.baseToPrimitive(null).doubleValue());
		}
		/** 17. If Type(x) is String and Type(y) is Number, return the result of the comparison
		 * ToNumber(x) == y. */
		if (o1.baseIsPrimitiveString() && o2.baseIsPrimitiveNumber()) {
			/** for fakes */
			// return o1.baseToNumber() == o2;
			return Double.doubleToLongBits(o1.baseToPrimitive(null).doubleValue()) //
			== Double.doubleToLongBits(o2.baseToPrimitive(null).doubleValue());
		}
		if (!o2.baseIsPrimitive()) {
			/** 20. If Type(x) is either String or Number and Type(y) is Object, return the result
			 * of the comparison x == ToPrimitive(y). */
			if (o1.baseIsPrimitiveString()) {
				return o1 == o2.baseToPrimitive(ToPrimitiveHint.STRING);
				// return ComparatorEcma.compareEQU( o1, o2.baseToPrimitive(
				// ToPrimitiveHint.STRING ) );
			}
			if (o1.baseIsPrimitiveNumber()) {
				return o1 == o2.baseToPrimitive(ToPrimitiveHint.NUMBER);
				// return ComparatorEcma.compareEQU( o1, o2.baseToPrimitive(
				// ToPrimitiveHint.NUMBER ) );
			}
			final Object base = o2.baseValue();
			if (base != o2 && base instanceof BaseObject) {
				return BaseObject.equalsNative(o1, (BaseObject) base);
			}
		}
		if (!o1.baseIsPrimitive()) {
			/** 21. If Type(x) is Object and Type(y) is either String or Number, return the result
			 * of the comparison ToPrimitive(x) == y. */
			if (o2.baseIsPrimitiveString()) {
				return o1.baseToPrimitive(ToPrimitiveHint.STRING) == o2;
				// return ComparatorEcma.compareEQU( o1.baseToPrimitive(
				// ToPrimitiveHint.STRING ), o2 );
			}
			if (o2.baseIsPrimitiveNumber()) {
				return o1.baseToPrimitive(ToPrimitiveHint.NUMBER) == o2;
				// return ComparatorEcma.compareEQU( o1.baseToPrimitive(
				// ToPrimitiveHint.NUMBER ), o2 );
			}
			final Object base = o1.baseValue();
			if (base != o1 && base instanceof BaseObject) {
				return BaseObject.equalsNative((BaseObject) base, o2);
			}
		}
		{
			// FIXME: EMERGENCY
			if (o1.getClass() == o2.getClass() && o1.baseValue() != o2.baseValue() && o1.equals(o2)) {
				/** do not catch - let's propagate such errors! */
				return true;
			}
		}
		return false;
	}

	/** 11.9.6 The Strict Equality Comparison Algorithm
	 * <p>
	 * The comparison x === y, where x and y are values, produces true or false. Such a comparison
	 * is performed as follows: <br>
	 * 1. If Type(x) is different from Type(y), return false.<br>
	 * 2. If Type(x) is Undefined, return true. <br>
	 * 3. If Type(x) is Null, return true. <br>
	 * 4. If Type(x) is not Number, go to step 11.<br>
	 * 5. If x is NaN, return false. <br>
	 * 6. If y is NaN, return false. <br>
	 * 7. If x is the same number value as y, return true.<br>
	 * 8. If x is +0 and y is −0, return true. <br>
	 * 9. If x is −0 and y is +0, return true. <br>
	 * 10. Return false. <br>
	 * 11. If Type(x) is String, then return true if x and y are exactly the same sequence of
	 * characters (same length and same characters in corresponding positions); otherwise, return
	 * false.<br>
	 * 12. If Type(x) is Boolean, return true if x and y are both true or both false; otherwise,
	 * return false.<br>
	 * 13. Return true if x and y refer to the same object or if they refer to objects joined to
	 * each other (section 13.1.2). Otherwise, return false. <br>
	 * <p>
	 *
	 * @param o1
	 * @param o2
	 * @return */
	@ReflectionHidden
	static boolean equalsStrict(final BaseObject o1, final BaseObject o2) {

		if (o1 == BasePrimitiveNumber.NAN || o2 == BasePrimitiveNumber.NAN) {
			return false;
		}
		if (o2 == o1) {
			return true;
		}
		/** have to do all of this because of non-detachable values */
		if (o1 instanceof BasePrimitive<?> && o2 instanceof BasePrimitive<?>) {
			/** Strings are strictly comparable
			 *
			 * No code needed:<code>
			 * </code> */
			if (o1.baseIsPrimitiveString() && o2.baseIsPrimitiveString()) {
				return o1.toString().equals(o2.toString());
			}
			/** Numbers are strictly comparable
			 *
			 * No code needed:<code>
			 * </code> */
			if (o1.baseIsPrimitiveNumber() && o2.baseIsPrimitiveNumber()) {
				return ((BasePrimitive<?>) o1).doubleValue() == ((BasePrimitive<?>) o2).doubleValue();
			}
			/** Booleans are strictly comparable
			 *
			 * No code needed:<code>
			if (argumentA.baseIsPrimitiveBoolean() && argumentB.baseIsPrimitiveBoolean()) {
				ctx.r7RR = argumentA.equals( argumentB )
						? BaseObject.TRUE
						: BaseObject.FALSE;
				return null;
			}
			 * </code> */
		}
		{
			final Object base = o1.baseValue();
			if (base != o1) {
				if (base instanceof BaseObject) {
					return BaseObject.equalsStrict((BaseObject) base, o2);
				} else //
				if (o1 instanceof FutureValue) {
					return BaseObject.equalsStrict(Base.forUnknown(base), o2);
				}
			}
		}
		{
			final Object base = o2.baseValue();
			if (base != o2) {
				if (base instanceof BaseObject) {
					return BaseObject.equalsStrict(o1, (BaseObject) base);
				} else //
				if (o2 instanceof FutureValue) {
					return BaseObject.equalsStrict(o1, Base.forUnknown(base));
				}
			}
		}
		return false;
	}

	/** @param b
	 * @return */
	@ReflectionHidden
	static int hashCodeGeneric(final BaseObject b) {

		final Object value = b.baseValue();
		if (value == b) {
			return System.identityHashCode(b);
		}
		return value == null
			? 0
			: value.hashCode();
	}

	/** Return NULL is not a writable array.
	 *
	 * @return TODO */
	// BaseArrayWritable<? extends Object, ? extends Object>
	// baseArrayWritable();

	/** Return NULL if not an array.
	 *
	 * @return NULL by default */
	@ReflectionHidden
	default BaseArray baseArray() {

		return null;
	}

	/** Returns a function associated with this object. Executes code associated with the object.
	 * Invoked via a function call expression. Objects that implement this internal method are
	 * called functions.
	 *
	 * null result means that this object is not a function.
	 *
	 * 13.2.1 [[Call]]
	 * <p>
	 * When the [[Call]] property for a Function object F is called, the following steps are
	 * taken:<br>
	 * 1. Establish a new execution context using F's FormalParameterList, the passed arguments
	 * list, and the this value as described in Section 10.2.3. <br>
	 * 2. Evaluate F's FunctionBody. <br>
	 * 3. Exit the execution context established in step 1, restoring the previous execution
	 * context.<br>
	 * 4. If Result(2).type is throw then throw Result(2).value. <br>
	 * 5. If Result(2).type is return then return Result(2).value. <br>
	 * 6. (Result(2).type must be normal.) Return undefined.
	 * <p>
	 *
	 *
	 * @return null by default */
	@ReflectionHidden
	default BaseFunction baseCall() {

		return null;
	}

	/** @param ctx
	 * @param name
	 * @param soft
	 *            when true, no error will be thrown when there is no such property or it is not a
	 *            function
	 * @param argument
	 * @return */
	@ReflectionHidden
	default BaseObject baseCall(final ExecProcess ctx, final String name, final boolean soft, final BaseObject argument) {

		final BaseObject value = this.baseGet(name, BaseObject.UNDEFINED);
		final BaseFunction candidate = value.baseCall();
		if (candidate == null) {
			if (soft) {
				return BaseObject.UNDEFINED;
			}
			throw new IllegalArgumentException("No " + name + " method detected, candidateClass=" + value.getClass().getName());
		}

		return candidate.callNE1(ctx, this, argument);
	}

	/** @param name
	 * @param soft
	 *            when true, no error will be thrown when there is no such property or it is not a
	 *            function
	 * @return */
	@ReflectionHidden
	default BaseObject baseCall(final String name, final boolean soft) {

		final BaseObject value = this.baseGet(name, BaseObject.UNDEFINED);
		final BaseFunction candidate = value.baseCall();
		if (candidate == null) {
			if (soft) {
				return BaseObject.UNDEFINED;
			}
			throw new IllegalArgumentException("No " + name + " method detected, candidateClass=" + value.getClass().getName());
		}

		return candidate.callNJ0(this);
	}

	/** @param name
	 * @param soft
	 *            when true, no error will be thrown when there is no such property or it is not a
	 *            function
	 * @param argument
	 * @return */
	@ReflectionHidden
	default BaseObject baseCall(final String name, final boolean soft, final BaseObject argument) {

		final BaseObject value = this.baseGet(name, BaseObject.UNDEFINED);
		final BaseFunction candidate = value.baseCall();
		if (candidate == null) {
			if (soft) {
				return BaseObject.UNDEFINED;
			}
			throw new IllegalArgumentException("No " + name + " method detected, candidateClass=" + value.getClass().getName());
		}

		return candidate.callNJ1(this, argument);
	}

	/** The value of the [[Class]] property is defined by this specification for every kind of
	 * built-in object. The value of the [[Class]] property of a host object may be any value, even
	 * a value used by a built-in object for its [[Class]] property. The value of a [[Class]]
	 * property is used internally to distinguish different kinds of built-in objects. Note that
	 * this specification does not provide any means for a program to access that value except
	 * through Object.prototype.toString (see 15.2.4.2).
	 *
	 * @return class, 'Object' by default */
	@ReflectionHidden
	default String baseClass() {

		return "Object";
	}

	/** Should delete all delete-able own properties.
	 *
	 * <pre>
	 * Iterator&lt;String&gt; iterator = this.baseKeysOwn;
	 * for (; iterator.hasNext();) {
	 * 	this.baseDelete(iterator.next());
	 * }
	 * </pre>
	 *
	 *
	 * Deletes all own keys by default */
	@ReflectionHidden
	default void baseClear() {

		final Iterator<String> iterator = this.baseKeysOwn();
		for (; iterator.hasNext();) {
			this.baseDelete(iterator.next());
		}
	}

	/** Returns constructor associated with this object. Constructs an object. Invoked via the new
	 * operator. Objects that implement this internal method are called constructors.
	 *
	 * null result means that this object is not a function.
	 *
	 * 13.2.2 [[Construct]]
	 * <p>
	 * When the [[Construct]] property for a Function object F is called, the following steps are
	 * taken:<br>
	 * 1. Create a new native ECMAScript object. <br>
	 * 2. Set the [[Class]] property of Result(1) to "Object".<br>
	 * 3. Get the value of the prototype property of the F. <br>
	 * 4. If Result(3) is an object, set the [[Prototype]] property of Result(1) to Result(3).<br>
	 * 5. If Result(3) is not an object, set the [[Prototype]] property of Result(1) to the original
	 * Object prototype object as described in section 15.2.3.1. <br>
	 * 6. Invoke the [[Call]] property of F, providing Result(1) as the this value and providing the
	 * argument list passed into [[Construct]] as the argument values.<br>
	 * 7. If Type(Result(6)) is Object then return Result(6).<br>
	 * 8. Return Result(1).
	 * <p>
	 *
	 * @return null by default */
	@ReflectionHidden
	default BaseFunction baseConstruct() {

		return null;
	}

	/** BaseObject
	 *
	 * Short cut for 'define(o,name,value.true,true,true)'
	 *
	 * FIXME: extend to support array index writes
	 *
	 * @param name
	 * @param value
	 * @return */
	@ReflectionHidden
	default boolean baseDefine(final BasePrimitive<?> name, final BaseObject value) {

		return name instanceof BasePrimitiveString
			? this.baseDefine((BasePrimitiveString) name, value, BaseProperty.ATTRS_MASK_WED)
			: this.baseDefine(name.stringValue(), value, BaseProperty.ATTRS_MASK_WED);
	}

	/** BaseObject
	 *
	 * Short cut for 'define(o,name,value.true,true,true)'
	 *
	 * FIXME: extend to support array index writes
	 *
	 * @param name
	 * @param value
	 * @return */
	@ReflectionHidden
	default boolean baseDefine(final BasePrimitiveString name, final BaseObject value) {

		return this.baseDefine(name, value, BaseProperty.ATTRS_MASK_WED);
	}

	/** Sets object's own property with specified attributes attached. In scripting, explicit store
	 * object specifier (i.e. "a.b = 5" as opposed to "a = 5") should use this method.
	 *
	 * @param name
	 * @param value
	 * @param attributes
	 * @return */
	@ReflectionHidden
	default boolean baseDefine(final BasePrimitiveString name, final BaseObject value, final short attributes) {

		assert value != null : "NULL java object!";
		final BaseProperty property = this.baseFindProperty(name);
		if (property == null) {
			return false;
		}
		final short propertyAttributes = property.propertyAttributes(name);
		if ((propertyAttributes & BaseProperty.ATTRS_DYNAMIC_OR_PROCEDURAL_SET) != 0) {
			return property.propertySet(this, name, value, attributes);
		}
		if ((propertyAttributes & BaseProperty.ATTR_WRITABLE) == 0 || (attributes & BaseProperty.ATTRS_MASK_WED) != (propertyAttributes & BaseProperty.ATTRS_MASK_WED)) {
			return false;
		}
		return property.propertySet(this, name, value, attributes);
	}

	/** level0 macro.
	 *
	 * @param object
	 * @param name
	 * @param value
	 * @param attributes
	 * @return */
	@ReflectionHidden
	default boolean baseDefine(final CharSequence name, final BaseObject value, final short attributes) {

		return name instanceof BasePrimitiveString
			? this.baseDefine((BasePrimitiveString) name, value, attributes)
			: this.baseDefine(name.toString(), value, attributes);
	}

	/** BaseObject
	 *
	 * Short cut for 'define(o,name,value.true,true,true)'
	 *
	 *
	 * @param name
	 * @param value
	 * @return */
	@ReflectionHidden
	default boolean baseDefine(final String name, final BaseObject value) {

		assert value != null : "NULL java object!";
		return this.baseDefine(name, value, BaseProperty.ATTRS_MASK_WED);
	}

	/** BaseOrdinary
	 *
	 *
	 * Sets object's own property with specified attributes attached. In scripting, explicit store
	 * object specifier (i.e. "a.b = 5" as opposed to "a = 5") should use this method.
	 *
	 * @param name
	 * @param value
	 * @param attributes
	 * @return */
	@ReflectionHidden
	default boolean baseDefine(final String name, final BaseObject value, final short attributes) {

		assert name != null : "Name is NULL";
		assert value != null : "Shouldn't be NULL, use BaseObject.UNDEFINED or BaseObject.NULL instead";
		final BaseProperty property = this.baseFindProperty(name);
		if (property == null) {
			return false;
		}
		final short propertyAttributes = property.propertyAttributes(name);
		if ((propertyAttributes & BaseProperty.ATTRS_DYNAMIC_OR_PROCEDURAL_SET) != 0) {
			return property.propertySet(this, name, value, attributes);
		}
		if ((propertyAttributes & BaseProperty.ATTR_WRITABLE) == 0 || (attributes & BaseProperty.ATTRS_MASK_WED) != (propertyAttributes & BaseProperty.ATTRS_MASK_WED)) {
			return false;
		}
		return property.propertySet(this, name, value, attributes);
	}

	/** BaseObject
	 *
	 * Short cut for 'define(o,name,value.true,true,true)'
	 *
	 *
	 * @param name
	 * @param value
	 * @return */
	@ReflectionHidden
	default boolean baseDefine(final String name, final BaseString<?> value) {

		return this.baseDefine(name, value, BaseProperty.ATTRS_MASK_WED);
	}

	/** BaseObject
	 *
	 * Short cut for 'define(o,name,value.true,true,true)'
	 *
	 *
	 * @param name
	 * @param value
	 * @return */
	@ReflectionHidden
	default boolean baseDefine(final String name, final boolean value) {

		return this.baseDefine(
				name,
				value
					? BaseObject.TRUE
					: BaseObject.FALSE,
				BaseProperty.ATTRS_MASK_WED);
	}

	/** BaseObject
	 *
	 * Short cut for 'define(o,name,value.true,true,true)'
	 *
	 *
	 * @param name
	 * @param value
	 * @return */
	@ReflectionHidden
	default boolean baseDefine(final String name, final CharSequence value) {

		assert value != null : "NULL java object!";
		return value instanceof BaseObject
			? this.baseDefine(name, (BaseObject) value, BaseProperty.ATTRS_MASK_WED)
			: this.baseDefine(name, value.toString(), BaseProperty.ATTRS_MASK_WED);
	}

	/** BaseObject
	 *
	 * Short cut for 'define(o,name,value.true,true,true)'
	 *
	 *
	 * @param name
	 * @param value
	 * @return */
	@ReflectionHidden
	default boolean baseDefine(final String name, final double value) {

		return this.baseDefine(name, value, BaseProperty.ATTRS_MASK_WED);
	}

	/** @param name
	 * @param value
	 * @param attributes
	 * @return */
	@ReflectionHidden
	default boolean baseDefine(final String name, final double value, final short attributes) {

		return this.baseDefine(name, Base.forDouble(value), attributes);
	}

	/** BaseObject
	 *
	 * Short cut for 'define(o,name,value.true,true,true)'
	 *
	 *
	 * @param name
	 * @param value
	 * @return */
	@ReflectionHidden
	default boolean baseDefine(final String name, final long value) {

		return this.baseDefine(name, value, BaseProperty.ATTRS_MASK_WED);
	}

	/** @param name
	 * @param value
	 * @param attributes
	 * @return */
	@ReflectionHidden
	default boolean baseDefine(final String name, final long value, final short attributes) {

		return this.baseDefine(name, Base.forLong(value), attributes);
	}

	/** BaseObject
	 *
	 * Short cut for 'define(o,name,value.true,true,true)'
	 *
	 *
	 * @param name
	 * @param value
	 * @return */
	@ReflectionHidden
	default boolean baseDefine(final String name, final String value) {

		return this.baseDefine(name, value, BaseProperty.ATTRS_MASK_WED);
	}

	/** @param name
	 * @param value
	 * @param attributes
	 * @return */
	@ReflectionHidden
	default boolean baseDefine(final String name, final String value, final short attributes) {

		return this.baseDefine(name, Base.forString(value), attributes);
	}

	/** @param source
	 */
	@ReflectionHidden
	default void baseDefineImportAllEnumerable(final BaseObject source) {

		if (source == null || source.baseIsPrimitive()) {
			return;
		}
		for (final Iterator<String> iterator = Base.keys(source); iterator.hasNext();) {
			final String key = iterator.next();
			this.baseDefine(key, source.baseGet(key, BaseObject.UNDEFINED), BaseProperty.ATTRS_MASK_WED);
		}
	}

	/** @param source
	 */
	@ReflectionHidden
	default void baseDefineImportOwnAll(final BaseObject source) {

		if (source == null || source.baseIsPrimitive()) {
			return;
		}
		for (final Iterator<? extends CharSequence> iterator = source.baseKeysOwnAll(); iterator.hasNext();) {
			final CharSequence key = iterator.next();
			this.baseDefine(key, source.baseGet(key, BaseObject.UNDEFINED), BaseProperty.ATTRS_MASK_WED);
		}
	}

	/** @param source
	 */
	@ReflectionHidden
	default void baseDefineImportOwnEnumerable(final BaseObject source) {

		if (source == null || source.baseIsPrimitive()) {
			return;
		}
		for (final Iterator<String> iterator = source.baseKeysOwn(); iterator.hasNext();) {
			final String key = iterator.next();
			this.baseDefine(key, source.baseGet(key, BaseObject.UNDEFINED), BaseProperty.ATTRS_MASK_WED);
		}
	}

	/** Converts to String by default, implements index in classes like BaseArrayWritable.
	 *
	 *
	 * @param propertyName
	 * @return */
	@ReflectionHidden
	default boolean baseDelete(final BaseObject propertyName) {

		/** remove? leave it only in BaseArray? Why check - override? */
		if (propertyName.baseIsPrimitiveInteger()) {
			final BaseArray array = this.baseArray();
			if (array != null) {
				final BaseArrayWritable<?> writable = array.baseArrayWritable();
				if (writable != null) {
					writable.set(propertyName.baseToJavaInteger(), null);
					return true;
				}
				return false;
			}
		}

		return this.baseDelete(propertyName.baseToJavaString());
	}

	/** [[Delete]] (P) When the [[Delete]] method of O is called with property name P, the following
	 * steps are taken:<br>
	 * 1. If O doesn’t have a property with name P, return true.<br>
	 * 2. If the property has the DontDelete attribute, return false.<br>
	 * 3. Remove the property with name P from O.<br>
	 * 4. Return true.
	 *
	 * @param name
	 * @return boolean */
	@ReflectionHidden
	boolean baseDelete(String name);

	/** Handy
	 *
	 * @param name
	 * @param stop
	 * @return */
	@ReflectionHidden
	default BaseProperty baseFindProperty(final BasePrimitive<?> name) {

		return name instanceof BasePrimitiveString
			? this.baseFindProperty((BasePrimitiveString) name)
			: this.baseFindProperty(name.baseToJavaString());
	}

	/** 8.6.2.1.1 [[GetProperty]] (P)
	 * <p>
	 * When the [[GetProperty]] method of O is called with property name P, the following steps are
	 * taken:<br>
	 * 1. Call the [[GetOwnProperty]] method of O with property name P. <br>
	 * 2. If Result(1) is not undefined, return Result(1). <br>
	 * 3. If the [[Prototype]] of O is null, return undefined. <br>
	 * 4. Call the [[GetProperty]] method of [[Prototype]] with property name P. <br>
	 * 5. Return Result(4). <br>
	 *
	 *
	 * @param name
	 * @param stop
	 * @return */
	@ReflectionHidden
	default BaseProperty baseFindProperty(final BasePrimitiveString name) {

		for (final BaseProperty property = this.baseGetOwnProperty(name); property != null;) {
			return property;
		}

		for (final BaseObject prototype = this.basePrototype(); prototype != null;) {
			return prototype.baseFindProperty(name);
		}
		return null;

		/** The initially correct code.
		 *
		 * <code>

		for (BaseObject object = this.basePrototype(); object != null; object = object.basePrototype()) {
			for (final BaseProperty property = object.baseGetOwnProperty(name); property != null;) {
				return property;
			}
		}
		return null;
		 * </code> */
	}

	/** 8.6.2.1.1 [[GetProperty]] (P)
	 * <p>
	 * When the [[GetProperty]] method of O is called with property name P, the following steps are
	 * taken:<br>
	 * 1. Call the [[GetOwnProperty]] method of O with property name P. <br>
	 * 2. If Result(1) is not undefined, return Result(1). <br>
	 * 3. If the [[Prototype]] of O is null, return undefined. <br>
	 * 4. Call the [[GetProperty]] method of [[Prototype]] with property name P. <br>
	 * 5. Return Result(4). <br>
	 *
	 *
	 * @param name
	 * @param stop
	 * @return */
	@ReflectionHidden
	default BaseProperty baseFindProperty(final BasePrimitiveString name, final BaseObject stop) {

		for (final BaseProperty property = this.baseGetOwnProperty(name); property != null;) {
			return property;
		}

		for (final BaseObject prototype = this.basePrototype(); prototype != null && prototype != stop;) {
			return prototype.baseFindProperty(name, stop);
		}
		return null;

		/** The initially correct code.
		 *
		 * <code>

		for (BaseObject object = this.basePrototype(); object != null; object = object.basePrototype()) {
			for (final BaseProperty property = object.baseGetOwnProperty(name); property != null;) {
				return property;
			}
		}
		return null;
		 * </code> */
	}

	/** Handy
	 *
	 * @param name
	 * @return */
	@ReflectionHidden
	default BaseProperty baseFindProperty(final CharSequence name) {

		return name instanceof BasePrimitiveString
			? this.baseFindProperty((BasePrimitiveString) name)
			: this.baseFindProperty(name.toString());
	}

	/** 8.6.2.1.1 [[GetProperty]] (P)
	 * <p>
	 * When the [[GetProperty]] method of O is called with property name P, the following steps are
	 * taken:<br>
	 * 1. Call the [[GetOwnProperty]] method of O with property name P. <br>
	 * 2. If Result(1) is not undefined, return Result(1). <br>
	 * 3. If the [[Prototype]] of O is null, return undefined. <br>
	 * 4. Call the [[GetProperty]] method of [[Prototype]] with property name P. <br>
	 * 5. Return Result(4). <br>
	 *
	 *
	 * @param name
	 * @return */
	@ReflectionHidden
	default BaseProperty baseFindProperty(final String name) {

		for (final BaseProperty property = this.baseGetOwnProperty(name); property != null;) {
			return property;
		}

		for (final BaseObject prototype = this.basePrototype(); prototype != null;) {
			return prototype.baseFindProperty(name);
		}
		return null;

		/** The initially correct code.
		 *
		 * <code>

		for (BaseObject object = this.basePrototype(); object != null; object = object.basePrototype()) {
			for (final BaseProperty property = object.baseGetOwnProperty(name); property != null;) {
				return property;
			}
		}
		return null;
		 * </code> */
	}

	/** 8.6.2.1.1 [[GetProperty]] (P)
	 * <p>
	 * When the [[GetProperty]] method of O is called with property name P, the following steps are
	 * taken:<br>
	 * 1. Call the [[GetOwnProperty]] method of O with property name P. <br>
	 * 2. If Result(1) is not undefined, return Result(1). <br>
	 * 3. If the [[Prototype]] of O is null, return undefined. <br>
	 * 4. Call the [[GetProperty]] method of [[Prototype]] with property name P. <br>
	 * 5. Return Result(4). <br>
	 *
	 *
	 * @param name
	 * @param stop
	 * @return */
	@ReflectionHidden
	default BaseProperty baseFindProperty(final String name, final BaseObject stop) {

		for (final BaseProperty property = this.baseGetOwnProperty(name); property != null;) {
			return property;
		}

		for (final BaseObject prototype = this.basePrototype(); prototype != null && prototype != stop;) {
			return prototype.baseFindProperty(name, stop);
		}
		return null;

		/** The initially correct code.
		 *
		 * <code>

		for (BaseObject object = this.basePrototype(); object != null; object = object.basePrototype()) {
			for (final BaseProperty property = object.baseGetOwnProperty(name); property != null;) {
				return property;
			}
		}
		return null;
		 * </code> */
	}

	/** @param name
	 * @param defaultValue
	 * @return */
	@ReflectionHidden
	default BaseObject baseGet(final BaseObject name, final BaseObject defaultValue) {

		if (name instanceof BasePrimitiveString) {
			return this.baseGet((BasePrimitiveString) name, defaultValue);
		}
		if (name instanceof CharSequence) {
			return this.baseGet(name.toString(), defaultValue);
		}
		if (name instanceof BasePrimitive<?>) {
			if (name instanceof PrimitiveNumberIntegerAbstract || name.baseIsPrimitiveInteger()) {
				final BaseArray array = this.baseArray();
				if (array != null) {
					return array.baseGet(name.baseToJavaInteger(), defaultValue);
				}
			}
			final BasePrimitive<?> primitive = (BasePrimitive<?>) name;
			final BasePrimitiveString identity = primitive.baseToStringIfReady();
			return identity != null
				? this.baseGet(identity, defaultValue)
				: this.baseGet(primitive.stringValue(), defaultValue);
		}
		return this.baseGet(name.baseToPrimitive(null), defaultValue);
	}

	/** @param name
	 * @param defaultValue
	 * @return */
	@ReflectionHidden
	default BaseObject baseGet(final BasePrimitive<?> name, final BaseObject defaultValue) {

		if (name instanceof BasePrimitiveString) {
			return this.baseGet((BasePrimitiveString) name, defaultValue);
		}
		if (name instanceof CharSequence) {
			return this.baseGet(name.toString(), defaultValue);
		}

		if (name instanceof PrimitiveNumberIntegerAbstract || name.baseIsPrimitiveInteger()) {
			final BaseArray array = this.baseArray();
			if (array != null) {
				return array.baseGet(name.baseToJavaInteger(), defaultValue);
			}
		}
		final BasePrimitiveString identity = name.baseToStringIfReady();
		return identity != null
			? this.baseGet(identity, defaultValue)
			: this.baseGet(name.stringValue(), defaultValue);
	}

	/** [[Get]] (P) When the [[Get]] method of O is called with property name P, the following steps
	 * are taken: <br>
	 * 1. If O doesn’t have a property with name P, go to step 4. <br>
	 * 2. Get the value of the property. <br>
	 * 3. Return Result(2). <br>
	 * 4. If the [[Prototype]] of O is null, return undefined. <br>
	 * 5. Call the [[Get]] method of [[Prototype]] with property name P. <br>
	 * 6. Return Result(5).
	 *
	 * @param name
	 * @param defaultValue
	 * @return property */
	@ReflectionHidden
	default BaseObject baseGet(final BasePrimitiveString name, final BaseObject defaultValue) {

		for (final BaseProperty property = this.baseFindProperty(name); property != null;) {
			return property.propertyGet(this, name);
		}
		return defaultValue;
	}

	/** @param name
	 * @param defaultValue
	 * @return */
	@ReflectionHidden
	default BaseObject baseGet(final CharSequence name, final BaseObject defaultValue) {

		if (name instanceof BasePrimitiveString) {
			return this.baseGet((BasePrimitiveString) name, defaultValue);
		}

		return this.baseGet(
				name instanceof String
					? (String) name
					: name.toString(),
				defaultValue);
	}

	/** [[Get]] (P) When the [[Get]] method of O is called with property name P, the following steps
	 * are taken: <br>
	 * 1. If O doesn’t have a property with name P, go to step 4. <br>
	 * 2. Get the value of the property. <br>
	 * 3. Return Result(2). <br>
	 * 4. If the [[Prototype]] of O is null, return undefined / defaultValue /. <br>
	 * 5. Call the [[Get]] method of [[Prototype]] with property name P. <br>
	 * 6. Return Result(5).
	 *
	 * @param name
	 * @param defaultValue
	 * @return property */
	@ReflectionHidden
	default BaseObject baseGet(final String name, final BaseObject defaultValue) {

		for (final BaseProperty property = this.baseFindProperty(name); property != null;) {
			return property.propertyGet(this, name);
		}
		return defaultValue;
	}

	/** 8.6.2.1.2 [[GetOwnProperty]] (P)
	 * <p>
	 * When the [[GetOwnProperty]] method of O is called with property name P, the following steps
	 * are taken: <br>
	 * 1. If Type(O) is String, and Type(P) is Number, go to step 4.<br>
	 * 2. If O is an instance of String, and Type(P) is a Number, go to step 4. <br>
	 * 3. Go to step 6. <br>
	 * 4. Call the [[Call]] method of the specified String.prototype.charAt method with O as the
	 * this value and argument P. <br>
	 * 5. Return a DDesc describing Result(4).<br>
	 * 6. If O doesn‘t have an own property with name P, return undefined.<br>
	 * 7. If O has an own data property with name P, return a DDesc describing its current state<br>
	 * 8. If O has an own procedural property with name P, return a PDesc describing its current
	 * state.<br>
	 *
	 * @param name
	 *            TODO change to BasePrimitive<?> or CharSequence and int
	 * @return */
	@ReflectionHidden
	BaseProperty baseGetOwnProperty(BasePrimitiveString name);

	/** @param name
	 * @return */
	@ReflectionHidden
	default BaseProperty baseGetOwnProperty(final CharSequence name) {

		return name instanceof BasePrimitiveString
			? this.baseGetOwnProperty((BasePrimitiveString) name)
			: this.baseGetOwnProperty(name.toString());
	}

	/** 8.6.2.1.2 [[GetOwnProperty]] (P)
	 * <p>
	 * When the [[GetOwnProperty]] method of O is called with property name P, the following steps
	 * are taken: <br>
	 * 1. If Type(O) is String, and Type(P) is Number, go to step 4.<br>
	 * 2. If O is an instance of String, and Type(P) is a Number, go to step 4. <br>
	 * 3. Go to step 6. <br>
	 * 4. Call the [[Call]] method of the specified String.prototype.charAt method with O as the
	 * this value and argument P. <br>
	 * 5. Return a DDesc describing Result(4).<br>
	 * 6. If O doesn‘t have an own property with name P, return undefined.<br>
	 * 7. If O has an own data property with name P, return a DDesc describing its current state<br>
	 * 8. If O has an own procedural property with name P, return a PDesc describing its current
	 * state.<br>
	 *
	 * @param name
	 * @return */
	@ReflectionHidden
	BaseProperty baseGetOwnProperty(String name);

	/** Returns false when no enumerable own properties available of any kind.
	 *
	 * @return */
	@ReflectionHidden
	boolean baseHasKeysOwn();

	/** @return */
	@ReflectionHidden
	boolean baseIsExtensible();

	/** @return FALSE by default */
	@ReflectionHidden
	default boolean baseIsPrimitive() {

		return false;
	}

	/** @return FALSE by default */
	@ReflectionHidden
	default boolean baseIsPrimitiveBoolean() {

		return false;
	}

	/** @return FALSE by default */
	@ReflectionHidden
	default boolean baseIsPrimitiveInteger() {

		return false;
	}

	/** @return FALSE by default */
	@ReflectionHidden
	default boolean baseIsPrimitiveNumber() {

		return false;
	}

	/** @return FALSE by default */
	@ReflectionHidden
	default boolean baseIsPrimitiveString() {

		return false;
	}

	/** Never returns null. BaseObject.ITERATOR_EMPTY at least
	 *
	 * Should list only those own properties whose 'enumerable' attribute is set to TRUE.
	 *
	 * @return */
	@ReflectionHidden
	Iterator<String> baseKeysOwn();
	/** Never returns null. BaseObject.ITERATOR_EMPTY at least
	 *
	 * Should list all of the own properties with no regard to 'enumerable' attribute;
	 *
	 * @return keys own by default */
	@ReflectionHidden
	default Iterator<? extends CharSequence> baseKeysOwnAll() {

		return this.baseKeysOwn();
	}

	/** Never returns null. BaseObject.ITERATOR_EMPTY_PRIMITIVE at least
	 *
	 * Should list only those own properties whose 'enumerable' attribute is set to TRUE.
	 *
	 * @return */
	@ReflectionHidden
	Iterator<? extends BasePrimitive<?>> baseKeysOwnPrimitive();

	/** The value of the [[Prototype]] property must be either an object or null, and every
	 * [[Prototype]] chain must have finite length (that is, starting from any object, recursively
	 * accessing the [[Prototype]] property must eventually lead to a null value). Whether or not a
	 * native object can have a host object as its [[Prototype]] depends on the implementation.
	 *
	 * @return prototype object or null */
	@ReflectionHidden
	default BaseObject basePrototype() {

		return BaseObject.PROTOTYPE;
	}

	/** @return boolean, TRUE by default */
	@ReflectionHidden
	default BasePrimitiveBoolean baseToBoolean() {

		return BaseObject.TRUE;
	}

	/** 9.5 ToInt32: (Signed 32 Bit Integer)
	 * <p>
	 * The operator ToInt32 converts its argument to one of 232 integer values in the range −231
	 * through 231−1, inclusive.
	 * <p>
	 * This operator functions as follows:<br>
	 * 1. Call ToNumber on the input argument.<br>
	 * 2. If Result(1) is NaN, +0, −0, +∞, or −∞, return +0.<br>
	 * 3. Compute sign(Result(1)) * floor(abs(Result(1))).<br>
	 * 4. Compute Result(3) modulo 232; that is, a finite integer value k of Number type with
	 * positive sign and less than 232 in magnitude such the mathematical difference of Result(3)
	 * and k is mathematically an integer multiple of 232. <br>
	 * 5. If Result(4) is greater than or equal to 231, return Result(4)− 232, otherwise return
	 * Result(4).
	 * <p>
	 * NOTE Given the above definition of ToInt32: <br>
	 * The ToInt32 operation is idempotent: if applied to a result that it produced, the second
	 * application leaves that value unchanged. <br>
	 * ToInt32(ToUint32(x)) is equal to ToInt32(x) for all values of x. (It is to preserve this
	 * latter property that +∞ and −∞ are mapped to +0.)
	 * <p>
	 * ToInt32 maps −0 to +0.
	 * <p>
	 *
	 * @return number
	 *
	 *         default: this.baseToPrimitive( ToPrimitiveHint.NUMBER ).baseToInt32() */
	@ReflectionHidden
	default BasePrimitiveNumber baseToInt32() {

		return this.baseToPrimitive(ToPrimitiveHint.NUMBER).baseToInt32();
	}

	/** 9.4 ToInteger
	 * <p>
	 * The operator ToInteger converts its argument to an integral numeric value. This operator
	 * functions as follows:<br>
	 * 1. Call ToNumber on the input argument. <br>
	 * 2. If Result(1) is NaN, return +0. <br>
	 * 3. If Result(1) is +0, −0, +∞, or −∞, return Result(1).<br>
	 * 4. Compute sign(Result(1)) * floor(abs(Result(1))).<br>
	 * 5. Return Result(4).
	 * <p>
	 *
	 * @return number
	 *
	 *         default: this.baseToPrimitive( ToPrimitiveHint.NUMBER ).baseToInteger() */
	@ReflectionHidden
	default BasePrimitiveNumber baseToInteger() {

		return this.baseToPrimitive(ToPrimitiveHint.NUMBER).baseToInteger();
	}

	/** @return */
	@ReflectionHidden
	default boolean baseToJavaBoolean() {

		return this.baseToBoolean().booleanValue();
	}

	/** Returns same as @baseToJavaString by default, and (the whole reason for this method) returns
	 * 'this' for BaseString instances.
	 *
	 * @return */
	@ReflectionHidden
	default CharSequence baseToJavaCharSequence() {

		return this.baseToJavaString();
	}

	/** @return */
	@ReflectionHidden
	default int baseToJavaInteger() {

		return this.baseToPrimitive(ToPrimitiveHint.NUMBER).intValue();
	}

	/** @return */
	@ReflectionHidden
	default long baseToJavaLong() {

		return this.baseToPrimitive(ToPrimitiveHint.NUMBER).longValue();
	}

	/** @return */
	@ReflectionHidden
	default String baseToJavaString() {

		return this.baseToPrimitive(ToPrimitiveHint.STRING).stringValue();
	}

	/** For Object
	 * <p>
	 * Apply the following steps:<br>
	 * 1. Call ToPrimitive(input argument, hint Number).<br>
	 * 2. Call ToNumber(Result(1)). <br>
	 * 3. Return Result(2). <br>
	 *
	 * @return number
	 *
	 *         default: this.baseToPrimitive( ToPrimitiveHint.NUMBER ).baseToNumber() */
	@ReflectionHidden
	default BasePrimitiveNumber baseToNumber() {

		return this.baseToPrimitive(ToPrimitiveHint.NUMBER).baseToNumber();
	}

	/** [[DefaultValue]] (hint) When the [[DefaultValue]] method of O is called with hint String,
	 * the following steps are taken:<br>
	 * 1. Call the [[Get]] method of object O with argument "toString".<br>
	 * 2. If Result(1) is not an object, go to step 5.<br>
	 * 3. Call the [[Call]] method of Result(1), with O as the this value and an empty argument
	 * list.<br>
	 * 4. If Result(3) is a primitive value, return Result(3).<br>
	 * 5. Call the [[Get]] method of object O with argument "valueOf".<br>
	 * 6. If Result(5) is not an object, go to step 9.<br>
	 * 7. Call the [[Call]] method of Result(5), with O as the this value and an empty argument
	 * list.<br>
	 * 8. If Result(7) is a primitive value, return Result(7).<br>
	 * 9. Throw a TypeError exception.
	 * <p>
	 * When the [[DefaultValue]] method of O is called with hint Number, the following steps are
	 * taken:<br>
	 * 1. Call the [[Get]] method of object O with argument "valueOf".<br>
	 * 2. If Result(1) is not an object, go to step 5.<br>
	 * 3. Call the [[Call]] method of Result(1), with O as the this value and an empty argument
	 * list.<br>
	 * 4. If Result(3) is a primitive value, return Result(3).<br>
	 * 5. Call the [[Get]] method of object O with argument "toString".<br>
	 * 6. If Result(5) is not an object, go to step 9.<br>
	 * 7. Call the [[Call]] method of Result(5), with O as the this value and an empty argument
	 * list.<br>
	 * 8. If Result(7) is a primitive value, return Result(7).<br>
	 * 9. Throw a TypeError exception.<b> When the [[DefaultValue]] method of O is called with no
	 * hint, then it behaves as if the hint were Number, unless O is a Date object (see 15.9), in
	 * which case it behaves as if the hint were String. The above specification of [[DefaultValue]]
	 * for native objects can return only primitive values. If a host object implements its own
	 * [[DefaultValue]] method, it must ensure that its [[DefaultValue]] method can return only
	 * primitive values.
	 * <p>
	 * ToPrimitive The operator ToPrimitive takes a Value argument and an optional argument
	 * PreferredType. The operator ToPrimitive converts its value argument to a non-Object type. If
	 * an object is capable of converting to more than one primitive type, it may use the optional
	 * hint PreferredType to favour that type
	 *
	 * @param hint
	 *            primitives must be able to accept null and always return this, non-primitives can
	 *            throw exceptions with null hint argument.
	 * @return EcmaPrimitive
	 *
	 *
	 *
	 *         Default implementation will return this.baseToString(); */
	@ReflectionHidden
	default BasePrimitive<?> baseToPrimitive(final ToPrimitiveHint hint) {

		if (hint == null || hint == ToPrimitiveHint.NUMBER) {
			{
				final BaseProperty property = this.baseFindProperty(BaseString.STR_VALUE_OF, BaseObject.PROTOTYPE);
				if (property != null) {
					final BaseFunction call = property.propertyGet(this, BaseString.STR_VALUE_OF).baseCall();
					if (call != null && call.execArgumentsMinimal() == 0) {
						final BaseObject result = call.callNJ0(this);
						if (result != this) {
							return result.baseToPrimitive(ToPrimitiveHint.NUMBER);
						}
					}
				}
			}
			try {
				if (this.getClass().getMethod("baseToNumber").getDeclaringClass() != BaseObject.class) {
					return this.baseToNumber();
				}
			} catch (NoSuchMethodException | SecurityException e) {
				Report.exception("BASE", "baseToPrimitive(NUMBER)", e);
			}
			{
				final BaseProperty property = this.baseFindProperty(BaseString.STR_TO_STRING, BaseObject.PROTOTYPE);
				if (property != null) {
					final BaseFunction call = property.propertyGet(this, BaseString.STR_TO_STRING).baseCall();
					if (call != null && call.execArgumentsMinimal() == 0) {
						final BaseObject result = call.callNJ0(this);
						if (result != this) {
							return result.baseToPrimitive(ToPrimitiveHint.NUMBER);
						}
					}
				}
			}
		} else {
			{
				final BaseProperty property = this.baseFindProperty(BaseString.STR_TO_STRING, BaseObject.PROTOTYPE);
				if (property != null) {
					final BaseFunction call = property.propertyGet(this, BaseString.STR_TO_STRING).baseCall();
					if (call != null && call.execArgumentsMinimal() == 0) {
						final BaseObject result = call.callNJ0(this);
						if (result != this) {
							return result.baseToPrimitive(ToPrimitiveHint.STRING);
						}
					}
				}
			}
			{
				final BaseProperty property = this.baseFindProperty(BaseString.STR_VALUE_OF, BaseObject.PROTOTYPE);
				if (property != null) {
					final BaseFunction call = property.propertyGet(this, BaseString.STR_VALUE_OF).baseCall();
					if (call != null && call.execArgumentsMinimal() == 0) {
						final BaseObject result = call.callNJ0(this);
						if (result != this) {
							return result.baseToPrimitive(ToPrimitiveHint.STRING);
						}
					}
				}
			}
		}

		try {
			if (this.getClass().getMethod("baseToString").getDeclaringClass() != BaseObject.class) {
				return this.baseToString();
			}
			if (this.getClass().getMethod("toString").getDeclaringClass() != Object.class) {
				return Base.forString(this.toString());
			}
		} catch (NoSuchMethodException | SecurityException e) {
			Report.exception("BASE", "baseToPrimitive(STRING)", e);
		}

		/** FIXME: 5. Throw a TypeError exception. */
		return Base.forString("[object " + this.baseClass() + "]");
	}

	/** @return string */
	@ReflectionHidden
	default BasePrimitiveString baseToString() {

		return this.baseToPrimitive(ToPrimitiveHint.STRING).baseToString();
	}

	/** Internal state information associated with this object.
	 *
	 * @return internal, this by default */
	@ReflectionHidden
	default Object baseValue() {

		return this;
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
	 * Type x is this and is an object of any type.
	 *
	 *
	 * Can be something like java.lang.Object.equals(), but in Java equals() specification should
	 * also check for objects being different instances with same context. In JavaScript { a : 5 }
	 * == { a : 5 } will evaluate to false.
	 *
	 * Can be something like baseEquals, but in Java equals() specification should also check for
	 * objects being different instances with same context. In JavaScript { a : 5 } == { a : 5 }
	 * will evaluate to false.
	 *
	 * @param o
	 * @return */
	@Override
	boolean equals(Object o);

	/** should implement!
	 *
	 * @return */
	@Override
	int hashCode();
	/** @return */
	// BaseObject toNative();

	/** @return */
	@Override
	String toString();

	/** BaseObject
	 *
	 * Short cut for 'define(o,name,value.true,true,true)'
	 *
	 * FIXME: extend to support array index writes
	 *
	 * @param ctx
	 * @param name
	 * @param value
	 *
	 * @return NULL */
	@Override
	@ReflectionHidden
	default ExecStateCode vmPropertyDefine(final ExecProcess ctx, final BaseObject name, final BaseObject value, final ResultHandler store) {

		assert value != null : "NULL java object!";

		if (name instanceof BasePrimitiveString) {
			this.baseDefine((BasePrimitiveString) name, value, BaseProperty.ATTRS_MASK_WED);
			return store.execReturn(ctx, value);
		}

		this.baseDefine(name.baseToJavaString(), value, BaseProperty.ATTRS_MASK_WED);
		return store.execReturn(ctx, value);
	}

	/** [[Get]] (P) When the [[Get]] method of O is called with property name P, the following steps
	 * are taken: <br>
	 * 1. If O doesn’t have a property with name P, go to step 4. <br>
	 * 2. Get the value of the property. <br>
	 * 3. Return Result(2). <br>
	 * 4. If the [[Prototype]] of O is null, return undefined. <br>
	 * 5. Call the [[Get]] method of [[Prototype]] with property name P. <br>
	 * 6. Return Result(5).
	 *
	 * @param ctx
	 * @param name
	 * @param defaultValue
	 * @return NULL */
	@Override
	@ReflectionHidden
	default ExecStateCode vmPropertyRead(final ExecProcess ctx, final BasePrimitiveString name, final BaseObject defaultValue, final ResultHandler store) {

		for (final BaseProperty property = this.baseFindProperty(name); property != null;) {
			return property.propertyGetCtxResult(ctx, this, name, store);
		}
		return store.execReturn(ctx, defaultValue);
	}

	/** [[Get]] (P) When the [[Get]] method of O is called with property name P, the following steps
	 * are taken: <br>
	 * 1. If O doesn’t have a property with name P, go to step 4. <br>
	 * 2. Get the value of the property. <br>
	 * 3. Return Result(2). <br>
	 * 4. If the [[Prototype]] of O is null, return undefined. <br>
	 * 5. Call the [[Get]] method of [[Prototype]] with property name P. <br>
	 * 6. Return Result(5).
	 *
	 * @param ctx
	 * @param name
	 * @param defaultValue
	 * @return NULL */
	@Override
	@ReflectionHidden
	default ExecStateCode vmPropertyRead(final ExecProcess ctx, final String name, final BaseObject defaultValue, final ResultHandler store) {

		for (final BaseProperty property = this.baseFindProperty(name); property != null;) {
			return store.execReturn(ctx, property.propertyGet(this, name));
		}
		return store.execReturn(ctx, defaultValue);
	}
}
