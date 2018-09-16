package crackingthecodinginterview.StringAndArray;

/**
 * Created by Bi on 9/13/18.
 */
public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("dknyaynkd"));
        System.out.println(isPalindrome("panamaamanap"));
        System.out.println(isPalindrome("dknyaynkddsdsdsds"));
    }
    // dknyaynkd
    public static boolean isPalindrome(String s) {
        Result result = isPalindrome(s.toCharArray(), 0, s.length());
        return result.truthy;
    }

    public static Result isPalindrome(char[] chars, int i, int len) {
        if (len == 0) {
            return new Result(chars[i], true, i);
        }

        if (len == 1) {
            return new Result(chars[i + 1], true, i + 1);
        }

        Result res = isPalindrome(chars, i + 1, len - 2);

        if (!res.truthy || res.nextIdx + 1 >= chars.length) {
            return res;
        }

        res.truthy = chars[i] == res.data;
        res.data = chars[res.nextIdx + 1];
        res.nextIdx = res.nextIdx + 1;

        return res;
    }
}

class Result {
    public char data;
    public boolean truthy;
    public int nextIdx;

    public Result(char data, boolean truthy, int nextIdx) {
        this.data = data;
        this.truthy = truthy;
        this.nextIdx = nextIdx;
    }
}