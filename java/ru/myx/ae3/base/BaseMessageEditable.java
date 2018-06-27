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

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	@Override
	default T addAttribute(final String name, final double value) {

		return this.addAttribute(name, Base.forDouble(value));
	}

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	@Override
	T addAttribute(String name, int value);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	@Override
	T addAttribute(String name, long value);

	/** Returns same or new message with corresponding attribute set.
	 * <p>
	 * Throws NullPointerException when attribute value is <b>NULL </b>.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	@Override
	T addAttribute(String name, Object value);

	/** Returns same or new message with corresponding attributes set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	@Override
	T addAttribute(String name, String value);

	/** Returns same or new message with corresponding attribute set.
	 * <p>
	 * Throws NullPointerException when attribute value is <b>NULL </b>.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	@Override
	T setAttribute(String name, BaseObject value);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	@Override
	T setAttribute(String name, double value);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	@Override
	T setAttribute(String name, int value);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	@Override
	T setAttribute(String name, long value);

	/** Returns same or new message with corresponding attribute set.
	 * <p>
	 * Throws NullPointerException when attribute value is <b>NULL </b>.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	@Override
	T setAttribute(String name, Object value);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	@Override
	T setAttribute(String name, String value);

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
