package ru.myx.ae3.base;

import java.util.Iterator;

import ru.myx.ae3.reflect.ReflectionHidden;
import ru.myx.ae3.reflect.ReflectionIgnore;

/** @author myx
 *
 *         Joined object. */
@ReflectionIgnore
public class BaseJoined implements BaseObject {

	/** Internal singular constant to denote uninitialized prototype */
	private static final BaseObject UNINITIALIZED_PROTOTYPE = new BaseDate(0);

	/** main primary map **/
	private final BaseObject primary;

	/** secondary (defaults) object **/
	private final BaseObject secondary;

	private BaseObject prototype = BaseJoined.UNINITIALIZED_PROTOTYPE;

	/** @param primary
	 * @param secondary */
	@ReflectionHidden
	public BaseJoined(final BaseObject primary, final BaseObject secondary) {

		this.prototype = BaseJoined.UNINITIALIZED_PROTOTYPE;
		this.primary = primary;
		this.secondary = secondary;
	}

	/** @param prototype
	 * @param primary
	 * @param secondary */
	@ReflectionHidden
	public BaseJoined(final BaseObject prototype, final BaseObject primary, final BaseObject secondary) {

		this.prototype = prototype;
		this.primary = primary;
		this.secondary = secondary;
	}

	@Override
	@ReflectionHidden
	public BaseArray baseArray() {

		return this.primary.baseArray();
	}

	@Override
	@ReflectionHidden
	public BaseFunction baseCall() {

		return this.primary.baseCall();
	}

	@Override
	@ReflectionHidden
	public String baseClass() {

		return this.primary.baseClass();
	}

	@Override
	@ReflectionHidden
	public void baseClear() {

		this.primary.baseClear();
	}

	@Override
	@ReflectionHidden
	public BaseFunction baseConstruct() {

		return this.primary.baseConstruct();
	}

	@Override
	@ReflectionHidden
	public boolean baseDefine(final BasePrimitiveString name, final BaseObject value, final short attributes) {

		return this.primary.baseDefine(name, value, attributes);
	}

	@Override
	@ReflectionHidden
	public boolean baseDefine(final String name, final BaseObject value, final short attributes) {

		return this.primary.baseDefine(name, value, attributes);
	}

	@Override
	@ReflectionHidden
	public boolean baseDefine(final String name, final double value, final short attributes) {

		return this.primary.baseDefine(name, value, attributes);
	}

	@Override
	@ReflectionHidden
	public boolean baseDefine(final String name, final long value, final short attributes) {

		return this.primary.baseDefine(name, value, attributes);
	}

	@Override
	@ReflectionHidden
	public boolean baseDefine(final String name, final String value, final short attributes) {

		return this.primary.baseDefine(name, value, attributes);
	}

	@Override
	@ReflectionHidden
	public boolean baseDelete(final String name) {

		return this.primary.baseDelete(name);
	}

	@Override
	@ReflectionHidden
	public BaseProperty baseGetOwnProperty(final BasePrimitiveString name) {

		{
			final BaseProperty property = this.primary.baseGetOwnProperty(name);
			if (property != null) {
				return property;
			}
		}

		if (this.prototype == null) {
			final BaseProperty property = this.secondary.baseGetOwnProperty(name);
			if (property != null) {
				return property;
			}
		}

		return null;
	}

	@Override
	@ReflectionHidden
	public BaseProperty baseGetOwnProperty(final CharSequence name) {

		{
			final BaseProperty property = this.primary.baseGetOwnProperty(name);
			if (property != null) {
				return property;
			}
		}

		if (this.prototype == null) {
			final BaseProperty property = this.secondary.baseGetOwnProperty(name);
			if (property != null) {
				return property;
			}
		}

		return null;
	}

	@Override
	@ReflectionHidden
	public BaseProperty baseGetOwnProperty(final String name) {

		{
			final BaseProperty property = this.primary.baseGetOwnProperty(name);
			if (property != null) {
				return property;
			}
		}

		if (this.prototype == null) {
			final BaseProperty property = this.secondary.baseGetOwnProperty(name);
			if (property != null) {
				return property;
			}
		}

		return null;
	}

	@Override
	@ReflectionHidden
	public boolean baseHasKeysOwn() {

		return this.primary.baseHasKeysOwn() || this.prototype == null && this.secondary.baseHasKeysOwn();
	}

	@Override
	@ReflectionHidden
	public boolean baseIsExtensible() {

		return this.primary.baseIsExtensible();
	}

	@Override
	@ReflectionHidden
	public Iterator<String> baseKeysOwn() {

		if (this.prototype == null) {
			return Base.joinIteratorsAsString(this.primary.baseKeysOwn(), this.secondary.baseKeysOwn());
		}

		return this.primary.baseKeysOwn();
	}

	@Override
	@ReflectionHidden
	public Iterator<? extends CharSequence> baseKeysOwnAll() {

		if (this.prototype == null) {
			return Base.joinIterators(this.primary.baseKeysOwnAll(), this.secondary.baseKeysOwnAll());
		}

		return this.primary.baseKeysOwnAll();
	}

	@Override
	@ReflectionHidden
	public Iterator<? extends BasePrimitive<?>> baseKeysOwnPrimitive() {

		if (this.prototype == null) {
			return Base.joinIteratorsPrimitive(this.primary.baseKeysOwnPrimitive(), this.secondary.baseKeysOwnPrimitive());
		}

		return this.primary.baseKeysOwnPrimitive();
	}

	@Override
	@ReflectionHidden
	public BaseObject basePrototype() {

		if (this.prototype != BaseJoined.UNINITIALIZED_PROTOTYPE) {
			return this.prototype;
		}
		synchronized (this) {
			if (this.prototype != BaseJoined.UNINITIALIZED_PROTOTYPE) {
				return this.prototype;
			}
			final BaseObject prototype = this.primary.basePrototype();
			if (prototype == null) {
				return this.prototype = null;
			}
			if (prototype == BaseObject.PROTOTYPE) {
				return this.prototype = this.secondary;
			}
			return this.prototype = new BaseJoined(prototype, this.secondary);
		}
	}

	@Override
	@ReflectionHidden
	public BasePrimitiveBoolean baseToBoolean() {

		return this.primary.baseToBoolean();
	}

	@Override
	@ReflectionHidden
	public BasePrimitiveNumber baseToInt32() {

		return this.primary.baseToInt32();
	}

	@Override
	@ReflectionHidden
	public BasePrimitiveNumber baseToInteger() {

		return this.primary.baseToInteger();
	}

	@Override
	@ReflectionHidden
	public BasePrimitiveNumber baseToNumber() {

		return this.primary.baseToNumber();
	}

	@Override
	@ReflectionHidden
	public BasePrimitive<?> baseToPrimitive(final ToPrimitiveHint hint) {

		return this.primary.baseToPrimitive(hint);
	}

	@Override
	@ReflectionHidden
	public BasePrimitiveString baseToString() {

		return this.primary.baseToString();
	}

	@Override
	@ReflectionHidden
	public Object baseValue() {

		return this.primary.baseValue();
	}

	@Override
	public boolean equals(final Object o) {

		return this.primary.equals(o);
	}

	@Override
	public int hashCode() {

		return this.primary.hashCode();
	}
}
