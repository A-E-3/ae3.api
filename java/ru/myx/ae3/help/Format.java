/**
 * Created on 09.11.2002
 *
 * myx - barachta */
package ru.myx.ae3.help;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

import org.xml.sax.Attributes;

import ru.myx.ae3.AbstractSAPI;
import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseMap;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.report.Report;

/** @author barachta
 *
 *         myx - barachta Window>Preferences>Java>Templates. To enable and disable the creation of
 *         type comments go to Window>Preferences>Java>Code Generation. */
public class Format extends AbstractSAPI {
	
	/** Inexact, Human readable
	 *
	 * Compact, short form. No more than one line of text. */
	public static final class Compact {
		
		private static final class NumberFormatter {
			
			private static final int CAPACITY = 32;
			
			private static volatile int counter = 0;
			
			private static final NumberFormat[] POOL1 = new NumberFormat[NumberFormatter.CAPACITY];
			
			private static final NumberFormat[] POOL2 = new NumberFormat[NumberFormatter.CAPACITY];
			
			private static final NumberFormat[] POOL3 = new NumberFormat[NumberFormatter.CAPACITY];
			
			static {
				for (int i = 0; i < NumberFormatter.CAPACITY; ++i) {
					NumberFormatter.POOL1[i] = NumberFormat.getInstance(Locale.ROOT);
					NumberFormatter.POOL1[i].setMaximumFractionDigits(1);
					NumberFormatter.POOL1[i].setMinimumFractionDigits(0);
					NumberFormatter.POOL1[i].setMinimumIntegerDigits(1);
					NumberFormatter.POOL1[i].setGroupingUsed(false);
					NumberFormatter.POOL1[i].setRoundingMode(RoundingMode.HALF_UP);
					
					NumberFormatter.POOL2[i] = NumberFormat.getInstance(Locale.ROOT);
					NumberFormatter.POOL2[i].setMaximumFractionDigits(2);
					NumberFormatter.POOL2[i].setMinimumFractionDigits(0);
					NumberFormatter.POOL2[i].setMinimumIntegerDigits(1);
					NumberFormatter.POOL2[i].setGroupingUsed(false);
					NumberFormatter.POOL2[i].setRoundingMode(RoundingMode.HALF_UP);
					
					NumberFormatter.POOL3[i] = NumberFormat.getInstance(Locale.ROOT);
					NumberFormatter.POOL3[i].setMaximumFractionDigits(3);
					NumberFormatter.POOL3[i].setMinimumFractionDigits(0);
					NumberFormatter.POOL3[i].setMinimumIntegerDigits(0);
					NumberFormatter.POOL3[i].setGroupingUsed(false);
					NumberFormatter.POOL3[i].setRoundingMode(RoundingMode.HALF_UP);
				}
			}
			
			static String format1(final double d) {
				
				final int index = NumberFormatter.counter++;
				final NumberFormat current = NumberFormatter.POOL1[index % NumberFormatter.CAPACITY];
				synchronized (current) {
					return current.format(d);
				}
			}
			
			static String format2(final double d) {
				
				final int index = NumberFormatter.counter++;
				final NumberFormat current = NumberFormatter.POOL2[index % NumberFormatter.CAPACITY];
				synchronized (current) {
					return current.format(d);
				}
			}
			
			static String format3(final double d) {
				
				final int index = NumberFormatter.counter++;
				final NumberFormat current = NumberFormatter.POOL3[index % NumberFormatter.CAPACITY];
				synchronized (current) {
					return current.format(d);
				}
			}
		}
		
		private static final DateFormatterCompact DATE = new DateFormatterCompact();
		
		/** @param argument
		 * @return */
		public static final String baseObject(final BaseObject argument) {
			
			if (argument == null) {
				return "null";
			}
			final StringBuilder builder = new StringBuilder();
			if (argument.baseIsPrimitiveString()) {
				builder.append('"');
			}
			ExecValueFormat.formatValue(builder, argument, false);
			if (argument.baseIsPrimitiveString()) {
				builder.append('"');
			}
			return builder.toString();
		}
		
		/** @param date
		 * @return string */
		public static final String date(final Date date) {
			
			return Compact.DATE.format(date);
		}
		
		/** @param time
		 * @return string */
		public static final String date(final long time) {
			
			return Compact.DATE.format(time);
		}
		
		/** @param date
		 * @return string */
		public static final String dateRelative(final Date date) {
			
			return Compact.DATE.formatRelative(date);
		}
		
		/** @param time
		 * @return string */
		public static final String dateRelative(final long time) {
			
			return Compact.DATE.formatRelative(time);
		}
		
		/** @param value
		 * @return string */
		public static final String toBytes(final double value) {
			
			if (value < 1_000L) {
				if (value < 0) {
					return '-' + Format.Compact.toBytes(-value);
				}
				if (value >= 1) {
					return NumberFormatter.format2(value) + ' ';
				}
				if (value >= Format.DOUBLE_MILLI) {
					return NumberFormatter.format2(value / Format.DOUBLE_MILLI_BYTES) + " ml";
				}
				if (value >= Format.DOUBLE_MICRO) {
					return NumberFormatter.format2(value / Format.DOUBLE_MICRO_BYTES) + " mk";
				}
				return NumberFormatter.format2(value / Format.DOUBLE_NANO_BYTES) + " n";
			}
			if (value >= 1_000_000_000_000L) {
				return NumberFormatter.format2(value / Format.DOUBLE_TERA_BYTES) + " T";
			}
			if (value >= 1_000_000_000L) {
				return NumberFormatter.format2(value / Format.DOUBLE_GIGA_BYTES) + " G";
			}
			if (value >= 1_000_000L) {
				return NumberFormatter.format2(value / Format.DOUBLE_MEGA_BYTES) + " M";
			}
			if (value >= 1_000L) {
				return NumberFormatter.format2(value / Format.DOUBLE_KILO_BYTES) + " k";
			}
			return "n/a";
		}
		
		/** @param value
		 * @return string */
		public static final String toBytes(final long value) {
			
			if (value < 0) {
				return '-' + Format.Compact.toBytes(-value);
			}
			if (value < 1_000L) {
				return String.valueOf(value) + ' ';
			}
			if (value >= 1_000_000_000_000L) {
				return NumberFormatter.format2(value / Format.DOUBLE_TERA_BYTES) + " T";
			}
			if (value >= 1_000_000_000L) {
				return NumberFormatter.format2(value / Format.DOUBLE_GIGA_BYTES) + " G";
			}
			if (value >= 1_000_000L) {
				return NumberFormatter.format2(value / Format.DOUBLE_MEGA_BYTES) + " M";
			}
			return NumberFormatter.format2(value / Format.DOUBLE_KILO_BYTES) + " k";
		}
		
