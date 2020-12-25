/**
 * 
 */
package net.msitprogram.cgl;

import static org.junit.jupiter.api.Assertions.*;

//import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * @author Jayaprakash Aluri
 * Version 2.0
 */
class TestJunitBoard {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	
	
	
	@Test
	void testcreateBoardOne() {
		Board b = new Board(4, 4, false);
		int myarr [][] = {{0,3},{1,2},{2,0}};
		b.createBoard(myarr);
		String s = b.showBoard();
		assertEquals(s, "...*\n..*.\n*...\n....");
		
	}
	
	@Test
	void testcreateBoardTwo() {
		Board b = new Board(4, 4, false);
		int myarr [][] = {{0,0},{3,3},{1,1}};
		b.createBoard(myarr);
		String s = b.showBoard();
		assertEquals(s, "*...\n.*..\n....\n...*");
		
	}
	
	@Test
	void testcreateBoardThree() {
		try{
			Board b = new Board(4, 4, false);
			int myarr [][] = {{4,3},{1,2},{4,0}};
			b.createBoard(myarr);
		}catch(Exception ex){
			assertEquals(ex.getMessage(), "Index Out of Bounds");
		}
		
	}
	
	@Test
	void testcreateBoardFour() {
		try{
			Board b = new Board(5, 5, false);
			int myarr [][] = {{0,5},{1,7},{2,12}};
			b.createBoard(myarr);
		}catch(Exception ex){
			assertEquals(ex.getMessage(), "Index Out of Bounds");
			
		}
		
	}
	
	/**
	 * Here we are testing the board length and width
	 */
	@Test
	void testBoard() {
		Board b = new Board(5, 4, false);
		assertSame(4, b.getBoardWidth());
		assertSame(5, b.getBoardLength());
	}
	
	/**
	 * Here we are testing Live Nighbours count
	 */
	@Test
	void testcountLiveNeighboursOne() {
		try{
			Board b = new Board(4, 4, false);
			int myarr [][] = {{4,3},{1,2},{4,0}};
			b.createBoard(myarr);
		}catch(Exception ex){
			assertEquals(ex.getMessage(), "Index Out of Bounds");
			
		}
		
	}


	
	/**
	 * Here we are testing Live Nighbours count
	 */
	@Test
	void testcountLiveNeighboursTwo() {
			Board b = new Board(10, 10, false);
			int myarr [][] = {{4,3},{1,2},{2,1},{2,3},{3,3},{4,1},{0,5},{2,5}};
			b.createBoard(myarr);
			assertSame(2, b.countLiveNeighbours(1, 1));
			assertSame(4, b.countLiveNeighbours(2, 2));
			assertSame(5, b.countLiveNeighbours(3, 2));
			assertSame(2, b.countLiveNeighbours(1, 5));
			assertSame(3, b.countLiveNeighbours(2, 4));	
	}
	
	/**
	 * Here we are testing Next Generation Board
	 */
	@Test
	void testgetNextGenerationOne() {
		Board b = new Board(4, 4, false);
		int myarr [][] = {{0,0},{1,1},{2,2}};
		b.createBoard(myarr);
		b.getNextGeneration();
		String s = b.showBoard();
		assertEquals(s, "....\n.*..\n....\n....");	
	}
	
	/**
	 * Here we are testing Next Generation Board
	 */
	@Test
	void testgetNextGenerationTwo() {
		Board b = new Board(4, 4, false);
		int myarr [][] = {{1,2},{3,1},{0,2},{0,1},{2,2},{1,1}};
		b.createBoard(myarr);
		b.getNextGeneration();
		String s1 = b.showBoard();
		assertEquals(s1, ".**.\n...*\n..*.\n....");
	}
	

	/**
	 * Here we are testing Kth Generation Board
	 */
	@Test
	void testgetKthGenerationOne() {
		Board b = new Board(4, 4, false);
		int myarr [][] = {{1,2},{3,1},{0,2},{0,1},{2,2},{1,1}};
		b.createBoard(myarr);
		b.getKthGeneration(3);
		String s1 = b.showBoard();
		assertEquals(s1, "..*.\n..*.\n....\n....");
	}
	
	/**
	 * Here we are testing Kth Generation Board
	 */
	@Test
	void testgetKthGenerationTwo() {
		Board b = new Board(6, 6, false);
		int myarr [][] = {{1,2},{3,1},{0,2},{0,1},{2,2},{1,1},{3,2},{4,1},{5,1},{4,2}};
		b.createBoard(myarr);
		b.getKthGeneration(10);
		String s1 = b.showBoard();
		assertEquals(s1, "......\n....*.\n....*.\n......\n......\n......");
	}
	
	/**
	 * Here we are testing Kth Generation Board
	 */
	@Test
	void testgetKthGenerationThree() {
		Board b = new Board(6, 6, false);
		int myarr [][] = {{1,2},{3,1},{0,2},{0,1},{2,2},{1,1},{3,2},{4,1},{5,1},{4,2}};
		b.createBoard(myarr);
		b.getKthGeneration(3);
		String s1 = b.showBoard();
		assertEquals(s1, "......\n....*.\n..***.\n.*....\n.**...\n.**...");
	}
	
	/**
	 * Here we are testing Kth Generation Board
	 */
	@Test
	void testgetKthGenerationFour() {
		Board b = new Board(6, 6, false);
		int myarr [][] = {{1,2},{3,1},{0,2},{0,1},{2,2},{1,1}};
		b.createBoard(myarr);
		b.getKthGeneration(8);
		String s1 = b.showBoard();
		assertEquals(s1, "......\n......\n......\n......\n......\n......");
	}

	/**
	 * Here we are testing isStatusChanged after end of the game
	 */
	@Test
	void testisStatusChanged() {
		Board b = new Board(4, 4, false);
		int myarr [][] = {{1,2},{3,1},{0,2},{0,1},{2,2},{1,1}};
		b.createBoard(myarr);
		b.getKthGeneration(14);
		assertTrue(b.getisStateChanged());
	}
	
	
}
