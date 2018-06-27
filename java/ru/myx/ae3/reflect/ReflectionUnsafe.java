package ru.myx.ae3.reflect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO: unused (yet?)
 * 
 * @author myx
 * 
 *         Used to mark members which should/designed-to work with raw VM values
 *         and should have simplified (faster) converters attached.
 * 
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR })
public @interface ReflectionUnsafe {
	//
}
