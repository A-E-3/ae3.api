package ru.myx.ae3.e4.act;

import java.util.function.Function;

import ru.myx.ae3.AbstractSAPI;
import ru.myx.ae3.Engine;
import ru.myx.ae3.e4.context.FrameContext;
import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.report.EventLevel;

/** @author myx */
public class Act4 extends AbstractSAPI {

	private static final AbstractActImpl ACT_IMPL;

	/**
	 *
	 */
	public static final String ACT_IMPL_CLASSNAME;

	static {
		ACT_IMPL_CLASSNAME = Engine.MODE_SIZE
			? "ru.myx.ae3.e4.act.ImplementActSize"
			: Engine.MODE_SPEED
				? "ru.myx.ae3.e4.act.ImplementActSpeed"
				: "ru.myx.ae3.e4.act.ImplementActNormal";
		/** this block should go last */
		{
			ACT_IMPL = AbstractSAPI.createObject(Act4.ACT_IMPL_CLASSNAME);
			assert Act4.ACT_IMPL != null : "Act implementation is not accessible!";
		}
	}

	/** creates default isolated process context
	 *
	 * @param string
	 * @return */
	public static ActProcessContext createProcess(final String string) {

		return Act4.ACT_IMPL.createProcessContext(string);
	}

	/** creates default isolated process context builder
	 *
	 * @param string
	 * @return */
	public static ActProcessContextBuilder createProcessBuilder(final String string) {

		return Act4.ACT_IMPL.createProcessContextBuilder(string);
	}

	/** @param ctx
	 * @param function
	 * @param arg
	 * @param delay */
	public static final <A, R> void /* Future<R> */ later(final ExecProcess ctx, final Function<A, R> function, final A arg, final long delay) {

		Act4.ACT_IMPL.later(ctx, function, arg, delay);
	}

	/** @param ctx
	 * @param delay */
	public static final void /* Future<R> */ later(final FrameContext ctx, final long delay) {

		Act4.ACT_IMPL.later(ctx, delay);
	}

	/** @param ctx
	 * @param function
	 * @param arg */
	public static final <A, R> void /* Future<R> */ launch(final ExecProcess ctx, final Function<A, R> function, final A arg) {

		Act4.ACT_IMPL.launch(ctx, function, arg);
	}

	/** @param ctx */
	public static final void /* Future<R> */ launch(final FrameContext ctx) {

		Act4.ACT_IMPL.launch(ctx);
	}

	/** @param level
	 * @param owner
	 * @param title
	 * @param message
	 * @return */
	public static boolean log(final EventLevel level, final String owner, final String title, final String message) {

		return Act4.ACT_IMPL.log(level, owner, title, message);
	}

	/** @param ctx
	 * @param function
	 * @param arg */
	public static final <A, R> void /* Future<R> */ whenIdle(final ExecProcess ctx, final Function<A, R> function, final A arg) {

		Act4.ACT_IMPL.launch(ctx, function, arg);
	}

	/** @param ctx */
	public static final void /* Future<R> */ whenIdle(final FrameContext ctx) {

		Act4.ACT_IMPL.launch(ctx);
	}

	private Act4() {

		//
	}

}
