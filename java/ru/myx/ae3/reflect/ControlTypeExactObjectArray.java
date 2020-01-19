/**
 *
 */
package ru.myx.ae3.reflect;

import java.util.Collection;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseArray;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.common.Value;
import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;

/** @author myx */
final class ControlTypeExactObjectArray implements ControlType<Object[], BaseObject> {
	
	@Override
	public final Object[] convertAnyJavaToJava(final Object object) {
		
		if (object == null) {
			return null;
		}
		if (object instanceof Object[]) {
			return (Object[]) object;
		}
		if (object instanceof Collection<?>) {
			return ((Collection<?>) object).toArray();
		}
		if (object instanceof CharSequence) {
			return null;
		}
		if (object instanceof BaseObject) {
			final BaseArray array = ((BaseObject) object).baseArray();
			if (array != null) {
				final Object[] result = new Object[array.length()];
				for (int i = 0; i < result.length; ++i) {
					result[i] = array.get(i);
				}
				return result;
			}
		}
		if (object instanceof Value<?>) {
			final Object baseValue = ((Value<?>) object).baseValue();
			return baseValue == object
				? null
				: this.convertAnyJavaToJava(baseValue);
		}
		assert false : "cannot convert from: " + object.getClass().getName() + " to Object[]";
		return null;
	}

	@Override
	public final Object[] convertAnyNativeToJava(final BaseObject object) {
		
		assert object != null : "NULL java value!";
		/** ensureNative is not required: new array created */
		if (object instanceof CharSequence) {
			return null;
		}
		final BaseArray array = object.baseArray();
		if (array != null) {
			final Object[] result = new Object[array.length()];
			for (int i = 0; i < result.length; ++i) {
				result[i] = array.get(i);
			}
			return result;
		}
		{
			final Object baseValue = ((Value<?>) object).baseValue();
			return baseValue == object
				? null
				: this.convertAnyJavaToJava(baseValue);
		}
	}

	@Override
	public final BaseObject convertAnyNativeToNative(final BaseObject object) {
		
		assert object != null : "NULL java value!";
		return object;
	}

	@Override
	public BaseObject convertJavaToAnyNative(final Object[] object) {
		
		return object != null
			? Base.forArray(object)
			: BaseObject.NULL;
	}

	@Override
	public ExecStateCode convertJavaToCtxResult(final ExecProcess ctx, final Object[] object, final ResultHandler store) {
		
		return store.execReturn(
				ctx,
				object != null
					? Base.forArray(object)
					: BaseObject.NULL);
	}

	@Override
	public Class<Object[]> getJavaClass() {
		
		return Object[].class;
	}

	@Override
	public final String getTypeName() {
		
		return "Object[]";
	}

	@Override
	public boolean isAnyJavaToJavaPerfect(final Object object) {
		
		if (object instanceof Object[]) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isAnyJavaToJavaPossible(final Object object) {
		
		if (object instanceof Collection<?>) {
			return true;
		}
		if (object instanceof Value<?>) {
			final Object value = ((Value<?>) object).baseValue();
			if (value != null && value != object && this.isAnyJavaToJavaPossible(value)) {
				return true;
			}
		}
		if (object instanceof CharSequence) {
			return false;
		}
		if (object instanceof BaseObject && ((BaseObject) object).baseArray() != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isAnyNativeToJavaPerfect(final BaseObject object) {
		
		assert object != null : "NULL java value!";
		// nothing is perfect for this class
		return false;
	}

	@Override
	public boolean isAnyNativeToJavaPossible(final BaseObject object) {
		
		assert object != null : "NULL java value!";
		if (object.baseArray() != null) {
			if (object instanceof CharSequence) {
				return false;
			}
			return true;
		}
		{
			final Object value = object.baseValue();
			if (value != null && value != object) {
				return this.isAnyJavaToJavaPossible(object);
			}
		}
		return false;
	}

}
