package com.gersonsosa.projecteuler;

/**
 * @author <a href="mailto:gg.sosa@transportsystems.co">Gerson Sosa</a>
 */
public class SumSquareDifference {

	static int sumSquareDifference(int end) {

		int sum = end * (end + 1) / 2;
		int sumOfSquares = 0;

		for (int i = 1; i <= end; i++) {
			sumOfSquares += i * i;
		}

		return (sum * sum) - sumOfSquares;
	}
}
