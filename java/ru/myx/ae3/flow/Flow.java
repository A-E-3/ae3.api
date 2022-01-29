/**
 * Created on 29.11.2002
 *
 */
package ru.myx.ae3.flow;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.StringTokenizer;
import java.util.function.Function;

import ru.myx.ae3.AbstractSAPI;
import ru.myx.ae3.Engine;
import ru.myx.ae3.act.Act;
import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseMap;
import ru.myx.ae3.base.BaseMessage;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.base.BaseProperty;
import ru.myx.ae3.binary.Transfer;
import ru.myx.ae3.binary.TransferBuffer;
import ru.myx.ae3.binary.TransferCopier;
import ru.myx.ae3.vfs.Entry;
import ru.myx.ae3.vfs.EntryBinary;

/** @author barachta
 *
 *
 *         myx - barachta "typecomment": Window>Preferences>Java>Templates. To enable and disable
 *         the creation of type comments go to Window>Preferences>Java>Code Generation. */
public final class Flow extends AbstractSAPI {
	
	/** @author myx */
	@SuppressWarnings("serial")
	public static class FlowOperationException extends RuntimeException {
		
		/** @param message
		 * @param parent */
		public FlowOperationException(final String message, final Throwable parent) {
			
			super(message, parent);
		}
	}
	
	private static final AbstractFlowImpl FLOW_IMPL;
	
	static {
		FLOW_IMPL = AbstractSAPI.createObject("ru.myx.ae3.flow.ImplementFlow");
		NUL_MESSAGE = Flow.FLOW_IMPL.nullMessage();
	}
	
	/**
	 *
	 */
	public static final UniversalMessage<?> NUL_MESSAGE;
	
	/** Creates a message object containing a buffer passed. This message should return true on
	 * isBinary() method and same buffer as a getBinary() method result.
	 *
	 * @param owner
	 * @param title
	 * @param attributes
	 * @param buf
	 * @return message */
	public static final BinaryMessage<?> binary(final String owner, final String title, final BaseObject attributes, final TransferBuffer buf) {
		
		return Flow.binary(owner, title, attributes, buf.toBinary());
	}
	
	/** Creates a message object containing a copier passed. This message should return true on
	 * isBinary() method and same buffer as a getBinary() method result.
	 *
	 * @param owner
	 * @param title
	 * @param attributes
	 * @param buf
	 * @return message */
	public static final BinaryMessage<?> binary(final String owner, final String title, final BaseObject attributes, final TransferCopier buf) {
		
		return Flow.FLOW_IMPL.binary(owner, title, attributes, buf);
	}
	
	/** Creates a message object containing a buffer passed. This message should return true on
	 * isBinary() method and same buffer as a getBinary() method result.
	 *
	 * @param owner
	 * @param title
	 * @param contentType
	 * @param buf
	 * @return message */
	public static final BinaryMessage<?> binary(final String owner, final String title, final String contentType, final TransferBuffer buf) {
		
		return Flow.binary(owner, title, contentType, buf.toBinary());
	}
	
	/** Creates a message object containing a copier passed. This message should return true on
	 * isBinary() method and same buffer as a getBinary() method result.
	 *
	 * @param owner
	 * @param title
	 * @param contentType
	 * @param buf
	 * @return message */
	public static final BinaryMessage<?> binary(final String owner, final String title, final String contentType, final TransferCopier buf) {
		
		final BaseMap attributes = BaseObject.createObject();
		if (contentType != null && contentType.length() > 0) {
			attributes.baseDefine("Content-Type", contentType);
		}
		return Flow.FLOW_IMPL.binary(owner, title, attributes, buf);
	}
	
	// TODO: remove, check scripts
	@SuppressWarnings("javadoc")
	@Deprecated
	public static final BinaryMessage<?> binary(final String owner, final String title, final TransferBuffer buf, final BaseObject attributes) {
		
		return Flow.binary(owner, title, attributes, buf.toBinary());
	}
	
	// TODO: remove, check scripts
	@SuppressWarnings("javadoc")
	@Deprecated
	public static final BinaryMessage<?> binary(final String owner, final String title, final TransferBuffer buf, final String contentType) {
		
		return Flow.binary(owner, title, contentType, buf.toBinary());
	}
	
	// TODO: remove, check scripts
	@SuppressWarnings("javadoc")
	@Deprecated
	public static final BinaryMessage<?> binary(final String owner, final String title, final TransferCopier buf, final BaseObject attributes) {
		
		return Flow.binary(owner, title, attributes, buf);
	}
	
	// TODO: remove, check scripts
	@SuppressWarnings("javadoc")
	@Deprecated
	public static final BinaryMessage<?> binary(final String owner, final String title, final TransferCopier buf, final String contentType) {
		
		return Flow.binary(owner, title, contentType, buf);
	}
	
