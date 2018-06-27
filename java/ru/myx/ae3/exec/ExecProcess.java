package ru.myx.ae3.exec;

import static ru.myx.ae3.exec.ExecProcessState.CLL;
import static ru.myx.ae3.exec.ExecProcessState.INA;
import static ru.myx.ae3.exec.ExecProcessState.RUN;
import static ru.myx.ae3.exec.ExecStateCode.BREAK;
import static ru.myx.ae3.exec.ExecStateCode.CONTINUE;
import static ru.myx.ae3.exec.ExecStateCode.ERROR;
import static ru.myx.ae3.exec.ExecStateCode.NEXT;
import static ru.myx.ae3.exec.ExecStateCode.REPEAT;
import static ru.myx.ae3.exec.ExecStateCode.RETURN;

import java.io.PrintStream;
import java.util.Iterator;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseAbstractException;
import ru.myx.ae3.base.BaseArray;
import ru.myx.ae3.base.BaseArrayAdvanced;
import ru.myx.ae3.base.BaseFunction;
import ru.myx.ae3.base.BaseJoined;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.base.BasePrimitive;
import ru.myx.ae3.base.BasePrimitiveBoolean;
import ru.myx.ae3.base.BasePrimitiveNumber;
import ru.myx.ae3.base.BasePrimitiveString;
import ru.myx.ae3.base.BaseProperty;
import ru.myx.ae3.base.ToPrimitiveHint;
import ru.myx.ae3.console.Console;
import ru.myx.ae3.e4.context.StackContext;
import ru.myx.ae3.exec.dynamic.ExecLexicalScope;
import ru.myx.ae3.reflect.ReflectionHidden;
import ru.myx.ae3.vfs.Entry;
import ru.myx.ae3.vfs.EntryVfsRoot;
import ru.myx.util.IteratorSingle;

/** VM registers are fields starting with 'r'. Registers by group:
 * <ul>
 * <li>raXXXX - accessible, readable as instruction argument and writable as instruction
 * result;</li>
 * <li>rbXXXX - basic, readable as instruction argument and writable by some special
 * instructions;</li>
 * <li>riXXXX - internal, not available as instruction argument or result, used internally;</li>
 * <li>rzXXXX - internal cache/optimization registers.</li>
 * </ul>
 *
 *
 * @author myx */
public abstract class ExecProcess implements ExecLexicalScope, StackContext/* , ExecArguments */, BaseArray {
	
	private static final boolean DBG_TMP_NODIRECT = true;
	
	static ExecTracer fldTracerStatic;
	
	/** no Object.prototype properties here
	 *
	 * TODO: should it be always IdentityObject? */
	public static final BaseObject GLOBAL = BaseObject.createObject(null);
	
	/** Use this to have faster access to 'arguments' context property. (No BaseString lookup
	 * needed) */
	public static final BasePrimitiveString PROPERTY_BASE_ARGUMENTS = Base.forString("arguments");
	
	/** Use this to have faster access to 'arguments' context property. (No BaseString lookup
	 * needed) */
	public static final String PROPERTY_STRING_ARGUMENTS = ExecProcess.PROPERTY_BASE_ARGUMENTS.baseValue();
	
	/**
	 *
	 */
	protected static final int STACK_INITIAL = 128;
	
	/** @param tracer
	 * @return */
	public static final ExecTracer setTracerStatic(final ExecTracer tracer) {
		
		try {
			return ExecProcess.fldTracerStatic;
		} finally {
			ExecProcess.fldTracerStatic = tracer;
		}
		
	}
	
	/** TODO: inline as BaseObject.execNative();
	 *
	 * @param ctx
	 * @param suspected
	 * @return */
	public static final BaseObject vmEnsureArgumentsDetached(final ExecProcess ctx, final BaseObject suspected) {
		
		return suspected instanceof ExecValueDirect
			? ((ExecValueDirect<?>) suspected).toDetached(ctx)
			: suspected;
	}
	
	/** TODO: inline as BaseObject.execNative();
	 *
	 * @param ctx
	 * @param suspected
	 * @return */
	public static final BaseObject vmEnsureDetached(final ExecProcess ctx, final BaseObject suspected) {
		
		if (ExecProcess.DBG_TMP_NODIRECT) {
			return suspected;
		}
		return suspected instanceof ExecValueDirect
			? ((ExecValueDirect<?>) suspected).toDetached(ctx)
			: suspected;
	}
	
	/** TODO: inline as BaseObject.execDetach();
	 *
	 * @param suspected
	 * @return */
	@NotNull
	public static final BaseObject vmEnsureNative(@NotNull final BaseObject suspected) {
		
		return suspected instanceof ExecValueStack
			? ((ExecValueStack<?>) suspected).toNative()
			: suspected;
	}
	
	/** code part of executable */
	Instruction[] fldCode;
	
	/** Attached console or NULL */
	Console fldConsole;
	
	/**
	 *
	 */
	BaseObject[] fldStack;
	
	ExecProcessState fldState;
	
	ExecTracer fldTracer;
	
	/** TODO: default access and getter
	 *
	 * Focused object.
	 *
	 * Analog to 'this' */
	public Entry fldVfsFocus;
	
	/** TODO: default access and getter
	 *
	 * Root object. To allow internal relative addressing. */
	public EntryVfsRoot fldVfsRoot;
	
	/** TODO: default access and getter
	 *
	 * Share<?> object. To allow external relative addressing. */
	public Entry fldVfsShare;
	
	/**
	 *
	 */
	private final ExecProcess parent;
	
	/** ACCUMULATOR / EXECUTION RESULT / Object */
	@NotNull
	public BaseObject ra0RB;
	
	/** ACCUMULATOR / EXECUTION RESULT / Integer */
	public long ra1RL;
	
	/** ACCUMULATOR / EXECUTION RESULT / Floating */
	public double ra2RD;
	
	/** ACCUMULATOR / EXECUTION RESULT / Character */
	@Nullable
	public CharSequence ra3RS;
	
	/** Call 'this' (instance) */
	public BaseObject rb4CT;
	/** Call callee */
	@Nullable
	public BaseFunction rb5CC;
	
	/** Call arguments */
	public BaseArray rb6CA;
	
	/** LOCAL FRAME CONTEXT VALUES */
	@NotNull
	public BaseObject rb7FV;
	
	/**
	 *
	 */
	public int ri08IP = 0;
	
	/**
	 *
	 */
	public int ri09IL = 0;
	
	/**
	 *
	 */
	public int ri0ASP = 0;
	
	/**
	 *
	 */
	public int ri0BSB = 0;
	
	/**
	 *
	 */
	public int ri0CBT = -1;
	
	/**
	 *
	 */
	public int ri0DCT = -1;
	
	/**
	 *
	 */
	public int ri0EET = -1;
	
	/**
	 *
	 */
	public int ri0FI0 = 0;
	
	/** GLOBAL CONTEXT VALUES */
	public BaseObject ri10GV;
	
	/** loop iterators, non-directly accessible. ITRPREPXXX and ITRNEXT is using it, Frames for
	 * loops and calls are saving it and replacing with NULL. */
	IteratorImpl ri11II;
	
	/** Iteration iterable object */
	BaseObject ri12IA;
	
