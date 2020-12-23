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
		try {
			Board b = new Board(4, 4, false);
			int myarr [][] = {{0,0},{3,3},{1,1}};
			b.createBoard(myarr);
			String s = b.showBoard();
			assertEquals(s, "*...\n.*..\n....\n...*");
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			
		}
		
	}
	
	@Test
	void testcreateBoardThree() {
		try{
			Board b = new Board(4, 4, false);
			int myarr [][] = {{4,3},{1,2},{4,0}};
			b.createBoard(myarr);
		}catch(Exception ex){
			assertEquals(ex.getMessage(), "Index 4 out of bounds for length 4");
		}
		
	}
	
	@Test
	void testcreateBoardFour() {
		try{
			Board b = new Board(4, 4, false);
			int myarr [][] = {{0,0},{1,1},{2,2}};
			b.createBoard(myarr);
			String s = b.showBoard();
			assertEquals(s, "*...\n.*..\n..*.\n....");
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			
		}
		
	}
	
	// Boardtest
	void testBoard() {
		Board b = new Board(5, 4, false);
		int myarr [][] = {{0,0},{1,1},{2,2}};
		b.createBoard(myarr);
		String s = b.showBoard();
//		System.out.println(s.length()) //pending
		assertSame(5, b.getBoardWidth());
		assertSame(4, b.getBoardLength());
		assertSame(5, b.getBoardWidth());
	}
	
	// Test for Live Nighbours
	@Test
	void testcountLiveNeighbours() {
		try{
			Board b = new Board(4, 4, false);
			int myarr [][] = {{4,3},{1,2},{4,0}};
			b.createBoard(myarr);
			String s = b.showBoard();
			assertSame(0, b.countLiveNeighbours(b.getNewBoard(), 5, 7));
		}catch(Exception ex){
			assertEquals(ex.getMessage(), "Index 4 out of bounds for length 4");
			
		}
		
	}

		

}
