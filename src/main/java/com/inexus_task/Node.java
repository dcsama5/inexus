package com.inexus_task;

public class Node {

	private int row;
	private int column;
	public GridState STATE;
	
	public Node(int row, int column) {
		this.row = row;
		this.column = column;
		this.STATE = GridState.NON_EXIST;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public GridState getState() {
		return STATE;
	}

	public void setState(GridState state) {
		this.STATE = state;
	}
	
	public String toString() {
		if(this == null)
			return "null object";
		else
			return "["+this.row+"]"+"["+this.column+"]="+this.STATE;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		else {
			Node node = (Node) obj;
			if(node.getRow()==this.row && node.getColumn() == this.getColumn() && node.getState() ==  this.STATE)
				return true;
			else
				return false;
		}	
	}
	
	@Override
	public int hashCode() {
		
		String col = new Integer(this.column).toString();
		String rowstr = new Integer(row).toString();
		
		String completestring = col+rowstr;
		int hashCode = Integer.parseInt(completestring);
		
		if(this.STATE==GridState.EXIST)
			hashCode+=1;
		else
			hashCode-=1;
		
		return hashCode;
	}
	
}
