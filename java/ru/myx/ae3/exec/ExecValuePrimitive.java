package ru.myx.ae3.exec;

import ru.myx.ae3.base.BaseObjectNoOwnProperties;
import ru.myx.ae3.base.BasePrimitive;
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
interface ExecValuePrimitive<T> extends BasePrimitive<T>, BaseObjectNoOwnProperties {
	//
}
