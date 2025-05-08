/**
 * Created on 28.11.2002
 *
 * myx - barachta */
package ru.myx.ae3.answer;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.StringTokenizer;

import ru.myx.ae3.AbstractSAPI;
import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseMessage;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.base.BaseProperty;
import ru.myx.ae3.binary.Transfer;
import ru.myx.ae3.binary.TransferBuffer;
import ru.myx.ae3.binary.TransferCopier;
import ru.myx.ae3.flow.CharacterMessage;
import ru.myx.ae3.flow.Flow;
import ru.myx.ae3.flow.FlowOperationException;
import ru.myx.ae3.vfs.EntryBinary;

/** CD_XXX codes represent values of HTTP response codes, you can look up their values and
 * descriptions online http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html
 *
 *
 *
 * @author barachta
 *
 *         myx - barachta "typecomment": Window>Preferences>Java>Templates. To enable and disable
 *         the creation of type comments go to Window>Preferences>Java>Code Generation. */
public class Reply extends AbstractSAPI {

	/**
	 *
	 */
	public static final ReplyAnswer ASYNC;

	/** Numeric == 202
	 *
	 * Status code (202) indicating that a request was accepted for processing, but was not
	 * completed. */
	public static final int CD_ACCEPTED = 202;

	/** replace with CD_UNAUTHORIZED
	 *
	 * Numeric == 401, Authorization required
	 *
	 * Status code (401) indicating that the request requires HTTP authentication. */
	@Deprecated
	public static final int CD_AUTHORIZE = 401;

	/** Numeric == 502, Bag gateway
	 *
	 * Status code (502) indicating that the HTTP server received an invalid response from a server
	 * it consulted when acting as a proxy or gateway. */
	public static final int CD_BADGATEWAY = 502;

	/** Numeric == 405, Bad method
	 *
	 * Status code (405) indicating the method specified is not allowed for the resource. */
	public static final int CD_BADMETHOD = 405;

	/** Numeric == 400, Bad request encountered
	 *
	 * Status code (400) indicating the request sent by the client was syntactically incorrect. */
	public static final int CD_BADQUERY = 400;

	/** Numeric == 416, Bad range */
	public static final int CD_BADRANGE = 416;

	/** Numeric == 451, Blocked For Legal Reasons */
	public static final int CD_BLOCKED_451 = 451;

	/** Numeric == 503, Server is too busy
	 *
	 * Status code (503) indicating that the HTTP service is temporarily overloaded, and unable to
	 * handle the request. */
	public static final int CD_BUSY = 503;

	/** Numeric == 409, Conflict
	 *
	 * Status code (409) indicating that the request could not be completed due to a conflict with
	 * the current state of the resource. */
	public static final int CD_CONFLICT = 409;

	/** Numeric == 100, Continue
	 *
	 * Status code (100) indicating the client may continue with its request. This interim response
	 * is used to inform the client that the initial part of the request has been received and has
	 * not yet been rejected by the server. */
	public static final int CD_CONTINUE = 100;

	/** Numeric == 201
	 *
	 * Status code (201) indicating the request succeeded and created a new resource on the
	 * server. */
	public static final int CD_CREATED = 201;

	/** Numeric == 403, Access is forbidden
	 *
	 * Status code (403) indicating the server understood the request but refused to fulfill it. */
	public static final int CD_DENIED = 403;

	/** Numeric == 204, Empty result
	 *
	 * Status code (204) indicating that the request succeeded but that there was no new information
	 * to return. */
	public static final int CD_EMPTY = 204;

	/** Numeric == 500, Server produced error
	 *
	 * Status code (500) indicating an error inside the HTTP service which prevented it from
	 * fulfilling the request. */
	public static final int CD_EXCEPTION = 500;

	/** Numeric == 412, Data was not found or unknown
	 *
	 * Status code (412) indicating the precondition given in one or more of the request-header
	 * fields evaluated to false when it was tested on the server. */
	public static final int CD_FAILED_PRECONDITION = 412;

	/** Numeric == 504, Gateway Timeout
	 *
	 * Status code (504) indicating that the HTTP service was unable to receive gateway reply within
	 * time allotted. */
	public static final int CD_GATEWAY_TIMEOUT = 504;

