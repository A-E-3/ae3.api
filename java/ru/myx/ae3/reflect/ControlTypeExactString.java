/**
 *
 */
package ru.myx.ae3.reflect;

import ru.myx.ae3.Engine;
import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.base.BasePrimitiveString;
import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;

/**
 * @author myx
 *
 */
final class ControlTypeExactString implements ControlType<String, BasePrimitiveString> {
	
	public static final String toString(final Object any, final String defaultValue) {

		if (any == null) {
			return defaultValue;
		}
		final Class<?> cls = any.getClass();
		if (cls == String.class) {
			return (String) any;
		}
		if (cls == char[].class) {
			return new String((char[]) any);
		}
		if (cls == byte[].class) {
			return new String((byte[]) any, Engine.CHARSET_UTF8);
		}
		final String tmp = any.toString();
		return tmp == null
			? defaultValue
			: tmp;
	}
	
	@Override
	public final String convertAnyJavaToJava(final Object object) {

		return object instanceof String
			? (String) object
			: object instanceof CharSequence
				? object.toString()
				: object == BaseObject.NULL || object == BaseObject.UNDEFINED
					? null
					: ControlTypeExactString.toString(object, null);
	}
	
	@Override
	public final String convertAnyNativeToJava(final BaseObject object) {

		// assert object != null : "NULL java value!";

		/**
		 * ensureNative is not required!
		 */
		return object == BaseObject.NULL || object == BaseObject.UNDEFINED
			? null
			: object.baseToJavaString();
	}
	
	@Override
	public final BasePrimitiveString convertAnyNativeToNative(final BaseObject object) {

		// assert object != null : "NULL java value!";
		
		return object.baseToString();
	}
	
	@Override
	public BasePrimitiveString convertJavaToAnyNative(final String object) {

		/**
		 * '' for NULL TODO: shouldn't it be BaseObject.NULL?
		 */
		return Base.forString(object);
	}
	
	@Override
	public ExecStateCode convertJavaToCtxResult(final ExecProcess ctx, final String object, final ResultHandler store) {

		return object != null
			? store.execReturnString(ctx, object)
			: store.execReturnNull(ctx);
	}
	
	@Override
	public Class<String> getJavaClass() {

		return String.class;
	}
	
	@Override
	public final String getTypeName() {

		return "String";
	}
	
	@Override
	public boolean isAnyJavaToJavaPerfect(final Object object) {

		return object instanceof String;
	}
	
	@Override
	public boolean isAnyJavaToJavaPossible(final Object object) {

		return true;
	}
	
	@Override
	public boolean isAnyNativeToJavaPerfect(final BaseObject object) {

		assert object != null : "NULL java value!";

		// TODO: object instanceof BaseString - ain't it better and faster?

		return object.baseIsPrimitiveString();
	}
	
	@Override
	public boolean isAnyNativeToJavaPossible(final BaseObject object) {

		assert object != null : "NULL java value!";
		return true;
	}
	
}
