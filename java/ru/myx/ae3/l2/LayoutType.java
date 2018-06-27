package ru.myx.ae3.l2;

/**
 * @author myx
 * 
 */
public enum LayoutType {
	/**
	 * 
	 */
	PRIVATE {
		@Override
		public String getShortName() {
		
			return "prv";
		}
	},
	/**
	 * 
	 */
	GEOMETRY {
		@Override
		public String getShortName() {
		
			return "geo";
		}
	},
	/**
	 * 
	 */
	INTERACTION {
		@Override
		public String getShortName() {
		
			return "int";
		}
	},
	/**
	 * 
	 */
	LOGICAL {
		@Override
		public String getShortName() {
		
			return "log";
		}
	},
	/**
	 * 
	 */
	APPLICATION {
		@Override
		public String getShortName() {
		
			return "app";
		}
	},
	/**
	 * 
	 */
	PERSISTENT {
		@Override
		public String getShortName() {
		
			return "str";
		}
	};
	/**
	 * Returns layout's short name used in short layout aliases.
	 * 
	 * 
	 * @return
	 */
	public abstract String getShortName();
}