	/** Numeric == 507, Insufficient Storage
	 *
	 * Status code (507) indicating that the there is 'insufficient storage' condition. */
	public static final int CD_INSUFFICIENT_STORAGE = 507;

	/** Numeric == 423, Data was not found or unknown */
	public static final int CD_LOCKED = 423;

	/** Numeric == 302, Try looking at
	 *
	 * Status code (302) indicating that the resource has temporarily moved to another location, but
	 * that future references should still use the original URI to access the resource. */
	public static final int CD_LOOKAT = 302;

	/** Numeric == 301, Moved permanently
	 *
	 * Status code (301) indicating that the resource has permanently moved to a new location, and
	 * that future references should use a new URI with their requests. */
	public static final int CD_MOVED = 301;

	/** Numeric == 207, Partial result
	 *
	 * Status code (207) indicating that the response requires providing status for multiple
	 * independent operations. */
	public static final int CD_MULTISTATUS = 207;

	/** Numeric == 200, Data follows
	 *
	 * Status code (200) indicating the request succeeded normally. */
	public static final int CD_OK = 200;

	/** Numeric == 206, Partial result */
	public static final int CD_PARTIAL = 206;

	/** Numeric == 402, Payment required
	 *
	 * Status code (402) indicating that the request cannot be served though seems valid. */
	public static final int CD_PAYMENT_REQUIRED = 402;

	/** TODO: replace with -111???
	 *
	 * Numeric == 111, Response delays */
	public static final int CD_PROCESSING = 111;

	/** TODO: replace with -112???
	 *
	 * Numeric == 112, Response delays */
	public static final int CD_RAW_PROTOCOL = 112;

	/** Numeric == 101, Switching Protocols */
	public static final int CD_SWITCHING_PROTOCOLS = 101;

	/** Numeric == 401, Authorization required
	 *
	 * Status code (401) indicating that the request requires HTTP authentication. */
	public static final int CD_UNAUTHORIZED = 401;

	/** Numeric == 501
	 *
	 * Status code (501) indicating the HTTP service does not support the functionality needed to
	 * fulfill the request. */
	public static final int CD_UNIMPLEMENTED = 501;

	/** Numeric == 404, Data was not found or unknown
	 *
	 * Status code (404) indicating that the requested resource is not available. */
	public static final int CD_UNKNOWN = 404;

	/** Numeric == 304, Data is not modified since
	 *
	 * Status code (304) indicating that a conditional GET operation found that the resource was
	 * available and not modified. */
	public static final int CD_UNMODIFIED = 304;

	/** Numeric == 415, Unsupported command or data type
	 *
	 * Status code (415) indicating the server is refusing to service the request because the entity
	 * of the request is in a format not supported by the requested resource for the requested
	 * method. */
	public static final int CD_UNSUPPORTED_FORMAT = 415;

	private static final AbstractReplyImpl REPLY_IMPL;

	static {
		REPLY_IMPL = AbstractSAPI.createObject("ru.myx.ae3.answer.ImplementReply");
		ASYNC = Reply.REPLY_IMPL.empty("ASYNC-DEFAULT", null, null).setCode(Reply.CD_PROCESSING).setFinal();
	}

	/** @param owner
	 * @param query
	 * @return */
	public static final ReplyAnswer async(final String owner, final BaseMessage query) {

		return Reply.string(owner, query, "async").setCode(Reply.CD_PROCESSING).setFinal();
	}

	/** @param owner
	 * @param query
	 * @param attributes
	 * @param buffer
	 * @return reply */
	public static final BinaryReplyAnswer<?> binary(final String owner, final BaseMessage query, final BaseObject attributes, final TransferBuffer buffer) {

		return Reply.REPLY_IMPL.binary(owner, query, attributes, buffer, null);
	}

	/** @param owner
	 * @param query
	 * @param attributes
	 * @param buffer
	 * @param fileName
	 * @return reply */
	public static final BinaryReplyAnswer<?> binary(final String owner, final BaseMessage query, final BaseObject attributes, final TransferBuffer buffer, final String fileName) {

		return Reply.REPLY_IMPL.binary(owner, query, attributes, buffer, fileName);
	}

