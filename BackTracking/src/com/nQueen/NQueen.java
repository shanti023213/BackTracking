package com.nQueen;

import java.util.ArrayList;

class Position{
	int row;
	int column;
	
	Position(int row, int column){
		this.row= row;
		this.column=column;
	}
}

public class NQueen {

	public static void main(String[] args){
			
		int[][] matrix = new int[4][4];
		ArrayList<Position> positions = new ArrayList<Position>();
		nQueenSolution(matrix ,0,positions);
	}
	
	public static void nQueenSolution(int[][] matrix, int row, ArrayList<Position>positions){
		
		if(row >matrix.length-1){
			return ;
		}
		
		for(int col =0;col<matrix[0].length;col++){
			
			boolean found = true;
			
			for(int queen=0;queen<row;queen++){
				if(positions.get(queen).column == col ||
						positions.get(queen).column+positions.get(queen).row == row+col ||
						positions.get(queen).column-positions.get(queen).row == col-row ){
					found = false;
					break;
				}
			}
			
			if(found){
				matrix[row][col] =1;
				positions.add(new Position(row,col));
				if(row== matrix.length-1){
					printMatrix(matrix);
					
				}else {
					nQueenSolution(matrix,row+1,positions);
				}
				matrix[row][col] =0;
				positions.remove(positions.size()-1);
			}
		}
	}
	
	
	public static void printMatrix(int[][] matrix){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.println(matrix[i][j]);
			}
		}
	}
}
