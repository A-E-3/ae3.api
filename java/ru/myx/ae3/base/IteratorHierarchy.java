package ru.myx.ae3.base;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

final class IteratorHierarchy implements Iterator<String> {
	
	
	private final Set<String> known;
	
	private Iterator<String> currentIterator;
	
	private BaseObject nextObject;
	
	private String key;
	
	IteratorHierarchy(final BaseObject initial, final Iterator<String> iterator, final BaseObject prototype) {
		assert iterator != null : "Should not be NULL";
		assert iterator.hasNext() : "Should not be empty!";
		this.known = new TreeSet<>();
		this.currentIterator = iterator;
		this.nextObject = prototype;
		
		{
			/**
			 * can't afford to loose it, tests are: TestIfInstanceVsCatchCast
			 */
			final Object keyObject = iterator.next();
			
			// don't know what to do with that yet
			assert keyObject != null : "NULL key, iterator class=" + iterator.getClass().getName() + ", initial object class=" + initial.getClass().getName() + "!";
			
			try {
				this.key = (String) keyObject;
			} catch (final ClassCastException e) {
				this.currentIterator = new IteratorTypeSafe(iterator);
				this.key = String.valueOf(keyObject);
			}
		}
	}
	
	@Override
	public boolean hasNext() {
		
		
		return this.key != null;
	}
	
	@Override
	public String next() {
		
		
		final String key = this.key;
		this.known.add(key);
		for (;;) {
			if (this.currentIterator.hasNext()) {
				{
					/**
					 * can't afford to loose it, tests are:
					 * TestIfInstanceVsCatchCast
					 */
					final Object keyObject = this.currentIterator.next();
					
					// don't know what to do with that yet
					assert keyObject != null : "NULL key, iterator class=" + this.currentIterator.getClass().getName();
					
					try {
						this.key = (String) keyObject;
					} catch (final ClassCastException e) {
						this.currentIterator = new IteratorTypeSafe(this.currentIterator);
						this.key = String.valueOf(keyObject);
					}
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
			this.currentIterator = this.nextObject.baseKeysOwn();
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
