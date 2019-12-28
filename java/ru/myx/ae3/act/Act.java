/**
 * Created on 23.11.2002
 *
 * myx - barachta */
package ru.myx.ae3.act;

import java.io.Closeable;
import java.io.Flushable;
import java.util.concurrent.Callable;
import java.util.function.Function;

import ru.myx.ae3.AbstractSAPI;
import ru.myx.ae3.base.BaseFunction;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.binary.Transfer;
import ru.myx.ae3.exec.ExecProcess;

/** @author barachta
 *
 * myx - barachta 
 *         Window>Preferences>Java>Templates. To enable and disable the creation of type comments go
 *         to Window>Preferences>Java>Code Generation. */
public class Act extends AbstractSAPI {

	private static final AbstractActImpl ACT_IMPL;

	/** The peak load to be properly handled by a service unit. This number guaranteed to be the
	 * power of 2.<br>
	 * Source: 2 ^ 'ae2.tune.peakload_factor' <br>
	 * Default: 64 <br>
	 * Min: 16 <br>
	 * Max: 512
	 * <p>
	 * Allows static access to some parameters whose values are defaults or explicitly specified by
	 * a user and should be considered if possible. */
	public static final int PEAK_LOAD;

	/** Peak load divided by parallelism - the load to one thread when thread count for a module a
	 * calculated by parallelism value. */
	public static final int THREAD_LOAD;

	static {
		/** this block should go last */
		{
			ACT_IMPL = AbstractSAPI.createObject("ru.myx.ae3.act.ImplementAct");
			assert Act.ACT_IMPL != null : "Act implementation is not accessible!";
			PEAK_LOAD = Act.ACT_IMPL.getPeakLoad();
			THREAD_LOAD = Act.ACT_IMPL.getThreadLoad();
		}
	}

	/** Executes java.lang.Runnable, returns NULL */
	public static final Function<Runnable, Void> FUNCTION_RUN_RUNNABLE = new Function<>() {

		@Override
		public final Void apply(final Runnable arg) {

			arg.run();
			return null;
		}

		@Override
		public final String toString() {

			return "Act.FUNCTION_RUN_RUNNABLE";
		}
	};

	/** Executes java.util.concurrent.Callable, returns NULL */
	public static final Function<Callable<?>, Object> FUNCTION_RUN_CALLABLE = new Function<>() {

		@Override
		public final Object apply(final Callable<?> arg) {

			try {
				return arg.call();
			} catch (final Throwable e) {
				throw new Transfer.TransferOperationException("while running " + this, e);
			}
		}

		@Override
		public final String toString() {

			return "Act.FUNCTION_RUN_CALLABLE";
		}
	};

	/** Closes java.io.Closeable, returns NULL */
	public static final Function<Closeable, Void> FUNCTION_CLOSE_CLOSEABLE = new Function<>() {

		@Override
		public final Void apply(final Closeable arg) {

			try {
				arg.close();
			} catch (final Throwable e) {
				throw new Transfer.TransferOperationException("while running " + this, e);
			}
			return null;
		}

		@Override
		public final String toString() {

			return "Act.FUNCTION_CLOSE_CLOSEABLE";
		}
	};

	/** Closes java.io.Flushable, returns NULL */
	public static final Function<Flushable, Void> FUNCTION_FLUSH_FLUSHABLE = new Function<>() {

		@Override
		public final Void apply(final Flushable arg) {

			try {
				arg.flush();
			} catch (final Throwable e) {
				throw new Transfer.TransferOperationException("while running " + this, e);
			}
			return null;
		}

		@Override
		public final String toString() {

			return "Act.FUNCTION_FLUSH_FLUSHABLE";
		}
	};

	/** Executes BaseFunction, returns NULL */
	public static final Function<BaseFunction, Void> FUNCTION_RUN_BASE_FUNCTION = new Function<>() {

		@Override
		public Void apply(final BaseFunction arg) {

			arg.callVJ0(BaseObject.UNDEFINED);
			return null;
		}

		@Override
		public final String toString() {

			return "Act.FUNCTION_RUN_BASE_FUNCTION";
		}

	};

	/** Executes synchronize/notifyAll on a given object */
	public static final Function<Object, Void> FUNCTION_NOTIFY_ALL = new Function<>() {

		@Override
		public final Void apply(final Object arg) {

			synchronized (arg) {
				arg.notifyAll();
			}
			return null;
		}

		@Override
		public final String toString() {

			return "Act.FUNCTION_NOTIFY_ALL";
		}
	};

