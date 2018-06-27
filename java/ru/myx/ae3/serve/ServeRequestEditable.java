/*
 * Created on 24.03.2006
 */
package ru.myx.ae3.serve;

import java.util.function.Function;

import ru.myx.ae3.answer.ReplyAnswer;
import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseMessageEditable;
import ru.myx.ae3.base.BaseObject;

/** @author myx
 * @param <T> */
public interface ServeRequestEditable<T extends ServeRequestEditable<?>> extends ServeRequest, BaseMessageEditable<T> {
	
	/** Returns the SAME request object. It is recommended to use this method while setting
	 * attributes to a "abstract" request because it is legal to return unmodifiable Map<?,?> via
	 * getAttributes() method call while this method guarantees at least not to throw an exception.
	 * Throws NullPointerException when attribute value is <b>NULL </b>.
	 *
	 * @param name
	 * @param value
	 *
	 * @return same request */
	@Override
	T addParameter(String name, BaseObject value);

	/** Returns the SAME request object. It is recommended to use this method while setting
	 * attributes to a "abstract" request because it is legal to return unmodifiable Map<?,?> via
	 * getAttributes() method call while this method guarantees at least not to throw an exception.
	 *
	 * @param name
	 * @param value
	 *
	 * @return same request */
	@Override
	default T addParameter(final String name, final double value) {

		return this.addParameter(name, Base.forDouble(value));
	}

	/** Returns the SAME request object. It is recommended to use this method while setting
	 * attributes to a "abstract" request because it is legal to return unmodifiable Map<?,?> via
	 * getAttributes() method call while this method guarantees at least not to throw an exception.
	 *
	 * @param name
	 * @param value
	 *
	 * @return same request */
	@Override
	default T addParameter(final String name, final long value) {

		return this.addParameter(name, Base.forLong(value));
	}

	/** Returns the SAME request object. It is recommended to use this method while setting
	 * attributes to a "abstract" request because it is legal to return unmodifiable Map<?,?> via
	 * getAttributes() method call while this method guarantees at least not to throw an exception.
	 * Throws NullPointerException when attribute value is <b>NULL </b>.
	 *
	 * @param name
	 * @param value
	 *
	 * @return same request */
	@Override
	default T addParameter(final String name, final Object value) {

		return this.addParameter(name, Base.forUnknown(value));
	}

	/** Returns the SAME request object. It is recommended to use this method while setting
	 * attributes to a "abstract" request because it is legal to return unmodifiable Map<?,?> via
	 * getAttributes() method call while this method guarantees at least not to throw an exception.
	 *
	 * @param name
	 * @param value
	 *
	 * @return same request */
	@Override
	default T addParameter(final String name, final String value) {

		return this.addParameter(name, Base.forString(value));
	}

	/** Returns the SAME request object.
	 *
	 * @param language
	 *
	 * @return same request */
	@Override
	T setLanguage(String language);

	/** Returns the SAME request object. It is recommended to use this method while setting
	 * attributes to a "abstract" request because it is legal to return unmodifiable Map<?,?> via
	 * getAttributes() method call while this method guarantees at least not to throw an exception.
	 *
	 * @param date
	 *
	 * @return same request */
	@Override
	T setLastModified(long date);

	/** Returns the SAME request object. It is recommended to use this method while setting
	 * attributes to a "abstract" request because it is legal to return unmodifiable Map<?,?> via
	 * getAttributes() method call while this method guarantees at least not to throw an exception.
	 * <p>
	 * Throws NullPointerException when attribute value is <b>NULL </b>.
	 *
	 * @param name
	 * @param value
	 *
	 * @return same request */
	@Override
	T setParameter(String name, BaseObject value);

	/** Returns the SAME request object. It is recommended to use this method while setting
	 * attributes to a "abstract" request because it is legal to return unmodifiable Map<?,?> via
	 * getAttributes() method call while this method guarantees at least not to throw an exception.
	 *
	 * @param name
	 * @param value
	 *
	 * @return same request */
	@Override
	default T setParameter(final String name, final double value) {

		return this.setParameter(name, Base.forDouble(value));
	}

