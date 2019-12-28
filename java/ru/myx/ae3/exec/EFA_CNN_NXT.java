package ru.myx.ae3.exec;


import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;

/**
 * extended. temporary. character/string.
 */
final class EFA_CNN_NXT extends ResultHandlerDirect implements ResultHandler.UseRS {
	
	
	public static final ResultHandlerDirect INSTANCE = new EFA_CNN_NXT();

	private EFA_CNN_NXT() {
		// prevent
	}

	@Override
	public final ExecStateCode execReturn(final ExecProcess ctx, final BaseObject value) {
		
		
		// ctx.rs7RR = value;
		ctx.ra3RS = value.baseToJavaString();
		return null;
	}

	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final double value) {
		
		
		ctx.ra3RS = Base.toString(value);
		// ctx.rs7RR = ctx.static7RS;
		return null;
	}

	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final int value) {
		
		
		ctx.ra3RS = Base.toString(value);
		// ctx.rs7RR = ctx.static7RS;
		return null;
	}

	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final long value) {
		
		
		ctx.ra3RS = Base.toString(value);
		// ctx.rs7RR = ctx.static7RS;
		return null;
	}

	@Override
	public final ExecStateCode execReturnString(final ExecProcess ctx, final String value) {
		
		
		ctx.ra3RS = value;
		// ctx.rs7RR = ctx.static7RS;
		return null;
	}
	
}
