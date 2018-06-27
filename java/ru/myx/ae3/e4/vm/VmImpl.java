package ru.myx.ae3.e4.vm;

import ru.myx.ae3.e4.context.FrameContext;
import ru.myx.ae3.e4.context.ProcessContext;

public interface VmImpl<A> {
	
	/**
	 * 
	 * @param callee
	 */
	void enqueueRoot(ProcessContext process, A callee);
	
	/**
	 * 
	 * @param caller
	 * @param callee
	 */
	void enqueueCall(FrameContext<?> caller, A callee);
}
