/*
 * Created on 04.12.2003
 * 
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package ru.myx.ae3.produce;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.flow.ObjectSource;
import ru.myx.ae3.flow.ObjectTarget;

final class ClassFactory extends FactoryGroup {
	/**
	 * Contains all factories for a concreete class.
	 */
	private final Set<ObjectFactory<?, ?>>	factories	= new HashSet<>();
	
	private final Map<String, FactoryGroup>	byType		= new HashMap<>( 64, 0.5f );
	
	private FactoryGroup					wildcard;
	
	ClassFactory(final ObjectFactory<?, ?> first, final ObjectFactory<?, ?> second) {
		this.add( first );
		this.add( second );
	}
	
	@Override
	public boolean accepts(final String type, final BaseObject attributes, final Class<?> context) {
		final FactoryGroup factory = this.byType.get( type );
		return factory != null
				? factory.accepts( type, attributes, context )
				: this.wildcard == null
						? false
						: this.wildcard.accepts( type, attributes, context );
	}
	
	@Override
	public final synchronized void add(final ObjectFactory<?, ?> factory) {
		this.factories.add( factory );
		final String[] types = factory.variety();
		if (types == null) {
			if (this.wildcard == null) {
				this.wildcard = new ExactWrapper( factory );
			} else {
				if (this.wildcard.type() == FactoryGroup.GROUP) {
					this.wildcard.add( factory );
				} else {
					this.wildcard = new TypeFactory( ((ExactWrapper) this.wildcard).factory, factory );
				}
			}
			return;
		}
		for (int i = types.length - 1; i >= 0; --i) {
			final FactoryGroup group = this.byType.get( types[i] );
			if (group == null) {
				this.byType.put( types[i], new ExactWrapper( factory ) );
			} else {
				if (group.type() == FactoryGroup.GROUP) {
					group.add( factory );
				} else {
					this.byType.put( types[i], new TypeFactory( ((ExactWrapper) group).factory, factory ) );
				}
			}
		}
	}
	
	@Override
	public final ObjectTarget<Object> wrapTarget(
			final String type,
			final BaseObject attributes,
			final Class<?> sourceClass,
			final ObjectTarget<Object> chain) {
		final FactoryGroup factory = this.byType.get( type );
		return factory != null
				? factory.wrapTarget( type, attributes, sourceClass, chain )
				: this.wildcard == null
						? null
						: this.wildcard.wrapTarget( type, attributes, sourceClass, chain );
	}
	
	@Override
	public synchronized ObjectFactory<?, ?>[] factories() {
		return this.factories.toArray( new ObjectFactory[this.factories.size()] );
	}
	
	@Override
	public final ObjectFactory<Object, Object> factory(
			final String type,
			final BaseObject attributes,
			final Class<?> sourceClass) {
		final FactoryGroup factory = this.byType.get( type );
		return factory != null
				? factory.factory( type, attributes, sourceClass )
				: this.wildcard == null
						? null
						: this.wildcard.factory( type, attributes, sourceClass );
	}
	
	@Override
	public final ObjectSource<Object> wrapSource(
			final String type,
			final BaseObject attributes,
			final Class<?> sourceClass,
			final Object context) {
		final FactoryGroup factory = this.byType.get( type );
		return factory != null
				? factory.wrapSource( type, attributes, sourceClass, context )
				: this.wildcard == null
						? null
						: this.wildcard.wrapSource( type, attributes, sourceClass, context );
	}
	
	@Override
	public final Object produce(
			final String type,
			final BaseObject attributes,
			final Class<?> sourceClass,
			final Object context) {
		final FactoryGroup factory = this.byType.get( type );
		return factory != null
				? factory.produce( type, attributes, sourceClass, context )
				: this.wildcard == null
						? null
						: this.wildcard.produce( type, attributes, sourceClass, context );
	}
	
	@Override
	public final int type() {
		return FactoryGroup.GROUP;
	}
}
