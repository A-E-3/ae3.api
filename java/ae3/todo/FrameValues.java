package ae3.todo;

/**
 * Implement on FV register values, allow %CODE: 'ACM.ECMA' % in TPL to write to
 * TPL variables' scope. Fail when pure ECMA code makes illegal variable access.
 * 
 * @author myx
 * 
 */
public interface FrameValues {
	/**
	 * When non-existing variable is being written, the behaviour depends on
	 * whether given scope is dynamic or not. For non-dynamic scopes, the
	 * exception 'variable is not defined' is produced. Otherwise new binding
	 * will be created.
	 * 
	 * @return
	 */
	public boolean isDynamic();
}
