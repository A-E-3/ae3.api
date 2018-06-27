package ru.myx.ae3.exec;

import static ru.myx.ae3.exec.ExecStateCode.RETURN;

import com.sun.istack.internal.NotNull;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;

/**
 * extended. temporary. character/string.
 */
final class EFB_CNN_RET extends ResultHandlerBasic implements ResultHandler.UseRS, ResultHandlerBasic.ExecutionControl {
	
	
	public static final ResultHandler INSTANCE = new EFB_CNN_RET();

	private EFB_CNN_RET() {
		// prevent
	}

	@Override
	public final ExecStateCode execReturn(@NotNull final ExecProcess ctx) {
		
		
		return RETURN;
	}

	@Override
	public final ExecStateCode execReturn(@NotNull final ExecProcess ctx, @NotNull final BaseObject value) {
		
		
		// ctx.rs7RR = value;
		ctx.ra3RS = value.baseToJavaString();
		return RETURN;
	}

	@Override
	public final ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final double value) {
		
		
		ctx.ra3RS = Base.toString(value);
		// ctx.rs7RR = ctx.static7RS;
		return RETURN;
	}

	@Override
	public final ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final int value) {
		
		
		ctx.ra3RS = Base.toString(value);
		// ctx.rs7RR = ctx.static7RS;
		return RETURN;
	}

	@Override
	public final ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final long value) {
		
		
		ctx.ra3RS = Base.toString(value);
		// ctx.rs7RR = ctx.static7RS;
		return RETURN;
	}

	@Override
	public final ExecStateCode execReturnString(@NotNull final ExecProcess ctx, final String value) {
		
		
		ctx.ra3RS = value;
		// ctx.rs7RR = ctx.static7RS;
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
