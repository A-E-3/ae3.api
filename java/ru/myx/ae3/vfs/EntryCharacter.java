package ru.myx.ae3.vfs;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.common.Value;
import ru.myx.ae3.reflect.Reflect;
import ru.myx.ae3.reflect.ReflectionExplicit;
import ru.myx.ae3.reflect.ReflectionManual;

/** TODO: not used (yet?)
 *
 * @author myx */
@ReflectionManual
public interface EntryCharacter extends Entry {
	
	/**
	 *
	 */
	@ReflectionExplicit
	static BaseObject PROTOTYPE = Reflect.classToBasePrototype(EntryCharacter.class);
	
	/** @return */
	@ReflectionExplicit
	long getCharacterContentLength();
	
	/** @return */
	@ReflectionExplicit
	CharSequence getText();
	
	/** @return */
	@Override
	Value<? extends CharSequence> getTextContent();
	
	@Override
	default boolean isCharacter() {
		
		return true;
	}
	
	@Override
	default EntryCharacter toCharacter() {
		
		return this;
	}
}
