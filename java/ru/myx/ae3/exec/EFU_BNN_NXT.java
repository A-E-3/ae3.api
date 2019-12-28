package ru.myx.ae3.exec;


import ru.myx.ae3.base.BaseObject;

/**
 * extended. unused. UN_NXT
 */
final class EFU_BNN_NXT extends ResultHandlerDirect implements ResultHandler.UseRV {
	
	
	public static final ResultHandlerDirect INSTANCE = new EFU_BNN_NXT();

	private EFU_BNN_NXT() {
		// prevent
	}

	@Override
	public final ExecStateCode execReturn(final ExecProcess ctx, final BaseObject value) {
		
		
		ctx.ra0RB = BaseObject.UNDEFINED;
		return null;
	}

	@Override
	public ExecStateCode execReturnBoolean(final ExecProcess ctx, final boolean value) {
		
		
		ctx.ra0RB = BaseObject.UNDEFINED;
		return null;
	}

	@Override
	public ExecStateCode execReturnChar(final ExecProcess ctx, final char value) {
		
		
		ctx.ra0RB = BaseObject.UNDEFINED;
		return null;
	}

	@Override
	public ExecStateCode execReturnFalse(final ExecProcess ctx) {
		
		
		ctx.ra0RB = BaseObject.UNDEFINED;
		return null;
	}

	@Override
	public ExecStateCode execReturnNull(final ExecProcess ctx) {
		
		
		ctx.ra0RB = BaseObject.UNDEFINED;
		return null;
	}

	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final double value) {
		
		
		ctx.ra0RB = BaseObject.UNDEFINED;
		return null;
	}

	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final int value) {
		
		
		ctx.ra0RB = BaseObject.UNDEFINED;
		return null;
	}

	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final long value) {
		
		
		ctx.ra0RB = BaseObject.UNDEFINED;
		return null;
	}

	@Override
	public ExecStateCode execReturnNumeric(final ExecProcess ctx, final short value) {
		
		
		ctx.ra0RB = BaseObject.UNDEFINED;
		return null;
	}

	@Override
	public ExecStateCode execReturnObject(final ExecProcess ctx, final Object value) {
		
		
		ctx.ra0RB = BaseObject.UNDEFINED;
		return null;
	}

	@Override
	public final ExecStateCode execReturnString(final ExecProcess ctx, final String value) {
		
		
		ctx.ra0RB = BaseObject.UNDEFINED;
		return null;
	}

	@Override
	public ExecStateCode execReturnTrue(final ExecProcess ctx) {
		
		
		ctx.ra0RB = BaseObject.UNDEFINED;
		return null;
	}

	@Override
	public ExecStateCode execReturnUndefined(final ExecProcess ctx) {
		
		
		ctx.ra0RB = BaseObject.UNDEFINED;
		return null;
	}
}
