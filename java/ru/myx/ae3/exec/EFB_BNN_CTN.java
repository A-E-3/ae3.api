package ru.myx.ae3.exec;

import static ru.myx.ae3.exec.ExecStateCode.CONTINUE;

import com.sun.istack.internal.NotNull;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;

/**
 * normal. -> RR, NN_RET
 */
final class EFB_BNN_CTN extends ResultHandlerBasic implements ResultHandler.UseRB, ResultHandlerBasic.ExecutionControl {
	
	
	public static final ResultHandlerBasic INSTANCE = new EFB_BNN_CTN();
	
	private EFB_BNN_CTN() {
		// prevent
	}
	
	@Override
	public final ExecStateCode execReturn(@NotNull final ExecProcess ctx) {
		
		
		return CONTINUE;
	}
	
	@Override
	public final ExecStateCode execReturn(@NotNull final ExecProcess ctx, @NotNull final BaseObject value) {
		
		
		ctx.ra0RB = value;
		return CONTINUE;
	}
	
	@Override
	public final ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final double value) {
		
		
		ctx.ra0RB = Base.forDouble(value);
		return CONTINUE;
	}
	
	@Override
	public final ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final int value) {
		
		
		ctx.ra0RB = Base.forInteger(value);
		return CONTINUE;
	}
	
	@Override
	public final ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final long value) {
		
		
		ctx.ra0RB = Base.forLong(value);
		return CONTINUE;
	}
	
	@Override
	public final ExecStateCode execReturnString(@NotNull final ExecProcess ctx, final String value) {
		
		
		ctx.ra0RB = Base.forString(value);
		return CONTINUE;
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
}
