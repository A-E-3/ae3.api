package ru.myx.ae3.exec;

import com.sun.istack.internal.NotNull;

import ru.myx.ae3.base.BaseObject;

/**
 * normal. output.
 */
final class EFB_BNO_NXT extends ResultHandlerBasic implements ResultHandler.UseRB, ResultHandlerBasic.ExecutionContinue {
	
	
	public static final ResultHandlerBasic INSTANCE = new EFB_BNO_NXT();

	private EFB_BNO_NXT() {
		// prevent
	}

	@Override
	public final ExecStateCode execReturn(@NotNull final ExecProcess ctx) {
		
		
		return ctx.execOutput(ctx.ra0RB);
	}

	@Override
	public final ExecStateCode execReturn(@NotNull final ExecProcess ctx, @NotNull final BaseObject value) {
		
		
		final ExecStateCode code = ctx.execOutput(value);
		if (code != null) {
			return code;
		}
		ctx.ra0RB = value;
		return null;
	}

	@Override
	public boolean isExecutionNext() {
		
		
		return true;
	}

	@Override
	public boolean isOutput() {
		
		
		return true;
	}

	@Override
	public final boolean isStackPush() {
		
		
		return false;
	}

	@Override
	public boolean isWithEffects() {
		
		
		return true;
	}

	@Override
	public ResultHandlerBasic replaceDoOutput() {
		
		
		return null;
	}

	@Override
	public ResultHandlerBasic replaceEffectsOnly() {
		
		
		return this;
	}
}