	/** @param owner
	 * @param query
	 * @param attributes
	 * @param copier
	 * @return reply */
	public static final BinaryReplyAnswer<?> binary(final String owner, final BaseMessage query, final BaseObject attributes, final TransferCopier copier) {

		return Reply.REPLY_IMPL.binary(owner, query, attributes, copier, null);
	}

	/** @param owner
	 * @param query
	 * @param attributes
	 * @param copier
	 * @param fileName
	 * @return reply */
	public static final BinaryReplyAnswer<?> binary(final String owner, final BaseMessage query, final BaseObject attributes, final TransferCopier copier, final String fileName) {

		return Reply.REPLY_IMPL.binary(owner, query, attributes, copier, fileName);
	}

	/** @param owner
	 * @param query
	 * @param buffer
	 * @return reply */
	public static final BinaryReplyAnswer<?> binary(final String owner, final BaseMessage query, final TransferBuffer buffer) {

		return Reply.binary(owner, query, buffer, null);
	}

	/** @param owner
	 * @param query
	 * @param buffer
	 * @param fileName
	 * @return reply */
	public static final BinaryReplyAnswer<?> binary(final String owner, final BaseMessage query, final TransferBuffer buffer, final String fileName) {

		return Reply.REPLY_IMPL.binary(owner, query, null, buffer, fileName);
	}

	/** @param owner
	 * @param query
	 * @param copier
	 * @return reply */
	public static final BinaryReplyAnswer<?> binary(final String owner, final BaseMessage query, final TransferCopier copier) {

		return Reply.binary(owner, query, copier, (String) null);
	}

	/** @param owner
	 * @param query
	 * @param copier
	 * @param fileName
	 * @return reply */
	public static final BinaryReplyAnswer<?> binary(final String owner, final BaseMessage query, final TransferCopier copier, final String fileName) {

		return Reply.REPLY_IMPL.binary(owner, query, null, copier, fileName);
	}

	/** @param owner
	 * @param query
	 * @param attributes
	 * @param copier
	 * @param text
	 * @return reply */
	public static final UniversalReplyAnswer<?>
			binaryAndCharacter(final String owner, final BaseMessage query, final BaseObject attributes, final TransferCopier copier, final CharSequence text) {

		return Reply.REPLY_IMPL.binaryAndCharacter(owner, query, attributes, copier, text);
	}

