package crackingthecodinginterview.BitManipulate;

/**
 * Created by Bi on 8/12/18.
 */
public class InsertBits {
    public static void main(String[] args) {
        System.out.println(insertBits(1024, 19, 2, 6));
    }

    public static int insertBits(int n, int m, int start, int end) {
        for (int i = start; i <= end; i++) {
            int lastBit = (m & 1) == 0 ? 0 : 1;
            m >>= 1;
            n = (~(lastBit << i) & n) | (lastBit << i);
        }

        return n;
    }
}
