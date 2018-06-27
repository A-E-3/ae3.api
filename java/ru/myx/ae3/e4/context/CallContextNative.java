package ru.myx.ae3.e4.context;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.exec.ExecStateCode;

/**
 * 
 * @author myx
 *
 */
public interface CallContextNative extends CallContext<BaseObject> {
	
	
	/**
	 * 
	 * @return
	 */
	default ExecStateCode callReturn() {
		
		
		return ExecStateCode.RETURN;
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	@Override
	ExecStateCode callReturn(BaseObject x);
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	default ExecStateCode callReturnString(String s) {
		
		
		return this.callReturn(Base.forString(s));
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	default ExecStateCode callReturnNumeric(int x) {
		
		
		return this.callReturn(Base.forInteger(x));
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	default ExecStateCode callReturnNumeric(long x) {
		
		
		return this.callReturn(Base.forLong(x));
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	default ExecStateCode callReturnNumeric(double x) {
		
		
		return this.callReturn(Base.forDouble(x));
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	default ExecStateCode callReturnUndefined() {
		
		
		return this.callReturn(BaseObject.UNDEFINED);
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	default ExecStateCode callReturnNull() {
		
		
		return this.callReturn(BaseObject.NULL);
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	default ExecStateCode callReturnTrue() {
		
		
		return this.callReturn(BaseObject.TRUE);
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	default ExecStateCode callReturnFalse() {
		
		
		return this.callReturn(BaseObject.FALSE);
	}
}
