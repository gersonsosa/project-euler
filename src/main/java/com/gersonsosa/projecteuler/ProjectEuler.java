package com.gersonsosa.projecteuler;

import java.util.Map;

/**
 * @author <a href="mailto:gg.sosa@transportsystems.co">Gerson Sosa</a>
 */
public class ProjectEuler {
	public static void main(String[] args) {

		System.out.printf("Largest palindrome product of three digits numbers is %d%n",
				Palindrome.findLargestPalindromeFromProductOfThreeDigitNumbers());

		System.out.printf("The smallest multiple of %d to %d is %d%n", 1, 20, LeastCommonMultiple.findForIntegerRange(1, 20));

//		MagicOfThree.findLeastMultipleOfNumberEndingWithThree();
//		MagicOfThree.findLeastMultipleOfNumberEndingWithThree2();

		int three = 3;
		int oneHundredEleven = 111;
		int thirteen = 17;
		int number111111 = 111111;
		int thirtyThree = 33;
		System.out.printf("decimal: %d, binary: %s%n", three, Integer.toBinaryString(three));
		System.out.printf("decimal: %d, binary: %s%n", oneHundredEleven, Integer.toBinaryString(oneHundredEleven));
		System.out.printf("decimal: %d, binary: %s%n", thirteen, Integer.toBinaryString(thirteen));
		System.out.printf("decimal: %d, binary: %s%n", number111111, Integer.toBinaryString(number111111));
		System.out.printf("decimal: %d, binary: %s%n", thirtyThree, Integer.toBinaryString(thirtyThree));

		final Map.Entry<Integer, Integer> mostFrequentAndCountInArray = MostFrequent.findMostFrequentAndCountInArray(
				new int[] { 1, 3, 4, 5, 2, 2, 3, 2 });
		System.out.printf("%d: %d%n", mostFrequentAndCountInArray.getKey(), mostFrequentAndCountInArray.getValue());
	}
}
