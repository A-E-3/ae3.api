/**
 * 
 */
package ru.myx.ae3.ecma;

import java.util.List;

import ru.myx.ae3.AbstractSAPI;
import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseFunction;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.base.BasePrimitiveNumber;
import ru.myx.ae3.base.BaseString;
import ru.myx.ae3.common.Value;
import ru.myx.ae3.exec.ExecCallable;
import ru.myx.ae3.help.Format;

/**
 * This is a helper API class for EcmaScript (ECMA-252 standard, revision 5.
 * Also known as JavaScript, JScript, etc.).
 * 
 * ECMA-262 standard defines syntax, notation, data types, formats, etc. Some
 * java methods with typical tasks while working with ECMA-262-related stuff are
 * defined in this helper class.
 * 
 * @author myx
 */
public class Ecma extends AbstractSAPI {
	
	
	private static final AbstractEcmaImpl ECMA_IMPL;
	
	/**
	 * this block should go last
	 */
	static {
		ECMA_IMPL = AbstractSAPI.createObject("ru.myx.ae3.ecma.ImplementEcma");
	}
	
	/**
	 * CATCH METHOD
	 * 
	 * Allowed for merge with 677
	 * 
	 * @param value
	 * @return
	 * 
	 */
	@Deprecated
	public static final boolean ecmaToBoolean(final BaseObject value) {
		
		
		return value == null
			? false
			: value.baseToJavaBoolean();
	}
	
	/**
	 * @param value
	 * @return boolean
	 * 
	 */
	public static final boolean ecmaToBoolean(final Object value) {
		
		
		if (value == Boolean.TRUE || value == BaseObject.TRUE) {
			return true;
		}
		if (value == null || value == Boolean.FALSE || value == BaseObject.FALSE || value == BaseObject.UNDEFINED || value == BaseObject.NULL || value == BasePrimitiveNumber.ZERO
				|| value == BaseString.EMPTY) {
			return false;
		}
		final Class<?> cls = value.getClass();
		if (cls == Boolean.class || cls == boolean.class) {
			return ((Boolean) value).booleanValue();
		}
		if (cls == Integer.class || cls == int.class || cls == Long.class || cls == long.class) {
			return ((Number) value).intValue() != 0;
		}
		if (cls == Double.class || cls == double.class || cls == Float.class || cls == float.class) {
			final double d = ((Number) value).doubleValue();
			return d != 0 && d != Double.NaN;
		}
		if (cls == String.class) {
			/**
			 * FIXME: wtf? // && !value.equals( "0" )
			 */
			return ((String) value).length() > 0 && !value.equals("0");
		}
		if (value instanceof BaseObject) {
			return ((BaseObject) value).baseToJavaBoolean();
		}
		if (value instanceof Number) {
			return ((Number) value).intValue() != 0;
		}
		if (value instanceof Value<?>) {
			final Object baseValue = ((Value<?>) value).baseValue();
			if (baseValue != value) {
				return Ecma.ecmaToBoolean(baseValue);
			}
		}
		return true;
	}
	
	/**
	 * <pre>
	 * 11.4.3 The typeof Operator 
	 * The production UnaryExpression : typeof UnaryExpression is evaluated as follows: 
	 * 1. Evaluate UnaryExpression. 
	 * 2. If Type(Result(1)) is not Reference, go to step 4. 
	 * 3. If GetBase(Result(1)) is null, return &quot;undefined&quot;. 
	 * 4. Call GetValue(Result(1)). 
	 * 5. Return a string determined by Type(Result(4)) according to the following table:
	 *  
	 * Type Result 
	 * Undefined &quot;undefined&quot; 
	 * Null &quot;object&quot; 
	 * Boolean &quot;boolean&quot; 
	 * Number &quot;number&quot; 
	 * String &quot;string&quot; 
	 * Object (native and 
	 * doesn’t implement 
	 * [[Call]]) 
	 * &quot;object&quot; 
	 * Object (native and 
	 * implements [[Call]]) 
	 * &quot;function&quot; 
	 * Object (host) Implementation-dependent
	 * 
	 * </pre>
	 * 
	 * @param value
	 * @return string type of
	 */
	public static final String ecmaTypeOf(final BaseObject value) {
		
		
		if (value == null || value == BaseObject.UNDEFINED) {
			return "undefined";
		}
		if (value == BaseObject.NULL) {
			return "object";
		}
		if (value.baseIsPrimitiveString()) {
			return "string";
		}
		if (value.baseIsPrimitiveNumber()) {
			return "number";
		}
		if (value.baseCall() != null) {
			return "function";
		}
		if (value.baseIsPrimitiveBoolean()) {
			return "boolean";
		}
		if (value.baseArray() != null) {
			return "array";
		}
		return "object";
	}
	
