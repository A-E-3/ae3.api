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
 * Abstract 'wrapped java object' object with NO own properties by design, see
 * BaseWrapObjectAbstract for one WITH own properties.
 * 
 * Only 2 abstract methods: baseValue & toString.
 * 
 * @author myx
 * 
 * @param <T>
 */
@ReflectionDisable
public abstract class BaseWrapEmptyAbstract<T extends Object> extends BaseAbstract implements Value<T>, BaseObjectNoOwnProperties {
	
	
	/**
	 * For 'Wrap' objects, baseValue() must return wrapped object and never
	 * return 'this' reference.
	 * 
	 * @return internal
	 */
	@Override
	public abstract T baseValue();
	
	@Override
	public abstract String toString();
}
