package ru.myx.ae3.e4.run;

/**
 * 
 * @author myx
 *		
 * @param <Task>
 * @param <Function>
 * @param <Argument>
 * @param <Result>
 */
public interface RunTaskRootComplete<Task, Function, Argument, Result> {
	
	/**
	 * 
	 * @param task
	 * @param function
	 * @param argument
	 * @return
	 */
	public Result execute(Task task, Function function, Argument argument);
}
