package ru.myx.ae3.base;

import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/**
 * Objects which are BaseObject just for class compatibility, not designed for
 * handling in general BaseObject way
 *
 * @author myx
 *
 */
@ReflectionDisable
public interface BaseObjectNominal extends BaseObjectNoOwnProperties {

	@Override
	@ReflectionHidden
	default String baseClass() {

		return this.getClass().getSimpleName();
	}

	@Override
	default BaseProperty baseFindProperty(final BasePrimitiveString name) {

		return null;
	}

	@Override
	default BaseProperty baseFindProperty(final BasePrimitive<?> name) {

		return null;
	}

	@Override
	default BaseProperty baseFindProperty(final BasePrimitiveString name, final BaseObject stop) {

		return null;
	}

	@Override
	default BaseProperty baseFindProperty(final CharSequence name) {

		return null;
	}

	@Override
	default BaseProperty baseFindProperty(final String name) {

		return null;
	}

	@Override
	default BaseProperty baseFindProperty(final String name, final BaseObject stop) {

		return null;
	}

	@Override
	default BaseObject baseGet(final BaseObject name, final BaseObject defaultValue) {

		return defaultValue;
	}

	@Override
	default BaseObject baseGet(final BasePrimitive<?> name, final BaseObject defaultValue) {

		return defaultValue;
	}

	@Override
	@ReflectionHidden
	default BaseObject baseGet(final BasePrimitiveString name, final BaseObject defaultValue) {

		return defaultValue;
	}

	@Override
	default BaseObject baseGet(final CharSequence name, final BaseObject defaultValue) {

		return defaultValue;
	}

	@Override
	@ReflectionHidden
	default BaseObject baseGet(final String name, final BaseObject defaultValue) {

		return defaultValue;
	}

	@Override
	@ReflectionHidden
	default BaseObject basePrototype() {

		return null;
	}

	@Override
	@ReflectionHidden
	default BasePrimitiveNumber baseToNumber() {

		return BasePrimitiveNumber.NAN;
	}

	@Override
	@ReflectionHidden
	default BasePrimitiveString baseToString() {

		return Base.forString(this.toString());
	}

	@Override
	@ReflectionHidden
	default Object baseValue() {

		return this;
	}

	@Override
	default ExecStateCode vmPropertyRead(final ExecProcess ctx, final BaseObject name, final BaseObject defaultValue, final ResultHandler store) {

		return store.execReturn(ctx, defaultValue);
	}

	@Override
	default ExecStateCode vmPropertyRead(final ExecProcess ctx, final BasePrimitive<?> name, final BaseObject defaultValue, final ResultHandler store) {

		return store.execReturn(ctx, defaultValue);
	}

	@Override
	@ReflectionHidden
	default ExecStateCode vmPropertyRead(final ExecProcess ctx, final BasePrimitiveString name, final BaseObject defaultValue, final ResultHandler store) {

		return store.execReturn(ctx, defaultValue);
	}

	@Override
	default ExecStateCode vmPropertyRead(final ExecProcess ctx,
			final CharSequence name,
			final BaseObject originalIfKnown,
			final BaseObject defaultValue,
			final ResultHandler store) {

		return store.execReturn(ctx, defaultValue);
	}

	@Override
	default ExecStateCode vmPropertyRead(final ExecProcess ctx, final int index, final BaseObject originalIfKnown, final BaseObject defaultValue, final ResultHandler store) {

		return store.execReturn(ctx, defaultValue);
	}

	@Override
	default ExecStateCode vmPropertyRead(final ExecProcess ctx, final String name, final BaseObject defaultValue, final ResultHandler store) {

		return store.execReturn(ctx, defaultValue);
	}

}
