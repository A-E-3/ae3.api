/*
 * Created on 24.03.2006
 */
package ru.myx.ae3.i3;

import ru.myx.ae3.answer.ReplyAnswer;
import ru.myx.ae3.serve.ServeRequest;

/**
 * @author myx
 * 
 */
public interface Handler {
	/**
	 * @param request
	 * @return reply
	 */
	ReplyAnswer onQuery(final ServeRequest request);
}
