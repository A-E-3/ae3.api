package ru.myx.ae3.exec;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseArray;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/** @author myx */
@ReflectionDisable
interface CallableResultLong {
	
	interface CRLAAFAAA extends ExecCallable {
		//
	}

	interface CRLAAFDAA extends CallableResultLong.CRLAAFAAA {
		//
	}

	interface CRLAAFEAA extends CallableResultLong.CRLAAFAAA {
		//
	}

	interface CRLAAFIAA extends CallableResultLong.CRLAAFAAA {
		//
	}

	interface CRLAAFLAA extends CallableResultLong.CRLAAFAAA {
		//
	}

	interface CRLAAFNAA extends CallableResultLong.CRLAAFAAA {
		//
	}

	interface CRLAAFSAA extends CallableResultLong.CRLAAFAAA {
		//
	}

	interface CRLAAFVAA extends CallableResultLong.CRLAAFAAA {
		//
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FDE0 extends CallableResultLong.CRLAAFDAA {
		
		@Override
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callLE0(ctx, instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FDE1 extends CallableResultLong.CRLE1FDE1 {
		
		@Override
		@ReflectionHidden
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callLE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FDE2 extends CallableResultLong.CRLE2FDE2 {
		
		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callLE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FDEA extends CallableResultLong.CRLEAFDEA {
		
		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callLE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FDEX extends CallableResultLong.CRLEXFDEX {
		
		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callLE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FDJ0 extends CallableResultLong.CRLJ0FDJ0 {
		
		@Override
		@ReflectionHidden
		default double callDJ0(final BaseObject instance) {
			
			return this.callLE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FDJ1 extends CallableResultLong.CRLE1FDJ1, CallableResultLong.CRLJ0FDJ1 {
		
		@Override
		default double callDJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callLE0(Exec.currentProcess(), instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FDJ2 extends CallableResultLong.CRLE2FDJ2, CallableResultLong.CRLJ0FDJ2 {
		
		@Override
		@ReflectionHidden
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callLE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FDJA extends CallableResultLong.CRLEAFDJA {
		
		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callLE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FEE0 extends CallableResultLong.CRLAAFEAA {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {
			
			return store.execReturnNumeric(ctx, this.callLE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FEE1 extends CallableResultLong.CRLE1FEE1 {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {
			
			return store.execReturnNumeric(ctx, this.callLE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FEE2 extends CallableResultLong.CRLE2FEE2 {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {
			
			return store.execReturnNumeric(ctx, this.callLE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FEEX extends CallableResultLong.CRLEXFEEX {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {
			
			return store.execReturnNumeric(ctx, this.callLE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FIE0 extends CallableResultLong.CRLAAFIAA {
		
		@Override
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {
			
			return (int) this.callLE0(ctx, instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FIE1 extends CallableResultLong.CRLE1FIE1 {
		
		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return (int) this.callLE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FIE2 extends CallableResultLong.CRLE2FIE2 {
		
		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return (int) this.callLE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FIEA extends CallableResultLong.CRLEAFIEA {
		
		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return (int) this.callLE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FIEX extends CallableResultLong.CRLEXFIEX {
		
		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return (int) this.callLE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FIJ0 extends CallableResultLong.CRLJ0FIJ0 {
		
		@Override
		@ReflectionHidden
		default int callIJ0(final BaseObject instance) {
			
			return (int) this.callLE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FIJ1 extends CallableResultLong.CRLJ0FIJ1, CallableResultLong.CRLE1FIJ1 {
		
		@Override
		@ReflectionHidden
		default int callIJ1(@NotNull final BaseObject instance, @NotNull final BaseObject argument) {
			
			return (int) this.callLE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FIJ2 extends CallableResultLong.CRLE2FIJ2 {
		
		@Override
		@ReflectionHidden
		default int callIJ2(@NotNull final BaseObject instance, @NotNull final BaseObject argument1, @NotNull final BaseObject argument2) {
			
			return (int) this.callLE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FIJA extends CallableResultLong.CRLEAFIJA {
		
		@Override
		@ReflectionHidden
		default int callIJA(@NotNull final BaseObject instance, @NotNull final BaseObject... arguments) {
			
			return (int) this.callLE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FLE0 extends CallableResultLong.CRLAAFLAA {
		
		@Override
		@ReflectionHidden
		long callLE0(final ExecProcess ctx, final BaseObject instance);

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FLE1 extends CallableResultLong.CRLE1FLE1 {
		
		@Override
		@ReflectionHidden
		default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callLE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FLE2 extends CallableResultLong.CRLE2FLE2 {
		
		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callLE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FLEA extends CallableResultLong.CRLEAFLEA {
		
		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callLE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FLEX extends CallableResultLong.CRLEXFLEX {
		
		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callLE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FLJ0 extends CallableResultLong.CRLJ0FLJ0 {
		
		@Override
		@ReflectionHidden
		default long callLJ0(final BaseObject instance) {
			
			return this.callLE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FLJ1 extends CallableResultLong.CRLE1FLJ1, CallableResultLong.CRLJ0FLJ1 {
		
		@Override
		@ReflectionHidden
		default long callLJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callLE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FLJ2 extends CallableResultLong.CRLE2FLJ2, CallableResultLong.CRLJ0FLJ2 {
		
		@Override
		@ReflectionHidden
		default long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callLE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FLJA extends CallableResultLong.CRLEAFLJA, CallableResultLong.CRLJ0FLJA {
		
		@Override
		@ReflectionHidden
		default long callLJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callLE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FNE0 extends CallableResultLong.CRLAAFNAA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {
			
			return Base.forLong(this.callLE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FNE1 extends CallableResultLong.CRLE1FNE1 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return Base.forLong(this.callLE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FNE2 extends CallableResultLong.CRLE2FNE2 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.forLong(this.callLE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FNEA extends CallableResultLong.CRLEAFNEA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return Base.forLong(this.callLE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FNEX extends CallableResultLong.CRLEXFNEX {
		
		@Override
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return Base.forLong(this.callLE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FNJ0 extends CallableResultLong.CRLJ0FNJ0 {
		
		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNJ0(@NotNull final BaseObject instance) {
			
			return Base.forLong(this.callLE0(Exec.currentProcess(), instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FNJ1 extends CallableResultLong.CRLE1FNJ1 {
		
		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNJ1(@NotNull final BaseObject instance, @NotNull final BaseObject argument) {
			
			return Base.forLong(this.callLE0(Exec.currentProcess(), instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FNJ2 extends CallableResultLong.CRLE2FNJ2 {
		
		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNJ2(@NotNull final BaseObject instance, @NotNull final BaseObject argument1, @NotNull final BaseObject argument2) {
			
			return Base.forLong(this.callLE0(Exec.currentProcess(), instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FNJA extends CallableResultLong.CRLEAFNJA {
		
		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNJA(@NotNull final BaseObject instance, @NotNull final BaseObject... arguments) {
			
			return Base.forLong(this.callLE0(Exec.currentProcess(), instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FSE0 extends CallableResultLong.CRLAAFSAA {
		
		@Override
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {
			
			return Base.toString(this.callLE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FSE1 extends CallableResultLong.CRLE1FSE1 {
		
		@Override
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return Base.toString(this.callLE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FSE2 extends CallableResultLong.CRLE2FSE2 {
		
		@Override
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.toString(this.callLE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FSEA extends CallableResultLong.CRLEAFSEA {
		
		@Override
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return Base.toString(this.callLE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FSEX extends CallableResultLong.CRLEXFSEX {
		
		@Override
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return Base.toString(this.callLE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FSJ0 extends CallableResultLong.CRLJ0FSJ0 {
		
		@Override
		default String callSJ0(final BaseObject instance) {
			
			return Base.toString(this.callLE0(Exec.currentProcess(), instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FSJ1 extends CallableResultLong.CRLE1FSJ1 {
		
		@Override
		default String callSJ1(final BaseObject instance, final BaseObject argument) {
			
			return Base.toString(this.callLE0(Exec.currentProcess(), instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FSJ2 extends CallableResultLong.CRLE2FSJ2 {
		
		@Override
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.toString(this.callLJ0(Exec.currentProcess()));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FSJA extends CallableResultLong.CRLEAFSJA {
		
		@Override
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {
			
			return Base.toString(this.callLE0(Exec.currentProcess(), instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FVE0 extends CallableResultLong.CRLAAFVAA {
		
		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {
			
			this.callLE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FVE1 extends CallableResultLong.CRLE1FVE1 {
		
		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			this.callLE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FVE2 extends CallableResultLong.CRLE2FVE2 {
		
		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callLE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FVEA extends CallableResultLong.CRLEAFVEA {
		
		@Override
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			this.callLE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FVEX extends CallableResultLong.CRLEXFVEX {
		
		@Override
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			this.callLE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FVJ0 extends CallableResultLong.CRLJ0FVJ0 {
		
		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {
			
			this.callLE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FVJ1 extends CallableResultLong.CRLE1FVJ1 {
		
		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {
			
			this.callLE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FVJ2 extends CallableResultLong.CRLE2FVJ2 {
		
		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callLE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE0FVJA extends CallableResultLong.CRLEAFVJA {
		
		@Override
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {
			
			this.callLE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FDE0 extends CallableResultLong.CRLE0FDE0 {
		
		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callLE1(ctx, instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FDE1 extends CallableResultLong.CRLAAFDAA {
		
		@Override
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callLE1(ctx, instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FDE2 extends CallableResultLong.CRLE2FDE2 {
		
		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callLE1(ctx, instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FDEA extends CallableResultLong.CRLEAFDEA {
		
		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callLE1(//
					ctx,
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FDEX extends CallableResultLong.CRLEXFDEX {
		
		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callLE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FDJ0 extends CallableResultLong.CRLE0FDJ0 {
		
		@Override
		@ReflectionHidden
		default double callDJ0(final BaseObject instance) {
			
			return this.callLE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FDJ1 extends CallableResultLong.CRLJ1FDJ1 {
		
		@Override
		default double callDJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callLE1(Exec.currentProcess(), instance, argument);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FDJ2 extends CallableResultLong.CRLE2FDJ2 {
		
		@Override
		@ReflectionHidden
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callLE1(Exec.currentProcess(), instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FDJA extends CallableResultLong.CRLEAFDJA {
		
		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callLE1(//
					Exec.currentProcess(),
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FEE0 extends CallableResultLong.CRLE0FEE0 {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {
			
			return store.execReturnNumeric(ctx, this.callLE1(ctx, instance, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FEE1 extends CallableResultLong.CRLAAFEAA {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {
			
			return store.execReturnNumeric(ctx, this.callLE1(ctx, instance, argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FEE2 extends CallableResultLong.CRLE2FEE2 {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {
			
			return store.execReturnNumeric(ctx, this.callLE1(ctx, instance, argument1));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FEEX extends CallableResultLong.CRLEXFEEX {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {
			
			return store.execReturnNumeric(ctx, this.callLE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED)));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FIE0 extends CallableResultLong.CRLE0FIE0 {
		
		@Override
		@ReflectionHidden
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {
			
			return (int) this.callLE1(ctx, instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FIE1 extends CallableResultLong.CRLAAFIAA {
		
		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return (int) this.callLE1(ctx, instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FIE2 extends CallableResultLong.CRLE2FIE2 {
		
		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return (int) this.callLE1(ctx, instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FIEA extends CallableResultLong.CRLEAFIEA {
		
		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return (int) this.callLE1(//
					ctx,
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FIEX extends CallableResultLong.CRLEXFIEX {
		
		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return (int) this.callLE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FIJ0 extends CallableResultLong.CRLE0FIJ0 {
		
		@Override
		@ReflectionHidden
		default int callIJ0(@NotNull final BaseObject instance) {
			
			return (int) this.callLE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FIJ1 extends CallableResultLong.CRLJ1FIJ1 {
		
		@Override
		@ReflectionHidden
		default int callIJ1(@NotNull final BaseObject instance, @NotNull final BaseObject argument) {
			
			return (int) this.callLE1(Exec.currentProcess(), instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FIJ2 extends CallableResultLong.CRLE2FIJ2 {
		
		@Override
		@ReflectionHidden
		default int callIJ2(@NotNull final BaseObject instance, @NotNull final BaseObject argument1, @NotNull final BaseObject argument2) {
			
			return (int) this.callLE1(Exec.currentProcess(), instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FIJA extends CallableResultLong.CRLEAFIJA {
		
		@Override
		@ReflectionHidden
		default int callIJA(@NotNull final BaseObject instance, @NotNull final BaseObject... arguments) {
			
			return (int) this.callLE1(//
					Exec.currentProcess(),
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FLE0 extends CallableResultLong.CRLE0FLE0 {
		
		@Override
		@ReflectionHidden
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callLE1(ctx, instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FLE1 extends CallableResultLong.CRLAAFEAA {
		
		@Override
		@ReflectionHidden
		default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callLE1(ctx, instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FLE2 extends CallableResultLong.CRLE2FLE2 {
		
		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callLE1(ctx, instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FLEA extends CallableResultLong.CRLEAFLEA {
		
		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callLE1(//
					ctx,
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FLEX extends CallableResultLong.CRLEXFLEX {
		
		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callLE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FLJ0 extends CallableResultLong.CRLE0FLJ0 {
		
		@Override
		@ReflectionHidden
		default long callLJ0(final BaseObject instance) {
			
			return this.callLE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FLJ1 extends CallableResultLong.CRLJ1FLJ1 {
		
		@Override
		@ReflectionHidden
		default long callLJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callLE1(Exec.currentProcess(), instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FLJ2 extends CallableResultLong.CRLE2FLJ2 {
		
		@Override
		@ReflectionHidden
		default long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callLE1(Exec.currentProcess(), instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FLJA extends CallableResultLong.CRLEAFLJA {
		
		@Override
		@ReflectionHidden
		default long callLJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callLE1(//
					Exec.currentProcess(),
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FNE0 extends CallableResultLong.CRLE0FNE0 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {
			
			return Base.forLong(this.callLE1(ctx, instance, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FNE1 extends CallableResultLong.CRLAAFNAA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return Base.forLong(this.callLE1(ctx, instance, argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FNE2 extends CallableResultLong.CRLE2FNE2 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.forLong(this.callLE1(ctx, instance, argument1));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FNEA extends CallableResultLong.CRLEAFNEA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			switch (arguments.length) {
				case 0 :
					return Base.forLong(this.callLE1(ctx, instance, BaseObject.UNDEFINED));
				default :
					return Base.forLong(this.callLE1(ctx, instance, arguments[0]));
			}
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FNEX extends CallableResultLong.CRLEXFNEX {
		
		@Override
		@ReflectionHidden
		default BaseObject callNEX(@NotNull final ExecProcess ctx, @Nullable final BaseObject instance, @NotNull final BaseArray arguments) {
			
			return Base.forLong(this.callLE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED)));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FNJ0 extends CallableResultLong.CRLE0FNJ0 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJ0(final BaseObject instance) {
			
			return Base.forLong(this.callLE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FNJ1 extends CallableResultLong.CRLJ1FNJ1 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJ1(final BaseObject instance, final BaseObject argument) {
			
			return Base.forLong(this.callLE1(Exec.currentProcess(), instance, argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FNJ2 extends CallableResultLong.CRLE2FNJ2 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.forLong(this.callLE1(Exec.currentProcess(), instance, argument1));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FNJA extends CallableResultLong.CRLEAFNJA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJA(final BaseObject instance, final BaseObject... arguments) {
			
			switch (arguments.length) {
				case 0 :
					return Base.forLong(this.callLE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED));
				default :
					return Base.forLong(this.callLE1(Exec.currentProcess(), instance, arguments[0]));
			}
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FSE0 extends CallableResultLong.CRLE0FSE0 {
		
		@Override
		@ReflectionHidden
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {
			
			return Base.toString(this.callLE1(ctx, instance, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FSE1 extends CallableResultLong.CRLAAFSAA {
		
		@Override
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return Base.toString(this.callLE1(ctx, instance, argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FSE2 extends CallableResultLong.CRLE2FSE2 {
		
		@Override
		@ReflectionHidden
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.toString(this.callLE1(ctx, instance, argument1));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FSEA extends CallableResultLong.CRLEAFSEA {
		
		@Override
		@ReflectionHidden
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return Base.toString(this.callLE1(ctx, instance, arguments.length == 0
				? BaseObject.UNDEFINED
				: arguments[0]));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FSEX extends CallableResultLong.CRLEXFSEX {
		
		@Override
		@ReflectionHidden
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return Base.toString(this.callLE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED)));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FSJ0 extends CallableResultLong.CRLE0FSJ0 {
		
		@Override
		@ReflectionHidden
		default String callSJ0(final BaseObject instance) {
			
			return Base.toString(this.callLE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FSJ1 extends CallableResultLong.CRLJ1FSJ1 {
		
		@Override
		default String callSJ1(final BaseObject instance, final BaseObject argument) {
			
			return Base.toString(this.callLE1(Exec.currentProcess(), instance, argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FSJ2 extends CallableResultLong.CRLE2FSJ2 {
		
		@Override
		@ReflectionHidden
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.toString(this.callLE1(Exec.currentProcess(), instance, argument1));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FSJA extends CallableResultLong.CRLEAFSJA {
		
		@Override
		@ReflectionHidden
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {
			
			return Base.toString(this.callLE1(//
					Exec.currentProcess(),
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FVE0 extends CallableResultLong.CRLE0FVE0 {
		
		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {
			
			this.callLE1(ctx, instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FVE1 extends CallableResultLong.CRLAAFVAA {
		
		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			this.callLE1(ctx, instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FVE2 extends CallableResultLong.CRLE2FVE2 {
		
		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callLE1(ctx, instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FVEA extends CallableResultLong.CRLEAFVEA {
		
		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			this.callLE1(//
					ctx,
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FVEX extends CallableResultLong.CRLEXFVEX {
		
		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			this.callLE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FVJ0 extends CallableResultLong.CRLE0FVJ0 {
		
		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {
			
			this.callLE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FVJ1 extends CallableResultLong.CRLJ1FVJ1 {
		
		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {
			
			this.callLE1(Exec.currentProcess(), instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FVJ2 extends CallableResultLong.CRLE2FVJ2 {
		
		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callLE1(Exec.currentProcess(), instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE1FVJA extends CallableResultLong.CRLEAFVJA {
		
		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {
			
			this.callLE1(//
					Exec.currentProcess(),
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE2FDE2 extends CallableResultLong.CRLAAFDAA {
		
		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callLE2(ctx, instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE2FDJ2 extends CallableResultLong.CRLJ2FDJ2 {
		
		@Override
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callLE2(Exec.currentProcess(), instance, argument1, argument2);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE2FEE2 extends CallableResultLong.CRLAAFEAA {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {
			
			return store.execReturnNumeric(ctx, this.callLE2(ctx, instance, argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE2FIE2 extends CallableResultLong.CRLAAFIAA {
		
		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return (int) this.callLE2(ctx, instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE2FIJ2 extends CallableResultLong.CRLJ2FIJ2 {
		
		@Override
		@ReflectionHidden
		default int callIJ2(@NotNull final BaseObject instance, @NotNull final BaseObject argument1, @NotNull final BaseObject argument2) {
			
			return (int) this.callLE2(Exec.currentProcess(), instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE2FLE0 extends CallableResultLong.CRLE0FLE0 {
		
		@Override
		@ReflectionHidden
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callLE2(ctx, instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE2FLE1 extends CallableResultLong.CRLE1FLE1 {
		
		@Override
		@ReflectionHidden
		default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callLE2(ctx, instance, argument, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE2FLE2 extends CallableResultLong.CRLAAFLAA {
		
		@Override
		@ReflectionHidden
		long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2);

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE2FLEA extends CallableResultLong.CRLEAFLEA {
		
		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callLE2(
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
	interface CRLE2FLEX extends CallableResultLong.CRLEXFLEX {
		
		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callLE2(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED), arguments.baseGet(1, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE2FLJ0 extends CallableResultLong.CRLE0FLJ0 {
		
		@Override
		@ReflectionHidden
		default long callLJ0(final BaseObject instance) {
			
			return this.callLE2(Exec.currentProcess(), instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE2FLJ1 extends CallableResultLong.CRLE1FLJ1 {
		
		@Override
		@ReflectionHidden
		default long callLJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callLE2(Exec.currentProcess(), instance, argument, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE2FLJ2 extends CallableResultLong.CRLJ2FLJ2 {
		
		@Override
		@ReflectionHidden
		default long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callLE2(Exec.currentProcess(), instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE2FLJA extends CallableResultLong.CRLEAFLJA {
		
		@Override
		@ReflectionHidden
		default long callLJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callLE2(
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
	interface CRLE2FNE2 extends CallableResultLong.CRLAAFNAA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.forLong(this.callLE2(ctx, instance, argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE2FNJ2 extends CallableResultLong.CRLJ2FNJ2 {
		
		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNJ2(@NotNull final BaseObject instance, @NotNull final BaseObject argument1, @NotNull final BaseObject argument2) {
			
			return Base.forLong(this.callLE2(Exec.currentProcess(), instance, argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE2FSE2 extends CallableResultLong.CRLAAFSAA {
		
		@Override
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.toString(this.callLE2(ctx, instance, argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE2FSJ2 extends CallableResultLong.CRLJ2FSJ2 {
		
		@Override
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.toString(this.callLE2(Exec.currentProcess(), instance, argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE2FVE2 extends CallableResultLong.CRLAAFVAA {
		
		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callLE2(ctx, instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLE2FVJ2 extends CallableResultLong.CRLJ2FVJ2 {
		
		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callLE2(Exec.currentProcess(), instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEAFDEA extends CallableResultLong.CRLAAFDAA {
		
		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callLEA(ctx, instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEAFDJA extends CallableResultLong.CRLJAFDJA {
		
		@Override
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callLEA(Exec.currentProcess(), instance, arguments);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEAFIEA extends CallableResultLong.CRLAAFIAA {
		
		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return (int) this.callLEA(ctx, instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEAFIJA extends CallableResultLong.CRLJAFIJA {
		
		@Override
		@ReflectionHidden
		default int callIJA(@NotNull final BaseObject instance, @NotNull final BaseObject... arguments) {
			
			return (int) this.callLEA(Exec.currentProcess(), instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEAFLEA extends CallableResultLong.CRLAAFLAA {
		
		@Override
		@ReflectionHidden
		long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments);

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEAFLJA extends CallableResultLong.CRLJAFLJA {
		
		@Override
		@ReflectionHidden
		default long callLJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callLEA(Exec.currentProcess(), instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEAFNEA extends CallableResultLong.CRLAAFNAA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return Base.forLong(this.callLEA(ctx, instance, arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEAFNJA extends CallableResultLong.CRLJAFNJA {
		
		@Override
		@NotNull
		@ReflectionHidden
		default BaseObject callNJA(@NotNull final BaseObject instance, @NotNull final BaseObject... arguments) {
			
			return Base.forLong(this.callLEA(Exec.currentProcess(), instance, arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEAFSEA extends CallableResultLong.CRLAAFSAA {
		
		@Override
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return Base.toString(this.callLEA(ctx, instance, arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEAFSJA extends CallableResultLong.CRLJAFSJA {
		
		@Override
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {
			
			return Base.toString(this.callLEA(Exec.currentProcess(), instance, arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEAFVEA extends CallableResultLong.CRLAAFVAA {
		
		@Override
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			this.callLEA(ctx, instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEAFVJA extends CallableResultLong.CRLJAFVJA {
		
		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {
			
			this.callLEA(Exec.currentProcess(), instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEXFDEX extends CallableResultLong.CRLAAFDAA {
		
		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callLEX(ctx, instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEXFEEX extends CallableResultLong.CRLAAFEAA {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {
			
			return store.execReturnNumeric(ctx, this.callLEX(ctx, instance, arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEXFIEX extends CallableResultLong.CRLAAFIAA {
		
		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return (int) this.callLEX(ctx, instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEXFLE0 extends CallableResultLong.CRLE0FLE0 {
		
		@Override
		@ReflectionHidden
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callLE1(ctx, instance, ctx.argumentsEmpty());
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEXFLE1 extends CallableResultLong.CRLE1FLE1 {
		
		@Override
		@ReflectionHidden
		default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callLE1(ctx, instance, ctx.argumentsList1(argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEXFLE2 extends CallableResultLong.CRLE2FLE2 {
		
		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callLE1(ctx, instance, ctx.argumentsList2(argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEXFLEA extends CallableResultLong.CRLEAFLEA {
		
		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callLE1(ctx, instance, ctx.argumentsListA(arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEXFLEX extends CallableResultLong.CRLAAFLAA {
		
		@Override
		@ReflectionHidden
		long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments);

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEXFLJ0 extends CallableResultLong.CRLE0FLJ0 {
		
		@Override
		@ReflectionHidden
		default long callLJ0(final BaseObject instance) {
			
			final ExecProcess ctx = Exec.currentProcess();
			return this.callLE1(ctx, instance, ctx.argumentsEmpty());
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEXFLJ1 extends CallableResultLong.CRLE1FLJ1 {
		
		@Override
		@ReflectionHidden
		default long callLJ1(final BaseObject instance, final BaseObject argument) {
			
			final ExecProcess ctx = Exec.currentProcess();
			return this.callLE1(ctx, instance, ctx.argumentsList1(argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEXFLJ2 extends CallableResultLong.CRLE2FLJ2 {
		
		@Override
		@ReflectionHidden
		default long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final ExecProcess ctx = Exec.currentProcess();
			return this.callLE1(ctx, instance, ctx.argumentsList2(argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEXFLJA extends CallableResultLong.CRLEAFLJA {
		
		@Override
		@ReflectionHidden
		default long callLJA(final BaseObject instance, final BaseObject... arguments) {
			
			final ExecProcess ctx = Exec.currentProcess();
			return this.callLE1(ctx, instance, ctx.argumentsListA(arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEXFNEX extends CallableResultLong.CRLAAFNAA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return Base.forLong(this.callLEX(ctx, instance, arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEXFSEX extends CallableResultLong.CRLAAFSAA {
		
		@Override
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return Base.toString(this.callLE1(ctx, instance, arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLEXFVEX extends CallableResultLong.CRLAAFVAA {
		
		@Override
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			this.callLEX(ctx, instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FDE0 extends CallableResultLong.CRLE0FDE0 {
		
		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callLJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FDE1 extends CallableResultLong.CRLJ1FDE1 {
		
		@Override
		@ReflectionHidden
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FDE2 extends CallableResultLong.CRLJ2FDE2 {
		
		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FDEA extends CallableResultLong.CRLJAFDEA {
		
		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FDEX extends CallableResultLong.CRLE0FDEX, CallableResultLong.CRLJAFDEX {
		
		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FDJ0 extends CallableResultLong.CRLAAFDAA {
		
		@Override
		@ReflectionHidden
		default double callDJ0(final BaseObject instance) {
			
			return this.callLJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FDJ1 extends CallableResultLong.CRLJ1FDJ1 {
		
		@Override
		@ReflectionHidden
		default double callDJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callLJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FDJ2 extends CallableResultLong.CRLJ2FDJ2 {
		
		@Override
		@ReflectionHidden
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callLJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FDJA extends CallableResultLong.CRLJAFDJA {
		
		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callLJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FEE0 extends CallableResultLong.CRLE0FEE0 {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {
			
			return store.execReturnNumeric(ctx, this.callLJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FEE1 extends CallableResultLong.CRLJ1FEE1 {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {
			
			return store.execReturnNumeric(ctx, this.callLJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FEE2 extends CallableResultLong.CRLJ2FEE2 {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {
			
			return store.execReturnNumeric(ctx, this.callLJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FEEX extends CallableResultLong.CRLJAFEEX {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {
			
			return store.execReturnNumeric(ctx, this.callLJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FIE0 extends CallableResultLong.CRLE0FIE0 {
		
		@Override
		@ReflectionHidden
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {
			
			return (int) this.callLJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FIE1 extends CallableResultLong.CRLJ1FIE1, CallableResultLong.CRLE0FIE1 {
		
		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return (int) this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FIE2 extends CallableResultLong.CRLJ2FIE2, CallableResultLong.CRLE0FIE2 {
		
		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return (int) this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FIEA extends CallableResultLong.CRLJAFIEA {
		
		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return (int) this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FIEX extends CallableResultLong.CRLJAFIEX {
		
		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return (int) this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FIJ0 extends CallableResultLong.CRLAAFIAA {
		
		@Override
		@ReflectionHidden
		default int callIJ0(final BaseObject instance) {
			
			return (int) this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FIJ1 extends CallableResultLong.CRLJ1FIJ1 {
		
		@Override
		@ReflectionHidden
		default int callIJ1(final BaseObject instance, final BaseObject argument) {
			
			return (int) this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FIJ2 extends CallableResultLong.CRLJ2FIJ2 {
		
		@Override
		@ReflectionHidden
		default int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return (int) this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FIJA extends CallableResultLong.CRLJAFIJA {
		
		@Override
		@ReflectionHidden
		default int callIJA(@NotNull final BaseObject instance, @NotNull final BaseObject... arguments) {
			
			return (int) this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FLE0 extends CallableResultLong.CRLE0FLE0 {
		
		@Override
		@ReflectionHidden
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callLJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FLE1 extends CallableResultLong.CRLJ1FLE1 {
		
		@Override
		@ReflectionHidden
		default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FLE2 extends CallableResultLong.CRLJ2FLE2 {
		
		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FLEA extends CallableResultLong.CRLJAFLEA {
		
		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... argument1s) {
			
			return this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FLEX extends CallableResultLong.CRLJAFLEX {
		
		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FLJ0 extends CallableResultLong.CRLAAFLAA {
		
		@Override
		@ReflectionHidden
		default long callLJ0(final BaseObject instance) {
			
			return this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FLJ1 extends CallableResultLong.CRLJ1FLJ1 {
		
		@Override
		@ReflectionHidden
		default long callLJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FLJ2 extends CallableResultLong.CRLJ2FLJ2 {
		
		@Override
		@ReflectionHidden
		default long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FLJA extends CallableResultLong.CRLJAFLJA {
		
		@Override
		@ReflectionHidden
		default long callLJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FNE0 extends CallableResultLong.CRLE0FNE0 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {
			
			return Base.forLong(this.callLJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FNE1 extends CallableResultLong.CRLJ1FNE1 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return Base.forLong(this.callLJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FNE2 extends CallableResultLong.CRLJ2FNE2 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.forLong(this.callLJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FNEA extends CallableResultLong.CRLJAFNEA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return Base.forLong(this.callLJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FNEX extends CallableResultLong.CRLJAFNEX {
		
		@Override
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return Base.forLong(this.callLJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FNJ0 extends CallableResultLong.CRLAAFNAA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJ0(@NotNull final BaseObject instance) {
			
			return Base.forLong(this.callLJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FNJ1 extends CallableResultLong.CRLJ1FNJ1 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJ1(@NotNull final BaseObject instance, @NotNull final BaseObject argument) {
			
			return Base.forLong(this.callLJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FNJ2 extends CallableResultLong.CRLJ2FNJ2 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJ2(@NotNull final BaseObject instance, @NotNull final BaseObject argument1, @NotNull final BaseObject argument2) {
			
			return Base.forLong(this.callLJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FNJA extends CallableResultLong.CRLJAFNJA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJA(@NotNull final BaseObject instance, @NotNull final BaseObject... arguments) {
			
			return Base.forLong(this.callLJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FSE0 extends CallableResultLong.CRLE0FSE0 {
		
		@Override
		@ReflectionHidden
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {
			
			return Base.toString(this.callLJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FSE1 extends CallableResultLong.CRLJ1FSE1, CallableResultLong.CRLE0FSE1 {
		
		@Override
		@ReflectionHidden
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return Base.toString(this.callLJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FSE2 extends CallableResultLong.CRLJ2FSE2, CallableResultLong.CRLE0FSE2 {
		
		@Override
		@ReflectionHidden
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.toString(this.callLJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FSEA extends CallableResultLong.CRLJAFSEA, CallableResultLong.CRLE0FSEA {
		
		@Override
		@ReflectionHidden
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return Base.toString(this.callLJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FSEX extends CallableResultLong.CRLJAFSEX, CallableResultLong.CRLE0FSEX {
		
		@Override
		@ReflectionHidden
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return Base.toString(this.callLJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FSJ0 extends CallableResultLong.CRLAAFSAA {
		
		@Override
		@ReflectionHidden
		default String callSJ0(final BaseObject instance) {
			
			return Base.toString(this.callLJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FSJ1 extends CallableResultLong.CRLJ1FSJ1 {
		
		@Override
		@ReflectionHidden
		default String callSJ1(final BaseObject instance, final BaseObject argument) {
			
			return Base.toString(this.callLJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FSJ2 extends CallableResultLong.CRLJ2FSJ2 {
		
		@Override
		@ReflectionHidden
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.toString(this.callLJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FSJA extends CallableResultLong.CRLJAFSJA {
		
		@Override
		@ReflectionHidden
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {
			
			return Base.toString(this.callLJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FVE0 extends CallableResultLong.CRLE0FVE0 {
		
		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {
			
			this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FVE1 extends CallableResultLong.CRLJ1FVE1 {
		
		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FVE2 extends CallableResultLong.CRLJ2FVE2 {
		
		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FVEA extends CallableResultLong.CRLJAFVEA {
		
		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FVEX extends CallableResultLong.CRLJAFVEX {
		
		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FVJ0 extends CallableResultLong.CRLAAFVAA {
		
		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {
			
			this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FVJ1 extends CallableResultLong.CRLJ1FVJ1 {
		
		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {
			
			this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FVJ2 extends CallableResultLong.CRLJ2FVJ2 {
		
		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ0FVJA extends CallableResultLong.CRLJAFVJA {
		
		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {
			
			this.callLJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FDA1
			extends //
				CallableResultLong.CRLJ1FDE1,
				CallableResultLong.CRLJ1FDJ1 {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FDE0 extends CallableResultLong.CRLJ0FDE0 {
		
		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callLJ1(instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FDE1 extends CallableResultLong.CRLE1FDE1 {
		
		@Override
		@ReflectionHidden
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callLJ1(instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FDE2 extends CallableResultLong.CRLJ2FDE2 {
		
		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callLJ1(instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FDEA extends CallableResultLong.CRLJAFDEA {
		
		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			switch (arguments.length) {
				case 0 :
					return this.callLJ1(instance, BaseObject.UNDEFINED);
				default :
					return this.callLJ1(instance, arguments[0]);
			}
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FDEX extends CallableResultLong.CRLJAFDEX {
		
		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callLJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FDJ0 extends CallableResultLong.CRLJ0FDJ0 {
		
		@Override
		@ReflectionHidden
		default double callDJ0(final BaseObject instance) {
			
			return this.callLJ1(instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FDJ1 extends CallableResultLong.CRLAAFDAA {
		
		@Override
		@ReflectionHidden
		default double callDJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callLJ1(instance, argument);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FDJ2 extends CallableResultLong.CRLJ2FDJ2 {
		
		@Override
		@ReflectionHidden
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callLJ1(instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FDJA extends CallableResultLong.CRLJAFDJA {
		
		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {
			
			switch (arguments.length) {
				case 0 :
					return this.callLJ1(instance, BaseObject.UNDEFINED);
				default :
					return this.callLJ1(instance, arguments[0]);
			}
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FEE0 extends CallableResultLong.CRLJ0FEE0 {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {
			
			return store.execReturnNumeric(ctx, this.callLJ1(instance, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FEE1 extends CallableResultLong.CRLE1FEE1 {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {
			
			return store.execReturnNumeric(ctx, this.callLJ1(instance, argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FEE2 extends CallableResultLong.CRLJ2FEE2 {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {
			
			return store.execReturnNumeric(ctx, this.callLJ1(instance, argument1));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FEEX extends CallableResultLong.CRLJAFEEX {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {
			
			return store.execReturnNumeric(ctx, this.callLJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED)));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FIE0 extends CallableResultLong.CRLJ0FIE0 {
		
		@Override
		@ReflectionHidden
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {
			
			return (int) this.callLJ1(instance, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FIE1 extends CallableResultLong.CRLE1FIE1 {
		
		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return (int) this.callLJ1(instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FIE2 extends CallableResultLong.CRLJ2FIE2 {
		
		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return (int) this.callLJ1(instance, argument1);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FIEA extends CallableResultLong.CRLJAFIEA {
		
		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return (int) this.callLJ1(//
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FIEX extends CallableResultLong.CRLJAFIEX {
		
		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return (int) this.callLJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FIJ0 extends CallableResultLong.CRLJ0FIJ0 {
		
		@Override
		@ReflectionHidden
		default int callIJ0(@NotNull final BaseObject instance) {
			
			return (int) this.callLJ1(instance, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FIJ1 extends CallableResultLong.CRLAAFIAA {
		
		@Override
		@ReflectionHidden
		default int callIJ1(final BaseObject instance, final BaseObject argument) {
			
			return (int) this.callLJ1(instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FIJ2 extends CallableResultLong.CRLJ2FIJ2 {
		
		@Override
		@ReflectionHidden
		default int callIJ2(@NotNull final BaseObject instance, @NotNull final BaseObject argument1, @NotNull final BaseObject argument2) {
			
			return (int) this.callLJ1(instance, argument1);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FIJA extends CallableResultLong.CRLJAFIJA {
		
		@Override
		@ReflectionHidden
		default int callIJA(@NotNull final BaseObject instance, @NotNull final BaseObject... arguments) {
			
			return (int) this.callLJ1(//
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FLE0 extends CallableResultLong.CRLJ0FLE0 {
		
		@Override
		@ReflectionHidden
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callLJ1(instance, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FLE1 extends CallableResultLong.CRLE1FLE1 {
		
		@Override
		@ReflectionHidden
		default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callLJ1(instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FLE2 extends CallableResultLong.CRLJ2FLE2 {
		
		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callLJ1(instance, argument1);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FLEA extends CallableResultLong.CRLJAFLEA {
		
		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callLJ1(//
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FLEX extends CallableResultLong.CRLJAFLEX {
		
		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callLJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FLJ0 extends CallableResultLong.CRLJ0FLJ0 {
		
		@Override
		@ReflectionHidden
		default long callLJ0(final BaseObject instance) {
			
			return this.callLJ1(instance, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FLJ1 extends CallableResultLong.CRLAAFLAA {
		
		@Override
		@ReflectionHidden
		long callLJ1(@NotNull final BaseObject instance, @NotNull final BaseObject argument);
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FLJ2 extends CallableResultLong.CRLJ2FLJ2 {
		
		@Override
		@ReflectionHidden
		default long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callLJ1(instance, argument1);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FLJA extends CallableResultLong.CRLJAFLJA {
		
		@Override
		@ReflectionHidden
		default long callLJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callLJ1(//
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FNE0 extends CallableResultLong.CRLJ0FNE0 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {
			
			return Base.forLong(this.callLJ1(instance, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FNE1 extends CallableResultLong.CRLE1FNE1 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return Base.forLong(this.callLJ1(instance, argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FNE2 extends CallableResultLong.CRLJ2FNE2 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.forLong(this.callLJ1(instance, argument1));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FNEA extends CallableResultLong.CRLJAFNEA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			switch (arguments.length) {
				case 0 :
					return Base.forLong(this.callLJ1(instance, BaseObject.UNDEFINED));
				default :
					return Base.forLong(this.callLJ1(instance, arguments[0]));
			}
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FNEX extends CallableResultLong.CRLJAFNEX {
		
		@Override
		@ReflectionHidden
		default BaseObject callNEX(@NotNull final ExecProcess ctx, @Nullable final BaseObject instance, @NotNull final BaseArray arguments) {
			
			return Base.forLong(this.callLJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED)));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FNJ0 extends CallableResultLong.CRLJ0FNJ0 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJ0(final BaseObject instance) {
			
			return Base.forLong(this.callLJ1(instance, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FNJ1 extends CallableResultLong.CRLAAFNAA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJ1(final BaseObject instance, final BaseObject argument) {
			
			return Base.forLong(this.callLJ1(instance, argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FNJ2 extends CallableResultLong.CRLJ2FNJ2 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.forLong(this.callLJ1(instance, argument1));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FNJA extends CallableResultLong.CRLJAFNJA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJA(final BaseObject instance, final BaseObject... arguments) {
			
			switch (arguments.length) {
				case 0 :
					return Base.forLong(this.callLJ1(instance, BaseObject.UNDEFINED));
				default :
					return Base.forLong(this.callLJ1(instance, arguments[0]));
			}
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FSE0 extends CallableResultLong.CRLJ0FSE0 {
		
		@Override
		@ReflectionHidden
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {
			
			return Base.toString(this.callLJ1(instance, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FSE1 extends CallableResultLong.CRLE1FSE1 {
		
		@Override
		@ReflectionHidden
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return Base.toString(this.callLJ1(instance, argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FSE2 extends CallableResultLong.CRLJ2FSE2 {
		
		@Override
		@ReflectionHidden
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.toString(this.callLJ1(instance, argument1));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FSEA extends CallableResultLong.CRLJAFSEA {
		
		@Override
		@ReflectionHidden
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return Base.toString(this.callLJ1(instance, arguments.length == 0
				? BaseObject.UNDEFINED
				: arguments[0]));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FSEX extends CallableResultLong.CRLJAFSEX {
		
		@Override
		@ReflectionHidden
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return Base.toString(this.callLJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED)));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FSJ0 extends CallableResultLong.CRLJ0FSJ0 {
		
		@Override
		@ReflectionHidden
		default String callSJ0(final BaseObject instance) {
			
			return Base.toString(this.callLJ1(instance, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FSJ1 extends CallableResultLong.CRLAAFSAA {
		
		@Override
		default String callSJ1(final BaseObject instance, final BaseObject argument) {
			
			return Base.toString(this.callLJ1(instance, argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FSJ2 extends CallableResultLong.CRLJ2FSJ2 {
		
		@Override
		@ReflectionHidden
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.toString(this.callLJ1(instance, argument1));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FSJA extends CallableResultLong.CRLJAFSJA {
		
		@Override
		@ReflectionHidden
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {
			
			return Base.toString(this.callLJ1(//
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FVE0 extends CallableResultLong.CRLJ0FVE0 {
		
		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {
			
			this.callLJ1(instance, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FVE1 extends CallableResultLong.CRLE1FVE1 {
		
		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			this.callLJ1(instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FVE2 extends CallableResultLong.CRLJ2FVE2 {
		
		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callLJ1(instance, argument1);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FVEA extends CallableResultLong.CRLJAFVEA {
		
		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			this.callLJ1(//
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FVEX extends CallableResultLong.CRLJAFVEX {
		
		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			this.callLJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FVJ0 extends CallableResultLong.CRLJ0FVJ0 {
		
		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {
			
			this.callLJ1(instance, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FVJ1 extends CallableResultLong.CRLAAFVAA {
		
		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {
			
			this.callLJ1(instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FVJ2 extends CallableResultLong.CRLJ2FVJ2 {
		
		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callLJ1(instance, argument1);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ1FVJA extends CallableResultLong.CRLJAFVJA {
		
		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {
			
			this.callLJ1(//
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ2FDA2
			extends //
				CallableResultLong.CRLJ2FDE2,
				CallableResultLong.CRLJ2FDJ2 {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ2FDE2 extends CallableResultLong.CRLE2FDE2 {
		
		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callLJ2(instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ2FDJ2 extends CallableResultLong.CRLAAFDAA {
		
		@Override
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callLJ2(instance, argument1, argument2);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ2FEE2 extends CallableResultLong.CRLE2FEE2 {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {
			
			return store.execReturnNumeric(ctx, this.callLJ2(instance, argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ2FIE2 extends CallableResultLong.CRLE2FIE2 {
		
		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return (int) this.callLJ2(instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ2FIJ2 extends CallableResultLong.CRLAAFIAA {
		
		@Override
		@ReflectionHidden
		default int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return (int) this.callLJ2(instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ2FLE2 extends CallableResultLong.CRLE2FLE2 {
		
		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callLJ2(instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ2FLJ2 extends CallableResultLong.CRLAAFLAA {
		
		@Override
		@ReflectionHidden
		default long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callLJ2(instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ2FNE2 extends CallableResultLong.CRLE2FNE2 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.forLong(this.callLJ2(instance, argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ2FNJ2 extends CallableResultLong.CRLAAFNAA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.forLong(this.callLJ2(instance, argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ2FSE2 extends CallableResultLong.CRLE2FSE2 {
		
		@Override
		@ReflectionHidden
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.toString(this.callLJ2(instance, argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ2FSJ2 extends CallableResultLong.CRLAAFSAA {
		
		@Override
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.toString(this.callLJ2(instance, argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ2FVE2 extends CallableResultLong.CRLE2FVE2 {
		
		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callLJ2(instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJ2FVJ2 extends CallableResultLong.CRLAAFVAA {
		
		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callLJ2(instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJAFDEA extends CallableResultLong.CRLEAFDEA {
		
		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callLJA(instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJAFDEX extends CallableResultLong.CRLEXFDEX {
		
		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callLEA(ctx, instance, arguments.toArrayBase());
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJAFDJA extends CallableResultLong.CRLAAFDAA {
		
		@Override
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callLJA(instance, arguments);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJAFEEX extends CallableResultLong.CRLEXFEEX {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {
			
			return store.execReturnNumeric(ctx, this.callLJA(instance, arguments.toArrayBase()));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJAFIEA extends CallableResultLong.CRLE0FIEA {
		
		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return (int) this.callLJA(instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJAFIEX extends CallableResultLong.CRLEXFIEX {
		
		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return (int) this.callLJA(instance, arguments.toArrayBase());
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJAFIJA extends CallableResultLong.CRLAAFIAA {
		
		@Override
		@ReflectionHidden
		default int callIJA(final BaseObject instance, final BaseObject... arguments) {
			
			return (int) this.callLJA(instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJAFLEA extends CallableResultLong.CRLEAFLEA {
		
		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callLJA(instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJAFLEX extends CallableResultLong.CRLEXFLEX {
		
		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callLJA(instance, arguments.toArrayBase());
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJAFLJA extends CallableResultLong.CRLAAFLAA {
		
		@Override
		@ReflectionHidden
		default long callLJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callLJA(instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJAFNEA extends CallableResultLong.CRLEAFNEA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return Base.forLong(this.callLJA(instance, arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJAFNEX extends CallableResultLong.CRLEXFNEX {
		
		@Override
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return Base.forLong(this.callLJA(instance, arguments.toArrayBase()));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJAFNJA extends CallableResultLong.CRLAAFNAA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJA(final BaseObject instance, final BaseObject... arguments) {
			
			return Base.forLong(this.callLJA(instance, arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJAFSEA extends CallableResultLong.CRLEAFSEA {
		
		@Override
		@ReflectionHidden
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return Base.toString(this.callLJA(instance, arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJAFSEX extends CallableResultLong.CRLEXFSEX {
		
		@Override
		@ReflectionHidden
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return Base.toString(this.callLJA(instance, arguments.toArrayBase()));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJAFSJA extends CallableResultLong.CRLAAFSAA {
		
		@Override
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {
			
			return Base.toString(this.callLJA(instance, arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJAFVEA extends CallableResultLong.CRLEAFVEA {
		
		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			this.callLJA(instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJAFVEX extends CallableResultLong.CRLEXFVEX {
		
		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			this.callLJA(instance, arguments.toArrayBase());
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRLJAFVJA extends CallableResultLong.CRLAAFVAA {
		
		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {
			
			this.callLJA(instance, arguments);
		}

	}

}
