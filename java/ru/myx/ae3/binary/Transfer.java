/**
 * Created on 17.11.2002
 *
 * myx - barachta */
package ru.myx.ae3.binary;

import java.io.Closeable;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.security.DigestException;
import java.security.MessageDigest;
import java.util.ConcurrentModificationException;

import ru.myx.ae3.AbstractSAPI;
import ru.myx.ae3.base.BaseMessage;
import ru.myx.ae3.common.BodyAccessBinary;
import ru.myx.ae3.common.BodyAccessCharacter;
import ru.myx.ae3.common.Value;
import ru.myx.ae3.reflect.ReflectionEnumerable;
import ru.myx.ae3.reflect.ReflectionExplicit;
import ru.myx.ae3.reflect.ReflectionManual;
import ru.myx.ae3.report.Report;
import ru.myx.ae3.vfs.Entry;
import ru.myx.ae3.vfs.EntryBinary;
import ru.myx.ae3.vfs.EntryCharacter;
import ru.myx.io.EmptyInputStream;
import ru.myx.io.EmptyReader;

/** @author barachta
 *
 *         myx - barachta "typecomment": Window>Preferences>Java>Templates. To enable and disable
 *         the creation of type comments go to Window>Preferences>Java>Code Generation. */
@ReflectionManual
public final class Transfer extends AbstractSAPI {

	/** @author myx */
	@SuppressWarnings("serial")
	public static class TransferOperationException extends RuntimeException {

		/** @param message
		 * @param parent */
		public TransferOperationException(final String message, final Throwable parent) {

			super(message, parent);
		}
	}

	/** Default large buffer size.<br>
	 * Source: 'ae2.tune.buffer_large' <br>
	 * Default: 64k <br>
	 * Min: 4k <br>
	 * Max: 128k */
	@ReflectionExplicit
	@ReflectionEnumerable
	public static final int BUFFER_LARGE;

	/** 128ki */
	static final int BUFFER_LARGE_MAX = 128 * 1024;

	/** 4ki */
	static final int BUFFER_LARGE_MIN = 4096;

	/** Default maximal buffer size for validation use. <br>
	 * Source: 'ae2.tune.buffer_max' <br>
	 * Default: 128k <br>
	 * Min: 32k <br>
	 * Max: 1M */
	@ReflectionExplicit
	@ReflectionEnumerable
	public static final int BUFFER_MAX;

	/** 1Mi */
	static final int BUFFER_MAX_MAX = 1024 * 1024;

	/** 32ki */
	static final int BUFFER_MAX_MIN = 32768;

	/** Default medium buffer size. Should be good for 'initial buffer size' when resulting size is
	 * unknown. <br>
	 * Source: 'ae2.tune.buffer_medium' <br>
	 * Default: 16k <br>
	 * Min: 1k <br>
	 * Max: 64k */
	@ReflectionExplicit
	@ReflectionEnumerable
	public static final int BUFFER_MEDIUM;

	/** 64ki */
	static final int BUFFER_MEDIUM_MAX = 65536;

	/** 1ki */
	static final int BUFFER_MEDIUM_MIN = 1024;

	/** Default small buffer size. <br>
	 * Source: 'ae2.tune.buffer_small' <br>
	 * Default: 2048 <br>
	 * Min: 128 <br>
	 * Max: 4096 */
	@ReflectionExplicit
	@ReflectionEnumerable
	public static final int BUFFER_SMALL;

	/** 4ki */
	static final int BUFFER_SMALL_MAX = 4096;

	/** 128 */
	static final int BUFFER_SMALL_MIN = 128;

	/**
	 *
	 */
	@ReflectionExplicit
	@ReflectionEnumerable
	public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

	/**
	 *
	 */
	@ReflectionExplicit
	@ReflectionEnumerable
	public static final Reader EMPTY_READER = EmptyReader.INSTANCE;

	/**
	 *
	 */
	@ReflectionExplicit
	@ReflectionEnumerable
	public static final InputStream EMPTY_STREAM = EmptyInputStream.INSTANCE;

	private static final AbstractTransferImpl IMPL;

	static {
		/** this block should go last */
		{
			IMPL = AbstractSAPI.createObject("ru.myx.ae3.binary.ImplementBinary");

			BUFFER_SMALL = Transfer.IMPL.getBufferSmall();
			BUFFER_MEDIUM = Transfer.IMPL.getBufferMedium();
			BUFFER_LARGE = Transfer.IMPL.getBufferLarge();
			BUFFER_MAX = Transfer.IMPL.getBufferMax();
		}
	}

	private static ReferenceQueue<Closeable> DEFER_CLOSE_QUEUE = new ReferenceQueue<>();

	static {
		new Thread("DEFER-CLOSE-THREAD") {

			{
				this.setDaemon(true);
			}

			@Override
			public void run() {

				for (;;) {
					Reference<? extends Closeable> reference;
					try {
						reference = Transfer.DEFER_CLOSE_QUEUE.remove();
					} catch (final InterruptedException e) {
						System.err.println("Transfer " + this + " exits (interrupted).");
						return;
					}
					if (reference == null) {
						System.err.println("Transfer " + this + " exits (exhausted).");
						return;
					}
					try (final Closeable closeable = reference.get()) {
						//
					} catch (final Throwable t) {
						Report.exception("DEFER-CLOSE-THREAD", "Close fail", t);
					}
				}
			}

		}.start();
	}

