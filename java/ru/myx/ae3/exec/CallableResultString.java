package ru.myx.ae3.exec;



import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseArray;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/** @author myx */
@ReflectionDisable
interface CallableResultString {

	@ReflectionDisable
	interface CRSAAFAAA extends ExecCallable {
		//
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FDE0 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {

			return Base.toDouble(this.callSE0(ctx, instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FDE1 extends CallableResultString.CRSE1FDE1 {

		@Override
		@ReflectionHidden
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return Base.toDouble(this.callSE0(ctx, instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FDE2 extends CallableResultString.CRSE2FDE2 {

		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toDouble(this.callSE0(ctx, instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FDEA extends CallableResultString.CRSEAFDEA {

		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return Base.toDouble(this.callSE0(ctx, instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FDEX extends CallableResultString.CRSEXFDEX {

		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return Base.toDouble(this.callSE0(ctx, instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FDJ0 extends CallableResultString.CRSJ0FDJ0 {

		@Override
		@ReflectionHidden
		default double callDJ0(final BaseObject instance) {

			return Base.toDouble(this.callSE0(Exec.currentProcess(), instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FDJ1 extends CallableResultString.CRSE1FDJ1 {

		@Override
		@ReflectionHidden
		default double callDJ1(final BaseObject instance, final BaseObject argument) {

			return Base.toDouble(this.callSE0(Exec.currentProcess(), instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FDJ2 extends CallableResultString.CRSE2FDJ2 {

		@Override
		@ReflectionHidden
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toDouble(this.callSE0(Exec.currentProcess(), instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FDJA extends CallableResultString.CRSEAFDJA {

		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {

			return Base.toDouble(this.callSE0(Exec.currentProcess(), instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FEE0 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {

			return store.execReturnString(ctx, this.callSE0(ctx, instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FEE1 extends CallableResultString.CRSE1FEE1 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {

			return store.execReturnString(ctx, this.callSE0(ctx, instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FEE2 extends CallableResultString.CRSE2FEE2 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {

			return store.execReturnString(ctx, this.callSE0(ctx, instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FEEX extends CallableResultString.CRSEXFEEX {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {

			return store.execReturnString(ctx, this.callSE0(ctx, instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FIE0 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {

			return Base.toInt32(this.callSE0(ctx, instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FIE1 extends CallableResultString.CRSE1FIE1 {

		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return Base.toInt32(this.callSE0(ctx, instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FIE2 extends CallableResultString.CRSE2FIE2 {

		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toInt32(this.callSE0(ctx, instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FIEA extends CallableResultString.CRSEAFIEA {

		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return Base.toInt32(this.callSE0(ctx, instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FIEX extends CallableResultString.CRSEXFIEX {

		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return Base.toInt32(this.callSE0(ctx, instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FIJ0 extends CallableResultString.CRSJ0FIJ0 {

		@Override
		@ReflectionHidden
		default int callIJ0(final BaseObject instance) {

			return Base.toInt32(this.callSE0(Exec.currentProcess(), instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FIJ1 extends CallableResultString.CRSE1FIJ1 {

		@Override
		@ReflectionHidden
		default int callIJ1(final BaseObject instance, final BaseObject argument) {

			return Base.toInt32(this.callSE0(Exec.currentProcess(), instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FIJ2 extends CallableResultString.CRSE2FIJ2 {

		@Override
		@ReflectionHidden
		default int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toInt32(this.callSE0(Exec.currentProcess(), instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FIJA extends CallableResultString.CRSEAFIJA {

		@Override
		@ReflectionHidden
		default int callIJA(final BaseObject instance, final BaseObject... arguments) {

			return Base.toInt32(this.callSE0(Exec.currentProcess(), instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FLE0 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {

			return Base.toLong(this.callSE0(ctx, instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FLE1 extends CallableResultString.CRSE1FLE1 {

		@Override
		@ReflectionHidden
		default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return Base.toLong(this.callSE0(ctx, instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FLE2 extends CallableResultString.CRSE2FLE2 {

		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toLong(this.callSE0(ctx, instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FLEA extends CallableResultString.CRSEAFLEA {

		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return Base.toLong(this.callSE0(ctx, instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FLEX extends CallableResultString.CRSEXFLEX {

		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return Base.toLong(this.callSE0(ctx, instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FLJ0 extends CallableResultString.CRSJ0FLJ0 {

		@Override
		@ReflectionHidden
		default long callLJ0(final BaseObject instance) {

			return Base.toLong(this.callSE0(Exec.currentProcess(), instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FLJ1 extends CallableResultString.CRSE1FLJ1 {

		@Override
		@ReflectionHidden
		default long callLJ1(final BaseObject instance, final BaseObject argument) {

			return Base.toLong(this.callSE0(Exec.currentProcess(), instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FLJ2 extends CallableResultString.CRSE2FLJ2 {

		@Override
		@ReflectionHidden
		default long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toLong(this.callSE0(Exec.currentProcess(), instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FLJA extends CallableResultString.CRSEAFLJA {

		@Override
		@ReflectionHidden
		default long callLJA(final BaseObject instance, final BaseObject... arguments) {

			return Base.toLong(this.callSE0(Exec.currentProcess(), instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FNE0 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {

			return Base.forString(this.callSE0(ctx, instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FNE1 extends CallableResultString.CRSE1FNE1 {

		@Override
		@ReflectionHidden
		default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return Base.forString(this.callSE0(ctx, instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FNE2 extends CallableResultString.CRSE2FNE2 {

		@Override
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.forString(this.callSE0(ctx, instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FNEA extends CallableResultString.CRSEAFNEA {

		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return Base.forString(this.callSE0(ctx, instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FNEX extends CallableResultString.CRSEXFNEX {

		@Override
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return Base.forString(this.callSE0(ctx, instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FNJ0 extends CallableResultString.CRSJ0FNJ0 {

		@Override
		@ReflectionHidden
		default BaseObject callNJ0(final BaseObject instance) {

			return Base.forString(this.callSE0(Exec.currentProcess(), instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FNJ1 extends CallableResultString.CRSE1FNJ1 {

		@Override
		@ReflectionHidden
		default BaseObject callNJ1(final BaseObject instance, final BaseObject argument) {

			return Base.forString(this.callSE0(Exec.currentProcess(), instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FNJ2 extends CallableResultString.CRSJ0FNJ2, CallableResultString.CRSE2FNJ2 {

		@Override
		@ReflectionHidden
		default BaseObject callNJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.forString(this.callSE0(Exec.currentProcess(), instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FNJA extends CallableResultString.CRSJ0FNJA, CallableResultString.CRSEAFNJA {

		@Override
		@ReflectionHidden
		default BaseObject callNJA(final BaseObject instance, final BaseObject... arguments) {

			return Base.forString(this.callSE0(Exec.currentProcess(), instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FSE1 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callSE0(ctx, instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FSE2 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callSE0(ctx, instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FSEA extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callSE0(ctx, instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FSEX extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callSE0(ctx, instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FSJ0 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default String callSJ0(final BaseObject instance) {

			return this.callSE0(Exec.currentProcess(), instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FSJ1 extends CallableResultString.CRSE1FSJ1 {

		@Override
		@ReflectionHidden
		default String callSJ1(final BaseObject instance, final BaseObject argument) {

			return this.callSE0(Exec.currentProcess(), instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FSJ2 extends CallableResultString.CRSE2FSJ2 {

		@Override
		@ReflectionHidden
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callSE0(Exec.currentProcess(), instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FSJA extends CallableResultString.CRSEAFSJA {

		@Override
		@ReflectionHidden
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callSE0(Exec.currentProcess(), instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FVE0 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {

			this.callSE0(ctx, instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FVE1 extends CallableResultString.CRSE1FVE1 {

		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			this.callSE0(ctx, instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FVE2 extends CallableResultString.CRSE2FVE2 {

		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callSE0(ctx, instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FVEA extends CallableResultString.CRSEAFVEA {

		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			this.callSE0(ctx, instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FVEX extends CallableResultString.CRSEXFVEX {

		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			this.callSE0(ctx, instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FVJ0 extends CallableResultString.CRSJ0FVJ0 {

		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {

			this.callSE0(Exec.currentProcess(), instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FVJ1 extends CallableResultString.CRSE1FVJ1 {

		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {

			this.callSE0(Exec.currentProcess(), instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FVJ2 extends CallableResultString.CRSE2FVJ2 {

		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callSE0(Exec.currentProcess(), instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE0FVJA extends CallableResultString.CRSEAFVJA {

		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {

			this.callSE0(Exec.currentProcess(), instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FDE0 extends CallableResultString.CRSE0FDE0 {

		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {

			return Base.toDouble(this.callSE1(ctx, instance, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FDE1 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return Base.toDouble(this.callSE1(ctx, instance, argument));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FDE2 extends CallableResultString.CRSE2FDE2 {

		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toDouble(this.callSE1(ctx, instance, argument1));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FDEA extends CallableResultString.CRSEAFDEA {

		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return Base.toDouble(this.callSE1(//
					ctx,
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FDEX extends CallableResultString.CRSEXFDEX {

		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return Base.toDouble(this.callSE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED)));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FDJ0 extends CallableResultString.CRSE0FDJ0 {

		@Override
		@ReflectionHidden
		default double callDJ0(final BaseObject instance) {

			return Base.toDouble(this.callSE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FDJ1 extends CallableResultString.CRSJ1FDJ1 {

		@Override
		@ReflectionHidden
		default double callDJ1(final BaseObject instance, final BaseObject argument) {

			return Base.toDouble(this.callSE1(//
					Exec.currentProcess(),
					instance,
					argument));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FDJ2 extends CallableResultString.CRSE2FDJ2 {

		@Override
		@ReflectionHidden
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toDouble(this.callSE1(Exec.currentProcess(), instance, argument1));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FDJA extends CallableResultString.CRSEAFDJA {

		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {

			return Base.toDouble(this.callSE1(//
					Exec.currentProcess(),
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FEE0 extends CallableResultString.CRSE0FEE0 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {

			return store.execReturnString(ctx, this.callSE1(ctx, instance, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FEE1 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {

			return store.execReturnString(ctx, this.callSE1(ctx, instance, argument));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FEE2 extends CallableResultString.CRSE2FEE2 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {

			return store.execReturnString(ctx, this.callSE1(ctx, instance, argument1));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FEEX extends CallableResultString.CRSEXFEEX {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {

			return store.execReturnString(ctx, this.callSE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED)));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FIE0 extends CallableResultString.CRSE0FIE0 {

		@Override
		@ReflectionHidden
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {

			return Base.toInt32(this.callSE1(ctx, instance, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FIE1 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return Base.toInt32(this.callSE1(ctx, instance, argument));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FIE2 extends CallableResultString.CRSE2FIE2 {

		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toInt32(this.callSE1(ctx, instance, argument1));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FIEA extends CallableResultString.CRSEAFIEA {

		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return Base.toInt32(this.callSE1(//
					ctx,
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FIEX extends CallableResultString.CRSEXFIEX {

		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return Base.toInt32(this.callSE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED)));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FIJ0 extends CallableResultString.CRSE0FIJ0 {

		@Override
		@ReflectionHidden
		default int callIJ0(final BaseObject instance) {

			return Base.toInt32(this.callSE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FIJ1 extends CallableResultString.CRSJ1FIJ1 {

		@Override
		@ReflectionHidden
		default int callIJ1(final BaseObject instance, final BaseObject argument) {

			return Base.toInt32(this.callSE1(Exec.currentProcess(), instance, argument));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FIJ2 extends CallableResultString.CRSE2FIJ2 {

		@Override
		@ReflectionHidden
		default int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toInt32(this.callSE1(Exec.currentProcess(), instance, argument1));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FIJA extends CallableResultString.CRSEAFIJA {

		@Override
		@ReflectionHidden
		default int callIJA(final BaseObject instance, final BaseObject... arguments) {

			return Base.toInt32(this.callSE1(//
					Exec.currentProcess(),
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FLE0 extends CallableResultString.CRSE0FLE0 {

		@Override
		@ReflectionHidden
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {

			return Base.toLong(this.callSE1(ctx, instance, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FLE1 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return Base.toLong(this.callSE1(ctx, instance, argument));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FLE2 extends CallableResultString.CRSE2FLE2 {

		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toLong(this.callSE1(ctx, instance, argument1));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FLEA extends CallableResultString.CRSEAFLEA {

		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return Base.toLong(this.callSE1(ctx, instance, arguments.length == 0
				? BaseObject.UNDEFINED
				: arguments[0]));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FLEX extends CallableResultString.CRSEXFLEX {

		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return Base.toLong(this.callSE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED)));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FLJ0 extends CallableResultString.CRSE0FLJ0 {

		@Override
		@ReflectionHidden
		default long callLJ0(final BaseObject instance) {

			return Base.toLong(this.callSE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FLJ1 extends CallableResultString.CRSJ1FLJ1 {

		@Override
		@ReflectionHidden
		default long callLJ1(final BaseObject instance, final BaseObject argument) {

			return Base.toLong(this.callSE1(Exec.currentProcess(), instance, argument));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FLJ2 extends CallableResultString.CRSE2FLJ2 {

		@Override
		@ReflectionHidden
		default long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toLong(this.callSE1(Exec.currentProcess(), instance, argument1));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FLJA extends CallableResultString.CRSEAFLJA {

		@Override
		@ReflectionHidden
		default long callLJA(final BaseObject instance, final BaseObject... arguments) {

			return Base.toLong(this.callSE1(Exec.currentProcess(), instance, arguments.length == 0
				? BaseObject.UNDEFINED
				: arguments[0]));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FNE0 extends CallableResultString.CRSE0FNE0 {

		@Override
		@ReflectionHidden
		default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {

			return Base.forString(this.callSE1(ctx, instance, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FNE1 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return Base.forString(this.callSE1(ctx, instance, argument));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FNE2 extends CallableResultString.CRSE2FNE2 {

		@Override
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.forString(this.callSE1(ctx, instance, argument1));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FNEA extends CallableResultString.CRSEAFNEA {

		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return Base.forString(this.callSE1(ctx, instance, arguments.length > 0
				? arguments[0]
				: BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FNEX extends CallableResultString.CRSEXFNEX {

		@Override
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return Base.forString(this.callSE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED)));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FNJ0 extends CallableResultString.CRSE0FNJ0 {

		@Override
		@ReflectionHidden
		default BaseObject callNJ0(final BaseObject instance) {

			return Base.forString(this.callSE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FNJ1 extends CallableResultString.CRSJ1FNJ1 {

		@Override
		@ReflectionHidden
		default BaseObject callNJ1(final BaseObject instance, final BaseObject argument) {

			return Base.forString(this.callSE1(Exec.currentProcess(), instance, argument));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FNJ2 extends CallableResultString.CRSE2FNJ2 {

		@Override
		@ReflectionHidden
		default BaseObject callNJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.forString(this.callSE1(Exec.currentProcess(), instance, argument1));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FNJA extends CallableResultString.CRSEAFNJA {

		@Override
		@ReflectionHidden
		default BaseObject callNJA(final BaseObject instance, final BaseObject... arguments) {

			return Base.forString(this.callSE1(Exec.currentProcess(), instance, arguments.length > 0
				? arguments[0]
				: BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FSE0 extends CallableResultString.CRSAAFAAA {

		@Override
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callSE1(ctx, instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FSE2 extends CallableResultString.CRSAAFAAA {

		@Override
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callSE1(ctx, instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FSEA extends CallableResultString.CRSAAFAAA {

		@Override
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callSE1(//
					ctx,
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FSEX extends CallableResultString.CRSAAFAAA {

		@Override
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callSE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FSJ0 extends CallableResultString.CRSE0FSJ0 {

		@Override
		default String callSJ0(final BaseObject instance) {

			return this.callSE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FSJ1 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default String callSJ1(final BaseObject instance, final BaseObject argument) {

			return this.callSE1(Exec.currentProcess(), instance, argument);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FSJ2 extends CallableResultString.CRSE2FSJ2 {

		@Override
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callSE1(Exec.currentProcess(), instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FSJA extends CallableResultString.CRSEAFSJA {

		@Override
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callSE1(Exec.currentProcess(), instance, arguments.length == 0
				? BaseObject.UNDEFINED
				: arguments[0]);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FVE0 extends CallableResultString.CRSE0FVE0 {

		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {

			this.callSE1(ctx, instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FVE1 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			this.callSE1(ctx, instance, argument);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FVE2 extends CallableResultString.CRSE2FVE2 {

		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callSE1(ctx, instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FVEA extends CallableResultString.CRSEAFVEA {

		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			this.callSE1(//
					ctx,
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FVEX extends CallableResultString.CRSEXFVEX {

		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			this.callSE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FVJ0 extends CallableResultString.CRSE0FVJ0 {

		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {

			this.callSE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FVJ1 extends CallableResultString.CRSJ1FVJ1 {

		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {

			this.callSE1(Exec.currentProcess(), instance, argument);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FVJ2 extends CallableResultString.CRSE2FVJ2 {

		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callSE1(Exec.currentProcess(), instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE1FVJA extends CallableResultString.CRSEAFVJA {

		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {

			this.callSE1(//
					Exec.currentProcess(),
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE2FDE2 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toDouble(this.callSE2(ctx, instance, argument1, argument2));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE2FDJ2 extends CallableResultString.CRSJ2FDJ2 {

		@Override
		@ReflectionHidden
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toDouble(this.callSE2(Exec.currentProcess(), instance, argument1, argument2));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE2FEE2 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {

			return store.execReturnString(ctx, this.callSE2(ctx, instance, argument1, argument2));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE2FIE2 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toInt32(this.callSE2(ctx, instance, argument1, argument2));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE2FIJ2 extends CallableResultString.CRSJ2FIJ2 {

		@Override
		@ReflectionHidden
		default int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toInt32(this.callSE2(Exec.currentProcess(), instance, argument1, argument2));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE2FLE2 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toLong(this.callSE2(ctx, instance, argument1, argument2));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE2FLJ2 extends CallableResultString.CRSJ2FLJ2 {

		@Override
		@ReflectionHidden
		default long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toLong(this.callSE2(Exec.currentProcess(), instance, argument1, argument2));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE2FNE2 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.forString(this.callSE2(ctx, instance, argument1, argument2));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE2FNJ2 extends CallableResultString.CRSJ2FNJ2 {

		@Override
		@ReflectionHidden
		default BaseObject callNJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.forString(this.callSE2(Exec.currentProcess(), instance, argument1, argument2));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE2FSE0 extends CallableResultString.CRSAAFAAA {

		@Override
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callSE2(ctx, instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE2FSE1 extends CallableResultString.CRSAAFAAA {

		@Override
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callSE2(ctx, instance, argument, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE2FSEA extends CallableResultString.CRSAAFAAA {

		@Override
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callSE2(//
					ctx,
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED,
					arguments.length > 1
						? arguments[1]
						: BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE2FSEX extends CallableResultString.CRSAAFAAA {

		@Override
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callSE2(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED), arguments.baseGet(1, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE2FSJ0 extends CallableResultString.CRSE0FSJ0 {

		@Override
		default String callSJ0(final BaseObject instance) {

			return this.callSE2(Exec.currentProcess(), instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE2FSJ1 extends CallableResultString.CRSE1FSJ1 {

		@Override
		default String callSJ1(final BaseObject instance, final BaseObject argument) {

			return this.callSE2(Exec.currentProcess(), instance, argument, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE2FSJ2 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callSE2(Exec.currentProcess(), instance, argument1, argument2);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE2FSJA extends CallableResultString.CRSEAFSJA {

		@Override
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callSE2(
					Exec.currentProcess(),
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED,
					arguments.length > 1
						? arguments[1]
						: BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE2FVE2 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callSE2(ctx, instance, argument1, argument2);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSE2FVJ2 extends CallableResultString.CRSJ2FVJ2 {

		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callSE2(Exec.currentProcess(), instance, argument1, argument2);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSEAFDEA extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return Base.toDouble(this.callSEA(ctx, instance, arguments));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSEAFDJA extends CallableResultString.CRSJAFDJA {

		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {

			return Base.toDouble(this.callSEA(Exec.currentProcess(), instance, arguments));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSEAFIEA extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return Base.toInt32(this.callSEA(ctx, instance, arguments));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSEAFIJA extends CallableResultString.CRSJAFIJA {

		@Override
		@ReflectionHidden
		default int callIJA(final BaseObject instance, final BaseObject... arguments) {

			return Base.toInt32(this.callSEA(Exec.currentProcess(), instance, arguments));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSEAFLEA extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return Base.toLong(this.callSEA(ctx, instance, arguments));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSEAFLJA extends CallableResultString.CRSJAFLJA {

		@Override
		@ReflectionHidden
		default long callLJA(final BaseObject instance, final BaseObject... arguments) {

			return Base.toLong(this.callSEA(Exec.currentProcess(), instance, arguments));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSEAFNEA extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return Base.forString(this.callSEA(ctx, instance, arguments));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSEAFNJA extends CallableResultString.CRSJAFNJA {

		@Override
		@ReflectionHidden
		default BaseObject callNJA(final BaseObject instance, final BaseObject... arguments) {

			return Base.forString(this.callSEA(Exec.currentProcess(), instance, arguments));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSEAFSJA extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callSEA(Exec.currentProcess(), instance, arguments);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSEAFVEA extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			this.callSEA(ctx, instance, arguments);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSEAFVJA extends CallableResultString.CRSJAFVJA {

		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {

			this.callSEA(//
					Exec.currentProcess(),
					instance,
					arguments);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSEXFDEX extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return Base.toDouble(this.callSEX(ctx, instance, arguments));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSEXFEEX extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {

			return store.execReturnString(ctx, this.callSEX(ctx, instance, arguments));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSEXFIEX extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return Base.toInt32(this.callSEX(ctx, instance, arguments));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSEXFLEX extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return Base.toLong(this.callSEX(ctx, instance, arguments));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSEXFNEX extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return Base.forString(this.callSEX(ctx, instance, arguments));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSEXFSE0 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callSE1(ctx, instance, ctx.argumentsEmpty());
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSEXFSE1 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callSE1(ctx, instance, ctx.argumentsList1(argument));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSEXFSE2 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callSE1(ctx, instance, ctx.argumentsList2(argument1, argument2));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSEXFSEA extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... argument) {

			return this.callSE1(ctx, instance, ctx.argumentsListA(argument));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSEXFSJ0 extends CallableResultString.CRSE0FSJ0 {

		@Override
		@ReflectionHidden
		default String callSJ0(final BaseObject instance) {

			final ExecProcess ctx = Exec.currentProcess();
			return this.callSE1(ctx, instance, ctx.argumentsEmpty());
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSEXFSJ1 extends CallableResultString.CRSE1FSJ1 {

		@Override
		@ReflectionHidden
		default String callSJ1(final BaseObject instance, final BaseObject argument) {

			final ExecProcess ctx = Exec.currentProcess();
			return this.callSE1(ctx, instance, ctx.argumentsList1(argument));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSEXFSJ2 extends CallableResultString.CRSE2FSJ2 {

		@Override
		@ReflectionHidden
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			final ExecProcess ctx = Exec.currentProcess();
			return this.callSE1(ctx, instance, ctx.argumentsList2(argument1, argument2));
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRSEXFSJA extends CallableResultString.CRSEAFSJA {

		@Override
		@ReflectionHidden
		default String callSJA(final BaseObject instance, final BaseObject... argument) {

			final ExecProcess ctx = Exec.currentProcess();
			return this.callSE1(ctx, instance, ctx.argumentsListA(argument));
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRSEXFVEX extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			this.callSEX(ctx, instance, arguments);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FDE0 extends CallableResultString.CRSE0FDE0 {

		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {

			return Base.toDouble(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FDE1 extends CallableResultString.CRSJ1FDE1 {

		@Override
		@ReflectionHidden
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return Base.toDouble(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FDE2 extends CallableResultString.CRSJ2FDE2 {

		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toDouble(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FDEA extends CallableResultString.CRSJAFDEA {

		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return Base.toDouble(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FDEX extends CallableResultString.CRSJAFDEX {

		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return Base.toDouble(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FDJ0 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default double callDJ0(final BaseObject instance) {

			return Base.toDouble(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FDJ1 extends CallableResultString.CRSJ1FDJ1 {

		@Override
		@ReflectionHidden
		default double callDJ1(final BaseObject instance, final BaseObject argument) {

			return Base.toDouble(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FDJ2 extends CallableResultString.CRSJ2FDJ2 {

		@Override
		@ReflectionHidden
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toDouble(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FDJA extends CallableResultString.CRSJAFDJA {

		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {

			return Base.toDouble(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FEE0 extends CallableResultString.CRSE0FEE0 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {

			return store.execReturnString(ctx, this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FEE1 extends CallableResultString.CRSJ1FEE1 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {

			return store.execReturnString(ctx, this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FEE2 extends CallableResultString.CRSJ2FEE2 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {

			return store.execReturnString(ctx, this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FEEX extends CallableResultString.CRSJAFEEX {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {

			return store.execReturnString(ctx, this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FIE0 extends CallableResultString.CRSE0FIE0 {

		@Override
		@ReflectionHidden
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {

			return Base.toInt32(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FIE1 extends CallableResultString.CRSJ1FIE1 {

		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return Base.toInt32(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FIE2 extends CallableResultString.CRSJ2FIE2 {

		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toInt32(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FIEA extends CallableResultString.CRSJAFIEA {

		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return Base.toInt32(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FIEX extends CallableResultString.CRSJAFIEX {

		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return Base.toInt32(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FIJ0 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default int callIJ0(final BaseObject instance) {

			return Base.toInt32(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FIJ1 extends CallableResultString.CRSJ1FIJ1 {

		@Override
		@ReflectionHidden
		default int callIJ1(final BaseObject instance, final BaseObject argument) {

			return Base.toInt32(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FIJ2 extends CallableResultString.CRSJ2FIJ2 {

		@Override
		@ReflectionHidden
		default int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toInt32(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FIJA extends CallableResultString.CRSJAFIJA {

		@Override
		@ReflectionHidden
		default int callIJA(final BaseObject instance, final BaseObject... arguments) {

			return Base.toInt32(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FLE0 extends CallableResultString.CRSE0FLE0 {

		@Override
		@ReflectionHidden
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {

			return Base.toLong(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FLE1 extends CallableResultString.CRSJ1FLE1 {

		@Override
		@ReflectionHidden
		default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return Base.toLong(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FLE2 extends CallableResultString.CRSJ2FLE2 {

		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toLong(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FLEA extends CallableResultString.CRSJAFLEA {

		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return Base.toLong(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FLEX extends CallableResultString.CRSJAFLEX {

		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return Base.toLong(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FLJ0 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default long callLJ0(final BaseObject instance) {

			return Base.toLong(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FLJ1 extends CallableResultString.CRSJ1FLJ1 {

		@Override
		@ReflectionHidden
		default long callLJ1(final BaseObject instance, final BaseObject argument) {

			return Base.toLong(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FLJ2 extends CallableResultString.CRSJ2FLJ2 {

		@Override
		@ReflectionHidden
		default long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toLong(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FLJA extends CallableResultString.CRSJAFLJA {

		@Override
		@ReflectionHidden
		default long callLJA(final BaseObject instance, final BaseObject... arguments) {

			return Base.toLong(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FNE0 extends CallableResultString.CRSE0FNE0 {

		@Override
		@ReflectionHidden
		default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {

			return Base.forString(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FNE1 extends CallableResultString.CRSJ1FNE1 {

		@Override
		@ReflectionHidden
		default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return Base.forString(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FNE2 extends CallableResultString.CRSE0FNE2, CallableResultString.CRSJ2FNE2 {

		@Override
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.forString(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FNEA extends CallableResultString.CRSE0FNEA, CallableResultString.CRSJAFNEA {

		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return Base.forString(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FNEX extends CallableResultString.CRSE0FNEX, CallableResultString.CRSJAFNEX {

		@Override
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return Base.forString(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FNJ0 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNJ0(final BaseObject instance) {

			return Base.forString(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FNJ1 extends CallableResultString.CRSJ1FNJ1 {

		@Override
		@ReflectionHidden
		default BaseObject callNJ1(final BaseObject instance, final BaseObject argument) {

			return Base.forString(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FNJ2 extends CallableResultString.CRSJ2FNJ2 {

		@Override
		@ReflectionHidden
		default BaseObject callNJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.forString(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FNJA extends CallableResultString.CRSJAFNJA {

		@Override
		@ReflectionHidden
		default BaseObject callNJA(final BaseObject instance, final BaseObject... arguments) {

			return Base.forString(this.callSJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FSE0 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callSJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FSE1 extends CallableResultString.CRSJ1FSE1 {

		@Override
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callSJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FSE2 extends CallableResultString.CRSJ2FSE2 {

		@Override
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callSJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FSEA extends CallableResultString.CRSJAFSEA {

		@Override
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callSJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FSEX extends CallableResultString.CRSJAFSEX {

		@Override
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callSJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FSJ1 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default String callSJ1(final BaseObject instance, final BaseObject argument) {

			return this.callSJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FSJ2 extends CallableResultString.CRSAAFAAA {

		@Override
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callSJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FSJA extends CallableResultString.CRSAAFAAA {

		@Override
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callSJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FVE0 extends CallableResultString.CRSE0FVE0 {

		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {

			this.callSJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FVE1 extends CallableResultString.CRSJ1FVE1 {

		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			this.callSJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FVE2 extends CallableResultString.CRSJ2FVE2 {

		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callSJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FVEA extends CallableResultString.CRSJAFVEA {

		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			this.callSJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FVEX extends CallableResultString.CRSJAFVEX {

		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			this.callSJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FVJ0 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {

			this.callSJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FVJ1 extends CallableResultString.CRSJ1FVJ1 {

		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {

			this.callSJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FVJ2 extends CallableResultString.CRSJ2FVJ2 {

		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callSJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ0FVJA extends CallableResultString.CRSJAFVJA {

		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {

			this.callSJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FDE0 extends CallableResultString.CRSJ0FDE0 {

		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {

			return Base.toDouble(this.callSJ1(instance, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FDE1 extends CallableResultString.CRSE1FDE1 {

		@Override
		@ReflectionHidden
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return Base.toDouble(this.callSJ1(instance, argument));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FDE2 extends CallableResultString.CRSJ2FDE2 {

		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toDouble(this.callSJ1(instance, argument1));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FDEA extends CallableResultString.CRSJAFDEA {

		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return Base.toDouble(this.callSJ1(//
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FDEX extends CallableResultString.CRSJAFDEX {

		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return Base.toDouble(this.callSJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED)));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FDJ0 extends CallableResultString.CRSJ0FDJ0 {

		@Override
		@ReflectionHidden
		default double callDJ0(final BaseObject instance) {

			return Base.toDouble(this.callSJ1(instance, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FDJ1 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default double callDJ1(final BaseObject instance, final BaseObject argument) {

			return Base.toDouble(this.callSJ1(instance, argument));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FDJ2 extends CallableResultString.CRSJ2FDJ2 {

		@Override
		@ReflectionHidden
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toDouble(this.callSJ1(instance, argument1));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FDJA extends CallableResultString.CRSJAFDJA {

		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {

			return Base.toDouble(this.callSJ1(//
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FEE0 extends CallableResultString.CRSJ0FEE0 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {

			return store.execReturnString(ctx, this.callSJ1(instance, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FEE1 extends CallableResultString.CRSE1FEE1 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {

			return store.execReturnString(ctx, this.callSJ1(instance, argument));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FEE2 extends CallableResultString.CRSJ2FEE2 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {

			return store.execReturnString(ctx, this.callSJ1(instance, argument1));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FEEX extends CallableResultString.CRSJAFEEX {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {

			return store.execReturnString(ctx, this.callSJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED)));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FIE0 extends CallableResultString.CRSJ0FIE0 {

		@Override
		@ReflectionHidden
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {

			return Base.toInt32(this.callSJ1(instance, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FIE1 extends CallableResultString.CRSE1FIE1 {

		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return Base.toInt32(this.callSJ1(instance, argument));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FIE2 extends CallableResultString.CRSJ2FIE2 {

		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toInt32(this.callSJ1(instance, argument1));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FIEA extends CallableResultString.CRSJAFIEA {

		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return Base.toInt32(this.callSJ1(//
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FIEX extends CallableResultString.CRSJAFIEX {

		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return Base.toInt32(this.callSJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED)));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FIJ0 extends CallableResultString.CRSJ0FIJ0 {

		@Override
		@ReflectionHidden
		default int callIJ0(final BaseObject instance) {

			return Base.toInt32(this.callSJ1(instance, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FIJ1 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default int callIJ1(final BaseObject instance, final BaseObject argument) {

			return Base.toInt32(this.callSJ1(instance, argument));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FIJ2 extends CallableResultString.CRSJ2FIJ2 {

		@Override
		@ReflectionHidden
		default int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toInt32(this.callSJ1(instance, argument1));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FIJA extends CallableResultString.CRSJAFIJA {

		@Override
		@ReflectionHidden
		default int callIJA(final BaseObject instance, final BaseObject... arguments) {

			return Base.toInt32(this.callSJ1(//
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FLE0 extends CallableResultString.CRSJ0FLE0 {

		@Override
		@ReflectionHidden
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {

			return Base.toLong(this.callSJ1(instance, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FLE1 extends CallableResultString.CRSE1FLE1 {

		@Override
		@ReflectionHidden
		default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return Base.toLong(this.callSJ1(instance, argument));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FLE2 extends CallableResultString.CRSJ2FLE2 {

		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toLong(this.callSJ1(instance, argument1));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FLEA extends CallableResultString.CRSJAFLEA {

		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return Base.toLong(this.callSJ1(instance, arguments.length == 0
				? BaseObject.UNDEFINED
				: arguments[0]));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FLEX extends CallableResultString.CRSJAFLEX {

		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return Base.toLong(this.callSJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED)));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FLJ0 extends CallableResultString.CRSJ0FLJ0 {

		@Override
		@ReflectionHidden
		default long callLJ0(final BaseObject instance) {

			return Base.toLong(this.callSJ1(instance, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FLJ1 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default long callLJ1(final BaseObject instance, final BaseObject argument) {

			return Base.toLong(this.callSJ1(instance, argument));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FLJ2 extends CallableResultString.CRSJ2FLJ2 {

		@Override
		@ReflectionHidden
		default long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toLong(this.callSJ1(instance, argument1));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FLJA extends CallableResultString.CRSJAFLJA {

		@Override
		@ReflectionHidden
		default long callLJA(final BaseObject instance, final BaseObject... arguments) {

			return Base.toLong(this.callSJ1(instance, arguments.length == 0
				? BaseObject.UNDEFINED
				: arguments[0]));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FNE0 extends CallableResultString.CRSJ0FNE0 {

		@Override
		@ReflectionHidden
		default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {

			return Base.forString(this.callSJ1(instance, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FNE1 extends CallableResultString.CRSE1FNE1 {

		@Override
		@ReflectionHidden
		default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return Base.forString(this.callSJ1(instance, argument));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FNE2 extends CallableResultString.CRSE1FNE2, CallableResultString.CRSJ2FNE2 {

		@Override
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.forString(this.callSJ1(instance, argument1));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FNEA extends CallableResultString.CRSE1FNEA, CallableResultString.CRSJAFNEA {

		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return Base.forString(this.callSJ1(instance, arguments.length > 0
				? arguments[0]
				: BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FNEX extends CallableResultString.CRSE1FNEX, CallableResultString.CRSJAFNEX {

		@Override
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return Base.forString(this.callSJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED)));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FNJ0 extends CallableResultString.CRSJ0FNJ0 {

		@Override
		@ReflectionHidden
		default BaseObject callNJ0(final BaseObject instance) {

			return Base.forString(this.callSJ1(instance, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FNJ1 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNJ1(final BaseObject instance, final BaseObject argument) {

			return Base.forString(this.callSJ1(instance, argument));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FNJ2 extends CallableResultString.CRSJ2FNJ2 {

		@Override
		@ReflectionHidden
		default BaseObject callNJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.forString(this.callSJ1(instance, argument1));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FNJA extends CallableResultString.CRSJAFNJA {

		@Override
		@ReflectionHidden
		default BaseObject callNJA(final BaseObject instance, final BaseObject... arguments) {

			return Base.forString(this.callSJ1(instance, arguments.length > 0
				? arguments[0]
				: BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FSE0 extends CallableResultString.CRSJ0FSE0 {

		@Override
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callSJ1(instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FSE1 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callSJ1(instance, argument);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FSE2 extends CallableResultString.CRSJ2FSE2 {

		@Override
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callSJ1(instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FSEA extends CallableResultString.CRSJAFSEA {

		@Override
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callSJ1(instance, arguments.length == 0
				? BaseObject.UNDEFINED
				: arguments[0]);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FSEX extends CallableResultString.CRSJAFSEX {

		@Override
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callSJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FSJ0 extends CallableResultString.CRSAAFAAA {

		@Override
		default String callSJ0(final BaseObject instance) {

			return this.callSJ1(instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FSJ2 extends CallableResultString.CRSAAFAAA {

		@Override
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callSJ1(instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FSJA extends CallableResultString.CRSAAFAAA {

		@Override
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callSJ1(instance, arguments.length == 0
				? BaseObject.UNDEFINED
				: arguments[0]);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FVE0 extends CallableResultString.CRSJ0FVE0 {

		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {

			this.callSJ1(instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FVE1 extends CallableResultString.CRSE1FVE1 {

		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			this.callSJ1(instance, argument);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FVE2 extends CallableResultString.CRSJ2FVE2 {

		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callSJ1(instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FVEA extends CallableResultString.CRSJAFVEA {

		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			this.callSJ1(//
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FVEX extends CallableResultString.CRSJAFVEX {

		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			this.callSJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FVJ0 extends CallableResultString.CRSJ0FVJ0 {

		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {

			this.callSJ1(instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FVJ1 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {

			this.callSJ1(instance, argument);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FVJ2 extends CallableResultString.CRSJ2FVJ2 {

		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callSJ1(instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ1FVJA extends CallableResultString.CRSJAFVJA {

		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {

			this.callSJ1(//
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ2FDE2 extends CallableResultString.CRSE2FDE2 {

		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toDouble(this.callSJ2(instance, argument1, argument2));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ2FDJ2 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toDouble(this.callSJ2(instance, argument1, argument2));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ2FEE2 extends CallableResultString.CRSE2FEE2 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {

			return store.execReturnString(ctx, this.callSJ2(instance, argument1, argument2));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ2FIE2 extends CallableResultString.CRSE2FIE2 {

		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toInt32(this.callSJ2(instance, argument1, argument2));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ2FIJ2 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toInt32(this.callSJ2(instance, argument1, argument2));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ2FLE2 extends CallableResultString.CRSE2FLE2 {

		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toLong(this.callSJ2(instance, argument1, argument2));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ2FLJ2 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.toLong(this.callSJ2(instance, argument1, argument2));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ2FNE2 extends CallableResultString.CRSE2FNE2 {

		@Override
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.forString(this.callSJ2(instance, argument1, argument2));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ2FNJ2 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return Base.forString(this.callSJ2(instance, argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ2FSE0 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callSJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ2FSE1 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callSJ2(instance, argument, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ2FSE2 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callSJ2(instance, argument1, argument2);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ2FSEA extends CallableResultString.CRSJAFSEA {

		@Override
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callSJ2(//
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED,
					arguments.length > 1
						? arguments[1]
						: BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ2FSEX extends CallableResultString.CRSJAFSEX {

		@Override
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callSJ2(//
					instance,
					arguments.baseGetFirst(BaseObject.UNDEFINED),
					arguments.baseGet(1, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ2FSJ0 extends CallableResultString.CRSAAFAAA {

		@Override
		default String callSJ0(final BaseObject instance) {

			return this.callSJ2(//
					instance,
					BaseObject.UNDEFINED,
					BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ2FSJ1 extends CallableResultString.CRSAAFAAA {

		@Override
		default String callSJ1(final BaseObject instance, final BaseObject argument) {

			return this.callSJ2(//
					instance,
					argument,
					BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ2FSJA extends CallableResultString.CRSAAFAAA {

		@Override
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callSJ2(//
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED,
					arguments.length > 1
						? arguments[1]
						: BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ2FVE2 extends CallableResultString.CRSE2FVE2 {

		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callSJ2(instance, argument1, argument2);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJ2FVJ2 extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callSJ2(instance, argument1, argument2);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJAFDEA extends CallableResultString.CRSEAFDEA {

		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return Base.toDouble(this.callSJA(instance, arguments));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJAFDEX extends CallableResultString.CRSEXFDEX {

		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return Base.toDouble(this.callSEA(ctx, instance, arguments.toArrayBase()));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJAFDJA extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {

			return Base.toDouble(this.callSJA(instance, arguments));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJAFEEX extends CallableResultString.CRSEXFEEX {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {

			return store.execReturnString(ctx, this.callSJA(instance, arguments.toArrayBase()));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJAFIEA extends CallableResultString.CRSEAFIEA {

		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return Base.toInt32(this.callSJA(instance, arguments));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJAFIEX extends CallableResultString.CRSEXFIEX {

		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return Base.toInt32(this.callSJA(instance, arguments.toArrayBase()));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJAFIJA extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default int callIJA(final BaseObject instance, final BaseObject... arguments) {

			return Base.toInt32(this.callSJA(instance, arguments));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJAFLEA extends CallableResultString.CRSEAFLEA {

		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return Base.toLong(this.callSJA(instance, arguments));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJAFLEX extends CallableResultString.CRSEXFLEX {

		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return Base.toLong(this.callSJA(instance, arguments.toArrayBase()));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJAFLJA extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default long callLJA(final BaseObject instance, final BaseObject... arguments) {

			return Base.toLong(this.callSJA(instance, arguments));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJAFNEA extends CallableResultString.CRSEAFNEA {

		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return Base.forString(this.callSJA(instance, arguments));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJAFNEX extends CallableResultString.CRSEXFNEX {

		@Override
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return Base.forString(this.callSJA(instance, arguments.toArrayBase()));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJAFNJA extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNJA(final BaseObject instance, final BaseObject... arguments) {

			return Base.forString(this.callSJA(instance, arguments));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJAFSEA extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callSJA(instance, arguments);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJAFSEX extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callSJA(instance, arguments.toArrayBase());
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJAFVEA extends CallableResultString.CRSEAFVEA {

		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			this.callSJA(instance, arguments);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJAFVEX extends CallableResultString.CRSEXFVEX {

		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			this.callSJA(instance, arguments.toArrayBase());
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJAFVJA extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {

			this.callSJA(instance, arguments);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRSJXFIEX extends CallableResultString.CRSAAFAAA {

		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return Base.toInt32(this.callSEX(ctx, instance, arguments));
		}
	}
}
