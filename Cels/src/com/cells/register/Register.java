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
public class Register{ 

	private static BlockingQueue<ICell> cellQueue = new ArrayBlockingQueue<ICell>(1000);
	
	/**
	 * Registers the Cells in the queue, if there are two 'good' cells in the queue -> 
	 * 			remove them and create the third cell
	 * @param cell - put in the queue the Cell which wants to divide
	 * 
	 */
	public static synchronized void registerCell(ICell cell) {
		if(cell != null && !cellQueue.contains(cell)){
			try {
				cellQueue.put(cell);
				if(cellQueue.size() > 1){
					cellQueue.take().afterMultiplication();
					cellQueue.take().afterMultiplication();
					CellFactory.Sexuated.create().start();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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