	/** Iteration value / key / index / parameter */
	Object ri13IV;
	
	/** named arguments mapper */
	@Nullable
	NamedToIndexMapper riCallNameMapper;
	
	/**
	 *
	 */
	public ResultHandler riCallResultHandler;
	
	/**
	 *
	 */
	Object riDebug;
	
	/** current output target */
	BaseFunction riOutput;
	
	ValueDirectInteger rzDirectInteger;
	
	ValueDirectLong rzDirectLong;
	
	ValueDirectNumber rzDirectNumber;
	
	ValueDirectString rzDirectString;
	
	/** Calls this(parent, parent)
	 *
	 * @param parent */
	protected ExecProcess(final ExecProcess parent) {
		
		this(parent, parent);
	}
	
	/** @param execParent
	 *            context to derive process from
	 * @param callParent
	 *            context to derive tracer and VFS settings */
	protected ExecProcess(final ExecProcess execParent, final ExecProcess callParent) {
		
		this.parent = execParent;
		this.fldState = INA;
		this.fldStack = new BaseObject[ExecProcess.STACK_INITIAL];
		this.riCallResultHandler = ResultHandler.FS_BNN_NXT;
		if (callParent != null) {
			this.fldVfsRoot = callParent.fldVfsRoot;
			this.fldVfsShare = callParent.fldVfsShare;
			this.fldVfsFocus = callParent.fldVfsFocus;
			this.fldTracer = callParent.fldTracer;
			this.fldConsole = callParent.fldConsole;
		}
	}
	
	/** Creates (probably) temporary arguments object. The guarantee is that they can be properly
	 * read during current call and before new arguments are generated (by direct call to
	 * argumentsXXX method or by AE3-VM execution).
	 *
	 * @param constant
	 * @return arguments */
	public abstract ExecArguments argumentsConstant(final BaseObject constant);
	
	/** Creates (probably) temporary arguments object. The guarantee is that they can be properly
	 * read during current call and before new arguments are generated (by direct call to
	 * argumentsXXX method or by AE3-VM execution).
	 *
	 * for CALLS. Copy some from stack.
	 *
	 * @param size
	 * @return arguments */
	public abstract ExecArguments argumentsCopy(final int size);
	
	/** Creates (probably) temporary arguments object. The guarantee is that they can be properly
	 * read during current call and before new arguments are generated (by direct call to
	 * argumentsXXX method or by AE3-VM execution).
	 *
	 * for CALLM. Copy some from stack, use description.
	 *
	 * @param size
	 * @param desc
	 * @return arguments */
	public abstract ExecArguments argumentsCopyMap(final int size, final NamedToIndexMapper desc);
	
	/** Creates (probably) temporary arguments object. The guarantee is that they can be properly
	 * read during current call and before new arguments are generated (by direct call to
	 * argumentsXXX method or by AE3-VM execution).
	 *
	 * for CALLO and CALLS. Use (/Map) some on stack.
	 *
	 * for CALLM. Use (/Map) some on stack, use description.
	 *
	 * @param size
	 * @param desc
	 * @return arguments */
	protected abstract ExecArguments argumentsCtx(final int size, final NamedToIndexMapper desc);
	
	/** Returns singleton empty arguments object with no 'callee' property
	 *
	 * @return arguments */
	public abstract ExecArguments argumentsEmpty();
	
	/** Creates (probably) temporary arguments object. The guarantee is that they can be properly
	 * read during current call and before new arguments are generated (by direct call to
	 * argumentsXXX method or by AE3-VM execution).
	 *
	 * @param argument
	 *
	 * @return arguments */
	public abstract ExecArguments argumentsList1(BaseObject argument);
	
	/** Creates (probably) temporary arguments object. The guarantee is that they can be properly
	 * read during current call and before new arguments are generated (by direct call to
	 * argumentsXXX method or by AE3-VM execution).
	 *
	 * @param argument1
	 * @param argument2
	 *
	 * @return arguments */
	public abstract ExecArguments argumentsList2(BaseObject argument1, BaseObject argument2);
	
	/** Creates (probably) temporary arguments object. The guarantee is that they can be properly
	 * read during current call and before new arguments are generated (by direct call to
	 * argumentsXXX method or by AE3-VM execution).
	 *
	 * @param arguments
	 *
	 * @return arguments */
	public abstract ExecArguments argumentsListA(BaseObject... arguments);
	
	/** Creates (probably) temporary arguments object. The guarantee is that they can be properly
	 * read during current call and before new arguments are generated (by direct call to
	 * argumentsXXX method or by AE3-VM execution).
	 *
	 * @param map
	 *
	 * @return arguments */
	public abstract ExecArguments argumentsMap(BaseObject map);
	
	/** Not an array. But, function arguments for a call accessible via this method as an array. */
	@SuppressWarnings("deprecation")
	@Override
	public final BaseArray baseArray() {
		
		return this.rb6CA;
	}
	
	@Override
	@ReflectionHidden
	public final BaseArrayAdvanced<?> baseArraySlice(final int start) {
		
		return this.rb6CA.baseArraySlice(start);
	}
	
	@Override
	@ReflectionHidden
	public final BaseArrayAdvanced<?> baseArraySlice(final int start, final int end) {
		
		return this.rb6CA.baseArraySlice(start, end);
	}
	
	@Override
	public final BaseFunction baseCall() {
		
		return this.rb7FV.baseCall();
	}
	
	@Override
	public final String baseClass() {
		
		return "Process";
	}
	
	@Override
	public final BaseFunction baseConstruct() {
		
		return this.rb7FV.baseConstruct();
	}
	
	@Override
	public final boolean baseContains(final BaseObject value) {
		
		return this.rb6CA.baseContains(value);
	}
	
	@Override
	public final boolean baseDefine(final BasePrimitiveString name, final BaseObject value, final short attributes) {
		
		return this.rb7FV.baseDefine(name, value, attributes);
	}
	
	@Override
	public final boolean baseDefine(final String name, final BaseObject value, final short attributes) {
		
		return this.rb7FV.baseDefine(name, value, attributes);
	}
	
	@Override
	public final boolean baseDelete(final BaseObject name) {
		
		return this.rb7FV.baseDelete(name);
	}
	
	@Override
	public final boolean baseDelete(final String name) {
		
		return this.rb7FV.baseDelete(name);
	}
	
	@Override
	public final BaseObject baseGet(final int index, final BaseObject defaultValue) {
		
		return this.rb6CA.baseGet(index, defaultValue);
	}
	
	@Override
	public BaseObject baseGetFirst(final BaseObject defaultValue) {
		
		return this.rb6CA.baseGetFirst(defaultValue);
	}
	
	@Override
	public BaseObject baseGetLast(final BaseObject defaultValue) {
		
		return this.rb6CA.baseGetLast(defaultValue);
	}
	
	@Override
	public final BaseProperty baseGetOwnProperty(final BasePrimitiveString name) {
		
		{
			/** not OWN */
			for (BaseObject object = this.rb7FV;;) {
				final BaseProperty property = object.baseGetOwnProperty(name);
				if (property != null) {
					return property;
				}
				object = object.basePrototype();
				if (object == null) {
					break;
				}
			}
		}
		{
			/** fake */
			if (ExecProcess.PROPERTY_BASE_ARGUMENTS == name) {
				return ExecProcessArgumentsProperty.INSTANCE;
			}
		}
		return null;
	}
	