	/** @param characterReply
	 * @return */
	public static UniversalReplyAnswer<?> binaryWrapCharacter(final CharacterReplyAnswer<?> characterReply) {

		if (characterReply == null) {
			throw new NullPointerException("NULL characterReply!");
		}
		/** can't really use it since implementors could use this method to implement toBinary
		 * method,... <code>
		if (characterReply instanceof UniversalReplyAnswer<?>
				&& (characterReply.isBinary() || characterReply.isEmpty())) {
			assert characterReply.isCharacter() : "Supposed to an isCharacter";
			return (UniversalReplyAnswer<?>) characterReply;
		}
		 * </code> ...we will enforce that they checked and handled it explicitly before calling
		 * this method */
		assert !characterReply.isBinary() : //
				"Supposed to check and handle isBinary() explicitly before calling this method";
		//
		assert characterReply.isCharacter() : "Supposed to be isCharacter";
		//
		final CharSequence text = characterReply.getText();
		CharacterMessage<?> contentType = null;
		// responses mostly do have attributes anyway
		final BaseObject originalAttributes = characterReply.getAttributes();
		final BaseObject attributes = BaseObject.createObject(originalAttributes);
		if (originalAttributes != null) {
			ownContentTypeAttribute : {
				final String contentTypeString = Base.getString(originalAttributes, "Content-Type", "").trim();
				if (contentTypeString.length() == 0) {
					break ownContentTypeAttribute;
				}
				contentType = Flow.mimeAttribute("", "", contentTypeString);
				final String explicitEncoding = Base.getString(contentType.getAttributes(), "charset", "").trim();
				if (explicitEncoding.length() > 0) {
					final Charset charset = Charset.forName(explicitEncoding);
					final TransferCopier binary = Transfer.createCopier(text, charset);
					/** define contentLength for MIME compatibility */
					attributes.baseDefine("Content-Length", binary.length());
					return Reply.binaryAndCharacter(
							characterReply.getEventTypeId(), //
							characterReply.getQuery(),
							attributes,
							binary,
							text)//
							.setCode(characterReply.getCode())//
							.useFlags(characterReply.getFlags());
				}
			}
			ownContentCharsetAttribute : {
				final String contentCharset = Base.getString(originalAttributes, "Content-Charset", "").trim();
				if (contentCharset.length() == 0) {
					break ownContentCharsetAttribute;
				}
				final Charset charset = Charset.forName(contentCharset);
				final TransferCopier binary = Transfer.createCopier(text, charset);
				/** define contentType attribute for MIME compatibility */
				attributes.baseDefine(
						"Content-Type",
						(contentType != null
							? contentType.getText() + "; charset="
							: "text/plain; charset=") + contentCharset);
				/** define contentLength for MIME compatibility */
				attributes.baseDefine("Content-Length", binary.length());
				return Reply.binaryAndCharacter(
						characterReply.getEventTypeId(), //
						characterReply.getQuery(),
						attributes,
						binary,
						text)//
						.setCode(characterReply.getCode())//
						.useFlags(characterReply.getFlags());
			}
		}
		clientNonDefaultCharset : {
			final BaseMessage query = characterReply.getQuery();
			if (query == null) {
				break clientNonDefaultCharset;
			}
			final String acceptCharset = Base.getString(query.getAttributes(), "Accept-Charset", "").trim();
			if (acceptCharset.length() == 0 || acceptCharset.lastIndexOf('*') != -1) {
				break clientNonDefaultCharset;
			}
			Charset charset = null;
			for (final StringTokenizer st = new StringTokenizer(acceptCharset, ","); st.hasMoreTokens();) {
				final String headerItem = st.nextToken();
				final int pos = headerItem.indexOf(';');
				final String charsetName;
				if (pos == -1) {
					charsetName = headerItem.trim();
				} else {
					charsetName = headerItem.substring(0, pos).trim();
				}
				try {
					final Charset tryCharset = Charset.forName(charsetName);
					if (tryCharset == StandardCharsets.UTF_8) {
						break clientNonDefaultCharset;
					}
					if (charset == null) {
						charset = tryCharset;
					}
				} catch (final UnsupportedCharsetException e) {
					// proceed to default UTF-8
					break clientNonDefaultCharset;
				} catch (final IllegalCharsetNameException e) {
					// proceed to default UTF-8
					break clientNonDefaultCharset;
				}
			}
			if (charset != null) {
				final TransferCopier binary = Transfer.createCopier(text, charset);
				final String charsetName = charset.name();
				attributes.baseDefine("Content-Charset", charsetName);
				attributes.baseDefine("Content-Type", "text/plain; charset=" + charsetName);
				attributes.baseDefine("Content-Length", binary.length());
				return Reply.binaryAndCharacter(
						characterReply.getEventTypeId(), //
						characterReply.getQuery(),
						attributes,
						binary,
						text)//
						.setCode(characterReply.getCode())//
						.useFlags(characterReply.getFlags());
			}
		}
		{
			final TransferCopier binary = Transfer.createCopierUtf8(text);
			attributes.baseDefine(
					"Content-Type",
					contentType != null
						? contentType.getText() + "; charset=UTF-8"
						: "text/plain; charset=UTF-8");
			attributes.baseDefine("Content-Charset", "UTF-8");
			attributes.baseDefine("Content-Length", binary.length());
			return Reply.REPLY_IMPL.wrapCharacterReplyAsUniversal(characterReply, attributes, binary);
		}
	}

	/** same as 'string'
	 *
	 * @param owner
	 * @param query
	 * @param attributes
	 * @param text
	 * @return reply */
	public static final CharacterReplyAnswer<?> character(final String owner, final BaseMessage query, final BaseObject attributes, final CharSequence text) {

		return Reply.REPLY_IMPL.character(owner, query, attributes, text);
	}

	/** same as 'string'
	 *
	 * @param owner
	 * @param query
	 * @param text
	 * @return reply */
	public static final CharacterReplyAnswer<?> character(final String owner, final BaseMessage query, final CharSequence text) {

		return Reply.REPLY_IMPL.character(owner, query, null, text);
	}

