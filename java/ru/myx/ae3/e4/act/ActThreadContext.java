package ru.myx.ae3.e4.act;

import ru.myx.ae3.e4.context.ThreadContext;

/** @author myx */
public interface ActThreadContext extends ThreadContext {

	/** @return */
	@Override
	ActProcessContext getParentProcess();

	/** @param millis
	 * @return false if thread was interrupted, failed or time-out has expired, true if thread has
	 *         completed normally
	 * @throws InterruptedException */
	boolean join(long millis) throws InterruptedException;
}
