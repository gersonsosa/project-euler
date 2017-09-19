package com.gersonsosa.projecteuler;

/**
 * @author <a href="mailto:gg.sosa@transportsystems.co">Gerson Sosa</a>
 */
public class LeastCommonMultiple {
	public static int findForIntegerRange(int start, int end) {

		int[] multiples = findMultiples(start, end);

		int leastCommonMultiple = 0;
		int i = end;
		while (leastCommonMultiple == 0) {
			boolean isLeastCommonMultiple = true;
			for (int j = 0; j < multiples.length; j++) {
				if (multiples[j] != 0 && i % multiples[j] != 0) {
					isLeastCommonMultiple = false;
					break;
				}
			}
			if (isLeastCommonMultiple) {
				leastCommonMultiple = i;
			}
			i += end;
		}

		return leastCommonMultiple;
	}

	private static int[] findMultiples(int start, int number) {

		int index = 0;
		final int[] multiples = new int[number];
		for (int i = start; i < number; i++) {
			if (number % i != 0) {
				multiples[index++] = i;
			}
		}
		return multiples;
	}
}
