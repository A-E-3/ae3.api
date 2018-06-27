package ru.myx.ae3.base;

import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;

final class IteratorHierarchyPrimitive implements Iterator<BasePrimitive<?>> {
	
	private final Map<BasePrimitive<?>, Boolean>	known;
	
	private Iterator<? extends BasePrimitive<?>>	currentIterator;
	
	private BaseObject							nextObject;
	
	private BasePrimitive<?>						key;
	
	IteratorHierarchyPrimitive(final Iterator<? extends BasePrimitive<?>> iterator, final BaseObject prototype) {
		assert iterator != null : "Should not be NULL";
		assert iterator.hasNext() : "Should not be empty!";
		this.known = new IdentityHashMap<>();
		this.currentIterator = iterator;
		this.nextObject = prototype;
		
		{
			/**
			 * can't afford to loose it, tests are: TestIfInstanceVsCatchCast
			 */
			final Object keyObject = iterator.next();
			
			// don't know what to do with that yet
			assert keyObject != null : "NULL key, iterator class=" + iterator.getClass().getName();
			
			try {
				this.key = (BasePrimitive<?>) keyObject;
			} catch (final ClassCastException e) {
				this.currentIterator = new IteratorTypeSafePrimitive( iterator );
				this.key = Base.forUnknown( keyObject ).baseToPrimitive( null );
			}
		}
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
				{
					/**
					 * can't afford to loose it, tests are:
					 * TestIfInstanceVsCatchCast
					 */
					final Object keyObject = this.currentIterator.next();
					
					// don't know what to do with that yet
					assert keyObject != null : "NULL key, iterator class=" + this.currentIterator.getClass().getName();
					
					try {
						this.key = (BasePrimitive<?>) keyObject;
					} catch (final ClassCastException e) {
						this.currentIterator = new IteratorTypeSafePrimitive( this.currentIterator );
						this.key = Base.forUnknown( keyObject ).baseToPrimitive( null );
					}
				}
				if (!this.known.containsKey( this.key )) {
					break;
				}
				continue;
			}
			if (this.nextObject == null) {
				this.key = null;
				break;
			}
			this.currentIterator = this.nextObject.baseKeysOwnPrimitive();
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
