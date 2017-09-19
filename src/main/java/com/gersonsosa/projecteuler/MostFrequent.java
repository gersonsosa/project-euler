package com.gersonsosa.projecteuler;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author <a href="mailto:gersonsosa@gmail.com">Gerson Sosa</a>
 */
public class MostFrequent {

	public static Map.Entry<Integer, Integer> findMostFrequentAndCountInArray(int[] integers) {

		Map.Entry<Integer, Integer> mostFrequent = new AbstractMap.SimpleEntry<>(0, 0);

		for (int i = 0; i < integers.length; i++) {
			int num = integers[i];
			Map.Entry<Integer, Integer> current = new AbstractMap.SimpleEntry<>(num, 1);
			for (int j = i + 1; j < integers.length; j++) {
				int curr = integers[j];
				if (curr == num) {
					current.setValue(current.getValue() + 1);
				}
			}
			if (current.getValue() > mostFrequent.getValue()) {
				mostFrequent = current;
			}
			if (Objects.equals(current.getValue(), mostFrequent.getValue()) && current.getKey() < mostFrequent.getKey()) {
				mostFrequent = current;
			}
		}


		return mostFrequent;
	}
}
