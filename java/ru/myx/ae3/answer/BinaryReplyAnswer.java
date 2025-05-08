package ru.myx.ae3.answer;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.flow.BinaryMessage;
import ru.myx.ae3.flow.FlowOperationException;
import ru.myx.ae3.reflect.Reflect;
import ru.myx.ae3.reflect.ReflectionHidden;

/**
 *
 * @author myx
 * 
 * @param <T>
 */
public interface BinaryReplyAnswer<T extends BinaryReplyAnswer<?>> extends ReplyAnswerEditable<T>, BinaryMessage<T> {

	/**
	 *
	 */
	static BaseObject PROTOTYPE = Reflect.classToBasePrototype(BinaryReplyAnswer.class);

	@Override
	@ReflectionHidden
	default BaseObject basePrototype() {

		return BinaryReplyAnswer.PROTOTYPE;
	}

	/**
	 * It is nasty to explicitly call to toBinary() when knowing for sure that
	 * object is already a BinaryAnswer
	 */
	@Deprecated
	@Override
	default BinaryReplyAnswer<?> toBinary() {

		return this;
	}

	@Override
	UniversalReplyAnswer<?> toCharacter() throws FlowOperationException;
}
