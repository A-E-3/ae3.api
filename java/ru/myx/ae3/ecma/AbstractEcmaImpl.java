package ru.myx.ae3.ecma;

import ru.myx.ae3.base.BaseObject;

abstract class AbstractEcmaImpl {
	/**
	 * 
	 * @param global
	 */
	public abstract void setupGlobalObject(BaseObject global);
	
	/**
	 * Readable source
	 * 
	 * @param builder
	 * @param o
	 * @param ident
	 * @param limit
	 *            - max depth level
	 * @return
	 */
	public abstract StringBuilder toEcmaSource(
			final StringBuilder builder,
			final BaseObject o,
			final int ident,
			final int limit);
	
	/**
	 * Compact source
	 * 
	 * @param builder
	 * @param o
	 * @return
	 */
	public abstract StringBuilder toEcmaSourceCompact(//
			final StringBuilder builder,
			final BaseObject o);
}
