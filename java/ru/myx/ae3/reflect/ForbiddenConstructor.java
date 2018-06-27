package ru.myx.ae3.reflect;

import ru.myx.ae3.base.BaseFunctionAbstract;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.exec.ExecCallableBoth;
import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;

final class ForbiddenConstructor extends BaseFunctionAbstract implements ExecCallableBoth.ExecStore0 {
	
	
	@Override
	public String toString() {
		
		
		return "[function ForbiddenConstructor]";
	}
	
	@Override
	public ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {
		
		
		return ctx.vmRaise("Constructor is not accessible (not allowed) for given java class");
	}
}
