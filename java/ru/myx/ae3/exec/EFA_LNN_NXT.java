package ru.myx.ae3.exec;

import com.sun.istack.internal.NotNull;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;

/**
 * extended. temporary. integer/long.
 */
final class EFA_LNN_NXT extends ResultHandlerDirect implements ResultHandler.UseRL {
	
	
	public static final ResultHandlerDirect INSTANCE = new EFA_LNN_NXT();

	private EFA_LNN_NXT() {
		// prevent
	}

	@Override
	public final ExecStateCode execReturn(@NotNull final ExecProcess ctx, @NotNull final BaseObject value) {
		
		
		// ctx.rs7RR = value;
		ctx.ra1RL = value.baseToJavaLong();
		return null;
	}

	@Override
	public final ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final double value) {
		
		
		ctx.ra1RL = (long) value;
		// ctx.rs7RR = ctx.static7RL;
		return null;
	}

	@Override
	public final ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final int value) {
		
		
		ctx.ra1RL = value;
		// ctx.rs7RR = ctx.static7RL;
		return null;
	}

	@Override
	public final ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final long value) {
		
		
		ctx.ra1RL = value;
		// ctx.rs7RR = ctx.static7RL;
		return null;
	}

	@Override
	public final ExecStateCode execReturnString(@NotNull final ExecProcess ctx, final String value) {
		
		
		ctx.ra1RL = (long) Base.toDouble(value);
		// ctx.rs7RR = ctx.static7RL;
		return null;
	}
	
}
