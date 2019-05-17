package String;

/**
 * Created by Bi on 8/16/18.
 */
public class OneWayString {
    public static void main(String[] args) {
        System.out.println(isOneAway("abcde", "abcd"));
        System.out.println(isOneAway("abde", "abcde"));
        System.out.println(isOneAway("a", "a"));
        System.out.println(isOneAway("abcdef", "abqdef"));
        System.out.println(isOneAway("abcdef", "abccef"));
        System.out.println(isOneAway("abcdef", "abcde"));
        System.out.println(isOneAway("aaa", "abc"));
        System.out.println(isOneAway("abcde", "abc"));
        System.out.println(isOneAway("abc", "abcde"));
        System.out.println(isOneAway("abc", "bcc"));
        // should return true
        // should return true
        // should return true
        // should return true
        // should return true
        // should return true
        // should return false
        // should return false
        // should return false
        // should return false
        System.out.println("========");
        System.out.println(isOneAway1("abcde", "abcd"));
        System.out.println(isOneAway1("abde", "abcde"));
        System.out.println(isOneAway1("a", "a"));
        System.out.println(isOneAway1("abcdef", "abqdef"));
        System.out.println(isOneAway1("abcdef", "abccef"));
        System.out.println(isOneAway1("abcdef", "abcde"));
        System.out.println(isOneAway1("aaa", "abc"));
        System.out.println(isOneAway1("abcde", "abc"));
        System.out.println(isOneAway1("abc", "abcde"));
        System.out.println(isOneAway1("abc", "bcc"));
    }

    public static boolean isOneAway(String a, String b) {
        if (Math.abs(a.length() - b.length()) > 1) {
            return false;
        }

        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        if (aChars.length == bChars.length) {
            int nDiff = 0;

            for (int i = 0; i < aChars.length; i++) {
                if (aChars[i] != bChars[i]) {
                    nDiff++;
                    if (nDiff > 1) {
                        return false;
                    }
                }
            }

            return true;
        } else {
            char[] shortArr = aChars.length > bChars.length ? bChars : aChars;
            char[] longArr = aChars.length > bChars.length ? aChars : bChars;

            int i = 0, j = 0;
            int nDiff = 0;
            while (i < shortArr.length) {
                if (shortArr[i] == longArr[j]) {
                    i++; j++;
                } else {
                    j++; nDiff++;
                    if (nDiff > 1) {
                        return false;
                    }
                }
            }

            return true;
        }
    }

    public static boolean isOneAway1(String a, String b) {
        if (Math.abs(a.length() - b.length()) > 1) {
            return false;
        }

        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int aLen = aChars.length;
        int bLen = bChars.length;

        char[] shortArr = aLen > bLen ? bChars : aChars;
        char[] longArr = aLen > bLen ? aChars : bChars;

        int i = 0, j = 0;
        int nDiff = 0;
        while (i < shortArr.length) {
            if (shortArr[i] == longArr[j]) {
                i++; j++;
            } else {
                j++; nDiff++;

                if (nDiff > 1) {
                    return false;
                }

                if (aLen == bLen) {
                    i++;
                }
            }
        }

        return true;
    }
}
