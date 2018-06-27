package ru.myx.ae3.base;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

@ReflectionDisable
final class SealedEmptyArray implements BaseListNoOwnProperties<Object> {
	
	
	@Override
	public int baseInsert(final int index, final BaseObject value) {
		
		
		throw new UnsupportedOperationException("Read-Only array");
	}

	static final SealedEmptyArray INSTANCE = new SealedEmptyArray();

	private static final Object[] NULL_ARRAY = new Object[0];

	private SealedEmptyArray() {
		
		//
	}

	@Override
	public void add(final int arg0, final Object arg1) {
		
		
		throw new UnsupportedOperationException("Read-Only array");
	}

	@Override
	public boolean add(final Object arg0) {
		
		
		return false;
	}

	@Override
	public boolean addAll(final Collection<? extends Object> arg0) {
		
		
		return false;
	}

	@Override
	public boolean addAll(final int arg0, final Collection<? extends Object> arg1) {
		
		
		return false;
	}

	/**
	 * Not really dynamic
	 */
	@SuppressWarnings("deprecation")
	@Override
	public SealedEmptyArray baseArrayDynamic() {
		
		
		return null;
	}

	/**
	 * Not really dynamic
	 */
	@SuppressWarnings("deprecation")
	@Override
	public SealedEmptyArray baseArrayWritable() {
		
		
		return null;
	}

	@Override
	public String baseClass() {
		
		
		return "Array";
	}

	@Override
	public boolean baseContains(final BaseObject value) {
		
		
		return false;
	}

	@Override
	public BaseObject baseDefaultPop() {
		
		
		return BaseObject.UNDEFINED;
	}

	@Override
	public int baseDefaultPush(final BaseObject value) {
		
		
		return 0;
	}

	@Override
	public SealedEmptyArray baseDefaultReverse() {
		
		
		return this;
	}

	@Override
	public BaseObject baseDefaultShift() {
		
		
		return BaseObject.UNDEFINED;
	}

	@Override
	public BaseArray baseDefaultSplice(final int start, final int count, final BaseObject[] values) {
		
		
		return Base.forArray(values);
	}

	@Override
	public int baseDefaultUnshift(final BaseObject value) {
		
		
		return 0;
	}

	@Override
	public int baseDefaultUnshift(final BaseObject[] values) {
		
		
		return 0;
	}

	@Override
	public BaseObject baseGet(final int index, final BaseObject defaultValue) {
		
		
		return defaultValue;
	}

	@Override
	public ExecStateCode vmPropertyRead(final ExecProcess ctx, final int index, final BaseObject originalIfKnown, final BaseObject defaultValue, final ResultHandler store) {
		
		
		return store.execReturn(ctx, defaultValue);
	}

	@Override
	public BaseObject baseGetFirst(final BaseObject defaultValue) {
		
		
		return defaultValue;
	}

	@Override
	public BaseObject baseGetLast(final BaseObject defaultValue) {
		
		
		return defaultValue;
	}

	@Override
	public Iterator<? extends BaseObject> baseIterator() {
		
		
		return BaseObject.ITERATOR_EMPTY_PRIMITIVE;
	}

	@Override
	public BaseObject baseRemove(final int index) {
		
		
		return BaseObject.UNDEFINED;
	}

	@Override
	public boolean baseSet(final int index, final BaseObject value) {
		
		
		return false;
	}

	@Override
	@ReflectionHidden
	public BaseArrayAdvanced<?> baseArraySlice(final int start) {
		
		
		return BaseObject.createArray(0);
	}

	@Override
	@ReflectionHidden
	public BaseArrayAdvanced<?> baseArraySlice(final int start, final int end) {
		
		
		return BaseObject.createArray(0);
	}

	@Override
	public String toString() {
		
		
		return "[array SealedEmpty]";
	}

	@Override
	public SealedEmptyArray baseValue() {
		
		
		return this;
	}

	@Override
	public void clear() {
		
		
		// ignore
	}

	@Override
	public boolean contains(final Object arg0) {
		
		
		return false;
	}

	@Override
	public boolean containsAll(final Collection<?> arg0) {
		
		
		return false;
	}

	@Override
	public boolean equals(final Object o) {
		
		
		/**
		 * supposed to have single instance
		 */
		return o == this;
	}

	@Override
	public Object get(final int i) {
		
		
		return null;
	}

	@Override
	public int hashCode() {
		
		
		return 0;
	}

	@Override
	public int indexOf(final Object arg0) {
		
		
		return -1;
	}

	@Override
	public boolean isEmpty() {
		
		
		return true;
	}

	@Override
	public Iterator<Object> iterator() {
		
		
		return Collections.emptyList().iterator();
	}

	@Override
	public int lastIndexOf(final Object arg0) {
		
		
		return -1;
	}

	@Override
	public int length() {
		
		
		return 0;
	}

	@Override
	public ListIterator<Object> listIterator() {
		
		
		return Collections.emptyList().listIterator();
	}

	@Override
	public ListIterator<Object> listIterator(final int arg0) {
		
		
		return Collections.emptyList().listIterator(arg0);
	}

	@Override
	public Object remove(final int arg0) {
		
		
		return null;
	}

	@Override
	public boolean remove(final Object arg0) {
		
		
		return false;
	}

	@Override
	public boolean removeAll(final Collection<?> arg0) {
		
		
		return false;
	}

	@Override
	public boolean retainAll(final Collection<?> arg0) {
		
		
		return false;
	}

	@Override
	public Object set(final int arg0, final Object arg1) {
		
		
		throw new UnsupportedOperationException();
	}

	@Override
	public int size() {
		
		
		return 0;
	}

	@Override
	public List<Object> subList(final int arg0, final int arg1) {
		
		
		return this;
	}

	@Override
	public Object[] toArray() {
		
		
		return SealedEmptyArray.NULL_ARRAY;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(final T[] arg0) {
		
		
		return (T[]) (arg0 != null && arg0.length == 0
			? arg0
			: SealedEmptyArray.NULL_ARRAY);
	}
}
