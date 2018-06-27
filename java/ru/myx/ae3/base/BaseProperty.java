/**
 *
 */
package ru.myx.ae3.base;

import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;
import ru.myx.ae3.reflect.ReflectionDisable;

/** 8.6.1 Property Attributes
 * <p>
 * A property can have zero or more attributes from the following set:<br< <b>ReadOnly</b> - The
 * property is a read-only property. Attempts by ECMAScript code to write to the property will be
 * ignored. (Note, however, that in some cases the value of a property with the ReadOnly attribute
 * may change over time because of actions taken by the host environment; therefore “ReadOnly” does
 * not mean “constant and unchanging”!)<br>
 * <b>DontEnum</b> - The property is not to be enumerated by a for-in enumeration (section 12.6.4).
 * <br>
 * <b>DontDelete</b> - Attempts to delete the property will be ignored. See the description of the
 * delete operator in section 11.4.1.<br>
 * <p>
 * Internal properties not mentioned here since they are implemented not as properties.
 * <p>
 *
 * @author myx */
@ReflectionDisable
public interface BaseProperty {

	/** true if and only if the value associated with the property may be changed with an assignment
	 * operator. */
	short ATTR_WRITABLE = 0x0001;

	/** true if and only if this property shows up during enumeration of the properties on the
	 * corresponding object. */
	short ATTR_ENUMERABLE = 0x0002;

	/** true if and only if the type of this property descriptor may be changed and if the property
	 * may be deleted from the corresponding object. */
	short ATTR_DYNAMIC = 0x0004;

	/** extra: property methods do need an instance */
	short ATTR_INSTANCE = 0x0008;

	/** extra: property get may return dynamic results or when getter or setter requires a special
	 * code to be run */
	short ATTR_PROCEDURAL = 0x0010;

	/** extra: property methods do need key */
	short ATTR_KEY_NEEDED = 0x0020;

	/**
	 *
	 */
	short ATTRS_DYNAMIC_OR_PROCEDURAL = BaseProperty.ATTR_DYNAMIC | BaseProperty.ATTR_PROCEDURAL;

	/**
	 *
	 */
	short ATTRS_MASK_WED = BaseProperty.ATTR_WRITABLE | BaseProperty.ATTR_ENUMERABLE | BaseProperty.ATTR_DYNAMIC;

	/**
	 *
	 */
	short ATTRS_MASK_WND = BaseProperty.ATTR_WRITABLE | BaseProperty.ATTR_DYNAMIC;

	/**
	 *
	 */
	short ATTRS_MASK_NED = BaseProperty.ATTR_ENUMERABLE | BaseProperty.ATTR_DYNAMIC;

	/**
	 *
	 */
	short ATTRS_MASK_WEN = BaseProperty.ATTR_WRITABLE | BaseProperty.ATTR_ENUMERABLE;

	/**
	 *
	 */
	short ATTRS_MASK_NEN = BaseProperty.ATTR_ENUMERABLE;

	/**
	 *
	 */
	short ATTRS_MASK_WNN = BaseProperty.ATTR_WRITABLE;

	/**
	 *
	 */
	short ATTRS_MASK_NND = BaseProperty.ATTR_DYNAMIC;

	/**
	 *
	 */
	short ATTRS_MASK_NNN = 0;

	/**
	 *
	 */
	short ATTRS_MASK_NNN_NPN = BaseProperty.ATTR_PROCEDURAL;

	/**
	 *
	 */
	short ATTRS_MASK_NNN_IPN = BaseProperty.ATTR_INSTANCE | BaseProperty.ATTR_PROCEDURAL;

	/**
	 *
	 */
	short ATTRS_MASK_WNN_IPN = BaseProperty.ATTRS_MASK_WNN | BaseProperty.ATTR_INSTANCE | BaseProperty.ATTR_PROCEDURAL;

	/**
	 *
	 */
	short ATTRS_MASK_WNN_IPK = BaseProperty.ATTRS_MASK_WNN | BaseProperty.ATTR_INSTANCE | BaseProperty.ATTR_PROCEDURAL | BaseProperty.ATTR_KEY_NEEDED;

	/**
	 *
	 */
	short ATTRS_MASK_NNN_INN = BaseProperty.ATTR_INSTANCE;

	/**
	 *
	 */
	short ATTRS_MASK_NNN_NNK = BaseProperty.ATTR_KEY_NEEDED;

