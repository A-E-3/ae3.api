package ru.myx.ae3.exec;

import static ru.myx.ae3.exec.ExecStateCode.RETURN;


import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;

/**
 * extended. temporary. integer/long.
 */
final class EFB_LNN_RET extends ResultHandlerBasic implements ResultHandler.UseRL, ResultHandlerBasic.ExecutionControl {
	
	
	public static final ResultHandler INSTANCE = new EFB_LNN_RET();

	private EFB_LNN_RET() {
		// prevent
	}

	@Override
	public final ExecStateCode execReturn(final ExecProcess ctx) {
		
		
		return RETURN;
	}

	@Override
	public final ExecStateCode execReturn(final ExecProcess ctx, final BaseObject value) {
		
		
		// ctx.rs7RR = value;
		ctx.ra1RL = value.baseToJavaLong();
		return RETURN;
	}

	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final double value) {
		
		
		ctx.ra1RL = (long) value;
		// ctx.rs7RR = ctx.static7RL;
		return RETURN;
	}

	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final int value) {
		
		
		ctx.ra1RL = value;
		// ctx.rs7RR = ctx.static7RL;
		return RETURN;
	}

	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final long value) {
		
		
		ctx.ra1RL = value;
		// ctx.rs7RR = ctx.static7RL;
		return RETURN;
	}

	@Override
	public final ExecStateCode execReturnString(final ExecProcess ctx, final String value) {
		
		
		ctx.ra1RL = (long) Base.toDouble(value);
		// ctx.rs7RR = ctx.static7RL;
		return RETURN;
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
