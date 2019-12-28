package ru.myx.ae3.exec;


import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;

/**
 * extended. temporary. float/double.
 */
final class EFA_DNN_NXT extends ResultHandlerDirect implements ResultHandler.UseRD {
	
	
	public static final ResultHandlerDirect INSTANCE = new EFA_DNN_NXT();

	private EFA_DNN_NXT() {
		// prevent
	}

	@Override
	public final ExecStateCode execReturn(final ExecProcess ctx, final BaseObject value) {
		
		
		// ctx.rs7RR = value;
		ctx.ra2RD = value.baseToJavaLong();
		return null;
	}

	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final double value) {
		
		
		ctx.ra2RD = value;
		// ctx.rs7RR = ctx.static7RD;
		return null;
	}

	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final int value) {
		
		
		ctx.ra2RD = value;
		// ctx.rs7RR = ctx.static7RD;
		return null;
	}

	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final long value) {
		
		
		ctx.ra2RD = value;
		// ctx.rs7RR = ctx.static7RD;
		return null;
	}

	@Override
	public final ExecStateCode execReturnString(final ExecProcess ctx, final String value) {
		
		
		ctx.ra2RD = Base.toDouble(value);
		// ctx.rs7RR = ctx.static7RD;
		return null;
	}
	
}
