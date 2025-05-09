/*
 * Created on 04.12.2003
 * 
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package ru.myx.ae3.produce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.flow.ObjectSource;
import ru.myx.ae3.flow.ObjectTarget;

final class TypeFactory extends FactoryGroup {
	/**
	 * Contains all factories for a concreete class and concreete type.
	 */
	private final List<ObjectFactory<?, ?>>		factories	= new ArrayList<>();
	
	private final Map<Class<?>, FactoryGroup>	bySource	= new HashMap<>( 64, 0.5f );
	
	TypeFactory(final ObjectFactory<?, ?> first, final ObjectFactory<?, ?> second) {
		this.add( first );
		this.add( second );
	}
	
	@Override
	public boolean accepts(final String type, final BaseObject attributes, final Class<?> context) {
		return this.factoryGroup( type, attributes, context ) != null;
	}
	
	@Override
	public final synchronized void add(final ObjectFactory<?, ?> factory) {
		if (!this.factories.contains( factory )) {
			this.factories.add( factory );
			this.factories.add( factory );
			final Class<?>[] sources = factory.sources();
			if (sources == null || sources.length == 0) {
				this.register( null, factory );
			} else {
				for (int i = sources.length - 1; i >= 0; --i) {
					this.register( sources[i], factory );
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
		final FactoryGroup factory = this.factoryGroup( type, attributes, sourceClass );
		return factory == null
				? null
				: factory.wrapTarget( type, attributes, sourceClass, chain );
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
		final FactoryGroup factory = this.factoryGroup( type, attributes, sourceClass );
		return factory == null
				? null
				: factory.factory( type, attributes, sourceClass );
	}
	
	private final FactoryGroup factoryGroup(final String type, final BaseObject attributes, final Class<?> context) {
		return this.search( type, attributes, context, context );
	}
	
	@Override
	public final ObjectSource<Object> wrapSource(
			final String type,
			final BaseObject attributes,
			final Class<?> sourceClass,
			final Object context) {
		final FactoryGroup factory = this.factoryGroup( type, attributes, sourceClass );
		return factory == null
				? null
				: factory.wrapSource( type, attributes, sourceClass, context );
	}
	
	@Override
	public final Object produce(
			final String type,
			final BaseObject attributes,
			final Class<?> sourceClass,
			final Object context) {
		final FactoryGroup factory = this.factoryGroup( type, attributes, sourceClass );
		return factory == null
				? null
				: factory.produce( type, attributes, sourceClass, context );
	}
	
	private final synchronized void register(final Class<?> cls, final FactoryGroup factory) {
		final FactoryGroup grp = this.bySource.get( cls );
		if (grp == null) {
			this.bySource.put( cls, factory );
		} else {
			final ObjectFactory<?, ?>[] factories = factory.factories();
			if (grp.type() == FactoryGroup.GROUP) {
				for (final ObjectFactory<?, ?> factorie : factories) {
					grp.add( factorie );
				}
			} else {
				final FactoryGroup group = new SourceFactory( ((ExactWrapper) grp).factory, factories[0] );
				for (int i = 1; i < factories.length; ++i) {
					group.add( factories[i] );
				}
				this.bySource.put( cls, group );
			}
		}
	}
	
	private final void register(final Class<?> cls, final ObjectFactory<?, ?> factory) {
		final FactoryGroup group = this.bySource.get( cls );
		if (group == null) {
			this.bySource.put( cls, new ExactWrapper( factory ) );
		} else {
			if (group.type() == FactoryGroup.GROUP) {
				group.add( factory );
			} else {
				this.bySource.put( cls, new SourceFactory( ((ExactWrapper) group).factory, factory ) );
			}
		}
	}
	
	private final FactoryGroup search(
			final String type,
			final BaseObject attributes,
			final Class<?> cls,
			final Class<?> context) {
		final FactoryGroup factory = this.bySource.get( cls );
		if (factory != null && factory.accepts( type, attributes, context )) {
			return factory;
		}
		if (cls == null) {
			return null;
		}
		final Class<?>[] interfaces = cls.getInterfaces();
		for (int i = interfaces.length - 1; i >= 0; --i) {
			if (interfaces[i] != cls) {
				final FactoryGroup found = this.search( type, attributes, interfaces[i], context );
				if (found != null && found.accepts( type, attributes, context )) {
					this.register( interfaces[i], found );
					return found;
				}
			}
		}
		final Class<?> parent = cls.getSuperclass();
		if (parent != null && parent != cls) {
			final FactoryGroup found = this.search( type, attributes, parent, context );
			if (found != null && found.accepts( type, attributes, context )) {
				this.register( parent, found );
				return found;
			}
		}
		return null;
	}
	
	@Override
	public final int type() {
		return FactoryGroup.GROUP;
	}
}
