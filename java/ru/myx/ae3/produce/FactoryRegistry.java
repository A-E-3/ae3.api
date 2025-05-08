/*
 * Created on 27.05.2003
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package ru.myx.ae3.produce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.flow.ObjectSource;
import ru.myx.ae3.flow.ObjectTarget;

/** !!! remove this class - copy routines to 'Produce', just another level of indirection
 *
 * @author myx
 *
 *         To change the template for this generated type comment go to Window>Preferences>Java>Code
 *         Generation>Code and Comments */
final class FactoryRegistry {

	private final List<ObjectFactory<?, ?>> factories = new ArrayList<>();

	private final Set<ObjectFactory<?, ?>> all = new HashSet<>();

	private final Map<Class<?>, FactoryGroup> byClass = new HashMap<>(128, 0.5f);

	private final void register(final Class<?> cls, final ObjectFactory<?, ?> factory) {

		final FactoryGroup group = this.byClass.get(cls);
		if (group == null) {
			this.byClass.put(cls, new ExactWrapper(factory));
		} else {
			if (group.type() == FactoryGroup.GROUP) {
				group.add(factory);
			} else {
				this.byClass.put(cls, new ClassFactory(((ExactWrapper) group).factory, factory));
			}
		}
		final Class<?>[] interfaces = cls.getInterfaces();
		for (int i = interfaces.length - 1; i >= 0; --i) {
			if (interfaces[i] != cls) {
				this.register(interfaces[i], factory);
			}
		}
		final Class<?> parent = cls.getSuperclass();
		if (parent != null && parent != cls) {
			this.register(parent, factory);
		}
	}

	@Override
	public final String toString() {

		return "ae2core-performance factory registry";
	}

	/** @param target
	 * @param type
	 * @param attributes
	 * @param context
	 * @return object */
	final Object create(final Class<?> target, final String type, final BaseObject attributes, final Object context) {

		final FactoryGroup factory = this.byClass.get(target);
		if (factory == null) {
			return null;
		}

		return factory.produce(
				type,
				attributes,
				context == null
					? null
					: context.getClass(),
				context);
	}

	/** @param target
	 * @param type
	 * @param attributes
	 * @param context
	 * @return factory */
	ObjectFactory<?, ?> factory(final Class<?> target, final String type, final BaseObject attributes, final Class<?> context) {

		final FactoryGroup factory = this.byClass.get(target);
		if (factory == null) {
			return null;
		}

		return factory.factory(type, attributes, context);
	}

	/** @param factory */
	final void register(final ObjectFactory<?, ?> factory) {

		synchronized (this) {
			if (this.all.add(factory)) {
				this.factories.add(factory);
				final Class<?>[] classes = factory.targets();
				if (classes == null || classes.length == 0) {
					throw new NullPointerException("Factory [" + factory.getClass().getName() + ": " + factory.toString() + "] has no classes to be created!");
				}
				boolean hasClass = false;
				for (int i = classes.length - 1; i >= 0; --i) {
					this.register(classes[i], factory);
					if (!classes[i].isInterface()) {
						hasClass = true;
					}
				}
				if (!hasClass) {
					this.register(Object.class, factory);
				}
			}
		}
	}

	/** @param target
	 * @param type
	 * @param attributes
	 * @param context
	 * @return source */
	final ObjectSource<?> sourcePrepared(final Class<?> target, final String type, final BaseObject attributes, final Object context) {

		final FactoryGroup factory = this.byClass.get(target);
		if (factory == null) {
			return null;
		}

		return factory.prepare(
				type,
				attributes,
				context == null
					? null
					: context.getClass(),
				context);
	}

	/** @param target
	 * @param type
	 * @param attributes
	 * @param sourceClass
	 * @param chain
	 * @return target */
	final ObjectTarget<?> targetConnected(final Class<?> target, final String type, final BaseObject attributes, final Class<?> sourceClass, final ObjectTarget<?> chain) {

		final FactoryGroup factory = this.byClass.get(target);
		if (factory == null) {
			return null;
		}

		@SuppressWarnings("unchecked")
		final ObjectTarget<Object> targetChain = (ObjectTarget<Object>) chain;

		return factory.connect(type, attributes, sourceClass, targetChain);
	}
}
