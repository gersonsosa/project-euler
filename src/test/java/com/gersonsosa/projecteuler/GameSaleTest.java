package com.gersonsosa.projecteuler;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * @author <a href="mailto:gersonsosa@gmail.com">Gerson Sosa</a>
 */
public class GameSaleTest {

    @Test
    public void shouldCalculateNumberOfGames() {
        Assertions.assertThat(GameSale.howManyGames(20, 3, 6, 80)).isEqualTo(6);
        Assertions.assertThat(GameSale.howManyGames(1, 1, 1, 10)).isEqualTo(10);
    }
}