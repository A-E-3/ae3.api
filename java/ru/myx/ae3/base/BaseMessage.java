package ru.myx.ae3.base;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import ru.myx.ae3.Engine;
import ru.myx.ae3.binary.Transfer;
import ru.myx.ae3.binary.TransferBuffer;
import ru.myx.ae3.binary.TransferCollector;
import ru.myx.ae3.common.BodyAccessUnknown;
import ru.myx.ae3.common.HasAttributes;
import ru.myx.ae3.flow.BinaryMessage;
import ru.myx.ae3.flow.CharacterMessage;
import ru.myx.ae3.flow.Flow;
import ru.myx.ae3.help.Format;
import ru.myx.ae3.reflect.ReflectionHidden;
import ru.myx.ae3.report.Event;
import ru.myx.ae3.transform.SerializationRequest;
import ru.myx.ae3.transform.Transform;

/** @author barachta
 *
 * myx - barachta 
 *         Window>Preferences>Java>Templates. To enable and disable the creation of type comments go
 *         to Window>Preferences>Java>Code Generation. */
public interface BaseMessage extends Event, BodyAccessUnknown, HasAttributes {

	/** Filled later in ae3.sys */
	@ReflectionHidden
	BaseObject PROTOTYPE = BaseObject.createObject(BaseObject.PROTOTYPE);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	BaseMessage addAttribute(String name, BaseObject value);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	default BaseMessage addAttribute(final String name, final double value) {
		
		return this.addAttribute(name, Base.forDouble(value));
	}

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	BaseMessage addAttribute(String name, int value);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	BaseMessage addAttribute(String name, long value);

	/** Returns same or new message with corresponding attribute set.
	 * <p>
	 * Throws NullPointerException when attribute value is <b>NULL </b>.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	BaseMessage addAttribute(String name, Object value);

	/** Returns same or new message with corresponding attributes set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	BaseMessage addAttribute(String name, String value);

	@Override
	@ReflectionHidden
	default BaseObject basePrototype() {

		return BaseMessage.PROTOTYPE;
	}

	/** Stop all pending tasks and transfers related to receiving the continuation of the message,
	 * if any.
	 *
	 * This is useful if the decision is made while the request or the response is probably not yet
	 * completely transferred or even rendered but the remainder of the response is not needed
	 * anymore.
	 *
	 * It does nothing if the message is already complete. */
	void cancel();

	/** The date of this message creation. */
	@Override
	long getDate();

	/** returns a string event type identifier or NULL. */
	@Override
	String getEventTypeId();

	/** @return file */
	default File getFile() {

		return null;
	}

	/** returns a protocol name, may be used as a hint, must return null if unknown.
	 *
	 * @return string */
	String getProtocolName();

	/** returns a protocol variant name, may be used as a hint, may return null.
	 *
	 * @return string */
	String getProtocolVariant();

	/** @return message */
	default BaseMessage[] getSequence() {

		return null;
	}

	/** returns a string with hardware or software address describing a sender of this message.
	 * I.e.: COM1, LPT2, 127.0.0.1, www.grammy.ru.....
	 *
	 * @return string */
	String getSourceAddress();

	/** returns a string with hardware or software address describing a path of this message. I.e.:
	 * COM1, LPT2, 127.0.0.1, www.grammy.ru.....
	 *
	 * @return string */
	String getSourceAddressExact();

	/** @return string */
	String getTarget();

	/** returns a string with hardware or software address describing a sender of this message.
	 * I.e.: COM1, LPT2, 127.0.0.1, www.grammy.ru.....
	 *
	 * for instance local messages must be NULL
	 *
	 * @return string */
	String getTargetAddress();

	/** @return string */
	String getTargetExact();

	/** returns a line of text shortly describing the type of the message, i.e. "ERROR",
	 * "REQUEST"... Should not ever return <b>null </b> value. */
	@Override
	String getTitle();

	/** returns true when any of getBinary(), getFile(), getText() or getObject() will return
	 * <b>null </b> value.
	 *
	 * @return boolean */
	@Override
	default boolean isEmpty() {

		return false;
	}

	/** returns true when getFile() method would return guaranteed non-null and seems to be existent
	 * instance of java.io.File class.
	 *
	 * @return boolean */
	default boolean isFile() {

		return false;
	}

	/** returns true when getSequence() method whould return guaranteed non-null and seems to be
	 * non-empty array of inner messages enclosed in current message.
	 *
	 * @return boolean */
	default boolean isSequence() {

		return false;
	}

	/** Returns same or new message with corresponding attribute set.
	 * <p>
	 * Throws NullPointerException when attribute value is <b>NULL </b>.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	BaseMessage setAttribute(String name, BaseObject value);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	BaseMessage setAttribute(String name, double value);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	BaseMessage setAttribute(String name, int value);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	BaseMessage setAttribute(String name, long value);

	/** Returns same or new message with corresponding attribute set.
	 * <p>
	 * Throws NullPointerException when attribute value is <b>NULL </b>.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	BaseMessage setAttribute(String name, Object value);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param name
	 * @param value
	 * @return reply */
	BaseMessage setAttribute(String name, String value);

	/** Returns same or new message with corresponding attributes set.
	 *
	 * @param attributes
	 * @return reply */
	BaseMessage setAttributes(BaseObject attributes);

