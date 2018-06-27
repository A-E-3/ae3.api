package ru.myx.ae3.answer;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.flow.CharacterMessage;
import ru.myx.ae3.flow.Flow;
import ru.myx.ae3.reflect.Reflect;
import ru.myx.ae3.reflect.ReflectionHidden;

/**
 *
 * @author myx
 * 
 * @param <T>
 */
public interface CharacterReplyAnswer<T extends CharacterReplyAnswer<?>> extends ReplyAnswerEditable<T>, CharacterMessage<T> {

	/**
	 *
	 */
	static BaseObject PROTOTYPE = Reflect.classToBasePrototype(CharacterReplyAnswer.class);

	@Override
	@ReflectionHidden
	default BaseObject basePrototype() {

		return CharacterReplyAnswer.PROTOTYPE;
	}

	@Override
	UniversalReplyAnswer<?> toBinary() throws Flow.FlowOperationException;
	
	/**
	 * It is nasty to explicitly call to toCharacter() when knowing for sure
	 * that object is already a CharacterAnswer
	 */
	@Deprecated
	@Override
	default CharacterReplyAnswer<?> toCharacter() {

		return this;
	}
}
