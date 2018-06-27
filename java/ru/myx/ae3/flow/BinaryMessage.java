package ru.myx.ae3.flow;

import ru.myx.ae3.base.BaseMessageEditable;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.common.BodyAccessBinary;
import ru.myx.ae3.reflect.Reflect;
import ru.myx.ae3.reflect.ReflectionHidden;

/**
 *
 * @author myx
 *
 * @param <T>
 */
public interface BinaryMessage<T extends BinaryMessage<?>> extends BaseMessageEditable<T>, BodyAccessBinary {

	/**
	 *
	 */
	static BaseObject PROTOTYPE = Reflect.classToBasePrototype(BinaryMessage.class);

	@Override
	@ReflectionHidden
	default BaseObject basePrototype() {

		return BinaryMessage.PROTOTYPE;
	}

	/**
	 * It is nasty to explicitly call to toBinary() when knowing for sure that
	 * object is already a BinaryMessage
	 */
	@Override
	@Deprecated
	default BinaryMessage<?> toBinary() {

		return this;
	}

	@Override
	UniversalMessage<?> toCharacter() throws Flow.FlowOperationException;
}
