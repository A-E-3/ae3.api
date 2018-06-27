/*
 * Created on 24.11.2005
 */
package ru.myx.ae3.binary;

import java.nio.ByteBuffer;

import ru.myx.ae3.act.Act;
import java.util.function.Function;
import ru.myx.ae3.exec.ExecProcess;

final class NullTarget implements TransferTarget {
	@Override
	public void abort(String reason) {
		// ignore
	}
	
	@Override
	public boolean absorb(final int i) {
		return true;
	}
	
	@Override
	public boolean absorbArray(final byte[] array, final int off, final int len) {
		return true;
	}
	
	@Override
	public boolean absorbBuffer(final TransferBuffer buffer) {
		return true;
	}
	
	@Override
	public boolean absorbNio(final ByteBuffer buffer) {
		buffer.clear();
		return true;
	}
	
	@Override
	public void close() {
		// ignore
	}
	
	@Override
	public <A, R> boolean enqueueAction(final ExecProcess process, final Function<A, R> function, final A argument) {
		Act.launch( process, function, argument );
		return true;
	}
	
	@Override
	public void force() {
		// ignore
	}
}
