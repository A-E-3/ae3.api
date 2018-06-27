/*
 * Created on 22.03.2006
 */
package ru.myx.ae3.answer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import ru.myx.ae3.Engine;
import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseMessage;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.base.BaseProperty;
import ru.myx.ae3.binary.Transfer;
import ru.myx.ae3.binary.TransferBuffer;
import ru.myx.ae3.binary.TransferCollector;
import ru.myx.ae3.flow.Flow;
import ru.myx.ae3.help.Format;
import ru.myx.ae3.reflect.Reflect;
import ru.myx.ae3.report.Report;
import ru.myx.ae3.transform.SerializationRequest;
import ru.myx.ae3.transform.Transform;

/** @author myx */
public interface ReplyAnswer extends BaseMessage {

	/**
	 *
	 */
	static BaseObject PROTOTYPE = Reflect.classToBasePrototype(ReplyAnswer.class);

	/** Numeric == 1, Control response */
	static int TP_CT = 1;

	/** Numeric == 2, Success response */
	static int TP_OK = 2;

	/** Numeric == 4, Query error */
	static int TP_QE = 4;

	/** Numeric == 3, Redirection response */
	static int TP_RD = 3;

	/** Numeric == 5, Server error */
	static int TP_SE = 5;

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	@Override
	ReplyAnswer addAttribute(String name, BaseObject value);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	@Override
	default ReplyAnswer addAttribute(final String name, final double value) {

		return this.addAttribute(name, Base.forDouble(value));
	}

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	@Override
	ReplyAnswer addAttribute(String name, int value);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	@Override
	ReplyAnswer addAttribute(String name, long value);

	/** Returns same or new message with corresponding attribute set.
	 * <p>
	 * Throws NullPointerException when attribute value is <b>NULL </b>.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	@Override
	ReplyAnswer addAttribute(String name, Object value);

	/** Returns same or new message with corresponding attributes set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	@Override
	ReplyAnswer addAttribute(String name, String value);

	@Override
	default BaseObject basePrototype() {

		return ReplyAnswer.PROTOTYPE;
	}

	/** returns one of CD_XXX values.
	 *
	 * @return int */
	int getCode();

	/** returns ( getCode() / 100 ) | 0;
	 *
	 * @return int */
	default int getCodeGroup() {

		return this.getCode() / 100;
	}

	/** @return date */
	long getExpirationDate();

	/** Returns a map of flags assigned to this message whose main purpose is to help with further
	 * local (system-internal) message processing.
	 *
	 * @return map */
	BaseObject getFlags();

	/** @return message */
	BaseMessage getQuery();

	/** Returns a string containing a session identity for this personalized response or null if
	 * response is common.
	 *
	 * @return string */
	String getSessionID();

	/** returns some text describing a concrete subject of this response. Useful when there
	 * partially completed response for example.
	 *
	 * Should not ever return <b>null </b> when hasSubject() method returns <b>true </b>. */
	@Override
	String getSubject();

	@Override
	String getTarget();

	@Override
	String getTargetExact();

	/** @return int */
	default int getTimeToLiveSeconds() {

		return Base.getInt(this.getAttributes(), "maxage", 0);
	}

	/** returns a line of text shortly describing the type and code in the context of current
	 * response, i.e. "Error", "Not found", "Access denied"... Should not ever return <b>null </b>
	 * value.
	 *
	 * @return string */
	@Override
	default String getTitle() {

		return Base.getString(this.getAttributes(), "Title", Reply.getDefaultTitleForCode(this.getCode()));
	}

	/** Returns a string containing a user identity for this personalized response or null if
	 * response is common.
	 *
	 * @return string */
	default String getUserID() {

		return Base.getString(this.getAttributes(), "X-User-Id", null);
	}

	/** @return boolean */
	default boolean isFinal() {

		return Base.getBoolean(this.getAttributes(), "Final", false);
	}

	/** @return boolean */
	default boolean isPrivate() {

		return Base.getBoolean(this.getAttributes(), "Private", false);
	}