	/** @param binaryReply
	 * @return */
	public static UniversalReplyAnswer<?> characterWrapBinary(final BinaryReplyAnswer<?> binaryReply) {

		if (binaryReply == null) {
			throw new NullPointerException("NULL binaryReply!");
		}
		/** can't really use it since implementors could use this method to implement toBinary
		 * method,... <code>
		if (binaryReply instanceof UniversalReplyAnswer<?>
				&& (binaryReply.isCharacter() || binaryReply.isEmpty())) {
			return (UniversalReplyAnswer<?>) binaryReply;
		}
		 * </code> ...we will enforce that they checked and handled it explicitly before calling
		 * this method */
		assert !binaryReply.isCharacter() : //
				"Supposed to check and handle isCharacter() explicitly before calling this method";
		//
		assert binaryReply.isBinary() : "Supposed to be isBinary";
		//
		final BaseObject originalAttributes = binaryReply.getAttributes();
		final String contentType = Base.getString(originalAttributes, "Content-Type", "application/octet-stream");
		final String currentEncoding = Base.getString(Flow.mimeAttribute("", "", contentType).getAttributes(), "charset", "").trim();
		final String UTF8 = "UTF8";
		final String encoding = currentEncoding.length() > 0
			? currentEncoding
			: originalAttributes == null
				? UTF8
				: Base.getString(
						originalAttributes,
						"Content-Charset",
						binaryReply.getQuery() == null
							? null
							: binaryReply.getQuery().getAttributes(),
						"Accept-Charset",
						UTF8);
		final String chosenEncoding = encoding != UTF8 && encoding.indexOf('*') != -1
			? UTF8
			: encoding;
		final BaseObject attributes;
		if (currentEncoding.length() == 0) {
			attributes = BaseObject.createObject(originalAttributes);
			attributes.baseDefine("Content-Type", contentType + "; charset=" + chosenEncoding, BaseProperty.ATTRS_MASK_WED);
		} else {
			attributes = originalAttributes;
		}
		final TransferCopier binary = binaryReply.getBinary();
		try {
			return Reply.REPLY_IMPL.wrapBinaryReplyAsUniversal(binaryReply, attributes, binary.toString(chosenEncoding));
		} catch (final UnsupportedEncodingException e) {
			throw new FlowOperationException("Error converting from binary to character", e);
		}
	}

	/** @param owner
	 * @param query
	 * @return reply */
	public static final UniversalReplyAnswer<?> empty(final String owner, final BaseMessage query) {

		return Reply.REPLY_IMPL.empty(owner, query, null).setCode(Reply.CD_EMPTY);
	}

	/** @param owner
	 * @param query
	 * @param attributes
	 * @return reply */
	public static final UniversalReplyAnswer<?> empty(final String owner, final BaseMessage query, final BaseObject attributes) {

		return Reply.REPLY_IMPL.empty(owner, query, attributes).setCode(Reply.CD_EMPTY);
	}

	/** @param owner
	 * @param query
	 * @param attributes
	 * @param file
	 * @param fileName
	 * @return reply */
	public static final ReplyAnswer entry(final String owner, final BaseMessage query, final BaseObject attributes, final EntryBinary file, final String fileName) {

		return Reply.REPLY_IMPL.entry(owner, query, attributes, file, fileName);
	}

	/** @param owner
	 * @param query
	 * @param file
	 * @param fileName
	 * @return reply */
	public static final ReplyAnswer entry(final String owner, final BaseMessage query, final EntryBinary file, final String fileName) {

		return Reply.REPLY_IMPL.entry(owner, query, null, file, fileName);
	}

	/** @param answer
	 * @return reply exception */
	public static final AbstractReplyException exception(final ReplyAnswer answer) {

		return new WrapperReplyException(answer);
	}

	/** @param owner
	 * @param query
	 * @param buffer
	 * @return reply exception */
	public static final AbstractReplyException exceptionBinary(final String owner, final BaseMessage query, final TransferBuffer buffer) {

		return Reply.exception(Reply.binary(owner, query, buffer, null));
	}

