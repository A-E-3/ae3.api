package ru.myx.ae3.common;

import ru.myx.ae3.base.BasePrimitive;
import ru.myx.ae3.know.Guid;

/** @author myx
 *
 * @param <T> */
public interface KeyFactory<T> {

	/**
	 */
	public static final KeyFactory<String> FACTORY_STRING = new KeyFactoryString();

	/**
	 */
	public static final KeyFactory<Guid> FACTORY_GUID = new KeyFactoryGuid();

	/**
	 */
	public static final KeyFactory<BasePrimitive<?>> FACTORY_BASE = new KeyFactoryBase();

	/** @param key
	 * @return */
	public T keyJavaBoolean(final boolean key);

	/** @param key
	 * @return */
	public T keyJavaDouble(final double key);

	/** @param key
	 * @return */
	public T keyJavaFloat(final float key);

	/** @param key
	 * @return */
	public T keyJavaInt(final int key);

	/** @param key
	 * @return */
	public T keyJavaLong(final long key);

	/** @param key
	 * @return */
	public T keyJavaString(final String key);
}
