package ru.myx.ae3.common;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;

/** @author myx */
public interface HasAttributes {

	/** @param name
	 * @param defaultValue
	 * @return */
	default BaseObject getAttribute(final CharSequence name, final BaseObject defaultValue) {

		final BaseObject attributes = this.getAttributes();
		return attributes == null
			? defaultValue
			: attributes.baseGet(name, defaultValue);
	}

	/** Returns a map of attributes assigned to this object or null. Must not return <b>null </b>
	 * when hasAttributes() returns <b>true </b>.
	 *
	 * @return map */
	BaseObject getAttributes();

	/** Default implementation of hasAttributes retrieves attributes using getAttributes and checks
	 * that it is a non-empty BaseMap instance.
	 *
	 *
	 * @return */
	default boolean hasAttributes() {

		final BaseObject attributes = this.getAttributes();
		return attributes != null && Base.hasKeys(attributes);
	}

}
