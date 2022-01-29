package ru.myx.ae3.e4.act;

import ru.myx.ae3.e4.context.FrameContext;

/** @author myx */
public abstract class FrameControlSymbolContext<A> implements FrameContext<A> {

	/** @author myx */
	public static class ControlDetach extends FrameControlSymbolContext {

		/** The only instance */
		public static final ControlDetach INSTANCE = new ControlDetach();

		private ControlDetach() {

			//
		}
	}

	/** Instructs to return from current frame handling and check local queue
	 *
	 * @author myx */
	public static class ControlErrorThrowable extends FrameControlSymbolContext {

		private final Throwable throwable;

		ControlErrorThrowable(final Throwable throwable) {

			this.throwable = throwable;
		}

		public Throwable getCause() {

			return this.throwable;
		}
	}

	/** Instructs to return from current frame handling and check local queue
	 *
	 * @author myx */
	public static class ControlReturn extends FrameControlSymbolContext {

		/** The only instance */
		public static final ControlReturn INSTANCE = new ControlReturn();

		private ControlReturn() {

			//
		}
	}

	public static ControlReturn E4_RETURN = ControlReturn.INSTANCE;

	public static FrameControlSymbolContext E4_REPEAT = new FrameControlSymbolContext() {
		//
	};

	public static FrameControlSymbolContext E4_TYIELD = new FrameControlSymbolContext() {
		//
	};

	public static FrameControlSymbolContext E4_GYIELD = new FrameControlSymbolContext() {
		//
	};

	public static FrameControlSymbolContext E4_FRMCALL = new FrameControlSymbolContext() {
		//
	};

	/** @param e
	 * @return */
	public static final FrameContext createErrorWithThrowable(final Throwable e) {

		return new ControlErrorThrowable(e);
	}

	FrameControlSymbolContext() {

		// locals only
	}

	@Override
	public FrameContext execute(final A a) {

		throw new Error(this + ": control symbols are not supposed to be executed");
	}
}
