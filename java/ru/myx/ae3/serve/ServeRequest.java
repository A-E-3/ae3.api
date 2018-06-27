/*
 * Created on 24.03.2006
 */
package ru.myx.ae3.serve;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.function.Function;

import ru.myx.ae3.Engine;
import ru.myx.ae3.answer.ReplyAnswer;
import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseMessage;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.binary.Transfer;
import ru.myx.ae3.binary.TransferBuffer;
import ru.myx.ae3.binary.TransferCollector;
import ru.myx.ae3.flow.Flow;
import ru.myx.ae3.help.Format;
import ru.myx.ae3.reflect.Reflect;
import ru.myx.ae3.transform.SerializationRequest;
import ru.myx.ae3.transform.Transform;

/** @author myx */
public interface ServeRequest extends BaseMessage {

	/**
	 *
	 */
	static BaseObject PROTOTYPE = Reflect.classToBasePrototype(ServeRequest.class);

	/** Used to indicate that the transaction was aborted and that any further response processing
	 * may be safely omitted.
	 * <p>
	 *
	 * Useful when there is an implemented possibility to cancel any activities related to
	 * processing of enqueued response(s). In any other case this method should perform same work as
	 * <b>done() </b> does at least. */
	void abort();

	/** Returns the SAME request object. It is recommended to use this method while setting
	 * attributes to a "abstract" request because it is legal to return unmodifiable Map<?,?> via
	 * getAttributes() method call while this method guarantees at least not to throw an exception.
	 * Throws NullPointerException when attribute value is <b>NULL </b>.
	 *
	 * @param name
	 * @param value
	 *
	 * @return same request */
	ServeRequest addParameter(String name, BaseObject value);

	/** Returns the SAME request object. It is recommended to use this method while setting
	 * attributes to a "abstract" request because it is legal to return unmodifiable Map<?,?> via
	 * getAttributes() method call while this method guarantees at least not to throw an exception.
	 *
	 * @param name
	 * @param value
	 *
	 * @return same request */
	default ServeRequest addParameter(final String name, final double value) {

		return this.addParameter(name, Base.forDouble(value));
	}

	/** Returns the SAME request object. It is recommended to use this method while setting
	 * attributes to a "abstract" request because it is legal to return unmodifiable Map<?,?> via
	 * getAttributes() method call while this method guarantees at least not to throw an exception.
	 *
	 * @param name
	 * @param value
	 *
	 * @return same request */
	default ServeRequest addParameter(final String name, final long value) {

		return this.addParameter(name, Base.forLong(value));
	}

	/** Returns the SAME request object. It is recommended to use this method while setting
	 * attributes to a "abstract" request because it is legal to return unmodifiable Map<?,?> via
	 * getAttributes() method call while this method guarantees at least not to throw an exception.
	 * Throws NullPointerException when attribute value is <b>NULL </b>.
	 *
	 * @param name
	 * @param value
	 *
	 * @return same request */
	default ServeRequest addParameter(final String name, final Object value) {

		return this.addParameter(name, Base.forUnknown(value));
	}

	/** Returns the SAME request object. It is recommended to use this method while setting
	 * attributes to a "abstract" request because it is legal to return unmodifiable Map<?,?> via
	 * getAttributes() method call while this method guarantees at least not to throw an exception.
	 *
	 * @param name
	 * @param value
	 *
	 * @return same request */
	default ServeRequest addParameter(final String name, final String value) {

		return this.addParameter(name, Base.forString(value));
	}

	@Override
	default BaseObject basePrototype() {

		return ServeRequest.PROTOTYPE;
	}

	/** Used to indicate that 'the case is closed' and there are no more responses to be ever
	 * enqueued for this queue. */
	void done();

	/** Must not return <b>null </b> when hasArguments() returns <b>true </b>.
	 *
	 * @return query arguments */
	String[] getArguments();

	/** Returns an attachment
	 *
	 * @return attachment */
	Object getAttachment();

	/** Returns known request language or null.
	 *
	 * @return language name */
	String getLanguage();

