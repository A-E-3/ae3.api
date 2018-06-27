package ru.myx.ae3.base;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

final class NumberFormatter {
	private static final int			CAPACITY	= 32;
	
	private static volatile int			counter		= 0;
	
	private static final NumberFormat[]	POOL1		= new NumberFormat[NumberFormatter.CAPACITY];
	
	static {
		for (int i = 0; i < NumberFormatter.CAPACITY; ++i) {
			NumberFormatter.POOL1[i] = NumberFormat.getInstance( Locale.US );
			NumberFormatter.POOL1[i].setMinimumIntegerDigits( 1 );
			NumberFormatter.POOL1[i].setGroupingUsed( false );
		}
	}
	
	static String formatFixed(final double d, final int digits) {
		final int index = NumberFormatter.counter++;
		final NumberFormat current = NumberFormatter.POOL1[index % NumberFormatter.CAPACITY];
		synchronized (current) {
			current.setMaximumFractionDigits( digits );
			current.setMinimumFractionDigits( digits );
			return current.format( d );
		}
	}
	
	static String formatPrecision(final double d, final int digits) {
		/**
		 * FIXME incorrect,
		 * https://developer.mozilla.org/en/JavaScript/Reference
		 * /Global_Objects/Number/toPrecision
		 */
		final int index = NumberFormatter.counter++;
		final NumberFormat current = NumberFormatter.POOL1[index % NumberFormatter.CAPACITY];
		final BigDecimal decimal = BigDecimal.valueOf( d );
		final int precision = decimal.precision();
		final int scale = decimal.scale();
		synchronized (current) {
			if (precision >= scale) {
				current.setMaximumFractionDigits( digits - (precision - scale) );
				current.setMinimumFractionDigits( 0 );
			} else {
				current.setMaximumFractionDigits( 0 );
				current.setMinimumFractionDigits( 0 );
			}
			return current.format( d );
		}
	}
	
	private NumberFormatter() {
		//
	}
}
