package ru.myx.ae3.base;

import ru.myx.ae3.reflect.Reflect;
import ru.myx.ae3.reflect.ReflectionExplicit;
import ru.myx.ae3.reflect.ReflectionManual;

/** Base Error Fixed Properties
 *
 *
 * @author myx */
@ReflectionManual
public interface BaseError extends BaseObjectNotDynamic {

	/**
	 *
	 */
	BaseObject PROTOTYPE = Reflect.classToBasePrototype(BaseError.class);

	/** The value of the [[Class]] property is defined by this specification for every kind of
	 * built-in object. The value of the [[Class]] property of a host object may be any value, even
	 * a value used by a built-in object for its [[Class]] property. The value of a [[Class]]
	 * property is used internally to distinguish different kinds of built-in objects. Note that
	 * this specification does not provide any means for a program to access that value except
	 * through Object.prototype.toString (see 15.2.4.2).
	 *
	 * @return class */
	@Override
	default String baseClass() {

		return "Error";
	}

	@Override
	default BaseProperty baseGetOwnProperty(final BasePrimitiveString name) {

		return null;
	}

	@Override
	default BaseProperty baseGetOwnProperty(final String name) {

		return null;
	}

	@Override
	default BaseObject basePrototype() {

		return BaseError.PROTOTYPE;
	}

	@Override
	default Object baseValue() {

		return this;
	}

	/** @return */
	@ReflectionExplicit
	default Throwable getCause() {

		return null;
	}

	/** @return */
	@ReflectionExplicit
	String getMessage();

	/** @return */
	@ReflectionExplicit
	Object getMessageContent();
}
