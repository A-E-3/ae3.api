package ru.myx.ae3.flow;

import java.io.File;

import ru.myx.ae3.base.BaseMessage;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.binary.TransferCopier;
import ru.myx.ae3.vfs.Entry;
import ru.myx.ae3.vfs.EntryBinary;

abstract class AbstractFlowImpl {
	
	public abstract BinaryMessage<?> binary(
			final String owner,
			final String title,
			final BaseObject attributes,
			final TransferCopier buf);
	
	public abstract UniversalMessage<?> binaryAndCharacter(
			String owner,
			String title,
			BaseObject attributes,
			TransferCopier binary,
			CharSequence text);
	
	public abstract CharacterMessage<?> character(
			final String owner,
			final String title,
			final BaseObject attributes,
			final String text);
	
	public abstract UniversalMessage<?> empty(final String owner, //
			final String title,
			final BaseObject attributes);
	
	public abstract BaseMessage entry(
			final String owner,
			final String title,
			final BaseObject attributes,
			final Entry entry);
	
	public abstract BaseMessage entry(
			String owner,
			String title,
			BaseObject attributes,
			EntryBinary entry,
			String fileName);
	
	public abstract BaseMessage file(
			final String owner,
			final String title,
			final BaseObject attributes,
			final File file);
	
	public abstract UniversalMessage<?> nullMessage();
	
	public abstract BaseMessage object(
			final String owner,
			final String title,
			final BaseObject attributes,
			final Object obj);
	
	public abstract BaseMessage sequence(//
			final String owner,
			final String title,
			final BaseObject attributes,
			final BaseMessage[] sequence);
	
	public abstract UniversalMessage<?> wrapBinaryMessageAsUniversal(
			BinaryMessage<?> binaryMessage,
			BaseObject attributes,
			CharSequence string);
	
	public abstract UniversalMessage<?> wrapCharacterMessageAsUniversal(
			CharacterMessage<?> characterMessage,
			BaseObject attributes,
			TransferCopier binary);
}
