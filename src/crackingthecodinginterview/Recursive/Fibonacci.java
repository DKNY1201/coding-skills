package crackingthecodinginterview.Recursive;

/**
 * Created by Bi on 8/12/18.
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci1(45));
        System.out.println(fibonacci2(45));
        System.out.println(fibonacci3(45));
        System.out.println(fibonacci4(45));
    }

    public static int fibonacci1(int i) {
        if (i == 0 || i == 1) {
            return i;
        }

        return fibonacci1(i - 1) + fibonacci1(i - 2);
    }

    public static int fibonacci2(int i) {
        return fibonnaci2Res(i, new int[i + 1]);
    }

    public static int fibonnaci2Res(int i, int[] memo) {
        if (i == 0 || i == 1) {
            return i;
        }

        if (memo[i] == 0) {
            memo[i] = fibonnaci2Res(i - 1, memo) + fibonnaci2Res(i - 2, memo);
        }

        return memo[i];
    }

    public static int fibonacci3(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int[] result = new int[n];

        result[0] = 0;
        result[1] = 1;

        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }

        return result[n - 1] + result[n - 2];
    }

    public static int fibonacci4(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int a = 0;
        int b = 1;

        for (int i = 2; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        return a + b;
    }
}
