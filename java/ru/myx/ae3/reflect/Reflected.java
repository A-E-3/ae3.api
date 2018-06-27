package ru.myx.ae3.reflect;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseFunction;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.base.BasePrimitive;
import ru.myx.ae3.base.BasePrimitiveString;
import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;

/**
 * @author myx
 *
 */
@ReflectionManual
public interface Reflected {
	
	/**
	 * Constructor key
	 */
	@ReflectionExplicit
	static BasePrimitiveString KEY_CONSTRUCTOR_BASE = Base.forString("<new>");
	
	/**
	 * Constructor key
	 */
	static String KEY_CONSTRUCTOR_JAVA = Reflected.KEY_CONSTRUCTOR_BASE.toString();
	
	/**
	 * Undefined constructor, Reflect is special - there is like always
	 * constructor present, but sometimes it is not accessible by design...
	 * Let's say it's private or such, i.e. class is not designed to be
	 * instantiated.
	 *
	 * Normal native object will return null on baseConstruct, but reflected
	 * objects should return this constructor instance in this case, cause they
	 * are really not going to be created if no legit constructors are
	 * available.
	 */
	static BaseFunction CONSTRUCTOR_UNDEFINED = new ForbiddenConstructor();
	
	/**
	 * @return identity or null
	 */
	@ReflectionExplicit
	String getGuid();
	
	/**
	 * @param ctx
	 * @param instance
	 * @param name
	 * @param store
	 *            TODO
	 * @return NULL
	 */
	ExecStateCode propertyGetCtxResult(ExecProcess ctx, BaseObject instance, BasePrimitive<?> name, ResultHandler store);
	
	/**
	 * @param ctx
	 * @param instance
	 * @param name
	 * @return reference
	 */
	BaseObject reflectReadNative(ExecProcess ctx, BaseObject instance, String name);
	
	/**
	 * This method can return NULL to indicate that write failed
	 *
	 * @param ctx
	 * @param instance
	 * @param name
	 * @param value
	 * @return true on success, false otherwise, exception on unexpected error
	 */
	default boolean reflectWriteNative(final ExecProcess ctx, final BaseObject instance, final CharSequence name, final BaseObject value) {
		
		return false;
	}
}
