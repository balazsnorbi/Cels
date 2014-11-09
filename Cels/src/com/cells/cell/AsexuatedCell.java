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
class AsexuatedCell extends AbstractCell{

	/**
	 * @brief Constructor
	 * @see com.cells.cell.AbstractCell#AbstractCell(int, int, int)
	 */
	AsexuatedCell(int timeBeforeHunger, int timeBeforeDie, int cellID) {
		super(timeBeforeHunger, timeBeforeDie, cellID);
	}

	/* (non-Javadoc)
	 * @see com.cells.cell.AbstractCell#move()
	 */
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.cells.cell.AbstractCell#eat()
	 */
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.cells.cell.AbstractCell#die()
	 */
	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.cells.cell.AbstractCell#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
