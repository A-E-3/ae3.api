/**
 *
 */
package ru.myx.ae3.exec;

import java.util.function.Function;

import ru.myx.ae3.AbstractSAPI;
import ru.myx.ae3.Engine;
import ru.myx.ae3.act.Act;
import ru.myx.ae3.base.BaseArray;
import ru.myx.ae3.base.BaseFunction;
import ru.myx.ae3.base.BaseObject;

/** @author myx */
public class Exec extends AbstractSAPI {
	
	private static final AbstractExecImpl EXEC_IMPL;
	
	static {
		/** this block should go last */
		{
			EXEC_IMPL = AbstractSAPI.createObject("ru.myx.ae3.exec.ImplementExec");
			assert Exec.EXEC_IMPL != null : "Exec implementation is not accessible!";
		}
		
		Engine.HOST_NAME.toString();
	}
	
	/** @param ctxParent
	 * @param ctxTitle
	 * @param callee
	 * @param instance
	 * @param store */
	public static void callAsyncForkUnrelated(final ExecProcess ctxParent, final String ctxTitle, final BaseFunction callee, final BaseObject instance, final ResultHandler store) {
		
		final ExecProcess ctx = Exec.createProcess(ctxParent, ctxTitle);
		Act.launch(ctx, new Function<>() {

			@Override
			public Object apply(final Object v) {

				final ExecStateCode code = callee.execCallPrepare(//
						ctx,
						instance,
						store == null
							? ResultHandler.FU_BNN_NXT
							: store,
						true);
				if (code == null || code == ExecStateCode.NEXT || code == ExecStateCode.RETURN) {
					return null;
				}
				ctx.vmStateToErrorOrSilence(code);
				return null;
			}
		}, null);
	}
	
	/** @param ctxParent
	 * @param ctxTitle
	 * @param callee
	 * @param instance
	 * @param store
	 * @param arguments */
	public static void callAsyncForkUnrelated(final ExecProcess ctxParent,
			final String ctxTitle,
			final BaseFunction callee,
			final BaseObject instance,
			final ResultHandler store,
			final BaseArray arguments) {
		
		final ExecProcess ctx = Exec.createProcess(ctxParent, ctxTitle);
		Act.launch(ctx, new Function<BaseArray, Object>() {

			@Override
			public Object apply(final BaseArray a) {

				final ExecStateCode code = callee.execCallPrepare(//
						ctx,
						instance,
						store == null
							? ResultHandler.FU_BNN_NXT
							: store,
						true,
						a);
				if (code == null || code == ExecStateCode.NEXT || code == ExecStateCode.RETURN) {
					return null;
				}
				ctx.vmStateToErrorOrSilence(code);
				return null;
			}
		}, (BaseArray) ExecProcess.vmEnsureNative(arguments));
	}
	
	/** @param ctxParent
	 * @param ctxTitle
	 * @param callee
	 * @param instance
	 * @param store
	 * @param argument */
	public static void callAsyncForkUnrelated(final ExecProcess ctxParent,
			final String ctxTitle,
			final BaseFunction callee,
			final BaseObject instance,
			final ResultHandler store,
			final BaseObject argument) {
		
		final ExecProcess ctx = Exec.createProcess(ctxParent, ctxTitle);
		Act.launch(ctx, new Function<>() {

			@Override
			public Object apply(final Object v) {

				final ExecStateCode code = callee.execCallPrepare(//
						ctx,
						instance,
						store == null
							? ResultHandler.FU_BNN_NXT
							: store,
						true,
						argument);
				if (code == null || code == ExecStateCode.NEXT || code == ExecStateCode.RETURN) {
					return null;
				}
				ctx.vmStateToErrorOrSilence(code);
				return null;
			}
		}, null);
	}
	
