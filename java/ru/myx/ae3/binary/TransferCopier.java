package ru.myx.ae3.binary;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.ConcurrentModificationException;

import ru.myx.ae3.Engine;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.common.Value;
import ru.myx.ae3.reflect.Reflect;
import ru.myx.ae3.reflect.ReflectionExplicit;
import ru.myx.ae3.reflect.ReflectionHidden;
import ru.myx.ae3.reflect.ReflectionManual;

/** An object whose duty is to provide any number of equal buffers. */
@ReflectionManual
public interface TransferCopier extends BaseObject, Value<TransferCopier>, Comparable<TransferCopier> {

	/**
	 *
	 */
	@ReflectionHidden
	BaseObject PROTOTYPE = Reflect.classToBasePrototype(TransferCopier.class);

	/** NUL COPIER instance - empty copier. */
	@ReflectionExplicit
	TransferCopier NUL_COPIER = new NullCopier();

	@Override
	default BaseObject basePrototype() {

		return TransferCopier.PROTOTYPE;
	}

	@Override
	default TransferCopier baseValue() {

		return this;
	}

	/** Copies a slice of the copier. Out of bounds are silently discarded.
	 *
	 * @param start
	 * @param target
	 * @param offset
	 * @param count
	 *
	 * @return number of bytes copied
	 * @throws ConcurrentModificationException
	 *             when underlying data suddenly changed */
	@ReflectionExplicit
	int copy(long start, byte[] target, int offset, int count) throws ConcurrentModificationException;

	/** Returns true if another object is also a copier and have same length and same contents.
	 *
	 * @param another
	 * @return */
	@Override
	boolean equals(final Object another);

	/** Returns a checksum.
	 *
	 * @return checksum
	 * @throws ConcurrentModificationException
	 *             when underlying data suddenly changed */
	@ReflectionExplicit
	MessageDigest getMessageDigest() throws ConcurrentModificationException;

	/** @return length of copier contents
	 * @throws ConcurrentModificationException
	 *             when underlying data suddenly changed */
	@ReflectionExplicit
	long length() throws ConcurrentModificationException;

	/** Returns a copy of copier contents in a newly created buffer.
	 *
	 * @return buffer
	 * @throws ConcurrentModificationException
	 *             when underlying data suddenly changed */
	@ReflectionExplicit
	TransferBuffer nextCopy() throws ConcurrentModificationException;

	/** Same as nextCopy().toDirectArray() but could be more effective.
	 *
	 * @return
	 * @throws ConcurrentModificationException */
	@ReflectionExplicit
	default byte[] nextDirectArray() throws ConcurrentModificationException {

		return this.nextCopy().toDirectArray();
	}

	/** Returns a copy of copier contents in a newly created InputStream.
	 *
	 * @return InputStream
	 * @throws IOException
	 * @throws ConcurrentModificationException
	 *             when underlying data suddenly changed */
	@ReflectionExplicit
	InputStream nextInputStream() throws IOException, ConcurrentModificationException;

	/** Same as ByteBuffer.wrap(nextDirectArray()) but could be more effective.
	 *
	 * @return
	 * @throws ConcurrentModificationException */
	@ReflectionExplicit
	default ByteBuffer nextNioBuffer() throws ConcurrentModificationException {
		
		return ByteBuffer.wrap(this.nextDirectArray());
	}

	/** Returns a copy of copier contents in a newly created InputStream.
	 *
	 * @return BufferedReader
	 * @throws IOException
	 * @throws ConcurrentModificationException
	 *             when underlying data suddenly changed */
	@ReflectionExplicit
	Reader nextReaderUtf8() throws IOException, ConcurrentModificationException;

	/** Returns a slice of the copier. Out of bounds are silently discarded.
	 *
	 * @param start
	 * @param count
	 *
	 * @return TransferCopier
	 * @throws ConcurrentModificationException
	 *             when underlying data suddenly changed */
	@ReflectionExplicit
	TransferCopier slice(long start, long count) throws ConcurrentModificationException;

	/** Returns a text representation of copier contents. Any binary-to-character conversions (if
	 * any) are performed using system-default locale and encoding.
	 *
	 * returns nextCopy().toString(); */
	@Override
	String toString();

	/** Returns a text representation of copier contents.
	 *
	 * returns nextCopy().toString(charset);
	 *
	 * @param charset
	 * @return */
	String toString(final Charset charset);

	/** Returns a text representation of copier contents.
	 *
	 * returns nextCopy().toString(encoding);
	 *
	 * @param encoding
	 * @return
	 * @throws UnsupportedEncodingException */
	String toString(final String encoding) throws UnsupportedEncodingException;

	/** Returns binary contents as base64 string.
	 *
	 * @return */
	@ReflectionExplicit
	default String toStringBase64() {

		return new String(Base64.getEncoder().withoutPadding().encode(this.nextDirectArray()), Engine.CHARSET_ASCII);
	}

	/** Returns a text representation of copier contents. Any binary-to-character conversions (if
	 * any) are performed using utf-8 encoding.
	 *
	 * @return nextCopy().toString(Engine.CHARSET_UTF8); */
	@ReflectionExplicit
	String toStringUtf8();
	/** Returns a checksum.
	 *
	 * @param digest
	 * @return checksum
	 * @throws ConcurrentModificationException
	 *             when underlying data suddenly changed */
	@ReflectionExplicit
	MessageDigest updateMessageDigest(final MessageDigest digest) throws ConcurrentModificationException;
}
