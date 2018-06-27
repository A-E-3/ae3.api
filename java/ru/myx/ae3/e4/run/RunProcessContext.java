package ru.myx.ae3.e4.run;

import ru.myx.ae3.console.ConsoleLogger;
import ru.myx.ae3.e4.context.ProcessContext;

/**
 * 
 * @author myx
 * 		
 */
public interface RunProcessContext extends ProcessContext, RunManager {
	
	/**
	 * 
	 * @return
	 */
	RunProcessContext getParentProcess();
	
	/**
	 * 
	 * @param frame
	 */
	@Override
	<P extends RunProcessContext> void launch(RunFrameContext<P> frame);
	
	/**
	 * 
	 * @param frame
	 * @param delayMillis
	 */
	@Override
	<P extends RunProcessContext> void later(RunFrameContext<P> frame, long delayMillis);
	
	/**
	 * 
	 * @return
	 */
	ConsoleLogger getConsoleLogger();
}
