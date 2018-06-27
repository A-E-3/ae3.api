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
final class ValueStackNumber extends Number implements BaseNumber<Number>, ExecValueStack<Number>, ExecValuePrimitive<Number> {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8147435374323547706L;
	
	private double number;
	
	ValueStackNumber(final double value) {
		
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
		
		
		return this.number == (long) this.number;
	}
	
	@Override
	public boolean baseIsPrimitiveNumber() {
		
		
		return true;
	}
	
	@Override
	public final BasePrimitiveBoolean baseToBoolean() {
		
		
		return this.number == 0 || Double.isNaN(this.number)
			? BaseObject.FALSE
			: BaseObject.TRUE;
	}
	
	@Override
	public final BasePrimitiveNumber baseToInt32() {
		
		
		return Base.forInteger((int) (long) this.number);
	}
	
	@Override
	public final BasePrimitiveNumber baseToInteger() {
		
		
		return Base.forLong((long) this.number);
	}
	
	@Override
	@ReflectionHidden
	public boolean baseToJavaBoolean() {
		
		
		return this.doubleValue() != 0;
	}
	
	@Override
	@ReflectionHidden
	public int baseToJavaInteger() {
		
		
		return (int) (long) this.number;
	}
	
	@Override
	@ReflectionHidden
	public long baseToJavaLong() {
		
		
		return (long) this.number;
	}
	
	@Override
	public final BasePrimitiveNumber baseToNumber() {
		
		
		return Base.forDouble(this.number);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public final BasePrimitive<Number> baseToPrimitive(final ToPrimitiveHint hint) {
		
		
		return Double.isNaN(this.number)
			? BasePrimitiveNumber.NAN
			: this;
	}
	
	@Override
	public final BasePrimitiveString baseToString() {
		
		
		return Base.forString(this.number);
	}
	
	@Override
	public final BasePrimitiveString baseToStringIfReady() {
		
		
		return null;
	}
	
	@Override
	public final Number baseValue() {
		
		
		return this;
	}
	
	@Override
	public final byte byteValue() {
		
		
		return (byte) this.number;
	}
	
	@Override
	public final double doubleValue() {
		
		
		return this.number;
	}
	
	@Override
	public final float floatValue() {
		
		
		return (float) this.number;
	}
	
	@Override
	public final int intValue() {
		
		
		return (int) (long) this.number;
	}
	
	@Override
	public final long longValue() {
		
		
		return (long) this.number;
	}
	
	public final ExecValueStack<?> setValue(final double number) {
		
		
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
	public BaseObject toNative() {
		
		
		return Base.forDouble(this.number);
	}
	
	@Override
	public String toString() {
		
		
		return Base.toString(this.number);
	}
	
}
