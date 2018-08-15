package crackingthecodinginterview;

/**
 * Created by Bi on 7/27/18.
 */
public class SumDigits {
    public static void main(String[] args) {
        System.out.println(sumDigits(237));
        System.out.println(sumDigits(1234));
        System.out.println(sumDigits(4422));
        System.out.println(sumDigits(1212121));
        System.out.println(sumDigits(10010011));
    }

    public static int sumDigits(int d) {
        int result = 0;

        while (d > 0) {
            result += d % 10;
            d /= 10;
        }

        return result;
    }
}
