package ru.myx.ae3.exec;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseNumber;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.base.BasePrimitive;
import ru.myx.ae3.base.BasePrimitiveBoolean;
import ru.myx.ae3.base.BasePrimitiveNumber;
import ru.myx.ae3.base.BasePrimitiveString;
import ru.myx.ae3.base.BaseProperty;
import ru.myx.ae3.base.ToPrimitiveHint;
import ru.myx.ae3.reflect.ReflectionHidden;
import ru.myx.ae3.reflect.ReflectionIgnore;

@ReflectionIgnore
final class ValueDirectLong extends Number implements BaseNumber<Number>, ExecValueDirect<Number>, ExecValuePrimitive<Number> {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8147435374323547706L;
	
	private long number;
	
	ValueDirectLong(final long value) {
		
		this.number = value;
	}
	
	@Override
	public BaseProperty baseFindProperty(BasePrimitiveString name) {
		
		
		return BaseNumber.PROTOTYPE.baseFindProperty(name);
	}
	
	@Override
	public BaseProperty baseFindProperty(BasePrimitiveString name, BaseObject stop) {
		
		
		return BaseNumber.PROTOTYPE.baseFindProperty(name, stop);
	}
	
	@Override
	public BaseProperty baseFindProperty(String name) {
		
		
		return BaseNumber.PROTOTYPE.baseFindProperty(name);
	}
	
	@Override
	public BaseProperty baseFindProperty(String name, BaseObject stop) {
		
		
		return BaseNumber.PROTOTYPE.baseFindProperty(name, stop);
	}
	
	@Override
	public boolean baseIsPrimitiveInteger() {
		
		
		return true;
	}
	
	@Override
	public boolean baseIsPrimitiveNumber() {
		
		
		return true;
	}
	
	@Override
	public BasePrimitiveBoolean baseToBoolean() {
		
		
		return this.number == 0
			? BaseObject.FALSE
			: BaseObject.TRUE;
	}
	
	@Override
	public BasePrimitiveNumber baseToInt32() {
		
		
		return Base.forInteger((int) this.number);
	}
	
	@Override
	public BasePrimitiveNumber baseToInteger() {
		
		
		return Base.forLong(this.number);
	}
	
	@Override
	@ReflectionHidden
	public boolean baseToJavaBoolean() {
		
		
		return this.longValue() != 0;
	}
	
	@Override
	@ReflectionHidden
	public int baseToJavaInteger() {
		
		
		return (int) this.number;
	}
	
	@Override
	@ReflectionHidden
	public long baseToJavaLong() {
		
		
		return this.number;
	}
	
	@Override
	public BasePrimitiveNumber baseToNumber() {
		
		
		return Base.forLong(this.number);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public BasePrimitive<Number> baseToPrimitive(ToPrimitiveHint hint) {
		
		
		return this;
	}
	
	@Override
	public BasePrimitiveString baseToString() {
		
		
		return Base.forString(this.number);
	}
	
	@Override
	public final BasePrimitiveString baseToStringIfReady() {
		
		
		return null;
	}
	
	@Override
	public Number baseValue() {
		
		
		return this;
	}
	
	@Override
	public final byte byteValue() {
		
		
		return (byte) this.number;
	}
	
	@Override
	public double doubleValue() {
		
		
		return this.number;
	}
	
	@Override
	public float floatValue() {
		
		
		return this.number;
	}
	
	@Override
	public int intValue() {
		
		
		return (int) this.number;
	}
	
	@Override
	public long longValue() {
		
		
		return this.number;
	}
	
	public final ExecValueDirect<?> setValue(final long number) {
		
		
		this.number = number;
		return this;
	}
	
	@Override
	public final short shortValue() {
		
		
		return (short) this.number;
	}
	
	@Override
	public String stringValue() {
		
		
		return Base.toString(this.number);
	}
	
	@Override
	public BaseObject toDetached(final ExecProcess ctx) {
		
		
		if (ctx.rzDirectLong == this) {
			ctx.rzDirectLong = null;
		}
		return this;
	}
	
	@Override
	public BaseObject toNative() {
		
		
		return Base.forLong(this.number);
	}
	
	@Override
	public String toString() {
		
		
		return Base.toString(this.number);
	}
	
}
