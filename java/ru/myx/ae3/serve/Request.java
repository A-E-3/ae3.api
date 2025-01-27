package ru.myx.ae3.serve;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import ru.myx.ae3.AbstractSAPI;
import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.base.BaseProperty;
import ru.myx.ae3.binary.Transfer;
import ru.myx.ae3.binary.TransferBuffer;
import ru.myx.ae3.binary.TransferCopier;
import ru.myx.ae3.common.BodyAccessBinary;
import ru.myx.ae3.common.BodyAccessCharacter;
import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.flow.CharacterMessage;
import ru.myx.ae3.flow.Flow;

/** @author myx */
public class Request extends AbstractSAPI {

	private static final AbstractRequestImpl REQUEST_IMPL;

	/**
	 *
	 */
	public final static ServeRequest NULL_REQUEST;

	/**
	 *
	 */
	public final static ServeRequest ROOT_REQUEST;

	static {
		REQUEST_IMPL = AbstractSAPI.createObject("ru.myx.ae3.serve.ImplementRequest");

		NULL_REQUEST = Request.REQUEST_IMPL.getNullRequest();
		ROOT_REQUEST = Request.REQUEST_IMPL.getRootRequest();
	}
	
	private static UniversalServeRequest<?>
			binaryAndCharacter(final String owner, final String verb, final BaseObject attributes, final TransferCopier binary, final CharSequence text) {
		
		return Request.REQUEST_IMPL.binaryAndCharacter(owner, verb, null, attributes, binary, text);
	}
	
	/** @param owner
	 * @param verb
	 * @param buffer
	 * @return */
	public static BinaryServeRequest<?> binary(final String owner, final String verb, final TransferBuffer buffer) {
		
		return Request.binary(owner, verb, buffer, null);
	}
	
	/** @param owner
	 * @param verb
	 * @param buffer
	 * @param attributes
	 * @return */
	public static BinaryServeRequest<?> binary(final String owner, final String verb, final TransferBuffer buffer, final BaseObject attributes) {
		
		return Request.REQUEST_IMPL.binary(owner, verb, null, attributes, buffer, null);
	}
	
	/** CATCH METHOD
	 *
	 * @param character */
	@Deprecated
	public static void binaryWrapCharacter(final BodyAccessBinary character) {
		
		//
	}
	
	/** @param characterRequest
	 * @return
	 * @throws UnsupportedEncodingException */
	public static UniversalServeRequest<?> binaryWrapCharacter(final CharacterServeRequest<?> characterRequest) throws UnsupportedEncodingException {
		
		if (characterRequest == null) {
			throw new NullPointerException("NULL characterRequest!");
		}
		/** can't really use it since implementors could use this method to implement toBinary
		 * method,... <code>
		if (characterRequest instanceof UniversalServeRequest<?>
				&& (characterRequest.isBinary() || characterRequest.isEmpty())) {
			assert characterRequest.isCharacter() : "Supposed to an isCharacter";
			return (UniversalServeRequest<?>) characterRequest;
		}
		 * </code> ...we will enforce that they checked and handled it explicitly before calling
		 * this method */
		assert !characterRequest.isBinary() : //
				"Supposed to check and handle isBinary() explicitly before calling this method";
		//
		assert characterRequest.isCharacter() : "Supposed to be isCharacter";
		//
		final CharSequence text = characterRequest.getText();
		CharacterMessage<?> contentTypeAttribute = null;
		// responses mostly do have attributes anyway
		final BaseObject ownAttributes = characterRequest.getAttributes();
		final BaseObject tempAttributes = BaseObject.createObject(ownAttributes);
		{
			final String contentType = Base.getString(ownAttributes, "Content-Type", "").trim();
			if (contentType.length() != 0) {
				contentTypeAttribute = Flow.mimeAttribute("", "", contentType);
				final String explicitEncoding = Base.getString(contentTypeAttribute.getAttributes(), "charset", "").trim();
				if (explicitEncoding.length() > 0) {
					final Charset charset = Charset.forName(explicitEncoding);
					final TransferCopier binary = Transfer.createCopier(text, charset);
					tempAttributes.baseDefine("Content-Length", binary.length());
					return Request.binaryAndCharacter(
							characterRequest.getEventTypeId(), //
							characterRequest.getVerb(),
							tempAttributes,
							binary,
							text);
				}
			}
		}
		{
			final String contentCharset = Base.getString(ownAttributes, "Content-Charset", "").trim();
			if (contentCharset.length() > 0) {
				final Charset charset = Charset.forName(contentCharset);
				final TransferCopier binary = Transfer.createCopier(text, charset);
				tempAttributes.baseDefine(
						"Content-Type",
						(contentTypeAttribute != null
							? contentTypeAttribute.getText() + "; charset="
							: "text/plain; charset=") + contentCharset);
				tempAttributes.baseDefine("Content-Length", binary.length());
				return Request.binaryAndCharacter(
						characterRequest.getEventTypeId(), //
						characterRequest.getVerb(),
						tempAttributes,
						binary,
						text);
			}
		}
		{
			final TransferCopier binary = Transfer.createCopierUtf8(text);
			tempAttributes.baseDefine(
					"Content-Type",
					contentTypeAttribute != null
						? contentTypeAttribute.getText() + "; charset=UTF-8"
						: "text/plain; charset=UTF-8");
			tempAttributes.baseDefine("Content-Charset", "UTF-8");
			tempAttributes.baseDefine("Content-Length", binary.length());

			return Request.binaryAndCharacter(
					characterRequest.getEventTypeId(), //
					characterRequest.getVerb(),
					tempAttributes,
					binary,
					text);
		}
	}
	
