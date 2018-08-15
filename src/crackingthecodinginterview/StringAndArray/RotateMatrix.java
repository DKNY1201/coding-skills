package crackingthecodinginterview.StringAndArray;

/**
 * Created by Bi on 8/6/18.
 */
public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = generateMatrix(6);
        printMatrix(matrix);
        int[][] rotatedMatrix = rotateMatrix(matrix);
        printMatrix(rotatedMatrix);
    }

    public static int[][] rotateMatrix(int[][] matrix) {
        int len = matrix.length;

        if (matrix[0].length != len) {
            return null;
        }

        for (int layer = 0; layer < len / 2; layer++) {
            for (int i = layer; i < len - layer - 1; i++) {
                int top = matrix[layer][i];
                matrix[layer][i] = matrix[len - i - 1][layer]; // l -> t
                matrix[len - i - 1][layer] = matrix[len - layer - 1][len - i - 1]; // b -> l
                matrix[len - layer - 1][len - i - 1] = matrix[i][len - layer - 1]; // r -> b
                matrix[i][len - layer - 1] = top; // t -> r
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int len) {
        int[][] matrix = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                matrix[i][j] = j;
            }
        }

        return matrix;
    }
}
