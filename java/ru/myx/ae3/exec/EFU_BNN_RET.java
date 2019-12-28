package ru.myx.ae3.exec;

import static ru.myx.ae3.exec.ExecStateCode.RETURN;


import ru.myx.ae3.base.BaseObject;

/**
 * extended. unused. UN_RET
 */
final class EFU_BNN_RET extends ResultHandlerBasic implements ResultHandler.UseRV, ResultHandlerBasic.ExecutionControl {
	
	
	public static final ResultHandlerBasic INSTANCE = new EFU_BNN_RET();

	private EFU_BNN_RET() {
		// prevent
	}

	@Override
	public final ExecStateCode execReturn(final ExecProcess ctx) {
		
		
		return RETURN;
	}

	@Override
	public final ExecStateCode execReturn(final ExecProcess ctx, final BaseObject value) {
		
		
		ctx.ra0RB = BaseObject.UNDEFINED;
		return RETURN;
	}

	@Override
	public ExecStateCode execReturnBoolean(final ExecProcess ctx, final boolean value) {
		
		
		ctx.ra0RB = BaseObject.UNDEFINED;
		return RETURN;
	}

	@Override
	public ExecStateCode execReturnChar(final ExecProcess ctx, final char value) {
		
		
		ctx.ra0RB = BaseObject.UNDEFINED;
		return RETURN;
	}

	@Override
	public ExecStateCode execReturnFalse(final ExecProcess ctx) {
		
		
		ctx.ra0RB = BaseObject.UNDEFINED;
		return RETURN;
	}

	@Override
	public ExecStateCode execReturnNull(final ExecProcess ctx) {
		
		
		ctx.ra0RB = BaseObject.UNDEFINED;
		return RETURN;
	}

	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final double value) {
		
		
		ctx.ra0RB = BaseObject.UNDEFINED;
		return RETURN;
	}

	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final int value) {
		
		
		ctx.ra0RB = BaseObject.UNDEFINED;
		return RETURN;
	}

	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final long value) {
		
		
		ctx.ra0RB = BaseObject.UNDEFINED;
		return RETURN;
	}

	@Override
	public ExecStateCode execReturnNumeric(final ExecProcess ctx, final short value) {
		
		
		ctx.ra0RB = BaseObject.UNDEFINED;
		return RETURN;
	}

	@Override
	public ExecStateCode execReturnObject(final ExecProcess ctx, final Object value) {
		
		
		ctx.ra0RB = BaseObject.UNDEFINED;
		return RETURN;
	}

	@Override
	public final ExecStateCode execReturnString(final ExecProcess ctx, final String value) {
		
		
		ctx.ra0RB = BaseObject.UNDEFINED;
		return RETURN;
	}

	@Override
	public ExecStateCode execReturnTrue(final ExecProcess ctx) {
		
		
		ctx.ra0RB = BaseObject.UNDEFINED;
		return RETURN;
	}

	@Override
	public ExecStateCode execReturnUndefined(final ExecProcess ctx) {
		
		
		ctx.ra0RB = BaseObject.UNDEFINED;
		return RETURN;
	}

	/**
	 * non-default
	 */
	@SuppressWarnings("deprecation")
	@Override
	public final ResultHandlerDirect execToCallDirectHandler(final ExecProcess ctx) {
		
		
		return EFU_BNN_NXT.INSTANCE;
	}

	@Override
	public boolean isExecutionNext() {
		
		
		return false;
	}

	@Override
	public boolean isOutput() {
		
		
		return false;
	}

	@Override
	public final boolean isStackPush() {
		
		
		return false;
	}

	@Override
	public boolean isWithEffects() {
		
		
		return false;
	}

}
