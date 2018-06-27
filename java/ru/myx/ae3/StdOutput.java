package ru.myx.ae3;

import java.io.OutputStream;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author myx
 * 		
 */
final class StdOutput extends PrintStream {
	
	private static final NumberFormat STAMP = StdOutput.createTimestampFormat();
	
	private static final StringBuilder BUILDER = new StringBuilder(256);
	
	/**
	 * @return format
	 */
	private static final NumberFormat createTimestampFormat() {
		
		final NumberFormat result = NumberFormat.getInstance(Locale.US);
		result.setMaximumFractionDigits(2);
		result.setMinimumFractionDigits(2);
		result.setMinimumIntegerDigits(6);
		result.setGroupingUsed(false);
		return result;
	}
	
	private boolean clean = true;
	
	private final long started;
	
	/**
	 * @param out
	 * @param flush
	 */
	StdOutput(final long started, final OutputStream out, final boolean flush) {
		super(out, flush);
		this.started = started;
	}
	
	@Override
	public void print(final Object message) {
		
		this.print(String.valueOf(message));
	}
	
	@Override
	public void print(final String message) {
		
		synchronized (this) {
			if (this.clean) {
				/**
				 * collecting as one to reduce mess with other thread's possible
				 * output
				 */
				StdOutput.BUILDER.setLength(0);
				StdOutput.BUILDER.append(StdOutput.STAMP.format((System.currentTimeMillis() - this.started) / 1000.0d));
				StdOutput.BUILDER.append(' ');
				StdOutput.BUILDER.append('[');
				StdOutput.BUILDER.append(Thread.currentThread().getId());
				StdOutput.BUILDER.append(']');
				StdOutput.BUILDER.append(':');
				StdOutput.BUILDER.append(' ');
				StdOutput.BUILDER.append(message);
				super.print(StdOutput.BUILDER.toString());
				StdOutput.BUILDER.setLength(0);
				this.clean = false;
			} else {
				super.print(message);
			}
		}
	}
	
	@Override
	public void println(final Object message) {
		
		this.println(String.valueOf(message));
	}
	
	@Override
	public void println(final String message) {
		
		synchronized (this) {
			if (this.clean) {
				/**
				 * collecting as one to reduce mess with other thread's possible
				 * output
				 */
				StdOutput.BUILDER.setLength(0);
				StdOutput.BUILDER.append(StdOutput.STAMP.format((System.currentTimeMillis() - this.started) / 1000.0d));
				StdOutput.BUILDER.append(' ');
				StdOutput.BUILDER.append('[');
				StdOutput.BUILDER.append(Thread.currentThread().getId());
				StdOutput.BUILDER.append(']');
				StdOutput.BUILDER.append(':');
				StdOutput.BUILDER.append(' ');
				StdOutput.BUILDER.append(message);
				this.clean = false;
				super.println(StdOutput.BUILDER.toString());
				StdOutput.BUILDER.setLength(0);
				this.clean = true;
			} else {
				super.println(message);
				this.clean = true;
			}
		}
	}
}
