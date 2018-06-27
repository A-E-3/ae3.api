/*
 * Created on 28.03.2006
 */
package ru.myx.ae3.report;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.reflect.ReflectionExplicit;
import ru.myx.ae3.reflect.ReflectionManual;

/**
 * Event's baseValue() method MUST return 'this'
 *
 * @author myx
 * 
 */
@ReflectionManual
public interface Event extends BaseObject {
	
	
	/**
	 * Initialized later
	 */
	public static final BaseObject PROTOTYPE = BaseObject.createObject(BaseObject.PROTOTYPE);

	@Override
	default BaseObject basePrototype() {
		
		
		return Event.PROTOTYPE;
	}

	/**
	 * The date of this event creation/registration.
	 *
	 * @return date
	 */
	@ReflectionExplicit
	long getDate();
	
	/**
	 * returns a string identifying the event type id or NULL.
	 *
	 * @return string
	 */
	@ReflectionExplicit
	String getEventTypeId();
	
	/**
	 * @return process number
	 */
	@ReflectionExplicit
	long getProcess();
	
	/**
	 * returns some text describing a concrete subject (evtBody) of this event.
	 * <b>true </b>.
	 *
	 * @return string
	 */
	@ReflectionExplicit
	String getSubject();
	
	/**
	 * returns a line of text shortly describing the type of the event, i.e.
	 * "ERROR", "REQUEST", "DEBUG"... Should not ever return <b>null </b> value.
	 *
	 * @return string
	 */
	@ReflectionExplicit
	String getTitle();
}
