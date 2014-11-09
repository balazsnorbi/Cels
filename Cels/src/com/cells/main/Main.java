/**
 * @since Oct 27, 2014
 */

package com.cells.main;

import com.cells.cell.CellFactory;
import com.cells.cell.ICell;
import com.cells.register.Register;

/**
 * @author Norbi
 * @since Oct 27, 2014 10:09:58 PM
 */
public class Main {

	public static void main(String[] args) {
		Thread sexuatedCell1 = CellFactory.Sexuated.create();
		Thread asexuatedCell1 = CellFactory.Asexuated.create();
		Thread sexuatedCell2 = CellFactory.Sexuated.create();
		Thread asexuatedCell2 = CellFactory.Asexuated.create();
		
		sexuatedCell1.start();
		asexuatedCell1.start();
		sexuatedCell2.start();
		asexuatedCell2.start();
		
		try {
			sexuatedCell1.join();
			asexuatedCell1.join();
			sexuatedCell2.join();
			asexuatedCell2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
