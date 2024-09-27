package ru.myx.ae3.base;

import ru.myx.ae3.common.FutureValue;
import ru.myx.ae3.reflect.Reflect;
import ru.myx.ae3.reflect.ReflectionExplicit;
import ru.myx.ae3.reflect.ReflectionHidden;
import ru.myx.ae3.reflect.ReflectionManual;

/** @author myx
 *
 * @param <V> */
@ReflectionManual
public interface BaseFuture<V> extends BaseObject, FutureValue<V> {

	/** @author myx
	 * @param <V> */
	@ReflectionManual
	public static interface Completable<V> extends BaseFuture<V> {

		/**
		 *
		 */
		static BaseObject PROTOTYPE = Reflect.classToBasePrototype(BaseFuture.Completable.class);
		
		/** @return BaseFuture.PROTOTYPE by default */
		@Override
		default BaseObject baseFutureType() {

			return BaseFuture.Completable.PROTOTYPE;
		}
		
		/** @param error */
		@ReflectionExplicit
		void setError(Object error);
		
		/** @param result */
		@ReflectionExplicit
		void setResult(V result);
	}
	
	/** Default base future prototype */
	@ReflectionHidden
	static BaseObject PROTOTYPE = Reflect.classToBasePrototype(BaseFuture.class);
	
	/** @return BaseFuture.PROTOTYPE by default */
	@ReflectionHidden
	default BaseObject baseFutureType() {

		return BaseFuture.PROTOTYPE;
	}
	
	/** @return null */
	@Override
	@ReflectionHidden
	default BaseProperty baseGetOwnProperty(final BasePrimitiveString name) {

		// System.out.println(">>> >>> GOPB: " + this.isDone() + ", name: " +
		// name);
		return this.baseFutureType().baseFindProperty(name);
	}
	
	/** @return null */
	@Override
	@ReflectionHidden
	default BaseProperty baseGetOwnProperty(final String name) {

		// System.out.println(">>> >>> GOPB: " + this.isDone() + ", name: " +
		// name);
		return this.baseFutureType().baseFindProperty(name);
	}
	
	/** return Base.forUnknown(this.baseValue()); */
	@Override
	@ReflectionHidden
	default BaseObject basePrototype() {

		return Base.forUnknown(this.baseValue());
	}
	
	@Override
	@ReflectionHidden
	default BasePrimitiveBoolean baseToBoolean() {

		if (!this.baseAwait()) {
			return BaseObject.FALSE;
		}
		final V value = this.baseValue();
		if (value == null || value == BaseObject.UNDEFINED || value == BaseObject.NULL) {
			return BaseObject.FALSE;
		}
		assert value != this : "Future base value is THIS, class: " + this.getClass().getName();
		if (value instanceof BaseObject) {
			return ((BaseObject) value).baseToBoolean();
		}
		if (value instanceof Number) {
			return ((Number) value).doubleValue() == 0.0
				? BaseObject.FALSE
				: BaseObject.TRUE;
		}
		if (value instanceof CharSequence) {
			return ((CharSequence) value).length() == 0
				? BaseObject.FALSE
				: BaseObject.TRUE;
		}
		return BaseObject.TRUE;
	}
	
	@Override
	@ReflectionHidden
	default BasePrimitiveString baseToString() {

		final V value = this.baseValue();
		assert value != this : "Future base value is THIS, class: " + this.getClass().getName();
		return Base.forUnknown(value).baseToString();
	}
	
	/** Must return future value, wait until complete */
	@Override
	V baseValue();
}