	/** @param ctxParent
	 * @param ctxTitle
	 * @param callee
	 * @param instance
	 * @param store
	 * @param arguments */
	public static void callAsyncForkUnrelated(final ExecProcess ctxParent,
			final String ctxTitle,
			final BaseFunction callee,
			final BaseObject instance,
			final ResultHandler store,
			final BaseObject... arguments) {
		
		final ExecProcess ctx = Exec.createProcess(ctxParent, ctxTitle);
		Act.launch(ctx, new Function<ExecArguments, Object>() {

			@Override
			public Object apply(final ExecArguments a) {

				final ExecStateCode code = callee.execCallPrepare(//
						ctx,
						instance,
						store == null
							? ResultHandler.FU_BNN_NXT
							: store,
						true,
						a);
				if (code == null || code == ExecStateCode.NEXT || code == ExecStateCode.RETURN) {
					return null;
				}
				ctx.vmStateToErrorOrSilence(code);
				return null;
			}
		}, ctx.argumentsListA(arguments));
	}
	
	/** @param ctxParent
	 * @param ctxTitle
	 * @param callee
	 * @param instance
	 * @param store
	 * @param argument1
	 * @param argument2 */
	public static void callAsyncForkUnrelated(final ExecProcess ctxParent,
			final String ctxTitle,
			final BaseFunction callee,
			final BaseObject instance,
			final ResultHandler store,
			final BaseObject argument1,
			final BaseObject argument2) {
		
		final ExecProcess ctx = Exec.createProcess(ctxParent, ctxTitle);
		Act.launch(ctx, new Function<>() {

			@Override
			public Object apply(final Object v) {

				final ExecStateCode code = callee.execCallPrepare(//
						ctx,
						instance,
						store == null
							? ResultHandler.FU_BNN_NXT
							: store,
						true,
						argument1,
						argument2);
				if (code == null || code == ExecStateCode.NEXT || code == ExecStateCode.RETURN) {
					return null;
				}
				ctx.vmStateToErrorOrSilence(code);
				return null;
			}
		}, null);
	}
	
	/** @param ctx
	 * @param callee
	 * @param instance
	 * @param store */
	public static void callAsyncUnrelated(final ExecProcess ctx, final BaseFunction callee, final BaseObject instance, final ResultHandler store) {
		
		Act.launch(ctx, new Function<>() {

			@Override
			public Object apply(final Object v) {

				final ExecStateCode code = callee.execCallPrepare(//
						ctx,
						instance,
						store == null
							? ResultHandler.FU_BNN_NXT
							: store,
						true);
				if (code == null || code == ExecStateCode.NEXT || code == ExecStateCode.RETURN) {
					return null;
				}
				ctx.vmStateToErrorOrSilence(code);
				return null;
			}
		}, null);
	}
	
	/** @param ctx
	 * @param callee
	 * @param instance
	 * @param store
	 * @param arguments */
	public static void callAsyncUnrelated(final ExecProcess ctx, final BaseFunction callee, final BaseObject instance, final ResultHandler store, final BaseArray arguments) {
		
		Act.launch(ctx, new Function<BaseArray, Object>() {

			@Override
			public Object apply(final BaseArray a) {

				final ExecStateCode code = callee.execCallPrepare(//
						ctx,
						instance,
						store == null
							? ResultHandler.FU_BNN_NXT
							: store,
						true,
						a);
				if (code == null || code == ExecStateCode.NEXT || code == ExecStateCode.RETURN) {
					return null;
				}
				ctx.vmStateToErrorOrSilence(code);
				return null;
			}
		}, (BaseArray) ExecProcess.vmEnsureNative(arguments));
	}
	
	/** @param ctx
	 * @param callee
	 * @param instance
	 * @param store
	 * @param argument */
	public static void callAsyncUnrelated(final ExecProcess ctx, final BaseFunction callee, final BaseObject instance, final ResultHandler store, final BaseObject argument) {
		
		Act.launch(ctx, new Function<>() {

			@Override
			public Object apply(final Object v) {

				final ExecStateCode code = callee.execCallPrepare(//
						ctx,
						instance,
						store == null
							? ResultHandler.FU_BNN_NXT
							: store,
						true,
						argument);
				if (code == null || code == ExecStateCode.NEXT || code == ExecStateCode.RETURN) {
					return null;
				}
				ctx.vmStateToErrorOrSilence(code);
				return null;
			}
		}, null);
	}
	
