/**
 * @since Oct 27, 2014
 */

package com.cells.main;

import java.util.ArrayList;
import java.util.List;

import com.cells.cell.CellFactory;

/**
 * @author Norbi
 * @since Oct 27, 2014 10:09:58 PM
 */
public class Main {

	public static void main(String[] args) {
		List<Thread> cells = new ArrayList<Thread>();
		for(int i=0; i < 10; i++) {
			cells.add(CellFactory.Sexuated.create());
			cells.add(CellFactory.Asexuated.create());
		}
		for (Thread thread : cells) {
			thread.start();
		}
	}
}
