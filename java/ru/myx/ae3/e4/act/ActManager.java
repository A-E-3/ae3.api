package ru.myx.ae3.e4.act;

import java.util.concurrent.Future;
import java.util.function.Function;

import ru.myx.ae3.e4.run.RunManager;

/**
 * 
 * @author myx
 * 		
 */
public interface ActManager extends RunManager {
	
	<T, R> Future<R> launchTask(Function<T, R> function, T argument);
	
	@Override
	default ActTaskBuilder design() {
		
		return null;
	}
	
	<V> ActTaskContext<V> launchTaskBuilder();
}
