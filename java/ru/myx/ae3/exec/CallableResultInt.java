package ru.myx.ae3.exec;



import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseArray;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/** @author myx */
@ReflectionDisable
interface CallableResultInt {
	
	interface CRIAAFAAA extends ExecCallable {
		//
	}

	interface CRIAAFDAA extends CallableResultInt.CRIAAFAAA {
		//
	}

	interface CRIAAFEAA extends CallableResultInt.CRIAAFAAA {
		//
	}

	interface CRIAAFIAA extends CallableResultInt.CRIAAFAAA {
		//
	}

	interface CRIAAFLAA extends CallableResultInt.CRIAAFAAA {
		//
	}

	interface CRIAAFNAA extends CallableResultInt.CRIAAFAAA {
		//
	}

	interface CRIAAFSAA extends CallableResultInt.CRIAAFAAA {
		//
	}

	interface CRIAAFVAA extends CallableResultInt.CRIAAFAAA {
		//
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FDE0 extends CallableResultInt.CRIAAFDAA {
		
		@Override
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callIE0(ctx, instance)//
			;
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FDE1 extends CallableResultInt.CRIE1FDE1 {
		
		@Override
		@ReflectionHidden
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callIE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FDE2 extends CallableResultInt.CRIE2FDE2 {
		
		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FDEA extends CallableResultInt.CRIEAFDEA {
		
		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FDEX extends CallableResultInt.CRIEXFDEX {
		
		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callIE0(ctx, instance)//
			;
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FDJ0 extends CallableResultInt.CRIJ0FDJ0 {
		
		@Override
		@ReflectionHidden
		default double callDJ0(final BaseObject instance) {
			
			return this.callIE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FDJ1 extends CallableResultInt.CRIE1FDJ1, CallableResultInt.CRIJ0FDJ1 {
		
		@Override
		default double callDJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callIE0(Exec.currentProcess(), instance)//
			;
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FDJ2 extends CallableResultInt.CRIE2FDJ2, CallableResultInt.CRIJ0FDJ2 {
		
		@Override
		@ReflectionHidden
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FDJA extends CallableResultInt.CRIEAFDJA {
		
		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FEE0 extends CallableResultInt.CRIAAFEAA {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {
			
			return store.execReturnNumeric(ctx, this.callIE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FEE1 extends CallableResultInt.CRIE1FEE1 {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {
			
			return store.execReturnNumeric(ctx, this.callIE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FEE2 extends CallableResultInt.CRIE2FEE2 {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {
			
			return store.execReturnNumeric(ctx, this.callIE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FEEX extends CallableResultInt.CRIEXFEEX {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {
			
			return store.execReturnNumeric(ctx, this.callIE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FIE0 extends CallableResultInt.CRIAAFIAA {
		
		@Override
		@ReflectionHidden
		int callIE0(final ExecProcess ctx, final BaseObject instance);

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FIE1 extends CallableResultInt.CRIE1FIE1 {
		
		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callIE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FIE2 extends CallableResultInt.CRIE2FIE2 {
		
		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FIEA extends CallableResultInt.CRIEAFIEA {
		
		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FIEX extends CallableResultInt.CRIEXFIEX {
		
		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callIE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FIJ0 extends CallableResultInt.CRIJ0FIJ0 {
		
		@Override
		@ReflectionHidden
		default int callIJ0(final BaseObject instance) {
			
			return this.callIE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FIJ1 extends CallableResultInt.CRIE1FIJ1, CallableResultInt.CRIJ0FIJ1 {
		
		@Override
		@ReflectionHidden
		default int callIJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callIE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FIJ2 extends CallableResultInt.CRIE2FIJ2, CallableResultInt.CRIJ0FIJ2 {
		
		@Override
		@ReflectionHidden
		default int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FIJA extends CallableResultInt.CRIEAFIJA, CallableResultInt.CRIJ0FIJA {
		
		@Override
		@ReflectionHidden
		default int callIJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FLE0 extends CallableResultInt.CRIAAFLAA {
		
		@Override
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callIE0(ctx, instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FLE1 extends CallableResultInt.CRIE1FLE1 {
		
		@Override
		@ReflectionHidden
		default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callIE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FLE2 extends CallableResultInt.CRIE2FLE2 {
		
		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FLEA extends CallableResultInt.CRIEAFLEA {
		
		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FLEX extends CallableResultInt.CRIEXFLEX {
		
		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callIE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FLJ0 extends CallableResultInt.CRIJ0FLJ0 {
		
		@Override
		@ReflectionHidden
		default long callLJ0(final BaseObject instance) {
			
			return this.callIE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FLJ1 extends CallableResultInt.CRIJ0FLJ1, CallableResultInt.CRIE1FLJ1 {
		
		@Override
		@ReflectionHidden
		default long callLJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callIE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FLJ2 extends CallableResultInt.CRIE2FLJ2 {
		
		@Override
		@ReflectionHidden
		default long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FLJA extends CallableResultInt.CRIEAFLJA {
		
		@Override
		@ReflectionHidden
		default long callLJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FNE0 extends CallableResultInt.CRIAAFNAA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {
			
			return Base.forInteger(this.callIE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FNE1 extends CallableResultInt.CRIE1FNE1 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return Base.forInteger(this.callIE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FNE2 extends CallableResultInt.CRIE2FNE2 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.forInteger(this.callIE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FNEA extends CallableResultInt.CRIEAFNEA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return Base.forInteger(this.callIE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FNEX extends CallableResultInt.CRIEXFNEX {
		
		@Override
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return Base.forInteger(this.callIE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FNJ0 extends CallableResultInt.CRIJ0FNJ0 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJ0(final BaseObject instance) {
			
			return Base.forInteger(this.callIE0(Exec.currentProcess(), instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FNJ1 extends CallableResultInt.CRIE1FNJ1 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJ1(final BaseObject instance, final BaseObject argument) {
			
			return Base.forInteger(this.callIE0(Exec.currentProcess(), instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FNJ2 extends CallableResultInt.CRIE2FNJ2 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.forInteger(this.callIE0(Exec.currentProcess(), instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FNJA extends CallableResultInt.CRIEAFNJA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJA(final BaseObject instance, final BaseObject... arguments) {
			
			return Base.forInteger(this.callIE0(Exec.currentProcess(), instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FSE0 extends CallableResultInt.CRIAAFSAA {
		
		@Override
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {
			
			return Base.toString(this.callIE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FSE1 extends CallableResultInt.CRIE1FSE1 {
		
		@Override
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return Base.toString(this.callIE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FSE2 extends CallableResultInt.CRIE2FSE2 {
		
		@Override
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.toString(this.callIE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FSEA extends CallableResultInt.CRIEAFSEA {
		
		@Override
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return Base.toString(this.callIE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FSEX extends CallableResultInt.CRIEXFSEX {
		
		@Override
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return Base.toString(this.callIE0(ctx, instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FSJ0 extends CallableResultInt.CRIJ0FSJ0 {
		
		@Override
		default String callSJ0(final BaseObject instance) {
			
			return Base.toString(this.callIE0(Exec.currentProcess(), instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FSJ1 extends CallableResultInt.CRIE1FSJ1 {
		
		@Override
		default String callSJ1(final BaseObject instance, final BaseObject argument) {
			
			return Base.toString(this.callIE0(Exec.currentProcess(), instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FSJ2 extends CallableResultInt.CRIE2FSJ2 {
		
		@Override
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.toString(this.callIJ0(Exec.currentProcess()));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FSJA extends CallableResultInt.CRIEAFSJA {
		
		@Override
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {
			
			return Base.toString(this.callIE0(Exec.currentProcess(), instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FVE0 extends CallableResultInt.CRIAAFVAA {
		
		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {
			
			this.callIE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FVE1 extends CallableResultInt.CRIE1FVE1 {
		
		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			this.callIE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FVE2 extends CallableResultInt.CRIE2FVE2 {
		
		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callIE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FVEA extends CallableResultInt.CRIEAFVEA {
		
		@Override
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			this.callIE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FVEX extends CallableResultInt.CRIEXFVEX {
		
		@Override
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			this.callIE0(ctx, instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FVJ0 extends CallableResultInt.CRIJ0FVJ0 {
		
		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {
			
			this.callIE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FVJ1 extends CallableResultInt.CRIE1FVJ1 {
		
		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {
			
			this.callIE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FVJ2 extends CallableResultInt.CRIE2FVJ2 {
		
		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callIE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE0FVJA extends CallableResultInt.CRIEAFVJA {
		
		@Override
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {
			
			this.callIE0(Exec.currentProcess(), instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FDE0 extends CallableResultInt.CRIE0FDE0 {
		
		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callIE1(ctx, instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FDE1 extends CallableResultInt.CRIAAFDAA {
		
		@Override
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callIE1(ctx, instance, argument)//
			;
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FDE2 extends CallableResultInt.CRIE2FDE2 {
		
		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIE1(ctx, instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FDEA extends CallableResultInt.CRIEAFDEA {
		
		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIE1(//
					ctx,
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FDEX extends CallableResultInt.CRIEXFDEX {
		
		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callIE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FDJ0 extends CallableResultInt.CRIE0FDJ0 {
		
		@Override
		@ReflectionHidden
		default double callDJ0(final BaseObject instance) {
			
			return this.callIE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FDJ1 extends CallableResultInt.CRIJ1FDJ1 {
		
		@Override
		default double callDJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callIE1(Exec.currentProcess(), instance, argument)//
			;
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FDJ2 extends CallableResultInt.CRIE2FDJ2 {
		
		@Override
		@ReflectionHidden
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIE1(Exec.currentProcess(), instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FDJA extends CallableResultInt.CRIEAFDJA {
		
		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIE1(//
					Exec.currentProcess(),
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FEE0 extends CallableResultInt.CRIE0FEE0 {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {
			
			return store.execReturnNumeric(ctx, this.callIE1(ctx, instance, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FEE1 extends CallableResultInt.CRIAAFEAA {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {
			
			return store.execReturnNumeric(ctx, this.callIE1(ctx, instance, argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FEE2 extends CallableResultInt.CRIE2FEE2 {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {
			
			return store.execReturnNumeric(ctx, this.callIE1(ctx, instance, argument1));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FEEX extends CallableResultInt.CRIEXFEEX {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {
			
			return store.execReturnNumeric(ctx, this.callIE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED)));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FIE0 extends CallableResultInt.CRIE0FIE0 {
		
		@Override
		@ReflectionHidden
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callIE1(ctx, instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FIE1 extends CallableResultInt.CRIAAFEAA {
		
		@Override
		@ReflectionHidden
		int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument);

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FIE2 extends CallableResultInt.CRIE2FIE2 {
		
		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIE1(ctx, instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FIEA extends CallableResultInt.CRIEAFIEA {
		
		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIE1(//
					ctx,
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FIEX extends CallableResultInt.CRIEXFIEX {
		
		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callIE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FIJ0 extends CallableResultInt.CRIE0FIJ0 {
		
		@Override
		@ReflectionHidden
		default int callIJ0(final BaseObject instance) {
			
			return this.callIE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FIJ1 extends CallableResultInt.CRIJ1FIJ1 {
		
		@Override
		@ReflectionHidden
		default int callIJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callIE1(Exec.currentProcess(), instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FIJ2 extends CallableResultInt.CRIE2FIJ2 {
		
		@Override
		@ReflectionHidden
		default int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIE1(Exec.currentProcess(), instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FIJA extends CallableResultInt.CRIEAFIJA {
		
		@Override
		@ReflectionHidden
		default int callIJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIE1(//
					Exec.currentProcess(),
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FLE0 extends CallableResultInt.CRIE0FLE0 {
		
		@Override
		@ReflectionHidden
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callIE1(ctx, instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FLE1 extends CallableResultInt.CRIAAFLAA {
		
		@Override
		@ReflectionHidden
		default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callIE1(ctx, instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FLE2 extends CallableResultInt.CRIE2FLE2 {
		
		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIE1(ctx, instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FLEA extends CallableResultInt.CRIEAFLEA {
		
		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIE1(//
					ctx,
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FLEX extends CallableResultInt.CRIEXFLEX {
		
		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callIE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FLJ0 extends CallableResultInt.CRIE0FLJ0 {
		
		@Override
		@ReflectionHidden
		default long callLJ0(final BaseObject instance) {
			
			return this.callIE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FLJ1 extends CallableResultInt.CRIJ1FLJ1 {
		
		@Override
		@ReflectionHidden
		default long callLJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callIE1(Exec.currentProcess(), instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FLJ2 extends CallableResultInt.CRIE2FLJ2 {
		
		@Override
		@ReflectionHidden
		default long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIE1(Exec.currentProcess(), instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FLJA extends CallableResultInt.CRIEAFLJA {
		
		@Override
		@ReflectionHidden
		default long callLJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIE1(//
					Exec.currentProcess(),
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FNE0 extends CallableResultInt.CRIE0FNE0 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {
			
			return Base.forInteger(this.callIE1(ctx, instance, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FNE1 extends CallableResultInt.CRIAAFNAA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return Base.forInteger(this.callIE1(ctx, instance, argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FNE2 extends CallableResultInt.CRIE2FNE2 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.forInteger(this.callIE1(ctx, instance, argument1));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FNEA extends CallableResultInt.CRIEAFNEA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			switch (arguments.length) {
				case 0 :
					return Base.forInteger(this.callIE1(ctx, instance, BaseObject.UNDEFINED));
				default :
					return Base.forInteger(this.callIE1(ctx, instance, arguments[0]));
			}
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FNEX extends CallableResultInt.CRIEXFNEX {
		
		@Override
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return Base.forInteger(this.callIE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED)));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FNJ0 extends CallableResultInt.CRIE0FNJ0 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJ0(final BaseObject instance) {
			
			return Base.forInteger(this.callIE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FNJ1 extends CallableResultInt.CRIJ1FNJ1 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJ1(final BaseObject instance, final BaseObject argument) {
			
			return Base.forInteger(this.callIE1(Exec.currentProcess(), instance, argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FNJ2 extends CallableResultInt.CRIE2FNJ2 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.forInteger(this.callIE1(Exec.currentProcess(), instance, argument1));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FNJA extends CallableResultInt.CRIEAFNJA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJA(final BaseObject instance, final BaseObject... arguments) {
			
			switch (arguments.length) {
				case 0 :
					return Base.forInteger(this.callIE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED));
				default :
					return Base.forInteger(this.callIE1(Exec.currentProcess(), instance, arguments[0]));
			}
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FSE0 extends CallableResultInt.CRIE0FSE0 {
		
		@Override
		@ReflectionHidden
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {
			
			return Base.toString(this.callIE1(ctx, instance, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FSE1 extends CallableResultInt.CRIAAFSAA {
		
		@Override
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return Base.toString(this.callIE1(ctx, instance, argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FSE2 extends CallableResultInt.CRIE2FSE2 {
		
		@Override
		@ReflectionHidden
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.toString(this.callIE1(ctx, instance, argument1));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FSEA extends CallableResultInt.CRIEAFSEA {
		
		@Override
		@ReflectionHidden
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return Base.toString(this.callIE1(ctx, instance, arguments.length == 0
				? BaseObject.UNDEFINED
				: arguments[0]));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FSEX extends CallableResultInt.CRIEXFSEX {
		
		@Override
		@ReflectionHidden
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return Base.toString(this.callIE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED)));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FSJ0 extends CallableResultInt.CRIE0FSJ0 {
		
		@Override
		@ReflectionHidden
		default String callSJ0(final BaseObject instance) {
			
			return Base.toString(this.callIE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FSJ1 extends CallableResultInt.CRIJ1FSJ1 {
		
		@Override
		default String callSJ1(final BaseObject instance, final BaseObject argument) {
			
			return Base.toString(this.callIE1(Exec.currentProcess(), instance, argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FSJ2 extends CallableResultInt.CRIE2FSJ2 {
		
		@Override
		@ReflectionHidden
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.toString(this.callIE1(Exec.currentProcess(), instance, argument1));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FSJA extends CallableResultInt.CRIEAFSJA {
		
		@Override
		@ReflectionHidden
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {
			
			return Base.toString(this.callIE1(//
					Exec.currentProcess(),
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FVE0 extends CallableResultInt.CRIE0FVE0 {
		
		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {
			
			this.callIE1(ctx, instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FVE1 extends CallableResultInt.CRIAAFVAA {
		
		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			this.callIE1(ctx, instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FVE2 extends CallableResultInt.CRIE2FVE2 {
		
		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callIE1(ctx, instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FVEA extends CallableResultInt.CRIEAFVEA {
		
		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			this.callIE1(//
					ctx,
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FVEX extends CallableResultInt.CRIEXFVEX {
		
		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			this.callIE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FVJ0 extends CallableResultInt.CRIE0FVJ0 {
		
		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {
			
			this.callIE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FVJ1 extends CallableResultInt.CRIJ1FVJ1 {
		
		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {
			
			this.callIE1(Exec.currentProcess(), instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FVJ2 extends CallableResultInt.CRIE2FVJ2 {
		
		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callIE1(Exec.currentProcess(), instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE1FVJA extends CallableResultInt.CRIEAFVJA {
		
		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {
			
			this.callIE1(//
					Exec.currentProcess(),
					instance,
					arguments.length == 0
						? BaseObject.UNDEFINED
						: arguments[0]);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE2FDE2 extends CallableResultInt.CRIAAFDAA {
		
		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIE2(ctx, instance, argument1, argument2)//
			;
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE2FDJ2 extends CallableResultInt.CRIJ2FDJ2 {
		
		@Override
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIE2(Exec.currentProcess(), instance, argument1, argument2)//
			;
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE2FEE2 extends CallableResultInt.CRIAAFEAA {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {
			
			return store.execReturnNumeric(ctx, this.callIE2(ctx, instance, argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE2FIE0 extends CallableResultInt.CRIE0FIE0 {
		
		@Override
		@ReflectionHidden
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callIE2(ctx, instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE2FIE1 extends CallableResultInt.CRIE1FIE1 {
		
		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callIE2(ctx, instance, argument, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE2FIE2 extends CallableResultInt.CRIAAFIAA {
		
		@Override
		@ReflectionHidden
		int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2);

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE2FIEA extends CallableResultInt.CRIEAFIEA {
		
		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIE2(
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
	interface CRIE2FIEX extends CallableResultInt.CRIEXFIEX {
		
		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callIE2(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED), arguments.baseGet(1, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE2FIJ0 extends CallableResultInt.CRIE0FIJ0 {
		
		@Override
		@ReflectionHidden
		default int callIJ0(final BaseObject instance) {
			
			return this.callIE2(Exec.currentProcess(), instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE2FIJ1 extends CallableResultInt.CRIE1FIJ1 {
		
		@Override
		@ReflectionHidden
		default int callIJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callIE2(Exec.currentProcess(), instance, argument, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE2FIJ2 extends CallableResultInt.CRIJ2FIJ2 {
		
		@Override
		@ReflectionHidden
		default int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIE2(Exec.currentProcess(), instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE2FIJA extends CallableResultInt.CRIEAFIJA {
		
		@Override
		@ReflectionHidden
		default int callIJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIE2(
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
	interface CRIE2FLE2 extends CallableResultInt.CRIAAFLAA {
		
		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIE2(ctx, instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE2FLJ2 extends CallableResultInt.CRIJ2FLJ2 {
		
		@Override
		@ReflectionHidden
		default long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIE2(Exec.currentProcess(), instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE2FNE2 extends CallableResultInt.CRIAAFNAA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.forInteger(this.callIE2(ctx, instance, argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE2FNJ2 extends CallableResultInt.CRIJ2FNJ2 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.forInteger(this.callIE2(Exec.currentProcess(), instance, argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE2FSE2 extends CallableResultInt.CRIAAFSAA {
		
		@Override
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.toString(this.callIE2(ctx, instance, argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE2FSJ2 extends CallableResultInt.CRIJ2FSJ2 {
		
		@Override
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.toString(this.callIE2(Exec.currentProcess(), instance, argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE2FVE2 extends CallableResultInt.CRIAAFVAA {
		
		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callIE2(ctx, instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIE2FVJ2 extends CallableResultInt.CRIJ2FVJ2 {
		
		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callIE2(Exec.currentProcess(), instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEAFDEA extends CallableResultInt.CRIAAFDAA {
		
		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIEA(ctx, instance, arguments)//
			;
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEAFDJA extends CallableResultInt.CRIJAFDJA {
		
		@Override
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIEA(Exec.currentProcess(), instance, arguments)//
			;
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEAFIEA extends CallableResultInt.CRIAAFIAA {
		
		@Override
		@ReflectionHidden
		int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments);

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEAFIJA extends CallableResultInt.CRIJAFIJA {
		
		@Override
		@ReflectionHidden
		default int callIJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIEA(Exec.currentProcess(), instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEAFLEA extends CallableResultInt.CRIAAFLAA {
		
		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIEA(ctx, instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEAFLJA extends CallableResultInt.CRIJAFLJA {
		
		@Override
		@ReflectionHidden
		default long callLJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIEA(Exec.currentProcess(), instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEAFNEA extends CallableResultInt.CRIAAFNAA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return Base.forInteger(this.callIEA(ctx, instance, arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEAFNJA extends CallableResultInt.CRIJAFNJA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJA(final BaseObject instance, final BaseObject... arguments) {
			
			return Base.forInteger(this.callIEA(Exec.currentProcess(), instance, arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEAFSEA extends CallableResultInt.CRIAAFSAA {
		
		@Override
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return Base.toString(this.callIEA(ctx, instance, arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEAFSJA extends CallableResultInt.CRIJAFSJA {
		
		@Override
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {
			
			return Base.toString(this.callIEA(Exec.currentProcess(), instance, arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEAFVEA extends CallableResultInt.CRIAAFVAA {
		
		@Override
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			this.callIEA(ctx, instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEAFVJA extends CallableResultInt.CRIJAFVJA {
		
		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {
			
			this.callIEA(Exec.currentProcess(), instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEXFDEX extends CallableResultInt.CRIAAFDAA {
		
		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callIEX(ctx, instance, arguments)//
			;
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEXFEEX extends CallableResultInt.CRIAAFEAA {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {
			
			return store.execReturnNumeric(ctx, this.callIEX(ctx, instance, arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEXFIE0 extends CallableResultInt.CRIE0FIE0 {
		
		@Override
		@ReflectionHidden
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callIE1(ctx, instance, ctx.argumentsEmpty());
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEXFIE1 extends CallableResultInt.CRIE1FIE1 {
		
		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callIE1(ctx, instance, ctx.argumentsList1(argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEXFIE2 extends CallableResultInt.CRIE2FIE2 {
		
		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIE1(ctx, instance, ctx.argumentsList2(argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEXFIEA extends CallableResultInt.CRIEAFIEA {
		
		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIE1(ctx, instance, ctx.argumentsListA(arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEXFIEX extends CallableResultInt.CRIAAFIAA {
		
		@Override
		@ReflectionHidden
		int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments);

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEXFIJ0 extends CallableResultInt.CRIE0FIJ0 {
		
		@Override
		@ReflectionHidden
		default int callIJ0(final BaseObject instance) {
			
			final ExecProcess ctx = Exec.currentProcess();
			return this.callIE1(ctx, instance, ctx.argumentsEmpty());
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEXFIJ1 extends CallableResultInt.CRIE1FIJ1 {
		
		@Override
		@ReflectionHidden
		default int callIJ1(final BaseObject instance, final BaseObject argument) {
			
			final ExecProcess ctx = Exec.currentProcess();
			return this.callIE1(ctx, instance, ctx.argumentsList1(argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEXFIJ2 extends CallableResultInt.CRIE2FIJ2 {
		
		@Override
		@ReflectionHidden
		default int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final ExecProcess ctx = Exec.currentProcess();
			return this.callIE1(ctx, instance, ctx.argumentsList2(argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEXFIJA extends CallableResultInt.CRIEAFIJA {
		
		@Override
		@ReflectionHidden
		default int callIJA(final BaseObject instance, final BaseObject... arguments) {
			
			final ExecProcess ctx = Exec.currentProcess();
			return this.callIE1(ctx, instance, ctx.argumentsListA(arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEXFLEX extends CallableResultInt.CRIAAFLAA {
		
		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callIEX(ctx, instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEXFNEX extends CallableResultInt.CRIAAFNAA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return Base.forInteger(this.callIEX(ctx, instance, arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEXFSEX extends CallableResultInt.CRIAAFSAA {
		
		@Override
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return Base.toString(this.callIE1(ctx, instance, arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIEXFVEX extends CallableResultInt.CRIAAFVAA {
		
		@Override
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			this.callIEX(ctx, instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FDE0 extends CallableResultInt.CRIE0FDE0 {
		
		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callIJ0(instance)//
			;
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FDE1 extends CallableResultInt.CRIJ1FDE1 {
		
		@Override
		@ReflectionHidden
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callIJ0(instance)//
			;
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FDE2 extends CallableResultInt.CRIJ2FDE2 {
		
		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIJ0(instance)//
			;
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FDEA extends CallableResultInt.CRIJAFDEA {
		
		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIJ0(instance)//
			;
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FDEX extends CallableResultInt.CRIE0FDEX, CallableResultInt.CRIJAFDEX {
		
		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callIJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FDJ0 extends CallableResultInt.CRIAAFDAA {
		
		@Override
		@ReflectionHidden
		default double callDJ0(final BaseObject instance) {
			
			return this.callIJ0(instance)//
			;
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FDJ1 extends CallableResultInt.CRIJ1FDJ1 {
		
		@Override
		@ReflectionHidden
		default double callDJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callIJ0(instance)//
			;
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FDJ2 extends CallableResultInt.CRIJ2FDJ2 {
		
		@Override
		@ReflectionHidden
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIJ0(instance)//
			;
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FDJA extends CallableResultInt.CRIJAFDJA {
		
		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIJ0(instance)//
			;
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FEE0 extends CallableResultInt.CRIE0FEE0 {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {
			
			return store.execReturnNumeric(ctx, this.callIJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FEE1 extends CallableResultInt.CRIJ1FEE1 {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {
			
			return store.execReturnNumeric(ctx, this.callIJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FEE2 extends CallableResultInt.CRIJ2FEE2 {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {
			
			return store.execReturnNumeric(ctx, this.callIJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FEEX extends CallableResultInt.CRIJAFEEX {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {
			
			return store.execReturnNumeric(ctx, this.callIJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FIE0 extends CallableResultInt.CRIE0FIE0 {
		
		@Override
		@ReflectionHidden
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callIJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FIE1 extends CallableResultInt.CRIJ1FIE1 {
		
		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callIJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FIE2 extends CallableResultInt.CRIJ2FIE2 {
		
		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FIEA extends CallableResultInt.CRIJAFIEA {
		
		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... argument1s) {
			
			return this.callIJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FIEX extends CallableResultInt.CRIJAFIEX {
		
		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callIJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FIJ0 extends CallableResultInt.CRIAAFIAA {
		
		@Override
		@ReflectionHidden
		int callIJ0(final BaseObject instance);

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FIJ1 extends CallableResultInt.CRIJ1FIJ1 {
		
		@Override
		@ReflectionHidden
		default int callIJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callIJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FIJ2 extends CallableResultInt.CRIJ2FIJ2 {
		
		@Override
		@ReflectionHidden
		default int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FIJA extends CallableResultInt.CRIJAFIJA {
		
		@Override
		@ReflectionHidden
		default int callIJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FLE0 extends CallableResultInt.CRIE0FLE0 {
		
		@Override
		@ReflectionHidden
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callIJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FLE1 extends CallableResultInt.CRIJ1FLE1, CallableResultInt.CRIE0FLE1 {
		
		@Override
		@ReflectionHidden
		default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callIJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FLE2 extends CallableResultInt.CRIJ2FLE2, CallableResultInt.CRIE0FLE2 {
		
		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FLEA extends CallableResultInt.CRIJAFLEA {
		
		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FLEX extends CallableResultInt.CRIJAFLEX {
		
		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callIJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FLJ0 extends CallableResultInt.CRIAAFLAA {
		
		@Override
		@ReflectionHidden
		default long callLJ0(final BaseObject instance) {
			
			return this.callIJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FLJ1 extends CallableResultInt.CRIJ1FLJ1 {
		
		@Override
		@ReflectionHidden
		default long callLJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callIJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FLJ2 extends CallableResultInt.CRIJ2FLJ2 {
		
		@Override
		@ReflectionHidden
		default long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FLJA extends CallableResultInt.CRIJAFLJA {
		
		@Override
		@ReflectionHidden
		default long callLJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FNE0 extends CallableResultInt.CRIE0FNE0 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {
			
			return Base.forInteger(this.callIJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FNE1 extends CallableResultInt.CRIJ1FNE1 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return Base.forInteger(this.callIJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FNE2 extends CallableResultInt.CRIJ2FNE2 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.forInteger(this.callIJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FNEA extends CallableResultInt.CRIJAFNEA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return Base.forInteger(this.callIJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FNEX extends CallableResultInt.CRIJAFNEX {
		
		@Override
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return Base.forInteger(this.callIJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FNJ0 extends CallableResultInt.CRIAAFNAA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJ0(final BaseObject instance) {
			
			return Base.forInteger(this.callIJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FNJ1 extends CallableResultInt.CRIJ1FNJ1 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJ1(final BaseObject instance, final BaseObject argument) {
			
			return Base.forInteger(this.callIJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FNJ2 extends CallableResultInt.CRIJ2FNJ2 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.forInteger(this.callIJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FNJA extends CallableResultInt.CRIJAFNJA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJA(final BaseObject instance, final BaseObject... arguments) {
			
			return Base.forInteger(this.callIJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FSE0 extends CallableResultInt.CRIE0FSE0 {
		
		@Override
		@ReflectionHidden
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {
			
			return Base.toString(this.callIJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FSE1 extends CallableResultInt.CRIJ1FSE1, CallableResultInt.CRIE0FSE1 {
		
		@Override
		@ReflectionHidden
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return Base.toString(this.callIJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FSE2 extends CallableResultInt.CRIJ2FSE2, CallableResultInt.CRIE0FSE2 {
		
		@Override
		@ReflectionHidden
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.toString(this.callIJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FSEA extends CallableResultInt.CRIJAFSEA, CallableResultInt.CRIE0FSEA {
		
		@Override
		@ReflectionHidden
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return Base.toString(this.callIJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FSEX extends CallableResultInt.CRIJAFSEX, CallableResultInt.CRIE0FSEX {
		
		@Override
		@ReflectionHidden
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return Base.toString(this.callIJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FSJ0 extends CallableResultInt.CRIAAFSAA {
		
		@Override
		@ReflectionHidden
		default String callSJ0(final BaseObject instance) {
			
			return Base.toString(this.callIJ0(instance));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FSJ1 extends CallableResultInt.CRIJ1FSJ1 {
		
		@Override
		@ReflectionHidden
		default String callSJ1(final BaseObject instance, final BaseObject argument) {
			
			return Base.toString(this.callIJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FSJ2 extends CallableResultInt.CRIJ2FSJ2 {
		
		@Override
		@ReflectionHidden
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.toString(this.callIJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FSJA extends CallableResultInt.CRIJAFSJA {
		
		@Override
		@ReflectionHidden
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {
			
			return Base.toString(this.callIJ0(instance));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FVE0 extends CallableResultInt.CRIE0FVE0 {
		
		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {
			
			this.callIJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FVE1 extends CallableResultInt.CRIJ1FVE1 {
		
		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			this.callIJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FVE2 extends CallableResultInt.CRIJ2FVE2 {
		
		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callIJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FVEA extends CallableResultInt.CRIJAFVEA {
		
		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			this.callIJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FVEX extends CallableResultInt.CRIJAFVEX {
		
		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			this.callIJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FVJ0 extends CallableResultInt.CRIAAFVAA {
		
		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {
			
			this.callIJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FVJ1 extends CallableResultInt.CRIJ1FVJ1 {
		
		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {
			
			this.callIJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FVJ2 extends CallableResultInt.CRIJ2FVJ2 {
		
		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callIJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ0FVJA extends CallableResultInt.CRIJAFVJA {
		
		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {
			
			this.callIJ0(instance);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FDA1
			extends //
				CallableResultInt.CRIJ1FDE1,
				CallableResultInt.CRIJ1FDJ1 {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FDE0 extends CallableResultInt.CRIJ0FDE0 {
		
		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callIJ1(instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FDE1 extends CallableResultInt.CRIE1FDE1 {
		
		@Override
		@ReflectionHidden
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callIJ1(instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FDE2 extends CallableResultInt.CRIJ2FDE2 {
		
		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIJ1(instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FDEA extends CallableResultInt.CRIJAFDEA {
		
		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIJ1(//
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FDEX extends CallableResultInt.CRIJAFDEX {
		
		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callIJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FDJ0 extends CallableResultInt.CRIJ0FDJ0 {
		
		@Override
		@ReflectionHidden
		default double callDJ0(final BaseObject instance) {
			
			return this.callIJ1(instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FDJ1 extends CallableResultInt.CRIAAFDAA {
		
		@Override
		@ReflectionHidden
		default double callDJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callIJ1(instance, argument)//
			;
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FDJ2 extends CallableResultInt.CRIJ2FDJ2 {
		
		@Override
		@ReflectionHidden
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIJ1(instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FDJA extends CallableResultInt.CRIJAFDJA {
		
		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIJ1(//
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FEE0 extends CallableResultInt.CRIJ0FEE0 {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {
			
			return store.execReturnNumeric(ctx, this.callIJ1(instance, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FEE1 extends CallableResultInt.CRIE1FEE1 {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {
			
			return store.execReturnNumeric(ctx, this.callIJ1(instance, argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FEE2 extends CallableResultInt.CRIJ2FEE2 {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {
			
			return store.execReturnNumeric(ctx, this.callIJ1(instance, argument1));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FEEX extends CallableResultInt.CRIJAFEEX {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {
			
			return store.execReturnNumeric(ctx, this.callIJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED)));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FIE0 extends CallableResultInt.CRIJ0FIE0 {
		
		@Override
		@ReflectionHidden
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callIJ1(instance, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FIE1 extends CallableResultInt.CRIE1FIE1 {
		
		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callIJ1(instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FIE2 extends CallableResultInt.CRIJ2FIE2 {
		
		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIJ1(instance, argument1);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FIEA extends CallableResultInt.CRIJAFIEA {
		
		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIJ1(//
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FIEX extends CallableResultInt.CRIJAFIEX {
		
		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callIJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FIJ0 extends CallableResultInt.CRIJ0FIJ0 {
		
		@Override
		@ReflectionHidden
		default int callIJ0(final BaseObject instance) {
			
			return this.callIJ1(instance, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FIJ1 extends CallableResultInt.CRIAAFIAA {
		
		@Override
		@ReflectionHidden
		int callIJ1(final BaseObject instance, final BaseObject argument);
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FIJ2 extends CallableResultInt.CRIJ2FIJ2 {
		
		@Override
		@ReflectionHidden
		default int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIJ1(instance, argument1);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FIJA extends CallableResultInt.CRIJAFIJA {
		
		@Override
		@ReflectionHidden
		default int callIJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIJ1(//
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FLE0 extends CallableResultInt.CRIJ0FLE0 {
		
		@Override
		@ReflectionHidden
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callIJ1(instance, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FLE1 extends CallableResultInt.CRIE1FLE1 {
		
		@Override
		@ReflectionHidden
		default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callIJ1(instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FLE2 extends CallableResultInt.CRIJ2FLE2 {
		
		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIJ1(instance, argument1);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FLEA extends CallableResultInt.CRIJAFLEA {
		
		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIJ1(//
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FLEX extends CallableResultInt.CRIJAFLEX {
		
		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callIJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FLJ0 extends CallableResultInt.CRIJ0FLJ0 {
		
		@Override
		@ReflectionHidden
		default long callLJ0(final BaseObject instance) {
			
			return this.callIJ1(instance, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FLJ1 extends CallableResultInt.CRIAAFLAA {
		
		@Override
		@ReflectionHidden
		default long callLJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callIJ1(instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FLJ2 extends CallableResultInt.CRIJ2FLJ2 {
		
		@Override
		@ReflectionHidden
		default long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIJ1(instance, argument1);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FLJA extends CallableResultInt.CRIJAFLJA {
		
		@Override
		@ReflectionHidden
		default long callLJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIJ1(//
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FNE0 extends CallableResultInt.CRIJ0FNE0 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {
			
			return Base.forInteger(this.callIJ1(instance, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FNE1 extends CallableResultInt.CRIE1FNE1 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return Base.forInteger(this.callIJ1(instance, argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FNE2 extends CallableResultInt.CRIJ2FNE2 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.forInteger(this.callIJ1(instance, argument1));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FNEA extends CallableResultInt.CRIJAFNEA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return Base.forInteger(this.callIJ1(//
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FNEX extends CallableResultInt.CRIJAFNEX {
		
		@Override
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return Base.forInteger(this.callIJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED)));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FNJ0 extends CallableResultInt.CRIJ0FNJ0 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJ0(final BaseObject instance) {
			
			return Base.forInteger(this.callIJ1(instance, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FNJ1 extends CallableResultInt.CRIAAFNAA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJ1(final BaseObject instance, final BaseObject argument) {
			
			return Base.forInteger(this.callIJ1(instance, argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FNJ2 extends CallableResultInt.CRIJ2FNJ2 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.forInteger(this.callIJ1(instance, argument1));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FNJA extends CallableResultInt.CRIJAFNJA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJA(final BaseObject instance, final BaseObject... arguments) {
			
			return Base.forInteger(this.callIJ1(//
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FSE0 extends CallableResultInt.CRIJ0FSE0 {
		
		@Override
		@ReflectionHidden
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {
			
			return Base.toString(this.callIJ1(instance, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FSE1 extends CallableResultInt.CRIE1FSE1 {
		
		@Override
		@ReflectionHidden
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return Base.toString(this.callIJ1(instance, argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FSE2 extends CallableResultInt.CRIJ2FSE2 {
		
		@Override
		@ReflectionHidden
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.toString(this.callIJ1(instance, argument1));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FSEA extends CallableResultInt.CRIJAFSEA {
		
		@Override
		@ReflectionHidden
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return Base.toString(this.callIJ1(//
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FSEX extends CallableResultInt.CRIJAFSEX {
		
		@Override
		@ReflectionHidden
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return Base.toString(this.callIJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED)));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FSJ0 extends CallableResultInt.CRIJ0FSJ0 {
		
		@Override
		@ReflectionHidden
		default String callSJ0(final BaseObject instance) {
			
			return Base.toString(this.callIJ1(instance, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FSJ1 extends CallableResultInt.CRIAAFSAA {
		
		@Override
		default String callSJ1(final BaseObject instance, final BaseObject argument) {
			
			return Base.toString(this.callIJ1(instance, argument));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FSJ2 extends CallableResultInt.CRIJ2FSJ2 {
		
		@Override
		@ReflectionHidden
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.toString(this.callIJ1(instance, argument1));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FSJA extends CallableResultInt.CRIJAFSJA {
		
		@Override
		@ReflectionHidden
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {
			
			return Base.toString(this.callIJ1(//
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FVE0 extends CallableResultInt.CRIJ0FVE0 {
		
		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {
			
			this.callIJ1(instance, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FVE1 extends CallableResultInt.CRIE1FVE1 {
		
		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			this.callIJ1(instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FVE2 extends CallableResultInt.CRIJ2FVE2 {
		
		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callIJ1(instance, argument1);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FVEA extends CallableResultInt.CRIJAFVEA {
		
		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			this.callIJ1(//
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FVEX extends CallableResultInt.CRIJAFVEX {
		
		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			this.callIJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FVJ0 extends CallableResultInt.CRIJ0FVJ0 {
		
		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {
			
			this.callIJ1(instance, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FVJ1 extends CallableResultInt.CRIAAFVAA {
		
		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {
			
			this.callIJ1(instance, argument);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FVJ2 extends CallableResultInt.CRIJ2FVJ2 {
		
		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callIJ1(instance, argument1);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ1FVJA extends CallableResultInt.CRIJAFVJA {
		
		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {
			
			this.callIJ1(//
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FDA2
			extends //
				CallableResultInt.CRIJ2FDE2,
				CallableResultInt.CRIJ2FDJ2 {
		//

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FDE0 extends CallableResultInt.CRIJ0FDE0 {
		
		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callIJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FDE1 extends CallableResultInt.CRIJ1FDE1 {
		
		@Override
		@ReflectionHidden
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callIJ2(instance, argument, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FDE2 extends CallableResultInt.CRIE2FDE2 {
		
		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIJ2(instance, argument1, argument2)//
			;
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FDEA extends CallableResultInt.CRIJAFDEA {
		
		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIJ2(//
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
	interface CRIJ2FDEX extends CallableResultInt.CRIJAFDEX {
		
		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callIJ2(//
					instance,
					arguments.baseGetFirst(BaseObject.UNDEFINED),
					arguments.baseGet(1, BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FDJ0 extends CallableResultInt.CRIJ0FDJ0 {
		
		@Override
		@ReflectionHidden
		default double callDJ0(final BaseObject instance) {
			
			return this.callIJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FDJ1 extends CallableResultInt.CRIJ1FDJ1 {
		
		@Override
		@ReflectionHidden
		default double callDJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callIJ2(instance, argument, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FDJ2 extends CallableResultInt.CRIAAFDAA {
		
		@Override
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIJ2(instance, argument1, argument2)//
			;
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FDJA extends CallableResultInt.CRIJAFDJA {
		
		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIJ2(//
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
	interface CRIJ2FEE0 extends CallableResultInt.CRIJ0FEE0 {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {
			
			return store.execReturnNumeric(ctx, this.callIJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FEE1 extends CallableResultInt.CRIJ1FEE1 {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseObject argument) {
			
			return store.execReturnNumeric(ctx, this.callIJ2(instance, argument, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FEE2 extends CallableResultInt.CRIE2FEE2 {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx,
				final BaseObject instance,
				final ResultHandler store,
				final boolean inline,
				final BaseObject argument1,
				final BaseObject argument2) {
			
			return store.execReturnNumeric(ctx, this.callIJ2(instance, argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FEEX extends CallableResultInt.CRIJAFEEX {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {
			
			return store.execReturnNumeric(ctx, this.callIJ2(instance, arguments.baseGetFirst(BaseObject.UNDEFINED), arguments.baseGet(1, BaseObject.UNDEFINED)));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FIE0 extends CallableResultInt.CRIJ0FIE0 {
		
		@Override
		@ReflectionHidden
		default int callIE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callIJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FIE1 extends CallableResultInt.CRIJ1FIE1 {
		
		@Override
		@ReflectionHidden
		default int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callIJ2(instance, argument, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FIE2 extends CallableResultInt.CRIE2FIE2 {
		
		@Override
		@ReflectionHidden
		default int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIJ2(instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FIEA extends CallableResultInt.CRIJAFIEA {
		
		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIJ2(//
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
	interface CRIJ2FIEX extends CallableResultInt.CRIJAFIEX {
		
		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callIJ2(//
					instance,
					arguments.baseGetFirst(BaseObject.UNDEFINED),
					arguments.baseGet(1, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FIJ0 extends CallableResultInt.CRIJ0FIJ0 {
		
		@Override
		@ReflectionHidden
		default int callIJ0(final BaseObject instance) {
			
			return this.callIJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FIJ1 extends CallableResultInt.CRIJ1FIJ1 {
		
		@Override
		@ReflectionHidden
		default int callIJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callIJ2(instance, argument, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FIJ2 extends CallableResultInt.CRIAAFIAA {
		
		@Override
		@ReflectionHidden
		int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2);
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FIJA extends CallableResultInt.CRIJAFIJA {
		
		@Override
		@ReflectionHidden
		default int callIJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIJ2(//
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
	interface CRIJ2FLE0 extends CallableResultInt.CRIJ0FLE0 {
		
		@Override
		@ReflectionHidden
		default long callLE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callIJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FLE1 extends CallableResultInt.CRIJ1FLE1 {
		
		@Override
		@ReflectionHidden
		default long callLE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callIJ2(instance, argument, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FLE2 extends CallableResultInt.CRIE2FLE2 {
		
		@Override
		@ReflectionHidden
		default long callLE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIJ2(instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FLEA extends CallableResultInt.CRIJAFLEA {
		
		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIJ2(//
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
	interface CRIJ2FLEX extends CallableResultInt.CRIJAFLEX {
		
		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callIJ2(//
					instance,
					arguments.baseGetFirst(BaseObject.UNDEFINED),
					arguments.baseGet(1, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FLJ0 extends CallableResultInt.CRIJ0FLJ0 {
		
		@Override
		@ReflectionHidden
		default long callLJ0(final BaseObject instance) {
			
			return this.callIJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FLJ1 extends CallableResultInt.CRIJ1FLJ1 {
		
		@Override
		@ReflectionHidden
		default long callLJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callIJ2(instance, argument, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FLJ2 extends CallableResultInt.CRIAAFLAA {
		
		@Override
		@ReflectionHidden
		default long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callIJ2(instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FLJA extends CallableResultInt.CRIJAFLJA {
		
		@Override
		@ReflectionHidden
		default long callLJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIJ2(//
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
	interface CRIJ2FNE0 extends CallableResultInt.CRIJ0FNE0 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {
			
			return Base.forInteger(this.callIJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FNE1 extends CallableResultInt.CRIJ1FNE1 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return Base.forInteger(this.callIJ2(instance, argument, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FNE2 extends CallableResultInt.CRIE2FNE2 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.forInteger(this.callIJ2(instance, argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FNEA extends CallableResultInt.CRIJAFNEA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return Base.forInteger(this.callIJ2(//
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED,
					arguments.length > 1
						? arguments[1]
						: BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FNEX extends CallableResultInt.CRIJAFNEX {
		
		@Override
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return Base.forInteger(this.callIJ2(//
					instance,
					arguments.baseGetFirst(BaseObject.UNDEFINED),
					arguments.baseGet(1, BaseObject.UNDEFINED)));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FNJ0 extends CallableResultInt.CRIJ0FNJ0 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJ0(final BaseObject instance) {
			
			return Base.forInteger(this.callIJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FNJ1 extends CallableResultInt.CRIJ1FNJ1 {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJ1(final BaseObject instance, final BaseObject argument) {
			
			return Base.forInteger(this.callIJ2(instance, argument, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FNJ2 extends CallableResultInt.CRIAAFNAA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.forInteger(this.callIJ2(instance, argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FNJA extends CallableResultInt.CRIJAFNJA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJA(final BaseObject instance, final BaseObject... arguments) {
			
			return Base.forInteger(this.callIJ2(//
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED,
					arguments.length > 1
						? arguments[1]
						: BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FSE0 extends CallableResultInt.CRIJ0FSE0 {
		
		@Override
		@ReflectionHidden
		default String callSE0(final ExecProcess ctx, final BaseObject instance) {
			
			return Base.toString(this.callIJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FSE1 extends CallableResultInt.CRIJ1FSE1 {
		
		@Override
		@ReflectionHidden
		default String callSE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return Base.toString(this.callIJ2(instance, argument, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FSE2 extends CallableResultInt.CRIE2FSE2 {
		
		@Override
		@ReflectionHidden
		default String callSE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.toString(this.callIJ2(instance, argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FSEA extends CallableResultInt.CRIJAFSEA {
		
		@Override
		@ReflectionHidden
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return Base.toString(this.callIJ2(//
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED,
					arguments.length > 1
						? arguments[1]
						: BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FSEX extends CallableResultInt.CRIJAFSEX {
		
		@Override
		@ReflectionHidden
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return Base.toString(this.callIJ2(//
					instance,
					arguments.baseGetFirst(BaseObject.UNDEFINED),
					arguments.baseGet(1, BaseObject.UNDEFINED)));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FSJ0 extends CallableResultInt.CRIJ0FSJ0 {
		
		@Override
		@ReflectionHidden
		default String callSJ0(final BaseObject instance) {
			
			return Base.toString(this.callIJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FSJ1 extends CallableResultInt.CRIJ1FSJ1 {
		
		@Override
		@ReflectionHidden
		default String callSJ1(final BaseObject instance, final BaseObject argument) {
			
			return Base.toString(this.callIJ2(instance, argument, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FSJ2 extends CallableResultInt.CRIAAFSAA {
		
		@Override
		default String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return Base.toString(this.callIJ2(instance, argument1, argument2));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FSJA extends CallableResultInt.CRIJAFSJA {
		
		@Override
		@ReflectionHidden
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {
			
			return Base.toString(this.callIJ2(//
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED,
					arguments.length > 1
						? arguments[1]
						: BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FVE0 extends CallableResultInt.CRIJ0FVE0 {
		
		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {
			
			this.callIJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FVE1 extends CallableResultInt.CRIJ1FVE1 {
		
		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			this.callIJ2(instance, argument, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FVE2 extends CallableResultInt.CRIE2FVE2 {
		
		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callIJ2(instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FVEA extends CallableResultInt.CRIJAFVEA {
		
		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			this.callIJ2(//
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
	interface CRIJ2FVEX extends CallableResultInt.CRIJAFVEX {
		
		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			this.callIJ2(//
					instance,
					arguments.baseGetFirst(BaseObject.UNDEFINED),
					arguments.baseGet(1, BaseObject.UNDEFINED));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FVJ0 extends CallableResultInt.CRIJ0FVJ0 {
		
		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {
			
			this.callIJ2(instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FVJ1 extends CallableResultInt.CRIJ1FVJ1 {
		
		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {
			
			this.callIJ2(instance, argument, BaseObject.UNDEFINED);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FVJ2 extends CallableResultInt.CRIAAFVAA {
		
		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callIJ2(instance, argument1, argument2);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJ2FVJA extends CallableResultInt.CRIJAFVJA {
		
		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {
			
			this.callIJ2(//
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
	interface CRIJAFDEA extends CallableResultInt.CRIEAFDEA {
		
		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIJA(instance, arguments)//
			;
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJAFDEX extends CallableResultInt.CRIEXFDEX {
		
		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callIEA(ctx, instance, arguments.toArrayBase())//
			;
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJAFDJA extends CallableResultInt.CRIAAFDAA {
		
		@Override
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIJA(instance, arguments)//
			;
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJAFEEX extends CallableResultInt.CRIEXFEEX {
		
		@Override
		@ReflectionHidden
		default ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline, final BaseArray arguments) {
			
			return store.execReturnNumeric(ctx, this.callIJA(instance, arguments.toArrayBase()));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJAFIEA extends CallableResultInt.CRIEAFIEA {
		
		@Override
		@ReflectionHidden
		default int callIEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIJA(instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJAFIEX extends CallableResultInt.CRIEXFIEX {
		
		@Override
		@ReflectionHidden
		default int callIEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callIJA(instance, arguments.toArrayBase());
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJAFIJA extends CallableResultInt.CRIAAFIAA {
		
		@Override
		@ReflectionHidden
		int callIJA(final BaseObject instance, final BaseObject... arguments);

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJAFLEA extends CallableResultInt.CRIE0FLEA {
		
		@Override
		@ReflectionHidden
		default long callLEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIJA(instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJAFLEX extends CallableResultInt.CRIEXFLEX {
		
		@Override
		@ReflectionHidden
		default long callLEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callIJA(instance, arguments.toArrayBase());
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJAFLJA extends CallableResultInt.CRIAAFLAA {
		
		@Override
		@ReflectionHidden
		default long callLJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callIJA(instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJAFNEA extends CallableResultInt.CRIEAFNEA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return Base.forInteger(this.callIJA(instance, arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJAFNEX extends CallableResultInt.CRIEXFNEX {
		
		@Override
		@ReflectionHidden
		default BaseObject callNEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return Base.forInteger(this.callIJA(instance, arguments.toArrayBase()));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJAFNJA extends CallableResultInt.CRIAAFNAA {
		
		@Override
		@ReflectionHidden
		default BaseObject callNJA(final BaseObject instance, final BaseObject... arguments) {
			
			return Base.forInteger(this.callIJA(instance, arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJAFSEA extends CallableResultInt.CRIEAFSEA {
		
		@Override
		@ReflectionHidden
		default String callSEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return Base.toString(this.callIJA(instance, arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJAFSEX extends CallableResultInt.CRIEXFSEX {
		
		@Override
		@ReflectionHidden
		default String callSEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return Base.toString(this.callIJA(instance, arguments.toArrayBase()));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJAFSJA extends CallableResultInt.CRIAAFSAA {
		
		@Override
		default String callSJA(final BaseObject instance, final BaseObject... arguments) {
			
			return Base.toString(this.callIJA(instance, arguments));
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJAFVEA extends CallableResultInt.CRIEAFVEA {
		
		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			this.callIJA(instance, arguments);
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJAFVEX extends CallableResultInt.CRIEXFVEX {
		
		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			this.callIJA(instance, arguments.toArrayBase());
		}

	}

	/** @author myx */
	@ReflectionDisable
	interface CRIJAFVJA extends CallableResultInt.CRIAAFVAA {
		
		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {
			
			this.callIJA(instance, arguments);
		}

	}

}
