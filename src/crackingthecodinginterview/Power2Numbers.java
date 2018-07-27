package crackingthecodinginterview;

/**
 * Created by Bi on 7/26/18.
 */
public class Power2Numbers {
    public static void main(String[] args) {
        System.out.println(power(2,3));
        System.out.println(power(8,4));
        System.out.println(power(4,2));
        System.out.println(powerRes(2,0));
        System.out.println(powerRes(8,4));
        System.out.println(powerRes(4,2));
    }

    public static int power(int a, int b) {
        int result = 1;

        for (int i = 0; i < b; i++) {
            result *= a;
        }

        return result;
    }

    public static int powerRes(int a, int b) {
        if (b < 0) {
            return 0;
        }
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        return a * powerRes(a, b - 1);
    }
}
