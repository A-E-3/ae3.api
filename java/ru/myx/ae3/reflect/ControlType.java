/**
 * 
 */
package ru.myx.ae3.reflect;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;

/**
 * @author myx
 * @param <N>
 *            native
 * @param <J>
 *            java
 * 
 */
public interface ControlType<J extends Object, N extends BaseObject> {
	/**
	 * @param object
	 * @return converted to T
	 */
	J convertAnyJavaToJava(Object object);
	
	/**
	 * @param object
	 * @return converted to J
	 */
	J convertAnyNativeToJava(BaseObject object);
	
	/**
	 * @param object
	 * @return converted to T
	 */
	N convertAnyNativeToNative(BaseObject object);
	
	/**
	 * @param object
	 * @return converted from J
	 */
	N convertJavaToAnyNative(J object);
	
	/**
	 * TODO: add convertNativeToCtxResult(ExecProcess ctx, N object)
	 * 
	 * @param ctx
	 * @param object
	 * @param store TODO
	 * @return converted from J
	 */
	ExecStateCode convertJavaToCtxResult(ExecProcess ctx, J object, ResultHandler store);
	
	/**
	 * @return associated java class
	 */
	Class<J> getJavaClass();
	
	/**
	 * @return string
	 */
	String getTypeName();
	
	/**
	 * @param object
	 * @return
	 */
	boolean isAnyJavaToJavaPerfect(Object object);
	
	/**
	 * @param object
	 * @return
	 */
	boolean isAnyJavaToJavaPossible(Object object);
	
	/**
	 * @param object
	 * @return
	 */
	boolean isAnyNativeToJavaPerfect(BaseObject object);
	
	/**
	 * @param object
	 * @return
	 */
	boolean isAnyNativeToJavaPossible(BaseObject object);
}
