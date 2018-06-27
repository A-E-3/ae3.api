package ru.myx.ae3.base;

import ru.myx.ae3.reflect.ReflectionHidden;
import ru.myx.ae3.reflect.ReflectionIgnore;

/**
 *
 * @author myx
 *
 * @param <T>
 */
@ReflectionIgnore
public interface BaseNumber<T extends Number> extends BaseObject {
	
	/**
	 *
	 */
	@ReflectionHidden
	public static final BaseObject PROTOTYPE = BaseObject.createObject(BaseObject.PROTOTYPE);

	@Override
	@ReflectionHidden
	default BaseObject basePrototype() {
		
		return BaseNumber.PROTOTYPE;
	}

	/**
	 * @return
	 */
	double doubleValue();

	/**
	 * @return
	 */
	float floatValue();

	/**
	 * @return
	 */
	int intValue();

	/**
	 *
	 * @return
	 */
	long longValue();

	@Override
	@ReflectionHidden
	default int baseToJavaInteger() {
		
		return this.intValue();
	}

	@Override
	@ReflectionHidden
	default long baseToJavaLong() {
		
		return this.longValue();
	}

	@Override
	@ReflectionHidden
	default boolean baseToJavaBoolean() {
		
		return this.doubleValue() != 0;
	}

	@Override
	@ReflectionHidden
	default String baseClass() {
		
		return "number";
	}

	@Override
	T baseValue();

	@ReflectionHidden
	@Override
	default BasePrimitiveNumber baseToNumber() {
		
		return Base.forDouble(this.doubleValue());
	}

	@ReflectionHidden
	@Override
	default BasePrimitive<Number> baseToPrimitive(final ToPrimitiveHint hint) {
		
		return Base.forDouble(this.doubleValue());
	}

}
