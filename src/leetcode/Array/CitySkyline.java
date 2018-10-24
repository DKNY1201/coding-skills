package leetcode.Array;

/**
 * Created by Bi on 9/26/18.
 */
public class CitySkyline {
    public static void main(String[] args) {
        int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        System.out.println(maxIncreaseKeepingSkyline(grid));
        System.out.println(maxIncreaseKeepingSkyline2(grid));
    }

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int i = grid.length;
        int j = grid[0].length;

        int[] lr = new int[i];
        int[] tb = new int[j];

        for (int n = 0; n < i; n++) {
            int maxlr = Integer.MIN_VALUE;
            for (int m = 0; m < j; m++) {
                if (grid[n][m] > maxlr) {
                    maxlr = grid[n][m];
                }
            }
            lr[n] = maxlr;
        }

        for (int n = 0; n < j; n++) {
            int maxtb = Integer.MIN_VALUE;
            for (int m = 0; m < i; m++) {
                if (grid[m][n] > maxtb) {
                    maxtb = grid[m][n];
                }
            }
            tb[n] = maxtb;
        }

        int totalIncrease = 0;

        for (int n = 0; n < i; n++) {
            for (int m = 0; m < j; m++) {
                totalIncrease += Math.min(lr[n], tb[m]) - grid[n][m];
            }
        }

        return totalIncrease;
    }

    public static int maxIncreaseKeepingSkyline2(int[][] grid) {
        int i = grid.length;
        int j = grid[0].length;

        int[] lr = new int[i];
        int[] tb = new int[j];

        for (int n = 0; n < i; n++) {
            for (int m = 0; m < j; m++) {
                if (grid[n][m] > lr[n]) {
                    lr[n] = grid[n][m];
                }

                if (grid[n][m] > tb[m]) {
                    tb[m] = grid[n][m];
                }
            }
        }

        int totalIncrease = 0;

        for (int n = 0; n < i; n++) {
            for (int m = 0; m < j; m++) {
                totalIncrease += (lr[n] > tb[m] ? tb[m] : lr[n]) - grid[n][m];
            }
        }

        return totalIncrease;
    }
}
