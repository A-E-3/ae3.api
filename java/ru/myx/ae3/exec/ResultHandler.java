package ru.myx.ae3.exec;

import com.sun.istack.internal.NotNull;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.base.ToPrimitiveHint;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/**
 *
 * @author myx
 *
 */
@ReflectionDisable
public interface ResultHandler {
	
	
	/**
	 *
	 * @author myx
	 *
	 */
	enum DirectTransport {
		/**
		 * Real 0RB register
		 */
		RB {
			
			
			@Override
			public DirectTransport transportForBooleanCheck() {
				
				
				return RB;
			}

			@Override
			public ResultHandlerDirect handlerForStoreNext() {
				
				
				return EFA_BNN_NXT.INSTANCE;
			}
		},
		/**
		 * Real 0RB register
		 */
		RL {
			
			
			@Override
			public DirectTransport transportForBooleanCheck() {
				
				
				return RL;
			}

			@Override
			public ResultHandlerDirect handlerForStoreNext() {
				
				
				return EFA_LNN_NXT.INSTANCE;
			}
		},
		/**
		 * Real 0RB register
		 */
		RD {
			
			
			@Override
			public DirectTransport transportForBooleanCheck() {
				
				
				return RD;
			}

			@Override
			public ResultHandlerDirect handlerForStoreNext() {
				
				
				return EFA_DNN_NXT.INSTANCE;
			}
		},
		/**
		 * Real 0RB register
		 */
		RS {
			
			
			@Override
			public DirectTransport transportForBooleanCheck() {
				
				
				return RS;
			}
			
			@Override
			public ResultHandlerDirect handlerForStoreNext() {
				
				
				return EFA_CNN_NXT.INSTANCE;
			}
		},
		/**
		 * Void/Virtual - UNDEFINED
		 */
		RV {
			
			
			@Override
			public DirectTransport transportForBooleanCheck() {
				
				
				return RB;
			}
			
			@Override
			public ResultHandlerDirect handlerForStoreNext() {
				
				
				return EFU_BNN_NXT.INSTANCE;
			}
		},
		/**
		 * Virtual - Call Handler
		 */
		CH {
			
			
			@Override
			public DirectTransport transportForBooleanCheck() {
				
				
				return CH;
			}

			@Override
			public ResultHandlerDirect handlerForStoreNext() {
				
				
				return EFC_PNN_NXT.INSTANCE;
			}
		},;
		
		public abstract ResultHandlerDirect handlerForStoreNext();

		public abstract DirectTransport transportForBooleanCheck();
	}
	
	/**
	 *
	 * @author myx
	 *
	 */
	@ReflectionDisable
	interface UseRB extends ResultHandler {
		
		
		@Override
		@Deprecated
		default DirectTransport execDirectTransportType() {
			
			
			return ResultHandler.DirectTransport.RB;
		}

		@Override
		@Deprecated
		default ResultHandlerDirect execToCallDirectHandler(final ExecProcess ctx) {
			
			
			return EFA_BNN_NXT.INSTANCE;
		}

		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default BaseObject execReadNative(@NotNull final ExecProcess ctx) {
			
			
			return ctx.ra0RB;
		}
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default long execReadLong(@NotNull final ExecProcess ctx) {
			
			
			return ctx.ra0RB.baseToJavaLong();
		}
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default int execReadInt(@NotNull final ExecProcess ctx) {
			
			
			return ctx.ra0RB.baseToJavaInteger();
		}
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default String execReadString(@NotNull final ExecProcess ctx) {
			
			
			return ctx.ra0RB.baseToJavaString();
		}
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default double execReadDouble(@NotNull final ExecProcess ctx) {
			
			
			return ctx.ra0RB.baseToPrimitive(ToPrimitiveHint.NUMBER).doubleValue();
		}
	}
	
	/**
	 *
	 * @author myx
	 *
	 */
	@ReflectionDisable
	interface UseRL extends ResultHandler {
		
		
		@Override
		@Deprecated
		default DirectTransport execDirectTransportType() {
			
			
			return ResultHandler.DirectTransport.RL;
		}
		
