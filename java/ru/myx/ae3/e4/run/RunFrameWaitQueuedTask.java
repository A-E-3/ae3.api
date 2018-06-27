package ru.myx.ae3.e4.run;

final class RunFrameWaitQueuedTask implements RunFrameContext<RunProcessContext> {
	
	@Override
	public void executeFrame(RunProcessContext process) {
		
		return queue.next();
		
	}
	
}
