package ru.myx.ae3.act;

import java.util.function.Function;

import ru.myx.ae3.exec.ExecProcess;

abstract class AbstractActImpl {
	
	public abstract int getPeakLoad();

	public abstract int getThreadLoad();

	public abstract <A, R> void /* Future<R> */ later(//
			ExecProcess ctx, Function<A, R> job, A arg, long delay);

	public abstract <A, R> void /* Future<R> */ launch(//
			ExecProcess ctx, Function<A, R> function, A arg);

	public abstract void launchNotifyAll(Object object);

	public abstract void launchService(//
			ExecProcess ctx, ActService service);

	public abstract <A, R> R run(//
			ExecProcess process, Function<A, R> job, A argument) throws Exception;

	public abstract <A, R> void /* Future<R> */ whenIdle(//
			ExecProcess ctx, Function<A, R> function, A arg);
}
