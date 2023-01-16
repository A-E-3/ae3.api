package ru.myx.ae3.exec;

import ru.myx.ae3.reflect.ReflectionDisable;

/** @author myx */
@FunctionalInterface
@ReflectionDisable
public interface ResultHandlerFinalizer extends ResultHandler.UseRB {
	
	/** result object supposed to be available in the direct register, default is 0RB. */
	@Override
	ExecStateCode execReturn(final ExecProcess ctx);
	
}
