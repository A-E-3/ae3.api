/*
 * Created on 04.12.2003
 * 
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package ru.myx.ae3.produce;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.flow.ObjectSource;
import ru.myx.ae3.flow.ObjectTarget;

final class ExactWrapper extends FactoryGroup {
	final ObjectFactory<Object, Object>	factory;
	
	@SuppressWarnings("unchecked")
	ExactWrapper(final ObjectFactory<?, ?> factory) {
		this.factory = (ObjectFactory<Object, Object>) factory;
	}
	
	@Override
	public boolean accepts(final String type, final BaseObject attributes, final Class<?> context) {
		return this.factory.accepts( type, attributes, context );
	}
	
	@Override
	public final void add(final ObjectFactory<?, ?> factory) {
		throw new UnsupportedOperationException( "EXACT group is immutable!" );
	}
	
	@Override
	public final ObjectTarget<Object> connect(
			final String type,
			final BaseObject attributes,
			final Class<?> sourceClass,
			final ObjectTarget<Object> chain) {
		return this.factory.connect( type, attributes, sourceClass, chain );
	}
	
	@Override
	public ObjectFactory<?, ?>[] factories() {
		return new ObjectFactory[] { this.factory };
	}
	
	@Override
	public final ObjectFactory<Object, Object> factory(
			final String type,
			final BaseObject attributes,
			final Class<?> sourceClass) {
		return this.factory.factory( type, attributes, sourceClass );
	}
	
	@Override
	public final ObjectSource<Object> prepare(
			final String type,
			final BaseObject attributes,
			final Class<?> sourceClass,
			final Object context) {
		return this.factory.prepare( type, attributes, context );
	}
	
	@Override
	public final Object produce(
			final String type,
			final BaseObject attributes,
			final Class<?> sourceClass,
			final Object context) {
		return this.factory.produce( type, attributes, context );
	}
	
	@Override
	public final int type() {
		return FactoryGroup.EXACT;
	}
}
