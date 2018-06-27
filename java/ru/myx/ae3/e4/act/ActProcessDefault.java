package ru.myx.ae3.e4.act;

import ru.myx.ae3.console.ConsoleLogger;
import ru.myx.ae3.e4.context.FrameContext;
import ru.myx.ae3.e4.run.RunFrameContext;
import ru.myx.ae3.e4.run.RunProcessContext;
import ru.myx.ae3.e4.run.RunProcessRooted;

/**
 * 
 * @author myx
 *		
 */
class ActProcessDefault implements ActProcessContext, RunProcessRooted {
	
	@Override
	public RunProcessContext getParentProcess() {
		
		// TODO Auto-generated method stub
		return null;
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
	public ConsoleLogger getConsoleLogger() {
		
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public CharSequence getProcessTitle() {
		
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ActTaskContext launch() {
		
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ActTaskContext launch(FrameContext<?> frame) {
		
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ActThreadContext start(FrameContext<?> service) {
		
		// TODO Auto-generated method stub
		return null;
	}
	
}
