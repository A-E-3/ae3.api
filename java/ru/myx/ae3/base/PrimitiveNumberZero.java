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
final class PrimitiveNumberZero extends PrimitiveNumberIntegerAbstract {
	
	
	private static final Number NUMBER_ZERO = Integer.valueOf(0);
	
	private static final long serialVersionUID = -8109008218110410060L;
	
	PrimitiveNumberZero() {
		//
	}
	
	@Override
	public final BasePrimitiveBoolean baseToBoolean() {
		
		
		return BaseObject.FALSE;
	}
	
	@Override
	public final BasePrimitiveString baseToString() {
		
		
		return BaseString.STR_ZERO;
	}
	
	@Override
	public final BasePrimitiveString baseToStringIfReady() {
		
		
		return BaseString.STR_ZERO;
	}
	
	@Override
	public final Number baseValue() {
		
		
		return PrimitiveNumberZero.NUMBER_ZERO;
	}
	
	@Override
	public double doubleValue() {
		
		
		return 0.0;
	}
	
	@Override
	public float floatValue() {
		
		
		return 0.0f;
	}
	
	@Override
	public int hashCode() {
		
		
		return 0;
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
		
		
		return false;
	}
	
	@Override
	@ReflectionHidden
	public String baseToJavaString() {
		
		
		return BaseString.STR_ZERO.baseToJavaString();
	}
	
	@Override
	public final String stringValue() {
		
		
		return BaseString.STR_ZERO.toString();
	}
}
