/**
 * @project Cels
 * @package com.cells.cell
 * @file ConcreteCell.java
 * @author Norbi
 * @since Nov 9, 2014 8:53:09 AM
 */
package com.cells.cell;

/**
 * Represents a concrete cell which can move, eat and die
 */
class SexuatedCell extends CellImplementation{
	
	/**
	 * @brief Constructor
	 * @see com.cells.cell.CellImplementation#AbstractCell(int, int, int)
	 */
	protected SexuatedCell(int timeBeforeHunger, int timeBeforeDie, int cellID) {
		super(timeBeforeHunger, timeBeforeDie, cellID);
	}
}