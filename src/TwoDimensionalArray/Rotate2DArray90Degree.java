package TwoDimensionalArray;

/**
 * Created by Bi on 8/22/18.
 */
public class Rotate2DArray90Degree {
    public static void main(String[] args) {
        int a1[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int a2[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        print(rotate2DArray90Deg(a1));
        print(rotate2DArray90Deg(a2));
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

    public static int[][] rotate2DArray90Deg(int[][] arr) {
        int n = arr.length;
        int layer = n / 2;

        for (int i = 0; i <= layer; i++) {
            for (int j = i + 1; j <= n - 1 - i; j++) {
                int top = arr[i][j];
                arr[i][j] = arr[n - 1 - j][i];
                arr[n - 1 - j][i] = arr[n - 1 - i][n - 1 - j];
                arr[n - 1 - i][n - 1 - j] = arr[j][n - 1 - i];
                arr[j][n - 1 - i] = top;
            }
        }

        return arr;
    }
}
