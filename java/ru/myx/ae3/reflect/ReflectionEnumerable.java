package ru.myx.ae3.reflect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author myx
 * 
 *         Used to explicitly mark members which should be reflected as
 *         enumerable fields Used for fields and getter methods.
 * 
 * 
 *         non (static | transient class fields are enumerable by default)
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD })
public @interface ReflectionEnumerable {
	//
}
