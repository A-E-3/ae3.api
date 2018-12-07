/*
 * Created on 28.03.2006
 */
package ru.myx.ae3.report;

import java.util.Collection;

import ru.myx.ae3.reflect.ReflectionExplicit;
import ru.myx.ae3.reflect.ReflectionManual;

/** @author myx */
@ReflectionManual
public interface ReportReceiver {
	
	/** @param event
	 * @return 'true' to be compatible with assertions */
	@ReflectionExplicit
	boolean event(final Event event);
	
	/** @param evtSourceId
	 * @param evtTypeId
	 * @return 'true' to be compatible with assertions */
	@ReflectionExplicit
	default boolean event(final String evtSourceId, final String evtTypeId) {
		
		return this.event(new EventNoSubject(evtSourceId, evtTypeId));
	}

	/** @param evtSourceId
	 * @param evtTypeId
	 * @param evtBody
	 * @return 'true' to be compatible with assertions */
	@ReflectionExplicit
	default boolean event(final String evtSourceId, final String evtTypeId, final Collection<?> evtBody) {
		
		return this.event(
				evtBody == null || evtBody.isEmpty()
					? (Event) new EventNoSubject(evtSourceId, evtTypeId)
					: (Event) new EventCollection(evtSourceId, evtTypeId, evtBody));
	}

	/** @param evtSourceId
	 * @param evtTypeId
	 * @param evtBody
	 * @return 'true' to be compatible with assertions */
	@ReflectionExplicit
	default boolean event(final String evtSourceId, final String evtTypeId, final String evtBody) {
		
		return this.event(
				evtBody == null || evtBody.length() == 0
					? (Event) new EventNoSubject(evtSourceId, evtTypeId)
					: (Event) new EventDefault(evtSourceId, evtTypeId, evtBody));
	}
	
	/** Non-overloaded method for scripting
	 *
	 * @param evtSourceId
	 * @param evtTypeId
	 * @param evtBody
	 */
	@ReflectionExplicit
	default void eventCollection(final String evtSourceId, final String evtTypeId, final Collection<?> evtBody) {
		
		this.event(new EventCollection(evtSourceId, evtTypeId, evtBody));
	}
	
	/** Non-overloaded method for scripting
	 *
	 * @param evtSourceId
	 * @param evtTypeId
	 * @param evtBody
	 */
	@ReflectionExplicit
	default void eventText(final String evtSourceId, final String evtTypeId, final String evtBody) {
		
		this.event(evtSourceId, evtTypeId, evtBody);
	}
	
	/** Non-overloaded method for scripting
	 *
	 * @param evtSourceId
	 * @param evtTypeId
	 */
	@ReflectionExplicit
	default void eventType(final String evtSourceId, final String evtTypeId) {
		
		this.event(new EventNoSubject(evtSourceId, evtTypeId));
	}
}
