package ru.myx.ae3.reflect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** @author myx
 *
 *         Used to mark method or field that it should be used for default property write operation.
 *
 *         <ul>
 *         method should be one of (function name does not matter):
 *         <li>Any fn(key, value)</li>
 *         <li>BaseMap fn()</li>
 *         <li>Map<String,Object> fn()</li>
 *         </ul>
 *
 *         <ul>
 *         member field should be one of:
 *         <li>BaseMap</li>
 *         <li>Map<String,Object></li>
 *         </ul>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({
		ElementType.METHOD, ElementType.FIELD
})
public @interface ReflectionPutDefault {
	//
}
