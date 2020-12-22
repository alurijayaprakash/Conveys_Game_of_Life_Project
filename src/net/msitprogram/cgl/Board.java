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
	 */
	public Board(int boardLength, int boardWidth, boolean isStateChanged) {
		// TODO Auto-generated constructor stub
		this.boardLength = boardLength;
		this.boardWidth = boardWidth;
		this.isStateChanged = isStateChanged;
		
		
		
	}

//	@Override
	public void createBoard(int[][] liveCells) {
		// TODO Auto-generated method stub
		boolean[][] newBoard = new boolean[this.boardLength][this.boardWidth];
		for (int i = 0; i < liveCells.length; i++) {
			int row = liveCells[i][0];
			int col = liveCells[i][1];
			newBoard[row][col] = true;
		}
//		System.out.println(Arrays.deepToString(newBoard));
	}

	@Override
	public String showBoard(boolean newBoard[][]) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.deepToString(newBoard));
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
			sb.append("\n");
		}
		return sb.toString();
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
