package ru.myx.ae3.exec;

import static ru.myx.ae3.exec.ExecStateCode.RETURN;


import ru.myx.ae3.base.BaseObject;

/**
 * 'P' - proxy (to call handler)
 */
final class EFC_PNN_RET extends ResultHandlerBasic implements ResultHandler.UseCH, ResultHandlerBasic.ExecutionControl {
	
	
	public static final EFC_PNN_RET INSTANCE = new EFC_PNN_RET();

	private EFC_PNN_RET() {
		// prevent
	}

	@Override
	public final ExecStateCode execReturn(final ExecProcess ctx) {
		
		
		final ExecStateCode code = ctx.riCallResultHandler.execReturn(ctx);
		if (code == null) {
			return RETURN;
		}
		return code;
	}

	@Override
	public final ExecStateCode execReturn(final ExecProcess ctx, final BaseObject value) {
		
		
		final ExecStateCode code = ctx.riCallResultHandler.execReturn(ctx, value);
		if (code == null) {
			return RETURN;
		}
		return code;
	}

	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final double value) {
		
		
		final ExecStateCode code = ctx.riCallResultHandler.execReturnNumeric(ctx, value);
		if (code == null) {
			return RETURN;
		}
		return code;
	}

	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final int value) {
		
		
		final ExecStateCode code = ctx.riCallResultHandler.execReturnNumeric(ctx, value);
		if (code == null) {
			return RETURN;
		}
		return code;
	}

	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final long value) {
		
		
		final ExecStateCode code = ctx.riCallResultHandler.execReturnNumeric(ctx, value);
		if (code == null) {
			return RETURN;
		}
		return code;
	}

	@Override
	public final ExecStateCode execReturnString(final ExecProcess ctx, final String value) {
		
		
		final ExecStateCode code = ctx.riCallResultHandler.execReturnString(ctx, value);
		if (code == null) {
			return RETURN;
		}
		return code;
	}

	@Override
	public boolean isExecutionNext() {
		
		
		return false;
	}

	@Override
	public boolean isOutput() {
		
		
		return false;
	}

	@Override
	public final boolean isStackPush() {
		
		
		return false;
	}

	@Override
	public boolean isWithEffects() {
		
		
		return false;
	}

	@Override
	public ResultHandlerBasic replaceDoOutput() {
		
		
		return EFB_BNO_RET.INSTANCE;
	}
}
