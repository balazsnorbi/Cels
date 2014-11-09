/**
 * @project Cels
 * @package com.cells.cell
 * @file AbstractCell.java
 * @author Norbi
 * @since Nov 9, 2014 12:22:46 AM
 */
package com.cells.cell;

/**
 * @author Norbi
 */
abstract class AbstractCell implements ICell{

	/**
	 * Represents the time between eating a food and becoming hungry in milliseconds
	 */
	private int timeBeforeHunger;
	
	/**
	 * Represents the time between entering in state hungry and die in milliseconds
	 */
	private int timeBeforeDie; 
	
	/**
	 * Unique identifier for each cell
	 */
	private int cellID;
	
	/**
	 * @brief Constructor
	 * @param timeBeforeHunger Represents the time between eating a food and becoming hungry in milliseconds
	 * @param timeBeforeDie Represents the time between entering in state hungry and die in milliseconds
	 * @param cellID Unique identifier for each cell
	 */
	AbstractCell(int timeBeforeHunger, int timeBeforeDie, int cellID) {
		setTimeBeforeHunger(timeBeforeHunger);
		setTimeBeforeDie(timeBeforeDie);
		setCellID(cellID);
	}
	
	/**
	 * Describes what the cell behavior on moving 
	 */
	@Override
	public abstract void move();

	/**
	 * Describes the thread behavior on eating
	 */
	@Override
	public abstract void eat();
	
	/**
	 * Describe what to do when the cell is left without food
	 */
	@Override
	public abstract void die();
	
	/**
	 * General method which describes the "cell" thread behavior
	 */
	@Override
	public abstract void run();
	
	/**
	 * @brief Setter for timeBeforeHunger
	 * @param timeBeforeHunger
	 */
	private void setTimeBeforeHunger(int timeBeforeHunger) {
		this.timeBeforeHunger = timeBeforeHunger;
	}

	/**
	 * @brief Setter for timeBeforeDie
	 * @param timeBeforeDie
	 */
	private void setTimeBeforeDie(int timeBeforeDie) {
		this.timeBeforeDie = timeBeforeDie;
	}


	/**
	 * @brief Setter for cellID
	 * @param cellID
	 */
	private void setCellID(int cellID) {
		this.cellID = cellID;
	}

	/**
	 * @brief Getter for cellID 
	 * @return cellID
	 */
	int getCellID() {
		return cellID;
	}
}
