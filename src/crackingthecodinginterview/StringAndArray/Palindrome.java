package crackingthecodinginterview.StringAndArray;

/**
 * Created by Bi on 9/13/18.
 */
public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("dknyaynkd"));
        System.out.println(isPalindrome("dknyaynkddsdsdsds"));
    }
    // dknyaynkd
    public static boolean isPalindrome(String s) {
        Result result = isPalindrome(s.toCharArray(), 0, s.length());
        return result.truthy;
    }

    public static Result isPalindrome(char[] chars, int i, int len) {
        if (len == 0) {
            return new Result(chars[i], true);
        }

        if (len == 1) {
            return new Result(chars[i + 1], true);
        }

        Result res = isPalindrome(chars, i + 1, len - 2);
        res.truthy = chars[i] == res.data;
        res.data = chars[i + 1];

        return res;
    }
}

class Result {
    public char data;
    public boolean truthy;

    public Result(char data, boolean truthy) {
        this.data = data;
        this.truthy = truthy;
    }
}