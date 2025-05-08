package ru.myx.ae3.flow;

import ru.myx.ae3.base.BaseMessageEditable;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.common.BodyAccessCharacter;
import ru.myx.ae3.reflect.Reflect;
import ru.myx.ae3.reflect.ReflectionHidden;

/**
 *
 * @author myx
 *
 * @param <T>
 */
public interface CharacterMessage<T extends CharacterMessage<?>> extends BaseMessageEditable<T>, BodyAccessCharacter {
	
	/**
	 *
	 */
	static BaseObject PROTOTYPE = Reflect.classToBasePrototype(CharacterMessage.class);
	
	@Override
	@ReflectionHidden
	default BaseObject basePrototype() {
		
		return CharacterMessage.PROTOTYPE;
	}
	
	@Override
	UniversalMessage<?> toBinary() throws FlowOperationException;

	/**
	 * It is nasty to explicitly call to toCharacter() when knowing for sure
	 * that object is already a CharacterMessage
	 */
	@Override
	@Deprecated
	default CharacterMessage<?> toCharacter() {
		
		return this;
	}
}