	/** @param ctx
	 * @param callee
	 * @param instance
	 * @param store
	 * @param arguments */
	public static void callAsyncUnrelated(final ExecProcess ctx, final BaseFunction callee, final BaseObject instance, final ResultHandler store, final BaseObject... arguments) {
		
		Act.launch(ctx, new Function<ExecArguments, Object>() {

			@Override
			public Object apply(final ExecArguments a) {

				final ExecStateCode code = callee.execCallPrepare(//
						ctx,
						instance,
						store == null
							? ResultHandler.FU_BNN_NXT
							: store,
						true,
						a);
				if (code == null || code == ExecStateCode.NEXT || code == ExecStateCode.RETURN) {
					return null;
				}
				ctx.vmStateToErrorOrSilence(code);
				return null;
			}
		}, ctx.argumentsListA(arguments));
	}
	
	/** @param ctx
	 * @param callee
	 * @param instance
	 * @param store
	 * @param argument1
	 * @param argument2 */
	public static void callAsyncUnrelated(final ExecProcess ctx,
			final BaseFunction callee,
			final BaseObject instance,
			final ResultHandler store,
			final BaseObject argument1,
			final BaseObject argument2) {
		
		Act.launch(ctx, new Function<>() {

			@Override
			public Object apply(final Object v) {

				final ExecStateCode code = callee.execCallPrepare(//
						ctx,
						instance,
						store == null
							? ResultHandler.FU_BNN_NXT
							: store,
						true,
						argument1,
						argument2);
				if (code == null || code == ExecStateCode.NEXT || code == ExecStateCode.RETURN) {
					return null;
				}
				ctx.vmStateToErrorOrSilence(code);
				return null;
			}
		}, null);
	}
	
	/** @param ctx
	 * @param delay
	 * @param callee
	 * @param instance
	 * @param store */
	public static void callDelayedUnrelated(final ExecProcess ctx, final long delay, final BaseFunction callee, final BaseObject instance, final ResultHandler store) {
		
		Act.later(ctx, new Function<>() {

			@Override
			public Object apply(final Object v) {

				final ExecStateCode code = callee.execCallPrepare(//
						ctx,
						instance,
						store == null
							? ResultHandler.FU_BNN_NXT
							: store,
						true);
				if (code == null || code == ExecStateCode.NEXT || code == ExecStateCode.RETURN) {
					return null;
				}
				ctx.vmStateToErrorOrSilence(code);
				return null;
			}
		}, null, delay);
	}
	
	/** @param ctx
	 * @param delay
	 * @param callee
	 * @param instance
	 * @param store
	 * @param arguments */
	public static void callDelayedUnrelated(final ExecProcess ctx,
			final long delay,
			final BaseFunction callee,
			final BaseObject instance,
			final ResultHandler store,
			final BaseArray arguments) {
		
		Act.later(ctx, new Function<BaseArray, Object>() {

			@Override
			public Object apply(final BaseArray a) {

				final ExecStateCode code = callee.execCallPrepare(//
						ctx,
						instance,
						store == null
							? ResultHandler.FU_BNN_NXT
							: store,
						true,
						a);
				if (code == null || code == ExecStateCode.NEXT || code == ExecStateCode.RETURN) {
					return null;
				}
				ctx.vmStateToErrorOrSilence(code);
				return null;
			}
		}, (BaseArray) ExecProcess.vmEnsureNative(arguments), delay);
	}
	
	/** @param ctx
	 * @param delay
	 * @param callee
	 * @param instance
	 * @param store
	 * @param argument */
	public static void callDelayedUnrelated(final ExecProcess ctx,
			final long delay,
			final BaseFunction callee,
			final BaseObject instance,
			final ResultHandler store,
			final BaseObject argument) {
		
		Act.later(ctx, new Function<>() {

			@Override
			public Object apply(final Object v) {

				final ExecStateCode code = callee.execCallPrepare(//
						ctx,
						instance,
						store == null
							? ResultHandler.FU_BNN_NXT
							: store,
						true,
						argument);
				if (code == null || code == ExecStateCode.NEXT || code == ExecStateCode.RETURN) {
					return null;
				}
				ctx.vmStateToErrorOrSilence(code);
				return null;
			}
		}, null, delay);
	}
	
