package ru.myx.ae3.help;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.common.Describable;
import ru.myx.ae3.help.Format.Describe;

/** @author myx
 *
 *         TODO: move to .help or even rename */
final class ExecValueFormat {
	
	static final void formatValue(final StringBuilder data, final Object value, final boolean detail) {

		if (value == null) {
			data.append("null");
			return;
		}
		
		if (value instanceof final Describable describable) {
			data.append(describable.baseDescribe());
			return;
		}
		final String stringValue;
		{
			String stringValueCheck;
			try {
				stringValueCheck = value.toString();
			} catch (final Throwable t) {
				stringValueCheck = "ERROR: " + t.toString();
			}
			stringValue = stringValueCheck;
		}
		data.append(
				stringValue == null
					? "null"
					: detail
						? Describe.limitStringDescribe(stringValue)
						: Describe.limitStringCompact(stringValue));
		if (detail) {
			data.append("\n\t\t").append(value.getClass().getName());
		}
	}

	/** @param builder
	 * @param o
	 * @param className
	 * @param type */
	static void moreDebug(final StringBuilder builder, final BaseObject o, final String type) {
		
		if (o == null) {
			builder.append(" /* NULL */");
			return;
		}
		
		/** additional debug info */
		builder.append(' ');

		// builder.append( '\n' );
		// ExecValueFormat.ident( builder, prefix, ident );
		builder.append("/* ").append(type).append(", class=");
		builder.append(o.getClass().getName());
		final Object baseValue = o.baseValue();
		if (baseValue != null && baseValue != o) {
			builder.append(" (").append(baseValue.getClass().getName()).append(')');
		}
		builder.append(" */");
	}

	/** @param builder
	 * @param o
	 * @param className
	 * @param type */
	static void moreDebug(final StringBuilder builder, final Object o, final String type) {
		
		if (o == null) {
			builder.append(" /* NULL */");
			return;
		}
		
		if (o instanceof BaseObject) {
			ExecValueFormat.moreDebug(builder, (BaseObject) o, type);
			return;
		}
		/** additional debug info */
		builder.append(' ');
		// builder.append( '\n' );
		// ExecValueFormat.ident( builder, prefix, ident );
		builder.append("/* ").append(type).append(", class=");
		builder.append(o.getClass().getName());
		builder.append(" (").append(o.getClass().getName()).append(')');
		builder.append(" */");
	}

	static final void printNumber(final StringBuilder builder, final int number, final int length) {
		
		if (number < 0) {
			{
				final String decimal = Long.toString(number & 0xFFFFFFFFL, 16);
				for (int i = length - decimal.length(); i > 0; --i) {
					builder.append('f');
				}
				builder.append(decimal);
			}
			builder.append(' ');
			builder.append('(');
			{
				builder.append('-');
				final String decimal = Integer.toString(-number, 10);
				for (int i = length - decimal.length(); i > 1; --i) {
					builder.append('0');
				}
				builder.append(decimal);
			}
			builder.append(')');
		} else {
			{
				final String decimal = Integer.toString(number, 16);
				for (int i = length - decimal.length(); i > 0; --i) {
					builder.append('0');
				}
				builder.append(decimal);
			}
			builder.append(' ');
			builder.append('(');
			{
				final String decimal = Integer.toString(number, 10);
				for (int i = length - decimal.length(); i > 0; --i) {
					builder.append('0');
				}
				builder.append(decimal);
			}
			builder.append(')');
		}
	}

}
