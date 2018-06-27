package ru.myx.ae3.e4.run;

import java.util.concurrent.Callable;

/**
 * 
 * @author myx
 * 		
 */
public class RunFrameCallCallable extends RunFrameAbstract<RunProcessContext> {
	
	private Callable<?> callable;
	RunFrameCallCallable(Callable<?> callable) {
		this.callable = callable;
	}
	
	@Override
	public void executeFrame(RunProcessContext process) {
		
		try {
			this.callable.call();
		} catch (Exception e) {
			Thread.currentThread().getThreadGroup().uncaughtException(Thread.currentThread(), e);
			// process.log?
			
		}
	}
}