	/** returns an answer message with the same contents without any impact to a current answer
	 * message. If this operation is not supported this method MUSReplyAnswer throw an
	 * UnsupportedOperationException and MUSReplyAnswer return false on isCloneable() method call.
	 *
	 * @param query
	 * @return reply */
	ReplyAnswer nextClone(BaseMessage query);

	/** Seals message, returns а message object A, such that any method called on A and that is
	 * changing value of any property will return another message B leaving A properties intact.
	 *
	 * @return */
	ReplyAnswer seal();

	/** Returns same or new message with corresponding attribute set.
	 * <p>
	 * Throws NullPointerException when attribute value is <b>NULL </b>.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	@Override
	ReplyAnswer setAttribute(String name, BaseObject value);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	@Override
	ReplyAnswer setAttribute(String name, double value);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	@Override
	ReplyAnswer setAttribute(String name, int value);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	@Override
	ReplyAnswer setAttribute(String name, long value);

	/** Returns same or new message with corresponding attribute set.
	 * <p>
	 * Throws NullPointerException when attribute value is <b>NULL </b>.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	@Override
	ReplyAnswer setAttribute(String name, Object value);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	@Override
	ReplyAnswer setAttribute(String name, String value);

	/** Returns same or new message with corresponding attributes set.
	 *
	 * @param attributes
	 * @return reply */
	@Override
	ReplyAnswer setAttributes(BaseObject attributes);

	/** Returns the SAME response object.
	 *
	 * @param code
	 * @return reply */
	ReplyAnswer setCode(int code);

	/** @param disposition
	 * @return */
	@Override
	ReplyAnswer setContentDisposition(String disposition);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param contentId
	 * @return message */
	@Override
	ReplyAnswer setContentID(String contentId);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param contentName
	 * @return message */
	@Override
	ReplyAnswer setContentName(String contentName);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param contentType
	 * @return message */
	@Override
	ReplyAnswer setContentType(String contentType);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param charset
	 * @return message */
	@Override
	ReplyAnswer setEncoding(Charset charset);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param encoding
	 * @return message */
	@Override
	ReplyAnswer setEncoding(String encoding);

	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @param date
	 * @return message */
	ReplyAnswer setExpirationDate(long date);

	/** @return reply */
	ReplyAnswer setFinal();

	/** Returns the SAME response object.
	 *
	 * @param flags
	 * @return reply */
	ReplyAnswer setFlags(BaseObject flags);

	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @param date
	 * @return reply */
	ReplyAnswer setLastModified(long date);

	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @return reply */
	ReplyAnswer setNoCaching();

	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @return reply */
	ReplyAnswer setPrivate();

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param sessionId
	 * @return reply */
	@Override
	ReplyAnswer setSessionID(String sessionId);

	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @param address
	 * @return reply */
	ReplyAnswer setSourceAddress(String address);

	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @param address
	 * @return reply */
	ReplyAnswer setSourceAddressExact(String address);

	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @param subject
	 * @return reply */
	ReplyAnswer setSubject(String subject);

	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @param target
	 * @return reply */
	ReplyAnswer setTarget(String target);

	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @param target
	 * @return reply */
	ReplyAnswer setTargetExact(String target);

	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @param days
	 * @return reply */
	default ReplyAnswer setTimeToLiveDays(final int days) {

		return days <= 0
			? this.setNoCaching()
			: this.setTimeToLiveSeconds(days * 60 * 60 * 24);
	}

	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @param hours
	 * @return reply */
	default ReplyAnswer setTimeToLiveHours(final int hours) {

		return hours <= 0
			? this.setNoCaching()
			: this.setTimeToLiveSeconds(hours * 60 * 60);
	}

	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @param minutes
	 * @return reply */
	default ReplyAnswer setTimeToLiveMinutes(final int minutes) {

		return minutes <= 0
			? this.setNoCaching()
			: this.setTimeToLiveSeconds(minutes * 60);
	}

	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @param seconds
	 * @return reply */
	ReplyAnswer setTimeToLiveSeconds(int seconds);

	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @param weeks
	 * @return reply */
	default ReplyAnswer setTimeToLiveWeeks(final int weeks) {

		return weeks <= 0
			? this.setNoCaching()
			: this.setTimeToLiveSeconds(weeks * 60 * 60 * 24 * 7);
	}

