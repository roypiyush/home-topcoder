package com.topcoder.bruteforce;



class Point {
	private int row;
	private int column;
	
	public Point(int row, int column) {
		super();
		this.row = row;
		this.column = column;
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

	@Override
	public String toString() {
		return "Edge [row=" + row + ", column=" + column + "]";
	}
	
}

public class LargestChessMatrix {

	
	boolean isCompatibleColumn(String string[], int i, int j, int row) {
		if(string[row].charAt(i) == '0' && string[row].charAt(j) == '1')
			return true;
		else if(string[row].charAt(i) == '1' && string[row].charAt(j) == '0') 
			return true;
		else
			return false;
	}
	
	boolean isCompatibleRow(String string[], int r1, int r2, int col) {
		boolean isValidIndex = r1 < string.length && r2 < string.length && col < string[r1].length() && col < string[r2].length();
		if(!isValidIndex)
			return false;			
		
		if(string[r1].charAt(col) == '0' && string[r2].charAt(col) == '1')
			return true;
		else if(string[r1].charAt(col) == '1' && string[r2].charAt(col) == '0') 
			return true;
		else
			return false;
	}
	
	
	int area(Point start, Point end) {
		int length = end.getColumn() - start.getColumn() + 1;
		int breadth = end.getRow() - start.getRow() + 1;
		
		return length * breadth;
	}
	
	int maxAreaForPoint(String string[], Point start) {
		
		int row = start.getRow() - 1;
		int minimumEndIndex = string[start.getRow()].length() - 1 ;
		int area = 1;
		do {
			row = row + 1;
			int column = findColumnEnd(string, start.getColumn(), row);
			if(column == -1)
				break;
			
			if(column <= minimumEndIndex) {
				minimumEndIndex = column;
			}
			
			Point temp = new Point(row, minimumEndIndex);
			if(area(start, temp) > area) {
				area = area(start, temp);
			}
			
			
		} while(isCompatibleRow(string, row, row + 1, start.getColumn()));
		
		
		return area;
	}

	

	private int findColumnEnd(String[] string, int column, int row) {
		if(row >= string.length)
			return -1;
		
		int columnEndIndex = column;
		for(int c = column; c + 1 < string[row].length(); c++) {
			if(isCompatibleColumn(string, c, c + 1, row)) {
				columnEndIndex = c + 1;
			}
			else
				break;
		}
		
		return columnEndIndex;
	}
	
	public static void main(String[] args) {
		
		LargestChessMatrix chessMatrix = new LargestChessMatrix();
		
		int maxArea = 0;
		String[] string = 
			{"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101", 
				"0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101"};
		
		for(int r = 0; r < string.length; r++) {
			for(int c = 0; c < string[0].length(); c++) {
				Point point = new Point(r, c);
				int area = chessMatrix.maxAreaForPoint(string, point);
				if(area > maxArea) {
					maxArea = area;
				}
			}
		}
		
		System.out.println(maxArea);

	}

}
