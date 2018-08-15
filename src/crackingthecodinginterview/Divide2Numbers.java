package crackingthecodinginterview;

/**
 * Created by Bi on 7/27/18.
 */
public class Divide2Numbers {
    public static void main(String[] args) {
        System.out.println(divide2Numbers(10,2));
        System.out.println(divide2Numbers(10,3));
        System.out.println(divide2Numbers(15,4));
        System.out.println(divide2Numbers(39,7));
    }

    public static int divide2Numbers(int a, int b) {
        int result = 0;
        int sum = b;

        while (sum <= a) {
            sum += b;
            result++;
        }

        return result;
    }
}
