/*
 * Created on 22.03.2006
 */
package ru.myx.ae3.answer;

import ru.myx.ae3.base.BaseError;
import ru.myx.ae3.base.BaseMessage;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.binary.TransferCopier;
import ru.myx.ae3.common.BodyAccessBinary;
import ru.myx.ae3.common.BodyAccessCharacter;
import ru.myx.ae3.common.Value;
import ru.myx.ae3.exec.ExecNonMaskedException;
import ru.myx.ae3.report.Report;

/** @author myx
 *
 *         TODO: implement ReplyAnswer */
public abstract class AbstractReplyException extends ExecNonMaskedException implements UniversalReplyAnswer<AbstractReplyException> {

	/**
	 *
	 */
	private static final long serialVersionUID = -7242938007081550923L;
	
	/**
	 *
	 */
	protected AbstractReplyException() {
		
		super(BaseError.PROTOTYPE);
	}
	
	@Override
	public AbstractReplyException addAttribute(final String name, final BaseObject value) {

		this.getReply().addAttribute(name, value);
		return this;
	}
	
	@Override
	public AbstractReplyException addAttribute(final String name, final double value) {

		this.getReply().addAttribute(name, value);
		return this;
	}
	
	@Override
	public AbstractReplyException addAttribute(final String name, final int value) {

		this.getReply().addAttribute(name, value);
		return this;
	}
	
	@Override
	public AbstractReplyException addAttribute(final String name, final long value) {

		this.getReply().addAttribute(name, value);
		return this;
	}
	
	@Override
	public AbstractReplyException addAttribute(final String name, final Object value) {

		this.getReply().addAttribute(name, value);
		return this;
	}
	
	@Override
	public AbstractReplyException addAttribute(final String name, final String value) {

		this.getReply().addAttribute(name, value);
		return this;
	}

	@Override
	public void cancel() {

		// default implementation is empty
	}
	
	/** No stack trace for replies (unless in DEBUG mode) */
	@Override
	public Throwable fillInStackTrace() {

		return Report.MODE_DEBUG
			? super.fillInStackTrace()
			: this;
	}
	
	@Override
	public BaseObject getAttributes() {

		return this.getReply().getAttributes();
	}
	
	/** @return binary */
	@Override
	public final TransferCopier getBinary() {

		return ((BodyAccessBinary) this.getReply()).getBinary();
	}
	
	@Override
	public Value<? extends TransferCopier> getBinaryContent() {

		return ((BodyAccessBinary) this.getReply()).getBinaryContent();
	}
	
	@Override
	public long getCharacterContentLength() {

		return ((BodyAccessCharacter) this.getReply()).getCharacterContentLength();
	}
	
	/** @return code */
	@Override
	public final int getCode() {

		return this.getReply().getCode();
	}
	
	@Override
	public long getDate() {

		return this.getReply().getDate();
	}
	
	@Override
	public String getEventTypeId() {

		return this.getReply().getEventTypeId();
	}
	
	@Override
	public long getExpirationDate() {

		return this.getReply().getExpirationDate();
	}

	/** @return file */
	@Override
	public final java.io.File getFile() {

		return this.getReply().getFile();
	}
	
	@Override
	public BaseObject getFlags() {

		return this.getReply().getFlags();
	}
	
	@Override
	public String getMessage() {

		return String.valueOf(this.getReply());
	}
	
	/** @return object */
	@Override
	public final Object getObject() {

		return this.getReply().getObject();
	}
	
	@Override
	public Class<?> getObjectClass() {

		return this.getObjectClass();
	}
	
	@Override
	public long getProcess() {

		return this.getReply().getProcess();
	}
	
	@Override
	public String getProtocolName() {

		return this.getReply().getProtocolName();
	}
	
	@Override
	public String getProtocolVariant() {

		return this.getReply().getProtocolVariant();
	}
	
	/** @return message */
	@Override
	public BaseMessage getQuery() {

		return this.getReply().getQuery();
	}
	
	/** @return answer */
	public abstract ReplyAnswer getReply();
	
	@Override
	public BaseMessage[] getSequence() {

		return this.getReply().getSequence();
	}
	
	@Override
	public String getSessionID() {

		return this.getReply().getSessionID();
	}
	
	@Override
	public String getSourceAddress() {

		return this.getReply().getSourceAddress();
	}
	
	@Override
	public String getSourceAddressExact() {

		return this.getReply().getSourceAddressExact();
	}
	
	@Override
	public String getSubject() {

		return this.getReply().getSubject();
	}
	
	@Override
	public String getTarget() {

		return this.getReply().getTarget();
	}
	
	@Override
	public String getTargetAddress() {

		return this.getReply().getTargetAddress();
	}
	
	@Override
	public String getTargetExact() {

		return this.getReply().getTargetExact();
	}
	
	@Override
	public final CharSequence getText() {

		return ((BodyAccessCharacter) this.getReply()).getText();
	}
	
	@Override
	public Value<? extends CharSequence> getTextContent() {

		return ((BodyAccessCharacter) this.getReply()).getTextContent();
	}
	
	@Override
	public int getTimeToLiveSeconds() {

		return this.getReply().getTimeToLiveSeconds();
	}
	
	@Override
	public String getTitle() {

		return this.getReply().getTitle();
	}
	
	@Override
	public String getUserID() {

		return this.getReply().getUserID();
	}
	
	@Override
	public final boolean isBinary() {

		return this.getReply().isBinary();
	}
	
	@Override
	public boolean isCharacter() {

		return this.getReply().isCharacter();
	}
	
	@Override
	public final boolean isEmpty() {

		return this.getReply().isEmpty();
	}
	
	@Override
	public final boolean isFile() {

		return this.getReply().isFile();
	}
	
	@Override
	public final boolean isFinal() {

		return this.getReply().isFinal();
	}
	
	@Override
	public final boolean isObject() {

		return this.getReply().isObject();
	}
	
	@Override
	public boolean isPrivate() {

		return this.getReply().isPrivate();
	}
	
	@Override
	public boolean isSequence() {

		return this.getReply().isSequence();
	}
	
	@Override
	public ReplyAnswer nextClone(final BaseMessage query) {

		return this.getReply().nextClone(query);
	}
	
	@Override
	public abstract AbstractReplyException seal();
	
	@Override
	public AbstractReplyException setAttribute(final String name, final BaseObject value) {

		this.getReply().setAttribute(name, value);
		return this;
	}
	
	@Override
	public AbstractReplyException setAttribute(final String name, final double value) {

		this.getReply().setAttribute(name, value);
		return this;
	}
	
	@Override
	public AbstractReplyException setAttribute(final String name, final int value) {

		this.getReply().setAttribute(name, value);
		return this;
	}
	
	@Override
	public AbstractReplyException setAttribute(final String name, final long value) {

		this.getReply().setAttribute(name, value);
		return this;
	}
	
	@Override
	public AbstractReplyException setAttribute(final String name, final Object value) {

		this.getReply().setAttribute(name, value);
		return this;
	}
	
	@Override
	public AbstractReplyException setAttribute(final String name, final String value) {

		this.getReply().setAttribute(name, value);
		return this;
	}
	
	@Override
	public AbstractReplyException setAttributes(final BaseObject attributes) {
		
		this.getReply().setAttributes(attributes);
		return this;
	}
	
}
