package ru.myx.ae3.l2;

import ru.myx.ae3.base.BaseObject;

/**
 * @author myx
 * @param <T>
 *            target
 * 
 */
public abstract class LayoutDefinitionAbstract<T> implements LayoutDefinition<T> {
	@Override
	public BaseObject onExecute(
			final T target,
			final BaseObject layout) {
	
		return layout;
	}
}
