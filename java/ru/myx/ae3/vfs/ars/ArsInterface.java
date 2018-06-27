package ru.myx.ae3.vfs.ars;

import ru.myx.ae3.binary.TransferCopier;
import ru.myx.ae3.common.Value;
import ru.myx.ae3.know.Guid;
import ru.myx.ae3.vfs.TreeLinkType;
import ru.myx.ae3.vfs.TreeReadType;

/**
 * 
 * @author myx
 * 
 * @param <O>
 * @param <R>
 * @param <A>
 */
public interface ArsInterface<O extends ArsRecord, R extends ArsReference<O>, A extends ArsArray<R>> {
	/**
	 * @param copier
	 * @return
	 */
	O createBinaryTemplate(
			TransferCopier copier);
	
	
	/**
	 * Can return NULL for read-only storages!
	 * 
	 * @return
	 */
	O createContainerTemplate();
	
	
	/**
	 * Can NOT ever return NULL!
	 * 
	 * @param key
	 * @return
	 */
	O createKeyForString(
			String key);
	
	
	/**
	 * @param guid
	 * @param transaction
	 * @return
	 */
	O createPrimitiveTemplate(
			Guid guid);
	
	
	/**
	 * @param key
	 * @param mode
	 * @param original
	 * @return
	 */
	R createReferenceTemplate(
			O key,
			TreeLinkType mode,
			R original);
	
	
	/**
	 * @param text
	 * @return
	 */
	O createTextTemplate(
			CharSequence text);
	
	
	/**
	 * @return
	 * @throws Exception
	 */
	ArsTransaction<O, R, A> createTransaction() throws Exception;
	
	
	/**
	 * @param template
	 *            - can be NULL easily, real existing template can be used as a
	 *            hint to driver, which can reorder some operations and
	 *            assumptions to speed-up process
	 * @param object
	 * @param key
	 * @param mode
	 * @return
	 */
	Value<R> doLinkDelete(
			R template,
			O object,
			O key,
			TreeLinkType mode);
	
	
	/**
	 * @param template
	 *            - can be NULL easily, real existing template can be used as a
	 *            hint to driver, which can reorder some operations and
	 *            assumptions to speed-up process
	 * @param object
	 * @param key
	 * @param newObject
	 * @param newKey
	 * @param mode
	 * @param modified
	 * @param target
	 * @param transaction
	 * @return
	 */
	Value<R> doLinkMoveRename(
			R template,
			O object,
			O key,
			O newObject,
			O newKey,
			TreeLinkType mode,
			long modified,
			O target);
	
	
	/**
	 * @param template
	 *            - can be NULL easily, real existing template can be used as a
	 *            hint to driver, which can reorder some operations and
	 *            assumptions to speed-up process
	 * @param object
	 * @param key
	 * @param newKey
	 * @param mode
	 * @param modified
	 * @param target
	 * @param transaction
	 * @return
	 */
	Value<R> doLinkRename(
			R template,
			O object,
			O key,
			O newKey,
			TreeLinkType mode,
			long modified,
			O target);
	
	
	/**
	 * @param template
	 *            - can be NULL easily, real existing template can be used as a
	 *            hint to driver, which can reorder some operations and
	 *            assumptions to speed-up process. When not null it is an
	 *            'existing' object's reference or 'new' object's template.
	 *            NULL-able only for objects whose existence is under question.
	 * @param object
	 * @param key
	 * @param mode
	 * @param modified
	 * @param target
	 * @param transaction
	 * @return
	 */
	Value<R> doLinkSet(
			R template,
			O object,
			O key,
			TreeLinkType mode,
			long modified,
			O target);
	
	
	/**
	 * @param object
	 * @param transaction
	 * @return
	 */
	Value<? extends TransferCopier> getBinary(
			O object);
	
	
	/**
	 * @param object
	 * @param mode
	 *            - default mode to use when given reference doesn't exist. Use
	 *            NULL value to get NULL result for not existing references.
	 * @param key
	 * @param transaction
	 * @return
	 */
	Value<R> getLink(
			O object,
			O key,
			TreeLinkType mode);
	
	
	/**
	 * TODO: eliminate and replace with one or several 'getLinksRange' calls
	 * 
	 * @param object
	 * @param mode
	 * @param transaction
	 * @return
	 */
	Value<A> getLinks(
			O object,
			TreeReadType mode);
	
	
	/**
	 * @param object
	 * @param keyStart
	 * @param keyStop
	 * @param limit
	 * @param backwards
	 * @param mode
	 * @param transaction
	 * @return
	 */
	Value<A> getLinksRange(
			O object,
			O keyStart,
			O keyStop,
			int limit,
			boolean backwards,
			TreeReadType mode);
	
	
	/**
	 * @param object
	 * @param transaction
	 * @return
	 */
	Value<? extends CharSequence> getText(
			O object);
	
	
	/**
	 * Just a sign that history is supported by this impl. In some cases we may
	 * want to check whether history is supported in some important mounts when
	 * they are not read-only and wrap with 'SimpleHistorySupportWrapper' or so.
	 * 
	 * @return
	 */
	boolean isHistorySupported();
	
	
	/**
	 * @return whether this storage is globally read-only
	 */
	boolean isReadOnly();
}
