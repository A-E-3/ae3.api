package ru.myx.ae3.help;

import ru.myx.ae3.base.BaseObject;

abstract class AbstractFormatDescribeImpl {
	
	abstract StringBuilder toEcmaSource(StringBuilder builder, BaseObject o, String prefix, int ident, int depth, int limit);
	
	abstract StringBuilder toDescription(StringBuilder builder, BaseObject o, String prefix, int ident, int depth, int limit);
}
