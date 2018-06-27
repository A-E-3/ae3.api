package ru.myx.ae3.base;

import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;
import ru.myx.ae3.reflect.ReflectionHidden;
import ru.myx.ae3.reflect.ReflectionIgnore;

/**
 *
 * @author myx
 * @param <T>
 */
@ReflectionIgnore
public interface BaseListNoOwnProperties<T> extends BaseList<T>, BaseObjectNoOwnProperties {
	
	
	/**
	 * Supports numeric index. Makes 'push' when (index == length). Ignored
	 * non-numeric names.
	 */
	@Override
	@ReflectionHidden
	default ExecStateCode vmPropertyDefine(final ExecProcess ctx, final BaseObject name, final BaseObject value, final ResultHandler store) {
		
		
		assert value != null : "NULL java object!";

		if (name instanceof BasePrimitiveString) {
			return store.execReturn(ctx, value);
		}

		if (name.baseIsPrimitiveInteger()) {
			final int index = name.baseToJavaInteger();
			final int length = this.length();
			if (index == length) {
				this.baseDefaultPush(value);
				return store.execReturn(ctx, value);
			}
			if (index >= 0 && index < length + 65536) {
				this.baseSet(index, value);
				return store.execReturn(ctx, value);
			}
			// Should it throw?!
			return ctx.vmRaise("Index out of bounds, index=" + index + ", length=" + length);
		}

		return store.execReturn(ctx, value);
	}

	@Override
	default boolean baseDefine(final BasePrimitive<?> name, final BaseObject value) {
		
		
		assert value != null : "NULL java object!";

		if (name instanceof BasePrimitiveString) {
			return false;
		}

		if (name.baseIsPrimitiveInteger()) {
			final int index = name.intValue();
			final int length = this.length();
			if (index == length) {
				this.baseDefaultPush(value);
				return true;
			}
			this.baseSet(index, value);
			return true;
		}

		return false;
	}
	
}
