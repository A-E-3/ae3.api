/*
 * Created on 22.03.2006
 */
package ru.myx.ae3.answer;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseMessageEditable;
import ru.myx.ae3.base.BaseObject;

/** @author myx
 * @param <T> */
public interface ReplyAnswerEditable<T extends ReplyAnswerEditable<?>> extends ReplyAnswer, BaseMessageEditable<T> {
	
	@Override
	default T addAttribute(final String name, final double value) {
		
		return this.addAttribute(name, Base.forDouble(value));
	}
	
	/** Seals message, returns а message object A, such that any method called on A and that is
	 * changing value of any property will return another message B leaving A properties intact.
	 *
	 * @return */
	@Override
	T seal();
	
	/** Returns the SAME response object.
	 *
	 * @param code
	 * @return reply */
	@Override
	T setCode(int code);
	
	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @param date
	 * @return message */
	@Override
	T setExpirationDate(long date);
	
	/** @return reply */
	@Override
	T setFinal();
	
	/** Returns the SAME response object.
	 *
	 * @param flags
	 * @return reply */
	@Override
	T setFlags(BaseObject flags);
	
	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @param date
	 * @return reply */
	@Override
	T setLastModified(long date);
	
	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @return reply */
	@Override
	T setNoCaching();
	
	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @return reply */
	@Override
	T setPrivate();
	
	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @param address
	 * @return reply */
	@Override
	T setSourceAddress(String address);
	
	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @param address
	 * @return reply */
	@Override
	T setSourceAddressExact(String address);
	
	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @param subject
	 * @return reply */
	@Override
	T setSubject(String subject);
	
	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @param target
	 * @return reply */
	@Override
	T setTarget(String target);
	
	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @param target
	 * @return reply */
	@Override
	T setTargetExact(String target);
	
	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @param days
	 * @return reply */
	@Override
	default T setTimeToLiveDays(final int days) {
		
		return days <= 0
			? this.setNoCaching()
			: this.setTimeToLiveSeconds(days * 60 * 60 * 24);
	}
	
	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @param hours
	 * @return reply */
	@Override
	default T setTimeToLiveHours(final int hours) {
		
		return hours <= 0
			? this.setNoCaching()
			: this.setTimeToLiveSeconds(hours * 60 * 60);
	}
	
	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @param minutes
	 * @return reply */
	@Override
	default T setTimeToLiveMinutes(final int minutes) {
		
		return minutes <= 0
			? this.setNoCaching()
			: this.setTimeToLiveSeconds(minutes * 60);
	}
	
	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @param seconds
	 * @return reply */
	@Override
	T setTimeToLiveSeconds(int seconds);
	
	/** Returns same or new reply with corresponding attribute set.
	 *
	 * @param weeks
	 * @return reply */
	@Override
	default T setTimeToLiveWeeks(final int weeks) {
		
		return weeks <= 0
			? this.setNoCaching()
			: this.setTimeToLiveSeconds(weeks * 60 * 60 * 24 * 7);
	}
	
	/** Returns the SAME response object. Note: title is designed to be a line of text - use
	 * setSubject in case of setting a short descriptions with multiple lines of text.
	 *
	 * @param title
	 * @return reply */
	@Override
	T setTitle(String title);
	
	/** Returns the SAME response object.
	 *
	 * @param flags
	 * @return reply */
	@Override
	T useFlags(BaseObject flags);
}
