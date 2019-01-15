package GeeksForGeeks;

import java.util.Stack;

/**
 * Created by Bi on 1/14/19.
 * https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-using-stack/
 */
public class RatInMaze {
    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 1, 1, 0},
                {1, 1, 1, 0, 1},
                {0, 1, 0, 1, 1},
                {1, 1, 1, 1, 1}
        };

        System.out.println(canEatFood(maze, 0, 3));
    }

    public static boolean canEatFood(int[][] maze, int x, int y) {
        int row = maze.length;
        int col = maze[0].length;
        int[][] visited = new int[row][col];
        Stack<Coor> path = new Stack<>();
        Coor current = new Coor(0, 0);
        Coor dest = new Coor(x, y);

        path.push(current);
        visited[0][0] = 1;

        while (!path.isEmpty() && !path.peek().equals(dest)) {
            int cX = current.x;
            int cY = current.y;

            int dCor = cX + 1;
            int rCor = cY + 1;
            int tCor = cX - 1;
            int lCor = cY - 1;

            // Down
            if (dCor < row && maze[dCor][cY] != 0) {
                if (visited[dCor][cY] == 0) {
                    current = new Coor(dCor, cY);
                    visited[dCor][cY] = 1;
                    path.push(current);
                    continue;
                }
            }

            // Right
            if (cY + 1 < col && maze[cX][rCor] != 0) {
                if (visited[cX][rCor] == 0) {
                    current = new Coor(cX , rCor);
                    visited[cX][rCor] = 1;
                    path.push(current);
                    continue;
                }
            }

            // Top
            if (cX > 0 && maze[tCor][cY] != 0) {
                if (visited[tCor][cY] == 0) {
                    current = new Coor(tCor, cY);
                    visited[tCor][cY] = 1;
                    path.push(current);
                    continue;
                }
            }

            // Left
            if (cY > 0 && maze[cX][lCor] != 0) {
                if (visited[cX][lCor] == 0) {
                    current = new Coor(cX , lCor);
                    visited[cX][lCor] = 1;
                    path.push(current);
                    continue;
                }
            }

            current = path.pop();
        }

        return path.size() > 0 && path.peek().equals(dest);
    }
}

class Coor {
    int x, y;

    public Coor(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Coor c = (Coor) obj;
        return this.x == c.x && this.y == c.y;
    }
}