	/** Schedules job for a delayed execution.
	 * <p>
	 * The main goal to be reached in a scheduler implementation is to minimize time spent while
	 * executing this method, so it is OK some real execution date lag in order to improve method
	 * efficiency.
	 * <p>
	 *
	 * @param ctx
	 * @param job
	 * @param delay
	 *            milliseconds */
	public static final void /* Future<Void> */ later(final ExecProcess ctx, final BaseFunction job, final long delay) {

		Act.ACT_IMPL.later(ctx, Act.FUNCTION_RUN_BASE_FUNCTION, job, delay);
	}

	/** Schedules job for a delayed execution.
	 * <p>
	 * The main goal to be reached in a scheduler implementation is to minimize time spent while
	 * executing this method, so it is OK some real execution date lag in order to improve method
	 * efficiency.
	 * <p>
	 *
	 * @param ctx
	 * @param job
	 * @param delay
	 *            milliseconds
	 * @param <A>
	 * @param <R> */
	public static final <A, R> void /* Future<R> */ later(final ExecProcess ctx, final Callable<R> job, final long delay) {

		Act.ACT_IMPL.later(ctx, Act.FUNCTION_RUN_CALLABLE, job, delay);
	}

	/** Schedules job for a delayed execution.
	 * <p>
	 * The main goal to be reached in a scheduler implementation is to minimize time spent while
	 * executing this method, so it is OK some real execution date lag in order to improve method
	 * efficiency.
	 * <p>
	 *
	 * @param ctx
	 * @param job
	 * @param arg
	 * @param delay
	 *            milliseconds
	 * @param <A>
	 * @param <R> */
	public static final <A, R> void /* Future<R> */ later(final ExecProcess ctx, final Function<A, R> job, final A arg, final long delay) {

		Act.ACT_IMPL.later(ctx, job, arg, delay);
	}

	/** Schedules job for a delayed execution.
	 * <p>
	 * The main goal to be reached in a scheduler implementation is to minimize time spent while
	 * executing this method, so it is OK some real execution date lag in order to improve method
	 * efficiency.
	 * <p>
	 *
	 * @param ctx
	 * @param job
	 * @param delay
	 *            milliseconds */
	public static final void /* Future<Void> */ later(final ExecProcess ctx, final Runnable job, final long delay) {

		Act.ACT_IMPL.later(ctx, Act.FUNCTION_RUN_RUNNABLE, job, delay);
	}

	/** Launches a job for an execution.
	 * <p>
	 * The main goals to be reached in a launcher implementation are to improve overall system
	 * performance and to minimize thread launch delays. In any situation first goal is more crucial
	 * than second one, so there are some delays allowed in order to gain overall power in some
	 * heavy-load conditions.
	 * <p>
	 *
	 * Launcher implementation may differ on every instance of system running and there are two
	 * primary reasons to use this method instead of <code>'new Thread(job).start();'</code>:
	 * <li>some special pooling of processing threads or smart scheduling may significantly increase
	 * performance when needed.</li>
	 * <li>special types of thread objects can be used to significantly improve performance of some
	 * currently chosen operations.</li>
	 *
	 * @param ctx
	 * @param function
	 * @param <R> */
	public static final <R> void /* Future<R> */ launch(final ExecProcess ctx, final Callable<R> function) {

		Act.ACT_IMPL.launch(ctx, Act.FUNCTION_RUN_CALLABLE, function);
	}

	/** Launches a job for an execution.
	 * <p>
	 * The main goals to be reached in a launcher implementation are to improve overall system
	 * performance and to minimize thread launch delays. In any situation first goal is more crucial
	 * than second one, so there are some delays allowed in order to gain overall power in some
	 * heavy-load conditions.
	 * <p>
	 *
	 * Launcher implementation may differ on every instance of system running and there are two
	 * primary reasons to use this method instead of <code>'new Thread(job).start();'</code>:
	 * <li>some special pooling of processing threads or smart scheduling may significantly increase
	 * performance when needed.</li>
	 * <li>special types of thread objects can be used to significantly improve performance of some
	 * currently chosen operations.</li>
	 *
	 * @param ctx
	 * @param function
	 * @param arg
	 * @param <A>
	 * @param <R> */
	public static final <A, R> void /* Future<R> */ launch(final ExecProcess ctx, final Function<A, R> function, final A arg) {

		Act.ACT_IMPL.launch(ctx, function, arg);
	}

