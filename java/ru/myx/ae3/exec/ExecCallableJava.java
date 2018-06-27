package ru.myx.ae3.exec;

import ru.myx.ae3.reflect.ReflectionDisable;

/** @author myx */
@ReflectionDisable
public interface ExecCallableJava extends ExecCallable {
	
	/** @author myx */
	@ReflectionDisable
	public static interface JavaIntJ
			extends //
				ExecCallable.JavaInt,
				ExecCallable.ForNative.UseIntJ,
				ExecCallable.ForNumbers.UseIntJ,
				ExecCallable.ForString.UseIntJ,
				ExecCallable.ForVoid.UseIntJ {
		//
	}
	
	/** @author myx */
	@ReflectionDisable
	interface JavaIntJ0
			extends //
				ExecCallable.JavaInt,
				ExecCallable.Arguments.Exactly0,
				ExecCallable.ForNative.UseIntJ0,
				ExecCallable.ForNumbers.UseIntJ0,
				ExecCallable.ForString.UseIntJ0,
				ExecCallable.ForVoid.UseIntJ0 {
		//
	}
	
	/** @author myx */
	@ReflectionDisable
	interface JavaIntJ1
			extends //
				ExecCallable.JavaInt,
				ExecCallable.Arguments.Exactly1,
				ExecCallable.ForNative.UseIntJ1,
				ExecCallable.ForNumbers.UseIntJ1,
				ExecCallable.ForString.UseIntJ1,
				ExecCallable.ForVoid.UseIntJ1 {
		//
	}
	
	/** @author myx */
	@ReflectionDisable
	interface JavaIntJ2
			extends //
				ExecCallable.JavaInt,
				ExecCallable.Arguments.Exactly2,
				ExecCallable.ForNative.UseIntJ2,
				ExecCallable.ForNumbers.UseIntJ2,
				ExecCallable.ForString.UseIntJ2,
				ExecCallable.ForVoid.UseIntJ2 {
		//
	}
	
	/** @author myx */
	@ReflectionDisable
	public static interface JavaLongJ
			extends //
				ExecCallable.JavaLong,
				ExecCallable.ForVoid.UseLongJ,
				ExecCallable.ForNumbers.UseLongJ,
				ExecCallable.ForString.UseLongJ,
				ExecCallable.ForNative.UseLongJ {
		//
	}
	
	/** @author myx */
	@ReflectionDisable
	interface JavaLongJ0
			extends //
				ExecCallable.JavaLong,
				ExecCallable.Arguments.Exactly0,
				ExecCallable.ForNative.UseLongJ0,
				ExecCallable.ForNumbers.UseLongJ0,
				ExecCallable.ForString.UseLongJ0,
				ExecCallable.ForVoid.UseLongJ0 {
		//
	}
	
	/** @author myx */
	@ReflectionDisable
	interface JavaLongJ1
			extends //
				ExecCallable.JavaLong,
				ExecCallable.Arguments.Exactly1,
				ExecCallable.ForNative.UseLongJ1,
				ExecCallable.ForNumbers.UseLongJ1,
				ExecCallable.ForString.UseLongJ1,
				ExecCallable.ForVoid.UseLongJ1 {
		//
	}
	
	/** @author myx */
	@ReflectionDisable
	interface JavaStringJ0
			extends //
				ExecCallable.JavaString,
				ExecCallable.Arguments.Exactly0,
				ExecCallable.ForNative.UseStringJ0,
				ExecCallable.ForNumbers.UseStringJ0,
				ExecCallable.ForString.UseStringJ0,
				ExecCallable.ForVoid.UseStringJ0 {
		//
	}
	
	/** @author myx */
	@ReflectionDisable
	interface NativeE
			extends //
				ExecCallable.ForVoid.UseNativeE,
				ExecCallable.ForNumbers.UseNativeE,
				ExecCallable.ForString.UseNativeE,
				ExecCallable.ForNative.UseNativeE {
		//
	}
	
	/** @author myx */
	@ReflectionDisable
	interface NativeE0
			extends //
				ExecCallable.Arguments.Exactly0,
				ExecCallable.ForVoid.UseNativeE0,
				ExecCallable.ForNumbers.UseNativeE0,
				ExecCallable.ForString.UseNativeE0,
				ExecCallable.ForNative.UseNativeE0 {
		//
	}
	
	/** @author myx */
	@ReflectionDisable
	interface NativeE1
			extends //
				ExecCallable.Arguments.Exactly1,
				ExecCallable.ForVoid.UseNativeE1,
				ExecCallable.ForNumbers.UseNativeE1,
				ExecCallable.ForString.UseNativeE1,
				ExecCallable.ForNative.UseNativeE1 {
		//
	}
	
	/** @author myx */
	@ReflectionDisable
	interface NativeE2
			extends //
				ExecCallable.Arguments.Exactly2,
				ExecCallable.ForString.UseNativeE2,
				ExecCallable.ForNumbers.UseNativeE2,
				ExecCallable.ForVoid.UseNativeE2,
				ExecCallable.ForNative.UseNativeE2 {
		//
	}
	
	/** @author myx */
	@ReflectionDisable
	interface NativeEX
			extends //
				ExecCallable.Arguments.ExactlyX,
				ExecCallable.ForString.UseNativeEX,
				ExecCallable.ForNumbers.UseNativeEX,
				ExecCallable.ForVoid.UseNativeEX,
				ExecCallable.ForNative.UseNativeEX {
		//
	}
	
	/** @author myx */
	@ReflectionDisable
	interface NativeJ
			extends //
				ExecCallable.ForNative.UseNativeJ,
				ExecCallable.ForNumbers.UseNativeJ,
				ExecCallable.ForString.UseNativeJ,
				ExecCallable.ForVoid.UseNativeJ {
		//
	}
	//
	
	/** @author myx */
	@ReflectionDisable
	interface NativeJ0
			extends //
				ExecCallable.Arguments.Exactly0,
				ExecCallable.ForNumbers.UseNativeJ0,
				ExecCallable.ForString.UseNativeJ0,
				ExecCallable.ForVoid.UseNativeJ0,
				ExecCallable.ForNative.UseNativeJ0 {
		//
	}
	
	/** @author myx */
	@ReflectionDisable
	interface NativeJ1
			extends //
				ExecCallable.Arguments.Exactly1,
				ExecCallable.ForString.UseNativeJ1,
				ExecCallable.ForNumbers.UseNativeJ1,
				ExecCallable.ForVoid.UseNativeJ1,
				ExecCallable.ForNative.UseNativeJ1 {
		//
	}
	
	/** @author myx */
	@ReflectionDisable
	interface NativeJ2
			extends //
				ExecCallable.Arguments.Exactly2,
				ExecCallable.ForString.UseNativeJ2,
				ExecCallable.ForNumbers.UseNativeJ2,
				ExecCallable.ForVoid.UseNativeJ2,
				ExecCallable.ForNative.UseNativeJ2 {
		//
	}
	//
}
