package ru.myx.ae3.e4.context;

/**
 * 
 * @author myx
 * 		
 */
public interface ContextFactory {
	
	/**
	 * Returns FrameContext or NULL if frame context is not used by given VM.
	 * 
	 * @return FrameContext or NULL if frame context is not used by given VM
	 */
	FrameContext<?> createRootFrameContext();
	
}
