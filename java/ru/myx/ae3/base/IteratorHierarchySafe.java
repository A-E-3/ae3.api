package ru.myx.ae3.base;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

final class IteratorHierarchySafe implements Iterator<String> {
	
	private final Set<String>	known;
	
	private Iterator<?>			currentIterator;
	
	private BaseObject		nextObject;
	
	private String				key;
	
	IteratorHierarchySafe(final Iterator<?> iterator, final BaseObject prototype) {
		assert iterator != null : "Should not be NULL";
		assert iterator.hasNext() : "Should not be empty!";
		this.known = new TreeSet<>();
		this.currentIterator = iterator;
		this.nextObject = prototype;
		
		final Object key = iterator.next();
		this.key = String.valueOf( key );
	}
	
	@Override
	public boolean hasNext() {
		return this.key != null;
	}
	
	@Override
	public String next() {
		final String key = this.key;
		this.known.add( key );
		for (;;) {
			if (this.currentIterator.hasNext()) {
				final String keyNew = String.valueOf( this.currentIterator.next() );
				this.key = keyNew;
				if (!this.known.contains( keyNew )) {
					break;
				}
				continue;
			}
			if (this.nextObject == null) {
				this.key = null;
				break;
			}
			this.currentIterator = this.nextObject.baseKeysOwn();
			assert this.currentIterator != null : "NULL iterator - use BaseObject.ITERATOR_EMPTY, class="
					+ this.nextObject.getClass().getName();
			this.nextObject = this.nextObject.basePrototype();
		}
		return key;
	}
	
	@Override
	public void remove() {
		// read-only
	}
}
