package ru.myx.ae3.common;

import java.io.UnsupportedEncodingException;

/**
 * The idea is that there is a simple way to work with this kind of values. The
 * least you must do is check is it empty, binary or text and, if not, convert
 * it to binary or text as you prefer.
 * 
 * To make things more optimal you can check additional isXXX methods when you
 * are ready or prefer to handle this. But in any case an object can be easily
 * converted to either binary or text.
 * 
 * There is an alternative way for some special cases: you use getObject()
 * method and work with java object provided. Technically, getObject method will
 * return NULL only when isEmpty() returns true, except some special cases:
 * empty binary or empty character sequence.
 * 
 * @author myx
 * 		
 */
public interface BodyAccessUnknown {
	
	/**
	 * @return object
	 */
	default Object getObject() {
		
		return null;
	}
	
	/**
	 * @return class
	 */
	default Class<?> getObjectClass() {
		
		final Object o = this.getObject();
		return o != null
			? this.getObject().getClass()
			: null;
	}
	
	/**
	 * returns true when object is a meaningful instance of BodyAccessBinary
	 * interface and getBinary() method would return guaranteed non-null and
	 * seems to be non-empty instance of Transfer.Buffer class.
	 * 
	 * @return boolean
	 */
	default boolean isBinary() {
		
		return false;
	}
	
	/**
	 * returns true when object is a meaningful instance of BodyAccessCharacter
	 * interface and getText() method would return guaranteed non-null and seems
	 * to be non-empty instance of java.lang.String class.
	 * 
	 * @return boolean
	 */
	default boolean isCharacter() {
		
		return false;
	}
	
	/**
	 * returns true when any of getBinary(), getFile(), getText() or getObject()
	 * will return <b>null </b> value.
	 * 
	 * @return boolean
	 */
	default boolean isEmpty() {
		
		return false;
	}
	
	/**
	 * returns true when getObject() method would return guaranteed non-null.
	 * This still can be a File, a String or a Binary object, so check the
	 * isEmpty(), isBinary() and isCharacter() methods first.
	 * 
	 * @return boolean
	 */
	default boolean isObject() {
		
		return false;
	}
	
	/**
	 * Returns an instance whose isEmpty(), isBinary() or isFile() method will
	 * return <b>true </b> and getBinary() or getFile() will return a binary
	 * non-null representation of a response. When a response is already meets
	 * conditions specified this method should return exactly the SAME response
	 * object. The "Character-Encoding" of "Content-Type" attributes of a
	 * current response and "Accept-Charset" or "Accept-Type" attributes of
	 * current query should be considered when possible. "UTF-8" encoding should
	 * be used by default.
	 * 
	 * @return message
	 * @throws UnsupportedEncodingException
	 */
	BodyAccessBinary toBinary() throws UnsupportedEncodingException;
	
	/**
	 * Returns an instance isEmpty(), isCharacter() and isObject() method will
	 * return <b>true </b> and getText() or getObject() will return a
	 * <b>non-null </b> stringual representation of object's body. When an
	 * object is already meet these conditions, this method should return
	 * exactly the SAME object. The "Character-Encoding" attribute of a current
	 * response and "Accept-Charset" attribute of current query should be
	 * considered when possible. "UTF-8" encoding should be used by default.
	 * 
	 * @return message
	 * @throws UnsupportedEncodingException
	 */
	BodyAccessCharacter toCharacter() throws UnsupportedEncodingException;
}