	@Override
	public final BaseProperty baseGetOwnProperty(final String name) {
		
		{
			/** not OWN */
			for (BaseObject object = this.rb7FV;;) {
				final BaseProperty property = object.baseGetOwnProperty(name);
				if (property != null) {
					return property;
				}
				object = object.basePrototype();
				if (object == null) {
					break;
				}
			}
		}
		{
			/** fake */
			if (name.length() == 9 && (name == ExecProcess.PROPERTY_STRING_ARGUMENTS || "arguments".equals(name))) {
				return ExecProcessArgumentsProperty.INSTANCE;
			}
		}
		return null;
	}
	
	@Override
	public final boolean baseHasKeysOwn() {
		
		/** Not FV but arguments, FV through prototype chain though */
		return this.rb6CA.baseHasKeysOwn();
	}
	
	@Override
	public final boolean baseIsExtensible() {
		
		return this.rb7FV.baseIsExtensible();
	}
	
	@Override
	public final Iterator<? extends BaseObject> baseIterator() {
		
		return this.rb6CA.baseIterator();
	}
	
	@Override
	public final Iterator<String> baseKeysOwn() {
		
		final BaseArray rb6ca = this.rb6CA;
		return rb6ca == null
			? BaseObject.ITERATOR_EMPTY
			: rb6ca.baseKeysOwn();/** Not FV but arguments, FV through prototype chain though */
		// return Base.keys(this.r6FV);
	}
	
	@Override
	public final Iterator<? extends CharSequence> baseKeysOwnAll() {
		
		final Iterator<? extends CharSequence> locals = Base.keysAll(this.rb7FV);
		return this.rb6CA != null
			? Base.joinIterators(locals, new IteratorSingle<>(ExecProcess.PROPERTY_STRING_ARGUMENTS))
			: locals;
	}
	
	@Override
	public final Iterator<? extends BasePrimitive<?>> baseKeysOwnPrimitive() {
		
		return Base.keysPrimitive(this.rb7FV);
	}
	
	@Override
	public final BaseObject basePrototype() {
		
		return this.parent;
	}
	
	@Override
	public final BasePrimitiveBoolean baseToBoolean() {
		
		return this.rb7FV.baseToBoolean();
	}
	
	@Override
	public final BasePrimitiveNumber baseToInt32() {
		
		return this.rb7FV.baseToInt32();
	}
	
	@Override
	public final BasePrimitiveNumber baseToInteger() {
		
		return this.rb7FV.baseToInteger();
	}
	
	@Override
	public final BasePrimitiveNumber baseToNumber() {
		
		return this.rb7FV.baseToNumber();
	}
	
	@Override
	public final BasePrimitive<?> baseToPrimitive(final ToPrimitiveHint hint) {
		
		return this.rb7FV.baseToPrimitive(hint);
	}
	
	@Override
	public final BasePrimitiveString baseToString() {
		
		return this.rb7FV.baseToString();
	}
	
	@Override
	public final ExecProcess baseValue() {
		
		return this;
	}
	
	@Override
	public final void contextCreateMutableBinding(final BasePrimitiveString name, final BaseObject value, final boolean dynamic) {
		
		this.rb7FV.baseDefine(
				name, //
				value,
				dynamic
					? BaseProperty.ATTRS_MASK_WED
					: BaseProperty.ATTRS_MASK_WEN);
	}
	
	@Override
	public final void contextCreateMutableBinding(final String name, final BaseObject value, final boolean dynamic) {
		
		this.rb7FV.baseDefine(
				name, //
				value,
				dynamic
					? BaseProperty.ATTRS_MASK_WED
					: BaseProperty.ATTRS_MASK_WEN);
	}
	
	@Override
	public final boolean contextDeleteBinding(final String name) {
		
		BaseProperty property = null;
		BaseObject source = this.rb7FV;
		for (;;) {
			property = source.baseGetOwnProperty(name);
			if (property != null) {
				/** Property found, setting it's value */
				return source.baseDelete(name);
			}
			/** not going upper than GV for DELETE */
			if (source == this.ri10GV) {
				/** kinda success */
				return true;
			}
			assert source.basePrototype() != source : "prototype should not be equal to this instance, class=" + source.getClass().getName();
			source = source.basePrototype();
			/** Oops - not found */
			if (source == null) {
				/** kinda success */
				return true;
			}
		}
	}
	
	/** Setups new context with actual arguments being bind.
	 *
	 * Should return ExecStateCode but do not fool yourself, there would be always null. It never
	 * fails, that's why actual return is void.
	 *
	 * @param calleeName
	 *
	 * @param arguments
	 *            NULL value is special, it causes system to ignore arguments totally regardless of
	 *            actual arguments passed. */
	public final void contextExecFARGS(@Nullable final BasePrimitiveString calleeName, @NotNull final BasePrimitiveString[] arguments) {
		
		if (arguments == null) {
			return;
		}
		if (calleeName != null) {
			final BaseObject callee = this.rb5CC;
			/** TODO: use synthetic context property instead */
			this.contextCreateMutableBinding(
					calleeName, //
					callee == null
						? BaseObject.UNDEFINED
						: callee,
					false);
		}
		
		final BaseArray list = this.rb6CA;
		final int sizea = arguments.length;
		if (list == null) {
			for (int position = sizea - 1; position >= 0; position--) {
				this.contextCreateMutableBinding(
						arguments[position], //
						BaseObject.UNDEFINED,
						false);
			}
		} else {
			if (list.baseHasKeysOwn()) {
				for (int position = sizea - 1; position >= 0; position--) {
					final BasePrimitiveString key = arguments[position];
					this.contextCreateMutableBinding(
							key, //
							/** TODO: no need for this? VMCALL does that?! No? */
							ExecProcess.vmEnsureNative(list.baseGet(key, BaseObject.UNDEFINED)),
							false);
				}
			} else {
				final int sizel = list.length();
				if (sizel <= sizea) {
					for (int position = sizel - 1; position >= 0; position--) {
						this.contextCreateMutableBinding(
								arguments[position], //
								/** TODO: no need for this? VMCALL does that?! No? */
								ExecProcess.vmEnsureNative(list.baseGet(position, BaseObject.UNDEFINED)),
								false);
					}
					for (int position = sizea - 1; position >= sizel; position--) {
						this.contextCreateMutableBinding(
								arguments[position], //
								BaseObject.UNDEFINED,
								false);
					}
				} else {
					for (int position = sizea - 1; position >= 0; position--) {
						this.contextCreateMutableBinding(
								arguments[position], //
								/** TODO: no need for this? VMCALL does that?! No? */
								ExecProcess.vmEnsureNative(list.baseGet(position, BaseObject.UNDEFINED)),
								false);
					}
				}
			}
		}
	}
	
	/** @param message
	 * @return NULL */
	public final ExecStateCode contextExecFDEBUG(final Object message) {
		
		assert this.fldTracer == null
			? ExecProcess.fldTracerStatic == null || ExecProcess.fldTracerStatic.traceDebug(this, message)
			: this.fldTracer.traceDebug(this, message);
		
		this.riDebug = message;
		return null;
	}
	
