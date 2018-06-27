package ru.myx.ae3.l2;

import ru.myx.ae3.base.BaseObject;

/**
 * @author myx
 * @param <T>
 *            target
 * 
 */
public interface LayoutDefinition<T> {
	/**
	 * "Обработчик перехода" - может модифицировать контекст, может подменять
	 * лэйаут.
	 * 
	 * @param target
	 * 
	 * @param layout
	 * @return null to stop, same to continue, new layout to replace
	 */
	public BaseObject onExecute(
			final T target,
			final BaseObject layout);
}