	/** Must not return <b>null </b> when hasParameters() returns <b>true </b>.
	 *
	 * @return query parameters */
	BaseObject getParameters();

	/** Returns an original stringual representation of passed parameters, must not return <b>null
	 * </b> when hasParameters() returns <b>true </b>.
	 *
	 * @return query string */
	String getParameterString();

	/** URL, URI, Path, ID and so on... Any stringual representation of requested identity.
	 *
	 * @return resource identifier */
	String getResourceIdentifier();

	/** Returns the prefix part of current resourceIdentifier. Without trailing '/'.
	 *
	 * @return resource prefix */
	String getResourcePrefix();

	/** @return accepted response class */
	Class<?> getResponseClass();

	/** Returns an Act.Function for passing responses to this query.
	 *
	 * @return response target */
	Function<ReplyAnswer, Boolean> getResponseTarget();

	/** @return sessionId */
	String getSessionID();

	/** Returns settings
	 *
	 * @return common settings */
	BaseObject getSettings();

	/** Returns true while this request is still actual.
	 *
	 * @return boolean */
	boolean getStillActual();

	/** returns target name/address used in request to reach the service.
	 *
	 * @return */
	@Override
	String getTarget();

	/** returns exact target name/address used in request to reach the service.
	 *
	 * @return */
	@Override
	String getTargetExact();

	/** returns an external url used to reach the service if available or null.
	 *
	 * @return url */
	String getUrl();

	/** Returns an external url base used to reach the service if available or null. The 'base' is a
	 * root url part which concatenated with getResourceIdentifier() will return the same string as
	 * returned by getUrl() method. Base is used to calculate incomplete urls when doing a
	 * redirection or in any other cases where local (relative) urls are used.
	 *
	 * @return url base */
	String getUrlBase();

	/** @return userId */
	String getUserID();

	/** Returns a verb to describe the reason for this request, this method should NEVER return
	 * <b>null </b>.
	 *
	 * @return verb */
	String getVerb();

	/** Returns an original verb in this request since this verb can be replaced while it's required
	 * to know original verb.
	 *
	 * @return verb */
	String getVerbOriginal();

	/** returns true when there is guaranteed non-null and seems to be non-empty array of arguments
	 * available.
	 *
	 * @return boolean */
	boolean hasArguments();

	/** returns true when there is guaranteed non-null and seems to be non-empty map of parameters
	 * available.
	 *
	 * @return boolean */
	boolean hasParameters();

	/** Sets new attachment returns previous attachment
	 *
	 * @param attachment
	 * @return previous attachment */
	Object setAttachment(Object attachment);

	/** Returns the SAME request object.
	 *
	 * @param language
	 *
	 * @return same request */
	ServeRequest setLanguage(String language);

	/** Returns the SAME request object. It is recommended to use this method while setting
	 * attributes to a "abstract" request because it is legal to return unmodifiable Map<?,?> via
	 * getAttributes() method call while this method guarantees at least not to throw an exception.
	 *
	 * @param date
	 *
	 * @return same request */
	ServeRequest setLastModified(long date);

	/** Returns the SAME request object. It is recommended to use this method while setting
	 * attributes to a "abstract" request because it is legal to return unmodifiable Map<?,?> via
	 * getAttributes() method call while this method guarantees at least not to throw an exception.
	 * <p>
	 * Throws NullPointerException when attribute value is <b>NULL </b>.
	 *
	 * @param name
	 * @param value
	 *
	 * @return same request */
	ServeRequest setParameter(String name, BaseObject value);

	/** Returns the SAME request object. It is recommended to use this method while setting
	 * attributes to a "abstract" request because it is legal to return unmodifiable Map<?,?> via
	 * getAttributes() method call while this method guarantees at least not to throw an exception.
	 *
	 * @param name
	 * @param value
	 *
	 * @return same request */
	default ServeRequest setParameter(final String name, final double value) {
		
		return this.setParameter(name, Base.forDouble(value));
	}

