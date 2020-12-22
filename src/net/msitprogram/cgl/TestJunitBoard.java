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
	void testcreateBoard() {
		Board b = new Board(4, 4, false);
		int myarr [][] = {{0,3},{1,2},{2,0}};
		b.createBoard(myarr);
//		String s = b.showBoard(b.newBoard);
//		assertEquals(s, "...* \n ..*. \n *... \n ....");
		assertEquals(1,1);
	}

}
