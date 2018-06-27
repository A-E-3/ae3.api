package ru.myx.ae3.base;

import java.util.Iterator;

import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/**
 *
 * @author myx
 *
 */
@ReflectionDisable
public interface BaseObjectNotDynamic extends BaseObject {
	
	
	/**
	 * @return false
	 */
	@Override
	@ReflectionHidden
	default boolean baseHasKeysOwn() {
		
		
		return false;
	}

	@Override
	@ReflectionHidden
	default Iterator<String> baseKeysOwn() {
		
		
		return BaseObject.ITERATOR_EMPTY;
	}

	@Override
	@ReflectionHidden
	default Iterator<? extends CharSequence> baseKeysOwnAll() {
		
		
		return BaseObject.ITERATOR_EMPTY;
	}

	@Override
	@ReflectionHidden
	default Iterator<? extends BasePrimitive<?>> baseKeysOwnPrimitive() {
		
		
		return BaseObject.ITERATOR_EMPTY_PRIMITIVE;
	}

	/**
	 * does nothing
	 */
	@Override
	@ReflectionHidden
	default boolean baseDelete(final String name) {
		
		
		return false;
	}

	@Override
	@ReflectionHidden
	default boolean baseIsExtensible() {
		
		
		return false;
	}

	/**
	 * does nothing
	 */
	@Override
	@ReflectionHidden
	default void baseClear() {
		
		
		return;
	}
}
