package ru.myx.ae3.e4.run;

import java.util.concurrent.Callable;

/**
 * 
 * @author myx
 * 		
 */
public class Run {
	
	final static RunWorkerGroupRoot runWorkerGroupRoot;
	final static RunWorkerGroupMain runWorkerGroupMain;
	
	static {
		runWorkerGroupRoot = RunWorkerGroupRoot.INSTANCE;
		runWorkerGroupMain = RunWorkerGroupMain.INSTANCE;
	}
	
	final static RunProcessContext PROCESS_CONTEXT_ANONYMOUS = new RunProcessDefault();
	
	/**
	 * Launches the task in the current process or in a an anonymous process
	 * group.
	 * 
	 * @param runnable
	 */
	public static void launch(final Runnable runnable) {
		
		RunManager.getInstance().launch(runnable);
	}
	
	/**
	 * Launches the task in the current process or in a an anonymous process
	 * group.
	 * 
	 * @param callable
	 */
	public static void launch(final Callable<?> callable) {
		
		RunManager.getInstance().launch(callable);
	}
	
	/**
	 * Launches the task in the current process or in a an anonymous process
	 * group.
	 * 
	 * @param callable
	 * @param delay
	 */
	public static void later(final Callable<?> callable, final long delay) {
		
		RunManager.getInstance().later(callable, delay);
	}
	
	/**
	 * Launches the task in the current process or in a an anonymous process
	 * group.
	 * 
	 * @param runnable
	 * @param delay
	 */
	public static void later(final Runnable runnable, final long delay) {
		
		RunManager.getInstance().later(runnable, delay);
	}
	
	final static RunManagerBuilder createManagerBuilder() {
		
		return null;
	}
	
	private Run() {
		// prevent
	}
}
