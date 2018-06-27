package ru.myx.ae3.base;

import ru.myx.ae3.exec.ExecCallable;
import ru.myx.ae3.exec.ExecProcess;
import ru.myx.ae3.exec.ExecStateCode;
import ru.myx.ae3.exec.ResultHandler;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.ae3.reflect.ReflectionHidden;

/**
 * The sole need for this class is in that we support both 'a'.length and
 * 'a'.length() access types
 *
 * @author myx
 *
 */
@ReflectionDisable
final class PrimitiveStringLengthValue extends Number
		implements ///
			BaseNumber<Number>,
			BasePrimitive<Number>,
			ExecCallable.ForNumbers.UseIntJ0,
			ExecCallable.ForVoid.UseIntJ0,
			ExecCallable.ForString.UseIntJ0,
			ExecCallable.ForNative.UseNativeJ0,
			ExecCallable.ForStore.UseStore0,
			BaseObjectNoOwnProperties {
	
	private static final PrimitiveStringLengthValue[] CACHE;

	private static final BaseFunction LENGTH_FUNCTION = new PrimitiveStringLengthMethod();
	/**
	 *
	 */
	private static final long serialVersionUID = 5309898230360619796L;

	static {
		CACHE = new PrimitiveStringLengthValue[128];
		for (int i = 0; i < 128; ++i) {
			PrimitiveStringLengthValue.CACHE[i] = new PrimitiveStringLengthValue(i);
		}
	}

	static final PrimitiveStringLengthValue getLengthValue(final int length) {
		
		assert length >= 0 : "Negative string length?";
		if (length < 128) {
			return PrimitiveStringLengthValue.CACHE[length];
		}
		return new PrimitiveStringLengthValue(length);
	}

	private final BasePrimitiveNumber value;

	private PrimitiveStringLengthValue(final int length) {

		this.value = Base.forInteger(length);
	}

	@Override
	public BaseFunction baseCall() {
		
		return PrimitiveStringLengthValue.LENGTH_FUNCTION;
	}

	@Override
	public final BaseProperty baseFindProperty(final BasePrimitiveString name) {
		
		return this.value.baseFindProperty(name);
	}

	@Override
	public final BaseProperty baseFindProperty(final BasePrimitiveString name, final BaseObject stop) {
		
		return this.value.baseFindProperty(name, stop);
	}

	@Override
	public final BaseProperty baseFindProperty(final String name) {
		
		return this.value.baseFindProperty(name);
	}
	@Override
	public final BaseProperty baseFindProperty(final String name, final BaseObject stop) {
		
		return this.value.baseFindProperty(name, stop);
	}

	@Override
	public BaseObject baseGet(final BasePrimitiveString name, final BaseObject defaultValue) {
		
		return this.value.baseGet(name, defaultValue);
	}

	@Override
	public BaseObject baseGet(final String name, final BaseObject defaultValue) {
		
		return this.value.baseGet(name, defaultValue);
	}

	@Override
	public boolean baseIsPrimitiveInteger() {
		
		return true;
	}

	@Override
	public boolean baseIsPrimitiveNumber() {
		
		return true;
	}

	@Override
	public BasePrimitiveBoolean baseToBoolean() {
		
		return this.value.baseToBoolean();
	}

	@Override
	public BasePrimitiveNumber baseToInt32() {
		
		return this.value.baseToInt32();
	}

	@Override
	public BasePrimitiveNumber baseToInteger() {
		
		return this.value.baseToInteger();
	}

	@Override
	@ReflectionHidden
	public int baseToJavaInteger() {
		
		return this.value.intValue();
	}

	@Override
	@ReflectionHidden
	public long baseToJavaLong() {
		
		return this.value.longValue();
	}

	@Override
	@ReflectionHidden
	public boolean baseToJavaBoolean() {
		
		return this.value.baseToJavaBoolean();
	}

	@Override
	@ReflectionHidden
	public String baseToJavaString() {
		
		return this.value.baseToJavaString();
	}

	@Override
	public BasePrimitiveNumber baseToNumber() {
		
		return this.value;
	}

	@SuppressWarnings("deprecation")
	@Override
	public BasePrimitiveNumber baseToPrimitive(final ToPrimitiveHint hint) {
		
		return this.value;
	}

	@Override
	public BasePrimitiveString baseToString() {
		
		return this.value.baseToString();
	}

	@Override
	public final BasePrimitiveString baseToStringIfReady() {
		
		return this.value.baseToStringIfReady();
	}

	@Override
	public Number baseValue() {
		
		return this.value.baseValue();
	}

	@Override
	public double doubleValue() {
		
		return this.value.doubleValue();
	}

	@Override
	public boolean equals(final Object obj) {
		
		return this.value.equals(obj);
	}

	@Override
	public int callIJ0(final BaseObject instance) {
		
		return this.baseToJavaInteger();
	}

	@Override
	public ExecStateCode execCallPrepare(final ExecProcess ctx, final BaseObject instance, final ResultHandler store, final boolean inline) {
		
		return store.execReturn(ctx, this.value);
	}

	@Override
	public long callLE0(final ExecProcess ctx, final BaseObject instance) {
		
		return this.value.baseToJavaLong();
	}

	@Override
	public long callLJ0(final BaseObject instance) {
		
		return this.value.baseToJavaLong();
	}

	@Override
	public BaseObject callNE0(final ExecProcess ctx, final BaseObject instance) {
		
		return this.value;
	}

	@Override
	public BaseObject callNJ0(final BaseObject instance) {
		
		return this.value;
	}

	@Override
	public boolean execIsConstant() {
		
		return true;
	}

	@Override
	public Class<? extends Number> execResultClassJava() {
		
		return Number.class;
	}

	@Override
	public BaseObject execScope() {
		
		/**
		 * executes in real current scope
		 */
		return ExecProcess.GLOBAL;
	}

	@Override
	public float floatValue() {
		
		return this.value.floatValue();
	}

	@Override
	public int hashCode() {
		
		return this.value.hashCode();
	}

	@Override
	public int intValue() {
		
		return this.value.intValue();
	}

	@Override
	public long longValue() {
		
		return this.value.longValue();
	}

	@Override
	public String stringValue() {
		
		return this.value.stringValue();
	}

	@Override
	public String toString() {
		
		return this.value.toString();
	}

	@Override
	public ExecStateCode vmPropertyRead(final ExecProcess ctx, final BasePrimitiveString name, final BaseObject defaultValue, final ResultHandler store) {
		
		return this.value.vmPropertyRead(ctx, name, defaultValue, store);
	}

	@Override
	public ExecStateCode vmPropertyRead(final ExecProcess ctx, final String name, final BaseObject defaultValue, final ResultHandler store) {
		
		return this.value.vmPropertyRead(ctx, name, defaultValue, store);
	}

}