	/** @return value of internal 'arguments' register */
	@NotNull
	public final BaseArray contextGetArguments() {
		
		final BaseArray arguments = this.rb6CA;
		if (arguments instanceof ExecArguments.NeedsDetachment) {
			
			final BaseArray replacement = ((ExecArguments.NeedsDetachment) arguments).toDetached(this);
			if (arguments != replacement) {
				return this.rb6CA = replacement;
			}
		}
		return arguments;
	}
	
	@Override
	public final BaseObject contextGetBindingValue(final BasePrimitiveString name, final boolean strict) {
		
		BaseObject source = this.rb7FV;
		/** from r6FV to r5GV or BaseObject.PROTOTYPE when r6FV does not contain r5GV in its
		 * prototype chain. */
		first : for (;;) {
			/** not going upper than every GV for GET, not including GV. */
			if (source == this.ri10GV) {
				break first;
			}
			final BaseProperty property = source.baseGetOwnProperty(name);
			if (property != null) {
				/** Property found, setting it's value */
				return property.propertyGet(source, name);
			}
			final BaseObject prototype = source.basePrototype();
			assert prototype != source : "prototype should not be equal to this instance, class=" + source.getClass().getName();
			source = prototype;
			/** Not including BaseObject.PROTOTYPE */
			if (source == BaseObject.PROTOTYPE || source == null) {
				break first;
			}
		}
		/** fake 'arguments'
		 *
		 * allows to access arguments of call here (dynamically) */
		if (name == ExecProcess.PROPERTY_BASE_ARGUMENTS) {
			return this.contextGetArguments();
		}
		/** from r5GV to BaseObject.PROTOTYPE; */
		for (source = this.ri10GV; source != null && source != BaseObject.PROTOTYPE;) {
			/** Not including ExecProcess.GLOBAL */
			if (source == ExecProcess.GLOBAL) {
				final BaseObject value = source.baseGet(name, null);
				if (value != null) {
					/** Property found, getting it's value */
					return value;
				}
				if (strict) {
					throw new RuntimeException("TypeError");
				}
				return BaseObject.UNDEFINED;
			}
			final BaseProperty property = source.baseGetOwnProperty(name);
			if (property != null) {
				/** Property found, setting it's value */
				return property.propertyGet(source, name);
			}
			source = source.basePrototype();
		}
		if (strict) {
			throw new RuntimeException("TypeError");
		}
		return BaseObject.UNDEFINED;
	}
	
	@Override
	public final BaseObject contextGetBindingValue(final String name, final boolean strict) {
		
		BaseObject source = this.rb7FV;
		/** from r6FV to r5GV or BaseObject.PROTOTYPE when r6FV does not contain r5GV in its
		 * prototype chain. */
		first : for (;;) {
			/** not going upper than every GV for GET, not including GV. */
			if (source == this.ri10GV) {
				break first;
			}
			final BaseProperty property = source.baseGetOwnProperty(name);
			if (property != null) {
				/** Property found, setting it's value */
				return property.propertyGet(source, name);
			}
			final BaseObject prototype = source.basePrototype();
			assert prototype != source : "prototype should not be equal to this instance, class=" + source.getClass().getName();
			source = prototype;
			/** Not including BaseObject.PROTOTYPE */
			if (source == BaseObject.PROTOTYPE || source == null) {
				break first;
			}
		}
		/** fake 'arguments'
		 *
		 * allows to access arguments of call here (dynamically) */
		if (name.length() == 9 && (name == ExecProcess.PROPERTY_STRING_ARGUMENTS || "arguments".equals(name))) {
			return this.contextGetArguments();
		}
		/** from r5GV to BaseObject.PROTOTYPE; */
		for (source = this.ri10GV; source != null && source != BaseObject.PROTOTYPE;) {
			/** Not including ExecProcess.GLOBAL */
			if (source == ExecProcess.GLOBAL) {
				final BaseObject value = source.baseGet(name, null);
				if (value != null) {
					/** Property found, getting it's value */
					return value;
				}
				if (strict) {
					throw new RuntimeException("TypeError");
				}
				return BaseObject.UNDEFINED;
			}
			final BaseProperty property = source.baseGetOwnProperty(name);
			if (property != null) {
				/** Property found, setting it's value */
				return property.propertyGet(source, name);
			}
			final BaseObject prototype = source.basePrototype();
			assert prototype != source : "prototype should not be equal to this instance, class=" + source.getClass().getName();
			source = prototype;
		}
		
		if (strict) {
			throw new RuntimeException("TypeError");
		}
		
		return BaseObject.UNDEFINED;
	}
	
	// @Override
	/** @return value of internal 'debug' register */
	public final Object contextGetDebug() {
		
		return this.riDebug;
	}
	
	@Override
	public final boolean contextHasBinding(final String name) {
		
		return Base.hasProperty(this.rb7FV, name);
	}
	
	/** <code>
	&#64;Override
	public final BaseFunction execCallee() {
	
	
		return this.fldArguments.execCallee();
	}
	
	&#64;Override
	public final ExecArguments execDetachable() {
	
	
		return this.fldArguments = this.fldArguments.execDetachable();
	}
	
	&#64;Override
	public final BaseObject execInstance() {
	
	
		return this.r4RT;
		// return this.fldArguments.execInstance();
	}
	
	</code> **/
	
	@Override
	public final BaseObject contextImplicitThisValue() {
		
		return this.ri10GV;
	}
	
	/** DIFFERS: strict = false would add new binding!
	 *
	 *
	 * 10.2.1.1.3 SetMutableBinding (N,V,S)
	 *
	 * The concrete Environment Record method SetMutableBinding for declarative environment records
	 * attempts to change the bound value of the current binding of the identifier whose name is the
	 * value of the argument N to the value of argument V. A binding for N must already exist. If
	 * the binding is an immutable binding, a TypeError is always thrown. The S argument is ignored
	 * because strict mode does not change the meaning of setting bindings in declarative
	 * environment records.
	 *
	 * 1. Let envRec be the declarative environment record for which the method was invoked.<br>
	 * 2. Assert: envRec must have a binding for N.<br>
	 * 3. If the binding for N in envRec is a mutable binding, change its bound value to V.<br>
	 * 4. Else this must be an attempt to change the value of an immutable binding so throw a
	 * TypeError exception. */
	@Override
	public final boolean contextSetMutableBinding(final BasePrimitiveString name, final BaseObject value, final boolean strict) {
		
		BaseProperty property = null;
		BaseObject source = this.rb7FV;
		for (;;) {
			property = source.baseGetOwnProperty(name);
			if (property != null) {
				final String nameString = name.toString();
				/** Property found, setting it's value
				 *
				 * LOCAL CONTEXT PROPERTIES ASSUMED ALWAYS WRITABLE. */
				return /* property.isWritable( nameString ) ? */property.propertySet(source, nameString, value, BaseProperty.ATTRS_MASK_WED)
				/* : false */;
			}
			/** not going upper than GV for SET */
			if (source == this.ri10GV) {
				break;
			}
			/** <code>
			assert source.basePrototype() != source : "prototype should not be equal to this instance, class="
					+ source.getClass().getName();
			</code> */
			source = source.basePrototype();
			/** Oops - not found */
			if (source == null) {
				break;
			}
		}
		/** special CM condition %) */
		if (value == BaseObject.UNDEFINED) {
			if (source != null) {
				/** Not own! Could have it somewhere upper, have to override then. */
				property = source.baseGetOwnProperty(name);
				if (property != null) {
					return this.rb7FV.baseDefine(name, value, BaseProperty.ATTRS_MASK_WED);
				}
			}
			return true;
		}
		if (strict) {
			throw new RuntimeException("TypeError: no such binding");
		}
		// System.err.println( ">>> >>> write to undeclared: name=" + name );
		/** source should be GV if GV is defined cause search goes till GV, it will not be GV if
		 * chain is broken, in this case we'll use FV */
		return (source != this.ri10GV || source == null
			/** Use frame itself */
			? this.rb7FV
			/** source should be GV and not NULL */
			: source) //
					.baseDefine(name, value, BaseProperty.ATTRS_MASK_WED);
	}
	
