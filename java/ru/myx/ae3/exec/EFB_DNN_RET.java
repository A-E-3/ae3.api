package ru.myx.ae3.exec;

import static ru.myx.ae3.exec.ExecStateCode.RETURN;

import com.sun.istack.internal.NotNull;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;

/**
 * extended. temporary. float/double.
 */
final class EFB_DNN_RET extends ResultHandlerBasic implements ResultHandler.UseRD, ResultHandlerBasic.ExecutionControl {
	
	
	public static final ResultHandler INSTANCE = new EFB_DNN_RET();

	private EFB_DNN_RET() {
		// prevent
	}

	@Override
	public final ExecStateCode execReturn(@NotNull final ExecProcess ctx) {
		
		
		return RETURN;
	}

	@Override
	public final ExecStateCode execReturn(@NotNull final ExecProcess ctx, @NotNull final BaseObject value) {
		
		
		// ctx.rs7RR = value;
		ctx.ra2RD = value.baseToJavaLong();
		return RETURN;
	}

	@Override
	public final ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final double value) {
		
		
		ctx.ra2RD = value;
		// ctx.rs7RR = ctx.static7RD;
		return RETURN;
	}

	@Override
	public final ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final int value) {
		
		
		ctx.ra2RD = value;
		// ctx.rs7RR = ctx.static7RD;
		return RETURN;
	}

	@Override
	public final ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final long value) {
		
		
		ctx.ra2RD = value;
		// ctx.rs7RR = ctx.static7RD;
		return RETURN;
	}

	@Override
	public final ExecStateCode execReturnString(@NotNull final ExecProcess ctx, final String value) {
		
		
		ctx.ra2RD = Base.toDouble(value);
		// ctx.rs7RR = ctx.static7RD;
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