	/** @param owner
	 * @param verb
	 * @param attributes
	 * @param text
	 * @return */
	public static CharacterServeRequest<?> character(final String owner, final String verb, final BaseObject attributes, final CharSequence text) {
		
		return Request.REQUEST_IMPL.character(owner, verb, null, attributes, text);
	}
	
	/** @param owner
	 * @param verb
	 * @param text
	 * @return */
	public static CharacterServeRequest<?> character(final String owner, final String verb, final CharSequence text) {
		
		return Request.character(owner, verb, null, text);
	}
	
	/** @param binaryRequest
	 * @return
	 * @throws UnsupportedEncodingException */
	public static UniversalServeRequest<?> characterWrapBinary(final BinaryServeRequest<?> binaryRequest) throws UnsupportedEncodingException {
		
		if (binaryRequest == null) {
			throw new NullPointerException("NULL binaryRequest!");
		}
		/** can't really use it since implementors could use this method to implement toBinary
		 * method,... <code>
		if (binaryRequest instanceof UniversalServeRequest<?>
				&& (binaryRequest.isCharacter() || binaryRequest.isEmpty())) {
			return (UniversalServeRequest<?>) binaryRequest;
		}
		 * </code> ...we will enforce that they checked and handled it explicitly before calling
		 * this method */
		assert !binaryRequest.isCharacter() : //
				"Supposed to check and handle isCharacter() explicitly before calling this method";
		//
		assert binaryRequest.isBinary() : "Supposed to be isBinary";
		//
		final BaseObject originalAttributes = binaryRequest.getAttributes();
		final String contentType = originalAttributes == null
			? ""
			: Base.getString(originalAttributes, "Content-Type", "application/octet-stream").trim();
		final String currentEncoding = Base.getString(Flow.mimeAttribute("", "", contentType), "charset", "").trim();
		final String UTF8 = "UTF-8";
		final String encoding = currentEncoding.length() > 0
			? currentEncoding
			: originalAttributes == null
				? UTF8
				: Base.getString(originalAttributes, "Content-Charset", UTF8);
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
		final TransferCopier binary = binaryRequest.getBinary();
		return Request.REQUEST_IMPL.wrapBinaryRequestAsUniversal(binaryRequest, attributes, binary.toString(chosenEncoding));
	}
	
	/** CATCH METHOD
	 *
	 * @param binary */
	@Deprecated
	public static void characterWrapBinary(final BodyAccessCharacter binary) {
		
		//
	}
	
	/** @param owner
	 * @param verb
	 * @return */
	public static UniversalServeRequest<?> empty(final String owner, //
			final String verb) {
		
		return Request.empty(owner, verb, null);
	}
	
	/** @param owner
	 * @param verb
	 * @param attributes
	 * @return */
	public static UniversalServeRequest<?> empty(final String owner, //
			final String verb,
			final BaseObject attributes) {
		
		return Request.REQUEST_IMPL.empty(owner, verb, null, attributes);
	}
	
	/** @param verb
	 * @return */
	public static final String getDefaultTitleForVerb(final String verb) {
		
		if (verb == null || verb.length() == 0) {
			return "Invalid request, no verb";
		}
		switch (verb.charAt(0)) {
			case 'D' :
				if ("DELETE".equals(verb)) {
					return "I want you to delete this";
				}
				break;
			case 'G' :
				if ("GET".equals(verb)) {
					return "I want to get this";
				}
				break;
			case 'H' :
				if ("HEAD".equals(verb)) {
					return "Describe me what I'll get";
				}
				break;
			case 'P' :
				if (verb.length() > 2) {
					switch (verb.charAt(1)) {
						case 'O' :
							if ("POST".equals(verb)) {
								return "Let's perform some";
							}
							break;
						case 'U' :
							if ("PUT".equals(verb)) {
								return "Put it there, please";
							}
							break;
						default :
							return verb;
					}
				}
				break;
			default :
				return verb;
		}
		return verb;
	}
	
	/** Some static crap. If shields ReplyAnswerExceptions and returns them as reply object as well.
	 *
	 * @param ctx
	 * @param handler
	 * @param context
	 * @return
	 * @throws Exception */
	public static final BaseObject queryHandler(final ExecProcess ctx, final BaseObject handler, final BaseObject context) throws Exception {
		
		return Request.REQUEST_IMPL.queryHandler(ctx, handler, context);
	}
	
	private Request() {
		
		// prevent
	}

}
