/**
 *
 */
package ru.myx.ae3.exec;

import ru.myx.ae3.base.BaseArray;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/** @author myx */
@ReflectionDisable
public interface ExecCallable {

	/** @author myx */
	@ReflectionDisable
	public static class Arguments {

		/** @author myx */
		@ReflectionDisable
		public static interface Declared0 extends ExecCallable {

			@Override
			@Deprecated
			default int execArgumentsDeclared() {

				return 0;
			}

			@Override
			@Deprecated
			default String[] execFormalParameters() {

				return new String[]{};
			}
		}

		/** @author myx */
		@ReflectionDisable
		public static interface Declared1 extends ExecCallable {

			@Override
			@Deprecated
			default int execArgumentsDeclared() {

				return 1;
			}

			@Override
			default String[] execFormalParameters() {

				return new String[]{
						"a"
				};
			}
		}

		/** @author myx */
		@ReflectionDisable
		public static interface Declared2 extends ExecCallable {

			@Override
			@Deprecated
			default int execArgumentsDeclared() {

				return 2;
			}

			@Override
			default String[] execFormalParameters() {

				return new String[]{
						"a", "b"
				};
			}
		}

		/** @author myx */
		@ReflectionDisable
		public static interface DeclaredX extends ExecCallable {

			@Override
			int execArgumentsDeclared();

			@Override
			default String[] execFormalParameters() {

				final int args = this.execArgumentsDeclared();
				final String[] result = new String[args];
				for (int i = args - 1; i >= 0; --i) {
					result[i] = "arg" + i;
				}
				return result;
			}
		}

		/** @author myx */
		@ReflectionDisable
		public static interface Exactly0 extends ExecCallable.Arguments.Declared0 {

			@Override
			@Deprecated
			default int execArgumentsAcceptable() {

				return 0;
			}

			@Override
			@Deprecated
			default int execArgumentsMinimal() {

				return 0;
			}
		}

		/** @author myx */
		@ReflectionDisable
		public static interface Exactly1 extends ExecCallable.Arguments.Declared1 {

			@Override
			@Deprecated
			default int execArgumentsAcceptable() {

				return 1;
			}

			@Override
			@Deprecated
			default int execArgumentsMinimal() {

				return 1;
			}
		}

		/** @author myx */
		@ReflectionDisable
		public static interface Exactly2 extends ExecCallable.Arguments.Declared2 {

			@Override
			@Deprecated
			default int execArgumentsAcceptable() {

				return 2;
			}

			@Override
			@Deprecated
			default int execArgumentsMinimal() {

				return 2;
			}
		}

		/** @author myx */
		@ReflectionDisable
		public static interface ExactlyX extends ExecCallable.Arguments.DeclaredX {

			@Override
			default int execArgumentsAcceptable() {

				return this.execArgumentsDeclared();
			}

			@Override
			default int execArgumentsMinimal() {

				return this.execArgumentsDeclared();
			}
		}

		private Arguments() {
			
			// prevent
		}
	}

	/** @author myx */
	@ReflectionDisable
	public static class ForAll {

