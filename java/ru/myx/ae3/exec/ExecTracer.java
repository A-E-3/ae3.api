package ru.myx.ae3.exec;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseArray;
import ru.myx.ae3.base.BaseObject;

/**
 * @author myx
 *
 */
public interface ExecTracer {
	
	
	/**
	 * @param ctx
	 * @param function
	 * @param thisValue
	 * @param arguments
	 * @return
	 */
	boolean traceCall(ExecProcess ctx, ExecCallable function, BaseObject thisValue, BaseArray arguments);
	
	/**
	 * @param ctx
	 * @param function
	 * @param thisValue
	 * @param arguments
	 * @return
	 */
	default boolean traceCall(final ExecProcess ctx, final ExecCallable function, final BaseObject thisValue, final BaseObject... arguments) {
		
		return this.traceCall(ctx, function, thisValue, Base.forArray(arguments));
	}
	
	/**
	 * @param ctx
	 * @param debug
	 * @return must return true (for use in assertions)
	 */
	boolean traceDebug(ExecProcess ctx, Object debug);
}