		/** @param value
		 * @return string */
		public static final String toDecimal(final double value) {
			
			if (Double.isInfinite(value)) {
				return value > 0
					? "+inf"
					: "-inf";
			}
			if (Double.isNaN(value)) {
				return "NaN";
			}
			if (value < 0) {
				return '-' + Format.Compact.toDecimal(-value);
			}
			if (value < Format.DOUBLE_NANO) {
				return String.valueOf(value);
			}
			if (value >= 100_000_000_000_000L) {
				return NumberFormatter.format1(value / Format.DOUBLE_TERA) + "T";
			}
			if (value >= 1_000_000_000_000L) {
				return NumberFormatter.format2(value / Format.DOUBLE_TERA) + "T";
			}
			if (value >= 100_000_000_000L) {
				return NumberFormatter.format1(value / Format.DOUBLE_GIGA) + "G";
			}
			if (value >= 1_000_000_000L) {
				return NumberFormatter.format2(value / Format.DOUBLE_GIGA) + "G";
			}
			if (value >= 100_000_000L) {
				return NumberFormatter.format1(value / Format.DOUBLE_MEGA) + "M";
			}
			if (value >= 1_000_000L) {
				return NumberFormatter.format2(value / Format.DOUBLE_MEGA) + "M";
			}
			if (value >= 100_000L) {
				return NumberFormatter.format1(value / Format.DOUBLE_KILO) + "k";
			}
			if (value >= 1_000L) {
				return NumberFormatter.format2(value / Format.DOUBLE_KILO) + "k";
			}
			if (value >= 20L) {
				return NumberFormatter.format1(value);
			}
			if (value >= 1L) {
				return NumberFormatter.format2(value);
			}
			if (value >= Format.DOUBLE_MILLI) {
				if (value >= Format.DOUBLE_MILLI * 10) {
					return NumberFormatter.format3((int) (value * 1000) / 1000.0);
				}
				return NumberFormatter.format2(value / Format.DOUBLE_MILLI) + "ml";
			}
			if (value >= Format.DOUBLE_MICRO) {
				return NumberFormatter.format2(value / Format.DOUBLE_MICRO) + "mk";
			}
			return NumberFormatter.format2(value / Format.DOUBLE_NANO) + "n";
		}
		
		/** @param value
		 * @return string */
		public static final String toDecimal(final long value) {
			
			if (value < 0) {
				return '-' + Format.Compact.toDecimal(-value);
			}
			if (value >= 100_000_000_000_000L) {
				return NumberFormatter.format1(value / Format.DOUBLE_TERA) + "T";
			}
			if (value >= 1_000_000_000_000L) {
				return NumberFormatter.format2(value / Format.DOUBLE_TERA) + "T";
			}
			if (value >= 100_000_000_000L) {
				return NumberFormatter.format1(value / Format.DOUBLE_GIGA) + "G";
			}
			if (value >= 1_000_000_000L) {
				return NumberFormatter.format2(value / Format.DOUBLE_GIGA) + "G";
			}
			if (value >= 100_000_000L) {
				return NumberFormatter.format1(value / Format.DOUBLE_MEGA) + "M";
			}
			if (value >= 1_000_000L) {
				return NumberFormatter.format2(value / Format.DOUBLE_MEGA) + "M";
			}
			if (value >= 100_000L) {
				return NumberFormatter.format1(value / Format.DOUBLE_KILO) + "k";
			}
			if (value >= 1_000L) {
				return NumberFormatter.format2(value / Format.DOUBLE_KILO) + "k";
			}
			if (value >= 100L) {
				return NumberFormatter.format1(value);
			}
			return NumberFormatter.format2(value);
		}
		
		/** @param value
		 * @return string */
		public static final String toPeriod(final double value) {
			
			if (value <= 0) {
				return String.valueOf(value);
			}
			if (value >= Format.DOUBLE_WEEK_PERIOD) {
				return NumberFormatter.format2(value / Format.DOUBLE_WEEK_PERIOD) + " week(s)";
			}
			if (value >= Format.DOUBLE_DAY_PERIOD) {
				return NumberFormatter.format2(value / Format.DOUBLE_DAY_PERIOD) + " day(s)";
			}
			if (value >= Format.DOUBLE_HOUR_PERIOD) {
				return NumberFormatter.format2(value / Format.DOUBLE_HOUR_PERIOD) + " hour(s)";
			}
			if (value >= Format.DOUBLE_MINUTE_PERIOD) {
				return NumberFormatter.format2(value / Format.DOUBLE_MINUTE_PERIOD) + " minute(s)";
			}
			if (value >= Format.DOUBLE_SECOND_PERIOD) {
				return NumberFormatter.format2(value / Format.DOUBLE_SECOND_PERIOD) + " second(s)";
			}
			if (value >= Format.DOUBLE_MILLISECOND_PERIOD) {
				// return formatter.format(value / dMILLISECOND_PERIOD) + " ms";
				return NumberFormatter.format2(value) + " ms";
			}
			if (value >= Format.DOUBLE_MICROSECOND_PERIOD) {
				return NumberFormatter.format2(value / Format.DOUBLE_MICROSECOND_PERIOD) + " mks";
			}
			return NumberFormatter.format2(value / Format.DOUBLE_NANOSECOND_PERIOD) + " nanos";
		}
		
		/** @param value
		 * @return string */
		public static final String toPeriod(final long value) {
			
			if (value <= 0) {
				return String.valueOf(value);
			}
			if (value >= 60_000L * 60L * 24L * 7L) {
				return NumberFormatter.format2(value / Format.DOUBLE_WEEK_PERIOD) + " week(s)";
			}
			if (value >= 60_000L * 60L * 24L) {
				return NumberFormatter.format2(value / Format.DOUBLE_DAY_PERIOD) + " day(s)";
			}
			if (value >= 60_000L * 60L) {
				return NumberFormatter.format2(value / Format.DOUBLE_HOUR_PERIOD) + " hour(s)";
			}
			if (value >= 60_000L) {
				return NumberFormatter.format2(value / Format.DOUBLE_MINUTE_PERIOD) + " minute(s)";
			}
			if (value >= 1_000L) {
				return NumberFormatter.format2(value / Format.DOUBLE_SECOND_PERIOD) + " second(s)";
			}
			return NumberFormatter.format2(value) + " ms";
		}
		
