package crackingthecodinginterview.StringAndArray;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Hashtable;

/**
 * Created by Bi on 7/29/18.
 */
public class IsUnique {
    public static void main(String[] args) {
//        System.out.println(isUnique1("abcdef"));
//        System.out.println(isUnique1("students"));
//        System.out.println(isUnique1("studenz"));
//        System.out.println("===========================");
//        System.out.println(isUnique2("abcdef"));
//        System.out.println(isUnique2("students"));
//        System.out.println(isUnique2("studenz"));
        System.out.println("===========================");
        System.out.println(isUnique3("abcdef"));
        System.out.println(isUnique3("students"));
        System.out.println(isUnique3("studenzrt"));
        System.out.println("===========================");
//        System.out.println(isUnique4("abcdef"));
//        System.out.println(isUnique4("students"));
//        System.out.println(isUnique4("studenz"));
//        System.out.println("===========================");
//        System.out.println(isUnique5("abcdef"));
//        System.out.println(isUnique5("students"));
//        System.out.println(isUnique5("studenz"));
//        System.out.println(isUnique5("!@#$%^&*(!)123467890qwertyuiQWERTY"));
//        System.out.println(isUnique5("!@#$%^&*()123467890qwertyuiQWERTY"));
    }

    public static boolean isUnique1(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return true;
        }

        Hashtable<Character, Integer> table = new Hashtable<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (table.containsKey(c)) {
                return false;
            }
            table.put(c, 0);
        }

        return true;
    }

    public static boolean isUnique2(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return true;
        }

        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static boolean isUnique3(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return true;
        }

        if (s.length() > 128) {
            return false;
        }

        boolean[] ascii = new boolean[128];

        for (char c: s.toCharArray()) {
            int index = (int) c;
            System.out.println(c + ": " + index);
            if (ascii[index]) {
                return false;
            }

            ascii[index] = true;
        }

        return true;
    }

    // limit 26 char, a - z
    // Time complexity: O(1) because only 26 chars
    // Space complexity: O(1)
    public static boolean isUnique4(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return true;
        }

        int mask = 0;

        for (char c: s.toCharArray()) {
            int cBit = 1 << (c - 'a');
            if ((mask & cBit) > 0) {
                return false;
            }

            mask |= cBit;
        }

        return true;
    }

    // 256 chars
    // Time complexity: O(1) because only 256 chars
    // Space complexity: O(1)
    public static boolean isUnique5(String s) {
        int[] masks = new int[8];

        for (int c: s.toCharArray()) {
            int maskNum = c / 32;
            int cInMask = c % 32;
            int cBit = 1 << cInMask;
            if ((masks[maskNum] & cBit) > 0) {
                return false;
            }

            masks[maskNum] |= cBit;
        }

        return true;
    }
}
