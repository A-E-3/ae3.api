package ru.myx.ae3.e5.context;

/** @author myx */
public interface TaskContext extends TaskContextProvider {
	
	@Override
	default TaskContext getTaskContext() {
		
		return this;
	}
	
}