		static final int limitStringCompact() {
			
			return Report.MODE_ASSERT || Report.MODE_DEBUG
				? Report.MODE_DEVEL
					? 128
					: 64
				: 32;
		}
		
		private Compact() {
			
			// empty
		}
		
	}
	
	/** Inexact, Human readable
	 *
	 * Text formatting of no more than one paragraph */
	public static final class Describe extends AbstractSAPI {
		
		private static final AbstractFormatDescribeImpl IMPL;
		
		static {
			/** this block should go last */
			{
				IMPL = AbstractSAPI.createObject("ru.myx.ae3.help.ImplementFormatDescribe");
				assert Describe.IMPL != null : "Format.Describe implementation is not accessible!";
			}
		}
		
		/** @param o
		 * @param prefix
		 * @return */
		public static final String toDescription(final Object o, final String prefix) {
			
			return Describe.toDescription(
					new StringBuilder(), //
					o,
					prefix,
					true,
					0,
					3).toString();
		}
		
		/** @param builder
		 * @param o
		 * @param prefix
		 * @param idented
		 * @param depth
		 * @param limit
		 * @return */
		public static final StringBuilder toDescription(final StringBuilder builder, final Object o, final String prefix, final boolean idented, final int depth, final int limit) {
			
			if (!idented && prefix != null) {
				builder.append(prefix);
			}
			
			if (o == null) {
				return Format.Describe.toEcmaSource(builder, BaseObject.UNDEFINED, prefix, idented, depth, limit);
			}
			
			if (o instanceof final BaseObject b) {
				if (b.baseIsPrimitive()) {
					if (b.baseIsPrimitiveString()) {
						return Format.Text.identNewLines(builder, b.baseToJavaString(), prefix);
					}
					
					return builder.append(b.baseToJavaString());
				}
				return Format.Describe.IMPL.toDescription(
						idented
							? builder
							: Describe.ident(builder, prefix, 0),
						b,
						prefix,
						0,
						depth,
						limit);
			}
			
			return Format.Text.identNewLines(builder, String.valueOf(o), prefix);
		}
		
		/** Macro for:
		 * <code>ExecValueFormat.toEcmaSource( new StringBuilder(), Base.forUnknown(o), prefix, true, 0, 3 )</code>
		 *
		 * @param o
		 * @param prefix
		 * @return */
		public static final String toEcmaSource(final Attributes o, final String prefix) {
			
			final BaseMap object = BaseObject.createObject((BaseObject) null);
			for (int i = 0; i < o.getLength(); ++i) {
				object.baseDefine(o.getLocalName(i), o.getValue(i));
			}
			return Describe.toEcmaSource(
					new StringBuilder(), //
					object,
					prefix,
					true,
					0,
					3).toString();
		}
		
		/** @param o
		 * @param prefix
		 * @return */
		public static final String toEcmaSource(final BaseObject o, final String prefix) {
			
			return Describe.toEcmaSource(
					new StringBuilder(), //
					o,
					prefix,
					true,
					0,
					3).toString();
		}
		
		/** Macro for:
		 * <code>ExecValueFormat.toEcmaSource( new StringBuilder(), Base.forUnknown(o), prefix, true, 0, 3 )</code>
		 *
		 * @param o
		 * @param prefix
		 * @return */
		public static final String toEcmaSource(final Object o, final String prefix) {
			
			return Format.Describe.toEcmaSource(
					new StringBuilder(), //
					Base.forUnknown(o),
					prefix,
					true,
					0,
					3).toString();
		}
		
		/** @param builder
		 * @param o
		 * @param prefix
		 * @param idented
		 * @param depth
		 * @param limit
		 * @return */
		public static final StringBuilder
				toEcmaSource(final StringBuilder builder, final BaseObject o, final String prefix, final boolean idented, final int depth, final int limit) {
			
			if (o == null) {
				return Format.Describe.toEcmaSource(builder, BaseObject.UNDEFINED, prefix, idented, depth, limit);
			}
			// assert o != null : "NULL java value";
			if (o.baseIsPrimitive()) {
				if (o.baseIsPrimitiveString()) {
					if (prefix == null || idented) {
						return Describe.toEcmaString(builder, o.baseToJavaString(), true);
					}
					
					return Describe.toEcmaString(
							Describe.ident(builder, prefix, 0), //
							o.baseToJavaString(),
							true);
				}
				builder.append(
						prefix != null && !idented
							? Describe.ident(builder, prefix, 0).append(o.baseToJavaString()).toString()
							: o.baseToJavaString());
				return builder;
			}
			return Format.Describe.IMPL.toEcmaSource(
					idented
						? builder
						: Describe.ident(builder, prefix, 0),
					o,
					prefix,
					0,
					depth,
					limit);
		}
		
		/** @param builder
		 * @param o
		 * @param prefix
		 * @param idented
		 * @param depth
		 * @param limit
		 * @return */
		public static final StringBuilder toEcmaSource(final StringBuilder builder, final Object o, final String prefix, final boolean idented, final int depth, final int limit) {
			
			if (o == null) {
				return Format.Describe.toEcmaSource(builder, BaseObject.UNDEFINED, prefix, idented, depth, limit);
			}
			
			return Describe.toEcmaSource(builder, Base.forUnknown(o), prefix, idented, depth, limit);
		}
		
