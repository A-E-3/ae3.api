package ru.myx.ae3.exec;

/**
 * 
 * @author myx
 * 
 */
public interface InstructionOrigin {
	
	
	/**
	 * 
	 * @author myx
	 *
	 */
	public interface DebugRecord {
		
		
		/**
		 * 
		 * @return
		 */
		int getLineNumber();
		
		/**
		 * 
		 * @return
		 */
		int getSourceCodeStartIndex();
		
		/**
		 * 
		 * @return
		 */
		int getSourceCodeStopIndex();
	}
	
	/**
	 * 
	 * @return
	 */
	Instruction[] execGetCode();
	
	/**
	 * 
	 * @return
	 */
	default Object[] execGetConstantPool() {
		
		
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	default InstructionBlock.DebugRecord[] execGetDebugInfo() {
		
		
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	default String execGetOriginGroup() {
		
		
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	default String execGetOriginId() {
		
		
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	default CharSequence execGetSourceCode() {
		
		
		return null;
	}
	
	/**
	 * Sets up the context fldCode, I0, IP, IL registers
	 * 
	 * @param ctx
	 */
	void execSetupContext(ExecProcess ctx);
}
