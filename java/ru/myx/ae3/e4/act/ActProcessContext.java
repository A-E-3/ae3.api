package ru.myx.ae3.e4.act;

import ru.myx.ae3.e4.context.FrameContext;
import ru.myx.ae3.e4.run.RunProcessContext;

/** @author myx */
public interface ActProcessContext extends RunProcessContext, ActManager {

	/** @param frame
	 * @return */
	ActTaskContext launch(FrameContext<?> frame);

	/** @param service
	 * @return */
	ActThreadContext start(FrameContext<?> service);
}