		/** @param builder
		 * @param string
		 * @param quoted
		 * @return */
		public static final StringBuilder toEcmaString(final StringBuilder builder, final String string, final boolean quoted) {
			
			if (string == null) {
				return builder.append("null");
			}
			final int length = string.length();
			final int limit = Report.MODE_ASSERT || Report.MODE_DEBUG
				? Report.MODE_DEVEL
					? 1024
					: 512
				: 256;
			if (quoted) {
				builder.append('"');
			}
			char prev = 0;
			for (int i = 0; i < length && i < limit; ++i) {
				final char c = string.charAt(i);
				switch (c) {
					case 0 :
						builder.append("\\x00");
						continue;
					case 0xFDD0 :
						builder.append("\\uFDD0");
						continue;
					case 0xFDEF :
						builder.append("\\uFDEF");
						continue;
					case 0xFFFE :
						builder.append("\\uFFFE");
						continue;
					case 0xFFFF :
						builder.append("\\uFFFF");
						continue;
					case '\t' :
						builder.append('\\').append('t');
						continue;
					case '\n' :
						builder.append('\\').append('n');
						continue;
					case '\r' :
						builder.append('\\').append('r');
						continue;
					case '\b' :
						builder.append('\\').append('b');
						continue;
					case '\f' :
						builder.append('\\').append('f');
						continue;
					case '\\' :
					case '"' :
						builder.append('\\').append(c);
						continue;
					/** have escape </script> like </scr\x69pt> */
					case '<' :
						prev = c;
						builder.append(c);
						continue;
					case '/' :
						if (prev == '<') {
							prev = c;
							builder.append(c);
							continue;
						}
						break;
					case 'S' :
					case 's' :
						if (prev == '/') {
							prev = c;
							builder.append(c);
							continue;
						}
						break;
					case 'C' :
					case 'c' :
						if (prev == 's') {
							prev = c;
							builder.append(c);
							continue;
						}
						break;
					case 'R' :
					case 'r' :
						if (prev == 'c') {
							prev = c;
							builder.append(c);
							continue;
						}
						break;
					case 'I' :
					case 'i' :
						if (prev == 'r' && length - i >= 3 && ('p' == string.charAt(i + 1) || 'P' == string.charAt(i + 1))
								&& ('t' == string.charAt(i + 2) || 'T' == string.charAt(i + 2)) && '>' == string.charAt(i + 3)) {
							builder.append('\\');
							builder.append('x');
							builder.append(
									c == 'i'
										? '6' // i
										: '4'); // I
							builder.append('9');
							prev = 0;
							continue;
						}
						//$FALL-THROUGH$
					default :
						break;
				}
				prev = 0;
				if (c < 32) {
					if (c < 16) {
						builder.append("\\x0").append(Integer.toString(c, 16));
						continue;
					}
					builder.append("\\x").append(Integer.toString(c, 16));
					continue;
				}
				builder.append(c);
			}
			if (quoted) {
				builder.append('"');
			}
			if (length > limit) {
				builder.append("... and ");
				builder.append(length - limit);
				builder.append(" of ");
				builder.append(length);
				builder.append(" characters left...");
			}
			
			return builder;
		}
		
		static final StringBuilder ident(final StringBuilder builder, final String ident, final int count) {
			
			if (ident != null) {
				builder.append(ident);
			}
			for (int i = count; i > 0; --i) {
				builder.append("  |  ");
			}
			return builder;
		}
		
		static final String limitStringCompact(final String stringValue) {
			
			final int length = stringValue.length();
			final int limit = Format.Compact.limitStringCompact();
			if (length <= limit) {
				return stringValue.replace("\r", "").replace("\n", "\\n").replace("\t", "\\t");
			}
			return stringValue.substring(0, limit).replace("\r", "").replace("\n", "\\n").replace("\t", "\\t") + "... +" + (length - limit);
		}
		
		static final int limitStringDescribe() {
			
			return Report.MODE_ASSERT || Report.MODE_DEBUG
				? Report.MODE_DEVEL
					? 1024
					: 512
				: 256;
		}
		
		static final String limitStringDescribe(final String stringValue) {
			
			final int length = stringValue.length();
			final int limit = Describe.limitStringDescribe();
			if (length <= limit) {
				return stringValue.replace("\r", "").replace("\n", "\\n").replace("\t", "\\t");
			}
			return stringValue.substring(0, limit).replace("\r", "").replace("\n", "\\n").replace("\t", "\\t") + "... and " + (length - limit) + " of " + length
					+ " characters left...";
		}
		
		private Describe() {
			
			// empty
		}
	}
	
	/** ECMA-related formatting
	 *
	 * ISO 8601 Extended Format */
	public static final class Ecma {
		
		private static final DateFormatterEcma DATE = new DateFormatterEcma();
		
		/** @param date
		 * @return string */
		public static final String date(final Date date) {
			
			return Ecma.DATE.format(date);
		}
		
		/** @param time
		 * @return string */
		public static final String date(final long time) {
			
			return Ecma.DATE.format(time);
		}
		
		/** Returns -1 on error or parsed ECMA date.
		 *
		 * @param string
		 * @return date */
		public static final long dateParse(final String string) {
			
			return Ecma.DATE.parse(string);
		}
		
		/** TODO: Move to Format.Ecma.stringLiteral or something like this
		 *
		 * @param string
		 * @return */
		public static final String string(final CharSequence string) {
			
			return string == null
				? "null"
				: Ecma.string(new StringBuilder(2 + (int) (string.length() * 1.1)), string).toString();
		}
		
		/** @param builder
		 * @param string
		 * @return */
		public static final StringBuilder string(final StringBuilder builder, final CharSequence string) {
			
			if (string == null) {
				return builder.append("null");
			}
			final int length = string.length();
			builder.append('"');
			char prev = 0;
			for (int i = 0; i < length; ++i) {
				final char c = string.charAt(i);
				switch (c) {
					case 0 :
						builder.append("\\x00");
						continue;
					case 0xFDD0 :
						builder.append("\\uFDD0");
						continue;
					case 0xFDEF :
						builder.append("\\uFDEF");
						continue;
					case 0xFFFE :
						builder.append("\\uFFFE");
						continue;
					case 0xFFFF :
						builder.append("\\uFFFF");
						continue;
					case '\t' :
						builder.append('\\').append('t');
						continue;
					case '\n' :
						builder.append('\\').append('n');
						continue;
					case '\r' :
						builder.append('\\').append('r');
						continue;
					case '\b' :
						builder.append('\\').append('b');
						continue;
					case '\f' :
						builder.append('\\').append('f');
						continue;
					case '\\' :
					case '"' :
						builder.append('\\').append(c);
						continue;
					/** have escape </script> like </scr\x69pt> */
					case '<' :
						prev = c;
						builder.append(c);
						continue;
					case '/' :
						if (prev == '<') {
							prev = c;
							builder.append(c);
							continue;
						}
						break;
					case 'S' :
					case 's' :
						if (prev == '/') {
							prev = c;
							builder.append(c);
							continue;
						}
						break;
					case 'C' :
					case 'c' :
						if (prev == 's') {
							prev = c;
							builder.append(c);
							continue;
						}
						break;
					case 'R' :
					case 'r' :
						if (prev == 'c') {
							prev = c;
							builder.append(c);
							continue;
						}
						break;
					case 'I' :
					case 'i' :
						if (prev == 'r' && length - i >= 3 && ('p' == string.charAt(i + 1) || 'P' == string.charAt(i + 1))
								&& ('t' == string.charAt(i + 2) || 'T' == string.charAt(i + 2)) && '>' == string.charAt(i + 3)) {
							builder.append('\\');
							builder.append('x');
							builder.append(
									c == 'i'
										? '6' // i
										: '4'); // I
							builder.append('9');
							prev = 0;
							continue;
						}
						//$FALL-THROUGH$
					default :
						break;
				}
				prev = 0;
				if (c < 32) {
					if (c < 16) {
						builder.append("\\x0").append(Integer.toString(c, 16));
						continue;
					}
					builder.append("\\x").append(Integer.toString(c, 16));
					continue;
				}
				builder.append(c);
			}
			builder.append('"');
			return builder;
		}
		
