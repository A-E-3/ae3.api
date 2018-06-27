/**
 *
 */
package ru.myx.ae3.base;

import ru.myx.ae3.common.Value;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/**
 * 4.3.2 Primitive Value
 * <p>
 * A primitive value is a member of one of the types Undefined, Null, Boolean,
 * Number, or String. A primitive value is a datum that is represented directly
 * at the lowest level of the language implementation.
 * <p>
 *
 *
 * Все примитивные объекты определены в этом пакеты, они должны наследовать этот
 * класс. Над всеми примитвными типамы определены алгоритмы выполнения операций
 * JavaScript, при столкновении с непримитивными объектами многие операции
 * предварительно явно преобразовывают в примитивный тип.
 * <p>
 *
 * При этом все примитивные типы не имеют свойств и данный класс определяет
 * реализацию методов связанных с работой со свойствами объекта.
 * <p>
 *
 * Класс не имеет публичного конструктора, так как создания наследников этого
 * класса вне пакета не предусмотрено.
 * <p>
 *
 * Также определяется преобразование toString() как:
 *
 * <pre>
 *
 * public String toString() {
 * 	
 * 	return this.baseToJavaString();
 * }
 * </pre>
 *
 * @author myx
 *
 * @param <T>
 */
@ReflectionDisable
public interface BasePrimitive<T> extends BaseObject, Value<T> {
	
	/**
	 * @return string
	 */
	BasePrimitiveString baseToStringIfReady();

	/**
	 * @return
	 */
	double doubleValue();

	/**
	 * @return
	 */
	int intValue();

	/**
	 * @return
	 */
	long longValue();

	/**
	 * it is not ok to use this method while knowing that this object is
	 * actually a primitive.
	 *
	 * @return TRUE
	 */
	@Deprecated
	@Override
	@ReflectionHidden
	default boolean baseIsPrimitive() {
		
		return true;
	}

	@Override
	@ReflectionHidden
	default int baseToJavaInteger() {
		
		return this.intValue();
	}

	@Override
	@ReflectionHidden
	default long baseToJavaLong() {
		
		return this.longValue();
	}

	@Override
	@ReflectionHidden
	default String baseToJavaString() {
		
		return this.stringValue();
	}

	/**
	 * @return
	 */
	String stringValue();
	
	/**
	 * Already a primitive
	 *
	 * it is not ok to use this method while knowing that this object is
	 * actually a number.
	 */
	@Deprecated
	@Override
	@ReflectionHidden
	default BasePrimitive<?> baseToPrimitive(final ToPrimitiveHint hint) {
		
		return this;
	}

	@Override
	T baseValue();
}
