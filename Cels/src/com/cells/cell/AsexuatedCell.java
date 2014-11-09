/**
 * @project Cels
 * @package com.cells.cell
 * @file AsexuatedCell.java
 * @author Norbi
 * @since Nov 9, 2014 10:38:07 AM
 */
package com.cells.cell;

/**
 * Represents a concrete cell which can move, eat and die
 */
class AsexuatedCell extends CellImplementation{
	
	/**
	 * @brief Constructor
	 * @see com.cells.cell.CellImplementation#AbstractCell(int, int, int)
	 */
	protected AsexuatedCell(int timeBeforeHunger, int timeBeforeDie, int cellID) {
		super(timeBeforeHunger, timeBeforeDie, cellID);
	}
}
