/*
 * Created on 12.05.2006
 */
package ru.myx.ae3.exec;

/**
 * @author myx
 * 
 */
public enum ExecStateCode {
	/**
	 * 000
	 */
	RETURN {
		
		
		@Override
		public final ExecStateCode execute(final ExecProcess ctx) {
			
			
			return this;
		}
		
		@Override
		public final boolean isExecutionExit() {
			
			
			return true;
		}
		
		@Override
		public final boolean isExecutionNext() {
			
			
			return false;
		}
		
		@Override
		public final boolean isValidForCall() {
			
			
			return false;
		}
		
		@Override
		public final String toShortNotation() {
			
			
			return "RET";
		}
		
	},
	/**
	 * 001
	 */
	NEXT {
		
		
		@Override
		public ExecStateCode execute(final ExecProcess ctx) {
			
			
			return null;
		}
		
		@Override
		public boolean isExecutionExit() {
			
			
			return false;
		}
		
		@Override
		public boolean isExecutionNext() {
			
			
			return true;
		}
		
		@Override
		public boolean isValidForCall() {
			
			
			/**
			 * MUST RETURN NULL instead of NEXT
			 */
			return false;
		}
		
		@Override
		public final String toShortNotation() {
			
			
			return "NXT";
		}
		
	},
	/**
	 * 010
	 */
	BREAK {
		
		
		@Override
		public ExecStateCode execute(final ExecProcess ctx) {
			
			
			final int rCBT = ctx.ri0CBT;
			if (rCBT != -1) {
				ctx.ri08IP = rCBT - 1;
				return null;
			}
			return this;
		}
		
		@Override
		public boolean isExecutionExit() {
			
			
			return false;
		}
		
		@Override
		public boolean isExecutionNext() {
			
			
			return false;
		}
		
		@Override
		public boolean isValidForCall() {
			
			
			return false;
		}
		
		@Override
		public final String toShortNotation() {
			
			
			return "BRK";
		}
	},
	/**
	 * 011
	 */
	CONTINUE {
		
		
		@Override
		public ExecStateCode execute(final ExecProcess ctx) {
			
			
			final int rDCT = ctx.ri0DCT;
			if (rDCT != -1) {
				ctx.ri08IP = rDCT - 1;
				return null;
			}
			return this;
		}
		
		@Override
		public boolean isExecutionExit() {
			
			
			return false;
		}
		
		@Override
		public boolean isExecutionNext() {
			
			
			return false;
		}
		
		@Override
		public boolean isValidForCall() {
			
			
			return false;
		}
		
		@Override
		public final String toShortNotation() {
			
			
			return "CTN";
		}
	},
	/**
	 * 100 ?
	 */
	CALL {
		
		
		@Override
		public ExecStateCode execute(final ExecProcess ctx) {
			
			
			return this;
		}
		
		@Override
		public boolean isExecutionExit() {
			
			
			return false;
		}
		
		@Override
		public boolean isExecutionNext() {
			
			
			return true;
		}
		
		@Override
		public boolean isValidForCall() {
			
			
			return true;
		}
		
		@Override
		public final String toShortNotation() {
			
			
			return "CLL";
		}
	},
	/**
	 * 101
	 */
	RESERVED_101 {
		
		
		@Override
		public ExecStateCode execute(final ExecProcess ctx) {
			
			
			return ctx.vmRaise("state code 101 is reserved!");
		}
		
		@Override
		public boolean isExecutionExit() {
			
			
			return true;
		}
		
		@Override
		public boolean isExecutionNext() {
			
			
			return false;
		}
		
		@Override
		public boolean isValidForCall() {
			
			
			return false;
		}
		
		@Override
		public final String toShortNotation() {
			
			
			return "101";
		}
	},
	/**
	 * 110
	 */
	REPEAT {
		
		
		@Override
		public ExecStateCode execute(final ExecProcess ctx) {
			
			
			return this;
		}
		
		@Override
		public boolean isExecutionExit() {
			
			
			return true;
		}
		
		@Override
		public boolean isExecutionNext() {
			
			
			return false;
		}
		
		@Override
		public boolean isValidForCall() {
			
			
			return true;
		}
		
		@Override
		public final String toShortNotation() {
			
			
			return "RPT";
		}
	},
	/**
	 * 111
	 */
	ERROR {
		
		
		@Override
		public ExecStateCode execute(final ExecProcess ctx) {
			
			
			return this;
		}
		
		@Override
		public boolean isExecutionExit() {
			
			
			return true;
		}
		
		@Override
		public boolean isExecutionNext() {
			
			
			return false;
		}
		
		@Override
		public boolean isValidForCall() {
			
			
			return true;
		}
		
		@Override
		public final String toShortNotation() {
			
			
			return "ERR";
		}
	},
	
	/**
	 * 
	 */
	;
	
	private static final ExecStateCode[] ALL = ExecStateCode.values();
	
	/**
	 * 
	 * @param state
	 * @return NON null
	 */
	public static final ExecStateCode instance(final ExecStateCode state) {
		
		
		return state == null
			? NEXT
			: state;
	}
	
	/**
	 * @return
	 */
	public static final int valueCount() {
		
		
		return ExecStateCode.ALL.length;
	}
	
	/**
	 * @param index
	 * @return
	 */
	public static final ExecStateCode valueForIndex(final int index) {
		
		
		return ExecStateCode.ALL[index];
	}
	
	/**
	 * 
	 * @return
	 */
	public abstract String toShortNotation();
	
	/**
	 * @param ctx
	 * @return null if done in-line or this when should be handled by VM
	 */
	public abstract ExecStateCode execute(final ExecProcess ctx);
	
	/**
	 * 
	 * @return
	 */
	public abstract boolean isExecutionExit();
	
	/**
	 * 
	 * @return
	 */
	public abstract boolean isExecutionNext();
	
	/**
	 * Return's true for valid exit state codes for function calls by
	 * context.vmCall method
	 * 
	 * To use invalid return codes function should implement ExecFunctionUnsafe
	 * interface.
	 * 
	 * @return
	 */
	public abstract boolean isValidForCall();
}
