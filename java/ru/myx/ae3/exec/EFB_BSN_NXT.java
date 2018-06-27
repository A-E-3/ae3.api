package ru.myx.ae3.exec;

import com.sun.istack.internal.NotNull;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;

/**
 * normal. SN_NXT
 */
final class EFB_BSN_NXT extends ResultHandlerBasic implements ResultHandler.UseRB, ResultHandlerBasic.ExecutionContinue {
	
	
	public static final ResultHandlerBasic INSTANCE = new EFB_BSN_NXT();
	
	private EFB_BSN_NXT() {
		// prevent
	}
	
	@Override
	public final ExecStateCode execReturn(@NotNull final ExecProcess ctx) {
		
		
		ctx.stackPush();
		return null;
	}
	
	@Override
	public final ExecStateCode execReturn(@NotNull final ExecProcess ctx, @NotNull final BaseObject value) {
		
		
		ctx.stackPush(ctx.ra0RB = value);
		return null;
	}
	
	@Override
	public final ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final double value) {
		
		
		ctx.stackPush(ctx.ra0RB = Base.forDouble(value));
		return null;
	}
	
	@Override
	public final ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final int value) {
		
		
		ctx.stackPush(ctx.ra0RB = Base.forInteger(value));
		return null;
	}
	
	@Override
	public final ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final long value) {
		
		
		ctx.stackPush(ctx.ra0RB = Base.forLong(value));
		return null;
	}
	
	@Override
	public final ExecStateCode execReturnString(@NotNull final ExecProcess ctx, final String value) {
		
		
		ctx.stackPush(ctx.ra0RB = Base.forString(value));
		return null;
	}
	
	@Override
	public boolean isExecutionNext() {
		
		
		return true;
	}
	
	@Override
	public boolean isOutput() {
		
		
		return false;
	}
	
	@Override
	public final boolean isStackPush() {
		
		
		return true;
	}
	
	@Override
	public boolean isWithEffects() {
		
		
		return true;
	}
	
	@Override
	public ResultHandlerBasic replaceDoOutput() {
		
		
		return ResultHandler.FB_BSO_NXT;
	}
	
	@Override
	public ResultHandlerBasic replaceEffectsOnly() {
		
		
		return this;
	}
}
