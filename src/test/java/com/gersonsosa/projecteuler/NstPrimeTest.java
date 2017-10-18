package com.gersonsosa.projecteuler;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * @author <a href="mailto:gg.sosa@transportsystems.co">Gerson Sosa</a>
 */
public class NstPrimeTest {

    @Test
    public void shouldFindNstPrime() {
        Assertions.assertThat(NstPrime.getPrime(6)).isEqualTo(13);
        Assertions.assertThat(NstPrime.getPrime(7)).isEqualTo(17);
        Assertions.assertThat(NstPrime.getPrime(8)).isEqualTo(19);
        System.out.printf("10001st prime %d", NstPrime.getPrime(10001));
    }

    @Test
    public void shouldDetermineWhetherIsPrimeOrNot() {

        Assertions.assertThat(NstPrime.isPrime(10)).isFalse();
        Assertions.assertThat(NstPrime.isPrime(15)).isFalse();
        Assertions.assertThat(NstPrime.isPrime(18)).isFalse();
        Assertions.assertThat(NstPrime.isPrime(19)).isTrue();
    }
}