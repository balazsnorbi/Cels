/**
 * @project Cels
 * @package com.cells.cell
 * @file AbstractCell.java
 * @author Norbi
 * @since Nov 9, 2014 12:22:46 AM
 */
package com.cells.cell;

import java.util.Random;
import com.cells.register.*;

/**
 * Base implementation for Cells. 
 */
class CellImplementation implements ICell{

	private int food = 5;

	/**
	 * Represents 100 milliseconds
	 */
	private int TIME_SEQUENCE = 1000;
	
	private Random timeGenerator;

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

	
	private boolean cellInRegisteredQueue = false;
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
		
		timeGenerator = new Random();
	}

	/**
	 * Describes what the cell behavior on moving 
	 */
	@Override
	public boolean move(int duration) {
		boolean succeded = true;

		try {
			System.out.println("Cell_" + getCellID() + " is moving!");
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			System.out.println("Cell_" + getCellID() + " caused problem: " + e.getMessage().toString());
			succeded = false;
		}

		return succeded;
	}

	/**
	 * Describes the thread behavior on eating
	 */
	@Override
	public boolean eat() {
		boolean successed = false;
		// TODO: Add implementation here!
		// TODO: Restore _timeToDie value after success!
		if (food > 0) {
			System.out.println("Cell_" + getCellID() + " is eating");
			food --;
			successed = true;
		}

		return successed;
	}

	/**
	 * Describe what to do when the cell is left without food
	 */
	@Override
	public void die() {
		System.out.println("Cell_" + getCellID() + " is DEAD");
		Thread.yield();
	}

	/* (non-Javadoc)
	 * @see com.cells.cell.ICell#onReadyForMultiplication()
	 */
	@Override
	public void onReadyForMultiplication() {
		Register.registerCell(this);
		cellInRegisteredQueue = true;
	}

	/**
	 * General method which describes the "cell" thread behavior
	 */
	@Override
	public void run(){
		int timeBeforeDie = _timeBeforeDie;
		int timeBeforeHunger = _timeBeforeHunger;
		int time = timeGenerator.nextInt(500);
		boolean foodFound;
		int numberOfEat = 0;

		System.out.println("Cell_" + getCellID() + " borned!");

		// While cell has energy, it tries to obtain food
		while(timeBeforeHunger > 0 && timeBeforeDie > 0)
		{
			// Has it eaten a food? Not yet...
			foodFound = false;
			// MOVING...MOVING...MOVING...
			while (timeBeforeHunger > 0 && move(time)) {
				timeBeforeHunger -= TIME_SEQUENCE;
				time = timeGenerator.nextInt(500);
				// Crop time if needed
				if (time > timeBeforeHunger)
					time = timeBeforeHunger;
			}
			// But there is a little more energy, which can save my life...
			while (timeBeforeDie > 0) {
				// Food?
				foodFound = eat();
				if (foodFound == true){
					// Restore energy level! :)
					timeBeforeHunger = _timeBeforeHunger;
					timeBeforeDie = _timeBeforeDie;
					numberOfEat++;
					if(numberOfEat == 2){
						onReadyForMultiplication();
					}
					break;
				} else {
					try {
						// No food found yet :(
						time = timeGenerator.nextInt(500);
						// Crop it if needed
						if (time > timeBeforeDie)
							time = timeBeforeDie;
						Thread.sleep(timeBeforeDie);
						timeBeforeDie -= TIME_SEQUENCE;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		// Damn. I'm just died of starvation 
		if(Register.removeSpecifiedCell(this)){
			System.out.println("SPECIFIED THREAD REMOVED FROM QUEUE");
		}
		else{
			System.out.println("SPECIFIED THREAD WASN'T IN QUEUE");
		}
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
	 * @brief Setter for timeBeforeDie
	 * @param timeBeforeDie
	 */
	private void setTimeBeforeDie(int timeBeforeDie) {
		this._timeBeforeDie = timeBeforeDie;
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