	/** DIFFERS: strict = false would add new binding!
	 *
	 *
	 * 10.2.1.1.3 SetMutableBinding (N,V,S)
	 *
	 * The concrete Environment Record method SetMutableBinding for declarative environment records
	 * attempts to change the bound value of the current binding of the identifier whose name is the
	 * value of the argument N to the value of argument V. A binding for N must already exist. If
	 * the binding is an immutable binding, a TypeError is always thrown. The S argument is ignored
	 * because strict mode does not change the meaning of setting bindings in declarative
	 * environment records.
	 *
	 * 1. Let envRec be the declarative environment record for which the method was invoked.<br>
	 * 2. Assert: envRec must have a binding for N.<br>
	 * 3. If the binding for N in envRec is a mutable binding, change its bound value to V.<br>
	 * 4. Else this must be an attempt to change the value of an immutable binding so throw a
	 * TypeError exception. */
	@Override
	public final boolean contextSetMutableBinding(final String name, final BaseObject value, final boolean strict) {
		
		BaseProperty property = null;
		BaseObject source = this.rb7FV;
		for (;;) {
			property = source.baseGetOwnProperty(name);
			if (property != null) {
				/** Property found, setting it's value
				 *
				 * LOCAL CONTEXT PROPERTIES ASSUMED ALWAYS WRITABLE. */
				return /* property.isWritable( name ) ? */property.propertySet(source, name, value, BaseProperty.ATTRS_MASK_WED)
				/* : false */;
			}
			/** not going upper than GV for SET */
			if (source == this.ri10GV) {
				break;
			}
			assert source.basePrototype() != source : "prototype should not be equal to this instance, class=" + source.getClass().getName();
			source = source.basePrototype();
			/** Oops - not found */
			if (source == null) {
				break;
			}
		}
		/** special CM condition %) */
		if (value == BaseObject.UNDEFINED) {
			if (source != null) {
				/** Not own! Could have it somewhere upper, have to override then. */
				property = source.baseGetOwnProperty(name);
				if (property != null) {
					return this.rb7FV.baseDefine(name, value, BaseProperty.ATTRS_MASK_WED);
				}
			}
			return true;
		}
		if (strict) {
			throw new RuntimeException("TypeError: no such binding");
		}
		// System.err.println( ">>> >>> write to undeclared: name=" + name );
		/** source should be GV if GV is defined cause search goes till GV, it will not be GV if
		 * chain is broken, in this case we'll use FV */
		return (source != this.ri10GV || source == null
			/** Use frame itself */
			? this.rb7FV
			/** source should be GV and not NULL */
			: source) //
					.baseDefine(name, value, BaseProperty.ATTRS_MASK_WED);
	}
	
	/** @param name
	 * @param value
	 * @param strict */
	public final void contextSetMutableBinding(final String name, final double value, final boolean strict) {
		
		this.contextSetMutableBinding(name, Base.forDouble(value), strict);
	}
	
	/** @param name
	 * @param value
	 * @param strict */
	public final void contextSetMutableBinding(final String name, final long value, final boolean strict) {
		
		this.contextSetMutableBinding(name, Base.forLong(value), strict);
	}
	
	/** @param name
	 * @param value
	 * @param strict */
	@Deprecated
	public final void contextSetMutableBinding(final String name, final Object value, final boolean strict) {
		
		this.contextSetMutableBinding(name, Base.forUnknown(value), strict);
	}
	
	/** @param pw */
	public final void dump(final PrintStream pw) {
		
		final StringBuilder sb = new StringBuilder(1024);
		this.dump(sb);
		pw.println(sb.toString());
	}
	
	/** @param sb */
	public abstract void dump(final StringBuilder sb);
	
	/** @param object
	 * @return */
	public final ExecStateCode execOutput(final BaseObject object) {
		
		if (object == null) {
			return null;
		}
		final BaseFunction output = this.riOutput;
		if (output == null) {
			return null;
		}
		final BaseObject ra0RB = this.ra0RB;
		final ExecStateCode code = output.execCallPrepare(this, BaseObject.UNDEFINED, ResultHandler.FU_BNN_NXT, true, object);
		if (code == null || code == ExecStateCode.NEXT || code == ExecStateCode.RETURN) {
			this.ra0RB = ra0RB;
			return null;
		}
		return code;
	}
	
	/** null outputs are welcome. Check OutputBuilder class.
	 *
	 * @param output
	 * @return previous output */
	public final BaseFunction execOutputReplace(final BaseFunction output) {
		
		try {
			return this.riOutput;
		} finally {
			this.riOutput = output;
		}
	}
	
	/** @param codeDefault
	 * @return */
	abstract ExecStateCode frameUp(final ExecStateCode codeDefault);
	
	@Override
	public final Object get(final int i) {
		
		return this.rb6CA.get(i);
	}
	
	/** returns local process's console or recursively calls parent context's method.
	 *
	 * @return */
	public Console getConsole() {
		
		return this.fldConsole == null
			? this.parent == null
				? null
				: this.parent.getConsole()
			: this.fldConsole;
	}
	
	/** @return chain */
	public final ExecProcess getParentProcess() {
		
		return this.parent;
	}
	
	/** @return */
	public Entry getVfsFocus() {
		
		return this.fldVfsFocus;
	}
	
	/** @return */
	public Entry getVfsRoot() {
		
		return this.fldVfsRoot;
	}
	
	/** @return */
	public Entry getVfsShare() {
		
		return this.fldVfsShare;
	}
	
	@Override
	public final boolean isEmpty() {
		
		return this.rb6CA.isEmpty();
	}
	
	@Override
	public final Iterator<?> iterator() {
		
		return this.rb6CA.iterator();
	}
	
	@Override
	public final int length() {
		
		return this.rb6CA.length();
	}
	
	/** @param title
	 * @throws IllegalArgumentException */
	public abstract void replaceInfo(final String title) throws IllegalArgumentException;
	
	/** @return */
	abstract ExecStateCode runImpl(final int stackBase);
	
	/** @param console */
	public void setConsole(final Console console) {
		
		this.fldConsole = console;
	}
	
	/** @param tracer
	 * @return */
	public final ExecTracer setTracer(final ExecTracer tracer) {
		
		try {
			return this.fldTracer;
		} finally {
			this.fldTracer = tracer;
		}
		
	}
	
