package ru.myx.ae3.base;

import java.util.IdentityHashMap;
import java.util.Iterator;

/**
 * Not public - use Base.joinPropertyIterators - does it better!
 * 
 * @author myx
 */
final class IteratorSequenceAnyPrimitive implements Iterator<BasePrimitive<?>> {
	
	private final IdentityHashMap<BasePrimitive<?>, Boolean>	known;
	
	private Iterator<? extends BasePrimitive<?>>				currentIterator;
	
	private Iterator<? extends BasePrimitive<?>>				nextIterator;
	
	private BasePrimitive<?>									key;
	
	/**
	 * @param iterator
	 * @param next
	 */
	IteratorSequenceAnyPrimitive(final Iterator<? extends BasePrimitive<?>> iterator,
			final Iterator<? extends BasePrimitive<?>> next) {
		assert iterator != null : "Should not be NULL";
		assert iterator.hasNext() : "Should not be empty!";
		this.known = new IdentityHashMap<>();
		this.currentIterator = iterator;
		this.nextIterator = next;
		this.key = iterator.next();
	}
	
	@Override
	public boolean hasNext() {
		return this.key != null;
	}
	
	@Override
	public BasePrimitive<?> next() {
		final BasePrimitive<?> key = this.key;
		this.known.put( key, Boolean.TRUE );
		for (;;) {
			if (this.currentIterator.hasNext()) {
				this.key = this.currentIterator.next();
				if (null == this.known.get( this.key )) {
					break;
				}
				continue;
			}
			if (this.nextIterator == null) {
				this.key = null;
				break;
			}
			this.currentIterator = this.nextIterator;
			this.nextIterator = null;
		}
		return key;
	}
	
	@Override
	public void remove() {
		// read-only
	}
}
