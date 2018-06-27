/*
 * Created on 04.12.2003
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package ru.myx.ae3.produce;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.flow.ObjectSource;
import ru.myx.ae3.flow.ObjectTarget;

abstract class FactoryGroup {
	static final int	EXACT	= 0;
	
	static final int	GROUP	= 1;
	
	/**
	 * @param type
	 * @param attributes
	 * @param context
	 * @return boolean
	 */
	abstract boolean accepts(final String type, final BaseObject attributes, final Class<?> context);
	
	/**
	 * @param factory
	 */
	abstract void add(final ObjectFactory<?, ?> factory);
	
	/**
	 * @param type
	 * @param attributes
	 * @param sourceClass
	 * @param chain
	 * @return target
	 */
	abstract ObjectTarget<Object> connect(
			final String type,
			final BaseObject attributes,
			final Class<?> sourceClass,
			final ObjectTarget<Object> chain);
	
	/**
	 * @return factory array
	 */
	abstract ObjectFactory<?, ?>[] factories();
	
	/**
	 * @param type
	 * @param attributes
	 * @param sourceClass
	 * @return factory
	 */
	abstract ObjectFactory<Object, Object> factory(
			final String type,
			final BaseObject attributes,
			final Class<?> sourceClass);
	
	/**
	 * @param type
	 * @param attributes
	 * @param sourceClass
	 * @param context
	 * @return source
	 */
	abstract ObjectSource<Object> prepare(
			final String type,
			final BaseObject attributes,
			final Class<?> sourceClass,
			final Object context);
	
	/**
	 * @param type
	 * @param attributes
	 * @param sourceClass
	 * @param context
	 * @return object
	 */
	abstract Object produce(
			final String type,
			final BaseObject attributes,
			final Class<?> sourceClass,
			final Object context);
	
	/**
	 * @return int
	 */
	abstract int type();
}
