package ru.myx.ae3.base;

import java.util.Iterator;
import java.util.RandomAccess;

import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/** @author myx */
@ReflectionDisable
public interface BaseArray extends BaseObject {
	
	/**
	 *
	 */
	// public static BaseObject PROTOTYPE = new
	// BaseNativeArray( true );
	@ReflectionHidden
	BaseObject PROTOTYPE = BaseObject.createObject(BaseObject.PROTOTYPE);

	/** arr[0] == arr['0'], etc */
	@ReflectionHidden
	BaseProperty BASE_ARRAY_NUMERIC_STRING_ACCESS = BaseArrayNumericStringProperty.INSTANCE;

	/** constant, read only */
	@ReflectionHidden
	SealedEmptyArray SEALED_EMPTY_ARRAY = SealedEmptyArray.INSTANCE;

	/**
	 *
	 */
	@SuppressWarnings("unchecked")
	@ReflectionHidden
	Iterator<BaseObject> ITERATOR_EMPTY = (Iterator<BaseObject>) (Iterator<?>) BaseObject.ITERATOR_EMPTY;

	/** @param end
	 * @param length
	 * @return */
	static int genericDefaultSliceGetEndIndex(final int end, final int length) {
		
		return end >= 0
			? end > length
				? length
				: end
			: Math.max(length + end, 0);
	}

	/** @param start
	 * @param length
	 * @return */
	static int genericDefaultSliceGetStartIndex(final int start, final int length) {
		
		return start >= 0
			? start > length
				? length
				: start
			: Math.max(length + start, 0);
	}

	/** It is already known to be an instance of Array!
	 *
	 * @return this by default */
	@Deprecated
	@Override
	@ReflectionHidden
	default BaseArray baseArray() {
		
		return this;
	}

	/** NULL or ADVANCED
	 *
	 * @return NULL by default */
	@ReflectionHidden
	default BaseArrayAdvanced<?> baseArrayAdvanced() {
		
		return null;
	}

	/** NULL or DYNAMIC
	 *
	 * @return null by default */
	@ReflectionHidden
	default BaseArrayDynamic<?> baseArrayDynamic() {
		
		return null;
	}

	/** Returns a shallow (one-level) deep copy of a portion of an array.
	 *
	 * @param start
	 * @return */
	@ReflectionHidden
	default BaseArrayAdvanced<?> baseArraySlice() {
		
		return this.baseArraySlice(0, 0);
	}

	/** Returns a shallow (one-level) deep copy of a portion of an array.
	 *
	 * @param start
	 * @return */
	@ReflectionHidden
	default BaseArrayAdvanced<?> baseArraySlice(final int start) {
		
		return this.baseArraySlice(start, this.length());
	}

	/** Returns a shallow (one-level) deep copy of a portion of an array.
	 *
	 * @param start
	 * @param end
	 * @return */
	@ReflectionHidden
	default BaseArrayAdvanced<?> baseArraySlice(final int start, final int end) {
		
		final int length = this.length();
		final int startIdx = start >= 0
			? start > length
				? length
				: start
			: Math.max(length + start, 0);
		final int endIdx = end > 0
			? end > length
				? length
				: end
			: Math.max(length + end, 0);
		final BaseList<Object> result = BaseObject.createArray(endIdx - startIdx);
		for (int i = startIdx; i < endIdx; ++i) {
			result.baseDefaultPush(this.baseGet(i, BaseObject.UNDEFINED));
		}
		return result;
	}

	/** NULL or WRITABLE
	 *
	 * @return NULL by default */
	@ReflectionHidden
	default BaseArrayWritable<?> baseArrayWritable() {
		
		return null;
	}

	/** @param value
	 * @return */
	default boolean baseContains(final BaseObject value) {
		
		final int length = this.length();
		if (length < 100) {
			/** double scan for equals */
			for (int i = 0; i < length; ++i) {
				final BaseObject object = this.baseGet(i, BaseObject.UNDEFINED);
				if (object == value) {
					return true;
				}
			}
		}
		for (int i = 0; i < length; ++i) {
			final BaseObject object = this.baseGet(i, BaseObject.UNDEFINED);
			if (object == value || object.equals(value)) {
				return true;
			}
		}
		return false;
	}

