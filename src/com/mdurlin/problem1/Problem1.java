package com.mdurlin.problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Problem1 {

	public int findCountAllOn(int[] myArray) {
		int countAllOn = 0;
		List<Integer> numbers = new ArrayList<Integer>();
		List<Integer> switchedOn = new ArrayList<Integer>();
		List<Integer> litUp = new ArrayList<Integer>();
		
		// This approach using stream is MUCH faster than looping to add the array individually
		Collections.addAll(numbers, Arrays.stream(myArray).boxed().toArray(Integer[]::new)); 
		
		Stream<Integer> sortedArray = numbers.stream().sorted(); // new sorted array needed to verify switched/lit up status
		Iterator<Integer> iter = sortedArray.iterator(); // Need an iterator for the sorted Stream of ints
		Integer nextInt = iter.next(); // Initialize the iterator first value
		
		for(int y : myArray) {
			// Loop over the original array
			switchedOn.add(y); // Always add the current
			// Check if it is the next one in the sorted array
			if(y == nextInt) {
				// If this is equal, then light it up because it is the next one in the sorted order
				litUp.add(y);
				if(iter.hasNext()) { 
					// In this block we check the ones previously switched on
					nextInt = iter.next(); // have to advance the iterator
					if(switchedOn.contains(nextInt) && !litUp.contains(nextInt)) {
						// If the next item in the sorted array IS in switchedOn but is NOT in litup array, need to light it
						litUp.add(nextInt);
						if(iter.hasNext()) {
							nextInt = iter.next(); // ensure to advance the sorted iterator again
						}
					}
				}
			}
			if(switchedOn.size() == litUp.size()) {
				// Increment countAllOn if the size of the two storage arrays is equivalent
				countAllOn++;
			}
		}
		
		return countAllOn;
	}

}
