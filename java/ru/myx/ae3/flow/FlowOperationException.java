package ru.myx.ae3.flow;

/** @author myx */
@SuppressWarnings("serial")
public class FlowOperationException extends RuntimeException {

	/** @param message
	 * @param parent */
	public FlowOperationException(final String message, final Throwable parent) {

		super(message, parent);
	}
}