		private Ecma() {
			
			// empty
		}
	}
	
	/** Exact, Machine/Human readable */
	public static final class Exact {
		
		/** @param value
		 * @return string */
		public static final String toBytes(double value) {
			
			if (value <= 0) {
				return String.valueOf(value);
			}
			final StringBuilder result = new StringBuilder(64);
			if (value > 1024L * 1024L * 1024L * 1024L) {
				final int ml = (int) (value / (1024L * 1024L * 1024L * 1024L));
				value -= 1024L * 1024L * 1024L * 1024L * ml;
				result.append(ml).append('T');
			}
			if (value > 1024L * 1024L * 1024L) {
				final int ml = (int) (value / (1024L * 1024L * 1024L));
				value -= 1024L * 1024L * 1024L * ml;
				result.append(ml).append('G');
			}
			if (value > 1024L * 1024L) {
				final int ml = (int) (value / (1024L * 1024L));
				value -= 1024L * 1024L * ml;
				result.append(ml).append('M');
			}
			if (value > 1024L) {
				final int ml = (int) (value / 1024L);
				value -= 1024L * ml;
				result.append(ml).append('k');
			}
			if (value > 0) {
				result.append(value);
			}
			return result.toString();
		}
		
		/** @param value
		 * @return string */
		public static final String toBytes(long value) {
			
			if (value <= 0) {
				return String.valueOf(value);
			}
			final StringBuilder result = new StringBuilder(64);
			if (value > 1024L * 1024L * 1024L * 1024L) {
				final int ml = (int) (value / (1024L * 1024L * 1024L * 1024L));
				value -= 1024L * 1024L * 1024L * 1024L * ml;
				result.append(ml).append('T');
			}
			if (value > 1024L * 1024L * 1024L) {
				final int ml = (int) (value / (1024L * 1024L * 1024L));
				value -= 1024L * 1024L * 1024L * ml;
				result.append(ml).append('G');
			}
			if (value > 1024L * 1024L) {
				final int ml = (int) (value / (1024L * 1024L));
				value -= 1024L * 1024L * ml;
				result.append(ml).append('M');
			}
			if (value > 1024L) {
				final int ml = (int) (value / 1024L);
				value -= 1024L * ml;
				result.append(ml).append('k');
			}
			if (value > 0) {
				result.append(value);
			}
			return result.toString();
		}
		
		/** @param value
		 * @return string */
		public static final String toPeriod(long value) {
			
			if (value <= 0) {
				return String.valueOf(value);
			}
			final StringBuilder result = new StringBuilder(64);
			if (value > 60_000L * 60L * 24L * 7L) {
				final int ml = (int) (value / (60_000L * 60L * 24L * 7L));
				value -= 60_000L * 60L * 24L * 7L * ml;
				result.append(ml).append('w');
			}
			if (value > 60_000L * 60L * 24L) {
				final int ml = (int) (value / (60_000L * 60L * 24L));
				value -= 60_000L * 60L * 24L * ml;
				result.append(ml).append('d');
			}
			if (value > 60_000L * 60L) {
				final int ml = (int) (value / (60_000L * 60L));
				value -= 60_000L * 60L * ml;
				result.append(ml).append('h');
			}
			if (value > 60_000L) {
				final int ml = (int) (value / 60_000L);
				value -= 60_000L * ml;
				result.append(ml).append('m');
			}
			if (value > 1_000L) {
				final int ml = (int) (value / 1_000L);
				value -= 1_000L * ml;
				result.append(ml).append('s');
			}
			if (value > 0) {
				result.append(value);
			}
			return result.toString();
		}
		
		private Exact() {
			
			// empty
		}
	}
	
	/** @author myx */
	public static final class Round {
		
		/** @param value
		 * @return string */
		public static final String toBytes(final long value) {
			
			if (value < 0) {
				return '-' + Format.Round.toBytes(-value);
			}
			if (value < 1_000L) {
				return String.valueOf(value) + ' ';
			}
			if (value >= 3 * Format.DOUBLE_TERA_BYTES) {
				return (int) (value / Format.DOUBLE_TERA_BYTES) + " T";
			}
			if (value >= 3 * Format.DOUBLE_GIGA_BYTES) {
				return (int) (value / Format.DOUBLE_GIGA_BYTES) + " G";
			}
			if (value >= 3 * Format.DOUBLE_MEGA_BYTES) {
				return (int) (value / Format.DOUBLE_MEGA_BYTES) + " M";
			}
			return (int) (value / Format.DOUBLE_KILO_BYTES) + " k";
		}
		
		/** @param value
		 * @return string */
		public static final String toDecimal(final double value) {
			
			if (Double.isInfinite(value)) {
				return value > 0
					? "+inf"
					: "-inf";
			}
			if (Double.isNaN(value)) {
				return "NaN";
			}
			if (value < 0) {
				return '-' + Format.Round.toDecimal(-value);
			}
			if (value < Format.DOUBLE_NANO) {
				return "0";
			}
			if (value >= 4 * 1_000_000_000_000L) {
				return (int) (value / Format.DOUBLE_TERA) + "T";
			}
			if (value >= 4 * 1_000_000_000L) {
				return (int) (value / Format.DOUBLE_GIGA) + "G";
			}
			if (value >= 4 * 1_000_000L) {
				return (int) (value / Format.DOUBLE_MEGA) + "M";
			}
			if (value >= 4 * 1_000L) {
				return (int) (value / Format.DOUBLE_KILO) + "k";
			}
			if (value >= 10L) {
				return String.valueOf((int) value);
			}
			if (value >= 1L) {
				/** Just more human-readable */
				return String.valueOf((int) value);
			}
			if (value >= 10 * Format.DOUBLE_MILLI) {
				return (int) (value / Format.DOUBLE_MILLI) + "ml";
			}
			if (value >= 10 * Format.DOUBLE_MICRO) {
				return (int) (value / Format.DOUBLE_MICRO) + "mk";
			}
			return (int) (value / Format.DOUBLE_NANO) + "n";
		}
		
