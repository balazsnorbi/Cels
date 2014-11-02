package com.cells.food;

import java.util.logging.Logger;

import net.jcip.annotations.ThreadSafe;

/**
 * 
 * Class that provides synchronizing using the monitor concept.
 * 
 * @author <a href="mailto:groza.claudiu@icloud.com">Claudiu Groza</a>
 *
 */

@ThreadSafe
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
		if(isFoodAvailable()) {
			--foodStock;
			return true;
		}
		
		return false;
	}

	@Override
	public synchronized boolean supplement(long supplementStock) {
		foodStock += supplementStock;

		return true;
	}

}
