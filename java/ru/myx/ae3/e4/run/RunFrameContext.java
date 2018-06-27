package ru.myx.ae3.e4.run;

import ru.myx.ae3.e4.context.FrameContext;

/**
 * 
 * @author myx
 * @param
 * 			<P>
 * 			
 */
public interface RunFrameContext<P extends RunProcessContext> extends FrameContext<P> {
	
	/**
	 * 
	 * @param process
	 */
	@Override
			void executeFrame(P process);
}
