/**
 * Created on 28.11.2002
 * 
 * myx - barachta */
package ru.myx.ae3.produce;

import java.util.Map;

import ru.myx.ae3.AbstractSAPI;
import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseMap;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.flow.Flow;
import ru.myx.ae3.flow.ObjectSource;
import ru.myx.ae3.flow.ObjectTarget;
import ru.myx.ae3.report.Report;

/**
 * 
 * @author barachta
 * 
 * myx - barachta 
 *         "typecomment": Window>Preferences>Java>Templates. To enable and
 *         disable the creation of type comments go to
 *         Window>Preferences>Java>Code Generation.
 */
public class Produce extends AbstractSAPI {
	
	private static final AbstractProduceImpl	PRODUCE_IMPL;
	
	private static final FactoryRegistry		factoryRegistry;
	
	static {
		PRODUCE_IMPL = AbstractSAPI.createObject( "ru.myx.ae3.produce.ImplementProduce" );
		factoryRegistry = new FactoryRegistry();
		Produce.PRODUCE_IMPL.registerDefaultFactories();
	}
	
	
	/**
	 * Creates an object flow connection using all available factories
	 * registered in the system. Any factories can produce objects via this
	 * method.
	 * 
	 * @param target
	 * @param type
	 * @param attributes
	 * @param context
	 * @param chain
	 * @param <T>
	 * @return target
	 */
	@SuppressWarnings("unchecked")
	public final static <T> ObjectTarget<T> connection(
			final Class<? extends T> target,
			final String type,
			final BaseMap attributes,
			final Class<?> context,
			final ObjectTarget<?> chain) {
	
		assert target != null : "target class agrument should not be NULL!";
		return (ObjectTarget<T>) Produce.factoryRegistry.target( target, type, attributes, context, chain );
	}
	
	
	/**
	 * @param <T>
	 * @param name
	 * @param parent
	 * @param chains
	 * @param chainIndex
	 *            start with given index
	 * @param sourceFactory
	 * @param sourceAttributes
	 * @return success
	 * @throws Exception
	 */
	public static final <T> boolean connectLeast(
			final String name,
			final ObjectTarget<T> parent,
			final BaseObject[] chains,
			final int chainIndex,
			final String sourceFactory,
			final BaseObject sourceAttributes) throws Exception {
	
		if (parent == null) {
			throw new IllegalArgumentException( "Parent is NULL: name=" + name );
		}
		if (chainIndex == chains.length) {
			final ObjectSource<T> source = Produce.source( parent.accepts(), sourceFactory, sourceAttributes, null );
			if (source == null) {
				return false;
			}
			return Flow.connect( source, parent );
		}
		final String filterFactory = Base.getString( chains[chainIndex], "factory", "" ).trim();
		if (filterFactory.length() == 0) {
			Produce.warning( "[" + name + "] chain filter factory undefined - SKIPPING!" );
			return Produce.connectLeast( name, parent, chains, chainIndex + 1, sourceFactory, sourceAttributes );
		}
		final ObjectFactory<T, T> factory = Produce.factory( parent.accepts(), filterFactory, chains[chainIndex], null );
		if (factory == null) {
			Produce.warning( "[" + name + "] chain filter factory [" + filterFactory + "] unknown - SKIPPING!" );
			return Produce.connectLeast( name, parent, chains, chainIndex + 1, sourceFactory, sourceAttributes );
		}
		final Class<?>[] sources = factory.sources();
		if (sources == null || sources.length == 0) {
			final ObjectTarget<T> target = factory.connect( filterFactory, chains[chainIndex], null, parent );
			if (target == null) {
				Produce.warning( "[" + name + "] chain single failed!" );
				return false;
			}
			return Produce.connectLeast( name, target, chains, chainIndex + 1, sourceFactory, sourceAttributes );
		}
		for (final Class<?> source : sources) {
			final ObjectTarget<T> target = factory.connect( filterFactory, chains[chainIndex], source, parent );
			if (target == null) {
				Produce.warning( "[" + name + "] chain multi [" + source.getName() + "] failed!" );
				continue;
			}
			if (Produce.connectLeast( name, target, chains, chainIndex + 1, sourceFactory, sourceAttributes )) {
				return true;
			}
		}
		Produce.warning( "[" + name + "] chain multi failed!" );
		return Produce.connectLeast( name, parent, chains, chainIndex + 1, sourceFactory, sourceAttributes );
	}
	
	
	/**
	 * @param <T>
	 * @param name
	 * @param parent
	 * @param chains
	 * @param sourceFactory
	 * @param sourceAttributes
	 * @return success
	 * @throws Exception
	 */
	public static final <T> boolean connectLeast(
			final String name,
			final ObjectTarget<T> parent,
			final BaseObject[] chains,
			final String sourceFactory,
			final BaseObject sourceAttributes) throws Exception {
	
		if (parent == null) {
			throw new IllegalArgumentException( "Parent is NULL: name=" + name );
		}
		if (chains == null || 0 == chains.length) {
			final ObjectSource<T> source = Produce.source( parent.accepts(), sourceFactory, sourceAttributes, null );
			if (source == null) {
				return false;
			}
			return Flow.connect( source, parent );
		}
		final String filterFactory = Base.getString( chains[0], "factory", "" ).trim();
		if (filterFactory.length() == 0) {
			Produce.warning( "[" + name + "] chain filter factory undefined - SKIPPING!" );
			return Produce.connectLeast( name, parent, chains, 1, sourceFactory, sourceAttributes );
		}
		final ObjectFactory<T, T> factory = Produce.factory( parent.accepts(), filterFactory, chains[0], null );
		if (factory == null) {
			Produce.warning( "[" + name + "] chain filter factory [" + filterFactory + "] unknown - SKIPPING!" );
			return Produce.connectLeast( name, parent, chains, 1, sourceFactory, sourceAttributes );
		}
		final Class<?>[] sources = factory.sources();
		if (sources == null || sources.length == 0) {
			final ObjectTarget<T> target = factory.connect( filterFactory, chains[0], null, parent );
			if (target == null) {
				Produce.warning( "[" + name + "] chain single failed!" );
				return false;
			}
			return Produce.connectLeast( name, target, chains, 1, sourceFactory, sourceAttributes );
		}
		for (final Class<?> source : sources) {
			final ObjectTarget<T> target = factory.connect( filterFactory, chains[0], source, parent );
			if (target == null) {
				Produce.warning( "[" + name + "] chain multi [" + source.getName() + "] failed!" );
				continue;
			}
			if (Produce.connectLeast( name, target, chains, 1, sourceFactory, sourceAttributes )) {
				return true;
			}
		}
		Produce.warning( "[" + name + "] chain multi failed!" );
		return Produce.connectLeast( name, parent, chains, 1, sourceFactory, sourceAttributes );
	}
	
	
	/**
	 * Retrieves a factory to produce objects of specified type.
	 * 
	 * @param target
	 * @param type
	 * @param attributes
	 * @param context
	 * @param <S>
	 * @param <T>
	 * @return factory
	 */
	@SuppressWarnings("unchecked")
	public final static <S, T> ObjectFactory<S, T> factory(
			final Class<? extends T> target,
			final String type,
			final BaseObject attributes,
			final Class<? extends S> context) {
	
		assert target != null : "target class agrument should not be NULL!";
		return (ObjectFactory<S, T>) Produce.factoryRegistry.factory( target, type, attributes, context );
	}
	
	
	/**
	 * Retrieves a factory to produce objects of specified type.
	 * 
	 * @param target
	 * @param type
	 * @param attributes
	 * @param context
	 * @param <S>
	 * @param <T>
	 * @return factory
	 */
	@SuppressWarnings("unchecked")
	public final static <S, T> ObjectFactory<S, T> factory(
			final Class<? extends T> target,
			final String type,
			final Map<String, Object> attributes,
			final Class<? extends S> context) {
	
		assert target != null : "target class agrument should not be NULL!";
		return (ObjectFactory<S, T>) Produce.factoryRegistry.factory( target, type, Base.fromMap( attributes ), context );
	}
	
	
	/**
	 * Creates an object using all available factories registered in the system.
	 * Only blocking factories can produce objects via this method.
	 * 
	 * @param target
	 * @param type
	 * @param attributes
	 * @param context
	 * @param <T>
	 * @return object
	 */
	@SuppressWarnings("unchecked")
	public final static <T> T object(
			final Class<? extends T> target,
			final String type,
			final BaseObject attributes,
			final Object context) {
	
		assert target != null : "target class agrument should not be NULL!";
		return (T) Produce.factoryRegistry.create( target, type, attributes, context );
	}
	
	
	/**
	 * @param factory
	 */
	public static final void registerFactory(
			final ObjectFactory<?, ?> factory) {
	
		Produce.factoryRegistry.register( factory );
	}
	
	
	/**
	 * Creates an object using all available factories registered in the system.
	 * This is the only way for non-blocking factory to produce objects.
	 * 
	 * @param target
	 * @param type
	 * @param attributes
	 * @param context
	 * @param <T>
	 * @return source
	 */
	@SuppressWarnings("unchecked")
	public final static <T> ObjectSource<T> source(
			final Class<? extends T> target,
			final String type,
			final BaseObject attributes,
			final Object context) {
	
		assert target != null : "target class agrument should not be NULL!";
		return (ObjectSource<T>) Produce.factoryRegistry.source( target, type, attributes, context );
	}
	
	
	/**
	 * Creates an object using all available factories registered in the system.
	 * This is the only way for non-blocking factory to produce objects.
	 * 
	 * @param target
	 * @param type
	 * @param attributes
	 * @param context
	 * @param <T>
	 * @return source
	 */
	@SuppressWarnings("unchecked")
	public final static <T> ObjectSource<T> source(
			final Class<? extends T> target,
			final String type,
			final Map<String, Object> attributes,
			final Object context) {
	
		assert target != null : "target class agrument should not be NULL!";
		return (ObjectSource<T>) Produce.factoryRegistry.source( target, type, Base.fromMap( attributes ), context );
	}
	
	
	private static final void warning(
			final String message) {
	
		Report.currentReceiverLog().event( "AE3.PRODUCE", "WARNING", message );
	}
	
	
	private Produce() {
	
		// empty
	}
	
}
