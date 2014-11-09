/**
 * @project Cels
 * @package com.cells.cell
 * @file ConcreteCell.java
 * @author Norbi
 * @since Nov 9, 2014 8:53:09 AM
 */
package com.cells.cell;

import com.cells.register.Register;

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
	
	/* (non-Javadoc)
	 * @see com.cells.cell.CellImplementation#onReadyForMultiplication()
	 */
	@Override
	public void onReadyForMultiplication() {
		Register.registerCell(this);
	}
	
	/* (non-Javadoc)
	 * @see com.cells.cell.CellImplementation#die()
	 */
	@Override
	public void die() {
		super.die();
		Register.removeSpecifiedCell(this);
	}
}
