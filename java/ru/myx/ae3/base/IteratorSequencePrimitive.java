package ru.myx.ae3.base;

import java.util.IdentityHashMap;
import java.util.Iterator;

/**
 * Not public - use Base.joinPropertyIterators - does it better!
 * 
 * @author myx
 */
final class IteratorSequencePrimitive implements Iterator<BasePrimitiveString> {
	
	private final IdentityHashMap<BasePrimitiveString, Boolean>	known;
	
	private Iterator<BasePrimitiveString>						currentIterator;
	
	private Iterator<BasePrimitiveString>						nextIterator;
	
	private BasePrimitiveString									key;
	
	/**
	 * @param iterator
	 * @param next
	 */
	IteratorSequencePrimitive(final Iterator<BasePrimitiveString> iterator, final Iterator<BasePrimitiveString> next) {
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
	public BasePrimitiveString next() {
		final BasePrimitiveString key = this.key;
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
