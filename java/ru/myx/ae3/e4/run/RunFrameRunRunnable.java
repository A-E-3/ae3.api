package ru.myx.ae3.e4.run;

/**
 * 
 * @author myx
 * 		
 */
public class RunFrameRunRunnable extends RunFrameAbstract<RunProcessContext> {
	
	private Runnable runnable;
	RunFrameRunRunnable(Runnable runnable) {
		this.runnable = runnable;
	}
	
	@Override
	public void executeFrame(RunProcessContext process) {
		
		this.runnable.run();
		
	}
}