		@Override
		@Deprecated
		default ResultHandlerDirect execToCallDirectHandler(final ExecProcess ctx) {
			
			
			return EFA_LNN_NXT.INSTANCE;
		}

		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default BaseObject execReadNative(@NotNull final ExecProcess ctx) {
			
			
			return Base.forLong(ctx.ra1RL);
		}
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default long execReadLong(@NotNull final ExecProcess ctx) {
			
			
			return ctx.ra1RL;
		}
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default int execReadInt(@NotNull final ExecProcess ctx) {
			
			
			return (int) ctx.ra1RL;
		}
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default String execReadString(@NotNull final ExecProcess ctx) {
			
			
			return Base.toString(ctx.ra1RL);
		}
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default double execReadDouble(@NotNull final ExecProcess ctx) {
			
			
			return ctx.ra1RL;
		}
	}
	
	/**
	 *
	 * @author myx
	 *
	 */
	@ReflectionDisable
	interface UseRD extends ResultHandler {
		
		
		@Override
		@Deprecated
		default DirectTransport execDirectTransportType() {
			
			
			return ResultHandler.DirectTransport.RD;
		}
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default BaseObject execReadNative(@NotNull final ExecProcess ctx) {
			
			
			return Base.forDouble(ctx.ra2RD);
		}
		
		@Override
		@Deprecated
		default ResultHandlerDirect execToCallDirectHandler(final ExecProcess ctx) {
			
			
			return EFA_DNN_NXT.INSTANCE;
		}
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default long execReadLong(@NotNull final ExecProcess ctx) {
			
			
			return (long) ctx.ra2RD;
		}
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default int execReadInt(@NotNull final ExecProcess ctx) {
			
			
			return (int) (long) ctx.ra2RD;
		}
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default String execReadString(@NotNull final ExecProcess ctx) {
			
			
			return Base.toString(ctx.ra2RD);
		}
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default double execReadDouble(@NotNull final ExecProcess ctx) {
			
			
			return ctx.ra2RD;
		}
	}
	
	/**
	 *
	 * @author myx
	 *
	 */
	@ReflectionDisable
	interface UseRS extends ResultHandler {
		
		
		@Override
		@Deprecated
		default DirectTransport execDirectTransportType() {
			
			
			return ResultHandler.DirectTransport.RS;
		}

		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default BaseObject execReadNative(@NotNull final ExecProcess ctx) {
			
			
			return Base.forString(ctx.ra3RS);
		}
		
		@Override
		@Deprecated
		default ResultHandlerDirect execToCallDirectHandler(final ExecProcess ctx) {
			
			
			return EFA_CNN_NXT.INSTANCE;
		}
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default long execReadLong(@NotNull final ExecProcess ctx) {
			
			
			return Base.toLong(ctx.ra3RS.toString());
		}
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default int execReadInt(@NotNull final ExecProcess ctx) {
			
			
			return Base.toInt32(ctx.ra3RS.toString());
		}
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default String execReadString(@NotNull final ExecProcess ctx) {
			
			
			return ctx.ra3RS.toString();
		}
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default double execReadDouble(@NotNull final ExecProcess ctx) {
			
			
			return Base.toDouble(ctx.ra3RS.toString());
		}
	}
	
	/**
	 * 'V' - void (undefined)
	 *
	 * @author myx
	 *
	 */
	@ReflectionDisable
	interface UseRV extends ResultHandler {
		
		
		@Override
		@Deprecated
		default DirectTransport execDirectTransportType() {
			
			
			return ResultHandler.DirectTransport.RV;
		}
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default BaseObject execReadNative(@NotNull final ExecProcess ctx) {
			
			
			return BaseObject.UNDEFINED;
		}
		
		@Override
		@Deprecated
		default ResultHandlerDirect execToCallDirectHandler(final ExecProcess ctx) {
			
			
			return EFU_BNN_NXT.INSTANCE;
		}
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default long execReadLong(@NotNull final ExecProcess ctx) {
			
			
			return 0;
		}
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default int execReadInt(@NotNull final ExecProcess ctx) {
			
			
			return 0;
		}
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default String execReadString(@NotNull final ExecProcess ctx) {
			
			
			return BaseObject.UNDEFINED.baseToJavaString();
		}
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default double execReadDouble(@NotNull final ExecProcess ctx) {
			
			
			return Double.NaN;
		}
	}

