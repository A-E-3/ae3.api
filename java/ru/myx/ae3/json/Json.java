/**
 *
 */
package ru.myx.ae3.json;

import ru.myx.ae3.AbstractSAPI;
import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.help.Format;

/** This is a helper API class for EcmaScript (ECMA-252 standard, revision 5. Also known as
 * JavaScript, JScript, etc.).
 *
 * ECMA-262 standard defines syntax, notation, data types, formats, etc. Some java methods with
 * typical tasks while working with ECMA-262-related stuff are defined in this helper class.
 *
 * @author myx */
public class Json extends AbstractSAPI {
	
	private static final AbstractJsonImpl JSON_IMPL;

	/** this block should go last */
	static {
		JSON_IMPL = AbstractSAPI.createObject("ru.myx.ae3.json.ImplementJson");
	}

	static final StringBuilder ident(final StringBuilder builder, final int count) {
		
		for (int i = count; i > 0; --i) {
			builder.append("  ");
		}
		return builder;
	}

	/** Readable source
	 *
	 * @param o
	 * @param idented
	 * @param ident
	 * @return */
	public static final String toJsonSource(final BaseObject o, final boolean idented, final int ident) {
		
		if (o == null || o == BaseObject.UNDEFINED) {
			return "null";
		}
		if (o instanceof CharSequence) {
			return ident > 0 && !idented
				? Format.Ecma.string(Json.ident(new StringBuilder(), ident), o.toString()).toString()
				: Format.Ecma.string(o.toString());
		}
		if (o.baseIsPrimitive()) {
			return ident > 0 && !idented
				? Json.ident(new StringBuilder(), ident).append(o.baseToJavaString()).toString()
				: o.baseToJavaString();
		}
		return Json.toJsonSource(
				idented
					? Json.ident(new StringBuilder(), ident)
					: new StringBuilder(),
				o,
				ident,
				256).toString();
	}

	/** Readable source
	 *
	 * @param o
	 * @param idented
	 * @param ident
	 * @param limit
	 * @return */
	public static final String toJsonSource(final BaseObject o, final boolean idented, final int ident, final int limit) {
		
		if (o == null || o == BaseObject.UNDEFINED) {
			return "null";
		}
		if (o.baseIsPrimitive()) {
			if (o.baseIsPrimitiveString()) {
				return ident > 0 && !idented
					? Format.Ecma.string(Json.ident(new StringBuilder(), ident), o.baseToJavaString()).toString()
					: Format.Ecma.string(o.baseToJavaString());
			}
			return ident > 0 && !idented
				? Json.ident(new StringBuilder(), ident).append(o.baseToJavaString()).toString()
				: o.baseToJavaString();
		}
		return Json.toJsonSource(
				idented
					? Json.ident(new StringBuilder(), ident)
					: new StringBuilder(),
				o,
				ident,
				limit).toString();
	}

	/** Readable source
	 *
	 * @param builder
	 * @param o
	 * @param ident
	 * @param limit
	 *            - max depth level
	 * @return */
	public static final StringBuilder toJsonSource(final StringBuilder builder, final BaseObject o, final int ident, final int limit) {
		
		return Json.JSON_IMPL.toJsonSource(builder, o, ident, limit);
	}

	/** Compact source
	 *
	 * @param o
	 * @return */
	public static final String toJsonSourceCompact(final BaseObject o) {
		
		if (o == null || o == BaseObject.UNDEFINED) {
			return "null";
		}
		if (o.baseIsPrimitive()) {
			if (o.baseIsPrimitiveString()) {
				return Format.Ecma.string(o.baseToJavaString());
			}
			return o.baseToJavaString();
		}
		return Json.toJsonSourceCompact(new StringBuilder(), o).toString();
	}

	/** Compact source
	 *
	 * @param o
	 * @return */
	public static final String toJsonSourceCompact(final Object o) {
		
		if (o == null || o == BaseObject.UNDEFINED) {
			return "null";
		}
		return Json.toJsonSourceCompact(Base.forUnknown(o));
	}

	/** Compact source
	 *
	 * @param builder
	 * @param o
	 * @return */
	public static final StringBuilder toJsonSourceCompact(final StringBuilder builder, final BaseObject o) {
		
		return Json.JSON_IMPL.toJsonSourceCompact(builder, o);
	}

	/** @param object
	 * @return */
	public static final String toString(final BaseObject object) {
		
		return object == null
			? "null"
			: object.baseIsPrimitive()
				? Json.toJsonSourceCompact(object)
				: object.baseToJavaString();
	}

	private Json() {
		
		// ignore
	}
}