	/** @param owner
	 * @param query
	 * @param copier
	 * @return reply exception */
	public static final AbstractReplyException exceptionBinary(final String owner, final BaseMessage query, final TransferCopier copier) {

		return Reply.exception(Reply.binary(owner, query, copier, (String) null));
	}

	/** @param owner
	 * @param query
	 * @return reply exception */
	public static final AbstractReplyException exceptionEmpty(final String owner, final BaseMessage query) {

		return Reply.exception(Reply.empty(owner, query));
	}

	/** @param owner
	 * @param query
	 * @param o
	 * @return reply exception */
	public static final AbstractReplyException exceptionObject(final String owner, final BaseMessage query, final Object o) {

		return Reply.exception(Reply.object(owner, query, o));
	}

	/** @param owner
	 * @param query
	 * @param text
	 * @return reply exception */
	public static final AbstractReplyException exceptionString(final String owner, final BaseMessage query, final String text) {

		return Reply.exception(Reply.string(owner, query, text));
	}

	/** @param owner
	 * @param query
	 * @param attributes
	 * @param file
	 * @param fileName
	 * @return reply */
	public static final ReplyAnswer file(final String owner, final BaseMessage query, final BaseObject attributes, final File file, final String fileName) {

		return Reply.REPLY_IMPL.file(owner, query, attributes, file, fileName);
	}

	/** @param owner
	 * @param query
	 * @param file
	 * @param fileName
	 * @return reply */
	public static final ReplyAnswer file(final String owner, final BaseMessage query, final File file, final String fileName) {

		return Reply.REPLY_IMPL.file(owner, query, null, file, fileName);
	}

	/** @param code
	 * @return string */
	public static final String getDefaultTitleForCode(final int code) {

		switch (code) {
			case Reply.CD_ACCEPTED :
				return "Accepted";
			case Reply.CD_UNAUTHORIZED :
				return "User Authentication Required";
			case Reply.CD_BADGATEWAY :
				return "Bad Gateway";
			case Reply.CD_BADMETHOD :
				return "Bad Method";
			case Reply.CD_BADQUERY :
				return "Bad Request";
			case Reply.CD_BADRANGE :
				return "Bad Range";
			case Reply.CD_BLOCKED_451 :
				return "Blocked For Legal Reasons";
			case Reply.CD_BUSY :
				return "Server Is Busy";
			case Reply.CD_CONFLICT :
				return "Conflict";
			case Reply.CD_CONTINUE :
				return "Continue";
			case Reply.CD_CREATED :
				return "Created";
			case Reply.CD_DENIED :
				return "Denied";
			case Reply.CD_EMPTY :
				return "Empty";
			case Reply.CD_EXCEPTION :
				return "Exception";
			case Reply.CD_GATEWAY_TIMEOUT :
				return "Gateway Timeout";
			case Reply.CD_INSUFFICIENT_STORAGE :
				return "Insufficient Storage";
			case Reply.CD_FAILED_PRECONDITION :
				return "Failed";
			case Reply.CD_LOCKED :
				return "Locked";
			case Reply.CD_LOOKAT :
				return "Try Looking At";
			case Reply.CD_MOVED :
				return "Moved Permanently";
			case Reply.CD_MULTISTATUS :
				return "Multistatus";
			case Reply.CD_OK :
				return "Success";
			case Reply.CD_PARTIAL :
				return "Partial";
			case Reply.CD_PAYMENT_REQUIRED :
				return "Payment Required";
			case Reply.CD_PROCESSING :
				return "Response Delays (Gone Async)";
			case Reply.CD_RAW_PROTOCOL :
				return "No (Raw) Protocol";
			case Reply.CD_SWITCHING_PROTOCOLS :
				return "Switching Protocols";
			case Reply.CD_UNIMPLEMENTED :
				return "Not Implemented";
			case Reply.CD_UNKNOWN :
				return "Unknown";
			case Reply.CD_UNMODIFIED :
				return "Not Modified";
			case Reply.CD_UNSUPPORTED_FORMAT :
				return "Unsupported Format";
			default :
				return "[" + code + "]";
		}
	}

