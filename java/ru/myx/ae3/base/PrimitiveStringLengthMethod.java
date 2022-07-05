package ru.myx.ae3.base;

import ru.myx.ae3.exec.ExecCallable;
import ru.myx.ae3.exec.ExecCallableJava;
import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;
import ru.myx.ae3.reflect.ReflectionDisable;

@ReflectionDisable
final class PrimitiveStringLengthMethod implements BaseObjectNoOwnProperties, BaseFunction, ExecCallableJava.JavaIntJ0, ExecCallable.ForStore.UseStore0 {

	PrimitiveStringLengthMethod() {
		
		//
	}

	@Override
	public String baseClass() {

		return "function";
	}

	@Override
	public BaseObject baseConstructPrototype() {

		return null;
	}

	@Override
	public boolean baseHasInstance(final BaseObject value) {

		return false;
	}

	@Override
	public BaseObject basePrototype() {

		return BaseObject.PROTOTYPE;
	}

	@Override
	public BasePrimitiveNumber baseToNumber() {

		return BasePrimitiveNumber.NAN;
	}

	@Override
	public BasePrimitive<?> baseToPrimitive(final ToPrimitiveHint hint) {

		return BasePrimitiveNumber.NAN;
	}

	@Override
	public BasePrimitiveString baseToString() {

		return BasePrimitiveNumber.NAN.baseToString();
	}

	@Override
	public ExecCallable baseValue() {

		return this;
	}

	@Override
	public int callIJ0(final BaseObject instance) {

		return instance instanceof final CharSequence charSequence
			? charSequence.length()
			: instance.baseToString().length();
	}
	
	@Override
	public ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {

		return store.execReturnNumeric(
				ctx,
				instance instanceof final CharSequence charSequence
					? charSequence.length()
					: instance.baseToString().length());
	}
	
	@Override
	public boolean execIsConstant() {

		return true;
	}

	@Override
	public Class<? extends Number> execResultClassJava() {

		return Number.class;
	}

	@Override
	public BaseObject execScope() {

		/** executes in real current scope */
		return ExecProcess.GLOBAL;
	}

}
