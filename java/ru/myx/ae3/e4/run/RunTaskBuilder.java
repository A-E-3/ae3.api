package ru.myx.ae3.e4.run;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @author myx
 * 		
 */
public interface RunTaskBuilder {
	
	static void example() {
		
		Run.createManagerBuilder().build().design(null)//
				.setTaskTitle("Example Task")//
				.executeSingle(() -> System.out.println("Hello!"))//
				.launchLater(10, TimeUnit.SECONDS);
				
	}
	
	RunTaskBuilder setTaskTitle(CharSequence title);
	
	/**
	 * Will run single task
	 * 
	 * @param runnable
	 * @return
	 */
	RunTaskBuilder executeSingle(Runnable runnable);
	
	/**
	 * Will run sequence of tasks regardless of exceptions in each task.
	 * 
	 * @param runnable
	 * @return
	 */
	RunTaskBuilder executeSequence(Runnable... runnable);
	
	/**
	 * 
	 * Task is failed and cancelled if any of the sub-tasks fail.
	 * 
	 * @param runnable
	 * @return
	 */
	RunTaskBuilder executeLogicalAnd(Runnable... runnable);
	
	/**
	 * Executes each following task only when previous task fails.
	 * 
	 * Task is failed if last task is failed.
	 * 
	 * @param runnable
	 * @return
	 */
	RunTaskBuilder executeLogicalOr(Runnable... runnable);
	
	/**
	 * 
	 * @param builder
	 * @return
	 */
	RunTaskBuilder andThen(RunTaskBuilder builder);
	
	/**
	 * 
	 * @param builder
	 * @return
	 */
	RunTaskBuilder andThen(Runnable builder);
	
	/**
	 * Finishes construction
	 */
	void launchAsync();
	
	/**
	 * Finishes construction
	 * 
	 * @param delayMillis
	 */
	void launchLater(long delayMillis);
	
	/**
	 * Finishes construction
	 * 
	 * @param delay
	 * @param unit
	 */
	default void launchLater(long delay, TimeUnit unit) {
		
		this.launchLater(unit.toMillis(delay));
	}
}