	/** @param binary
	 * @return */
	@ReflectionExplicit
	public static final long binarySize(final Object binary) {

		if (binary == null) {
			return 0;
		}
		if (binary instanceof byte[]) {
			return ((byte[]) binary).length;
		}
		if (binary instanceof final TransferBuffer binaryBuffer) {
			return binaryBuffer.remaining();
		}
		if (binary instanceof final TransferCopier binaryCopier) {
			return binaryCopier.length();
		}
		if (binary instanceof final Entry entry) {
			if (!entry.isExist()) {
				return 0;
			}
			if (entry.isCharacter()) {
				/** TODO: EntryCharacter implement BodyAccessCharacter<code>
				assert entry instanceof BodyAccessCharacter : "Supposed to be an instance of BodyAccessCharacter, class: "
						+ entry.getClass().getName();
				return ((BodyAccessCharacter) entry).getCharacterContentLength();
				</code> */
				assert entry instanceof EntryCharacter //
						: "Supposed to be an instance of EntryCharacter, class: " + entry.getClass().getName();
				return ((EntryCharacter) entry).getCharacterContentLength();
			}
			if (entry.isBinary()) {
				/** TODO: EntryBinary implement BodyAccessBinary<code>
				assert entry instanceof BodyAccessBinary : "Supposed to be an instance of BodyAccessBinary, class: "
						+ entry.getClass().getName();
				return ((BodyAccessBinary) entry).getBinaryContentLength();
				</code> */
				assert entry instanceof EntryBinary //
						: "Supposed to be an instance of EntryBinary, class: " + entry.getClass().getName();
				return ((EntryBinary) entry).getBinaryContentLength();
			}
			return entry.toBinary().getBinaryContentLength();
		}
		if (binary instanceof Value<?>) {
			final Object baseValue = ((Value<?>) binary).baseValue();
			if (baseValue != binary) {
				return Transfer.binarySize(baseValue);
			}
		}
		if (binary instanceof final BaseMessage message) {
			if (message.isCharacter()) {
				assert message instanceof BodyAccessCharacter : "Supposed to be an instance of BodyAccessCharacter, class: " + message.getClass().getName();
				return ((BodyAccessCharacter) message).getCharacterContentLength();
			}
			if (message.isBinary()) {
				assert message instanceof BodyAccessBinary : "Supposed to be an instance of BodyAccessBinary, class: " + message.getClass().getName();
				return ((BodyAccessBinary) message).getBinaryContentLength();
			}
			if (message.isEmpty()) {
				return 0;
			}
			// and not isBinary(), really?
			if (message.isFile()) {
				return message.getFile().length();
			}
			return message.toBinary().getBinaryContentLength();
		}
		return binary.toString().length();
	}

	/** @param stream1
	 * @param stream2
	 * @return
	 * @throws IOException */
	@ReflectionExplicit
	public static final int compareStreams(final InputStream stream1, final InputStream stream2) throws IOException {

		if (stream1 == null) {
			throw new NullPointerException("'stream1' is NULL!");
		}
		if (stream2 == null) {
			throw new NullPointerException("'stream2' is NULL!");
		}
		try {
			try {
				final int size = Transfer.BUFFER_SMALL;
				final int half = size >> 1;
				final byte[] buffer = new byte[size];
				for (;;) {
					final int read1 = stream1.read(buffer, 0, half);
					final int read2 = stream2.read(buffer, half, half);
					if (read1 <= 0) {
						return read2 <= 0
							? 0
							: -1;
					}
					if (read2 <= 0) {
						return 1;
					}
					for (int index = 0; index < half; ++index) {
						if (read1 <= index) {
							return read2 <= index
								? 0
								: -1;
						}
						if (read2 <= index) {
							return 1;
						}
						final int diff = buffer[index] - buffer[index + half];
						if (diff == 0) {
							continue;
						}
						return diff < 0
							? -1
							: 1;
					}
				}
			} finally {
				try {
					stream2.close();
				} catch (final Throwable e) {
					// ignore
				}
			}
		} finally {
			try {
				stream1.close();
			} catch (final Throwable e) {
				// ignore
			}
		}
	}

	/** @param srcBinary
	 * @param srcOffset
	 * @param dstBytes
	 * @param dstOffset
	 * @param length
	 * @return
	 * @throws IOException
	 * @throws IllegalArgumentException
	 * @throws ConcurrentModificationException */
	@ReflectionExplicit
	public static final int copyBytes(final Object srcBinary, final long srcOffset, final byte[] dstBytes, final int dstOffset, final int length)
			throws ConcurrentModificationException, IllegalArgumentException, IOException {

		if (srcBinary == null) {
			return 0;
		}
		if (srcBinary instanceof final TransferCopier srcBinaryCopier) {
			return srcBinaryCopier.copy(srcOffset, dstBytes, dstOffset, length);
		}
		if (srcBinary instanceof final byte[] bytes) {
			if (srcOffset >= bytes.length) {
				return 0;
			}
			final int count = (int) Math.min(bytes.length - srcOffset, length);
			System.arraycopy(bytes, (int) srcOffset, dstBytes, dstOffset, count);
			return count;
		}
		return Transfer.createCopierFromBinary(srcBinary).copy(srcOffset, dstBytes, dstOffset, length);
	}

	/** When buffer size is greater than BUFFER_MAX - creates file-based buffer, use wrapBuffer to
	 * be sure that your bytes are definitely in memory. Copies bytes.
	 *
	 * @param bytes
	 * @return buffer */
	@ReflectionExplicit
	public static final TransferBuffer createBuffer(final byte[] bytes) {

		if (bytes == null) {
			return TransferBuffer.NUL_BUFFER;
		}
		final int length = bytes.length;
		return length == 0
			? TransferBuffer.NUL_BUFFER
			: Transfer.IMPL.createBuffer(bytes, 0, length);
	}

