package ru.myx.ae3.exec;

import com.sun.istack.internal.NotNull;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.common.Value;
import ru.myx.ae3.reflect.ReflectionHidden;
import ru.myx.ae3.reflect.ReflectionIgnore;

/**
 * 
 * exec's package values can be represented as 'fake', faster then native,
 * objects. internally they are handled well (vm operations and stack, etc...),
 * but when interfacing with outside world, like unknown function calls and
 * external object properties, it is needed to ensure that those values are
 * safe.
 * 
 * @author myx
 * 
 * @param <T>
 */
@ReflectionIgnore
interface ExecValueStack<T> extends BaseObject, Value<T> {
	
	
	@Override
	T baseValue();
	
	/**
	 * Returns proper 'native' form as it supposed to be without internal
	 * optimizations.
	 * 
	 * @return
	 */
	// @Override
	@NotNull
	@ReflectionHidden
	BaseObject toNative();
	
}