		/** @param value
		 * @return string */
		public static final String toPeriod(final long value) {
			
			if (value <= 0) {
				return String.valueOf(value);
			}
			if (value >= 3 * 60_000L * 60L * 24L * 7L) {
				return (int) (value / Format.DOUBLE_WEEK_PERIOD) + " week(s)";
			}
			if (value >= 3 * 60_000L * 60L * 24L) {
				return (int) (value / Format.DOUBLE_DAY_PERIOD) + " day(s)";
			}
			if (value >= 3 * 60_000L * 60L) {
				return (int) (value / Format.DOUBLE_HOUR_PERIOD) + " hour(s)";
			}
			if (value >= 3 * 60_000L) {
				return (int) (value / Format.DOUBLE_MINUTE_PERIOD) + " minute(s)";
			}
			if (value >= 3 * 1_000L) {
				return (int) (value / Format.DOUBLE_SECOND_PERIOD) + " second(s)";
			}
			return (int) value + " ms";
		}
		
		private Round() {
			
			// empty
		}
	}
	
	/** @author myx */
	public static final class Text {
		
		/** excluding initial line. ignores '\r'
		 *
		 * @param target
		 * @param string
		 * @param ident
		 * @return */
		public static final StringBuilder identNewLines(final StringBuilder target, final CharSequence string, final String ident) {
			
			if (ident == null || ident.isEmpty()) {
				return target.append(string);
			}
			
			final int length = string.length();
			for (int i = 0; i < length; ++i) {
				final char c = string.charAt(i);
				switch (c) {
					case '\n' :
						target.append(c).append(ident);
						continue;
					case '\r' :
						continue;
					default :
						target.append(c);
				}
			}
			return target;
		}
	}
	
	/** @author myx */
	public static final class Throwable {
		
		private static final void fill(final StringBuilder target, final java.lang.Throwable t, final int level) {
			
			Throwable.ident(target, level).append("> ").append(t.getLocalizedMessage()).append("\r\n");
			Throwable.ident(target, level).append("> ").append(t.getClass().getName()).append("\r\n");
			final java.lang.Throwable cause = t.getCause();
			if (cause != null) {
				Throwable.fill(target, cause, level + 1);
			} else {
				try {
					final StackTraceElement[] stack = t.getStackTrace();
					if (stack != null) {
						String previous = "";
						for (final StackTraceElement element : stack) {
							final String string = element.toString();
							if (string.endsWith(":1)") && //
									previous.startsWith(string.substring(0, string.length() - 2))) {
								continue;
							}
							previous = string;
							Throwable.ident(target, level).append("  : ").append(string).append("\r\n");
						}
					}
				} catch (final java.lang.Throwable anything) {
					String text;
					try {
						text = anything.getMessage();
					} catch (final java.lang.Throwable anythingAgain) {
						text = "Class:" + anything.getClass().getName();
					}
					Throwable.ident(target, level).append("  : Unthinkable: ").append(text).append("\r\n");
				}
			}
		}
		
		private static final StringBuilder ident(final StringBuilder target, final int ident) {
			
			for (int i = ident; i > 0; --i) {
				target.append("    ");
			}
			return target;
		}
		
		/** @param t
		 * @return string */
		public static final String toText(final java.lang.Throwable t) {
			
			if (t == null) {
				return "Exception is NULL!";
			}
			final StringBuilder sb = new StringBuilder(2048);
			Throwable.fill(sb, t, 0);
			return sb.toString();
		}
		
		/** @param info
		 * @param t
		 * @return string */
		public static final String toText(final String info, final java.lang.Throwable t) {
			
			final StringBuilder sb = new StringBuilder(info).append("\r\n");
			Throwable.fill(sb, t, 1);
			return sb.toString();
		}
		
		private Throwable() {
			
			// empty
		}
	}
	
	/** Common web formatting */
	public static final class Web {
		
		private static final DateFormatterWeb DATE = new DateFormatterWeb();
		
		/** @param date
		 * @return string */
		public static final String date(final Date date) {
			
			return Web.DATE.format(date);
		}
		
		/** @param time
		 * @return string */
		public static final String date(final long time) {
			
			return Web.DATE.format(time);
		}
		
		/** Returns -1 on error or parsed HTTP date.
		 *
		 * @param string
		 * @return date */
		public static final long dateParse(final String string) {
			
			return Web.DATE.parse(string);
		}
		
		private Web() {
			
			// empty
		}
	}
	
	/** Common xml formatting */
	public static final class Xml {
		
		/** Is this string an exact valid element attribute value.
		 *
		 * @param string
		 * @return */
		public static final boolean isValidAttributeValue(final CharSequence string) {
			
			for (int i = string.length() - 1; i > 0; --i) {
				if (!Format.Xml.isValidAttributeValueChar(string.charAt(i))) {
					return false;
				}
			}
			return true;
		}
		
		/** FIXME: not properly implemented
		 *
		 * [67] Reference ::= EntityRef | CharRef
		 *
		 *
		 * [66] CharRef ::= '&#' [0-9]+ ';' | '&#x' [0-9a-fA-F]+ ';' [WFC: Legal Character]
		 *
		 * [68] EntityRef ::= '&' Name ';'
		 *
		 * [10] AttValue ::= '"' ([^<&"] | Reference)* '"' | "'" ([^<&'] | Reference)* "'"
		 *
		 * @param c
		 * @return */
		public static final boolean isValidAttributeValueChar(final char c) {
			
			if (c < 32) {
				return false;
			}
			/** and c >= 32 ^^^ */
			if (c <= 127 || c == 0xB7) {
				return true;
			}
			/** same as in first char */
			if (c >= 0xC0 && c <= 0xD6) {
				return true;
			}
			if (c >= 0xD8 && c <= 0xF6) {
				return true;
			}
			if (c >= 0xF8 && c <= 0x2FF) {
				return true;
			}
			if (c >= 0x370 && c <= 0x37D) {
				return true;
			}
			if (c >= 0x37F && c <= 0x1FFF) {
				return true;
			}
			if (c >= 0x200C && c <= 0x200D) {
				return true;
			}
			if (c >= 0x2070 && c <= 0x218F) {
				return true;
			}
			if (c >= 0x2C00 && c <= 0x2FEF) {
				return true;
			}
			if (c >= 0x3001 && c <= 0xD7FF) {
				return true;
			}
			if (c >= 0xF900 && c <= 0xFDCF) {
				return true;
			}
			if (c >= 0xFDF0 && c <= 0xFFFD) {
				return true;
			}
			if (c >= 0x10000 && c <= 0xEFFFF) {
				return true;
			}
			/** added by body char */
			if (c >= 0x300 && c <= 0x36F) {
				return true;
			}
			if (c >= 0x203F && c <= 0x2040) {
				return true;
			}
			return false;
		}
		