	/** Returns the SAME response object. Note: title is designed to be a line of text - use
	 * setSubject in case of setting a short descriptions with multiple lines of text.
	 *
	 * @param title
	 * @return reply */
	ReplyAnswer setTitle(String title);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param userId
	 * @return reply */
	@Override
	ReplyAnswer setUserID(String userId);

	/** Returns a response whose isEmpty(), isBinary() or isFile() method will return <b>true </b>
	 * and getBinary() or getFile() will return a binary non-null representation of a response. When
	 * a response is already meets conditions secified this method should return exactly the SAME
	 * response object. The "Character-Encoding" of "Content-Type" attributes of a current response
	 * and "Accept-Charset" or "Accept-Type" attributes of current query should be considered when
	 * possible. "UTF-8" encoding should be used by default.
	 *
	 * @return reply
	 * @throws Flow.FlowOperationException
	 */
	@Override
	default BinaryReplyAnswer<?> toBinary() throws Flow.FlowOperationException {

		if (this.isEmpty() || this.isBinary()) {
			assert this instanceof BinaryReplyAnswer : "Expected to be an instance of BinaryReplyAnswer, class: " + this.getClass().getName();
			return (BinaryReplyAnswer<?>) this;
		}
		if (this.isCharacter()) {
			assert this instanceof CharacterReplyAnswer : "Expected to be an instance of CharacterReplyAnswer, class: " + this.getClass().getName();
			return Reply.binaryWrapCharacter((CharacterReplyAnswer<?>) this);
		}
		if (this.isObject()) {
			final BaseObject newAttributes = BaseObject.createObject(this.getAttributes());
			final TransferCollector collector = Transfer.createCollector();
			final SerializationRequest request = new SerializationRequest() {

				@Override
				public String[] getAcceptTypes() {

					return null;
				}

				@Override
				public Object getObject() {

					return ReplyAnswer.this.getObject();
				}

				@Override
				public Class<?> getObjectClass() {

					return ReplyAnswer.this.getObjectClass();
				}

				@Override
				public TransferCollector setResultType(final String contentType) {

					newAttributes.baseDefine("Content-Type", contentType, BaseProperty.ATTRS_MASK_WED);
					return collector;
				}
			};
			try {
				if (Transform.serialize(request)) {
					return Reply.binary(
							this.getEventTypeId(), //
							this.getQuery(),
							newAttributes,
							collector.toBuffer());
				}
				collector.close();
				return Reply.empty(this.getEventTypeId(), this.getQuery())//
						.useFlags(this.getFlags());
			} catch (final IOException e) {
				collector.close();
				return Reply.binary(this.getEventTypeId(), this.getQuery(), Transfer.createBuffer(Format.Throwable.toText(e).getBytes(Engine.CHARSET_UTF8)))
						.setAttribute("Content-Type", "text/plain; charset=UTF-8")//
						.useFlags(this.getFlags());
			}
		}
		return null;
	}

