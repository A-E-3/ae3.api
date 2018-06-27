package ru.myx.ae3.e4.vm;

/**
 * 
 * @author myx
 *
 * @param <State>
 * @param <Context>
 */
public interface VmInstruction<State, Context> {
	/**
	 * 
	 * @param ctx
	 * @return
	 * @throws Exception
	 */
	State execCall(
			Context ctx) throws Exception;
}
