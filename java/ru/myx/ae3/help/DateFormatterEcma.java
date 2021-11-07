/**
 * Created on 23.12.2002
 *
 * To change this generated comment edit the template variable "filecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of file comments go to
 * Window>Preferences>Java>Code Generation.
 */
package ru.myx.ae3.help;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/** @author myx
 *
 *         myx - barachta "typecomment": Window>Preferences>Java>Templates. To enable and disable
 *         the creation of type comments go to Window>Preferences>Java>Code Generation. */
final class DateFormatterEcma {

	static final class Formatter {

		// 2012-10-09T16:56:32.032+0000
		private final SimpleDateFormat format28Z;

		// 2012-10-09T16:56:32.032Z
		private final SimpleDateFormat format24z;

		// 2012-10-09T16:56:32+0000
		private final SimpleDateFormat format24Z;

		// 2012-10-09T16:56:32Z
		private final SimpleDateFormat format20z;

		// 20121009T165632032Z
		private final SimpleDateFormat format19z;

		// 2012-10-09T16:56Z
		private final SimpleDateFormat format17z;

		// 20121009T165632Z
		private final SimpleDateFormat format16z;

		// 20121009T1656Z
		private final SimpleDateFormat format14z;

		// 2012-10-09 (Z)
		private final SimpleDateFormat format10D;

		// 2012-10 (Z)
		private final SimpleDateFormat format07D;

		// 2012 (Z)
		private final SimpleDateFormat format04D;

		/** used only for 'format' (default format for 'long' argument) */
		private final Date dateFor24;

		Formatter() {

			// TODO: add [+/-]yyyyyy (6 digit years)
			/** http://www.ecma-international.org/ecma-262/5.1/#sec-15.9.1.15.1 <code>
			this.format27P = new SimpleDateFormat("'+'yyyyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
			this.format27N = new SimpleDateFormat("'-'yyyyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
			this.format23P = new SimpleDateFormat("'+'yyyyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
			this.format23N = new SimpleDateFormat("'-'yyyyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
			this.format20P = new SimpleDateFormat("'+'yyyyyy-MM-dd'T'HH:mm'Z'", Locale.ENGLISH);
			this.format20N = new SimpleDateFormat("'-'yyyyyy-MM-dd'T'HH:mm'Z'", Locale.ENGLISH);


			</code> */

			this.format28Z = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH);
			this.format24z = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
			this.format24Z = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH);
			this.format20z = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
			this.format19z = new SimpleDateFormat("yyyyMMdd'T'HHmmssSSS'Z'", Locale.ENGLISH);
			this.format17z = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'", Locale.ENGLISH);
			this.format16z = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'", Locale.ENGLISH);
			this.format14z = new SimpleDateFormat("yyyyMMdd'T'HHmm'Z'", Locale.ENGLISH);
			this.format10D = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			this.format07D = new SimpleDateFormat("yyyy-MM", Locale.ENGLISH);
			this.format04D = new SimpleDateFormat("yyyy", Locale.ENGLISH);

			final TimeZone timeZone = TimeZone.getTimeZone("GMT");
			this.format28Z.setTimeZone(timeZone);
			this.format24z.setTimeZone(timeZone);
			this.format24Z.setTimeZone(timeZone);
			this.format20z.setTimeZone(timeZone);
			this.format19z.setTimeZone(timeZone);
			this.format17z.setTimeZone(timeZone);
			this.format16z.setTimeZone(timeZone);
			this.format14z.setTimeZone(timeZone);
			this.format10D.setTimeZone(timeZone);
			this.format07D.setTimeZone(timeZone);
			this.format04D.setTimeZone(timeZone);

			this.dateFor24 = new Date(0);
		}

		final String format(final Date date) {

			final SimpleDateFormat format = this.format24z;
			synchronized (format) {
				return format.format(date);
			}
		}

		final String format(final long time) {

			final SimpleDateFormat format = this.format24z;
			synchronized (format) {
				this.dateFor24.setTime(time);
				return format.format(this.dateFor24);
			}
		}

		final long parse(final String date) throws ParseException {

			final SimpleDateFormat format;
			switch (date.length()) {
				// 2012-10-09T16:56:32.032+0000
				case 28 : {
					if (date.charAt(10) == 'T') {
						format = this.format28Z;
						break;
					}
					throw new IllegalArgumentException("Unknown [28] date format: " + date);
				}
				// 2012-10-09T16:56:32.032Z
				// 2012-10-09T16:56:32+0000
				case 24 : {
					if (date.charAt(10) == 'T') {
						if (date.charAt(19) == '.') {
							format = this.format24z;
						} else {
							format = this.format24Z;
						}
						break;
					}
					throw new IllegalArgumentException("Unknown [24] date format: " + date);
				}
				// 2012-10-09T16:56:32Z
				case 20 : {
					if (date.charAt(10) == 'T') {
						format = this.format20z;
						break;
					}
					throw new IllegalArgumentException("Unknown [20] date format: " + date);
				}
				// 20121009T165632032Z
				case 19 : {
					if (date.charAt(8) == 'T') {
						format = this.format19z;
						break;
					}
					throw new IllegalArgumentException("Unknown [19] date format: " + date);
				}
				// 2012-10-09T16:56Z
				case 17 : {
					if (date.charAt(10) == 'T') {
						format = this.format17z;
						break;
					}
					throw new IllegalArgumentException("Unknown [17] date format: " + date);
				}
				// 20121009T165632Z
				case 16 : {
					if (date.charAt(8) == 'T') {
						format = this.format16z;
						break;
					}
					throw new IllegalArgumentException("Unknown [16] date format: " + date);
				}
				// 20121009T1656Z
				case 14 : {
					if (date.charAt(8) == 'T') {
						format = this.format14z;
						break;
					}
					throw new IllegalArgumentException("Unknown [14] date format: " + date);
				}
				// 2012-10-09
				case 10 : {
					if (date.charAt(4) == '-') {
						format = this.format10D;
						break;
					}
					throw new IllegalArgumentException("Unknown [10] date format: " + date);
				}
				// 2012-10
				case 7 : {
					if (date.charAt(4) == '-') {
						format = this.format07D;
						break;
					}
					throw new IllegalArgumentException("Unknown [7] date format: " + date);
				}
				// 2012
				case 4 : {
					format = this.format04D;
					break;
				}
				default : {
					throw new IllegalArgumentException("Unknown date format: " + date);
				}
			}
			synchronized (format) {
				return format.parse(date).getTime();
			}
		}
	}

	private static final int CAPACITY = 32;

	private static final int MASK = DateFormatterEcma.CAPACITY - 1;

	private int counter = 0;

	private final Formatter[] formatters = new Formatter[DateFormatterEcma.CAPACITY];

	DateFormatterEcma() {

		for (int i = DateFormatterEcma.MASK; i >= 0; --i) {
			this.formatters[i] = new Formatter();
		}
	}

	final String format(final Date date) {

		final Formatter format = this.formatters[--this.counter & DateFormatterEcma.MASK];
		return format.format(date);
	}

	final String format(final long date) {

		final Formatter format = this.formatters[--this.counter & DateFormatterEcma.MASK];
		return format.format(date);
	}

	long parse(final String date) {

		final Formatter format = this.formatters[--this.counter & DateFormatterEcma.MASK];
		try {
			return format.parse(date);
		} catch (final Throwable t) {
			return -1L;
		}
	}

	@Override
	public String toString() {

		return "ae2core Ecma Date formatter, capacity=" + DateFormatterEcma.CAPACITY;
	}

}
