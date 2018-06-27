package ru.myx.ae3.e4.run;

/**
 * 
 * @author myx
 * 		
 */
public interface RunProcessRooted extends RunProcessContext {
	
	@Override
	default RunProcessContext getParentProcess() {
		
		return null;
	}
	
}
