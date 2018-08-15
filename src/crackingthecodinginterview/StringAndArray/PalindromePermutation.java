package crackingthecodinginterview.StringAndArray;

import java.util.Hashtable;

/**
 * Created by Bi on 8/1/18.
 */
public class PalindromePermutation {
    public static void main(String[] args) {
        System.out.println(isPermutationIsPalindrome("aabbccdd"));
        System.out.println(isPermutationIsPalindrome("aabsbccdd"));
        System.out.println(isPermutationIsPalindrome("aabsdabccdd"));
        System.out.println(isPermutationIsPalindrome("aabbccddeee"));
        System.out.println("====================");
        System.out.println(isPermutationIsPalindrome2("aabbccdd"));
        System.out.println(isPermutationIsPalindrome2("aabsbccdd"));
        System.out.println(isPermutationIsPalindrome2("aabsdabccdd"));
        System.out.println(isPermutationIsPalindrome2("aabbccddeee"));
    }

    public static boolean isPermutationIsPalindrome(String s) {
        Hashtable<Character, Integer> table = new Hashtable<>();

        for (char c: s.toCharArray()) {
            if (table.containsKey(c)) {
                table.put(c, table.get(c) + 1);
            } else {
                table.put(c, 1);
            }
        }

        int odd = 0;

        for (int val: table.values()) {
            if (val % 2 == 1) {
                if(++odd > 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isPermutationIsPalindrome2(String s) {
        int checker = 0;

        for (char c: s.toCharArray()) {
            int mask = 1 << c - 'a';
            if ((checker & mask) == 0) {
                checker |= mask;
            } else {
                checker &= ~mask;
            }
        }

        return checker == 0 ? true : (checker & (checker - 1)) == 0 ? true : false;
    }
}
