package ru.myx.ae3.base;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

final class SealedEmptyObject implements BaseMap, ConcurrentMap<String, Object>, BaseObjectNoOwnProperties {
	
	
	static final SealedEmptyObject INSTANCE = new SealedEmptyObject();
	
	private SealedEmptyObject() {
		
		//
	}
	
	@Override
	public String toString() {
		
		
		return "[object SealedEmpty]";
	}
	
	@Override
	public SealedEmptyObject baseValue() {
		
		
		return this;
	}
	
	@Override
	public void clear() {
		
		
		// ignore
	}
	
	@Override
	public boolean containsKey(final Object arg0) {
		
		
		return false;
	}
	
	@Override
	public boolean containsValue(final Object arg0) {
		
		
		return false;
	}
	
	@Override
	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		
		
		return Collections.emptySet();
	}
	
	@Override
	public boolean equals(final Object o) {
		
		
		/**
		 * supposed to have single instance
		 */
		return o == this;
	}
	
	@Override
	public Object get(final Object arg0) {
		
		
		return null;
	}
	
	@Override
	public int hashCode() {
		
		
		return 0;
	}
	
	@Override
	public boolean isEmpty() {
		
		
		return true;
	}
	
	@Override
	public Set<String> keySet() {
		
		
		return Collections.emptySet();
	}
	
	@Override
	public Object put(final String arg0, final Object arg1) {
		
		
		return null;
	}
	
	@Override
	public void putAll(final Map<? extends String, ? extends Object> arg0) {
		
		
		// ignore
	}
	
	@Override
	public Object putIfAbsent(final String key, final Object value) {
		
		
		return null;
	}
	
	@Override
	public Object remove(final Object arg0) {
		
		
		return null;
	}
	
	@Override
	public boolean remove(final Object key, final Object value) {
		
		
		return false;
	}
	
	@Override
	public Object replace(final String key, final Object value) {
		
		
		return null;
	}
	
	@Override
	public boolean replace(final String key, final Object oldValue, final Object newValue) {
		
		
		return false;
	}
	
	@Override
	public int size() {
		
		
		return 0;
	}
	
	@Override
	public Collection<Object> values() {
		
		
		return Collections.emptyList();
	}
}
