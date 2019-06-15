package String;

/**
 * Created by Bi on 6/14/19.
 */
public class RepeatedSubString {
    public static void main(String[] args) {
        System.out.println(repeatedSubString("banana"));
        System.out.println(repeatedSubString("aabaab"));
        System.out.println(repeatedSubString("aaaaa"));
        System.out.println(repeatedSubString("AaAaA"));
    }

    /**
     * suffix string array = [banana, anana, nana, ana, na, a]
     * after sorted with index = [a (5), ana (3), anana(1), banana(0), na(4), nana(2)]
     * suffix array = [5, 3, 1, 0, 4, 2]
     * LCP = [0, 1, 3, 0, 0, 2]. Note: 1st of LCP always 0
     *
     * suffix strings       suffix array        LCP
     * a                        5                0
     * ana                      3                1
     * anana                    1                3
     * banana                   0                0
     * na                       4                0
     * nana                     2                2
     */
    public static int repeatedSubString(String s) {
        int[] suffixesArr = Utils.generateSuffixArray(s);
        // Longest common prefix
        int[] LCP = Utils.generateLCP(s, suffixesArr);
        int res = 0;

        for (int i = 1; i < LCP.length; i++) {
            if (LCP[i] > LCP[i - 1]) {
                res += LCP[i] - LCP[i - 1];
            }
        }

        return res;
    }
}
