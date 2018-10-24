package leetcode.String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bi on 9/23/18.
 */
public class FindAndReplacePattern {
    public static void main(String[] args) {
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        System.out.println(findAndReplacePattern(words, "abb"));
    }
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ret = new ArrayList<>();
        for (String w : words) {
            if (isPermutation(w, pattern)) {
                ret.add(w);
            }
        }
        return ret;
    }

    private static boolean isPermutation(String word, String p) {
        int[] wPos = new int[26];
        int[] pPos = new int[26];
        for (int i = 0; i < word.length(); i++) {
            if (wPos[word.charAt(i) - 'a'] != pPos[p.charAt(i) - 'a']) {
                return false;
            } else {
                wPos[word.charAt(i) - 'a'] = i + 1;
                pPos[p.charAt(i) - 'a'] = i + 1;
            }
        }
        return true;
    }
}
