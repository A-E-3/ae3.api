package ru.myx.ae3.base;

import java.util.Iterator;

import ru.myx.ae3.common.Value;
import ru.myx.ae3.exec.ExecCallable;
import ru.myx.ae3.reflect.ReflectionDisable;
import ru.myx.util.IteratorSingle;

/** @author myx */
@ReflectionDisable
public abstract class BaseFunctionAbstract extends BaseWrapObjectAbstract<ExecCallable> implements BaseFunction {
	
	/**
	 *
	 */
	public static final String PROTOTYPE_PROPERTY_JAVA_NAME;
	
	/**
	 *
	 */
	public static final int PROTOTYPE_PROPERTY_LENGTH;
	
	static {
		assert BaseString.STR_PROTOTYPE == Base.forString("prototype") : "Should return the same instance!";
		PROTOTYPE_PROPERTY_JAVA_NAME = BaseString.STR_PROTOTYPE.baseValue();
		PROTOTYPE_PROPERTY_LENGTH = BaseFunctionAbstract.PROTOTYPE_PROPERTY_JAVA_NAME.length();
	}
	
	/** BaseFunction.PROTOTYPE */
	protected BaseFunctionAbstract() {
		
		super(BaseFunction.PROTOTYPE);
	}
	
	/** Use default construction for default function prototype
	 *
	 * @param prototype */
	protected BaseFunctionAbstract(final BaseObject prototype) {
		
		super(prototype);
	}
	
	@Override
	public String baseClass() {
		
		return "function";
	}
	
	@Override
	public BaseFunction baseConstruct() {
		
		return this;
	}
	
	@Override
	public boolean baseDefine(final BasePrimitiveString name, final BaseObject value, final short attributes) {
		
		/** in hope of reducing the amount of created objects. not all functions have their
		 * properties accessed, except constructors and ones getting in error messages. */
		if (this.properties == null) {
			synchronized (this) {
				if (this.properties == null) {
					if (BaseString.STR_PROTOTYPE == name) {
						this.properties = BaseProperties.createFirstProperty(//
								name,
								value,
								(short) (attributes & ~BaseProperty.ATTR_DYNAMIC)//
						);
						return true;
					}
					this.properties = BaseProperties.createFirstProperty(//
							BaseString.STR_PROTOTYPE,
							BaseObject.createObject(),
							BaseProperty.ATTRS_MASK_WEN//
					);
				}
			}
		}
		return super.baseDefine(name, value, attributes);
	}
	
	@Override
	public boolean baseDefine(final String name, final BaseObject value, final short attributes) {
		
		/** in hope of reducing the amount of created objects. not all functions have their
		 * properties accessed, except constructors and ones getting in error messages. */
		if (this.properties == null) {
			synchronized (this) {
				if (this.properties == null) {
					if (BaseFunctionAbstract.PROTOTYPE_PROPERTY_JAVA_NAME.equals(name)) {
						this.properties = BaseProperties.createFirstProperty(//
								name,
								value,
								(short) (attributes & ~BaseProperty.ATTR_DYNAMIC)//
						);
						return true;
					}
					this.properties = BaseProperties.createFirstProperty(//
							BaseString.STR_PROTOTYPE,
							BaseObject.createObject(),
							BaseProperty.ATTRS_MASK_WEN//
					);
				}
			}
		}
		return super.baseDefine(name, value, attributes);
	}
	
	@Override
	public BaseProperty baseGetOwnProperty(final BasePrimitiveString name) {
		
		/** in hope of reducing the amount of created objects. not all functions have their
		 * properties accessed, except constructors and ones getting in error messages. */
		if (this.properties == null && BaseString.STR_PROTOTYPE == name) {
			synchronized (this) {
				if (this.properties == null) {
					this.properties = BaseProperties.createFirstProperty(//
							name,
							BaseObject.createObject(),
							BaseProperty.ATTRS_MASK_WEN//
					);
				}
			}
		}
		return super.baseGetOwnProperty(name);
	}
	
	@Override
	public BaseProperty baseGetOwnProperty(final String name) {
		
		/** in hope of reducing the amount of created objects. not all functions have their
		 * properties accessed, except constructors and ones getting in error messages. */
		if (this.properties == null && BaseFunctionAbstract.PROTOTYPE_PROPERTY_JAVA_NAME.equals(name)) {
			synchronized (this) {
				if (this.properties == null) {
					this.properties = BaseProperties.createFirstProperty(//
							BaseString.STR_PROTOTYPE,
							BaseObject.createObject(),
							BaseProperty.ATTRS_MASK_WEN//
					);
				}
			}
		}
		return super.baseGetOwnProperty(name);
	}
	
	@Override
	public Iterator<? extends CharSequence> baseKeysOwnAll() {
		
		/** in hope of reducing the amount of created objects. not all functions have their
		 * properties accessed, except constructors and ones getting in error messages. */
		if (this.properties == null) {
			return new IteratorSingle<>(BaseFunctionAbstract.PROTOTYPE_PROPERTY_JAVA_NAME);
		}
		return super.baseKeysOwnAll();
	}
	
	@Override
	public BasePrimitiveString baseToString() {
		
		return Base.forString(this.toString());
	}
	
	@Override
	public final ExecCallable baseValue() {
		
		return this;
	}
	
	@Override
	public boolean equals(final Object o) {
		
		if (o == this) {
			return true;
		}
		if (o instanceof Value<?>) {
			final Object base = ((Value<?>) o).baseValue();
			return base != o && this.equals(base);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		
		return System.identityHashCode(this);
	}
	
	@Override
	public String toString() {
		
		return "[Function " + this.baseValue().getClass().getSimpleName() + ']';
	}
	
}
