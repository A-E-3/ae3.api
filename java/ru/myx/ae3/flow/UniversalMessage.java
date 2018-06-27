package ru.myx.ae3.flow;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.reflect.Reflect;
import ru.myx.ae3.reflect.ReflectionHidden;

/**
 *
 * @author myx
 *
 * @param <T>
 */
public interface UniversalMessage<T extends UniversalMessage<?>> extends BinaryMessage<T>, CharacterMessage<T> {
	
	/**
	 *
	 */
	static BaseObject PROTOTYPE = Reflect.classToBasePrototype(UniversalMessage.class);
	
	@Override
	@ReflectionHidden
	default BaseObject basePrototype() {
		
		return UniversalMessage.PROTOTYPE;
	}
	
	/**
	 * It is nasty to explicitly call to toBinary() when knowing for sure that
	 * object is already a BinaryMessage
	 */
	@Override
	@Deprecated
	default UniversalMessage<?> toBinary() {
		
		return this;
	}
	
	/**
	 * It is nasty to explicitly call to toCharacter() when knowing for sure
	 * that object is already a CharacterMessage
	 */
	@Override
	@Deprecated
	default UniversalMessage<?> toCharacter() {
		
		return this;
	}
}
