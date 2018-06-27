package ru.myx.ae3.common;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.exec.Exec;
import ru.myx.ae3.help.Format;

/**
 * 
 * @author myx
 * 
 * 
 * @param <V>
 *            value type
 */
public interface FutureValue<V> extends /* java.util.concurrent.Future<V>, */Value<V>, Describable {
	
	
	/**
	 * 
	 * @return
	 */
	boolean isFailed();
	
	/**
	 * 
	 * @return
	 */
	boolean isDone();
	
	/**
	 * 
	 * @return
	 */
	default boolean baseAwait() {
		
		
		if (this.isFailed()) {
			return false;
		}
		try {
			this.baseValue();
			return true;
		} catch (Throwable t) {
			return false;
		}
	}
	
	/**
	 * Actually throws something based on 'error' field. Never returns normally.
	 *
	 * @param error
	 * @param task
	 * 
	 * @return
	 */
	static Error throwTaskFailedError(final Object error, final FutureValue<?> task) {
		
		
		if (error instanceof Error) {
			throw (Error) error;
		}
		if (error instanceof RuntimeException) {
			throw (RuntimeException) error;
		}
		if (error instanceof BaseObject) {
			throw Exec.createThrown(
					(BaseObject) error, //
					task.baseDescribe(),
					task.getClass().getSimpleName() + ": task failed");
		}
		if (error instanceof Throwable) {
			throw new Error(Format.Describe.toEcmaSource(task, ""), (Throwable) error);
		}
		throw Exec.createThrown(
				Base.forUnknown(error), //
				task.baseDescribe(),
				task.getClass().getSimpleName() + ": task failed");
	}
	
	@Override
	default Object baseDescribe() {
		
		
		if (!this.isDone()) {
			return "Unfinished task: class=" + this.getClass().getSimpleName();
		}
		if (this.isFailed()) {
			return "Failed task: class=" + this.getClass().getSimpleName();
		}
		try {
			return "Finished task: class=" + this.getClass().getSimpleName() + ", value=" + Format.Describe.toEcmaSource(this.baseValue(), "");
		} catch (final Throwable t) {
			return Format.Describe.toEcmaSource(t, "");
		}
	}
	
	/**
	 * 
	 * @return
	 */
	// BaseObject toNative();
}
