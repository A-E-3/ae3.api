package ru.myx.ae3.base;

import java.lang.reflect.Constructor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ru.myx.ae3.AbstractSAPI;
import ru.myx.ae3.Engine;
import ru.myx.ae3.exec.Exec;
import ru.myx.ae3.exec.ExecCallable;
import ru.myx.ae3.help.Format;

/** @author myx */
public final class Base extends AbstractSAPI {

	private static final AbstractBaseImpl BASE_IMPL;

	private static final CacheDoubleImpl CACHE_DBL;

	private static final CacheIntegerImpl CACHE_INT;

	private static final BasePrimitiveNumber[] CACHE_INT_NEGATIVE;

	/** yes - same number, cause starts with -1 (not 0) */
	private static final short CACHE_INT_NEGATIVE_MIN;

	private static final short CACHE_INT_NEGATIVE_MIN_SHORT;

	private static final short CACHE_INT_NEGATIVE_SIZE;

	private static final BasePrimitiveNumber[] CACHE_INT_POSITIVE;

	/** Not less than Short.MAX */
	private static final int CACHE_INT_POSITIVE_SIZE;

	private static final CacheLongImpl CACHE_LNG;

	private static final CacheStringImpl CACHE_STR;

	private static final BasePrimitiveString[] CHARS = new BasePrimitiveString[Character.MAX_VALUE + 1];

	static final BaseProperty LENGTH_PROPERTY_STRING = new BasePropertyStringLength();

	static final AbstractBaseImpl.BaseObjectFactory OBJECT_FACTORY;

	static final Class<? extends BaseList<?>> OF_CLS_BASE_LIST;

	static final Class<? extends BaseMapEditable> OF_CLS_BASE_MAP;

	static final Constructor<? extends BaseMapEditable> OF_CNS_BASE_MAP;

	/**
	 */
	public static final BaseObject[] ZERO_BASE_OBJECT_ARRAY = new BaseObject[0];

	static {

		assert AbstractSAPI.logDebug("Base: public api, static init...");

		/** this block should go last */
		{
			BASE_IMPL = AbstractSAPI.createObject("ru.myx.ae3.base.ImplementBase");
		}
		{
			assert AbstractSAPI.logDebug("Base: public api, static init: start factories...");

			OBJECT_FACTORY = Base.BASE_IMPL.createObjectFactory();
			OF_CLS_BASE_LIST = Base.OBJECT_FACTORY.getClassForBaseList();
			OF_CLS_BASE_MAP = Base.OBJECT_FACTORY.getClassForBaseMap();
			try {
				OF_CNS_BASE_MAP = Base.OF_CLS_BASE_MAP.getConstructor(BaseObject.class);
			} catch (NoSuchMethodException | SecurityException e) {
				throw new RuntimeException("Cannot initilize!", e);
			}
		}
		{
			assert AbstractSAPI.logDebug("Base: public api, static init: create caches...");

			CACHE_INT = Base.BASE_IMPL.createCacheInteger();
			CACHE_LNG = Base.BASE_IMPL.createCacheLong();
			CACHE_DBL = Base.BASE_IMPL.createCacheDouble();
			CACHE_STR = Base.BASE_IMPL.createCacheString();
		}

		assert AbstractSAPI.logDebug("Base: public api, static init: prefill int cache...");
		/** INT_CACHE_POSITIVE */
		{
			/** Not less than Short.MAX */
			final int size = Engine.MODE_SIZE
				? 64 * 1024
				: Engine.MODE_SPEED
					? 8 * 64 * 1024
					: 4 * 64 * 1024;
			CACHE_INT_POSITIVE = new BasePrimitiveNumber[size];
			CACHE_INT_POSITIVE_SIZE = size;

			/** Excluding ONE and ZERO */
			for (int i = Base.CACHE_INT_POSITIVE_SIZE - 1; i > 1; --i) {
				Base.CACHE_INT_POSITIVE[i] = new PrimitiveNumberTrueInteger(i);
			}
			/** Here goes ONE */
			Base.CACHE_INT_POSITIVE[1] = BasePrimitiveNumber.ONE;
			/** Here goes ZERO */
			Base.CACHE_INT_POSITIVE[0] = BasePrimitiveNumber.ZERO;
		}
		/** INT_CACHE_NEGATIVE */
		{

			final int size = (Engine.MODE_SIZE
				? 2 * 1024
				: Engine.MODE_SPEED
					? 32 * 1024
					: 8 * 1024) - 1;

			CACHE_INT_NEGATIVE = new BasePrimitiveNumber[size];

			/** yes - same number, cause starts with -1 (not 0) */
			CACHE_INT_NEGATIVE_MIN = (short) -size;

			CACHE_INT_NEGATIVE_MIN_SHORT = (short) -size;

			CACHE_INT_NEGATIVE_SIZE = (short) size;

			/** than 'negatives starting with -1' excluding -1 */
			for (int i = Base.CACHE_INT_NEGATIVE_SIZE - 1; i > 0; --i) {
				Base.CACHE_INT_NEGATIVE[i] = new PrimitiveNumberTrueInteger(-i - 1);
			}
			/** Here goes MONE */
			Base.CACHE_INT_NEGATIVE[0] = BasePrimitiveNumber.MONE;

			/** Just to be sure that byte range support is here. */
			assert Math.round(Base.CACHE_INT_POSITIVE_SIZE) >= Short.MAX_VALUE : "Required for full range positive short support";
			assert Math.round(Base.CACHE_INT_NEGATIVE_SIZE) >= 255 : "Required for full range byte support";
			assert Math.round(Base.CACHE_INT_NEGATIVE_MIN) <= -256 : "Required for full range byte support";
			assert Math.round(Base.CACHE_INT_NEGATIVE_MIN_SHORT) <= -256 : "Required for full range byte support";

			/** fill 1-char length strings */
			for (int i = Base.CHARS.length - 1; i >= 0; --i) {
				switch (i) {
					case '0' :
						Base.CHARS['0'] = BaseString.STR_ZERO;
						continue;
					case '1' :
						Base.CHARS['1'] = BaseString.STR_ONE;
						continue;
					case '2' :
					case '3' :
					case '4' :
					case '5' :
					case '6' :
					case '7' :
					case '8' :
					case '9' :
						Base.CHARS[i] = new PrimitiveStringBaseInteger(String.valueOf((char) i).intern(), i - '0');
						continue;
					default :
						Base.CHARS[i] = new PrimitiveStringBaseNaN(String.valueOf((char) i).intern());
				}
			}

			assert AbstractSAPI.logDebug("Base: public api, static init: prefill double cache...");

			/** fill constants */
			Base.initCachePutDouble(BasePrimitiveNumber.E);
			Base.initCachePutDouble(BasePrimitiveNumber.LN10);
			Base.initCachePutDouble(BasePrimitiveNumber.LN2);
			Base.initCachePutDouble(BasePrimitiveNumber.LOG10E);
			Base.initCachePutDouble(BasePrimitiveNumber.LOG2E);
			Base.initCachePutDouble(BasePrimitiveNumber.NAN);
			Base.initCachePutDouble(BasePrimitiveNumber.NINF);
			Base.initCachePutDouble(BasePrimitiveNumber.PI);
			Base.initCachePutDouble(BasePrimitiveNumber.MAX_VALUE);
			Base.initCachePutDouble(BasePrimitiveNumber.MIN_VALUE);
			Base.initCachePutDouble(BasePrimitiveNumber.PINF);
			Base.initCachePutDouble(BasePrimitiveNumber.SQRT1_2);
			Base.initCachePutDouble(BasePrimitiveNumber.SQRT2);

			assert AbstractSAPI.logDebug("Base: public api, static init: prefill string cache...");

			Base.initCachePutString(BaseString.EMPTY);
			Base.initCachePutString(BaseString.STR_FALSE);
			Base.initCachePutString(BaseString.STR_INFINITY);
			Base.initCachePutString(BaseString.STR_NAN);
			Base.initCachePutString(BaseString.STR_NINFINITY);
			Base.initCachePutString(BaseString.STR_NULL);
			Base.initCachePutString(BaseString.STR_PINFINITY);
			Base.initCachePutString(BaseString.STR_TO_STRING);
			Base.initCachePutString(BaseString.STR_TRUE);
			Base.initCachePutString(BaseString.STR_UNDEFINED);
			Base.initCachePutString(BaseString.STR_VALUE_OF);
			Base.initCachePutString(BaseString.STR_UTF8);
			Base.initCachePutString(BaseString.STR_ONE);
			Base.initCachePutString(BaseString.STR_ZERO);

			Base.initCachePutString(BaseString.STR_BOOLEAN);
			Base.initCachePutString(BaseString.STR_FUNCTION);
			Base.initCachePutString(BaseString.STR_NUMBER);
			Base.initCachePutString(BaseString.STR_OBJECT);
			Base.initCachePutString(BaseString.STR_STRING);

			Base.initCachePutString(BaseString.STR_LENGTH);
			Base.initCachePutString(BaseString.STR_CALLEE);
			Base.initCachePutString(BaseString.STR_PROTOTYPE);
			Base.initCachePutString(BaseString.STR_CONSTRUCTOR);

			Base.initCachePutString(BaseString.STR_EX_GETDATA);
		}
		{
			assert BaseString.STR_LENGTH == Base.forString("length") : "Should return the same instance!";
			assert BaseString.STR_PROTOTYPE == Base.forString("prototype") : "Should return the same instance!";
		}

		BaseString.class.getName();

		BaseObject.PROTOTYPE.getClass();

		assert AbstractSAPI.logDebug("Base: public api, static init: patch editable...");

		((BaseEditable) BaseString.PROTOTYPE).setOwnProperty( //
				BaseString.STR_LENGTH,
				Base.LENGTH_PROPERTY_STRING,
				BaseProperty.ATTRS_MASK_NNN);

		assert AbstractSAPI.logDebug("Base: public api, static init: done.");
	}

	private static final int bigDecimalExponent = 324; // i.e.

	// abs(minDecimalExponent)

	private static final char infinity[] = {
			'I', 'n', 'f', 'i', 'n', 'i', 't', 'y'
	};

	private static final char notANumber[] = {
			'N', 'a', 'N'
	};

	private static final char zero[] = {
			'0', '0', '0', '0', '0', '0', '0', '0'
	};

	/** @param function
	 * @param instance
	 * @param arguments
	 * @return */
	public static final BaseFunction bindFunction(final BaseFunction function, final BaseObject instance, final BaseObject... arguments) {

		return Base.BASE_IMPL.bindFunction(function, instance, arguments);
	}

	/** 'object's prototype chain should not have 'check' object in it.
	 *
	 * @param object
	 * @param check
	 * @return */
	static final boolean checkPrototypeChainDuplicates(BaseObject object, final BaseObject check) {

		int counter = 500;
		for (; object != null; object = object.basePrototype()) {
			if (object == check) {
				return false;
			}
			if (--counter < 0) {
				throw new IllegalArgumentException("Prototype chain is too long, more than 500 entries: object=" + Format.Describe.toEcmaSource(object, ""));
			}
		}
		return true;
	}

