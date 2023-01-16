package ru.myx.ae3.exec;

import ru.myx.ae3.reflect.ReflectionDisable;

/** No side-effects and NXT (null) result code.
 *
 * @author myx */
@ReflectionDisable
public abstract class ResultHandlerDirect extends ResultHandlerBasic implements ResultHandlerBasic.ExecutionContinue {
	
	@Override
	public ExecStateCode execReturn(final ExecProcess ctx) {
		
		return null;
	}
	
	@Override
	@Deprecated
	public ResultHandlerDirect execToCallDirectHandler(final ExecProcess ctx) {
		
		return this;
	}
	
	/** @return */
	@Override
	public final boolean isExecutionNext() {
		
		return true;
	}
	
	/** @return */
	@Override
	public final boolean isOutput() {
		
		return false;
	}
	
	@Override
	public final boolean isStackPush() {
		
		return false;
	}
	
	/** @return */
	@Override
	public final boolean isWithEffects() {
		
		return false;
	}
	
	/** @return new handler or NULL if can't add an OUTPUT to given handler (has output already)
	 *
	 * @throws IllegalStateException */
	@Override
	public final ResultHandlerBasic replaceDoOutput() {
		
		return ResultHandler.FB_BNO_NXT;
	}

	/** @return
	 * @throws IllegalStateException */
	@Override
	public ResultHandlerBasic replaceEffectsOnly() throws IllegalStateException {
		
		return null;
	}
}