	/** Returns the SAME request object. It is recommended to use this method while setting
	 * attributes to a "abstract" request because it is legal to return unmodifiable Map<?,?> via
	 * getAttributes() method call while this method guarantees at least not to throw an exception.
	 *
	 * @param name
	 * @param value
	 *
	 * @return same request */
	default ServeRequest setParameter(final String name, final long value) {

		return this.setParameter(name, Base.forLong(value));
	}

	/** Returns the SAME request object. It is recommended to use this method while setting
	 * attributes to a "abstract" request because it is legal to return unmodifiable Map<?,?> via
	 * getAttributes() method call while this method guarantees at least not to throw an exception.
	 * <p>
	 * Throws NullPointerException when attribute value is <b>NULL </b>.
	 *
	 * @param name
	 * @param value
	 *
	 * @return same request */
	default ServeRequest setParameter(final String name, final Object value) {

		return this.setParameter(name, Base.forUnknown(value));
	}

	/** Returns the SAME request object. It is recommended to use this method while setting
	 * attributes to a "abstract" request because it is legal to return unmodifiable Map<?,?> via
	 * getAttributes() method call while this method guarantees at least not to throw an exception.
	 *
	 * @param name
	 * @param value
	 *
	 * @return same request */
	default ServeRequest setParameter(final String name, final String value) {
		
		return this.setParameter(name, Base.forString(value));
	}

	/** Returns the SAME request object. It is recommended to use this method while setting
	 * parameters to a "abstract" request because it is legal to return unmodifiable Map<?,?> via
	 * getParameters() method call while this method guarantees at least not to throw an exception.
	 *
	 * @param parameters
	 *
	 * @return same request */
	ServeRequest setParameters(BaseObject parameters);

	/** Returns the SAME request object.
	 *
	 * @param resourceIdentifier
	 *
	 * @return same request */
	ServeRequest setResourceIdentifier(String resourceIdentifier);

	/** Returns the SAME request object.
	 *
	 * @param resourcePrefix
	 *
	 * @return same request */
	ServeRequest setResourcePrefix(String resourcePrefix);

	/** Returns the SAME request object.
	 *
	 * @param responseClass
	 *
	 * @return same request */
	ServeRequest setResponseClass(Class<?> responseClass);

	/** Returns the SAME request object.
	 *
	 * @param responseTarget
	 *
	 * @return same request */
	ServeRequest setResponseTarget(Function<ReplyAnswer, Boolean> responseTarget);

	/** Returns the SAME request object.
	 *
	 * @param settings
	 *
	 * @return same request */
	ServeRequest setSettings(BaseObject settings);

	/** Returns the SAME request object.
	 *
	 * @param sourceAddress
	 *
	 * @return same request */
	ServeRequest setSourceAddress(String sourceAddress);

	/** Returns the SAME request object.
	 *
	 * @param sourceAddressExact
	 *
	 * @return same request */
	ServeRequest setSourceAddressExact(final String sourceAddressExact);

	/** @param target
	 * @return same request */
	ServeRequest setTarget(String target);

	/** @param targetExact
	 * @return same request */
	ServeRequest setTargetExact(String targetExact);

	/** Returns the SAME request object.
	 *
	 * @param url
	 *
	 * @return same request */
	ServeRequest setUrl(String url);

	/** Returns the SAME request object.
	 *
	 * @param urlBase
	 *
	 * @return same request */
	ServeRequest setUrlBase(String urlBase);

	/** Returns the SAME request object.
	 *
	 * @param verb
	 *
	 * @return same request */
	ServeRequest setVerb(String verb);

	/** Returns the SAME request object.
	 *
	 * @param characters
	 * @param shiftBase
	 *
	 * @return same request */
	ServeRequest shiftRequested(int characters, boolean shiftBase);

