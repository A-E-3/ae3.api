/**
 *
 */
package ru.myx.ae3.exec;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseArray;
import ru.myx.ae3.base.BaseFunction;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.reflect.ReflectionDisable;

/** Prepares context and executes vm-native instruction block
 *
 * @author myx */
@ReflectionDisable
public interface ExecCallableStepper extends BaseFunction, InstructionBlock, ExecCallableBoth.ExecStore {

	/** @return int */
	@Override
	default int execArgumentsAcceptable() {

		return 0;
	}
	
	/** @return int */
	@Override
	default int execArgumentsDeclared() {

		return 0;
	}
	
	/** @return int */
	@Override
	default int execArgumentsMinimal() {

		return 0;
	}
	
	@Override
	default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {

		if (0 < this.execArgumentsMinimal()) {
			return ctx.vmRaise("Function requires minimum of " + this.execArgumentsMinimal() + " arguments, got " + 0 + " in this call!");
		}
		
		{
			final ExecArguments arguments = ctx.argumentsEmpty();
			
			ctx.vmFrameEntryExCall(inline, instance, this, arguments, store);
		}
		{
			final BaseObject scope = this.execScope();
			if (scope == ExecProcess.GLOBAL) {
				/** keep current */
			} else //
			if (scope != null) {
				ctx.rb7FV = ctx.ri10GV = scope;
			} else {
				ctx.rb7FV = ctx.ri10GV = Base.seal(ctx.ri10GV);
			}
		}

		this.execSetupContext(ctx);
		
		if (!inline) {
			return ExecStateCode.REPEAT;
		}
		
		return ctx.vmStateFinalizeFrames(ExecStateCode.REPEAT, ctx.ri0BSB - 1, true);
	}
	
	@Override
	default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {

		if (arguments.length() < this.execArgumentsMinimal()) {
			return ctx.vmRaise("Function requires minimum of " + this.execArgumentsMinimal() + " arguments, got " + arguments.length() + " in this call!");
		}
		
		{
			ctx.vmFrameEntryExCall(inline, instance, this, arguments, store);
		}
		{
			final BaseObject scope = this.execScope();
			if (scope == ExecProcess.GLOBAL) {
				/** keep current */
			} else //
			if (scope != null) {
				ctx.rb7FV = ctx.ri10GV = scope;
			} else {
				ctx.rb7FV = ctx.ri10GV = Base.seal(ctx.ri10GV);
			}
		}
		
		this.execSetupContext(ctx);
		
		if (!inline) {
			return ExecStateCode.REPEAT;
		}
		
		return ctx.vmStateFinalizeFrames(ExecStateCode.REPEAT, ctx.ri0BSB - 1, true);
	}
	
	@Override
	default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {

		if (1 < this.execArgumentsMinimal()) {
			return ctx.vmRaise("Function requires minimum of " + this.execArgumentsMinimal() + " arguments, got " + 1 + " in this call!");
		}
		
		{
			final ExecArguments arguments = ctx.argumentsList1(argument);
			
			ctx.vmFrameEntryExCall(inline, instance, this, arguments, store);
		}
		{
			final BaseObject scope = this.execScope();
			if (scope == ExecProcess.GLOBAL) {
				/** keep current */
			} else //
			if (scope != null) {
				ctx.rb7FV = ctx.ri10GV = scope;
			} else {
				ctx.rb7FV = ctx.ri10GV = Base.seal(ctx.ri10GV);
			}
		}
		
		this.execSetupContext(ctx);
		
		if (!inline) {
			return ExecStateCode.REPEAT;
		}
		
		return ctx.vmStateFinalizeFrames(ExecStateCode.REPEAT, ctx.ri0BSB - 1, true);
	}
	
	@Override
	default ExecStateCode execCallPrepare(//
			final ExecProcess ctx, //
			final BaseObject instance,
			final ResultHandler store,
			final boolean inline,
			final BaseObject argument1,
			final BaseObject argument2) {

		if (2 < this.execArgumentsMinimal()) {
			return ctx.vmRaise("Function requires minimum of " + this.execArgumentsMinimal() + " arguments, got " + 2 + " in this call!");
		}
		
		{
			final ExecArguments arguments = ctx.argumentsList2(argument1, argument2);
			
			ctx.vmFrameEntryExCall(inline, instance, this, arguments, store);
			
		}
		{
			final BaseObject scope = this.execScope();
			if (scope == ExecProcess.GLOBAL) {
				/** keep current */
			} else //
			if (scope != null) {
				ctx.rb7FV = ctx.ri10GV = scope;
			} else {
				ctx.rb7FV = ctx.ri10GV = Base.seal(ctx.ri10GV);
			}
		}
		
		this.execSetupContext(ctx);

		if (!inline) {
			return ExecStateCode.REPEAT;
		}
		
		return ctx.vmStateFinalizeFrames(ExecStateCode.REPEAT, ctx.ri0BSB - 1, true);
	}
	
}
