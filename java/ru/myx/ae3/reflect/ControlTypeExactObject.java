/**
 *
 */
package ru.myx.ae3.reflect;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.common.Value;
import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;

/**
 * @author myx
 *
 */
final class ControlTypeExactObject implements ControlType<Object, BaseObject> {
	
	
	@Override
	public final Object convertAnyJavaToJava(final Object object) {
		
		
		if (object instanceof Value<?>) {
			return ((Value<?>) object).baseValue();
		}
		return object;
	}

	@Override
	public final Object convertAnyNativeToJava(final BaseObject object) {
		
		
		// assert object != null : "NULL java value!";

		/**
		 * ensureNative is not required!
		 */
		return object.baseValue();
	}

	@Override
	public final BaseObject convertAnyNativeToNative(final BaseObject object) {
		
		
		assert object != null : "NULL java value!";

		return object;
	}

	@Override
	public BaseObject convertJavaToAnyNative(final Object object) {
		
		
		return Base.forUnknown(object);
	}

	@Override
	public ExecStateCode convertJavaToCtxResult(final ExecProcess ctx, final Object object, final ResultHandler store) {
		
		
		/**
		 * Classify here cause it potentially saves an instantiation of
		 * BasePrimitive objects
		 */
		if (object == null) {
			return store.execReturnUndefined(ctx);
		}
		if (object instanceof BaseObject) {
			return store.execReturn(ctx, (BaseObject) object);
		}
		if (object instanceof String) {
			return store.execReturnString(ctx, (String) object);
		}
		if (object instanceof Number) {
			if (object instanceof Integer) {
				return store.execReturnNumeric(ctx, ((Integer) object).intValue());
			}
			if (object instanceof Long) {
				return store.execReturnNumeric(ctx, ((Long) object).longValue());
			}
			if (object instanceof Double) {
				return store.execReturnNumeric(ctx, ((Double) object).doubleValue());
			}
			if (object instanceof Float) {
				return store.execReturnNumeric(ctx, ((Double) object).doubleValue());
			}
			return store.execReturn(ctx, Base.forNumber((Number) object));
		}
		return store.execReturnObject(ctx, object);
	}

	@Override
	public Class<Object> getJavaClass() {
		
		
		return Object.class;
	}

	@Override
	public final String getTypeName() {
		
		
		return "Object";
	}

	@Override
	public boolean isAnyJavaToJavaPerfect(final Object object) {
		
		
		return true;
	}

	@Override
	public boolean isAnyJavaToJavaPossible(final Object object) {
		
		
		return true;
	}

	@Override
	public boolean isAnyNativeToJavaPerfect(final BaseObject object) {
		
		
		assert object != null : "NULL java value!";
		return true;
	}

	@Override
	public boolean isAnyNativeToJavaPossible(final BaseObject object) {
		
		
		assert object != null : "NULL java value!";
		return true;
	}

}
