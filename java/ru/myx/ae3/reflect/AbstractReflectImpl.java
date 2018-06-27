package ru.myx.ae3.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import ru.myx.ae3.base.BaseFunction;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.base.BasePrimitiveBoolean;
import ru.myx.ae3.base.BasePrimitiveNumber;
import ru.myx.ae3.base.BasePrimitiveString;

abstract class AbstractReflectImpl {

	public abstract BaseObject classToBasePrototype(final Class<?> cls);

	public abstract ControlType<?, BaseObject> classToControlType(final Class<?> cls);

	public abstract Reflected classToReflected(final Class<?> cls);

	public abstract BaseFunction constructorToFunction(final Constructor<?> constructor);

	public abstract BaseFunction methodToFunction(final Method method);

	public abstract ControlType<Boolean, BasePrimitiveBoolean> getControlTypeExactBoolean();

	public abstract ControlType<Byte, BasePrimitiveNumber> getControlTypeExactByte();

	public abstract ControlType<Character, BasePrimitiveString> getControlTypeExactChar();

	public abstract ControlType<Double, BasePrimitiveNumber> getControlTypeExactDouble();

	public abstract ControlType<Float, BasePrimitiveNumber> getControlTypeExactFloat();

	public abstract ControlType<Integer, BasePrimitiveNumber> getControlTypeExactInteger();

	public abstract ControlType<Long, BasePrimitiveNumber> getControlTypeExactLong();

	public abstract ControlType<Number, BaseObject> getControlTypeExactNumber();

	public abstract ControlType<Short, BasePrimitiveNumber> getControlTypeExactShort();

}
