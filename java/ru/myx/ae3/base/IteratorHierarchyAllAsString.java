package ru.myx.ae3.base;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

final class IteratorHierarchyAllAsString implements Iterator<String> {
	
	private final Set<String>					known;
	
	private Iterator<? extends CharSequence>	currentIterator;
	
	private BaseObject						nextObject;
	
	private String								key;
	
	IteratorHierarchyAllAsString(final Iterator<? extends CharSequence> iterator, final BaseObject prototype) {
		assert iterator != null : "Should not be NULL";
		assert iterator.hasNext() : "Should not be empty!";
		this.known = new TreeSet<>();
		this.currentIterator = iterator;
		this.nextObject = prototype;
		this.key = String.valueOf( iterator.next() );
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
				{
					this.key = String.valueOf( this.currentIterator.next() );
				}
				if (!this.known.contains( this.key )) {
					break;
				}
				continue;
			}
			if (this.nextObject == null) {
				this.key = null;
				break;
			}
			this.currentIterator = this.nextObject.baseKeysOwnAll();
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
