/*
 * Created on 28.03.2006
 */
package ru.myx.ae3.report;

/**
 * @author myx
 * 
 */
public interface ReportReceiver {
	/**
	 * @param event
	 * @return 'true' to be compatible with assertions
	 */
	boolean event(final Event event);
	
	/**
	 * @param evtSourceId
	 * @param evtTypeId
	 * @param evtBody
	 * @return 'true' to be compatible with assertions
	 */
	boolean event(final String evtSourceId, final String evtTypeId, final String evtBody);
}
