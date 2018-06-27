/*
 * Created on 19.04.2006
 */
package ru.myx.ae3.flow;

import java.util.function.Function;

final class SourceCloserFunction implements Function<ObjectTarget<?>, Object> {
	@Override
	public final Object apply(final ObjectTarget<?> o) {
		o.close();
		return null;
	}
}