	/** When requested length is greater than BUFFER_MAX - creates file-based buffer, use wrapBuffer
	 * to be sure that your bytes are definitely in memory. Copies bytes.
	 *
	 * @param bytes
	 * @param offset
	 * @param length
	 * @return buffer */
	@ReflectionExplicit
	public static final TransferBuffer createBuffer(final byte[] bytes, final int offset, final int length) {

		if (bytes == null || length == 0) {
			return TransferBuffer.NUL_BUFFER;
		}
		return Transfer.IMPL.createBuffer(bytes, offset, length);
	}

	/** @param file
	 * @return buffer */
	@ReflectionExplicit
	public static final TransferBuffer createBuffer(final File file) {

		return Transfer.IMPL.createBuffer(file);
	}

	/** @param file
	 * @param skip
	 * @param length
	 * @return buffer */
	@ReflectionExplicit
	public static final TransferBuffer createBuffer(final File file, final long skip, final long length) {

		return Transfer.IMPL.createBuffer(file, skip, length);
	}

	/** Wraps input stream. Since the general contract of a buffer class requires that contents of a
	 * buffer were immediately available this InputStream are read into collector or any special
	 * holder. An exception that may rise while reading an InputStream is throwed from this method.
	 *
	 * In any case InputStream will be closed on exit from this method!
	 *
	 * @param stream
	 * @return buffer
	 * @throws TransferOperationException */
	@ReflectionExplicit
	public static final TransferBuffer createBuffer(final InputStream stream) throws TransferOperationException {

		assert stream != null;
		try {
			try {
				final TransferCollector collector = Transfer.createCollector();
				try (final TransferTarget out = collector.getTarget()) {
					final byte[] buffer = new byte[Transfer.BUFFER_MEDIUM];
					for (;;) {
						final int i = stream.read(buffer);
						if (i == -1) {
							break;
						}
						out.absorbArray(buffer, 0, i);
					}
				}
				return collector.toBuffer();
			} finally {
				stream.close();
			}
		} catch (final Throwable t) {
			throw new TransferOperationException("stream: " + stream, t);
		}
	}

	/** @param base58
	 * @return buffer */
	@ReflectionExplicit
	public static final TransferBuffer createBufferFromBase58(final CharSequence base58) {

		if (base58 == null || base58.length() == 0) {
			return TransferBuffer.NUL_BUFFER;
		}
		return Transfer.IMPL.createBufferFromBase58(base58);
	}

	/** @param base64
	 * @return buffer */
	@ReflectionExplicit
	public static final TransferBuffer createBufferFromBase64(final CharSequence base64) {

		if (base64 == null || base64.length() == 0) {
			return TransferBuffer.NUL_BUFFER;
		}
		return Transfer.IMPL.createBufferFromBase64(base64);
	}

	/** @param binary
	 * @return
	 * @throws TransferOperationException
	 * @throws IllegalArgumentException
	 *             - not a binary */
	@ReflectionExplicit
	public static final TransferBuffer createBufferFromBinary(final Object binary) throws TransferOperationException, IllegalArgumentException {

		if (binary instanceof byte[]) {
			return Transfer.createBuffer((byte[]) binary);
		}
		if (binary instanceof TransferBuffer) {
			return (TransferBuffer) binary;
		}
		if (binary instanceof TransferCopier) {
			return ((TransferCopier) binary).nextCopy();
		}
		if (binary instanceof final BaseMessage message) {
			if (message.isEmpty()) {
				return TransferBuffer.NUL_BUFFER;
			}
			if (message.isBinary()) {
				assert message instanceof BodyAccessBinary : "Supposed to be an instance of BodyAccessBinary, class: " + message.getClass().getName();
				return ((BodyAccessBinary) message).getBinary().nextCopy();
			}
			if (message.isFile()) {
				return Transfer.createBuffer(message.getFile());
			}
			final BaseMessage replacement = message.toBinary();
			assert replacement instanceof BodyAccessBinary : "Supposed to be an instance of BodyAccessBinary, class: " + replacement.getClass().getName();
			return ((BodyAccessBinary) replacement).getBinary().nextCopy();
		}
		if (binary instanceof InputStream) {
			return Transfer.createBuffer((InputStream) binary);
		}
		if (binary instanceof final ByteBuffer buffer) {
			final int remaining = buffer.remaining();
			if (remaining == 0) {
				return TransferBuffer.NUL_BUFFER;
			}
			if (remaining < Transfer.BUFFER_LARGE) {
				final byte[] bytes = new byte[remaining];
				buffer.get(bytes);
				return Transfer.wrapBuffer(bytes);
			}
			{
				@SuppressWarnings("resource")
				final TransferCollector collector = Transfer.createCollector();
				collector.getTarget().absorbNio(buffer);
				collector.close();
				return collector.toBuffer();
			}
		}
		if (binary instanceof Value<?>) {
			final Object base = ((Value<?>) binary).baseValue();
			if (base != null && base != binary) {
				return Transfer.createBufferFromBinary(base);
			}
		}
		throw new IllegalArgumentException("Not a binary: " + binary);
	}

	/** Creates buffer representing given string using UTF-8 charset encoding.
	 *
	 * TODO: use Collector and CharacterDecoder for long strings!
	 *
	 * @param string
	 * @return buffer */
	@ReflectionExplicit
	public static final TransferBuffer createBufferUtf8(final CharSequence string) {

		if (string == null || string.length() == 0) {
			return TransferBuffer.NUL_BUFFER;
		}
		return Transfer.wrapBuffer(string.toString().getBytes(StandardCharsets.UTF_8));
	}

