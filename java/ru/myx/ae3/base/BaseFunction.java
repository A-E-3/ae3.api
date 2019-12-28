package ru.myx.ae3.base;



import ru.myx.ae3.exec.ExecCallable;
import ru.myx.ae3.reflect.ReflectionDisable;

/** @author myx
 *
 *         Both parameters meant to be one parameter, but java generics will fail actual
 *         implementations with 'cannot implement ...' when actually it is not the case. */
@ReflectionDisable
public interface BaseFunction extends BaseObject, ExecCallable {

	/**
	 *
	 */
	BaseObject PROTOTYPE = BaseObject.createObject(BaseObject.PROTOTYPE);
	
	/** The fastest and most universal 'return undefined;' possible.
	 *
	 * Equivalent to:
	 *
	 * function(){}
	 *
	 * OR/AND
	 *
	 * function(){ return undefined; } */
	BaseFunction RETURN_UNDEFINED = new FunctionReturnUndefined();
	
	/** The fastest and most universal 'return null;' possible.
	 *
	 * Equivalent to:
	 *
	 * function(){ return null; } */
	BaseFunction RETURN_NULL = new FunctionReturnNull();
	
	/** @param instance
	 * @return */
	default BaseFunction baseBind(final BaseObject instance) {

		return Base.bindFunction(this, instance);
	}
	
	/** @param instance
	 * @param argument
	 * @return */
	default BaseFunction baseBind(final BaseObject instance, final BaseObject argument) {

		return Base.bindFunction(this, instance, argument);
	}
	
	/** @param instance
	 * @param arguments
	 * @return */
	default BaseFunction baseBind(final BaseObject instance, final BaseObject... arguments) {

		return Base.bindFunction(this, instance, arguments);
	}
	
	/** @param instance
	 * @param argument1
	 * @param argument2
	 * @return */
	default BaseFunction baseBind(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

		return Base.bindFunction(this, instance, argument1, argument2);
	}
	
	/** returns this by default */
	@Override
	default BaseFunction baseCall() {

		return this;
	}
	
	/** "prototype" property of function used to create new objects
	 *
	 * @return */
	
	default BaseObject baseConstructPrototype() {

		final BaseFunction constructor = this.baseConstruct();
		if (constructor == null) {
			/** instead of TypeError */
			return null;
		}
		if (constructor != this) {
			{
				final BaseObject prototype = constructor.baseConstructPrototype();
				if (prototype != null && !(prototype instanceof BasePrimitive)) {
					return prototype;
				}
			}
			{
				final BaseObject prototype = this.baseGet(BaseString.STR_PROTOTYPE, null);
				if (prototype != null && !(prototype instanceof BasePrimitive)) {
					return prototype;
				}
			}
		}
		{
			final BaseObject prototype = constructor.baseGet(BaseString.STR_PROTOTYPE, null);
			if (prototype != null && !(prototype instanceof BasePrimitive)) {
				return prototype;
			}
		}
		/** instead of error */
		return null;
	}
	
	/** Returns a boolean value indicating whether Value delegates behaviour to this object. Of the
	 * native ECMAScript objects, only Function objects implement [[HasInstance]].
	 *
	 * 15.3.5.3 [[HasInstance]] (V)
	 *
	 * <pre>
	 * Assume F is a Function object.
	 * When the [[HasInstance]] internal method of F is called with value V, the following steps are taken:
	 * 1.	If V is not an object, return false.
	 * 2.	Let O be the result of calling the [[Get]] internal method of F with property name "prototype".
	 * 3.	If Type(O) is not Object, throw a TypeError exception.
	 * 4.	Repeat
	 * 		a.	Let V be the value of the [[Prototype]] internal property of V.
	 * 		b.	If V is null, return false.
	 * 		c.	If O and V refer to the same object, return true.
	 * </pre>
	 *
	 * Function objects created using Function.prototype.bind have a different implementation of
	 * [[HasInstance]] defined in 15.3.4.5.3.
	 *
	 * @param value
	 * @return boolean */
	default boolean baseHasInstance(final BaseObject value) {

		final BaseObject prototype = this.baseConstructPrototype();
		if (prototype == null) {
			/** instead of TypeError */
			return false;
		}
		for (BaseObject check = value.basePrototype(); check != null;) {
			if (check == prototype) {
				return true;
			}
			check = check.basePrototype();
		}
		return false;
	}
	
	@Override
	default BaseObject basePrototype() {

		return BaseFunction.PROTOTYPE;
	}
}
