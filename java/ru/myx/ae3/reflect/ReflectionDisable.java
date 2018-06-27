package ru.myx.ae3.reflect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author myx
 * 
 *         When present, reflection would skip this type and its ancestors
 *         (upper hierarchy) completely, all other reflection annotations on
 *         this type and its members would be ignored.
 * 
 *         The class is completely transparent to reflection, none of the class
 *         methods anyhow visible.
 * 
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ReflectionDisable {
	//
}
