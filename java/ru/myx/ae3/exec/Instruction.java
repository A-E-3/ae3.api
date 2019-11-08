/*
 * Created on 05.05.2006
 */
package ru.myx.ae3.exec;

import ru.myx.ae3.base.BaseObjectNominal;

/** @author myx */
public interface Instruction extends BaseObjectNominal {

	/** @param name
	 * @param length
	 * @return */
	static String pad(final String name, final int length) {

		int add = length - name.length();
		if (add < 0) {
			return name.substring(0, length);
		}
		if (add <= 0) {
			return name;
		}
		final StringBuilder builder = new StringBuilder(length);
		builder.append(name);
		for (; add > 0; add--) {
			builder.append(' ');
		}
		return builder.toString();
	}

	/** @param constant
	 * @return */
	static String padCONSTANT(final int constant) {

		return Instruction.pad(String.valueOf(constant), 10);
	}

	/** {A|X|V|Z}{A|B|C|E|F|I|M|T}XXXX_{I|T|D|N|U}(A|I|S)*
	 *
	 * 1st part:
	 * <ul>
	 * <li>A - abstract instruction (implementation detail)</li>
	 * <li>X - standard instruction (recommended set)</li>
	 * <li>V - virtual (runtime optimization)</li>
	 * <li>Z - extra instruction (VM extension)</li>
	 * </ul>
	 *
	 * 2nd part:
	 * <ul>
	 * <li>A - access (reference resolution)</li>
	 * <li>B - boolean logical operation</li>
	 * <li>C - object creation or type conversion (CVT...)</li>
	 * <li>E - execution flow control operation</li>
	 * <li>F - frame access (execution scope reference resolution)</li>
	 * <li>I - iteration</li>
	 * <li>M - mathematical or bitwise (MB...) operation</li>
	 * <li>T - 'this' access ('this' object property resolution)</li>
	 * </ul>
	 *
	 * <b>XXXX - operation name</b>
	 *
	 * 3rd part:
	 * <ul>
	 * <li>F - floating temp result. The result may be a 'context direct' type instance as the
	 * result of calculations implementation.</li>
	 * <li>I - integer temp result. The result may be a 'context direct' type instance as the result
	 * of calculations implementation.</li>
	 * <li>T - temp/ctx result. The result may be a 'context direct' type instance as the result of
	 * calculations implementation.</li>
	 * <li>P - pass-through result. The result may be a 'context direct' type instance because
	 * instruction doesn't alter the result).</li>
	 * <li>D - stack result optimization. The result may be a 'stack storage compatible wrapped
	 * value' (either as the result of calculations implementation, either because the conversion of
	 * 'T'-type result to 'S'-type result is enforced)</li>
	 * <li>N - native result. The result is guaranteed to be normal native base object or primitive
	 * (either as the result of calculations implementation, either because the conversion of
	 * 'T'-type or 'S'-type result to 'N'-type result is enforced)</li>
	 * <li>U - 'no result' optimization</li>
	 * </ul>
	 *
	 *
	 * 4th part ('virtual' only) (can repeat for each argument (0-3 times)):
	 * <ul>
	 * <li>A - any input</li>
	 * <li>I - integer input</li>
	 * <li>S - character input</li>
	 * </ul>
	 *
	 * @param name
	 * @return */
	static String padOPCODE(final String name) {

		return Instruction.pad(name, 12);
	}

	/** null - instruction finished normally.
	 *
	 * @param process
	 * @return state code
	 * @throws Exception */
	ExecStateCode execCall(final ExecProcess process) throws Exception;

	/** @return */
	default int getConstant() {

		return 0;
	}

	/** The number of arguments needed in stack to fill in arguments.
	 *
	 * @return int */
	int getOperandCount();

	/** The number of results this instruction will push into the stack.
	 *
	 * @return int */
	int getResultCount();

	/** Only for good code dumps. Doesn't affect execution and compilation at all.
	 *
	 * @return */
	default boolean isRelativeAddressInConstant() {

		return false;
	}

	/** String of code to be materializable.
	 *
	 * @return string */
	String toCode();

}
