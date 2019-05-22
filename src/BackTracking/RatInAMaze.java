package BackTracking;

/**
 * Created by Bi on 5/21/19.
 */
public class RatInAMaze {
    public static void main(String[] args) {
        int[][] maze = new int[4][4];
        int[][] sol = new int[4][4];

        maze[0][0] = 1;
        maze[0][1] = 0;
        maze[0][2] = 0;
        maze[0][3] = 0;

        maze[1][0] = 1;
        maze[1][1] = 1;
        maze[1][2] = 1;
        maze[1][3] = 1;

        maze[2][0] = 0;
        maze[2][1] = 1;
        maze[2][2] = 0;
        maze[2][3] = 0;

        maze[3][0] = 1;
        maze[3][1] = 1;
        maze[3][2] = 1;
        maze[3][3] = 1;

        System.out.println(solveMaze(maze, 0, 0, sol));

        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol[0].length; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean solveMaze(int[][] maze, int x, int y, int[][] sol) {
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            sol[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y)) {
            sol[x][y] = 1;

            if (solveMaze(maze, x, y + 1, sol)) {
                return true;
            }

            if (solveMaze(maze, x + 1, y, sol)) {
                return true;
            }

            sol[x][y] = 0;
        }

        return false;
    }

    public static boolean isSafe(int[][] maze, int x, int y) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length || maze[x][y] == 0) {
            return false;
        }

        return true;
    }
}
