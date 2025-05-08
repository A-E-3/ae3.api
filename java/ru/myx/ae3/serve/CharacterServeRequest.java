package ru.myx.ae3.serve;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.flow.CharacterMessage;
import ru.myx.ae3.flow.FlowOperationException;
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
public interface CharacterServeRequest<T extends CharacterServeRequest<?>> extends ServeRequestEditable<T>, CharacterMessage<T> {
	
	/**
	 *
	 */
	static BaseObject PROTOTYPE = Reflect.classToBasePrototype(CharacterServeRequest.class);
	
	@Override
	@ReflectionHidden
	default BaseObject basePrototype() {
		
		return CharacterServeRequest.PROTOTYPE;
	}
	
	@Override
	UniversalServeRequest<?> toBinary() throws FlowOperationException;

	@Deprecated
	@Override
	default CharacterServeRequest<?> toCharacter() {
		
		return this;
	}
}
