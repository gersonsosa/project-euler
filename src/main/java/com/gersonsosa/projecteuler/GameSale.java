package com.gersonsosa.projecteuler;

/**
 * @author <a href="mailto:gg.sosa@transportsystems.co">Gerson Sosa</a>
 */
class GameSale {
    static int howManyGames(int p, int d, int m, int s) {
        int currentPrice = p;
        int games = 0;
        for (int currentCredit = p; s - currentCredit >= 0; currentCredit += currentPrice) {
            games++;
            if (currentPrice - d > m) {
                currentPrice = currentPrice - d;
            } else {
                currentPrice = m;
            }
        }
        return games;
    }
}
