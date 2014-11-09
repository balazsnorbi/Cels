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
	 */
	public void eat();
	
	/**
	 * Describe what to do when the cell is left without food
	 */
	public void die();
}
