/**
 * 
 */
package ru.myx.ae3.reflect;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;

/**
 * @author myx
 * 
 */
final class ControlTypeExactBaseObjectUnsafe implements ControlType<BaseObject, BaseObject> {
	
	@Override
	public BaseObject convertAnyJavaToJava(final Object object) {
		
		return Base.forUnknown(object);
	}
	
	@Override
	public final BaseObject convertAnyNativeToJava(final BaseObject object) {
		
		assert object != null : "NULL java value!";
		/**
		 * ensureNative is not required! (unsafe)
		 */
		return object;
	}
	
	@Override
	public final BaseObject convertAnyNativeToNative(final BaseObject object) {
		
		assert object != null : "NULL java value!";
		return object;
	}
	
	@Override
	public BaseObject convertJavaToAnyNative(final BaseObject object) {
		
		return object == null
			? BaseObject.UNDEFINED
			: object;
	}
	
	@Override
	public ExecStateCode convertJavaToCtxResult(final ExecProcess ctx, final BaseObject object, final ResultHandler store) {
		
		return store.execReturn(ctx, object == null
			? BaseObject.UNDEFINED
			: object);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Class<BaseObject> getJavaClass() {
		
		final Class<?> cls = BaseObject.class;
		return (Class<BaseObject>) cls;
	}
	
	@Override
	public final String getTypeName() {
		
		return "BaseObject";
	}
	
	@Override
	public boolean isAnyJavaToJavaPerfect(final Object object) {
		
		return object instanceof BaseObject;
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
