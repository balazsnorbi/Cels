package com.cells.food;

import net.jcip.annotations.NotThreadSafe;

/**
 * Abstract class for classes that work with food stock number.
 * 
 * For concurrent use, the subclasses must implement the synchronize policy.
 * 
 * @author <a href="mailto:groza.claudiu@icloud.com">Claudiu Groza</a>
 *
 */
@NotThreadSafe
abstract class AbstractFood implements IEatable {
	protected long foodStock = 0;

	@Override
	public abstract boolean eat() throws InterruptedException;

	@Override
	public abstract boolean supplement(long supplementStock);
	
	/**
	 * 
	 * @return
	 * 		<code> true </code> if the food stock is enough,<code> false </code> otherwise
	 */
	protected boolean isFoodAvailable() {
		return (foodStock > 0 ? true : false);
	}
}
