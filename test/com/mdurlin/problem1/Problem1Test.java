package com.mdurlin.problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.AssumptionViolatedException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Stopwatch;
import org.junit.runner.Description;

/**
 * Test suite providing quality control for solution of Problem 1
 * 
 * @author mdurlin
 * @version 0.1.0
 *
 */

public class Problem1Test {

	// TODO replace with log4j (unit test isn't critical to do this)
	private static final Logger logger = Logger.getLogger("");
	
	private static void logInfo(Description description, String status, long nanos) {
        String testName = description.getMethodName();
        logger.info(String.format("Test %s %s, spent %d microseconds",
                                  testName, status, TimeUnit.MILLISECONDS.toMicros(nanos)));
    }
	
	@Rule
    public Stopwatch stopwatch = new Stopwatch() {
        @Override
        protected void succeeded(long nanos, Description description) {
            logInfo(description, "succeeded", nanos);
        }

        @Override
        protected void failed(long nanos, Throwable e, Description description) {
            logInfo(description, "failed", nanos);
        }

        @Override
        protected void skipped(long nanos, AssumptionViolatedException e, Description description) {
            logInfo(description, "skipped", nanos);
        }

        @Override
        protected void finished(long nanos, Description description) {
            logInfo(description, "finished", nanos);
        }
    };
	
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
	
	// Purpose of this test is NOT to validate functionality but to validate performance!
	// Since it is random there is no way to (easily) assert countAllOn, but this will confirm performance of under 5s
	@Test
	public void perfEdgeTest() throws InterruptedException {
		Problem1 problem1 = new Problem1();
		int[] myArray = new Random().ints(1000, 3, 1004).toArray(); // 2, 1 (1), 3 (2), 5, 4 (3)
		int countAllOn = problem1.findCountAllOn(myArray);
		boolean goodPerf = (stopwatch.runtime(TimeUnit.MILLISECONDS) <= 5000) ? true : false;
		assertTrue(goodPerf);
		System.out.println(countAllOn);
	}
	
	
	
}
