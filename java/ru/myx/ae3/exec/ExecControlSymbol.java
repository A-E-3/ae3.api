package ru.myx.ae3.exec;

import ru.myx.ae3.base.BaseAbstract;
import ru.myx.ae3.base.BaseObjectNominal;
import ru.myx.ae3.base.BaseObject;

/**
 * Todo CONTINUE and BREAK are thrown using ExecStateCode.ERROR
 *
 * @author myx
 *
 */
class ExecControlSymbol extends BaseAbstract implements BaseObjectNominal {
	
	
	static final BaseObject SYMBOL_BRK = new ExecControlSymbol("BREAK");
	static final BaseObject SYMBOL_CTN = new ExecControlSymbol("CONTINUE");

	private final String name;

	ExecControlSymbol(final String name) {
		this.name = name;
	}

	@Override
	public final String toString() {
		
		
		return this.name;
	}
}
