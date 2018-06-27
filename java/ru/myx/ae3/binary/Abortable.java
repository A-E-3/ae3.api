package ru.myx.ae3.binary;

import java.util.function.Function;

/**
 * @author myx
 *
 */
public interface Abortable {
	
	/**
	 *
	 */
	Function<Abortable, Void> ABORT_FUNCTION = new Function<Abortable, Void>() {
		
		@Override
		public Void apply(final Abortable arg) {
			
			arg.abort(null);
			return null;
		}
		
		@Override
		public String toString() {

			return "Default Abortable.ABORT_FUNCTION";
		}
	};
	
	/**
	 * @param reason
	 *            short reason string or NULL if non-specific, used for
	 *            debugging only
	 *
	 */
	void abort(String reason);
}
