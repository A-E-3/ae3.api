/*
 * Created on 04.12.2003
 * 
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package ru.myx.ae3.produce;

import java.util.ArrayList;
import java.util.List;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.flow.ObjectSource;
import ru.myx.ae3.flow.ObjectTarget;

final class SourceFactory extends FactoryGroup {
	private final List<ObjectFactory<Object, Object>>	factories	= new ArrayList<>();
	
	SourceFactory(final ObjectFactory<?, ?> first, final ObjectFactory<?, ?> second) {
		this.add( first );
		this.add( second );
	}
	
	@Override
	public boolean accepts(final String type, final BaseObject attributes, final Class<?> context) {
		return this.factory( type, attributes, context ) != null;
	}
	
	@Override
	public final synchronized void add(final ObjectFactory<?, ?> factory) {
		if (!this.factories.contains( factory )) {
			@SuppressWarnings("unchecked")
			final ObjectFactory<Object, Object> converted = (ObjectFactory<Object, Object>) factory;
			this.factories.add( converted );
		}
	}
	
	@Override
	public final ObjectTarget<Object> connect(
			final String type,
			final BaseObject attributes,
			final Class<?> sourceClass,
			final ObjectTarget<Object> chain) {
		final ObjectFactory<Object, Object> factory = this.factory( type, attributes, sourceClass );
		return factory == null
				? null
				: factory.connect( type, attributes, sourceClass, chain );
	}
	
	@Override
	public synchronized ObjectFactory<?, ?>[] factories() {
		return this.factories.toArray( new ObjectFactory[this.factories.size()] );
	}
	
	@Override
	public final ObjectFactory<Object, Object> factory(
			final String type,
			final BaseObject attributes,
			final Class<?> context) {
		for (final ObjectFactory<Object, Object> current : this.factories) {
			if (current.accepts( type, attributes, context )) {
				return current;
			}
		}
		return null;
	}
	
	@Override
	public final ObjectSource<Object> prepare(
			final String type,
			final BaseObject attributes,
			final Class<?> sourceClass,
			final Object context) {
		final ObjectFactory<Object, Object> factory = this.factory( type, attributes, sourceClass );
		return factory == null
				? null
				: factory.prepare( type, attributes, context );
	}
	
	@Override
	public final Object produce(
			final String type,
			final BaseObject attributes,
			final Class<?> sourceClass,
			final Object context) {
		final ObjectFactory<Object, Object> factory = this.factory( type, attributes, sourceClass );
		return factory == null
				? null
				: factory.produce( type, attributes, context );
	}
	
	@Override
	public final int type() {
		return FactoryGroup.GROUP;
	}
}
