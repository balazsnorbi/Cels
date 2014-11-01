package com.cells.food;

import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

import net.jcip.annotations.ThreadSafe;

/**
 * Class that provides synchronizing using a simple binary semaphore.
 * 
 * @author <a href="mailto:groza.claudiu@icloud.com">Claudiu Groza</a>
 *
 */

@ThreadSafe
class FoodSemaphore extends AbstractFood {
	private final static Logger LOGGER = Logger.getLogger(FoodSemaphore.class.getName()); 
	
	private final Semaphore mSemaphore;
	
	/**
	 * 
	 * @param foodStock
	 * 				the initial amount of food stock
	 * @param enableFairness
	 * 				activate the fairness of the semaphore
	 */
	protected FoodSemaphore(long foodStock, boolean enableFairness) {
		this.foodStock = foodStock;
		this.mSemaphore = new Semaphore(1, enableFairness);
	}

	@Override
	public boolean eat() {
		boolean hasSucceded = false;
		
		if(mSemaphore.tryAcquire()) {
			try {
				mSemaphore.acquire();
				if(isFoodAvailable()) {
					--foodStock;
					hasSucceded = true;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				mSemaphore.release();
			}
		}
		
		return hasSucceded;
	}

	@Override
	public boolean supplement(long supplementStock) {
		boolean hasSucceded = false;
		if(mSemaphore.tryAcquire()) {
			try {
				mSemaphore.acquire();
				foodStock += supplementStock;
				hasSucceded = true;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				mSemaphore.release();
			}
		}
		
		return hasSucceded;
	}
}
