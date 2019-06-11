package TwoDimensionalArray;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Bi on 6/6/19.
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths1(2,100));
    }

    /**
     * Backtracking - Generate all solution and count using BFS
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        // Add start to stack
        queue.add(new int[]{0,0});
        // Traversal
        while(!queue.isEmpty()) {
            int[] currentPoint = queue.remove();
            // Vertical coordinate
            int y = currentPoint[0] + 1;
            // Horizontal coordinate
            int x = currentPoint[1] + 1;

            // Increase count if robot reach finish point
            if ((currentPoint[0] == n - 1 && x == m - 1) || (y == n - 1 && currentPoint[1] == m - 1)) {
                count++;
            } else { // Traversal right and down
                if (x < m) {
                    queue.add(new int[]{currentPoint[0], x});
                }

                if (y < n) {
                    queue.add(new int[]{y, currentPoint[1]});
                }
            }

        }

        return count;
    }

    /**
     * Using math Binomial coefficient - There is total m + n steps to go from start to finish point.
     * So in total we choose m or n.
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths1(int m, int n) {
        if (m == 1 || n == 1) return 1;

        int steps = (m - 1) + (n - 1);
        int x = 1;

        for (int i = 0; i < n - 1; i++) {
            x *= (steps - i);
        }

        int y = 1;

        for (int i = 1; i <= n - 1; i++) {
            y *=i;
        }

        return x / y;
    }
}
