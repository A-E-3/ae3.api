package ru.myx.ae3.e5.context;

/** @author myx */
public interface ThreadContext extends ThreadContextProvider {
	
	@Override
	default ThreadContext getThreadContext() {
		
		return this;
	}
}
