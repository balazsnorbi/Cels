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
	 * 		<code> true </code> if the simulation had success,<code> false </code> otherwise
	 */
	boolean eat();
	
	/**
	 * Simulate supplementing the food stock task.
	 * 
	 * @return
	 * 		<code> true </code> if the simulation had success,<code> false </code> otherwise
	 */
	boolean supplement(long supplementStock);
}
