package ru.myx.ae3.serve;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.flow.UniversalMessage;
import ru.myx.ae3.reflect.Reflect;
import ru.myx.ae3.reflect.ReflectionHidden;
import ru.myx.ae3.reflect.ReflectionIgnore;

/**
 *
 * @author myx
 *
 * @param <T>
 */
@ReflectionIgnore
public interface UniversalServeRequest<T extends UniversalServeRequest<?>> extends CharacterServeRequest<T>, BinaryServeRequest<T>, UniversalMessage<T> {
	
	/**
	 *
	 */
	static BaseObject PROTOTYPE = Reflect.classToBasePrototype(UniversalServeRequest.class);
	
	@Override
	@ReflectionHidden
	default BaseObject basePrototype() {
		
		return UniversalServeRequest.PROTOTYPE;
	}
	
	@Deprecated
	@Override
	default UniversalServeRequest<?> toBinary() {
		
		return this;
	}
	
	@Deprecated
	@Override
	default UniversalServeRequest<?> toCharacter() {
		
		return this;
	}
}