	/**
	 * 'CH' - Call Handler
	 *
	 *
	 * @author myx
	 *
	 */
	@ReflectionDisable
	interface UseCH extends ResultHandler {
		
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default BaseObject execReadNative(@NotNull final ExecProcess ctx) {
			
			
			return ctx.riCallResultHandler.execReadNative(ctx);
		}
		
		@Override
		@Deprecated
		default ResultHandlerDirect execToCallDirectHandler(final ExecProcess ctx) {
			
			
			return ctx.riCallResultHandler.execToCallDirectHandler(ctx);
		}

		@Override
		@Deprecated
		default DirectTransport execDirectTransportType() {
			
			
			return ResultHandler.DirectTransport.CH;
		}
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default long execReadLong(@NotNull final ExecProcess ctx) {
			
			
			return ctx.riCallResultHandler.execReadLong(ctx);
		}
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default int execReadInt(@NotNull final ExecProcess ctx) {
			
			
			return ctx.riCallResultHandler.execReadInt(ctx);
		}
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default String execReadString(@NotNull final ExecProcess ctx) {
			
			
			return ctx.riCallResultHandler.execReadString(ctx);
		}
		
		/**
		 *
		 * @param ctx
		 * @return
		 */
		@Override
		@ReflectionHidden
		default double execReadDouble(@NotNull final ExecProcess ctx) {
			
			
			return ctx.riCallResultHandler.execReadDouble(ctx);
		}
	}
	
	/**
	 *
	 */
	static ResultHandlerDirect FA_BNN_NXT = EFA_BNN_NXT.INSTANCE;

	/**
	 *
	 */
	static ResultHandlerDirect FA_CNN_NXT = EFA_CNN_NXT.INSTANCE;

	/**
	 *
	 */
	static ResultHandlerDirect FA_DNN_NXT = EFA_DNN_NXT.INSTANCE;

	/**
	 *
	 */
	static ResultHandlerDirect FA_LNN_NXT = EFA_LNN_NXT.INSTANCE;

	/**
	 *
	 */
	static ResultHandlerBasic FB_BNN_ERR = EFB_BNN_ERR.INSTANCE;

	/**
	 *
	 */
	static ResultHandlerBasic FB_BNN_RET = EFB_BNN_RET.INSTANCE;

	/**
	 *
	 */
	static ResultHandlerBasic FB_BNN_BRK = EFB_BNN_BRK.INSTANCE;

	/**
	 *
	 */
	static ResultHandlerBasic FB_BNN_CTN = EFB_BNN_CTN.INSTANCE;

	/**
	 *
	 */
	static ResultHandlerBasic FB_BSN_NXT = EFB_BSN_NXT.INSTANCE;

	/**
	 *
	 */
	static ResultHandlerBasic FB_BNO_NXT = EFB_BNO_NXT.INSTANCE;

	/**
	 *
	 */
	static ResultHandlerBasic FC_PNN_NXT = EFC_PNN_NXT.INSTANCE;

	/**
	 *
	 */
	static ResultHandlerBasic FC_PNN_RET = EFC_PNN_RET.INSTANCE;

	/**
	 *
	 */
	static ResultHandlerBasic FB_BSO_NXT = EFB_BSO_NXT.INSTANCE;

	/**
	 * stack / detach-able
	 */
	static ResultHandlerDirect FS_BNN_NXT = EFS_BNN_NXT.INSTANCE;

	/**
	 * temp / context-local
	 */
	static ResultHandler FT_BNN_NXT = EFT_BNN_NXT.INSTANCE;

	/**
	 * unused / void
	 */
	static ResultHandlerDirect FU_BNN_NXT = EFU_BNN_NXT.INSTANCE;

