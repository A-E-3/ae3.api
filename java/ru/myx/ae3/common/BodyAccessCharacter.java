package ru.myx.ae3.common;

/**
 * 
 * @author myx
 * 		
 */
public interface BodyAccessCharacter extends BodyAccessUnknown {
	
	@Override
	default boolean isCharacter() {
		
		return true;
	}
	
	/**
	 * Must not return NULL when isCharacter() returns true.
	 * 
	 * @return length in characters
	 */
	long getCharacterContentLength();
	
	/**
	 * Must not return NULL when isCharacter() returns true.
	 * 
	 * @return string
	 */
	CharSequence getText();
	
	/**
	 * Must not return NULL when isCharacter() returns true.
	 * 
	 * This method can return Future object.
	 * 
	 * @return
	 */
	Value<? extends CharSequence> getTextContent();
}