	/**
	 * <pre>
	 * 11.4.3 The typeof Operator 
	 * The production UnaryExpression : typeof UnaryExpression is evaluated as follows: 
	 * 1. Evaluate UnaryExpression. 
	 * 2. If Type(Result(1)) is not Reference, go to step 4. 
	 * 3. If GetBase(Result(1)) is null, return &quot;undefined&quot;. 
	 * 4. Call GetValue(Result(1)). 
	 * 5. Return a string determined by Type(Result(4)) according to the following table:
	 *  
	 * Type Result 
	 * Undefined &quot;undefined&quot; 
	 * Null &quot;object&quot; 
	 * Boolean &quot;boolean&quot; 
	 * Number &quot;number&quot; 
	 * String &quot;string&quot; 
	 * Object (native and 
	 * doesn’t implement 
	 * [[Call]]) 
	 * &quot;object&quot; 
	 * Object (native and 
	 * implements [[Call]]) 
	 * &quot;function&quot; 
	 * Object (host) Implementation-dependent
	 * 
	 * </pre>
	 * 
	 * @param value
	 * @return string type of
	 */
	public static final String ecmaTypeOf(final Object value) {
		
		
		if (value == null || value == BaseObject.UNDEFINED) {
			return "undefined";
		}
		if (value == BaseObject.NULL) {
			return "object";
		}
		if (value.getClass() == String.class) {
			return "string";
		}
		if (value instanceof Number) {
			return "number";
		}
		if (value instanceof BaseFunction) {
			return "function";
		}
		if (value instanceof ExecCallable) {
			return "function";
		}
		if (value instanceof Boolean) {
			return "boolean";
		}
		if (value instanceof BaseObject) {
			return "object";
		}
		if (value instanceof List<?> || value instanceof Object[]) {
			return "array";
		}
		return "object";
	}
	
	static final StringBuilder ident(final StringBuilder builder, final int count) {
		
		
		for (int i = count; i > 0; --i) {
			builder.append("  ");
		}
		return builder;
	}
	
	/**
	 * @param global
	 */
	public static final void setupGlobalObject(final BaseObject global) {
		
		
		Ecma.ECMA_IMPL.setupGlobalObject(global);
	}
	
	/**
	 * Readable source
	 * 
	 * @param o
	 * @param idented
	 * @param ident
	 * @return
	 */
	public static final String toEcmaSource(final BaseObject o, final boolean idented, final int ident) {
		
		
		if (o == null) {
			return "undefined";
		}
		if (o instanceof CharSequence) {
			return ident > 0 && !idented
				? Format.Ecma.string(Ecma.ident(new StringBuilder(), ident), o.toString()).toString()
				: Format.Ecma.string(o.toString());
		}
		if (o.baseIsPrimitive()) {
			return ident > 0 && !idented
				? Ecma.ident(new StringBuilder(), ident).append(o.baseToJavaString()).toString()
				: o.baseToJavaString();
		}
		return Ecma.toEcmaSource(idented
			? Ecma.ident(new StringBuilder(), ident)
			: new StringBuilder(), o, ident, 256).toString();
	}
	
	/**
	 * Readable source
	 * 
	 * @param o
	 * @param idented
	 * @param ident
	 * @param limit
	 * @return
	 */
	public static final String toEcmaSource(final BaseObject o, final boolean idented, final int ident, final int limit) {
		
		
		if (o == null) {
			return "undefined";
		}
		if (o.baseIsPrimitive()) {
			if (o.baseIsPrimitiveString()) {
				return ident > 0 && !idented
					? Format.Ecma.string(Ecma.ident(new StringBuilder(), ident), o.baseToJavaString()).toString()
					: Format.Ecma.string(o.baseToJavaString());
			}
			return ident > 0 && !idented
				? Ecma.ident(new StringBuilder(), ident).append(o.baseToJavaString()).toString()
				: o.baseToJavaString();
		}
		return Ecma.toEcmaSource(idented
			? Ecma.ident(new StringBuilder(), ident)
			: new StringBuilder(), o, ident, limit).toString();
	}
	
	/**
	 * Readable source
	 * 
	 * @param builder
	 * @param o
	 * @param ident
	 * @param limit
	 *            - max depth level
	 * @return
	 */
	public static final StringBuilder toEcmaSource(final StringBuilder builder, final BaseObject o, final int ident, final int limit) {
		
		
		return Ecma.ECMA_IMPL.toEcmaSource(builder, o, ident, limit);
	}
	
	/**
	 * Compact source
	 * 
	 * @param o
	 * @return
	 */
	public static final String toEcmaSourceCompact(final BaseObject o) {
		
		
		if (o == null) {
			return "undefined";
		}
		if (o.baseIsPrimitive()) {
			if (o.baseIsPrimitiveString()) {
				return Format.Ecma.string(o.baseToJavaString());
			}
			return o.baseToJavaString();
		}
		return Ecma.toEcmaSourceCompact(new StringBuilder(), o).toString();
	}
	
	/**
	 * Compact source
	 * 
	 * @param o
	 * @return
	 */
	public static final String toEcmaSourceCompact(final Object o) {
		
		
		if (o == null) {
			return "null";
		}
		return Ecma.toEcmaSourceCompact(Base.forUnknown(o));
	}
	
	/**
	 * Compact source
	 * 
	 * @param builder
	 * @param o
	 * @return
	 */
	public static final StringBuilder toEcmaSourceCompact(final StringBuilder builder, final BaseObject o) {
		
		
		return Ecma.ECMA_IMPL.toEcmaSourceCompact(builder, o);
	}
	
	/**
	 * @param object
	 * @return
	 */
	public static final String toString(final BaseObject object) {
		
		
		return object == null
			? "null"
			: object.baseIsPrimitive()
				? Ecma.toEcmaSourceCompact(object)
				: object.baseToJavaString();
	}
	
	private Ecma() {
		// ignore
	}
}
