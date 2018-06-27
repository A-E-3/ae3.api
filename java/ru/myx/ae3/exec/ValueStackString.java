package ru.myx.ae3.exec;

import java.io.Serializable;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.base.BasePrimitive;
import ru.myx.ae3.base.BasePrimitiveBoolean;
import ru.myx.ae3.base.BasePrimitiveNumber;
import ru.myx.ae3.base.BasePrimitiveString;
import ru.myx.ae3.base.BaseProperty;
import ru.myx.ae3.base.BaseString;
import ru.myx.ae3.base.ToPrimitiveHint;
import ru.myx.ae3.reflect.ReflectionHidden;
import ru.myx.ae3.reflect.ReflectionIgnore;

/**
 * TODO: BaseArray???
 * 
 * @author myx
 * 
 */
@ReflectionIgnore
final class ValueStackString implements ExecValueStack<String>, ExecValuePrimitive<String>, BaseString<String>, Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8147435374323547706L;
	
	private String string;
	
	ValueStackString(final String value) {
		
		this.string = value;
	}
	
	@Override
	public BaseProperty baseFindProperty(BasePrimitiveString name) {
		
		
		return BaseString.PROTOTYPE.baseFindProperty(name);
	}
	
	@Override
	public BaseProperty baseFindProperty(BasePrimitiveString name, BaseObject stop) {
		
		
		return BaseString.PROTOTYPE.baseFindProperty(name, stop);
	}
	
	@Override
	public BaseProperty baseFindProperty(String name) {
		
		
		return BaseString.PROTOTYPE.baseFindProperty(name);
	}
	
	@Override
	public BaseProperty baseFindProperty(String name, BaseObject stop) {
		
		
		return BaseString.PROTOTYPE.baseFindProperty(name, stop);
	}
	
	@Override
	public BaseObject baseGet(final int index, final BaseObject defaultValue) {
		
		
		if (index < 0) {
			return defaultValue;
		}
		final CharSequence string = this.string;
		if (index >= string.length()) {
			return defaultValue;
		}
		return Base.forChar(string.charAt(index));
	}
	
	@Override
	public ExecStateCode vmPropertyRead(final ExecProcess ctx, final int index, final BaseObject originalIfKnown, final BaseObject defaultValue, final ResultHandler store) {
		
		
		if (index < 0) {
			return store.execReturn(ctx, defaultValue);
		}
		final CharSequence string = this.string;
		if (index >= string.length()) {
			return store.execReturn(ctx, defaultValue);
		}
		return store.execReturnChar(ctx, string.charAt(index));
	}
	
	@Override
	public boolean baseIsPrimitiveString() {
		
		
		return true;
	}
	
	@Override
	public BasePrimitiveBoolean baseToBoolean() {
		
		
		return this.string.length() == 0
			? BaseObject.FALSE
			: BaseObject.TRUE;
	}
	
	@Override
	public BasePrimitiveNumber baseToInt32() {
		
		
		return Base.forInteger((int) (long) Base.toDouble(this.string));
	}
	
	@Override
	public BasePrimitiveNumber baseToInteger() {
		
		
		return Base.forLong((long) Base.toDouble(this.string));
	}
	
	@Override
	public BasePrimitiveNumber baseToNumber() {
		
		
		return Base.forDouble(this.string);
	}
	
	@Override
	public BasePrimitiveString baseToString() {
		
		
		return Base.forString(this.string);
	}
	
	@Override
	public final BasePrimitiveString baseToStringIfReady() {
		
		
		return null;
	}
	
	@Override
	public String baseValue() {
		
		
		return this.string;
	}
	
	@Override
	public char charAt(final int index) {
		
		
		return this.string.charAt(index);
	}
	
	@Override
	public double doubleValue() {
		
		
		return Base.toDouble(this.string);
	}
	
	@Override
	public boolean equals(final Object obj) {
		
		
		return this == obj || obj instanceof CharSequence && this.string.contentEquals((CharSequence) obj);
	}
	
	@Override
	public String get(final int index) {
		
		
		if (index < 0) {
			return null;
		}
		final CharSequence string = this.string;
		if (index >= string.length()) {
			return null;
		}
		return String.valueOf(string.charAt(index));
	}
	
	@Override
	public int hashCode() {
		
		
		return this.string.hashCode();
	}
	
	@Override
	public int intValue() {
		
		
		return (int) this.doubleValue();
	}
	
	@Override
	public long longValue() {
		
		
		return (long) this.doubleValue();
	}
	
	@Override
	public boolean isEmpty() {
		
		
		return this.string.length() == 0;
	}
	
	@Override
	public int length() {
		
		
		return this.string.length();
	}
	
	public final ExecValueStack<?> setValue(final String string) {
		
		
		this.string = string;
		return this;
	}
	
	@Override
	@ReflectionHidden
	public String baseToJavaString() {
		
		
		return this.string;
	}
	
	@Override
	public String stringValue() {
		
		
		return this.string;
	}
	
	@Override
	public CharSequence subSequence(final int start, final int end) {
		
		
		return this.string.subSequence(start, end);
	}
	
	@Override
	public BaseObject toNative() {
		
		
		return Base.forString(this.string);
	}
	
	@Override
	public String toString() {
		
		
		return this.string;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public BasePrimitive<?> baseToPrimitive(ToPrimitiveHint hint) {
		
		
		return this;
	}
	
}
