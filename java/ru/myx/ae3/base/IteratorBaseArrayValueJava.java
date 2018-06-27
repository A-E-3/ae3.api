package ru.myx.ae3.base;

import java.util.Iterator;

final class IteratorBaseArrayValueJava<K> implements Iterator<K> {
	private final BaseArray	array;
	
	private int				index;
	
	
	IteratorBaseArrayValueJava(final BaseArray array) {
	
		this.array = array;
		this.index = 0;
	}
	
	
	@Override
	public boolean hasNext() {
	
		return this.index < this.array.length();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public K next() {
	
		return (K) this.array.get( this.index++ );
	}
	
	
	@Override
	public void remove() {
	
		// ignore
	}
}
