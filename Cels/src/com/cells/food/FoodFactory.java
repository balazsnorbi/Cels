package com.cells.food;

public class FoodFactory {
	public static final int MAX_STOCK_SIZE = 10000;

	private FoodFactory() {
	}

	/**
	 * Static factory method for instancing an IEatable type.
	 * 
	 * @param typeOf
	 *            the synchronizing concept to be used.
	 * @param stockSize
	 *            the initial stock size.
	 * @param enableFairness
	 *            enable fairness if available.
	 * @return the new instance created.
	 */
	public static IEatable getInstance(String typeOf, int stockSize,
			boolean enableFairness) {
		if (typeOf.equalsIgnoreCase("FoodSemaphore")) {
			return new FoodSemaphore(stockSize, enableFairness);
		} else if (typeOf.equalsIgnoreCase("FoodReentrantLock")) {
			return new FoodReentrantLock(stockSize, enableFairness);
		} else if (typeOf.equalsIgnoreCase("FoodObjects")) {
			return new FoodObjects(MAX_STOCK_SIZE, stockSize);
		} else if (typeOf.equalsIgnoreCase("FoodMonitor")) {
			return new FoodMonitor(stockSize);
		}
		return null;
	}
}
