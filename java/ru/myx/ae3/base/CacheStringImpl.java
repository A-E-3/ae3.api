package ru.myx.ae3.base;

interface CacheStringImpl {
	
	BasePrimitiveString cacheGetCreate(String key);

	void cachePutInternal(BasePrimitiveString value);
}
