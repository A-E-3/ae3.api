package ru.myx.ae3.exec;


import ru.myx.ae3.base.BaseObject;
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
interface ExecValueDirect<T> extends ExecValueStack<T> {
	
	
	/**
	 * Detaches this value from given context. Like when we want to put this
	 * value on stack but still in non-default optimized form preferably.
	 * 
	 * @param ctx
	 * @return
	 */
	@ReflectionHidden
	BaseObject toDetached(final ExecProcess ctx);
	
}
