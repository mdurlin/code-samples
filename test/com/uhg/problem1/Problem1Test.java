package com.uhg.problem1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test suite providing quality control for solution of Problem 1
 * 
 * @author mdurlin
 * @version 0.1.0
 *
 */

public class Problem1Test {

	@Test
	public void oneArrayItem() {
		Problem1 problem1 = new Problem1();
		int[] myArray = {1};
		int countAllOn = problem1.findCountAllOn(myArray);
		assertEquals(1, countAllOn);
	}
	
	@Test
	public void orderedArray() {
		Problem1 problem1 = new Problem1();
		int[] myArray = {1, 2};
		int countAllOn = problem1.findCountAllOn(myArray);
		assertEquals(2, countAllOn);
	}
	
	@Test
	public void unorderedSmallArray() {
		Problem1 problem1 = new Problem1();
		int[] myArray = {2, 1};
		int countAllOn = problem1.findCountAllOn(myArray);
		assertEquals(1, countAllOn);
	}
	
	@Test
	public void unorderedComplexArray() {
		Problem1 problem1 = new Problem1();
		int[] myArray = {2, 1, 3, 5, 4}; // 2, 1 (1), 3 (2), 5, 4 (3)
		int countAllOn = problem1.findCountAllOn(myArray);
		assertEquals(3, countAllOn);
	}
	
}
