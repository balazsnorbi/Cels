/**
 * @project Cels
 * @package com.cells.cell
 * @file AbstractCell.java
 * @author Norbi
 * @since Nov 9, 2014 12:22:46 AM
 */
package com.cells.cell;

import com.cells.food.IEatable;
import com.cells.register.Register;

/**
 * Base implementation for Cells. 
 */
abstract class CellImplementation implements ICell{
	
	private final int EAT_TIME_BEFORE_MULTIPLY = 10;
	
	/**
	 * Represents the time between eating a food and becoming hungry in milliseconds
	 */
	private int _timeBeforeHunger;

	/**
	 * Represents the time between entering in state hungry and die in milliseconds
	 */
	private int _timeBeforeDie; 

	/**
	 * Unique identifier for each cell
	 */
	private int cellID;

	/**
	 * Counter for eaten food. 
	 */
	private int eatenFoodCount;
	
	/**
	 * 
	 */
	private IEatable eatable;
	
	/**
	 * @brief Constructor
	 * @param timeBeforeHunger Represents the time between eating a food and becoming hungry in milliseconds
	 * @param timeBeforeDie Represents the time between entering in state hungry and die in milliseconds
	 * @param cellID Unique identifier for each cell
	 */
	protected CellImplementation(int timeBeforeHunger, int timeBeforeDie, int cellID) {
		setTimeBeforeHunger(timeBeforeHunger);
		setTimeBeforeDie(timeBeforeDie);
		setCellID(cellID);
		
		eatenFoodCount = 0;
	}
	
	/**
	 * @brief Setter for eatable
	 * @param eatable
	 */
	public void setEatable(IEatable eatable) {
		this.eatable = eatable;
	}

	/**
	 * Describes what the cell behavior on moving 
	 */
	@Override
	public void move() {
		// Define the time when the cell finished the moving process 
		long finalTime = System.currentTimeMillis() + _timeBeforeHunger;
		// Let's moving!
		while (System.currentTimeMillis() <= finalTime) {
			// At this point, please do nothing. 
			// The cell is alive and he is moving all around in the universe.
			// TODO: Remove next line
			System.out.println("Move: " + getCellID());
		}
	}

	/**
	 * Describes the thread behavior on eating
	 */
	@Override
	public boolean eat() {
		boolean successed = false;
		// This is the last time when the cell can eat
		long finalTime = System.currentTimeMillis() + _timeBeforeDie;
		// Try to get the food!
		try {
			while (successed != true && System.currentTimeMillis() <= finalTime){
				// Food?
				successed = eatable.eat();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Call this method to check eaten food count
		if (successed == true) {
			eatenFoodCount ++;
			if (eatenFoodCount >= EAT_TIME_BEFORE_MULTIPLY){
				Register.registerCell(this);
			}
		}
		
		return successed;
	}

	/**
	 * Describe what to do when the cell is left without food
	 */
	@Override
	public void die(){
		System.out.println("Cell_" + getCellID() + " is DEAD");
	}

	/* (non-Javadoc)
	 * @see com.cells.cell.ICell#onReadyForMultiplication()
	 */
	@Override
	public abstract void onReadyForMultiplication();

	/**
	 * General method which describes the "cell" thread behavior
	 */
	@Override
	public void run(){
		boolean foodFound = false;
		//
		System.out.println("Cell_" + getCellID() + " borned!");
		//
		do {
			// Just move a little to ensure cell condition
			move();
			// Let's get energy back
			foodFound = eat();
		}while (foodFound == true);
		// Damn. I'm just died of starvation 
		die();
	}

	/**
	 * @brief Setter for timeBeforeHunger
	 * @param timeBeforeHunger
	 */
	private void setTimeBeforeHunger(int timeBeforeHunger) {
		this._timeBeforeHunger = timeBeforeHunger;
	}
	
	/**
	 * @brief getter for timeBeforeHunger
	 * @return _timeBeforeHunger
	 */
	protected int getTimeBeforeHunger() {
		return _timeBeforeHunger;
	}

	/**
	 * @brief Setter for timeBeforeDie
	 * @param timeBeforeDie
	 */
	private void setTimeBeforeDie(int timeBeforeDie) {
		this._timeBeforeDie = timeBeforeDie;
	}
	
	/**
	 * @brief getter for _timeBeforeDie
	 * @return _timeBeforeDie
	 */
	protected int getTimeBeforeDie() {
		return _timeBeforeDie;
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
	protected int getCellID() {
		return cellID;
	}
}