	/** Returns a request whose isEmpty(), isBinary() or isFile() method will return <b>true </b>
	 * and getBinary() or getFile() will return a binary non-null representation of a response. When
	 * a response is already meets conditions specified this method should return exactly the SAME
	 * response object. The "Character-Encoding" of "Content-Type" attributes of a current response
	 * and "Accept-Charset" or "Accept-Type" attributes of current query should be considered when
	 * possible. "UTF-8" encoding should be used by default.
	 *
	 * @return reply
	 * @throws Flow.FlowOperationException */
	@Override
	default BinaryServeRequest<?> toBinary() throws Flow.FlowOperationException {

		if (this.isEmpty() || this.isBinary()) {
			assert this instanceof BinaryServeRequest : "Expected to be an instance of BinaryServeRequest, class: " + this.getClass().getName();
			return (BinaryServeRequest<?>) this;
		}
		if (this.isCharacter()) {
			assert this instanceof CharacterServeRequest : "Expected to be an instance of CharacterServeRequest, class: " + this.getClass().getName();
			try {
				return Request.binaryWrapCharacter((CharacterServeRequest<?>) this);
			} catch (final UnsupportedEncodingException e) {
				throw new Flow.FlowOperationException("Error converting from character to binary", e);
			}
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

					return this.getObject();
				}

				@Override
				public Class<?> getObjectClass() {

					return this.getObjectClass();
				}

				@Override
				public TransferCollector setResultType(final String contentType) {

					newAttributes.baseDefine("Content-Type", contentType);
					return collector;
				}
			};
			try {
				if (Transform.serialize(request)) {
					return Request.binary(this.getEventTypeId(), this.getTitle(), collector.toBuffer(), newAttributes);
				}
				collector.close();
				return Request.empty(this.getEventTypeId(), this.getTitle(), newAttributes);
			} catch (final IOException e) {
				collector.close();
				return Request.binary(
						this.getEventTypeId(),
						this.getTitle(),
						Transfer.createBuffer(Format.Throwable.toText(e).getBytes(Engine.CHARSET_UTF8)),
						BaseObject.createObject(null).putAppend("Content-Type", "text/plain; charset=UTF-8"));
			}
		}
		return null;
	}

	/** Returns a request whose isEmpty(), isTextual() or isObject() method will return <b>true </b>
	 * and getText() or getObject() will return a <b>non-null </b> stringual representation of a
	 * response. When a response is already meets conditions specified this method should return
	 * exactly the SAME response object. The "Character-Encoding" attribute of a current response
	 * and "Accept-Charset" attribute of current query should be considered when possible. "UTF-8"
	 * encoding should be used by default.
	 *
	 * @return reply
	 * @throws Flow.FlowOperationException */
	@Override
	default CharacterServeRequest<?> toCharacter() throws Flow.FlowOperationException {

		if (this.isEmpty() || this.isCharacter()) {
			assert this instanceof CharacterServeRequest : "Expected to be an instance of CharacterServeRequest, class: " + this.getClass().getName();
			return (CharacterServeRequest<?>) this;
		}
		if (this.isBinary()) {
			assert this instanceof BinaryServeRequest : "Expected to be an instance of BinaryServeRequest, class: " + this.getClass().getName();
			try {
				return Request.characterWrapBinary((BinaryServeRequest<?>) this);
			} catch (final UnsupportedEncodingException e) {
				throw new Flow.FlowOperationException("Error converting from binary to character", e);
			}
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
			return Request.character(this.getEventTypeId(), this.getTitle(), attributes, text);
		}
		{
			return Request.character(
					"ABSTRACT-MESSAGE",
					"Error",
					BaseObject.createObject(null).putAppend("Content-Type", "text/plain"),
					"Cannot convert to character response, class=" + this.getClass().getName() + ", contentClass=" + this.getObjectClass());
		}
	}

	/** returns null when this request is secure or an answer to switch to secure mode or to display
	 * a message that secure channel is unavailable.
	 *
	 * @return reply to switch to secure channel */
	ReplyAnswer toSecureChannel();

	/** returns null when this request is unsecure or an answer to switch to unsecure mode or to
	 * display a message that unsecure channel is unavailable.
	 *
	 * @return reply to switch to unsecure channel */
	ReplyAnswer toUnSecureChannel();
}
