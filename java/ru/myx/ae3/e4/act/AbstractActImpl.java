package ru.myx.ae3.e4.act;

import java.util.function.Function;

import ru.myx.ae3.act.ActService;
import ru.myx.ae3.e4.context.FrameContext;
import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.report.EventLevel;

abstract class AbstractActImpl {

	public abstract ActProcessContext createProcessContext(String title);

	public abstract ActProcessContextBuilder createProcessContextBuilder(String title);

	public abstract <A, R> void /* Future<R> */ later(//
			ExecProcess ctx,
			Function<A, R> job,
			A arg,
			long delay);

	public abstract void /* Future<R> */ later(//
			FrameContext ctx,
			long delay);

	public abstract <A, R> void /* Future<R> */ launch(//
			ExecProcess ctx,
			Function<A, R> function,
			A arg);

	public abstract void /* Future<R> */ launch(//
			FrameContext ctx);

	public abstract void launchNotifyAll(Object object);

	public abstract void launchService(//
			ExecProcess ctx,
			ActService service);

	public abstract boolean log(EventLevel level, String owner, String title, String message);

	public abstract <A, R> void /* Future<R> */ whenIdle(//
			ExecProcess ctx,
			Function<A, R> function,
			A arg);

	public abstract void /* Future<R> */ whenIdle(//
			FrameContext ctx);
}
