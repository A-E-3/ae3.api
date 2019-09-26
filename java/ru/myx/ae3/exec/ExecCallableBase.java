package ru.myx.ae3.exec;

import ru.myx.ae3.reflect.ReflectionDisable;

/** @author myx */
@ReflectionDisable
public interface ExecCallableBase extends ExecCallable {

	/** @author myx */
	@ReflectionDisable
	interface ExecStore0
			extends //
				ExecCallable.Arguments.Exactly0,
				ExecCallable.ForStore.UseStore0 {
		//
	}

	/** @author myx */
	@ReflectionDisable
	interface ExecStore1
			extends //
				ExecCallable.Arguments.Exactly1,
				ExecCallable.ForStore.UseStore1 {
		//
	}

	/** @author myx */
	@ReflectionDisable
	interface ExecStore2
			extends //
				ExecCallable.Arguments.Exactly2,
				ExecCallable.ForStore.UseStore2 {
		//
	}
	
	/** @author myx */
	@ReflectionDisable
	interface ExecStoreX
			extends //
				ExecCallable.Arguments.ExactlyX,
				ExecCallable.ForStore.UseStoreX {
		//
	}

	/** @author myx */
	@ReflectionDisable
	public static interface NativeJ
			extends //
				ExecCallable.ForStore.UseNativeJ {
		//
	}
	//

	/** @author myx */
	@ReflectionDisable
	public static interface NativeJ2
			extends //
				ExecCallable.Arguments.Exactly2,
				ExecCallable.ForStore.UseNativeJ2 {
		//
	}

	/** @author myx */
	@ReflectionDisable
	public static interface NativeJA
			extends //
				ExecCallable.Arguments.ExactlyX,
				ExecCallable.ForStore.UseNativeJA {
		//
	}
	//
}
