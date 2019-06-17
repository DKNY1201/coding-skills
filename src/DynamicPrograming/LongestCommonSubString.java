package DynamicPrograming;

/**
 * Created by Bi on 6/16/19.
 */
public class LongestCommonSubString {
    public static void main(String[] args) {
        System.out.println(longestCommonSubString("abcdaf", "zbcdf"));
        System.out.println(longestCommonSubString("GeeksforGeeks", "GeeksQuiz"));
        System.out.println(longestCommonSubString("abcdxyz", "xyzabcd"));
        System.out.println(longestCommonSubString("zxabcdezy", "yzabcdezx"));

        System.out.println();

        System.out.println(longestCommonSubStringRes("abcdaf", "zbcdf"));
        System.out.println(longestCommonSubStringRes("GeeksforGeeks", "GeeksQuiz"));
        System.out.println(longestCommonSubStringRes("abcdxyz", "xyzabcd"));
        System.out.println(longestCommonSubStringRes("zxabcdezy", "yzabcdezx"));
    }

    /**
     * This problem turn out another problem
     * Finding longest common suffix (LCS) of all pairs of s1 & s2. The longest one is the longest common substring
     *
     */
    public static String longestCommonSubString(String s1, String s2) {
        int max = 0;
        int maxR = 0;
        int maxC = 0;
        int m = s1.length();
        int n = s2.length();
        int[][] table = new int[m + 1][n + 1];

        for (int r = 0; r <= m; r++) {
            for (int c = 0; c <= n; c++) {
                if (r == 0 || c == 0) {
                    table[r][c] = 0;
                    continue;
                }

                // LCS of 2 strings have same ending character = LCS of 2 strings without that ending character + 1
                if (s1.charAt(r - 1) == s2.charAt(c - 1)) {
                    table[r][c] = table[r - 1][c - 1] + 1;
                    if (table[r][c] > max) {
                        max = table[r][c];
                        // Store row and col of max LCS to get sub string later
                        maxR = r;
                        maxC = c;
                    }
                } else {
                    table[r][c] = 0;
                }
            }
        }

        String temp = "";
        while(table[maxR][maxC] != 0) {
            temp += s1.charAt(maxR - 1);
            maxR--;
            maxC--;
        }

        // Reverse temp to get actual result
        String result = "";
        for (int i = temp.length() - 1; i >= 0; i--) {
            result += temp.charAt(i);
        }

        return result;
    }

    static int max = 0;

    public static int longestCommonSubStringRes(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) {
            return 0;
        }

        max = 0;

        helper(s1, s2, s1.length() - 1, s2.length() - 1, 0);

        return max;
    }

    public static void helper(String s1, String s2, int i, int j, int count) {
        // base case
        if (i < 0 || j < 0) {
            max = Math.max(count, max);
        } else if (s1.charAt(i) == s2.charAt(j)) {
            count++;
            max = Math.max(count, max);
            helper(s1, s2, i - 1, j - 1, count);
        } else {
            helper(s1, s2, i - 1, j, 0);
            helper(s1, s2, i, j - 1, 0);
        }
    }
}
