package ru.myx.ae3.exec;

import com.sun.istack.internal.NotNull;

import ru.myx.ae3.base.BaseObject;

/**
 * extended. stackable / detach-able. non-native.
 */
final class EFS_BNN_NXT extends ResultHandlerDirect implements ResultHandler.UseRB {
	
	
	public static final ResultHandlerDirect INSTANCE = new EFS_BNN_NXT();

	private EFS_BNN_NXT() {
		// prevent
	}

	@Override
	public final ExecStateCode execReturn(@NotNull final ExecProcess ctx, @NotNull final BaseObject value) {
		
		
		ctx.ra0RB = value;
		return null;
	}

	@Override
	public final ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final double value) {
		
		
		return ctx.vmSetResultVmStackNumeric(value);
	}

	@Override
	public final ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final int value) {
		
		
		return ctx.vmSetResultVmStackNumeric(value);
	}

	@Override
	public final ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final long value) {
		
		
		return ctx.vmSetResultVmStackNumeric(value);
	}

	@Override
	public final ExecStateCode execReturnString(@NotNull final ExecProcess ctx, final String value) {
		
		
		return ctx.vmSetResultVmStackString(value);
	}
}
