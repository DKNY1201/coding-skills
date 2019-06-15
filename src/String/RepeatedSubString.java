package String;

import java.util.Arrays;

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

    public static int repeatedSubString(String s) {
        int[] suffixesArr = generateSuffixArray(s);
        // Longest common prefix
        int[] LCP = generateLCP(s, suffixesArr);
        int res = 0;

        for (int i = 1; i < LCP.length; i++) {
            if (LCP[i] > LCP[i - 1]) {
                res += LCP[i] - LCP[i - 1];
            }
        }

        return res;
    }

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

class Suffix implements Comparable<Suffix> {
    String text;
    int index;

    public Suffix(String text, int index) {
        this.text = text;
        this.index = index;
    }

    public char charAt(int i) {
        return text.charAt(index + i);
    }

    public String toString() {
        return text.substring(index);
    }

    public int length() {
        return text.length() - index;
    }

    public int compareTo(Suffix that) {
        if (this == that) return 0;

        // n is length of shorter string
        // Only need to compare till the end of shorter string
        int n = this.length() < that.length() ? this.length() : that.length();

        for (int i = 0; i < n; i++) {
            if (this.charAt(i) < that.charAt(i)) {
                return -1;
            } else if (this.charAt(i) > that.charAt(i)) {
                return 1;
            }
        }

        // If all chars are equal than compare their length
        // aab
        // aabc
        return this.length() - that.length();
    }
}