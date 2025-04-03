package ru.myx.ae3.base;

import java.util.RandomAccess;

import ru.myx.ae3.common.Value;
import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;
import ru.myx.ae3.reflect.ReflectionExplicit;
import ru.myx.ae3.reflect.ReflectionHidden;

/** @author myx
 *
 *         TODO: please, move all ECMA/JS (non generic) constants to Ecma place...
 *		
 * @param <T> */
public interface BaseString<T extends CharSequence> extends CharSequence, BaseArray, RandomAccess, Value<T> {
	
	/**
	 *
	 */
	@ReflectionHidden
	BasePrimitiveString EMPTY = new PrimitiveStringEmpty();

	/**
	 *
	 */
	@ReflectionHidden
	BaseObject PROTOTYPE = BaseObject.createObject(BaseObject.PROTOTYPE);
	
	/**
	 *
	 */
	@ReflectionHidden
	BasePrimitiveString STR_BOOLEAN = new PrimitiveStringBaseNaN("boolean");
	
	/** ...and it actually will hold java-name, keeping it in memory and increasing probability of
	 * == check success, especially when 'length' string comes from VM execution. */
	@ReflectionHidden
	BasePrimitiveString STR_CALLEE = new PrimitiveStringBaseNaN("callee");
	
	/** ...and it actually will hold java-name, keeping it in memory and increasing probability of
	 * == check success, especially when 'length' string comes from VM execution. */
	@ReflectionHidden
	BasePrimitiveString STR_CONSTRUCTOR = new PrimitiveStringBaseNaN("constructor");
	
	/**
	 *
	 */
	@ReflectionHidden
	BasePrimitiveString STR_ENUMERABLE = new PrimitiveStringBaseNaN("enumerable");
	
	/**
	 *
	 */
	@ReflectionHidden
	BasePrimitiveString STR_WRITABLE = new PrimitiveStringBaseNaN("writable");
	
	/**
	 *
	 */
	@ReflectionHidden
	BasePrimitiveString STR_CONFIGURABLE = new PrimitiveStringBaseNaN("configurable");
	
	/**
	 *
	 */
	@ReflectionHidden
	BasePrimitiveString STR_GET = new PrimitiveStringBaseNaN("get");
	
	/**
	 *
	 */
	@ReflectionHidden
	BasePrimitiveString STR_SET = new PrimitiveStringBaseNaN("set");
	
	/**
	 *
	 */
	@ReflectionHidden
	BasePrimitiveString STR_VALUE = new PrimitiveStringBaseNaN("value");
	
	/**
	 *
	 */
	@ReflectionHidden
	BasePrimitiveString STR_EX_GETDATA = new PrimitiveStringBaseNaN("getData");
	/**
	 *
	 */
	@ReflectionHidden
	BasePrimitiveString STR_FALSE = new PrimitiveStringBaseNaN("false");
	
	/**
	 *
	 */
	@ReflectionHidden
	BasePrimitiveString STR_FUNCTION = new PrimitiveStringBaseNaN("function");
	/**
	 *
	 */
	@ReflectionHidden
	BasePrimitiveString STR_INFINITY = new PrimitiveStringBaseNumber("Infinity", Double.POSITIVE_INFINITY);
	/** ...and it actually will hold java-name, keeping it in memory and increasing probability of
	 * == check success, especially when 'length' string comes from VM execution. */
	@ReflectionHidden
	BasePrimitiveString STR_LENGTH = new PrimitiveStringBaseNaN("length");
	/**
	 *
	 */
	@ReflectionHidden
	BasePrimitiveString STR_NAN = new PrimitiveStringBaseNaN("NaN");
	/**
	 *
	 */
	@ReflectionHidden
	BasePrimitiveString STR_NINFINITY = new PrimitiveStringBaseNumber("-Infinity", Double.NEGATIVE_INFINITY);
	
	/**
	 *
	 */
	@ReflectionHidden
	BasePrimitiveString STR_NULL = new PrimitiveStringBaseNaN("null");
	/**
	 *
	 */
	@ReflectionHidden
	BasePrimitiveString STR_NUMBER = new PrimitiveStringBaseNaN("number");
	/**
	 *
	 */
	@ReflectionHidden
	BasePrimitiveString STR_OBJECT = new PrimitiveStringBaseNaN("object");
	/**
	 *
	 */
	@ReflectionHidden
	BasePrimitiveString STR_ONE = new PrimitiveStringOne();
	/**
	 *
	 */
	@ReflectionHidden
	BasePrimitiveString STR_PINFINITY = new PrimitiveStringBaseNumber("+Infinity", Double.POSITIVE_INFINITY);
	
	/** ...and it actually will hold java-name, keeping it in memory and increasing probability of
	 * == check success, especially when 'length' string comes from VM execution. */
	@ReflectionHidden
	BasePrimitiveString STR_PROTOTYPE = new PrimitiveStringBaseNaN("prototype");
	
