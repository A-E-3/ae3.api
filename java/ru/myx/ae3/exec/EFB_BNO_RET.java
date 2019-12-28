package ru.myx.ae3.exec;

import static ru.myx.ae3.exec.ExecStateCode.RETURN;


import ru.myx.ae3.base.BaseObject;

/**
 * normal. output.
 */
final class EFB_BNO_RET extends ResultHandlerBasic implements ResultHandler.UseRB, ResultHandlerBasic.ExecutionControl {
	
	
	public static final ResultHandlerBasic INSTANCE = new EFB_BNO_RET();

	private EFB_BNO_RET() {
		// prevent
	}

	@Override
	public final ExecStateCode execReturn(final ExecProcess ctx) {
		
		
		final ExecStateCode code = ctx.execOutput(ctx.ra0RB);
		if (code != null) {
			return code;
		}
		return RETURN;
	}

	@Override
	public final ExecStateCode execReturn(final ExecProcess ctx, final BaseObject value) {
		
		
		final ExecStateCode code = ctx.execOutput(value);
		if (code != null) {
			return code;
		}
		ctx.ra0RB = value;
		return RETURN;
	}

	@Override
	public boolean isExecutionNext() {
		
		
		return false;
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
}
