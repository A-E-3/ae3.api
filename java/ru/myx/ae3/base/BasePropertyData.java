package ru.myx.ae3.base;

import ru.myx.ae3.reflect.ReflectionDisable;

/** 8.6.1 Property Attributes
 * <p>
 * A property can have zero or more attributes from the following set:<br< <b>ReadOnly</b> - The
 * property is a read-only property. Attempts by ECMAScript code to write to the property will be
 * ignored. (Note, however, that in some cases the value of a property with the ReadOnly attribute
 * may change over time because of actions taken by the host environment; therefore “ReadOnly” does
 * not mean “constant and unchanging”!)<br>
 * <b>DontEnum</b> - The property is not to be enumerated by a for-in enumeration (section 12.6.4).
 * <br>
 * <b>DontDelete</b> - Attempts to delete the property will be ignored. See the description of the
 * delete operator in section 11.4.1.<br>
 * <p>
 * Internal properties not mentioned here since they are implemented not as properties.
 * <p>
 *
 * @author myx
 *
 * @param <K>
 *            The java type of the Key. (String.class or BasePrimitiveString.class, etc...) */
@ReflectionDisable
public abstract class BasePropertyData<K> implements BaseProperty, BaseProperties<K> {
	
	K name;
	
	short attributes;
	
	/** Linked list navigation */
	BasePropertyData<K> prev;
	
	/** Linked list navigation */
	BasePropertyData<K> next;
	
	/** @param name
	 * @param attributes */
	public BasePropertyData(final K name, final short attributes) {
		
		this.name = name;
		this.attributes = attributes;
	}
	
	/**
	 */
	BasePropertyData() {
		
		//
	}
	
	@Override
	public final short propertyAttributes(final CharSequence name) {
		
		return this.attributes;
	}
	
	@Override
	public String toString() {
		
		return this.getClass().getSimpleName() + " [key=" + this.name + "]";
	}
}
