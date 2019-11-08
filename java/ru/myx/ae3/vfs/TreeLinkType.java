package ru.myx.ae3.vfs;

/** @author myx Legend:<br>
 *         <li>B - blocks garbage collection</li>
 *         <li>N - share with neighbours????</li>
 *         <li>C - send in default contents</li>
 *         <li>S - indexed for and used in search</li> */
public enum TreeLinkType {
	/** methods: evaluateField<br>
	 * <li>B N C S</li>
	 * <li>- - - -</li> */
	NO_REFERENCE {
		
		@Override
		public boolean allowsSearchIndexing() {
			
			return false;
		}
		
		@Override
		public boolean blocksGarbageCollection() {
			
			return false;
		}
		
		@Override
		public boolean isHidden() {
			
			return true;
		}
		
		@Override
		public boolean sentOutsideInDefaultQuery() {
			
			return false;
		}
		
		@Override
		public boolean sentOutsideInExactQuery() {
			
			return false;
		}
		
		@Override
		public String toString() {
			
			return "NON-REF";
		}
	},
	/** methods: evaluateField<br>
	 * <li>B N C S</li>
	 * <li>- - - -</li>
	 *
	 * vfsMixed can write to %private%/cache */
	CACHE_REFERENCE {
		
		@Override
		public boolean allowsSearchIndexing() {
			
			return false;
		}
		
		@Override
		public boolean blocksGarbageCollection() {
			
			return false;
		}
		
		@Override
		public boolean isHidden() {
			
			return true;
		}
		
		@Override
		public boolean sentOutsideInDefaultQuery() {
			
			return false;
		}
		
		@Override
		public boolean sentOutsideInExactQuery() {
			
			return false;
		}
		
		@Override
		public String toString() {
			
			return "TMP-REF";
		}
	},
	/** methods: evaluateField<br>
	 * <li>B N C S</li>
	 * <li>- + - -</li>
	 *
	 * vfsMixed can write to %private%/cache */
	PRODUCT_REFERENCE {
		
		@Override
		public boolean allowsSearchIndexing() {
			
			return false;
		}
		
		@Override
		public boolean blocksGarbageCollection() {
			
			return false;
		}
		
		@Override
		public boolean isHidden() {
			
			return true;
		}
		
		@Override
		public boolean sentOutsideInDefaultQuery() {
			
			return false;
		}
		
		@Override
		public boolean sentOutsideInExactQuery() {
			
			return true;
		}
		
		@Override
		public String toString() {
			
			return "PRD-REF";
		}
	},
	/** methods: evaluateField<br>
	 * <li>B N C S</li>
	 * <li>+ + - -</li>
	 *
	 * vfsMixed can write to %private%/data */
	LOCAL_PRIVATE_REFERENCE {
		
		@Override
		public boolean allowsSearchIndexing() {
			
			return false;
		}
		
		@Override
		public boolean blocksGarbageCollection() {
			
			return true;
		}
		
		@Override
		public boolean isHidden() {
			
			return false;
		}
		
		@Override
		public boolean sentOutsideInDefaultQuery() {
			
			return false;
		}
		
		@Override
		public boolean sentOutsideInExactQuery() {
			
			return false;
		}
		
		@Override
		public String toString() {
			
			return "LCL-PRV";
		}
	},
	/** methods: evaluateField<br>
	 * <li>B N C S</li>
	 * <li>+ + - -</li> */
	HIDDEN_FIELD_REFERENCE {
		
		@Override
		public boolean allowsSearchIndexing() {
			
			return false;
		}
		
		@Override
		public boolean blocksGarbageCollection() {
			
			return true;
		}
		
		@Override
		public boolean isHidden() {
			
			return true;
		}
		
		@Override
		public boolean sentOutsideInDefaultQuery() {
			
			return false;
		}
		
		@Override
		public boolean sentOutsideInExactQuery() {
			
			return true;
		}
		
		@Override
		public String toString() {
			
			return "HDN-FLD";
		}
	},
	/** methods: evaluateField / getChildByName<br>
	 * <li>B N C S</li>
	 * <li>+ + - -</li> */
	HIDDEN_TREE_REFERENCE {
		
		@Override
		public boolean allowsSearchIndexing() {
			
			return false;
		}
		
		@Override
		public boolean blocksGarbageCollection() {
			
			return true;
		}
		
		@Override
		public boolean isHidden() {
			
			return true;
		}
		
		@Override
		public boolean sentOutsideInDefaultQuery() {
			
			return false;
		}
		
		@Override
		public boolean sentOutsideInExactQuery() {
			
			return true;
		}
		
		@Override
		public String toString() {
			
			return "HDN-TRE";
		}
	},
	/** methods: evaluateField<br>
	 * <li>B N C S</li>
	 * <li>+ + + +</li> */
	PUBLIC_FIELD_REFERENCE {
		
		@Override
		public boolean allowsSearchIndexing() {
			
			return true;
		}
		
		@Override
		public boolean blocksGarbageCollection() {
			
			return true;
		}
		
		@Override
		public boolean isHidden() {
			
			return false;
		}
		
		@Override
		public boolean sentOutsideInDefaultQuery() {
			
			return true;
		}
		
		@Override
		public boolean sentOutsideInExactQuery() {
			
			return true;
		}
		
		@Override
		public String toString() {
			
			return "PUB-FLD";
		}
	},
	/** methods: evaluateField / getChildren / getChildByName<br>
	 * <li>B N C S</li>
	 * <li>+ + + +</li> */
	PUBLIC_TREE_REFERENCE {
		
		@Override
		public boolean allowsSearchIndexing() {
			
			return true;
		}
		
		@Override
		public boolean blocksGarbageCollection() {
			
			return true;
		}
		
		@Override
		public boolean isHidden() {
			
			return false;
		}
		
		@Override
		public boolean sentOutsideInDefaultQuery() {
			
			return true;
		}
		
		@Override
		public boolean sentOutsideInExactQuery() {
			
			return true;
		}
		
		@Override
		public String toString() {
			
			return "PUB-TRE";
		}
	},;
	
	private static final TreeLinkType[] ALL = TreeLinkType.values();
	
	static TreeLinkType resolve(final boolean field, final boolean index) {
		
		if (index) {
			if (field) {
				return TreeLinkType.PUBLIC_FIELD_REFERENCE;
			}
			return TreeLinkType.PUBLIC_TREE_REFERENCE;
		}
		{
			if (field) {
				return TreeLinkType.HIDDEN_FIELD_REFERENCE;
			}
			return TreeLinkType.HIDDEN_TREE_REFERENCE;
		}
	}
	
	/** @return */
	public static final int valueCount() {
		
		return TreeLinkType.ALL.length;
	}
	
	/** @param index
	 * @return */
	public static final TreeLinkType valueForIndex(final int index) {
		
		return TreeLinkType.ALL[index];
	}
	
	/** @return */
	public abstract boolean allowsSearchIndexing();
	
	/** @return */
	public abstract boolean blocksGarbageCollection();
	
	/** @return */
	public abstract boolean isHidden();
	
	/** @return */
	public abstract boolean sentOutsideInDefaultQuery();
	
	/** @return */
	public abstract boolean sentOutsideInExactQuery();
	
	@Override
	public abstract String toString();
	
}
