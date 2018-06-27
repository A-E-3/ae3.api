package ru.myx.ae3.base;

import ru.myx.ae3.common.Value;
import ru.myx.ae3.reflect.ReflectionDisable;

/**
 *
 * BaseWrapAbstract is intended for wrapping of non-base java objects.
 *
 * The reason for it's existence is that it has reference implementation for
 * most of base object's methods.
 *
 *
 * Abstract 'wrapped java object' object WITH own properties by design, see
 * BaseWrapAbstract for one with NO own properties.
 *
 * Only 2 abstract methods: baseValue & toString.
 *
 * @author myx
 *
 * @param <T>
 */
@ReflectionDisable
public abstract class BaseWrapObjectAbstract<T extends Object> extends BaseEditableAbstract implements Value<T> {
	
	@Override
	public abstract T baseValue();
	
	/**
	 * Prototype object
	 */
	protected BaseObject prototype;
	
	/**
	 * @param prototype
	 */
	public BaseWrapObjectAbstract(final BaseObject prototype) {
		this.prototype = prototype;
	}
	
	@Override
	public String baseClass() {
		
		return this.getClass().getSimpleName();
	}
	
	/**
	 * overrides default iterator implementation.
	 */
	@Override
	public void baseClear() {
		
		this.properties = null;
	}
	
	@Override
	public boolean baseIsExtensible() {
		
		return true;
	}
	
	@Override
	public BaseObject basePrototype() {
		
		return this.prototype;
	}
	
	@Override
	public abstract String toString();
}
