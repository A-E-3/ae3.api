package ru.myx.ae3.common;

import java.security.MessageDigest;

import ru.myx.ae3.binary.TransferCopier;

/** @author myx */
public interface BodyAccessBinary extends BodyAccessUnknown {

	/** Must not return NULL when isBinary() returns true.
	 *
	 * @return binary */
	TransferCopier getBinary();

	/** Must not return NULL when isBinary() returns true.
	 *
	 * This method can return Future object.
	 *
	 * @return */
	Value<? extends TransferCopier> getBinaryContent();

	/** Must not return NULL when isBinary() returns true.
	 *
	 * Default implementation is: <code>
		return this.getBinary().length();
	 * </code>
	 *
	 * ATTN: Override only when providing better implementation!
	 *
	 * @return length in bytes */
	default long getBinaryContentLength() {

		return this.getBinary().length();
	}

	/** returns a checksum.
	 *
	 * Default implementation is: <code>
		return this.getBinary().getMessageDigest();
	 * </code>
	 *
	 * ATTN: Override only when providing better implementation!
	 *
	 * @return checksum */
	default MessageDigest getBinaryMessageDigest() {

		return this.getBinary().getMessageDigest();
	}

	@Override
	default boolean isBinary() {

		return true;
	}
}