	/**
	 *
	 */
	short ATTRS_MASK_NEN_NNK = BaseProperty.ATTRS_MASK_NEN | BaseProperty.ATTR_KEY_NEEDED;

	/**
	 *
	 */
	short ATTRS_MASK_WED_NNK = BaseProperty.ATTRS_MASK_WED | BaseProperty.ATTR_KEY_NEEDED;

	/**
	 *
	 */
	short ATTRS_MASK_WED_NPK = BaseProperty.ATTRS_MASK_WED | BaseProperty.ATTR_PROCEDURAL | BaseProperty.ATTR_KEY_NEEDED;

	/**
	 *
	 */
	short ATTRS_MASK_NNN_INK = BaseProperty.ATTR_INSTANCE | BaseProperty.ATTR_KEY_NEEDED;

	/**
	 *
	 */
	short ATTRS_MASK_NNN_IPK = BaseProperty.ATTR_INSTANCE | BaseProperty.ATTR_PROCEDURAL | BaseProperty.ATTR_KEY_NEEDED;

	/**
	 *
	 */
	short ATTRS_MASK_WED_IPK = BaseProperty.ATTRS_MASK_WED | BaseProperty.ATTR_INSTANCE | BaseProperty.ATTR_PROCEDURAL | BaseProperty.ATTR_KEY_NEEDED;

	/** all standard: (attrs >> ATTRS_SHR_STANDARD) == 0
	 *
	 * has non-standard: (attrs >> ATTRS_SHR_STANDARD) != 0 */
	short ATTRS_SHR_STANDARD = 3;

	/** @param writable
	 * @param enumerable
	 * @param dynamic
	 * @return */
	static short propertyAttributes(final boolean writable, final boolean enumerable, final boolean dynamic) {

		return (short) (0 + //
				(writable
					? BaseProperty.ATTR_WRITABLE
					: 0)
				| //
				(enumerable
					? BaseProperty.ATTR_ENUMERABLE
					: 0)
				| //
				(dynamic
					? BaseProperty.ATTR_DYNAMIC
					: 0) //
		);
	}

	/** true if and only if the type of this property descriptor may be changed and if the property
	 * may be deleted from the corresponding object.
	 *
	 * @param attributes
	 * @return */
	static boolean propertyIsDynamic(final short attributes) {

		return (attributes & BaseProperty.ATTR_DYNAMIC) != 0;
	}

	/** true if and only if this property shows up during enumeration of the properties on the
	 * corresponding object.
	 *
	 * @param attributes
	 * @return */
	static boolean propertyIsEnumerable(final short attributes) {

		return (attributes & BaseProperty.ATTR_ENUMERABLE) != 0;
	}

	/** @param attributes
	 * @return */
	static boolean propertyIsProcedural(final short attributes) {

		return (attributes & BaseProperty.ATTR_PROCEDURAL) != 0;
	}

	/** true if and only if the value associated with the property may be changed with an assignment
	 * operator.
	 *
	 * @param attributes
	 * @return */
	static boolean propertyIsWritable(final short attributes) {

		return (attributes & BaseProperty.ATTR_WRITABLE) != 0;
	}

	/** property attributes
	 *
	 * @param name
	 * @return */
	short propertyAttributes(CharSequence name);

	/** @param instance
	 * @param name
	 * @return value */
	BaseObject propertyGet(BaseObject instance, BasePrimitiveString name);

	/** @param instance
	 * @param name
	 * @return value */
	BaseObject propertyGet(BaseObject instance, String name);

	/** @param instance
	 * @param name
	 * @param value
	 *
	 * @return */
	BaseObject propertyGetAndSet(BaseObject instance, String name, BaseObject value);

	/** @param ctx
	 * @param instance
	 * @param name
	 * @param store
	 * @return execution state code (null) */
	ExecStateCode propertyGetCtxResult(ExecProcess ctx, BaseObject instance, BasePrimitive<?> name, ResultHandler store);

	/** Should not change attributes. Attributes are still provided for 'synthetic' property
	 * objects, which are always existing, for them to be able to set 'em for newly created
	 * properties.
	 *
	 * @param instance
	 * @param name
	 * @param value
	 * @param attributes
	 * @return */
	default boolean propertySet(final BaseObject instance, final CharSequence name, final BaseObject value, final short attributes) {

		assert instance != null : "NULL java value!";

		/** read-only */
		return false;
	}
}
