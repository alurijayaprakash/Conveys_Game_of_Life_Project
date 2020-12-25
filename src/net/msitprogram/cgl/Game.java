/**
 * 
 */
package net.msitprogram.cgl;

import java.util.Scanner;

/**
 * @author Jayaprakash Aluri
 * Version 2.0
 */
public class Game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Reading size of the Board
        int boardLength = sc.nextInt();
        int boardWidth = sc.nextInt();
        
        // get kth generation
        int kthGen = sc.nextInt();
        
        // Reading no. of initial live cells
        int m = sc.nextInt();
        int[][] l = new int[m][2];
        
        int i = 0;
        // Reading Live cells
        while (i < m) {
            l[i][0] = sc.nextInt();
            l[i++][1] = sc.nextInt();
        }
        Board b = new Board(boardLength, boardWidth, false);
        b.createBoard(l);
        b.getKthGeneration(kthGen);
        sc.close();
	}

}
