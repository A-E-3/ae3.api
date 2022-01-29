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
				.executeSingle(new Runnable() {
					
					@Override
					public void run() {
						
						System.out.println("Hello!");
					}
				})//
				.launchLater(10, TimeUnit.SECONDS);

		Act4.createProcess("Example Process").design()//
				.setTaskTitle("Example Task")//
				.executeSingle("Hello!", new Consumer<String>() {
					
					@Override
					public void accept(String x) {
						
						System.out.println(x);
					}
				})//
				.launchLater(10, TimeUnit.SECONDS);

		Act4.createProcess("Example Process").design()//
				.setTaskTitle("Example Task")//
				.executeSingle(new Supplier<String>() {
					
					@Override
					public String get() {
						
						return "Hello!";
					}
				}, new Consumer<String>() {
					
					@Override
					public void accept(String x) {
						
						System.out.println(x);
					}
				})//
				.launchLater(10, TimeUnit.SECONDS);

		Act4.createProcess("Example Process").design()//
				.setTaskTitle("Example Task")//
				.executeSingle(new Consumer<String>() {
					
					@Override
					public void accept(String x) {
						
						System.out.println(x);
					}
				}, new Callable<String>() {
					
					@Override
					public String call() throws Exception {
						
						return "Hello!";
					}
				})//
				.launchLater(10, TimeUnit.SECONDS);

	}

	<V> ActTaskBuilder executeSingle(Consumer<V> consumer, Callable<V> callable);

	<V> ActTaskBuilder executeSingle(Supplier<V> producer, Consumer<V> consumer);

	<V> ActTaskBuilder executeSingle(V Object, Consumer<V> consumer);

	@Override
	ActTaskBuilder setTaskTitle(CharSequence title);
}
