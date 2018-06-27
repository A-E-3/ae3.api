package ru.myx.ae3.e4.run;

import java.util.function.Consumer;

/**
 * 
 * @author myx
 * @param <T>
 * 			
 */
public class RunFrameFeedConsumer<T> extends RunFrameAbstract<RunProcessContext> {
	
	private Consumer<T> consumer;
	private T value;
	RunFrameFeedConsumer(final Consumer<T> consumer, final T value) {
		this.consumer = consumer;
		this.value = value;
	}
	
	@Override
	public void executeFrame(final RunProcessContext process) {
		
		try {
			this.consumer.accept(this.value);
		} catch (Exception e) {
			Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
			// process.log?
			
		}
	}
}
