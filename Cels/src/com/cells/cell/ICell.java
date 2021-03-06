/**
 * @project Cels
 * @package com.cells.cell
 * @file ICell.java
 * @author Norbi
 * @since Nov 9, 2014 12:14:55 AM
 */
package com.cells.cell;

/**
 * @author Norbi
 */
public interface ICell extends Runnable{

	/**
	 * Describes what the cell behavior on moving 
	 */
	public void move();
	
	/**
	 * Describes the thread behavior on eating
	 * @return boolean - true on success, false on error
	 */
	public boolean eat();
	
	/**
	 * Describe what to do when the cell is left without food
	 */
	public void die();
	
	/**
	 * Method called when a cell is ready for multiplication
	 */
	public void onReadyForMultiplication();
	
	/**
	 * Called by register after multiplication completed
	 */
	public void afterMultiplication();
}
