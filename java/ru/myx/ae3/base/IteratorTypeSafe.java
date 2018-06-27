package ru.myx.ae3.base;

import java.util.Iterator;

final class IteratorTypeSafe implements Iterator<String> {
	
	private final Iterator<?>	iterator;
	
	IteratorTypeSafe(final Iterator<?> iterator) {
		assert iterator != null : "Should not be NULL";
		assert iterator.hasNext() : "Should not be empty!";
		this.iterator = iterator;
	}
	
	@Override
	public boolean hasNext() {
		return this.iterator.hasNext();
	}
	
	@Override
	public String next() {
		final Object next = this.iterator.next();
		return next == null
				? null
				: String.valueOf( next );
	}
	
	@Override
	public void remove() {
		this.iterator.remove();
	}
}
