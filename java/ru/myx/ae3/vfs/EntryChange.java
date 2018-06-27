package ru.myx.ae3.vfs;

import ru.myx.ae3.binary.TransferCopier;
import ru.myx.ae3.common.Value;

public interface EntryChange {
	
	/**
	 * Makes given entry to be a binary. Equivalent to:
	 * 
	 * <pre>
	 * entry.getParent().toContainer().setContentBinary(entry.getKey(), entry.getMode(), binary)
	 * </pre>
	 * 
	 * @param binary
	 * @return
	 */
	Value<Boolean> doSetBinary(TransferCopier binary);
	
	/**
	 * Makes given entry to be collection. Equivalent to:
	 * 
	 * <pre>
	 * entry.getParent().toContainer().setContentContainer(entry.getKey(), entry.getMode())
	 * </pre>
	 * 
	 * @return
	 */
	Value<Boolean> doSetContainer();
	
	/**
	 * Changes last-modified date of given entry.
	 * 
	 * @param lastModified
	 * @return
	 */
	Value<Boolean> doSetLastModified(long lastModified);
	
	/**
	 * Makes given entry to be a primitive. Not every value can be primitive.
	 * Applicable only to values that can be stored in-line. Equivalent to:
	 * 
	 * <pre>
	 * entry.getParent().toContainer().setContentPrimitive(entry.getKey(), entry.getMode(), primitive)
	 * </pre>
	 * 
	 * @param primitive
	 * @return
	 */
	Value<Boolean> doSetPrimitive(Object primitive);
	
	/**
	 * 
	 * @param primitive
	 * @return
	 */
	default Value<Boolean> doSetDate(Object primitive) {
		
		return this.doSetPrimitive(primitive);
	}
	
	/**
	 * 
	 * @param primitive
	 * @return
	 */
	default Value<Boolean> doSetString(Object primitive) {
		
		return this.doSetPrimitive(primitive);
	}
	
	/**
	 * 
	 * @param primitive
	 * @return
	 */
	default Value<Boolean> doSetNumber(Object primitive) {
		
		return this.doSetPrimitive(primitive);
	}
	
	/**
	 * 
	 * @param primitive
	 * @return
	 */
	default Value<Boolean> doSetBoolean(Object primitive) {
		
		return this.doSetPrimitive(primitive);
	}
	
	/**
	 * Makes given entry to be a binary. Equivalent to:
	 * 
	 * <pre>
	 * entry.getParent().toContainer().setContentText(entry.getKey(), entry.getMode(), text)
	 * </pre>
	 * 
	 * @param text
	 * @return
	 */
	Value<Boolean> doSetText(CharSequence text);
	
	/**
	 * Makes given entry to contain a value. Equivalent to:
	 * 
	 * <pre>
	 * entry.getParent().toContainer().setContentValue(entry.getKey(), entry.getMode())
	 * </pre>
	 * 
	 * @param value
	 * @return
	 */
	Value<Boolean> doSetValue(Object value);
}
