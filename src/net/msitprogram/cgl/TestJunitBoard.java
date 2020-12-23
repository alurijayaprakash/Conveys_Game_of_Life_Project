/**
 * 
 */
package net.msitprogram.cgl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Jayaprakash Aluri
 *
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
	
	// Board test 
	@Test
	void testBoard() {
		Board b = new Board(5, 4, false);
		assertSame(4, b.getBoardWidth());
		assertSame(5, b.getBoardLength());
	}
	
//	 Test for Live Nighbours
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


	
	
	@Test
	void testcountLiveNeighboursTwo() {
			Board b = new Board(10, 10, false);
			int myarr [][] = {{4,3},{1,2},{2,1},{2,3},{3,3},{4,1},{0,5},{2,5}};
			b.createBoard(myarr);
			assertSame(2, b.countLiveNeighbours(b.getNewBoard(), 1, 1));
			assertSame(4, b.countLiveNeighbours(b.getNewBoard(), 2, 2));
			assertSame(5, b.countLiveNeighbours(b.getNewBoard(), 3, 2));
			assertSame(2, b.countLiveNeighbours(b.getNewBoard(), 1, 5));
			assertSame(3, b.countLiveNeighbours(b.getNewBoard(), 2, 4));	
	}
	
	@Test
	void getNextGenerationOne() {
		Board b = new Board(4, 4, false);
		int myarr [][] = {{0,0},{1,1},{2,2}};
		b.createBoard(myarr);
		b.getNextGeneration();
		String s = b.showBoard();
//		System.out.println(s);
		assertEquals(s, "....\n.*..\n....\n....");	
	}
	
	@Test
	void getNextGenerationTwo() {
		Board b = new Board(4, 4, false);
		int myarr [][] = {{1,2},{3,1},{0,2},{0,1},{2,2},{1,1}};
		b.createBoard(myarr);
		b.getNextGeneration();
		String s1 = b.showBoard();
		assertEquals(s1, ".**.\n...*\n..*.\n....");	
	}
		

}
