package ru.myx.ae3.exec;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import ru.myx.ae3.base.BaseArray;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/** @author myx */
@ReflectionDisable
interface CallableResultStore {
	
	/** @author myx */
	@ReflectionDisable
	interface CREAAFAAA extends ExecCallable {
		//
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FDE0 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {
			
			final double ra2RD = ctx.ra2RD;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_DNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra2RD;
			} finally {
				ctx.ra2RD = ra2RD;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FDE1 extends CallableResultStore.CREE1FDE1 {
		
		@Override
		@ReflectionHidden
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			final double ra2RD = ctx.ra2RD;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_DNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra2RD;
			} finally {
				ctx.ra2RD = ra2RD;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FDE2 extends CallableResultStore.CREE2FDE2 {
		
		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final double ra2RD = ctx.ra2RD;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_DNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra2RD;
			} finally {
				ctx.ra2RD = ra2RD;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FDEA extends CallableResultStore.CREEXFDEA {
		
		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			final double ra2RD = ctx.ra2RD;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_DNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra2RD;
			} finally {
				ctx.ra2RD = ra2RD;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FDEX extends CallableResultStore.CREEXFDEX {
		
		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			final double ra2RD = ctx.ra2RD;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_DNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra2RD;
			} finally {
				ctx.ra2RD = ra2RD;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FEE1 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {
			
			return this.execCallPrepare(ctx, instance, store, inline);
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FEE2 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {
			
			return this.execCallPrepare(ctx, instance, store, inline);
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FEEX extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {
			
			return this.execCallPrepare(ctx, instance, store, inline);
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FIE0 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return (int) ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FIE1 extends CallableResultStore.CREE1FIE1 {
		
		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return (int) ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FIE2 extends CallableResultStore.CREE2FIE2 {
		
		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return (int) ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FIEA extends CallableResultStore.CREEXFIEA {
		
		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return (int) ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FIEX extends CallableResultStore.CREEXFIEX {
		
		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return (int) ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FLE0 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FLE1 extends CallableResultStore.CREE1FLE1 {
		
		@Override
		@ReflectionHidden
		default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FLE2 extends CallableResultStore.CREE2FLE2 {
		
		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FLEA extends CallableResultStore.CREEXFLEA {
		
		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FLEX extends CallableResultStore.CREEXFLEX {
		
		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FNE0 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(ctx, instance, ResultHandler.FA_BNN_NXT, true));
				return ctx.ra0RB;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FNE1 extends CallableResultStore.CREE1FNE1 {
		
		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_BNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra0RB;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FNE2 extends CallableResultStore.CREE2FNE2 {
		
		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_BNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra0RB;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FNEA extends CallableResultStore.CREEXFNEA {
		
		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_BNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra0RB;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FNEX extends CallableResultStore.CREEXFNEX {
		
		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_BNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra0RB;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FSE0 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@Nullable
		@ReflectionHidden
		default String callSE0(@NotNull final ExecProcess ctx, @Nullable final BaseObject instance) {
			
			final CharSequence ra3RS = ctx.ra3RS;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_CNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra3RS.toString();
			} finally {
				ctx.ra3RS = ra3RS;
			}
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FSE1 extends CallableResultStore.CREE1FSE1 {
		
		@Override
		@Nullable
		@ReflectionHidden
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			final CharSequence ra3RS = ctx.ra3RS;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_CNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra3RS.toString();
			} finally {
				ctx.ra3RS = ra3RS;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FSE2 extends CallableResultStore.CREE2FSE2 {
		
		@Override
		@Nullable
		@ReflectionHidden
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final CharSequence ra3RS = ctx.ra3RS;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_CNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra3RS.toString();
			} finally {
				ctx.ra3RS = ra3RS;
			}
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FSEA extends CallableResultStore.CREEXFSEA {
		
		@Override
		@Nullable
		@ReflectionHidden
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			final CharSequence ra3RS = ctx.ra3RS;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_CNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra3RS.toString();
			} finally {
				ctx.ra3RS = ra3RS;
			}
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FSEX extends CallableResultStore.CREEXFSEX {
		
		@Override
		@Nullable
		@ReflectionHidden
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			final CharSequence ra3RS = ctx.ra3RS;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_CNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra3RS.toString();
			} finally {
				ctx.ra3RS = ra3RS;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FVE0 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FU_BNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FVE1 extends CallableResultStore.CREE1FVE1 {
		
		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FU_BNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FVE2 extends CallableResultStore.CREE2FVE2 {
		
		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FU_BNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FVEA extends CallableResultStore.CREEXFVEA {
		
		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FU_BNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FVEX extends CallableResultStore.CREEXFVEX {
		
		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FU_BNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FVJ0 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {
			
			final ExecProcess ctx = Exec.currentProcess();
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FU_BNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FVJ1 extends CallableResultStore.CREE1FVJ1 {

		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {

			final ExecProcess ctx = Exec.currentProcess();
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FU_BNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}

	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FVJ2 extends CallableResultStore.CREE2FVJ2 {
		
		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final ExecProcess ctx = Exec.currentProcess();
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FU_BNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE0FVJA extends CallableResultStore.CREEXFVJA {
		
		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {
			
			final ExecProcess ctx = Exec.currentProcess();
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FU_BNN_NXT, true);
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FDE0 extends CallableResultStore.CREE0FDE0 {
		
		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {
			
			final double ra2RD = ctx.ra2RD;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_DNN_NXT, true, BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra2RD;
			} finally {
				ctx.ra2RD = ra2RD;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FDE1 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			final double ra2RD = ctx.ra2RD;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_DNN_NXT, true, argument);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra2RD;
			} finally {
				ctx.ra2RD = ra2RD;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FDE2 extends CallableResultStore.CREE2FDE2 {
		
		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final double ra2RD = ctx.ra2RD;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_DNN_NXT, true, argument1);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra2RD;
			} finally {
				ctx.ra2RD = ra2RD;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FDEA extends CallableResultStore.CREEXFDEA {
		
		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			final double ra2RD = ctx.ra2RD;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_DNN_NXT, true, arguments.length > 0
					? arguments[0]
					: BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra2RD;
			} finally {
				ctx.ra2RD = ra2RD;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FDEX extends CallableResultStore.CREEXFDEX {
		
		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			final double ra2RD = ctx.ra2RD;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_DNN_NXT, true, arguments.baseGetFirst(BaseObject.UNDEFINED));
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra2RD;
			} finally {
				ctx.ra2RD = ra2RD;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FEE0 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {
			
			return this.execCallPrepare(ctx, instance, store, inline, BaseObject.UNDEFINED);
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FEE2 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {
			
			return this.execCallPrepare(ctx, instance, store, inline, argument1);
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FEEX extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {
			
			return this.execCallPrepare(ctx, instance, store, inline, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FIE0 extends CallableResultStore.CREE0FIE0 {
		
		@Override
		@ReflectionHidden
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true, BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return (int) ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FIE1 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true, argument);
				ctx.vmStateToErrorOrSilence(code);
				return (int) ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FIE2 extends CallableResultStore.CREE2FIE2 {
		
		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true, argument1);
				ctx.vmStateToErrorOrSilence(code);
				return (int) ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FIEA extends CallableResultStore.CREEXFIEA {
		
		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true, arguments.length > 0
					? arguments[0]
					: BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return (int) ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FIEX extends CallableResultStore.CREEXFIEX {
		
		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true, arguments.baseGetFirst(BaseObject.UNDEFINED));
				ctx.vmStateToErrorOrSilence(code);
				return (int) ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FLE0 extends CallableResultStore.CREE0FLE0 {
		
		@Override
		@ReflectionHidden
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true, BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FLE1 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true, argument);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FLE2 extends CallableResultStore.CREE2FLE2 {
		
		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true, argument1);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FLEA extends CallableResultStore.CREEXFLEA {
		
		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true, arguments.length > 0
					? arguments[0]
					: BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FLEX extends CallableResultStore.CREEXFLEX {
		
		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true, arguments.baseGetFirst(BaseObject.UNDEFINED));
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FNE0 extends CallableResultStore.CREE0FNE0 {
		
		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_BNN_NXT, true, BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra0RB;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FNE1 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_BNN_NXT, true, argument);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra0RB;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FNE2 extends CallableResultStore.CREE2FNE2 {
		
		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_BNN_NXT, true, argument1);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra0RB;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FNEA extends CallableResultStore.CREEXFNEA {
		
		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_BNN_NXT, true, arguments.length > 0
					? arguments[0]
					: BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra0RB;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FNEX extends CallableResultStore.CREEXFNEX {
		
		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_BNN_NXT, true, arguments.baseGetFirst(BaseObject.UNDEFINED));
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra0RB;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FSE0 extends CallableResultStore.CREE0FSE0 {
		
		@Override
		@Nullable
		@ReflectionHidden
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {
			
			final CharSequence ra3RS = ctx.ra3RS;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_CNN_NXT, true, BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra3RS.toString();
			} finally {
				ctx.ra3RS = ra3RS;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FSE1 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@Nullable
		@ReflectionHidden
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			final CharSequence ra3RS = ctx.ra3RS;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_CNN_NXT, true, argument);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra3RS.toString();
			} finally {
				ctx.ra3RS = ra3RS;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FSE2 extends CallableResultStore.CREE2FSE2 {
		
		@Override
		@Nullable
		@ReflectionHidden
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final CharSequence ra3RS = ctx.ra3RS;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_CNN_NXT, true, argument1);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra3RS.toString();
			} finally {
				ctx.ra3RS = ra3RS;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FSEA extends CallableResultStore.CREEXFSEA {
		
		@Override
		@Nullable
		@ReflectionHidden
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			final CharSequence ra3RS = ctx.ra3RS;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_CNN_NXT, true, arguments.length > 0
					? arguments[0]
					: BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra3RS.toString();
			} finally {
				ctx.ra3RS = ra3RS;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FSEX extends CallableResultStore.CREEXFSEX {
		
		@Override
		@Nullable
		@ReflectionHidden
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			final CharSequence ra3RS = ctx.ra3RS;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_CNN_NXT, true, arguments.baseGetFirst(BaseObject.UNDEFINED));
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra3RS.toString();
			} finally {
				ctx.ra3RS = ra3RS;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FVE0 extends CallableResultStore.CREE0FVE0 {
		
		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FU_BNN_NXT, true, BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FVE1 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FU_BNN_NXT, true, argument);
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FVE2 extends CallableResultStore.CREE2FVE2 {
		
		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FU_BNN_NXT, true, argument1);
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FVEA extends CallableResultStore.CREEXFVEA {
		
		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FU_BNN_NXT,
						true,
						arguments.length > 0
							? arguments[0]
							: BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FVEX extends CallableResultStore.CREEXFVEX {
		
		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FU_BNN_NXT, true, arguments.baseGetFirst(BaseObject.UNDEFINED));
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FVJ0 extends CallableResultStore.CREE0FVJ0 {
		
		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {
			
			final ExecProcess ctx = Exec.currentProcess();
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FU_BNN_NXT, true, BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FVJ1 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {
			
			final ExecProcess ctx = Exec.currentProcess();
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FU_BNN_NXT, true, argument);
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FVJ2 extends CallableResultStore.CREE2FVJ2 {
		
		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final ExecProcess ctx = Exec.currentProcess();
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FU_BNN_NXT, true, argument1);
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE1FVJA extends CallableResultStore.CREEXFVJA {
		
		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {
			
			final ExecProcess ctx = Exec.currentProcess();
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FU_BNN_NXT,
						true,
						arguments.length > 0
							? arguments[0]
							: BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FDE0 extends CallableResultStore.CREE0FDE0 {
		
		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {
			
			final double ra2RD = ctx.ra2RD;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_DNN_NXT, true, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra2RD;
			} finally {
				ctx.ra2RD = ra2RD;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FDE1 extends CallableResultStore.CREE1FDE1 {
		
		@Override
		@ReflectionHidden
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			final double ra2RD = ctx.ra2RD;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_DNN_NXT, true, argument, BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra2RD;
			} finally {
				ctx.ra2RD = ra2RD;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FDE2 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final double ra2RD = ctx.ra2RD;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_DNN_NXT, true, argument1, argument2);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra2RD;
			} finally {
				ctx.ra2RD = ra2RD;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FDEA extends CallableResultStore.CREEXFDEA {
		
		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			final double ra2RD = ctx.ra2RD;
			try {
				final ExecStateCode code = this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FA_DNN_NXT,
						true,
						arguments.length > 0
							? arguments[0]
							: BaseObject.UNDEFINED,
						arguments.length > 1
							? arguments[1]
							: BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra2RD;
			} finally {
				ctx.ra2RD = ra2RD;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FDEX extends CallableResultStore.CREEXFDEX {
		
		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			final double ra2RD = ctx.ra2RD;
			try {
				final ExecStateCode code = this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FA_DNN_NXT,
						true,
						arguments.baseGetFirst(BaseObject.UNDEFINED),
						arguments.baseGet(1, BaseObject.UNDEFINED));
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra2RD;
			} finally {
				ctx.ra2RD = ra2RD;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FEE0 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {
			
			return this.execCallPrepare(ctx, instance, store, inline, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FEE1 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {
			
			return this.execCallPrepare(ctx, instance, store, inline, argument, BaseObject.UNDEFINED);
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FEEX extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {
			
			return this.execCallPrepare(//
					ctx,
					instance,
					store,
					inline,
					arguments.baseGetFirst(BaseObject.UNDEFINED),
					arguments.baseGet(1, BaseObject.UNDEFINED));
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FIE0 extends CallableResultStore.CREE0FIE0 {
		
		@Override
		@ReflectionHidden
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return (int) ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FIE1 extends CallableResultStore.CREE1FIE1 {
		
		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true, argument, BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return (int) ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FIE2 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true, argument1, argument2);
				ctx.vmStateToErrorOrSilence(code);
				return (int) ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FIEA extends CallableResultStore.CREEXFIEA {
		
		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FA_LNN_NXT,
						true,
						arguments.length > 0
							? arguments[0]
							: BaseObject.UNDEFINED,
						arguments.length > 1
							? arguments[1]
							: BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return (int) ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FIEX extends CallableResultStore.CREEXFIEX {
		
		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FA_LNN_NXT,
						true,
						arguments.baseGetFirst(BaseObject.UNDEFINED),
						arguments.baseGet(1, BaseObject.UNDEFINED));
				ctx.vmStateToErrorOrSilence(code);
				return (int) ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FLE0 extends CallableResultStore.CREE0FLE0 {
		
		@Override
		@ReflectionHidden
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FLE1 extends CallableResultStore.CREE1FLE1 {
		
		@Override
		@ReflectionHidden
		default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true, argument, BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FLE2 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true, argument1, argument2);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FLEA extends CallableResultStore.CREEXFLEA {
		
		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(
						ctx,
						instance,
						ResultHandler.FA_LNN_NXT,
						true,
						arguments.length > 0
							? arguments[0]
							: BaseObject.UNDEFINED,
						arguments.length > 1
							? arguments[1]
							: BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FLEX extends CallableResultStore.CREEXFLEX {
		
		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FA_LNN_NXT,
						true,
						arguments.baseGetFirst(BaseObject.UNDEFINED),
						arguments.baseGet(1, BaseObject.UNDEFINED));
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FNE0 extends CallableResultStore.CREE0FNE0 {
		
		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_BNN_NXT, true, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra0RB;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FNE1 extends CallableResultStore.CREE1FNE1 {
		
		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_BNN_NXT, true, argument, BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra0RB;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FNE2 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_BNN_NXT, true, argument1, argument2);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra0RB;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FNEA extends CallableResultStore.CREEXFNEA {
		
		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(
						ctx,
						instance,
						ResultHandler.FA_BNN_NXT,
						true,
						arguments.length > 0
							? arguments[0]
							: BaseObject.UNDEFINED,
						arguments.length > 1
							? arguments[1]
							: BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra0RB;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FNEX extends CallableResultStore.CREEXFNEX {
		
		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FA_BNN_NXT,
						true,
						arguments.baseGetFirst(BaseObject.UNDEFINED),
						arguments.baseGet(1, BaseObject.UNDEFINED));
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra0RB;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FSE0 extends CallableResultStore.CREE0FSE0 {
		
		@Override
		@Nullable
		@ReflectionHidden
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {
			
			final CharSequence ra3RS = ctx.ra3RS;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_CNN_NXT, true, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra3RS.toString();
			} finally {
				ctx.ra3RS = ra3RS;
			}
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FSE1 extends CallableResultStore.CREE1FSE1 {
		
		@Override
		@Nullable
		@ReflectionHidden
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			final CharSequence ra3RS = ctx.ra3RS;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_CNN_NXT, true, argument, BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra3RS.toString();
			} finally {
				ctx.ra3RS = ra3RS;
			}
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FSE2 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@Nullable
		@ReflectionHidden
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final CharSequence ra3RS = ctx.ra3RS;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_CNN_NXT, true, argument1, argument2);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra3RS.toString();
			} finally {
				ctx.ra3RS = ra3RS;
			}
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FSEA extends CallableResultStore.CREEXFSEA {
		
		@Override
		@Nullable
		@ReflectionHidden
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			final CharSequence ra3RS = ctx.ra3RS;
			try {
				final ExecStateCode code = this.execCallPrepare(
						ctx,
						instance,
						ResultHandler.FA_CNN_NXT,
						true,
						arguments.length > 0
							? arguments[0]
							: BaseObject.UNDEFINED,
						arguments.length > 1
							? arguments[1]
							: BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra3RS.toString();
			} finally {
				ctx.ra3RS = ra3RS;
			}
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FSEX extends CallableResultStore.CREEXFSEX {
		
		@Override
		@ReflectionHidden
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			final CharSequence ra3RS = ctx.ra3RS;
			try {
				final ExecStateCode code = this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FA_CNN_NXT,
						true,
						arguments.baseGetFirst(BaseObject.UNDEFINED),
						arguments.baseGet(1, BaseObject.UNDEFINED));
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra3RS.toString();
			} finally {
				ctx.ra3RS = ra3RS;
			}
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FVE0 extends CallableResultStore.CREE0FVE0 {
		
		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FU_BNN_NXT, true, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FVE1 extends CallableResultStore.CREE1FVE1 {
		
		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FU_BNN_NXT, true, argument, BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FVE2 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FU_BNN_NXT, true, argument1, argument2);
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FVEA extends CallableResultStore.CREEXFVEA {
		
		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(
						ctx,
						instance,
						ResultHandler.FU_BNN_NXT,
						true,
						arguments.length > 0
							? arguments[0]
							: BaseObject.UNDEFINED,
						arguments.length > 1
							? arguments[1]
							: BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FVEX extends CallableResultStore.CREEXFVEX {
		
		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FU_BNN_NXT,
						true,
						arguments.baseGetFirst(BaseObject.UNDEFINED),
						arguments.baseGet(1, BaseObject.UNDEFINED));
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FVJ0 extends CallableResultStore.CREE0FVJ0 {
		
		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {
			
			final ExecProcess ctx = Exec.currentProcess();
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FU_BNN_NXT, true, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FVJ1 extends CallableResultStore.CREE1FVJ1 {
		
		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {
			
			final ExecProcess ctx = Exec.currentProcess();
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FU_BNN_NXT, true, argument, BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FVJ2 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			final ExecProcess ctx = Exec.currentProcess();
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FU_BNN_NXT, true, argument1, argument2);
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREE2FVJA extends CallableResultStore.CREEXFVJA {
		
		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {
			
			final ExecProcess ctx = Exec.currentProcess();
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				final ExecStateCode code = this.execCallPrepare(
						ctx,
						instance,
						ResultHandler.FU_BNN_NXT,
						true,
						arguments.length > 0
							? arguments[0]
							: BaseObject.UNDEFINED,
						arguments.length > 1
							? arguments[1]
							: BaseObject.UNDEFINED);
				ctx.vmStateToErrorOrSilence(code);
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFDE0 extends CallableResultStore.CREE0FDE0 {
		
		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {
			
			final double ra2RD = ctx.ra2RD;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_DNN_NXT, true, ctx.argumentsEmpty());
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra2RD;
			} finally {
				ctx.ra2RD = ra2RD;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFDE1 extends CallableResultStore.CREE1FDE1 {
		
		@Override
		@ReflectionHidden
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			final double ra2RD = ctx.ra2RD;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_DNN_NXT, true, ctx.argumentsList1(argument));
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra2RD;
			} finally {
				ctx.ra2RD = ra2RD;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFDE2 extends CallableResultStore.CREE2FDE2 {
		
		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final double ra2RD = ctx.ra2RD;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_DNN_NXT, true, ctx.argumentsList2(argument1, argument2));
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra2RD;
			} finally {
				ctx.ra2RD = ra2RD;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFDEA extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			final double ra2RD = ctx.ra2RD;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_DNN_NXT, true, ctx.argumentsListA(arguments));
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra2RD;
			} finally {
				ctx.ra2RD = ra2RD;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFDEX extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			final double ra2RD = ctx.ra2RD;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_DNN_NXT, true, arguments);
				ctx.vmStateToErrorOrSilence(code);
				return ctx.ra2RD;
			} finally {
				ctx.ra2RD = ra2RD;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFEE0 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {
			
			return this.execCallPrepare(ctx, instance, store, inline, ctx.argumentsEmpty());
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFEE1 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {
			
			return this.execCallPrepare(ctx, instance, store, inline, ctx.argumentsList1(argument));
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFEE2 extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {
			
			return this.execCallPrepare(ctx, instance, store, inline, ctx.argumentsList2(argument1, argument2));
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFIE0 extends CallableResultStore.CREE0FIE0 {
		
		@Override
		@ReflectionHidden
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FA_LNN_NXT,
						true,
						ctx.argumentsEmpty()//
				));
				return (int) ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFIE1 extends CallableResultStore.CREE1FIE1 {
		
		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FA_LNN_NXT,
						true,
						ctx.argumentsList1(argument)//
				));
				return (int) ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFIE2 extends CallableResultStore.CREE2FIE2 {
		
		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FA_LNN_NXT,
						true,
						ctx.argumentsList2(argument1, argument2)//
				));
				return (int) ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFIEA extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true, ctx.argumentsListA(arguments));
				ctx.vmStateToErrorOrSilence(code);
				return (int) ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFIEX extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				final ExecStateCode code = this.execCallPrepare(ctx, instance, ResultHandler.FA_LNN_NXT, true, arguments);
				ctx.vmStateToErrorOrSilence(code);
				return (int) ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFLE0 extends CallableResultStore.CREE0FLE0 {
		
		@Override
		@ReflectionHidden
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FA_LNN_NXT,
						true,
						ctx.argumentsEmpty()//
				));
				return ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFLE1 extends CallableResultStore.CREE1FLE1 {
		
		@Override
		@ReflectionHidden
		default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FA_LNN_NXT,
						true,
						ctx.argumentsList1(argument)//
				));
				return ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFLE2 extends CallableResultStore.CREE2FLE2 {
		
		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FA_LNN_NXT,
						true,
						ctx.argumentsList2(argument1, argument2)//
				));
				return ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFLEA extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FA_LNN_NXT,
						true,
						ctx.argumentsListA(arguments)//
				));
				return ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFLEX extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			final long ra1RL = ctx.ra1RL;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FA_LNN_NXT,
						true,
						arguments//
				));
				return ctx.ra1RL;
			} finally {
				ctx.ra1RL = ra1RL;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFNE0 extends CallableResultStore.CREE0FNE0 {
		
		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FA_BNN_NXT,
						true,
						ctx.argumentsEmpty()//
				));
				return ctx.ra0RB;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFNE1 extends CallableResultStore.CREE1FNE1 {
		
		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FA_BNN_NXT,
						true,
						ctx.argumentsList1(argument)//
				));
				return ctx.ra0RB;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFNE2 extends CallableResultStore.CREE2FNE2 {
		
		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FA_BNN_NXT,
						true,
						ctx.argumentsList2(argument1, argument2)//
				));
				return ctx.ra0RB;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFNEA extends CallableResultStore.CREAAFAAA {
		
		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FA_BNN_NXT,
						true,
						ctx.argumentsListA(arguments)//
				));
				return ctx.ra0RB;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFNEX extends CallableResultStore.CREAAFAAA {
		
		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FA_BNN_NXT,
						true,
						arguments//
				));
				return ctx.ra0RB;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFSE0 extends CallableResultStore.CREE0FSE0 {
		
		@Override
		@Nullable
		@ReflectionHidden
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {
			
			final CharSequence ra3RS = ctx.ra3RS;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FA_CNN_NXT,
						true,
						ctx.argumentsEmpty()//
				));
				return ctx.ra3RS.toString();
			} finally {
				ctx.ra3RS = ra3RS;
			}
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFSE1 extends CallableResultStore.CREE1FSE1 {
		
		@Override
		@Nullable
		@ReflectionHidden
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			final CharSequence ra3RS = ctx.ra3RS;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FA_CNN_NXT,
						true,
						ctx.argumentsList1(argument)//
				));
				return ctx.ra3RS.toString();
			} finally {
				ctx.ra3RS = ra3RS;
			}
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFSE2 extends CallableResultStore.CREE2FSE2 {
		
		@Override
		@Nullable
		@ReflectionHidden
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final CharSequence ra3RS = ctx.ra3RS;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FA_CNN_NXT,
						true,
						ctx.argumentsList2(argument1, argument2)//
				));
				return ctx.ra3RS.toString();
			} finally {
				ctx.ra3RS = ra3RS;
			}
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFSEA extends CallableResultStore.CREAAFAAA {
		
		@Override
		@Nullable
		@ReflectionHidden
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			final CharSequence ra3RS = ctx.ra3RS;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FA_CNN_NXT,
						true,
						ctx.argumentsListA(arguments)//
				));
				return ctx.ra3RS.toString();
			} finally {
				ctx.ra3RS = ra3RS;
			}
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFSEX extends CallableResultStore.CREAAFAAA {
		
		@Override
		@Nullable
		@ReflectionHidden
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			final CharSequence ra3RS = ctx.ra3RS;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FA_CNN_NXT,
						true,
						arguments//
				));
				return ctx.ra3RS.toString();
			} finally {
				ctx.ra3RS = ra3RS;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFVE0 extends CallableResultStore.CREE0FVE0 {
		
		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FU_BNN_NXT,
						true,
						ctx.argumentsEmpty()//
				));
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFVE1 extends CallableResultStore.CREE1FVE1 {
		
		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FU_BNN_NXT,
						true,
						ctx.argumentsList1(argument)//
				));
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFVE2 extends CallableResultStore.CREE2FVE2 {
		
		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FU_BNN_NXT,
						true,
						ctx.argumentsList2(argument1, argument2)//
				));
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFVEA extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FU_BNN_NXT,
						true,
						ctx.argumentsListA(arguments)//
				));
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFVEX extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FU_BNN_NXT,
						true,
						arguments//
				));
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFVJ0 extends CallableResultStore.CREE0FVJ0 {
		
		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {
			
			final ExecProcess ctx = Exec.currentProcess();
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FU_BNN_NXT,
						true,
						ctx.argumentsEmpty()//
				));
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFVJ1 extends CallableResultStore.CREE1FVJ1 {
		
		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {
			
			final ExecProcess ctx = Exec.currentProcess();
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FU_BNN_NXT,
						true,
						ctx.argumentsList1(argument)//
				));
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFVJ2 extends CallableResultStore.CREE2FVJ2 {
		
		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final ExecProcess ctx = Exec.currentProcess();
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FU_BNN_NXT,
						true,
						ctx.argumentsList2(argument1, argument2)//
				));
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CREEXFVJA extends CallableResultStore.CREAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {
			
			final ExecProcess ctx = Exec.currentProcess();
			final BaseObject ra0RB = ctx.ra0RB;
			try {
				ctx.vmStateToErrorOrSilence(this.execCallPrepare(//
						ctx,
						instance,
						ResultHandler.FU_BNN_NXT,
						true,
						ctx.argumentsListA(arguments)//
				));
				return;
			} finally {
				ctx.ra0RB = ra0RB;
			}
		}
		
	}
}
