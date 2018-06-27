package ru.myx.ae3.binary;

import java.io.Closeable;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.reflect.Reflect;

/**
 * Socket is a pair of source and target which both make you able to read and
 * write data from/to a channel.
 */
public interface TransferSocket extends Closeable, Abortable {
	
	/**
	 * 
	 */
	static BaseObject PROTOTYPE = Reflect.classToBasePrototype(TransferSocket.class);
	
	/**
	 * 
	 */
	@Override
			void abort(String reason);
			
	/**
	 * 
	 */
	@Override
			void close();
			
	/**
	 * Returns a string representation of a peer's address identifying a peer
	 * within a whole lots of different sources by mixing
	 * <i>transport-type-name </i> and <i>transport-local-identity </i>.
	 * 
	 * @return string
	 */
	String getIdentity();
	
	/**
	 * Returns a string representation of local address.
	 * 
	 * @return string
	 */
	String getLocalAddress();
	
	/**
	 * Returns a string representation of a peer's address identifying a peer
	 * within current source.
	 * 
	 * @return string
	 */
	String getRemoteAddress();
	
	/**
	 * Returns a source instance to read data from this socket.
	 * 
	 * @return source
	 */
	TransferSource getSource();
	
	/**
	 * Returns a target instance to write data to this socket.
	 * 
	 * @return target
	 */
	TransferTarget getTarget();
	
	/**
	 * @return description
	 */
	TransferDescription getTransferDescription();
	
	/**
	 * @return boolean
	 */
	boolean isOpen();
	
	/**
	 * @param description
	 * @return description
	 */
	TransferDescription setTransferDescription(final TransferDescription description);
}
