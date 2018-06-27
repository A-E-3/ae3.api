package ru.myx.ae3.e4.context;

/**
 * 
 * It is being executed by workers, returns new FrameContext, or predefined
 * control frames, or NULL.
 * 
 * @author myx
 * @param <ProcessContext>
 * 			
 */
public interface FrameContext<ProcessContext> {
	
	/**
	 * 
	 * @param process
	 */
	void executeFrame(ProcessContext process);
}
