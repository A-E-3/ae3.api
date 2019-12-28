package ru.myx.ae3.base;

import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/**
 * @author myx
 * 
 */
@ReflectionDisable
final class PrimitiveNumberOne extends PrimitiveNumberIntegerAbstract {
	
	
	private static final long serialVersionUID = 6777998057139262710L;
	
	private static final Long ONE = Long.valueOf(1L);
	
	@Override
	public final BasePrimitiveString baseToString() {
		
		
		return BaseString.STR_ONE;
	}
	
	@Override
	public final BasePrimitiveString baseToStringIfReady() {
		
		
		return BaseString.STR_ONE;
	}
	
	@Override
	public final Number baseValue() {
		
		
		return PrimitiveNumberOne.ONE;
	}
	
	@Override
	public double doubleValue() {
		
		
		return 1.0;
	}
	
	@Override
	public float floatValue() {
		
		
		return 1.0f;
	}
	
	@Override
	public int hashCode() {
		
		
		return 1;
	}
	
	@Override
	public int intValue() {
		
		
		return 1;
	}
	
	@Override
	public long longValue() {
		
		
		return 1L;
	}
	
	@Override
	@ReflectionHidden
	public int baseToJavaInteger() {
		
		
		return 1;
	}
	
	@Override
	@ReflectionHidden
	public long baseToJavaLong() {
		
		
		return 1L;
	}
	
	@Override
	@ReflectionHidden
	public boolean baseToJavaBoolean() {
		
		
		return true;
	}
	
	@Override
	@ReflectionHidden
	public String baseToJavaString() {
		
		
		return BaseString.STR_ONE.baseToJavaString();
	}
	
	@Override
	public final String stringValue() {
		
		
		return BaseString.STR_ONE.stringValue();
	}
}