	/** Creates a message object containing a copier and text passed. This message should return
	 * true on isBinary() and isCharacter() method and same buffer as a getBinary() method result
	 * and same text as getText() method result.
	 *
	 * @param owner
	 * @param title
	 * @param attributes
	 * @param binary
	 * @param text
	 * @return message */
	public static final UniversalMessage<?>
			binaryAndCharacter(final String owner, final String title, final BaseObject attributes, final TransferCopier binary, final CharSequence text) {
		
		return Flow.FLOW_IMPL.binaryAndCharacter(owner, title, attributes, binary, text);
	}
	
	/** @param characterMessage
	 * @return */
	public static UniversalMessage<?> binaryWrapCharacter(final CharacterMessage<?> characterMessage) {
		
		if (characterMessage == null) {
			throw new NullPointerException("NULL characterMessage!");
		}
		/** can't really use it since implementors could use this method to implement toBinary
		 * method,... <code>
		if (characterMessage instanceof UniversalMessage<?>
				&& (characterMessage.isBinary() || characterMessage.isEmpty())) {
			assert characterMessage.isCharacter() : "Supposed to an isCharacter";
			return (UniversalMessage<?>) characterMessage;
		}
		 * </code> ...we will enforce that they checked and handled it explicitly before calling
		 * this method */
		assert !characterMessage.isBinary() : //
				"Supposed to check and handle isBinary() explicitly before calling this method";
		//
		assert characterMessage.isCharacter() : "Supposed to be isCharacter";
		//
		final CharSequence text = characterMessage.getText();
		CharacterMessage<?> contentTypeAttribute = null;
		// responses mostly do have attributes anyway
		final BaseObject originalAttributes = characterMessage.getAttributes();
		final BaseObject attributes = BaseObject.createObject(originalAttributes);
		{
			final String contentType = Base.getString(originalAttributes, "Content-Type", "").trim();
			if (contentType.length() != 0) {
				contentTypeAttribute = Flow.mimeAttribute("", "", contentType);
				final String explicitEncoding = Base.getString(contentTypeAttribute.getAttributes(), "charset", "").trim();
				if (explicitEncoding.length() > 0) {
					final Charset charset = Charset.forName(explicitEncoding);
					final TransferCopier binary = Transfer.createCopier(text, charset);
					attributes.baseDefine("Content-Length", binary.length());
					return Flow.binaryAndCharacter(
							characterMessage.getEventTypeId(), //
							characterMessage.getTitle(),
							attributes,
							binary,
							text);
				}
			}
		}
		{
			final String contentCharset = Base.getString(originalAttributes, "Content-Charset", "").trim();
			if (contentCharset.length() > 0) {
				final Charset charset = Charset.forName(contentCharset);
				final TransferCopier binary = Transfer.createCopier(text, charset);
				attributes.baseDefine(
						"Content-Type",
						(contentTypeAttribute != null
							? contentTypeAttribute.getText() + "; charset="
							: "text/plain; charset=") + contentCharset);
				attributes.baseDefine("Content-Length", binary.length());
				return Flow.binaryAndCharacter(
						characterMessage.getEventTypeId(), //
						characterMessage.getTitle(),
						attributes,
						binary,
						text);
			}
		}
		/** default conversion */
		{
			final TransferCopier binary = Transfer.createCopierUtf8(text);
			
			attributes.baseDefine(
					"Content-Type",
					contentTypeAttribute != null
						? contentTypeAttribute.getText() + "; charset=UTF-8"
						: "text/plain; charset=UTF-8");
			attributes.baseDefine("Content-Charset", Engine.ENCODING_UTF8);
			attributes.baseDefine("Content-Length", binary.length());
			
			return Flow.FLOW_IMPL.wrapCharacterMessageAsUniversal(characterMessage, attributes, binary);
		}
	}
	
	/** Creates a message object containing a string passed. This message should return true on
	 * isCharacter() methods and same string as a getText() method result.
	 *
	 * @param owner
	 * @param title
	 * @param attributes
	 * @param text
	 * @return message */
	public static final CharacterMessage<?> character(final String owner, final String title, final BaseObject attributes, final String text) {
		
		return Flow.FLOW_IMPL.character(owner, title, attributes, text);
	}
	
	/** Creates a message object containing a string passed. This message should return true on
	 * isCharacter() methods and same string as a getText() method result.
	 *
	 * @param owner
	 * @param title
	 * @param text
	 * @return message */
	public static final CharacterMessage<?> character(final String owner, final String title, final String text) {
		
		return Flow.FLOW_IMPL.character(owner, title, null, text);
	}
	
