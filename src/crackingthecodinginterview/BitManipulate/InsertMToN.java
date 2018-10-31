package crackingthecodinginterview.BitManipulate;

/**
 * Created by Bi on 10/30/18.
 */
public class InsertMToN {
    public static void main(String[] args) {
        System.out.println(insertMToN(1024, 19, 2, 6));
    }

    public static int insertMToN(int n, int m, int i, int j) {
        int allOnes = ~0;

        int allOnesLeft = allOnes << (j + 1);
        int allOnesRight = (1 << i) - 1;

        int mask = allOnesLeft | allOnesRight;
        int nCleared = n & mask;
        int mShifted = m << i;

        return nCleared | mShifted;
    }
}
