package String;

/**
 * Created by Bi on 6/15/19.
 */
public class UniqueSubStrings {
    public static void main(String[] args) {
        System.out.println(uniqueSubStrings("AZAZA"));
        System.out.println(uniqueSubStrings("banana"));
        System.out.println(uniqueSubStrings("a"));
    }

    public static int uniqueSubStrings(String s) {
        int[] suffixArr = Utils.generateSuffixArray(s);
        int[] LCP = Utils.generateLCP(s, suffixArr);
        int len = s.length();
        int totalRepeatedSubStrings = 0;
        int totalSubStrings = len * (len + 1) / 2;

        for (int n: LCP) {
            totalRepeatedSubStrings += n;
        }

        return totalSubStrings - totalRepeatedSubStrings;
    }
}