	/** Returns a response whose isEmpty(), isCharacter() or isObject() method will return <b>true
	 * </b> and getText() or getObject() will return a <b>non-null </b> stringual representation of
	 * a response. When a response is already meets conditions secified this method should return
	 * exactly the SAME response object. The "Character-Encoding" attribute of a current response
	 * and "Accept-Charset" attribute of current query should be considered when possible. "UTF-8"
	 * encoding should be used by default.
	 *
	 * @return reply
	 * @throws Flow.FlowOperationException
	 */
	@Override
	default CharacterReplyAnswer<?> toCharacter() throws Flow.FlowOperationException {

		if (this.isEmpty() || this.isCharacter()) {
			assert this instanceof CharacterReplyAnswer : "Expected to be an instance of CharacterReplyAnswer, class: " + this.getClass().getName();
			return (CharacterReplyAnswer<?>) this;
		}
		if (this.isBinary()) {
			assert this instanceof BinaryReplyAnswer : "Expected to be an instance of BinaryReplyAnswer, class: " + this.getClass().getName();
			return Reply.characterWrapBinary((BinaryReplyAnswer<?>) this);
		}
		if (this.isFile()) {
			final TransferBuffer buffer = Transfer.createBuffer(this.getFile());
			final BaseObject ownAttributes = this.getAttributes();
			final String contentType = ownAttributes == null
				? "application/octet-stream"
				: Base.getString(ownAttributes, "Content-Type", "application/octet-stream");
			final String currentEncoding = Base.getString(Flow.mimeAttribute("", "", contentType).getAttributes(), "charset", "").trim();
			final String encoding = currentEncoding.length() > 0
				? currentEncoding
				: ownAttributes == null
					? Engine.ENCODING_UTF8
					: Base.getString(
							ownAttributes, //
							"Character-Encoding",
							this.getQuery() == null
								? null
								: this.getQuery().getAttributes(),
							"Accept-Charset",
							Engine.ENCODING_UTF8);
			final String chosenEncoding = encoding.indexOf('*') != -1
				? Engine.ENCODING_UTF8
				: encoding;
			final BaseObject attributes = BaseObject.createObject();
			if (ownAttributes != null) {
				attributes.baseDefineImportAllEnumerable(ownAttributes);
			}
			if (currentEncoding.length() == 0) {
				attributes.baseDefine("Content-Type", contentType + "; charset=" + chosenEncoding, BaseProperty.ATTRS_MASK_WED);
			}
			final String text;
			try {
				text = new String(buffer.toDirectArray(), chosenEncoding);
			} catch (final UnsupportedEncodingException e) {
				throw new Flow.FlowOperationException("Error creating String from Buffer", e);
			}
			return Reply.string(
					this.getEventTypeId(), //
					this.getQuery(),
					attributes,
					text)//
					.setCode(this.getCode())//
					.useFlags(this.getFlags());
		}
		{
			final Object object = this.getObject();
			if (object instanceof CharSequence) {
				return Reply.string(
						this.getEventTypeId(), //
						this.getQuery(),
						this.getAttributes(),
						String.valueOf(object))//
						.setCode(this.getCode())//
						.useFlags(this.getFlags());
			}
			if (object == null) {
				final String title = "UNCONVERTABLE: responseClass=" + this.getClass().getName();
				Report.exception(this.getEventTypeId(), "UNCONVERTABLE", new Error(title));
				return Reply.string(
						this.getEventTypeId(), //
						this.getQuery(),
						this.getAttributes(),
						title)//
						.setCode(this.getCode())//
						.useFlags(this.getFlags());
			}
			{
				final BaseObject base = object instanceof BaseObject
					? (BaseObject) object
					: Base.forUnknown(object);
				if (base.baseIsPrimitive()) {
					return Reply.string(
							this.getEventTypeId(), //
							this.getQuery(),
							this.getAttributes(),
							base.baseToString())//
							.setCode(this.getCode())//
							.useFlags(this.getFlags());
				}
				final String title = "UNCONVERTABLE OBJECT: responseClass=" + this.getClass().getName() + ", objectClass=" + object.getClass().getName() + ", getObjectClass="
						+ this.getObjectClass().getName() + ", object=" + object;
				Report.exception(this.getEventTypeId(), "UNCONVERTABLE OBJECT", new Error(title));
				return Reply.string(
						this.getEventTypeId(), //
						this.getQuery(),
						this.getAttributes(),
						title)//
						.setCode(this.getCode())//
						.useFlags(this.getFlags());
			}
		}
	}

	/** Returns the SAME response object.
	 *
	 * @param attributes
	 * @return reply */
	@Override
	ReplyAnswer useAttributes(BaseObject attributes);

	/** Returns the SAME response object.
	 *
	 * @param flags
	 * @return reply */
	ReplyAnswer useFlags(BaseObject flags);

}