	/** @param o1
	 * @param o2
	 * @return */
	public static final boolean compareEQU(final BaseObject o1, final BasePrimitiveString o2) {

		if (o1 == o2) {
			return true;
		}
		if (o1 == BasePrimitiveNumber.NAN) {
			return false;
		}

		{
			final boolean o1falseExact = o1 == null || o1 == BaseObject.UNDEFINED || o1 == BaseObject.NULL || o1 == BaseObject.FALSE || o1 == BasePrimitiveNumber.ZERO
					|| o1 == BaseString.EMPTY;

			final boolean o2falseExact = o2 == null || o2 == BaseString.EMPTY;

			if (o1falseExact && o2falseExact) {
				return true;
			}

			if (o1falseExact) {
				return o2 != null && o2.baseToJavaBoolean()
					? false
					: true;
			}
			if (o2falseExact) {
				return o1 != null && o1.baseToJavaBoolean()
					? false
					: true;
			}
		}

		{
			final boolean o1trueExact = o1 == BaseObject.TRUE;

			if (o1trueExact) {
				return true;
			}

			if (o1trueExact) {
				return o2 != null && o2.baseToJavaBoolean()
					? true
					: false;
			}
		}

		assert o1 != null && o2 != null : "should not get there ^^^^^";

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
		if (o1 instanceof CharSequence) {
			final String s1 = o1.toString();
			return s1 != null && s1.equals(o2.toString());
		}
		/** 16. If Type(x) is Number and Type(y) is String, return the result of the comparison x ==
		 * ToNumber(y). */
		if (o1.baseIsPrimitiveNumber()) {
			/** for fakes */
			// return o1 == o2.baseToNumber();
			return Double.doubleToLongBits(o1.baseToPrimitive(null).doubleValue()) //
					== Double.doubleToLongBits(o2.doubleValue());
		}
		if (!o1.baseIsPrimitive()) {
			/** 21. If Type(x) is Object and Type(y) is either String or Number, return the result
			 * of the comparison ToPrimitive(x) == y. */
			final BasePrimitive<?> primitive = o1.baseToPrimitive(ToPrimitiveHint.STRING);
			return primitive instanceof BasePrimitiveString
				? primitive == o2
				: primitive instanceof CharSequence && primitive.stringValue().equals(o2.stringValue());
			// return ComparatorEcma.compareEQU( o1.baseToPrimitive(
			// ToPrimitiveHint.STRING ), o2 );
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

	/** @param o1
	 * @param o2
	 * @return */
	public static final boolean compareEQU(final BasePrimitiveString o1, final BaseObject o2) {

		return Base.compareEQU(o2, o1);
	}

	static final CacheIntegerImpl createCacheIntegerBucket() {

		return Base.BASE_IMPL.createCacheInteger();
	}

	/** equivalent to JS 'new Function ([arg1[, arg2[, ...argN]],] functionBody)'.
	 *
	 * for Java-2-JS integration calls
	 *
	 * Function will be scoped to runtime-current context's GV (Global Values).
	 *
	 * @param arg
	 * @return
	 * @throws Exception */
	public static final BaseFunction createFunction(final String... arg) throws Exception {

		if (arg == null) {
			return BaseFunction.RETURN_UNDEFINED;
		}
		return Base.BASE_IMPL.createFunction(Exec.currentProcess().ri10GV, arg);
	}

	/** Leaves property's name empty, key is used for 'isProcedural' call only.
	 *
	 * @param instance
	 *            for property passed
	 * @param key
	 *            for property passed
	 * @param property
	 * @param attributes
	 * @return */
	static final BasePropertyData<BasePrimitiveString>
			createPropertyPrimitive(final BaseObject instance, final BasePrimitiveString key, final BaseProperty property, final short attributes) {

		return Base.BASE_IMPL.createPropertyPrimitive(instance, key, property, attributes);
	}

	static final BasePropertyData<BasePrimitiveString> createPropertyPrimitive(final BasePrimitiveString key, final BaseObject value, final short attributes) {

		return Base.BASE_IMPL.createPropertyPrimitive(key, value, attributes);
	}

	/** Leaves property's name empty, key is used for 'isProcedural' call only.
	 *
	 * @param instance
	 * @param key
	 * @param property
	 * @param attributes
	 * @return */
	static final BasePropertyData<String> createPropertyString(final BaseObject instance, final String key, final BaseProperty property, final short attributes) {

		return Base.BASE_IMPL.createPropertyString(instance, key, property, attributes);
	}

	static final BasePropertyData<String> createPropertyString(final String key, final BaseObject value, final short attributes) {

		return Base.BASE_IMPL.createPropertyString(key, value, attributes);
	}

	/** Creates default extensible unsealed string object just like new String(x) will do in the
	 * script
	 *
	 * @param x
	 *
	 * @return */
	public static final BaseStringObject<?> createStringObject(final CharSequence x) {

		return Base.OBJECT_FACTORY.createStringObject(x.toString());
	}

	/** Creates default extensible unsealed string object just like new String(x) will do in the
	 * script
	 *
	 * @param x
	 *
	 * @return */
	public static final BaseStringObject<?> createStringObject(final String x) {

		return Base.OBJECT_FACTORY.createStringObject(x);
	}

	/** This is default implementation for toPrimitive method.
	 *
	 * TODO: search for similar code and refactor to use this one.
	 *
	 * @param object
	 * @param hint
	 * @return */
	public static final BasePrimitive<?> defaultToPrimitive(final BaseObject object, final ToPrimitiveHint hint) {

		if (hint == null || hint == ToPrimitiveHint.NUMBER) {
			{
				final BaseObject valueOf = object.baseGet(BaseString.STR_VALUE_OF, BaseObject.UNDEFINED);
				assert valueOf != null : "Never returns java NULLs";
				final BaseFunction call = valueOf.baseCall();
				if (call != null) {
					final BaseObject result = call.callNJ0(object);
					if (result != object) {
						return result.baseToPrimitive(ToPrimitiveHint.NUMBER);
					}
				}
			}
			{
				final BaseObject toString = object.baseGet(BaseString.STR_TO_STRING, BaseObject.UNDEFINED);
				assert toString != null : "Never returns java NULLs";
				final BaseFunction call = toString.baseCall();
				if (call != null) {
					final BaseObject result = call.callNJ0(object);
					if (result != object) {
						return result.baseToPrimitive(ToPrimitiveHint.NUMBER);
					}
				}
			}
		} else {
			{
				final BaseObject toString = object.baseGet(BaseString.STR_TO_STRING, BaseObject.UNDEFINED);
				assert toString != null : "Never returns java NULLs";
				final BaseFunction call = toString.baseCall();
				if (call != null) {
					final BaseObject result = call.callNJ0(object);
					if (result != object) {
						return result.baseToPrimitive(ToPrimitiveHint.STRING);
					}
				}
			}
			{
				final BaseObject valueOf = object.baseGet(BaseString.STR_VALUE_OF, BaseObject.UNDEFINED);
				assert valueOf != null : "Never returns java NULLs";
				final BaseFunction call = valueOf.baseCall();
				if (call != null) {
					final BaseObject result = call.callNJ0(object);
					if (result != object) {
						return result.baseToPrimitive(ToPrimitiveHint.STRING);
					}
				}
			}
		}
		/** FIXME: 5. Throw a TypeError exception. */
		return Base.forString("[object " + object.getClass().getName() + "]");
	}

	/** CATCH METHOD
	 *
	 * @param object */
	@Deprecated
	public static final void forArray(final BaseObject object) {

		// ignore
	}

	/** @param <T>
	 * @param object
	 * @return array or java-NULL when object is NULL */
	public static final <T> BaseArray forArray(final List<T> object) {

		return Base.BASE_IMPL.javaObjectToBaseArray(object);
	}

	/** TODO: return java-null for NULL argument
	 *
	 * @param <T>
	 * @param object
	 * @return primitive */
	public static final <T> BaseArray forArray(final T[] object) {

		return Base.BASE_IMPL.javaObjectToBaseArray(object);
	}

	/** @param x
	 * @return */
	public static BasePrimitiveBoolean forBoolean(final boolean x) {

		return x
			? BaseObject.TRUE
			: BaseObject.FALSE;
	}

	/** @param value
	 * @return number */
	public static final BasePrimitiveNumber forByte(final byte value) {

		return value < 0
			? Base.CACHE_INT_NEGATIVE[-value - 1]
			: Base.CACHE_INT_POSITIVE[value];
	}

	/** @param c
	 * @return */
	public static final BasePrimitiveString forChar(final char c) {

		return Base.CHARS[c];
	}

	/** CATCH METHOD
	 *
	 * @param date */
	@Deprecated
	public static final void forDate(final BaseDate date) {

		//
	}

	/** Will return same objects if it is an instance of BaseDate or will create BaseWrapDate
	 * wrapper to dynamically reflect changes in given Date object.
	 *
	 * @param date
	 * @return date or java-NULL when date is null */
	public static final BaseDate forDate(final Date date) {

		if (date == null) {
			return null;
		}
		if (date instanceof final BaseDate baseDate) {
			return baseDate;
		}
		return date.getClass() == Date.class
			? new BaseDate(date)
			: new BaseWrapDate(date);
	}

	/** Will simply create an instance of BaseDate
	 *
	 * @param date
	 * @return date */
	public static final BaseDate forDateMillis(final long date) {

		return new BaseDate(date);
	}

	/** CATCH METHOD
	 *
	 * @param value */
	@Deprecated
	public static final void forDouble(final byte value) {

		//
	}

	/** @param x
	 * @return number */
	public static final BasePrimitiveNumber forDouble(final double x) {

		if (x == (long) x) {
			final int intX = (int) x;
			if (intX == x) {
				return Base.forInteger(intX);
			}
			return Base.forLong((long) x);
		}
		if (Double.isNaN(x)) {
			return BasePrimitiveNumber.NAN;
		}
		if (x == Double.NEGATIVE_INFINITY) {
			return BasePrimitiveNumber.NINF;
		}
		if (x == Double.POSITIVE_INFINITY) {
			return BasePrimitiveNumber.PINF;
		}
		return Base.CACHE_DBL.cacheGetCreate(x);
	}

	/** CATCH METHOD
	 *
	 * @param value */
	@Deprecated
	public static final void forDouble(final int value) {

		//
	}

	/** CATCH METHOD
	 *
	 * @param value */
	@Deprecated
	public static final void forDouble(final long value) {

		//
	}

	/** CATCH METHOD
	 *
	 * @param value */
	@Deprecated
	public static final void forDouble(final short value) {

		//
	}

	/** Parses double as BasePrimitiveString.baseToNumber() would.
	 *
	 * @param string
	 * @return */
	public static BasePrimitiveNumber forDouble(final String string) {

		return Base.forDouble(Base.parseDouble(string));
	}

	/** @param x
	 * @return number */
	public static final BasePrimitiveNumber forDoublePrecachedOrNull(final double x) {

		{
			final int value = (int) x;
			if (value == x) {
				return value >= 0
					/** positives */
					? value < Base.CACHE_INT_POSITIVE_SIZE
						/** in cache: ZERO value stored at 0 index */
						? Base.CACHE_INT_POSITIVE[value]
						/** TODO: make .cacheGetNoCreate()? */
						: null
					/** negatives */
					: value >= Base.CACHE_INT_NEGATIVE_MIN
						/** in cache: MONE value at 0 index */
						? Base.CACHE_INT_NEGATIVE[-value - 1]
						/** TODO: make .cacheGetNoCreate()? */
						: null;
			}
		}
		if (Double.isNaN(x)) {
			return BasePrimitiveNumber.NAN;
		}
		if (x == Double.NEGATIVE_INFINITY) {
			return BasePrimitiveNumber.NINF;
		}
		if (x == Double.POSITIVE_INFINITY) {
			return BasePrimitiveNumber.PINF;
		}
		/** TODO: make .cacheGetNoCreate()? */
		return null;
	}

	/** Catch method
	 *
	 * @param function */
	@Deprecated
	public static final void forFunction(final BaseFunction function) {

		//
	}

	/** @param function
	 * @return */
	public static final BaseFunction forFunction(final ExecCallable function) {

		return Base.BASE_IMPL.javaNativeFunction(function);
	}

	/** @param value
	 * @return number */
	public static final BasePrimitiveNumber forInteger(final int value) {

		return value >= 0
			/** positives */
			? value < Base.CACHE_INT_POSITIVE_SIZE
				/** in cache: ZERO value stored at 0 index */
				? Base.CACHE_INT_POSITIVE[value]
				/** in cache */
				: Base.CACHE_INT.cacheGetCreate(value)
			/** negatives */
			: value >= Base.CACHE_INT_NEGATIVE_MIN
				/** in cache: MONE value at 0 index */
				? Base.CACHE_INT_NEGATIVE[-value - 1]
				/** in cache */
				: Base.CACHE_INT.cacheGetCreate(value);
	}

	/** CATCH METHOD
	 *
	 * @param value */
	@Deprecated
	public static final void forInteger(final short value) {

		//
	}

	/** @param value
	 * @return number */
	public static final BasePrimitiveNumber forIntegerPrecachedOrNull(final int value) {

		return value >= 0
			/** positives */
			? value < Base.CACHE_INT_POSITIVE_SIZE
				/** in cache: ZERO value stored at 0 index */
				? Base.CACHE_INT_POSITIVE[value]
				/** TODO: make .cacheGetNoCreate()? */
				: null
			/** negatives */
			: value >= Base.CACHE_INT_NEGATIVE_MIN
				/** in cache: MONE value at 0 index */
				? Base.CACHE_INT_NEGATIVE[-value - 1]
				/** TODO: make .cacheGetNoCreate()? */
				: null;
	}

	/** CATCH METHOD
	 *
	 * @param value */
	@Deprecated
	public static final void forLong(final byte value) {

		//
	}

	/** CATCH METHOD
	 *
	 * @param value */
	@Deprecated
	public static final void forLong(final int value) {

		//
	}

	/** @param x
	 * @return number */
	public static final BasePrimitiveNumber forLong(final long x) {

		{
			final int intX = (int) x;
			if (intX == x) {
				return Base.forInteger(intX);
			}
		}
		return Base.CACHE_LNG.cacheGetCreate(x);
	}

	/** CATCH METHOD
	 *
	 * @param value */
	@Deprecated
	public static final void forLong(final short value) {

		//
	}

	/** @param x
	 * @return number */
	public static final BasePrimitiveNumber forLongPrecachedOrNull(final long x) {

		{
			final int value = (int) x;
			if (value == x) {
				return value >= 0
					/** positives */
					? value < Base.CACHE_INT_POSITIVE_SIZE
						/** in cache: ZERO value stored at 0 index */
						? Base.CACHE_INT_POSITIVE[value]
						/** TODO: make .cacheGetNoCreate()? */
						: null
					/** negatives */
					: value >= Base.CACHE_INT_NEGATIVE_MIN
						/** in cache: MONE value at 0 index */
						? Base.CACHE_INT_NEGATIVE[-value - 1]
						/** TODO: make .cacheGetNoCreate()? */
						: null;
			}
		}
		/** TODO: make .cacheGetNoCreate()? */
		return null;
	}

	/** @param <T>
	 * @return */
	@SuppressWarnings("unchecked")
	public static final <T> T forNull() {

		return (T) BaseObject.NULL;
	}

	/** Catch method for catching objects that are known before compilation to have String type
	 * already - user forNumber().
	 *
	 * @param object */
	@Deprecated
	public static final void forNumber(final Byte object) {

		//
	}

	/** Catch method for catching objects that are known before compilation to have String type
	 * already - user forNumber().
	 *
	 * @param object */
	@Deprecated
	public static final void forNumber(final Double object) {

		//
	}

	/** Catch method for catching objects that are known before compilation to have String type
	 * already - user forNumber().
	 *
	 * @param object */
	@Deprecated
	public static final void forNumber(final Float object) {

		//
	}

	/** Catch method for catching objects that are known before compilation to have String type
	 * already - user forNumber().
	 *
	 * @param object */
	@Deprecated
	public static final void forNumber(final Integer object) {

		//
	}

	/** Catch method for catching objects that are known before compilation to have String type
	 * already - user forNumber().
	 *
	 * @param object */
	@Deprecated
	public static final void forNumber(final Long object) {

		//
	}

	/** @param value
	 * @return number, NaN when value is null, never java-NULL. */
	public static final BaseObject forNumber(final Number value) {

		return Base.BASE_IMPL.javaNumberToBaseObjectNumber(value);
	}

	/** Catch method for catching objects that are known before compilation to have String type
	 * already - user forNumber().
	 *
	 * @param object */
	@Deprecated
	public static final void forNumber(final Short object) {

		//
	}

	/** @param value
	 * @return number */
	public static final BasePrimitiveNumber forShort(final short value) {

		return value >= 0
			? Base.CACHE_INT_POSITIVE[value]
			: value >= Base.CACHE_INT_NEGATIVE_MIN_SHORT
				? Base.CACHE_INT_NEGATIVE[-value - 1]
				: Base.CACHE_INT.cacheGetCreate(value);
	}

	/** Catch method
	 *
	 * @param stringValue */
	@Deprecated
	public static void forString(final BasePrimitiveString stringValue) {

		//
	}

	/** @param stringValue
	 * @return */
	public static BasePrimitiveString forString(final CharSequence stringValue) {

		if (stringValue instanceof final BasePrimitiveString primitiveString) {
			return primitiveString;
		}
		if (stringValue != null) {
			switch (stringValue.length()) {
				case 0 :
					return BaseString.EMPTY;
				case 1 :
					return Base.CHARS[stringValue.charAt(0)];
				default : {
					return Base.CACHE_STR.cacheGetCreate(stringValue.toString());
				}
			}
		}
		return BaseString.STR_NULL;
	}

	/** Formats double as BasePrimitiveNumber.baseToString() would.
	 *
	 * @param doubleValue
	 * @return */
	public static BasePrimitiveString forString(final double doubleValue) {

		/** can't use pre-cached numbers, cause, likely, it will call this method to baseToString()
		 * implementation. */
		return Base.forString(
				doubleValue == (long) doubleValue
					? Long.toString((long) doubleValue)
					: Double.toString(doubleValue));
	}

	/** Formats int as BasePrimitiveNumber.baseToString() would.
	 *
	 * @param intValue
	 * @return */
	public static BasePrimitiveString forString(final int intValue) {

		/** can't use pre-cached numbers, cause, likely, it will call this method to baseToString()
		 * implementation. */
		return Base.forString(Integer.toString(intValue));
	}

	/** Formats long as BasePrimitiveNumber.baseToString() would.
	 *
	 * @param longValue
	 * @return */
	public static BasePrimitiveString forString(final long longValue) {

		/** can't use pre-cached numbers, cause, likely, it will call this method to baseToString()
		 * implementation. */
		return Base.forString(Long.toString(longValue));
	}

	/** @param value
	 * @return string, never java-NULL, empty string when argument is NULL */
	public static final BasePrimitiveString forString(final String value) {

		if (value == null) {
			return BaseString.EMPTY;
		}
		switch (value.length()) {
			case 0 :
				return BaseString.EMPTY;
			case 1 :
				return Base.CHARS[value.charAt(0)];
			default :
				return Base.CACHE_STR.cacheGetCreate(value);
		}
	}

	/** @param value
	 * @return string, never java-NULL, empty string when argument is NULL */
	public static final BasePrimitiveString forStringPrecachedOrNull(final String value) {

		if (value == null) {
			return BaseString.EMPTY;
		}
		switch (value.length()) {
			case 0 :
				return BaseString.EMPTY;
			case 1 :
				return Base.CHARS[value.charAt(0)];
			default :
				/** TODO: make .cacheGetNoCreate()? */
				return null;
		}
	}

	/** Catch method for catching objects that are known before compilation to have BaseObject type
	 * already.
	 *
	 * @param object */
	@Deprecated
	public static final void forThrowable(final BaseObject object) {

		//
	}

	/** @param object
	 * @return primitive */
	public static final BaseAbstractException forThrowable(final Throwable object) {

		return Base.BASE_IMPL.javaThrowableToBaseObject(object);
	}

	/** Catch method for catching objects that are known before compilation to have BaseObject type
	 * already.
	 *
	 * @param object */
	@Deprecated
	public static final void forUnknown(final BaseObject object) {

		//
	}

	/** Catch method for catching objects that are known before compilation to have BaseObject type
	 * already.
	 *
	 * @param object */
	@Deprecated
	public static final void forUnknown(final Boolean object) {

		//
	}

	/** Catch method for catching objects that are known before compilation to have BaseObject type
	 * already.
	 *
	 * @param object */
	@Deprecated
	public static final void forUnknown(final Date object) {

		//
	}

	/** Catch method for catching objects that are known before compilation to have BaseObject type
	 * already.
	 *
	 * @param object */
	@Deprecated
	public static final void forUnknown(final ExecCallable object) {

		//
	}

	/** Catch method for catching objects that are known before compilation.
	 *
	 * Use getArray
	 *
	 * @param object */
	@Deprecated
	public static final void forUnknown(final List<?> object) {

		//
	}

	/** Catch method for catching objects that are known before compilation to have BaseObject type
	 * already.
	 *
	 * @param object */
	@Deprecated
	public static final void forUnknown(final Number object) {

		//
	}

	/** @param object
	 * @return primitive */
	public static final BaseObject forUnknown(final Object object) {

		return Base.BASE_IMPL.javaObjectToBaseObject(object);
	}

	/** Catch method for catching objects that are known before compilation.
	 *
	 * Use forArray
	 *
	 * @param object */
	@Deprecated
	public static final void forUnknown(final Object[] object) {

		//
	}

	/** Catch method for catching objects that are known before compilation to have BaseObject type
	 * already.
	 *
	 * @param object */
	@Deprecated
	public static final void forUnknown(final String object) {

		//
	}

	/** Catch method for catching objects that are known before compilation to have BaseObject type
	 * already.
	 *
	 * @param object */
	@Deprecated
	public static final void forUnknown(final Throwable object) {

		//
	}

	/** CATCH METHOD
	 *
	 * @param object */
	@Deprecated
	public static final void fromMap(final BaseMap object) {

		//
	}

	/** @param object
	 * @return */
	public static final BaseMap fromMap(final BaseObject object) {

		if (object instanceof final BaseMap baseMap) {
			return baseMap;
		}
		return BaseObject.createObject(object);
	}

	/** @param map
	 * @return */
	public static final BaseMap fromMap(final Map<String, Object> map) {

		if (map instanceof final BaseMap baseMap) {
			return baseMap;
		}
		final BaseMap base = BaseObject.createObject();
		if (map != null) {
			base.putAll(map);
		}
		return base;
	}

	/** Allows NULL object
	 *
	 * @param object
	 * @param property
	 * @param defaultValue
	 * @return */
	public static final BaseObject get(final BaseObject object, final BasePrimitiveString property, final BaseObject defaultValue) {

		return object == null
			? defaultValue
			: object.baseGet(property, defaultValue);
	}

	/** Allows NULL object
	 *
	 * @param object
	 * @param property
	 * @param defaultValue
	 * @return */
	public static final BaseObject get(final BaseObject object, final String property, final BaseObject defaultValue) {

		return object == null
			? defaultValue
			: object.baseGet(property, defaultValue);
	}

	/** @param object
	 * @param name
	 * @param defaultValue
	 * @param stop
	 * @return */
	public static final BaseObject get(final BaseObject object, final String name, final BaseObject defaultValue, final BaseObject stop) {

		if (object == null) {
			return defaultValue;
		}
		final BaseProperty property = object.baseFindProperty(name, stop);
		return property == null
			? defaultValue
			: property.propertyGet(object, name);
	}

	/** @param object
	 * @param name
	 * @param defaultValue
	 * @return */
	public static final boolean getBoolean(final BaseObject object, final String name, final boolean defaultValue) {

		if (object == null) {
			return defaultValue;
		}
		final BaseObject value = object.baseGet(name, BaseObject.UNDEFINED);
		assert value != null : "NULL java object";
		return value == BaseObject.UNDEFINED
			? defaultValue
			: value.baseToJavaBoolean();
	}

	/** @param object
	 * @param index
	 * @param defaultValue
	 * @return */
	public static final double getDouble(final BaseArray object, final int index, final double defaultValue) {

		if (object == null) {
			return defaultValue;
		}
		final BaseObject value = object.baseGet(index, BaseObject.UNDEFINED);
		assert value != null : "NULL java object";
		return value == BaseObject.UNDEFINED
			? defaultValue
			: value.baseToNumber().doubleValue();
	}

	/** @param object
	 * @param name
	 * @param defaultValue
	 * @return */
	public static final double getDouble(final BaseObject object, final String name, final double defaultValue) {

		if (object == null) {
			return defaultValue;
		}
		final BaseObject value = object.baseGet(name, BaseObject.UNDEFINED);
		assert value != null : "NULL java object";
		return value == BaseObject.UNDEFINED
			? defaultValue
			: value.baseToNumber().doubleValue();
	}

	/** @param array
	 * @param defaultValue
	 * @return */
	public static final BaseObject getFirst(final BaseArray array, final BaseObject defaultValue) {

		if (array == null) {
			return defaultValue;
		}
		return array.baseGetFirst(defaultValue);
	}

	/** @param array
	 * @param defaultValue
	 * @return */
	public static final String getFirstString(final BaseArray array, final String defaultValue) {

		if (array == null) {
			return defaultValue;
		}
		final BaseObject value = array.baseGetFirst(BaseObject.UNDEFINED);
		return value == BaseObject.UNDEFINED
			? defaultValue
			: value.baseToJavaString();
	}

	/** @param object
	 * @param index
	 * @param defaultValue
	 * @return */
	public static final int getInt(final BaseArray object, final int index, final int defaultValue) {

		if (object == null) {
			return defaultValue;
		}
		final BaseObject value = object.baseGet(index, BaseObject.UNDEFINED);
		assert value != null : "NULL java object";
		return value == BaseObject.UNDEFINED
			? defaultValue
			: value.baseToJavaInteger();
	}

	/** @param object
	 * @param name
	 * @param defaultValue
	 * @return */
	public static final int getInt(final BaseObject object, final String name, final int defaultValue) {

		if (object == null) {
			return defaultValue;
		}
		final BaseObject value = object.baseGet(name, BaseObject.UNDEFINED);
		assert value != null : "NULL java object";
		return value == BaseObject.UNDEFINED
			? defaultValue
			: value.baseToJavaInteger();
	}

	/** Alias for: HasProperty(name) ? Get(name).value() : defaultValue
	 *
	 * @param object
	 * @param name
	 * @param defaultValue
	 * @return object */
	public static final Object getJava(final BaseObject object, final String name, final Object defaultValue) {

		if (object == null) {
			return defaultValue;
		}
		final BaseObject result = object.baseGet(name, BaseObject.UNDEFINED);
		return result == BaseObject.UNDEFINED
			? defaultValue
			: result.baseValue();
	}

	/** @param array
	 * @param defaultValue
	 * @return */
	public static final BaseObject getLast(final BaseArray array, final BaseObject defaultValue) {

		if (array == null) {
			return defaultValue;
		}
		return array.baseGetLast(defaultValue);
	}

	/** @param array
	 * @param defaultValue
	 * @return */
	public static final String getLastString(final BaseArray array, final String defaultValue) {

		if (array == null) {
			return defaultValue;
		}
		final BaseObject value = array.baseGetLast(null);
		return value == null || value == BaseObject.UNDEFINED
			? defaultValue
			: value.baseToJavaString();
	}

	/** @param object
	 * @param name
	 * @param defaultValue
	 * @return */
	public static final long getLong(final BaseObject object, final String name, final long defaultValue) {

		if (object == null) {
			return defaultValue;
		}
		final BaseObject value = object.baseGet(name, BaseObject.UNDEFINED);
		assert value != null : "NULL java object";
		return value == BaseObject.UNDEFINED
			? defaultValue
			: value.baseToJavaLong();
	}

	/** @param array
	 * @param index
	 * @param defaultValue
	 * @return */
	public static final String getString(final BaseArray array, final int index, final String defaultValue) {

		if (array == null) {
			return defaultValue;
		}
		final BaseObject value = array.baseGet(index, BaseObject.UNDEFINED);
		assert value != null : "NULL java object";
		return value == BaseObject.UNDEFINED
			? defaultValue
			: value.baseToJavaString();
	}

	/** @param object1
	 * @param name1
	 * @param object2
	 * @param name2
	 * @param defaultValue
	 * @return */
	public static final String getString(final BaseObject object1, final String name1, final BaseObject object2, final String name2, final String defaultValue) {

		if (object1 != null) {
			final BaseObject value = object1.baseGet(name1, BaseObject.UNDEFINED);
			assert value != null : "NULL java object";
			if (value != BaseObject.UNDEFINED) {
				return value.baseToJavaString();
			}
		}
		if (object2 != null) {
			final BaseObject value = object2.baseGet(name2, BaseObject.UNDEFINED);
			assert value != null : "NULL java object";
			if (value != BaseObject.UNDEFINED) {
				return value.baseToJavaString();
			}
		}
		return defaultValue;
	}

	/** @param object
	 * @param name
	 * @param defaultValue
	 * @return */
	public static final String getString(final BaseObject object, final String name, final String defaultValue) {

		if (object == null) {
			return defaultValue;
		}
		final BaseObject value = object.baseGet(name, BaseObject.UNDEFINED);
		assert value != null : "NULL java object";
		return value == BaseObject.UNDEFINED
			? defaultValue
			: value.baseToJavaString();
	}

	/** @param object
	 * @param name1
	 * @param name2
	 * @param defaultValue
	 * @return */
	public static final String getString(final BaseObject object, final String name1, final String name2, final String defaultValue) {

		if (object == null) {
			return defaultValue;
		}
		{
			final BaseObject value = object.baseGet(name1, BaseObject.UNDEFINED);
			assert value != null : "NULL java object";
			if (value != BaseObject.UNDEFINED) {
				return value.baseToJavaString();
			}
		}
		{
			final BaseObject value = object.baseGet(name2, BaseObject.UNDEFINED);
			assert value != null : "NULL java object";
			return value == BaseObject.UNDEFINED
				? defaultValue
				: value.baseToJavaString();
		}
	}

	/** equivalent to: return this.hasOwnProperties || this.prototype &&
	 * this.prototype.hasProperties
	 *
	 * @param object
	 * @return */
	public static final boolean hasKeys(final BaseObject object) {

		if (object == null) {
			return false;
		}
		if (object.baseHasKeysOwn()) {
			return true;
		}
		final BaseObject prototype = object.basePrototype();
		return prototype != null && Base.hasKeys(prototype);
	}

	/** equivalent to: return this.hasOwnProperties || this.prototype &&
	 * this.prototype.hasProperties
	 *
	 * @param object
	 * @param searchUntil
	 * @return */
	public static final boolean hasKeys(final BaseObject object, final BaseObject searchUntil) {

		if (object == null) {
			return false;
		}
		if (object.baseHasKeysOwn()) {
			return true;
		}
		final BaseObject prototype = object.basePrototype();
		return prototype != null && prototype != searchUntil && Base.hasKeys(prototype, searchUntil);
	}

	/** [[HasProperty]] (P) When the [[HasProperty]] method of O is called with property name P, the
	 * following steps are taken:<br>
	 * 1. If O has a property with name P, return true.<br>
	 * 2. If the [[Prototype]] of O is null, return false.<br>
	 * 3. Call the [[HasProperty]] method of [[Prototype]] with property name P. <br>
	 * 4. Return Result(3).
	 *
	 * @param object
	 * @param name
	 * @return boolean */
	public static final boolean hasProperty(final BaseObject object, final BasePrimitive<?> name) {

		return object.baseFindProperty(name) != null;
	}

	/** [[HasProperty]] (P) When the [[HasProperty]] method of O is called with property name P, the
	 * following steps are taken:<br>
	 * 1. If O has a property with name P, return true.<br>
	 * 2. If the [[Prototype]] of O is null, return false.<br>
	 * 3. Call the [[HasProperty]] method of [[Prototype]] with property name P. <br>
	 * 4. Return Result(3).
	 *
	 * @param object
	 * @param name
	 * @return boolean */
	public static final boolean hasProperty(final BaseObject object, final String name) {

		return object.baseFindProperty(name) != null;
	}

	private static final void initCachePutDouble(final BasePrimitiveNumber value) {

		final double doubleValue = value.doubleValue();
		assert doubleValue != value.longValue() : "Use CacheInteger or CacheLong instead!";
		Base.CACHE_DBL.cachePutInternal(value);
	}

	private static final void initCachePutString(final BasePrimitiveString value) {

		Base.CACHE_STR.cachePutInternal(value);
	}

	/** @param iterator
	 * @return */
	public static final Iterator<BasePrimitive<?>> iteratorPrimitiveSafe(final Iterator<?> iterator) {

		if (!iterator.hasNext()) {
			return BaseObject.ITERATOR_EMPTY_PRIMITIVE;
		}
		if (iterator instanceof final IteratorTypeSafePrimitive iteratorPrimitive) {
			return iteratorPrimitive;
		}
		return new IteratorTypeSafePrimitive(iterator);
	}

	/** @param iterator
	 * @return */
	public static final Iterator<String> iteratorStringSafe(final Iterator<?> iterator) {

		if (!iterator.hasNext()) {
			return BaseObject.ITERATOR_EMPTY;
		}
		if (iterator instanceof final IteratorTypeSafe iteratorTypeSafe) {
			return iteratorTypeSafe;
		}
		return new IteratorTypeSafe(iterator);
	}

	/** @param primary
	 * @param secondary
	 * @return */
	public static final Iterator<? extends CharSequence> joinIterators(final Iterator<? extends CharSequence> primary, final Iterator<? extends CharSequence> secondary) {

		assert primary != null : "Iterator is null, use BaseObject.ITERATOR_EMPTY!";
		assert secondary != null : "Iterator is null, use BaseObject.ITERATOR_EMPTY!";
		if (primary == BaseObject.ITERATOR_EMPTY) {
			return secondary;
		}
		if (secondary == BaseObject.ITERATOR_EMPTY) {
			return primary;
		}
		return new IteratorSequenceCharSequence(primary, secondary);
	}

	/** @param primary
	 * @param secondary
	 * @return */
	public static final Iterator<String> joinIteratorsAsString(final Iterator<String> primary, final Iterator<String> secondary) {

		assert primary != null : "Iterator is null, use BaseObject.ITERATOR_EMPTY!";
		assert secondary != null : "Iterator is null, use BaseObject.ITERATOR_EMPTY!";
		if (primary == BaseObject.ITERATOR_EMPTY) {
			return secondary;
		}
		if (secondary == BaseObject.ITERATOR_EMPTY) {
			return primary;
		}
		return new IteratorSequenceString(primary, secondary);
	}

	/** @param primary
	 * @param secondary
	 * @return */
	public static final Iterator<? extends BasePrimitive<?>> joinIteratorsPrimitive(final Iterator<? extends BasePrimitive<?>> primary,
			final Iterator<? extends BasePrimitive<?>> secondary) {

		assert primary != null : "Iterator is null, use BaseObject.ITERATOR_EMPTY!";
		assert secondary != null : "Iterator is null, use BaseObject.ITERATOR_EMPTY!";
		if (primary == BaseObject.ITERATOR_EMPTY_PRIMITIVE) {
			return secondary;
		}
		if (secondary == BaseObject.ITERATOR_EMPTY_PRIMITIVE) {
			return primary;
		}
		return new IteratorSequenceAnyPrimitive(primary, secondary);
	}

	/** Never returns NULL. Should return BaseObject.ITERATOR_EMPTY at least.
	 * <p>
	 * Properties of the object being enumerated may be deleted during enumeration. If a property
	 * that has not yet been visited during enumeration is deleted, then it will not be visited. If
	 * new properties are added to the object being enumerated during enumeration, the newly added
	 * properties are not guaranteed to be visited in the active enumeration.
	 * <p>
	 * Enumerating the properties of an object includes enumerating properties of its prototype, and
	 * the prototype of the prototype, and so on, recursively; but a property of a prototype is not
	 * enumerated if it is ―shadowed because some previous object in the prototype chain has a
	 * property with the same name. Deleted: The mechanics of enumerating the properties (step 5 in
	 * the first algorithm, step 6 in the second) is implementation dependent. The order of
	 * enumeration is defined by the object.
	 *
	 * @param object
	 *
	 * @return */
	public static final Iterator<String> keys(BaseObject object) {

		assert object != null : "Is there any good reason to return an empty iterator in case of null object?";

		for (;;) {
			final Iterator<String> iterator = object.baseKeysOwn();
			assert iterator != null : "NULL iterator: use BaseObject.ITERATOR_EMPTY, class=" //
					+ object.getClass().getName() + "!";

			final BaseObject prototype = object.basePrototype();
			if (prototype == null) {
				return iterator;
			}

			if (iterator == BaseObject.ITERATOR_EMPTY) {
				object = prototype;
				continue;
			}
			assert iterator.hasNext() : "Should not be empty (use BaseObject.ITERATOR_EMPTY for empty key iterator), class=" + object.getClass().getName() + "!";

			{
				final BaseObject superPrototype = prototype.basePrototype();
				if (superPrototype != null) {
					return new IteratorHierarchy(object, iterator, prototype);
				}
			}

			{
				final Iterator<String> another = prototype.baseKeysOwn();
				assert another != null : "NULL iterator: use BaseObject.ITERATOR_EMPTY, class=" //
						+ prototype.getClass().getName() + "!";

				if (another == BaseObject.ITERATOR_EMPTY) {
					return iterator;
				}
				assert another.hasNext() : "Should not be empty (use BaseObject.ITERATOR_EMPTY for empty key iterator), class=" + prototype.getClass().getName() + "!";

				return new IteratorSequenceString(iterator, another);
			}
		}
	}

	/** Never returns NULL. Should return BaseObject.ITERATOR_EMPTY at least.
	 * <p>
	 * Properties of the object being enumerated may be deleted during enumeration. If a property
	 * that has not yet been visited during enumeration is deleted, then it will not be visited. If
	 * new properties are added to the object being enumerated during enumeration, the newly added
	 * properties are not guaranteed to be visited in the active enumeration.
	 * <p>
	 * Enumerating the properties of an object includes enumerating properties of its prototype, and
	 * the prototype of the prototype, and so on, recursively; but a property of a prototype is not
	 * enumerated if it is ―shadowed because some previous object in the prototype chain has a
	 * property with the same name. Deleted: The mechanics of enumerating the properties (step 5 in
	 * the first algorithm, step 6 in the second) is implementation dependent. The order of
	 * enumeration is defined by the object.
	 *
	 * @param object
	 * @param searchUntil
	 *
	 * @return */
	public static final Iterator<String> keys(BaseObject object, final BaseObject searchUntil) {

		assert object != null : "Is there any good reason to return an empty iterator in case of null object?";
		for (;;) {
			final Iterator<String> iterator = object.baseKeysOwn();
			assert iterator != null : "NULL iterator: use BaseObject.ITERATOR_EMPTY, class=" //
					+ object.getClass().getName() + "!";

			final BaseObject prototype = object.basePrototype();
			if (prototype == null || prototype == searchUntil) {
				return iterator;
			}

			if (iterator == BaseObject.ITERATOR_EMPTY) {
				object = prototype;
				continue;
			}
			assert iterator.hasNext() : "Should not be empty (use BaseObject.ITERATOR_EMPTY for empty key iterator), class=" + object.getClass().getName() + "!";

			{
				final BaseObject superPrototype = prototype.basePrototype();
				if (superPrototype != null && superPrototype != searchUntil) {
					return new IteratorHierarchyUntil(iterator, prototype, searchUntil);
				}
			}

			{
				final Iterator<String> another = prototype.baseKeysOwn();
				assert another != null : "NULL iterator: use BaseObject.ITERATOR_EMPTY, class=" //
						+ prototype.getClass().getName() + "!";

				if (another == BaseObject.ITERATOR_EMPTY) {
					return iterator;
				}
				assert another.hasNext() : "Should not be empty (use BaseObject.ITERATOR_EMPTY for empty key iterator), class=" + prototype.getClass().getName() + "!";

				return new IteratorSequenceString(iterator, another);
			}
		}
	}

	/** Never returns NULL. Should return BaseObject.ITERATOR_EMPTY at least.
	 * <p>
	 * Properties of the object being enumerated may be deleted during enumeration. If a property
	 * that has not yet been visited during enumeration is deleted, then it will not be visited. If
	 * new properties are added to the object being enumerated during enumeration, the newly added
	 * properties are not guaranteed to be visited in the active enumeration.
	 * <p>
	 * Enumerating the properties of an object includes enumerating properties of its prototype, and
	 * the prototype of the prototype, and so on, recursively; but a property of a prototype is not
	 * enumerated if it is ―shadowed because some previous object in the prototype chain has a
	 * property with the same name. Deleted: The mechanics of enumerating the properties (step 5 in
	 * the first algorithm, step 6 in the second) is implementation dependent. The order of
	 * enumeration is defined by the object.
	 *
	 * @param object
	 *
	 * @return */
	public static final Iterator<? extends CharSequence> keysAll(BaseObject object) {

		assert object != null : "Is there any good reason to return an empty iterator in case of null object?";

		for (;;) {
			final Iterator<? extends CharSequence> iterator = object.baseKeysOwnAll();
			assert iterator != null : "NULL iterator: use BaseObject.ITERATOR_EMPTY, class=" //
					+ object.getClass().getName() + "!";

			final BaseObject prototype = object.basePrototype();
			if (prototype == null) {
				return iterator;
			}

			if (iterator == BaseObject.ITERATOR_EMPTY) {
				object = prototype;
				continue;
			}
			assert iterator.hasNext() : "Should not be empty (use BaseObject.ITERATOR_EMPTY for empty key iterator), class=" + object.getClass().getName() + "!";

			{
				final BaseObject superPrototype = prototype.basePrototype();
				if (superPrototype != null) {
					return new IteratorHierarchyAll(iterator, prototype);
				}
			}

			{
				final Iterator<? extends CharSequence> another = prototype.baseKeysOwnAll();
				assert another != null : "NULL iterator: use BaseObject.ITERATOR_EMPTY, class=" //
						+ prototype.getClass().getName() + "!";

				if (another == BaseObject.ITERATOR_EMPTY) {
					return iterator;
				}
				assert another.hasNext() : "Should not be empty (use BaseObject.ITERATOR_EMPTY for empty key iterator), class=" + prototype.getClass().getName() + "!";

				return new IteratorSequenceCharSequence(iterator, another);
			}
		}
	}

	/** Never returns NULL. Should return BaseObject.ITERATOR_EMPTY_PRIMITIVE at least.
	 * <p>
	 * Properties of the object being enumerated may be deleted during enumeration. If a property
	 * that has not yet been visited during enumeration is deleted, then it will not be visited. If
	 * new properties are added to the object being enumerated during enumeration, the newly added
	 * properties are not guaranteed to be visited in the active enumeration.
	 * <p>
	 * Enumerating the properties of an object includes enumerating properties of its prototype, and
	 * the prototype of the prototype, and so on, recursively; but a property of a prototype is not
	 * enumerated if it is ―shadowed because some previous object in the prototype chain has a
	 * property with the same name. Deleted: The mechanics of enumerating the properties (step 5 in
	 * the first algorithm, step 6 in the second) is implementation dependent. The order of
	 * enumeration is defined by the object.
	 *
	 * @param baseObject
	 *
	 * @return */
	public static final Iterator<? extends BasePrimitive<?>> keysPrimitive(BaseObject baseObject) {

		assert baseObject != null : "Is there any good reason to return an empty iterator in case of null object?";

		for (;;) {
			final Iterator<? extends BasePrimitive<?>> iterator = baseObject.baseKeysOwnPrimitive();
			assert iterator != null : "NULL iterator: use BaseObject.ITERATOR_EMPTY_PRIMITIVE, class=" //
					+ baseObject.getClass().getName() + "!";

			final BaseObject prototype = baseObject.basePrototype();
			if (prototype == null) {
				return iterator;
			}

			if (iterator == BaseObject.ITERATOR_EMPTY_PRIMITIVE) {
				baseObject = prototype;
				continue;
			}
			assert iterator.hasNext() : "Should not be empty (use BaseObject.ITERATOR_EMPTY_PRIMITIVE for empty key iterator), class=" + baseObject.getClass().getName() + "!";

			{
				final BaseObject superPrototype = prototype.basePrototype();
				if (superPrototype != null) {
					return new IteratorHierarchyPrimitive(iterator, prototype);
				}
			}

			{
				final Iterator<? extends BasePrimitive<?>> another = prototype.baseKeysOwnPrimitive();
				assert another != null : "NULL iterator: use BaseObject.ITERATOR_EMPTY_PRIMITIVE, class=" //
						+ prototype.getClass().getName() + "!";

				if (another == BaseObject.ITERATOR_EMPTY_PRIMITIVE) {
					return iterator;
				}
				assert another.hasNext() : "Should not be empty (use BaseObject.ITERATOR_EMPTY_PRIMITIVE for empty key iterator), class=" + prototype.getClass().getName() + "!";

				return new IteratorSequenceAnyPrimitive(iterator, another);
			}
		}
	}

	/** An array of object's own property entries, each entry in form of array of length 2 (key,
	 * value)
	 *
	 * @param object
	 * @return */
	public static BaseArrayDynamic<Object> objectEntriesArray(final BaseObject object) {

		final BaseList<Object> result = BaseObject.createArray();
		for (final Iterator<? extends BasePrimitive<?>> iterator = object.baseKeysOwnPrimitive(); iterator.hasNext();) {
			final BasePrimitive<?> key = iterator.next();
			final BaseList<Object> entry = BaseObject.createArray(2);
			entry.baseDefaultPush(key);
			entry.baseDefaultPush(object.baseGet(key, null));
			result.baseDefaultPush(entry);
		}
		return result;
	}

	/** An array of object's own property names
	 *
	 * @param object
	 * @return */
	public static BaseArrayDynamic<Object> objectKeysArray(final BaseObject object) {

		final BaseList<Object> result = BaseObject.createArray();
		for (final Iterator<? extends BasePrimitive<?>> iterator = object.baseKeysOwnPrimitive(); iterator.hasNext();) {
			result.baseDefaultPush(iterator.next());
		}
		return result;
	}

	/** An array of object's own property values
	 *
	 * @param object
	 * @return */
	public static BaseArrayDynamic<Object> objectValuesArray(final BaseObject object) {

		final BaseList<Object> result = BaseObject.createArray();
		for (final Iterator<? extends BasePrimitive<?>> iterator = object.baseKeysOwnPrimitive(); iterator.hasNext();) {
			result.baseDefaultPush(object.baseGet(iterator.next(), null));
		}
		return result;
	}

	/** @param s
	 * @return */
	static double parseDouble(final String s) {

		boolean isNegative = false;
		boolean signSeen = false;

		final String in = s.trim(); // don't fool around with white space.
		// throws NullPointerException if null
		final int l = in.length();
		if (l == 0) {
			// throw new NumberFormatException( "empty String" );
			return Double.NaN;
		}
		char c;
		int i = 0;
		switch (c = in.charAt(i)) {
			case '-' :
				isNegative = true;
				//$FALL-THROUGH$
			case '+' :
				++i;
				signSeen = true;
				//$FALL-THROUGH$
			default :
		}

		// Check for NaN and Infinity strings
		c = in.charAt(i);
		if (c == 'N' || c == 'I') { // possible NaN or infinity
			boolean potentialNaN = false;
			char targetChars[] = null; // char array of "NaN" or "Infinity"

			if (c == 'N') {
				targetChars = Base.notANumber;
				potentialNaN = true;
			} else {
				targetChars = Base.infinity;
			}

			// compare Input string to "NaN" or "Infinity"
			int j = 0;
			while (i < l && j < targetChars.length) {
				if (in.charAt(i) == targetChars[j]) {
					++i;
					++j;
				} else {
					// something is amiss, throw exception
					// break parseNumber;
					return Double.NaN;
				}
			}

			// For the candidate string to be a NaN or infinity,
			// all characters in input string and target char[]
			// must be matched ==> j must equal targetChars.length
			// and i must equal l
			if (j == targetChars.length && i == l) { // return NaN or
														// infinity
				return potentialNaN
					? Double.NaN // NaN has no sign
					: isNegative
						? Double.NEGATIVE_INFINITY
						: Double.POSITIVE_INFINITY;
			}
			{ // something went wrong, throw exception
				// break parseNumber;
				return Double.NaN;
			}

		} else //
		if (c == '0') { // check for hexadecimal number
			if (l > i + 1) {
				final char ch = in.charAt(i + 1);
				if (ch == 'x' || ch == 'X') {
					final double val = Base.parseLong(in.substring(2), 16);
					return val == Double.NEGATIVE_INFINITY
						? Double.NaN
						: val;
				}
			}
		} // look for and process decimal floating-point string

		int decExp;
		char[] digits = new char[l];
		int nDigits = 0;
		boolean decSeen = false;
		int decPt = 0;
		int nLeadZero = 0;
		int nTrailZero = 0;
		digitLoop : while (i < l) {
			switch (c = in.charAt(i)) {
				case '0' :
					if (nDigits > 0) {
						++nTrailZero;
					} else {
						++nLeadZero;
					}
					break; // out of switch.
				case '1' :
				case '2' :
				case '3' :
				case '4' :
				case '5' :
				case '6' :
				case '7' :
				case '8' :
				case '9' :
					while (nTrailZero > 0) {
						digits[nDigits++] = '0';
						--nTrailZero;
					}
					digits[nDigits++] = c;
					break; // out of switch.
				case '.' :
					if (decSeen) {
						// already saw one ., this is the 2nd.

						// throw new NumberFormatException( "multiple points" );
						return Double.NaN;
					}
					decPt = i;
					if (signSeen) {
						--decPt;
					}
					decSeen = true;
					break; // out of switch.
				default :
					break digitLoop;
			}
			++i;
		}
		/* At this point, we've scanned all the digits and decimal point we're going to see. Trim
		 * off leading and trailing zeros, which will just confuse us later, and adjust our initial
		 * decimal exponent accordingly. To review: we have seen i total characters. nLeadZero of
		 * them were zeros before any other digits. nTrailZero of them were zeros after any other
		 * digits. if ( decSeen ), then a . was seen after decPt characters ( including leading
		 * zeros which have been discarded ) nDigits characters were neither lead nor trailing
		 * zeros, nor point */
		/* special hack: if we saw no non-zero digits, then the answer is zero! Unfortunately, we
		 * feel honor-bound to keep parsing! */
		if (nDigits == 0) {
			if (nLeadZero == 0) {
				// we saw NO DIGITS AT ALL,
				// not even a crummy 0!
				// this is not allowed.

				// break parseNumber; // go throw exception

				return Double.NaN;
			}
			digits = Base.zero;
			nDigits = 1;
		}

		/* Our initial exponent is decPt, adjusted by the number of discarded zeros. Or, if there
		 * was no decPt, then its just nDigits adjusted by discarded trailing zeros. */
		if (decSeen) {
			decExp = decPt - nLeadZero;
		} else {
			decExp = nDigits + nTrailZero;
		}

		/* Look for 'e' or 'E' and an optionally signed integer. */
		if (i < l && ((c = in.charAt(i)) == 'e' || c == 'E')) {
			int expSign = 1;
			int expVal = 0;
			final int reallyBig = Integer.MAX_VALUE / 10;
			boolean expOverflow = false;
			switch (in.charAt(++i)) {
				case '-' :
					expSign = -1;
					//$FALL-THROUGH$
				case '+' :
					++i;
					//$FALL-THROUGH$
				default :
			}
			final int expAt = i;
			expLoop : while (i < l) {
				if (expVal >= reallyBig) {
					// the next character will cause integer
					// overflow.
					expOverflow = true;
				}
				switch (c = in.charAt(i++)) {
					case '0' :
					case '1' :
					case '2' :
					case '3' :
					case '4' :
					case '5' :
					case '6' :
					case '7' :
					case '8' :
					case '9' :
						expVal = expVal * 10 + c - '0';
						continue;
					default :
						i--; // back up.
						break expLoop; // stop parsing exponent.
				}
			}
			final int expLimit = Base.bigDecimalExponent + nDigits + nTrailZero;
			if (expOverflow || expVal > expLimit) {
				//
				// The intent here is to end up with
				// infinity or zero, as appropriate.
				// The reason for yielding such a small decExponent,
				// rather than something intuitive such as
				// expSign*Integer.MAX_VALUE, is that this value
				// is subject to further manipulation in
				// doubleValue() and floatValue(), and I don't want
				// it to be able to cause overflow there!
				// (The only way we can get into trouble here is for
				// really outrageous nDigits+nTrailZero, such as 2 billion.
				// )
				//
				decExp = expSign * expLimit;
			} else {
				// this should not overflow, since we tested
				// for expVal > (MAX+N), where N >= abs(decExp)
				decExp = decExp + expSign * expVal;
			}

			// if we saw something not a digit ( or end of string )
			// after the [Ee][+-], without seeing any digits at all
			// this is certainly an error. If we saw some digits,
			// but then some trailing garbage, that might be ok.
			// so we just fall through in that case.
			// HUMBUG
			if (i == expAt) {
				// break parseNumber; // certainly bad
				return Double.NaN;
			}
		}
		/* We parsed everything we could. If there are leftovers, then this is not good input! */
		if (i < l && (i != l - 1 || in.charAt(i) != 'f' && in.charAt(i) != 'F' && in.charAt(i) != 'd' && in.charAt(i) != 'D')) {
			// break parseNumber; // go throw exception
			return Double.NaN;
		}

		// return new FloatingDecimal( isNegative, decExp, digits, nDigits,
		// false ).doubleValue();
		try {
			return Double.parseDouble(in);
		} catch (final NumberFormatException e) {
			return Double.NaN;
		}
	}

	/** @param s
	 * @param radix
	 * @return */
	static double parseLong(final String s, final int radix) {

		final int max = s.length();

		if (max <= 0) {
			return Double.NEGATIVE_INFINITY;
		}
		{
			long result = 0;
			boolean negative = false;
			int i = 0;
			final long limit;
			final long multmin;
			int digit;
			if (s.charAt(0) == '-') {
				negative = true;
				limit = Long.MIN_VALUE;
				++i;
			} else {
				limit = -Long.MAX_VALUE;
			}
			multmin = limit / radix;
			if (i < max) {
				digit = Character.digit(s.charAt(i++), radix);
				if (digit < 0) {
					return Double.NEGATIVE_INFINITY;
				}
				result = -digit;
			}
			while (i < max) {
				// Accumulating negatively avoids surprises near MAX_VALUE
				digit = Character.digit(s.charAt(i++), radix);
				if (digit < 0) {
					return Double.NEGATIVE_INFINITY;
				}
				if (result < multmin) {
					return Double.NEGATIVE_INFINITY;
				}
				result *= radix;
				if (result < limit + digit) {
					return Double.NEGATIVE_INFINITY;
				}
				result -= digit;
			}
			if (negative) {
				if (i > 1) {
					return result;
				}
				return Double.NEGATIVE_INFINITY;
			}
			return -result;
		}
	}

	/**
	 * <pre>
	 * 8.6.2.2 [[Put]] (P, V, Strict)
	 * For brevity, the changes caused by [[Put]] are described below in a self contained manner. But [[Put]]
	 * must not be able to cause and state transitions that wouldn‘t be allowed by [[SetOwnProperty]].
	 * When the [[Put]] method of O is called with property P and value V, the following steps are taken:
	 *
	 * 1. Call the [[GetOwnProperty]] method of O with name P.
	 * 2. If Result(1) is a DDesc, then
	 * 		a. Get the [[Writeable]] component of Result(1).
	 * 		b. If Result(2a) is true, then
	 * 			i. Set the [[Value]] component of property P of O to V.
	 * 			ii. Return true.
	 * 		c. If Strict is true, then throw TypeError.
	 * 		d. Else return false.
	 * 3. Call the [[GetProperty]] method of O with name P.
	 * 4. If Result(3) is a ProceduralDescription, then
	 * 		a. Get the [[Setter]] component of Result(3).
	 * 		b. If Result(4a) is undefined, then
	 * 			i. If Strict is true, then throw TypeError.
	 * 			ii. Else return false.
	 * 		e. Call Result(4a) as a method on O with argument V.
	 * 		f. Return true.
	 * 5. Get the [[Extensible]] property of object O.
	 * 6. If Result(5) is false, then.
	 * 		a. If Strict is true, then throw TypeError.
	 * 		b. Else return false.
	 * 7. Create an own property P on object O whose state is
	 * 		a. [[Value]]: V,
	 * 		b. [[Writeable]]: true,
	 * 		c. [[Enumerable]]: true,
	 * 		d. [[Dynamic]]: true.
	 * 8. Return true.
	 * </pre>
	 *
	 * Note, however, that if O is an Array object, it has a more elaborate [[Put]] method
	 * (15.4.5.1).
	 *
	 * <p>
	 * In any implementation should behave exactly as put(name, value, writable, enumerable,
	 * dynamic)
	 * </p>
	 *
	 * In scripting, implicit store object specifier (i.e. "b = 5" as opposed to "a.b = 5") should
	 * use this method.
	 *
	 * @param object
	 * @param name
	 * @param value
	 * @param attributes
	 * @return */
	public static final boolean put(final BaseObject object, final BasePrimitiveString name, final BaseObject value, final short attributes) {

		{
			/** 1. Call the [[GetOwnProperty]] method of O with name P. */
			final BaseProperty property = object.baseGetOwnProperty(name);
			/** 2. If Result(1) is a DDesc, then */
			if (property != null) {
				/** a. Get the [[Writeable]] component of Result(1).<br>
				 * b. If Result(2a) is true, then */
				final short propertyAttributes = property.propertyAttributes(name);
				if ((propertyAttributes & BaseProperty.ATTR_WRITABLE) != 0) {
					/** i. Set the [[Value]] component of property P of O to V. <br>
					 * ii. Return true. */
					return property.propertySet(object, name, value, attributes);
				}
				/** c. If Strict is true, then throw TypeError.<br>
				 * d. Else return false. */
				return false;
			}
		}
		{
			final BaseObject prototype = object.basePrototype();
			if (prototype != null) {
				/** 3. Call the [[GetProperty]] method of O with name P. */
				final BaseProperty property = prototype.baseFindProperty(name);
				/** 4. If Result(3) is a ProceduralDescription, then<br>
				 */
				if (property != null && (property.propertyAttributes(name) & BaseProperty.ATTR_PROCEDURAL_SET) != 0) {
					/** a. Get the [[Setter]] component of Result(3).<br>
					 * b. If Result(4a) is undefined, then <br>
					 * i. If Strict is true, then throw TypeError.<br>
					 * ii. Else return false. <br>
					 * e. Call Result(4a) as a method on O with argument V. <br>
					 * f. Return true.<br>
					 */
					return property.propertySet(object, name, value, attributes);
				}
			}
		}
		/** 5. Get the [[Extensible]] property of object O.<br>
		 * 6. If Result(5) is false, then. */
		if (!object.baseIsExtensible()) {
			return false;
		}
		/** 7. Create an own property P on object O whose state is<br>
		 * a. [[Value]]: V, <br>
		 * b. [[Writeable]]: true, <br>
		 * c. [[Enumerable]]: true, <br>
		 * d. [[Dynamic]]: true. <br>
		 */
		return object.baseDefine(name, value, attributes);
	}

	/**
	 * <pre>
	 * 8.6.2.2 [[Put]] (P, V, Strict)
	 * For brevity, the changes caused by [[Put]] are described below in a self contained manner. But [[Put]]
	 * must not be able to cause and state transitions that wouldn‘t be allowed by [[SetOwnProperty]].
	 * When the [[Put]] method of O is called with property P and value V, the following steps are taken:
	 *
	 * 1. Call the [[GetOwnProperty]] method of O with name P.
	 * 2. If Result(1) is a DDesc, then
	 * 		a. Get the [[Writeable]] component of Result(1).
	 * 		b. If Result(2a) is true, then
	 * 			i. Set the [[Value]] component of property P of O to V.
	 * 			ii. Return true.
	 * 		c. If Strict is true, then throw TypeError.
	 * 		d. Else return false.
	 * 3. Call the [[GetProperty]] method of O with name P.
	 * 4. If Result(3) is a ProceduralDescription, then
	 * 		a. Get the [[Setter]] component of Result(3).
	 * 		b. If Result(4a) is undefined, then
	 * 			i. If Strict is true, then throw TypeError.
	 * 			ii. Else return false.
	 * 		e. Call Result(4a) as a method on O with argument V.
	 * 		f. Return true.
	 * 5. Get the [[Extensible]] property of object O.
	 * 6. If Result(5) is false, then.
	 * 		a. If Strict is true, then throw TypeError.
	 * 		b. Else return false.
	 * 7. Create an own property P on object O whose state is
	 * 		a. [[Value]]: V,
	 * 		b. [[Writeable]]: true,
	 * 		c. [[Enumerable]]: true,
	 * 		d. [[Dynamic]]: true.
	 * 8. Return true.
	 * </pre>
	 *
	 * Note, however, that if O is an Array object, it has a more elaborate [[Put]] method
	 * (15.4.5.1).
	 *
	 * <p>
	 * In any implementation should behave exactly as put(name, value, writable, enumerable,
	 * dynamic)
	 * </p>
	 *
	 * In scripting, implicit store object specifier (i.e. "b = 5" as opposed to "a.b = 5") should
	 * use this method.
	 *
	 * @param object
	 * @param name
	 * @param value
	 * @param attributes
	 * @return */
	public static final boolean put(final BaseObject object, final CharSequence name, final BaseObject value, final short attributes) {

		if (name instanceof final BasePrimitiveString primitiveName) {
			return Base.put(object, primitiveName, value, attributes);
		}
		return Base.put(object, name.toString(), value, attributes);
	}

	/** Short cut for 'put(o,name,value.true,true,true)'
	 *
	 * @param object
	 * @param name
	 * @param value
	 * @return */
	public static final boolean put(final BaseObject object, final String name, final BaseObject value) {

		return Base.put(object, name, value, BaseProperty.ATTRS_MASK_WED);
	}

	/**
	 * <pre>
	 * 8.6.2.2 [[Put]] (P, V, Strict)
	 * For brevity, the changes caused by [[Put]] are described below in a self contained manner. But [[Put]]
	 * must not be able to cause and state transitions that wouldn‘t be allowed by [[SetOwnProperty]].
	 * When the [[Put]] method of O is called with property P and value V, the following steps are taken:
	 *
	 * 1. Call the [[GetOwnProperty]] method of O with name P.
	 * 2. If Result(1) is a DDesc, then
	 * 		a. Get the [[Writeable]] component of Result(1).
	 * 		b. If Result(2a) is true, then
	 * 			i. Set the [[Value]] component of property P of O to V.
	 * 			ii. Return true.
	 * 		c. If Strict is true, then throw TypeError.
	 * 		d. Else return false.
	 * 3. Call the [[GetProperty]] method of O with name P.
	 * 4. If Result(3) is a ProceduralDescription, then
	 * 		a. Get the [[Setter]] component of Result(3).
	 * 		b. If Result(4a) is undefined, then
	 * 			i. If Strict is true, then throw TypeError.
	 * 			ii. Else return false.
	 * 		e. Call Result(4a) as a method on O with argument V.
	 * 		f. Return true.
	 * 5. Get the [[Extensible]] property of object O.
	 * 6. If Result(5) is false, then.
	 * 		a. If Strict is true, then throw TypeError.
	 * 		b. Else return false.
	 * 7. Create an own property P on object O whose state is
	 * 		a. [[Value]]: V,
	 * 		b. [[Writeable]]: true,
	 * 		c. [[Enumerable]]: true,
	 * 		d. [[Dynamic]]: true.
	 * 8. Return true.
	 * </pre>
	 *
	 * Note, however, that if O is an Array object, it has a more elaborate [[Put]] method
	 * (15.4.5.1).
	 *
	 * <p>
	 * In any implementation should behave exactly as put(name, value, writable, enumerable,
	 * dynamic)
	 * </p>
	 *
	 * In scripting, implicit store object specifier (i.e. "b = 5" as opposed to "a.b = 5") should
	 * use this method.
	 *
	 * @param object
	 * @param name
	 * @param value
	 * @param attributes
	 * @return */
	public static final boolean put(final BaseObject object, final String name, final BaseObject value, final short attributes) {

		{
			/** 1. Call the [[GetOwnProperty]] method of O with name P. */
			final BaseProperty property = object.baseGetOwnProperty(name);
			/** 2. If Result(1) is a DDesc, then */
			if (property != null) {
				/** a. Get the [[Writeable]] component of Result(1).<br>
				 * b. If Result(2a) is true, then */
				final short propertyAttributes = property.propertyAttributes(name);
				if ((propertyAttributes & BaseProperty.ATTR_WRITABLE) != 0) {
					/** i. Set the [[Value]] component of property P of O to V. <br>
					 * ii. Return true. */
					return property.propertySet(object, name, value, attributes);
				}
				/** c. If Strict is true, then throw TypeError.<br>
				 * d. Else return false. */
				return false;
			}
		}
		{
			final BaseObject prototype = object.basePrototype();
			if (prototype != null) {
				/** 3. Call the [[GetProperty]] method of O with name P. */
				final BaseProperty property = prototype.baseFindProperty(name);
				/** 4. If Result(3) is a ProceduralDescription, then<br>
				 */
				if (property != null && (property.propertyAttributes(name) & BaseProperty.ATTR_PROCEDURAL_SET) != 0) {
					/** a. Get the [[Setter]] component of Result(3).<br>
					 * b. If Result(4a) is undefined, then <br>
					 * i. If Strict is true, then throw TypeError.<br>
					 * ii. Else return false. <br>
					 * e. Call Result(4a) as a method on O with argument V. <br>
					 * f. Return true.<br>
					 */
					return property.propertySet(object, name, value, attributes);
				}
			}
		}
		/** 5. Get the [[Extensible]] property of object O.<br>
		 * 6. If Result(5) is false, then. */
		if (!object.baseIsExtensible()) {
			return false;
		}
		/** 7. Create an own property P on object O whose state is<br>
		 * a. [[Value]]: V, <br>
		 * b. [[Writeable]]: true, <br>
		 * c. [[Enumerable]]: true, <br>
		 * d. [[Dynamic]]: true. <br>
		 */
		return object.baseDefine(name, value, attributes);
	}

	/**
	 * <pre>
	 * put(
	 * 		name,
	 * 		value
	 * 			? BaseObject.TRUE
	 * 			: BaseObject.FALSE,
	 * 		BaseProperty.ATTRS_MASK_WED);
	 * </pre>
	 *
	 * @param object
	 * @param name
	 * @param value
	 * @return */
	public static final boolean put(final BaseObject object, final String name, final boolean value) {

		return Base.put(
				object, //
				name,
				value
					? BaseObject.TRUE
					: BaseObject.FALSE,
				BaseProperty.ATTRS_MASK_WED);
	}

	/**
	 * <p>
	 * <b> Alias for: put(name, value, BaseProperty.ATTRS_MASK_WED) </b>
	 * </p>
	 *
	 * @param object
	 * @param name
	 * @param value
	 * @return */
	public static final boolean put(final BaseObject object, final String name, final double value) {

		return Base.put(object, name, value, BaseProperty.ATTRS_MASK_WED);
	}

	/**
	 * <pre>
	 * 8.6.2.2 [[Put]] (P, V, Strict)
	 * For brevity, the changes caused by [[Put]] are described below in a self contained manner. But [[Put]]
	 * must not be able to cause and state transitions that wouldn‘t be allowed by [[SetOwnProperty]].
	 * When the [[Put]] method of O is called with property P and value V, the following steps are taken:
	 *
	 * 1. Call the [[GetOwnProperty]] method of O with name P.
	 * 2. If Result(1) is a DDesc, then
	 * 		a. Get the [[Writeable]] component of Result(1).
	 * 		b. If Result(2a) is true, then
	 * 			i. Set the [[Value]] component of property P of O to V.
	 * 			ii. Return true.
	 * 		c. If Strict is true, then throw TypeError.
	 * 		d. Else return false.
	 * 3. Call the [[GetProperty]] method of O with name P.
	 * 4. If Result(3) is a ProceduralDescription, then
	 * 		a. Get the [[Setter]] component of Result(3).
	 * 		b. If Result(4a) is undefined, then
	 * 			i. If Strict is true, then throw TypeError.
	 * 			ii. Else return false.
	 * 		e. Call Result(4a) as a method on O with argument V.
	 * 		f. Return true.
	 * 5. Get the [[Extensible]] property of object O.
	 * 6. If Result(5) is false, then.
	 * 		a. If Strict is true, then throw TypeError.
	 * 		b. Else return false.
	 * 7. Create an own property P on object O whose state is
	 * 		a. [[Value]]: V,
	 * 		b. [[Writeable]]: true,
	 * 		c. [[Enumerable]]: true,
	 * 		d. [[Dynamic]]: true.
	 * 8. Return true.
	 * </pre>
	 *
	 * Note, however, that if O is an Array object, it has a more elaborate [[Put]] method
	 * (15.4.5.1).
	 *
	 * <p>
	 * In any implementation should behave exactly as put(name, value, writable, enumerable,
	 * dynamic)
	 * </p>
	 *
	 * In scripting, implicit store object specifier (i.e. "b = 5" as opposed to "a.b = 5") should
	 * use this method.
	 *
	 * @param object
	 * @param name
	 * @param value
	 * @param attributes
	 * @return */
	public static final boolean put(final BaseObject object, final String name, final double value, final short attributes) {

		{
			/** 1. Call the [[GetOwnProperty]] method of O with name P. */
			final BaseProperty property = object.baseGetOwnProperty(name);
			/** 2. If Result(1) is a DDesc, then */
			if (property != null) {
				/** a. Get the [[Writeable]] component of Result(1).<br>
				 * b. If Result(2a) is true, then */
				final short propertyAttributes = property.propertyAttributes(name);
				if ((propertyAttributes & BaseProperty.ATTR_WRITABLE) != 0) {
					/** i. Set the [[Value]] component of property P of O to V. <br>
					 * ii. Return true. */
					return property.propertySet(object, name, Base.forDouble(value), attributes);
				}
				/** c. If Strict is true, then throw TypeError.<br>
				 * d. Else return false. */
				return false;
			}
		}
		{
			final BaseObject prototype = object.basePrototype();
			if (prototype != null) {
				/** 3. Call the [[GetProperty]] method of O with name P. */
				final BaseProperty property = prototype.baseFindProperty(name);
				/** 4. If Result(3) is a ProceduralDescription, then<br>
				 */
				if (property != null && (property.propertyAttributes(name) & BaseProperty.ATTR_PROCEDURAL_SET) != 0) {
					/** a. Get the [[Setter]] component of Result(3).<br>
					 * b. If Result(4a) is undefined, then <br>
					 * i. If Strict is true, then throw TypeError.<br>
					 * ii. Else return false. <br>
					 * e. Call Result(4a) as a method on O with argument V. <br>
					 * f. Return true.<br>
					 */
					return property.propertySet(object, name, Base.forDouble(value), attributes);
				}
			}
		}
		/** 5. Get the [[Extensible]] property of object O.<br>
		 * 6. If Result(5) is false, then. */
		if (!object.baseIsExtensible()) {
			return false;
		}
		/** 7. Create an own property P on object O whose state is<br>
		 * a. [[Value]]: V, <br>
		 * b. [[Writeable]]: true, <br>
		 * c. [[Enumerable]]: true, <br>
		 * d. [[Dynamic]]: true. <br>
		 */
		return object.baseDefine(name, value, attributes);
	}

	/**
	 * <p>
	 * <b> Alias for: put(name, value, BaseProperty.ATTRS_MASK_WED) </b>
	 * </p>
	 *
	 * @param object
	 * @param name
	 * @param value
	 * @return */
	public static final boolean put(final BaseObject object, final String name, final long value) {

		return Base.put(object, name, value, BaseProperty.ATTRS_MASK_WED);
	}

	/**
	 * <pre>
	 * 8.6.2.2 [[Put]] (P, V, Strict)
	 * For brevity, the changes caused by [[Put]] are described below in a self contained manner. But [[Put]]
	 * must not be able to cause and state transitions that wouldn‘t be allowed by [[SetOwnProperty]].
	 * When the [[Put]] method of O is called with property P and value V, the following steps are taken:
	 *
	 * 1. Call the [[GetOwnProperty]] method of O with name P.
	 * 2. If Result(1) is a DDesc, then
	 * 		a. Get the [[Writeable]] component of Result(1).
	 * 		b. If Result(2a) is true, then
	 * 			i. Set the [[Value]] component of property P of O to V.
	 * 			ii. Return true.
	 * 		c. If Strict is true, then throw TypeError.
	 * 		d. Else return false.
	 * 3. Call the [[GetProperty]] method of O with name P.
	 * 4. If Result(3) is a ProceduralDescription, then
	 * 		a. Get the [[Setter]] component of Result(3).
	 * 		b. If Result(4a) is undefined, then
	 * 			i. If Strict is true, then throw TypeError.
	 * 			ii. Else return false.
	 * 		e. Call Result(4a) as a method on O with argument V.
	 * 		f. Return true.
	 * 5. Get the [[Extensible]] property of object O.
	 * 6. If Result(5) is false, then.
	 * 		a. If Strict is true, then throw TypeError.
	 * 		b. Else return false.
	 * 7. Create an own property P on object O whose state is
	 * 		a. [[Value]]: V,
	 * 		b. [[Writeable]]: true,
	 * 		c. [[Enumerable]]: true,
	 * 		d. [[Dynamic]]: true.
	 * 8. Return true.
	 * </pre>
	 *
	 * Note, however, that if O is an Array object, it has a more elaborate [[Put]] method
	 * (15.4.5.1).
	 *
	 * <p>
	 * In any implementation should behave exactly as put(name, value, writable, enumerable,
	 * dynamic)
	 * </p>
	 *
	 * In scripting, implicit store object specifier (i.e. "b = 5" as opposed to "a.b = 5") should
	 * use this method.
	 *
	 * @param object
	 * @param name
	 * @param value
	 * @param attributes
	 * @return */
	public static final boolean put(final BaseObject object, final String name, final long value, final short attributes) {

		{
			/** 1. Call the [[GetOwnProperty]] method of O with name P. */
			final BaseProperty property = object.baseGetOwnProperty(name);
			/** 2. If Result(1) is a DDesc, then */
			if (property != null) {
				/** a. Get the [[Writeable]] component of Result(1).<br>
				 * b. If Result(2a) is true, then */
				final short propertyAttributes = property.propertyAttributes(name);
				if ((propertyAttributes & BaseProperty.ATTR_WRITABLE) != 0) {
					/** i. Set the [[Value]] component of property P of O to V. <br>
					 * ii. Return true. */
					return property.propertySet(object, name, Base.forLong(value), attributes);
				}
				/** c. If Strict is true, then throw TypeError.<br>
				 * d. Else return false. */
				return false;
			}
		}
		{
			final BaseObject prototype = object.basePrototype();
			if (prototype != null) {
				/** 3. Call the [[GetProperty]] method of O with name P. */
				final BaseProperty property = prototype.baseFindProperty(name);
				/** 4. If Result(3) is a ProceduralDescription, then<br>
				 */
				if (property != null && (property.propertyAttributes(name) & BaseProperty.ATTR_PROCEDURAL_SET) != 0) {
					/** a. Get the [[Setter]] component of Result(3).<br>
					 * b. If Result(4a) is undefined, then <br>
					 * i. If Strict is true, then throw TypeError.<br>
					 * ii. Else return false. <br>
					 * e. Call Result(4a) as a method on O with argument V. <br>
					 * f. Return true.<br>
					 */
					return property.propertySet(object, name, Base.forLong(value), attributes);
				}
			}
		}
		/** 5. Get the [[Extensible]] property of object O.<br>
		 * 6. If Result(5) is false, then. */
		if (!object.baseIsExtensible()) {
			return false;
		}
		/** 7. Create an own property P on object O whose state is<br>
		 * a. [[Value]]: V, <br>
		 * b. [[Writeable]]: true, <br>
		 * c. [[Enumerable]]: true, <br>
		 * d. [[Dynamic]]: true. <br>
		 */
		return object.baseDefine(name, value, attributes);
	}

	/**
	 * <p>
	 * <b> Alias for: put(name, value, BaseProperty.ATTRS_MASK_WED) </b>
	 * </p>
	 *
	 * @param object
	 * @param name
	 * @param value
	 * @return */
	public static final boolean put(final BaseObject object, final String name, final String value) {

		return Base.put(object, name, value, BaseProperty.ATTRS_MASK_WED);
	}

	/**
	 * <pre>
	 * 8.6.2.2 [[Put]] (P, V, Strict)
	 *
	 * For brevity, the changes caused by [[Put]] are described below in a self contained manner. But [[Put]]
	 * must not be able to cause and state transitions that wouldn‘t be allowed by [[SetOwnProperty]].
	 * When the [[Put]] method of O is called with property P and value V, the following steps are taken:
	 *
	 * 1. Call the [[GetOwnProperty]] method of O with name P.
	 * 2. If Result(1) is a DDesc, then
	 * 		a. Get the [[Writeable]] component of Result(1).
	 * 		b. If Result(2a) is true, then
	 * 			i. Set the [[Value]] component of property P of O to V.
	 * 			ii. Return true.
	 * 		c. If Strict is true, then throw TypeError.
	 * 		d. Else return false.
	 * 3. Call the [[GetProperty]] method of O with name P.
	 * 4. If Result(3) is a ProceduralDescription, then
	 * 		a. Get the [[Setter]] component of Result(3).
	 * 		b. If Result(4a) is undefined, then
	 * 			i. If Strict is true, then throw TypeError.
	 * 			ii. Else return false.
	 * 		e. Call Result(4a) as a method on O with argument V.
	 * 		f. Return true.
	 * 5. Get the [[Extensible]] property of object O.
	 * 6. If Result(5) is false, then.
	 * 		a. If Strict is true, then throw TypeError.
	 * 		b. Else return false.
	 * 7. Create an own property P on object O whose state is
	 * 		a. [[Value]]: V,
	 * 		b. [[Writeable]]: true,
	 * 		c. [[Enumerable]]: true,
	 * 		d. [[Dynamic]]: true.
	 * 8. Return true.
	 * </pre>
	 *
	 * Note, however, that if O is an Array object, it has a more elaborate [[Put]] method
	 * (15.4.5.1).
	 *
	 * <p>
	 * In any implementation should behave exactly as put(name, value, writable, enumerable,
	 * dynamic)
	 * </p>
	 *
	 * In scripting, implicit store object specifier (i.e. "b = 5" as opposed to "a.b = 5") should
	 * use this method.
	 *
	 * @param object
	 * @param name
	 * @param value
	 * @param attributes
	 * @return */
	public static final boolean put(final BaseObject object, final String name, final String value, final short attributes) {

		{
			/** 1. Call the [[GetOwnProperty]] method of O with name P. */
			final BaseProperty property = object.baseGetOwnProperty(name);
			/** 2. If Result(1) is a DDesc, then */
			if (property != null) {
				/** a. Get the [[Writeable]] component of Result(1).<br>
				 * b. If Result(2a) is true, then */
				final short propertyAttributes = property.propertyAttributes(name);
				if ((propertyAttributes & BaseProperty.ATTR_WRITABLE) != 0) {
					/** i. Set the [[Value]] component of property P of O to V. <br>
					 * ii. Return true. */
					return property.propertySet(object, name, Base.forString(value), attributes);
				}
				/** c. If Strict is true, then throw TypeError.<br>
				 * d. Else return false. */
				return false;
			}
		}
		{
			final BaseObject prototype = object.basePrototype();
			if (prototype != null) {
				/** 3. Call the [[GetProperty]] method of O with name P. */
				final BaseProperty property = prototype.baseFindProperty(name);
				/** 4. If Result(3) is a ProceduralDescription, then<br>
				 */
				if (property != null && (property.propertyAttributes(name) & BaseProperty.ATTR_PROCEDURAL_SET) != 0) {
					/** a. Get the [[Setter]] component of Result(3).<br>
					 * b. If Result(4a) is undefined, then <br>
					 * i. If Strict is true, then throw TypeError.<br>
					 * ii. Else return false. <br>
					 * e. Call Result(4a) as a method on O with argument V. <br>
					 * f. Return true.<br>
					 */
					return property.propertySet(object, name, Base.forString(value), attributes);
				}
			}
		}
		/** 5. Get the [[Extensible]] property of object O.<br>
		 * 6. If Result(5) is false, then. */
		if (!object.baseIsExtensible()) {
			return false;
		}
		/** 7. Create an own property P on object O whose state is<br>
		 * a. [[Value]]: V, <br>
		 * b. [[Writeable]]: true, <br>
		 * c. [[Enumerable]]: true, <br>
		 * d. [[Dynamic]]: true. <br>
		 */
		return object.baseDefine(name, value, attributes);
	}

	/** Puts all elements like:<br>
	 * <code>
	 * for(String key : value){
	 * 	putProperty( key, value.get( key ), BaseProperty.ATTRS_MASK_WED );
	 * }
	 * </code>
	 *
	 * Can save some iteration if implemented object is known to be read-only.
	 *
	 * @param target
	 *
	 * @param source */
	public static final void putAll(final BaseObject target, final BaseObject source) {

		if (source == null || source.baseIsPrimitive()) {
			return;
		}
		for (final Iterator<String> iterator = Base.keys(source); iterator.hasNext();) {
			final String key = iterator.next();
			Base.put(target, key, source.baseGet(key, BaseObject.UNDEFINED), BaseProperty.ATTRS_MASK_WED);
		}
	}

	/** <code>
		return !object.baseIsExtensible()
				? object
				: Base.BASE_IMPL.seal( object );
	 * </code>
	 *
	 *
	 * TODO: move to BaseObject's method
	 *
	 * @param object
	 * @return */
	public static final BaseObject seal(final BaseObject object) {

		return !object.baseIsExtensible()
			? object
			: Base.BASE_IMPL.seal(object);
	}

	/** Parses ECMA date universally, like Date.parse()
	 *
	 *
	 * @param s
	 * @return
	 * @throws ParseException */
	public static final long toDateMillis(final String s) throws ParseException {

		final String format;
		switch (s.length()) {
			// 2012-10-09T16:56:32.032
			case 23 :
				format = "yyyy-MM-dd'T'HH:mm:ss.SSS";
				break;
			// 20121009T165632032Z
			// 2012-10-09T16:56:32
			case 19 :
				if (s.charAt(8) == 'T') {
					return Format.Ecma.dateParse(s);
				}
				format = "yyyy-MM-dd'T'HH:mm:ss";
				break;
			// 20221122T221133Z
			// 2012-10-09T16:56
			case 16 : {
				if (s.charAt(8) == 'T') {
					return Format.Ecma.dateParse(s);
				}
				format = "yyyy-MM-dd'T'HH:mm";
				break;
			}
			// 2012-10-09T16:56:32.032+0000
			// 2012-10-09T16:56:32.032Z
			// 2012-10-09T16:56:32Z
			default :
				return Format.Ecma.dateParse(s);
		}

		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		simpleDateFormat.setTimeZone(Engine.TIMEZONE_GMT);
		return simpleDateFormat.parse(s).getTime();
	}

	/** Parses double as BasePrimitiveString.baseToNumber() would.
	 *
	 * @param string
	 * @return */
	public static double toDouble(final String string) {

		return Base.parseDouble(string);
	}

	/** Formats a doubleValue to a fixed-precision string as Number.prototype.toFixed would.
	 *
	 * @param doubleValue
	 * @param digits
	 * @return */
	public static final String toFixed(final double doubleValue, final int digits) {

		return NumberFormatter.formatFixed(doubleValue, digits);
	}

	/** Parses int32 as BasePrimitiveString.baseToInt32() would.
	 *
	 * @param string
	 * @return */
	public static int toInt32(final String string) {

		return (int) (long) Base.parseDouble(string);
	}

	/** Parses long as BasePrimitiveString.baseToInteger() would.
	 *
	 * @param string
	 * @return */
	public static long toLong(final String string) {

		return (long) Base.parseDouble(string);
	}

	/** Formats double as BasePrimitiveNumber.baseToString() would.
	 *
	 * @param number
	 * @return */
	public static String toString(final double number) {

		return number == (long) number
			? Long.toString((long) number)
			: Double.toString(number);
	}

	/** Formats double as BasePrimitiveNumber.baseToString() would.
	 *
	 * @param number
	 * @return */
	public static String toString(final long number) {

		return Long.toString(number);
	}

}
