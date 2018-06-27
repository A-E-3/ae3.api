package ru.myx.ae3.common;

import ru.myx.ae3.know.Guid;

final class KeyFactoryGuid implements KeyFactory<Guid> {

	/** @param key
	 * @return */
	@Override
	public final Guid keyJavaBoolean(final boolean key) {
		
		return key
			? Guid.GUID_BOOLEAN_TRUE
			: Guid.GUID_BOOLEAN_FALSE;
	}

	/** @param key
	 * @return */
	@Override
	public final Guid keyJavaDouble(final double key) {
		
		return Guid.forJavaDouble(key);
	}

	/** @param key
	 * @return */
	@Override
	public final Guid keyJavaFloat(final float key) {
		
		return Guid.forJavaDouble(key);
	}

	/** @param key
	 * @return */
	@Override
	public final Guid keyJavaInt(final int key) {
		
		return Guid.forJavaInteger(key);
	}

	/** @param key
	 * @return */
	@Override
	public final Guid keyJavaLong(final long key) {
		
		return Guid.forJavaLong(key);
	}

	/** @param key
	 * @return */
	@Override
	public final Guid keyJavaString(final String key) {
		
		return Guid.forString(key);
	}
}
