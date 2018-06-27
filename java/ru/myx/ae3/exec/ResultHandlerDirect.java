package ru.myx.ae3.exec;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

/**
 *
 * No side-effects and NXT (null) result code.
 *
 * @author myx
 *
 */
public abstract class ResultHandlerDirect extends ResultHandlerBasic implements ResultHandlerBasic.ExecutionContinue {
	
	
	@Override
	public final boolean isStackPush() {
		
		
		return false;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public final boolean isOutput() {
		
		
		return false;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public final boolean isExecutionNext() {
		
		
		return true;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public final boolean isWithEffects() {
		
		
		return false;
	}

	/**
	 *
	 * @return
	 * @throws IllegalStateException
	 */
	@Override
	public ResultHandlerBasic replaceEffectsOnly() throws IllegalStateException {
		
		
		return null;
	}

	/**
	 *
	 * @return new handler or NULL if can't add an OUTPUT to given handler (has
	 *         output already)
	 *
	 * @throws IllegalStateException
	 */
	@Override
	@Nullable
	public final ResultHandlerBasic replaceDoOutput() {
		
		
		return ResultHandler.FB_BNO_NXT;
	}

	@Override
	@NotNull
	@Deprecated
	public ResultHandlerDirect execToCallDirectHandler(final ExecProcess ctx) {
		
		
		return this;
	}
	
	@Override
	public ExecStateCode execReturn(@NotNull final ExecProcess ctx) {
		
		
		return null;
	}
}
