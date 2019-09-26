package ru.myx.ae3.exec;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseArray;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.base.ToPrimitiveHint;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/** @author myx */
@ReflectionDisable
interface CallableResultNative {

	interface CRNAAFAAA extends ExecCallable {
		//
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FDE0 extends CallableResultNative.CRNAAFAAA {

		@Override
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNE0(ctx, instance)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FDE1 extends CallableResultNative.CRNE1FDE1 {

		@Override
		@ReflectionHidden
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNE0(ctx, instance).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FDE2 extends CallableResultNative.CRNE2FDE2 {

		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNE0(ctx, instance).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FDEA extends CallableResultNative.CRNEAFDEA {

		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNE0(ctx, instance).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FDEX extends CallableResultNative.CRNEXFDEX {

		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNE0(ctx, instance)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FDJ0 extends CallableResultNative.CRNJ0FDJ0 {

		@Override
		@ReflectionHidden
		default double callDJ0(final BaseObject instance) {

			return this.callNE0(Exec.currentProcess(), instance).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FDJ1 extends CallableResultNative.CRNE1FDJ1, CallableResultNative.CRNJ0FDJ1 {

		@Override
		default double callDJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNE0(Exec.currentProcess(), instance)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FDJ2 extends CallableResultNative.CRNE2FDJ2, CallableResultNative.CRNJ0FDJ2 {

		@Override
		@ReflectionHidden
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNE0(Exec.currentProcess(), instance).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FDJA extends CallableResultNative.CRNEAFDJA {

		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callNE0(Exec.currentProcess(), instance).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FEE0 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {

			return store.execReturn(ctx, this.callNE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FEE1 extends CallableResultNative.CRNE1FEE1 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {

			return store.execReturn(ctx, this.callNE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FEE2 extends CallableResultNative.CRNE2FEE2 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {

			return store.execReturn(ctx, this.callNE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FEEX extends CallableResultNative.CRNEXFEEX {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {

			return store.execReturn(ctx, this.callNE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FIE0 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNE0(ctx, instance).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FIE1 extends CallableResultNative.CRNE1FIE1 {

		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNE0(ctx, instance).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FIE2 extends CallableResultNative.CRNE2FIE2 {

		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNE0(ctx, instance).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FIEA extends CallableResultNative.CRNEAFIEA {

		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNE0(ctx, instance).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FIEX extends CallableResultNative.CRNEXFIEX {

		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNE0(ctx, instance).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FIJ0 extends CallableResultNative.CRNJ0FIJ0 {

		@Override
		@ReflectionHidden
		default int callIJ0(final BaseObject instance) {

			return this.callNE0(Exec.currentProcess(), instance).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FIJ1 extends CallableResultNative.CRNE1FIJ1, CallableResultNative.CRNJ0FIJ1 {

		@Override
		@ReflectionHidden
		default int callIJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNE0(Exec.currentProcess(), instance).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FIJ2 extends CallableResultNative.CRNE2FIJ2, CallableResultNative.CRNJ0FIJ2 {

		@Override
		@ReflectionHidden
		default int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNE0(Exec.currentProcess(), instance).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FIJA extends CallableResultNative.CRNEAFIJA, CallableResultNative.CRNJ0FIJA {

		@Override
		@ReflectionHidden
		default int callIJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callNE0(Exec.currentProcess(), instance).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FLA0
			extends //
				CallableResultNative.CRNE0FLE0,
				CallableResultNative.CRNE0FLJ0 {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FLA1
			extends //
				CallableResultNative.CRNE0FLE1,
				CallableResultNative.CRNE0FLJ1 {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FLA2
			extends //
				CallableResultNative.CRNE0FLE2,
				CallableResultNative.CRNE0FLJ2 {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FLAA
			extends //
				CallableResultNative.CRNE0FLEA,
				CallableResultNative.CRNE0FLJA {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FLE0 extends CallableResultNative.CRNAAFAAA {

		@Override
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNE0(ctx, instance).baseToJavaLong();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FLE1 extends CallableResultNative.CRNE1FLE1 {

		@Override
		@ReflectionHidden
		default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNE0(ctx, instance).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FLE2 extends CallableResultNative.CRNE2FLE2 {

		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNE0(ctx, instance).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FLEA extends CallableResultNative.CRNEAFLEA {

		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNE0(ctx, instance).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FLEX extends CallableResultNative.CRNEXFLEX {

		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNE0(ctx, instance).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FLJ0 extends CallableResultNative.CRNJ0FLJ0 {

		@Override
		@ReflectionHidden
		default long callLJ0(final BaseObject instance) {

			return this.callNE0(Exec.currentProcess(), instance).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FLJ1 extends CallableResultNative.CRNJ0FLJ1, CallableResultNative.CRNE1FLJ1 {

		@Override
		@ReflectionHidden
		default long callLJ1(@NotNull final BaseObject instance, @NotNull final BaseObject argument) {

			return this.callNE0(Exec.currentProcess(), instance).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FLJ2 extends CallableResultNative.CRNE2FLJ2 {

		@Override
		@ReflectionHidden
		default long callLJ2(@NotNull final BaseObject instance, @NotNull final BaseObject argument1, @NotNull final BaseObject argument2) {

			return this.callNE0(Exec.currentProcess(), instance).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FLJA extends CallableResultNative.CRNEAFLJA {

		@Override
		@ReflectionHidden
		default long callLJA(@NotNull final BaseObject instance, @NotNull final BaseObject... arguments) {

			return this.callNE0(Exec.currentProcess(), instance).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FNE1 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FNE2 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FNEA extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FNEX extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FNJ0 extends CallableResultNative.CRNAAFAAA {

		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNJ0(@NotNull final BaseObject instance) {

			return this.callNE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FNJ1 extends CallableResultNative.CRNE1FNJ1 {

		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNJ1(@NotNull final BaseObject instance, @NotNull final BaseObject argument) {

			return this.callNE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FNJ2 extends CallableResultNative.CRNE2FNJ2 {

		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNJ2(@NotNull final BaseObject instance, @NotNull final BaseObject argument1, @NotNull final BaseObject argument2) {

			return this.callNE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FNJA extends CallableResultNative.CRNEAFNJA {

		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNJA(@NotNull final BaseObject instance, @NotNull final BaseObject... arguments) {

			return this.callNE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FSE0 extends CallableResultNative.CRNAAFAAA {

		@Override
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNE0(ctx, instance).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FSE1 extends CallableResultNative.CRNE1FSE1 {

		@Override
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNE0(ctx, instance).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FSE2 extends CallableResultNative.CRNE2FSE2 {

		@Override
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNE0(ctx, instance).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FSEA extends CallableResultNative.CRNEAFSEA {

		@Override
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNE0(ctx, instance).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FSEX extends CallableResultNative.CRNEXFSEX {

		@Override
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNE0(ctx, instance).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FSJ0 extends CallableResultNative.CRNJ0FSJ0 {

		@Override
		default String callSJ0(final BaseObject instance) {

			return this.callNE0(Exec.currentProcess(), instance).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FSJ1 extends CallableResultNative.CRNE1FSJ1 {

		@Override
		default String callSJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNE0(Exec.currentProcess(), instance).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FSJ2 extends CallableResultNative.CRNE2FSJ2 {

		@Override
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNE0(Exec.currentProcess(), instance).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FSJA extends CallableResultNative.CRNEAFSJA {

		@Override
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callNE0(Exec.currentProcess(), instance).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FVE0 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {

			this.callNE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FVE1 extends CallableResultNative.CRNE1FVE1 {

		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			this.callNE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FVE2 extends CallableResultNative.CRNE2FVE2 {

		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callNE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FVEA extends CallableResultNative.CRNEAFVEA {

		@Override
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			this.callNE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FVEX extends CallableResultNative.CRNEXFVEX {

		@Override
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			this.callNE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FVJ0 extends CallableResultNative.CRNJ0FVJ0 {

		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {

			this.callNE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FVJ1 extends CallableResultNative.CRNE1FVJ1 {

		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {

			this.callNE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FVJ2 extends CallableResultNative.CRNE2FVJ2 {

		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callNE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE0FVJA extends CallableResultNative.CRNEAFVJA {

		@Override
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {

			this.callNE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FDE0 extends CallableResultNative.CRNE0FDE0 {

		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNE1(ctx, instance, BaseObject.UNDEFINED).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FDE1 extends CallableResultNative.CRNAAFAAA {

		@Override
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNE1(ctx, instance, argument)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FDE2 extends CallableResultNative.CRNE2FDE2 {

		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNE1(ctx, instance, argument1).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FDEA extends CallableResultNative.CRNEAFDEA {

		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNE1(//
					ctx,
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0])
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FDEX extends CallableResultNative.CRNEXFDEX {

		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED)).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FDJ0 extends CallableResultNative.CRNE0FDJ0 {

		@Override
		@ReflectionHidden
		default double callDJ0(final BaseObject instance) {

			return this.callNE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FDJ1 extends CallableResultNative.CRNJ1FDJ1 {

		@Override
		default double callDJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNE1(Exec.currentProcess(), instance, argument)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FDJ2 extends CallableResultNative.CRNE2FDJ2 {

		@Override
		@ReflectionHidden
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNE1(Exec.currentProcess(), instance, argument1).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FDJA extends CallableResultNative.CRNEAFDJA {

		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callNE1(//
					Exec.currentProcess(),
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0])
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FEE0 extends CallableResultNative.CRNE0FEE0 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {

			return store.execReturn(ctx, this.callNE1(ctx, instance, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FEE1 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {

			return store.execReturn(ctx, this.callNE1(ctx, instance, argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FEE2 extends CallableResultNative.CRNE2FEE2 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {

			return store.execReturn(ctx, this.callNE1(ctx, instance, argument1));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FEEX extends CallableResultNative.CRNEXFEEX {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {

			return store.execReturn(ctx, this.callNE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED)));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FIE0 extends CallableResultNative.CRNE0FIE0 {

		@Override
		@ReflectionHidden
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNE1(ctx, instance, BaseObject.UNDEFINED).baseToJavaInteger();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FIE1 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNE1(ctx, instance, argument).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FIE2 extends CallableResultNative.CRNE2FIE2 {

		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNE1(ctx, instance, argument1).baseToJavaInteger();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FIEA extends CallableResultNative.CRNEAFIEA {

		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNE1(//
					ctx,
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0])
					.baseToJavaInteger();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FIEX extends CallableResultNative.CRNEXFIEX {

		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED)).baseToJavaInteger();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FIJ0 extends CallableResultNative.CRNE0FIJ0 {

		@Override
		@ReflectionHidden
		default int callIJ0(final BaseObject instance) {

			return this.callNE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED).baseToJavaInteger();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FIJ1 extends CallableResultNative.CRNJ1FIJ1 {

		@Override
		@ReflectionHidden
		default int callIJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNE1(Exec.currentProcess(), instance, argument).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FIJ2 extends CallableResultNative.CRNE2FIJ2 {

		@Override
		@ReflectionHidden
		default int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNE1(Exec.currentProcess(), instance, argument1).baseToJavaInteger();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FIJA extends CallableResultNative.CRNEAFIJA {

		@Override
		@ReflectionHidden
		default int callIJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callNE1(//
					Exec.currentProcess(),
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0])
					.baseToJavaInteger();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FLA1
			extends //
				CallableResultNative.CRNE1FLE1,
				CallableResultNative.CRNE1FLJ1 {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FLE0 extends CallableResultNative.CRNE0FLE0 {

		@Override
		@ReflectionHidden
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNE1(ctx, instance, BaseObject.UNDEFINED).baseToJavaLong();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FLE1 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNE1(ctx, instance, argument).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FLE2 extends CallableResultNative.CRNE2FLE2 {

		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNE1(ctx, instance, argument1).baseToJavaLong();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FLEA extends CallableResultNative.CRNEAFLEA {

		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNE1(//
					ctx,
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0])
					.baseToJavaLong();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FLEX extends CallableResultNative.CRNEXFLEX {

		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED)).baseToJavaLong();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FLJ0 extends CallableResultNative.CRNE0FLJ0 {

		@Override
		@ReflectionHidden
		default long callLJ0(@NotNull final BaseObject instance) {

			return this.callNE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED).baseToJavaLong();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FLJ1 extends CallableResultNative.CRNJ1FLJ1 {

		@Override
		@ReflectionHidden
		default long callLJ1(@NotNull final BaseObject instance, @NotNull final BaseObject argument) {

			return this.callNE1(Exec.currentProcess(), instance, argument).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FLJ2 extends CallableResultNative.CRNE2FLJ2 {

		@Override
		@ReflectionHidden
		default long callLJ2(@NotNull final BaseObject instance, @NotNull final BaseObject argument1, @NotNull final BaseObject argument2) {

			return this.callNE1(Exec.currentProcess(), instance, argument1).baseToJavaLong();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FLJA extends CallableResultNative.CRNEAFLJA {

		@Override
		@ReflectionHidden
		default long callLJA(@NotNull final BaseObject instance, @NotNull final BaseObject... arguments) {

			return this.callNE1(//
					Exec.currentProcess(),
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0])
					.baseToJavaLong();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FNE0 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNE1(ctx, instance, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FNE2 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNE1(ctx, instance, argument1);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FNEA extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			switch (arguments.length) {
				case 0 :
					return this.callNE1(ctx, instance, BaseObject.UNDEFINED);
				default :
					return this.callNE1(ctx, instance, arguments[0]);
			}
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FNEX extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNEX(@NotNull final ExecProcess ctx, @Nullable final BaseObject instance, @NotNull final BaseArray arguments) {

			return this.callNE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FNJ0 extends CallableResultNative.CRNE0FNJ0 {

		@Override
		@ReflectionHidden
		default BaseObject callNJ0(final BaseObject instance) {

			return this.callNE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FNJ1 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNE1(Exec.currentProcess(), instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FNJ2 extends CallableResultNative.CRNE2FNJ2 {

		@Override
		@ReflectionHidden
		default BaseObject callNJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNE1(Exec.currentProcess(), instance, argument1);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FNJA extends CallableResultNative.CRNEAFNJA {

		@Override
		@ReflectionHidden
		default BaseObject callNJA(final BaseObject instance, final BaseObject... arguments) {

			switch (arguments.length) {
				case 0 :
					return this.callNE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED);
				default :
					return this.callNE1(Exec.currentProcess(), instance, arguments[0]);
			}
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FSE0 extends CallableResultNative.CRNE0FSE0 {

		@Override
		@ReflectionHidden
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNE1(ctx, instance, BaseObject.UNDEFINED).baseToJavaString();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FSE1 extends CallableResultNative.CRNAAFAAA {

		@Override
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNE1(ctx, instance, argument).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FSE2 extends CallableResultNative.CRNE2FSE2 {

		@Override
		@ReflectionHidden
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNE1(ctx, instance, argument1).baseToJavaString();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FSEA extends CallableResultNative.CRNEAFSEA {

		@Override
		@ReflectionHidden
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNE1(
					ctx,
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0])
					.baseToJavaString();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FSEX extends CallableResultNative.CRNEXFSEX {

		@Override
		@ReflectionHidden
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED)).baseToJavaString();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FSJ0 extends CallableResultNative.CRNE0FSJ0 {

		@Override
		@ReflectionHidden
		default String callSJ0(final BaseObject instance) {

			return this.callNE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED).baseToJavaString();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FSJ1 extends CallableResultNative.CRNJ1FSJ1 {

		@Override
		default String callSJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNE1(Exec.currentProcess(), instance, argument).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FSJ2 extends CallableResultNative.CRNE2FSJ2 {

		@Override
		@ReflectionHidden
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNE1(Exec.currentProcess(), instance, argument1).baseToJavaString();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FSJA extends CallableResultNative.CRNEAFSJA {

		@Override
		@ReflectionHidden
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callNE1(//
					Exec.currentProcess(),
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0])
					.baseToJavaString();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FVE0 extends CallableResultNative.CRNE0FVE0 {

		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {

			this.callNE1(ctx, instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FVE1 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			this.callNE1(ctx, instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FVE2 extends CallableResultNative.CRNE2FVE2 {

		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callNE1(ctx, instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FVEA extends CallableResultNative.CRNEAFVEA {

		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			this.callNE1(//
					ctx,
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FVEX extends CallableResultNative.CRNEXFVEX {

		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			this.callNE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FVJ0 extends CallableResultNative.CRNE0FVJ0 {

		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {

			this.callNE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FVJ1 extends CallableResultNative.CRNJ1FVJ1 {

		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {

			this.callNE1(Exec.currentProcess(), instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FVJ2 extends CallableResultNative.CRNE2FVJ2 {

		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callNE1(Exec.currentProcess(), instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE1FVJA extends CallableResultNative.CRNEAFVJA {

		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {

			this.callNE1(//
					Exec.currentProcess(),
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FDE0 extends CallableResultNative.CRNE0FDE0 {

		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNE2(ctx, instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FDE1 extends CallableResultNative.CRNE1FDE1 {

		@Override
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNE2(ctx, instance, argument, BaseObject.UNDEFINED)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FDE2 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNE2(ctx, instance, argument1, argument2)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FDEA extends CallableResultNative.CRNJAFDEA {

		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			switch (arguments.length) {
				case 0 :
					return this.callNE2(ctx, instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
				case 1 :
					return this.callNE2(ctx, instance, arguments[0], BaseObject.UNDEFINED).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
				default :
					return this.callNE2(ctx, instance, arguments[0], arguments[1]).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
			}
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FDEX extends CallableResultNative.CRNEXFDEX {

		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNE2(//
					ctx,
					instance,
					arguments.baseGetFirst(BaseObject.UNDEFINED),
					arguments.baseGet(1, BaseObject.UNDEFINED)).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FDJ0 extends CallableResultNative.CRNE0FDJ0 {

		@Override
		@ReflectionHidden
		default double callDJ0(final BaseObject instance) {

			return this.callNE2(Exec.currentProcess(), instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FDJ1 extends CallableResultNative.CRNE1FDJ1 {

		@Override
		default double callDJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNE2(Exec.currentProcess(), instance, argument, BaseObject.UNDEFINED)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FDJ2 extends CallableResultNative.CRNJ2FDJ2 {

		@Override
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNE2(Exec.currentProcess(), instance, argument1, argument2)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FDJA extends CallableResultNative.CRNEAFDJA {

		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {

			switch (arguments.length) {
				case 0 :
					return this.callNE2(//
							Exec.currentProcess(),
							instance,
							BaseObject.UNDEFINED,
							BaseObject.UNDEFINED).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
				case 1 :
					return this.callNE2(//
							Exec.currentProcess(),
							instance,
							arguments[0],
							BaseObject.UNDEFINED).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
				default :
					return this.callNE2(//
							Exec.currentProcess(),
							instance,
							arguments[0],
							arguments[1]).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
			}
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FEE0 extends CallableResultNative.CRNE0FIE0 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {

			return store.execReturn(ctx, this.callNE2(ctx, instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FEE1 extends CallableResultNative.CRNE1FIE1 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {

			return store.execReturn(ctx, this.callNE2(ctx, instance, argument, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FEE2 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {

			return store.execReturn(ctx, this.callNE2(ctx, instance, argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FEEX extends CallableResultNative.CRNEXFIEX {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {

			return store.execReturn(ctx, this.callNE2(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED), arguments.baseGet(1, BaseObject.UNDEFINED)));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FIE0 extends CallableResultNative.CRNE0FIE0 {

		@Override
		@ReflectionHidden
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNE2(ctx, instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FIE1 extends CallableResultNative.CRNE1FIE1 {

		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNE2(ctx, instance, argument, BaseObject.UNDEFINED).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FIE2 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNE2(ctx, instance, argument1, argument2).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FIEA extends CallableResultNative.CRNEAFIEA {

		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNE2(//
					ctx,
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED,
					arguments.length > 1
						? arguments[1]
						: BaseObject.UNDEFINED)
					.baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FIEX extends CallableResultNative.CRNEXFIEX {

		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNE2(//
					ctx,
					instance,
					arguments.baseGetFirst(BaseObject.UNDEFINED),
					arguments.baseGet(1, BaseObject.UNDEFINED)).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FIJ0 extends CallableResultNative.CRNE0FIJ0 {

		@Override
		@ReflectionHidden
		default int callIJ0(final BaseObject instance) {

			return this.callNE2(Exec.currentProcess(), instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FIJ1 extends CallableResultNative.CRNE1FIJ1 {

		@Override
		@ReflectionHidden
		default int callIJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNE2(Exec.currentProcess(), instance, argument, BaseObject.UNDEFINED).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FIJ2 extends CallableResultNative.CRNJ2FIJ2 {

		@Override
		@ReflectionHidden
		default int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNE2(Exec.currentProcess(), instance, argument1, argument2).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FIJA extends CallableResultNative.CRNEAFIJA {

		@Override
		@ReflectionHidden
		default int callIJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callNE2(//
					Exec.currentProcess(),
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED,
					arguments.length > 1
						? arguments[1]
						: BaseObject.UNDEFINED)
					.baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FLA2
			extends //
				CallableResultNative.CRNE2FLE2,
				CallableResultNative.CRNE2FLJ2 {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FLE0 extends CallableResultNative.CRNE0FLE0 {

		@Override
		@ReflectionHidden
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNE2(ctx, instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FLE1 extends CallableResultNative.CRNE1FLE1 {

		@Override
		@ReflectionHidden
		default long callLE1(@NotNull final ExecProcess ctx, @NotNull final BaseObject instance, @NotNull final BaseObject argument) {

			return this.callNE2(ctx, instance, argument, BaseObject.UNDEFINED).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FLE2 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNE2(ctx, instance, argument1, argument2).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FLEA extends CallableResultNative.CRNEAFLEA {

		@Override
		@ReflectionHidden
		default long callLEA(@NotNull final ExecProcess ctx, @NotNull final BaseObject instance, @NotNull final BaseObject... arguments) {

			return this.callNE2(//
					ctx,
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED,
					arguments.length > 1
						? arguments[1]
						: BaseObject.UNDEFINED)
					.baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FLEX extends CallableResultNative.CRNEXFLEX {

		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNE2(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED), arguments.baseGetFirst(BaseObject.UNDEFINED)).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FLJ0 extends CallableResultNative.CRNE0FLJ0 {

		@Override
		@ReflectionHidden
		default long callLJ0(@NotNull final BaseObject instance) {

			return this.callNE2(Exec.currentProcess(), instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FLJ1 extends CallableResultNative.CRNE1FLJ1 {

		@Override
		@ReflectionHidden
		default long callLJ1(@NotNull final BaseObject instance, @NotNull final BaseObject argument) {

			return this.callNE2(Exec.currentProcess(), instance, argument, BaseObject.UNDEFINED).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FLJ2 extends CallableResultNative.CRNJ2FLJ2 {

		@Override
		@ReflectionHidden
		default long callLJ2(@NotNull final BaseObject instance, @NotNull final BaseObject argument1, @NotNull final BaseObject argument2) {

			return this.callNE2(Exec.currentProcess(), instance, argument1, argument2).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FLJA extends CallableResultNative.CRNEAFLJA {

		@Override
		@ReflectionHidden
		default long callLJA(@NotNull final BaseObject instance, @NotNull final BaseObject... arguments) {

			return this.callNE2(//
					Exec.currentProcess(),
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED,
					arguments.length > 1
						? arguments[1]
						: BaseObject.UNDEFINED)
					.baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FNE0 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNE2(ctx, instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FNE1 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNE2(ctx, instance, argument, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FNEA extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNE2(
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
	interface CRNE2FNEX extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNE2(//
					ctx,
					instance,
					arguments.baseGetFirst(BaseObject.UNDEFINED),
					arguments.baseGet(1, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FNJ0 extends CallableResultNative.CRNE0FNJ0 {

		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNJ0(@NotNull final BaseObject instance) {

			return this.callNE2(Exec.currentProcess(), instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FNJ1 extends CallableResultNative.CRNE1FNJ1 {

		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNJ1(@NotNull final BaseObject instance, @NotNull final BaseObject argument) {

			return this.callNE2(Exec.currentProcess(), instance, argument, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FNJ2 extends CallableResultNative.CRNAAFAAA {

		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNJ2(@NotNull final BaseObject instance, @NotNull final BaseObject argument1, final BaseObject argument2) {

			return this.callNE2(Exec.currentProcess(), instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FNJA extends CallableResultNative.CRNEAFNJA {

		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNJA(@NotNull final BaseObject instance, @NotNull final BaseObject... arguments) {

			return this.callNE2(
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
	interface CRNE2FSE0 extends CallableResultNative.CRNE0FSE0 {

		@Override
		@ReflectionHidden
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNE2(ctx, instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FSE1 extends CallableResultNative.CRNE1FSE1 {

		@Override
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNE2(ctx, instance, argument, BaseObject.UNDEFINED).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FSE2 extends CallableResultNative.CRNAAFAAA {

		@Override
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNE2(ctx, instance, argument1, argument2).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FSEA extends CallableResultNative.CRNEAFSEA {

		@Override
		@ReflectionHidden
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNE2(//
					ctx,
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED,
					arguments.length > 1
						? arguments[1]
						: BaseObject.UNDEFINED)
					.baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FSEX extends CallableResultNative.CRNEXFSEX {

		@Override
		@ReflectionHidden
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNE2(//
					ctx,
					instance,
					arguments.baseGetFirst(BaseObject.UNDEFINED),
					arguments.baseGet(1, BaseObject.UNDEFINED)).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FSJ0 extends CallableResultNative.CRNE0FSJ0 {

		@Override
		@ReflectionHidden
		default String callSJ0(final BaseObject instance) {

			return this.callNE2(Exec.currentProcess(), instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FSJ1 extends CallableResultNative.CRNE1FSJ1 {

		@Override
		default String callSJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNE2(Exec.currentProcess(), instance, argument, BaseObject.UNDEFINED).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FSJ2 extends CallableResultNative.CRNJ2FSJ2 {

		@Override
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNE2(Exec.currentProcess(), instance, argument1, argument2).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FSJA extends CallableResultNative.CRNEAFSJA {

		@Override
		@ReflectionHidden
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callNE2(//
					Exec.currentProcess(),
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED,
					arguments.length > 1
						? arguments[1]
						: BaseObject.UNDEFINED)
					.baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FVE0 extends CallableResultNative.CRNE0FVE0 {

		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {

			this.callNE2(ctx, instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FVE1 extends CallableResultNative.CRNE1FVE1 {

		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			this.callNE2(ctx, instance, argument, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FVE2 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callNE2(ctx, instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FVEA extends CallableResultNative.CRNEAFVEA {

		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			this.callNE2(//
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
	interface CRNE2FVEX extends CallableResultNative.CRNEXFVEX {

		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			this.callNE2(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED), arguments.baseGet(1, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FVJ0 extends CallableResultNative.CRNE0FVJ0 {

		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {

			this.callNE2(Exec.currentProcess(), instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FVJ1 extends CallableResultNative.CRNE1FVJ1 {

		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {

			this.callNE2(Exec.currentProcess(), instance, argument, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FVJ2 extends CallableResultNative.CRNJ2FVJ2 {

		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callNE2(Exec.currentProcess(), instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNE2FVJA extends CallableResultNative.CRNEAFVJA {

		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {

			this.callNE2(//
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
	interface CRNEAFDE0 extends CallableResultNative.CRNE0FDE0 {

		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNEA(ctx, instance, Base.ZERO_BASE_OBJECT_ARRAY)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFDE1 extends CallableResultNative.CRNE1FDE1 {

		@Override
		@ReflectionHidden
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNEA(ctx, instance, new BaseObject[]{
					argument
			})//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFDE2 extends CallableResultNative.CRNE2FDE2 {

		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNEA(ctx, instance, new BaseObject[]{
					argument1, argument2
			})//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFDEA extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNEA(ctx, instance, arguments)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFDEX extends CallableResultNative.CRNEXFDEX {

		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNEA(ctx, instance, arguments.toArrayBase())//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFDJ0 extends CallableResultNative.CRNE0FDJ0 {

		@Override
		@ReflectionHidden
		default double callDJ0(final BaseObject instance) {

			return this.callNEA(Exec.currentProcess(), instance, Base.ZERO_BASE_OBJECT_ARRAY).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFDJ1 extends CallableResultNative.CRNE1FDJ1 {

		@Override
		@ReflectionHidden
		default double callDJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNEA(Exec.currentProcess(), instance, new BaseObject[]{
					argument
			}).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFDJ2 extends CallableResultNative.CRNE2FDJ2 {

		@Override
		@ReflectionHidden
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNEA(Exec.currentProcess(), instance, new BaseObject[]{
					argument1, argument2
			}).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFDJA extends CallableResultNative.CRNJAFDJA {

		@Override
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callNEA(Exec.currentProcess(), instance, arguments)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFEE0 extends CallableResultNative.CRNE0FEE0 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {

			return store.execReturn(ctx, this.callNEA(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFEE1 extends CallableResultNative.CRNE1FEE1 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {

			return store.execReturn(ctx, this.callNEA(ctx, instance, argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFEE2 extends CallableResultNative.CRNE2FEE2 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {

			return store.execReturn(ctx, this.callNEA(ctx, instance, argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFEEX extends CallableResultNative.CRNEXFEEX {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {

			return store.execReturn(ctx, this.callNEA(ctx, instance, arguments.toArrayBase()));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFIE0 extends CallableResultNative.CRNE0FIE0 {

		@Override
		@ReflectionHidden
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNEA(ctx, instance, Base.ZERO_BASE_OBJECT_ARRAY).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFIE1 extends CallableResultNative.CRNE1FIE1 {

		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNEA(ctx, instance, new BaseObject[]{
					argument
			}).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFIE2 extends CallableResultNative.CRNE2FIE2 {

		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNEA(ctx, instance, new BaseObject[]{
					argument1, argument2
			}).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFIEA extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNEA(ctx, instance, arguments).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFIEX extends CallableResultNative.CRNEXFIEX {

		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNEA(ctx, instance, arguments.toArrayBase()).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFIJ0 extends CallableResultNative.CRNE0FIJ0 {

		@Override
		@ReflectionHidden
		default int callIJ0(final BaseObject instance) {

			return this.callNEA(Exec.currentProcess(), instance, Base.ZERO_BASE_OBJECT_ARRAY).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFIJ1 extends CallableResultNative.CRNE1FIJ1 {

		@Override
		@ReflectionHidden
		default int callIJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNEA(Exec.currentProcess(), instance, new BaseObject[]{
					argument
			}).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFIJ2 extends CallableResultNative.CRNE2FIJ2 {

		@Override
		@ReflectionHidden
		default int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNEA(Exec.currentProcess(), instance, new BaseObject[]{
					argument1, argument2
			}).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFIJA extends CallableResultNative.CRNJAFIJA {

		@Override
		@ReflectionHidden
		default int callIJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callNEA(Exec.currentProcess(), instance, arguments).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFLE0 extends CallableResultNative.CRNE0FLE0 {

		@Override
		@ReflectionHidden
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNEA(ctx, instance, Base.ZERO_BASE_OBJECT_ARRAY).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFLE1 extends CallableResultNative.CRNE1FLE1 {

		@Override
		@ReflectionHidden
		default long callLE1(@NotNull final ExecProcess ctx, @NotNull final BaseObject instance, @NotNull final BaseObject argument) {

			return this.callNEA(ctx, instance, new BaseObject[]{
					argument
			}).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFLE2 extends CallableResultNative.CRNE2FLE2 {

		@Override
		@ReflectionHidden
		default long callLE2(@NotNull final ExecProcess ctx, @NotNull final BaseObject instance, @NotNull final BaseObject argument1, @NotNull final BaseObject argument2) {

			return this.callNEA(ctx, instance, new BaseObject[]{
					argument1, argument2
			}).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFLEA extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNEA(ctx, instance, arguments).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFLEX extends CallableResultNative.CRNEXFLEX {

		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNEA(ctx, instance, arguments.toArrayBase()).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFLJ0 extends CallableResultNative.CRNE0FLJ0 {

		@Override
		@ReflectionHidden
		default long callLJ0(@NotNull final BaseObject instance) {

			return this.callNEA(Exec.currentProcess(), instance, Base.ZERO_BASE_OBJECT_ARRAY).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFLJ1 extends CallableResultNative.CRNE1FLJ1 {

		@Override
		@ReflectionHidden
		default long callLJ1(@NotNull final BaseObject instance, @NotNull final BaseObject argument) {

			return this.callNEA(Exec.currentProcess(), instance, new BaseObject[]{
					argument
			}).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFLJ2 extends CallableResultNative.CRNE2FLJ2 {

		@Override
		@ReflectionHidden
		default long callLJ2(@NotNull final BaseObject instance, @NotNull final BaseObject argument1, @NotNull final BaseObject argument2) {

			return this.callNEA(Exec.currentProcess(), instance, new BaseObject[]{
					argument1, argument2
			}).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFLJA extends CallableResultNative.CRNJAFLJA {

		@Override
		@ReflectionHidden
		default long callLJA(@NotNull final BaseObject instance, @NotNull final BaseObject... arguments) {

			return this.callNEA(Exec.currentProcess(), instance, arguments).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFNE0 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNEA(ctx, instance, Base.ZERO_BASE_OBJECT_ARRAY);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFNE1 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNEA(ctx, instance, new BaseObject[]{
					argument
			});
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFNE2 extends CallableResultNative.CRNAAFAAA {

		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNE2(@NotNull final ExecProcess ctx, @NotNull final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNEA(ctx, instance, new BaseObject[]{
					argument1, argument2,
			});
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFNEX extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNEA(//
					ctx,
					instance,
					arguments.toArrayBase());
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFNJ0 extends CallableResultNative.CRNE0FNJ0 {

		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNJ0(@NotNull final BaseObject instance) {

			return this.callNEA(Exec.currentProcess(), instance, Base.ZERO_BASE_OBJECT_ARRAY);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFNJ1 extends CallableResultNative.CRNE1FNJ1 {

		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNJ1(@NotNull final BaseObject instance, final BaseObject argument) {

			return this.callNEA(Exec.currentProcess(), instance, new BaseObject[]{
					argument
			});
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFNJ2 extends CallableResultNative.CRNE2FNJ2 {

		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNJ2(@NotNull final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNEA(Exec.currentProcess(), instance, new BaseObject[]{
					argument1, argument2,
			});
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFNJA extends CallableResultNative.CRNAAFAAA {

		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNJA(@NotNull final BaseObject instance, @NotNull final BaseObject... arguments) {

			return this.callNEA(Exec.currentProcess(), instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFSE0 extends CallableResultNative.CRNE0FSE0 {

		@Override
		@ReflectionHidden
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNEA(ctx, instance, Base.ZERO_BASE_OBJECT_ARRAY).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFSE1 extends CallableResultNative.CRNE1FSE1 {

		@Override
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNEA(ctx, instance, new BaseObject[]{
					argument
			}).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFSE2 extends CallableResultNative.CRNE2FSE2 {

		@Override
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNEA(ctx, instance, new BaseObject[]{
					argument1, argument2
			}).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFSEA extends CallableResultNative.CRNAAFAAA {

		@Override
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNEA(ctx, instance, arguments).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFSEX extends CallableResultNative.CRNEXFSEX {

		@Override
		@ReflectionHidden
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNEA(//
					ctx,
					instance,
					arguments.toArrayBase()).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFSJ0 extends CallableResultNative.CRNE0FSJ0 {

		@Override
		@ReflectionHidden
		default String callSJ0(final BaseObject instance) {

			return this.callNEA(Exec.currentProcess(), instance, Base.ZERO_BASE_OBJECT_ARRAY).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFSJ1 extends CallableResultNative.CRNE1FSJ1 {

		@Override
		default String callSJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNEA(Exec.currentProcess(), instance, new BaseObject[]{
					argument
			}).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFSJ2 extends CallableResultNative.CRNE2FSJ2 {

		@Override
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNEA(Exec.currentProcess(), instance, new BaseObject[]{
					argument1, argument2
			}).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFSJA extends CallableResultNative.CRNJAFSJA {

		@Override
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callNEA(Exec.currentProcess(), instance, arguments).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFVE0 extends CallableResultNative.CRNE0FVE0 {

		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {

			this.callNEA(ctx, instance, Base.ZERO_BASE_OBJECT_ARRAY);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFVE1 extends CallableResultNative.CRNE1FVE1 {

		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			this.callNEA(ctx, instance, new BaseObject[]{
					argument
			});
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFVE2 extends CallableResultNative.CRNE2FVE2 {

		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callNEA(ctx, instance, new BaseObject[]{
					argument1, argument2
			});
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFVEA extends CallableResultNative.CRNAAFAAA {

		@Override
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			this.callNEA(ctx, instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFVEX extends CallableResultNative.CRNEXFVEX {

		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			this.callNEA(ctx, instance, arguments.toArrayBase());
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFVJ0 extends CallableResultNative.CRNE0FVJ0 {

		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {

			this.callNEA(Exec.currentProcess(), instance, Base.ZERO_BASE_OBJECT_ARRAY);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFVJ1 extends CallableResultNative.CRNE1FVJ1 {

		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {

			this.callNEA(Exec.currentProcess(), instance, new BaseObject[]{
					argument
			});
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFVJ2 extends CallableResultNative.CRNE2FVJ2 {

		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callNEA(Exec.currentProcess(), instance, new BaseObject[]{
					argument1, argument2
			});
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEAFVJA extends CallableResultNative.CRNJAFVJA {

		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {

			this.callNEA(Exec.currentProcess(), instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFDE0 extends CallableResultNative.CRNE0FDE0 {

		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNEX(ctx, instance, ctx.argumentsEmpty())//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFDE1 extends CallableResultNative.CRNE1FDE1 {

		@Override
		@ReflectionHidden
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNEX(ctx, instance, ctx.argumentsList1(argument))//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFDE2 extends CallableResultNative.CRNE2FDE2 {

		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNEX(ctx, instance, ctx.argumentsList2(argument1, argument2))//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFDEA extends CallableResultNative.CRNEAFDEA {

		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNEX(ctx, instance, ctx.argumentsListA(arguments))//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFDEX extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNEX(ctx, instance, arguments)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFDJ0 extends CallableResultNative.CRNE0FDJ0 {

		@Override
		@ReflectionHidden
		default double callDJ0(final BaseObject instance) {

			final ExecProcess ctx = Exec.currentProcess();
			return this.callNEX(ctx, instance, ctx.argumentsEmpty()).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFDJ1 extends CallableResultNative.CRNE1FDJ1 {

		@Override
		@ReflectionHidden
		default double callDJ1(final BaseObject instance, final BaseObject argument) {

			final ExecProcess ctx = Exec.currentProcess();
			return this.callNEX(ctx, instance, ctx.argumentsList1(argument)).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFDJ2 extends CallableResultNative.CRNE2FDJ2 {

		@Override
		@ReflectionHidden
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			final ExecProcess ctx = Exec.currentProcess();
			return this.callNEX(ctx, instance, ctx.argumentsList2(argument1, argument2)).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFDJA extends CallableResultNative.CRNEAFDJA {

		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {

			final ExecProcess ctx = Exec.currentProcess();
			return this.callNEX(ctx, instance, ctx.argumentsListA(arguments)).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFEE0 extends CallableResultNative.CRNE0FEE0 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {

			return store.execReturn(ctx, this.callNEX(ctx, instance, ctx.argumentsEmpty()));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFEE1 extends CallableResultNative.CRNE1FEE1 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {

			return store.execReturn(ctx, this.callNEX(ctx, instance, ctx.argumentsList1(argument)));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFEE2 extends CallableResultNative.CRNE2FEE2 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {

			return store.execReturn(ctx, this.callNEX(ctx, instance, ctx.argumentsList2(argument1, argument2)));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFEEX extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {

			return store.execReturn(ctx, this.callNEX(ctx, instance, arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFIE0 extends CallableResultNative.CRNE0FIE0 {

		@Override
		@ReflectionHidden
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNEX(ctx, instance, ctx.argumentsEmpty()).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFIE1 extends CallableResultNative.CRNE1FIE1 {

		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNEX(ctx, instance, ctx.argumentsList1(argument)).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFIE2 extends CallableResultNative.CRNE2FIE2 {

		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNEX(ctx, instance, ctx.argumentsList2(argument1, argument2)).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFIEA extends CallableResultNative.CRNEAFIEA {

		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNEX(ctx, instance, ctx.argumentsListA(arguments)).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFIEX extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNEX(ctx, instance, arguments).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFIJ0 extends CallableResultNative.CRNE0FIJ0 {

		@Override
		@ReflectionHidden
		default int callIJ0(final BaseObject instance) {

			final ExecProcess ctx = Exec.currentProcess();
			return this.callNEX(ctx, instance, ctx.argumentsEmpty()).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFIJ1 extends CallableResultNative.CRNE1FIJ1 {

		@Override
		@ReflectionHidden
		default int callIJ1(final BaseObject instance, final BaseObject argument) {

			final ExecProcess ctx = Exec.currentProcess();
			return this.callNEX(ctx, instance, ctx.argumentsList1(argument)).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFIJ2 extends CallableResultNative.CRNE2FIJ2 {

		@Override
		@ReflectionHidden
		default int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			final ExecProcess ctx = Exec.currentProcess();
			return this.callNEX(ctx, instance, ctx.argumentsList2(argument1, argument2)).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFIJA extends CallableResultNative.CRNEAFIJA {

		@Override
		@ReflectionHidden
		default int callIJA(final BaseObject instance, final BaseObject... arguments) {

			final ExecProcess ctx = Exec.currentProcess();
			return this.callNEX(ctx, instance, ctx.argumentsListA(arguments)).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFLE0 extends CallableResultNative.CRNE0FLE0 {

		@Override
		@ReflectionHidden
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNEX(ctx, instance, ctx.argumentsEmpty()).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFLE1 extends CallableResultNative.CRNE1FLE1 {

		@Override
		@ReflectionHidden
		default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNEX(ctx, instance, ctx.argumentsList1(argument)).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFLE2 extends CallableResultNative.CRNE2FLE2 {

		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNEX(ctx, instance, ctx.argumentsList2(argument1, argument2)).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFLEA extends CallableResultNative.CRNEAFLEA {

		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNEX(ctx, instance, ctx.argumentsListA(arguments)).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFLEX extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNEX(ctx, instance, arguments).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFLJ0 extends CallableResultNative.CRNE0FLJ0 {

		@Override
		@ReflectionHidden
		default long callLJ0(@NotNull final BaseObject instance) {

			final ExecProcess ctx = Exec.currentProcess();
			return this.callNEX(ctx, instance, ctx.argumentsEmpty()).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFLJ1 extends CallableResultNative.CRNE1FLJ1 {

		@Override
		@ReflectionHidden
		default long callLJ1(@NotNull final BaseObject instance, @NotNull final BaseObject argument) {

			final ExecProcess ctx = Exec.currentProcess();
			return this.callNEX(ctx, instance, ctx.argumentsList1(argument)).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFLJ2 extends CallableResultNative.CRNE2FLJ2 {

		@Override
		@ReflectionHidden
		default long callLJ2(@NotNull final BaseObject instance, @NotNull final BaseObject argument1, @NotNull final BaseObject argument2) {

			final ExecProcess ctx = Exec.currentProcess();
			return this.callNEX(ctx, instance, ctx.argumentsList2(argument1, argument2)).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFLJA extends CallableResultNative.CRNEAFLJA {

		@Override
		@ReflectionHidden
		default long callLJA(@NotNull final BaseObject instance, @NotNull final BaseObject... arguments) {

			final ExecProcess ctx = Exec.currentProcess();
			return this.callNEX(ctx, instance, ctx.argumentsListA(arguments)).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFNE0 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNEX(ctx, instance, ctx.argumentsEmpty());
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFNE1 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNEX(ctx, instance, ctx.argumentsList1(argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFNE2 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNEX(ctx, instance, ctx.argumentsList2(argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFNEA extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNEX(ctx, instance, ctx.argumentsListA(arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFNJ0 extends CallableResultNative.CRNE0FNJ0 {

		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNJ0(@NotNull final BaseObject instance) {

			return this.callNEX(Exec.currentProcess(), instance, BaseArray.SEALED_EMPTY_ARRAY);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFNJ1 extends CallableResultNative.CRNE1FNJ1 {

		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNJ1(@NotNull final BaseObject instance, final BaseObject argument) {

			final ExecProcess ctx = Exec.currentProcess();
			return this.callNEX(ctx, instance, ctx.argumentsList1(argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFNJ2 extends CallableResultNative.CRNE2FNJ2 {

		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNJ2(@NotNull final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			final ExecProcess ctx = Exec.currentProcess();
			return this.callNEX(ctx, instance, ctx.argumentsList2(argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFNJA extends CallableResultNative.CRNEAFNJA {

		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNJA(@NotNull final BaseObject instance, final BaseObject... arguments) {

			final ExecProcess ctx = Exec.currentProcess();
			return this.callNEX(ctx, instance, ctx.argumentsListA(arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFSE0 extends CallableResultNative.CRNE0FSE0 {

		@Override
		@ReflectionHidden
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNEX(ctx, instance, ctx.argumentsEmpty()).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFSE1 extends CallableResultNative.CRNE1FSE1 {

		@Override
		@ReflectionHidden
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNEX(ctx, instance, ctx.argumentsList1(argument)).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFSE2 extends CallableResultNative.CRNE2FSE2 {

		@Override
		@ReflectionHidden
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNEX(ctx, instance, ctx.argumentsList2(argument1, argument2)).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFSEA extends CallableResultNative.CRNEAFSEA {

		@Override
		@ReflectionHidden
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNEX(ctx, instance, ctx.argumentsListA(arguments)).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFSEX extends CallableResultNative.CRNAAFAAA {

		@Override
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNEX(ctx, instance, arguments).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFSJ0 extends CallableResultNative.CRNE0FSJ0 {

		@Override
		@ReflectionHidden
		default String callSJ0(final BaseObject instance) {

			final ExecProcess ctx = Exec.currentProcess();
			return this.callNEX(ctx, instance, ctx.argumentsEmpty()).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFSJ1 extends CallableResultNative.CRNE1FSJ1 {

		@Override
		@ReflectionHidden
		default String callSJ1(final BaseObject instance, final BaseObject argument) {

			final ExecProcess ctx = Exec.currentProcess();
			return this.callNEX(ctx, instance, ctx.argumentsList1(argument)).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFSJ2 extends CallableResultNative.CRNE2FSJ2 {

		@Override
		@ReflectionHidden
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			final ExecProcess ctx = Exec.currentProcess();
			return this.callNEX(ctx, instance, ctx.argumentsList2(argument1, argument2)).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFSJA extends CallableResultNative.CRNEAFSJA {

		@Override
		@ReflectionHidden
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {

			final ExecProcess ctx = Exec.currentProcess();
			return this.callNEX(ctx, instance, ctx.argumentsListA(arguments)).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFVE0 extends CallableResultNative.CRNE0FVE0 {

		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {

			this.callNEX(ctx, instance, ctx.argumentsEmpty());
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFVE1 extends CallableResultNative.CRNE1FVE1 {

		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			this.callNEX(ctx, instance, ctx.argumentsList1(argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFVE2 extends CallableResultNative.CRNE2FVE2 {

		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callNEX(ctx, instance, ctx.argumentsList2(argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFVEA extends CallableResultNative.CRNEAFVEA {

		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			this.callNEX(ctx, instance, ctx.argumentsListA(arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFVEX extends CallableResultNative.CRNAAFAAA {

		@Override
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			this.callNEX(ctx, instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFVJ0 extends CallableResultNative.CRNE0FVJ0 {

		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {

			final ExecProcess ctx = Exec.currentProcess();
			this.callNEX(ctx, instance, ctx.argumentsEmpty());
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFVJ1 extends CallableResultNative.CRNE1FVJ1 {

		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {

			final ExecProcess ctx = Exec.currentProcess();
			this.callNEX(ctx, instance, ctx.argumentsList1(argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFVJ2 extends CallableResultNative.CRNE2FVJ2 {

		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			final ExecProcess ctx = Exec.currentProcess();
			this.callNEX(ctx, instance, ctx.argumentsList2(argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNEXFVJA extends CallableResultNative.CRNEAFVJA {

		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {

			final ExecProcess ctx = Exec.currentProcess();
			this.callNEX(ctx, instance, ctx.argumentsListA(arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FDA0
			extends //
				CallableResultNative.CRNJ0FDE0,
				CallableResultNative.CRNJ0FDJ0 {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FDA1
			extends //
				CallableResultNative.CRNJ0FDE1,
				CallableResultNative.CRNJ0FDJ1 {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FDA2
			extends //
				CallableResultNative.CRNJ0FDE2,
				CallableResultNative.CRNJ0FDJ2 {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FDAA
			extends //
				CallableResultNative.CRNJ0FDEA,
				CallableResultNative.CRNJ0FDJA {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FDE0 extends CallableResultNative.CRNE0FDE0 {

		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNJ0(instance)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FDE1 extends CallableResultNative.CRNJ1FDE1 {

		@Override
		@ReflectionHidden
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNJ0(instance)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FDE2 extends CallableResultNative.CRNJ2FDE2 {

		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ0(instance)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FDEA extends CallableResultNative.CRNJAFDEA {

		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNJ0(instance)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FDEX extends CallableResultNative.CRNE0FDEX, CallableResultNative.CRNJAFDEX {

		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNJ0(instance).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FDJ0 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default double callDJ0(final BaseObject instance) {

			return this.callNJ0(instance)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FDJ1 extends CallableResultNative.CRNJ1FDJ1 {

		@Override
		@ReflectionHidden
		default double callDJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNJ0(instance)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FDJ2 extends CallableResultNative.CRNJ2FDJ2 {

		@Override
		@ReflectionHidden
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ0(instance)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FDJA extends CallableResultNative.CRNJAFDJA {

		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callNJ0(instance)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FEE0 extends CallableResultNative.CRNE0FEE0 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {

			return store.execReturn(ctx, this.callNJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FEE1 extends CallableResultNative.CRNJ1FEE1 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {

			return store.execReturn(ctx, this.callNJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FEE2 extends CallableResultNative.CRNJ2FEE2 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {

			return store.execReturn(ctx, this.callNJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FEEX extends CallableResultNative.CRNJAFEEX {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {

			return store.execReturn(ctx, this.callNJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FIA0
			extends //
				CallableResultNative.CRNJ0FIE0,
				CallableResultNative.CRNJ0FIJ0 {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FIA1
			extends //
				CallableResultNative.CRNJ0FIE1,
				CallableResultNative.CRNJ0FIJ1 {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FIA2
			extends //
				CallableResultNative.CRNJ0FIE2,
				CallableResultNative.CRNJ0FIJ2 {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FIAA
			extends //
				CallableResultNative.CRNJ0FIEA,
				CallableResultNative.CRNJ0FIJA {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FIE0 extends CallableResultNative.CRNE0FIE0 {

		@Override
		@ReflectionHidden
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNJ0(instance).baseToJavaInteger();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FIE1 extends CallableResultNative.CRNJ1FIE1 {

		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNJ0(instance).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FIE2 extends CallableResultNative.CRNJ2FIE2 {

		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ0(instance).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FIEA extends CallableResultNative.CRNJAFIEA {

		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... argument1s) {

			return this.callNJ0(instance).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FIEX extends CallableResultNative.CRNJAFIEX {

		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNJ0(instance).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FIJ0 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default int callIJ0(final BaseObject instance) {

			return this.callNJ0(instance).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FIJ1 extends CallableResultNative.CRNJ1FIJ1 {

		@Override
		@ReflectionHidden
		default int callIJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNJ0(instance).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FIJ2 extends CallableResultNative.CRNJ2FIJ2 {

		@Override
		@ReflectionHidden
		default int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ0(instance).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FIJA extends CallableResultNative.CRNJAFIJA {

		@Override
		@ReflectionHidden
		default int callIJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callNJ0(instance).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FLA0
			extends //
				CallableResultNative.CRNJ0FLE0,
				CallableResultNative.CRNJ0FLJ0 {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FLA1
			extends //
				CallableResultNative.CRNJ0FLE1,
				CallableResultNative.CRNJ0FLJ1 {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FLA2
			extends //
				CallableResultNative.CRNJ0FLE2,
				CallableResultNative.CRNJ0FLJ2 {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FLAA
			extends //
				CallableResultNative.CRNJ0FLEA,
				CallableResultNative.CRNJ0FLJA {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FLE0 extends CallableResultNative.CRNE0FLE0 {

		@Override
		@ReflectionHidden
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNJ0(instance).baseToJavaLong();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FLE1 extends CallableResultNative.CRNJ1FLE1, CallableResultNative.CRNE0FLE1 {

		@Override
		@ReflectionHidden
		default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNJ0(instance).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FLE2 extends CallableResultNative.CRNJ2FLE2, CallableResultNative.CRNE0FLE2 {

		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ0(instance).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FLEA extends CallableResultNative.CRNJAFLEA {

		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNJ0(instance).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FLEX extends CallableResultNative.CRNJAFLEX {

		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNJ0(instance).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FLJ0 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default long callLJ0(final BaseObject instance) {

			return this.callNJ0(instance).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FLJ1 extends CallableResultNative.CRNJ1FLJ1 {

		@Override
		@ReflectionHidden
		default long callLJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNJ0(instance).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FLJ2 extends CallableResultNative.CRNJ2FLJ2 {

		@Override
		@ReflectionHidden
		default long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ0(instance).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FLJA extends CallableResultNative.CRNJAFLJA {

		@Override
		@ReflectionHidden
		default long callLJA(@NotNull final BaseObject instance, @NotNull final BaseObject... arguments) {

			return this.callNJ0(instance).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FNE0 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FNE1 extends CallableResultNative.CRNJ1FNE1 {

		@Override
		@ReflectionHidden
		default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FNE2 extends CallableResultNative.CRNJ2FNE2 {

		@Override
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FNEA extends CallableResultNative.CRNJAFNEA {

		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FNEX extends CallableResultNative.CRNJAFNEX {

		@Override
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FNJ0 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		BaseObject callNJ0(final BaseObject instance);

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FNJ1 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNJ1(@NotNull final BaseObject instance, @NotNull final BaseObject argument) {

			return this.callNJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FNJ2 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNJ2(@NotNull final BaseObject instance, @NotNull final BaseObject argument1, @NotNull final BaseObject argument2) {

			return this.callNJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FNJA extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNJA(@NotNull final BaseObject instance, @NotNull final BaseObject... arguments) {

			return this.callNJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FSE0 extends CallableResultNative.CRNE0FSE0 {

		@Override
		@ReflectionHidden
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNJ0(instance).baseToJavaString();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FSE1 extends CallableResultNative.CRNJ1FSE1, CallableResultNative.CRNE0FSE1 {

		@Override
		@ReflectionHidden
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNJ0(instance).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FSE2 extends CallableResultNative.CRNJ2FSE2, CallableResultNative.CRNE0FSE2 {

		@Override
		@ReflectionHidden
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ0(instance).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FSEA extends CallableResultNative.CRNJAFSEA, CallableResultNative.CRNE0FSEA {

		@Override
		@ReflectionHidden
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNJ0(instance).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FSEX extends CallableResultNative.CRNJAFSEX, CallableResultNative.CRNE0FSEX {

		@Override
		@ReflectionHidden
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNJ0(instance).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FSJ0 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default String callSJ0(final BaseObject instance) {

			return this.callNJ0(instance).baseToJavaString();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FSJ1 extends CallableResultNative.CRNJ1FSJ1 {

		@Override
		@ReflectionHidden
		default String callSJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNJ0(instance).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FSJ2 extends CallableResultNative.CRNJ2FSJ2 {

		@Override
		@ReflectionHidden
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ0(instance).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FSJA extends CallableResultNative.CRNJAFSJA {

		@Override
		@ReflectionHidden
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callNJ0(instance).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FVE0 extends CallableResultNative.CRNE0FVE0 {

		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {

			this.callNJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FVE1 extends CallableResultNative.CRNJ1FVE1 {

		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			this.callNJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FVE2 extends CallableResultNative.CRNJ2FVE2 {

		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callNJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FVEA extends CallableResultNative.CRNJAFVEA {

		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			this.callNJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FVEX extends CallableResultNative.CRNJAFVEX {

		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			this.callNJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FVJ0 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {

			this.callNJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FVJ1 extends CallableResultNative.CRNJ1FVJ1 {

		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {

			this.callNJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FVJ2 extends CallableResultNative.CRNJ2FVJ2 {

		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callNJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ0FVJA extends CallableResultNative.CRNJAFVJA {

		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {

			this.callNJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FDA1
			extends //
				CallableResultNative.CRNJ1FDE1,
				CallableResultNative.CRNJ1FDJ1 {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FDE0 extends CallableResultNative.CRNJ0FDE0 {

		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNJ1(instance, BaseObject.UNDEFINED).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FDE1 extends CallableResultNative.CRNE1FDE1 {

		@Override
		@ReflectionHidden
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNJ1(instance, argument)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FDE2 extends CallableResultNative.CRNJ2FDE2 {

		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ1(instance, argument1).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FDEA extends CallableResultNative.CRNJAFDEA {

		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			switch (arguments.length) {
				case 0 :
					return this.callNJ1(instance, BaseObject.UNDEFINED).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
				default :
					return this.callNJ1(instance, arguments[0]).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
			}
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FDEX extends CallableResultNative.CRNJAFDEX {

		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED)).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FDJ0 extends CallableResultNative.CRNJ0FDJ0 {

		@Override
		@ReflectionHidden
		default double callDJ0(final BaseObject instance) {

			return this.callNJ1(instance, BaseObject.UNDEFINED).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FDJ1 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default double callDJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNJ1(instance, argument)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FDJ2 extends CallableResultNative.CRNJ2FDJ2 {

		@Override
		@ReflectionHidden
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ1(instance, argument1).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FDJA extends CallableResultNative.CRNJAFDJA {

		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {

			switch (arguments.length) {
				case 0 :
					return this.callNJ1(instance, BaseObject.UNDEFINED).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
				default :
					return this.callNJ1(instance, arguments[0]).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
			}
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FEE0 extends CallableResultNative.CRNJ0FEE0 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {

			return store.execReturn(ctx, this.callNJ1(instance, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FEE1 extends CallableResultNative.CRNE1FEE1 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {

			return store.execReturn(ctx, this.callNJ1(instance, argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FEE2 extends CallableResultNative.CRNJ2FEE2 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {

			return store.execReturn(ctx, this.callNJ1(instance, argument1));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FEEX extends CallableResultNative.CRNJAFEEX {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {

			return store.execReturn(ctx, this.callNJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED)));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FIA1
			extends //
				CallableResultNative.CRNJ1FIE1,
				CallableResultNative.CRNJ1FIJ1 {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FIE0 extends CallableResultNative.CRNJ0FIE0 {

		@Override
		@ReflectionHidden
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNJ1(instance, BaseObject.UNDEFINED).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FIE1 extends CallableResultNative.CRNE1FIE1 {

		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNJ1(instance, argument).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FIE2 extends CallableResultNative.CRNJ2FIE2 {

		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ1(instance, argument1).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FIEA extends CallableResultNative.CRNJAFIEA {

		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNJ1(//
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0])
					.baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FIEX extends CallableResultNative.CRNJAFIEX {

		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED)).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FIJ0 extends CallableResultNative.CRNJ0FIJ0 {

		@Override
		@ReflectionHidden
		default int callIJ0(final BaseObject instance) {

			return this.callNJ1(instance, BaseObject.UNDEFINED).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FIJ1 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default int callIJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNJ1(instance, argument).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FIJ2 extends CallableResultNative.CRNJ2FIJ2 {

		@Override
		@ReflectionHidden
		default int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ1(instance, argument1).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FIJA extends CallableResultNative.CRNJAFIJA {

		@Override
		@ReflectionHidden
		default int callIJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callNJ1(//
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0])
					.baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FLE0 extends CallableResultNative.CRNJ0FLE0 {

		@Override
		@ReflectionHidden
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNJ1(instance, BaseObject.UNDEFINED).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FLE1 extends CallableResultNative.CRNE1FLE1 {

		@Override
		@ReflectionHidden
		default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNJ1(instance, argument).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FLE2 extends CallableResultNative.CRNJ2FLE2 {

		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ1(instance, argument1).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FLEA extends CallableResultNative.CRNJAFLEA {

		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNJ1(//
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0])
					.baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FLEX extends CallableResultNative.CRNJAFLEX {

		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED)).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FLJ0 extends CallableResultNative.CRNJ0FLJ0 {

		@Override
		@ReflectionHidden
		default long callLJ0(@NotNull final BaseObject instance) {

			return this.callNJ1(instance, BaseObject.UNDEFINED).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FLJ1 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default long callLJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNJ1(instance, argument).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FLJ2 extends CallableResultNative.CRNJ2FLJ2 {

		@Override
		@ReflectionHidden
		default long callLJ2(@NotNull final BaseObject instance, @NotNull final BaseObject argument1, @NotNull final BaseObject argument2) {

			return this.callNJ1(instance, argument1).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FLJA extends CallableResultNative.CRNJAFLJA {

		@Override
		@ReflectionHidden
		default long callLJA(@NotNull final BaseObject instance, @NotNull final BaseObject... arguments) {

			return this.callNJ1(//
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0])
					.baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FNE0 extends CallableResultNative.CRNJ0FNE0 {

		@Override
		@ReflectionHidden
		default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNJ1(instance, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FNE1 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNJ1(instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FNE2 extends CallableResultNative.CRNJ2FNE2 {

		@Override
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ1(instance, argument1);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FNEA extends CallableResultNative.CRNJAFNEA {

		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			switch (arguments.length) {
				case 0 :
					return this.callNJ1(instance, BaseObject.UNDEFINED);
				default :
					return this.callNJ1(instance, arguments[0]);
			}
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FNEX extends CallableResultNative.CRNJAFNEX {

		@Override
		@ReflectionHidden
		default BaseObject callNEX(@NotNull final ExecProcess ctx, @Nullable final BaseObject instance, @NotNull final BaseArray arguments) {

			return this.callNJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FNJ0 extends CallableResultNative.CRNJ0FNJ0 {

		@Override
		@ReflectionHidden
		default BaseObject callNJ0(final BaseObject instance) {

			return this.callNJ1(instance, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FNJ2 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ1(instance, argument1);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FNJA extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNJA(final BaseObject instance, final BaseObject... arguments) {

			switch (arguments.length) {
				case 0 :
					return this.callNJ1(instance, BaseObject.UNDEFINED);
				default :
					return this.callNJ1(instance, arguments[0]);
			}
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FSE0 extends CallableResultNative.CRNJ0FSE0 {

		@Override
		@ReflectionHidden
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNJ1(instance, BaseObject.UNDEFINED).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FSE1 extends CallableResultNative.CRNE1FSE1 {

		@Override
		@ReflectionHidden
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNJ1(instance, argument).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FSE2 extends CallableResultNative.CRNJ2FSE2 {

		@Override
		@ReflectionHidden
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ1(instance, argument1).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FSEA extends CallableResultNative.CRNJAFSEA {

		@Override
		@ReflectionHidden
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNJ1(
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0])
					.baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FSEX extends CallableResultNative.CRNJAFSEX {

		@Override
		@ReflectionHidden
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED)).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FSJ0 extends CallableResultNative.CRNJ0FSJ0 {

		@Override
		@ReflectionHidden
		default String callSJ0(final BaseObject instance) {

			return this.callNJ1(instance, BaseObject.UNDEFINED).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FSJ1 extends CallableResultNative.CRNAAFAAA {

		@Override
		default String callSJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNJ1(instance, argument).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FSJ2 extends CallableResultNative.CRNJ2FSJ2 {

		@Override
		@ReflectionHidden
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ1(instance, argument1).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FSJA extends CallableResultNative.CRNJAFSJA {

		@Override
		@ReflectionHidden
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callNJ1(//
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0])
					.baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FVE0 extends CallableResultNative.CRNJ0FVE0 {

		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {

			this.callNJ1(instance, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FVE1 extends CallableResultNative.CRNE1FVE1 {

		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			this.callNJ1(instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FVE2 extends CallableResultNative.CRNJ2FVE2 {

		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callNJ1(instance, argument1);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FVEA extends CallableResultNative.CRNJAFVEA {

		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			this.callNJ1(//
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FVEX extends CallableResultNative.CRNJAFVEX {

		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			this.callNJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FVJ0 extends CallableResultNative.CRNJ0FVJ0 {

		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {

			this.callNJ1(instance, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FVJ1 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {

			this.callNJ1(instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FVJ2 extends CallableResultNative.CRNJ2FVJ2 {

		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callNJ1(instance, argument1);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ1FVJA extends CallableResultNative.CRNJAFVJA {

		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {

			this.callNJ1(//
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FDA2
			extends //
				CallableResultNative.CRNJ2FDE2,
				CallableResultNative.CRNJ2FDJ2 {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FDE0 extends CallableResultNative.CRNJ0FDE0 {

		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FDE1 extends CallableResultNative.CRNJ1FDE1 {

		@Override
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNJ2(instance, argument, BaseObject.UNDEFINED)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FDE2 extends CallableResultNative.CRNE2FDE2 {

		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ2(instance, argument1, argument2)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FDEA extends CallableResultNative.CRNJAFDEA {

		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			switch (arguments.length) {
				case 0 :
					return this.callNJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
				case 1 :
					return this.callNJ2(instance, arguments[0], BaseObject.UNDEFINED).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
				default :
					return this.callNJ2(instance, arguments[0], arguments[1]).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
			}
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FDEX extends CallableResultNative.CRNJAFDEX {

		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNJ2(//
					instance,
					arguments.baseGetFirst(BaseObject.UNDEFINED),
					arguments.baseGet(1, BaseObject.UNDEFINED)).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FDJ0 extends CallableResultNative.CRNJ0FDJ0 {

		@Override
		@ReflectionHidden
		default double callDJ0(final BaseObject instance) {

			return this.callNJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FDJ1 extends CallableResultNative.CRNJ1FDJ1 {

		@Override
		@ReflectionHidden
		default double callDJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNJ2(instance, argument, BaseObject.UNDEFINED).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FDJ2 extends CallableResultNative.CRNAAFAAA {

		@Override
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ2(instance, argument1, argument2)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FDJA extends CallableResultNative.CRNJAFDJA {

		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {

			switch (arguments.length) {
				case 0 :
					return this.callNJ2(//
							instance,
							BaseObject.UNDEFINED,
							BaseObject.UNDEFINED).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
				case 1 :
					return this.callNJ2(//
							instance,
							arguments[0],
							BaseObject.UNDEFINED).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
				default :
					return this.callNJ2(//
							instance,
							arguments[0],
							arguments[1]).baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
			}
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FEE0 extends CallableResultNative.CRNE2FEE0 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {

			return store.execReturn(ctx, this.callNJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FEE1 extends CallableResultNative.CRNE2FEE1 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {

			return store.execReturn(ctx, this.callNJ2(instance, argument, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FEE2 extends CallableResultNative.CRNE2FEE2 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {

			return store.execReturn(ctx, this.callNJ2(instance, argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FEEX extends CallableResultNative.CRNE2FEEX {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {

			return store.execReturn(ctx, this.callNJ2(instance, arguments.baseGetFirst(BaseObject.UNDEFINED), arguments.baseGet(1, BaseObject.UNDEFINED)));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FIA2
			extends //
				CallableResultNative.CRNJ2FIE2,
				CallableResultNative.CRNJ2FIJ2 {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FIE0 extends CallableResultNative.CRNJ0FIE0 {

		@Override
		@ReflectionHidden
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FIE1 extends CallableResultNative.CRNJ1FIE1 {

		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNJ2(instance, argument, BaseObject.UNDEFINED).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FIE2 extends CallableResultNative.CRNE2FIE2 {

		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ2(instance, argument1, argument2).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FIEA extends CallableResultNative.CRNJAFIEA {

		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNJ2(//
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED,
					arguments.length > 1
						? arguments[1]
						: BaseObject.UNDEFINED)
					.baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FIEX extends CallableResultNative.CRNJAFIEX {

		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNJ2(//
					instance,
					arguments.baseGetFirst(BaseObject.UNDEFINED),
					arguments.baseGet(1, BaseObject.UNDEFINED)).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FIJ0 extends CallableResultNative.CRNJ0FIJ0 {

		@Override
		@ReflectionHidden
		default int callIJ0(final BaseObject instance) {

			return this.callNJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FIJ1 extends CallableResultNative.CRNJ1FIJ1 {

		@Override
		@ReflectionHidden
		default int callIJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNJ2(instance, argument, BaseObject.UNDEFINED).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FIJ2 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ2(instance, argument1, argument2).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FIJA extends CallableResultNative.CRNJAFIJA {

		@Override
		@ReflectionHidden
		default int callIJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callNJ2(//
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED,
					arguments.length > 1
						? arguments[1]
						: BaseObject.UNDEFINED)
					.baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FLE0 extends CallableResultNative.CRNJ0FLE0 {

		@Override
		@ReflectionHidden
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FLE1 extends CallableResultNative.CRNJ1FLE1 {

		@Override
		@ReflectionHidden
		default long callLE1(@NotNull final ExecProcess ctx, @NotNull final BaseObject instance, @NotNull final BaseObject argument) {

			return this.callNJ2(instance, argument, BaseObject.UNDEFINED).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FLE2 extends CallableResultNative.CRNE2FLE2 {

		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ2(instance, argument1, argument2).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FLEA extends CallableResultNative.CRNJAFLEA {

		@Override
		@ReflectionHidden
		default long callLEA(@NotNull final ExecProcess ctx, @NotNull final BaseObject instance, @NotNull final BaseObject... arguments) {

			return this.callNJ2(//
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED,
					arguments.length > 1
						? arguments[1]
						: BaseObject.UNDEFINED)
					.baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FLEX extends CallableResultNative.CRNJAFLEX {

		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNJ2(instance, arguments.baseGetFirst(BaseObject.UNDEFINED), arguments.baseGetFirst(BaseObject.UNDEFINED)).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FLJ0 extends CallableResultNative.CRNJ0FLJ0 {

		@Override
		@ReflectionHidden
		default long callLJ0(@NotNull final BaseObject instance) {

			return this.callNJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FLJ1 extends CallableResultNative.CRNJ1FLJ1 {

		@Override
		@ReflectionHidden
		default long callLJ1(@NotNull final BaseObject instance, @NotNull final BaseObject argument) {

			return this.callNJ2(instance, argument, BaseObject.UNDEFINED).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FLJ2 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ2(instance, argument1, argument2).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FLJA extends CallableResultNative.CRNJAFLJA {

		@Override
		@ReflectionHidden
		default long callLJA(@NotNull final BaseObject instance, @NotNull final BaseObject... arguments) {

			return this.callNJ2(//
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED,
					arguments.length > 1
						? arguments[1]
						: BaseObject.UNDEFINED)
					.baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FNE0 extends CallableResultNative.CRNJ0FNE0 {

		@Override
		@ReflectionHidden
		default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FNE1 extends CallableResultNative.CRNJ1FNE1 {

		@Override
		@ReflectionHidden
		default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNJ2(instance, argument, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FNE2 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ2(instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FNEA extends CallableResultNative.CRNJAFNEA {

		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNJ2(
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
	interface CRNJ2FNEX extends CallableResultNative.CRNJAFNEX {

		@Override
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNJ2(//
					instance,
					arguments.baseGetFirst(BaseObject.UNDEFINED),
					arguments.baseGet(1, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FNJ0 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNJ0(final BaseObject instance) {

			return this.callNJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FNJ1 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNJ2(instance, argument, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FNJA extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callNJ2(
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
	interface CRNJ2FSE0 extends CallableResultNative.CRNJ0FSE0 {

		@Override
		@ReflectionHidden
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FSE1 extends CallableResultNative.CRNJ1FSE1 {

		@Override
		@ReflectionHidden
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNJ2(instance, argument, BaseObject.UNDEFINED).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FSE2 extends CallableResultNative.CRNE2FSE2 {

		@Override
		@ReflectionHidden
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ2(instance, argument1, argument2).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FSEA extends CallableResultNative.CRNJAFSEA {

		@Override
		@ReflectionHidden
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNJ2(//
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED,
					arguments.length > 1
						? arguments[1]
						: BaseObject.UNDEFINED)
					.baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FSEX extends CallableResultNative.CRNJAFSEX {

		@Override
		@ReflectionHidden
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNJ2(//
					instance,
					arguments.baseGetFirst(BaseObject.UNDEFINED),
					arguments.baseGet(1, BaseObject.UNDEFINED)).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FSJ0 extends CallableResultNative.CRNJ0FSJ0 {

		@Override
		@ReflectionHidden
		default String callSJ0(final BaseObject instance) {

			return this.callNJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FSJ1 extends CallableResultNative.CRNJ1FSJ1 {

		@Override
		default String callSJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNJ2(instance, argument, BaseObject.UNDEFINED).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FSJ2 extends CallableResultNative.CRNAAFAAA {

		@Override
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJ2(instance, argument1, argument2).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FSJA extends CallableResultNative.CRNJAFSJA {

		@Override
		@ReflectionHidden
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callNJ2(//
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED,
					arguments.length > 1
						? arguments[1]
						: BaseObject.UNDEFINED)
					.baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FVE0 extends CallableResultNative.CRNJ0FVE0 {

		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {

			this.callNJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FVE1 extends CallableResultNative.CRNJ1FVE1 {

		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			this.callNJ2(instance, argument, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FVE2 extends CallableResultNative.CRNE2FVE2 {

		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callNJ2(instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FVEA extends CallableResultNative.CRNJAFVEA {

		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			this.callNJ2(//
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
	interface CRNJ2FVEX extends CallableResultNative.CRNJAFVEX {

		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			this.callNJ2(instance, arguments.baseGetFirst(BaseObject.UNDEFINED), arguments.baseGet(1, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FVJ0 extends CallableResultNative.CRNJ0FVJ0 {

		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {

			this.callNJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FVJ1 extends CallableResultNative.CRNJ1FVJ1 {

		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {

			this.callNJ2(instance, argument, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FVJ2 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callNJ2(instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJ2FVJA extends CallableResultNative.CRNJAFVJA {

		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {

			this.callNJ2(//
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
	interface CRNJAFDAA
			extends //
				CallableResultNative.CRNJAFDEA,
				CallableResultNative.CRNJAFDJA {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFDE0 extends CallableResultNative.CRNJ0FDE0 {

		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callNJA(instance)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFDE1 extends CallableResultNative.CRNJ1FDE1 {

		@Override
		@ReflectionHidden
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNJA(instance, argument)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFDE2 extends CallableResultNative.CRNJ2FDE2 {

		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJA(instance, argument1, argument2)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRNJAFDEA extends CallableResultNative.CRNEAFDEA {

		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNJA(instance, arguments)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFDEX extends CallableResultNative.CRNEXFDEX {

		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNJA(instance, arguments.toArrayBase())//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}

	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRNJAFDJ0 extends CallableResultNative.CRNJ0FDJ0 {

		@Override
		default double callDJ0(final BaseObject instance) {

			return this.callNJA(instance)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFDJ1 extends CallableResultNative.CRNJ1FDJ1 {

		@Override
		default double callDJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNJA(instance, argument)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFDJ2 extends CallableResultNative.CRNJ2FDJ2 {

		@Override
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJA(instance, argument1, argument2)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFDJA extends CallableResultNative.CRNAAFAAA {

		@Override
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callNJA(instance, arguments)//
					.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFEE0 extends CallableResultNative.CRNJ0FEE0 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {

			return store.execReturn(ctx, this.callNJA(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFEE1 extends CallableResultNative.CRNJ1FEE1 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {

			return store.execReturn(ctx, this.callNJA(instance, argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFEE2 extends CallableResultNative.CRNJ2FEE2 {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {

			return store.execReturn(ctx, this.callNJA(instance, argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFEEX extends CallableResultNative.CRNEAFEEX {

		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {

			return store.execReturn(ctx, this.callNJA(instance, arguments.toArrayBase()));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFIAA
			extends //
				CallableResultNative.CRNJAFIEA,
				CallableResultNative.CRNJAFIJA {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFIE0 extends CallableResultNative.CRNJ0FIE0 {

		@Override
		@ReflectionHidden
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNJA(instance).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFIE1 extends CallableResultNative.CRNJ1FIE1 {

		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNJA(instance, argument).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFIE2 extends CallableResultNative.CRNJ2FIE2 {

		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJA(instance, argument1, argument2).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFIEA extends CallableResultNative.CRNEAFIEA {

		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNJA(instance, arguments).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFIEX extends CallableResultNative.CRNEXFIEX {

		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNJA(instance, arguments.toArrayBase()).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFIJ0 extends CallableResultNative.CRNJ0FIJ0 {

		@Override
		@ReflectionHidden
		default int callIJ0(final BaseObject instance) {

			return this.callNJA(instance).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFIJ1 extends CallableResultNative.CRNJ1FIJ1 {

		@Override
		@ReflectionHidden
		default int callIJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNJA(instance, argument).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFIJ2 extends CallableResultNative.CRNJ2FIJ2 {

		@Override
		@ReflectionHidden
		default int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJA(instance, argument1, argument2).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFIJA extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default int callIJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callNJA(instance, arguments).baseToJavaInteger();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFLE0 extends CallableResultNative.CRNJ0FLE0 {

		@Override
		@ReflectionHidden
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNJA(instance).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFLE1 extends CallableResultNative.CRNJ1FLE1 {

		@Override
		@ReflectionHidden
		default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNJA(instance, argument).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFLE2 extends CallableResultNative.CRNJ2FLE2 {

		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJA(instance, argument1, argument2).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFLEA extends CallableResultNative.CRNEAFLEA {

		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNJA(instance, arguments).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFLEX extends CallableResultNative.CRNEXFLEX {

		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNJA(instance, arguments.toArrayBase()).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFLJ0 extends CallableResultNative.CRNJ0FLJ0 {

		@Override
		@ReflectionHidden
		default long callLJ0(final BaseObject instance) {

			return this.callNJA(instance).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFLJ1 extends CallableResultNative.CRNJ1FLJ1 {

		@Override
		@ReflectionHidden
		default long callLJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNJA(instance, argument).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFLJ2 extends CallableResultNative.CRNJ2FLJ2 {

		@Override
		@ReflectionHidden
		default long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJA(instance, argument1, argument2).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFLJA extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default long callLJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callNJA(instance, arguments).baseToJavaLong();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFNE0 extends CallableResultNative.CRNJ0FNE0 {

		@Override
		@ReflectionHidden
		default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNJA(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFNE1 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNJA(instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFNE2 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJA(instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFNEA extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNJA(instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFNEX extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNJA(instance, arguments.toArrayBase());
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFNJ0 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNJ0(final BaseObject instance) {

			return this.callNJA(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFNJ1 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNJA(instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFNJ2 extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default BaseObject callNJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJA(instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFSE0 extends CallableResultNative.CRNJ0FSE0 {

		@Override
		@ReflectionHidden
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {

			return this.callNJA(instance).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFSE1 extends CallableResultNative.CRNJ1FSE1 {

		@Override
		@ReflectionHidden
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			return this.callNJA(instance, argument).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFSE2 extends CallableResultNative.CRNJ2FSE2 {

		@Override
		@ReflectionHidden
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJA(instance, argument1, argument2).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFSEA extends CallableResultNative.CRNEAFSEA {

		@Override
		@ReflectionHidden
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			return this.callNJA(instance, arguments).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFSEX extends CallableResultNative.CRNEXFSEX {

		@Override
		@ReflectionHidden
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			return this.callNJA(instance, arguments.toArrayBase()).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFSJ0 extends CallableResultNative.CRNJ0FSJ0 {

		@Override
		default String callSJ0(final BaseObject instance) {

			return this.callNJA(instance).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFSJ1 extends CallableResultNative.CRNJ1FSJ1 {

		@Override
		default String callSJ1(final BaseObject instance, final BaseObject argument) {

			return this.callNJA(instance, argument).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFSJ2 extends CallableResultNative.CRNJ2FSJ2 {

		@Override
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			return this.callNJA(instance, argument1, argument2).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFSJA extends CallableResultNative.CRNAAFAAA {

		@Override
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {

			return this.callNJA(instance, arguments).baseToJavaString();
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFVE0 extends CallableResultNative.CRNE0FVE0 {

		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {

			this.callNJA(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFVE1 extends CallableResultNative.CRNE1FVE1 {

		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

			this.callNJA(instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFVE2 extends CallableResultNative.CRNE2FVE2 {

		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callNJA(instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFVEA extends CallableResultNative.CRNEAFVEA {

		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

			this.callNJA(instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFVEX extends CallableResultNative.CRNEXFVEX {

		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {

			this.callNJA(instance, arguments.toArrayBase());
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFVJ0 extends CallableResultNative.CRNJ0FVJ0 {

		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {

			this.callNJA(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFVJ1 extends CallableResultNative.CRNJ1FVJ1 {

		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {

			this.callNJA(instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFVJ2 extends CallableResultNative.CRNJ2FVJ2 {

		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

			this.callNJA(instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRNJAFVJA extends CallableResultNative.CRNAAFAAA {

		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {

			this.callNJA(instance, arguments);
		}

	}

}
