package ru.myx.ae3.exec;


/**
 *
 * @author myx
 *
 */
@FunctionalInterface
public interface ResultHandlerFinalizer extends ResultHandler.UseRB {
	
	
	/**
	 * result object supposed to be available in the direct register, default is
	 * 0RB.
	 */
	@Override
	ExecStateCode execReturn(final ExecProcess ctx);

}
