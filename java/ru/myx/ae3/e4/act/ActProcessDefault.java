package ru.myx.ae3.e4.act;

import ru.myx.ae3.console.ConsoleLogger;
import ru.myx.ae3.e4.context.FrameContext;
import ru.myx.ae3.e4.run.RunFrameContext;
import ru.myx.ae3.e4.run.RunProcessContext;
import ru.myx.ae3.e4.run.RunProcessRooted;

/** @author myx */
class ActProcessDefault implements ActProcessContext, RunProcessRooted {

	@Override
	public ConsoleLogger getConsoleLogger() {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RunProcessContext getParentProcess() {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CharSequence getProcessTitle() {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <P extends RunProcessContext> void later(final RunFrameContext<P> frame, final long delayMillis) {

		// TODO Auto-generated method stub

	}

	@Override
	public ActTaskContext launch() {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActTaskContext launch(final FrameContext<?> frame) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <P extends RunProcessContext> void launch(final RunFrameContext<P> frame) {

		// TODO Auto-generated method stub

	}

	@Override
	public ActThreadContext start(final FrameContext<?> service) {

		// TODO Auto-generated method stub
		return null;
	}

}
