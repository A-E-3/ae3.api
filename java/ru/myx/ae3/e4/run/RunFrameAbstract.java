package ru.myx.ae3.e4.run;

/**
 * 
 * @author myx
 * 		
 * @param
 * 			<P>
 */
public abstract class RunFrameAbstract<P extends RunProcessContext> implements RunFrameContext<P> {
	
	RunFrameAbstract<?> next;
	
	@Override
	public abstract void executeFrame(P process);
}
