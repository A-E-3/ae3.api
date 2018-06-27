/**
 *
 */
package ru.myx.ae3.reflect;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;

/**
 * @author myx
 *
 */
final class ControlTypeInexactBaseObject implements ControlType<BaseObject, BaseObject> {
	
	@Override
	public BaseObject convertAnyJavaToJava(final Object object) {
		
		throw new UnsupportedOperationException();
	}
	
	@Override
	public final BaseObject convertAnyNativeToJava(final BaseObject object) {
		
		throw new UnsupportedOperationException();
	}
	
	@Override
	public final BaseObject convertAnyNativeToNative(final BaseObject object) {
		
		throw new UnsupportedOperationException();
	}
	
	@Override
	public BaseObject convertJavaToAnyNative(final BaseObject object) {
		
		return object == null
			? BaseObject.NULL
			: object;
	}
	
	@Override
	public ExecStateCode convertJavaToCtxResult(final ExecProcess ctx, final BaseObject object, final ResultHandler store) {
		
		return store.execReturn(ctx, object == null
			? BaseObject.NULL
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
		
		return "BaseObject+";
	}
	
	@Override
	public boolean isAnyJavaToJavaPerfect(final Object object) {
		
		return false;
	}
	
	@Override
	public boolean isAnyJavaToJavaPossible(final Object object) {
		
		return false;
	}
	
	@Override
	public boolean isAnyNativeToJavaPerfect(final BaseObject object) {
		
		return false;
	}
	
	@Override
	public boolean isAnyNativeToJavaPossible(final BaseObject object) {
		
		return false;
	}
}