	/** @param binaryMessage
	 * @return */
	public static UniversalMessage<?> characterWrapBinary(final BinaryMessage<?> binaryMessage) {
		
		if (binaryMessage == null) {
			throw new NullPointerException("NULL binaryMessage!");
		}
		//
		/** can't really use it since implementors could use this method to implement toBinary
		 * method,... <code>
		if (binaryMessage instanceof UniversalMessage<?>
				&& (binaryMessage.isCharacter() || binaryMessage.isEmpty())) {
			return (UniversalMessage<?>) binaryMessage;
		}
		 * </code> ...we will enforce that they checked and handled it explicitly before calling
		 * this method */
		assert !binaryMessage.isCharacter() : //
				"Supposed to check and handle isCharacter() explicitly before calling this method";
		assert binaryMessage.isBinary() : "Supposed to be isBinary";
		//
		final BaseObject originalAttributes = binaryMessage.getAttributes();
		final String contentType = originalAttributes == null
			? ""
			: Base.getString(originalAttributes, "Content-Type", "application/octet-stream").trim();
		final String currentEncoding = Base.getString(Flow.mimeAttribute("", "", contentType), "charset", "").trim();
		final String encoding = currentEncoding.length() > 0
			? currentEncoding
			: originalAttributes == null
				? Engine.ENCODING_UTF8
				: Base.getString(originalAttributes, "Character-Encoding", Engine.ENCODING_UTF8);
		final String chosenEncoding = encoding.indexOf('*') != -1
			? Engine.ENCODING_UTF8
			: encoding;
		final BaseObject attributes;
		if (currentEncoding.length() == 0) {
			attributes = BaseObject.createObject(originalAttributes);
			attributes.baseDefine("Content-Type", contentType + "; charset=" + chosenEncoding, BaseProperty.ATTRS_MASK_WED);
		} else {
			attributes = originalAttributes;
		}
		final TransferCopier binary = binaryMessage.getBinary();
		try {
			return Flow.FLOW_IMPL.wrapBinaryMessageAsUniversal(binaryMessage, attributes, binary.toString(chosenEncoding));
		} catch (final UnsupportedEncodingException e) {
			throw new Flow.FlowOperationException("Error converting from binary to universal", e);
		}
	}
	
	/** @param source
	 * @param target
	 * @return
	 * @throws Exception */
	public static final <T> boolean connect(final ObjectSource<T> source, final ObjectTarget<T> target) throws Exception {
		
		if (source instanceof ObjectSourceAsync) {
			((ObjectSourceAsync<T>) source).connectTarget(target);
			return true;
		}
		Act.launch(null, new Function<Object, Object>() {
			
			@Override
			public Object apply(Object v) {
				
				Flow.transferFully(source, target);
				return null;
			}
		}, null);
		return true;
	}
	
	/** CATCH METHOD
	 *
	 * @param source
	 * @param target */
	@Deprecated
	public static final <T> void connect(final ObjectSourceAsync<T> source, final ObjectTarget<T> target) {
		
		// ignore
	}
	
	/** Creates an empty message object. This message should return true on isEmpty() method.
	 *
	 * @param owner
	 * @param title
	 * @param attributes
	 * @return message */
	public static final UniversalMessage<?> empty(final String owner, final String title, final BaseObject attributes) {
		
		return Flow.FLOW_IMPL.empty(owner, title, attributes);
	}
	
	/** Creates a message object containing a file passed. This message should return true on
	 * isFile() method and same file as a getFile() method result.
	 *
	 * @param owner
	 * @param title
	 * @param attributes
	 * @param entry
	 * @return message */
	public static final BaseMessage entry(final String owner, final String title, final BaseObject attributes, final Entry entry) {
		
		return Flow.FLOW_IMPL.entry(owner, title, attributes, entry);
	}
	
	/** @param owner
	 * @param title
	 * @param attributes
	 * @param entry
	 * @param fileName
	 * @return */
	public static final BaseMessage entry(final String owner, final String title, final BaseObject attributes, final EntryBinary entry, final String fileName) {
		
		return Flow.FLOW_IMPL.entry(owner, title, attributes, entry, fileName);
	}
	
	// TODO: remove, check scripts
	@SuppressWarnings("javadoc")
	@Deprecated
	public static final BaseMessage entry(final String owner, final String title, final Entry entry, final BaseObject attributes) {
		
		return Flow.entry(owner, title, attributes, entry);
	}
	
	/** Creates a message object containing a file passed. This message should return true on
	 * isFile() method and same file as a getFile() method result.
	 *
	 * @param owner
	 * @param title
	 * @param attributes
	 * @param file
	 * @return message */
	public static final BaseMessage file(final String owner, final String title, final BaseObject attributes, final File file) {
		
		return Flow.FLOW_IMPL.file(owner, title, attributes, file);
	}
	
