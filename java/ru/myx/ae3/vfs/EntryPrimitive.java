package ru.myx.ae3.vfs;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.know.Guid;
import ru.myx.ae3.reflect.Reflect;
import ru.myx.ae3.reflect.ReflectionExplicit;
import ru.myx.ae3.reflect.ReflectionHidden;
import ru.myx.ae3.reflect.ReflectionManual;

/** @author myx */
@ReflectionManual
public interface EntryPrimitive extends Entry {

	/**
	 *
	 */
	@ReflectionExplicit
	static BaseObject PROTOTYPE = Reflect.classToBasePrototype(EntryPrimitive.class);

	/** Works when isPrimitive() method returns TRUE.
	 *
	 * Value is always immediately available, so return type is Guid.
	 *
	 * @return */
	@ReflectionExplicit
	Guid getPrimitiveGuid();

	/** Works when isPrimitive() method returns TRUE.
	 *
	 * Value is always immediately available, so return type is Object.
	 *
	 * @return */
	@ReflectionHidden
	Object getPrimitiveValue();

	/** Version for scripting
	 *
	 * @param ctx
	 * @return */
	@ReflectionExplicit
	BaseObject getPrimitiveValue(final ExecProcess ctx);

	@Override
	default boolean isPrimitive() {

		return true;
	}

	@Override
	default EntryPrimitive toPrimitive() {

		return this;
	}
}
