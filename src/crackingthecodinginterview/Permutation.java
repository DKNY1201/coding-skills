package crackingthecodinginterview;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Bi on 7/28/18.
 */
public class Permutation {
    public static void main(String[] args) {

    }

    public static void printPermutation(String s, String b) {
        char[] chars = b.toCharArray();

        HashSet<String> set = permutation(s);

        for (int i = 0; i < chars.length - 4; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            String current4Chars = stringBuilder.append(chars[i]).append(chars[i+1])
                    .append(chars[i+2]).append(chars[i+3]).toString();
            if (set.contains(current4Chars)) {
                System.out.print(i + " ");
            }
        }
    }

    public static HashSet<String> permutation(String s) {
        HashSet<String> set = new HashSet<>();

        return set;
    }
}
