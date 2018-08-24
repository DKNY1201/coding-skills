package Dojo.Array.TwoDimensionalArray;

import java.util.HashSet;

/**
 * Created by Bi on 8/18/18.
 */
public class Minesweeper {
    public static void main(String[] args) {
        print(generateMap(new int[][] {{0,0}, {0,1}}, 3, 4));
        print(generateMap(new int[][] {{0,0}, {0,4}, {0,5}, {1,1}, {2,3}, {3,1}, {3,3}, {3,5}, {4,3}}, 7, 8));
        print(generateMap2(new int[][] {{0,0}, {0,4}, {0,5}, {1,1}, {2,3}, {3,1}, {3,3}, {3,5}, {4,3}}, 7, 8));
    }

    public static void print(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=========================");
    }

    public static int[][] generateMap2(int[][] bombs, int row, int col) {
        int[][] map = new int[row][col];

        for (int b = 0; b < bombs.length; b++) {
            int i = bombs[b][0];
            int j = bombs[b][1];
            map[i][j] = -1;

            for (int k = i - 1; k <= i + 1; k++) {
                for (int l = j - 1; l <= j + 1; l++) {
                    if (k >= 0 && l >= 0 && k < row && l < col && map[k][l] != -1) {
                        map[k][l] += 1;
                    }
                }
            }
        }

        return map;
    }

    public static int[][] generateMap(int[][] bombs, int row, int col) {
        HashSet<String> locations = new HashSet<>();

        for (int i = 0; i < bombs.length; i++) {
            locations.add(bombs[i][0] + "-" + bombs[i][1]);
        }

        int[][] map = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (locations.contains(i + "-" + j)) { // set bomb
                    map[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] != -1) { // 0 or num of bombs near by
                    int count = 0;
                    if (i == 0) { // row 0
                        if (j == 0) { // row 0, col 0
                            if (map[i][j + 1] == -1) {
                                count++;
                            }

                            if (map[i + 1][j + 1] == -1) {
                                count++;
                            }

                            if (map[i + 1][j] == -1) {
                                count++;
                            }
                        } else if (j == col - 1) { // row 0, last col
                            if (map[i][j - 1] == -1) {
                                count++;
                            }

                            if (map[i + 1][j] == -1) {
                                count++;
                            }

                            if (map[i + 1][j - 1] == -1) {
                                count++;
                            }
                        } else { // row 0, middle cols
                            if (map[i][j - 1] == -1) {
                                count++;
                            }

                            if (map[i + 1][j - 1] == -1) {
                                count++;
                            }

                            if (map[i + 1][j] == -1) {
                                count++;
                            }

                            if (map[i + 1][j + 1] == -1) {
                                count++;
                            }

                            if (map[i][j + 1] == -1) {
                                count++;
                            }
                        }
                    } else if (i == row - 1) { // last row
                        if (j == 0) { // last row, col 0
                            if (map[i -1][j] == -1) {
                                count++;
                            }

                            if (map[i - 1][j + 1] == -1) {
                                count++;
                            }

                            if (map[i][j + 1] == -1) {
                                count++;
                            }
                        } else if (j == col - 1) { // last row, last col
                            if (map[i][j - 1] == -1) {
                                count++;
                            }

                            if (map[i - 1][j - 1] == -1) {
                                count++;
                            }

                            if (map[i - 1][j] == -1) {
                                count++;
                            }
                        } else { // last row, mid cols
                            if (map[i][j - 1] == -1) {
                                count++;
                            }

                            if (map[i - 1][j - 1] == -1) {
                                count++;
                            }

                            if (map[i - 1][j] == -1) {
                                count++;
                            }

                            if (map[i - 1][j + 1] == -1) {
                                count++;
                            }

                            if (map[i][j + 1] == -1) {
                                count++;
                            }
                        }
                    } else { // mid rows
                        if (j == 0) { // mid rows, col 0
                            if (map[i -1][j] == -1) {
                                count++;
                            }

                            if (map[i - 1][j + 1] == -1) {
                                count++;
                            }

                            if (map[i][j + 1] == -1) {
                                count++;
                            }

                            if (map[i + 1][j + 1] == -1) {
                                count++;
                            }

                            if (map[i + 1][j] == -1) {
                                count++;
                            }
                        } else if (j == col - 1) { // mid rows, last col
                            if (map[i - 1][j] == -1) {
                                count++;
                            }

                            if (map[i - 1][j - 1] == -1) {
                                count++;
                            }

                            if (map[i][j - 1] == -1) {
                                count++;
                            }

                            if (map[i + 1][j - 1] == -1) {
                                count++;
                            }

                            if (map[i + 1][j] == -1) {
                                count++;
                            }
                        } else { // mid rows, mid cols
                            if (map[i - 1][j - 1] == -1) {
                                count++;
                            }

                            if (map[i - 1][j] == -1) {
                                count++;
                            }

                            if (map[i - 1][j + 1] == -1) {
                                count++;
                            }

                            if (map[i][j + 1] == -1) {
                                count++;
                            }

                            if (map[i + 1][j + 1] == -1) {
                                count++;
                            }

                            if (map[i + 1][j] == -1) {
                                count++;
                            }

                            if (map[i + 1][j - 1] == -1) {
                                count++;
                            }

                            if (map[i][j - 1] == -1) {
                                count++;
                            }
                        }

                    }

                    map[i][j] = count;
                }
            }
        }

        return map;
    }


}
