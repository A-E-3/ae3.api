package ru.myx.ae3.base;

import java.util.Iterator;

final class IteratorTypeSafePrimitive implements Iterator<BasePrimitive<?>> {
	
	private final Iterator<?>	iterator;
	
	IteratorTypeSafePrimitive(final Iterator<?> iterator) {
		assert iterator != null : "Should not be NULL";
		assert iterator.hasNext() : "Should not be empty!";
		this.iterator = iterator;
	}
	
	@Override
	public boolean hasNext() {
		return this.iterator.hasNext();
	}
	
	@Override
	public BasePrimitive<?> next() {
		final Object next = this.iterator.next();
		return next == null
				? null
				: Base.forUnknown( next ).baseToPrimitive( null );
	}
	
	@Override
	public void remove() {
		this.iterator.remove();
	}
}
