package ru.myx.ae3.base;

import javax.script.Bindings;

import ru.myx.ae3.reflect.ReflectionHidden;
import ru.myx.ae3.reflect.ReflectionIgnore;

/**
 * @author myx
 */
@ReflectionIgnore
public interface BaseMap extends BaseObject, Bindings {
	
	// static Supplier<BaseMapEditable> OBJECT_DEFAULT_SUPPLIER = Base.;
	
	// static Function<BaseObject, BaseMapEditable> OBJECT_BY_PROTOTYPE_FUNCTION
	// = null;
	
	/**
	 * Creates default extensible unsealed object just like '{}' will do in the
	 * script
	 * 
	 * 
	 * 
	 * Alias for BaseMap.create();
	 * 
	 * @return
	 */
	@ReflectionHidden
	static BaseMapEditable create() {
		
		return Base.OBJECT_FACTORY.createObject();
		/**
		 * try { return Base.OF_CLS_BASE_MAP.newInstance(); } catch
		 * (InstantiationException | IllegalAccessException e) { throw new
		 * RuntimeException("BaseObject: BaseMap factory failure", e); }
		 */
	}
	
	/**
	 * Creates default extensible unsealed object just like '{}' will do in the
	 * script but with given prototype.
	 * 
	 * @param prototype
	 * 			
	 * @return
	 */
	@ReflectionHidden
	static BaseMapEditable create(final BaseObject prototype) {
		
		return Base.OBJECT_FACTORY.createObject(prototype);
		/**
		 * try { return Base.OF_CNS_BASE_MAP.newInstance(prototype); } catch
		 * (InvocationTargetException e) { throw new RuntimeException(
		 * "BaseObject: BaseMap factory failure", e.getCause()); } catch
		 * (InstantiationException | IllegalAccessException |
		 * IllegalArgumentException e) { throw new RuntimeException(
		 * "BaseObject: BaseMap factory failure", e); }
		 */
	}
	
}
