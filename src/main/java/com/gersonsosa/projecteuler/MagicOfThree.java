package com.gersonsosa.projecteuler;

import java.math.BigInteger;
import java.util.Objects;

/**
 * @author <a href="mailto:gersonsosa@gmail.com">Gerson Sosa</a>
 */
public class MagicOfThree {

	public static void findLeastMultipleOfNumberEndingWithThree(int num) {
	    int i = 0;
		while (true) {
			BigInteger ones = new BigInteger(getStringOnes(i));
			System.out.printf("i: %d ones: %s%n", i, ones);
			if (Objects.equals(ones.mod(BigInteger.valueOf(num)), BigInteger.ZERO)) {
				System.out.printf("number: %d multiple: %d%n", ones, num);
				break;
			}
			i++;
		}
	}

	private static String getStringOnes(int i) {

		String one = "1";
		String result = "";

		for (int j = 0; j <= i; j++) {
			result += one;
		}

		return result;
	}

	public static void findLeastMultipleOfNumberEndingWithThreeOLogN(int num3) {

		BigInteger num = BigInteger.ONE;
		BigInteger i = BigInteger.TEN;
		while (true) {
			num = i.add(num);
			if (Objects.equals(num.mod(BigInteger.valueOf(num3)), BigInteger.ZERO)) {
				System.out.printf("number: %d multiple: %d%n", num, num3);
				break;
			}
			i = i.multiply(BigInteger.TEN);
		}
	}
}
