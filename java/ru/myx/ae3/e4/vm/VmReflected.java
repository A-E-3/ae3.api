package ru.myx.ae3.e4.vm;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.base.BasePrimitive;
import ru.myx.ae3.base.BasePrimitiveString;
import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/** @author myx */
@ReflectionDisable
public interface VmReflected {
	
	/** @param ctx
	 * @param name
	 * @param value
	 * @param store
	 * @return */
	@ReflectionHidden
	ExecStateCode vmPropertyDefine(@NotNull ExecProcess ctx, @NotNull BaseObject name, @NotNull BaseObject value, @NotNull ResultHandler store);
	
	/** @param ctx
	 * @param index
	 * @param originalIfKnown
	 * @param value
	 * @param store
	 * @return */
	@ReflectionHidden
	default ExecStateCode vmPropertyDefine(@NotNull final ExecProcess ctx,
			final int index,
			@Nullable final BaseObject originalIfKnown,
			@NotNull final BaseObject value,
			@NotNull final ResultHandler store) {
		
		/** FIXME: unwanted recursion possible! */
		if (originalIfKnown != null) {
			return this.vmPropertyDefine(ctx, originalIfKnown, value, store);
		}
		return this.vmPropertyDefine(ctx, Base.forString(index), value, store);
	}
	
	/** @param ctx
	 * @param name
	 * @param defaultValue
	 * @param store
	 * @return */
	@ReflectionHidden
	default ExecStateCode vmPropertyRead(final ExecProcess ctx, final BaseObject name, final BaseObject defaultValue, final ResultHandler store) {
		
		if (name instanceof BasePrimitiveString) {
			return this.vmPropertyRead(ctx, (BasePrimitiveString) name, defaultValue, store);
		}
		
		if (name instanceof CharSequence) {
			return this.vmPropertyRead(ctx, name.baseToJavaString(), defaultValue, store);
		}
		
		if (name instanceof BasePrimitive<?>) {
			return this.vmPropertyRead(ctx, (BasePrimitive<?>) name, defaultValue, store);
		}
		
		return this.vmPropertyRead(ctx, name.baseToPrimitive(null), defaultValue, store);
	}
	
	/** @param ctx
	 * @param name
	 * @param defaultValue
	 * @param store
	 * @return */
	@ReflectionHidden
	default ExecStateCode vmPropertyRead(final ExecProcess ctx, final BasePrimitive<?> name, final BaseObject defaultValue, final ResultHandler store) {
		
		if (name instanceof BasePrimitiveString) {
			return this.vmPropertyRead(ctx, (BasePrimitiveString) name, defaultValue, store);
		}
		
		if (name instanceof CharSequence) {
			return this.vmPropertyRead(ctx, name.baseToJavaString(), defaultValue, store);
		}
		
		/** with support for fakes */
		if (name.baseIsPrimitiveInteger()) {
			return this.vmPropertyRead(ctx, name.intValue(), name, defaultValue, store);
		}
		
		final BasePrimitiveString identity = name.baseToStringIfReady();
		if (identity != null) {
			return this.vmPropertyRead(ctx, identity, defaultValue, store);
		}
		
		return this.vmPropertyRead(ctx, name.baseToJavaString(), defaultValue, store);
	}
	
	/** @param ctx
	 * @param name
	 * @param defaultValue
	 * @param store
	 * @return */
	@ReflectionHidden
	ExecStateCode vmPropertyRead(ExecProcess ctx, BasePrimitiveString name, BaseObject defaultValue, ResultHandler store);
	
	/** @param ctx
	 * @param name
	 * @param originalIfKnown
	 * @param defaultValue
	 * @param store
	 * @return */
	@ReflectionHidden
	default ExecStateCode vmPropertyRead(final ExecProcess ctx,
			final CharSequence name,
			final BaseObject originalIfKnown,
			final BaseObject defaultValue,
			final ResultHandler store) {
		
		if (name instanceof BasePrimitiveString) {
			return this.vmPropertyRead(ctx, (BasePrimitiveString) name, defaultValue, store);
		}
		
		return this.vmPropertyRead(ctx, name instanceof String
			? (String) name
			: originalIfKnown == null
				? name.toString()
				: originalIfKnown.baseToJavaString(), defaultValue, store);
	}
	
	/** @param ctx
	 * @param index
	 * @param originalIfKnown
	 * @param defaultValue
	 * @param store
	 * @return */
	@ReflectionHidden
	default ExecStateCode vmPropertyRead(final ExecProcess ctx, final int index, final BaseObject originalIfKnown, final BaseObject defaultValue, final ResultHandler store) {
		
		if (originalIfKnown != null) {
			final BasePrimitive<?> primitive = originalIfKnown.baseToPrimitive(null);
			final BasePrimitiveString identity = primitive.baseToStringIfReady();
			if (identity != null) {
				return this.vmPropertyRead(ctx, identity, defaultValue, store);
			}
			
			return this.vmPropertyRead(ctx, primitive.baseToJavaString(), defaultValue, store);
		}
		
		return this.vmPropertyRead(ctx, Base.toString(index), defaultValue, store);
		// return this.vmPropertyRead(ctx, Base.forString(index), defaultValue);
	}
	
	/** @param ctx
	 * @param name
	 * @param defaultValue
	 * @param store
	 * @return */
	@ReflectionHidden
	ExecStateCode vmPropertyRead(ExecProcess ctx, String name, BaseObject defaultValue, ResultHandler store);
}