	/** <code>this.fldStack[pointer - 1]</code>
	 *
	 * @return topmost stack object */
	@Override
	public abstract BaseObject stackPeek();
	
	/** <code>this.fldStack[pointer - 1 - more]</code>
	 *
	 * @param more
	 * @return stack object */
	@Override
	public abstract BaseObject stackPeek(int more);
	
	/** @return topmost stack object */
	@Override
	public abstract BaseObject stackPop();
	
	/** Pushes RR */
	@Override
	public abstract void stackPush();
	
	/** @param value */
	@Override
	public abstract void stackPush(BaseObject value);
	
	abstract BaseAbstractException throwError(final Object msg, final Throwable t);
	
	/** function implementation should not return RETURN or exception could be raised
	 *
	 * @param callee
	 * @param thisValue
	 * @param mapper
	 * @param resultVisibility
	 * @return */
	final ExecStateCode vmCallM(final BaseFunction callee, final BaseObject thisValue, final NamedToIndexMapper mapper, final ResultHandler resultHandler) {
		
		final int count = mapper.length();
		
		if (count == 0) {
			return callee.execCallPrepare(this, thisValue, resultHandler, false);
		}
		
		{
			/** Can't use CTX - used for vm calls and stack values are overwritten immediately */
			final ExecArguments arguments = this.argumentsCopyMap(count, mapper);
			/** have to clean up */
			final BaseObject[] stack = this.fldStack;
			final int rASP = this.ri0ASP;
			for (int i = count; i > 0; --i) {
				stack[rASP - i] = null;
			}
			this.ri0ASP -= count;
			
			return callee.execCallPrepare(this, thisValue, resultHandler, false, arguments);
		}
		
	}
	
	/** CALLSxxx instruction implementation
	 *
	 * function implementation should not return RETURN or exception could be raised
	 *
	 * ARGUMENTS ON STACK
	 *
	 * @param callee
	 * @param thisValue
	 * @param count
	 *            number of arguments on stack
	 * @param resultHandler
	 * @return */
	final ExecStateCode vmCallS(final BaseFunction callee, final BaseObject thisValue, final int count, final ResultHandler resultHandler) {
		
		if (count == 0) {
			return callee.execCallPrepare(this, thisValue, resultHandler, false);
		}
		
		if (count == 1) {
			return callee.execCallPrepare(this, thisValue, resultHandler, false, this.stackPop());
		}
		
		{
			final ExecArguments arguments = this.argumentsCopy(count);
			/** have to clean up */
			final BaseObject[] stack = this.fldStack;
			final int rASP = this.ri0ASP;
			for (int i = count; i > 0; --i) {
				stack[rASP - i] = null;
			}
			this.ri0ASP -= count;
			
			return callee.execCallPrepare(this, thisValue, resultHandler, false, arguments);
		}
	}
	
	/** @return */
	public abstract ExecStateCode vmFrameEntryExBlock();
	
	/** @param inline
	 * @param thisValue
	 * @param callee
	 * @param arguments
	 * @param exitHandler */
	public abstract void vmFrameEntryExCall(//
			final boolean inline, //
			final BaseObject thisValue,
			final BaseFunction callee,
			final BaseArray arguments,
			final ResultHandler exitHandler);
	
	/** @return */
	public abstract ExecStateCode vmFrameEntryExCode();
	
	/** @return */
	public abstract ExecStateCode vmFrameEntryExFull();
	
	/** (CTRL + VARS + DEBUG, NEW VARS)
	 *
	 * @param leaveAddress
	 *            frame leave address or -1
	 * @return */
	public abstract ExecStateCode vmFrameEntryOpCatch(final int leaveAddress);
	
	/** (CTRL)
	 *
	 * @param leaveAddress
	 *            frame leave address or -1
	 * @return */
	public abstract ExecStateCode vmFrameEntryOpCtrl(final int leaveAddress);
	
	/** (CTRL + VARS, NEW VARS)
	 *
	 * @param leaveAddress
	 *            frame leave address or -1
	 * @return */
	public abstract ExecStateCode vmFrameEntryOpCtrlNewVars(final int leaveAddress);
	
	/** (ALL_REGS + CTRL + VARS)
	 *
	 * @param leaveAddress
	 *            frame leave address or -1
	 * @return */
	public abstract ExecStateCode vmFrameEntryOpFull(final int leaveAddress);
	
	/** (ITER_REGS + CTRL + VARS)
	 *
	 * @param leaveAddress
	 *            frame leave address or -1
	 * @return */
	public abstract ExecStateCode vmFrameEntryOpIterCtrl(final int leaveAddress);
	
	/** (ITER_REGS + CTRL + VARS, NEW VARS)
	 *
	 * @param leaveAddress
	 *            frame leave address or -1
	 * @return */
	public abstract ExecStateCode vmFrameEntryOpIterCtrlNewVars(final int leaveAddress);
	
	/** (VARS, NEW VARS)
	 *
	 * @param leaveAddress
	 *            frame leave address or -1
	 * @return */
	public abstract ExecStateCode vmFrameEntryOpNewVars(final int leaveAddress);
	
	/** ()
	 *
	 * @param leaveAddress
	 *            frame leave address or -1
	 * @return */
	public abstract ExecStateCode vmFrameEntryOpNone(final int leaveAddress);
	
	/** @return int */
	public abstract ExecStateCode vmFrameLeave();
	
	/** Detachable RR
	 *
	 * Maybe: detach(BaseObject)?
	 *
	 * @return */
	public final BaseObject vmGetResultDetachable() {
		
		return this.ra0RB instanceof ExecValueDirect<?>
			? this.ra0RB = ((ExecValueDirect<?>) this.ra0RB).toDetached(this)
			: this.ra0RB;
	}
	
	/** @return */
	public final BaseObject vmGetResultImmediate() {
		
		return this.ra0RB;
	}
	
	/** Detachable RR
	 *
	 * .baseValue()
	 *
	 * @return */
	public final Object vmGetResultJava() {
		
		return this.ra0RB != null
			? this.ra0RB.baseValue()
			: null;
	}
	
	/** Detachable RR
	 *
	 * Maybe: detach(BaseObject)?
	 *
	 * @return */
	public final BaseObject vmGetResultNative() {
		
		return this.ra0RB instanceof ExecValueStack<?>
			? this.ra0RB = ((ExecValueStack<?>) this.ra0RB).toNative()
			: this.ra0RB;
	}
	
	@Override
	public final ExecStateCode vmPropertyRead(final ExecProcess ctx, final int index, final BaseObject originalIfKnown, final BaseObject defaultValue, final ResultHandler store) {
		
		return this.rb6CA.vmPropertyRead(ctx, index, originalIfKnown, defaultValue, store);
	}
	
	/** Throws error with given text as an error message. (Much like 'throw new Error(e)')
	 *
	 * @param o
	 * @return */
	public abstract ExecStateCode vmRaise(final String o);
	
	/** Throws error with given text as an error message. (Much like 'throw new Error(e)')
	 *
	 * @param o
	 * @return */
	public abstract ExecStateCode vmRaise(final Throwable o);
	