	/** Creates buffer representing given string using UTF-8 charset encoding.
	 *
	 * TODO: use Collector and CharacterDecoder for long strings!
	 *
	 * @param string
	 * @return buffer */
	public static final TransferBuffer createBufferUtf8(final String string) {

		if (string == null || string.isEmpty()) {
			return TransferBuffer.NUL_BUFFER;
		}
		return Transfer.wrapBuffer(string.getBytes(StandardCharsets.UTF_8));
	}

	/** Creates new collector.
	 *
	 * @return collector */
	@ReflectionExplicit
	public static final TransferCollector createCollector() {

		return Transfer.IMPL.createCollector();
	}

	/** Clones byte buffer unless it is larger than BUFFER_MAX. Creates temporary file-based
	 * solution otherwise.
	 *
	 * @param bytes
	 * @return copier */
	@ReflectionExplicit
	public static final TransferCopier createCopier(final byte[] bytes) {

		if (bytes == null) {
			return TransferCopier.NUL_COPIER;
		}
		final int length = bytes.length;
		return length == 0
			? TransferCopier.NUL_COPIER
			: Transfer.IMPL.createCopier(bytes, 0, length);
	}

	/** Clones byte buffer unless it is larger than BUFFER_MAX. Creates temporary file-based
	 * solution otherwise.
	 *
	 * @param bytes
	 * @param offset
	 * @param length
	 * @return copier */
	@ReflectionExplicit
	public static final TransferCopier createCopier(final byte[] bytes, final int offset, final int length) {

		if (bytes == null || length == 0) {
			return TransferCopier.NUL_COPIER;
		}
		return Transfer.IMPL.createCopier(bytes, offset, length);
	}

	/** Creates copier representing given string using given charset encoding.
	 *
	 * TODO: use Collector and CharacterDecoder for long strings!
	 *
	 * @param string
	 * @param charset
	 * @return copier */
	@ReflectionExplicit
	public static final TransferCopier createCopier(final CharSequence string, final Charset charset) {

		if (string == null || string.length() == 0) {
			return TransferCopier.NUL_COPIER;
		}
		return Transfer.wrapCopier(string.toString().getBytes(charset));
	}

	/** @param file
	 * @return copier */
	@ReflectionExplicit
	public static final TransferCopier createCopier(final File file) {

		return Transfer.IMPL.createCopier(file);
	}

	/** @param file
	 * @param skip
	 * @param length
	 * @return copier */
	@ReflectionExplicit
	public static final TransferCopier createCopier(final File file, final long skip, final long length) {

		return Transfer.IMPL.createCopier(file, skip, length);
	}

	/** TODO: move to sys / ImplementBinary
	 *
	 * @param stream
	 * @return copier
	 * @throws IOException */
	@ReflectionExplicit
	public static final TransferCopier createCopier(final InputStream stream) throws IOException {

		assert stream != null : "NULL stream";
		try {
			final TransferCollector collector = Transfer.createCollector();
			try (final TransferTarget out = collector.getTarget()) {
				final byte[] buffer = new byte[Transfer.BUFFER_MEDIUM];
				for (;;) {
					final int i = stream.read(buffer);
					if (i == -1) {
						break;
					}
					out.absorbArray(buffer, 0, i);
				}
			}
			/** collector is closed buy try ^^^ */
			return collector.toCloneFactory();
		} finally {
			stream.close();
		}
	}

	/** @param path
	 * @return copier */
	@ReflectionExplicit
	public static final TransferCopier createCopier(final Path path) {

		return Transfer.IMPL.createCopier(path);
	}

	/** Creates copier representing given string using given charset encoding.
	 *
	 * TODO: use Collector and CharacterDecoder for long strings!
	 *
	 * @param string
	 * @param charset
	 * @return copier */
	public static final TransferCopier createCopier(final String string, final Charset charset) {

		if (string == null || string.length() == 0) {
			return TransferCopier.NUL_COPIER;
		}
		return Transfer.wrapCopier(string.getBytes(charset));
	}

	/** Creates copier representing by decoding a Base58 encoded string.
	 *
	 * TODO: use Collector and CharacterDecoder for long strings!
	 *
	 * @param base58
	 * @return copier */
	@ReflectionExplicit
	public static final TransferCopier createCopierFromBase58(final CharSequence base58) {

		if (base58 == null || base58.length() == 0) {
			return TransferCopier.NUL_COPIER;
		}
		return Transfer.IMPL.createCopierFromBase58(base58);
	}

	/** Creates copier representing by decoding a Base64 encoded string.
	 *
	 * TODO: use Collector and CharacterDecoder for long strings!
	 *
	 * @param base64
	 * @return copier */
	@ReflectionExplicit
	public static final TransferCopier createCopierFromBase64(final CharSequence base64) {

		if (base64 == null || base64.length() == 0) {
			return TransferCopier.NUL_COPIER;
		}
		return Transfer.IMPL.createCopierFromBase64(base64);
	}

