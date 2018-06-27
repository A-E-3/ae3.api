package ru.myx.ae3.e4.run;

class RunWorkerGroupMain extends ThreadGroup {
	
	static final RunWorkerGroupMain INSTANCE = new RunWorkerGroupMain();
	
	public RunWorkerGroupMain() {
		super(RunWorkerGroupRoot.INSTANCE, "AE3:RUN:MainGroup");
		setDaemon(true);
	}
}
