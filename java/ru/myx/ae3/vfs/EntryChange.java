package ru.myx.ae3.vfs;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.binary.TransferCopier;
import ru.myx.ae3.common.Value;
import ru.myx.ae3.know.Guid;
import ru.myx.ae3.reflect.ReflectionExplicit;
import ru.myx.ae3.reflect.ReflectionManual;

/** @author myx */
@ReflectionManual
public interface EntryChange {
	
	/** Makes given entry to be a binary. Equivalent to:
	 *
	 * <pre>
	 * entry.getParent().toContainer().setContentBinary(entry.getKey(), entry.getMode(), binary)
	 * </pre>
	 *
	 * @param binary
	 * @return */
	@ReflectionExplicit
	Value<Boolean> doSetBinary(TransferCopier binary);
	
	/** @param primitive
	 * @return */
	@ReflectionExplicit
	default Value<Boolean> doSetBoolean(final Object primitive) {
		
		return this.doSetPrimitive(primitive);
	}
	
	/** Makes given entry to be collection. Equivalent to:
	 *
	 * <pre>
	 * entry.getParent().toContainer().setContentContainer(entry.getKey(), entry.getMode())
	 * </pre>
	 *
	 * @return */
	@ReflectionExplicit
	Value<Boolean> doSetContainer();
	
	/** @param primitive
	 * @return */
	@ReflectionExplicit
	default Value<Boolean> doSetDate(final Object primitive) {
		
		return this.doSetPrimitive(primitive);
	}
	
	/** Changes last-modified date of given entry.
	 *
	 * @param lastModified
	 * @return */
	@ReflectionExplicit
	Value<Boolean> doSetLastModified(long lastModified);
	
	/** @param primitive
	 * @return */
	@ReflectionExplicit
	default Value<Boolean> doSetNumber(final Object primitive) {
		
		return this.doSetPrimitive(primitive);
	}
	
	/** Makes given entry to be a primitive. Not every value can be primitive. Applicable only to
	 * values that can be stored in-line. Equivalent to:
	 *
	 * <pre>
	 * entry.getParent().toContainer().setContentPrimitive(entry.getKey(), entry.getMode(), primitive)
	 * </pre>
	 *
	 * @param primitive
	 * @return */
	@ReflectionExplicit
	Value<Boolean> doSetPrimitive(Object primitive);
	
	/** @param primitive
	 * @return */
	@ReflectionExplicit
	default Value<Boolean> doSetString(final Object primitive) {
		
		return this.doSetPrimitive(primitive);
	}
	
	/** Makes given entry to be a binary. Equivalent to:
	 *
	 * <pre>
	 * entry.getParent().toContainer().setContentText(entry.getKey(), entry.getMode(), text)
	 * </pre>
	 *
	 * @param text
	 * @return */
	@ReflectionExplicit
	Value<Boolean> doSetText(CharSequence text);
	
	/** Makes given entry to contain a value. Equivalent to:
	 *
	 * <pre>
	 * entry.getParent().toContainer().setContentValue(entry.getKey(), entry.getMode())
	 * </pre>
	 *
	 * @param value
	 * @return */
	@ReflectionExplicit
	default Value<Boolean> doSetValue(final Object value) {
		
		if (value == BaseObject.UNDEFINED || value == null) {
			return this.doUnlink();
		}
		if (value instanceof CharSequence) {
			return this.doSetText((CharSequence) value);
		}
		if (value instanceof TransferCopier) {
			return this.doSetBinary((TransferCopier) value);
		}

		final Guid guid = value instanceof Guid
			? (Guid) value
			: Guid.forUnknown(value);
		if (guid != null && guid.isInline()) {
			return this.doSetPrimitive(guid);
		}

		throw new IllegalArgumentException("Don't know how to store, class: " + value.getClass().getName());
	}
	
	/** Unlinks given entry. Equivalent to:
	 *
	 * <pre>
	 * entry.getParent().toContainer().setContentUndefined(entry.getKey())
	 * </pre>
	 *
	 * @return */
	@ReflectionExplicit
	Value<Boolean> doUnlink();
}
