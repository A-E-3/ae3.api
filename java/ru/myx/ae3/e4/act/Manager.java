package ru.myx.ae3.e4.act;

import ru.myx.ae3.AbstractSAPI;
import ru.myx.ae3.Engine;
import ru.myx.ae3.flow.ObjectSource;
import ru.myx.ae3.flow.ObjectTarget;

/**
 * FIXME: TODO:
 * 
 * @author myx
 * 		
 * @param <T>
 */
public interface Manager<T extends Task<?>> {
	
	/**
	 * @author myx
	 * 		
	 */
	public static class Factory extends AbstractSAPI {
		
		/**
		 * Inspects the ProcessExecutionType runtime annotation on the class
		 * given and returns one of the common thread management profiles
		 * defaulting to SINGLE_THREAD.
		 * 
		 * @param driver
		 * @return
		 */
		public static Manager.Factory.TYPE getManagerType(Object driver) {
			
			final ProcessExecutionType execute = driver.getClass().getAnnotation(ProcessExecutionType.class);
			
			return execute != null
				? execute.type()
				: Manager.Factory.TYPE.SINGLE_THREAD;
		}
		
		abstract static class Implement {
			
			public abstract <T extends Task<?>, W extends Worker<T>> ManagerService<T>//
					createSingleThreadManager(final String name, final ObjectSource<W> workerSource, final ObjectTarget<W> workerRecycler);
					
			public abstract <T extends Task<?>, W extends Worker<T>> ManagerService<T> //
					createWorkerPoolManager(final String name, final int poolSize, final ObjectSource<W> workerSource, final ObjectTarget<W> workerRecycler);
					
			public abstract <T extends Task<?>, W extends Worker<T>> ManagerService<T> //
					createWorkerPoolManager(final String name, final ObjectSource<W> workerSource, final ObjectTarget<W> workerRecycler);
					
			public abstract <T extends Task<?>, W extends Worker<T>> ManagerService<T> //
					createWorkerStickyManager(final String name, final int stickyCount, final ObjectSource<W> workerSource, final ObjectTarget<W> workerRecycler);
					
			public abstract <T extends Task<?>, W extends Worker<T>> ManagerService<T> //
					createWorkerStickyManager(final String name, final ObjectSource<W> workerSource, final ObjectTarget<W> workerRecycler);
					
			public abstract <T extends Task<?>, W extends Worker<T>> ManagerService<T> //
					createUniworkerInlineManager(final String name, final ObjectSource<W> workerSource, final ObjectTarget<W> workerRecycler);
					
			public abstract <T extends Task<?>> ManagerService<T> //
					createUniworkerInlineManager(final Worker<T> worker);
					
			public abstract <T extends Task<?>, W extends Worker<T>> ManagerService<T>//
					createUniworkerParallelManager(final String name, final ObjectSource<W> workerSource, final ObjectTarget<W> workerRecycler);
					
			public abstract <T extends Task<?>> ManagerService<T>//
					createUniworkerParallelManager(final Worker<T> worker);
					
			public abstract <T extends Task<?>, W extends Worker<T>> ManagerService<T>//
					createParallelManager(final String name, final ObjectSource<W> workerSource, final ObjectTarget<W> workerRecycler);
		}
		
		/**
		 * 
		 * @author myx
		 * 		
		 */
		public static enum TYPE {
			/**
			 * 
			 */
			UNIWORKER_INLINE {
				
				@Override
				public <T extends Task<?>, W extends Worker<T>> //
						ManagerService<T>
								createManager(final String name, final ObjectSource<W> workerSource, final ObjectTarget<W> workerRecycler) {
								
					return Manager.Factory.IMPL.createUniworkerInlineManager(name, workerSource, workerRecycler);
				}
			}, //
			/**
			 * 
			 */
			UNIWORKER_PARALLEL {
				
				@Override
				public <T extends Task<?>, W extends Worker<T>> //
						ManagerService<T>
								createManager(final String name, final ObjectSource<W> workerSource, final ObjectTarget<W> workerRecycler) {
								
					return Manager.Factory.IMPL.createUniworkerParallelManager(name, workerSource, workerRecycler);
				}
			}, //
			/**
			 * 
			 */
			PARALLEL_UNLIMITED {
				
				@Override
				public <T extends Task<?>, W extends Worker<T>> //
						ManagerService<T>
								createManager(final String name, final ObjectSource<W> workerSource, final ObjectTarget<W> workerRecycler) {
								
					return Manager.Factory.IMPL.createParallelManager(name, workerSource, workerRecycler);
				}
			}, //
			/**
			 * 
			 */
			SINGLE_THREAD {
				
				@Override
				public <T extends Task<?>, W extends Worker<T>> //
						ManagerService<T>
								createManager(final String name, final ObjectSource<W> workerSource, final ObjectTarget<W> workerRecycler) {
								
					return Manager.Factory.IMPL.createSingleThreadManager(name, workerSource, workerRecycler);
				}
			}, //
			/**
			 * 
			 */
			WORKER_POOL {
				
				@Override
				public <T extends Task<?>, W extends Worker<T>> //
						ManagerService<T>
								createManager(final String name, final ObjectSource<W> workerSource, final ObjectTarget<W> workerRecycler) {
								
					return Manager.Factory.IMPL.createWorkerPoolManager(name, workerSource, workerRecycler);
				}
			}, //
			/**
			 * 
			 */
			WORKER_STICKY {
				
				@Override
				public <T extends Task<?>, W extends Worker<T>> //
						ManagerService<T>
								createManager(final String name, final ObjectSource<W> workerSource, final ObjectTarget<W> workerRecycler) {
								
					return Manager.Factory.IMPL.createWorkerStickyManager(name, workerSource, workerRecycler);
				}
			}, //
			;
			
