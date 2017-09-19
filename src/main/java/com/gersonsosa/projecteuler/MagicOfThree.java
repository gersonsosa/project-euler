package com.gersonsosa.projecteuler;

import java.math.BigInteger;
import java.util.Objects;

/**
 * @author <a href="mailto:gg.sosa@transportsystems.co">Gerson Sosa</a>
 */
public class MagicOfThree {

	public static void findLeastMultipleOfNumberEndingWithThree() {

		BigInteger num = BigInteger.ONE;
		for (BigInteger i = BigInteger.TEN;
			 i.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) < 0;
			 i = i.multiply(BigInteger.TEN)) {
			num = i.add(num);
			BigInteger num3 = BigInteger.valueOf(3);
			for (BigInteger j = BigInteger.TEN; j.compareTo(i) < 0; j = j.add(BigInteger.TEN)) {
				if (Objects.equals(num.mod(num3), BigInteger.ZERO)) {
					System.out.printf("number: %d multiple: %d%n", num, num3);
					break;
				}
				num3 = num3.add(j);
			}
		}
	}

	public static void findLeastMultipleOfNumberEndingWithThree2() {

		BigInteger num3 = BigInteger.valueOf(3);
		for (BigInteger j = BigInteger.TEN; j.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) < 0; j = j.add(BigInteger.TEN)) {
			BigInteger num;
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				num = new BigInteger(getStringOnes(i));
				if (Objects.equals(num.mod(num3), BigInteger.ZERO)) {
					System.out.printf("number: %d multiple: %d%n", num, num3);
					break;
				}
			}
			num3 = j.add(BigInteger.valueOf(3L));
		}
	}

	private static String getStringOnes(int i) {

		String result = "111";

		for (int j = 0; j < i; j++) {
			result = result.concat(result);
		}

		return result;
	}
}
