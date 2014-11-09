/**
 * @author Roland
 * Nov 9, 2014
 * @brief
 */
package com.cells.register;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.cells.cell.CellFactory;
import com.cells.cell.ICell;

/**
 * @author Roland
 *
 */
public class Register implements Runnable{

	private static BlockingQueue<ICell> cellQueue;
	
	public Register(){
		cellQueue = new ArrayBlockingQueue<ICell>(1000);
	}
	
	/**
	 * 
	 * @param cell - put in the queue the Cell which wants to divide
	 * 
	 */
	public static synchronized void registerCell(ICell cell) {
		if(cell != null){
			try {
				cellQueue.put(cell);
				System.out.println("PUTTED IN QUEUE");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run(){
		while(true){
			if(cellQueue.size() > 1){
				removePairsFromQueue();
				CellFactory.Sexuated.create().start();
			}
		}
	}

	/**
	 * 
	 * @ removes first two cells from the queue 
	 */
	private synchronized void removePairsFromQueue(){
		try {
			System.out.println("PAIRS REMOVED");
			cellQueue.take();
			cellQueue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param cell - the element that will be removed
	 * @return
	 * 		 <code> true </code> if the element was found and removed, <code> false </code> otherwise
	 */
	public static synchronized boolean removeSpecifiedCell(ICell cell){
		if(cellQueue.contains(cell)){
			return cellQueue.remove(cell);
		}
		else{
			return false;
		}
	}

}
