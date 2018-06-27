package ru.myx.ae3.vfs;

import ru.myx.ae3.base.BaseAbstract;
import ru.myx.ae3.base.BaseHost;
import ru.myx.ae3.base.BaseObjectNoOwnProperties;
import ru.myx.ae3.reflect.ReflectionExplicit;
import ru.myx.ae3.reflect.ReflectionManual;

/** Used for VFS context root specification only
 *
 * @author myx */
@ReflectionManual
public abstract class EntryVfsRoot extends BaseAbstract implements BaseHost, Entry, BaseObjectNoOwnProperties {
	
	@Override
	public String getLocation() {

		return "/";
	}

	@Override
	public TreeLinkType getMode() {

		return TreeLinkType.NO_REFERENCE;
	}

	@Override
	public Entry getParent() {

		return null;
	}

	@Override
	public boolean isContainer() {

		return true;
	}

	@Override
	public boolean isExist() {

		return true;
	}

	/** @return true */
	@ReflectionExplicit
	public boolean isRoot() {
		
		return true;
	}

	@Override
	public abstract String toString();
}
