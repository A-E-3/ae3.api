package ru.myx.ae3.exec.dynamic;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.base.BasePrimitive;
import ru.myx.ae3.base.BasePrimitiveString;
import ru.myx.ae3.base.ToPrimitiveHint;
import ru.myx.ae3.e4.vm.VmContext;

/**
 *
 * Lexical context scope interface
 *
 * @author myx
 *
 */
public interface ExecLexicalScope extends VmContext {
	
	
	/**
	 * Create a new mutable binding in an environment record. The String value N
	 * is the text of the bound name. If the optional Boolean argument D is true
	 * the binding is may be subsequently deleted.
	 *
	 * @param name
	 *            property name
	 * @param value
	 *            initial value
	 * @param dynamic
	 */
	default void contextCreateMutableBinding(final BaseObject name, final BaseObject value, final boolean dynamic) {
		
		
		if (name instanceof BasePrimitiveString) {
			this.contextCreateMutableBinding((BasePrimitiveString) name, value, dynamic);
			return;
		}

		if (name instanceof CharSequence) {
			this.contextCreateMutableBinding(name.toString(), value, dynamic);
			return;
		}
		
		final BasePrimitive<?> primitiveName = name.baseToPrimitive(ToPrimitiveHint.STRING);
		final BasePrimitiveString identity = primitiveName.baseToStringIfReady();
		if (identity != null) {
			this.contextCreateMutableBinding(identity, value, dynamic);
			return;
		}

		this.contextCreateMutableBinding(primitiveName.baseToJavaString(), value, dynamic);
		return;
	}

	/**
	 * Create a new mutable binding in an environment record. The String value N
	 * is the text of the bound name. If the optional Boolean argument D is true
	 * the binding is may be subsequently deleted.
	 *
	 * @param name
	 *            property name
	 * @param value
	 *            initial value
	 * @param dynamic
	 */
	void contextCreateMutableBinding(BasePrimitiveString name, BaseObject value, boolean dynamic);

	/**
	 * Create a new mutable binding in an environment record. The String value N
	 * is the text of the bound name. If the optional Boolean argument D is true
	 * the binding is may be subsequently deleted.
	 *
	 * @param name
	 *            property name
	 * @param value
	 *            initial value
	 * @param dynamic
	 */
	void contextCreateMutableBinding(String name, BaseObject value, boolean dynamic);

	/**
	 * Create a new mutable binding in an environment record. The String value N
	 * is the text of the bound name. If the optional Boolean argument D is true
	 * the binding is may be subsequently deleted.
	 *
	 * @param name
	 *            property name
	 * @param value
	 *            initial value
	 * @param dynamic
	 */
	default void contextCreateMutableBinding(final String name, final int value, final boolean dynamic) {
		
		
		this.contextCreateMutableBinding(name, Base.forInteger(value), dynamic);
	}

	/**
	 * Create a new mutable binding in an environment record. The String value N
	 * is the text of the bound name. If the optional Boolean argument D is true
	 * the binding is may be subsequently deleted.
	 *
	 * @param name
	 *            property name
	 * @param value
	 *            initial value
	 * @param dynamic
	 */
	default void contextCreateMutableBinding(final String name, final String value, final boolean dynamic) {
		
		
		this.contextCreateMutableBinding(name, Base.forString(value), dynamic);
	}

	/**
	 * DeleteBinding(N)
	 *
	 * Delete a binding from an environment record. The String value N is the
	 * text of the bound name If a binding for N exists, remove the binding and
	 * return true. If the binding exists but cannot be removed return false. If
	 * the binding does not exist return true.
	 *
	 * @param name
	 * @return
	 */
	boolean contextDeleteBinding(String name);

	/**
	 * GetBindingValue(N,S)
	 *
	 * Returns the value of an already existing binding from an environment
	 * record. The String value N is the text of the bound name. S is used to
	 * identify strict mode references. If S is true and the binding does not
	 * exist or is uninitialized throw a ReferenceError exception.
	 *
	 * @param name
	 * @param strict
	 * @return
	 */
	BaseObject contextGetBindingValue(BasePrimitiveString name, boolean strict);

