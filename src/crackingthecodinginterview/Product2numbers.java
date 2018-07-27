package crackingthecodinginterview;

/**
 * Created by Bi on 7/26/18.
 */
class Product2Numbers {
    public static void main(String[] args) {
        System.out.println(product(2, 7));
        System.out.println(product(3, 10));
        System.out.println(product(2, 2));
    }

    public static int product(int a, int b) {
        int result = 0;

        for (int i = 0; i < b; i++) {
            result += a;
        }

        return result;
    }
}
