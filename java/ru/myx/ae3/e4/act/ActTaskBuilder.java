package ru.myx.ae3.e4.act;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Supplier;

import ru.myx.ae3.e4.run.RunTaskBuilder;

public interface ActTaskBuilder extends RunTaskBuilder {
	
	static void example() {
		
		Act4.createProcess("Example Process").design()//
				.setTaskTitle("Example Task")//
				.executeSingle(() -> System.out.println("Hello!"))//
				.launchLater(10, TimeUnit.SECONDS);
				
		Act4.createProcess("Example Process").design()//
				.setTaskTitle("Example Task")//
				.executeSingle("Hello!", (x) -> System.out.println(x))//
				.launchLater(10, TimeUnit.SECONDS);
				
		Act4.createProcess("Example Process").design()//
				.setTaskTitle("Example Task")//
				.executeSingle(() -> "Hello!", (x) -> System.out.println(x))//
				.launchLater(10, TimeUnit.SECONDS);
				
		Act4.createProcess("Example Process").design()//
				.setTaskTitle("Example Task")//
				.executeSingle((x) -> System.out.println(x), () -> "Hello!")//
				.launchLater(10, TimeUnit.SECONDS);
				
	}
	
	@Override
			ActTaskBuilder setTaskTitle(CharSequence title);
			
	<V> ActTaskBuilder executeSingle(V Object, Consumer<V> consumer);
	
	<V> ActTaskBuilder executeSingle(Supplier<V> producer, Consumer<V> consumer);
	
	<V> ActTaskBuilder executeSingle(Consumer<V> consumer, Callable<V> callable);
}
