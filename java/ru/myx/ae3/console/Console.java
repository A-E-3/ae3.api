/**
 * 
 */
package ru.myx.ae3.console;

/**
 * @author myx
 * 
 */
public interface Console extends ConsoleOutput, ConsoleInput, ConsoleLogger, ConsoleInteractive {
	
	/**
	 * 
	 */
	public void close();
	
	/**
	 * Console is interactive when console's output can be used to communicate
	 * with the supplier of console's input.
	 * 
	 * @return true when console is interactive
	 */
	public boolean isInteractive();
	
	/**
	 * Console is readable when is has non-NULL and not yet closed ConsoleInput
	 * 
	 * @return false when there are no [further] read operations to succeed
	 */
	public boolean isReadable();
}
