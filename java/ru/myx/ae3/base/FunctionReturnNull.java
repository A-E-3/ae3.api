package ru.myx.ae3.base;

import com.sun.istack.internal.NotNull;

import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

@ReflectionDisable
final class FunctionReturnNull extends BaseFunctionAbstract {
	
	
	private static final BasePrimitiveString TO_STRING = Base.forString("function(){ return null; }");

	@Override
	@ReflectionHidden
	public BasePrimitiveString baseToString() {
		
		
		return FunctionReturnNull.TO_STRING;
	}

	@Override
	@ReflectionHidden
	public double callDJ0(final BaseObject instance) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public double callDJ1(final BaseObject instance, final BaseObject argument) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public double callDJA(final BaseObject instance, final BaseObject... arguments) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public double callDE0(final ExecProcess ctx, final BaseObject instance) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public double callDEX(final ExecProcess context, final BaseObject instance, final BaseArray arguments) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public int callIJ0(final BaseObject instance) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public int callIJ1(final BaseObject instance, final BaseObject argument) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public int callIJA(final BaseObject instance, final BaseObject... arguments) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public int callIE0(final ExecProcess ctx, final BaseObject instance) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public int callIEX(final ExecProcess context, final BaseObject instance, final BaseArray arguments) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public long callLJ0(final BaseObject instance) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public long callLJ1(final BaseObject instance, final BaseObject argument) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public long callLJA(final BaseObject instance, final BaseObject... arguments) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public long callLE0(final ExecProcess ctx, final BaseObject instance) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public long callLEX(final ExecProcess context, final BaseObject instance, final BaseArray arguments) {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public BaseObject callNJ0(final BaseObject instance) {
		
		
		return BaseObject.NULL;
	}

	@Override
	@ReflectionHidden
	public BaseObject callNJ1(final BaseObject instance, final BaseObject argument) {
		
		
		return BaseObject.NULL;
	}

	@Override
	@ReflectionHidden
	public BaseObject callNJA(final BaseObject instance, final BaseObject... arguments) {
		
		
		return BaseObject.NULL;
	}

	@Override
	@ReflectionHidden
	public BaseObject callNJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return BaseObject.NULL;
	}

	@Override
	@ReflectionHidden
	public final BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {
		
		
		return BaseObject.NULL;
	}

	@Override
	@ReflectionHidden
	public BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
		
		
		return BaseObject.NULL;
	}

	@Override
	@ReflectionHidden
	public BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
		
		
		return BaseObject.NULL;
	}

	@Override
	@ReflectionHidden
	public BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return BaseObject.NULL;
	}

	@Override
	@ReflectionHidden
	public BaseObject callNEX(final ExecProcess context, final BaseObject instance, final BaseArray arguments) {
		
		
		return BaseObject.NULL;
	}

	@Override
	@ReflectionHidden
	public String callSJ0(@NotNull final BaseObject instance) {
		
		
		return null;
	}

	@Override
	@ReflectionHidden
	public String callSJ1(final BaseObject instance, final BaseObject argument) {
		
		
		return null;
	}

	@Override
	@ReflectionHidden
	public String callSJA(final BaseObject instance, final BaseObject... arguments) {
		
		
		return null;
	}

	@Override
	@ReflectionHidden
	public String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return null;
	}

	@Override
	@ReflectionHidden
	public String callSE0(final ExecProcess ctx, final BaseObject instance) {
		
		
		return null;
	}

	@Override
	@ReflectionHidden
	public String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
		
		
		return null;
	}

	@Override
	@ReflectionHidden
	public String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
		
		
		return null;
	}

	@Override
	@ReflectionHidden
	public String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return null;
	}

	@Override
	@ReflectionHidden
	public String callSEX(final ExecProcess context, final BaseObject instance, final BaseArray arguments) {
		
		
		return null;
	}

	@Override
	@ReflectionHidden
	public void callVJ0(final BaseObject instance) {
		
		
		//
	}

	@Override
	@ReflectionHidden
	public void callVJ1(final BaseObject instance, final BaseObject argument) {
		
		
		//
	}

	@Override
	@ReflectionHidden
	public void callVJA(final BaseObject instance, final BaseObject... arguments) {
		
		
		//
	}

	@Override
	@ReflectionHidden
	public void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		//
	}

	@Override
	@ReflectionHidden
	public void callVE0(final ExecProcess ctx, final BaseObject instance) {
		
		
		//
	}

	@Override
	@ReflectionHidden
	public void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
		
		
		//
	}

	@Override
	@ReflectionHidden
	public void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
		
		
		//
	}

	@Override
	@ReflectionHidden
	public void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		//
	}

	@Override
	@ReflectionHidden
	public void callVEX(final ExecProcess context, final BaseObject instance, final BaseArray arguments) {
		
		
		//
	}

	@Override
	@ReflectionHidden
	public int execArgumentsAcceptable() {
		
		
		return 0;
	}

	@Override
	@ReflectionHidden
	public ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {
		
		
		return store.execReturnNull(ctx);
	}

	@Override
	@ReflectionHidden
	public ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {
		
		
		return store.execReturnNull(ctx);
	}

	@Override
	@ReflectionHidden
	public ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {
		
		
		return store.execReturnNull(ctx);
	}

	@Override
	@ReflectionHidden
	public ExecStateCode execCallPrepare(final ExecProcess ctx,
			final BaseObject instance,
			final ResultHandler store,
			final boolean inline,
			final BaseObject argument1,
			final BaseObject argument2) {
		
		
		return store.execReturnNull(ctx);
	}

	@Override
	@ReflectionHidden
	public boolean execIsConstant() {
		
		
		return true;
	}

	@Override
	@ReflectionHidden
	public Class<? extends Object> execResultClassJava() {
		
		
		return Object.class;
	}

	@Override
	@ReflectionHidden
	public final BaseObject execScope() {
		
		
		/**
		 * executes in real current scope
		 */
		return ExecProcess.GLOBAL;
	}

	@Override
	@ReflectionHidden
	public String toString() {
		
		
		return "[function " + this.getClass().getSimpleName() + "]";
	}

}