	/**
	 * unused / void
	 */
	static ResultHandlerBasic FU_BNN_RET = EFU_BNN_RET.INSTANCE;

	/**
	 *
	 */
	static ResultHandlerFinalizer FZ_CVT_BOOLEAN = ResultHandler::onReturnConvertRbToBoolean;

	/**
	 *
	 */
	static ResultHandlerFinalizer FZ_CVT_NUMBER = ResultHandler::onReturnConvertRbToNumber;

	/**
	 *
	 */
	static ResultHandlerFinalizer FZ_CVT_STRING = ResultHandler::onReturnConvertRbToString;

	/**
	 *
	 */
	static ResultHandlerFinalizer FZ_CVT_INT32 = ResultHandler::onReturnConvertRbToInt32;

	/**
	 *
	 * @param ctx
	 * @return
	 */
	static ExecStateCode onReturnConvertRbToBoolean(final ExecProcess ctx) {
		
		
		final BaseObject ra0RB = ctx.ra0RB;
		try {
			ctx.ra0RB = ra0RB.baseToBoolean();
			return null;
		} catch (final NullPointerException e) {
			/**
			 * should not happen, really
			 */
			ctx.ra0RB = BaseObject.FALSE;
			return null;
		}
	}

	/**
	 *
	 * @param ctx
	 * @return
	 */
	static ExecStateCode onReturnConvertRbToString(final ExecProcess ctx) {
		
		
		final BaseObject ra0RB = ctx.ra0RB;
		try {
			ctx.ra0RB = ra0RB.baseToString();
			return null;
		} catch (final NullPointerException e) {
			/**
			 * should not happen, really
			 */
			ctx.ra0RB = BaseObject.FALSE;
			return null;
		}
	}

	/**
	 *
	 * @param ctx
	 * @return
	 */
	static ExecStateCode onReturnConvertRbToNumber(final ExecProcess ctx) {
		
		
		final BaseObject ra0RB = ctx.ra0RB;
		try {
			ctx.ra0RB = ra0RB.baseToNumber();
			return null;
		} catch (final NullPointerException e) {
			/**
			 * should not happen, really
			 */
			ctx.ra0RB = BaseObject.FALSE;
			return null;
		}
	}

	/**
	 *
	 * @param ctx
	 * @return
	 */
	static ExecStateCode onReturnConvertRbToInt32(final ExecProcess ctx) {
		
		
		final BaseObject ra0RB = ctx.ra0RB;
		try {
			ctx.ra0RB = ra0RB.baseToInt32();
			return null;
		} catch (final NullPointerException e) {
			/**
			 * should not happen, really
			 */
			ctx.ra0RB = BaseObject.FALSE;
			return null;
		}
	}

	// static ResultHandler FX_CALL_RESULT = FX_CALL_RESULT.INSTANCE;

	/**
	 * Returns ExitCode. Does side-effects. Result is provided according to
	 * DirectHandler.
	 *
	 * @param ctx
	 * @return
	 */
	default ExecStateCode execReturn(@NotNull final ExecProcess ctx) {
		
		
		return null;
	}

	/**
	 *
	 * @param ctx
	 * @param value
	 * @return
	 */
	default ExecStateCode execReturn(@NotNull final ExecProcess ctx, @NotNull final BaseObject value) {
		
		
		ctx.ra0RB = value;
		return this.execReturn(ctx);
	}

	/**
	 *
	 * Invalid method, Use: execReturn for BaseObjects
	 *
	 * @param ctx
	 * @param value
	 * @return
	 * @throws Throwable
	 */
	@Deprecated
	default Void execReturnObject(@NotNull final ExecProcess ctx, @NotNull final BaseObject value) throws Throwable {
		
		
		return null;
	}

	/**
	 *
	 * @param ctx
	 * @param value
	 * @return
	 */
	default ExecStateCode execReturnObject(@NotNull final ExecProcess ctx, @NotNull final Object value) {
		
		
		return this.execReturn(ctx, Base.forUnknown(value));
	}

