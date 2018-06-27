/**
 * Created on 27.11.2002
 * 
 * myx - barachta */
package ru.myx.ae3.transform;

import java.io.IOException;

import ru.myx.ae3.AbstractSAPI;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.binary.TransferBuffer;
import ru.myx.ae3.binary.TransferCopier;

/**
 * @author barachta
 * 
 * myx - barachta 
 *         "typecomment": Window>Preferences>Java>Templates. To enable and
 *         disable the creation of type comments go to
 *         Window>Preferences>Java>Code Generation.
 */
public final class Transform extends AbstractSAPI {
	
	private static final AbstractTransformImpl	TRANSFORM_IMPL;
	
	static {
		TRANSFORM_IMPL = AbstractSAPI.createObject( "ru.myx.ae3.transform.ImplementTransform" );
		Transform.TRANSFORM_IMPL.registerDefaultTransformers();
	}
	
	/**
	 * 
	 * This method is using Produce.object facility, but being aware of MIME
	 * types it can sequentially scan for factories with more general types.
	 * 
	 * Example: text/plain or even application/octet-stream for text/javascript.
	 * 
	 * @param <T>
	 * @param acceptable
	 * @param contentType
	 * @param attributes
	 * @param buffer
	 * @return object
	 */
	public static final <T> T materialize(
			final Class<T> acceptable,
			final String contentType,
			final BaseObject attributes,
			final TransferBuffer buffer) {
		assert acceptable != null : "'acceptable' class agrument should not be NULL!";
		return Transform.TRANSFORM_IMPL.materialize( acceptable, contentType, attributes, buffer );
	}
	
	/**
	 * 
	 * This method is using Produce.object facility, but being aware of MIME
	 * types it can sequentially scan for factories with more general types.
	 * 
	 * Example: text/plain or even application/octet-stream for text/javascript.
	 * 
	 * @param <T>
	 * @param acceptable
	 * @param contentType
	 * @param attributes
	 * @param copier
	 * @return object
	 */
	public static final <T> T materialize(
			final Class<T> acceptable,
			final String contentType,
			final BaseObject attributes,
			final TransferCopier copier) {
		assert acceptable != null : "'acceptable' class agrument should not be NULL!";
		return Transform.TRANSFORM_IMPL.materialize( acceptable, contentType, attributes, copier.nextCopy() );
	}
	
	/**
	 * @param serializer
	 */
	public static final void registerSerializer(final TransformSerializer serializer) {
		Transform.TRANSFORM_IMPL.addSerializer( serializer );
	}
	
	/**
	 * @param request
	 * @return boolean
	 * @throws IOException
	 */
	public static final boolean serialize(final SerializationRequest request) throws IOException {
		return Transform.TRANSFORM_IMPL.serialize( request );
	}
	
	private Transform() {
		// empty
	}
}
