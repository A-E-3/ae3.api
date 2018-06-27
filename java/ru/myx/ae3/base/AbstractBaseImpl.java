package ru.myx.ae3.base;

import java.util.List;

import ru.myx.ae3.exec.ExecCallable;

abstract class AbstractBaseImpl {
	
	public static abstract class BaseObjectFactory {
		
		public abstract <T> BaseList<T> createArray();
		
		public abstract <T> BaseList<T> createArray(int expectedLength);
		
		public abstract BaseProperties<?> createFirstProperty(BaseObject instance, BasePrimitiveString key, BaseProperty property, short attributes);
		
		public abstract BaseProperties<?> createFirstProperty(BaseObject instance, String key, BaseProperty property, short attributes);
		
		public abstract BaseProperties<?> createFirstProperty(BasePrimitiveString key, BaseObject value, short attributes);
		
		public abstract BaseProperties<?> createFirstProperty(String key, BaseObject value, short attributes);
		
		public abstract BaseMapEditable createObject();
		
		public abstract BaseMapEditable createObject(BaseObject prototype);
		
		public abstract BaseStringObject<?> createStringObject(String x);
		
		public abstract <T extends BaseList<?>> Class<T> getClassForBaseList();
		
		public abstract <T extends BaseMapEditable> Class<T> getClassForBaseMap();
	}
	
	public abstract BaseFunction bindFunction(BaseFunction function, BaseObject instance, BaseObject... arguments);
	
	public abstract CacheDoubleImpl createCacheDouble();
	
	public abstract CacheIntegerImpl createCacheInteger();
	
	public abstract CacheLongImpl createCacheLong();
	
	public abstract CacheStringImpl createCacheString();
	
	public abstract BaseFunction createFunction(final BaseObject scope, final String[] arg) throws Exception;
	
	public abstract BaseObjectFactory createObjectFactory();
	
	public abstract BasePropertyData<BasePrimitiveString> createPropertyPrimitive(BaseObject instance, BasePrimitiveString key, BaseProperty property, short attributes);
	
	public abstract BasePropertyData<BasePrimitiveString> createPropertyPrimitive(BasePrimitiveString key, BaseObject value, short attributes);
	
	public abstract BasePropertyData<String> createPropertyString(BaseObject instance, String key, BaseProperty property, short attributes);
	
	public abstract BasePropertyData<String> createPropertyString(String key, BaseObject value, short attributes);
	
	public abstract BaseFunction javaNativeFunction(ExecCallable object);
	
	public abstract BaseObject javaNumberToBaseObjectNumber(Number object);
	
	public abstract <T> BaseArray javaObjectToBaseArray(final List<T> list);
	
	public abstract <T> BaseArray javaObjectToBaseArray(final T[] array);
	
	public abstract BaseObject javaObjectToBaseObject(Object object);
	
	public abstract BaseAbstractException javaThrowableToBaseObject(Throwable object);

	public abstract BaseObject seal(BaseObject object);
}
