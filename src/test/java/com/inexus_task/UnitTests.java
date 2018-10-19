package com.inexus_task;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.junit.Assert;


import com.inexus_task.exceptions.GridSizeException;
import com.inexus_task.exceptions.NodeNonExistantAtPointException;
import com.inexus_task.exceptions.NodeNotFoundException;



public class UnitTests 
{
	
	private Grid grid1;
	
	@BeforeClass
	public void setUpGrid() throws GridSizeException {
		grid1 = new Grid(10,10);
		grid1.setStateLocation(0, 1, GridState.EXIST);
		grid1.setStateLocation(1, 7, GridState.EXIST);
		grid1.setStateLocation(7, 7, GridState.EXIST);
		grid1.setStateLocation(2, 3, GridState.EXIST);
		grid1.setStateLocation(0, 9, GridState.EXIST);
		GridUtil.printGrid(grid1);
	}
	
	@Test
    public void findNearestNeighbourToRight() throws NodeNotFoundException, NodeNonExistantAtPointException {
    	Node node = new Node(0, 1);node.setState(GridState.EXIST);
		Node s = GridUtil.findNeighbourToRight(node, grid1); //method returns the nearest neighbour to the right, hence 0,7
		Node s1 = new Node(0,9); s1.setState(GridState.EXIST);
		AssertJUnit.assertEquals(s, s1);
		
		int difference = GridUtil.getDifferenceBetweenNodes(s, node);
		System.out.println(node+"--"+s1+" distance="+difference);
		AssertJUnit.assertEquals(8, difference);
    }
	
	@Test(expectedExceptions=NodeNotFoundException.class)
    public void failNotFoundNearestNeighbourToRight() throws NodeNotFoundException, NodeNonExistantAtPointException {
    	Node node = new Node(2, 3);node.setState(GridState.EXIST);
    	GridUtil.findNeighbourToRight(node, grid1); // There is no node that can be found to the right of 2,3
    }
	
	@Test
    public void findNearestNeighbourBelow() throws NodeNotFoundException, NodeNonExistantAtPointException {
    	Node node = new Node(1,7);node.setState(GridState.EXIST);
    	Node s = GridUtil.findNeighbourBelow(node, grid1);
    	Node s1 = new Node(7,7);s1.setState(GridState.EXIST);
    	AssertJUnit.assertEquals(s,s1);
    	
    	int difference = GridUtil.getDifferenceBetweenNodes(s, node);
		System.out.println(node+"--"+s1+" distance="+difference);
		AssertJUnit.assertEquals(6, difference);
    }
	
	@Test(expectedExceptions=NodeNotFoundException.class)
    public void failNotFoundNearestNeighbourBelow() throws NodeNotFoundException, NodeNonExistantAtPointException {
    	Node node = new Node(0, 9);node.setState(GridState.EXIST);
    	GridUtil.findNeighbourBelow(node, grid1);
    }
	
	@Test(expectedExceptions=NodeNonExistantAtPointException.class)
    public void failNonExistantNode() throws NodeNotFoundException, NodeNonExistantAtPointException {
    	Node node = new Node(7,1);node.setState(GridState.EXIST);
    	GridUtil.findNeighbourToRight(node, grid1); // There is no initial node that exists at 7,1 hence should throw an exception
    }
    
    public void assertTwoSimilarNodeObjects() {
    	Node node1 = new Node(0,0);
    	Node node2 = new Node(0,0);
    	AssertJUnit.assertEquals(node1, node2);
    }
    
    public void assertTwoDifferentNodeObjects() {
    	Node node1 = new Node(1,1);
    	Node node2 = new Node(6,6);
    	Assert.assertNotEquals(node1,node2);
    }
    
    @Test(expectedExceptions=ArrayIndexOutOfBoundsException.class)
    public void testArrayIndexOutOfBoundsException() {
    	grid1.getNode(0, 11);
    }
    
    @Test(expectedExceptions=GridSizeException.class)
    public void testGridSizeException() throws GridSizeException {
    	Grid grid = new Grid(-1, 10);
    	Grid grid2 = new Grid(10000000, 100);
    }
}
