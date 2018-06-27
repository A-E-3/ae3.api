/**
 *
 */
package ru.myx.ae3.exec;

/**
 * @author myx
 *
 */
public interface NamedToIndexMapper {
	
	
	/**
	 *
	 * @return
	 */
	int length();

	/**
	 * @return int
	 */
	default int nameCount() {
		
		
		return this.names().length;
	}

	/**
	 * @param key
	 * @return index, -1 when not found
	 */
	default int nameIndex(final String key) {
		
		int i = 0;
		for (final String name : this.names()) {
			if (name.equals(key)) {
				return i;
			}
			++i;
		}
		return -1;
	}

	/**
	 * @param nameIndex
	 *            the index of the name in names() array
	 * @return index, -1 when not found
	 */
	int nameIndex(final int nameIndex);

	/**
	 * @return array
	 */
	String[] names();

}
