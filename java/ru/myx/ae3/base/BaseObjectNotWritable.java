package ru.myx.ae3.base;

import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/**
 *
 * @author myx
 *
 */
@ReflectionDisable
public interface BaseObjectNotWritable extends BaseObjectNotDynamic {
	
	
	/**
	 * does nothing
	 */
	@Override
	@ReflectionHidden
	default void baseDefineImportAllEnumerable(final BaseObject source) {
		
		
		return;
	}

	/**
	 * does nothing
	 */
	@Override
	@ReflectionHidden
	default void baseDefineImportOwnAll(final BaseObject source) {
		
		
		return;
	}

	/**
	 * does nothing
	 */
	@Override
	@ReflectionHidden
	default void baseDefineImportOwnEnumerable(final BaseObject source) {
		
		
		return;
	}

	/**
	 * does nothing
	 */
	@Override
	@ReflectionHidden
	default boolean baseDefine(final BasePrimitive<?> name, final BaseObject value) {
		
		
		return false;
	}

	/**
	 * does nothing
	 */
	@Override
	@ReflectionHidden
	default boolean baseDefine(final BasePrimitiveString name, final BaseObject value) {
		
		
		return false;
	}

	/**
	 * does nothing
	 */
	@Override
	@ReflectionHidden
	default boolean baseDefine(final CharSequence name, final BaseObject value, final short attributes) {
		
		
		return false;
	}

	/**
	 * does nothing
	 */
	@Override
	@ReflectionHidden
	default boolean baseDefine(final String name, final BaseObject value) {
		
		
		return false;
	}

	/**
	 * does nothing
	 */
	@Override
	@ReflectionHidden
	default boolean baseDefine(final String name, final BaseString<?> value) {
		
		
		return false;
	}

	/**
	 * does nothing
	 */
	@Override
	@ReflectionHidden
	default boolean baseDefine(final String name, final double value) {
		
		
		return false;
	}

	/**
	 * does nothing
	 */
	@Override
	@ReflectionHidden
	default boolean baseDefine(final String name, final long value) {
		
		
		return false;
	}

	/**
	 * does nothing
	 */
	@Override
	@ReflectionHidden
	default boolean baseDefine(final String name, final String value) {
		
		
		return false;
	}

	/**
	 * does nothing
	 */
	@Override
	@ReflectionHidden
	default boolean baseDefine(final String name, final boolean value) {
		
		
		return false;
	}

	/**
	 * does nothing
	 */
	@Override
	@ReflectionHidden
	default boolean baseDefine(final String name, final CharSequence value) {
		
		
		return false;
	}

	/**
	 * does nothing
	 */
	@Override
	@ReflectionHidden
	default boolean baseDefine(final BasePrimitiveString name, final BaseObject value, final short attributes) {
		
		
		return false;
	}

	/**
	 * does nothing
	 */
	@Override
	@ReflectionHidden
	default boolean baseDefine(final String name, final BaseObject value, final short attributes) {
		
		
		return false;
	}

	/**
	 * does nothing
	 */
	@Override
	@ReflectionHidden
	default boolean baseDefine(final String name, final double value, final short attributes) {
		
		
		return false;
	}

	/**
	 * does nothing
	 */
	@Override
	@ReflectionHidden
	default boolean baseDefine(final String name, final long value, final short attributes) {
		
		
		return false;
	}

	/**
	 * does nothing
	 */
	@Override
	@ReflectionHidden
	default boolean baseDefine(final String name, final String value, final short attributes) {
		
		
		return false;
	}

	/**
	 * does nothing
	 */
	@Override
	@ReflectionHidden
	default ExecStateCode vmPropertyDefine(final ExecProcess ctx, final BaseObject name, final BaseObject value, final ResultHandler store) {
		
		
		/**
		 * change nothing
		 */

		return store.execReturn(ctx, value);
	}

	/**
	 * does nothing
	 */
	@Override
	@ReflectionHidden
	default boolean baseDelete(final String name) {
		
		
		return false;
	}

	@Override
	@ReflectionHidden
	default boolean baseIsExtensible() {
		
		
		return false;
	}

}
