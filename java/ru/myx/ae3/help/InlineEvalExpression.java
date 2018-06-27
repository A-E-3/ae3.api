package ru.myx.ae3.help;

import java.io.IOException;

/**
 * 
 * @author myx
 * 
 */
public interface InlineEvalExpression {
	
	/**
	 * 
	 * @param target
	 * @return
	 * @throws IOException
	 */
	Appendable toEvalExpression(Appendable target) throws IOException;
	
	/**
	 * Return valid eval expression
	 * 
	 * @return
	 */
	@Override
	String toString();
}
