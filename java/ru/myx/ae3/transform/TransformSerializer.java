/*
 * Created on 24.03.2006
 */
package ru.myx.ae3.transform;

import java.io.IOException;

/**
 * @author myx
 * 
 */
public interface TransformSerializer {
	/**
	 * @param request
	 * @return boolean
	 */
	boolean canSerialize(final SerializationRequest request);
	
	/**
	 * @param request
	 * @return serializer
	 */
	TransformSerializer getSerializer(final SerializationRequest request);
	
	/**
	 * @param request
	 * @return boolean
	 * @throws IOException
	 */
	boolean serialize(final SerializationRequest request) throws IOException;
}
