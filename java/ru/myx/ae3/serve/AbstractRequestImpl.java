package ru.myx.ae3.serve;

import java.io.File;

import ru.myx.ae3.base.BaseMessage;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.binary.TransferBuffer;
import ru.myx.ae3.binary.TransferCopier;
import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.vfs.EntryBinary;

abstract class AbstractRequestImpl {
	public abstract BinaryServeRequest<?> binary(
			final String owner,
			final String verb,
			final BaseMessage context,
			final BaseObject attributes,
			final TransferBuffer buffer,
			final String fileName);
	
	
	public abstract BinaryServeRequest<?> binary(
			final String owner,
			final String verb,
			final BaseMessage context,
			final BaseObject attributes,
			final TransferCopier copier,
			final String fileName);
	
	
	public abstract UniversalServeRequest<?> binaryAndCharacter(
			String owner,
			String verb,
			Object object,
			BaseObject attributes,
			TransferCopier binary,
			CharSequence text);
	
	
	public abstract CharacterServeRequest<?> character(
			final String owner,
			final String verb,
			final BaseMessage context,
			final BaseObject attributes,
			final CharSequence text);
	
	
	public abstract UniversalServeRequest<?> empty(
			final String owner,
			final String verb,
			final BaseMessage context,
			final BaseObject attributes);
	
	
	public abstract ServeRequest entry(
			final String owner,
			final String verb,
			final BaseMessage context,
			final BaseObject attributes,
			final EntryBinary file,
			final String fileName);
	
	
	public abstract ServeRequest file(
			final String owner,
			final String verb,
			final BaseMessage context,
			final BaseObject attributes,
			final File file,
			final String fileName);
	
	
	public abstract ServeRequest getNullRequest();
	
	
	public abstract ServeRequest getRootRequest();
	
	
	public abstract ServeRequest object(
			final String owner,
			final String verb,
			final BaseMessage context,
			final BaseObject attributes,
			final Object o);
	
	
	public abstract BaseObject queryHandler(
			ExecProcess ctx,
			BaseObject handler,
			BaseObject context) throws Exception;
	
	
	public abstract UniversalServeRequest<?> wrapBinaryRequestAsUniversal(
			BinaryServeRequest<?> binaryRequest,
			BaseObject attributes,
			CharSequence text);
	
	
	public abstract UniversalServeRequest<?> wrapCharacterRequestAsUniversal(
			CharacterServeRequest<?> characterRequest,
			BaseObject attributes,
			TransferCopier binary);
	
}
