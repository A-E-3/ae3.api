package ru.myx.ae3.exec;

import com.sun.istack.internal.NotNull;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;

/**
 * normal. ->RR, NN_NXT
 */
final class EFA_BNN_NXT extends ResultHandlerDirect implements ResultHandler.UseRB {
	
	
	public static final ResultHandlerDirect INSTANCE = new EFA_BNN_NXT();

	private EFA_BNN_NXT() {
		// prevent
	}

	@Override
	public final ExecStateCode execReturn(@NotNull final ExecProcess ctx, @NotNull final BaseObject value) {
		
		
		ctx.ra0RB = value;
		return null;
	}

	@Override
	public final ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final double value) {
		
		
		ctx.ra0RB = Base.forDouble(value);
		return null;
	}

	@Override
	public final ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final int value) {
		
		
		ctx.ra0RB = Base.forInteger(value);
		return null;
	}

	@Override
	public final ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final long value) {
		
		
		ctx.ra0RB = Base.forLong(value);
		return null;
	}

	@Override
	public final ExecStateCode execReturnString(@NotNull final ExecProcess ctx, final String value) {
		
		
		ctx.ra0RB = Base.forString(value);
		return null;
	}
	
}
