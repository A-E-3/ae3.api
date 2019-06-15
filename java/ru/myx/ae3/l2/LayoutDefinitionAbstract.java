package ru.myx.ae3.l2;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.reflect.ReflectionIgnore;

/** @author myx
 * @param <T>
 *            target
 * 
 *            TODO: needed, really? */
@ReflectionIgnore
public interface LayoutDefinitionAbstract<T> extends LayoutDefinition<T> {
	
	@Override
	public default BaseObject onExecute(final T target, final BaseObject layout) {
		
		return layout;
	}
}
