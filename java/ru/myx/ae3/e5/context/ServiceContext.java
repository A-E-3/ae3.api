package ru.myx.ae3.e5.context;

/** @author myx */
public interface ServiceContext extends ServiceContextProvider {
	
	@Override
	default ServiceContext getServiceContext() {
		
		return this;
	}
}
