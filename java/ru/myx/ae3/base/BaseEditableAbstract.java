package ru.myx.ae3.base;

import java.util.Iterator;

import ru.myx.ae3.reflect.ReflectionDisable;

/** @author myx */
@ReflectionDisable
public abstract class BaseEditableAbstract extends BaseAbstract implements BaseEditable {
	
	/**
	 *
	 */
	protected BaseProperties<?> properties = null;
	
	@Override
	public boolean baseDefine(final BasePrimitiveString name, final BaseObject value, final short attributes) {
		
		assert name != null : "Name is NULL";
		assert value != null : "Shouldn't be NULL, use BaseObject.UNDEFINED or BaseObject.NULL instead";
		/** 1. Call the [[GetOwnProperty]] method of O with property name P.<br>
		 * 2. Get the [[Extensible]] property of O. <br>
		 * 3. If Result(1) is undefined and Result(2) is true, then<br>
		 * a. Create an own property named P of object O whose state is described by Desc.<br>
		 * b. Return true. <br>
		 * 4. If Result(1) is undefined and Result(2) is false, then<br>
		 * a. If Strict is true, then throw TypeError. <br>
		 * b. Else return false. <br>
		 */
		final BaseProperty property = this.baseGetOwnProperty(name);
		if (property == null) {
			if (this.baseIsExtensible()) {
				this.properties = this.properties == null
					? BaseProperties.createFirstProperty(name, value, attributes)
					: this.properties.add(name, value, attributes);
				return true;
			}
			return false;
		}
		/** 5. If Result(1) is the same as Desc, then return true. */
		// ignore
		/** 6. If the [[Dynamic]] attribute of Result(1) is true, then<br>
		 * a. Alter the P property of O to have the state described by Desc. <br>
		 * b. Return true. <br>
		 */
		final short propertyAttributes = property.propertyAttributes(name);
		if ((propertyAttributes & BaseProperty.ATTRS_DYNAMIC_OR_PROCEDURAL_SET) != 0) {
			return property.propertySet(this, name, value, attributes);
		}
		/** 7. If Result(1) or Desc is a PDesc, then<br>
		 * a. If Strict is true, then throw something. <br>
		 * b. Else return false. <br>
		 */
		// skipped
		/** 8. Get the [[Writeable]] component of Result(1), which is a DDesc. <br>
		 * 9. If Result(8) is false, or if Result(1) and Desc differ in any component besides
		 * [[Value]], then<br>
		 * a. If Strict is true, then throw something. <br>
		 * b. Else return false. <br>
		 */
		if ((propertyAttributes & BaseProperty.ATTR_WRITABLE) == 0 || (attributes & BaseProperty.ATTRS_MASK_WED) != (propertyAttributes & BaseProperty.ATTRS_MASK_WED)) {
			return false;
		}
		/** 10. Alter the [[Value]] field of the P property of O to be the same as the [[Value]]
		 * field of Desc, thereby altering the property to have the state described by Desc. <br>
		 */
		return property.propertySet(this, name, value, attributes);
	}
	
