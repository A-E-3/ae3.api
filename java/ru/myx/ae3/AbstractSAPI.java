package ru.myx.ae3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Major static APIs derived from this class (partially for the sake of
 * javaDoc's links)
 *
 * @author myx
 *
 */
public abstract class AbstractSAPI {
	
	private static final Object[] NULL_ARRAY = new Object[0];
	
	/**
	 * @param <T>
	 * @param className
	 * @return
	 * @throws RuntimeException
	 */
	protected final static <T> T createObject(final String className) throws RuntimeException {
		
		final T object = AbstractSAPI.createObjectIntern(className);
		System.out.println("Object created: " + className);
		return object;
	}
	
	/**
	 *
	 * @param className
	 * @param fieldName
	 * @return
	 */
	protected final static Field getReflectedField(final String className, final String fieldName) {
		
		try {
			final ClassLoader loader = Engine.class.getClassLoader();
			final Class<?> boot = loader.loadClass(className);
			final Field field = boot.getField(fieldName);
			field.setAccessible(true);
			return field;
		} catch (final Throwable e) {
			throw new RuntimeException("default implementation is missing - please use ae3sys.jar", e);
		}
	}
	
	/**
	 *
	 * @param className
	 * @param methodName
	 * @return
	 */
	protected final static Method getReflectedMethod0(final String className, final String methodName) {
		
		try {
			final ClassLoader loader = Engine.class.getClassLoader();
			final Class<?> boot = loader.loadClass(className);
			final Method method = boot.getMethod(methodName);
			method.setAccessible(true);
			return method;
		} catch (final Throwable e) {
			throw new RuntimeException("default implementation is missing - please use ae3sys.jar", e);
		}
	}
	
	@SuppressWarnings("unchecked")
	private final static <T> T createObjectIntern(final String className) throws RuntimeException {
		
		try {
			final ClassLoader loader = Engine.class.getClassLoader();
			final Class<?> boot = loader.loadClass(className);
			// return (T) boot.newInstance();
			final Class<?>[] arguments = null;
			final Constructor<?> constructor = boot.getConstructor(arguments);
			constructor.setAccessible(true);
			return (T) constructor.newInstance(AbstractSAPI.NULL_ARRAY);
		} catch (final Throwable e) {
			throw new RuntimeException("default implementation is missing - please use ae3sys.jar (while trying to load: " + className + ")", e);
		}
	}

	/**
	 *
	 * @param text
	 * @return true (to be usable with 'assert' keyword)
	 */
	public final static boolean logDebug(final String text) {

		System.out.println(text);
		return true;
	}
	
}
