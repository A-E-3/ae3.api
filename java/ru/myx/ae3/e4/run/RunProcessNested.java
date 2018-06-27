package ru.myx.ae3.e4.run;

import java.util.concurrent.TimeUnit;

import ru.myx.ae3.console.ConsoleLogger;

/**
 * 
 * @author myx
 * 		
 */
public interface RunProcessNested extends RunProcessContext {
	
	@Override
	default <P extends RunProcessContext> void launch(RunFrameContext<P> frame) {
		
		this.getParentProcess().launch(frame);
	}
	
	@Override
	default <P extends RunProcessContext> void later(RunFrameContext<P> frame, long delayMillis) {
		
		this.getParentProcess().later(frame, delayMillis);
	}
	
	@Override
	default <P extends RunProcessContext> void later(RunFrameContext<P> frame, long delayDuration, TimeUnit units) {
		
		this.later(frame, units.toMillis(delayDuration));
	}
	
	@Override
	default ConsoleLogger getConsoleLogger() {
		
		return this.getParentProcess().getConsoleLogger();
	}
	
}
