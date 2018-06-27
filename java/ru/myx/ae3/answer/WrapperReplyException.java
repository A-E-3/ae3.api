/**
 *
 */
package ru.myx.ae3.answer;

import java.nio.charset.Charset;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.flow.Flow;
import ru.myx.ae3.reflect.ReflectionIgnore;

@ReflectionIgnore
final class WrapperReplyException extends AbstractReplyException {

	/**
	 *
	 */
	private static final long serialVersionUID = -4279457778556809816L;
	
	private ReplyAnswer reply;
	
	WrapperReplyException(final ReplyAnswer answer) {
		assert answer != null : "No anwser to be wrapped!";
		this.reply = answer;
	}
	
	@Override
	public ReplyAnswer getReply() {

		return this.reply;
	}
	
	@Override
	public AbstractReplyException seal() {

		this.reply = this.getReply().seal();
		return this;
	}
	
	@Override
	public AbstractReplyException setAttribute(final String name, final BaseObject value) {

		this.reply = this.reply.setAttribute(name, value);
		return this;
	}
	
	@Override
	public AbstractReplyException setAttribute(final String name, final double value) {

		this.reply = this.reply.setAttribute(name, value);
		return this;
	}
	
	@Override
	public AbstractReplyException setAttribute(final String name, final int value) {

		this.reply = this.reply.setAttribute(name, value);
		return this;
	}
	
	@Override
	public AbstractReplyException setAttribute(final String name, final long value) {

		this.reply = this.reply.setAttribute(name, value);
		return this;
	}
	
	@Override
	public AbstractReplyException setAttribute(final String name, final Object value) {

		this.reply = this.reply.setAttribute(name, value);
		return this;
	}
	
	@Override
	public AbstractReplyException setAttribute(final String name, final String value) {

		this.reply = this.reply.setAttribute(name, value);
		return this;
	}
	
	@Override
	public AbstractReplyException setAttributes(final BaseObject attributes) {

		this.reply = this.reply.setAttributes(attributes);
		return this;
	}
	
	@Override
	public AbstractReplyException setCode(final int code) {

		this.reply = this.reply.setCode(code);
		return this;
	}
	
	@Override
	public AbstractReplyException setContentDisposition(final String disposition) {

		this.reply = this.reply.setContentName(disposition);
		return this;
	}
	
	@Override
	public AbstractReplyException setContentID(final String contentId) {

		this.reply = this.reply.setContentID(contentId);
		return this;
	}
	
	@Override
	public AbstractReplyException setContentName(final String contentName) {

		this.reply = this.reply.setContentName(contentName);
		return this;
	}
	
	@Override
	public AbstractReplyException setContentType(final String contentType) {

		this.reply = this.reply.setContentType(contentType);
		return this;
	}
	
	@Override
	public AbstractReplyException setEncoding(final Charset charset) {

		this.reply = this.reply.setEncoding(charset);
		return this;
	}
	
	@Override
	public AbstractReplyException setEncoding(final String encoding) {

		this.reply = this.reply.setEncoding(encoding);
		return this;
	}
	
	@Override
	public AbstractReplyException setExpirationDate(final long date) {

		this.reply = this.reply.setExpirationDate(date);
		return this;
	}
	
	@Override
	public AbstractReplyException setFinal() {

		this.reply = this.reply.setFinal();
		return this;
	}
	
	@Override
	public AbstractReplyException setFlags(final BaseObject flags) {

		this.reply = this.reply.setFlags(flags);
		return this;
	}
	
	@Override
	public AbstractReplyException setLastModified(final long date) {

		this.reply = this.reply.setLastModified(date);
		return this;
	}
	
	@Override
	public AbstractReplyException setNoCaching() {

		this.reply = this.reply.setNoCaching();
		return this;
	}
	
	@Override
	public AbstractReplyException setPrivate() {

		this.reply = this.reply.setPrivate();
		return this;
	}
	
	@Override
	public AbstractReplyException setSessionID(final String sessionId) {

		this.reply = this.reply.setSessionID(sessionId);
		return this;
	}
	
	@Override
	public AbstractReplyException setSourceAddress(final String address) {

		this.reply = this.reply.setSourceAddress(address);
		return this;
	}
	
	@Override
	public AbstractReplyException setSourceAddressExact(final String address) {

		this.reply = this.reply.setSourceAddressExact(address);
		return this;
	}
	
	@Override
	public AbstractReplyException setSubject(final String subject) {

		this.reply = this.reply.setSubject(subject);
		return this;
	}
	
	@Override
	public AbstractReplyException setTarget(final String target) {

		this.reply = this.reply.setTarget(target);
		return this;
	}
	
	@Override
	public AbstractReplyException setTargetExact(final String target) {

		this.reply = this.reply.setTargetExact(target);
		return this;
	}
	
	@Override
	public AbstractReplyException setTimeToLiveSeconds(final int seconds) {

		this.reply = this.reply.setTimeToLiveSeconds(seconds);
		return this;
	}
	
	@Override
	public AbstractReplyException setTitle(final String title) {

		this.reply = this.reply.setTitle(title);
		return this;
	}
	
	@Override
	public AbstractReplyException setUserID(final String userId) {

		this.reply = this.reply.setUserID(userId);
		return this;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public WrapperReplyException toBinary() throws Flow.FlowOperationException {

		this.reply = this.reply.toBinary();
		return this;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public WrapperReplyException toCharacter() throws Flow.FlowOperationException {

		this.reply = this.reply.toCharacter();
		return this;
	}
	
	@Override
	public String toString() {

		return "[WrapperReplyException: " + this.reply + "]";
	}
	
	@Override
	public AbstractReplyException useAttributes(final BaseObject attributes) {

		this.reply = this.reply.useAttributes(attributes);
		return this;
	}
	
	@Override
	public AbstractReplyException useFlags(final BaseObject flags) {

		this.reply = this.reply.useFlags(flags);
		return this;
	}
}
