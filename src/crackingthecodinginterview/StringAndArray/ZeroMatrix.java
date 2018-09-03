package crackingthecodinginterview.StringAndArray;

/**
 * Created by Bi on 9/3/18.
 */
public class ZeroMatrix {
    public static void main(String[] args) {
        int[][] matrix = generateMatrix(5, 8);
        matrix[2][3] = 0;
        matrix[3][5] = 0;
        matrix[4][7] = 0;

        int[][] matrix1 = generateMatrix(20, 30);
        matrix1[2][3] = 0;
        matrix1[3][5] = 0;
        matrix1[4][7] = 0;
        matrix1[19][29] = 0;

        printMatrix(zeroMatrix(matrix));
        printMatrix(zeroMatrix1(matrix1));
    }

    public static int[][] generateMatrix(int row, int col) {
        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = j + 1;
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static int[][] zeroMatrix(int[][] matrix) {
        boolean[] zeroesRow = new boolean[matrix.length];
        boolean[] zeroesCol = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroesRow[i] = true;
                    zeroesCol[j] = true;
                }
            }
        }

        for (int i = 0; i < zeroesRow.length; i++) {
            if (zeroesRow[i]) {
                for (int j = 0; j < zeroesCol.length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < zeroesCol.length; i++) {
            if (zeroesCol[i]) {
                for (int j = 0; j < zeroesRow.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        return matrix;
    }

    public static int[][] zeroMatrix1(int[][] matrix) {
        int maskRow = 0;
        int maskCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    maskRow |= 1 << i;
                    maskCol |= 1 << j;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if ((maskRow & (1 << i)) > 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if ((maskCol & (1 << i)) > 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        return matrix;
    }
}
