package ru.myx.ae3.console;

import java.util.Collection;
import java.util.Map.Entry;

import ru.myx.ae3.common.Value;

/**
 * 
 * @author myx
 * 
 */
public interface ConsoleInput {
	
	/**
	 * @param title
	 * @return boolean value
	 */
	Value<Boolean> readBoolean(String title);
	
	/**
	 * @param title
	 * @param defaultValue
	 * @return boolean value
	 */
	Value<Boolean> readBoolean(String title, boolean defaultValue);
	
	/**
	 * @param title
	 * @param selection
	 * @param defaultValue
	 * @return result
	 */
	Value<String> readChoose(String title, Collection<Entry<String, Object>> selection, String defaultValue);
	
	/**
	 * @param title
	 * @return nothing
	 */
	Value<?> readContinue(String title);
	
	/**
	 * @param title
	 * @return integer value
	 */
	Value<Number> readInteger(String title);
	
	/**
	 * @param title
	 * @param defaultValue
	 * @return integer value
	 */
	Value<Number> readInteger(String title, int defaultValue);
	
	/**
	 * @param title
	 * @return string value
	 */
	Value<String> readPassword(String title);
	
	/**
	 * @param title
	 * @param defaultValue
	 *            - may be null, when no default value available
	 * @return string value
	 */
	Value<String> readString(String title, String defaultValue);
}