	/** @param binary
	 * @return
	 * @throws IOException
	 * @throws IllegalArgumentException
	 *             - not a binary */
	@ReflectionExplicit
	public static final TransferCopier createCopierFromBinary(final Object binary) throws IOException, IllegalArgumentException {

		if (binary == null) {
			return TransferCopier.NUL_COPIER;
		}
		if (binary instanceof byte[]) {
			return Transfer.createCopier((byte[]) binary);
		}
		if (binary instanceof TransferCopier) {
			return (TransferCopier) binary;
		}
		if (binary instanceof TransferBuffer) {
			return ((TransferBuffer) binary).toBinary();
		}
		if (binary instanceof final BaseMessage message) {
			if (message.isEmpty()) {
				return TransferCopier.NUL_COPIER;
			}
			if (message.isBinary()) {
				assert message instanceof BodyAccessBinary : "Supposed to be an instance of BodyAccessBinary, class: " + message.getClass().getName();
				return ((BodyAccessBinary) message).getBinary();
			}
			if (message.isFile()) {
				return Transfer.createCopier(message.getFile());
			}
			final BaseMessage replacement = message.toBinary();
			assert replacement instanceof BodyAccessBinary : "Supposed to be an instance of BodyAccessBinary, class: " + replacement.getClass().getName();
			return ((BodyAccessBinary) replacement).getBinary();
		}
		if (binary instanceof InputStream) {
			return Transfer.createCopier((InputStream) binary);
		}
		if (binary instanceof final ByteBuffer buffer) {
			final int remaining = buffer.remaining();
			if (remaining == 0) {
				return TransferCopier.NUL_COPIER;
			}
			if (remaining < Transfer.BUFFER_LARGE) {
				final byte[] bytes = new byte[remaining];
				buffer.get(bytes);
				return Transfer.wrapCopier(bytes);
			}
			{
				final TransferCollector collector = Transfer.createCollector();
				collector.getTarget().absorbNio(buffer);
				return collector.toBinary();
			}
		}
		if (binary instanceof Value<?>) {
			final Object base = ((Value<?>) binary).baseValue();
			if (base != null && base != binary) {
				return Transfer.createCopierFromBinary(base);
			}
		}
		throw new IllegalArgumentException("Not a binary: " + binary);
	}

	/** Creates copier representing given string using UTF-8 charset encoding.
	 *
	 * TODO: use Collector and CharacterDecoder for long strings!
	 *
	 * @param string
	 * @return copier */
	@ReflectionExplicit
	public static final TransferCopier createCopierUtf8(final CharSequence string) {

		if (string == null || string.length() == 0) {
			return TransferCopier.NUL_COPIER;
		}
		return Transfer.wrapCopier(string.toString().getBytes(StandardCharsets.UTF_8));
	}

	/** Creates copier representing given string using UTF-8 charset encoding.
	 *
	 * TODO: use Collector and CharacterDecoder for long strings!
	 *
	 * @param string
	 * @return copier */
	public static final TransferCopier createCopierUtf8(final String string) {

		if (string == null || string.isEmpty()) {
			return TransferCopier.NUL_COPIER;
		}
		return Transfer.wrapCopier(string.getBytes(StandardCharsets.UTF_8));
	}

	/** Creates writable transfer description.
	 *
	 * @param name
	 * @param priority
	 * @return description */
	@ReflectionExplicit
	public static final TransferDescription createDescription(final String name, final int priority) {

		return Transfer.IMPL.createDescription(name, priority);
	}

	/** Must only be called from place of instantiations of closeable objects that are relying on
	 * this particular facility to make sure resources are actually released.
	 *
	 * Use try-with-resource whenever is possible (instead of deferClose facility).
	 *
	 * @param <T>
	 * @param closeable
	 * @return */
	@SuppressWarnings("unused")
	public static <T extends Closeable> T deferClose(final T closeable) {

		new WeakReference<Closeable>(closeable, Transfer.DEFER_CLOSE_QUEUE);
		return closeable;
	}

	/** @param in
	 * @param out
	 * @param close
	 * @return byte count
	 * @throws IOException */
	@ReflectionExplicit
	public static final int fromStream(final InputStream in, final TransferTarget out, final boolean close) throws IOException {

		try {
			final byte[] buffer = new byte[Transfer.BUFFER_MEDIUM];
			for (int count = 0;;) {
				final int i = in.read(buffer);
				if (i <= 0) {
					return count;
				}
				count += i;
				if (!out.absorbArray(buffer, 0, i)) {
					return count;
				}
			}
		} finally {
			// behavior.returnBuffer(buffer);
			if (close) {
				try {
					in.close();
				} catch (final Throwable t) {
					// ignore
				}
				try {
					out.close();
				} catch (final Throwable t) {
					// ignore
				}
			}
		}
	}

	/** 2 bytes
	 *
	 * @param srcBytes
	 * @param srcOffset
	 * @return */
	@ReflectionExplicit
	public static final float readFloat(final byte[] srcBytes, final int srcOffset) {

		return Float.intBitsToFloat(Transfer.readInt(srcBytes, srcOffset));
	}

	/** 4 bytes
	 *
	 * @param srcBytes
	 * @param srcOffset
	 * @return */
	@ReflectionExplicit
	public static final int readInt(final byte[] srcBytes, final int srcOffset) {

		return ((srcBytes[srcOffset + 0] & 0xff) << 24) + ((srcBytes[srcOffset + 1] & 0xff) << 16) + ((srcBytes[srcOffset + 2] & 0xff) << 8)
				+ ((srcBytes[srcOffset + 3] & 0xff) << 0);
	}

	/** 3 bytes
	 *
	 * @param srcBytes
	 * @param srcOffset
	 * @return */
	@ReflectionExplicit
	public static final int readInt24(final byte[] srcBytes, final int srcOffset) {

		return ((srcBytes[srcOffset + 1] & 0xff) << 16) + ((srcBytes[srcOffset + 2] & 0xff) << 8) + ((srcBytes[srcOffset + 3] & 0xff) << 0);
	}

