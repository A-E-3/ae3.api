package ru.myx.ae3.e4.context;

/**
 * 
 * @author myx
 * 		
 */
public interface ProcessContextBuilder {
	
	/**
	 * @param title
	 * @return
	 */
	ProcessContextBuilder setProcessTitle(String title);
	
	/**
	 * @param title
	 * @return
	 */
	ProcessContextBuilder setProcessTitle(CharSequence title);
	/**
	 * 
	 * @return
	 */
	CharSequence getProcessTitle();
	
	/**
	 * 
	 * @return
	 */
	ProcessContext create();
}
