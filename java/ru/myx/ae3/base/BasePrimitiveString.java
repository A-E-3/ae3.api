/**
 *
 */
package ru.myx.ae3.base;

import ru.myx.ae3.AbstractSAPI;
import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/** @author myx */
@ReflectionDisable
public abstract class BasePrimitiveString extends BasePrimitiveAbstract<String> implements BaseString<String>, Comparable<Object> {
	
	/**
	 *
	 */
	public static final String PROPERTY_JAVA_CALLEE;
	
	/**
	 *
	 */
	public static final String PROPERTY_JAVA_LENGTH;
	
	/**
	 *
	 */
	public static final String PROPERTY_JAVA_PROTOTYPE;
	
	private static final int PROPERTY_LEN_LENGTH;
	
	static {
		
		assert AbstractSAPI.logDebug("BasePrimitiveString: static init...");
		
		PROPERTY_JAVA_LENGTH = BaseString.STR_LENGTH.baseValue();
		PROPERTY_JAVA_CALLEE = BaseString.STR_CALLEE.baseValue();
		PROPERTY_JAVA_PROTOTYPE = BaseString.STR_PROTOTYPE.baseValue();
		PROPERTY_LEN_LENGTH = "length".length();
		
		assert AbstractSAPI.logDebug("BasePrimitiveString: static init: done.");
	}
	
	BasePrimitiveString() {
		
		//
	}
	
	@Override
	public BaseProperty baseFindProperty(final BasePrimitiveString name, final BaseObject stop) {
		
		if (name == BaseString.STR_LENGTH) {
			return Base.LENGTH_PROPERTY_STRING;
		}
		
		return BaseString.PROTOTYPE.baseFindProperty(name, stop);
	}
	
	@Override
	public BaseProperty baseFindProperty(final String name, final BaseObject stop) {
		
		if (name == BasePrimitiveString.PROPERTY_JAVA_LENGTH || name.length() == BasePrimitiveString.PROPERTY_LEN_LENGTH && BasePrimitiveString.PROPERTY_JAVA_LENGTH.equals(name)) {
			// if (BasePrimitiveString.PROPERTY_JAVA_LENGTH.equals(name)) {
			return Base.LENGTH_PROPERTY_STRING;
		}
		
		return BaseString.PROTOTYPE.baseFindProperty(name, stop);
	}
	
	@Override
	public final BaseObject baseGet(final BasePrimitiveString name, final BaseObject defaultValue) {
		
		if (name == BaseString.STR_LENGTH) {
			return PrimitiveStringLengthValue.getLengthValue(this.length());
		}
		for (final BaseProperty property = BaseString.PROTOTYPE.baseFindProperty(name); property != null;) {
			return property.propertyGet(this, name);
		}
		return defaultValue;
	}
	
	/** Allows array-like character access
	 *
	 * @param index
	 * @return */
	@Override
	public final BaseObject baseGet(final int index, final BaseObject defaultValue) {
		
		if (index < 0) {
			return defaultValue;
		}
		final String string = this.stringValue();
		if (index >= string.length()) {
			return defaultValue;
		}
		return Base.forChar(string.charAt(index));
	}
	
	@Override
	public final BaseObject baseGet(final String name, final BaseObject defaultValue) {
		
		if (name == BasePrimitiveString.PROPERTY_JAVA_LENGTH || name.length() == BasePrimitiveString.PROPERTY_LEN_LENGTH && BasePrimitiveString.PROPERTY_JAVA_LENGTH.equals(name)) {
			return PrimitiveStringLengthValue.getLengthValue(this.length());
		}
		for (final BaseProperty property = BaseString.PROTOTYPE.baseFindProperty(name); property != null;) {
			return property.propertyGet(this, name);
		}
		return defaultValue;
	}
	
	/** 15.5.5.1 length
	 *
	 * The number of characters in the String value represented by this String object.
	 *
	 * Once a String object is created, this property is unchanging. It has the attributes {
	 * DontEnum, DontDelete, ReadOnly }. */
	@Override
	public BaseProperty baseGetOwnProperty(final BasePrimitiveString name) {
		
		if (name == BaseString.STR_LENGTH) {
			return Base.LENGTH_PROPERTY_STRING;
		}
		return null;
	}
	
	/** @param name
	 * @return */
	@Override
	public BaseProperty baseGetOwnProperty(final CharSequence name) {
		
		return name instanceof final BasePrimitiveString primitiveString
			? this.baseGetOwnProperty(primitiveString)
			: this.baseGetOwnProperty(name.toString());
	}
	
	/** 15.5.5.1 length
	 *
	 * The number of characters in the String value represented by this String object.
	 *
	 * Once a String object is created, this property is unchanging. It has the attributes {
	 * DontEnum, DontDelete, ReadOnly }. */
	@Override
	public BaseProperty baseGetOwnProperty(final String name) {
		
		if (BasePrimitiveString.PROPERTY_JAVA_LENGTH.equals(name)) {
			return Base.LENGTH_PROPERTY_STRING;
		}
		return null;
	}
	
	/** it is not ok to use this method while knowing that this object is actually a string. */
	@Deprecated
	@Override
	public final boolean baseIsPrimitiveString() {
		
		return true;
	}
	
	@Override
	public BasePrimitiveNumber baseToInt32() {
		
		return this.baseToNumber().baseToInt32();
	}
	
