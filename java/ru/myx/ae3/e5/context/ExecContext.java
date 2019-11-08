package ru.myx.ae3.e5.context;

/** @author myx */
public interface ExecContext extends ExecContextProvider {
	
	@Override
	default ExecContext getExecContext() {
		
		return this;
	}
}