	/**
	 * GetBindingValue(N,S)
	 *
	 * Returns the value of an already existing binding from an environment
	 * record. The String value N is the text of the bound name. S is used to
	 * identify strict mode references. If S is true and the binding does not
	 * exist or is uninitialized throw a ReferenceError exception.
	 *
	 * @param name
	 * @param strict
	 * @return
	 */
	BaseObject contextGetBindingValue(String name, boolean strict);

	/**
	 * Determine if an environment record has a binding for an identifier.
	 * Return true if it does and false if it does not. The String value N is
	 * the text of the identifier.
	 *
	 * @param name
	 * @return
	 */
	boolean contextHasBinding(String name);

	/**
	 * ImplicitThisValue()
	 *
	 * Returns the value to use as the this value on calls to function objects
	 * that are obtained as binding values from this environment record.
	 *
	 * @return
	 */
	BaseObject contextImplicitThisValue();

	/**
	 * SetMutableBinding(N, V, S)
	 *
	 * Set the value of an already existing mutable binding in an environment
	 * record. The String value N is the text of the bound name. V is the value
	 * for the binding and may be a value of any ECMAScript language type. S is
	 * a Boolean flag. If S is true and the binding cannot be set throw a
	 * TypeError exception. S is used to identify strict mode references.
	 *
	 * @param name
	 * @param value
	 * @param strict
	 * @return
	 */
	default boolean contextSetMutableBinding(final BaseObject name, final BaseObject value, final boolean strict) {
		
		
		if (name instanceof BasePrimitiveString) {
			return this.contextSetMutableBinding((BasePrimitiveString) name, value, strict);
		}

		if (name instanceof CharSequence) {
			return this.contextSetMutableBinding(name.toString(), value, strict);
		}
		
		final BasePrimitive<?> primitiveName = name.baseToPrimitive(ToPrimitiveHint.STRING);
		final BasePrimitiveString identity = primitiveName.baseToStringIfReady();
		return identity != null
			? this.contextSetMutableBinding(identity, value, strict)
			: this.contextSetMutableBinding(primitiveName.baseToJavaString(), value, strict);
	}

	/**
	 * SetMutableBinding(N, V, S)
	 *
	 * Set the value of an already existing mutable binding in an environment
	 * record. The String value N is the text of the bound name. V is the value
	 * for the binding and may be a value of any ECMAScript language type. S is
	 * a Boolean flag. If S is true and the binding cannot be set throw a
	 * TypeError exception. S is used to identify strict mode references.
	 *
	 * @param name
	 * @param value
	 * @param strict
	 * @return
	 */
	boolean contextSetMutableBinding(BasePrimitiveString name, BaseObject value, boolean strict);

	/**
	 * SetMutableBinding(N, V, S)
	 *
	 * Set the value of an already existing mutable binding in an environment
	 * record. The String value N is the text of the bound name. V is the value
	 * for the binding and may be a value of any ECMAScript language type. S is
	 * a Boolean flag. If S is true and the binding cannot be set throw a
	 * TypeError exception. S is used to identify strict mode references.
	 *
	 * @param name
	 * @param value
	 * @param strict
	 * @return
	 */
	boolean contextSetMutableBinding(String name, BaseObject value, boolean strict);

	/**
	 * SetMutableBinding(N, V, S)
	 *
	 * Set the value of an already existing mutable binding in an environment
	 * record. The String value N is the text of the bound name. V is the value
	 * for the binding and may be a value of any ECMAScript language type. S is
	 * a Boolean flag. If S is true and the binding cannot be set throw a
	 * TypeError exception. S is used to identify strict mode references.
	 *
	 * @param name
	 * @param value
	 * @param strict
	 */
	default void contextSetMutableBinding(final String name, final String value, final boolean strict) {
		
		
		this.contextSetMutableBinding(name, Base.forString(value), strict);
	}
}
