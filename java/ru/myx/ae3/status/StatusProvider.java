/*
 * Created on 22.03.2006
 */
package ru.myx.ae3.status;

import ru.myx.ae3.common.Describable;

/** @author myx */
public interface StatusProvider extends StatusFiller, Describable {

	@Override
	default String baseDescribe() {
		
		final String s = this.statusName();
		return s + (s.length() < 8
			? "\t\t"
			: "\t") + this.statusDescription();
	}
	
	/** @return providers */
	default StatusProvider[] childProviders() {

		return null;
	}
	
	/** @return status */
	default StatusInfo getStatus() {
		
		final StatusInfo result = new StatusInfo(this.statusDescription());
		this.statusFill(result);
		result.childProviders = this.childProviders();
		return result;
	}
	
	/** @return string */
	String statusDescription();
	
	@Override
	void statusFill(final StatusInfo status);
	
	/** @return string */
	String statusName();
}
