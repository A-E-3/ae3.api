/**
 *
 */
package ru.myx.ae3.base;

import ru.myx.ae3.AbstractSAPI;
import ru.myx.ae3.reflect.ReflectionDisable;

/**
 * @author myx
 *
 */
@ReflectionDisable
public abstract class BasePrimitiveBoolean extends BasePrimitiveAbstract<Boolean> {

	static {
		assert AbstractSAPI.logDebug("BasePrimitiveBoolean: static init.");
	}

	/**
	 * Boolean.prototype
	 */
	public static final BaseObject PROTOTYPE = BaseObject.createObject(BaseObject.PROTOTYPE);
	
	/**
	 * non-public method
	 */
	BasePrimitiveBoolean() {
		//
	}
	
	@Override
	public final String baseClass() {
		
		return "boolean";
	}
	
	@Override
	public final boolean baseIsPrimitiveBoolean() {
		
		return true;
	}
	
	@Override
	public final BaseObject basePrototype() {
		
		return BasePrimitiveBoolean.PROTOTYPE;
	}
	
	@Override
	public final BasePrimitiveBoolean baseToBoolean() {
		
		return this;
	}
	
	/**
	 * @return
	 */
	public abstract BasePrimitiveBoolean baseToBooleanXorTrue();
	
	/**
	 * Return tyoe is Boolean
	 */
	@Override
	public abstract Boolean baseValue();
	
	/**
	 * @return
	 */
	public abstract Boolean baseValueXorTrue();
	
	/**
	 * @return
	 */
	public abstract boolean booleanValue();
	
	/**
	 * @return
	 */
	public abstract boolean booleanValueXorTrue();
	
}
