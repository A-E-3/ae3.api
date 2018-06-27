package ru.myx.ae3.l2;

/**
 * @author myx
 * 
 * @param <T>
 *            target (TargetContext)
 * @param <L>
 *            layout type
 */
public interface ContextHandler<T, L> {
	/**
	 * When execution context is entering
	 * 
	 * @param target
	 * @param layout
	 * @return
	 */
	public L onEnter(
			final T target,
			final L layout);
	
	
	/**
	 * When execution context is leaving
	 * 
	 * @param target
	 * 
	 */
	public void onLeave(
			final T target);
	
	
	/**
	 * When new child element is going to be considered.
	 * 
	 * Replace or return the same.
	 * 
	 * @param target
	 * @param layout
	 * @return
	 */
	public L onNest(
			final T target,
			final L layout);
}
