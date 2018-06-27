package ru.myx.ae3.base;

import java.util.Date;
import java.util.Iterator;

import ru.myx.ae3.Engine;
import ru.myx.ae3.common.Value;
import ru.myx.ae3.help.Format;
import ru.myx.ae3.reflect.ReflectionExplicit;
import ru.myx.ae3.reflect.ReflectionHidden;
import ru.myx.ae3.reflect.ReflectionManual;

/**
 * @author myx
 *
 */
@ReflectionManual
public class BaseDate extends Date implements BaseObject, Value<Date> {
	
	
	/**
	 *
	 */
	private static final long serialVersionUID = -8671137391039373014L;

	/**
	 * Filled in ImplementBase
	 */
	@ReflectionHidden
	public static final BaseObject PROTOTYPE = BaseObject.createObject(BaseObject.PROTOTYPE);

	private BaseProperties<?> properties = null;

	/**
	 *
	 */
	public static final BaseDate UNKNOWN = Base.forDate(new Date(0L) {
		
		
		private static final long serialVersionUID = -2348545687999247899L;

		@Override
		public final long getTime() {
			
			
			return -1L;
		}

		@Override
		public final void setTime(final long time) {
			
			
			throw new UnsupportedOperationException("UNDEFINED date - read-only!");
		}
	});

	/**
	 *
	 */
	public static final BaseDate UNDEFINED = BaseDate.UNKNOWN;

	/**
	 *
	 */
	public static final BaseDate NOW = Base.forDate(Engine.CURRENT_TIME);

	/**
	 * @return
	 */
	@ReflectionExplicit
	public static final long now() {
		
		
		return System.currentTimeMillis();
	}

	/**
	 * Current date
	 */
	@ReflectionExplicit
	public BaseDate() {
		
		super();
	}

	/**
	 * @param date
	 *
	 */
	@ReflectionExplicit
	public BaseDate(final Date date) {
		
		super(date.getTime());
	}

	/**
	 * @param date
	 *
	 */
	@ReflectionExplicit
	public BaseDate(final long date) {
		
		super(date);
	}

	/**
	 * The value of the [[Class]] property is defined by this specification for
	 * every kind of built-in object. The value of the [[Class]] property of a
	 * host object may be any value, even a value used by a built-in object for
	 * its [[Class]] property. The value of a [[Class]] property is used
	 * internally to distinguish different kinds of built-in objects. Note that
	 * this specification does not provide any means for a program to access
	 * that value except through Object.prototype.toString (see 15.2.4.2).
	 *
	 * @return class
	 */
	@Override
	public String baseClass() {
		
		
		return "Date";
	}

	/**
	 * overrides default iterator implementation.
	 */

	@Override
	public void baseClear() {
		
		
		this.properties = null;
	}

	@Override
	public boolean baseDefine(final BasePrimitiveString name, final BaseObject value, final short attributes) {
		
		
		return this.baseDefine(name.toString(), value, attributes);
	}

	@Override
	public boolean baseDefine(final String name, final BaseObject value, final short attributes) {
		
		
		assert value != null : "Shouldn't be NULL, use BaseObject.UNDEFINED or BaseObject.NULL instead";
		/**
		 * 1. Call the [[GetOwnProperty]] method of O with property name P.<br>
		 * 2. Get the [[Extensible]] property of O. <br>
		 * 3. If Result(1) is undefined and Result(2) is true, then<br>
		 * a. Create an own property named P of object O whose state is
		 * described by Desc.<br>
		 * b. Return true. <br>
		 * 4. If Result(1) is undefined and Result(2) is false, then<br>
		 * a. If Strict is true, then throw TypeError. <br>
		 * b. Else return false. <br>
		 *
		 */
		final BaseProperty property = this.baseGetOwnProperty(name);
		if (property == null) {
			if (this.baseIsExtensible()) {
				this.properties = this.properties == null
					? BaseProperties.createFirstProperty(name, value, attributes)
					: this.properties.add(name, value, attributes);
				return true;
			}
			return false;
		}
		/**
		 * 5. If Result(1) is the same as Desc, then return true.
		 */
		// ignore
		/**
		 * 6. If the [[Dynamic]] attribute of Result(1) is true, then<br>
		 * a. Alter the P property of O to have the state described by Desc.
		 * <br>
		 * b. Return true. <br>
		 */
		final short propertyAttributes = property.propertyAttributes(name);
		if ((propertyAttributes & BaseProperty.ATTRS_DYNAMIC_OR_PROCEDURAL) != 0) {
			return property.propertySet(this, name, value, attributes);
		}
		/**
		 * 7. If Result(1) or Desc is a PDesc, then<br>
		 * a. If Strict is true, then throw something. <br>
		 * b. Else return false. <br>
		 */
		// skipped
		/**
		 * 8. Get the [[Writeable]] component of Result(1), which is a DDesc.
		 * <br>
		 * 9. If Result(8) is false, or if Result(1) and Desc differ in any
		 * component besides [[Value]], then<br>
		 * a. If Strict is true, then throw something. <br>
		 * b. Else return false. <br>
		 */
		if ((propertyAttributes & BaseProperty.ATTR_WRITABLE) == 0 || (attributes & BaseProperty.ATTRS_MASK_WED) != (propertyAttributes & BaseProperty.ATTRS_MASK_WED)) {
			return false;
		}
		/**
		 * 10. Alter the [[Value]] field of the P property of O to be the same
		 * as the [[Value]] field of Desc, thereby altering the property to have
		 * the state described by Desc. <br>
		 */
		return property.propertySet(this, name, value, attributes);
	}

