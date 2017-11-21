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
                    if (checkPyramid(copyOfRange(h, i, j, i + squareSize, j + squareSize), pyramidSize, k)) {
                        largestPyramid = pyramidSize;
                        break checkPyramid;
                    }
                }
            }
        }
        return largestPyramid;
    }

    static int[][] copyOfRange(int[][] h, int fromX, int fromY, int toX, int toY) {
        int[][] newArray = new int[toX - fromX][];
        for (int i = fromX; i < toX; i++) {
            newArray[i - fromX] = new int[toY - fromY];
            System.arraycopy(h[i], fromY, newArray[i - fromX], 0, toY - fromY);
        }
        return newArray;
    }

    private static boolean checkPyramid(int[][] h, int pyramidSize, int blocks) {
        for (int i = 0; i < h.length; i++) {
            for (int j = 0; j < h[i].length; j++) {
                int current = h[i][j];
                int value = findMin(i + 1, j + 1, 2 * pyramidSize - (i + 1), 2 * pyramidSize - (j + 1));
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