package ru.myx.ae3.common;

import ru.myx.ae3.reflect.ReflectionDisable;

/**
 *
 * @author myx
 * 
 */
@ReflectionDisable
public interface Describable {

	/**
	 * TODO: add request/interface context to allow for media selection and zoom
	 *
	 * @return
	 */
	Object baseDescribe();

}
