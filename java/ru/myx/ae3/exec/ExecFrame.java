/**
 *
 */
package ru.myx.ae3.exec;

import ru.myx.ae3.base.BaseHost;
import ru.myx.ae3.base.BaseObjectNoOwnProperties;

/** @author myx */
abstract class ExecFrame implements BaseHost, BaseObjectNoOwnProperties {
	
	/** TODO: move to FrameNormal */
	final int ri0BSB;

	ExecFrame(final int ri0BSB) {
		this.ri0BSB = ri0BSB;
	}

	/** called when this frame's lifetime is over and code execution stack if going up.
	 *
	 * @param ctx
	 * @param codeDefault
	 * @return */
	abstract ExecStateCode execFrameLeave(ExecProcess ctx, ExecStateCode codeDefault);

	/** @return -1 or an address of FRAME_LEAVE (finally) instruction. */
	abstract int getExitAddress();

	@Override
	public abstract String toString();
}
