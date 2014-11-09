/**
 * @project Cels
 * @package com.cells.cell
 * @file CellFactory.java
 * @author Norbi
 * @since Nov 9, 2014 9:04:39 AM
 */
package com.cells.cell;


/**
 * Use this Singleton to create cell objects
 */
public enum CellFactory {
	Sexuated,
	Asexuated;
	
	/**
	 * Default value for timeBeforeHunger is 3 seconds
	 */
	private final int TIME_BEFORE_HUNGER = 3000;
	
	/**
	 * Default value for timeBeforeDie is 5 seconds
	 */
	private final int TIME_BEFORE_DIE = 5000; 
	
	/**
	 * Each cell(thread) will be assigned with a unique ID 
	 */
	private int NEXT_THREAD_ID = 0;
	
	/**
	 * Cell creator method
	 * @brief Returns a new cell 
	 * @return
	 */
	public ICell create() {
		ICell cell = null;
		
		switch (CellFactory.valueOf(name())){
		case Sexuated:
			cell = getSexuatedCell();
			break;
		case Asexuated:
			cell = getAsexuatedCell();
			break;
		}
		
		return cell;
	}
	
	public ICell create(int timeBeforeHunger, int timeBeforeDie){
		ICell cell = null;
		
		switch(CellFactory.valueOf(name())){
		case Sexuated:
			cell = getSexuatedCell(timeBeforeHunger, timeBeforeDie);
			break;
		case Asexuated:
			cell = getAsexuatedCell(timeBeforeHunger, timeBeforeDie);
			break;
		}
		
		return cell;
	}
	
	/**
	 * @brief Creates a new Sexuated Cell object with default values(3 seconds / 5 seconds) 
	 * @return ConcreteCell
	 */
	private ICell getSexuatedCell() {
		return new SexuatedCell(TIME_BEFORE_HUNGER, TIME_BEFORE_DIE, NEXT_THREAD_ID++);
	}
	
	/** 
	 * @brief Creates a new Sexuated Cell object with specific timeBeforeHunger and timeBeforeDie times
	 * @param timeBeforeHunger
	 * @param timeBeforeDie
	 * @return ConcreteCell
	 */
	private ICell getSexuatedCell(int timeBeforeHunger, int timeBeforeDie) {
		return new SexuatedCell(timeBeforeHunger, timeBeforeDie, NEXT_THREAD_ID++);
	}
	
	/**
	 * @brief Creates a new Asexuated Cell object with default values(3 seconds / 5 seconds) 
	 * @return AsexuatedCell
	 */
	private ICell getAsexuatedCell(){
		return new AsexuatedCell(TIME_BEFORE_HUNGER, TIME_BEFORE_DIE, NEXT_THREAD_ID++);
	}
	
	/**
	 * 
	 * @brief Creates a new Cell object with specific timeBeforeHunger and timeBeforeDie times
	 * @param timeBeforeHunger
	 * @param timeBeforeDie
	 * @return AsexuatedCell
	 */
	private ICell getAsexuatedCell(int timeBeforeHunger, int timeBeforeDie) {
		return new AsexuatedCell(timeBeforeHunger, timeBeforeDie, NEXT_THREAD_ID++);
	}
	
}