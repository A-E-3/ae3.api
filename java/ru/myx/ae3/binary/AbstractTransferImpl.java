package ru.myx.ae3.binary;

import java.io.File;
import java.nio.file.Path;

abstract class AbstractTransferImpl {
	
	
	public abstract TransferBuffer createBuffer(final byte[] bytes, final int offset, final int length);
	
	public abstract TransferBuffer createBuffer(final File file);
	
	public abstract TransferBuffer createBuffer(final File file, final long skip, final long limit);
	
	public abstract TransferBuffer createBufferFromBase64(CharSequence base64);
	
	public abstract TransferCollector createCollector();
	
	public abstract TransferCopier createCopier(final byte[] bytes, final int offset, final int length);
	
	public abstract TransferCopier createCopier(final File file);
	
	public abstract TransferCopier createCopier(final File file, final long skip, final long limit);
	
	public abstract TransferCopier createCopier(final Path path);
	
	public abstract TransferCopier createCopierFromBase64(CharSequence base64);
	
	public abstract TransferDescription createDescription(final String name, final int priority);
	
	public abstract int getBufferLarge();
	
	public abstract int getBufferMax();
	
	public abstract int getBufferMedium();
	
	public abstract int getBufferSmall();
	
	public abstract TransferBuffer singletonBuffer(final byte oneByte);
	
	public abstract TransferCopier singletonCopier(final byte oneByte);
	
	/**
	 * No other checks, all basic checks are supposed to be in Transfer.
	 *
	 * @param bytes
	 * @param offset
	 * @param length
	 * @return
	 */
	public abstract TransferBuffer wrapBuffer(final byte[] bytes, final int offset, final int length);
	
	/**
	 * No other checks, all basic checks are supposed to be in Transfer.
	 *
	 * @param bytes
	 * @param offset
	 * @param length
	 * @return
	 */
	public abstract TransferCopier wrapCopier(final byte[] bytes, final int offset, final int length);
}
