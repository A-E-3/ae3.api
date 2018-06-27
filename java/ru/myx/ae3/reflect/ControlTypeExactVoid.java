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
final class ControlTypeExactVoid implements ControlType<Void, BaseObject> {
	
	
	@Override
	public final Void convertAnyJavaToJava(final Object object) {
		
		
		return null;
	}
	
	@Override
	public final Void convertAnyNativeToJava(final BaseObject object) {
		
		
		assert object != null : "NULL java value!";
		/**
		 * ensureNative is not required (obviously)
		 */
		return null;
	}
	
	@Override
	public final BaseObject convertAnyNativeToNative(final BaseObject object) {
		
		
		assert object != null : "NULL java value!";
		return BaseObject.UNDEFINED;
	}
	
	@Override
	public BaseObject convertJavaToAnyNative(final Void object) {
		
		
		return BaseObject.UNDEFINED;
	}
	
	@Override
	public ExecStateCode convertJavaToCtxResult(final ExecProcess ctx, final Void object, final ResultHandler store) {
		
		
		return store.execReturnUndefined(ctx);
	}
	
	@Override
	public Class<Void> getJavaClass() {
		
		
		return Void.class;
	}
	
	@Override
	public final String getTypeName() {
		
		
		return "Void";
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
		return object.baseValue() instanceof Void;
	}
	
	@Override
	public boolean isAnyNativeToJavaPossible(final BaseObject object) {
		
		
		assert object != null : "NULL java value!";
		return true;
	}
	
}
