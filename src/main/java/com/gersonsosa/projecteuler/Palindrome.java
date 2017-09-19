package com.gersonsosa.projecteuler;

import java.util.Arrays;

/**
 * @author <a href="mailto:gersonsosa@gmail.com">Gerson Sosa</a>
 */
public class Palindrome {

	public static int findLargestPalindromeFromProductOfThreeDigitNumbers() {
		int start = 100;
		int end = 999;

		int index = 0;

		int[] palindromes = new int[404550];

		for (int i = end; i > start; i--) {
			for (int j = i; j > start; j--) {
				if (isPalindrome(i*j)) {
					palindromes[index++] = i*j;
				}
			}
		}

		for (int i = start; i < end; i++) {
			if (isPalindrome(i*i)) {
				palindromes[index++] = i*i;
			}
		}

		Arrays.sort(palindromes);

		return palindromes[palindromes.length - 1];
	}

	private static boolean isPalindrome(int i) {

		final String number = String.valueOf(i);
		return new StringBuilder(number).reverse().toString().equals(number);
	}

}
