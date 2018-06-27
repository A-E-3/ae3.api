package ru.myx.ae3.exec;

import ru.myx.ae3.base.BaseObject;

abstract class AbstractExecImpl {
	
	public abstract ExecProcess createProcess(final ExecProcess execParent, final ExecProcess callParent, final String title);
	
	public abstract ExecProcess createProcess(
			//
			ExecProcess parent, String title);
			
	public abstract <T extends BaseObject> ExecProcessVariable<T> createProcessVariable(
			//
			String key, boolean inheritable);
			
	public abstract ExecNonMaskedException createThrown(BaseObject message, final Object source, final Object detail);
	
	public abstract ExecProcess currentProcess();
	
	public abstract InheritableThreadLocal<ExecProcess> getAtLeastHolder();
	
	public abstract ExecProcess getRootProcess();
}
