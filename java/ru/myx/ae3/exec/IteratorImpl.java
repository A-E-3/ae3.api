/**
 *
 */
package ru.myx.ae3.exec;

import ru.myx.ae3.base.BaseObject;

/** @author myx */
interface IteratorImpl extends BaseObject {

	/** @param ctx
	 * @param object
	 * @param name
	 * @return boolean */
	public boolean next(final ExecProcess ctx, final BaseObject object, final String name);
}