	@Override
	public boolean baseDefine(final String name, final BaseObject value, final short attributes) {
		
		assert name != null : "Name is NULL";
		assert value != null : "Shouldn't be NULL, use BaseObject.UNDEFINED or BaseObject.NULL instead";
		/** 1. Call the [[GetOwnProperty]] method of O with property name P.<br>
		 * 2. Get the [[Extensible]] property of O. <br>
		 * 3. If Result(1) is undefined and Result(2) is true, then<br>
		 * a. Create an own property named P of object O whose state is described by Desc.<br>
		 * b. Return true. <br>
		 * 4. If Result(1) is undefined and Result(2) is false, then<br>
		 * a. If Strict is true, then throw TypeError. <br>
		 * b. Else return false. <br>
		 */
		final BaseProperty property = this.baseGetOwnProperty(name);
		if (property == null) {
			if (this.baseIsExtensible()) {
				this.properties = this.properties == null
					? BaseProperties.createFirstProperty(name, value, attributes)
					: this.properties.add(name, value, attributes);
				return true;
			}
			return false;
		}
		/** 5. If Result(1) is the same as Desc, then return true. */
		// ignore
		/** 6. If the [[Dynamic]] attribute of Result(1) is true, then<br>
		 * a. Alter the P property of O to have the state described by Desc. <br>
		 * b. Return true. <br>
		 */
		final short propertyAttributes = property.propertyAttributes(name);
		if ((propertyAttributes & BaseProperty.ATTRS_DYNAMIC_OR_PROCEDURAL_SET) != 0) {
			return property.propertySet(this, name, value, attributes);
		}
		/** 7. If Result(1) or Desc is a PDesc, then<br>
		 * a. If Strict is true, then throw something. <br>
		 * b. Else return false. <br>
		 */
		// skipped
		/** 8. Get the [[Writeable]] component of Result(1), which is a DDesc. <br>
		 * 9. If Result(8) is false, or if Result(1) and Desc differ in any component besides
		 * [[Value]], then<br>
		 * a. If Strict is true, then throw something. <br>
		 * b. Else return false. <br>
		 */
		if ((propertyAttributes & BaseProperty.ATTR_WRITABLE) == 0 || (attributes & BaseProperty.ATTRS_MASK_WED) != (propertyAttributes & BaseProperty.ATTRS_MASK_WED)) {
			return false;
		}
		/** 10. Alter the [[Value]] field of the P property of O to be the same as the [[Value]]
		 * field of Desc, thereby altering the property to have the state described by Desc. <br>
		 */
		return property.propertySet(this, name, value, attributes);
	}
	
	/** [[Delete]] (P) When the [[Delete]] method of O is called with property name P, the following
	 * steps are taken:<br>
	 * 1. If O doesn’t have a property with name P, return true.<br>
	 * 2. If the property has the DontDelete attribute, return false.<br>
	 * 3. Remove the property with name P from O.<br>
	 * 4. Return true.
	 *
	 * @param name
	 * @return boolean */
	public boolean baseDelete(final BasePrimitiveString name) {
		
		assert name != null : "property name shouldn't be NULL";
		
		final BaseProperties<?> properties = this.properties;
		if (properties == null) {
			return true;
		}
		final BaseProperty property = properties.find(name);
		if (property == null) {
			return true;
		}
		final short propertyAttributes = property.propertyAttributes(name);
		if ((propertyAttributes & BaseProperty.ATTR_DYNAMIC) != 0) {
			this.properties = properties.delete(name);
			return true;
		}
		return false;
	}
	
	/** [[Delete]] (P) When the [[Delete]] method of O is called with property name P, the following
	 * steps are taken:<br>
	 * 1. If O doesn’t have a property with name P, return true.<br>
	 * 2. If the property has the DontDelete attribute, return false.<br>
	 * 3. Remove the property with name P from O.<br>
	 * 4. Return true.
	 *
	 * @param name
	 * @return boolean */
	@Override
	public boolean baseDelete(final String name) {
		
		assert name != null : "property name shouldn't be NULL";
		final BaseProperties<?> properties = this.properties;
		if (properties == null) {
			return true;
		}
		final BaseProperty property = properties.find(name);
		if (property == null) {
			return true;
		}
		final short propertyAttributes = property.propertyAttributes(name);
		if ((propertyAttributes & BaseProperty.ATTR_DYNAMIC) != 0) {
			this.properties = properties.delete(name);
			return true;
		}
		return false;
	}
	
	@Override
	public BaseProperty baseGetOwnProperty(final BasePrimitiveString name) {
		
		final BaseProperties<?> properties = this.properties;
		return properties == null
			? null
			: properties.find(name);
	}
	
	@Override
	public BaseProperty baseGetOwnProperty(final CharSequence name) {
		
		final BaseProperties<?> properties = this.properties;
		return properties == null
			? null
			: properties.find(name);
	}
	
