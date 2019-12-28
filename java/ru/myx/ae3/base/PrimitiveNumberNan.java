/**
 * 
 */
package ru.myx.ae3.base;

import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/**
 * @author myx
 * 
 */
@ReflectionDisable
final class PrimitiveNumberNan extends BasePrimitiveNumber {
	
	
	private static final Double NaN = Double.valueOf(Double.NaN);
	
	private static final long serialVersionUID = 5560896981483738379L;
	
	PrimitiveNumberNan() {
		//
	}
	
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
	public final BasePrimitiveString baseToString() {
		
		
		return BaseString.STR_NAN;
	}
	
	@Override
	public final BasePrimitiveString baseToStringIfReady() {
		
		
		return BaseString.STR_NAN;
	}
	
	@Override
	public Number baseValue() {
		
		
		return PrimitiveNumberNan.NaN;
	}
	
	@Override
	public double doubleValue() {
		
		
		return Double.NaN;
	}
	
	@Override
	public float floatValue() {
		
		
		return Float.NaN;
	}
	
	@Override
	public final int hashCode() {
		
		
		return this.baseValue().hashCode();
	}
	
	@Override
	public int intValue() {
		
		
		return 0;
	}
	
	@Override
	public long longValue() {
		
		
		return 0L;
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
	public boolean baseToJavaBoolean() {
		
		
		return true;
	}
	
	@Override
	public String baseToJavaString() {
		
		
		return BaseString.STR_NAN.baseToJavaString();
	}
}