	/**
	 *
	 */
	@ReflectionHidden
	BasePrimitiveString STR_STRING = new PrimitiveStringBaseNaN("string");
	
	/**
	 *
	 */
	@ReflectionHidden
	BasePrimitiveString STR_TO_STRING = new PrimitiveStringBaseNaN("toString");
	
	/**
	 *
	 */
	@ReflectionHidden
	BasePrimitiveString STR_TRUE = new PrimitiveStringBaseNaN("true");
	
	/**
	 *
	 */
	@ReflectionHidden
	BasePrimitiveString STR_UNDEFINED = new PrimitiveStringBaseNaN("undefined");
	
	/** 'utf-8' */
	@ReflectionHidden
	BasePrimitiveString STR_UTF8 = new PrimitiveStringBaseNaN("utf-8");
	
	/**
	 *
	 */
	@ReflectionHidden
	BasePrimitiveString STR_VALUE_OF = new PrimitiveStringBaseNaN("valueOf");
	
	/**
	 *
	 */
	@ReflectionHidden
	BasePrimitiveString STR_ZERO = new PrimitiveStringZero();
	
	@Override
	@ReflectionHidden
	default String baseClass() {
		
		return "string";
	}
	
	@Override
	@ReflectionHidden
	default BaseObject baseGet(final int index, final BaseObject defaultValue) {
		
		if (index < 0) {
			return defaultValue;
		}
		final CharSequence string = this.baseValue();
		if (index >= string.length()) {
			return defaultValue;
		}
		return Base.forChar(string.charAt(index));
	}
	
	@Override
	@ReflectionHidden
	default BaseObject basePrototype() {
		
		return BaseString.PROTOTYPE;
	}
	
	@Override
	@ReflectionHidden
	default CharSequence baseToJavaCharSequence() {
		
		return this;
	}
	
	@Override
	@ReflectionHidden
	default String baseToJavaString() {
		
		return this.toString();
	}
	
	@Override
	@ReflectionHidden
	default BasePrimitive<?> baseToPrimitive(final ToPrimitiveHint hint) {
		
		return Base.forString(this.baseValue());
	}
	
	@Override
	@ReflectionHidden
	default BasePrimitiveString baseToString() {
		
		return Base.forString(this.baseValue());
	}
	
	@Override
	@ReflectionHidden
	T baseValue();
	@Override
	@ReflectionHidden
	default char charAt(final int index) {
		
		return this.baseValue().charAt(index);
	}
	
	/** Must OVERRIDE! */
	@Override
	boolean equals(Object o);
	
	@Override
	@ReflectionHidden
	default String get(final int index) {
		
		if (index < 0) {
			return null;
		}
		final CharSequence string = this.baseValue();
		if (index >= string.length()) {
			return null;
		}
		return String.valueOf(string.charAt(index));
	}
	
	/** Must OVERRIDE! */
	@Override
	int hashCode();
	
	@Override
	@ReflectionExplicit
	default boolean isEmpty() {
		
		return this.baseValue().length() == 0;
	}
	
	@Override
	@ReflectionExplicit
	default int length() {
		
		return this.baseValue().length();
	}
	
	/** Replace all
	 *
	 * @param searchValue
	 * @param replaceValue
	 * @return */
	default BaseString<?> replace(final CharSequence searchValue, final CharSequence replaceValue) {
		
		final String source = this.baseToJavaString();
		final String result = source.replace(searchValue, replaceValue);
		return source == result
			? this
			: Base.forString(result);
	}
	
	/** @param s
	 * @return */
	default int stringCompare(final String s) {
		
		return this.baseToJavaString().compareTo(s);
	}
	
	/** @param s
	 * @return */
	default boolean stringEquals(final String s) {
		
		return this.stringCompare(s) == 0;
	}
	
	/** TODO: can make FutureMergeableCharSequence(start, end) when !isDone() */
	@Override
	default CharSequence subSequence(final int start, final int end) {
		
		return this.baseValue().subSequence(start, end);
	}
	
	/** Must OVERRIDE! */
	@Override
	String toString();
	
	/** @return */
	default BaseString<?> trim() {
		
		final String source = this.baseToJavaString();
		final String result = source.trim();
		
		// only if original was the String, should be changed?
		return source == result
			? this
			: Base.forString(result);
	}
	
	@Override
	@ReflectionHidden
	default ExecStateCode vmPropertyRead(final ExecProcess ctx, final int index, final BaseObject originalIfKnown, final BaseObject defaultValue, final ResultHandler store) {
		
		if (index < 0) {
			return store.execReturn(ctx, defaultValue);
		}
		final CharSequence string = this.baseValue();
		if (index >= string.length()) {
			return store.execReturn(ctx, defaultValue);
		}
		return store.execReturnChar(ctx, string.charAt(index));
	}
}
