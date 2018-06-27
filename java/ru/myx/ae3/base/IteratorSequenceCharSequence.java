package ru.myx.ae3.base;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Not public - use Base.joinPropertyIterators - does it better!
 * 
 * @author myx
 */
final class IteratorSequenceCharSequence implements Iterator<CharSequence> {
	
	private final Set<CharSequence>				known;
	
	private Iterator<? extends CharSequence>	currentIterator;
	
	private Iterator<? extends CharSequence>	nextIterator;
	
	private CharSequence						key;
	
	/**
	 * @param iterator
	 * @param next
	 */
	IteratorSequenceCharSequence(final Iterator<? extends CharSequence> iterator,
			final Iterator<? extends CharSequence> next) {
		assert iterator != null : "Should not be NULL";
		assert iterator.hasNext() : "Should not be empty!";
		this.known = new TreeSet<>();
		this.currentIterator = iterator;
		this.nextIterator = next;
		this.key = iterator.next();
	}
	
	@Override
	public boolean hasNext() {
		return this.key != null;
	}
	
	@Override
	public CharSequence next() {
		final CharSequence key = this.key;
		this.known.add( key );
		for (;;) {
			if (this.currentIterator.hasNext()) {
				this.key = this.currentIterator.next();
				if (!this.known.contains( this.key )) {
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
