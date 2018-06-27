package ru.myx.ae3.base;

import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;

/**
 * 15.5.5.1 length
 *
 * The number of characters in the String value represented by this String
 * object.
 *
 * Once a String object is created, this property is unchanging. It has the
 * attributes { DontEnum, DontDelete, ReadOnly }.
 */
final class BasePropertyStringLength implements BaseProperty {
	
	@Override
	public short propertyAttributes(final CharSequence name) {
		
		return BaseProperty.ATTRS_MASK_NNN_IPN;
	}

	@Override
	public BaseObject propertyGet(final BaseObject instance, final BasePrimitiveString name) {
		
		assert instance != null : "NULL java value!";
		return PrimitiveStringLengthValue.getLengthValue(instance instanceof CharSequence
			? ((CharSequence) instance).length()
			: instance.baseToString().length());
	}

	@Override
	public BaseObject propertyGet(final BaseObject instance, final String name) {
		
		assert instance != null : "NULL java value!";
		return PrimitiveStringLengthValue.getLengthValue(instance instanceof CharSequence
			? ((CharSequence) instance).length()
			: instance.baseToString().length());
	}

	@Override
	public BaseObject propertyGetAndSet(final BaseObject instance, final String name, final BaseObject value) {
		
		assert instance != null : "NULL java value!";
		return PrimitiveStringLengthValue.getLengthValue(instance instanceof CharSequence
			? ((CharSequence) instance).length()
			: instance.baseToString().length());
	}

	@Override
	public ExecStateCode propertyGetCtxResult(final ExecProcess ctx, final BaseObject instance, final BasePrimitive<?> name, final ResultHandler store) {
		
		assert instance != null : "NULL java value!";
		return store.execReturn(ctx, PrimitiveStringLengthValue.getLengthValue(instance instanceof CharSequence
			? ((CharSequence) instance).length()
			: instance.baseToString().length()));
	}
}
