package ru.myx.ae3.answer;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.flow.UniversalMessage;
import ru.myx.ae3.reflect.Reflect;
import ru.myx.ae3.reflect.ReflectionHidden;

/**
 *
 * @author myx
 *
 * @param <T>
 */
public interface UniversalReplyAnswer<T extends UniversalReplyAnswer<?>> extends CharacterReplyAnswer<T>, BinaryReplyAnswer<T>, UniversalMessage<T> {
	
	/**
	 *
	 */
	static BaseObject PROTOTYPE = Reflect.classToBasePrototype(UniversalReplyAnswer.class);
	
	@Override
	@ReflectionHidden
	default BaseObject basePrototype() {
		
		return UniversalReplyAnswer.PROTOTYPE;
	}
	
	/**
	 * It is nasty to explicitly call to toBinary() when knowing for sure that
	 * object is already a BinaryAnswer
	 */
	@Deprecated
	@Override
	default UniversalReplyAnswer<?> toBinary() {
		
		return this;
	}
	
	/**
	 * It is nasty to explicitly call to toCharacter() when knowing for sure
	 * that object is already a CharacterAnswer
	 */
	@Deprecated
	@Override
	default UniversalReplyAnswer<?> toCharacter() {
		
		return this;
	}
}
