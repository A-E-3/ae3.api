package ru.myx.ae3.exec;


import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;

/**
 * extra. ensure-native. SN_NXT
 */
final class EFN_BSN_NXT implements ResultHandler.UseRB, ResultHandlerBasic.ExecutionContinue {
	
	
	public static final ResultHandler INSTANCE = new EFN_BSN_NXT();

	private EFN_BSN_NXT() {
		// prevent
	}

	@Override
	public final ExecStateCode execReturn(final ExecProcess ctx) {
		
		
		ctx.stackPush(ctx.ra0RB = ExecProcess.vmEnsureNative(ctx.ra0RB));
		return null;
	}

	@Override
	public final ExecStateCode execReturn(final ExecProcess ctx, final BaseObject value) {
		
		
		ctx.stackPush(ctx.ra0RB = ExecProcess.vmEnsureNative(value));
		return null;
	}

	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final double value) {
		
		
		ctx.stackPush(ctx.ra0RB = Base.forDouble(value));
		return null;
	}

	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final int value) {
		
		
		ctx.stackPush(ctx.ra0RB = Base.forInteger(value));
		return null;
	}

	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final long value) {
		
		
		ctx.stackPush(ctx.ra0RB = Base.forLong(value));
		return null;
	}

	@Override
	public final ExecStateCode execReturnString(final ExecProcess ctx, final String value) {
		
		
		ctx.stackPush(ctx.ra0RB = Base.forString(value));
		return null;
	}

	/**
	 * non-default
	 */
	@SuppressWarnings("deprecation")
	@Override
	public final ResultHandlerDirect execToCallDirectHandler(final ExecProcess ctx) {
		
		
		return EFN_BNN_NXT.INSTANCE;
	}
}
