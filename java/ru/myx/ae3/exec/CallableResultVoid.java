package ru.myx.ae3.exec;

import ru.myx.ae3.base.BaseArray;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/** @author myx */
@ReflectionDisable
interface CallableResultVoid {
	
	/** @author myx */
	@ReflectionDisable
	interface CRVAAFAAA extends ExecCallable {
		//
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVE0FVE1 extends CallableResultVoid.CRVAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			this.callVE0(ctx, instance);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVE0FVE2 extends CallableResultVoid.CRVAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callVE0(ctx, instance);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVE0FVEA extends CallableResultVoid.CRVAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			this.callVE0(ctx, instance);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVE0FVEX extends CallableResultVoid.CRVAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			this.callVE0(ctx, instance);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVE0FVJ0 extends CallableResultVoid.CRVAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {
			
			this.callVE0(Exec.currentProcess(), instance);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVE0FVJ1 extends CallableResultVoid.CRVE1FVJ1 {
		
		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {
			
			this.callVE0(Exec.currentProcess(), instance);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVE0FVJ2 extends CallableResultVoid.CRVE2FVJ2 {
		
		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callVE0(Exec.currentProcess(), instance);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVE0FVJA extends CallableResultVoid.CRVEAFVJA {
		
		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {
			
			this.callVE0(Exec.currentProcess(), instance);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVE1FVE0 extends CallableResultVoid.CRVAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {
			
			this.callVE1(ctx, instance, BaseObject.UNDEFINED);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVE1FVE2 extends CallableResultVoid.CRVAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callVE1(ctx, instance, argument1);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVE1FVEA extends CallableResultVoid.CRVAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			this.callVE1(
					ctx,
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVE1FVEX extends CallableResultVoid.CRVAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			this.callVE1(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED));
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVE1FVJ0 extends CallableResultVoid.CRVE0FVJ0 {
		
		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {
			
			this.callVE1(Exec.currentProcess(), instance, BaseObject.UNDEFINED);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVE1FVJ1 extends CallableResultVoid.CRVAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {
			
			this.callVE1(Exec.currentProcess(), instance, argument);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVE1FVJ2 extends CallableResultVoid.CRVE2FVJ2 {
		
		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callVE1(Exec.currentProcess(), instance, argument1);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVE1FVJA extends CallableResultVoid.CRVEAFVJA {
		
		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {
			
			this.callVE1(
					Exec.currentProcess(),
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVE2FVE0 extends CallableResultVoid.CRVAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {
			
			this.callVE2(ctx, instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVE2FVE1 extends CallableResultVoid.CRVAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			this.callVE2(ctx, instance, argument, BaseObject.UNDEFINED);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVE2FVEA extends CallableResultVoid.CRVAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			this.callVE2(
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
	interface CRVE2FVEX extends CallableResultVoid.CRVAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVEX(final ExecProcess ctx, final BaseObject instance, final BaseArray arguments) {
			
			this.callVE2(ctx, instance, arguments.baseGetFirst(BaseObject.UNDEFINED), arguments.baseGet(1, BaseObject.UNDEFINED));
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVE2FVJ0 extends CallableResultVoid.CRVE0FVJ0 {
		
		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {
			
			this.callVE2(Exec.currentProcess(), instance, BaseObject.UNDEFINED, BaseObject.UNDEFINED);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVE2FVJ1 extends CallableResultVoid.CRVE1FVJ1 {
		
		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {
			
			this.callVE2(Exec.currentProcess(), instance, argument, BaseObject.UNDEFINED);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVE2FVJ2 extends CallableResultVoid.CRVAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callVE2(Exec.currentProcess(), instance, argument1, argument2);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVE2FVJA extends CallableResultVoid.CRVEAFVJA {
		
		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {
			
			this.callVE2(
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
	interface CRVEAFVJA extends CallableResultVoid.CRVAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {
			
			this.callVEA(Exec.currentProcess(), instance, arguments);
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVEXFVE0 extends CallableResultVoid.CRVAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVE0(final ExecProcess ctx, final BaseObject instance) {
			
			this.callVEX(ctx, instance, ctx.argumentsEmpty());
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVEXFVE1 extends CallableResultVoid.CRVAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {
			
			this.callVEX(ctx, instance, ctx.argumentsList1(argument));
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVEXFVE2 extends CallableResultVoid.CRVAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			this.callVEX(ctx, instance, ctx.argumentsList2(argument1, argument2));
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVEXFVEA extends CallableResultVoid.CRVAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {
			
			this.callVEX(ctx, instance, ctx.argumentsListA(arguments));
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVEXFVJ0 extends CallableResultVoid.CRVE0FVJ0 {
		
		@Override
		@ReflectionHidden
		default void callVJ0(final BaseObject instance) {
			
			final ExecProcess ctx = Exec.currentProcess();
			this.callVEX(ctx, instance, ctx.argumentsEmpty());
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVEXFVJ1 extends CallableResultVoid.CRVE0FVJ1 {
		
		@Override
		@ReflectionHidden
		default void callVJ1(final BaseObject instance, final BaseObject argument) {
			
			final ExecProcess ctx = Exec.currentProcess();
			this.callVEX(ctx, instance, ctx.argumentsList1(argument));
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVEXFVJ2 extends CallableResultVoid.CRVE0FVJ2 {
		
		@Override
		@ReflectionHidden
		default void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {
			
			final ExecProcess ctx = Exec.currentProcess();
			this.callVEX(ctx, instance, ctx.argumentsList2(argument1, argument2));
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVEXFVJA extends CallableResultVoid.CRVE0FVJA {
		
		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {
			
			final ExecProcess ctx = Exec.currentProcess();
			this.callVEX(ctx, instance, ctx.argumentsListA(arguments));
		}
	}
	
	/** @author myx */
	@ReflectionDisable
	interface CRVJ1FVJA extends CallableResultVoid.CRVAAFAAA {
		
		@Override
		@ReflectionHidden
		default void callVJA(final BaseObject instance, final BaseObject... arguments) {
			
			this.callVJ1(
					instance,
					arguments.length > 0
						? arguments[0]
						: BaseObject.UNDEFINED);
		}
	}
}
