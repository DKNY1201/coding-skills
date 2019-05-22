package BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Bi on 5/21/19.
 */
public class CanSolveMaze {
    public static void main(String[] args) {
        List<Integer>[] maze = new List[9];
        for (int i = 0; i < maze.length; i++) {
            maze[i] = new ArrayList<>();
        }

        maze[0].add(1);
        maze[0].add(3);

        maze[1].add(0);
        maze[1].add(2);

        maze[2].add(1);

        maze[3].add(0);
        maze[3].add(4);
        maze[3].add(6);

        maze[4].add(3);
        maze[4].add(5);
        maze[4].add(7);

        maze[5].add(4);

        maze[6].add(3);

        maze[7].add(4);
        maze[7].add(8);

        maze[8].add(7);

        int start = 0, end = 8;

        System.out.println(canSolveMaze(maze, start, end));

        List<Integer> path = solveMazePath(maze, start, end);

        for (int item: path) {
            System.out.print(item + (item != end ? " -> " : ""));
        }
    }

    public static boolean canSolveMaze(List<Integer>[] maze, int start, int end) {
        Stack<Integer> stack = new Stack<>();
        stack.add(start);
        int[] visited = new int[9];
        visited[start] = 1;

        while (!stack.isEmpty() && stack.peek() != end) {
            List<Integer> adjs = maze[stack.peek()];

            boolean hasAdj = false;

            for (int adj: adjs) {
                if (visited[adj] == 0) {
                    stack.add(adj);
                    visited[adj] = 1;
                    hasAdj = true;
                    break;
                }
            }

            if (!hasAdj) {
                stack.pop();
            }
        }

        return stack.isEmpty() ? false : true;
    }

    public static List<Integer> solveMazePath(List<Integer>[] maze, int start, int end) {
        Stack<Integer> stack = new Stack<>();
        stack.add(start);
        int[] visited = new int[9];
        visited[start] = 1;

        while (!stack.isEmpty() && stack.peek() != end) {
            List<Integer> adjs = maze[stack.peek()];

            boolean hasAdj = false;

            for (int adj: adjs) {
                if (visited[adj] == 0) {
                    stack.add(adj);
                    visited[adj] = 1;
                    hasAdj = true;
                    break;
                }
            }

            if (!hasAdj) {
                stack.pop();
            }
        }

        return new ArrayList<>(stack);
    }
}
