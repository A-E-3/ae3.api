package ru.myx.ae3.common;

import java.security.MessageDigest;

import ru.myx.ae3.binary.TransferCopier;

/**
 * 
 * @author myx
 * 		
 */
public interface BodyAccessBinary extends BodyAccessUnknown {
	
	@Override
	default boolean isBinary() {
		
		return true;
	}
	
	/**
	 * Must not return NULL when isBinary() returns true.
	 * 
	 * @return binary
	 */
	TransferCopier getBinary();
	
	/**
	 * Must not return NULL when isBinary() returns true.
	 * 
	 * This method can return Future object.
	 * 
	 * @return
	 */
	Value<? extends TransferCopier> getBinaryContent();
	
	/**
	 * Must not return NULL when isBinary() returns true.
	 * 
	 * @return length in bytes
	 */
	long getBinaryContentLength();
	
	/**
	 * returns a checksum.
	 * 
	 * @return checksum
	 */
	MessageDigest getBinaryMessageDigest();
}
