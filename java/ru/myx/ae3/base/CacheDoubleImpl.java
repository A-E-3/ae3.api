package ru.myx.ae3.base;

interface CacheDoubleImpl {

	BasePrimitiveNumber cacheGetCreate(final double key);
	
	void cachePutInternal(BasePrimitiveNumber value);
}