	/** Launches a job for an execution.
	 * <p>
	 * The main goals to be reached in a launcher implementation are to improve overall system
	 * performance and to minimize thread launch delays. In any situation first goal is more crucial
	 * than second one, so there are some delays allowed in order to gain overall power in some
	 * heavy-load conditions.
	 * <p>
	 *
	 * Launcher implementation may differ on every instance of system running and there are two
	 * primary reasons to use this method instead of <code>'new Thread(job).start();'</code>:
	 * <li>some special pooling of processing threads or smart scheduling may significantly increase
	 * performance when needed.</li>
	 * <li>special types of thread objects can be used to significantly improve performance of some
	 * currently chosen operations.</li>
	 *
	 * @param ctx
	 * @param job */
	public static final void /* Future<Void> */ launch(final ExecProcess ctx, final Runnable job) {

		Act.ACT_IMPL.launch(ctx, Act.FUNCTION_RUN_RUNNABLE, job);
	}

	/** @param object */
	public static final void launchNotifyAll(final Object object) {

		Act.ACT_IMPL.launchNotifyAll(object);
	}

	/** @param ctx
	 * @param service */
	public static final void launchService(final ExecProcess ctx, final ActService service) {

		Act.ACT_IMPL.launchService(ctx, service);
	}

	/** @param <R>
	 * @param process
	 * @param job
	 * @return result
	 * @throws Exception */
	@SuppressWarnings("unchecked")
	public static final <R> R run(final ExecProcess process, final Callable<R> job) throws Exception {

		return (R) Act.ACT_IMPL.run(process, Act.FUNCTION_RUN_CALLABLE, job);
	}

	/** @param <A>
	 * @param <R>
	 * @param process
	 * @param job
	 * @param argument
	 * @return result
	 * @throws Exception */
	public static final <A, R> R run(final ExecProcess process, final Function<A, R> job, final A argument) throws Exception {

		return Act.ACT_IMPL.run(process, job, argument);
	}

	/** @param process
	 * @param job
	 * @return */
	public static Throwable run(final ExecProcess process, final Runnable job) {

		try {
			Act.ACT_IMPL.run(process, Act.FUNCTION_RUN_RUNNABLE, job);
			return null;
		} catch (final Throwable t) {
			return t;
		}
	}

	/** Launches a job for a low priority execution.
	 * <p>
	 * The main goal to be reached in a launcher implementation is to minimize time spent while
	 * executing this method, so it is OK if real thread launch is delayed a little in order to
	 * improve method efficiency.
	 * <p>
	 *
	 * Launcher implementation may differ on every instance of system running and there are two
	 * primary reasons to use this method instead of <code>'new Thread(job).start();'</code>:
	 * <li>some special pooling of processing threads or smart scheduling may significantly increase
	 * performance when needed.</li>
	 * <li>special types of thread objects can be used to significantly improve performance of some
	 * currently chosen operations.</li>
	 *
	 * @param ctx
	 * @param job
	 * @param <R> */
	public static final <R> void /* Future<R> */ whenIdle(final ExecProcess ctx, final Callable<R> job) {

		Act.ACT_IMPL.whenIdle(ctx, Act.FUNCTION_RUN_CALLABLE, job);
	}

	/** Launches a job for a low priority execution.
	 * <p>
	 * The main goal to be reached in a launcher implementation is to minimize time spent while
	 * executing this method, so it is OK if real thread launch is delayed a little in order to
	 * improve method efficiency.
	 * <p>
	 *
	 * Launcher implementation may differ on every instance of system running and there are two
	 * primary reasons to use this method instead of <code>'new Thread(job).start();'</code>:
	 * <li>some special pooling of processing threads or smart scheduling may significantly increase
	 * performance when needed.</li>
	 * <li>special types of thread objects can be used to significantly improve performance of some
	 * currently chosen operations.</li>
	 *
	 * @param ctx
	 * @param function
	 * @param arg
	 * @param <A>
	 * @param <R> */
	public static final <A, R> void /* Future<R> */ whenIdle(final ExecProcess ctx, final Function<A, R> function, final A arg) {

		Act.ACT_IMPL.whenIdle(ctx, function, arg);
	}

	/** Launches a job for a low priority execution.
	 * <p>
	 * The main goal to be reached in a launcher implementation is to minimize time spent while
	 * executing this method, so it is OK if real thread launch is delayed a little in order to
	 * improve method efficiency.
	 * <p>
	 *
	 * Launcher implementation may differ on every instance of system running and there are two
	 * primary reasons to use this method instead of <code>'new Thread(job).start();'</code>:
	 * <li>some special pooling of processing threads or smart scheduling may significantly increase
	 * performance when needed.</li>
	 * <li>special types of thread objects can be used to significantly improve performance of some
	 * currently choosen operations.</li>
	 *
	 * @param ctx
	 * @param job */
	public static final void /* Future<Void> */ whenIdle(final ExecProcess ctx, final Runnable job) {

		Act.ACT_IMPL.whenIdle(ctx, Act.FUNCTION_RUN_RUNNABLE, job);
	}

	private Act() {
		// empty
	}

}
