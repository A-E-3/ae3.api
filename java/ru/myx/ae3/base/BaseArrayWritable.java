package ru.myx.ae3.base;

import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/** @author myx
 *
 * @param <T>
 *            java array element type */
@ReflectionDisable
public interface BaseArrayWritable<T extends Object> extends BaseArray {
	
	/** It is already known to be an instance of ArrayWritable!
	 *
	 * @return this by default */
	@Deprecated
	@Override
	@ReflectionHidden
	default BaseArrayWritable<? extends T> baseArrayWritable() {
		
		return this;
	}

	/** DEFAULT implementation, for scripts could be redefined.
	 *
	 * https://developer.mozilla.org/en/JavaScript/Reference/Global_Objects/ Array/reverse
	 *
	 * @return array (SAME array) */
	@ReflectionHidden
	BaseArrayWritable<T> baseDefaultReverse();

	/** Supports numeric index */
	@Override
	@ReflectionHidden
	default boolean baseDefine(final BasePrimitive<?> name, final BaseObject value) {
		
		assert value != null : "NULL java object!";

		if (name instanceof BasePrimitiveString) {
			return this.baseDefine((BasePrimitiveString) name, value, BaseProperty.ATTRS_MASK_WED);
		}

		if (name.baseIsPrimitiveInteger()) {
			final int index = name.intValue();
			final int length = this.length();
			if (index >= 0 && index < length) {
				this.baseSet(index, value);
				return true;
			}
			return false;
		}

		return this.baseDefine(name.stringValue(), value, BaseProperty.ATTRS_MASK_WED);
	}

	@Override
	@ReflectionHidden
	default boolean baseDelete(final BaseObject propertyName) {
		
		if (propertyName.baseIsPrimitiveInteger()) {
			this.set(propertyName.baseToJavaInteger(), null);
			return true;
		}

		return this.baseDelete(propertyName.baseToJavaString());
	}

	/** @param index
	 * @param value
	 * @return */
	boolean baseSet(int index, BaseObject value);

	/** For compatibility with java list - have to unwrap objects here cause otherwise there is no
	 * way to provide customers with proper types.
	 *
	 * @param i
	 * @return object */
	@Override
	T get(int i);

	/** @param index
	 * @param value
	 * @return */
	T set(int index, T value);

	/** Supports numeric index */
	@Override
	@ReflectionHidden
	default ExecStateCode vmPropertyDefine(final ExecProcess ctx, final BaseObject name, final BaseObject value, final ResultHandler store) {
		
		assert value != null : "NULL java object!";

		if (name instanceof BasePrimitiveString) {
			this.baseDefine((BasePrimitiveString) name, value, BaseProperty.ATTRS_MASK_WED);
			return store.execReturn(ctx, value);
		}

		if (name.baseIsPrimitiveInteger()) {
			final int index = name.baseToJavaInteger();
			final int length = this.length();
			if (index >= 0 && index < length) {
				this.baseSet(index, value);
				return store.execReturn(ctx, value);
			}
			// Should it throw?!
			return ctx.vmRaise("Index out of bounds, index=" + index + ", length=" + length);
		}

		this.baseDefine(name.baseToJavaString(), value, BaseProperty.ATTRS_MASK_WED);
		return store.execReturn(ctx, value);
	}

	@Override
	@ReflectionHidden
	default ExecStateCode vmPropertyDefine(final ExecProcess ctx, final int index, final BaseObject originalIfKnown, final BaseObject value, final ResultHandler store) {
		
		assert value != null : "NULL java object!";

		final int length = this.length();
		if (index >= 0 && index < length) {
			this.baseSet(index, value);
			return store.execReturn(ctx, value);
		}
		// Should it throw?!
		return ctx.vmRaise("Index out of bounds, index=" + index + ", length=" + length);
	}
}