	/** @param ctx
	 * @param delay
	 * @param callee
	 * @param instance
	 * @param store
	 * @param arguments */
	public static void callDelayedUnrelated(final ExecProcess ctx,
			final long delay,
			final BaseFunction callee,
			final BaseObject instance,
			final ResultHandler store,
			final BaseObject... arguments) {
		
		Act.later(ctx, new Function<ExecArguments, Object>() {

			@Override
			public Object apply(final ExecArguments a) {

				final ExecStateCode code = callee.execCallPrepare(//
						ctx,
						instance,
						store == null
							? ResultHandler.FU_BNN_NXT
							: store,
						true,
						a);
				if (code == null || code == ExecStateCode.NEXT || code == ExecStateCode.RETURN) {
					return null;
				}
				ctx.vmStateToErrorOrSilence(code);
				return null;
			}
		}, ctx.argumentsListA(arguments), delay);
	}
	
	/** @param ctx
	 * @param delay
	 * @param callee
	 * @param instance
	 * @param store
	 * @param argument1
	 * @param argument2 */
	public static void callDelayedUnrelated(final ExecProcess ctx,
			final long delay,
			final BaseFunction callee,
			final BaseObject instance,
			final ResultHandler store,
			final BaseObject argument1,
			final BaseObject argument2) {
		
		Act.later(ctx, new Function<>() {

			@Override
			public Object apply(final Object v) {

				final ExecStateCode code = callee.execCallPrepare(//
						ctx,
						instance,
						store == null
							? ResultHandler.FU_BNN_NXT
							: store,
						true,
						argument1,
						argument2);
				if (code == null || code == ExecStateCode.NEXT || code == ExecStateCode.RETURN) {
					return null;
				}
				ctx.vmStateToErrorOrSilence(code);
				return null;
			}
		}, null, delay);
	}
	
	/** for variables new empty BaseNaiveObject will be created with prototype based on execParent
	 * context's variables, tracer will be copied from ecmaParent
	 *
	 * @param execParent
	 * @param ecmaParent
	 *            [prototype] when NULL - parent will be used for prototype, when parent is NULL
	 *            then current process will be used.
	 * @param title
	 * @return */
	public static final ExecProcess createProcess(final ExecProcess execParent, final ExecProcess ecmaParent, final String title) {
		
		return Exec.EXEC_IMPL.createProcess(execParent, ecmaParent, title);
	}
	
	/** for variables new empty BaseNaiveObject will be created with prototype based on parent
	 * context's variables
	 *
	 * @param parent
	 *            [prototype] when NULL - parent will be used for prototype, when parent is NULL
	 *            then current process will be used.
	 * @param title
	 * @return */
	public static final ExecProcess createProcess(final ExecProcess parent, final String title) {
		
		return Exec.EXEC_IMPL.createProcess(parent, title);
	}
	
	/** Creates process variable (either inheritable or local). These variables use thread context
	 * to bind so it goes in java way (as contrary to js way, where on function call scope stack is
	 * bind to function declaration context).
	 *
	 * That's why it is a good place to allocate such things as 'server', 'request', 'session', etc
	 * or your own context objects with this things accessible as fields.
	 *
	 * Yes - this variables have to be BaseObjects explicitly, this provides fastest, wrapper-less
	 * access. Use BaseHostAbstract if you don't care.
	 *
	 * @param <T>
	 * @param key
	 * @param inheritable
	 * @return */
	public static final <T extends BaseObject> ExecProcessVariable<T> createProcessVariable(final String key, final boolean inheritable) {
		
		return Exec.EXEC_IMPL.createProcessVariable(key, inheritable);
	}
	
	/** Creates a wrapped exception that acts as close to original message object as possible.
	 *
	 *
	 * @param message
	 * @param source
	 * @param detail
	 *            TODO
	 * @return */
	public static final ExecNonMaskedException createThrown(final BaseObject message, final Object source, final Object detail) {
		
		if (message == null) {
			throw new NullPointerException("NULL message!");
		}
		if (message instanceof ExecNonMaskedException) {
			return (ExecNonMaskedException) message;
		}
		if (message instanceof OutOfMemoryError) {
			throw (OutOfMemoryError) message;
		}
		return Exec.EXEC_IMPL.createThrown(message, source, detail);
	}
	
	/** @return context */
	public static final ExecProcess currentProcess() {
		
		return Exec.EXEC_IMPL.currentProcess();
	}
	
	/** @return root process */
	public static final ExecProcess getRootProcess() {
		
		return Exec.EXEC_IMPL.getRootProcess();
	}
	
}