	/** 8 bytes
	 *
	 * @param srcBytes
	 * @param srcOffset
	 * @return */
	@ReflectionExplicit
	public static final long readLong(final byte[] srcBytes, final int srcOffset) {

		return 0 //
				+ ((srcBytes[srcOffset + 0] & 0xffL) << 56) //
				+ ((srcBytes[srcOffset + 1] & 0xffL) << 48) //
				+ ((srcBytes[srcOffset + 2] & 0xffL) << 40) //
				+ ((srcBytes[srcOffset + 3] & 0xffL) << 32) + (((srcBytes[srcOffset + 4] & 0xff) << 24) //
						+ ((srcBytes[srcOffset + 5] & 0xff) << 16) //
						+ ((srcBytes[srcOffset + 6] & 0xff) << 8) //
						+ ((srcBytes[srcOffset + 7] & 0xff) << 0) //
				);
	}

	/** 2 bytes
	 *
	 * @param srcBytes
	 * @param srcOffset
	 * @return */
	@ReflectionExplicit
	public static final short readShort(final byte[] srcBytes, final int srcOffset) {

		return (short) (((srcBytes[srcOffset + 0] & 0xff) << 8) + ((srcBytes[srcOffset + 1] & 0xff) << 0));
	}

	/** @param oneByte
	 * @return buffer */
	@ReflectionExplicit
	public static final TransferBuffer singletonBuffer(final byte oneByte) {

		return Transfer.IMPL.singletonBuffer(oneByte);
	}

	/** @param oneByte
	 * @return copier */
	@ReflectionExplicit
	public static final TransferCopier singletonCopier(final byte oneByte) {

		return Transfer.IMPL.singletonCopier(oneByte);
	}

	/** @param in
	 * @param out
	 * @param close
	 * @return byte count
	 * @throws IOException */
	@ReflectionExplicit
	public static final int toStream(final InputStream in, final OutputStream out, final boolean close) throws IOException {

		try {
			final byte[] buffer = new byte[Transfer.BUFFER_MEDIUM];
			for (int count = 0;;) {
				final int i = in.read(buffer);
				if (i <= 0) {
					return count;
				}
				count += i;
				out.write(buffer, 0, i);
			}
		} finally {
			// behavior.returnBuffer(buffer);
			if (close) {
				try {
					in.close();
				} catch (final Throwable t) {
					// ignore
				}
				try {
					out.close();
				} catch (final Throwable t) {
					// ignore
				}
			}
		}
	}

	/** @param buf
	 * @param out
	 * @return byte count
	 * @throws IOException */
	@ReflectionExplicit
	public static final int toStream(final TransferBuffer buf, final DataOutput out) throws IOException {

		final long remaining = buf.remaining();
		if (remaining == 0) {
			return 0;
		}
		if (remaining < Transfer.BUFFER_SMALL || buf.isDirectAbsolutely()) {
			final byte[] bytes = buf.toDirectArray();
			out.write(bytes);
			return bytes.length;
		}
		if (buf.isSequence()) {
			for (int count = 0;;) {
				if (!buf.hasRemaining()) {
					return count;
				}
				final TransferBuffer next = buf.nextSequenceBuffer();
				if (next.hasRemaining()) {
					count += Transfer.toStream(next, out);
				}
			}
		}
		{
			final byte[] buffer = new byte[(int) Math.min(remaining, Transfer.BUFFER_MEDIUM)];
			try (final InputStream in = buf.toInputStream()) {
				for (int count = 0;;) {
					final int i = in.read(buffer);
					if (i <= 0) {
						return count;
					}
					count += i;
					out.write(buffer, 0, i);
				}
			}
		}
	}

	/** @param buf
	 * @param out
	 * @param close
	 * @return byte count
	 * @throws IOException */
	@ReflectionExplicit
	public static final int toStream(final TransferBuffer buf, final OutputStream out, final boolean close) throws IOException {

		try {
			final long remaining = buf.remaining();
			if (remaining == 0) {
				return 0;
			}
			if (remaining < Transfer.BUFFER_SMALL || buf.isDirectAbsolutely()) {
				final byte[] bytes = buf.toDirectArray();
				out.write(bytes);
				return bytes.length;
			}
			if (buf.isSequence()) {
				for (int count = 0;;) {
					if (!buf.hasRemaining()) {
						return count;
					}
					final TransferBuffer next = buf.nextSequenceBuffer();
					if (next.hasRemaining()) {
						count += Transfer.toStream(next, out, false);
					}
				}
			}
			{
				final byte[] buffer = new byte[(int) Math.min(remaining, Transfer.BUFFER_MEDIUM)];
				try (final InputStream in = buf.toInputStream()) {
					for (int count = 0;;) {
						final int i = in.read(buffer);
						if (i <= 0) {
							return count;
						}
						count += i;
						out.write(buffer, 0, i);
					}
				}
			}
		} finally {
			if (close) {
				try {
					out.close();
				} catch (final Throwable t) {
					Report.exception("AE3TRANSFER", "Close fail", t);
				}
			}
		}
	}

	/** @param binary
	 * @param out
	 * @return byte count
	 * @throws IOException */
	@ReflectionExplicit
	public static final int toStream(final TransferCopier binary, final DataOutput out) throws IOException {

		return Transfer.toStream(binary.nextCopy(), out);
	}

	/** @param binary
	 * @param out
	 * @param close
	 * @return byte count
	 * @throws IOException */
	@ReflectionExplicit
	public static final int toStream(final TransferCopier binary, final OutputStream out, final boolean close) throws IOException {

		return Transfer.toStream(binary.nextCopy(), out, close);
	}

	/** @param digest
	 * @param binary
	 * @return
	 * @throws IOException
	 * @throws IllegalArgumentException
	 * @throws ConcurrentModificationException */
	@ReflectionExplicit
	public static final MessageDigest updateMessageDigest(final MessageDigest digest, final Object binary)
			throws ConcurrentModificationException, IllegalArgumentException, IOException {

		if (binary == null) {
			return digest;
		}
		if (binary instanceof TransferCopier) {
			return ((TransferCopier) binary).updateMessageDigest(digest);
		}
		if (binary instanceof byte[]) {
			digest.update((byte[]) binary);
			return digest;
		}
		Transfer.createCopierFromBinary(binary).updateMessageDigest(digest);
		return digest;
	}

