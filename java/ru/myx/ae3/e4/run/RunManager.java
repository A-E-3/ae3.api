package ru.myx.ae3.e4.run;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * 
 * @author myx
 * 		
 */
public interface RunManager {
	
	/**
	 * 
	 * @return
	 */
	static RunManager getInstance() {
		
		final Thread thread = Thread.currentThread();
		if (thread instanceof RunWorkerThreadAbstract) {
			final RunProcessContext process = ((RunWorkerThreadAbstract<?, ?>) thread).process;
			if (process != null) {
				return process;
			}
		}
		return Run.PROCESS_CONTEXT_ANONYMOUS;
	}
	
	/**
	 * 
	 * @return
	 */
	default RunTaskBuilder design() {
		
		return new RunTaskBuilderSimple(null);
	}
	
	/**
	 * @param frame
	 * 			
	 */
	default void launch(Runnable frame) {
		
		this.launch(new RunFrameRunRunnable(frame));
	}
	
	/**
	 * 
	 * @param frame
	 */
	default void launch(Callable<?> frame) {
		
		this.launch(new RunFrameCallCallable(frame));
	}
	
	/**
	 * 
	 * @param function
	 * @param argument
	 */
	default <T, R> void launch(Function<T, R> function, T argument) {
		
		this.launch(new RunFrameCallFunction<>(function, argument));
	}
	
	/**
	 * 
	 * @param frame
	 */
	<P extends RunProcessContext> void launch(RunFrameContext<P> frame);
	
	/**
	 * @param frame
	 * @param delayMillis
	 * 			
	 */
	default void later(final Runnable frame, long delayMillis) {
		
		this.later(new RunFrameRunRunnable(frame), delayMillis);
	}
	
	/**
	 * 
	 * @param frame
	 * @param delayMillis
	 */
	default void later(final Callable<?> frame, long delayMillis) {
		
		this.later(new RunFrameCallCallable(frame), delayMillis);
	}
	
	/**
	 * 
	 * @param function
	 * @param argument
	 * @param delayMillis
	 */
	default <T, R> void later(Function<T, R> function, T argument, long delayMillis) {
		
		this.later(new RunFrameCallFunction<>(function, argument), delayMillis);
	}
	
	/**
	 * 
	 * @param frame
	 * @param delayMillis
	 */
	<P extends RunProcessContext> void later(RunFrameContext<P> frame, long delayMillis);
	
	/**
	 * 
	 * @param frame
	 * @param delayDuration
	 * @param units
	 */
	default <P extends RunProcessContext> void later(RunFrameContext<P> frame, long delayDuration, TimeUnit units) {
		
		this.later(frame, units.toMillis(delayDuration));
	}
}