	/**
	 * [[Delete]] (P) When the [[Delete]] method of O is called with property
	 * name P, the following steps are taken:<br>
	 * 1. If O doesn’t have a property with name P, return true.<br>
	 * 2. If the property has the DontDelete attribute, return false.<br>
	 * 3. Remove the property with name P from O.<br>
	 * 4. Return true.
	 *
	 * @param name
	 * @return boolean
	 */

	@Override
	public final boolean baseDelete(final String name) {
		
		
		assert name != null : "property name shouldn't be NULL";
		final BaseProperties<?> properties = this.properties;
		if (properties == null) {
			return true;
		}
		final BaseProperty property = properties.find(name);
		if (property == null) {
			return true;
		}
		final short propertyAttributes = property.propertyAttributes(name);
		if ((propertyAttributes & BaseProperty.ATTR_DYNAMIC) != 0) {
			this.properties = properties.delete(name);
			return true;
		}
		return false;
	}

	@Override
	public final BaseProperty baseFindProperty(final BasePrimitiveString name) {
		
		
		for (final BaseProperty property = this.baseGetOwnProperty(name); property != null;) {
			return property;
		}
		return BaseDate.PROTOTYPE.baseFindProperty(name);
	}

	@Override
	public final BaseProperty baseFindProperty(final BasePrimitiveString name, final BaseObject stop) {
		
		
		for (final BaseProperty property = this.baseGetOwnProperty(name); property != null;) {
			return property;
		}
		return BaseDate.PROTOTYPE.baseFindProperty(name, stop);
	}

	@Override
	public final BaseProperty baseFindProperty(final String name) {
		
		
		for (final BaseProperty property = this.baseGetOwnProperty(name); property != null;) {
			return property;
		}
		return BaseDate.PROTOTYPE.baseFindProperty(name);
	}

	@Override
	public final BaseProperty baseFindProperty(final String name, final BaseObject stop) {
		
		
		for (final BaseProperty property = this.baseGetOwnProperty(name); property != null;) {
			return property;
		}
		return BaseDate.PROTOTYPE.baseFindProperty(name, stop);
	}

	@Override
	public BaseProperty baseGetOwnProperty(final BasePrimitiveString name) {
		
		
		final BaseProperties<?> properties = this.properties;
		if (properties == null) {
			return null;
		}
		return properties.find(name);
	}

	@Override
	public BaseProperty baseGetOwnProperty(final String name) {
		
		
		final BaseProperties<?> properties = this.properties;
		if (properties == null) {
			return null;
		}
		return properties.find(name);
	}

	@Override
	public final boolean baseHasKeysOwn() {
		
		
		final BaseProperties<?> properties = this.properties;
		return properties != null && properties.hasEnumerableProperties();
	}

	@Override
	public boolean baseIsExtensible() {
		
		
		return true;
	}

	/**
	 * Never returns NULL. Should return BaseObject.ITERATOR_EMPTY at least.
	 *
	 * @return
	 */
	@Override
	public Iterator<String> baseKeysOwn() {
		
		
		return this.properties == null
			? BaseObject.ITERATOR_EMPTY
			: this.properties.iteratorEnumerableAsString();
	}

	/**
	 * Never returns NULL
	 *
	 * @return
	 */

	@Override
	public Iterator<? extends CharSequence> baseKeysOwnAll() {
		
		
		return this.properties == null
			? BaseObject.ITERATOR_EMPTY
			: this.properties.iteratorAllAsString();
	}

