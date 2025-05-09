package ru.myx.ae3.base;

import java.util.function.Function;

import ru.myx.ae3.exec.ExecCallableBoth;
import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;
import ru.myx.ae3.reflect.ControlType;
import ru.myx.ae3.reflect.Reflect;
import ru.myx.ae3.reflect.ReflectionDisable;

/** @author myx
 * @param <A>
 *
 * @param <R> */
@ReflectionDisable
public abstract class BaseFunctionActAbstract<A, R> extends BaseFunctionAbstract implements Function<A, R>, ExecCallableBoth.NativeJ1 {

	private final ControlType<A, ?> argumentConverter;
	
	private final ControlType<R, ?> resultConverter;
	
	/** @param argumentClass
	 * @param resultClass */
	@SuppressWarnings("unchecked")
	protected BaseFunctionActAbstract(final Class<? extends A> argumentClass, final Class<? super R> resultClass) {
		
		super();
		this.argumentConverter = (ControlType<A, ?>) Reflect.getConverter(argumentClass);
		this.resultConverter = (ControlType<R, ?>) Reflect.getConverter(resultClass);
	}
	
	@Override
	public abstract R apply(final A arg);

	@Override
	public BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

		final A arg = this.argumentConverter.convertAnyNativeToJava(argument);
		try {
			return this.resultConverter.convertJavaToAnyNative(this.apply(arg));
		} catch (final Error | RuntimeException e) {
			throw e;
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public BaseObject callNJ1(final BaseObject instance, final BaseObject argument) {

		final A arg = this.argumentConverter.convertAnyNativeToJava(argument);
		try {
			return this.resultConverter.convertJavaToAnyNative(this.apply(arg));
		} catch (final Error | RuntimeException e) {
			throw e;
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Deprecated
	@Override
	public int execArgumentsDeclared() {

		return this.argumentConverter.getJavaClass() == Void.class
			? 0
			: 1;
	}
	
	@Override
	public ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {

		final A arg = this.argumentConverter.convertAnyNativeToJava(argument);
		try {
			return this.resultConverter.convertJavaToCtxResult(ctx, this.apply(arg), store);
		} catch (final Error | RuntimeException e) {
			throw e;
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public boolean execIsConstant() {

		return false;
	}
	
	@Override
	public Class<R> execResultClassJava() {

		return this.resultConverter.getJavaClass();
	}
	
	@Override
	public BaseObject execScope() {

		/** executes in real current scope */
		return ExecProcess.GLOBAL;
	}
	
}
