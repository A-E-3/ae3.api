package ru.myx.ae3.exec;

import ru.myx.ae3.base.BaseArray;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/** @author myx */
@ReflectionDisable
interface CallableResultDouble {
	
	interface CRDAAFAAA extends ExecCallable {
		//
	}

	/** @author myx */
	@ReflectionDisable
	interface CRDE0FDE1 extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callDE0(ctx, instance);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDE0FDE2 extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callDE0(ctx, instance);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDE0FDEA extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callDE0(ctx, instance);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDE0FDEX extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callDE0(ctx, instance);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDE0FDJ0 extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDJ0(final BaseObject instance) {
			
			return this.callDE0(Exec.currentProcess(), instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRDE0FDJ1 extends CallableResultDouble.CRDE1FDJ1 {
		
		@Override
		@ReflectionHidden
		default double callDJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callDE0(Exec.currentProcess(), instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRDE0FDJ2 extends CallableResultDouble.CRDE2FDJ2 {
		
		@Override
		@ReflectionHidden
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callDE0(Exec.currentProcess(), instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRDE0FDJA extends CallableResultDouble.CRDEAFDJA {
		
		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callDE0(Exec.currentProcess(), instance);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDE1FDE0 extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callDE1(ctx, instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRDE1FDE2 extends CallableResultDouble.CRDEAFDJA {
		
		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callDE1(ctx, instance, argument1);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDE1FDEA extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callDE1(ctx, instance, arguments.length > 0
				? arguments[0]
				: BaseObject.UNDEFINED);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDE1FDEX extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callDE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDE1FDJ0 extends CallableResultDouble.CRDE0FDJ0 {
		
		@Override
		@ReflectionHidden
		default double callDJ0(final BaseObject instance) {
			
			return this.callDE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDE1FDJ1 extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callDE1(Exec.currentProcess(), instance, argument);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDE1FDJ2 extends CallableResultDouble.CRDE2FDJ2 {
		
		@Override
		@ReflectionHidden
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callDE1(Exec.currentProcess(), instance, argument1);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDE1FDJA extends CallableResultDouble.CRDEAFDJA {
		
		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callDE1(Exec.currentProcess(), instance, arguments.length > 0
				? arguments[0]
				: BaseObject.UNDEFINED);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDE2FDE0 extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callDE2(ctx, instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDE2FDE1 extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callDE2(ctx, instance, argument, BaseObject.UNDEFINED);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDE2FDEA extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callDE2(
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
	interface CRDE2FDEX extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callDE2(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED), arguments.baseGet(1, BaseObject.UNDEFINED));
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDE2FDJ0 extends CallableResultDouble.CRDE0FDJ0 {
		
		@Override
		@ReflectionHidden
		default double callDJ0(final BaseObject instance) {
			
			return this.callDE2(Exec.currentProcess(), instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDE2FDJ1 extends CallableResultDouble.CRDE1FDJ1 {
		
		@Override
		@ReflectionHidden
		default double callDJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callDE2(Exec.currentProcess(), instance, argument, BaseObject.UNDEFINED);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDE2FDJ2 extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callDE2(Exec.currentProcess(), instance, argument1, argument2);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDE2FDJA extends CallableResultDouble.CRDEAFDJA {
		
		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callDE2(//
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
	interface CRDEAFDJA extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callDEA(Exec.currentProcess(), instance, arguments);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRDEXFDE0 extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callDEX(ctx, instance, ctx.argumentsEmpty());
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDEXFDE1 extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callDEX(ctx, instance, ctx.argumentsList1(argument));
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDEXFDE2 extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callDEX(ctx, instance, ctx.argumentsList2(argument1, argument2));
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDEXFDEA extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callDEX(ctx, instance, ctx.argumentsListA(arguments));
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDEXFDJ0 extends CallableResultDouble.CRDE0FDJ0 {
		
		@Override
		@ReflectionHidden
		default double callDJ0(final BaseObject instance) {
			
			final ExecProcess ctx = Exec.currentProcess();
			return this.callDEX(ctx, instance, ctx.argumentsEmpty());
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDEXFDJ1 extends CallableResultDouble.CRDE1FDJ1 {
		
		@Override
		@ReflectionHidden
		default double callDJ1(final BaseObject instance, final BaseObject argument) {
			
			final ExecProcess ctx = Exec.currentProcess();
			return this.callDEX(ctx, instance, ctx.argumentsList1(argument));
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDEXFDJ2 extends CallableResultDouble.CRDE2FDJ2 {
		
		@Override
		@ReflectionHidden
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final ExecProcess ctx = Exec.currentProcess();
			return this.callDEX(ctx, instance, ctx.argumentsList2(argument1, argument2));
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDEXFDJA extends CallableResultDouble.CRDEAFDJA {
		
		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {
			
			final ExecProcess ctx = Exec.currentProcess();
			return this.callDEX(ctx, instance, ctx.argumentsListA(arguments));
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDJ0FDE0 extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callDJ0(instance);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDJ0FDE1 extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callDJ0(instance);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDJ0FDE2 extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callDJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRDJ0FDEA extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callDJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRDJ0FDEX extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callDJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRDJ0FDJ1 extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDJ1(final BaseObject instance, final BaseObject argument) {
			
			return this.callDJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRDJ0FDJ2 extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callDJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRDJ0FDJA extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {
			
			return this.callDJ0(instance);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRDJ1FDE0 extends CallableResultDouble.CRDJ0FDE0 {
		
		@Override
		@ReflectionHidden
		default double callDE0(final ExecProcess ctx, final BaseObject instance) {
			
			return this.callDJ1(instance, BaseObject.UNDEFINED);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRDJ1FDE1 extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			return this.callDJ1(instance, argument);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRDJ1FDE2 extends CallableResultDouble.CRDJ2FDE2 {
		
		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callDJ1(instance, argument1);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRDJ1FDEA extends CallableResultDouble.CRDJAFDEA {
		
		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			switch (arguments.length) {
				case 0 :
					return this.callDJ1(instance, BaseObject.UNDEFINED);
				default :
					return this.callDJ1(instance, arguments[0]);
			}
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRDJ1FDEX extends CallableResultDouble.CRDJAFDEX {
		
		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callDJ1(instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRDJ1FDJ0 extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDJ0(final BaseObject instance) {
			
			return this.callDJ1(instance, BaseObject.UNDEFINED);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDJ1FDJ2 extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callDJ1(instance, argument1);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDJ1FDJA extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDJA(final BaseObject instance, final BaseObject... arguments) {
			
			switch (arguments.length) {
				case 0 :
					return this.callDJ1(instance, BaseObject.UNDEFINED);
				default :
					return this.callDJ1(instance, arguments[0]);
			}
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRDJ2FDE2 extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			return this.callDJ2(instance, argument1, argument2);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRDJAFDEA extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			return this.callDJA(instance, arguments);
		}
	}

	/** @author myx */
	@ReflectionDisable
	interface CRDJAFDEX extends CallableResultDouble.CRDAAFAAA {
		
		@Override
		@ReflectionHidden
		default double callDEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			return this.callDJA(instance, arguments.toArrayBase());
		}
	}
	
}
