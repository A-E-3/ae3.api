/*
 * Created on 01.12.2005
 */
package ru.myx.ae3.flow;

import java.util.function.Consumer;

import ru.myx.ae3.report.Report;

/** @author myx
 *
 * @param <T> */
public interface ObjectTarget<T> extends Consumer<T> {

	/** Dummy target. Can be used anywhere ;) Absorb method returns <b>true </b> value to exhaust
	 * any source. */
	public static final ObjectTarget<Object> NUL_TARGET = new NulTarget();

	/** @param object
	 * @return boolean
	 * @throws FlowOperationException */
	boolean absorb(final T object) throws FlowOperationException;

	@Override
	@Deprecated
	default void accept(final T t) {

		try {
			this.absorb(t);
		} catch (final Exception e) {
			Report.exception("ae3.flow.ObjectTarget", "uncaught exception ignored", e);
		}

	}

	/** Returns base class that this target is able to absorb, i.e. Object.class if any kinds of
	 * object are acceptable.
	 *
	 * @return class */
	@SuppressWarnings("unchecked")
	default Class<? extends T> accepts() {
		
		return (Class<T>) Object.class;
	}

	/**
	 *
	 */
	default void close() {

		// empty
	}
}
