/**
 * 
 */
package net.msitprogram.cgl;

import java.util.Arrays;

/**
 * @author Jayaprakash Aluri
 *
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
		// TODO Auto-generated constructor stub
		this.boardLength = boardLength;
		this.boardWidth = boardWidth;
		this.isStateChanged = isStateChanged;
		this.newBoard = new boolean [this.boardWidth][this.boardLength];
		
		
		
	}
	
	

	/**
	 * @param liveCells ==> 
	 */
	public void createBoard(int[][] liveCells) {
		for (int i = 0; i < liveCells.length; i++) {
			int row = liveCells[i][0];
			int col = liveCells[i][1];
			newBoard[row][col] = true;
		}
	}

	@Override
	public String showBoard() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < newBoard.length;i++){
			for (int j = 0; j < newBoard.length; j++) {
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
	
	
	
	public int countLiveNeighbours(boolean[][] newBoard, int boardLength, int boardWidth) {
		int n = newBoard.length;
		int countLivesVal = 0;
		for (int i = boardWidth - 1; i <= boardWidth + 1; i++) {
			for (int j = boardLength - 1; j <= boardLength + 1; j++) {
				if (i!= boardWidth || j != boardLength) {
					if (i >= 0 && i < n && j >= 0 && j < n && newBoard[i][j]) {
						countLivesVal = countLivesVal + 1;
					}
				}
			}
		}
		return countLivesVal;
	}
	
	
	/**
	 * @return the newBoard
	 */
	public boolean[][] getNewBoard() {
		return newBoard;
	}
	
	
	/**
	 * @return the isStateChanged
	 */
	public boolean isStateChanged() {
		return isStateChanged;
	}

	/**
	 * @param isStateChanged the isStateChanged to set
	 */
	public void setStateChanged(boolean isStateChanged) {
		this.isStateChanged = isStateChanged;
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