	/** Throws syntax error with given text as an error message. (Much like 'throw new
	 * SyntaxError(e)')
	 *
	 * @param o
	 * @return */
	public abstract ExecStateCode vmRaiseSyntax(final String o);
	
	/** Throws syntax error with given text as an error message. (Much like 'throw new
	 * TypeError(e)')
	 *
	 * @param o
	 * @return */
	public abstract ExecStateCode vmRaiseType(final String o);
	
	/** Remember to use same direct transport type
	 *
	 * @param newHandler
	 * @param oldHandler */
	public abstract void vmReplaceCallResultHandler(final ResultHandler newHandler, final ResultHandler oldHandler);
	
	/** @param mixIn
	 * @return */
	public final BaseObject vmScopeCreateMixIn(final BaseObject mixIn) {
		
		/** non checked */
		this.ri10GV = mixIn;
		return this.rb7FV = BaseObject.createObject(new BaseJoined(mixIn, this.rb7FV));
	}
	
	/** @param deriveFrom
	 * @return */
	public final BaseObject vmScopeCreateSandbox(final BaseObject deriveFrom) {
		
		return this.rb7FV = this.ri10GV = BaseObject.createObject(Base.seal(deriveFrom));
	}
	
	/** @param deriveFrom
	 * @return */
	public final BaseObject vmScopeDeriveContext(final BaseObject deriveFrom) {
		
		return this.rb7FV = this.ri10GV = BaseObject.createObject(deriveFrom);
	}
	
	/** @param process
	 * @return */
	public final BaseObject vmScopeDeriveContext(final ExecProcess process) {
		
		return this.rb7FV = this.ri10GV = BaseObject.createObject(process.rb7FV);
	}
	
	/** @return */
	public final BaseObject vmScopeDeriveContextFromFV() {
		
		final BaseObject prototype = this.rb7FV;
		return this.rb7FV = this.ri10GV = BaseObject.createObject(prototype);
	}
	
	/** @return */
	public final BaseObject vmScopeDeriveContextFromGV() {
		
		final BaseObject prototype = this.ri10GV;
		return this.rb7FV = this.ri10GV = BaseObject.createObject(prototype);
	}
	
	/** @return */
	public final BaseObject vmScopeDeriveLocals() {
		
		final BaseObject prototype = this.rb7FV;
		return this.rb7FV = BaseObject.createObject(prototype);
	}
	
	/** @param process
	 * @return */
	public final BaseObject vmScopeDeriveLocals(final ExecProcess process) {
		
		return this.rb7FV = BaseObject.createObject(this.ri10GV = process.rb7FV);
	}
	
	/** @param r7RR
	 * @return */
	public final ExecStateCode vmSetCallResult(final BaseObject r7RR) {
		
		return this.riCallResultHandler.execReturn(this, r7RR);
	}
	
	/** @param r7RR
	 * @return */
	public final ExecStateCode vmSetCallResultBoolean(final boolean r7RR) {
		
		return this.riCallResultHandler.execReturn(this, r7RR
			? BaseObject.TRUE
			: BaseObject.FALSE);
	}
	
	/** false - result
	 *
	 * @return */
	public final ExecStateCode vmSetCallResultFalse() {
		
		return this.riCallResultHandler.execReturn(this, BaseObject.FALSE);
	}
	
	/** null - result
	 *
	 * @return */
	public final ExecStateCode vmSetCallResultNull() {
		
		return this.riCallResultHandler.execReturn(this, BaseObject.NULL);
	}
	
	/** @param r7RR
	 * @return */
	public final ExecStateCode vmSetCallResultNumeric(final double r7RR) {
		
		return this.riCallResultHandler.execReturnNumeric(this, r7RR);
	}
	
	/** @param r7RR
	 * @return */
	public final ExecStateCode vmSetCallResultNumeric(final int r7RR) {
		
		return this.riCallResultHandler.execReturnNumeric(this, r7RR);
	}
	
	/** @param r7RR
	 * @return */
	public final ExecStateCode vmSetCallResultNumeric(final long r7RR) {
		
		return this.riCallResultHandler.execReturnNumeric(this, r7RR);
	}
	
	/** @param r7RR
	 * @return */
	public final ExecStateCode vmSetCallResultString(final String r7RR) {
		
		return this.riCallResultHandler.execReturnString(this, r7RR);
	}
	
	/** true - result
	 *
	 * @return */
	public final ExecStateCode vmSetCallResultTrue() {
		
		return this.riCallResultHandler.execReturn(this, BaseObject.TRUE);
	}
	
	/** undefined - result
	 *
	 * @return */
	public final ExecStateCode vmSetCallResultUndefined() {
		
		return this.riCallResultHandler.execReturn(this, BaseObject.UNDEFINED);
	}
	
	/** prepares special call, for next loop, and then repeat same instruction after call finished
	 *
	 * @param instructions
	 * @param start
	 * @param stop
	 * @return */
	public ExecStateCode vmSetResultCallRepeat(final Instruction[] instructions, final int start, final int stop) {
		
		final ExecProcessState state = this.fldState;
		assert state == RUN || state == CLL : "Wrong process state: " + state;
		
		this.fldState = CLL;
		
		this.fldCode = instructions;
		this.ri08IP = start;
		this.ri09IL = stop;
		this.ri0FI0 = start;
		return REPEAT;
	}
	
	final ExecStateCode vmSetResultVmDirectNumeric(final double r7RR) {
		
		{
			final BasePrimitiveNumber precached = Base.forDoublePrecachedOrNull(r7RR);
			if (precached != null) {
				this.ra0RB = precached;
				return null;
			}
		}
		if (ExecProcess.DBG_TMP_NODIRECT) {
			this.ra0RB = r7RR == (long) r7RR
				? new ValueStackLong((long) r7RR)
				: new ValueStackNumber(r7RR);
			return null;
		}
		{
			final ValueDirectNumber directNumber = this.rzDirectNumber;
			if (directNumber != null) {
				this.ra0RB = directNumber.setValue(r7RR);
				return null;
			}
		}
		this.ra0RB = this.rzDirectNumber = new ValueDirectNumber(r7RR);
		return null;
	}
	
	final ExecStateCode vmSetResultVmDirectNumeric(final int r7RR) {
		
		{
			final BasePrimitiveNumber precached = Base.forIntegerPrecachedOrNull(r7RR);
			if (precached != null) {
				this.ra0RB = precached;
				return null;
			}
		}
		if (ExecProcess.DBG_TMP_NODIRECT) {
			this.ra0RB = new ValueStackInteger(r7RR);
			return null;
		}
		{
			final ValueDirectInteger directInteger = this.rzDirectInteger;
			if (directInteger != null) {
				this.ra0RB = directInteger.setValue(r7RR);
				return null;
			}
		}
		this.ra0RB = this.rzDirectInteger = new ValueDirectInteger(r7RR);
		return null;
	}
	
