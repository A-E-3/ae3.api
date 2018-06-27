package ru.myx.ae3.e4.act;

import ru.myx.ae3.e4.context.FrameContext;
import ru.myx.ae3.e4.run.RunTaskRootComplete;

/**
 * 
 * @author myx
 *		
 * @param <Task>
 * @param <Function>
 * @param <Argument>
 * @param <Result>
 */
public interface ActTaskRootComplete<Task extends ActTaskContext<Result>, Function extends FrameContext<Argument>, Argument, Result>
		extends
			RunTaskRootComplete<Task, Function, Argument, Result> {
	//
}
