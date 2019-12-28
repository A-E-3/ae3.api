package ru.myx.ae3.base;


import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;
import ru.myx.ae3.help.Format;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

@ReflectionDisable
final class FunctionReturnConstantValue extends BaseFunctionAbstract {
	
	
	private final BaseObject constantValue;

	FunctionReturnConstantValue(final BaseObject constantValue) {
		this.constantValue = constantValue;
	}

	@Override
	@ReflectionHidden
	public BasePrimitiveString baseToString() {
		
		
		return Base.forString( //
				"function(){ " //
						+ "  return " //
						+ // this.constantValue.baseToSource(new
							// StringBuilder(), "")
							//
						(this.constantValue instanceof CharSequence
							? Format.Ecma.string(this.constantValue.toString())
							: this.constantValue.baseIsPrimitive()
								? this.constantValue
								: Format.Describe.toEcmaSource(this.constantValue, "")//
						) + "  ;"//
						+ "}"//
		);
	}

	@Override
	@ReflectionHidden
	public double callDJ0(final BaseObject instance) {
		
		
		return this.constantValue.baseToNumber().doubleValue();
	}

	@Override
	@ReflectionHidden
	public double callDJ1(final BaseObject instance, final BaseObject argument) {
		
		
		return this.constantValue.baseToNumber().doubleValue();
	}

	@Override
	@ReflectionHidden
	public double callDJA(final BaseObject instance, final BaseObject... arguments) {
		
		
		return this.constantValue.baseToNumber().doubleValue();
	}