	/** @param digest
	 * @param binary
	 * @param offset
	 * @param length
	 * @return
	 * @throws IOException
	 * @throws IllegalArgumentException
	 * @throws ConcurrentModificationException
	 * @throws DigestException */
	@ReflectionExplicit
	public static final MessageDigest updateMessageDigest(final MessageDigest digest, final Object binary, final long offset, final long length)
			throws ConcurrentModificationException, IllegalArgumentException, IOException, DigestException {

		if (binary == null) {
			return digest;
		}
		if (binary instanceof TransferCopier) {
			return ((TransferCopier) binary).slice(offset, length).updateMessageDigest(digest);
		}
		if (binary instanceof final byte[] bytes) {
			if (offset < bytes.length) {
				digest.update(bytes, (int) offset, (int) Math.min(bytes.length - offset, length));
			}
			return digest;
		}
		Transfer.createCopierFromBinary(binary).slice(offset, length).updateMessageDigest(digest);
		return digest;
	}

	/** @param bytes
	 * @return buffer */
	@ReflectionExplicit
	public static final TransferBuffer wrapBuffer(final byte[] bytes) {

		if (bytes == null) {
			return TransferBuffer.NUL_BUFFER;
		}
		final int length = bytes.length;
		return length == 0
			? TransferBuffer.NUL_BUFFER
			: Transfer.IMPL.wrapBuffer(bytes, 0, length);
	}

	/** @param bytes
	 * @param offset
	 * @param length
	 * @return buffer */
	@ReflectionExplicit
	public static final TransferBuffer wrapBuffer(final byte[] bytes, final int offset, final int length) {

		return length == 0
			? TransferBuffer.NUL_BUFFER
			: Transfer.IMPL.wrapBuffer(bytes, offset, length);
	}

	/** @param bytes
	 * @return copier */
	@ReflectionExplicit
	public static final TransferCopier wrapCopier(final byte[] bytes) {

		if (bytes == null) {
			return TransferCopier.NUL_COPIER;
		}
		final int length = bytes.length;
		return length == 0
			? TransferCopier.NUL_COPIER
			: Transfer.IMPL.wrapCopier(bytes, 0, length);
	}

	/** @param bytes
	 * @param offset
	 * @param length
	 * @return copier */
	@ReflectionExplicit
	public static final TransferCopier wrapCopier(final byte[] bytes, final int offset, final int length) {

		return length == 0
			? TransferCopier.NUL_COPIER
			: Transfer.IMPL.wrapCopier(bytes, offset, length);
	}

	/** @param value
	 * @param dstBytes
	 * @param dstOffset
	 * @return
	 * @throws IOException
	 * @throws IllegalArgumentException
	 * @throws ConcurrentModificationException */
	@ReflectionExplicit
	public static final int writeBoolean(final boolean value, final byte[] dstBytes, final int dstOffset)
			throws ConcurrentModificationException, IllegalArgumentException, IOException {

		dstBytes[dstOffset] = value
			? (byte) 1
			: (byte) 0;
		return 1;
	}

	/** @param value
	 * @param dstBytes
	 * @param dstOffset
	 * @return
	 * @throws IOException
	 * @throws IllegalArgumentException
	 * @throws ConcurrentModificationException */
	@ReflectionExplicit
	public static final int writeByte(final int value, final byte[] dstBytes, final int dstOffset) throws ConcurrentModificationException, IllegalArgumentException, IOException {

		dstBytes[dstOffset] = (byte) value;
		return 1;
	}

	/** @param value
	 * @param exactLength
	 * @param dstBytes
	 * @param dstOffset
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IOException */
	@ReflectionExplicit
	public static final int writeBytesExact(final byte[] value, final int exactLength, final byte[] dstBytes, final int dstOffset) throws IllegalArgumentException, IOException {

		if (value == null) {
			throw new IllegalArgumentException("source bytes is NULL!");
		}

		if (value.length != exactLength) {
			throw new IllegalArgumentException("Exact length doesn't match: valueLength: " + value.length + ", expectLength: " + exactLength);
		}

		System.arraycopy(value, 0, dstBytes, dstOffset, exactLength);
		return exactLength;
	}

	/** @param value
	 * @param dstBytes
	 * @param dstOffset
	 * @return
	 * @throws IOException
	 * @throws IllegalArgumentException
	 * @throws ConcurrentModificationException */
	@ReflectionExplicit
	public static final int writeFloat(final float value, final byte[] dstBytes, final int dstOffset)
			throws ConcurrentModificationException, IllegalArgumentException, IOException {

		return Transfer.writeInt(Float.floatToIntBits(value), dstBytes, dstOffset);
	}

	/** @param value
	 * @param dstBytes
	 * @param dstOffset
	 * @return
	 * @throws IOException
	 * @throws IllegalArgumentException
	 * @throws ConcurrentModificationException */
	@ReflectionExplicit
	public static final int writeInt(final int value, final byte[] dstBytes, final int dstOffset) throws ConcurrentModificationException, IllegalArgumentException, IOException {

		dstBytes[dstOffset + 0] = (byte) (value >> 24 & 0xFF);
		dstBytes[dstOffset + 1] = (byte) (value >> 16 & 0xFF);
		dstBytes[dstOffset + 2] = (byte) (value >> 8 & 0xFF);
		dstBytes[dstOffset + 3] = (byte) (value >> 0 & 0xFF);
		return 4;
	}