	/**
	 *
	 * @param ctx
	 * @param value
	 * @return
	 */
	default ExecStateCode execReturnBoolean(@NotNull final ExecProcess ctx, final boolean value) {
		
		
		return this.execReturn(ctx, value
			? BaseObject.TRUE
			: BaseObject.FALSE);
	}

	/**
	 *
	 * @param ctx
	 * @param value
	 * @return
	 */
	default ExecStateCode execReturnUndefined(@NotNull final ExecProcess ctx) {
		
		
		return this.execReturn(ctx, BaseObject.UNDEFINED);
	}

	/**
	 *
	 * @param ctx
	 * @param value
	 * @return
	 */
	default ExecStateCode execReturnNull(@NotNull final ExecProcess ctx) {
		
		
		return this.execReturn(ctx, BaseObject.NULL);
	}

	/**
	 *
	 * @param ctx
	 * @param value
	 * @return
	 */
	default ExecStateCode execReturnFalse(@NotNull final ExecProcess ctx) {
		
		
		return this.execReturn(ctx, BaseObject.FALSE);
	}

	/**
	 *
	 * @param ctx
	 * @param value
	 * @return
	 */
	default ExecStateCode execReturnTrue(@NotNull final ExecProcess ctx) {
		
		
		return this.execReturn(ctx, BaseObject.TRUE);
	}

	/**
	 *
	 * @param ctx
	 * @param value
	 * @return
	 */
	default ExecStateCode execReturnChar(@NotNull final ExecProcess ctx, final char value) {
		
		
		return this.execReturn(ctx, Base.forChar(value));
	}

	/**
	 *
	 * @param ctx
	 * @param value
	 * @return
	 */
	default ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final short value) {
		
		
		return this.execReturn(ctx, Base.forShort(value));
	}

	/**
	 *
	 * @param ctx
	 * @param value
	 * @return
	 */
	default ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final int value) {
		
		
		return this.execReturn(ctx, Base.forInteger(value));
	}

	/**
	 *
	 * @param ctx
	 * @param value
	 * @return
	 */
	default ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final long value) {
		
		
		return this.execReturn(ctx, Base.forLong(value));
	}

	/**
	 *
	 * @param ctx
	 * @param value
	 * @return
	 */
	default ExecStateCode execReturnNumeric(@NotNull final ExecProcess ctx, final double value) {
		
		
		return this.execReturn(ctx, Base.forDouble(value));
	}

	/**
	 *
	 * @param ctx
	 * @param value
	 * @return
	 */
	default ExecStateCode execReturnString(@NotNull final ExecProcess ctx, final String value) {
		
		
		return this.execReturn(ctx, Base.forString(value));
	}

	/**
	 * Returns direct handler, which is generally just indication of result type
	 * expected (i.e. object / int ...)
	 *
	 * @param ctx
	 *            TODO
	 *
	 * @return
	 */
	@NotNull
	@ReflectionHidden
	default ResultHandlerDirect execToCallDirectHandler(final ExecProcess ctx) {
		
		
		return EFA_BNN_NXT.INSTANCE;
	}

	/**
	 *
	 * TODO: move to BASIC
	 *
	 * @return
	 */
	default boolean isStackPush() {
		
		
		return false;
	}
	/**
	 *
	 * @param ctx
	 * @return
	 */
	@ReflectionHidden
	BaseObject execReadNative(@NotNull final ExecProcess ctx);
	
	/**
	 *
	 * @param ctx
	 * @return
	 */
	@ReflectionHidden
	long execReadLong(@NotNull final ExecProcess ctx);
	
	/**
	 *
	 * @param ctx
	 * @return
	 */
	@ReflectionHidden
	int execReadInt(@NotNull final ExecProcess ctx);
	
	/**
	 *
	 * @param ctx
	 * @return
	 */
	@ReflectionHidden
	String execReadString(@NotNull final ExecProcess ctx);
	
	/**
	 *
	 * @param ctx
	 * @return
	 */
	@ReflectionHidden
	double execReadDouble(@NotNull final ExecProcess ctx);
	
	/**
	 *
	 * @return
	 */
	@NotNull
	@ReflectionHidden
	DirectTransport execDirectTransportType();
}
