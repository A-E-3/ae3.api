package ru.myx.ae3.exec;



import ru.myx.ae3.reflect.ReflectionDisable;

/**
 *
 * @author myx
 *
 */
public abstract class ResultHandlerBasic implements ResultHandler {
	
	
	/**
	 *
	 * @author myx
	 *
	 */
	@ReflectionDisable
	public interface ExecutionContinue extends ExecutionReflected {
		
		
		/**
		 *
		 * @return true
		 */
		@Override
		default boolean isExecutionNext() {
			
			
			return true;
		}
		
		/**
		 *
		 * @return new handler or NULL if there are no side effects pending (NN)
		 *
		 * @throws IllegalStateException
		 */
			default ResultHandlerBasic replaceEffectsOnly() {
			
			
			throw new IllegalStateException(this + " doesn't not support OUTPUT");
		}
	}

	/**
	 *
	 * @author myx
	 *
	 */
	@ReflectionDisable
	public interface ExecutionControl extends ExecutionReflected {
		
		
		/**
		 *
		 * @return false
		 */
		@Override
		default boolean isExecutionNext() {
			
			
			return false;
		}
	}

	/**
	 *
	 * @author myx
	 *
	 */
	@ReflectionDisable
	public interface ExecutionReflected extends ResultHandler {
		
		
		/**
		 *
		 * @return false
		 */
		boolean isExecutionNext();
	}

	/**
	 *
	 * @return
	 */
	public abstract boolean isOutput();
	
	@Override
	public abstract boolean isStackPush();
	
	/**
	 *
	 * @return
	 */
	public abstract boolean isWithEffects();
	
	/**
	 *
	 * @return new handler or NULL if can't add an OUTPUT to given handler (has
	 *         output already)
	 *
	 * @throws IllegalStateException
	 */
	public ResultHandlerBasic replaceDoOutput() throws IllegalStateException {
		
		
		throw new IllegalStateException(this + " doesn't not support OUTPUT");
	}
	
	@Override
	public final String toString() {
		
		
		return this.getClass().getSimpleName();
	}
	
}
