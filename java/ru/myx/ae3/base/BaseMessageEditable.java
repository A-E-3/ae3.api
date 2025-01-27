package ru.myx.ae3.base;

import java.nio.charset.Charset;

import ru.myx.ae3.common.HasAttributesGeneric;

/** @author myx
 *
 * @param <T> */
public interface BaseMessageEditable<T extends BaseMessageEditable<?>> extends BaseMessage, HasAttributesGeneric<T> {

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	@Override
	T addAttribute(String name, BaseObject value);
	
	@Override
	default T addAttribute(final String name, final double value) {
		
		return this.addAttribute(name, Base.forDouble(value));
	}

	@Override
	default T addAttribute(final String name, final int value) {
		
		return this.addAttribute(name, Base.forInteger(value));
	}
	
	@Override
	default T addAttribute(final String name, final long value) {
		
		return this.addAttribute(name, Base.forLong(value));
	}
	
	@Override
	default T addAttribute(final String name, final Object value) {
		
		return this.addAttribute(name, Base.forUnknown(value));
	}
	
	@Override
	default T addAttribute(final String name, final String value) {
		
		return this.addAttribute(name, Base.forString(value));
	}
	
	/** Returns same or new message with corresponding attribute set.
	 * <p>
	 * Throws NullPointerException when attribute value is <b>NULL </b>.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	@Override
	T setAttribute(String name, BaseObject value);
	
	@Override
	default T setAttribute(final String name, final double value) {
		
		return this.setAttribute(name, Base.forDouble(value));
	}

	@Override
	default T setAttribute(final String name, final int value) {
		
		return this.setAttribute(name, Base.forInteger(value));
	}
	
	@Override
	default T setAttribute(final String name, final long value) {
		
		return this.setAttribute(name, Base.forLong(value));
	}
	
	@Override
	default T setAttribute(final String name, final Object value) {

		return this.setAttribute(name, Base.forUnknown(value));
	}
	
	@Override
	default T setAttribute(final String name, final String value) {
		
		return this.setAttribute(name, Base.forString(value));
	}
	
	/** Returns same or new message with corresponding attributes set.
	 *
	 * @param attributes
	 * @return reply */
	@Override
	T setAttributes(BaseObject attributes);
	
	/** @param disposition
	 * @return */
	@Override
	T setContentDisposition(String disposition);
	
	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param contentId
	 * @return message */
	@Override
	T setContentID(String contentId);
	
	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param contentName
	 * @return message */
	@Override
	T setContentName(String contentName);
	
	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param contentType
	 * @return message */
	@Override
	T setContentType(String contentType);
	
	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param charset
	 * @return message */
	@Override
	T setEncoding(Charset charset);
	
	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param encoding
	 * @return message */
	@Override
	T setEncoding(String encoding);
	
	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param sessionId
	 * @return reply */
	@Override
	T setSessionID(String sessionId);
	
	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param userId
	 * @return reply */
	@Override
	T setUserID(String userId);
	
	/** Returns the SAME response object.
	 *
	 * @param attributes
	 * @return reply */
	@Override
	T useAttributes(BaseObject attributes);
}
