import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author konstantin Tomashevsky
 *
 */



public class GradebookTester {

	private GradeBook g1;
	
	@Before
	public void setUp() {
		
		g1 = new GradeBook(5);
		g1.addScore(50);
		g1.addScore(75);
	}
	
	@After
	public void tearDown() {
		
		g1 = null;
		
	}
	@Test
	public void testSum() {
		assertEquals(125, g1.sum(), .0001);
		
		
	}
	@Test
	public void testMinimum() {
		
		assertEquals(50, g1.minimum(), .001);
	}
	@Test
	public void addScoreTest() {
		assertTrue(g1.toString().equals("50.0 75.0 "));
		
	}
	
	
	
}
