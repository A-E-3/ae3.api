package ru.myx.ae3.e4.act;

/**
 * FIXME: TODO:
 * 
 * @author myx
 * 
 * @param <T>
 */
public interface ManagerService<T extends Task<?>> {
	/**
	 * 
	 * @return
	 */
	Manager<T> getManager();
	
	/**
	 * @throws Exception
	 * 
	 */
	void start() throws Exception;
	
	/**
	 * @throws Exception
	 * 
	 */
	void stop() throws Exception;
}
