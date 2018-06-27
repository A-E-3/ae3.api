package ru.myx.ae3.base;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

final class IteratorHierarchyAll implements Iterator<CharSequence> {
	
	
	private final Set<CharSequence> known;
	
	private Iterator<? extends CharSequence> currentIterator;
	
	private BaseObject nextObject;
	
	private CharSequence key;
	
	IteratorHierarchyAll(final Iterator<? extends CharSequence> iterator, final BaseObject prototype) {
		assert iterator != null : "Should not be NULL";
		assert iterator.hasNext() : "Should not be empty!";
		this.known = new TreeSet<>();
		this.currentIterator = iterator;
		this.nextObject = prototype;
		this.key = iterator.next();
		// don't know what to do with that yet
		assert this.key != null : "NULL key, iterator class=" + iterator.getClass().getName();
	}
	
	@Override
	public boolean hasNext() {
		
		
		return this.key != null;
	}
	
	@Override
	public CharSequence next() {
		
		
		final CharSequence key = this.key;
		this.known.add(key);
		for (;;) {
			if (this.currentIterator.hasNext()) {
				{
					this.key = this.currentIterator.next();
					// don't know what to do with that yet
					assert this.key != null : "NULL key, iterator class=" + this.currentIterator.getClass().getName();
				}
				if (!this.known.contains(this.key)) {
					break;
				}
				continue;
			}
			if (this.nextObject == null) {
				this.key = null;
				break;
			}
			this.currentIterator = this.nextObject.baseKeysOwnAll();
			assert this.currentIterator != null : "NULL iterator - use BaseObject.ITERATOR_EMPTY, class=" + this.nextObject.getClass().getName();
			this.nextObject = this.nextObject.basePrototype();
		}
		return key;
	}
	
	@Override
	public void remove() {
		
		
		// read-only
	}
}
