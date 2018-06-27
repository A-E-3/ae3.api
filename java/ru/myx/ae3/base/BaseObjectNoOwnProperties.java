package ru.myx.ae3.base;

import java.util.Iterator;

import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/** @author myx */
@ReflectionDisable
public interface BaseObjectNoOwnProperties extends BaseObjectNotDynamic {
	
	@Override
	default BaseProperty baseFindProperty(final BasePrimitiveString name) {
		
		for (final BaseObject prototype = this.basePrototype(); prototype != null;) {
			return prototype.baseFindProperty(name);
		}
		return null;
	}
	
	@Override
	default BaseProperty baseFindProperty(final BasePrimitiveString name, final BaseObject stop) {
		
		for (final BaseObject prototype = this.basePrototype(); prototype != null && prototype != stop;) {
			return prototype.baseFindProperty(name, stop);
		}
		return null;
	}
	
	@Override
	default BaseProperty baseFindProperty(final String name) {
		
		for (final BaseObject prototype = this.basePrototype(); prototype != null;) {
			return prototype.baseFindProperty(name);
		}
		return null;
	}
	
	@Override
	default BaseProperty baseFindProperty(final String name, final BaseObject stop) {
		
		for (final BaseObject prototype = this.basePrototype(); prototype != null && prototype != stop;) {
			return prototype.baseFindProperty(name, stop);
		}
		return null;
	}
	
	/** @return null */
	@Override
	@ReflectionHidden
	default BaseProperty baseGetOwnProperty(final BasePrimitiveString name) {
		
		return null;
	}
	
	/** @return null */
	@Override
	@ReflectionHidden
	default BaseProperty baseGetOwnProperty(final CharSequence name) {
		
		return null;
	}
	
	/** @return null */
	@Override
	@ReflectionHidden
	default BaseProperty baseGetOwnProperty(final String name) {
		
		return null;
	}
	
	/** @return false */
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

}
