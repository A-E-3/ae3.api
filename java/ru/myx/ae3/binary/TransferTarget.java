package ru.myx.ae3.binary;

import java.io.Closeable;
import java.nio.ByteBuffer;

import ru.myx.ae3.act.Act;
import java.util.function.Function;
import ru.myx.ae3.base.BaseFunction;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.reflect.ReflectionHidden;

/**
 * An object for non-blocking binary data consumption. It is assumed that if a
 * target is backing some blocking operation it should enqueue absorption
 * requests and process them somehow in background.
 */
public interface TransferTarget extends Closeable, Abortable {

	/**
	 *
	 */
	Function<Closeable, Void> CLOSE_FUNCTION = Act.FUNCTION_CLOSE_CLOSEABLE;
	
	/**
	 *
	 */
	Function<TransferTarget, Void> FORCE_FUNCTION = new Function<>() {

		@Override
		public Void apply(final TransferTarget arg) {

			arg.force();
			return null;
		}

		@Override
		public String toString() {

			return "TransferTarget.FORCE_FUNCTION";
		}
	};
	
	/**
	 * NUL TARGET instance - dummy target. It is important to use this one -
	 * since implementations can easily check for equality and perform some
	 * shortcuts while rendering something.
	 */
	TransferTarget NUL_TARGET = new NullTarget();
	
	/**
	 * immediately
	 */
	@Override
	void abort(String reason);
	
	/**
	 * Can buffer/collect or actually process in-line.
	 *
	 * @param i
	 * @return boolean
	 */
	boolean absorb(int i);
	
	/**
	 * The 'array' argument's value should not be used by target after this
	 * method returned and can be freely reused many times. Target must read all
	 * required bytes before returning.
	 *
	 * TODO: check implementations to respect this ^^^^
	 *
	 * @param array
	 * @param off
	 * @param len
	 * @return boolean
	 */
	boolean absorbArray(byte[] array, int off, int len);
	
	/**
	 * TransferBuffer is a single time use object, so for target it is supposed
	 * to be safe to collect buffers, not just immediately read them.
	 *
	 * TODO: check users to respect this ^^^^
	 *
	 * @param buffer
	 * @return boolean
	 */
	boolean absorbBuffer(TransferBuffer buffer);
	
	/**
	 * NioBuffer is a reusable object (put-flip-get-compact pattern). The
	 * 'buffer' argument's value should not be used by target after this method
	 * returned and can be freely reused many times. Target get's the buffer in
	 * {pos=start, lim=limit} state (like after call to flip()). Target can read
	 * all, some or none of the buffer, next time it could be called with the
	 * same or new buffer and reading should continue where it stopped
	 * previously.
	 *
	 * TODO: check implementations to respect this ^^^^
	 *
	 * @param buffer
	 * @return boolean
	 */
	boolean absorbNio(ByteBuffer buffer);
	
	/**
	 * in order*
	 *
	 * FIXME: doc * Enqueues a 'close' action on completion. This action have to
	 * be launched when currently absorbed data is sent to underlying medium or
	 * when transfer is interrupted. When no data available in buffers launch
	 * should happen immediately. In any case the action will be launched in
	 * other thread, not to block current process.
	 */
	@Override
	void close();
	
	/**
	 * in order*
	 *
	 * FIXME: doc * Enqueues an action to launch on completion. This action have
	 * to be launched when currently absorbed data is sent to underlying medium
	 * or when transfer is interrupted. When no data available in buffers launch
	 * should happen immediately. In any cases the action will be launched in
	 * other thread, not to block current process.
	 *
	 * When no delayed buffering used in this target, acts like: <code>
	 * public boolean enqueueAction( Act.Context ctx, Act.Function function, Object argument) {
	 * Act.launch(ctx, function, argument);
	 * 	return true;
	 * }
	 * </code>
	 *
	 * @param ctx
	 * @param function
	 * @param argument
	 * @param <A>
	 * @param <R>
	 * @return boolean
	 */
	@ReflectionHidden
	<A, R> boolean enqueueAction(ExecProcess ctx, Function<A, R> function, A argument);
	
	/**
	 *
	 * @param ctx
	 * @param function
	 * @return
	 */
	default boolean enqueueAction(final ExecProcess ctx, final BaseFunction function) {
		
		return this.enqueueAction(ctx, arg -> {
			function.callVE0(ctx, BaseObject.NULL);
			return null;
		}, null);
	}
	
	/**
	 * Forces all data enqueued to a target to be flushed further.
	 */
	void force();
}
