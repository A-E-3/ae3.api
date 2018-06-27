/*
 * Created on 24.03.2006
 */
package ru.myx.ae3.transform;

import java.io.IOException;

import ru.myx.ae3.binary.TransferCollector;

/**
 * @author myx
 * 
 */
public interface SerializationRequest {
	/**
	 * @return string array
	 */
	String[] getAcceptTypes();
	
	/**
	 * @return object
	 */
	Object getObject();
	
	/**
	 * @return object class
	 */
	Class<?> getObjectClass();
	
	/**
	 * @param contentType
	 * @return collector for body
	 * @throws IOException
	 */
	TransferCollector setResultType(final String contentType) throws IOException;
}
