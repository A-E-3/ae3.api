package ru.myx.ae3.vfs;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.reflect.Reflect;

/**
 * @author myx
 * 		
 */
public interface EntryMount extends Entry {
	
	@Override
	default boolean isMount() {
		
		return true;
	}
	
	@Override
	default EntryMount toMount() {
		
		return this;
	}
	
	/**
	 * 
	 */
	static BaseObject PROTOTYPE = Reflect.classToBasePrototype(EntryMount.class);
	
	//
	
	/**
	 * Non null for isMount entries!
	 * 
	 * @return
	 */
	Entry getMountTarget();
}
