package ru.myx.ae3.e4.act;

import ru.myx.ae3.e4.context.ProcessContextBuilder;

/**
 * @author myx
 * 		
 */
public interface ActProcessContextBuilder extends ProcessContextBuilder {
	
	/**
	 * 
	 * @return
	 */
	@Override
			ActProcessContext create();
}
