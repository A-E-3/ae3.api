package ru.myx.ae3.exec;

import ru.myx.ae3.base.BaseArray;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/**
 *
 * @author myx
 *
 */
@ReflectionDisable
public interface ExecCallableNotCallable extends ExecCallable {
	
	
	@Override
	@ReflectionHidden
	default int callIJ0(final BaseObject instance) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default int callIJ1(final BaseObject instance, final BaseObject argument) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}

	@Override
	default int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}

	@Override
	@ReflectionHidden
	default int callIE0(final ExecProcess ctx, final BaseObject instance) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}

	@Override
	default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}

	@Override
	default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default int callIEX(final ExecProcess context, final BaseObject instance, final BaseArray arguments) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default long callLJ0(final BaseObject instance) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default long callLJ1(final BaseObject instance, final BaseObject argument) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default long callLJA(final BaseObject instance, final BaseObject... arguments) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default long callLE0(final ExecProcess ctx, final BaseObject instance) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default long callLEX(final ExecProcess context, final BaseObject instance, final BaseArray arguments) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default BaseObject callNJ0(final BaseObject instance) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default BaseObject callNJ1(final BaseObject instance, final BaseObject argument) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default BaseObject callNJA(final BaseObject instance, final BaseObject... arguments) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default BaseObject callNJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default BaseObject callNEX(final ExecProcess context, final BaseObject instance, final BaseArray arguments) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default String callSJ0(final BaseObject instance) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default String callSE0(final ExecProcess ctx, final BaseObject instance) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default void callVJ0(final BaseObject instance) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default void callVJ1(final BaseObject instance, final BaseObject argument) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default void callVE0(final ExecProcess ctx, final BaseObject instance) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
		
		
		throw new IllegalAccessError(this + " is not a function!");
	}
	
	@Override
	default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {
		
		
		return ctx.vmRaise(this + " is not a function!");
	}
	
	@Override
	default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {
		
		
		return ctx.vmRaise(this + " is not a function!");
	}
	
	@Override
	default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {
		
		
		return ctx.vmRaise(this + " is not a function!");
	}
	
	@Override
	default ExecStateCode execCallPrepare(final ExecProcess ctx,
			final BaseObject instance,
			final ResultHandler store,
			final boolean inline,
			final BaseObject argument1,
			final BaseObject argument2) {
		
		
		return ctx.vmRaise(this + " is not a function!");
	}
	
}
