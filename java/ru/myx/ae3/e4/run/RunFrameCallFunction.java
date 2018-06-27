package ru.myx.ae3.e4.run;

import java.util.function.Function;

/**
 * 
 * @author myx
 * @param <T>
 * @param <R>
 * 			
 */
public class RunFrameCallFunction<T, R> extends RunFrameAbstract<RunProcessContext> {
	
	private Function<T, R> function;
	private T argument;
	
	RunFrameCallFunction(final Function<T, R> function, final T argument) {
		this.function = function;
		this.argument = argument;
	}
	
	@Override
	public void executeFrame(RunProcessContext process) {
		
		this.function.apply(this.argument);
	}
}
