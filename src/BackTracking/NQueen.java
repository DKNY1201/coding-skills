package BackTracking;

/**
 * Created by Bi on 5/24/19.
 */
public class NQueen {
    public static void main(String[] args) {
        System.out.println(canSolveNQueen(0));
        System.out.println(canSolveNQueen(1));
        System.out.println(canSolveNQueen(2));
        System.out.println(canSolveNQueen(3));
        System.out.println(canSolveNQueen(4));
        System.out.println(canSolveNQueen(5));
        System.out.println(canSolveNQueen(6));
        System.out.println(canSolveNQueen(7));
        System.out.println(canSolveNQueen(8));
        System.out.println(canSolveNQueen(9));
    }

    public static boolean canSolveNQueen(int n) {
        if (n < 1) return false;

        int[][] board = new int[n][n];

        boolean res = helper(board, 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        return res;
    }

    public static boolean helper(int[][] board, int col) {
        if (col >= board.length) return true;

        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (helper(board, col + 1)) return true;
                board[i][col] = 0;
            }
        }

        return false;
    }

    /**
     * Only need to check for left side of current col. Right side have not placed any queen yet.
     */
    public static boolean isSafe(int[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board.length) {
            return false;
        }

        // Check row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) return false;
        }

        // Check left upper diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        // Check left lower diagonal
        for (int i = row, j = col; i < board.length && j >= 0 ; i++, j--) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }
}
