package ru.myx.ae3.serve;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.flow.BinaryMessage;
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
public interface BinaryServeRequest<T extends BinaryServeRequest<?>> extends ServeRequestEditable<T>, BinaryMessage<T> {
	
	/**
	 *
	 */
	static BaseObject PROTOTYPE = Reflect.classToBasePrototype(BinaryServeRequest.class);
	
	@Override
	@ReflectionHidden
	default BaseObject basePrototype() {
		
		return BinaryServeRequest.PROTOTYPE;
	}
	
	@Deprecated
	@Override
	default BinaryServeRequest<?> toBinary() {
		
		return this;
	}
	
	@Override
	UniversalServeRequest<?> toCharacter() throws FlowOperationException;
}
