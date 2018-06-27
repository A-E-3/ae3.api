package ru.myx.ae3.vfs;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.binary.TransferCopier;
import ru.myx.ae3.common.Value;
import ru.myx.ae3.reflect.Reflect;
import ru.myx.ae3.reflect.ReflectionExplicit;
import ru.myx.ae3.reflect.ReflectionManual;

/** @author myx */
@ReflectionManual
public interface EntryBinary extends Entry {
	
	/**
	 *
	 */
	@ReflectionExplicit
	static BaseObject PROTOTYPE = Reflect.classToBasePrototype(EntryBinary.class);
	
	/** @return */
	@ReflectionExplicit
	TransferCopier getBinary();
	
	/** @return */
	@Override
	Value<? extends TransferCopier> getBinaryContent();
	
	/** @return */
	@ReflectionExplicit
	long getBinaryContentLength();
	
	@Override
	default boolean isBinary() {
		
		return true;
	}
	
	@Override
	default EntryBinary toBinary() {
		
		return this;
	}
}
