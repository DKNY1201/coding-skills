package crackingthecodinginterview.BitManipulate;

/**
 * Created by Bi on 8/11/18.
 */
public class ClearBitThoughN {
    public static void main(String[] args) {
        System.out.println(clearBitsMSBthroughI(31,4));
    }

    public static int clearBitsMSBthroughI(int num, int i) {
        int mask = (1 << i) - 1;
        return num & mask;
    }
}

