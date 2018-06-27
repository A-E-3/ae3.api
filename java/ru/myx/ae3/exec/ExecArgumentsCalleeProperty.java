package ru.myx.ae3.exec;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.base.BasePrimitive;
import ru.myx.ae3.base.BasePrimitiveString;
import ru.myx.ae3.base.BaseProperty;

final class ExecArgumentsCalleeProperty implements BaseProperty {

	static final BaseProperty INSTANCE = new ExecArgumentsCalleeProperty();

	private ExecArgumentsCalleeProperty() {
		//
	}

	@Override
	public short propertyAttributes(final CharSequence name) {

		// assert BasePrimitiveString.PROPERTY_BASE_CALLEE.equals(name) :
		// "Only for 'callee'!";
		return BaseProperty.ATTRS_MASK_NNN_INN;
	}

	@Override
	public BaseObject propertyGet(final BaseObject instance, final BasePrimitiveString name) {

		throw new UnsupportedOperationException("'callee' property is obsolete and deprecated!");
		// return ((ExecArguments) instance).execCallee();
	}

	@Override
	public BaseObject propertyGet(final BaseObject instance, final String name) {

		throw new UnsupportedOperationException("'callee' property is obsolete and deprecated!");
		// return ((ExecArguments) instance).execCallee();
	}

	@Override
	public BaseObject propertyGetAndSet(final BaseObject instance, final String name, final BaseObject value) {

		throw new UnsupportedOperationException("'callee' property is obsolete and deprecated!");
		// return ((ExecArguments) instance).execCallee();
	}

	@Override
	public ExecStateCode propertyGetCtxResult(final ExecProcess ctx, final BaseObject instance, final BasePrimitive<?> name, final ResultHandler store) {

		throw new UnsupportedOperationException("'callee' property is obsolete and deprecated!");
		// return store.execReturn(ctx, ((ExecArguments) instance).execCallee());
	}

}
