package ru.myx.ae3.base;

import java.util.Iterator;

final class IteratorBaseArrayValue implements Iterator<BaseObject> {
	private final BaseArray	array;
	
	private int					index;
	
	
	IteratorBaseArrayValue(final BaseArray array) {
	
		this.array = array;
		this.index = 0;
	}
	
	
	@Override
	public boolean hasNext() {
	
		return this.index < this.array.length();
	}
	
	
	@Override
	public BaseObject next() {
	
		return this.array.baseGet( this.index++, BaseObject.UNDEFINED );
	}
	
	
	@Override
	public void remove() {
	
		// ignore
	}
}
