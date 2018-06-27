package ru.myx.ae3.e4.logic;

/**
 * 
 * @author myx
 * 		
 */
public interface LexicalContext {
	
	/**
	 * 
	 * @return
	 */
	LexicalContext getParentContext();
	/**
	 * 
	 * @param name
	 * @return
	 */
	LogicReference resolveToken(String name);
}