	// TODO: remove, check scripts
	@SuppressWarnings("javadoc")
	@Deprecated
	public static final BaseMessage file(final String owner, final String title, final File file, final BaseObject attributes) {
		
		return Flow.file(owner, title, attributes, file);
	}
	
	/** @param owner
	 * @param title
	 * @param attributeValue
	 * @return message */
	public static final CharacterMessage<?> mimeAttribute(final String owner, final String title, final String attributeValue) {
		
		if (title == null) {
			throw new NullPointerException("Message title cannot be null!");
		}
		if (owner == null) {
			throw new NullPointerException("Message owner cannot be null!");
		}
		if (attributeValue == null) {
			return Flow.NUL_MESSAGE;
		}
		final int posSemicolon = attributeValue.indexOf(';');
		if (posSemicolon == -1) {
			return Flow.character(owner, title, attributeValue.trim());
		}
		final String clean = attributeValue.substring(0, posSemicolon);
		final BaseObject attributes = BaseObject.createObject();
		final StringTokenizer attrsTokenizer = new StringTokenizer(attributeValue.substring(posSemicolon + 1), ";");
		for (; attrsTokenizer.hasMoreTokens();) {
			final String tk = attrsTokenizer.nextToken();
			final int positionEquals = tk.indexOf('=');
			if (positionEquals == -1) {
				attributes.baseDefine(tk, BaseObject.TRUE);
			} else {
				final String value = tk.substring(positionEquals + 1).trim();
				final int length = value.length();
				attributes.baseDefine(
						tk.substring(0, positionEquals).trim(),
						length > 1 && value.charAt(0) == '"' && value.charAt(length - 1) == '"'
							? value.substring(1, length - 1)
							: value);
			}
		}
		return Flow.character(owner, title, attributes, clean);
	}
	
	/** Creates a message object containing an object passed. This message should return true on
	 * isObject() method and same object on getObject() method invocation.
	 *
	 * @param owner
	 * @param title
	 * @param attributes
	 * @param obj
	 * @return message */
	public static final BaseMessage object(final String owner, final String title, final BaseObject attributes, final Object obj) {
		
		return Flow.FLOW_IMPL.object(owner, title, attributes, obj);
	}
	
	// TODO: remove, check scripts
	@SuppressWarnings("javadoc")
	@Deprecated
	public static final BaseMessage object(final String owner, final String title, final Object obj, final BaseObject attributes) {
		
		return Flow.object(owner, title, attributes, obj);
	}
	
	/** Creates a message object containing a sequence of messages. This message should return true
	 * on isSequence() method and an array of messages as a getSequence() method result.
	 *
	 * @param owner
	 * @param title
	 * @param sequence
	 * @return message */
	public static final BaseMessage sequence(final String owner, final String title, final BaseMessage[] sequence) {
		
		return Flow.FLOW_IMPL.sequence(owner, title, null, sequence);
	}
	
	// TODO: remove, check scripts
	@SuppressWarnings("javadoc")
	@Deprecated
	public static final BaseMessage sequence(final String owner, final String title, final BaseMessage[] sequence, final BaseObject attributes) {
		
		return Flow.sequence(owner, title, attributes, sequence);
	}
	
	/** Creates a message object containing a sequence of messages. This message should return true
	 * on isSequence() method and an array of messages as a getSequence() method result.
	 *
	 * @param owner
	 * @param title
	 * @param attributes
	 * @param sequence
	 * @return message */
	public static final BaseMessage sequence(final String owner, final String title, final BaseObject attributes, final BaseMessage[] sequence) {
		
		return Flow.FLOW_IMPL.sequence(owner, title, attributes, sequence);
	}
	
	// TODO: remove, check scripts
	@SuppressWarnings("javadoc")
	@Deprecated
	public static final CharacterMessage<?> textual(final String owner, final String title, final String text, final BaseObject attributes) {
		
		return Flow.character(owner, title, attributes, text);
	}
	
	/** @param source
	 * @param target
	 * @throws Flow.FlowOperationException */
	public static final <T> void transferFully(final ObjectSource<T> source, final ObjectTarget<T> target) throws Flow.FlowOperationException {
		
		for (;;) {
			while (source.isReady()) {
				if (!target.absorb(source.next())) {
					return;
				}
			}
			if (!source.isExhausted()) {
				try {
					Thread.sleep(50L);
				} catch (final InterruptedException e) {
					throw new RuntimeException("interrupted", e);
				}
			} else {
				target.close();
				return;
			}
		}
	}
}