		/** @author myx */
		@ReflectionDisable
		public static interface UseE0
				extends //
					ExecCallable.Arguments.Exactly0,
					ExecCallable.ForStore.UseStore0,
					ExecCallable.ForString.UseStringE0,
					ExecCallable.ForNative.UseNativeE0,
					ExecCallable.ForNumbers.UseNumbersE0,
					ExecCallable.ForVoid.UseVoidE0 {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseE1
				extends //
					ExecCallable.Arguments.Exactly1,
					ExecCallable.ForStore.UseStore1,
					ExecCallable.ForString.UseStringE1,
					ExecCallable.ForNative.UseNativeE1,
					ExecCallable.ForNumbers.UseNumbersE1,
					ExecCallable.ForVoid.UseVoidE1 {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseE2
				extends //
					ExecCallable.Arguments.Exactly2,
					ExecCallable.ForStore.UseStore2,
					ExecCallable.ForString.UseStringE2,
					ExecCallable.ForNative.UseNativeE2,
					ExecCallable.ForNumbers.UseNumbersE2,
					ExecCallable.ForVoid.UseVoidE2 {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseEX
				extends //
					ExecCallable.Arguments.ExactlyX,
					ExecCallable.ForStore.UseStoreX,
					ExecCallable.ForString.UseStringEX,
					ExecCallable.ForNative.UseNativeEX,
					ExecCallable.ForNumbers.UseNumbersEX,
					ExecCallable.ForVoid.UseVoidEX {
			//
		}
	}

	/** @author myx */
	@ReflectionDisable
	public static class ForDouble {

		/** @author myx */
		@ReflectionDisable
		public static interface UseDoubleE0
				extends //
					CallableResultDouble.CRDE0FDJ0,
					CallableResultDouble.CRDE0FDJ1,
					CallableResultDouble.CRDE0FDJ2,
					CallableResultDouble.CRDE0FDJA,
					CallableResultDouble.CRDE0FDE1,
					CallableResultDouble.CRDE0FDE2,
					CallableResultDouble.CRDE0FDEA,
					CallableResultDouble.CRDE0FDEX {

			//

		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseDoubleE1
				extends //
					CallableResultDouble.CRDE1FDJ0,
					CallableResultDouble.CRDE1FDJ1,
					CallableResultDouble.CRDE1FDJ2,
					CallableResultDouble.CRDE1FDJA,
					CallableResultDouble.CRDE1FDE0,
					CallableResultDouble.CRDE1FDE2,
					CallableResultDouble.CRDE1FDEA,
					CallableResultDouble.CRDE1FDEX {

			//

		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseDoubleE2
				extends //
					CallableResultDouble.CRDE2FDJ0,
					CallableResultDouble.CRDE2FDJ1,
					CallableResultDouble.CRDE2FDJ2,
					CallableResultDouble.CRDE2FDJA,
					CallableResultDouble.CRDE2FDE0,
					CallableResultDouble.CRDE2FDE1,
					CallableResultDouble.CRDE2FDEA,
					CallableResultDouble.CRDE2FDEX {

			//

		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseDoubleEX
				extends //
					CallableResultDouble.CRDEXFDJ0,
					CallableResultDouble.CRDEXFDJ1,
					CallableResultDouble.CRDEXFDJ2,
					CallableResultDouble.CRDEXFDJA,
					CallableResultDouble.CRDEXFDE0,
					CallableResultDouble.CRDEXFDE1,
					CallableResultDouble.CRDEXFDE2,
					CallableResultDouble.CRDEXFDEA {

			//

		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseDoubleJ
				extends //
					CallableResultDouble.CRDJ0FDE0,
					CallableResultDouble.CRDJ1FDE1,
					CallableResultDouble.CRDJ2FDE2,
					CallableResultDouble.CRDJAFDEA,
					CallableResultDouble.CRDJAFDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseDoubleJ0
				extends //
					CallableResultDouble.CRDJ0FDE0,
					CallableResultDouble.CRDJ0FDE1,
					CallableResultDouble.CRDJ0FDE2,
					CallableResultDouble.CRDJ0FDEA,
					CallableResultDouble.CRDJ0FDEX,
					CallableResultDouble.CRDJ0FDJ1,
					CallableResultDouble.CRDJ0FDJ2,
					CallableResultDouble.CRDJ0FDJA {

			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseInt
				extends //
					CallableResultInt.CRIJ0FDJ0,
					CallableResultInt.CRIJ1FDJ1,
					CallableResultInt.CRIJ2FDJ2,
					CallableResultInt.CRIJAFDJA,
					CallableResultInt.CRIE0FDE0,
					CallableResultInt.CRIE1FDE1,
					CallableResultInt.CRIE2FDE2,
					CallableResultInt.CRIEAFDEA,
					CallableResultInt.CRIEXFDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ
				extends //
					CallableResultInt.CRIJ0FDJ0,
					CallableResultInt.CRIJ1FDJ1,
					CallableResultInt.CRIJ2FDJ2,
					CallableResultInt.CRIJAFDJA,
					CallableResultInt.CRIJ0FDE0,
					CallableResultInt.CRIJ1FDE1,
					CallableResultInt.CRIJ2FDE2,
					CallableResultInt.CRIJAFDEA,
					CallableResultInt.CRIJAFDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ0
				extends //
					CallableResultInt.CRIJ0FDJ0,
					CallableResultInt.CRIJ0FDJ1,
					CallableResultInt.CRIJ0FDJ2,
					CallableResultInt.CRIJ0FDJA,
					CallableResultInt.CRIJ0FDE0,
					CallableResultInt.CRIJ0FDE1,
					CallableResultInt.CRIJ0FDE2,
					CallableResultInt.CRIJ0FDEA,
					CallableResultInt.CRIJ0FDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ1
				extends //
					CallableResultInt.CRIJ1FDJ0,
					CallableResultInt.CRIJ1FDJ1,
					CallableResultInt.CRIJ1FDJ2,
					CallableResultInt.CRIJ1FDJA,
					CallableResultInt.CRIJ1FDE0,
					CallableResultInt.CRIJ1FDE1,
					CallableResultInt.CRIJ1FDE2,
					CallableResultInt.CRIJ1FDEA,
					CallableResultInt.CRIJ1FDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ2
				extends //
					CallableResultInt.CRIJ2FDJ0,
					CallableResultInt.CRIJ2FDJ1,
					CallableResultInt.CRIJ2FDJ2,
					CallableResultInt.CRIJ2FDJA,
					CallableResultInt.CRIJ2FDE0,
					CallableResultInt.CRIJ2FDE1,
					CallableResultInt.CRIJ2FDE2,
					CallableResultInt.CRIJ2FDEA,
					CallableResultInt.CRIJ2FDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLong
				extends //
					CallableResultLong.CRLJ0FDJ0,
					CallableResultLong.CRLJ1FDJ1,
					CallableResultLong.CRLJ2FDJ2,
					CallableResultLong.CRLJAFDJA,
					CallableResultLong.CRLE0FDE0,
					CallableResultLong.CRLE1FDE1,
					CallableResultLong.CRLE2FDE2,
					CallableResultLong.CRLEAFDEA,
					CallableResultLong.CRLEXFDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongJ
				extends //
					CallableResultLong.CRLJ0FDJ0,
					CallableResultLong.CRLJ1FDJ1,
					CallableResultLong.CRLJ2FDJ2,
					CallableResultLong.CRLJAFDJA,
					CallableResultLong.CRLJ0FDE0,
					CallableResultLong.CRLJ1FDE1,
					CallableResultLong.CRLJ2FDE2,
					CallableResultLong.CRLJAFDEA,
					CallableResultLong.CRLJAFDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongJ0
				extends //
					CallableResultLong.CRLJ0FDJ0,
					CallableResultLong.CRLJ0FDJ1,
					CallableResultLong.CRLJ0FDJ2,
					CallableResultLong.CRLJ0FDJA,
					CallableResultLong.CRLJ0FDE0,
					CallableResultLong.CRLJ0FDE1,
					CallableResultLong.CRLJ0FDE2,
					CallableResultLong.CRLJ0FDEA,
					CallableResultLong.CRLJ0FDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongJ1
				extends //
					CallableResultLong.CRLJ1FDJ0,
					CallableResultLong.CRLJ1FDJ1,
					CallableResultLong.CRLJ1FDJ2,
					CallableResultLong.CRLJ1FDJA,
					CallableResultLong.CRLJ1FDE0,
					CallableResultLong.CRLJ1FDE1,
					CallableResultLong.CRLJ1FDE2,
					CallableResultLong.CRLJ1FDEA,
					CallableResultLong.CRLJ1FDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNative
				extends //
					CallableResultNative.CRNJ0FDJ0,
					CallableResultNative.CRNJ1FDJ1,
					CallableResultNative.CRNJ2FDJ2,
					CallableResultNative.CRNJAFDJA,
					CallableResultNative.CRNE0FDE0,
					CallableResultNative.CRNE1FDE1,
					CallableResultNative.CRNE2FDE2,
					CallableResultNative.CRNEAFDEA,
					CallableResultNative.CRNEXFDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE
				extends //
					CallableResultNative.CRNE0FDJ0,
					CallableResultNative.CRNE1FDJ1,
					CallableResultNative.CRNE2FDJ2,
					CallableResultNative.CRNEAFDJA,
					CallableResultNative.CRNE0FDE0,
					CallableResultNative.CRNE1FDE1,
					CallableResultNative.CRNE2FDE2,
					CallableResultNative.CRNEAFDEA,
					CallableResultNative.CRNEXFDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE0
				extends //
					CallableResultNative.CRNE0FDJ0,
					CallableResultNative.CRNE0FDJ1,
					CallableResultNative.CRNE0FDJ2,
					CallableResultNative.CRNE0FDJA,
					CallableResultNative.CRNE0FDE0,
					CallableResultNative.CRNE0FDE1,
					CallableResultNative.CRNE0FDE2,
					CallableResultNative.CRNE0FDEA,
					CallableResultNative.CRNE0FDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE1
				extends //
					CallableResultNative.CRNE1FDJ0,
					CallableResultNative.CRNE1FDJ1,
					CallableResultNative.CRNE1FDJ2,
					CallableResultNative.CRNE1FDJA,
					CallableResultNative.CRNE1FDE0,
					CallableResultNative.CRNE1FDE2,
					CallableResultNative.CRNE1FDE1,
					CallableResultNative.CRNE1FDEA,
					CallableResultNative.CRNE1FDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE2
				extends //
					CallableResultNative.CRNE2FDJ0,
					CallableResultNative.CRNE2FDJ1,
					CallableResultNative.CRNE2FDJ2,
					CallableResultNative.CRNE2FDJA,
					CallableResultNative.CRNE2FDE0,
					CallableResultNative.CRNE2FDE1,
					CallableResultNative.CRNE2FDE2,
					CallableResultNative.CRNE2FDEA,
					CallableResultNative.CRNE2FDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeEA
				extends //
					CallableResultNative.CRNEAFDJ0,
					CallableResultNative.CRNEAFDJ1,
					CallableResultNative.CRNEAFDJ2,
					CallableResultNative.CRNEAFDJA,
					CallableResultNative.CRNEAFDE0,
					CallableResultNative.CRNEAFDE1,
					CallableResultNative.CRNEAFDE2,
					CallableResultNative.CRNEAFDEA,
					CallableResultNative.CRNEAFDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeEX
				extends //
					CallableResultNative.CRNEXFDJ0,
					CallableResultNative.CRNEXFDJ1,
					CallableResultNative.CRNEXFDJ2,
					CallableResultNative.CRNEXFDJA,
					CallableResultNative.CRNEXFDE0,
					CallableResultNative.CRNEXFDE1,
					CallableResultNative.CRNEXFDE2,
					CallableResultNative.CRNEXFDEA,
					CallableResultNative.CRNEXFDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ
				extends //
					CallableResultNative.CRNJ0FDJ0,
					CallableResultNative.CRNJ1FDJ1,
					CallableResultNative.CRNJ2FDJ2,
					CallableResultNative.CRNJAFDJA,
					CallableResultNative.CRNJ0FDE0,
					CallableResultNative.CRNJ1FDE1,
					CallableResultNative.CRNJ2FDE2,
					CallableResultNative.CRNJAFDEA,
					CallableResultNative.CRNJAFDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ0
				extends //
					CallableResultNative.CRNJ0FDJ0,
					CallableResultNative.CRNJ0FDJ1,
					CallableResultNative.CRNJ0FDJ2,
					CallableResultNative.CRNJ0FDJA,
					CallableResultNative.CRNJ0FDE0,
					CallableResultNative.CRNJ0FDE1,
					CallableResultNative.CRNJ0FDE2,
					CallableResultNative.CRNJ0FDEA,
					CallableResultNative.CRNJ0FDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ1
				extends //
					CallableResultNative.CRNJ1FDJ0,
					CallableResultNative.CRNJ1FDJ1,
					CallableResultNative.CRNJ1FDJ2,
					CallableResultNative.CRNJ1FDJA,
					CallableResultNative.CRNJ1FDE0,
					CallableResultNative.CRNJ1FDE1,
					CallableResultNative.CRNJ1FDE2,
					CallableResultNative.CRNJ1FDEA,
					CallableResultNative.CRNJ1FDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ2
				extends //
					CallableResultNative.CRNJ2FDJ0,
					CallableResultNative.CRNJ2FDJ1,
					CallableResultNative.CRNJ2FDJ2,
					CallableResultNative.CRNJ2FDJA,
					CallableResultNative.CRNJ2FDE0,
					CallableResultNative.CRNJ2FDE1,
					CallableResultNative.CRNJ2FDE2,
					CallableResultNative.CRNJ2FDEA,
					CallableResultNative.CRNJ2FDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJA
				extends //
					CallableResultNative.CRNJAFDJ0,
					CallableResultNative.CRNJAFDJ1,
					CallableResultNative.CRNJAFDJ2,
					CallableResultNative.CRNJAFDJA,
					CallableResultNative.CRNJAFDE0,
					CallableResultNative.CRNJAFDE1,
					CallableResultNative.CRNJAFDE2,
					CallableResultNative.CRNJAFDEA,
					CallableResultNative.CRNJAFDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore
				extends //
					CallableResultDouble.CRDE0FDJ0,
					CallableResultDouble.CRDE1FDJ1,
					CallableResultDouble.CRDE2FDJ2,
					CallableResultDouble.CRDEAFDJA,
					CallableResultStore.CREE0FDE0,
					CallableResultStore.CREE1FDE1,
					CallableResultStore.CREE2FDE2,
					CallableResultStore.CREEXFDEX,
					CallableResultStore.CREEXFDEA {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore0
				extends //
					CallableResultDouble.CRDE0FDJ0,
					CallableResultDouble.CRDE0FDJ1,
					CallableResultDouble.CRDE0FDJ2,
					CallableResultDouble.CRDE0FDJA,
					CallableResultStore.CREE0FDE0,
					CallableResultStore.CREE0FDE1,
					CallableResultStore.CREE0FDE2,
					CallableResultStore.CREE0FDEX,
					CallableResultStore.CREE0FDEA {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore1
				extends //
					CallableResultDouble.CRDE1FDJ0,
					CallableResultDouble.CRDE1FDJ1,
					CallableResultDouble.CRDE1FDJ2,
					CallableResultDouble.CRDE1FDJA,
					CallableResultStore.CREE1FDE0,
					CallableResultStore.CREE1FDE1,
					CallableResultStore.CREE1FDE2,
					CallableResultStore.CREE1FDEX,
					CallableResultStore.CREE1FDEA {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore2
				extends //
					CallableResultDouble.CRDE2FDJ0,
					CallableResultDouble.CRDE2FDJ1,
					CallableResultDouble.CRDE2FDJ2,
					CallableResultDouble.CRDE2FDJA,
					CallableResultStore.CREE2FDE0,
					CallableResultStore.CREE2FDE1,
					CallableResultStore.CREE2FDE2,
					CallableResultStore.CREE2FDEX,
					CallableResultStore.CREE2FDEA {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStoreX
				extends //
					CallableResultDouble.CRDEXFDJ0,
					CallableResultDouble.CRDEXFDJ1,
					CallableResultDouble.CRDEXFDJ2,
					CallableResultDouble.CRDEXFDJA,
					CallableResultStore.CREEXFDE0,
					CallableResultStore.CREEXFDE1,
					CallableResultStore.CREEXFDE2,
					CallableResultStore.CREEXFDEX,
					CallableResultStore.CREEXFDEA {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseString
				extends //
					CallableResultString.CRSJ0FDJ0,
					CallableResultString.CRSJ1FDJ1,
					CallableResultString.CRSJ2FDJ2,
					CallableResultString.CRSJAFDJA,
					CallableResultString.CRSE0FDE0,
					CallableResultString.CRSE1FDE1,
					CallableResultString.CRSE2FDE2,
					CallableResultString.CRSEAFDEA,
					CallableResultString.CRSEXFDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringE
				extends //
					CallableResultString.CRSE0FDJ0,
					CallableResultString.CRSE1FDJ1,
					CallableResultString.CRSE2FDJ2,
					CallableResultString.CRSEAFDJA,
					CallableResultString.CRSE0FDE0,
					CallableResultString.CRSE1FDE1,
					CallableResultString.CRSE2FDE2,
					CallableResultString.CRSEAFDEA,
					CallableResultString.CRSEXFDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringE0
				extends //
					CallableResultString.CRSE0FDJ0,
					CallableResultString.CRSE0FDJ1,
					CallableResultString.CRSE0FDJ2,
					CallableResultString.CRSE0FDJA,
					CallableResultString.CRSE0FDE0,
					CallableResultString.CRSE0FDE1,
					CallableResultString.CRSE0FDE2,
					CallableResultString.CRSE0FDEA,
					CallableResultString.CRSE0FDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringE1
				extends //
					CallableResultString.CRSE1FDJ0,
					CallableResultString.CRSE1FDJ1,
					CallableResultString.CRSE1FDJ2,
					CallableResultString.CRSE1FDJA,
					CallableResultString.CRSE1FDE0,
					CallableResultString.CRSE1FDE1,
					CallableResultString.CRSE1FDE2,
					CallableResultString.CRSE1FDEA,
					CallableResultString.CRSE1FDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringJ
				extends //
					CallableResultString.CRSJ0FDJ0,
					CallableResultString.CRSJ1FDJ1,
					CallableResultString.CRSJ2FDJ2,
					CallableResultString.CRSJAFDJA,
					CallableResultString.CRSJ0FDE0,
					CallableResultString.CRSJ1FDE1,
					CallableResultString.CRSJ2FDE2,
					CallableResultString.CRSJAFDEA,
					CallableResultString.CRSJAFDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringJ0
				extends //
					CallableResultString.CRSJ0FDJ0,
					CallableResultString.CRSJ0FDJ1,
					CallableResultString.CRSJ0FDJ2,
					CallableResultString.CRSJ0FDJA,
					CallableResultString.CRSJ0FDE0,
					CallableResultString.CRSJ0FDE1,
					CallableResultString.CRSJ0FDE2,
					CallableResultString.CRSJ0FDEA,
					CallableResultString.CRSJ0FDEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringJ1
				extends //
					CallableResultString.CRSJ1FDJ0,
					CallableResultString.CRSJ1FDJ1,
					CallableResultString.CRSJ1FDJ2,
					CallableResultString.CRSJ1FDJA,
					CallableResultString.CRSJ1FDE0,
					CallableResultString.CRSJ1FDE1,
					CallableResultString.CRSJ1FDE2,
					CallableResultString.CRSJ1FDEA,
					CallableResultString.CRSJ1FDEX {
			//
		}

		private ForDouble() {
			
			// prevent
		}
	}

	/** @author myx */
	@ReflectionDisable
	public static class ForInt {

		/** @author myx */
		@ReflectionDisable
		public static interface UseInt
				extends //
					CallableResultInt.CRIJ0FIJ0,
					CallableResultInt.CRIJ1FIJ1,
					CallableResultInt.CRIJ2FIJ2,
					CallableResultInt.CRIJAFIJA,
					CallableResultInt.CRIE0FIE0,
					CallableResultInt.CRIE1FIE1,
					CallableResultInt.CRIE2FIE2,
					CallableResultInt.CRIEAFIEA,
					CallableResultInt.CRIEXFIEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntE0
				extends //
					CallableResultInt.CRIE0FIJ0,
					CallableResultInt.CRIE0FIJ1,
					CallableResultInt.CRIE0FIJ2,
					CallableResultInt.CRIE0FIJA,
					CallableResultInt.CRIE0FIE1,
					CallableResultInt.CRIE0FIE2,
					CallableResultInt.CRIE0FIEA,
					CallableResultInt.CRIE0FIEX {
			//

		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntE1
				extends //
					CallableResultInt.CRIE1FIJ0,
					CallableResultInt.CRIE1FIJ1,
					CallableResultInt.CRIE1FIJ2,
					CallableResultInt.CRIE1FIJA,
					CallableResultInt.CRIE1FIE0,
					CallableResultInt.CRIE1FIE2,
					CallableResultInt.CRIE1FIEA,
					CallableResultInt.CRIE1FIEX {
			//

		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntE2
				extends //
					CallableResultInt.CRIE2FIJ0,
					CallableResultInt.CRIE2FIJ1,
					CallableResultInt.CRIE2FIJ2,
					CallableResultInt.CRIE2FIJA,
					CallableResultInt.CRIE2FIE0,
					CallableResultInt.CRIE2FIE1,
					CallableResultInt.CRIE2FIEA,
					CallableResultInt.CRIE2FIEX {
			//

		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntEX
				extends //
					CallableResultInt.CRIEXFIJ0,
					CallableResultInt.CRIEXFIJ1,
					CallableResultInt.CRIEXFIJ2,
					CallableResultInt.CRIEXFIJA,
					CallableResultInt.CRIEXFIE0,
					CallableResultInt.CRIEXFIE1,
					CallableResultInt.CRIEXFIE2,
					CallableResultInt.CRIEXFIEA {
			//

		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ
				extends //
					CallableResultInt.CRIJ0FIJ0,
					CallableResultInt.CRIJ1FIJ1,
					CallableResultInt.CRIJ2FIJ2,
					CallableResultInt.CRIJAFIJA,
					CallableResultInt.CRIJ0FIE0,
					CallableResultInt.CRIJ1FIE1,
					CallableResultInt.CRIJ2FIE2,
					CallableResultInt.CRIJAFIEX,
					CallableResultInt.CRIJAFIEA {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ0
				extends //
					CallableResultInt.CRIJ0FIJ1,
					CallableResultInt.CRIJ0FIJ2,
					CallableResultInt.CRIJ0FIJA,
					CallableResultInt.CRIJ0FIE0,
					CallableResultInt.CRIJ0FIE1,
					CallableResultInt.CRIJ0FIE2,
					CallableResultInt.CRIJ0FIEA,
					CallableResultInt.CRIJ0FIEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ1
				extends //
					CallableResultInt.CRIJ1FIJ0,
					CallableResultInt.CRIJ1FIJ2,
					CallableResultInt.CRIJ1FIJA,
					CallableResultInt.CRIJ1FIE0,
					CallableResultInt.CRIJ1FIE1,
					CallableResultInt.CRIJ1FIE2,
					CallableResultInt.CRIJ1FIEA,
					CallableResultInt.CRIJ1FIEX {

			//

		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ2
				extends //
					CallableResultInt.CRIJ2FIJ0,
					CallableResultInt.CRIJ2FIJ1,
					CallableResultInt.CRIJ2FIJA,
					CallableResultInt.CRIJ2FIE0,
					CallableResultInt.CRIJ2FIE1,
					CallableResultInt.CRIJ2FIE2,
					CallableResultInt.CRIJ2FIEA,
					CallableResultInt.CRIJ2FIEX {

			//

		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLong
				extends //
					CallableResultLong.CRLJ0FIJ0,
					CallableResultLong.CRLJ1FIJ1,
					CallableResultLong.CRLJ2FIJ2,
					CallableResultLong.CRLJAFIJA,
					CallableResultLong.CRLE0FIE0,
					CallableResultLong.CRLE1FIE1,
					CallableResultLong.CRLE2FIE2,
					CallableResultLong.CRLEAFIEA,
					CallableResultLong.CRLEXFIEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongJ
				extends //
					CallableResultLong.CRLJ0FIJ0,
					CallableResultLong.CRLJ1FIJ1,
					CallableResultLong.CRLJ2FIJ2,
					CallableResultLong.CRLJAFIJA,
					CallableResultLong.CRLJ0FIE0,
					CallableResultLong.CRLJ1FIE1,
					CallableResultLong.CRLJ2FIE2,
					CallableResultLong.CRLJAFIEA,
					CallableResultLong.CRLJAFIEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongJ0
				extends //
					CallableResultLong.CRLJ0FIJ0,
					CallableResultLong.CRLJ0FIJ1,
					CallableResultLong.CRLJ0FIJ2,
					CallableResultLong.CRLJ0FIJA,
					CallableResultLong.CRLJ0FIE0,
					CallableResultLong.CRLJ0FIE1,
					CallableResultLong.CRLJ0FIE2,
					CallableResultLong.CRLJ0FIEX,
					CallableResultLong.CRLJ0FIEA {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongJ1
				extends //
					CallableResultLong.CRLJ1FIJ0,
					CallableResultLong.CRLJ1FIJ1,
					CallableResultLong.CRLJ1FIJ2,
					CallableResultLong.CRLJ1FIJA,
					CallableResultLong.CRLJ1FIE0,
					CallableResultLong.CRLJ1FIE1,
					CallableResultLong.CRLJ1FIE2,
					CallableResultLong.CRLJ1FIEX,
					CallableResultLong.CRLJ1FIEA {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNative
				extends //
					CallableResultNative.CRNJ0FIJ0,
					CallableResultNative.CRNJ1FIJ1,
					CallableResultNative.CRNJ2FIJ2,
					CallableResultNative.CRNJAFIJA,
					CallableResultNative.CRNE0FIE0,
					CallableResultNative.CRNE1FIE1,
					CallableResultNative.CRNE2FIE2,
					CallableResultNative.CRNEAFIEA,
					CallableResultNative.CRNEXFIEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE
				extends //
					CallableResultNative.CRNE0FIJ0,
					CallableResultNative.CRNE1FIJ1,
					CallableResultNative.CRNE2FIJ2,
					CallableResultNative.CRNEAFIJA,
					CallableResultNative.CRNE0FIE0,
					CallableResultNative.CRNE1FIE1,
					CallableResultNative.CRNE2FIE2,
					CallableResultNative.CRNEAFIEA,
					CallableResultNative.CRNEXFIEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE0
				extends //
					CallableResultNative.CRNE0FIJ0,
					CallableResultNative.CRNE0FIJ1,
					CallableResultNative.CRNE0FIJ2,
					CallableResultNative.CRNE0FIJA,
					CallableResultNative.CRNE0FIE0,
					CallableResultNative.CRNE0FIE1,
					CallableResultNative.CRNE0FIE2,
					CallableResultNative.CRNE0FIEA,
					CallableResultNative.CRNE0FIEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE1
				extends //
					CallableResultNative.CRNE1FIJ0,
					CallableResultNative.CRNE1FIJ1,
					CallableResultNative.CRNE1FIJ2,
					CallableResultNative.CRNE1FIJA,
					CallableResultNative.CRNE1FIE0,
					CallableResultNative.CRNE1FIE1,
					CallableResultNative.CRNE1FIE2,
					CallableResultNative.CRNE1FIEA,
					CallableResultNative.CRNE1FIEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE2
				extends //
					CallableResultNative.CRNE2FIJ0,
					CallableResultNative.CRNE2FIJ1,
					CallableResultNative.CRNE2FIJ2,
					CallableResultNative.CRNE2FIJA,
					CallableResultNative.CRNE2FIE0,
					CallableResultNative.CRNE2FIE1,
					CallableResultNative.CRNE2FIE2,
					CallableResultNative.CRNE2FIEA,
					CallableResultNative.CRNE2FIEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeEA
				extends //
					CallableResultNative.CRNEAFIJ0,
					CallableResultNative.CRNEAFIJ1,
					CallableResultNative.CRNEAFIJ2,
					CallableResultNative.CRNEAFIJA,
					CallableResultNative.CRNEAFIE0,
					CallableResultNative.CRNEAFIE1,
					CallableResultNative.CRNEAFIE2,
					CallableResultNative.CRNEAFIEA,
					CallableResultNative.CRNEAFIEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeEX
				extends //
					CallableResultNative.CRNEXFIJ0,
					CallableResultNative.CRNEXFIJ1,
					CallableResultNative.CRNEXFIJ2,
					CallableResultNative.CRNEXFIJA,
					CallableResultNative.CRNEXFIE0,
					CallableResultNative.CRNEXFIE1,
					CallableResultNative.CRNEXFIE2,
					CallableResultNative.CRNEXFIEA,
					CallableResultNative.CRNEXFIEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ
				extends //
					CallableResultNative.CRNJ0FIJ0,
					CallableResultNative.CRNJ1FIJ1,
					CallableResultNative.CRNJ2FIJ2,
					CallableResultNative.CRNJAFIJA,
					CallableResultNative.CRNJ0FIE0,
					CallableResultNative.CRNJ1FIE1,
					CallableResultNative.CRNJ2FIE2,
					CallableResultNative.CRNJAFIEA,
					CallableResultNative.CRNJAFIEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ0
				extends //
					CallableResultNative.CRNJ0FIJ0,
					CallableResultNative.CRNJ0FIJ1,
					CallableResultNative.CRNJ0FIJ2,
					CallableResultNative.CRNJ0FIJA,
					CallableResultNative.CRNJ0FIE0,
					CallableResultNative.CRNJ0FIE1,
					CallableResultNative.CRNJ0FIE2,
					CallableResultNative.CRNJ0FIEA,
					CallableResultNative.CRNJ0FIEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ1
				extends //
					CallableResultNative.CRNJ1FIJ0,
					CallableResultNative.CRNJ1FIJ1,
					CallableResultNative.CRNJ1FIJ2,
					CallableResultNative.CRNJ1FIJA,
					CallableResultNative.CRNJ1FIE0,
					CallableResultNative.CRNJ1FIE1,
					CallableResultNative.CRNJ1FIE2,
					CallableResultNative.CRNJ1FIEA,
					CallableResultNative.CRNJ1FIEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ2
				extends //
					CallableResultNative.CRNJ2FIJ0,
					CallableResultNative.CRNJ2FIJ1,
					CallableResultNative.CRNJ2FIJ2,
					CallableResultNative.CRNJ2FIJA,
					CallableResultNative.CRNJ2FIE0,
					CallableResultNative.CRNJ2FIE1,
					CallableResultNative.CRNJ2FIE2,
					CallableResultNative.CRNJ2FIEA,
					CallableResultNative.CRNJ2FIEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJA
				extends //
					CallableResultNative.CRNJAFIJ0,
					CallableResultNative.CRNJAFIJ1,
					CallableResultNative.CRNJAFIJ2,
					CallableResultNative.CRNJAFIJA,
					CallableResultNative.CRNJAFIE0,
					CallableResultNative.CRNJAFIE1,
					CallableResultNative.CRNJAFIE2,
					CallableResultNative.CRNJAFIEA,
					CallableResultNative.CRNJAFIEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore
				extends //
					CallableResultInt.CRIE0FIJ0,
					CallableResultInt.CRIE1FIJ1,
					CallableResultInt.CRIE2FIJ2,
					CallableResultInt.CRIEAFIJA,
					CallableResultStore.CREE0FIE0,
					CallableResultStore.CREE1FIE1,
					CallableResultStore.CREE2FIE2,
					CallableResultStore.CREEXFIEA,
					CallableResultStore.CREEXFIEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore0
				extends //
					CallableResultInt.CRIE0FIJ0,
					CallableResultInt.CRIE0FIJ1,
					CallableResultInt.CRIE0FIJ2,
					CallableResultInt.CRIE0FIJA,
					CallableResultStore.CREE0FIE0,
					CallableResultStore.CREE0FIE1,
					CallableResultStore.CREE0FIE2,
					CallableResultStore.CREE0FIEA,
					CallableResultStore.CREE0FIEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore1
				extends //
					CallableResultInt.CRIE1FIJ0,
					CallableResultInt.CRIE1FIJ1,
					CallableResultInt.CRIE1FIJ2,
					CallableResultInt.CRIE1FIJA,
					CallableResultStore.CREE1FIE0,
					CallableResultStore.CREE1FIE1,
					CallableResultStore.CREE1FIE2,
					CallableResultStore.CREE1FIEA,
					CallableResultStore.CREE1FIEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore2
				extends //
					CallableResultInt.CRIE2FIJ0,
					CallableResultInt.CRIE2FIJ1,
					CallableResultInt.CRIE2FIJ2,
					CallableResultInt.CRIE2FIJA,
					CallableResultStore.CREE2FIE0,
					CallableResultStore.CREE2FIE1,
					CallableResultStore.CREE2FIE2,
					CallableResultStore.CREE2FIEA,
					CallableResultStore.CREE2FIEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStoreX
				extends //
					CallableResultInt.CRIEXFIJ0,
					CallableResultInt.CRIEXFIJ1,
					CallableResultInt.CRIEXFIJ2,
					CallableResultInt.CRIEXFIJA,
					CallableResultStore.CREEXFIE0,
					CallableResultStore.CREEXFIE1,
					CallableResultStore.CREEXFIE2,
					CallableResultStore.CREEXFIEA,
					CallableResultStore.CREEXFIEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseString
				extends //
					CallableResultString.CRSJ0FIJ0,
					CallableResultString.CRSJ1FIJ1,
					CallableResultString.CRSJ2FIJ2,
					CallableResultString.CRSJAFIJA,
					CallableResultString.CRSE0FIE0,
					CallableResultString.CRSE1FIE1,
					CallableResultString.CRSE2FIE2,
					CallableResultString.CRSEAFIEA,
					CallableResultString.CRSEXFIEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringE
				extends //
					CallableResultString.CRSE0FIJ0,
					CallableResultString.CRSE1FIJ1,
					CallableResultString.CRSE2FIJ2,
					CallableResultString.CRSEAFIJA,
					CallableResultString.CRSE0FIE0,
					CallableResultString.CRSE1FIE1,
					CallableResultString.CRSE2FIE2,
					CallableResultString.CRSEAFIEA,
					CallableResultString.CRSEXFIEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringE0
				extends //
					CallableResultString.CRSE0FIJ0,
					CallableResultString.CRSE0FIJ1,
					CallableResultString.CRSE0FIJ2,
					CallableResultString.CRSE0FIJA,
					CallableResultString.CRSE0FIE0,
					CallableResultString.CRSE0FIE1,
					CallableResultString.CRSE0FIE2,
					CallableResultString.CRSE0FIEA,
					CallableResultString.CRSE0FIEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringE1
				extends //
					CallableResultString.CRSE1FIJ0,
					CallableResultString.CRSE1FIJ1,
					CallableResultString.CRSE1FIJ2,
					CallableResultString.CRSE1FIJA,
					CallableResultString.CRSE1FIE0,
					CallableResultString.CRSE1FIE1,
					CallableResultString.CRSE1FIE2,
					CallableResultString.CRSE1FIEA,
					CallableResultString.CRSE1FIEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringJ
				extends //
					CallableResultString.CRSJ0FIJ0,
					CallableResultString.CRSJ1FIJ1,
					CallableResultString.CRSJ2FIJ2,
					CallableResultString.CRSJAFIJA,
					CallableResultString.CRSJ0FIE0,
					CallableResultString.CRSJ1FIE1,
					CallableResultString.CRSJ2FIE2,
					CallableResultString.CRSJAFIEX,
					CallableResultString.CRSJAFIEA {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringJ0
				extends //
					CallableResultString.CRSJ0FIJ0,
					CallableResultString.CRSJ0FIJ1,
					CallableResultString.CRSJ0FIJ2,
					CallableResultString.CRSJ0FIJA,
					CallableResultString.CRSJ0FIE0,
					CallableResultString.CRSJ0FIE1,
					CallableResultString.CRSJ0FIE2,
					CallableResultString.CRSJ0FIEA,
					CallableResultString.CRSJ0FIEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringJ1
				extends //
					CallableResultString.CRSJ1FIJ0,
					CallableResultString.CRSJ1FIJ1,
					CallableResultString.CRSJ1FIJ2,
					CallableResultString.CRSJ1FIJA,
					CallableResultString.CRSJ1FIE0,
					CallableResultString.CRSJ1FIE1,
					CallableResultString.CRSJ1FIE2,
					CallableResultString.CRSJ1FIEA,
					CallableResultString.CRSJ1FIEX {
			//
		}

		private ForInt() {
			
			// prevent
		}
	}

	/** @author myx */
	@ReflectionDisable
	public static class ForLong {

		/** @author myx */
		@ReflectionDisable
		public static interface UseInt
				extends //
					CallableResultInt.CRIJ0FLJ0,
					CallableResultInt.CRIJ1FLJ1,
					CallableResultInt.CRIJ2FLJ2,
					CallableResultInt.CRIJAFLJA,
					CallableResultInt.CRIE0FLE0,
					CallableResultInt.CRIE1FLE1,
					CallableResultInt.CRIE2FLE2,
					CallableResultInt.CRIEAFLEA,
					CallableResultInt.CRIEXFLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ
				extends //
					CallableResultInt.CRIJ0FLJ0,
					CallableResultInt.CRIJ1FLJ1,
					CallableResultInt.CRIJ2FLJ2,
					CallableResultInt.CRIJAFLJA,
					CallableResultInt.CRIJ0FLE0,
					CallableResultInt.CRIJ1FLE1,
					CallableResultInt.CRIJ2FLE2,
					CallableResultInt.CRIJAFLEA,
					CallableResultInt.CRIJAFLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ0
				extends //
					CallableResultInt.CRIJ0FLJ0,
					CallableResultInt.CRIJ0FLJ1,
					CallableResultInt.CRIJ0FLJ2,
					CallableResultInt.CRIJ0FLJA,
					CallableResultInt.CRIJ0FLE0,
					CallableResultInt.CRIJ0FLE1,
					CallableResultInt.CRIJ0FLE2,
					CallableResultInt.CRIJ0FLEA,
					CallableResultInt.CRIJ0FLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ1
				extends //
					CallableResultInt.CRIJ1FLJ0,
					CallableResultInt.CRIJ1FLJ1,
					CallableResultInt.CRIJ1FLJ2,
					CallableResultInt.CRIJ1FLJA,
					CallableResultInt.CRIJ1FLE0,
					CallableResultInt.CRIJ1FLE1,
					CallableResultInt.CRIJ1FLE2,
					CallableResultInt.CRIJ1FLEA,
					CallableResultInt.CRIJ1FLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ2
				extends //
					CallableResultInt.CRIJ2FLJ0,
					CallableResultInt.CRIJ2FLJ1,
					CallableResultInt.CRIJ2FLJ2,
					CallableResultInt.CRIJ2FLJA,
					CallableResultInt.CRIJ2FLE0,
					CallableResultInt.CRIJ2FLE1,
					CallableResultInt.CRIJ2FLE2,
					CallableResultInt.CRIJ2FLEA,
					CallableResultInt.CRIJ2FLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLong
				extends //
					CallableResultLong.CRLJ0FLJ0,
					CallableResultLong.CRLJ1FLJ1,
					CallableResultLong.CRLJ2FLJ2,
					CallableResultLong.CRLJAFLJA,
					CallableResultLong.CRLE0FLE0,
					CallableResultLong.CRLE1FLE1,
					CallableResultLong.CRLE2FLE2,
					CallableResultLong.CRLEAFLEA,
					CallableResultLong.CRLEXFLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongE
				extends //
					CallableResultLong.CRLE0FLJ0,
					CallableResultLong.CRLE1FLJ1,
					CallableResultLong.CRLE2FLJ2,
					CallableResultLong.CRLEAFLJA {

			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongE0
				extends //
					CallableResultLong.CRLE0FLJ0,
					CallableResultLong.CRLE0FLJ1,
					CallableResultLong.CRLE0FLJ2,
					CallableResultLong.CRLE0FLJA,
					CallableResultLong.CRLE0FLE1,
					CallableResultLong.CRLE0FLE2,
					CallableResultLong.CRLE0FLEA,
					CallableResultLong.CRLE0FLEX {

			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongE1
				extends //
					CallableResultLong.CRLE1FLJ0,
					CallableResultLong.CRLE1FLJ1,
					CallableResultLong.CRLE1FLJ2,
					CallableResultLong.CRLE1FLJA,
					CallableResultLong.CRLE1FLE0,
					CallableResultLong.CRLE1FLE2,
					CallableResultLong.CRLE1FLEA,
					CallableResultLong.CRLE1FLEX {

			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongE2
				extends //
					CallableResultLong.CRLE2FLJ0,
					CallableResultLong.CRLE2FLJ1,
					CallableResultLong.CRLE2FLJ2,
					CallableResultLong.CRLE2FLJA,
					CallableResultLong.CRLE2FLE0,
					CallableResultLong.CRLE2FLE1,
					CallableResultLong.CRLE2FLEA,
					CallableResultLong.CRLE2FLEX {

			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongEX
				extends //
					CallableResultLong.CRLEXFLJ0,
					CallableResultLong.CRLEXFLJ1,
					CallableResultLong.CRLEXFLJ2,
					CallableResultLong.CRLEXFLJA,
					CallableResultLong.CRLEXFLE0,
					CallableResultLong.CRLEXFLE1,
					CallableResultLong.CRLEXFLE2,
					CallableResultLong.CRLEXFLEA {

			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongJ
				extends //
					CallableResultLong.CRLJ0FLE0,
					CallableResultLong.CRLJ1FLE1,
					CallableResultLong.CRLJ2FLE2,
					CallableResultLong.CRLJAFLEA,
					CallableResultLong.CRLJAFLEX {

			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongJ0
				extends //
					CallableResultLong.CRLJ0FLJ1,
					CallableResultLong.CRLJ0FLJ2,
					CallableResultLong.CRLJ0FLJA,
					CallableResultLong.CRLJ0FLE0,
					CallableResultLong.CRLJ0FLE1,
					CallableResultLong.CRLJ0FLE2,
					CallableResultLong.CRLJ0FLEA,
					CallableResultLong.CRLJ0FLEX {

			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongJ1
				extends //
					CallableResultLong.CRLJ1FLJ0,
					CallableResultLong.CRLJ1FLJ1,
					CallableResultLong.CRLJ1FLJ2,
					CallableResultLong.CRLJ1FLJA,
					CallableResultLong.CRLJ1FLE0,
					CallableResultLong.CRLJ1FLE1,
					CallableResultLong.CRLJ1FLE2,
					CallableResultLong.CRLJ1FLEA,
					CallableResultLong.CRLJ1FLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNative
				extends //
					CallableResultNative.CRNJ0FLJ0,
					CallableResultNative.CRNJ1FLJ1,
					CallableResultNative.CRNJ2FLJ2,
					CallableResultNative.CRNJAFLJA,
					CallableResultNative.CRNE0FLE0,
					CallableResultNative.CRNE1FLE1,
					CallableResultNative.CRNE2FLE2,
					CallableResultNative.CRNEAFLEA,
					CallableResultNative.CRNEXFLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE
				extends //
					CallableResultNative.CRNE0FLJ0,
					CallableResultNative.CRNE1FLJ1,
					CallableResultNative.CRNE2FLJ2,
					CallableResultNative.CRNEAFLJA,
					CallableResultNative.CRNE0FLE0,
					CallableResultNative.CRNE1FLE1,
					CallableResultNative.CRNE2FLE2,
					CallableResultNative.CRNEAFLEA,
					CallableResultNative.CRNEXFLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE0
				extends //
					CallableResultNative.CRNE0FLJ0,
					CallableResultNative.CRNE0FLJ1,
					CallableResultNative.CRNE0FLJ2,
					CallableResultNative.CRNE0FLJA,
					CallableResultNative.CRNE0FLE0,
					CallableResultNative.CRNE0FLE1,
					CallableResultNative.CRNE0FLE2,
					CallableResultNative.CRNE0FLEA,
					CallableResultNative.CRNE0FLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE1
				extends //
					CallableResultNative.CRNE1FLJ0,
					CallableResultNative.CRNE1FLJ1,
					CallableResultNative.CRNE1FLJ2,
					CallableResultNative.CRNE1FLJA,
					CallableResultNative.CRNE1FLE0,
					CallableResultNative.CRNE1FLE1,
					CallableResultNative.CRNE1FLE2,
					CallableResultNative.CRNE1FLEA,
					CallableResultNative.CRNE1FLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE2
				extends //
					CallableResultNative.CRNE2FLJ0,
					CallableResultNative.CRNE2FLJ1,
					CallableResultNative.CRNE2FLJ2,
					CallableResultNative.CRNE2FLJA,
					CallableResultNative.CRNE2FLE0,
					CallableResultNative.CRNE2FLE1,
					CallableResultNative.CRNE2FLE2,
					CallableResultNative.CRNE2FLEA,
					CallableResultNative.CRNE2FLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeEA
				extends //
					CallableResultNative.CRNEAFLJ0,
					CallableResultNative.CRNEAFLJ1,
					CallableResultNative.CRNEAFLJ2,
					CallableResultNative.CRNEAFLJA,
					CallableResultNative.CRNEAFLE0,
					CallableResultNative.CRNEAFLE1,
					CallableResultNative.CRNEAFLE2,
					CallableResultNative.CRNEAFLEA,
					CallableResultNative.CRNEAFLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeEX
				extends //
					CallableResultNative.CRNEXFLJ0,
					CallableResultNative.CRNEXFLJ1,
					CallableResultNative.CRNEXFLJ2,
					CallableResultNative.CRNEXFLJA,
					CallableResultNative.CRNEXFLE0,
					CallableResultNative.CRNEXFLE1,
					CallableResultNative.CRNEXFLE2,
					CallableResultNative.CRNEXFLEA,
					CallableResultNative.CRNEXFLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ
				extends //
					CallableResultNative.CRNJ0FLJ0,
					CallableResultNative.CRNJ1FLJ1,
					CallableResultNative.CRNJ2FLJ2,
					CallableResultNative.CRNJAFLJA,
					CallableResultNative.CRNJ0FLE0,
					CallableResultNative.CRNJ1FLE1,
					CallableResultNative.CRNJ2FLE2,
					CallableResultNative.CRNJAFLEA,
					CallableResultNative.CRNJAFLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ0
				extends //
					CallableResultNative.CRNJ0FLJ0,
					CallableResultNative.CRNJ0FLJ1,
					CallableResultNative.CRNJ0FLJ2,
					CallableResultNative.CRNJ0FLJA,
					CallableResultNative.CRNJ0FLE0,
					CallableResultNative.CRNJ0FLE1,
					CallableResultNative.CRNJ0FLE2,
					CallableResultNative.CRNJ0FLEA,
					CallableResultNative.CRNJ0FLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ1
				extends //
					CallableResultNative.CRNJ1FLJ0,
					CallableResultNative.CRNJ1FLJ1,
					CallableResultNative.CRNJ1FLJ2,
					CallableResultNative.CRNJ1FLJA,
					CallableResultNative.CRNJ1FLE0,
					CallableResultNative.CRNJ1FLE1,
					CallableResultNative.CRNJ1FLE2,
					CallableResultNative.CRNJ1FLEA,
					CallableResultNative.CRNJ1FLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ2
				extends //
					CallableResultNative.CRNJ2FLJ0,
					CallableResultNative.CRNJ2FLJ1,
					CallableResultNative.CRNJ2FLJ2,
					CallableResultNative.CRNJ2FLJA,
					CallableResultNative.CRNJ2FLE0,
					CallableResultNative.CRNJ2FLE1,
					CallableResultNative.CRNJ2FLE2,
					CallableResultNative.CRNJ2FLEA,
					CallableResultNative.CRNJ2FLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJA
				extends //
					CallableResultNative.CRNJAFLJ0,
					CallableResultNative.CRNJAFLJ1,
					CallableResultNative.CRNJAFLJ2,
					CallableResultNative.CRNJAFLJA,
					CallableResultNative.CRNJAFLE0,
					CallableResultNative.CRNJAFLE1,
					CallableResultNative.CRNJAFLE2,
					CallableResultNative.CRNJAFLEA,
					CallableResultNative.CRNJAFLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore
				extends //
					ExecCallable.ForLong.UseLongE,
					CallableResultStore.CREE0FLE0,
					CallableResultStore.CREE1FLE1,
					CallableResultStore.CREE2FLE2,
					CallableResultStore.CREEXFLEA,
					CallableResultStore.CREEXFLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore0
				extends //
					CallableResultLong.CRLE0FLJ0,
					CallableResultLong.CRLE1FLJ1,
					CallableResultLong.CRLE2FLJ2,
					CallableResultLong.CRLEAFLJA,
					CallableResultStore.CREE0FLE0,
					CallableResultStore.CREE0FLE1,
					CallableResultStore.CREE0FLE2,
					CallableResultStore.CREE0FLEA,
					CallableResultStore.CREE0FLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore1
				extends //
					CallableResultLong.CRLE1FLJ0,
					CallableResultLong.CRLE1FLJ1,
					CallableResultLong.CRLE1FLJ2,
					CallableResultLong.CRLE1FLJA,
					CallableResultStore.CREE1FLE0,
					CallableResultStore.CREE1FLE1,
					CallableResultStore.CREE1FLE2,
					CallableResultStore.CREE1FLEA,
					CallableResultStore.CREE1FLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore2
				extends //
					CallableResultLong.CRLE2FLJ0,
					CallableResultLong.CRLE2FLJ1,
					CallableResultLong.CRLE2FLJ2,
					CallableResultLong.CRLE2FLJA,
					CallableResultStore.CREE2FLE0,
					CallableResultStore.CREE2FLE1,
					CallableResultStore.CREE2FLE2,
					CallableResultStore.CREE2FLEA,
					CallableResultStore.CREE2FLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStoreX
				extends //
					CallableResultLong.CRLEXFLJ0,
					CallableResultLong.CRLEXFLJ1,
					CallableResultLong.CRLEXFLJ2,
					CallableResultLong.CRLEXFLJA,
					CallableResultStore.CREEXFLE0,
					CallableResultStore.CREEXFLE1,
					CallableResultStore.CREEXFLE2,
					CallableResultStore.CREEXFLEA,
					CallableResultStore.CREEXFLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseString
				extends //
					CallableResultString.CRSJ0FLJ0,
					CallableResultString.CRSJ1FLJ1,
					CallableResultString.CRSJ2FLJ2,
					CallableResultString.CRSJAFLJA,
					CallableResultString.CRSE0FLE0,
					CallableResultString.CRSE1FLE1,
					CallableResultString.CRSE2FLE2,
					CallableResultString.CRSEAFLEA,
					CallableResultString.CRSEXFLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringE
				extends //
					CallableResultString.CRSE0FLJ0,
					CallableResultString.CRSE1FLJ1,
					CallableResultString.CRSE2FLJ2,
					CallableResultString.CRSEAFLJA,
					CallableResultString.CRSE0FLE0,
					CallableResultString.CRSE1FLE1,
					CallableResultString.CRSE2FLE2,
					CallableResultString.CRSEAFLEA,
					CallableResultString.CRSEXFLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringE0
				extends //
					CallableResultString.CRSE0FLJ0,
					CallableResultString.CRSE0FLJ1,
					CallableResultString.CRSE0FLJ2,
					CallableResultString.CRSE0FLJA,
					CallableResultString.CRSE0FLE0,
					CallableResultString.CRSE0FLE1,
					CallableResultString.CRSE0FLE2,
					CallableResultString.CRSE0FLEA,
					CallableResultString.CRSE0FLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringE1
				extends //
					CallableResultString.CRSE1FLJ0,
					CallableResultString.CRSE1FLJ1,
					CallableResultString.CRSE1FLJ2,
					CallableResultString.CRSE1FLJA,
					CallableResultString.CRSE1FLE0,
					CallableResultString.CRSE1FLE1,
					CallableResultString.CRSE1FLE2,
					CallableResultString.CRSE1FLEA,
					CallableResultString.CRSE1FLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringJ
				extends //
					CallableResultString.CRSJ0FLJ0,
					CallableResultString.CRSJ1FLJ1,
					CallableResultString.CRSJ2FLJ2,
					CallableResultString.CRSJAFLJA,
					CallableResultString.CRSJ0FLE0,
					CallableResultString.CRSJ1FLE1,
					CallableResultString.CRSJ2FLE2,
					CallableResultString.CRSJAFLEA,
					CallableResultString.CRSJAFLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringJ0
				extends //
					CallableResultString.CRSJ0FLJ0,
					CallableResultString.CRSJ0FLJ1,
					CallableResultString.CRSJ0FLJ2,
					CallableResultString.CRSJ0FLJA,
					CallableResultString.CRSJ0FLE0,
					CallableResultString.CRSJ0FLE1,
					CallableResultString.CRSJ0FLE2,
					CallableResultString.CRSJ0FLEA,
					CallableResultString.CRSJ0FLEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringJ1
				extends //
					CallableResultString.CRSJ1FLJ0,
					CallableResultString.CRSJ1FLJ1,
					CallableResultString.CRSJ1FLJ2,
					CallableResultString.CRSJ1FLJA,
					CallableResultString.CRSJ1FLE0,
					CallableResultString.CRSJ1FLE1,
					CallableResultString.CRSJ1FLE2,
					CallableResultString.CRSJ1FLEA,
					CallableResultString.CRSJ1FLEX {
			//
		}

		private ForLong() {
			
			// prevent
		}
	}

	/** @author myx */
	@ReflectionDisable
	public static class ForNative {

		/** @author myx */
		@ReflectionDisable
		public static interface UseInt
				extends //
					CallableResultInt.CRIJ0FNJ0,
					CallableResultInt.CRIJ1FNJ1,
					CallableResultInt.CRIJ2FNJ2,
					CallableResultInt.CRIJAFNJA,
					CallableResultInt.CRIE0FNE0,
					CallableResultInt.CRIE1FNE1,
					CallableResultInt.CRIE2FNE2,
					CallableResultInt.CRIEAFNEA,
					CallableResultInt.CRIEXFNEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ
				extends//
					CallableResultInt.CRIJ0FNJ0,
					CallableResultInt.CRIJ1FNJ1,
					CallableResultInt.CRIJ2FNJ2,
					CallableResultInt.CRIJAFNJA,
					CallableResultInt.CRIJ0FNE0,
					CallableResultInt.CRIJ1FNE1,
					CallableResultInt.CRIJ2FNE2,
					CallableResultInt.CRIJAFNEA,
					CallableResultInt.CRIJAFNEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ0
				extends//
					CallableResultInt.CRIJ0FNJ0,
					CallableResultInt.CRIJ0FNJ1,
					CallableResultInt.CRIJ0FNJ2,
					CallableResultInt.CRIJ0FNJA,
					CallableResultInt.CRIJ0FNE0,
					CallableResultInt.CRIJ0FNE1,
					CallableResultInt.CRIJ0FNE2,
					CallableResultInt.CRIJ0FNEA,
					CallableResultInt.CRIJ0FNEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ1
				extends//
					CallableResultInt.CRIJ1FNJ0,
					CallableResultInt.CRIJ1FNJ1,
					CallableResultInt.CRIJ1FNJ2,
					CallableResultInt.CRIJ1FNJA,
					CallableResultInt.CRIJ1FNE0,
					CallableResultInt.CRIJ1FNE1,
					CallableResultInt.CRIJ1FNE2,
					CallableResultInt.CRIJ1FNEA,
					CallableResultInt.CRIJ1FNEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ2
				extends//
					CallableResultInt.CRIJ2FNJ0,
					CallableResultInt.CRIJ2FNJ1,
					CallableResultInt.CRIJ2FNJ2,
					CallableResultInt.CRIJ2FNJA,
					CallableResultInt.CRIJ2FNE0,
					CallableResultInt.CRIJ2FNE1,
					CallableResultInt.CRIJ2FNE2,
					CallableResultInt.CRIJ2FNEA,
					CallableResultInt.CRIJ2FNEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLong
				extends //
					CallableResultLong.CRLJ0FNJ0,
					CallableResultLong.CRLJ1FNJ1,
					CallableResultLong.CRLJ2FNJ2,
					CallableResultLong.CRLJAFNJA,
					CallableResultLong.CRLE0FNE0,
					CallableResultLong.CRLE1FNE1,
					CallableResultLong.CRLE2FNE2,
					CallableResultLong.CRLEAFNEA,
					CallableResultLong.CRLEXFNEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongJ
				extends//
					CallableResultLong.CRLJ0FNJ0,
					CallableResultLong.CRLJ1FNJ1,
					CallableResultLong.CRLJ2FNJ2,
					CallableResultLong.CRLJAFNJA,
					CallableResultLong.CRLJ0FNE0,
					CallableResultLong.CRLJ1FNE1,
					CallableResultLong.CRLJ2FNE2,
					CallableResultLong.CRLJAFNEA,
					CallableResultLong.CRLJAFNEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongJ0
				extends//
					CallableResultLong.CRLJ0FNJ0,
					CallableResultLong.CRLJ0FNJ1,
					CallableResultLong.CRLJ0FNJ2,
					CallableResultLong.CRLJ0FNJA,
					CallableResultLong.CRLJ0FNE0,
					CallableResultLong.CRLJ0FNE1,
					CallableResultLong.CRLJ0FNE2,
					CallableResultLong.CRLJ0FNEA,
					CallableResultLong.CRLJ0FNEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongJ1
				extends//
					CallableResultLong.CRLJ1FNJ0,
					CallableResultLong.CRLJ1FNJ1,
					CallableResultLong.CRLJ1FNJ2,
					CallableResultLong.CRLJ1FNJA,
					CallableResultLong.CRLJ1FNE0,
					CallableResultLong.CRLJ1FNE1,
					CallableResultLong.CRLJ1FNE2,
					CallableResultLong.CRLJ1FNEA,
					CallableResultLong.CRLJ1FNEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE
				extends //
					CallableResultNative.CRNE0FNJ0,
					CallableResultNative.CRNE1FNJ1,
					CallableResultNative.CRNE2FNJ2,
					CallableResultNative.CRNEAFNJA {

			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE0
				extends //
					CallableResultNative.CRNE0FNJ0,
					CallableResultNative.CRNE0FNJ1,
					CallableResultNative.CRNE0FNJ2,
					CallableResultNative.CRNE0FNJA,
					CallableResultNative.CRNE0FNE1,
					CallableResultNative.CRNE0FNE2,
					CallableResultNative.CRNE0FNEA,
					CallableResultNative.CRNE0FNEX {

			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE1
				extends //
					CallableResultNative.CRNE1FNJ0,
					CallableResultNative.CRNE1FNJ1,
					CallableResultNative.CRNE1FNJ2,
					CallableResultNative.CRNE1FNJA,
					CallableResultNative.CRNE1FNE0,
					CallableResultNative.CRNE1FNE2,
					CallableResultNative.CRNE1FNEA,
					CallableResultNative.CRNE1FNEX {

			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE2
				extends //
					CallableResultNative.CRNE2FNJ0,
					CallableResultNative.CRNE2FNJ1,
					CallableResultNative.CRNE2FNJ2,
					CallableResultNative.CRNE2FNJA,
					CallableResultNative.CRNE2FNE0,
					CallableResultNative.CRNE2FNE1,
					CallableResultNative.CRNE2FNEA,
					CallableResultNative.CRNE2FNEX {

			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeEA
				extends //
					CallableResultNative.CRNEAFNJ0,
					CallableResultNative.CRNEAFNJ1,
					CallableResultNative.CRNEAFNJ2,
					CallableResultNative.CRNEAFNJA,
					CallableResultNative.CRNEAFNE0,
					CallableResultNative.CRNEAFNE1,
					CallableResultNative.CRNEAFNE2,
					CallableResultNative.CRNEAFNEX {

			//

		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeEX
				extends //
					CallableResultNative.CRNEXFNJ0,
					CallableResultNative.CRNEXFNJ1,
					CallableResultNative.CRNEXFNJ2,
					CallableResultNative.CRNEXFNJA,
					CallableResultNative.CRNEXFNE0,
					CallableResultNative.CRNEXFNE1,
					CallableResultNative.CRNEXFNE2,
					CallableResultNative.CRNEXFNEA {

			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ
				extends //
					CallableResultNative.CRNJ0FNE0,
					CallableResultNative.CRNJ1FNE1,
					CallableResultNative.CRNJ2FNE2,
					CallableResultNative.CRNJAFNEA,
					CallableResultNative.CRNJAFNEX {

			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ0
				extends //
					CallableResultNative.CRNJ0FNJ1,
					CallableResultNative.CRNJ0FNJ2,
					CallableResultNative.CRNJ0FNJA,
					CallableResultNative.CRNJ0FNE0,
					CallableResultNative.CRNJ0FNE1,
					CallableResultNative.CRNJ0FNE2,
					CallableResultNative.CRNJ0FNEA,
					CallableResultNative.CRNJ0FNEX {

			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ1
				extends //
					CallableResultNative.CRNJ1FNJ0,
					CallableResultNative.CRNJ1FNJ2,
					CallableResultNative.CRNJ1FNJA,
					CallableResultNative.CRNJ1FNE0,
					CallableResultNative.CRNJ1FNE1,
					CallableResultNative.CRNJ1FNE2,
					CallableResultNative.CRNJ1FNEA,
					CallableResultNative.CRNJ1FNEX {

			//

		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ2
				extends //
					CallableResultNative.CRNJ2FNJ0,
					CallableResultNative.CRNJ2FNJ1,
					CallableResultNative.CRNJ2FNJA,
					CallableResultNative.CRNJ2FNE0,
					CallableResultNative.CRNJ2FNE1,
					CallableResultNative.CRNJ2FNE2,
					CallableResultNative.CRNJ2FNEA,
					CallableResultNative.CRNJ2FNEX {

			//

		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJA
				extends //
					CallableResultNative.CRNJAFNJ0,
					CallableResultNative.CRNJAFNJ1,
					CallableResultNative.CRNJAFNJ2,
					CallableResultNative.CRNJAFNE0,
					CallableResultNative.CRNJAFNE1,
					CallableResultNative.CRNJAFNE2,
					CallableResultNative.CRNJAFNEA,
					CallableResultNative.CRNJAFNEX {

			//

		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore
				extends//
					ExecCallable.ForNative.UseNativeE,
					CallableResultStore.CREE0FNE0,
					CallableResultStore.CREE1FNE1,
					CallableResultStore.CREE2FNE2,
					CallableResultStore.CREEXFNEA,
					CallableResultStore.CREEXFNEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore0
				extends//
					CallableResultNative.CRNE0FNJ0,
					CallableResultNative.CRNE0FNJ1,
					CallableResultNative.CRNE0FNJ2,
					CallableResultNative.CRNE0FNJA,
					CallableResultStore.CREE0FNE0,
					CallableResultStore.CREE0FNE1,
					CallableResultStore.CREE0FNE2,
					CallableResultStore.CREE0FNEA,
					CallableResultStore.CREE0FNEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore1
				extends//
					CallableResultNative.CRNE1FNJ0,
					CallableResultNative.CRNE1FNJ1,
					CallableResultNative.CRNE1FNJ2,
					CallableResultNative.CRNE1FNJA,
					CallableResultStore.CREE1FNE0,
					CallableResultStore.CREE1FNE1,
					CallableResultStore.CREE1FNE2,
					CallableResultStore.CREE1FNEA,
					CallableResultStore.CREE1FNEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore2
				extends//
					CallableResultNative.CRNE2FNJ0,
					CallableResultNative.CRNE2FNJ1,
					CallableResultNative.CRNE2FNJ2,
					CallableResultNative.CRNE2FNJA,
					CallableResultStore.CREE2FNE0,
					CallableResultStore.CREE2FNE1,
					CallableResultStore.CREE2FNE2,
					CallableResultStore.CREE2FNEA,
					CallableResultStore.CREE2FNEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStoreX
				extends//
					CallableResultNative.CRNEXFNJ0,
					CallableResultNative.CRNEXFNJ1,
					CallableResultNative.CRNEXFNJ2,
					CallableResultNative.CRNEXFNJA,
					CallableResultStore.CREEXFNE0,
					CallableResultStore.CREEXFNE1,
					CallableResultStore.CREEXFNE2,
					CallableResultStore.CREEXFNEA,
					CallableResultStore.CREEXFNEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseString
				extends //
					CallableResultString.CRSJ0FNJ0,
					CallableResultString.CRSJ1FNJ1,
					CallableResultString.CRSJ2FNJ2,
					CallableResultString.CRSJAFNJA,
					CallableResultString.CRSE0FNE0,
					CallableResultString.CRSE1FNE1,
					CallableResultString.CRSE2FNE2,
					CallableResultString.CRSEAFNEA,
					CallableResultString.CRSEXFNEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringE
				extends //
					CallableResultString.CRSE0FNJ0,
					CallableResultString.CRSE1FNJ1,
					CallableResultString.CRSE2FNJ2,
					CallableResultString.CRSEAFNJA,
					CallableResultString.CRSE0FNE0,
					CallableResultString.CRSE1FNE1,
					CallableResultString.CRSE2FNE2,
					CallableResultString.CRSEAFNEA,
					CallableResultString.CRSEXFNEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringE0
				extends //
					CallableResultString.CRSE0FNJ0,
					CallableResultString.CRSE0FNJ1,
					CallableResultString.CRSE0FNJ2,
					CallableResultString.CRSE0FNJA,
					CallableResultString.CRSE0FNE0,
					CallableResultString.CRSE0FNE1,
					CallableResultString.CRSE0FNE2,
					CallableResultString.CRSE0FNEA,
					CallableResultString.CRSE0FNEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringE1
				extends //
					CallableResultString.CRSE1FNJ0,
					CallableResultString.CRSE1FNJ1,
					CallableResultString.CRSE1FNJ2,
					CallableResultString.CRSE1FNJA,
					CallableResultString.CRSE1FNE0,
					CallableResultString.CRSE1FNE1,
					CallableResultString.CRSE1FNE2,
					CallableResultString.CRSE1FNEA,
					CallableResultString.CRSE1FNEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringJ
				extends //
					CallableResultString.CRSJ0FNJ0,
					CallableResultString.CRSJ1FNJ1,
					CallableResultString.CRSJ2FNJ2,
					CallableResultString.CRSJAFNJA,
					CallableResultString.CRSJ0FNE0,
					CallableResultString.CRSJ1FNE1,
					CallableResultString.CRSJ2FNE2,
					CallableResultString.CRSJAFNEA,
					CallableResultString.CRSJAFNEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringJ0
				extends //
					CallableResultString.CRSJ0FNJ0,
					CallableResultString.CRSJ0FNJ1,
					CallableResultString.CRSJ0FNJ2,
					CallableResultString.CRSJ0FNJA,
					CallableResultString.CRSJ0FNE0,
					CallableResultString.CRSJ0FNE1,
					CallableResultString.CRSJ0FNE2,
					CallableResultString.CRSJ0FNEA,
					CallableResultString.CRSJ0FNEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringJ1
				extends //
					CallableResultString.CRSJ1FNJ0,
					CallableResultString.CRSJ1FNJ1,
					CallableResultString.CRSJ1FNJ2,
					CallableResultString.CRSJ1FNJA,
					CallableResultString.CRSJ1FNE0,
					CallableResultString.CRSJ1FNE1,
					CallableResultString.CRSJ1FNE2,
					CallableResultString.CRSJ1FNEA,
					CallableResultString.CRSJ1FNEX {
			//
		}

		private ForNative() {
			
			// prevent
		}
	}

	/** @author myx */
	@ReflectionDisable
	static class ForNumbers {

		/** @author myx */
		@ReflectionDisable
		public static interface UseInt
				extends //
					ExecCallable.ForLong.UseInt,
					ExecCallable.ForInt.UseInt,
					ExecCallable.ForDouble.UseInt {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ
				extends //
					ExecCallable.ForNumbers.UseInt,
					ExecCallable.ForLong.UseIntJ,
					ExecCallable.ForInt.UseIntJ,
					ExecCallable.ForDouble.UseIntJ {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ0
				extends //
					ExecCallable.ForNumbers.UseIntJ,
					ExecCallable.ForLong.UseIntJ0,
					ExecCallable.ForInt.UseIntJ0,
					ExecCallable.ForDouble.UseIntJ0 {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ1
				extends //
					ExecCallable.ForNumbers.UseIntJ,
					ExecCallable.ForLong.UseIntJ1,
					ExecCallable.ForInt.UseIntJ1,
					ExecCallable.ForDouble.UseIntJ1 {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ2
				extends //
					ExecCallable.ForNumbers.UseIntJ,
					ExecCallable.ForLong.UseIntJ2,
					ExecCallable.ForInt.UseIntJ2,
					ExecCallable.ForDouble.UseIntJ2 {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLong
				extends //
					ExecCallable.ForLong.UseLong,
					ExecCallable.ForInt.UseLong,
					ExecCallable.ForDouble.UseLong {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongJ
				extends //
					ExecCallable.ForNumbers.UseLong,
					ExecCallable.ForLong.UseLongJ,
					ExecCallable.ForInt.UseLongJ,
					ExecCallable.ForDouble.UseLongJ {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongJ0
				extends //
					ExecCallable.ForNumbers.UseLongJ,
					ExecCallable.ForLong.UseLongJ0,
					ExecCallable.ForInt.UseLongJ0,
					ExecCallable.ForDouble.UseLongJ0 {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongJ1
				extends //
					ExecCallable.ForNumbers.UseLongJ,
					ExecCallable.ForLong.UseLongJ1,
					ExecCallable.ForInt.UseLongJ1,
					ExecCallable.ForDouble.UseLongJ1 {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNative
				extends //
					ExecCallable.ForLong.UseNative,
					ExecCallable.ForInt.UseNative,
					ExecCallable.ForDouble.UseNative {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE
				extends //
					ExecCallable.ForNumbers.UseNative,
					ExecCallable.ForLong.UseNativeE,
					ExecCallable.ForInt.UseNativeE,
					ExecCallable.ForDouble.UseNativeE {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE0
				extends //
					ExecCallable.ForNumbers.UseNativeE,
					ExecCallable.ForLong.UseNativeE0,
					ExecCallable.ForInt.UseNativeE0,
					ExecCallable.ForDouble.UseNativeE0 {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE1
				extends //
					ExecCallable.ForNumbers.UseNativeE,
					ExecCallable.ForLong.UseNativeE1,
					ExecCallable.ForInt.UseNativeE1,
					ExecCallable.ForDouble.UseNativeE1 {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE2
				extends //
					ExecCallable.ForNumbers.UseNativeE,
					ExecCallable.ForLong.UseNativeE2,
					ExecCallable.ForInt.UseNativeE2,
					ExecCallable.ForDouble.UseNativeE2 {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeEA
				extends //
					ExecCallable.ForNumbers.UseNativeE,
					ExecCallable.ForLong.UseNativeEA,
					ExecCallable.ForInt.UseNativeEA,
					ExecCallable.ForDouble.UseNativeEA {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeEX
				extends //
					ExecCallable.ForNumbers.UseNativeE,
					ExecCallable.ForLong.UseNativeEX,
					ExecCallable.ForInt.UseNativeEX,
					ExecCallable.ForDouble.UseNativeEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ
				extends //
					ExecCallable.ForNumbers.UseNative,
					ExecCallable.ForLong.UseNativeJ,
					ExecCallable.ForInt.UseNativeJ,
					ExecCallable.ForDouble.UseNativeJ {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ0
				extends //
					ExecCallable.ForNumbers.UseNativeJ,
					ExecCallable.ForLong.UseNativeJ0,
					ExecCallable.ForInt.UseNativeJ0,
					ExecCallable.ForDouble.UseNativeJ0 {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ1
				extends //
					ExecCallable.ForNumbers.UseNativeJ,
					ExecCallable.ForLong.UseNativeJ1,
					ExecCallable.ForInt.UseNativeJ1,
					ExecCallable.ForDouble.UseNativeJ1 {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ2
				extends //
					ExecCallable.ForNumbers.UseNativeJ,
					ExecCallable.ForLong.UseNativeJ2,
					ExecCallable.ForInt.UseNativeJ2,
					ExecCallable.ForDouble.UseNativeJ2 {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJA
				extends //
					ExecCallable.ForNumbers.UseNativeJ,
					ExecCallable.ForLong.UseNativeJA,
					ExecCallable.ForInt.UseNativeJA,
					ExecCallable.ForDouble.UseNativeJA {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNumbersE0
				extends //
					ExecCallable.ForDouble.UseDoubleE0,
					ExecCallable.ForInt.UseIntE0,
					ExecCallable.ForLong.UseLongE0 {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNumbersE1
				extends //
					ExecCallable.ForDouble.UseDoubleE1,
					ExecCallable.ForInt.UseIntE1,
					ExecCallable.ForLong.UseLongE1 {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNumbersE2
				extends //
					ExecCallable.ForDouble.UseDoubleE2,
					ExecCallable.ForInt.UseIntE2,
					ExecCallable.ForLong.UseLongE2 {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNumbersEX
				extends //
					ExecCallable.ForDouble.UseDoubleEX,
					ExecCallable.ForInt.UseIntEX,
					ExecCallable.ForLong.UseLongEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNumbersJ0
				extends //
					ExecCallable.ForDouble.UseDoubleJ0,
					ExecCallable.ForInt.UseIntJ0,
					ExecCallable.ForLong.UseLongJ0 {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore
				extends //
					ExecCallable.ForLong.UseStore,
					ExecCallable.ForInt.UseStore,
					ExecCallable.ForDouble.UseStore {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore0
				extends //
					ExecCallable.ForLong.UseStore0,
					ExecCallable.ForInt.UseStore0,
					ExecCallable.ForDouble.UseStore0 {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore1
				extends //
					ExecCallable.ForLong.UseStore1,
					ExecCallable.ForInt.UseStore1,
					ExecCallable.ForDouble.UseStore1 {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore2
				extends //
					ExecCallable.ForLong.UseStore2,
					ExecCallable.ForInt.UseStore2,
					ExecCallable.ForDouble.UseStore2 {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStoreX
				extends //
					ExecCallable.ForLong.UseStoreX,
					ExecCallable.ForInt.UseStoreX,
					ExecCallable.ForDouble.UseStoreX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseString
				extends //
					ExecCallable.ForLong.UseString,
					ExecCallable.ForInt.UseString,
					ExecCallable.ForDouble.UseString {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringJ
				extends //
					ExecCallable.ForNumbers.UseString,
					ExecCallable.ForLong.UseStringJ,
					ExecCallable.ForInt.UseStringJ,
					ExecCallable.ForDouble.UseStringJ {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringJ0
				extends //
					ExecCallable.ForNumbers.UseStringJ,
					ExecCallable.ForLong.UseStringJ0,
					ExecCallable.ForInt.UseStringJ0,
					ExecCallable.ForDouble.UseStringJ0 {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringJ1
				extends //
					ExecCallable.ForNumbers.UseStringJ,
					ExecCallable.ForLong.UseStringJ1,
					ExecCallable.ForInt.UseStringJ1,
					ExecCallable.ForDouble.UseStringJ1 {
			//
		}

		private ForNumbers() {
			
			// prevent
		}
	}

	/** @author myx */
	@ReflectionDisable
	public static class ForStore {

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntE
				extends //
					CallableResultInt.CRIE0FEE0,
					CallableResultInt.CRIE1FEE1,
					CallableResultInt.CRIE2FEE2,
					CallableResultInt.CRIEXFEEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ
				extends //
					CallableResultInt.CRIJ0FEE0,
					CallableResultInt.CRIJ1FEE1,
					CallableResultInt.CRIJ2FEE2,
					CallableResultInt.CRIJAFEEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ0
				extends //
					CallableResultInt.CRIJ0FEE0,
					CallableResultInt.CRIJ0FEE1,
					CallableResultInt.CRIJ0FEE2,
					CallableResultInt.CRIJ0FEEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ1
				extends //
					CallableResultInt.CRIJ1FEE0,
					CallableResultInt.CRIJ1FEE1,
					CallableResultInt.CRIJ1FEE2,
					CallableResultInt.CRIJ1FEEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ2
				extends //
					CallableResultInt.CRIJ2FEE0,
					CallableResultInt.CRIJ2FEE1,
					CallableResultInt.CRIJ2FEE2,
					CallableResultInt.CRIJ2FEEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongE
				extends //
					CallableResultLong.CRLE0FEE0,
					CallableResultLong.CRLE1FEE1,
					CallableResultLong.CRLE2FEE2,
					CallableResultLong.CRLEXFEEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongJ
				extends //
					CallableResultLong.CRLJ0FEE0,
					CallableResultLong.CRLJ1FEE1,
					CallableResultLong.CRLJ2FEE2,
					CallableResultLong.CRLJAFEEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongJ0
				extends //
					CallableResultLong.CRLJ0FEE0,
					CallableResultLong.CRLJ0FEE1,
					CallableResultLong.CRLJ0FEE2,
					CallableResultLong.CRLJ0FEEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongJ1
				extends //
					CallableResultLong.CRLJ1FEE0,
					CallableResultLong.CRLJ1FEE1,
					CallableResultLong.CRLJ1FEE2,
					CallableResultLong.CRLJ1FEEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE
				extends //
					CallableResultNative.CRNE0FEE0,
					CallableResultNative.CRNE1FEE1,
					CallableResultNative.CRNE2FEE2,
					CallableResultNative.CRNEXFEEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE0
				extends //
					CallableResultNative.CRNE0FEE0,
					CallableResultNative.CRNE0FEE1,
					CallableResultNative.CRNE0FEE2,
					CallableResultNative.CRNE0FEEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE1
				extends //
					CallableResultNative.CRNE1FEE0,
					CallableResultNative.CRNE1FEE1,
					CallableResultNative.CRNE1FEE2,
					CallableResultNative.CRNE1FEEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE2
				extends //
					CallableResultNative.CRNE2FEE0,
					CallableResultNative.CRNE2FEE1,
					CallableResultNative.CRNE2FEE2,
					CallableResultNative.CRNE2FEEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeEA
				extends //
					CallableResultNative.CRNEAFEE0,
					CallableResultNative.CRNEAFEE1,
					CallableResultNative.CRNEAFEE2,
					CallableResultNative.CRNEAFEEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeEX
				extends //
					CallableResultNative.CRNEXFEE0,
					CallableResultNative.CRNEXFEE1,
					CallableResultNative.CRNEXFEE2,
					CallableResultNative.CRNEXFEEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ
				extends //
					CallableResultNative.CRNJ0FEE0,
					CallableResultNative.CRNJ1FEE1,
					CallableResultNative.CRNJ2FEE2,
					CallableResultNative.CRNJAFEEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ0
				extends //
					CallableResultNative.CRNJ0FEE0,
					CallableResultNative.CRNJ0FEE1,
					CallableResultNative.CRNJ0FEE2,
					CallableResultNative.CRNJ0FEEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ1
				extends //
					CallableResultNative.CRNJ1FEE0,
					CallableResultNative.CRNJ1FEE1,
					CallableResultNative.CRNJ1FEE2,
					CallableResultNative.CRNJ1FEEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ2
				extends //
					CallableResultNative.CRNJ2FEE0,
					CallableResultNative.CRNJ2FEE1,
					CallableResultNative.CRNJ2FEE2,
					CallableResultNative.CRNJ2FEEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJA
				extends //
					CallableResultNative.CRNJAFEE0,
					CallableResultNative.CRNJAFEE1,
					CallableResultNative.CRNJAFEE2,
					CallableResultNative.CRNJAFEEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore0
				extends //
					CallableResultStore.CREE0FEE1,
					CallableResultStore.CREE0FEE2,
					CallableResultStore.CREE0FEEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore1
				extends //
					CallableResultStore.CREE1FEE0,
					CallableResultStore.CREE1FEE2,
					CallableResultStore.CREE1FEEX {

			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore2
				extends //
					CallableResultStore.CREE2FEE1,
					CallableResultStore.CREE2FEE0,
					CallableResultStore.CREE2FEEX {

			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStoreX
				extends //
					CallableResultStore.CREEXFEE1,
					CallableResultStore.CREEXFEE0,
					CallableResultStore.CREEXFEE2 {

			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringE
				extends //
					CallableResultString.CRSE0FEE0,
					CallableResultString.CRSE1FEE1,
					CallableResultString.CRSE2FEE2,
					CallableResultString.CRSEXFEEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringE0
				extends //
					CallableResultString.CRSE0FEE0,
					CallableResultString.CRSE0FEE1,
					CallableResultString.CRSE0FEE2,
					CallableResultString.CRSE0FEEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringE1
				extends //
					CallableResultString.CRSE1FEE0,
					CallableResultString.CRSE1FEE1,
					CallableResultString.CRSE1FEE2,
					CallableResultString.CRSE1FEEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringJ
				extends //
					CallableResultString.CRSJ0FEE0,
					CallableResultString.CRSJ1FEE1,
					CallableResultString.CRSJ2FEE2,
					CallableResultString.CRSJAFEEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringJ0
				extends //
					CallableResultString.CRSJ0FEE0,
					CallableResultString.CRSJ0FEE1,
					CallableResultString.CRSJ0FEE2,
					CallableResultString.CRSJ0FEEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringJ1
				extends //
					CallableResultString.CRSJ1FEE0,
					CallableResultString.CRSJ1FEE1,
					CallableResultString.CRSJ1FEE2,
					CallableResultString.CRSJ1FEEX {
			//
		}

		private ForStore() {
			
			// prevent
		}
	}

	/** @author myx */
	@ReflectionDisable
	public static class ForString {

		/** @author myx */
		@ReflectionDisable
		public static interface UseInt
				extends //
					CallableResultInt.CRIJ0FSJ0,
					CallableResultInt.CRIJ1FSJ1,
					CallableResultInt.CRIJ2FSJ2,
					CallableResultInt.CRIJAFSJA,
					CallableResultInt.CRIE0FSE0,
					CallableResultInt.CRIE1FSE1,
					CallableResultInt.CRIE2FSE2,
					CallableResultInt.CRIEAFSEA,
					CallableResultInt.CRIEXFSEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ
				extends //
					CallableResultInt.CRIJ0FSJ0,
					CallableResultInt.CRIJ1FSJ1,
					CallableResultInt.CRIJ2FSJ2,
					CallableResultInt.CRIJAFSJA,
					CallableResultInt.CRIJ0FSE0,
					CallableResultInt.CRIJ1FSE1,
					CallableResultInt.CRIJ2FSE2,
					CallableResultInt.CRIJAFSEA,
					CallableResultInt.CRIJAFSEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ0
				extends //
					CallableResultInt.CRIJ0FSJ0,
					CallableResultInt.CRIJ0FSJ1,
					CallableResultInt.CRIJ0FSJ2,
					CallableResultInt.CRIJ0FSJA,
					CallableResultInt.CRIJ0FSE0,
					CallableResultInt.CRIJ0FSE1,
					CallableResultInt.CRIJ0FSE2,
					CallableResultInt.CRIJ0FSEA,
					CallableResultInt.CRIJ0FSEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ1
				extends //
					CallableResultInt.CRIJ1FSJ0,
					CallableResultInt.CRIJ1FSJ1,
					CallableResultInt.CRIJ1FSJ2,
					CallableResultInt.CRIJ1FSJA,
					CallableResultInt.CRIJ1FSE0,
					CallableResultInt.CRIJ1FSE1,
					CallableResultInt.CRIJ1FSE2,
					CallableResultInt.CRIJ1FSEA,
					CallableResultInt.CRIJ1FSEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ2
				extends //
					CallableResultInt.CRIJ2FSJ0,
					CallableResultInt.CRIJ2FSJ1,
					CallableResultInt.CRIJ2FSJ2,
					CallableResultInt.CRIJ2FSJA,
					CallableResultInt.CRIJ2FSE0,
					CallableResultInt.CRIJ2FSE1,
					CallableResultInt.CRIJ2FSE2,
					CallableResultInt.CRIJ2FSEA,
					CallableResultInt.CRIJ2FSEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLong
				extends //
					CallableResultLong.CRLJ0FSJ0,
					CallableResultLong.CRLJ1FSJ1,
					CallableResultLong.CRLJ2FSJ2,
					CallableResultLong.CRLJAFSJA,
					CallableResultLong.CRLE0FSE0,
					CallableResultLong.CRLE1FSE1,
					CallableResultLong.CRLE2FSE2,
					CallableResultLong.CRLEAFSEA,
					CallableResultLong.CRLEXFSEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongJ
				extends //
					CallableResultLong.CRLJ0FSJ0,
					CallableResultLong.CRLJ1FSJ1,
					CallableResultLong.CRLJ2FSJ2,
					CallableResultLong.CRLJAFSJA,
					CallableResultLong.CRLJ0FSE0,
					CallableResultLong.CRLJ1FSE1,
					CallableResultLong.CRLJ2FSE2,
					CallableResultLong.CRLJAFSEA,
					CallableResultLong.CRLJAFSEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongJ0
				extends //
					CallableResultLong.CRLJ0FSJ0,
					CallableResultLong.CRLJ0FSJ1,
					CallableResultLong.CRLJ0FSJ2,
					CallableResultLong.CRLJ0FSJA,
					CallableResultLong.CRLJ0FSE0,
					CallableResultLong.CRLJ0FSE1,
					CallableResultLong.CRLJ0FSE2,
					CallableResultLong.CRLJ0FSEA,
					CallableResultLong.CRLJ0FSEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongJ1
				extends //
					CallableResultLong.CRLJ1FSJ0,
					CallableResultLong.CRLJ1FSJ1,
					CallableResultLong.CRLJ1FSJ2,
					CallableResultLong.CRLJ1FSJA,
					CallableResultLong.CRLJ1FSE0,
					CallableResultLong.CRLJ1FSE1,
					CallableResultLong.CRLJ1FSE2,
					CallableResultLong.CRLJ1FSEA,
					CallableResultLong.CRLJ1FSEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNative
				extends //
					CallableResultNative.CRNE0FSE0,
					CallableResultNative.CRNE1FSE1,
					CallableResultNative.CRNE2FSE2,
					CallableResultNative.CRNEAFSEA,
					CallableResultNative.CRNEXFSEX,
					CallableResultNative.CRNJ0FSJ0,
					CallableResultNative.CRNJ1FSJ1,
					CallableResultNative.CRNJ2FSJ2,
					CallableResultNative.CRNJAFSJA {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE
				extends //
					CallableResultNative.CRNE0FSE0,
					CallableResultNative.CRNE1FSE1,
					CallableResultNative.CRNE2FSE2,
					CallableResultNative.CRNEAFSEA,
					CallableResultNative.CRNEXFSEX,
					CallableResultNative.CRNE0FSJ0,
					CallableResultNative.CRNE1FSJ1,
					CallableResultNative.CRNE2FSJ2,
					CallableResultNative.CRNEAFSJA {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE0
				extends //
					CallableResultNative.CRNE0FSJ0,
					CallableResultNative.CRNE0FSJ1,
					CallableResultNative.CRNE0FSJ2,
					CallableResultNative.CRNE0FSJA,
					CallableResultNative.CRNE0FSE0,
					CallableResultNative.CRNE0FSE1,
					CallableResultNative.CRNE0FSE2,
					CallableResultNative.CRNE0FSEA,
					CallableResultNative.CRNE0FSEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE1
				extends //
					CallableResultNative.CRNE1FSJ0,
					CallableResultNative.CRNE1FSJ1,
					CallableResultNative.CRNE1FSJ2,
					CallableResultNative.CRNE1FSJA,
					CallableResultNative.CRNE1FSE0,
					CallableResultNative.CRNE1FSE1,
					CallableResultNative.CRNE1FSE2,
					CallableResultNative.CRNE1FSEA,
					CallableResultNative.CRNE1FSEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE2
				extends //
					CallableResultNative.CRNE2FSJ0,
					CallableResultNative.CRNE2FSJ1,
					CallableResultNative.CRNE2FSJ2,
					CallableResultNative.CRNE2FSJA,
					CallableResultNative.CRNE2FSE0,
					CallableResultNative.CRNE2FSE1,
					CallableResultNative.CRNE2FSE2,
					CallableResultNative.CRNE2FSEA,
					CallableResultNative.CRNE2FSEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeEA
				extends //
					CallableResultNative.CRNEAFSJ0,
					CallableResultNative.CRNEAFSJ1,
					CallableResultNative.CRNEAFSJ2,
					CallableResultNative.CRNEAFSJA,
					CallableResultNative.CRNEAFSE0,
					CallableResultNative.CRNEAFSE1,
					CallableResultNative.CRNEAFSE2,
					CallableResultNative.CRNEAFSEA,
					CallableResultNative.CRNEAFSEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeEX
				extends //
					CallableResultNative.CRNEXFSJ0,
					CallableResultNative.CRNEXFSJ1,
					CallableResultNative.CRNEXFSJ2,
					CallableResultNative.CRNEXFSJA,
					CallableResultNative.CRNEXFSE0,
					CallableResultNative.CRNEXFSE1,
					CallableResultNative.CRNEXFSE2,
					CallableResultNative.CRNEXFSEA,
					CallableResultNative.CRNEXFSEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ
				extends //
					CallableResultNative.CRNJ0FSJ0,
					CallableResultNative.CRNJ1FSJ1,
					CallableResultNative.CRNJ2FSJ2,
					CallableResultNative.CRNJAFSJA,
					CallableResultNative.CRNJ0FSE0,
					CallableResultNative.CRNJ1FSE1,
					CallableResultNative.CRNJ2FSE2,
					CallableResultNative.CRNJAFSEA,
					CallableResultNative.CRNJAFSEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ0
				extends //
					CallableResultNative.CRNJ0FSJ0,
					CallableResultNative.CRNJ0FSJ1,
					CallableResultNative.CRNJ0FSJ2,
					CallableResultNative.CRNJ0FSJA,
					CallableResultNative.CRNJ0FSE0,
					CallableResultNative.CRNJ0FSE1,
					CallableResultNative.CRNJ0FSE2,
					CallableResultNative.CRNJ0FSEA,
					CallableResultNative.CRNJ0FSEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ1
				extends //
					CallableResultNative.CRNJ1FSJ0,
					CallableResultNative.CRNJ1FSJ1,
					CallableResultNative.CRNJ1FSJ2,
					CallableResultNative.CRNJ1FSJA,
					CallableResultNative.CRNJ1FSE0,
					CallableResultNative.CRNJ1FSE1,
					CallableResultNative.CRNJ1FSE2,
					CallableResultNative.CRNJ1FSEA,
					CallableResultNative.CRNJ1FSEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ2
				extends //
					CallableResultNative.CRNJ2FSJ0,
					CallableResultNative.CRNJ2FSJ1,
					CallableResultNative.CRNJ2FSJ2,
					CallableResultNative.CRNJ2FSJA,
					CallableResultNative.CRNJ2FSE0,
					CallableResultNative.CRNJ2FSE1,
					CallableResultNative.CRNJ2FSE2,
					CallableResultNative.CRNJ2FSEA,
					CallableResultNative.CRNJ2FSEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJA
				extends //
					CallableResultNative.CRNJAFSJ0,
					CallableResultNative.CRNJAFSJ1,
					CallableResultNative.CRNJAFSJ2,
					CallableResultNative.CRNJAFSJA,
					CallableResultNative.CRNJAFSE0,
					CallableResultNative.CRNJAFSE1,
					CallableResultNative.CRNJAFSE2,
					CallableResultNative.CRNJAFSEA,
					CallableResultNative.CRNJAFSEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore
				extends //
					CallableResultString.CRSE0FSJ0,
					CallableResultString.CRSE1FSJ1,
					CallableResultString.CRSE2FSJ2,
					CallableResultString.CRSEAFSJA,
					CallableResultStore.CREE0FSE0,
					CallableResultStore.CREE1FSE1,
					CallableResultStore.CREE2FSE2,
					CallableResultStore.CREEXFSEA,
					CallableResultStore.CREEXFSEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore0
				extends //
					CallableResultString.CRSE0FSJ0,
					CallableResultString.CRSE0FSJ1,
					CallableResultString.CRSE0FSJ2,
					CallableResultString.CRSE0FSJA,
					CallableResultStore.CREE0FSE0,
					CallableResultStore.CREE0FSE1,
					CallableResultStore.CREE0FSE2,
					CallableResultStore.CREE0FSEA,
					CallableResultStore.CREE0FSEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore1
				extends //
					CallableResultString.CRSE1FSJ0,
					CallableResultString.CRSE1FSJ1,
					CallableResultString.CRSE1FSJ2,
					CallableResultString.CRSE1FSJA,
					CallableResultStore.CREE1FSE0,
					CallableResultStore.CREE1FSE1,
					CallableResultStore.CREE1FSE2,
					CallableResultStore.CREE1FSEA,
					CallableResultStore.CREE1FSEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore2
				extends //
					CallableResultString.CRSE2FSJ0,
					CallableResultString.CRSE2FSJ1,
					CallableResultString.CRSE2FSJ2,
					CallableResultString.CRSE2FSJA,
					CallableResultStore.CREE2FSE0,
					CallableResultStore.CREE2FSE1,
					CallableResultStore.CREE2FSE2,
					CallableResultStore.CREE2FSEA,
					CallableResultStore.CREE2FSEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStoreX
				extends //
					CallableResultString.CRSEXFSJ0,
					CallableResultString.CRSEXFSJ1,
					CallableResultString.CRSEXFSJ2,
					CallableResultString.CRSEXFSJA,
					CallableResultStore.CREEXFSE0,
					CallableResultStore.CREEXFSE1,
					CallableResultStore.CREEXFSE2,
					CallableResultStore.CREEXFSEA,
					CallableResultStore.CREEXFSEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringE0
				extends //
					CallableResultString.CRSE0FSJ0,
					CallableResultString.CRSE1FSJ1,
					CallableResultString.CRSE2FSJ2,
					CallableResultString.CRSEAFSJA,
					CallableResultString.CRSE0FSE1,
					CallableResultString.CRSE0FSE2,
					CallableResultString.CRSE0FSEA,
					CallableResultString.CRSE0FSEX {

			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringE1
				extends //
					CallableResultString.CRSE1FSJ0,
					CallableResultString.CRSE1FSJ1,
					CallableResultString.CRSE1FSJ2,
					CallableResultString.CRSE1FSJA,
					CallableResultString.CRSE1FSE0,
					CallableResultString.CRSE1FSE2,
					CallableResultString.CRSE1FSEA,
					CallableResultString.CRSE1FSEX {

			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringE2
				extends //
					CallableResultString.CRSE2FSJ0,
					CallableResultString.CRSE2FSJ1,
					CallableResultString.CRSE2FSJ2,
					CallableResultString.CRSE2FSJA,
					CallableResultString.CRSE2FSE0,
					CallableResultString.CRSE2FSE1,
					CallableResultString.CRSE2FSEA,
					CallableResultString.CRSE2FSEX {

			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringEX
				extends //
					CallableResultString.CRSEXFSJ0,
					CallableResultString.CRSEXFSJ1,
					CallableResultString.CRSEXFSJ2,
					CallableResultString.CRSEXFSJA,
					CallableResultString.CRSEXFSE0,
					CallableResultString.CRSEXFSE1,
					CallableResultString.CRSEXFSE2,
					CallableResultString.CRSEXFSEA {

			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringJ
				extends //
					CallableResultString.CRSJ0FSE0,
					CallableResultString.CRSJ1FSE1,
					CallableResultString.CRSJ2FSE2,
					CallableResultString.CRSJAFSEA,
					CallableResultString.CRSJAFSEX {

			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringJ0
				extends //
					CallableResultString.CRSJ0FSJ1,
					CallableResultString.CRSJ0FSJ2,
					CallableResultString.CRSJ0FSJA,
					CallableResultString.CRSJ0FSE0,
					CallableResultString.CRSJ0FSE1,
					CallableResultString.CRSJ0FSE2,
					CallableResultString.CRSJ0FSEA,
					CallableResultString.CRSJ0FSEX {

			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringJ1
				extends //
					CallableResultString.CRSJ1FSJ0,
					CallableResultString.CRSJ1FSJ2,
					CallableResultString.CRSJ1FSJA,
					CallableResultString.CRSJ1FSE0,
					CallableResultString.CRSJ1FSE1,
					CallableResultString.CRSJ1FSE2,
					CallableResultString.CRSJ1FSEA,
					CallableResultString.CRSJ1FSEX {

			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringJ2
				extends //
					CallableResultString.CRSJ2FSJ0,
					CallableResultString.CRSJ2FSJ1,
					CallableResultString.CRSJ2FSJA,
					CallableResultString.CRSJ2FSE0,
					CallableResultString.CRSJ2FSE1,
					CallableResultString.CRSJ2FSE2,
					CallableResultString.CRSJ2FSEA,
					CallableResultString.CRSJ2FSEX {

			//
		}

		private ForString() {
			
			// prevent
		}
	}

	/** @author myx */
	@ReflectionDisable
	public static class ForVoid {

		/** @author myx */
		@ReflectionDisable
		public static interface UseInt
				extends //
					CallableResultInt.CRIJ0FVJ0,
					CallableResultInt.CRIJ1FVJ1,
					CallableResultInt.CRIJ2FVJ2,
					CallableResultInt.CRIJAFVJA,
					CallableResultInt.CRIE0FVE0,
					CallableResultInt.CRIE1FVE1,
					CallableResultInt.CRIE2FVE2,
					CallableResultInt.CRIEAFVEA,
					CallableResultInt.CRIEXFVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ
				extends //
					CallableResultInt.CRIJ0FVJ0,
					CallableResultInt.CRIJ1FVJ1,
					CallableResultInt.CRIJ2FVJ2,
					CallableResultInt.CRIJAFVJA,
					CallableResultInt.CRIJ0FVE0,
					CallableResultInt.CRIJ1FVE1,
					CallableResultInt.CRIJ2FVE2,
					CallableResultInt.CRIJAFVEA,
					CallableResultInt.CRIJAFVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ0
				extends //
					CallableResultInt.CRIJ0FVJ0,
					CallableResultInt.CRIJ0FVJ1,
					CallableResultInt.CRIJ0FVJ2,
					CallableResultInt.CRIJ0FVJA,
					CallableResultInt.CRIJ0FVE0,
					CallableResultInt.CRIJ0FVE1,
					CallableResultInt.CRIJ0FVE2,
					CallableResultInt.CRIJ0FVEA,
					CallableResultInt.CRIJ0FVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ1
				extends //
					CallableResultInt.CRIJ1FVJ0,
					CallableResultInt.CRIJ1FVJ1,
					CallableResultInt.CRIJ1FVJ2,
					CallableResultInt.CRIJ1FVJA,
					CallableResultInt.CRIJ1FVE0,
					CallableResultInt.CRIJ1FVE1,
					CallableResultInt.CRIJ1FVE2,
					CallableResultInt.CRIJ1FVEA,
					CallableResultInt.CRIJ1FVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseIntJ2
				extends //
					CallableResultInt.CRIJ2FVJ0,
					CallableResultInt.CRIJ2FVJ1,
					CallableResultInt.CRIJ2FVJ2,
					CallableResultInt.CRIJ2FVJA,
					CallableResultInt.CRIJ2FVE0,
					CallableResultInt.CRIJ2FVE1,
					CallableResultInt.CRIJ2FVE2,
					CallableResultInt.CRIJ2FVEA,
					CallableResultInt.CRIJ2FVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLong
				extends //
					CallableResultLong.CRLJ0FVJ0,
					CallableResultLong.CRLJ1FVJ1,
					CallableResultLong.CRLJ2FVJ2,
					CallableResultLong.CRLJAFVJA,
					CallableResultLong.CRLE0FVE0,
					CallableResultLong.CRLE1FVE1,
					CallableResultLong.CRLE2FVE2,
					CallableResultLong.CRLEAFVEA,
					CallableResultLong.CRLEXFVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongJ
				extends //
					CallableResultLong.CRLJ0FVJ0,
					CallableResultLong.CRLJ1FVJ1,
					CallableResultLong.CRLJ2FVJ2,
					CallableResultLong.CRLJAFVJA,
					CallableResultLong.CRLJ0FVE0,
					CallableResultLong.CRLJ1FVE1,
					CallableResultLong.CRLJ2FVE2,
					CallableResultLong.CRLJAFVEA,
					CallableResultLong.CRLJAFVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongJ0
				extends //
					CallableResultLong.CRLJ0FVJ0,
					CallableResultLong.CRLJ0FVJ1,
					CallableResultLong.CRLJ0FVJ2,
					CallableResultLong.CRLJ0FVJA,
					CallableResultLong.CRLJ0FVE0,
					CallableResultLong.CRLJ0FVE1,
					CallableResultLong.CRLJ0FVE2,
					CallableResultLong.CRLJ0FVEA,
					CallableResultLong.CRLJ0FVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseLongJ1
				extends //
					CallableResultLong.CRLJ1FVJ0,
					CallableResultLong.CRLJ1FVJ1,
					CallableResultLong.CRLJ1FVJ2,
					CallableResultLong.CRLJ1FVJA,
					CallableResultLong.CRLJ1FVE0,
					CallableResultLong.CRLJ1FVE1,
					CallableResultLong.CRLJ1FVE2,
					CallableResultLong.CRLJ1FVEA,
					CallableResultLong.CRLJ1FVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNative
				extends //
					CallableResultNative.CRNJ0FVJ0,
					CallableResultNative.CRNJ1FVJ1,
					CallableResultNative.CRNJ2FVJ2,
					CallableResultNative.CRNJAFVJA,
					CallableResultNative.CRNE0FVE0,
					CallableResultNative.CRNE1FVE1,
					CallableResultNative.CRNE2FVE2,
					CallableResultNative.CRNEAFVEA,
					CallableResultNative.CRNEXFVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE
				extends //
					CallableResultNative.CRNE0FVJ0,
					CallableResultNative.CRNE1FVJ1,
					CallableResultNative.CRNE2FVJ2,
					CallableResultNative.CRNEAFVJA,
					CallableResultNative.CRNE0FVE0,
					CallableResultNative.CRNE1FVE1,
					CallableResultNative.CRNE2FVE2,
					CallableResultNative.CRNEAFVEA,
					CallableResultNative.CRNEXFVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE0
				extends //
					CallableResultNative.CRNE0FVJ0,
					CallableResultNative.CRNE0FVJ1,
					CallableResultNative.CRNE0FVJ2,
					CallableResultNative.CRNE0FVJA,
					CallableResultNative.CRNE0FVE0,
					CallableResultNative.CRNE0FVE1,
					CallableResultNative.CRNE0FVE2,
					CallableResultNative.CRNE0FVEA,
					CallableResultNative.CRNE0FVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE1
				extends //
					CallableResultNative.CRNE1FVJ0,
					CallableResultNative.CRNE1FVJ1,
					CallableResultNative.CRNE1FVJ2,
					CallableResultNative.CRNE1FVJA,
					CallableResultNative.CRNE1FVE0,
					CallableResultNative.CRNE1FVE1,
					CallableResultNative.CRNE1FVE2,
					CallableResultNative.CRNE1FVEA,
					CallableResultNative.CRNE1FVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeE2
				extends //
					CallableResultNative.CRNE2FVJ0,
					CallableResultNative.CRNE2FVJ1,
					CallableResultNative.CRNE2FVJ2,
					CallableResultNative.CRNE2FVJA,
					CallableResultNative.CRNE2FVE0,
					CallableResultNative.CRNE2FVE1,
					CallableResultNative.CRNE2FVE2,
					CallableResultNative.CRNE2FVEA,
					CallableResultNative.CRNE2FVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeEA
				extends //
					CallableResultNative.CRNEAFVJ0,
					CallableResultNative.CRNEAFVJ1,
					CallableResultNative.CRNEAFVJ2,
					CallableResultNative.CRNEAFVJA,
					CallableResultNative.CRNEAFVE0,
					CallableResultNative.CRNEAFVE1,
					CallableResultNative.CRNEAFVE2,
					CallableResultNative.CRNEAFVEA,
					CallableResultNative.CRNEAFVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeEX
				extends //
					CallableResultNative.CRNEXFVJ0,
					CallableResultNative.CRNEXFVJ1,
					CallableResultNative.CRNEXFVJ2,
					CallableResultNative.CRNEXFVJA,
					CallableResultNative.CRNEXFVE0,
					CallableResultNative.CRNEXFVE1,
					CallableResultNative.CRNEXFVE2,
					CallableResultNative.CRNEXFVEA,
					CallableResultNative.CRNEXFVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ
				extends //
					CallableResultNative.CRNJ0FVJ0,
					CallableResultNative.CRNJ1FVJ1,
					CallableResultNative.CRNJ2FVJ2,
					CallableResultNative.CRNJAFVJA,
					CallableResultNative.CRNJ0FVE0,
					CallableResultNative.CRNJ1FVE1,
					CallableResultNative.CRNJ2FVE2,
					CallableResultNative.CRNJAFVEA,
					CallableResultNative.CRNJAFVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ0
				extends //
					CallableResultNative.CRNJ0FVJ0,
					CallableResultNative.CRNJ0FVJ1,
					CallableResultNative.CRNJ0FVJ2,
					CallableResultNative.CRNJ0FVJA,
					CallableResultNative.CRNJ0FVE0,
					CallableResultNative.CRNJ0FVE1,
					CallableResultNative.CRNJ0FVE2,
					CallableResultNative.CRNJ0FVEA,
					CallableResultNative.CRNJ0FVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ1
				extends //
					CallableResultNative.CRNJ1FVJ0,
					CallableResultNative.CRNJ1FVJ1,
					CallableResultNative.CRNJ1FVJ2,
					CallableResultNative.CRNJ1FVJA,
					CallableResultNative.CRNJ1FVE0,
					CallableResultNative.CRNJ1FVE1,
					CallableResultNative.CRNJ1FVE2,
					CallableResultNative.CRNJ1FVEA,
					CallableResultNative.CRNJ1FVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJ2
				extends //
					CallableResultNative.CRNJ2FVJ0,
					CallableResultNative.CRNJ2FVJ1,
					CallableResultNative.CRNJ2FVJ2,
					CallableResultNative.CRNJ2FVJA,
					CallableResultNative.CRNJ2FVE0,
					CallableResultNative.CRNJ2FVE1,
					CallableResultNative.CRNJ2FVE2,
					CallableResultNative.CRNJ2FVEA,
					CallableResultNative.CRNJ2FVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseNativeJA
				extends //
					CallableResultNative.CRNJAFVJ0,
					CallableResultNative.CRNJAFVJ1,
					CallableResultNative.CRNJAFVJ2,
					CallableResultNative.CRNJAFVJA,
					CallableResultNative.CRNJAFVE0,
					CallableResultNative.CRNJAFVE1,
					CallableResultNative.CRNJAFVE2,
					CallableResultNative.CRNJAFVEA,
					CallableResultNative.CRNJAFVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore
				extends //
					CallableResultStore.CREE0FVJ0,
					CallableResultStore.CREE1FVJ1,
					CallableResultStore.CREE2FVJ2,
					CallableResultStore.CREEXFVJA,
					CallableResultStore.CREE0FVE0,
					CallableResultStore.CREE1FVE1,
					CallableResultStore.CREE2FVE2,
					CallableResultStore.CREEXFVEA,
					CallableResultStore.CREEXFVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore0
				extends //
					CallableResultStore.CREE0FVJ0,
					CallableResultStore.CREE0FVJ1,
					CallableResultStore.CREE0FVJ2,
					CallableResultStore.CREE0FVJA,
					CallableResultStore.CREE0FVE0,
					CallableResultStore.CREE0FVE1,
					CallableResultStore.CREE0FVE2,
					CallableResultStore.CREE0FVEA,
					CallableResultStore.CREE0FVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore1
				extends //
					CallableResultStore.CREE1FVJ0,
					CallableResultStore.CREE1FVJ1,
					CallableResultStore.CREE1FVJ2,
					CallableResultStore.CREE1FVJA,
					CallableResultStore.CREE1FVE0,
					CallableResultStore.CREE1FVE1,
					CallableResultStore.CREE1FVE2,
					CallableResultStore.CREE1FVEA,
					CallableResultStore.CREE1FVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStore2
				extends //
					CallableResultStore.CREE2FVJ0,
					CallableResultStore.CREE2FVJ1,
					CallableResultStore.CREE2FVJ2,
					CallableResultStore.CREE2FVJA,
					CallableResultStore.CREE2FVE0,
					CallableResultStore.CREE2FVE1,
					CallableResultStore.CREE2FVE2,
					CallableResultStore.CREE2FVEA,
					CallableResultStore.CREE2FVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStoreX
				extends //
					CallableResultStore.CREEXFVJ0,
					CallableResultStore.CREEXFVJ1,
					CallableResultStore.CREEXFVJ2,
					CallableResultStore.CREEXFVJA,
					CallableResultStore.CREEXFVE0,
					CallableResultStore.CREEXFVE1,
					CallableResultStore.CREEXFVE2,
					CallableResultStore.CREEXFVEX,
					CallableResultStore.CREEXFVEA {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseString
				extends //
					CallableResultString.CRSJ0FVJ0,
					CallableResultString.CRSJ1FVJ1,
					CallableResultString.CRSJ2FVJ2,
					CallableResultString.CRSJAFVJA,
					CallableResultString.CRSE0FVE0,
					CallableResultString.CRSE1FVE1,
					CallableResultString.CRSE2FVE2,
					CallableResultString.CRSEAFVEA,
					CallableResultString.CRSEXFVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringE
				extends //
					CallableResultString.CRSE0FVJ0,
					CallableResultString.CRSE1FVJ1,
					CallableResultString.CRSE2FVJ2,
					CallableResultString.CRSEAFVJA,
					CallableResultString.CRSE0FVE0,
					CallableResultString.CRSE1FVE1,
					CallableResultString.CRSE2FVE2,
					CallableResultString.CRSEAFVEA,
					CallableResultString.CRSEXFVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringE0
				extends //
					CallableResultString.CRSE0FVJ0,
					CallableResultString.CRSE0FVJ1,
					CallableResultString.CRSE0FVJ2,
					CallableResultString.CRSE0FVJA,
					CallableResultString.CRSE0FVE0,
					CallableResultString.CRSE0FVE1,
					CallableResultString.CRSE0FVE2,
					CallableResultString.CRSE0FVEA,
					CallableResultString.CRSE0FVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringE1
				extends //
					CallableResultString.CRSE1FVJ0,
					CallableResultString.CRSE1FVJ1,
					CallableResultString.CRSE1FVJ2,
					CallableResultString.CRSE1FVJA,
					CallableResultString.CRSE1FVE0,
					CallableResultString.CRSE1FVE1,
					CallableResultString.CRSE1FVE2,
					CallableResultString.CRSE1FVEA,
					CallableResultString.CRSE1FVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringJ
				extends //
					CallableResultString.CRSJ0FVJ0,
					CallableResultString.CRSJ1FVJ1,
					CallableResultString.CRSJ2FVJ2,
					CallableResultString.CRSJAFVJA,
					CallableResultString.CRSJ0FVE0,
					CallableResultString.CRSJ1FVE1,
					CallableResultString.CRSJ2FVE2,
					CallableResultString.CRSJAFVEA,
					CallableResultString.CRSJAFVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringJ0
				extends //
					CallableResultString.CRSJ0FVJ0,
					CallableResultString.CRSJ0FVJ1,
					CallableResultString.CRSJ0FVJ2,
					CallableResultString.CRSJ0FVJA,
					CallableResultString.CRSJ0FVE0,
					CallableResultString.CRSJ0FVE1,
					CallableResultString.CRSJ0FVE2,
					CallableResultString.CRSJ0FVEA,
					CallableResultString.CRSJ0FVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseStringJ1
				extends //
					CallableResultString.CRSJ1FVJ0,
					CallableResultString.CRSJ1FVJ1,
					CallableResultString.CRSJ1FVJ2,
					CallableResultString.CRSJ1FVJA,
					CallableResultString.CRSJ1FVE0,
					CallableResultString.CRSJ1FVE1,
					CallableResultString.CRSJ1FVE2,
					CallableResultString.CRSJ1FVEA,
					CallableResultString.CRSJ1FVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseVoidE
				extends //
					CallableResultVoid.CRVE0FVJ0,
					CallableResultVoid.CRVE1FVJ1,
					CallableResultVoid.CRVE2FVJ2,
					CallableResultVoid.CRVEAFVJA {

			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseVoidE0
				extends //
					CallableResultVoid.CRVE0FVJ0,
					CallableResultVoid.CRVE0FVJ1,
					CallableResultVoid.CRVE0FVJ2,
					CallableResultVoid.CRVE0FVJA,
					CallableResultVoid.CRVE0FVE1,
					CallableResultVoid.CRVE0FVE2,
					CallableResultVoid.CRVE0FVEA,
					CallableResultVoid.CRVE0FVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseVoidE1
				extends //
					CallableResultVoid.CRVE1FVJ0,
					CallableResultVoid.CRVE1FVJ1,
					CallableResultVoid.CRVE1FVJ2,
					CallableResultVoid.CRVE1FVJA,
					CallableResultVoid.CRVE1FVE0,
					CallableResultVoid.CRVE1FVE2,
					CallableResultVoid.CRVE1FVEA,
					CallableResultVoid.CRVE1FVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseVoidE2
				extends //
					CallableResultVoid.CRVE2FVJ0,
					CallableResultVoid.CRVE2FVJ1,
					CallableResultVoid.CRVE2FVJ2,
					CallableResultVoid.CRVE2FVJA,
					CallableResultVoid.CRVE2FVE0,
					CallableResultVoid.CRVE2FVE1,
					CallableResultVoid.CRVE2FVEA,
					CallableResultVoid.CRVE2FVEX {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseVoidEX
				extends //
					CallableResultVoid.CRVEXFVJ0,
					CallableResultVoid.CRVEXFVJ1,
					CallableResultVoid.CRVEXFVJ2,
					CallableResultVoid.CRVEXFVJA,
					CallableResultVoid.CRVEXFVE0,
					CallableResultVoid.CRVEXFVE1,
					CallableResultVoid.CRVEXFVE2,
					CallableResultVoid.CRVEXFVEA {
			//
		}

		/** @author myx */
		@ReflectionDisable
		public static interface UseVoidJ extends ExecCallable {

			@Override
			@ReflectionHidden
			default void callVE0(final ExecProcess ctx, final BaseObject instance) {

				this.callVJ0(instance);
			}

			@Override
			@ReflectionHidden
			default void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument) {

				this.callVJ1(instance, argument);
			}

			@Override
			@ReflectionHidden
			default void callVE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

				this.callVJ2(instance, argument1, argument2);
			}

			@Override
			@ReflectionHidden
			default void callVEA(final ExecProcess ctx, final BaseObject instance, final BaseObject... arguments) {

				this.callVJA(instance, arguments);
			}

		}

		private ForVoid() {
			
			// prevent
		}
	}

	/** @author myx */
	@ReflectionDisable
	public static interface JavaInt extends ExecCallable {

		@Override
		@ReflectionHidden
		default Class<? extends Object> execResultClassJava() {

			return Number.class;
		}
	}

	/** @author myx */
	@ReflectionDisable
	public static interface JavaLong extends ExecCallable {

		@Override
		@ReflectionHidden
		default Class<? extends Object> execResultClassJava() {

			return Number.class;
		}
	}

	/** @author myx */
	@ReflectionDisable
	public static interface JavaString extends ExecCallable {

		@Override
		@ReflectionHidden
		default Class<? extends Object> execResultClassJava() {

			return CharSequence.class;
		}
	}

	@SuppressWarnings("javadoc")
	static boolean assertTraceCall(final ExecProcess ctx, final ExecCallable callee, final BaseObject instance) {

		/** <code>
		System.err.println(">>>>>> " + callee.getClass().getSimpleName() + ": ctx: " + ctx.ri0BSB + ":" + ctx.ri0ASP + ", call0: " + callee);
		 * </code> */

		assert ctx.fldTracer == null
			? ExecProcess.fldTracerStatic == null || ExecProcess.fldTracerStatic.traceCall(ctx, callee, instance)
			: ctx.fldTracer.traceCall(ctx, callee, instance);

		return true;
	}

	@SuppressWarnings("javadoc")
	static boolean assertTraceCall(final ExecProcess ctx, final ExecCallable callee, final BaseObject instance, final BaseArray arguments) {

		/** <code>
		System.err.println(">>>>>> " + callee.getClass().getSimpleName() + ": ctx: " + ctx.ri0BSB + ":" + ctx.ri0ASP + ", callA: " + callee + ", argc: " + arguments.length());
		 * </code> */

		assert ctx.fldTracer == null
			? ExecProcess.fldTracerStatic == null || ExecProcess.fldTracerStatic.traceCall(ctx, callee, instance, arguments)
			: ctx.fldTracer.traceCall(ctx, callee, instance, arguments);

		return true;
	}

	@SuppressWarnings("javadoc")
	static boolean assertTraceCall(final ExecProcess ctx, final ExecCallable callee, final BaseObject instance, final BaseObject argument) {

		/** <code>
		System.err.println(">>>>>> " + callee.getClass().getSimpleName() + ": ctx: " + ctx.ri0BSB + ":" + ctx.ri0ASP + ", call1: " + callee);
		 * </code> */

		assert ctx.fldTracer == null
			? ExecProcess.fldTracerStatic == null || ExecProcess.fldTracerStatic.traceCall(ctx, callee, instance, argument)
			: ctx.fldTracer.traceCall(ctx, callee, instance, argument);

		return true;
	}

	@SuppressWarnings("javadoc")
	static boolean assertTraceCall(final ExecProcess ctx, final ExecCallable callee, final BaseObject instance, final BaseObject... arguments) {

		/** <code>
		System.err.println(">>>>>> " + callee.getClass().getSimpleName() + ": ctx: " + ctx.ri0BSB + ":" + ctx.ri0ASP + ", callX: " + callee + ", argc: " + arguments.length);
		 * </code> */

		assert ctx.fldTracer == null
			? ExecProcess.fldTracerStatic == null || ExecProcess.fldTracerStatic.traceCall(ctx, callee, instance, arguments)
			: ctx.fldTracer.traceCall(ctx, callee, instance, arguments);

		return true;
	}

	@SuppressWarnings("javadoc")
	static boolean assertTraceCall(final ExecProcess ctx, final ExecCallable callee, final BaseObject instance, final BaseObject argument1, final BaseObject argument2) {

		/** <code>
		System.err.println(">>>>>> " + callee.getClass().getSimpleName() + ": ctx: " + ctx.ri0BSB + ":" + ctx.ri0ASP + ", call2: " + callee);
		 * </code> */

		assert ctx.fldTracer == null
			? ExecProcess.fldTracerStatic == null || ExecProcess.fldTracerStatic.traceCall(ctx, callee, instance, argument1, argument2)
			: ctx.fldTracer.traceCall(ctx, callee, instance, argument1, argument2);

		return true;
	}

	/** @param ctx
	 * @param instance
	 * @return */
	@ReflectionHidden
	double callDE0(ExecProcess ctx, BaseObject instance);

	/** @param ctx
	 * @param instance
	 * @param argument
	 * @return */
	@ReflectionHidden
	double callDE1(ExecProcess ctx, BaseObject instance, BaseObject argument);

	/** @param ctx
	 * @param instance
	 * @param argument1
	 * @param argument2
	 * @return */
	@ReflectionHidden
	double callDE2(ExecProcess ctx, BaseObject instance, BaseObject argument1, BaseObject argument2);

	/** @param ctx
	 * @param instance
	 * @param arguments
	 * @return */
	@ReflectionHidden
	double callDEA(ExecProcess ctx, BaseObject instance, BaseObject... arguments);

	/** @param ctx
	 * @param instance
	 * @param arguments
	 * @return */
	@ReflectionHidden
	double callDEX(ExecProcess ctx, BaseObject instance, BaseArray arguments);

	/** @param instance
	 * @return */
	@ReflectionHidden
	double callDJ0(final BaseObject instance);

	/** @param instance
	 * @param argument
	 * @return */
	@ReflectionHidden
	double callDJ1(final BaseObject instance, final BaseObject argument);

	/** @param instance
	 * @param argument1
	 * @param argument2
	 * @return */
	@ReflectionHidden
	double callDJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2);

	/** @param instance
	 * @param arguments
	 * @return */
	@ReflectionHidden
	double callDJA(final BaseObject instance, final BaseObject... arguments);

	/** @param ctx
	 * @param instance
	 * @return */
	@ReflectionHidden
	int callIE0(final ExecProcess ctx, final BaseObject instance);

	/** @param ctx
	 * @param instance
	 * @param argument
	 * @return */
	@ReflectionHidden
	int callIE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument);

	/** @param ctx
	 * @param instance
	 * @param argument1
	 * @param argument2
	 * @return */
	@ReflectionHidden
	int callIE2(final ExecProcess ctx, final BaseObject instance, final BaseObject argument1, final BaseObject argument2);

	/** @param ctx
	 * @param instance
	 * @param arguments
	 * @return */
	@ReflectionHidden
	int callIEA(ExecProcess ctx, BaseObject instance, BaseObject... arguments);

	/** @param ctx
	 * @param instance
	 * @param arguments
	 * @return */
	@ReflectionHidden
	int callIEX(ExecProcess ctx, BaseObject instance, BaseArray arguments);

	/** @param instance
	 * @return */
	@ReflectionHidden
	int callIJ0(final BaseObject instance);

	/** @param instance
	 * @param argument
	 * @return */
	@ReflectionHidden
	int callIJ1(final BaseObject instance, final BaseObject argument);

	/** @param instance
	 * @param argument1
	 * @param argument2
	 * @return */
	@ReflectionHidden
	int callIJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2);

	/** @param instance
	 * @param arguments
	 * @return */
	@ReflectionHidden
	int callIJA(final BaseObject instance, final BaseObject... arguments);

	/** @param ctx
	 * @param instance
	 * @return */
	@ReflectionHidden
	long callLE0(ExecProcess ctx, BaseObject instance);

	/** @param ctx
	 * @param instance
	 * @param argument
	 * @return */
	@ReflectionHidden
	long callLE1(ExecProcess ctx, BaseObject instance, BaseObject argument);

	/** @param ctx
	 * @param instance
	 * @param argument1
	 * @param argument2
	 * @return */
	@ReflectionHidden
	long callLE2(ExecProcess ctx, BaseObject instance, BaseObject argument1, BaseObject argument2);

	/** @param ctx
	 * @param instance
	 * @param arguments
	 * @return */
	@ReflectionHidden
	long callLEA(ExecProcess ctx, BaseObject instance, BaseObject... arguments);

	/** @param ctx
	 * @param instance
	 * @param arguments
	 * @return */
	@ReflectionHidden
	long callLEX(ExecProcess ctx, BaseObject instance, BaseArray arguments);

	/** @param instance
	 * @return */
	@ReflectionHidden
	long callLJ0(final BaseObject instance);

	/** @param instance
	 * @param argument
	 * @return */
	@ReflectionHidden
	long callLJ1(final BaseObject instance, final BaseObject argument);

	/** @param instance
	 * @param argument1
	 * @param argument2
	 * @return */
	@ReflectionHidden
	long callLJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2);

	/** @param instance
	 * @param arguments
	 * @return */
	@ReflectionHidden
	long callLJA(final BaseObject instance, final BaseObject... arguments);

	/** @param ctx
	 * @param instance
	 * @return */

	@ReflectionHidden
	BaseObject callNE0(ExecProcess ctx, BaseObject instance);

	/** @param ctx
	 * @param instance
	 * @param argument
	 * @return */

	@ReflectionHidden
	BaseObject callNE1(ExecProcess ctx, BaseObject instance, BaseObject argument);

	/** @param ctx
	 * @param instance
	 * @param argument1
	 * @param argument2
	 * @return */

	@ReflectionHidden
	BaseObject callNE2(ExecProcess ctx, BaseObject instance, BaseObject argument1, BaseObject argument2);

	/** @param ctx
	 * @param instance
	 * @param arguments
	 * @return */

	@ReflectionHidden
	BaseObject callNEA(ExecProcess ctx, BaseObject instance, BaseObject... arguments);

	/** @param ctx
	 * @param instance
	 * @param arguments
	 * @return */

	@ReflectionHidden
	BaseObject callNEX(ExecProcess ctx, BaseObject instance, BaseArray arguments);

	/** @param instance
	 * @return */

	@ReflectionHidden
	BaseObject callNJ0(final BaseObject instance);

	/** @param instance
	 * @param argument
	 * @return */

	@ReflectionHidden
	BaseObject callNJ1(final BaseObject instance, final BaseObject argument);

	/** @param instance
	 * @param argument1
	 * @param argument2
	 * @return */

	@ReflectionHidden
	BaseObject callNJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2);

	/** @param instance
	 * @param arguments
	 * @return */

	@ReflectionHidden
	BaseObject callNJA(final BaseObject instance, final BaseObject... arguments);

	/** @param ctx
	 * @param instance
	 * @return */
	@ReflectionHidden
	String callSE0(final ExecProcess ctx, final BaseObject instance);

	/** @param ctx
	 * @param instance
	 * @param argument
	 * @return */
	@ReflectionHidden
	String callSE1(ExecProcess ctx, BaseObject instance, BaseObject argument);

	/** @param ctx
	 * @param instance
	 * @param argument1
	 * @param argument2
	 * @return */
	@ReflectionHidden
	String callSE2(ExecProcess ctx, BaseObject instance, BaseObject argument1, BaseObject argument2);

	/** @param ctx
	 * @param instance
	 * @param arguments
	 * @return */
	@ReflectionHidden
	String callSEA(ExecProcess ctx, BaseObject instance, BaseObject... arguments);

	/** @param ctx
	 * @param instance
	 * @param arguments
	 * @return */
	@ReflectionHidden
	String callSEX(ExecProcess ctx, BaseObject instance, BaseArray arguments);

	/** @param ctx
	 * @param instance
	 * @return */
	@ReflectionHidden
	String callSJ0(final BaseObject instance);

	/** @param instance
	 * @param argument
	 * @return */

	@ReflectionHidden
	String callSJ1(final BaseObject instance, final BaseObject argument);

	/** @param instance
	 * @param argument1
	 * @param argument2
	 * @return */
	@ReflectionHidden
	String callSJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2);

	/** @param instance
	 * @param arguments
	 * @return */
	@ReflectionHidden
	String callSJA(final BaseObject instance, final BaseObject... arguments);

	/** @param ctx
	 * @param instance
	 */
	@ReflectionHidden
	void callVE0(final ExecProcess ctx, final BaseObject instance);

	/** @param ctx
	 * @param instance
	 * @param argument
	 */
	@ReflectionHidden
	void callVE1(final ExecProcess ctx, final BaseObject instance, final BaseObject argument);

	/** @param ctx
	 * @param instance
	 * @param argument1
	 * @param argument2
	 */
	@ReflectionHidden
	void callVE2(ExecProcess ctx, BaseObject instance, BaseObject argument1, BaseObject argument2);

	/** @param ctx
	 * @param instance
	 * @param arguments
	 */
	@ReflectionHidden
	void callVEA(ExecProcess ctx, BaseObject instance, BaseObject... arguments);

	/** @param ctx
	 * @param instance
	 * @param arguments
	 */
	@ReflectionHidden
	void callVEX(ExecProcess ctx, BaseObject instance, BaseArray arguments);

	/** @param instance
	 */
	@ReflectionHidden
	void callVJ0(final BaseObject instance);

	/** @param instance
	 * @param argument
	 */
	@ReflectionHidden
	void callVJ1(final BaseObject instance, final BaseObject argument);

	/** @param instance
	 * @param argument1
	 * @param argument2
	 */
	@ReflectionHidden
	void callVJ2(final BaseObject instance, final BaseObject argument1, final BaseObject argument2);

	/** @param instance
	 * @param arguments
	 */
	@ReflectionHidden
	void callVJA(final BaseObject instance, final BaseObject... arguments);

	/** @return int */
	@ReflectionHidden
	default int execArgumentsAcceptable() {

		return Integer.MAX_VALUE;
	}

	/** @return int */
	@ReflectionHidden
	default int execArgumentsDeclared() {

		return 0;
	}

	/** @return int */
	@ReflectionHidden
	default int execArgumentsMinimal() {

		return 0;
	}

	/** Return REPEAT when you just setup context for stepper execution
	 *
	 * @param ctx
	 * @param instance
	 * @param store
	 * @param inline
	 * @return */
	ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, boolean inline);

	/** Return REPEAT when you just setup context for stepper execution
	 *
	 * @param ctx
	 * @param instance
	 * @param store
	 * @param inline
	 * @param arguments
	 * @return */
	ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, boolean inline, final BaseArray arguments);

	/** Return REPEAT when you just setup context for stepper execution
	 *
	 * @param ctx
	 * @param instance
	 * @param store
	 * @param inline
	 *            TODO
	 * @param argument
	 * @return */
	ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, boolean inline, final BaseObject argument);

	/** Return REPEAT when you just setup context for stepper execution
	 *
	 * @param ctx
	 * @param instance
	 * @param store
	 * @param inline
	 *            TODO
	 * @param argument1
	 * @param argument2
	 * @return */
	ExecStateCode
			execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, boolean inline, final BaseObject argument1, final BaseObject argument2);

	/** A possibly empty List containing the identifier Strings of a Function’s FormalParameterList.
	 * Of the standard built-in ECMAScript objects, only Function objects implement
	 * [[FormalParameterList]].
	 *
	 * @return List of Strings */
	@ReflectionHidden
	default String[] execFormalParameters() {

		return null;
	}

	/** @return boolean */
	@ReflectionHidden
	default boolean execHasNamedArguments() {

		return false;
	}

	/** @return boolean */
	@ReflectionHidden
	default boolean execIsConstant() {

		return false;
	}

	/** If not sure, return Object.class
	 *
	 * @return */
	@ReflectionHidden
	default Class<? extends Object> execResultClassJava() {

		return Object.class;
	}

	/** A scope chain that defines the environment in which a Function object is executed.
	 *
	 * FROM ECMAScript specification:
	 *
	 * A lexical environment that defines the environment in which a Function object is executed. Of
	 * the standard built-in ECMAScript objects, only Function objects implement [[Scope]].
	 *
	 * @return Lexical Environment. Options are:
	 *         <ul>
	 *         <li>null value will perform default setup (which is to seal current value of r5GV and
	 *         use it as both r6FV and r5GV values),</li>
	 *         <li>ExecProcess.GLOBAL value will keep all registers intact,</li>
	 *         <li>any other value will use given object as both r6FV and r5GV values.</li>
	 *         </ul>
	 */
	@ReflectionHidden
	default BaseObject execScope() {

		return ExecProcess.GLOBAL;
	}

}
