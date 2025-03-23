package ru.myx.ae3.exec;

import static ru.myx.ae3.exec.ExecStateCode.ERROR;
import static ru.myx.ae3.exec.ExecStateCode.REPEAT;

import java.lang.reflect.InvocationTargetException;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseArray;
import ru.myx.ae3.base.BaseFunction;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/** Execution is performed after (within) full CallContext / CallFrame.
 *
 * There is no distinction based on internal function result type.
 *
 * @author myx */
@ReflectionDisable
public interface ExecCallableFull extends ExecCallableBoth.ExecStore, BaseFunction {

	/** Arguments should be taken from context, result (if any) should be stored in RR register.
	 *
	 * Should not ever return state codes: RETURN, BREAK, CONTINUE
	 *
	 * @param context
	 * @param arguments
	 * @return object
	 * @throws Exception */
	@ReflectionHidden
	ExecStateCode execCallImpl(final ExecProcess context) throws Exception;
	
	@Override
	@ReflectionHidden
	default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {

		if (0 < this.execArgumentsMinimal()) {
			return ctx.vmRaise("Function requires minimum of " + this.execArgumentsMinimal() + " arguments, got " + 0 + " in this call!");
		}
		
		final ExecArguments arguments = ctx.argumentsEmpty();
		
		final int ri0ASP = ctx.ri0ASP;
		
		ctx.vmFrameEntryExCall(inline, instance, this, arguments, store);
		
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
		
		final ExecStateCode code;
		try {
			code = this.execCallImpl(ctx);
			
			if (!inline && code == REPEAT || ctx.ri0BSB <= ri0ASP) {
				return code;
			}
		} catch (final Error | ExecNonMaskedException e) {
			throw e;
		} catch (final InvocationTargetException e) {
			final Throwable t = e.getCause();
			if (t instanceof final ExecNonMaskedException ee) {
				// pass-through
				throw ee;
			}
			if (t instanceof final Error ee) {
				// pass-through
				throw ee;
			}
			ctx.ra0RB = Base.forThrowable(t);
			return ERROR;
		} catch (final Throwable t) {
			ctx.ra0RB = Base.forThrowable(t);
			return ERROR;
		}
		
		return ctx.vmStateFinalizeFrames(code, ri0ASP, inline);
	}
	
	@Override
	@ReflectionHidden
	default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {

		if (arguments.length() < this.execArgumentsMinimal()) {
			return ctx.vmRaise("Function requires minimum of " + this.execArgumentsMinimal() + " arguments, got " + arguments.length() + " in this call!");
		}
		
		final int ri0ASP = ctx.ri0ASP;
		
		ctx.vmFrameEntryExCall(inline, instance, this, arguments, store);
		
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
		
		final ExecStateCode code;
		try {
			code = this.execCallImpl(ctx);
			
			if (!inline && code == REPEAT || ctx.ri0BSB <= ri0ASP) {
				return code;
			}
		} catch (final Error | ExecNonMaskedException e) {
			throw e;
		} catch (final InvocationTargetException e) {
			final Throwable t = e.getCause();
			if (t instanceof final ExecNonMaskedException ee) {
				// pass-through
				throw ee;
			}
			if (t instanceof final Error ee) {
				// pass-through
				throw ee;
			}
			ctx.ra0RB = Base.forThrowable(t);
			return ERROR;
		} catch (final Throwable t) {
			ctx.ra0RB = Base.forThrowable(t);
			return ERROR;
		}
		
		return ctx.vmStateFinalizeFrames(code, ri0ASP, inline);
	}
	
	@Override
	@ReflectionHidden
	default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {

		if (1 < this.execArgumentsMinimal()) {
			return ctx.vmRaise("Function requires minimum of " + this.execArgumentsMinimal() + " arguments, got " + 1 + " in this call!");
		}
		
		final ExecArguments arguments = ctx.argumentsList1(argument);
		
		final int ri0ASP = ctx.ri0ASP;
		
		ctx.vmFrameEntryExCall(inline, instance, this, arguments, store);
		
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
		
		final ExecStateCode code;
		try {
			code = this.execCallImpl(ctx);
			
			if (!inline && code == REPEAT || ctx.ri0BSB <= ri0ASP) {
				return code;
			}
		} catch (final Error | ExecNonMaskedException e) {
			throw e;
		} catch (final InvocationTargetException e) {
			final Throwable t = e.getCause();
			if (t instanceof final ExecNonMaskedException ee) {
				// pass-through
				throw ee;
			}
			if (t instanceof final Error ee) {
				// pass-through
				throw ee;
			}
			ctx.ra0RB = Base.forThrowable(t);
			return ERROR;
		} catch (final Throwable t) {
			ctx.ra0RB = Base.forThrowable(t);
			return ERROR;
		}
		
		return ctx.vmStateFinalizeFrames(code, ri0ASP, inline);
	}
	
	@Override
	@ReflectionHidden
	default ExecStateCode execCallPrepare(final ExecProcess ctx,
			final BaseObject instance,
			final ResultHandler store,
			final boolean inline,
			final BaseObject argument1,
			final BaseObject argument2) {

		if (2 < this.execArgumentsMinimal()) {
			return ctx.vmRaise("Function requires minimum of " + this.execArgumentsMinimal() + " arguments, got " + 2 + " in this call!");
		}
		
		final ExecArguments arguments = ctx.argumentsList2(argument1, argument2);
		
		final int ri0ASP = ctx.ri0ASP;
		
		ctx.vmFrameEntryExCall(inline, instance, this, arguments, store);
		
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
		
		final ExecStateCode code;
		try {
			code = this.execCallImpl(ctx);
			
			if (!inline && code == REPEAT || ctx.ri0BSB <= ri0ASP) {
				return code;
			}
		} catch (final Error | ExecNonMaskedException e) {
			throw e;
		} catch (final InvocationTargetException e) {
			final Throwable t = e.getCause();
			if (t instanceof final ExecNonMaskedException ee) {
				// pass-through
				throw ee;
			}
			if (t instanceof final Error ee) {
				// pass-through
				throw ee;
			}
			ctx.ra0RB = Base.forThrowable(t);
			return ERROR;
		} catch (final Throwable t) {
			ctx.ra0RB = Base.forThrowable(t);
			return ERROR;
		}
		
		return ctx.vmStateFinalizeFrames(code, ri0ASP, inline);
	}
}
