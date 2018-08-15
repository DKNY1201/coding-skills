package crackingthecodinginterview;

/**
 * Created by Bi on 7/27/18.
 */
public class Mod2Numbers {
    public static void main(String[] args) {
        System.out.println(mod2Numbers(10,3));
        System.out.println(mod2Numbers(10,-3));
        System.out.println(mod2Numbers(-10,-3));
        System.out.println(mod2Numbers(-10,4));
    }

    public static int mod2Numbers(int a, int b) {
        if (b == 0) {
            return -1;
        }

        int div = a / b;

        return a - div * b;
    }
}
