package Dojo.Array.String;

import java.util.Hashtable;

/**
 * Created by Bi on 8/16/18.
 */
public class FindUniqueChar {
    public static void main(String[] args) {
        System.out.println(findUniqueChar("aabcb"));
        System.out.println(findUniqueChar("aabccb"));
        System.out.println(findUniqueChar("aaaabbbeeqdcssq"));
    }

    public static Character findUniqueChar(String str) {
        Hashtable<Character, Integer> table = new Hashtable<>();

        if (str == null || str.length() == 0) {
            return null;
        }

        for (char c: str.toCharArray()) {
            if (!table.containsKey(c)) {
                table.put(c, 1);
            } else {
                table.put(c, table.get(c) + 1);
            }
        }

        for (char c: str.toCharArray()) {
            if (table.get(c) == 1) {
                return c;
            }
        }

        return null;
    }
}
