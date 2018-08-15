package crackingthecodinginterview;

/**
 * Created by Bi on 7/27/18.
 */
public class sqrt {
    public static void main(String[] args) {
        System.out.println(sqrt(100));
        System.out.println(sqrt(17));
        System.out.println(sqrt(16));
    }

    public static int sqrt(int n) {
        return sqrt(n, 1, n);
    }

    public static int sqrt(int n, int min, int max) {
        if (max < min) {
            return -1; // not found
        }

        int guess = (min + max) / 2;

        if (guess * guess == n) {
            return guess;
        } else if (guess * guess < n) {
            return sqrt(n, guess + 1, max);
        } else {
            return sqrt(n, min, guess - 1);
        }
    }

}
