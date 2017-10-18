package com.gersonsosa.projecteuler;

/**
 * @author <a href="mailto:gersonsosa@gmail.com">Gerson Sosa</a>
 */
public class NstPrime {

    static int getPrime(int n) {

        int m = 1;
        int i = 1;
        while (m < n) {
            i += 2;
            if (isPrime(i)) {
                m++;
            }
        }

        return i;
    }

    static boolean isPrime(int i) {

        for (int j = 2; j < i / 2; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
