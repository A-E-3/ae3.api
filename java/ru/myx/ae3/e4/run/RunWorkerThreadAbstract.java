package ru.myx.ae3.e4.run;

/**
 * 
 * @author myx
 * 		
 * @param
 * 			<P>
 * @param <F>
 * 			
 */
public abstract class RunWorkerThreadAbstract<P extends RunProcessContext, F extends RunFrameContext<P>> extends Thread {
	
	RunWorkerThreadAbstract(final ThreadGroup group, final String name) {
		super(group, name);
	}
	
	P process;
	F frame;
	
	@Override
	public void run() {
		
		this.frame.executeFrame(this.process);
	}
}
