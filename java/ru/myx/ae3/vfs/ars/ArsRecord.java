package ru.myx.ae3.vfs.ars;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.know.Guid;

/** A unique record, that is user to represent any supported value or a key.
 *
 * @author myx */
public interface ArsRecord {

	/** @return */
	long getBinaryContentLength();

	/** required to return non-NULL values only for records created as result of createKeyForString
	 * method.
	 *
	 * @return */
	String getKeyString();

	/** @return */
	BaseObject getPrimitiveBaseValue();

	/** @return */
	Guid getPrimitiveGuid();

	/** @return */
	Object getPrimitiveValue();

	/** @return */
	boolean isBinary();

	/** @return */
	boolean isCharacter();

	/** @return */
	boolean isContainer();

	/** @return */
	boolean isPrimitive();
}
