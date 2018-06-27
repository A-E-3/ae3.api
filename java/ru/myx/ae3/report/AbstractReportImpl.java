package ru.myx.ae3.report;

abstract class AbstractReportImpl {
	public abstract ReportReceiver createReciever(final String busName);
	
	public abstract int getLevel();
	
	public abstract void reportException(
			final ReportReceiver reciever,
			final String eOwner,
			final String eSubject,
			final String text,
			final Throwable t);
}
