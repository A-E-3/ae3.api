package ru.myx.ae3.json;

import ru.myx.ae3.base.BaseObject;

abstract class AbstractJsonImpl {

	/** Readable source
	 *
	 * @param builder
	 * @param o
	 * @param ident
	 * @param limit
	 *            - max depth level
	 * @return */
	public abstract StringBuilder toJsonSource(final StringBuilder builder, final BaseObject o, final int ident, final int limit);

	/** Compact source
	 *
	 * @param builder
	 * @param o
	 * @return */
	public abstract StringBuilder toJsonSourceCompact(//
			final StringBuilder builder,
			final BaseObject o);
}
