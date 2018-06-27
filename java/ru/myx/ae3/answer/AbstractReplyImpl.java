package ru.myx.ae3.answer;

import java.io.File;

import ru.myx.ae3.base.BaseMessage;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.binary.TransferBuffer;
import ru.myx.ae3.binary.TransferCopier;
import ru.myx.ae3.vfs.EntryBinary;

abstract class AbstractReplyImpl {
	
	public abstract BinaryReplyAnswer<?> binary(final String owner, final BaseMessage query, final BaseObject attributes, final TransferBuffer buffer, final String fileName);

	public abstract BinaryReplyAnswer<?> binary(final String owner, final BaseMessage query, final BaseObject attributes, final TransferCopier copier, final String fileName);

	public abstract UniversalReplyAnswer<?> binaryAndCharacter(String owner, BaseMessage query, BaseObject attributes, TransferCopier copier, CharSequence text);

	public abstract CharacterReplyAnswer<?> character(final String owner, final BaseMessage query, final BaseObject attributes, final CharSequence text);

	public abstract UniversalReplyAnswer<?> empty(final String owner, final BaseMessage query, final BaseObject attributes);

	public abstract ReplyAnswer entry(final String owner, final BaseMessage query, final BaseObject attributes, final EntryBinary file, final String fileName);

	public abstract ReplyAnswer file(final String owner, final BaseMessage query, final BaseObject attributes, final File file, final String fileName);

	public abstract ReplyAnswer object(final String owner, final BaseMessage query, final BaseObject attributes, final Object o);

	public abstract BinaryReplyAnswer<?> wrap(final String owner, final BaseMessage query, final BaseObject attributes, final byte[] bytes, final String fileName);

	public abstract UniversalReplyAnswer<?> wrapBinaryReplyAsUniversal(BinaryReplyAnswer<?> binaryReply, BaseObject attributes, CharSequence text);

	public abstract UniversalReplyAnswer<?> wrapCharacterReplyAsUniversal(CharacterReplyAnswer<?> characterReply, BaseObject attributes, TransferCopier binary);

}
