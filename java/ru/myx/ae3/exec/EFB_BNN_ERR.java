package ru.myx.ae3.exec;

import static ru.myx.ae3.exec.ExecStateCode.ERROR;


import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;

/**
 * normal. -> RR, NN_RET
 */
final class EFB_BNN_ERR extends ResultHandlerBasic implements ResultHandler.UseRB, ResultHandlerBasic.ExecutionControl {
	
	
	public static final ResultHandlerBasic INSTANCE = new EFB_BNN_ERR();
	
	private EFB_BNN_ERR() {
		// prevent
	}
	
	@Override
	public final ExecStateCode execReturn(final ExecProcess ctx) {
		
		
		return ERROR;
	}
	
	@Override
	public final ExecStateCode execReturn(final ExecProcess ctx, final BaseObject value) {
		
		
		ctx.ra0RB = value;
		return ERROR;
	}
	
	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final double value) {
		
		
		ctx.ra0RB = Base.forDouble(value);
		return ERROR;
	}
	
	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final int value) {
		
		
		ctx.ra0RB = Base.forInteger(value);
		return ERROR;
	}
	
	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final long value) {
		
		
		ctx.ra0RB = Base.forLong(value);
		return ERROR;
	}
	
	@Override
	public final ExecStateCode execReturnString(final ExecProcess ctx, final String value) {
		
		
		ctx.ra0RB = Base.forString(value);
		return ERROR;
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
