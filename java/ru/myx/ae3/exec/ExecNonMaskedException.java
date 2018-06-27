package ru.myx.ae3.exec;

import ru.myx.ae3.base.BaseAbstractException;
import ru.myx.ae3.base.BaseObject;

/**
 * @author myx
 * 		
 */
public abstract class ExecNonMaskedException extends BaseAbstractException {
	
	/**
	 * Prototype object
	 */
	protected BaseObject prototype;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3427642301252080907L;
	
	/**
	 * @param prototype
	 * 			
	 */
	protected ExecNonMaskedException(final BaseObject prototype) {
		super();
		assert prototype != null : "Prototype is java null";
		this.prototype = prototype == BaseObject.UNDEFINED
			? null
			: prototype;
	}
	
	/**
	 * @param prototype
	 * @param message
	 */
	protected ExecNonMaskedException(final BaseObject prototype, final String message) {
		super(message);
		assert prototype != null : "Prototype is java null";
		this.prototype = prototype == BaseObject.UNDEFINED
			? null
			: prototype;
	}
	
	/**
	 * @param prototype
	 * @param message
	 * @param cause
	 */
	protected ExecNonMaskedException(final BaseObject prototype, final String message, final Throwable cause) {
		super(message, cause);
		assert prototype != null : "Prototype is java null";
		this.prototype = prototype == BaseObject.UNDEFINED
			? null
			: prototype;
	}
	
	/**
	 * The value of the [[Prototype]] property must be either an object or null,
	 * and every [[Prototype]] chain must have finite length (that is, starting
	 * from any object, recursively accessing the [[Prototype]] property must
	 * eventually lead to a null value). Whether or not a native object can have
	 * a host object as its [[Prototype]] depends on the implementation.
	 * 
	 * @return prototype object or null
	 */
	@Override
	public final BaseObject basePrototype() {
		
		return this.prototype;
	}
	
}
