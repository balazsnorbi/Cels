package com.cells.food;

import java.util.logging.Logger;

/**
 * Class that provides synchronizing using the monitor concept.
 * 
 * @author <a href="mailto:groza.claudiu@icloud.com">Claudiu Groza</a>
 *
 */
class FoodMonitor extends AbstractFood {
	private final static Logger LOGGER = Logger.getLogger(FoodMonitor.class.getName());
	
	/**
	 * 
	 * @param foodStock
	 * 			the initial amount of food stock
	 */
	protected FoodMonitor(long foodStock) {
		this.foodStock = foodStock;
	}

	@Override
	public synchronized boolean eat() {
		
		if(isAvailableFood()) {
			--foodStock;
		}
		
		return true;
	}

	@Override
	public synchronized boolean supplement(long supplementStock) {
		foodStock += supplementStock;
		
		return true;
	}

}