			/**
			 * @param name
			 * @param workerSource
			 * @param workerRecycler
			 * @return
			 */
			public abstract <T extends Task<?>, W extends Worker<T>> //
					ManagerService<T>
							createManager(String name, ObjectSource<W> workerSource, ObjectTarget<W> workerRecycler);
		}
		
		static final Implement IMPL;
		
		static {
			/**
			 * this block should go last
			 */
			{
				IMPL = AbstractSAPI.createObject("ru.myx.ae3.e4.act.ImplementManagerFactory");
			}
		}
		
		/**
		 * unlimited parallel manager, usable for real-cheap worker
		 * initializations and destructions.
		 * 
		 * @param name
		 * @param workerSource
		 * @param workerRecycler
		 * 			
		 * @return
		 */
		public static final <T extends Task<?>, W extends Worker<T>> //
				ManagerService<T>
						createParallelManager(final String name, final ObjectSource<W> workerSource, final ObjectTarget<W> workerRecycler) {
						
			return Factory.IMPL.createParallelManager(name, workerSource, workerRecycler);
		}
		
		//
		/**
		 * 
		 * @param name
		 * @param workerSource
		 * @param workerRecycler
		 * @return
		 */
		public static final <T extends Task<?>, W extends Worker<T>> //
				ManagerService<T>
						createSingleThreadManager(final String name, final ObjectSource<W> workerSource, final ObjectTarget<W> workerRecycler) {
						
			return Factory.IMPL.createSingleThreadManager(name, workerSource, workerRecycler);
		}
		
		/**
		 * same worker is used for all tasks
		 * 
		 * @param name
		 * @param workerSource
		 * @param workerRecycler
		 * 			
		 * @return
		 */
		public static final <T extends Task<?>, W extends Worker<T>> //
				ManagerService<T>
						createUniworkerInlineManager(final String name, final ObjectSource<W> workerSource, final ObjectTarget<W> workerRecycler) {
						
			return Factory.IMPL.createUniworkerInlineManager(name, workerSource, workerRecycler);
		}
		
		/**
		 * same worker is used for all tasks, no worker initialization or
		 * recycling.
		 * 
		 * @param worker
		 * @return
		 */
		public static final <T extends Task<?>> ManagerService<T>//
				createUniworkerInlineManager(final Worker<T> worker) {
				
			return Factory.IMPL.createUniworkerInlineManager(worker);
		}
		
		/**
		 * same worker is used for all tasks
		 * 
		 * @param name
		 * @param workerSource
		 * @param workerRecycler
		 * 			
		 * @return
		 */
		public static final <T extends Task<?>, W extends Worker<T>> ManagerService<T>//
				createUniworkerParallelManager(final String name, final ObjectSource<W> workerSource, final ObjectTarget<W> workerRecycler) {
				
			return Factory.IMPL.createUniworkerParallelManager(name, workerSource, workerRecycler);
		}
		
		/**
		 * same worker is used for all tasks, no worker initialization or
		 * recycling.
		 * 
		 * @param worker
		 * @return
		 */
		public static final <T extends Task<?>> //
				ManagerService<T>
						createUniworkerParallelManager(final Worker<T> worker) {
						
			return Factory.IMPL.createUniworkerParallelManager(worker);
		}
		
		/**
		 * 
		 * @param name
		 * @param workerSource
		 * @param workerRecycler
		 * @return
		 */
		public static final <T extends Task<?>, W extends Worker<T>> ManagerService<T>//
				createWorkerPoolManager(final String name, final ObjectSource<W> workerSource, final ObjectTarget<W> workerRecycler) {
				
			if (Engine.MODE_SPEED) {
				return Factory.IMPL.createWorkerPoolManager(
						name, //
						Math.max(64, Math.min(4, Engine.PARALLELISM * 3 / 2 + 5)),
						workerSource,
						workerRecycler);
			} else //
			if (Engine.MODE_SIZE) {
				return Factory.IMPL.createWorkerPoolManager(
						name, //
						Math.max(32, Math.min(2, Engine.PARALLELISM / 2 + 2)),
						workerSource,
						workerRecycler);
			} else {
				return Factory.IMPL.createWorkerPoolManager(
						name, //
						Math.max(64, Math.min(4, Engine.PARALLELISM + 3)),
						workerSource,
						workerRecycler);
			}
			
		}
		
		/**
		 * 
		 * @param name
		 * @param workerSource
		 * @param workerRecycler
		 * @return
		 */
		public static final <T extends Task<?>, W extends Worker<T>> ManagerService<T>//
				createWorkerStickyManager(final String name, final ObjectSource<W> workerSource, final ObjectTarget<W> workerRecycler) {
				
			return Factory.IMPL.createWorkerStickyManager(
					name, //
					Engine.PARALLELISM * (Engine.MODE_SPEED
						? 2
						: 1),
					workerSource,
					workerRecycler);
		}
	}
	
	/**
	 * 
	 * @param task
	 * @throws IllegalArgumentException
	 * @throws IllegalStateException
	 */
	// Future<V>
	void enqueue(T task) throws IllegalArgumentException, IllegalStateException;
	
}
