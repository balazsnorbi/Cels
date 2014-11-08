package com.cells.food;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Class that provides synchronizing using a BlockingQueue.
 * 
 * @author <a href="mailto:groza.claudiu@icloud.com">Claudiu Groza</a>
 *
 */
@ThreadSafe
class FoodObjects implements IEatable{
	private final BlockingQueue<Object> queue;
	
	public FoodObjects(int foodStockCapacity, int initialStock) {
		queue = new ArrayBlockingQueue<Object>(foodStockCapacity);
		
		for(int i=0; i<initialStock; i++) {
			queue.add(new Object());
		}
	}
	
	@GuardedBy("this.queque")
	@Override
	public boolean eat() {
		if(queue.poll() != null){
			return true;
		}
		return false;
	}
	
	@GuardedBy("this.queque")
	@Override
	public boolean supplement(long supplementStock) {
		synchronized (queue) {
			for(int i=0; i<supplementStock; i++) {
				queue.offer(new Object());
			}
		}
		
		return true;
	}

}
