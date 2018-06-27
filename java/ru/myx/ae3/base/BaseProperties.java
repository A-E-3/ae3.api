package ru.myx.ae3.base;

import java.util.Iterator;

import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/**
 *
 * @author myx
 *
 * @param <K>
 */
@ReflectionDisable
public interface BaseProperties<K> {

	/**
	 * iterator() method should not ever return NULL, return this value at
	 * least.
	 */
	@SuppressWarnings("unchecked")
	@ReflectionHidden
	Iterator<BasePrimitiveString> ITERATOR_EMPTY_PRIMITIVE_STRING = (Iterator<BasePrimitiveString>) IteratorEmpty.INSTANCE;

	/**
	 * @param instance
	 * @param name
	 * @param property
	 * @param attributes
	 * @return same or new props
	 */
	BaseProperties<K> add(BaseObject instance, BasePrimitiveString name, BaseProperty property, short attributes);

	/**
	 * @param instance
	 *            TODO
	 * @param name
	 * @param property
	 * @param attributes
	 * @return same or new props
	 */
	BaseProperties<K> add(BaseObject instance, String name, BaseProperty property, short attributes);

	/**
	 * @param name
	 * @param value
	 * @param attributes
	 * @return same or new props
	 */
	BaseProperties<K> add(BasePrimitiveString name, BaseObject value, short attributes);

	/**
	 * @param name
	 * @param property
	 * @return same or new props
	 */
	BaseProperties<K> add(BasePrimitiveString name, BasePropertyData<K> property);

	/**
	 * @param name
	 * @param value
	 * @param attributes
	 * @return same or new props
	 */
	BaseProperties<K> add(String name, BaseObject value, short attributes);

	/**
	 * @param name
	 * @param property
	 * @return same or new props
	 */
	BaseProperties<K> add(String name, BasePropertyData<K> property);

	/**
	 * @param name
	 * @return same or new props
	 */
	BaseProperties<K> delete(BasePrimitiveString name);

	/**
	 * @param name
	 * @return same or new props
	 */
	BaseProperties<K> delete(String name);

	/**
	 *
	 * @param name
	 * @return
	 */
	BasePropertyData<K> find(BasePrimitiveString name);

	/**
	 *
	 * @param name
	 * @return
	 */
	BasePropertyData<K> find(CharSequence name);

	/**
	 *
	 * @param name
	 * @return
	 */
	BasePropertyData<K> find(String name);

	/**
	 *
	 * @return
	 */
	boolean hasEnumerableProperties();

	/**
	 *
	 * @return
	 */
	Iterator<? extends CharSequence> iteratorAll();

	/**
	 *
	 * @return
	 */
	Iterator<BasePrimitiveString> iteratorAllAsPrimitive();

	/**
	 *
	 * @return
	 */
	Iterator<String> iteratorAllAsString();

	/**
	 *
	 * @return
	 */
	Iterator<? extends CharSequence> iteratorEnumerable();

	/**
	 *
	 * @return
	 */
	Iterator<BasePrimitiveString> iteratorEnumerableAsPrimitive();

	/**
	 *
	 * @return
	 */
	Iterator<String> iteratorEnumerableAsString();

	/**
	 * not really used - just for fun / because we can
	 *
	 * @return
	 */
	int size();
	
	/**
	 * @param instance
	 * @param key
	 * @param property
	 * @param attributes
	 * @return
	 */
	static BaseProperties<?> createFirstProperty(final BaseObject instance, final BasePrimitiveString key, final BaseProperty property, final short attributes) {

		return Base.OBJECT_FACTORY.createFirstProperty(instance, key, property, attributes);
	}
	
	/**
	 * @param instance
	 * @param key
	 * @param property
	 * @param attributes
	 * @return
	 */
	static BaseProperties<?> createFirstProperty(final BaseObject instance, final String key, final BaseProperty property, final short attributes) {

		return Base.OBJECT_FACTORY.createFirstProperty(instance, key, property, attributes);
	}
	
	/**
	 * @param key
	 * @param value
	 * @param attributes
	 * @return
	 */
	static BaseProperties<?> createFirstProperty(final BasePrimitiveString key, final BaseObject value, final short attributes) {

		return Base.OBJECT_FACTORY.createFirstProperty(key, value, attributes);
	}
	
	/**
	 * @param key
	 * @param value
	 * @param attributes
	 * @return
	 */
	static BaseProperties<?> createFirstProperty(final String key, final BaseObject value, final short attributes) {

		return Base.OBJECT_FACTORY.createFirstProperty(key, value, attributes);
	}
}