	/** @param owner
	 * @param query
	 * @param attributes
	 * @param o
	 * @return reply */
	public static final ReplyAnswer object(final String owner, final BaseMessage query, final BaseObject attributes, final Object o) {

		return Reply.REPLY_IMPL.object(owner, query, attributes, o);
	}

	/** @param owner
	 * @param query
	 * @param o
	 * @return reply */
	public static final ReplyAnswer object(final String owner, final BaseMessage query, final Object o) {

		return Reply.REPLY_IMPL.object(owner, query, null, o);
	}

	/** @param owner
	 * @param query
	 * @param moved
	 * @param url
	 * @return reply */
	public static final ReplyAnswer redirect(final String owner, final BaseMessage query, final boolean moved, final String url) {

		return Reply.string(owner, query, url).setCode(
				moved
					? Reply.CD_MOVED
					: Reply.CD_LOOKAT)
				.setFinal();
	}

	/** @param owner
	 * @param query
	 * @param attributes
	 * @param text
	 * @return reply */
	public static final CharacterReplyAnswer<?> string(final String owner, final BaseMessage query, final BaseObject attributes, final CharSequence text) {

		return Reply.REPLY_IMPL.character(owner, query, attributes, text);
	}

	/** @param eventTypeId
	 * @param query
	 * @param text
	 * @return reply */
	public static final CharacterReplyAnswer<?> string(final String eventTypeId, final BaseMessage query, final CharSequence text) {

		return Reply.REPLY_IMPL.character(eventTypeId, query, null, text);
	}

	/** Replace with: stringAuthenticate
	 *
	 * @param eventTypeId
	 * @param query
	 * @param text
	 * @return reply */
	@Deprecated
	public static final CharacterReplyAnswer<?> stringAuthorize(final String eventTypeId, final BaseMessage query, final CharSequence text) {

		return Reply.string(eventTypeId, query, text).setCode(Reply.CD_UNAUTHORIZED).setPrivate();
	}

	/** @param owner
	 * @param query
	 * @param text
	 * @return reply */
	public static final CharacterReplyAnswer<?> stringForbidden(final String owner, final BaseMessage query, final CharSequence text) {

		return Reply.string(owner, query, text).setCode(Reply.CD_DENIED).setPrivate();
	}

	/** @param owner
	 * @param query
	 * @param text
	 * @return reply */
	public static final CharacterReplyAnswer<?> stringUnauthorized(final String owner, final BaseMessage query, final CharSequence text) {

		return Reply.string(owner, query, text).setCode(Reply.CD_UNAUTHORIZED).setPrivate();
	}

	/** @param owner
	 * @param query
	 * @param text
	 * @return reply */
	public static final CharacterReplyAnswer<?> stringUnknown(final String owner, final BaseMessage query, final String text) {

		return Reply.string(owner, query, text).setCode(Reply.CD_UNKNOWN);
	}

	/** @param owner
	 * @param query
	 * @param attributes
	 * @param bytes
	 * @return reply */
	public static final BinaryReplyAnswer<?> wrap(final String owner, final BaseMessage query, final BaseObject attributes, final byte[] bytes) {

		return Reply.REPLY_IMPL.wrap(owner, query, attributes, bytes, null);
	}

	/** @param owner
	 * @param query
	 * @param attributes
	 * @param bytes
	 * @param fileName
	 * @return reply */
	public static final ReplyAnswer wrap(final String owner, final BaseMessage query, final BaseObject attributes, final byte[] bytes, final String fileName) {

		return Reply.REPLY_IMPL.wrap(owner, query, attributes, bytes, fileName);
	}

	/** @param owner
	 * @param query
	 * @param bytes
	 * @return reply */
	public static final ReplyAnswer wrap(final String owner, final BaseMessage query, final byte[] bytes) {

		return Reply.REPLY_IMPL.wrap(owner, query, null, bytes, null);
	}

	/** @param owner
	 * @param query
	 * @param bytes
	 * @param fileName
	 * @return reply */
	public static final ReplyAnswer wrap(final String owner, final BaseMessage query, final byte[] bytes, final String fileName) {

		return Reply.REPLY_IMPL.wrap(owner, query, null, bytes, fileName);
	}

	private Reply() {

		// empty
	}
}
