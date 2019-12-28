package ru.myx.ae3.exec;


import ru.myx.ae3.base.BaseObject;

/**
 * normal. ->RR, NN_NXT
 */
final class EFC_PNN_NXT extends ResultHandlerDirect implements ResultHandler.UseCH {
	
	
	public static final EFC_PNN_NXT INSTANCE = new EFC_PNN_NXT();
	
	private EFC_PNN_NXT() {
		// prevent
	}

	@Override
	public final ExecStateCode execReturn(final ExecProcess ctx) {
		
		
		return ctx.riCallResultHandler.execReturn(ctx);
	}

	@Override
	public final ExecStateCode execReturn(final ExecProcess ctx, final BaseObject value) {
		
		
		return ctx.riCallResultHandler.execReturn(ctx, value);
	}

	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final double value) {
		
		
		return ctx.riCallResultHandler.execReturnNumeric(ctx, value);
	}

	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final int value) {
		
		
		return ctx.riCallResultHandler.execReturnNumeric(ctx, value);
	}
	
	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final long value) {
		
		
		return ctx.riCallResultHandler.execReturnNumeric(ctx, value);
	}
	
	@Override
	public final ExecStateCode execReturnString(final ExecProcess ctx, final String value) {
		
		
		return ctx.riCallResultHandler.execReturnString(ctx, value);
	}
	
	/**
	 * Non-default
	 */
	@SuppressWarnings("deprecation")
	@Override
	public final ResultHandlerDirect execToCallDirectHandler(final ExecProcess ctx) {
		
		
		return ctx.riCallResultHandler.execToCallDirectHandler(ctx);
	}
}
