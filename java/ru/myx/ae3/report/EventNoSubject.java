/*
 * Created on 28.03.2006
 */
package ru.myx.ae3.report;

import ru.myx.ae3.reflect.ReflectionHidden;
import ru.myx.ae3.reflect.ReflectionIgnore;

/** @author myx */
@ReflectionIgnore
final class EventNoSubject extends AbstractEvent {
	
	/** @param stringBuilder
	 * @param typeId
	 * @param title
	 */
	@ReflectionHidden
	static StringBuilder formatAsLogEntry(final StringBuilder stringBuilder, final String typeId, final String title) {
		
		return stringBuilder.append('"').append(typeId).append("\" \"").append(title).append('"');
	}

	final String eventTypeId;

	final String title;

	EventNoSubject(final String eventTypeId, final String title) {
		
		this.eventTypeId = eventTypeId;
		this.title = title;
	}
	
	@Override
	@ReflectionHidden
	public StringBuilder formatAsLogEntry(final StringBuilder stringBuilder) {
		
		return EventNoSubject.formatAsLogEntry(stringBuilder, this.eventTypeId, this.title);
	}

	@Override
	public String getEventTypeId() {

		return this.eventTypeId;
	}

	@Override
	public String getTitle() {

		return this.title;
	}
}
