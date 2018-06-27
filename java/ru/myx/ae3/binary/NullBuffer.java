/*
 * Created on 24.11.2005
 */
package ru.myx.ae3.binary;

import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;

import ru.myx.ae3.Engine;
import ru.myx.ae3.base.BaseObjectNoOwnProperties;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.base.BasePrimitive;
import ru.myx.ae3.base.BasePrimitiveBoolean;
import ru.myx.ae3.base.BasePrimitiveNumber;
import ru.myx.ae3.base.BasePrimitiveString;
import ru.myx.ae3.base.BaseString;
import ru.myx.ae3.base.ToPrimitiveHint;

final class NullBuffer implements BaseObjectNoOwnProperties, BaseTransferBuffer {
	
	
	@Override
	public String baseClass() {
		
		
		return "binary";
	}
	
	@Override
	public BasePrimitiveBoolean baseToBoolean() {
		
		
		return BaseObject.FALSE;
	}
	
	@Override
	public BasePrimitiveNumber baseToInt32() {
		
		
		return BasePrimitiveNumber.ZERO;
	}
	
	@Override
	public BasePrimitiveNumber baseToInteger() {
		
		
		return BasePrimitiveNumber.ZERO;
	}
	
	@Override
	public BasePrimitiveNumber baseToNumber() {
		
		
		return BasePrimitiveNumber.NAN;
	}
	
	@Override
	public BasePrimitive<?> baseToPrimitive(final ToPrimitiveHint hint) {
		
		
		return BaseString.EMPTY;
	}
	
	@Override
	public BasePrimitiveString baseToString() {
		
		
		return BaseString.EMPTY;
	}
	
	@Override
	public TransferBuffer baseValue() {
		
		
		return this;
	}
	
	@Override
	public final void destroy() {
		
		
		// ignore
	}
	
	@Override
	public boolean equals(final Object obj) {
		
		
		if (obj == this) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		return obj instanceof TransferCopier && ((TransferCopier) obj).length() == 0;
	}
	
	@Override
	public MessageDigest getMessageDigest() {
		
		
		return Engine.getMessageDigestInstance();
	}
	
	@Override
	public int hashCode() {
		
		
		return 0;
	}
	
	@Override
	public final boolean hasRemaining() {
		
		
		return false;
	}
	
	@Override
	public final boolean isDirectAbsolutely() {
		
		
		return false;
	}
	
	@Override
	public final boolean isSequence() {
		
		
		return false;
	}
	
	@Override
	public final int next() {
		
		
		return -1;
	}
	
	@Override
	public final int next(final byte[] buffer, final int offset, final int length) {
		
		
		return 0;
	}
	
	@Override
	public final TransferBuffer nextSequenceBuffer() {
		
		
		throw new UnsupportedOperationException("Not a sequence!");
	}
	
	@Override
	public final long remaining() {
		
		
		return 0;
	}
	
	@Override
	public final TransferCopier toBinary() {
		
		
		return TransferCopier.NUL_COPIER;
	}
	
	@Override
	public final byte[] toDirectArray() {
		
		
		return Transfer.EMPTY_BYTE_ARRAY;
	}
	
	@Override
	public final InputStream toInputStream() {
		
		
		return Transfer.EMPTY_STREAM;
	}
	
	@Override
	public final TransferBuffer toNioBuffer(final ByteBuffer target) {
		
		
		return null;
	}
	
	@Override
	public final Reader toReaderUtf8() {
		
		
		return Transfer.EMPTY_READER;
	}
	
	@Override
	public final String toString() {
		
		
		return "";
	}
	
	@Override
	public final String toString(final Charset charset) {
		
		
		return "";
	}
	
	@Override
	public final String toString(final String encoding) {
		
		
		return "";
	}
	
	@Override
	public final TransferBuffer toSubBuffer(final long start, final long end) {
		
		
		if (start != 0 || end != 0) {
			throw new IllegalArgumentException("Indexes are out of bounds: start=" + start + ", end=" + end + ", length=0");
		}
		return this;
	}
	
	@Override
	public MessageDigest updateMessageDigest(final MessageDigest digest) {
		
		
		return digest;
	}
}
