package ru.myx.ae3.vfs;

import java.io.File;
import java.util.Map;

import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.vfs.ars.ArsArray;
import ru.myx.ae3.vfs.ars.ArsRecord;
import ru.myx.ae3.vfs.ars.ArsReference;
import ru.myx.ae3.vfs.ars.ArsStorageImpl;

abstract class AbstractStorageImpl implements VfsStorage {
	public abstract//
	EntryContainer createEmpty();
	
	public abstract//
	EntryContainer createFileSystemRoot(File root, boolean readOnly);
	
	public abstract//
	EntryContainer createRamStorageRoot(String name);
	
	public abstract <O extends ArsRecord, R extends ArsReference<O>, A extends ArsArray<R>> //
	EntryContainer createRoot(final ArsStorageImpl<O, R, A> impl);
	
	public abstract//
	TransactionVfs createTransaction(ExecProcess ctx);
	
	public abstract//
	EntryContainer createUnionRoot(EntryContainer[] stack);
	
	public abstract//
	EntryVfsRoot createVfsRoot(EntryContainer root);
	
	public abstract//
	TransactionVfs ensureTransaction(ExecProcess ctx);
	
	public abstract//
	Map<Entry, Map<String, Entry>> getMounts();
	
	public abstract//
	Entry mount(final EntryContainer container, final String key, final Entry target);
	
	public abstract//
	Entry mount(final EntryContainer container, final String key, final TreeLinkType mode, final Entry target);
	
	public abstract//
	void postInit();
	
	public abstract//
	boolean unmount(final EntryMount mounted);
}
