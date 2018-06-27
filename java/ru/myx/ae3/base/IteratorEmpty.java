package ru.myx.ae3.base;

import java.util.Iterator;

final class IteratorEmpty<T> implements Iterator<T> {
	
	static final IteratorEmpty<?>	INSTANCE	= new IteratorEmpty<>();
	
	private IteratorEmpty() {
		//
	}
	
	@Override
	public boolean hasNext() {
		return false;
	}
	
	@Override
	public T next() {
		return null;
	}
	
	@Override
	public void remove() {
		// ignore
	}
	
}
