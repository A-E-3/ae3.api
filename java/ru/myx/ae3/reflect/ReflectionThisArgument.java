package ru.myx.ae3.reflect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** @author myx
 *
 *         Only for static methods. Use thisInstance as first argument which is of BaseObject
 *         type. */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({
		ElementType.METHOD
})
public @interface ReflectionThisArgument {
	//
}
