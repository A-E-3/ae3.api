package ru.myx.ae3.exec;

import ru.myx.ae3.base.BaseArray;
import ru.myx.ae3.base.BaseObject;

/**
 *
 * @author myx
 *
 */
public interface ExecCallableWrapper extends ExecCallable {
	
	
	@Override
	default double callDJ0(final BaseObject instance) {
		
		
		return this.function().callDJ0(instance);
	}

	@Override
	default double callDJ1(final BaseObject instance, final BaseObject argument) {
		
		
		return this.function().callDJ1(instance, argument);
	}

	@Override
	default double callDJA(final BaseObject instance, final BaseObject... arguments) {
		
		
		return this.function().callDJA(instance, arguments);
	}

	@Override
	default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return this.function().callDJ2(instance, argument1, argument2);
	}

	@Override
	default double callDE0(final ExecProcess ctx, final BaseObject instance) {
		
		
		return this.function().callDE0(ctx, instance);
	}

	@Override
	default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
		
		
		return this.function().callDE1(ctx, instance, argument);
	}

	@Override
	default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
		
		
		return this.function().callDEA(ctx, instance, arguments);
	}

	@Override
	default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return this.function().callDE2(ctx, instance, argument1, argument2);
	}

	@Override
	default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
		
		
		return this.function().callDEX(ctx, instance, arguments);
	}

	@Override
	default int callIJ0(final BaseObject instance) {
		
		
		return this.function().callIJ0(instance);
	}

	@Override
	default int callIJA(final BaseObject instance, final BaseObject... arguments) {
		
		
		return this.function().callIJA(instance, arguments);
	}

	@Override
	default int callIJ1(final BaseObject instance, final BaseObject argument) {
		
		
		return this.function().callIJ1(instance, argument);
	}

	@Override
	default int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return this.function().callIJ2(instance, argument1, argument2);
	}

	@Override
	default int callIE0(final ExecProcess ctx, final BaseObject instance) {
		
		
		return this.function().callIE0(ctx, instance);
	}

	@Override
	default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
		
		
		return this.function().callIEA(ctx, instance, arguments);
	}

	@Override
	default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
		
		
		return this.function().callIE1(ctx, instance, argument);
	}

	@Override
	default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return this.function().callIE2(ctx, instance, argument1, argument2);
	}

	@Override
	default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
		
		
		return this.function().callIEX(ctx, instance, arguments);
	}

	@Override
	default long callLJ0(final BaseObject instance) {
		
		
		return this.function().callLJ0(instance);
	}

	@Override
	default long callLJ1(final BaseObject instance, final BaseObject argument) {
		
		
		return this.function().callLJ1(instance, argument);
	}

	@Override
	default long callLJA(final BaseObject instance, final BaseObject... arguments) {
		
		
		return this.function().callLJA(instance, arguments);
	}

	@Override
	default long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return this.function().callLJ2(instance, argument1, argument2);
	}

	@Override
	default long callLE0(final ExecProcess ctx, final BaseObject instance) {
		
		
		return this.function().callLE0(ctx, instance);
	}

	@Override
	default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
		
		
		return this.function().callLE1(ctx, instance, argument);
	}

	@Override
	default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
		
		
		return this.function().callLEA(ctx, instance, arguments);
	}

	@Override
	default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return this.function().callLE2(ctx, instance, argument1, argument2);
	}

	@Override
	default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
		
		
		return this.function().callLEX(ctx, instance, arguments);
	}

	@Override
	default BaseObject callNJ0(final BaseObject instance) {
		
		
		return this.function().callNJ0(instance);
	}

	@Override
	default BaseObject callNJ1(final BaseObject instance, final BaseObject argument) {
		
		
		return this.function().callNJ1(instance, argument);
	}

	@Override
	default BaseObject callNJA(final BaseObject instance, final BaseObject... arguments) {
		
		
		return this.function().callNJA(instance, arguments);
	}

	@Override
	default BaseObject callNJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return this.function().callNJ2(instance, argument1, argument2);
	}

	@Override
	default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {
		
		
		return this.function().callNE0(ctx, instance);
	}

	@Override
	default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
		
		
		return this.function().callNE1(ctx, instance, argument);
	}

	@Override
	default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
		
		
		return this.function().callNEA(ctx, instance, arguments);
	}

	@Override
	default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return this.function().callNE2(ctx, instance, argument1, argument2);
	}

	@Override
	default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
		
		
		return this.function().callNEX(ctx, instance, arguments);
	}

	@Override
	default String callSJ0(final BaseObject instance) {
		
		
		return this.function().callSJ0(instance);
	}

	@Override
	default String callSJ1(final BaseObject instance, final BaseObject argument) {
		
		
		return this.function().callSJ1(instance, argument);
	}

	@Override
	default String callSJA(final BaseObject instance, final BaseObject... arguments) {
		
		
		return this.function().callSJA(instance, arguments);
	}

	@Override
	default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return this.function().callSJ2(instance, argument1, argument2);
	}

	@Override
	default String callSE0(final ExecProcess ctx, final BaseObject instance) {
		
		
		return this.function().callSE0(ctx, instance);
	}

	@Override
	default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
		
		
		return this.function().callSE1(ctx, instance, argument);
	}

	@Override
	default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
		
		
		return this.function().callSEA(ctx, instance, arguments);
	}

	@Override
	default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		return this.function().callSE2(ctx, instance, argument1, argument2);
	}

	@Override
	default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
		
		
		return this.function().callSEX(ctx, instance, arguments);
	}

	@Override
	default void callVJ0(final BaseObject instance) {
		
		
		this.function().callVJ0(instance);
	}

	@Override
	default void callVJA(final BaseObject instance, final BaseObject... arguments) {
		
		
		this.function().callVJA(instance, arguments);
	}

	@Override
	default void callVJ1(final BaseObject instance, final BaseObject argument) {
		
		
		this.function().callVJ1(instance, argument);
	}

	@Override
	default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		this.function().callVJ2(instance, argument1, argument2);
		
	}

	@Override
	default void callVE0(final ExecProcess ctx, final BaseObject instance) {
		
		
		this.function().callVE0(ctx, instance);
		
	}

	@Override
	default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
		
		
		this.function().callVEA(ctx, instance, arguments);
	}

	@Override
	default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
		
		
		this.function().callVE1(ctx, instance, argument);
		
	}

	@Override
	default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		this.function().callVE2(ctx, instance, argument1, argument2);
		
	}

	@Override
	default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
		
		
		this.function().callVE1(ctx, instance, arguments);
		
	}

	@Override
	default int execArgumentsAcceptable() {
		
		
		return this.function().execArgumentsAcceptable();
	}

	@Override
	default int execArgumentsDeclared() {
		
		
		return this.function().execArgumentsDeclared();
	}

	@Override
	default int execArgumentsMinimal() {
		
		
		return this.function().execArgumentsMinimal();
	}

	@Override
	default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {
		
		
		return this.function().execCallPrepare(ctx, instance, store, inline);
	}

	@Override
	default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {
		
		
		return this.function().execCallPrepare(ctx, instance, store, inline, arguments);
	}

	@Override
	default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {
		
		
		return this.function().execCallPrepare(ctx, instance, store, inline, argument);
	}

	@Override
	default ExecStateCode execCallPrepare(final ExecProcess ctx,
			final BaseObject instance,
			final ResultHandler store,
			final boolean inline,
			final BaseObject argument1,
			final BaseObject argument2) {
		
		
		return this.function().execCallPrepare(ctx, instance, store, inline, argument1, argument2);
	}

	@Override
	default String[] execFormalParameters() {
		
		
		return this.function().execFormalParameters();
	}

	@Override
	default boolean execHasNamedArguments() {
		
		
		return this.function().execHasNamedArguments();
	}

	@Override
	default boolean execIsConstant() {
		
		
		return this.function().execIsConstant();
	}

	@Override
	default Class<? extends Object> execResultClassJava() {
		
		
		return this.function().execResultClassJava();
	}

	@Override
	default BaseObject execScope() {
		
		
		return this.function().execScope();
	}

	/**
	 *
	 * @return
	 */
	ExecCallable function();

}
