package ru.myx.ae3.base;

import java.util.Iterator;
import java.util.List;

import ru.myx.ae3.reflect.ReflectionHidden;
import ru.myx.ae3.reflect.ReflectionIgnore;

/**
 *
 * @author myx
 * @param <T>
 */
@ReflectionIgnore
public interface BaseList<T> extends BaseArrayDynamic<T>, List<T> {
	//

	// static Supplier<BaseList<Object>> ARRAY_DEFAULT_SUPPLIER = null;

	// static IntFunction<BaseList<?>> ARRAY_BY_SIZE_FUNCTION = null;

	/**
	 * Creates default extensible unsealed array object just like '[]' will do
	 * in the script
	 *
	 *
	 *
	 * Alias for BaseList.create();
	 *
	 * @return
	 */
	// @SuppressWarnings("unchecked")
	@ReflectionHidden
	static <T> BaseList<T> create() {
		
		
		return Base.OBJECT_FACTORY.createArray();
		/**
		 * try { return (BaseList<T>) Base.OF_CLS_BASE_LIST.newInstance(); }
		 * catch (InstantiationException | IllegalAccessException e) { throw new
		 * RuntimeException("BaseObject: array factory failure", e); }
		 */
	}

	/**
	 * Creates default extensible unsealed array object just like '[]' will do
	 * in the script
	 *
	 *
	 *
	 * Alias for BaseList.create();
	 *
	 * @param expectedLength
	 * @return
	 */
	// @SuppressWarnings("unchecked")
	@ReflectionHidden
	static <T> BaseList<T> create(final int expectedLength) {
		
		
		return Base.OBJECT_FACTORY.createArray(expectedLength);
		/**
		 * try { return (BaseList<T>) Base.OF_CLS_BASE_LIST.newInstance(); }
		 * catch (InstantiationException | IllegalAccessException e) { throw new
		 * RuntimeException("BaseObject: array factory failure", e); }
		 */
	}
	
	@Override
	default boolean isEmpty() {
		
		
		return this.length() == 0;
	}
	
	@Override
	default Iterator<T> iterator() {
		
		
		return BaseArrayDynamic.super.iterator();
	}
	
}
