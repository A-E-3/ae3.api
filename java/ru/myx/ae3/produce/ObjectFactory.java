package ru.myx.ae3.produce;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.flow.FlowOperationException;
import ru.myx.ae3.flow.ObjectSource;
import ru.myx.ae3.flow.ObjectTarget;

/**
 * An object to create objects using data specified.
 * <p>
 * Some common types: <br>
 * - (type) to an (object) - creation <br>
 * - (type + attributes) to an (object) - creation <br>
 * - (type + attributes + source) to an (object) - creation/conversion <br>
 * - (source) to an (object) - conversion <br>
 * - (source:Transfer.Buffer) to an (object) - Materialization <br>
 * - (source) to a (object:Transfer.Buffer) - Serialization <br>
 *
 * @param <S>
 * @param <T>
 */
public interface ObjectFactory<S, T> {
	
	/**
	 * Returns true when this factory can produce objects using data provided.
	 *
	 * @param variant
	 * @param attributes
	 * @param source
	 * @return boolean
	 */
	boolean accepts(final String variant, final BaseObject attributes, final Class<?> source);

	/**
	 * Creates a target whose absorbation methods will absorb instances of
	 * <i>source </i> class and send produced objects to a target specified.
	 *
	 * @param variant
	 * @param attributes
	 * @param source
	 * @param target
	 * @return target
	 */
	default ObjectTarget<S> wrapTarget(final String variant, final BaseObject attributes, final Class<?> source, final ObjectTarget<T> target) {

		final ObjectFactory<S, T> factory = this.factory(variant, attributes, source);
		if (factory == null) {
			@SuppressWarnings("unchecked")
			final ObjectTarget<S> result = (ObjectTarget<S>) ObjectTarget.NUL_TARGET;
			return result;
		}
		return new ObjectTarget<>() {
			
			@Override
			public boolean absorb(final S object) throws FlowOperationException {

				return target.absorb(factory.produce(variant, attributes, object));
			}
			
			@Override
			public String toString() {
				
				return "[object AbstractObjectFactoryTarget]";
			}
		};
	}

	/**
	 * Returns exact factory to produce objects using data provided or null.
	 *
	 * @param variant
	 * @param attributes
	 * @param source
	 * @return factory
	 */
	default ObjectFactory<S, T> factory(final String variant, final BaseObject attributes, final Class<?> source) {
		
		return this.accepts(variant, attributes, source)
			? this
			: null;
	}

	/**
	 * Prepares a source to produce objects using data specified. This is the
	 * only way for non-blocking factory to produce objects.
	 *
	 * @param variant
	 * @param attributes
	 * @param source
	 * @return source
	 */
	default ObjectSource<T> wrapSource(final String variant, final BaseObject attributes, final S source) {

		final ObjectFactory<S, T> factory = this.factory(variant, attributes, source == null
			? null
			: source.getClass());
		if (factory == null) {
			@SuppressWarnings("unchecked")
			final ObjectSource<T> result = (ObjectSource<T>) ObjectSource.NUL_SOURCE;
			return result;
		}
		return new ObjectSource<>() {

			@Override
			public T next() {

				return factory.produce(variant, attributes, source);
			}

			@Override
			public String toString() {
				
				return "[object AbstractObjectFactorySource]";
			}
		};
	}

	/**
	 * Creates an object using data specified. Only blocking factory can produce
	 * objects using this method.
	 *
	 * @param variant
	 * @param attributes
	 * @param source
	 * @return object
	 */
	T produce(final String variant, final BaseObject attributes, final S source);

	/**
	 * Returns an array of classes and interfaces to be accepted by this factory
	 * for production. Factory will NOT recieve creation request when source
	 * class is not compatible with every class declared by this method. Factory
	 * MUST return same or equal array on every call. It's recommended to use
	 * something like static constant variable to return in this method because
	 * some registry factory implementations may call this method frequently. In
	 * order to be used when no source object is available (e.g. source is NULL)
	 * this array should contain null value. When no source object is needed at
	 * all this method may return NULL.
	 *
	 * @return class array
	 */
	Class<?>[] sources();

	/**
	 * Returns an array of classes and interfaces to be assignable from any
	 * object produced by this factory. Factory will NOT recieve creation
	 * request for a class not declared (and not assignable from any declared
	 * classes) by this method. Use more specific types here. Factory MUST
	 * return same or equal array on every call. It's recommended to use
	 * something like static constant variable to return in this method because
	 * some registry factory implementations may call this method frequently.
	 *
	 * @return class array
	 */
	Class<?>[] targets();

	/**
	 * Returns an array of type names accepted by this factory. Factory will NOT
	 * recieve creation request for a type not declared by this method. Factory
	 * MUST return same or equal array on every call. It's recommended to use
	 * something like static constant variable to return in this method because
	 * some registry factory implementations may call this method frequently.
	 *
	 * @return string array
	 */
	String[] variety();
}
