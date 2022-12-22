package ru.myx.ae3.vfs.ars;

import ru.myx.ae3.vfs.TreeLinkType;

/** A named reference from record to a record with a key that is also a record. 8)
 *
 * Source [ Key ]-> Target
 *
 * @author myx
 *
 * @param <O> */
public interface ArsReference<O extends ArsRecord> {

	/** @return */
	O getKey();
	
	/** @return */
	String getKeyString();
	
	/** @return */
	long getLastModified();
	
	/** @return */
	TreeLinkType getLinkageMode();
	
	/** @return */
	O getSource();
	
	/** @return */
	O getTarget();
	
	/** @return */
	boolean isExist();
}