	final ExecStateCode vmSetResultVmDirectNumeric(final long r7RR) {
		
		{
			final BasePrimitiveNumber precached = Base.forLongPrecachedOrNull(r7RR);
			if (precached != null) {
				this.ra0RB = precached;
				return null;
			}
		}
		if (ExecProcess.DBG_TMP_NODIRECT) {
			this.ra0RB = new ValueStackLong(r7RR);
		}
		{
			final ValueDirectLong directLong = this.rzDirectLong;
			if (directLong != null) {
				this.ra0RB = directLong.setValue(r7RR);
				return null;
			}
		}
		this.ra0RB = this.rzDirectLong = new ValueDirectLong(r7RR);
		return null;
	}
	
	final ExecStateCode vmSetResultVmDirectString(final String r7RR) {
		
		{
			final BasePrimitiveString precached = Base.forStringPrecachedOrNull(r7RR);
			if (precached != null) {
				this.ra0RB = precached;
				return null;
			}
		}
		if (ExecProcess.DBG_TMP_NODIRECT) {
			this.ra0RB = new ValueStackString(r7RR);
			return null;
		}
		{
			final ValueDirectString directString = this.rzDirectString;
			if (directString != null) {
				this.ra0RB = this.rzDirectString.setValue(r7RR);
				return null;
			}
		}
		this.ra0RB = this.rzDirectString = new ValueDirectString(r7RR);
		return null;
	}
	
	final ExecStateCode vmSetResultVmStackNumeric(final double r7RR) {
		
		{
			final BasePrimitiveNumber precached = Base.forDoublePrecachedOrNull(r7RR);
			if (precached != null) {
				this.ra0RB = precached;
				return null;
			}
		}
		this.ra0RB = r7RR == (long) r7RR
			? new ValueStackLong((long) r7RR)
			: new ValueStackNumber(r7RR);
		return null;
	}
	
	final ExecStateCode vmSetResultVmStackNumeric(final int r7RR) {
		
		{
			final BasePrimitiveNumber precached = Base.forIntegerPrecachedOrNull(r7RR);
			if (precached != null) {
				this.ra0RB = precached;
				return null;
			}
		}
		this.ra0RB = new ValueStackInteger(r7RR);
		return null;
	}
	
	final ExecStateCode vmSetResultVmStackNumeric(final long r7RR) {
		
		{
			final BasePrimitiveNumber precached = Base.forLongPrecachedOrNull(r7RR);
			if (precached != null) {
				this.ra0RB = precached;
				return null;
			}
		}
		this.ra0RB = new ValueStackLong(r7RR);
		return null;
	}
	
	final ExecStateCode vmSetResultVmStackString(final String r7RR) {
		
		{
			final BasePrimitiveString precached = Base.forStringPrecachedOrNull(r7RR);
			if (precached != null) {
				this.ra0RB = precached;
				return null;
			}
		}
		this.ra0RB = new ValueStackString(r7RR);
		return null;
	}
	
	/** SB equals stackBase after this call.
	 *
	 * @param resultCode
	 * @param stackBase
	 * @param inline
	 *            TODO
	 * @return */
	public final ExecStateCode vmStateFinalizeFrames(final ExecStateCode resultCode, final int stackBase, final boolean inline) {
		
		run : for (ExecStateCode code = resultCode;;) {
			if (this.ri0BSB <= stackBase) {
				/** <code>
				new Error().printStackTrace();
				System.err.println(">>>> >>> FFNX(" + this.ri0BSB + " | " + this.ri0ASP + " | " + stackBase + "), code: " + code + ", state: " + this.fldState);
					</code> */
				
				return inline && code == NEXT
					? null
					: code;
			}
			if (code == null) {
				/** <code>
				System.err.println(">>>> >>> FFFU(" + this.ri0BSB + " | " + this.ri0ASP + " | " + stackBase + "), code: " + code + ", state: " + this.fldState);
				</code> */
				final ExecStateCode codeUp = this.frameUp(code);
				if (codeUp != null && codeUp != NEXT) {
					code = codeUp;
					continue run;
				}
				// keep code = null
				continue run;
			}
			if (code == REPEAT) {
				repeat : for (;;) {
					/** <code>
					new Error().printStackTrace();
					System.err.println(">>>> >>> FFRE(" + this.ri0BSB + " | " + this.ri0ASP + " | " + stackBase + "), code: " + code + ", state: " + this.fldState);
					</code> */
					final ExecStateCode blockCode = this.runImpl(stackBase);
					/** <code>
					System.err.println(">>>> >>> FFR2(" + this.ri0BSB + " | " + this.ri0ASP + " | " + stackBase + "), code: " + blockCode + ", state: " + this.fldState);
					</code> */
					if (blockCode == REPEAT) {
						if (this.ri0BSB <= stackBase) {
							/** <code>
							System.err.println(">>>> >>> FFRX(" + this.ri0BSB + " | " + this.ri0ASP + " | " + stackBase + "),  code: " + code + ", state: " + this.fldState);
							</code> */
							return code;
						}
						continue repeat;
					}
					code = blockCode;
					continue run;
				}
			}
			if (code == RETURN) {
				/** <code>
				System.err.println(">>> >>>> FFRN(" + this.ri0BSB + " | " + this.ri0ASP + " | " + stackBase + "), code: " + code + ", state: " + this.fldState);
				</code> */
				final ExecStateCode codeUp = this.frameUp(code);
				if (codeUp != null && codeUp != NEXT) {
					code = codeUp;
					continue run;
				}
				// keep code = return
				continue run;
			}
			if (code == NEXT) {
				/** <code>
				System.err.println(">>>> >>> FFNN(" + this.ri0BSB + " | " + this.ri0ASP + " | " + stackBase + "), code: " + code + ", state: " + this.fldState);
				</code> */
				final ExecStateCode codeUp = this.frameUp(null);
				if (codeUp != null && codeUp != NEXT) {
					code = codeUp;
					continue run;
				}
				code = null;
				continue run;
			}
			if (code == ERROR) {
				/** <code>
				System.err.println(">>> >>>> FFFE(" + this.ri0BSB + " | " + this.ri0ASP + " | " + stackBase + "), code: " + code + ", state: " + this.fldState);
				</code> */
				final ExecStateCode codeUp = this.frameUp(code);
				if (codeUp != null && codeUp != NEXT) {
					code = codeUp;
					continue run;
				}
				// keep code = error
				continue run;
			}
			{
				this.ri0BSB = this.ri0ASP = stackBase;
				return this.vmRaise("Invalid state for call: " + code);
			}
		}
	}
	
	/** @param code
	 * @throws BaseAbstractException */
	public final void vmStateToErrorOrSilence(final ExecStateCode code) throws BaseAbstractException {
		
		if (code == null) {
			return;
		}
		if (code == RETURN || code == NEXT) {
			return;
		}
		if (code == BREAK) {
			throw this.throwError("break without target!", null);
		}
		if (code == CONTINUE) {
			throw this.throwError("continue without target!", null);
		}
		if (code == ERROR) {
			final BaseObject result = this.ra0RB;
			throw result instanceof Throwable
				? this.throwError(result, (Throwable) result)
				: Exec.createThrown(result, this.riDebug, this.riDebug);
		}
		throw this.throwError("Unknown state for inline finisher: " + code, null);
	}
	
	/** Throws (not an error but) a given object. (Much like 'throw o')
	 *
	 * @param o
	 * @return */
	public final ExecStateCode vmThrow(final BaseObject o) {
		
		this.ra0RB = o;
		return ERROR;
	}
}
