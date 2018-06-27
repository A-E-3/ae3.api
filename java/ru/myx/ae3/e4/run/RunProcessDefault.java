package ru.myx.ae3.e4.run;

import java.util.concurrent.TimeUnit;

import ru.myx.ae3.console.ConsoleLogger;

/**
 * Default anonymous group process
 * 
 * @author myx
 * 		
 */
class RunProcessDefault implements RunProcessRooted {
	
	@Override
	public CharSequence getProcessTitle() {
		
		return "AE3.RUN default anonymous process";
	}
	
	@Override
	public <P extends RunProcessContext> void launch(RunFrameContext<P> frame) {
		
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public <P extends RunProcessContext> void later(RunFrameContext<P> frame, long delayMillis) {
		
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public <P extends RunProcessContext> void later(RunFrameContext<P> frame, long delayDuration, TimeUnit units) {
		
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ConsoleLogger getConsoleLogger() {
		
		// TODO Auto-generated method stub
		return null;
	}
	
}