	/** @param value
	 * @param dstBytes
	 * @param dstOffset
	 * @return
	 * @throws IOException
	 * @throws IllegalArgumentException
	 * @throws ConcurrentModificationException */
	@ReflectionExplicit
	public static final int writeInt24(final int value, final byte[] dstBytes, final int dstOffset) throws ConcurrentModificationException, IllegalArgumentException, IOException {

		dstBytes[dstOffset + 1] = (byte) (value >> 16 & 0xFF);
		dstBytes[dstOffset + 2] = (byte) (value >> 8 & 0xFF);
		dstBytes[dstOffset + 3] = (byte) (value >> 0 & 0xFF);
		return 3;
	}

	/** 8 bytes
	 *
	 * @param value
	 * @param dstBytes
	 * @param dstOffset
	 * @return
	 * @throws IOException
	 * @throws IllegalArgumentException
	 * @throws ConcurrentModificationException */
	@ReflectionExplicit
	public static final int writeLong(final long value, final byte[] dstBytes, final int dstOffset) throws ConcurrentModificationException, IllegalArgumentException, IOException {

		dstBytes[dstOffset + 0] = (byte) (value >> 56 & 0xFF);
		dstBytes[dstOffset + 1] = (byte) (value >> 48 & 0xFF);
		dstBytes[dstOffset + 2] = (byte) (value >> 40 & 0xFF);
		dstBytes[dstOffset + 3] = (byte) (value >> 32 & 0xFF);
		dstBytes[dstOffset + 4] = (byte) (value >> 24 & 0xFF);
		dstBytes[dstOffset + 5] = (byte) (value >> 16 & 0xFF);
		dstBytes[dstOffset + 6] = (byte) (value >> 8 & 0xFF);
		dstBytes[dstOffset + 7] = (byte) (value >> 0 & 0xFF);
		return 8;
	}

	/** 2 bytes
	 *
	 * @param value
	 * @param dstBytes
	 * @param dstOffset
	 * @return
	 * @throws IOException
	 * @throws IllegalArgumentException
	 * @throws ConcurrentModificationException */
	@ReflectionExplicit
	public static final int writeShort(final int value, final byte[] dstBytes, final int dstOffset) throws ConcurrentModificationException, IllegalArgumentException, IOException {

		dstBytes[dstOffset + 0] = (byte) (value >> 8 & 0xFF);
		dstBytes[dstOffset + 1] = (byte) (value >> 0 & 0xFF);
		return 2;
	}

	/** @param string
	 * @param dstBytes
	 * @param dstOffset
	 * @return */
	@ReflectionExplicit
	public static final int writeStringZeroEndUtf8(final CharSequence string, final byte[] dstBytes, final int dstOffset) {

		if (string == null || string.length() == 0) {
			dstBytes[dstOffset + 0] = 0;
			return 1;
		}
		final byte[] bytes = string.toString().getBytes(StandardCharsets.UTF_8);
		System.arraycopy(bytes, 0, dstBytes, dstOffset, bytes.length);
		dstBytes[dstOffset + bytes.length] = 0;
		return bytes.length + 1;
	}

	/** @param byteBuffer
	 * @param offset
	 * @param xorBinary
	 * @param length
	 * @return
	 * @throws ConcurrentModificationException
	 * @throws IllegalArgumentException
	 * @throws IOException */
	@ReflectionExplicit
	public static final int xorBytes(final byte[] byteBuffer, final int offset, final Object xorBinary, final int length)
			throws ConcurrentModificationException, IllegalArgumentException, IOException {

		final byte[] xor;
		if (xorBinary == null) {
			throw new NullPointerException("xorBinary is NULL!");
		}
		if (xorBinary instanceof byte[]) {
			xor = (byte[]) xorBinary;
		} else {
			xor = Transfer.createCopierFromBinary(xorBinary).nextDirectArray();
		}

		final int limit = Math.min(length, byteBuffer.length - offset);
		for (int i = offset, x = 0, c = xor.length; x < limit;) {
			byteBuffer[i++] ^= xor[x++ % c];
		}

		return limit;
	}

	/** @param srcBinary
	 * @param srcOffset
	 * @param xorBinary
	 * @param dstBytes
	 * @param dstOffset
	 * @param length
	 * @return
	 * @throws ConcurrentModificationException
	 * @throws IllegalArgumentException
	 * @throws IOException */
	@ReflectionExplicit
	public static final int xorBytes(final Object srcBinary, final long srcOffset, final Object xorBinary, final byte[] dstBytes, final int dstOffset, final int length)
			throws ConcurrentModificationException, IllegalArgumentException, IOException {

		final byte[] xor;
		if (xorBinary == null) {
			throw new NullPointerException("xorBinary is NULL!");
		}
		if (xorBinary instanceof byte[]) {
			xor = (byte[]) xorBinary;
		} else {
			xor = Transfer.createCopierFromBinary(xorBinary).nextDirectArray();
		}

		final int limit = Math.min(length, dstBytes.length - dstOffset);
		if (srcBinary instanceof TransferCopier) {
			((TransferCopier) srcBinary).copy(srcOffset, dstBytes, dstOffset, limit);
		} else {
			final TransferCopier src = Transfer.createCopierFromBinary(srcBinary);
			src.copy(srcOffset, dstBytes, dstOffset, limit);
		}

		for (int i = dstOffset, x = 0, c = xor.length; x < limit;) {
			dstBytes[i++] ^= xor[x++ % c];
		}

		return limit;
	}

	private Transfer() {

		// empty
	}
}
