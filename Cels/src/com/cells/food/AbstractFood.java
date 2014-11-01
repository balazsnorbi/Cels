package com.cells.food;

/**
 * Abstract class for classes that work with food stock number.
 * 
 * @author <a href="mailto:groza.claudiu@icloud.com">Claudiu Groza</a>
 *
 */
public abstract class AbstractFood implements IEatable {
	protected long foodStock = 0;

	@Override
	public abstract boolean eat();

	@Override
	public abstract boolean supplement(long supplementStock);
	
	/**
	 * 
	 * @return
	 * 		<code> true </code> if the food stock is enough,<code> false </code> otherwise
	 */
	protected boolean isAvailableFood() {
		return (foodStock > 0 ? true : false);
	}
}