	@Override
	public BaseProperty baseGetOwnProperty(final String name) {
		
		final BaseProperties<?> properties = this.properties;
		return properties == null
			? null
			: properties.find(name);
	}
	
	@Override
	public boolean baseHasKeysOwn() {
		
		final BaseProperties<?> properties = this.properties;
		return properties != null && properties.hasEnumerableProperties();
	}
	
	@Override
	public Iterator<String> baseKeysOwn() {
		
		final BaseProperties<?> properties = this.properties;
		return properties == null
			? BaseObject.ITERATOR_EMPTY
			: properties.iteratorEnumerableAsString();
	}
	
	@Override
	public Iterator<? extends CharSequence> baseKeysOwnAll() {
		
		final BaseProperties<?> properties = this.properties;
		return properties == null
			? BaseObject.ITERATOR_EMPTY
			: properties.iteratorAllAsString();
	}
	
	@Override
	public Iterator<? extends BasePrimitive<?>> baseKeysOwnPrimitive() {
		
		final BaseProperties<?> properties = this.properties;
		return properties == null
			? BaseObject.ITERATOR_EMPTY_PRIMITIVE
			: properties.iteratorEnumerableAsPrimitive();
	}
	
	// @Override
	// public abstract boolean equals(final Object o);
	
	// @Override
	// public abstract int hashCode();
	
	@Override
	public boolean setOwnProperty(final BasePrimitiveString name, final BaseProperty property, final short attributes) {
		
		assert property != null : "NULL property";
		
		final BaseProperties<?> properties = this.properties;
		
		if (properties != null) {
			final BaseProperty existing = properties.find(name);
			if (existing != null) {
				final short existingAttributes = existing.propertyAttributes(name);
				if ((existingAttributes & BaseProperty.ATTRS_MASK_WND) == 0) {
					// ignore
					return false;
				}
				
				// assert AbstractSAPI.logDebug("ROPI(this=" +
				// this.getClass().getSimpleName() + ", key=" + name + ",
				// propClass=" + property.getClass().getSimpleName() + ")");
				
				final BaseProperties<?> replacement = properties.delete(name);
				
				this.properties = replacement == null
					? BaseProperties.createFirstProperty(this, name, property, attributes)
					: replacement.add(this, name, property, attributes);
				return true;
			}
		}
		
		// assert AbstractSAPI.logDebug("SOPI(this=" +
		// this.getClass().getSimpleName() + ", key=" + name + ", propClass=" +
		// property.getClass().getSimpleName() + ")");
		
		/** including BasePropertyFilter */
		this.properties = properties == null
			? BaseProperties.createFirstProperty(this, name, property, attributes)
			: properties.add(this, name, property, attributes);
		return true;
	}
	
	@Override
	public boolean setOwnProperty(final String name, final BaseProperty property, final short attributes) {
		
		assert property != null : "NULL property";
		
		final BaseProperties<?> properties = this.properties;
		
		if (properties != null) {
			final BaseProperty existing = properties.find(name);
			if (existing != null) {
				if ((existing.propertyAttributes(name) & BaseProperty.ATTRS_MASK_WND) == 0) {
					// ignore
					return false;
				}
				
				// assert AbstractSAPI.logDebug("ROPS(this=" +
				// this.getClass().getSimpleName() + ", key=" + name + ",
				// propClass=" + property.getClass().getSimpleName() + ")");
				
				final BaseProperties<?> replacement = properties.delete(name);
				
				this.properties = replacement == null
					? BaseProperties.createFirstProperty(this, name, property, attributes)
					: replacement.add(this, name, property, attributes);
				return true;
			}
		}
		
		// assert AbstractSAPI.logDebug("SOPS(this=" +
		// this.getClass().getSimpleName() + ", key=" + name + ", propClass=" +
		// property.getClass().getSimpleName() + ")");
		
		/** including BasePropertyFilter */
		this.properties = properties == null
			? BaseProperties.createFirstProperty(this, name, property, attributes)
			: properties.add(this, name, property, attributes);
		return true;
	}
	
}
