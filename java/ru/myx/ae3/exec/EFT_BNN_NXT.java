package ru.myx.ae3.exec;

import com.sun.istack.internal.NotNull;

import ru.myx.ae3.base.BaseObject;

/**
 * extended. temporary.
 */
final class EFT_BNN_NXT implements ResultHandler.UseRB, ResultHandlerBasic.ExecutionContinue {
	
	
	public static final ResultHandler INSTANCE = new EFT_BNN_NXT();
	
	private EFT_BNN_NXT() {
		// prevent
	}
	
	@Override
	public final ExecStateCode execReturn(@NotNull final ExecProcess ctx) {
		
		
		return null;
	}
	
	@Override
	public final ExecStateCode execReturn(@NotNull final ExecProcess ctx, @NotNull final BaseObject value) {
		
		
		ctx.ra0RB = value;
		return null;
	}
	
	@Override
	public final ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final double value) {
		
		
		return ctx.vmSetResultVmDirectNumeric(value);
	}
	
	@Override
	public final ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final int value) {
		
		
		return ctx.vmSetResultVmDirectNumeric(value);
	}
	
	@Override
	public final ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final long value) {
		
		
		return ctx.vmSetResultVmDirectNumeric(value);
	}
	
	@Override
	public final ExecStateCode execReturnString(@NotNull final ExecProcess ctx, final String value) {
		
		
		return ctx.vmSetResultVmDirectString(value);
	}
	
	/**
	 * non-default
	 */
	@SuppressWarnings("deprecation")
	@Override
	public ResultHandlerDirect execToCallDirectHandler(final ExecProcess ctx) {
		
		
		return EFS_BNN_NXT.INSTANCE;
	}
	
	@Override
	public final String toString() {
		
		
		return this.getClass().getSimpleName();
	}
}
