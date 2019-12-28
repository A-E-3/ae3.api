package ru.myx.ae3.exec;


import ru.myx.ae3.base.BaseObject;

/**
 * normal,
 */
final class EFB_BSO_NXT extends ResultHandlerBasic implements ResultHandler.UseRB, ResultHandlerBasic.ExecutionContinue {
	
	
	public static final ResultHandlerBasic INSTANCE = new EFB_BSO_NXT();
	
	private EFB_BSO_NXT() {
		// prevent
	}
	
	@Override
	public final ExecStateCode execReturn(final ExecProcess ctx) {
		
		
		final ExecStateCode code = ctx.execOutput(ctx.ra0RB);
		if (code != null) {
			return code;
		}
		ctx.stackPush();
		return null;
	}
	
	@Override
	public final ExecStateCode execReturn(final ExecProcess ctx, final BaseObject value) {
		
		
		final ExecStateCode code = ctx.execOutput(value);
		if (code != null) {
			return code;
		}
		ctx.stackPush(ctx.ra0RB = value);
		return null;
	}
	
	@Override
	public boolean isExecutionNext() {
		
		
		return true;
	}
	
	@Override
	public boolean isOutput() {
		
		
		return true;
	}
	
	@Override
	public final boolean isStackPush() {
		
		
		return true;
	}
	
	@Override
	public boolean isWithEffects() {
		
		
		return true;
	}
	
	@Override
	public ResultHandlerBasic replaceDoOutput() {
		
		
		return null;
	}
	
	@Override
	public ResultHandlerBasic replaceEffectsOnly() {
		
		
		return this;
	}
}
