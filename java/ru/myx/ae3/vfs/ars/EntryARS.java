package ru.myx.ae3.vfs.ars;

import ru.myx.ae3.base.BaseArray;
import ru.myx.ae3.base.BaseFunction;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.base.BasePrimitiveBoolean;
import ru.myx.ae3.common.Value;
import ru.myx.ae3.know.Guid;
import ru.myx.ae3.vfs.Entry;

/**
 * @author myx
 * 
 * 
 *         TODO: unfinished
 *
 * @param <O>
 * @param <R>
 */
public interface EntryARS<O extends ArsRecord, R extends ArsReference<O>> extends Entry {
	
	/**
	 * 
	 * @param reference
	 * @param value
	 * @return
	 */
	Value<Void> doSetReferenceGuid(
			Guid reference,
			Guid value);
	
	
	/**
	 * 
	 * @param reference
	 * @param value
	 * @return
	 */
	Value<Void> doSetReferenceValue(
			Guid reference,
			Object value);
	
	
	/**
	 * Returns entry key in it's original native form. Returns NULL when this
	 * entry is a root entry.
	 * 
	 * 
	 * @return
	 */
	Guid getKeyGuid();
	
	
	/**
	 * Returns entry key in it's original native form. Returns NULL when this
	 * entry is a root entry.
	 * 
	 * 
	 * @return
	 */
	O getKeyOriginal();
	
	
	/**
	 * 
	 * @param reference
	 * @return
	 */
	Value<EntryARS> getReferenceAsEntry(
			Guid reference);
	
	
	/**
	 * 
	 * @return
	 */
	Guid getSourceGuid();
	
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @param callBack
	 *            return false to stop, true to continue
	 * @param thisObject
	 * @return
	 */
	Value<Void> iterateEach(
			Guid start,
			Guid end,
			BaseFunction callBack,
			BaseObject thisObject);
	
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @param callBack
	 * @param thisObject
	 * @return
	 */
	Value<BasePrimitiveBoolean> iterateEvery(
			Guid start,
			Guid end,
			BaseFunction callBack,
			BaseObject thisObject);
	
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @param callBack
	 * @param thisObject
	 * @return
	 */
	Value<BaseArray> iterateFilter(
			Guid start,
			Guid end,
			BaseFunction callBack,
			BaseObject thisObject);
	
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @param callBack
	 * @param thisObject
	 * @return
	 */
	Value<BaseArray> iterateMap(
			Guid start,
			Guid end,
			BaseFunction callBack,
			BaseObject thisObject);
	
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @param callBack
	 * @param initialValue
	 * @return
	 */
	Value<BaseObject> iterateReduce(
			Guid start,
			Guid end,
			BaseFunction callBack,
			BaseObject initialValue);
	
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @param callBack
	 * @param initialValue
	 * @return
	 */
	Value<BaseObject> iterateReduceRight(
			Guid start,
			Guid end,
			BaseFunction callBack,
			BaseObject initialValue);
	
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @param callBack
	 * @param thisObject
	 * @return
	 */
	Value<BasePrimitiveBoolean> iterateSome(
			Guid start,
			Guid end,
			BaseFunction callBack,
			BaseObject thisObject);
}
