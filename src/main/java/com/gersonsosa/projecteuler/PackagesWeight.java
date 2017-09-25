package com.gersonsosa.projecteuler;

import java.util.LinkedList;

/**
 * @author <a href="mailto:gersonsosa@gmail.com">Gerson Sosa</a>
 */
public class PackagesWeight {
	public int findMinimumTrips(int maxWeight, int[] packagesWeight) {

		LinkedList<Integer> integers = new LinkedList<>();
		for (int packageWeight : packagesWeight) {
			integers.add(packageWeight);
		}

		int trips = 0;
		while (!integers.isEmpty()) {
			int current = integers.remove();
			int complimentIndex = -1;
			int minDifference = maxWeight;
			for (int j = 0; j < integers.size(); j++) {
				final int diff = maxWeight - (current + integers.get(j));
				if (diff >= 0 && diff < minDifference) {
					minDifference = diff;
					complimentIndex = j;
				}
			}
			if (complimentIndex > -1) {
				integers.remove(complimentIndex);
			}
			trips++;
		}
		return trips;
	}
}
