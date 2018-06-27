package ru.myx.ae3.exec;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseArray;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.base.BasePrimitive;
import ru.myx.ae3.base.BasePrimitiveString;
import ru.myx.ae3.base.BaseProperty;

final class ExecArgumentsLengthProperty implements BaseProperty {
	
	static final BaseProperty INSTANCE = new ExecArgumentsLengthProperty();

	private ExecArgumentsLengthProperty() {
		//
	}

	@Override
	public short propertyAttributes(final CharSequence name) {
		
		// assert BasePrimitiveString.PROPERTY_BASE_LENGTH.equals(name) :
		// "Only for 'length'!";
		return BaseProperty.ATTRS_MASK_NNN_IPN;
	}

	@Override
	public BaseObject propertyGet(final BaseObject instance, final BasePrimitiveString name) {
		
		return Base.forInteger(((BaseArray) instance).length());
	}

	@Override
	public BaseObject propertyGet(final BaseObject instance, final String name) {
		
		return Base.forInteger(((BaseArray) instance).length());
	}

	@Override
	public BaseObject propertyGetAndSet(final BaseObject instance, final String name, final BaseObject value) {
		
		return Base.forInteger(((BaseArray) instance).length());
	}

	@Override
	public ExecStateCode propertyGetCtxResult(final ExecProcess ctx, final BaseObject instance, final BasePrimitive<?> name, final ResultHandler store) {
		
		return store.execReturnNumeric(ctx, ((BaseArray) instance).length());
	}

}