	/** Returns the SAME request object. It is recommended to use this method while setting
	 * attributes to a "abstract" request because it is legal to return unmodifiable Map<?,?> via
	 * getAttributes() method call while this method guarantees at least not to throw an exception.
	 *
	 * @param name
	 * @param value
	 *
	 * @return same request */
	@Override
	default T setParameter(final String name, final long value) {

		return this.setParameter(name, Base.forLong(value));
	}

	/** Returns the SAME request object. It is recommended to use this method while setting
	 * attributes to a "abstract" request because it is legal to return unmodifiable Map<?,?> via
	 * getAttributes() method call while this method guarantees at least not to throw an exception.
	 * <p>
	 * Throws NullPointerException when attribute value is <b>NULL </b>.
	 *
	 * @param name
	 * @param value
	 *
	 * @return same request */
	@Override
	default T setParameter(final String name, final Object value) {
		
		return this.setParameter(name, Base.forUnknown(value));
	}

	/** Returns the SAME request object. It is recommended to use this method while setting
	 * attributes to a "abstract" request because it is legal to return unmodifiable Map<?,?> via
	 * getAttributes() method call while this method guarantees at least not to throw an exception.
	 *
	 * @param name
	 * @param value
	 *
	 * @return same request */
	@Override
	default T setParameter(final String name, final String value) {

		return this.setParameter(name, Base.forString(value));
	}

	/** Returns the SAME request object. It is recommended to use this method while setting
	 * parameters to a "abstract" request because it is legal to return unmodifiable Map<?,?> via
	 * getParameters() method call while this method guarantees at least not to throw an exception.
	 *
	 * @param parameters
	 *
	 * @return same request */
	@Override
	T setParameters(BaseObject parameters);

	/** Returns the SAME request object.
	 *
	 * @param resourceIdentifier
	 *
	 * @return same request */
	@Override
	T setResourceIdentifier(String resourceIdentifier);

	/** Returns the SAME request object.
	 *
	 * @param resourcePrefix
	 *
	 * @return same request */
	@Override
	T setResourcePrefix(String resourcePrefix);

	/** Returns the SAME request object.
	 *
	 * @param responseClass
	 *
	 * @return same request */
	@Override
	T setResponseClass(Class<?> responseClass);

	/** Returns the SAME request object.
	 *
	 * @param responseTarget
	 *
	 * @return same request */
	@Override
	T setResponseTarget(Function<ReplyAnswer, Boolean> responseTarget);

	/** Returns the SAME request object.
	 *
	 * @param settings
	 *
	 * @return same request */
	@Override
	T setSettings(BaseObject settings);

	/** Returns the SAME request object.
	 *
	 * @param sourceAddress
	 *
	 * @return same request */
	@Override
	T setSourceAddress(String sourceAddress);

	/** Returns the SAME request object.
	 *
	 * @param sourceAddressExact
	 *
	 * @return same request */
	@Override
	T setSourceAddressExact(final String sourceAddressExact);

	/** @param target
	 * @return same request */
	@Override
	T setTarget(String target);

	/** @param targetExact
	 * @return same request */
	@Override
	T setTargetExact(String targetExact);

	/** Returns the SAME request object.
	 *
	 * @param url
	 *
	 * @return same request */
	@Override
	T setUrl(String url);

	/** Returns the SAME request object.
	 *
	 * @param urlBase
	 *
	 * @return same request */
	@Override
	T setUrlBase(String urlBase);

	/** Returns the SAME request object.
	 *
	 * @param verb
	 *
	 * @return same request */
	@Override
	T setVerb(String verb);

	/** Returns the SAME request object.
	 *
	 * @param characters
	 * @param shiftBase
	 *
	 * @return same request */
	@Override
	T shiftRequested(int characters, boolean shiftBase);
	
}
