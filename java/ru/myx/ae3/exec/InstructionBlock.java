package ru.myx.ae3.exec;

/**
 * 
 * @author myx
 * 
 */
public interface InstructionBlock extends InstructionOrigin {
	
	/**
	 * 
	 * @return
	 */
	int execGetCodeStart();
	
	
	/**
	 * 
	 * @return
	 */
	int execGetCodeStop();
}