	@Override
	@ReflectionHidden
	public double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return this.constantValue.baseToNumber().doubleValue();
	}

	@Override
	@ReflectionHidden
	public double callDE0(final ExecProcess ctx, final BaseObject instance) {
		
		
		return this.constantValue.baseToNumber().doubleValue();
	}

	@Override
	@ReflectionHidden
	public double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
		
		
		return this.constantValue.baseToNumber().doubleValue();
	}

	@Override
	@ReflectionHidden
	public double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
		
		
		return this.constantValue.baseToNumber().doubleValue();
	}

	@Override
	@ReflectionHidden
	public double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return this.constantValue.baseToNumber().doubleValue();
	}

	@Override
	@ReflectionHidden
	public double callDEX(final ExecProcess context, final BaseObject instance, final BaseArray arguments) {
		
		
		return this.constantValue.baseToNumber().doubleValue();
	}

	@Override
	@ReflectionHidden
	public int callIJ0(final BaseObject instance) {
		
		
		return this.constantValue.baseToJavaInteger();
	}

	@Override
	@ReflectionHidden
	public int callIJ1(final BaseObject instance, final BaseObject argument) {
		
		
		return this.constantValue.baseToJavaInteger();
	}

	@Override
	@ReflectionHidden
	public int callIJA(final BaseObject instance, final BaseObject... arguments) {
		
		
		return this.constantValue.baseToJavaInteger();
	}

	@Override
	@ReflectionHidden
	public int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return this.constantValue.baseToJavaInteger();
	}

	@Override
	@ReflectionHidden
	public int callIE0(final ExecProcess ctx, final BaseObject instance) {
		
		
		return this.constantValue.baseToJavaInteger();
	}

	@Override
	@ReflectionHidden
	public int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
		
		
		return this.constantValue.baseToJavaInteger();
	}

	@Override
	@ReflectionHidden
	public int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
		
		
		return this.constantValue.baseToJavaInteger();
	}

	@Override
	@ReflectionHidden
	public int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return this.constantValue.baseToJavaInteger();
	}

	@Override
	@ReflectionHidden
	public int callIEX(final ExecProcess context, final BaseObject instance, final BaseArray arguments) {
		
		
		return this.constantValue.baseToJavaInteger();
	}

	@Override
	@ReflectionHidden
	public long callLJ0(final BaseObject instance) {
		
		
		return this.constantValue.baseToJavaLong();
	}

	@Override
	@ReflectionHidden
	public long callLJ1(final BaseObject instance, final BaseObject argument) {
		
		
		return this.constantValue.baseToJavaLong();
	}

	@Override
	@ReflectionHidden
	public long callLJA(final BaseObject instance, final BaseObject... arguments) {
		
		
		return this.constantValue.baseToJavaLong();
	}

	@Override
	@ReflectionHidden
	public long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return this.constantValue.baseToJavaLong();
	}

	@Override
	@ReflectionHidden
	public long callLE0(final ExecProcess ctx, final BaseObject instance) {
		
		
		return this.constantValue.baseToJavaLong();
	}

	@Override
	@ReflectionHidden
	public long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
		
		
		return this.constantValue.baseToJavaLong();
	}

	@Override
	@ReflectionHidden
	public long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
		
		
		return this.constantValue.baseToJavaLong();
	}

	@Override
	@ReflectionHidden
	public long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return this.constantValue.baseToJavaLong();
	}

	@Override
	@ReflectionHidden
	public long callLEX(final ExecProcess context, final BaseObject instance, final BaseArray arguments) {
		
		
		return this.constantValue.baseToJavaLong();
	}

	@Override
	@ReflectionHidden
	public BaseObject callNJ0(final BaseObject instance) {
		
		
		return this.constantValue;
	}

	@Override
	@ReflectionHidden
	public BaseObject callNJ1(final BaseObject instance, final BaseObject argument) {
		
		
		return this.constantValue;
	}

	@Override
	@ReflectionHidden
	public BaseObject callNJA(final BaseObject instance, final BaseObject... arguments) {
		
		
		return this.constantValue;
	}

	@Override
	@ReflectionHidden
	public BaseObject callNJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return this.constantValue;
	}

	@Override
	@ReflectionHidden
	public final BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {
		
		
		return this.constantValue;
	}

	@Override
	@ReflectionHidden
	public BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
		
		
		return this.constantValue;
	}

	@Override
	@ReflectionHidden
	public BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
		
		
		return this.constantValue;
	}

	@Override
	@ReflectionHidden
	public BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return this.constantValue;
	}

	@Override
	@ReflectionHidden
	public BaseObject callNEX(final ExecProcess context, final BaseObject instance, final BaseArray arguments) {
		
		
		return this.constantValue;
	}

	@Override
	@ReflectionHidden
	public String callSJ0(final BaseObject instance) {
		
		
		return this.constantValue.baseToJavaString();
	}

	@Override
	@ReflectionHidden
	public String callSJ1(final BaseObject instance, final BaseObject argument) {
		
		
		return this.constantValue.baseToJavaString();
	}

	@Override
	@ReflectionHidden
	public String callSJA(final BaseObject instance, final BaseObject... arguments) {
		
		
		return this.constantValue.baseToJavaString();
	}

	@Override
	@ReflectionHidden
	public String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return this.constantValue.baseToJavaString();
	}

	@Override
	@ReflectionHidden
	public String callSE0(final ExecProcess ctx, final BaseObject instance) {
		
		
		return this.constantValue.baseToJavaString();
	}

	@Override
	@ReflectionHidden
	public String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
		
		
		return this.constantValue.baseToJavaString();
	}

	@Override
	@ReflectionHidden
	public String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
		
		
		return this.constantValue.baseToJavaString();
	}

	@Override
	@ReflectionHidden
	public String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return this.constantValue.baseToJavaString();
	}

	@Override
	@ReflectionHidden
	public String callSEX(final ExecProcess context, final BaseObject instance, final BaseArray arguments) {
		
		
		return this.constantValue.baseToJavaString();
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
		
		
		return store.execReturn(ctx, this.constantValue);
	}

	@Override
	@ReflectionHidden
	public ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {
		
		
		return store.execReturn(ctx, this.constantValue);
	}

	@Override
	@ReflectionHidden
	public ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {
		
		
		return store.execReturn(ctx, this.constantValue);
	}

	@Override
	@ReflectionHidden
	public ExecStateCode execCallPrepare(final ExecProcess ctx,
			final BaseObject instance,
			final ResultHandler store,
			final boolean inline,
			final BaseObject argument1,
			final BaseObject argument2) {
		
		
		return store.execReturn(ctx, this.constantValue);
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