	@Override
	@ReflectionHidden
	default boolean baseDelete(final BaseObject propertyName) {
		
		if (propertyName.baseIsPrimitiveInteger()) {
			final BaseArrayWritable<?> writable = this.baseArrayWritable();
			if (writable != null) {
				writable.set(propertyName.baseToJavaInteger(), null);
				return true;
			}
			return false;
		}

		return this.baseDelete(propertyName.baseToJavaString());
	}

	/** Not generic - cause have to return BaseObject.UNDEFINED instead of null's and so on.
	 *
	 * @param index
	 * @param defaultValue
	 * @return */
	@ReflectionHidden
	BaseObject baseGet(int index, BaseObject defaultValue);

	/** Not generic - cause have to return BaseObject.UNDEFINED instead of null's and so on.
	 *
	 * @param defaultValue
	 * @return */
	@ReflectionHidden
	default BaseObject baseGetFirst(final BaseObject defaultValue) {
		
		final int length = this.length();
		if (length == 0) {
			return defaultValue;
		}

		return this.baseGet(0, defaultValue);
	}

	/** Not generic - cause have to return BaseObject.UNDEFINED instead of null's and so on.
	 *
	 * @param defaultValue
	 * @return */
	@ReflectionHidden
	default BaseObject baseGetLast(final BaseObject defaultValue) {
		
		final int length = this.length();
		if (length == 0) {
			return defaultValue;
		}

		return this.baseGet(length - 1, defaultValue);
	}

	/** @return */
	@ReflectionHidden
	default Iterator<? extends BaseObject> baseIterator() {
		
		return new IteratorBaseArrayValue(this);
	}

	@Override
	@ReflectionHidden
	default BaseObject basePrototype() {
		
		return BaseArray.PROTOTYPE;
	}

	/** For compatibility with java list - have to unwrap objects here cause otherwise there is no
	 * way to provide customers with proper types.
	 *
	 * @param i
	 * @return object */
	@ReflectionHidden
	Object get(int i);

	/** Must be equivalent to this.length() == 0, but implementation has a chance to be faster.
	 *
	 * @return */
	@ReflectionHidden
	default boolean isEmpty() {
		
		return this.length() == 0;
	}

	/** @return */
	default Iterator<?> iterator() {
		
		return new IteratorBaseArrayValueJava<>(this);
	}

	/** @return */
	@ReflectionHidden
	int length();

	/** In contrast to java Collection, this method is OK to return inner array when possible, so it
	 * is unknown whether the changes to array returned will be reflected in the original BaseArray
	 * or even in other instances of BaseArray.
	 *
	 * @return */
	default BaseObject[] toArrayBase() {
		
		final int length = this.length();
		if (length == 0) {
			return Base.ZERO_BASE_OBJECT_ARRAY;
		}

		final BaseObject[] result = new BaseObject[length];
		if (length < 4 || this instanceof RandomAccess) {
			for (int i = 0; i < length; ++i) {
				result[i] = this.baseGet(i, BaseObject.UNDEFINED);
			}
			return result;
		}

		{
			final Iterator<? extends BaseObject> iter = this.baseIterator();
			int index = 0;
			for (; index < length && iter.hasNext(); ++index) {
				result[index] = iter.next();
			}
			return result;
		}
	}

	/** Not generic - cause have to return BaseObject.UNDEFINED instead of null's and so on. */
	@Override
	@ReflectionHidden
	default ExecStateCode vmPropertyRead(final ExecProcess ctx, final int index, final BaseObject originalIfKnown, final BaseObject defaultValue, final ResultHandler store) {
		
		return store.execReturn(ctx, this.baseGet(index, defaultValue));
	}
}
