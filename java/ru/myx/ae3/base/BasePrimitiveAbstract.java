/**
 * 
 */
package ru.myx.ae3.base;

import ru.myx.ae3.reflect.ReflectionDisable;

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
abstract class BasePrimitiveAbstract<T> implements BasePrimitive<T>, BaseObjectNoOwnProperties {
	
	
	/**
	 * non-public method
	 */
	BasePrimitiveAbstract() {
		//
	}
	
	@Override
	public abstract BasePrimitiveString baseToString();
	
	@Override
	public abstract boolean equals(final Object o);
	
	@Override
	public abstract int hashCode();
	
	@Override
	public abstract String toString();
	
}
