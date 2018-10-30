package com.uhg.problem1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Problem1 {

	public int findCountAllOn(int[] myArray) {
		int countAllOn = 0;
		List<Integer> numbers = new ArrayList<Integer>();
		List<Integer> switchedOn = new ArrayList<Integer>();
		List<Integer> litUp = new ArrayList<Integer>();
		for(int i : myArray) {
			numbers.add(i);
		}
		Stream<Integer> sortedArray = numbers.stream().sorted();
		Iterator<Integer> iter = sortedArray.iterator();
		Integer nextInt = iter.next();
		for(int y : myArray) {
			switchedOn.add(y); // Always add the current
			// Check if it is the next one in the sorted array
			if(y == nextInt) {
				// If this is equal, then light it up!
				litUp.add(y);
				if(iter.hasNext()) {
					nextInt = iter.next();
					// Check for previous switchedOn
					if(switchedOn.contains(nextInt) && !litUp.contains(nextInt)) {
						litUp.add(nextInt);
						if(iter.hasNext()) {
							nextInt = iter.next();
						}
					}
				}
			}
			if(switchedOn.size() == litUp.size()) {
				countAllOn++;
			}
		}
		return countAllOn;
	}

}
