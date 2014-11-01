package com.cells.food;

import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

/**
 * Class that provides synchronizing using a simple binary semaphore.
 * 
 * @author <a href="mailto:groza.claudiu@icloud.com">Claudiu Groza</a>
 *
 */
public class FoodSemaphore implements IEatable {
	private final static Logger LOGGER = Logger.getLogger(FoodSemaphore.class.getName()); 
	
	private long foodStock;
	private final Semaphore mSemaphore;
	
	protected FoodSemaphore(long foodStock, boolean enableFairness) {
		this.foodStock = foodStock;
		this.mSemaphore = new Semaphore(1, enableFairness);
	}

	@Override
	public boolean eat() {
		boolean hasSucceded = true;
		
		try {
			mSemaphore.acquire();
			if(isAvailable()) {
				--foodStock;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			LOGGER.info("Not able to eat.");
			
			hasSucceded = false;
		} finally {
			mSemaphore.release();
		}
		
		return hasSucceded;
	}

	@Override
	public boolean supplement(long supplementStock) {
		boolean hasSucceded = true;
		
		try {
			mSemaphore.acquire();
			foodStock += supplementStock;
		} catch (InterruptedException e) {
			e.printStackTrace();
			LOGGER.info("Not able to supplement.");
			
			hasSucceded = false;
		} finally {
			mSemaphore.release();
		}
		
		return hasSucceded;
	}
	
	boolean isAvailable() {
		return (foodStock > 0 ? true : false);
	}

}
