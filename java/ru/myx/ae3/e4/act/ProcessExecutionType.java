package ru.myx.ae3.e4.act;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** @author myx
 *
 *         Drivers checkReferenced method can be safely called by a dedicated thread asynchronously
 *         of other methods. */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({
		ElementType.TYPE
})
public @interface ProcessExecutionType {

	/** @return */
	Manager.Factory.TYPE type();
}
