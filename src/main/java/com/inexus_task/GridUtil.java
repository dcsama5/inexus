package com.inexus_task;

import com.inexus_task.exceptions.NodeNonExistantAtPointException;
import com.inexus_task.exceptions.NodeNotFoundException;

public final class GridUtil {
	
	private GridUtil() {
		
	}
	
	public static void printGrid(Grid grid) {
		for(int i=0; i<grid.getColumn(); i++) {
			System.out.print("\t" + i);
		}
			System.out.println();
		
		for(int i=0; i<grid.getRow(); i++) {
			System.out.print(i);
			for(int j=0; j<grid.getColumn(); j++) {
				printLocationState(i, j, grid);
			}
			System.out.println();
		}
	}
	
	public static Node findNeighbourToRight(Node n1, Grid grid) throws NodeNotFoundException, NodeNonExistantAtPointException {
		if(grid.getNode(n1.getRow(), n1.getColumn()).STATE == GridState.NON_EXIST) {
			throw new NodeNonExistantAtPointException(grid.getNode(n1.getRow(), n1.getColumn()));
		}
		else {
			for(int i=(n1.getColumn()+1); i<grid.getColumn(); i++) {
				if(grid.getNode(n1.getRow(), i).STATE == GridState.EXIST)
					return grid.getNode(n1.getRow(), i);
			}
			throw new NodeNotFoundException();	
		}
	}

	public static Node findNeighbourBelow(Node n1, Grid grid) throws NodeNotFoundException, NodeNonExistantAtPointException  {
		if(grid.getNode(n1.getRow(), n1.getColumn()).STATE == GridState.NON_EXIST) {
			throw new NodeNonExistantAtPointException(grid.getNode(n1.getRow(), n1.getColumn()));
		}
		else {
			for(int i=(n1.getRow()+1); i<grid.getRow(); i++) {
				if(grid.getNode(i, n1.getColumn()).STATE == GridState.EXIST)
					return grid.getNode(i, n1.getColumn());
			}
			throw new NodeNotFoundException();	
		}
	}
	
	private static void printLocationState(int i, int j, Grid grid) {
		if(grid.getNode(i, j).STATE == GridState.EXIST)
		System.out.print("\t"+"*");
		else
			System.out.print("\t\\");
	}
	
	public static int getDifferenceBetweenNodes(Node n1, Node n2) {
		if(n1.getRow() == n2.getRow())
			return Math.abs(n1.getColumn() - n2.getColumn());
		else if(n1.getColumn() == n2.getColumn())
			return Math.abs(n1.getRow() - n2.getRow());
		return -1;
	}
	
}
