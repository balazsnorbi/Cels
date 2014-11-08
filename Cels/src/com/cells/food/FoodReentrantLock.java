package com.cells.food;

import java.util.concurrent.locks.ReentrantLock;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Class that provides synchronizing using an ReentrantLock.
 * 
 * @author <a href="mailto:groza.claudiu@icloud.com">Claudiu Groza</a>
 * 
 */
@ThreadSafe
class FoodReentrantLock extends AbstractFood {
	private final ReentrantLock lock;

	/**
	 * 
	 * @param stockSize
	 *            the number of food units.
	 * @param enableFairness
	 *            the fairness of the lock.
	 */
	public FoodReentrantLock(int stockSize, boolean enableFairness) {
		lock = new ReentrantLock(enableFairness);
		this.foodStock = stockSize;
	}

	@GuardedBy("this.lock")
	@Override
	public boolean eat() throws InterruptedException {
		boolean hasEaten = false;
		if (lock.tryLock()) {
			try {
				if(isFoodAvailable()) {
					--foodStock;
					hasEaten = true;
				}
			} finally {
				lock.unlock();
			}
		}
		return hasEaten;
	}

	@GuardedBy("this.lock")
	@Override
	public boolean supplement(long supplementStock) {
		if (lock.tryLock()) {
			try {
				foodStock += supplementStock;
			} finally {
				lock.unlock();
			}
			return true;
		}
		return false;
	}
}
