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
class SexuatedCell extends AbstractCell{

	/**
	 * @brief Constructor
	 * @see com.cells.cell.AbstractCell#AbstractCell(int, int, int)
	 */
	SexuatedCell(int timeBeforeHunger, int timeBeforeDie, int cellID) {
		super(timeBeforeHunger, timeBeforeDie, cellID);
	}

	/* (non-Javadoc)
	 * @see com.cells.cell.AbstractCell#move()
	 */
	@Override
	public void move() {
		
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
