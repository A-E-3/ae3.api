package ru.myx.ae3.e4.run;

class RunWorkerGroupRoot extends ThreadGroup {
	
	private static final ThreadGroup THREAD_GROUP_ROOT;
	
	static {
		ThreadGroup root = Thread.currentThread().getThreadGroup();
		while (root.getParent() != null) {
			root = root.getParent();
		}
		THREAD_GROUP_ROOT = root;
	}
	
	final static RunWorkerGroupRoot INSTANCE = new RunWorkerGroupRoot();
	
	private RunWorkerGroupRoot() {
		super(THREAD_GROUP_ROOT, "AE3:RUN:RootGroup");
		setDaemon(true);
	}
}
