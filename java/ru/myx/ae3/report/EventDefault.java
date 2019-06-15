/*
 * Created on 28.03.2006
 */
package ru.myx.ae3.report;

import ru.myx.ae3.reflect.ReflectionHidden;
import ru.myx.ae3.reflect.ReflectionIgnore;

/** @author myx */
@ReflectionIgnore
final class EventDefault extends AbstractEvent {

	@ReflectionHidden
	static StringBuilder formatAsLogEntry(final StringBuilder stringBuilder, final String typeId, final String title, final String subject) {

		stringBuilder.append('"').append(typeId).append("\" \"").append(title).append("\" \"");
		if (subject != null) {
			final int subjectLength = subject.length();
			for (int i = 0; i < subjectLength; ++i) {
				final char c = subject.charAt(i);
				if (c == '"') {
					stringBuilder.append("\\\"");
				} else {
					stringBuilder.append(c);
				}
			}
		}
		stringBuilder.append('"');
		return stringBuilder;
	}

	final String eventTypeId;
	
	final String title;
	
	final String subject;
	
	EventDefault(final String eventTypeId, final String title, final String subject) {

		this.eventTypeId = eventTypeId;
		this.title = title;
		this.subject = subject;
	}
	
	@Override
	@ReflectionHidden
	public StringBuilder formatAsLogEntry(final StringBuilder stringBuilder) {

		return EventDefault.formatAsLogEntry(stringBuilder, this.eventTypeId, this.title, this.subject);
	}
	
	@Override
	public String getEventTypeId() {
		
		return this.eventTypeId;
	}
	
	@Override
	public String getSubject() {
		
		return this.subject;
	}

	@Override
	public String getTitle() {
		
		return this.title;
	}
	
}
