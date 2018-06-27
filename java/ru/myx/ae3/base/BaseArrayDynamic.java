package ru.myx.ae3.base;

import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/**
 * @author myx
 * 
 * @param <T>
 *            java array element type
 */
@ReflectionDisable
public interface BaseArrayDynamic<T extends Object> extends BaseArrayWritable<T>, BaseArrayAdvanced<T> {
	
	
	/**
	 * Supports numeric index. Makes 'push' when (index == length).
	 */
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
			if (index == length) {
				this.baseDefaultPush(value);
				return true;
			}
			this.baseSet(index, value);
			return true;
		}
		
		return this.baseDefine(name.stringValue(), value, BaseProperty.ATTRS_MASK_WED);
	}
	
	/**
	 * Supports numeric index. Makes 'push' when (index == length).
	 */
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
		
		this.baseDefine(name.baseToJavaString(), value, BaseProperty.ATTRS_MASK_WED);
		return store.execReturn(ctx, value);
	}
	
	@Override
	@ReflectionHidden
	default ExecStateCode vmPropertyDefine(final ExecProcess ctx, final int index, final BaseObject originalIfKnown, final BaseObject value, ResultHandler store) {
		
		
		assert value != null : "NULL java object!";
		
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
	
	/**
	 * It is already known to be an instance of ArrayDynamic!
	 * 
	 * @return this by default
	 */
	@Deprecated
	@Override
	@ReflectionHidden
	default BaseArrayDynamic<?> baseArrayDynamic() {
		
		
		return this;
	}
	
	/**
	 * @param value
	 * @return
	 */
	boolean add(T value);
	
	/**
	 * DEFAULT implementation, for scripts could be redefined.
	 * 
	 * @return
	 */
	@ReflectionHidden
	BaseObject baseDefaultPop();
	
	/**
	 * DEFAULT implementation, for scripts could be redefined.
	 * 
	 * @param value
	 * @return new length
	 */
	@ReflectionHidden
	int baseDefaultPush(BaseObject value);
	
	/**
	 * DEFAULT implementation, for scripts could be redefined.
	 * 
	 * @param index
	 * 
	 * @param value
	 * @return new length
	 */
	@ReflectionHidden
	int baseInsert(int index, BaseObject value);
	
	/**
	 * DEFAULT implementation, for scripts could be redefined.
	 * 
	 * @return
	 */
	@ReflectionHidden
	BaseObject baseDefaultShift();
	
	/**
	 * @param start
	 * @param count
	 * @param values
	 * @return
	 */
	@ReflectionHidden
	default BaseArray baseDefaultSplice(int start, int count, BaseObject[] values) {
		
		
		/**
		 * 3. Let lenVal be the result of calling the [[Get]] internal method of
		 * O with argument "length".<br>
		 * 4. Let len be ToUint32(lenVal).
		 */
		final int length = this.length();
		/**
		 * 5. Let relativeStart be ToInteger(start).<br>
		 * 6. If relativeStart is negative, let actualStart be max((len +
		 * relativeStart),0); else let actualStart be min(relativeStart, len).
		 */
		final int actualStart = start < 0
			? Math.max(length + start, 0)
			: Math.min(start, length);
		/**
		 * 7. Let actualDeleteCount be min(max(ToInteger(deleteCount),0), len –
		 * actualStart).
		 */
		final int deleteCount = Math.min(Math.max(count, 0), length - start);
		final BaseArray result = this.baseArraySlice(actualStart, deleteCount);
		final int insertCount = values.length;
		if (deleteCount > insertCount) {
			for (int i = deleteCount - insertCount; i > 0; --i) {
				this.baseRemove(start);
			}
			for (int i = 0; i < insertCount; ++i) {
				this.baseSet(start + i, values[i]);
			}
		} else //
		if (deleteCount < insertCount) {
			for (int i = 0; i < insertCount - deleteCount; ++i) {
				this.baseInsert(start + i, values[i]);
			}
			for (int i = deleteCount; i < insertCount; ++i) {
				this.baseSet(start + i, values[i]);
			}
		} else {
			for (int i = 0; i < insertCount; ++i) {
				this.baseSet(start + i, values[i]);
			}
		}
		return result;
	}
	
	/**
	 * DEFAULT implementation, for scripts could be redefined.
	 * 
	 * @param value
	 * @return new length
	 */
	@ReflectionHidden
	int baseDefaultUnshift(BaseObject value);
	
	/**
	 * DEFAULT implementation, for scripts could be redefined.
	 * 
	 * @param values
	 * @return new length
	 */
	@ReflectionHidden
	int baseDefaultUnshift(BaseObject[] values);
	
	/**
	 * @param index
	 * @return
	 */
	@ReflectionHidden
	BaseObject baseRemove(int index);
	
	/**
	 * @param value
	 * @return
	 */
	boolean contains(Object value);
	
	/**
	 * @param index
	 * @return
	 */
	T remove(int index);
}
