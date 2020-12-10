/*
 * Created on 24.11.2005
 */
package ru.myx.ae3.binary;

import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ConcurrentModificationException;

import ru.myx.ae3.Engine;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.base.BaseObjectNoOwnProperties;
import ru.myx.ae3.base.BasePrimitive;
import ru.myx.ae3.base.BasePrimitiveBoolean;
import ru.myx.ae3.base.BasePrimitiveNumber;
import ru.myx.ae3.base.BasePrimitiveString;
import ru.myx.ae3.base.BaseString;
import ru.myx.ae3.base.ToPrimitiveHint;

final class NullCopier implements BaseObjectNoOwnProperties, TransferCopier {
	
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
	public NullCopier baseValue() {
		
		return this;
	}

	@Override
	public int compareTo(final TransferCopier o) {
		
		if (o == null) {
			return 1;
		}
		return o.length() == 0
			? 0
			: -1;
	}

	@Override
	public int copy(final long start, final byte[] target, final int offset, final int count) throws ConcurrentModificationException {
		
		return 0;
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
	public final long length() {
		
		return 0;
	}

	@Override
	public TransferBuffer nextCopy() {
		
		return TransferBuffer.NUL_BUFFER;
	}

	@Override
	public byte[] nextDirectArray() {
		
		return Transfer.EMPTY_BYTE_ARRAY;
	}

	@Override
	public InputStream nextInputStream() {
		
		return Transfer.EMPTY_STREAM;
	}

	@Override
	public ByteBuffer nextNioBuffer() {
		
		return ByteBuffer.allocate(0);
	}

	@Override
	public Reader nextReaderUtf8() {
		
		return Transfer.EMPTY_READER;
	}

	@Override
	public TransferCopier slice(final long start, final long count) throws ConcurrentModificationException {
		
		return this;
	}

	@Override
	public String toString() {
		
		return "";
	}

	@Override
	public String toString(final Charset charset) {
		
		return "";
	}

	@Override
	public String toString(final String encoding) {
		
		return "";
	}

	@Override
	public String toStringUtf8() {
		
		return "";
	}

	@Override
	public MessageDigest updateMessageDigest(final MessageDigest digest) {
		
		return digest;
	}
}
