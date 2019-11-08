package ru.myx.ae3.e5.context;

/** Default context for non-context thread
 *
 *
 * @author myx */
public interface ConsoleContext extends ConsoleContextProvider {
	
	@Override
	default ConsoleContext getConsoleContext() {
		
		return this;
	}
}
