package ru.myx.ae3.exec;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.base.BasePrimitive;
import ru.myx.ae3.base.BasePrimitiveString;
import ru.myx.ae3.base.BaseProperty;

final class ExecProcessArgumentsProperty implements BaseProperty {
	
	static final BaseProperty INSTANCE = new ExecProcessArgumentsProperty();

	private ExecProcessArgumentsProperty() {
		//
	}

	@Override
	public short propertyAttributes(final CharSequence name) {
		
		// assert ExecProcess.PROPERTY_BASE_ARGUMENTS.equals(name) :
		// "Only for 'arguments'!";
		return BaseProperty.ATTRS_MASK_NNN_NPN;
	}

	@Override
	public BaseObject propertyGet(final BaseObject instance, final BasePrimitiveString name) {
		
		assert ExecProcess.PROPERTY_BASE_ARGUMENTS == name : "Only for 'arguments'!";
		return ((ExecProcess) instance).contextGetArguments();
	}

	@Override
	public BaseObject propertyGet(final BaseObject instance, final String name) {
		
		// assert name.length() == 9 && (name ==
		// ExecProcess.PROPERTY_STRING_ARGUMENTS || "arguments".equals( name ))
		// //
		// : "Only for 'arguments'!";
		return ((ExecProcess) instance).contextGetArguments();
	}

	@Override
	public BaseObject propertyGetAndSet(final BaseObject instance, final String name, final BaseObject value) {
		
		// assert name.length() == 9 && (name ==
		// ExecProcess.PROPERTY_STRING_ARGUMENTS || "arguments".equals( name ))
		// //
		// : "Only for 'arguments'!";
		return ((ExecProcess) instance).contextGetArguments();
	}

	@Override
	public ExecStateCode propertyGetCtxResult(final ExecProcess ctx, final BaseObject instance, final BasePrimitive<?> name, final ResultHandler store) {
		
		return store.execReturn(ctx, ((ExecProcess) instance).contextGetArguments());
	}

}
