package DynamicPrograming;

import java.util.HashMap;

/**
 * Created by Bi on 5/2/19.
 */
public class LongestCommonSubSequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubSequence("abcdaf","acbcf"));
        System.out.println(longestCommonSubSequence("BCD","CDEB"));
    }

    public static int longestCommonSubSequence(String s1, String s2) {
        if (s1 == null || s2 == null) return 0;
//        return recursive(s1, s2, s1.length() - 1, s2.length() - 1);
//        return memoize(s1, s2, s1.length() - 1, s2.length() - 1, new HashMap<String, Integer>());
        return bottomUp(s1, s2);
    }

    public static int recursive(String s1, String s2, int i, int j) {
        if (i < 0 || j < 0) return 0;

        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + recursive(s1, s2, i - 1, j - 1);
        }

        return Math.max(recursive(s1, s2, i - 1, j), recursive(s1, s2, i, j - 1));
    }

    public static int memoize(String s1, String s2, int i, int j, HashMap<String, Integer> map) {
        String key = i + ":" + j;

        if (map.containsKey(key)) return map.get(key);
        if (i < 0 || j < 0) return 0;

        int res;

        if (s1.charAt(i) == s2.charAt(j)) {
            res = 1 + recursive(s1, s2, i - 1, j - 1);
        } else {
            res = Math.max(recursive(s1, s2, i - 1, j), recursive(s1, s2, i, j - 1));
        }

        map.put(key, res);

        return res;
    }

    public static int bottomUp(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int[][] table = new int[chars1.length + 1][chars2.length + 1];

        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[0].length; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }

        return table[table.length - 1][table[0].length - 1];
    }
}