	@Override
	@ReflectionHidden
	public BasePrimitiveNumber baseToInteger() {
		
		return this.baseToNumber().baseToInteger();
	}
	
	@Override
	@ReflectionHidden
	public boolean baseToJavaBoolean() {
		
		return this.length() > 0;
	}
	
	@Override
	@ReflectionHidden
	public int baseToJavaInteger() {
		
		return this.baseToNumber().intValue();
	}
	
	@Override
	@ReflectionHidden
	public long baseToJavaLong() {
		
		return this.baseToNumber().longValue();
	}
	
	/** Must override default */
	@Override
	@ReflectionHidden
	public abstract String baseToJavaString();
	
	@SuppressWarnings("deprecation")
	@Override
	public final BasePrimitive<?> baseToPrimitive(final ToPrimitiveHint hint) {
		
		return this;
	}
	
	/** it is not ok to use this method while knowing that this object is actually a string. */
	@Deprecated
	@Override
	public final BasePrimitiveString baseToString() {
		
		return this;
	}
	
	/** it is not ok to use this method while knowing that this object is actually a string. */
	@Deprecated
	@Override
	public final BasePrimitiveString baseToStringIfReady() {
		
		return this;
	}
	
	@Override
	public abstract String baseValue();
	
	@Override
	public char charAt(final int index) {
		
		return this.baseValue().charAt(index);
	}
	
	@Override
	public int compareTo(final Object o) {
		
		if (o == null) {
			return 1;
		}
		return this.stringCompare(o.toString());
	}
	
	@Override
	public double doubleValue() {
		
		return this.baseToNumber().doubleValue();
	}
	
	@Override
	public String get(final int index) {
		
		if (index < 0) {
			return null;
		}
		final String string = this.stringValue();
		if (index >= string.length()) {
			return null;
		}
		return String.valueOf(string.charAt(index));
	}
	
	@Override
	public int hashCode() {
		
		return this.baseValue().hashCode();
	}
	
	/** @param search
	 * @param fromIndex
	 * @return */
	public abstract int indexOf(String search, int fromIndex);
	
	@Override
	public int intValue() {
		
		return this.baseToNumber().intValue();
	}
	
	@Override
	public abstract boolean isEmpty();
	
	/** String length in characters
	 *
	 * @return */
	@Override
	public abstract int length();
	
	/** @param searchValue
	 * @param replaceValue
	 * @return */
	@Override
	public BasePrimitiveString replace(final CharSequence searchValue, final CharSequence replaceValue) {
		
		final String source = this.stringValue();
		final String result = source.replace(searchValue, replaceValue);
		return source == result
			? this
			: Base.forString(result);
	}
	
	@Override
	public CharSequence subSequence(final int startIndex, final int endIndex) {
		
		final String source = this.stringValue();
		final String result = source.substring(startIndex, endIndex);
		return source == result
			? this
			: Base.forString(result);
	}
	
	/** @param startIndex
	 * @param endIndex
	 * @return */
	public final BasePrimitiveString substring(final int startIndex, final int endIndex) {
		
		final String source = this.stringValue();
		final String result = source.substring(startIndex, endIndex);
		return source == result
			? this
			: Base.forString(result);
	}
	
	/** Must override java default */
	@Override
	public abstract String toString();
	
	/** @return */
	@Override
	public BasePrimitiveString trim() {
		
		final String source = this.stringValue();
		final String result = source.trim();
		return source == result
			? this
			: Base.forString(result);
	}
	
	@Override
	public ExecStateCode vmPropertyRead(final ExecProcess ctx, final BasePrimitiveString name, final BaseObject defaultValue, final ResultHandler store) {
		
		if (name == BaseString.STR_LENGTH) {
			/** support for 'length' as int and as function both */
			return store.execReturn(ctx, PrimitiveStringLengthValue.getLengthValue(this.length()));
			// return ctx.vmSetResultNumeric(this.length());
		}
		for (final BaseProperty property = BaseString.PROTOTYPE.baseFindProperty(name); property != null;) {
			return property.propertyGetCtxResult(ctx, this, name, store);
		}
		return store.execReturn(ctx, defaultValue);
	}
	
	@Override
	public ExecStateCode vmPropertyRead(final ExecProcess ctx, final int index, final BaseObject originalIfKnown, final BaseObject defaultValue, final ResultHandler store) {
		
		return store.execReturn(ctx, this.baseGet(index, defaultValue));
	}
	
	@Override
	public ExecStateCode vmPropertyRead(final ExecProcess ctx, final String name, final BaseObject defaultValue, final ResultHandler store) {
		
		if (name == BasePrimitiveString.PROPERTY_JAVA_LENGTH || name.length() == BasePrimitiveString.PROPERTY_LEN_LENGTH && BasePrimitiveString.PROPERTY_JAVA_LENGTH.equals(name)) {
			/** support for 'length' as int and as function both */
			return store.execReturn(ctx, PrimitiveStringLengthValue.getLengthValue(this.length()));
			// return ctx.vmSetResultNumeric(this.length());
		}
		for (final BaseProperty property = BaseString.PROTOTYPE.baseFindProperty(name); property != null;) {
			return store.execReturn(ctx, property.propertyGet(this, name));
		}
		return store.execReturn(ctx, defaultValue);
	}
}
