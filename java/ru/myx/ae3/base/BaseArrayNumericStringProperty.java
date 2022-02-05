package ru.myx.ae3.base;

import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;

class BaseArrayNumericStringProperty implements BaseProperty {
	
	public final static BaseProperty INSTANCE = new BaseArrayNumericStringProperty();
	
	private BaseArrayNumericStringProperty() {
		
		//
	}
	
	@Override
	public short propertyAttributes(final CharSequence name) {
		
		return BaseProperty.ATTRS_MASK_WND;
	}
	
	@Override
	public BaseObject propertyGet(final BaseObject instance, final BasePrimitiveString name) {
		
		final BaseArray array = instance.baseArray();
		if (array == null) {
			throw new IllegalArgumentException("Array is expected!");
		}
		return array.baseGet(name.baseToJavaInteger(), BaseObject.UNDEFINED);
	}
	
	@Override
	public BaseObject propertyGet(final BaseObject instance, final String name) {
		
		final BaseArray array = instance.baseArray();
		if (array == null) {
			throw new IllegalArgumentException("Array is expected!");
		}
		return array.baseGet(Base.forString(name).baseToJavaInteger(), BaseObject.UNDEFINED);
	}
	
	@Override
	public BaseObject propertyGetAndSet(final BaseObject instance, final String name, final BaseObject value) {
		
		final BaseArray array = instance.baseArray();
		if (array == null) {
			throw new IllegalArgumentException("Array is expected!");
		}
		@SuppressWarnings("unchecked")
		final BaseArrayWritable<Object> writable = (BaseArrayWritable<Object>) array.baseArrayWritable();
		
		final int index = Base.forString(name).baseToJavaInteger();
		try {
			return array.baseGet(index, BaseObject.UNDEFINED);
		} finally {
			if (writable != null) {
				writable.baseSet(index, value);
			}
		}
	}
	
	@Override
	public ExecStateCode propertyGetCtxResult(final ExecProcess ctx, final BaseObject instance, final BasePrimitive<?> name, final ResultHandler store) {
		
		final BaseArray array = instance.baseArray();
		return array == null
			? ctx.vmRaise("Array is expected!")
			: array.vmPropertyRead(ctx, name.baseToJavaInteger(), name, BaseObject.UNDEFINED, store);
	}
	
	@Override
	public boolean propertySet(final BaseObject instance, final CharSequence name, final BaseObject value, final short attributes) {
		
		final BaseArray array = instance.baseArray();
		if (array == null) {
			throw new IllegalArgumentException("Array is expected!");
		}
		@SuppressWarnings("unchecked")
		final BaseArrayWritable<Object> writableArray = (BaseArrayWritable<Object>) array.baseArrayWritable();
		
		final int index = name instanceof BasePrimitiveString
			? ((BasePrimitiveString) name).intValue()
			: Base.toInt32(name.toString());
		if (writableArray != null) {
			writableArray.baseSet(index, value);
			return true;
		}
		return false;
	}
	//
}
