package Number;

/**
 * Created by Bi on 6/14/19.
 */
public class PrintNumberVertical {
    public static void main(String[] args) {
        printNumberVertical(12345);
        printNumberVertical(1);
        printNumberVertical(0);
    }

    public static void printNumberVertical(int n) {
        if (n < 10) {
            System.out.println(n);
            return;
        }

        // x is multiple of 10 right under n
        // n = 12345 => x = 10000
        int x = 1;
        int temp = n;

        while (temp >= 10) {
            temp /= 10;
            x *= 10;
        }

        while (n > 0) {
            System.out.println(n / x);
            n %= x;
            x /= 10;
        }
    }
}
