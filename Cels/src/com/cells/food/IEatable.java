package com.cells.food;

/**
 * Interface for a food type.
 * 
 * @author <a href="mailto:groza.claudiu@icloud.com">Claudiu Groza</a>
 *
 */
public interface IEatable {
	/**
	 * Simulate the eating task.
	 * 
	 * @return
	 * 		<code> true </code> if succeeded,<code> false </code> otherwise
	 * @throws InterruptedException 
	 */
	boolean eat() throws InterruptedException;
	
	/**
	 * Simulate supplementing the food stock task.
	 * 
	 * @param supplementStock
	 * 			the value with stock is supplemented
	 * @return
	 * 		<code> true </code> if succeeded,<code> false </code> otherwise
	 */
	boolean supplement(long supplementStock);
}
