package BackTracking;

/**
 * Created by Bi on 5/27/19.
 */
public class Sudoku {
    public static void main(String[] args) {
        int[][] grid1 = new int[4][4];
        grid1[0][0] = 1;
        grid1[0][2] = 3;
        grid1[1][2] = 2;
        grid1[1][3] = 1;
        grid1[2][1] = 1;
        grid1[2][3] = 2;
        grid1[3][0] = 2;
        grid1[3][1] = 4;

        print(grid1);
        System.out.println(solveSudoku(grid1));
        print(grid1);

        int[][] grid2 = new int[9][9];
        grid2[0][0] = 5;
        grid2[0][1] = 3;
        grid2[0][4] = 7;

        grid2[1][0] = 6;
        grid2[1][3] = 1;
        grid2[1][4] = 9;
        grid2[1][5] = 5;

        grid2[2][1] = 9;
        grid2[2][2] = 8;
        grid2[2][7] = 6;

        grid2[3][0] = 8;
        grid2[3][4] = 6;
        grid2[3][8] = 3;

        grid2[4][0] = 4;
        grid2[4][3] = 8;
        grid2[4][5] = 3;
        grid2[4][8] = 1;

        grid2[5][0] = 7;
        grid2[5][4] = 2;
        grid2[5][8] = 6;

        grid2[6][1] = 6;
        grid2[6][6] = 2;
        grid2[6][7] = 8;

        grid2[7][3] = 4;
        grid2[7][4] = 1;
        grid2[7][5] = 9;
        grid2[7][8] = 5;

        grid2[8][4] = 8;
        grid2[8][7] = 7;
        grid2[8][8] = 9;

        print(grid2);
        System.out.println(solveSudoku(grid2));
        print(grid2);
    }

    public static void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean solveSudoku(int[][] grid) {
        int[] emptyCellCoordinate = findEmptyCell(grid);

        if (emptyCellCoordinate == null) {
            return true;
        }

        int row = emptyCellCoordinate[0];
        int col = emptyCellCoordinate[1];

        for (int i = 1; i <= grid.length; i++) {
            if (isSafe(grid, row, col, i)) {
                grid[row][col] = i;

                if (solveSudoku(grid)) {
                    return true;
                }

                grid[row][col] = 0;
            }
        }

        return false;
    }

    public static boolean isSafe(int[][] grid, int row, int col, int val) {
        int sodokuType = (int) Math.sqrt(grid.length);
        // Check row
        for (int i = 0; i < grid[0].length; i++) {
            if (i != col && grid[row][i] == val) return false;
        }

        // Check col
        for (int i = 0; i < grid.length; i++) {
            if (i != row && grid[i][col] == val) return false;
        }

        // Check zone
        int startZoneRow = (row / sodokuType) * sodokuType;
        int endZoneRow = (row / sodokuType) * sodokuType + sodokuType;
        int startZoneCol = (col / sodokuType) * sodokuType;
        int endZoneCol = (col / sodokuType) * sodokuType + sodokuType;

        for (int i = startZoneRow; i < endZoneRow; i++) {
            for (int j = startZoneCol; j < endZoneCol; j++) {
                if (i != row && j != col && grid[i][j] == val) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int[] findEmptyCell(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    return new int[] {i, j};
                }
            }
        }

        return null;
    }
}
