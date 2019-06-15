package String;

import java.util.Arrays;

/**
 * Created by Bi on 6/15/19.
 */
public class Utils {
    public static int[] generateSuffixArray(String s) {
        int len = s.length();
        Suffix[] suffixes = new Suffix[len];

        for (int i = 0; i < len; i++) {
            Suffix sf = new Suffix(s, i);
            suffixes[i] = sf;
        }

        Arrays.sort(suffixes);
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            res[i] = suffixes[i].index;
        }

        return res;
    }

    public static int[] generateLCP(String s, int[] sa) {
        int len = s.length();
        int[] LCP = new int[len];
        LCP[0] = 0;

        for (int i = 1; i < len; i++) {
            String s1 = s.substring(sa[i]);
            String s2 = s.substring(sa[i - 1]);
            // Length of shorter string
            int n = s1.length() < s2.length() ? s1.length() : s2.length();
            int val = 0;

            for (int j = 0; j < n; j++) {
                if (s1.charAt(j) == s2.charAt(j)) {
                    val++;
                } else {
                    break;
                }
            }

            LCP[i] = val;
        }

        return LCP;
    }
}
