package ru.myx.ae3.base;

import java.util.Iterator;

import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/** @author myx */
@ReflectionDisable
public interface BaseEditable extends BaseObject {
	
	/** @param source
	 * @return */
	@ReflectionHidden
	default BaseEditable setOwnProperties(final BaseObject source) {
		
		for (final Iterator<? extends CharSequence> iterator = source.baseKeysOwnAll(); iterator.hasNext();) {
			final BasePrimitiveString key = Base.forString(iterator.next());
			
			// new Error(">>>>> setOwn: key: " + key + ", source: " +
			// source.getClass().getSimpleName()).printStackTrace();
			
			final BaseProperty property = source.baseGetOwnProperty(key);
			if (property == null) {
				continue;
			}
			this.setOwnProperty(key, property, property.propertyAttributes(key));
		}
		return this;
	}
	
	/** @param nameInstance
	 * @param property
	 * @param attributes
	 * @return */
	@ReflectionHidden
	default boolean setOwnProperty(final BasePrimitiveString nameInstance, final BaseProperty property) {
		
		return this.setOwnProperty(//
				nameInstance,
				property,
				property.propertyAttributes(nameInstance));
	}
	
	/** @param nameInstance
	 * @param property
	 * @param attributes
	 * @return */
	@ReflectionHidden
	boolean setOwnProperty(final BasePrimitiveString nameInstance, final BaseProperty property, final short attributes);
	
	/** @param nameString
	 * @param property
	 * @param attributes
	 * @return */
	@ReflectionHidden
	default boolean setOwnProperty(final String nameString, final BaseProperty property) {
		
		return this.setOwnProperty(//
				nameString,
				property,
				property.propertyAttributes(nameString));
	}
	
	/** @param nameString
	 * @param property
	 * @param attributes
	 * @return */
	@ReflectionHidden
	boolean setOwnProperty(final String nameString, final BaseProperty property, final short attributes);
	
	/** @param nameInstance
	 * @param property
	 * @param attributes
	 * @return */
	@ReflectionHidden
	default boolean setOwnPropertyValue(final BasePrimitiveString nameInstance, final BaseObject property, final short attributes) {
		
		return this.setOwnProperty(//
				nameInstance,
				(BaseProperty) BaseProperties.createFirstProperty(nameInstance, property, attributes),
				attributes);
	}
	
	/** @param nameString
	 * @param property
	 * @param attributes
	 * @return */
	@ReflectionHidden
	default boolean setOwnPropertyValue(final String nameString, final BaseObject property, final short attributes) {
		
		return this.setOwnProperty(//
				nameString,
				(BaseProperty) BaseProperties.createFirstProperty(nameString, property, attributes),
				attributes);
	}
}
