package com.bruteforce;



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
		return "Point [row=" + row + ", column=" + column + "]";
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
			{"11001110011000110001111001001110110011010110001011", 
				 "10100100010111111011111001011110101111010011100001", 
				 "11101111001110100110010101101100011100101000010001", 
				 "01000010001010101100010011111000100100110111111000", 
				 "10110100000101100000111000100001011101111101010010", 
				 "00111010000011100001110110010011010110010011100100", 
				 "01100001111101001101001101100001111000111001101010", 
				 "11010000000011011010100010000000111011001001100101", 
				 "10100000000100010100100011010100110110110001000001", 
				 "01101010101100001100000110100110100000010100100010", 
				 "11010000001110111111011010011110001101100011100010", 
				 "11101111000000011010011100100001100011111111110111", 
				 "11000001101100100011000110111010011001010100000001", 
				 "00100001111001010000101101100010000001100100001000", 
				 "01001110110111101011010000111111101011000110010111", 
				 "01001010000111111001100000100010101100100101010100", 
				 "11111101001101110011011011011000111001101100011011", 
				 "10000100110111000001110110010000000000111100101101", 
				 "01010011101101101110000011000110011111001111011100", 
				 "01101010011111010000011001111101011010011100001101", 
				 "11011000011000110010101111100000101011011111101100", 
				 "11100001001000110010100011001010101101001010001100", 
				 "11011011001100111101001100111100000101011101101011", 
				 "11110111100100101011100101111101000111001111110111", 
				 "00011001100110111100111100001100101001111100001111", 
				 "10001111100101110111001111100000000011110000100111", 
				 "10101010110110100110010001001010000111100110100011", 
				 "01100110100000001110101001101011001010001101110101", 
				 "10110101110100110110101001100111110000101111100110", 
				 "01011000001001101110100001101001110011001001110001", 
				 "00100101010001100110110101001010010100001011000011", 
				 "00011101100100001010100000000011000010100110011100", 
				 "11001001011000000101111111000000110010001101101110", 
				 "10101010110110010000010011001100110101110100111011", 
				 "01101001010111010001101000100011101001110101000110", 
				 "00110101101110110001110101110010100100110000101101", 
				 "11010101000111010011110011000001101111010011110011", 
				 "10010000010001110011011101001110110010001100011100", 
				 "00111101110001001100101001110100110010100110110000", 
				 "00010011011000101000100001101110111100100000010100", 
				 "01101110001101000001001000001011101010011101011110", 
				 "00000100110011001011101011110011011101100001110111", 
				 "00110011110000011001011100001110101010100110010110", 
				 "00111001010011011111010100000100100000101101110001", 
				 "10101101101110111110000011111011001011100011110001", 
				 "00101110010101111000001010110100001110111011100011", 
				 "01111110010100111010110001111000111101110100111011"};
		
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
