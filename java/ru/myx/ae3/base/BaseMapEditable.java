package ru.myx.ae3.base;

import ru.myx.ae3.reflect.ReflectionIgnore;

/**
 * @author myx
 *
 */
@ReflectionIgnore
public interface BaseMapEditable extends BaseEditable, BaseMap {
	
	
	/**
	 * Funny method returns same object. For use in in-line initializations.
	 * <p>
	 * Will return NULL if put fails, but this possible only when prototype
	 * object explicitly prohibits it or property was previously set as
	 * read-only.
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	BaseMapEditable putAppend(final BasePrimitiveString key, final BaseObject value);
	
	/**
	 * Funny method returns same object. For use in in-line initializations.
	 * <p>
	 * Will return NULL if put fails, but this possible only when prototype
	 * object explicitly prohibits it or property was previously set as
	 * read-only.
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	BaseMapEditable putAppend(final String key, final BaseObject value);
	
	/**
	 * @param key
	 * @param value
	 * @return
	 */
	BaseMapEditable putAppend(final String key, final boolean value);
	
	/**
	 * Funny method returns same object. For use in in-line initializations.
	 * <p>
	 * Will return NULL if put fails, but this possible only when prototype
	 * object explicitly prohibits it or property was previously set as
	 * read-only.
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	BaseMapEditable putAppend(final String key, final double value);
	
	/**
	 * @param key
	 * @param value
	 * @return
	 */
	BaseMapEditable putAppend(final String key, final int value);
	
	/**
	 * @param key
	 * @param value
	 * @return
	 */
	BaseMapEditable putAppend(final String key, final String value);
	
	/**
	 *
	 * @param source
	 * @return
	 */
	default BaseMapEditable putAppendAllOwnProperties(final BaseObject source) {
		
		
		this.setOwnProperties(source);
		return this;
	}
}
