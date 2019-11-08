package ru.myx.ae3.e5.exec;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.e5.context.ExecContext;
import ru.myx.e5.vm.VmStackContext;

/** @author myx */
public interface ExecStackContext extends ExecContext, VmStackContext<BaseObject> {
	
	/** <code>this.fldStack[pointer - 1]</code>
	 *
	 * @return topmost stack object */
	@Override
	BaseObject stackPeek();
	
	/** <code>this.fldStack[pointer - 1 - more]</code>
	 *
	 * @param more
	 * @return stack object */
	@Override
	BaseObject stackPeek(int more);

	/** @return topmost stack object */
	@Override
	BaseObject stackPop();

	/** Push accumulator */
	void stackPush();

	/** @param value */
	@Override
	void stackPush(BaseObject value);

	/** @param value */
	@Override
	default void stackPushDouble(final double value) {
		
		this.stackPush(Base.forDouble(value));
	}

	/** @param value */
	@Override
	default void stackPushInteger(final int value) {
		
		this.stackPush(Base.forInteger(value));
	}

	/** @param value */
	@Override
	default void stackPushLong(final long value) {
		
		this.stackPush(Base.forLong(value));
	}

	/** @param value */
	@Override
	@Deprecated
	default void stackPushObject(final Object value) {
		
		this.stackPush(Base.forUnknown(value));
	}

	/** @param value */
	@Override
	default void stackPushString(final String value) {
		
		this.stackPush(Base.forString(value));
	}

	/** @return current stack */
	@Override
	BaseObject[] stackRaw();
}
