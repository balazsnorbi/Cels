package com.cells.food;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
class FoodObjects implements IEatable{
	private final BlockingQueue<Object> queque;
	
	public FoodObjects(int foodStockCapacity, int initialStock) {
		queque = new ArrayBlockingQueue<Object>(foodStockCapacity);
		
		for(int i=0; i<initialStock; i++) {
			queque.add(new Object());
		}
	}
	
	@GuardedBy("this.queque")
	@Override
	public boolean eat() {
		if(queque.poll() != null){
			return true;
		}
		return false;
	}
	
	@GuardedBy("this.queque")
	@Override
	public boolean supplement(long supplementStock) {
		synchronized (queque) {
			for(int i=0; i<supplementStock; i++) {
				queque.offer(new Object());
			}
		}
		
		return true;
	}

}