	/** @param disposition
	 * @return */
	BaseMessage setContentDisposition(String disposition);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param contentId
	 * @return message */
	BaseMessage setContentID(String contentId);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param contentName
	 * @return message */
	BaseMessage setContentName(String contentName);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param contentType
	 * @return message */
	BaseMessage setContentType(String contentType);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param charset
	 * @return message */
	BaseMessage setEncoding(Charset charset);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param encoding
	 * @return message */
	BaseMessage setEncoding(String encoding);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param sessionId
	 * @return reply */
	BaseMessage setSessionID(String sessionId);

	/** Returns same or new message with corresponding attribute set.
	 *
	 * @param userId
	 * @return reply */
	BaseMessage setUserID(String userId);

	/** Returns a response whose isEmpty(), isBinary() or isFile() method will return <b>true </b>
	 * and getBinary() or getFile() will return a binary non-null representation of a response. When
	 * a response is already meets conditions secified this method should return exactly the SAME
	 * response object. The "Character-Encoding" of "Content-Type" attributes of a current response
	 * and "Accept-Charset" or "Accept-Type" attributes of current query should be considered when
	 * possible. "UTF-8" encoding should be used by default.
	 *
	 * @return message
	 * @throws Flow.FlowOperationException,
	 *             Transfer.TransferOperationException */
	@Override
	default BinaryMessage<?> toBinary() {

		if (this.isEmpty() || this.isBinary() || this.isFile()) {
			assert this instanceof BinaryMessage : "Expected to be an instance of BodyAccessBinary, class: " + this.getClass().getName();
			return (BinaryMessage<?>) this;
		}
		if (this.isCharacter()) {
			assert this instanceof CharacterMessage : "Expected to be an instance of CharacterMessage, class: " + this.getClass().getName();
			return Flow.binaryWrapCharacter((CharacterMessage<?>) this);
		}
		if (this.isObject()) {
			final BaseObject ownAttributes = this.getAttributes();
			assert ownAttributes != null : "NULL java object!";
			final BaseObject newAttributes = BaseObject.createObject(ownAttributes);
			final TransferCollector collector = Transfer.createCollector();
			final SerializationRequest request = new SerializationRequest() {

				@Override
				public String[] getAcceptTypes() {

					return null;
				}

				@Override
				public Object getObject() {

					return BaseMessage.this.getObject();
				}

				@Override
				public Class<?> getObjectClass() {

					return BaseMessage.this.getObjectClass();
				}

				@Override
				public TransferCollector setResultType(final String contentType) {

					newAttributes.baseDefine("Content-Type", contentType);
					return collector;
				}
			};
			try {
				if (Transform.serialize(request)) {
					return Flow.binary(this.getEventTypeId(), this.getTitle(), newAttributes, collector.toBuffer());
				}
				collector.close();
				return Flow.empty(this.getEventTypeId(), this.getTitle(), this.getAttributes());
			} catch (final IOException e) {
				collector.close();
				return Flow.binary(
						this.getEventTypeId(),
						this.getTitle(),
						BaseObject.createObject(null).putAppend("Content-Type", "text/plain; charset=UTF-8"),
						Transfer.createBuffer(Format.Throwable.toText(e).getBytes(StandardCharsets.UTF_8)));
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
	 * @return message
	 * @throws Flow.FlowOperationException */
	@Override
	default CharacterMessage<?> toCharacter() throws Flow.FlowOperationException, Transfer.TransferOperationException {

		if (this.isEmpty() || this.isCharacter()) {
			assert this instanceof CharacterMessage : "Expected to be an instance of CharacterMessage, class: " + this.getClass().getName();
			return (CharacterMessage<?>) this;
		}
		if (this.isBinary()) {
			assert this instanceof BinaryMessage : "Expected to be an instance of BinaryMessage, class: " + this.getClass().getName();
			return Flow.characterWrapBinary((BinaryMessage<?>) this);
		}
		if (this.isFile()) {
			final BaseObject ownAttributes = this.getAttributes();
			assert ownAttributes != null : "NULL java object!";
			final TransferBuffer buffer = Transfer.createBuffer(this.getFile());
			final String contentType = Base.getString(ownAttributes, "Content-Type", "application/octet-stream");
			final String currentEncoding = Base.getString(Flow.mimeAttribute("", "", contentType), "charset", "").trim();
			final String encoding = currentEncoding.length() > 0
				? currentEncoding
				: Base.getString(ownAttributes, "Character-Encoding", Engine.ENCODING_UTF8);
			final String chosenEncoding = encoding.indexOf('*') != -1
				? Engine.ENCODING_UTF8
				: encoding;
			final BaseObject attributes = BaseObject.createObject();
			if (!ownAttributes.baseIsPrimitive()) {
				attributes.baseDefineImportAllEnumerable(ownAttributes);
			}
			if (currentEncoding.length() == 0) {
				attributes.baseDefine("Content-Type", contentType + "; charset=" + chosenEncoding);
			}
			final String text;
			try {
				text = new String(buffer.toDirectArray(), chosenEncoding);
			} catch (final UnsupportedEncodingException e) {
				throw new Flow.FlowOperationException("Error creating String from Buffer", e);
			}
			return Flow.character(this.getEventTypeId(), this.getTitle(), attributes, text);
		}
		{
			return Flow.character(
					"ABSTRACT-MESSAGE",
					"Error",
					BaseObject.createObject(null).putAppend("Content-Type", "text/plain"),
					"Cannot convert to character response, class=" + this.getClass().getName() + ", contentClass=" + this.getObjectClass());
		}
	}

	/** Returns the SAME response object.
	 *
	 * @param attributes
	 * @return reply */
	BaseMessage useAttributes(BaseObject attributes);
}