	@Override
	public Iterator<? extends BasePrimitive<?>> baseKeysOwnPrimitive() {
		
		
		return this.properties == null
			? BaseObject.ITERATOR_EMPTY_PRIMITIVE
			: this.properties.iteratorEnumerableAsPrimitive();
	}

	/**
	 * The value of the [[Prototype]] property must be either an object or null,
	 * and every [[Prototype]] chain must have finite length (that is, starting
	 * from any object, recursively accessing the [[Prototype]] property must
	 * eventually lead to a null value). Whether or not a native object can have
	 * a host object as its [[Prototype]] depends on the implementation.
	 *
	 * @return prototype object or null
	 */
	@Override
	public final BaseObject basePrototype() {
		
		
		return BaseDate.PROTOTYPE;
	}

	/**
	 * 9.4 ToInteger
	 * <p>
	 * The operator ToInteger converts its argument to an integral numeric
	 * value. This operator functions as follows:<br>
	 * 1. Call ToNumber on the input argument. <br>
	 * 2. If Result(1) is NaN, return +0. <br>
	 * 3. If Result(1) is +0, −0, +∞, or −∞, return Result(1).<br>
	 * 4. Compute sign(Result(1)) * floor(abs(Result(1))).<br>
	 * 5. Return Result(4).
	 * <p>
	 *
	 * @return number
	 */
	@Override
	public BasePrimitiveNumber baseToInteger() {
		
		
		return Base.forLong(this.getTime());
	}

	/**
	 * For Object
	 * <p>
	 * Apply the following steps:<br>
	 * 1. Call ToPrimitive(input argument, hint Number).<br>
	 * 2. Call ToNumber(Result(1)). <br>
	 * 3. Return Result(2). <br>
	 *
	 * @return number
	 */
	@Override
	public BasePrimitiveNumber baseToNumber() {
		
		
		return Base.forLong(this.getTime());
	}

	@Override
	public BasePrimitiveString baseToString() {
		
		
		return Base.forString(Format.Ecma.date(this));
	}

	@Override
	public Date baseValue() {
		
		
		return this;
	}

	@Override
	@ReflectionExplicit
	public boolean equals(final Object o) {
		
		
		/**
		 * Fits here, booleans, undefined and null are fixed:<br>
		 * 2. If Type(x) is Undefined, return true.<br>
		 * 3. If Type(x) is Null, return true. 12. If Type(x) is Boolean, return
		 * true if x and y are both true or both false. Otherwise, return false.
		 */
		if (o == this) {
			return true;
		}
		/**
		 * !!! NON-STANDARD: Date only, java enchancement!
		 */
		if (o instanceof Date) {
			return this.getTime() == ((Date) o).getTime();
		}
		/**
		 * 22. Return false.
		 */
		return false;
	}

	/**
	 * @return
	 */
	@ReflectionExplicit
	public String toDateString() {
		
		
		// yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
		// 1977-09-18T03:04:05.000Z
		final String format24 = Format.Ecma.date(this);
		if (format24.length() == 24) {
			return format24.substring(0, 10);
		}

		{
			return format24.substring(0, format24.indexOf('T'));
		}
	}

	/**
	 * @return
	 */
	@ReflectionExplicit
	public String toTimeString() {
		
		
		// yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
		// 1977-09-18T03:04:05.000Z
		final String format24 = Format.Ecma.date(this);
		if (format24.length() == 24) {
			return format24.substring(10);
		}

		{
			return format24.substring(format24.indexOf('T'));
		}
	}

	/**
	 * @return
	 */
	@ReflectionExplicit
	public String toISOString() {
		
		
		return Format.Ecma.date(this);
	}

	@Override
	@ReflectionHidden
	public String toString() {
		
		
		return Format.Compact.dateRelative(this);
	}

	/**
	 * @return
	 */
	@ReflectionExplicit
	public String toUTCString() {
		
		
		return Format.Web.date(this);
	}

	/**
	 * JavaScript date.UTC() method<br>
	 *
	 * Returns the number of milliseconds in a date string since midnight of
	 * January 1, 1970, according to universal time
	 *
	 * @return
	 */
	@ReflectionExplicit
	public final long UTC() {
		
		
		return this.getTime();
	}

	/**
	 *
	 * Generic equals operation for comparing two dates
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean equalsGeneric(final Object a, final Object b) {
		
		
		if (a == b) {
			return true;
		}

		if (!(a instanceof Date && b instanceof Date)) {
			return false;
		}
		return ((Date) a).getTime() == ((Date) b).getTime();
	}

}
