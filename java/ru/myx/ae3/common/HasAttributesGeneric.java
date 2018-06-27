package ru.myx.ae3.common;

import java.util.Iterator;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;

/** @author myx
 * @param <T> */
public interface HasAttributesGeneric<T extends HasAttributesGeneric<?>> extends HasAttributes {
	
	/** Returns same or new message with corresponding attribute set.
	 * <p>
	 * Throws NullPointerException when attribute value is <b>NULL </b>.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	T setAttribute(String name, BaseObject value);
	
	/** @param name
	 * @param value
	 * @return same object */
	default T setAttribute(final String name, final boolean value) {
		
		return this.setAttribute(name, Base.forBoolean(value));
	}
	
	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	default T setAttribute(final String name, final double value) {
		
		return this.setAttribute(name, Base.forDouble(value));
	}
	
	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	default T setAttribute(final String name, final int value) {
		
		return this.setAttribute(name, Base.forInteger(value));
	}
	
	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	default T setAttribute(final String name, final long value) {
		
		return this.setAttribute(name, Base.forLong(value));
	}
	
	/** Returns same or new message with corresponding attribute set.
	 * <p>
	 * Throws NullPointerException when attribute value is <b>NULL </b>.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	default T setAttribute(final String name, final Object value) {
		
		return this.setAttribute(name, Base.forUnknown(value));
	}
	
	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	default T setAttribute(final String name, final String value) {
		
		return this.setAttribute(name, Base.forString(value));
	}
	
	/** Returns same or new message with corresponding attributes set.
	 *
	 * @param attributes
	 * @return reply */
	@SuppressWarnings("unchecked")
	default T setAttributes(final BaseObject attributes) {
		
		if (attributes != null && !attributes.baseIsPrimitive()) {
			for (final Iterator<String> keys = Base.keys(attributes, BaseObject.PROTOTYPE); keys.hasNext();) {
				final String key = keys.next();
				this.setAttribute(key, attributes.baseGet(key, null));
			}
		}
		return (T) this;
	}
}
