package ru.myx.ae3.exec;


import ru.myx.ae3.base.BaseObject;

/**
 * extended. stackable / detach-able. non-native. string results stay as raw stack strings
 * (ValueStackString) instead of going through the string cache.
 */
final class EFS_BSN_NXT extends ResultHandlerBasic implements ResultHandler.UseRB, ResultHandlerBasic.ExecutionContinue {
	
	
	public static final ResultHandlerBasic INSTANCE = new EFS_BSN_NXT();
	
	private EFS_BSN_NXT() {
		// prevent
	}
	
	@Override
	public final ExecStateCode execReturn(final ExecProcess ctx) {
		
		
		ctx.stackPush();
		return null;
	}
	
	@Override
	public final ExecStateCode execReturn(final ExecProcess ctx, final BaseObject value) {
		
		
		ctx.stackPush(ctx.ra0RB = value);
		return null;
	}
	
	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final double value) {
		
		
		ctx.vmSetResultVmStackNumeric(value);
		ctx.stackPush();
		return null;
	}
	
	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final int value) {
		
		
		ctx.vmSetResultVmStackNumeric(value);
		ctx.stackPush();
		return null;
	}
	
	@Override
	public final ExecStateCode execReturnNumeric(final ExecProcess ctx, final long value) {
		
		
		ctx.vmSetResultVmStackNumeric(value);
		ctx.stackPush();
		return null;
	}
	
	@Override
	public final ExecStateCode execReturnString(final ExecProcess ctx, final String value) {
		
		
		ctx.vmSetResultVmStackString(value);
		ctx.stackPush();
		return null;
	}
	
	/**
	 * non-default
	 */
	@SuppressWarnings("deprecation")
	@Override
	public final ResultHandlerDirect execToCallDirectHandler(final ExecProcess ctx) {
		
		
		return EFS_BNN_NXT.INSTANCE;
	}
	
	@Override
	public boolean isExecutionNext() {
		
		
		return true;
	}
	
	@Override
	public boolean isOutput() {
		
		
		return false;
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
		
		
		return ResultHandler.FB_BSO_NXT;
	}
	
	@Override
	public ResultHandlerBasic replaceEffectsOnly() {
		
		
		return this;
	}
}