		/** Is this string an exact valid character data (CDATA) block.
		 *
		 * @param string
		 * @return */
		public static final boolean isValidCharacterData(final CharSequence string) {
			
			final int length = string.length();
			for (int i = length - 1; i > 0; --i) {
				if (!Format.Xml.isValidCharacterDataChar(string.charAt(i))) {
					return false;
				}
			}
			return true;
		}
		
		/** FIXME: exclude ']]>'
		 *
		 * [20] CData ::= (Char* - (Char* ']]>' Char*))
		 *
		 *
		 * Character Range
		 *
		 * [2] Char ::= #x9 | #xA | #xD | [#x20-#xD7FF] | [#xE000-#xFFFD] | [#x10000-#x10FFFF]
		 *
		 * any Unicode character, excluding the surrogate blocks, FFFE, and FFFF.
		 *
		 *
		 *
		 *
		 * @param c
		 * @return */
		public static final boolean isValidCharacterDataChar(final char c) {
			
			switch (c) {
				case 0x09 :
				case 0x0A :
				case 0x0D :
					return true;
				default :
					break;
			}
			if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') {
				return true;
			}
			if (c >= '0' && c <= '9') {
				return true;
			}
			/** same as in first char */
			if (c >= 0x20 && c <= 0xD7FF) {
				return true;
			}
			if (c >= 0xE000 && c <= 0xFFFD) {
				return true;
			}
			if (c >= 0x10000 && c <= 0x10FFFF) {
				return true;
			}
			return false;
		}
		
		/** Is this string an exact valid element name or attribute name. Yes according to XML
		 * specification there are same rules for both element names and attribute names.
		 *
		 * @param string
		 * @return */
		public static final boolean isValidName(final CharSequence string) {
			
			final int length = string.length();
			if (length == 0) {
				return false;
			}
			if (!Format.Xml.isValidNameStartChar(string.charAt(0))) {
				return false;
			}
			for (int i = length - 1; i > 0; --i) {
				if (!Format.Xml.isValidNameBodyChar(string.charAt(i))) {
					return false;
				}
			}
			return true;
		}
		
