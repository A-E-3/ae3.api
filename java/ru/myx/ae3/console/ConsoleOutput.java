package ru.myx.ae3.console;

import java.io.Flushable;

/** @author myx */
public interface ConsoleOutput extends Flushable {
	
	/** Force-flush collected buffers (if any) */
	@Override
	void flush();
	
	/** @param message */
	default void sendAlert(final String message) {

		synchronized (this) {
			this.setStateAttention();
			this.sendMessage(message);
			this.setStateNormal();
		}
	}
	
	/** @param message */
	default void sendError(final String message) {

		synchronized (this) {
			this.setStateError();
			this.sendMessage(message);
			this.setStateNormal();
		}
	}
	
	/** @param message */
	void sendMessage(String message);
	
	/** @param title
	 * @param text */
	void sendMessage(String title, String text);
	
	/** same as setState(ConsoleState.ATTENTION) */
	void setStateAttention();
	
	/** same as setState(ConsoleState.ERROR) */
	void setStateError();
	
	/** same as setState(ConsoleState.NORMAL) */
	void setStateNormal();
}
