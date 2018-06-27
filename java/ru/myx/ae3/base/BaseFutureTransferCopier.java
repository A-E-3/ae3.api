package ru.myx.ae3.base;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ConcurrentModificationException;

import ru.myx.ae3.binary.TransferBuffer;
import ru.myx.ae3.binary.TransferCopier;
import ru.myx.ae3.reflect.ReflectionExplicit;
import ru.myx.ae3.reflect.ReflectionHidden;

/**
 * 
 * @author myx
 * 		
 */
public interface BaseFutureTransferCopier extends BaseFuture<TransferCopier>, TransferCopier {
	
	@Override
			TransferCopier baseValue();
			
	@Override
	@ReflectionHidden
	default BaseObject basePrototype() {
		
		return TransferCopier.PROTOTYPE;
	}
	
	@Override
	@ReflectionHidden
	default BasePrimitiveBoolean baseToBoolean() {
		
		if (!this.baseAwait()) {
			return BaseObject.FALSE;
		}
		final TransferCopier value = this.baseValue();
		if (value == null) {
			return BaseObject.FALSE;
		}
		assert value != this : "Future base value is THIS, class: " + this.getClass().getName();
		return value.length() == 0
			? BaseObject.FALSE
			: BaseObject.TRUE;
	}
	
	@Override
	@ReflectionExplicit
	default int compareTo(final TransferCopier o) {
		
		return this == o
			? 0
			: this.baseValue().compareTo(o);
	}
	
	@Override
	@ReflectionExplicit
	default int copy(final long start, final byte[] target, final int offset, final int count) throws ConcurrentModificationException {
		
		return this.baseValue().copy(start, target, offset, count);
	}
	
	@Override
	@ReflectionExplicit
	default MessageDigest getMessageDigest() throws ConcurrentModificationException {
		
		return this.baseValue().getMessageDigest();
	}
	
	@Override
	@ReflectionExplicit
	default long length() {
		
		return this.baseValue().length();
	}
	
	@Override
	@ReflectionExplicit
	default TransferBuffer nextCopy() throws ConcurrentModificationException {
		
		return this.baseValue().nextCopy();
	}
	
	@Override
	@ReflectionExplicit
	default byte[] nextDirectArray() throws ConcurrentModificationException {
		
		return this.baseValue().nextDirectArray();
	}
	
	@Override
	@ReflectionExplicit
	default InputStream nextInputStream() throws IOException, ConcurrentModificationException {
		
		return this.baseValue().nextInputStream();
	}
	
	@Override
	@ReflectionExplicit
	default Reader nextReaderUtf8() throws IOException, ConcurrentModificationException {
		
		return this.baseValue().nextReaderUtf8();
	}
	
	@Override
	@ReflectionExplicit
	default TransferCopier slice(final long start, final long count) throws ConcurrentModificationException {
		
		// TODO new FutureBinarySlice(this, start, count)
		return this.baseValue().slice(start, count);
	}
	
	@Override
	@ReflectionExplicit
	default String toString(final Charset charset) {
		
		return this.baseValue().toString(charset);
	}
	
	@Override
	@ReflectionExplicit
	default String toString(final String encoding) throws UnsupportedEncodingException {
		
		return this.baseValue().toString(encoding);
	}
	
	@Override
	@ReflectionExplicit
	default String toStringUtf8() {
		
		return this.baseValue().toStringUtf8();
	}
	
	@Override
	@ReflectionExplicit
	default MessageDigest updateMessageDigest(final MessageDigest digest) throws ConcurrentModificationException {
		
		return this.baseValue().updateMessageDigest(digest);
	}
}