		/** NameStartChar ::= ":" | [A-Z] | "_" | [a-z] | [#xC0-#xD6] | [#xD8-#xF6] | [#xF8-#x2FF] |
		 * [#x370-#x37D] | [#x37F-#x1FFF] | [#x200C-#x200D] | [#x2070-#x218F] | [#x2C00-#x2FEF] |
		 * [#x3001-#xD7FF] | [#xF900-#xFDCF] | [#xFDF0-#xFFFD] | [#x10000-#xEFFFF]
		 *
		 * NameChar ::= NameStartChar | "-" | "." | [0-9] | #xB7 | [#x0300-#x036F] | [#x203F-#x2040]
		 *
		 *
		 * @param c
		 * @return */
		public static final boolean isValidNameBodyChar(final char c) {
			
			switch (c) {
				case ':' :
				case '_' :
				case '-' :
				case '.' :
				case 0xB7 :
					return true;
				default :
					break;
			}
			if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') {
				return true;
			}
			if (c >= '0' && c <= '9') {
				return true;
			}
			/** same as in first char */
			if (c >= 0xC0 && c <= 0xD6) {
				return true;
			}
			if (c >= 0xD8 && c <= 0xF6) {
				return true;
			}
			if (c >= 0xF8 && c <= 0x2FF) {
				return true;
			}
			if (c >= 0x370 && c <= 0x37D) {
				return true;
			}
			if (c >= 0x37F && c <= 0x1FFF) {
				return true;
			}
			if (c >= 0x200C && c <= 0x200D) {
				return true;
			}
			if (c >= 0x2070 && c <= 0x218F) {
				return true;
			}
			if (c >= 0x2C00 && c <= 0x2FEF) {
				return true;
			}
			if (c >= 0x3001 && c <= 0xD7FF) {
				return true;
			}
			if (c >= 0xF900 && c <= 0xFDCF) {
				return true;
			}
			if (c >= 0xFDF0 && c <= 0xFFFD) {
				return true;
			}
			if (c >= 0x10000 && c <= 0xEFFFF) {
				return true;
			}
			/** added by body char */
			if (c >= 0x300 && c <= 0x36F) {
				return true;
			}
			if (c >= 0x203F && c <= 0x2040) {
				return true;
			}
			return false;
		}
		
		/** NameStartChar ::= ":" | [A-Z] | "_" | [a-z] | [#xC0-#xD6] | [#xD8-#xF6] | [#xF8-#x2FF] |
		 * [#x370-#x37D] | [#x37F-#x1FFF] | [#x200C-#x200D] | [#x2070-#x218F] | [#x2C00-#x2FEF] |
		 * [#x3001-#xD7FF] | [#xF900-#xFDCF] | [#xFDF0-#xFFFD] | [#x10000-#xEFFFF]
		 *
		 * @param c
		 * @return */
		public static final boolean isValidNameStartChar(final char c) {
			
			switch (c) {
				case ':' :
				case '_' :
					return true;
				default :
					break;
			}
			if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') {
				return true;
			}
			if (c >= 0xC0 && c <= 0xD6) {
				return true;
			}
			if (c >= 0xD8 && c <= 0xF6) {
				return true;
			}
			if (c >= 0xF8 && c <= 0x2FF) {
				return true;
			}
			if (c >= 0x370 && c <= 0x37D) {
				return true;
			}
			if (c >= 0x37F && c <= 0x1FFF) {
				return true;
			}
			if (c >= 0x200C && c <= 0x200D) {
				return true;
			}
			if (c >= 0x2070 && c <= 0x218F) {
				return true;
			}
			if (c >= 0x2C00 && c <= 0x2FEF) {
				return true;
			}
			if (c >= 0x3001 && c <= 0xD7FF) {
				return true;
			}
			if (c >= 0xF900 && c <= 0xFDCF) {
				return true;
			}
			if (c >= 0xFDF0 && c <= 0xFFFD) {
				return true;
			}
			if (c >= 0x10000 && c <= 0xEFFFF) {
				return true;
			}
			return false;
		}
		
		/** Basic reference escaping
		 *
		 * @param string
		 * @param target
		 * @return
		 * @throws IOException */
		public static final <T extends Appendable> T xmlAttributeFragmentImpl(final String string, final T target) throws IOException {
			
			final int length = string.length();
			for (int i = 0; i < length; ++i) {
				final char c = string.charAt(i);
				switch (c) {
					case '&' :
						target.append("&amp;");
						continue;
					case '>' :
						target.append("&gt;");
						continue;
					case '<' :
						target.append("&lt;");
						continue;
					case '"' :
						target.append("&quot;");
						continue;
					case '\'' :
						target.append("&#39;");
						continue;
					case '\n' :
						target.append("&#10;");
						continue;
					case '\r' :
						// builder.append( "&#13;" );
						continue;
					default :
						target.append(c);
				}
			}
			return target;
		}
		
		/** Basic reference escaping
		 *
		 * Skips if name is illegal or value is undefined.
		 *
		 * @param name
		 * @param value
		 * @param builder
		 * @return
		 * @throws IOException */
		public static final <T extends Appendable> T xmlAttributeImpl(final String name, final Object value, final T builder) throws IOException {
			
			if (value == null || value == BaseObject.UNDEFINED) {
				return builder;
			}
			if (name == null || !Xml.isValidName(name)) {
				return builder;
			}
			builder.append(' ');
			builder.append(name);
			builder.append('=');
			Format.Xml.xmlAttributeValueImpl(value, builder);
			return builder;
		}
		
		/** Basic reference escaping and attribute value quotes
		 *
		 * @param string
		 * @param target
		 * @return
		 * @throws IOException */
		public static final <T extends Appendable> T xmlAttributeValueImpl(final Object string, final T target) throws IOException {
			
			if (string == null) {
				target.append("\"\"");
				return target;
			}
			if (string instanceof Date) {
				return Xml.xmlAttributeValueImpl(Format.Ecma.date((Date) string), target);
			}
			final String s = string.toString();
			if (s == null) {
				target.append("\"\"");
				return target;
			}
			final int length = s.length();
			if (length == 0) {
				target.append("\"\"");
				return target;
			}
			target.append('"');
			Xml.xmlAttributeFragmentImpl(s, target);
			target.append('"');
			return target;
		}
		
		/** Basic reference escaping
		 *
		 * @param o
		 * @param target
		 * @return
		 * @throws IOException */
		public static final <T extends Appendable> T xmlNodeValueImpl(final Object o, final T target) throws IOException {
			
			if (o == null || o == BaseObject.UNDEFINED) {
				return target;
			}
			final String s = o.toString();
			final int length = s.length();
			for (int i = 0; i < length; ++i) {
				final char c = s.charAt(i);
				switch (c) {
					case '&' :
						if (!s.regionMatches(true, i + 1, "amp;", 0, 4)) {
							target.append("&amp;");
						} else {
							target.append(c);
						}
						continue;
					case '>' :
						target.append("&gt;");
						continue;
					case '<' :
						target.append("&lt;");
						continue;
					case '"' :
						target.append("&quot;");
						continue;
					case '\'' :
						target.append("&#39;");
						continue;
					case '\n' :
						target.append("&#10;");
						continue;
					case '\r' :
						// builder.append( "&#13;" );
						continue;
					default :
						target.append(c);
				}
			}
			return target;
		}
		
	}
	
	/**
	 *
	 */
	public static final double DOUBLE_KILO_BYTES = 1024L;
	
	/**
	 *
	 */
	public static final double DOUBLE_MEGA_BYTES = 1024L * 1024L;
	
	/**
	 *
	 */
	public static final double DOUBLE_GIGA_BYTES = 1024L * 1024L * 1024L;
	
	/**
	 *
	 */
	public static final double DOUBLE_TERA_BYTES = 1024L * 1024L * 1024L * 1024L;
	
	/**
	 *
	 */
	public static final double DOUBLE_MILLI_BYTES = Format.DOUBLE_KILO_BYTES / Format.DOUBLE_MEGA_BYTES;
	
	/**
	 *
	 */
	public static final double DOUBLE_MICRO_BYTES = Format.DOUBLE_KILO_BYTES / Format.DOUBLE_GIGA_BYTES;
	
	/**
	 *
	 */
	public static final double DOUBLE_NANO_BYTES = Format.DOUBLE_KILO_BYTES / Format.DOUBLE_TERA_BYTES;
	
	/**
	 *
	 */
	public static final double DOUBLE_KILO = 1_000L;
	
	/**
	 *
	 */
	public static final double DOUBLE_MEGA = 1_000L * 1_000L;
	
	/**
	 *
	 */
	public static final double DOUBLE_GIGA = 1_000L * 1_000L * 1_000L;
	
	/**
	 *
	 */
	public static final double DOUBLE_TERA = 1_000L * 1_000L * 1_000L * 1_000L;
	
	/**
	 *
	 */
	public static final double DOUBLE_MILLI = 1_000L / Format.DOUBLE_MEGA;
	
	/**
	 *
	 */
	public static final double DOUBLE_MICRO = 1_000L / Format.DOUBLE_GIGA;
	
	/**
	 *
	 */
	public static final double DOUBLE_NANO = 1_000L / Format.DOUBLE_TERA;
	
	/**
	 *
	 */
	public static final double DOUBLE_SECOND_PERIOD = 1_000L;
	
	/**
	 *
	 */
	public static final double DOUBLE_MINUTE_PERIOD = 60_000L;
	
	/**
	 *
	 */
	public static final double DOUBLE_HOUR_PERIOD = 60_000L * 60L;
	
	/**
	 *
	 */
	public static final double DOUBLE_DAY_PERIOD = 60_000L * 60L * 24L;
	
	/**
	 *
	 */
	public static final double DOUBLE_WEEK_PERIOD = 60_000L * 60L * 24L * 7L;
	
	/**
	 *
	 */
	public static final double DOUBLE_MILLISECOND_PERIOD = 1.0;
	
	/**
	 *
	 */
	public static final double DOUBLE_MICROSECOND_PERIOD = Format.DOUBLE_MILLISECOND_PERIOD / 1000.0;
	
	/**
	 *
	 */
	public static final double DOUBLE_NANOSECOND_PERIOD = Format.DOUBLE_MICROSECOND_PERIOD / 1000.0;
	
	private Format() {
		
		// empty
	}
}
