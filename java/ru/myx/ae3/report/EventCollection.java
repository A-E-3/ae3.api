/*
 * Created on 28.03.2006
 */
package ru.myx.ae3.report;

import java.util.Collection;

import ru.myx.ae3.reflect.ReflectionHidden;
import ru.myx.ae3.reflect.ReflectionIgnore;

@ReflectionIgnore
final class EventCollection extends AbstractEvent {
	
	@ReflectionHidden
	static StringBuilder formatAsLogEntry(final StringBuilder stringBuilder, final String typeId, final String title, final Collection<?> subjectCollection) {
		
		stringBuilder.append('"').append(typeId).append("\" \"").append(title).append('"');
		if (subjectCollection != null) {
			for (final Object subjectObject : subjectCollection) {
				stringBuilder.append(' ').append('"');
				if (subjectObject != null) {
					final String subject = subjectObject.toString();
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
			}
		}
		return stringBuilder;
	}
	
	final String eventTypeId;
	
	final String title;
	
	String subject = null;
	
	final Collection<?> subjectCollection;
	
	EventCollection(final String eventTypeId, final String title, final Collection<?> subjectCollection) {
		
		this.eventTypeId = eventTypeId;
		this.title = title;
		this.subjectCollection = subjectCollection;
	}
	
	@Override
	@ReflectionHidden
	public StringBuilder formatAsLogEntry(final StringBuilder stringBuilder) {

		return EventCollection.formatAsLogEntry(stringBuilder, this.eventTypeId, this.title, this.subjectCollection);
	}
	
	@Override
	public String getEventTypeId() {
		
		return this.eventTypeId;
	}
	
	@Override
	public String getSubject() {
		
		if (this.subject == null) {
			synchronized (this) {
				if (this.subject == null) {
					final StringBuilder builder = new StringBuilder();
					for (final Object element : this.subjectCollection) {
						if (builder.length() > 0) {
							builder.append(' ');
						}
						builder.append(element);
					}
					this.subject = builder.toString();
				}
			}
		}
		return this.subject;
	}
	
	@Override
	public String getTitle() {
		
		return this.title;
	}
	
}
