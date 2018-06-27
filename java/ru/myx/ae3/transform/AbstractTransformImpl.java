package ru.myx.ae3.transform;

import java.io.IOException;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.binary.TransferBuffer;

abstract class AbstractTransformImpl {
	public abstract void addSerializer(final TransformSerializer serializer);
	
	public abstract <T> T materialize(
			final Class<T> acceptable,
			final String contentType,
			final BaseObject attributes,
			final TransferBuffer buffer);
	
	public abstract void registerDefaultTransformers();
	
	public abstract boolean serialize(final SerializationRequest request) throws IOException;
}
