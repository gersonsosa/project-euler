package com.gersonsosa.projecteuler;

/**
 * @author <a href="mailto:gersonsosa@gmail.com">Gerson Sosa</a>
 */
class Pyramid {

    static int findLargestPyramid(int n, int m, int k, int[][] h) {
        int largestPyramid = 0;
        for (int pyramidSize = 1; 2 * pyramidSize - 1 <= n && 2 * pyramidSize - 1 <= m; pyramidSize++) {
            int squareSize = 2 * pyramidSize - 1;

            checkPyramid:
            for (int i = 0; i + squareSize <= n; i++) {
                for (int j = 0; j + squareSize <= m; j++) {
                    if (checkPyramid(h, i, j, i + squareSize, j + squareSize, pyramidSize, k)) {
                        largestPyramid = pyramidSize;
                        break checkPyramid;
                    }
                }
            }
        }
        return largestPyramid;
    }

    private static boolean checkPyramid(int[][] h, int fromX, int fromY, int toX, int toY, int pyramidSize, int blocks) {
        for (int i = fromX; i < toX; i++) {
            final int ir = i - fromX;
            for (int j = fromY; j < toY; j++) {
                final int jr = j - fromY;

                int current = h[i][j];

                int value = findMin(ir + 1, jr + 1, 2 * pyramidSize - (ir + 1), 2 * pyramidSize - (jr + 1));

                if (current > value) {
                    return false;
                } else if (value != current) {
                    if (blocks <= 0) {
                        return false;
                    }
                    blocks -= (value - current);
                }
            }
        }
        return true;
    }

    static int findMin(int a, int b, int c, int d) {
        int min = a;
        if (b <= min) {
            min = b;
        }
        if (c <= min) {
            min = c;
        }
        if (d <= min) {
            min = d;
        }
        return min;
    }
}