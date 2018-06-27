package ru.myx.ae3.exec;

/**
 *
 * @author myx
 *
 */
public enum ExecResultVisibility {
	/**
	 * Direct / Once / Temp
	 *
	 * Default, but it will be detached on vmGetResultNative and
	 * vmGetResultDetachable
	 */
	RVT_VM_DIRECT {
		
		
		@Override
		ResultHandler toExitHandler() {
			
			
			return ResultHandler.FT_BNN_NXT;
		}
		
	},
	
	/**
	 * Stack / Detachable / VM Local
	 *
	 * Non-reused. vmGetResultDetachable() returns detach-able values like this.
	 */
	RVT_VM_STACK {
		
		
		@Override
		ResultHandler toExitHandler() {
			
			
			return ResultHandler.FS_BNN_NXT;
		}
		
	},
	
	/**
	 * Native / Memory / Public
	 *
	 * Native values. vmGetResultNative() returns native values like this.
	 */
	RVT_PUBLIC {
		
		
		@Override
		ResultHandler toExitHandler() {
			
			
			return EFA_BNN_NXT.INSTANCE;
		}
		
	},
	
	/**
	 * Result Value is Unused.
	 *
	 * Ignore value.
	 */
	RVT_UNUSED {
		
		
		@Override
		ResultHandler toExitHandler() {
			
			
			return EFU_BNN_NXT.INSTANCE;
		}
		
	},;
	
	abstract ResultHandler toExitHandler();
}
