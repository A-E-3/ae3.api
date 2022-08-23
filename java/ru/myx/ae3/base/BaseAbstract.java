package ru.myx.ae3.base;

/** Not Primitive type. Implements basic equals, hashCode, toString.
 *
 *
 * TODO: use and advertize default generic equals? Or have BaseArray.genricEquals and
 * BaseObject.genericEquals....
 *
 *
 * @author myx */
public abstract class BaseAbstract implements BaseObject {

	@Override
	public String baseClass() {

		return this.getClass().getSimpleName();
	}

	/** standart ECMA reference alike impl */
	@Override
	public boolean equals(final Object o) {

		/** Fits here, booleans, undefined and null are fixed:<br>
		 * 2. If Type(x) is Undefined, return true.<br>
		 * 3. If Type(x) is Null, return true. 12. If Type(x) is Boolean, return true if x and y are
		 * both true or both false. Otherwise, return false. */
		if (o == this) {
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
		if (this.baseIsPrimitiveNumber()) {
			assert false : "PrimitiveNumber object should have it's own equals method implementation!";
			/** 7. If x is the same number value as y, return true.<br>
			 * 8. If x is +0 and y is −0, return true.<br>
			 * 9. If x is −0 and y is +0, return true.<br>
			 * 10. Return false. <br>
			 */
			if (object.baseIsPrimitiveNumber()) {
				return this.baseValue().equals(object.baseValue());
			}
			/** 16. If Type(x) is Number and Type(y) is String,<br>
			 * return the result of the comparison x == ToNumber(y). */
			if (object.baseIsPrimitiveString()) {
				return this.baseValue().equals(object.baseToNumber().baseValue());
			}
			/** 20. If Type(x) is either String or Number and Type(y) is Object, <br>
			 * return the result of the comparison x == ToPrimitive(y). */
			if (!object.baseIsPrimitive()) {
				return this.baseToPrimitive(ToPrimitiveHint.NUMBER).equals(object.baseToPrimitive(ToPrimitiveHint.NUMBER));
			}
		}
		if (this.baseIsPrimitiveString()) {
			assert false : "PrimitiveString object should have it's own equals method implementation!";
			/** 11. If Type(x) is String, then return true if x and y are exactly the same sequence
			 * of characters (same length and same characters in corresponding positions).
			 * Otherwise, return false. */
			if (object.baseIsPrimitiveString()) {
				return this.baseValue().equals(object.baseValue());
			}
			/** 17. If Type(x) is String and Type(y) is Number,<br>
			 * return the result of the comparison ToNumber(x) == y. */
			if (object.baseIsPrimitiveNumber()) {
				return this.baseToNumber().baseValue().equals(object.baseValue());
			}
			/** 20. If Type(x) is either String or Number and Type(y) is Object, <br>
			 * return the result of the comparison x == ToPrimitive(y). */
			if (!object.baseIsPrimitive()) {
				return this.baseToPrimitive(ToPrimitiveHint.STRING).equals(object.baseToPrimitive(ToPrimitiveHint.STRING));
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
		assert !this.baseIsPrimitiveBoolean() : "PrimitiveBoolean object must have it's own equals method implementation!";
		/** 19. If Type(y) is Boolean,<br>
		 * return the result of the comparison x == ToNumber(y). */
		if (object.baseIsPrimitiveBoolean()) {
			return this.baseToJavaBoolean() == object.baseToNumber().baseToJavaBoolean();
		}
		/** 21. If Type(x) is Object and Type(y) is either String or Number,<br>
		 * return the result of the comparison ToPrimitive(x) == y. */
		if (!this.baseIsPrimitive()) {
			if (object.baseIsPrimitiveString()) {
				return this.baseToPrimitive(ToPrimitiveHint.STRING).equals(object);
			}
			if (object.baseIsPrimitiveNumber()) {
				return this.baseToPrimitive(ToPrimitiveHint.NUMBER).equals(object);
			}
		}
		/** 22. Return false. */
		return false;
	}

	@Override
	public int hashCode() {

		final Object value = this.baseValue();
		if (value == this) {
			return System.identityHashCode(this);
		}
		return value == null
			? 0
			: value.hashCode();
	}

	@Override
	public String toString() {

		final Object value = this.baseValue();
		if (value == this) {
			return "[object " + this.getClass().getSimpleName() + "]";
		}
		return String.valueOf(value);
	}

}
