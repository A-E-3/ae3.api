package ru.myx.ae3.common;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.base.BasePrimitive;
import ru.myx.ae3.base.BasePrimitiveBoolean;
import ru.myx.ae3.base.BasePrimitiveNumber;
import ru.myx.ae3.base.BasePrimitiveString;

final class KeyFactoryBase implements KeyFactory<BasePrimitive<?>> {

	/** @param key
	 * @return */
	@Override
	public final BasePrimitiveBoolean keyJavaBoolean(final boolean key) {
		
		return key
			? BaseObject.TRUE
			: BaseObject.FALSE;
	}

	/** @param key
	 * @return */
	@Override
	public final BasePrimitiveNumber keyJavaDouble(final double key) {
		
		return Base.forDouble(key);
	}

	/** @param key
	 * @return */
	@Override
	public final BasePrimitiveNumber keyJavaFloat(final float key) {
		
		return Base.forDouble(key);
	}

	/** @param key
	 * @return */
	@Override
	public final BasePrimitiveNumber keyJavaInt(final int key) {
		
		return Base.forInteger(key);
	}

	/** @param key
	 * @return */
	@Override
	public final BasePrimitiveNumber keyJavaLong(final long key) {
		
		return Base.forLong(key);
	}

	/** @param key
	 * @return */
	@Override
	public final BasePrimitiveString keyJavaString(final String key) {
		
		return Base.forString(key);
	}
}
