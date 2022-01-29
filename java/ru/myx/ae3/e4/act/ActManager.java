package ru.myx.ae3.e4.act;

import java.util.concurrent.Future;
import java.util.function.Function;

import ru.myx.ae3.e4.run.RunManager;

/** @author myx */
public interface ActManager extends RunManager {

	@Override
	default ActTaskBuilder design() {

		return null;
	}

	<T, R> Future<R> launchTask(Function<T, R> function, T argument);

	<V> ActTaskContext<V> launchTaskBuilder();
}
