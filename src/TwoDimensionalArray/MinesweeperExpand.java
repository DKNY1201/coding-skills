package TwoDimensionalArray;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Bi on 8/18/18.
 */
public class MinesweeperExpand {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        int[][] field1 = {{0, 0, 0, 0, 0},
                          {0, 1, 1, 1, 0},
                          {0, 1, -1, 1, 0}};

        print(expandMineSweeperBFS(field1, 0, 2));
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

    public static int[][] expandMineSweeper(int[][] map, int x, int y) {
        if (map[x][y] != 0) {
            return map;
        } else {
            return expandMineSweeperRes(map, x, y);
        }
    }

    public static int[][] expandMineSweeperRes(int[][] map, int x, int y) {
        map[x][y] = -2;

        for (int i = x - 1; i < x + 1; i++) {
            for (int j = y - 1; j < y + 1; j++) {
                if (i >= 0 && j >= 0 && i < map.length && j < map[0].length && map[i][j] == 0) {
                    return expandMineSweeperRes(map, i, j);
                }
            }
        }

        return map;
    }

    static class Position {
        int x; int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] expandMineSweeperBFS(int[][] map, int x, int y) {
        Queue<Position> positions = new LinkedBlockingQueue<>();

        if (map[x][y] == 0) {
            map[x][y] = -2;
            positions.add(new Position(x, y));
        } else {
            return map;
        }

        while (!positions.isEmpty()) {
            Position currentPosition = positions.remove();

            int curX = currentPosition.x;
            int curY = currentPosition.y;

            for (int i = curX - 1; i <= curX + 1; i++) {
                for (int j = curY - 1; j <= curY + 1; j++) {
                    if (i >= 0 && i < map.length && j >= 0 && j < map[0].length && map[i][j] == 0) {
                        map[i][j] = -2;
                        positions.add(new Position(i, j));
                    }
                }
            }
        }

        return map;
    }
}
