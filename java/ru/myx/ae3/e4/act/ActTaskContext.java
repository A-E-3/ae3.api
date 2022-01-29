package ru.myx.ae3.e4.act;

import ru.myx.ae3.e4.context.TaskContext;

/** @author myx */
public interface ActTaskContext<V> extends TaskContext, Task<V>

{

	/** @return */
	@Override
	ActProcessContext getParentProcess();

	/** @param millis
	 * @return false if task was cancelled, failed or time-out has expired, true if task has
	 *         completed normally
	 * @throws InterruptedException */
	boolean join(long millis) throws InterruptedException;
}
