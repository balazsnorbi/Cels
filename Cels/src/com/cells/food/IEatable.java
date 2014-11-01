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
	 */
	boolean eat();
	
	/**
	 * Simulate the supplemeting the food stock task.
	 * 
	 * @return
	 */
	boolean supplement(long supplementStock);
}
