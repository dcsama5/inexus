package com.inexus_task;

import java.util.Arrays;

import com.inexus_task.exceptions.GridSizeException;

public class Grid {
	private Node[][] grid;
	private int nrOfRow;
	private int nrOfColumn;
	
	public Grid(int row, int column) throws GridSizeException {
		
		if(!validateGridSize(row, column)) {
			throw new GridSizeException();
		}
		else {
			this.nrOfRow = row;
			this.nrOfColumn = column;
			this.grid = new Node[this.nrOfRow][this.nrOfColumn];
			for(int i=0; i<this.nrOfRow; i++)
				for(int j=0; j<this.nrOfColumn; j++)
					this.grid[i][j] = new Node(i,j);
		}
		
	}
	
	private static boolean validateGridSize(int row, int column) {
		if((row > 100000 || column > 100000 ) || row < 0 || column < 0)
			return false;
		else
			return true;
	}

	public int getRow() {
		return this.nrOfRow;
	}
	
	public int getColumn() {
		return this.nrOfColumn;
	}

	/**
	 * Sets the state location by the set_state parameter to the given row, column parameters in the grid.
	 * @param row row of the grid
	 * @param column column of the grid
	 * @param set_state the state to which you want to set at the location
	 * @return return a {@code boolean} value that suggests whether the location has changed state.
	 */
	public boolean setStateLocation(int row, int column, GridState set_state) {
		 if((grid[row][column].STATE == GridState.EXIST && set_state == GridState.EXIST)
			 || 
			 grid[row][column].STATE==GridState.NON_EXIST && set_state == GridState.NON_EXIST) {
			 System.out.println("no state changed");
			 return false; 
		 }
		 else {
			 System.out.println("changed ["+row+"]"+"["+column+"]" +" from "+grid[row][column]+" to "+set_state);
			 grid[row][column].STATE = set_state;
			 return true; 
		 }
			
	}
	
	public Node getNode(int row, int column) throws ArrayIndexOutOfBoundsException {
		if(row > this.nrOfRow || row < 0 || column > this.nrOfColumn || column < 0)
			throw new ArrayIndexOutOfBoundsException();
			return grid[row][column];	
	}
}
