package ru.myx.ae3.console;

/**
 * @author myx
 * 
 */
public interface ConsoleInteractive {
	
	/**
	 * Some console implementations do support terminal auto detection, etc.
	 * Normally they perform these tasks on initial handshake in the beginning
	 * of the session. You can call this method in some special cases, when
	 * there is a need to try to re-handshake session parameters eventually, for
	 * example: shell calls this method when displaying prompt so when client
	 * reconnects to the console later with different terminal this change would
	 * be re-checked.
	 */
	public void checkUpdateClient();
	
	/**
	 * Optional. Sends an undefined progress. Implementation dependent. Could be
	 * ignored, could print dots, could update busy indicator etc.
	 * 
	 * Must support defer-buffering, could be called frequently, needs to be
	 * updated pretty seldom.
	 * 
	 * @param string
	 */
	void sendProgress(String string);
	
}
