package com.gersonsosa.projecteuler;

import java.util.Map;

/**
 * Some solutions to project-euler problems
 *
 * @author <a href="mailto:gg.sosa@transportsystems.co">Gerson Sosa</a>
 */
public class ProjectEuler {
    public static void main(String[] args) {

        System.out.printf("Largest palindrome product of three digits numbers is %d%n",
                Palindrome.findLargestPalindromeFromProductOfThreeDigitNumbers());

        System.out.printf("The smallest multiple of %d to %d is %d%n", 1, 20, LeastCommonMultiple.findForIntegerRange(1, 20));

        MagicOfThree.findLeastMultipleOfNumberEndingWithThree(23);
        MagicOfThree.findLeastMultipleOfNumberEndingWithThreeOLogN(113);

        final Map.Entry<Integer, Integer> mostFrequentAndCountInArray = MostFrequent.findMostFrequentAndCountInArray(
                new int[]{1, 3, 4, 5, 2, 2, 3, 2});

        System.out.printf("%d: %d%n", mostFrequentAndCountInArray.getKey(), mostFrequentAndCountInArray.getValue());
    }
}
