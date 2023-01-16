/**
 *
 */
package ru.myx.ae3.exec;

import java.util.RandomAccess;

import ru.myx.ae3.base.BaseArray;
import ru.myx.ae3.base.BaseArrayAdvanced;
import ru.myx.ae3.base.BaseHost;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.base.BasePrimitiveString;
import ru.myx.ae3.base.BaseProperty;
import ru.myx.ae3.base.BaseString;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;
import ru.myx.ae3.reflect.ReflectionIgnore;

/** Replace with BaseArray
 *
 * @author myx */
@ReflectionIgnore
public interface ExecArguments extends BaseArrayAdvanced<Object>, BaseHost, RandomAccess {
	
	/** Replace with BaseArray
	 *
	 * @author myx */
	@ReflectionDisable
	public interface NeedsDetachment extends ExecArguments, ExecValueDirect<ExecArguments> {
		
		@Override
		default ExecArguments baseValue() {
			
			return this;
		}
		
		/** @param ctx
		 * @return clone or this */
		@Override
		@ReflectionHidden
		BaseArray toDetached(final ExecProcess ctx);
		
		/** @param ctx
		 * @return clone or this */
		@Override
		@ReflectionHidden
		default BaseArray toNative() {

			return this.toDetached(Exec.currentProcess());
		}
		
	}
	
	/** arguments.callee (for ExecArguments instances) */
	BaseProperty PROPERTY_CALLEE = ExecArgumentsCalleeProperty.INSTANCE;
	/** arguments.length (for ExecArguments instances) */
	BaseProperty PROPERTY_LENGTH = ExecArgumentsLengthProperty.INSTANCE;
	
	@Override
	default String baseClass() {
		
		return "Arguments";
	}
	
	/** Argument at given index.
	 *
	 * @param i
	 *
	 * @return object */
	@Override
	BaseObject baseGet(int i, BaseObject defaultValue);
	
	@Override
	default BaseProperty baseGetOwnProperty(final BasePrimitiveString name) {
		
		if (name == BaseString.STR_LENGTH) {
			return ExecArguments.PROPERTY_LENGTH;
		}
		if (name == BaseString.STR_CALLEE) {
			return ExecArguments.PROPERTY_CALLEE;
		}
		return null;
	}
	
	@Override
	default BaseProperty baseGetOwnProperty(final String name) {
		
		if (name.length() == 6) {
			if ("length".equals(name)) {
				return ExecArguments.PROPERTY_LENGTH;
			}
			if ("callee".equals(name)) {
				return ExecArguments.PROPERTY_CALLEE;
			}
		}
		return null;
	}
	
	@Override
	default BaseObject basePrototype() {
		
		return BaseArray.PROTOTYPE;
	}
	
	/** Argument list length.
	 *
	 * @return integer */
	@Override
	int length();
}
