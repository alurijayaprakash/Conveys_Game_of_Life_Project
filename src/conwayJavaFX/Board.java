/**
 * 
 */
 
// package net.msitprogram.cgl;
package conwayJavaFX;

import java.util.Arrays;
//import java.util.Scanner;

/**
 * @author Jayaprakash Aluri
 * Version 2.0
 */
public class Board implements BoardInterface{
	
	private final int boardLength;
	private final int boardWidth;
	private boolean newBoard[][];
	private boolean isStateChanged;
	

	/**
	 * 
	 * @param boardLength Length of board
	 * @param boardWidth  Width of board
	 * @param isStateChanged Status of board, it's flag variable
	 */
	public Board(int boardLength, int boardWidth, boolean isStateChanged) {
		this.boardLength = boardLength;
		this.boardWidth = boardWidth;
		this.isStateChanged = isStateChanged;
		this.newBoard = new boolean [this.boardWidth][this.boardLength];
		
	}
	
	/**
	 * This method validate the 2D live cells Array
	 * @param liveCells  2D Array contains lives cells positions
	 * @return return true or Index Out of Bounds
	 */
	private boolean isValidInput(int [][] liveCells) {
//		System.out.println("isvalid started");
		for (int i = 0; i < liveCells.length; i++) {
			for (int j = 0; j < liveCells[0].length; j++) {
				if ((liveCells[i][j] < 0 || liveCells[i][j] >= this.boardWidth) || (liveCells[i][j] < 0 || liveCells[i][j] >= this.boardLength)) {
					throw new IllegalArgumentException("Index Out of Bounds");
				}
			}
		}
		return true;
	}
	
	

	/**
	 * This method used to create board
	 * @param liveCells 2D array contains all live cells positions
	 */
	public void createBoard(int[][] liveCells) {
		if (isValidInput(liveCells)) {
			for (int i = 0; i < liveCells.length; i++) {
				int row = liveCells[i][0];
				int col = liveCells[i][1];
				newBoard[row][col] = true;
			}
		}
	}

	/**
	 * Insted of toSTring , we are using Showboard method.
	 * We can display the board by using this method.
	 */
	@Override
	public String showBoard() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < this.boardLength;i++){
			for (int j = 0; j < this.boardWidth; j++) {
				if (!(newBoard[i][j])) {
					sb.append(".");
				}
				else {
					sb.append("*");
				}
			}
			if (i < newBoard.length-1) {
				sb.append("\n");
			}
		}
		return sb.toString();
	}
	

	/**
	 * We can get next generation board by this method
	 */
	
	public void getNextGeneration () {
		int k = this.newBoard.length;
		Board nextGeneration = new Board(this.boardLength, this.boardWidth, false);
		for (int i = 0; i < k; i++) {
			for (int j = 0 ; j < k; j++) {
				int countOfLivesdata = countLiveNeighbours(i, j);
				if (!(this.newBoard[i][j])) {
					if (countOfLivesdata == 3) {
						nextGeneration.newBoard[i][j] = true;
					}
				}
				else {
					if (countOfLivesdata < 2) {
						nextGeneration.newBoard[i][j] = false;
					}
					else if (countOfLivesdata <= 3){
						nextGeneration.newBoard[i][j] = true;
					}
					else if (countOfLivesdata > 3){
						nextGeneration.newBoard[i][j] = false;
					}
				}
			}
		}
		if (Arrays.deepEquals(this.newBoard, nextGeneration.newBoard)) {
//			System.out.println("StatusCheck");
			this.isStateChanged = true;
		} else {
//			System.out.println("StatusCheck else case");
			this.isStateChanged = false;
		}
//		this.newBoard = nextGeneration;
		this.newBoard = nextGeneration.newBoard;
	}
	
	
	
	
	/**
	 * We can get kth Generation board by this method
	 * @param k means no of generations
	 */
	
	public void getKthGeneration(int k) {
//		createBoard(int[][] liveCells);
		int i;
		for (i=0; i < k; i++) {
			getNextGeneration();
			if (this.isStateChanged == false) {
			} else {
//				System.out.println(i + "true case");
				System.out.println("Game ended after " + i + " th iteration");
				System.out.println("Final board is : \n" + showBoard());
				break;
			}
		}
//		System.out.println(i + "now case");
		if (i <= k && this.isStateChanged == false)  {
			System.out.println("Status of Baord at " + i + " Generations");
			System.out.println("Final board is : \n" + showBoard());
		}
		
	}
	
	/**
	 * This method is used to create neighbour live cells
	 * @param a board length
	 * @param b board width
	 * @return int value ie. count of Live Neighbours 
	 */
	public int countLiveNeighbours(int a, int b) {
		int m = newBoard.length;
		int n = newBoard.length;
		int countLivesVal = 0;
		for (int i = a - 1; i <= a + 1; i++) {
			for (int j = b - 1; j <= b + 1; j++) {
				if (i!= a || j != b) {
					if (i >= 0 && i < m && j >= 0 && j < n && newBoard[i][j]) {
						countLivesVal = countLivesVal + 1;
					}
				}
			}
		}
//		System.out.println(countLivesVal);
		return countLivesVal;
	}
	
	
	
	
	
	
	/**
	 * @return the isStateChanged
	 */
	public boolean getisStateChanged() {
		return isStateChanged;
	}


	/**
	 * @return the boardLength
	 */
	public int getBoardLength() {
		return boardLength;
	}

	/**
	 * @return the boardWidth
	 */
	public int getBoardWidth() {
		return boardWidth;
	}

}
