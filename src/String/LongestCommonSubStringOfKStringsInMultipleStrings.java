package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Bi on 6/17/19.
 * https://www.youtube.com/watch?v=Ic80xQFWevc
 */
public class LongestCommonSubStringOfKStringsInMultipleStrings {
    Suffix[] suffixes;
    String[] sentinels = new String[] {"!", "#", "%", "&", "(", ")", "*", "+", ",", "-", "."};

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("AABC");
        list.add("BCDC");
        list.add("BCDE");
        list.add("CDED");
        LongestCommonSubStringOfKStringsInMultipleStrings lcs = new LongestCommonSubStringOfKStringsInMultipleStrings();
        System.out.println(lcs.longestCommonSubStringOfKStringsInMultipleStrings(list, 2));
        System.out.println(lcs.longestCommonSubStringOfKStringsInMultipleStrings(list, 3));
        System.out.println(lcs.longestCommonSubStringOfKStringsInMultipleStrings(list, 4));

        List<String> list1 = new ArrayList<>();
        list1.add("abca");
        list1.add("bcad");
        list1.add("daca");
        LongestCommonSubStringOfKStringsInMultipleStrings lcs1 = new LongestCommonSubStringOfKStringsInMultipleStrings();
        System.out.println(lcs1.longestCommonSubStringOfKStringsInMultipleStrings(list1, 2));
        System.out.println(lcs1.longestCommonSubStringOfKStringsInMultipleStrings(list1, 3));
        System.out.println(lcs1.longestCommonSubStringOfKStringsInMultipleStrings(list1, 4));
    }

    public int[] generateSuffixArray(String s) {
        int len = s.length();
        suffixes = new Suffix[len];
        int stringOrder = 0;

        for (int i = 0; i < len; i++) {
            for (String sentinel: sentinels) {
                if (sentinel.compareTo(String.valueOf(s.charAt(i))) == 0) {
                    stringOrder++;
                    break;
                }
            }

            Suffix sf = new Suffix(s, i, stringOrder);
            suffixes[i] = sf;
        }

        Arrays.sort(suffixes);
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            res[i] = suffixes[i].index;
        }

        return res;
    }

    public List<String> longestCommonSubStringOfKStringsInMultipleStrings(List<String> strs, int k) {
        if (k < 2 || k > strs.size()) {
            return null;
        }
        // Text to create suffix array
        String T = unionString(strs);
        int[] suffixArray = generateSuffixArray(T);
        int[] LCP = Utils.generateLCP(T, suffixArray);
        // Top and bottom bounder of sliding window
        int i = 0, j = 0;
        // Store number of suffix array in sliding window so we can check whether
        // we have enough k strings in window or not
        int[] checker = new int[strs.size()];
        // Store all substrings have max length all the way dow, will remove some incorrect substrings later
        List<String> tempStrings = new ArrayList<>();
        // Store max length of substrings
        int max = 0;

        // Skip all suffixes start with setinels letter
        for (Suffix suffix: suffixes) {
            for (String sentinel: sentinels) {
                if (sentinel.compareTo(String.valueOf(suffix.charAt(0))) == 0) {
                    i++;
                    j++;
                    break;
                }
            }
        }

        // Start sliding window
        while (i < LCP.length && j < LCP.length) {
            if (isKStringInWindow(checker, k)) {
                int LCPInWindow = Integer.MAX_VALUE;
                // Ignore 1st suffix in window
                for (int m = i + 1; m < j; m++) {
                    LCPInWindow = Math.min(LCPInWindow, LCP[m]);
                }

                // Update max and result
                if (LCPInWindow >= max) {
                    max = LCPInWindow;
                    tempStrings.add(suffixes[i].text.substring(suffixes[i].index, suffixes[i].index + max));
                }

                // Shrink the window
                checker[suffixes[i].stringOrder]--;
                i++;
            } else {
                // Expand the window
                checker[suffixes[j].stringOrder]++;
                j++;
            }
        }

        List<String> result = new ArrayList<>();

        // Only get longest common substring
        for (String s: tempStrings) {
            if (s.length() == max) {
                result.add(s);
            }
        }

        return result;
    }

    /**
     * Check in checker have enough strings that we need to examine
     */
    public boolean isKStringInWindow(int[] checker, int k) {
        int count = 0;

        for (int num: checker) {
            if (num > 0) {
                count++;
            }

            if (count == k) {
                return true;
            }
        }

        return false;
    }

    /**
     * Currently support 11 strings in list according to limited number of
     * unique sentinels have lexicographically less than a-z, A-Z
     */
    public String unionString(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strs.size(); i++) {
            sb.append(strs.get(i));
            sb.append(sentinels[i]);
        }

        return sb.toString();
    }
}
