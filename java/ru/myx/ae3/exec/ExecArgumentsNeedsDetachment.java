/**
 *
 */
package ru.myx.ae3.exec;

import ru.myx.ae3.base.BaseArray;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/**
 * Replace with BaseArray
 *
 * @author myx
 *
 */
@ReflectionDisable
public interface ExecArgumentsNeedsDetachment
		extends
			ExecArguments /* , ExecValueDirect<ExecArguments> */ {
	
	
	/**
	 * @param ctx
	 * @return clone or this
	 */
	@ReflectionHidden
	BaseArray toDetachedOriginal(final ExecProcess ctx);

}
