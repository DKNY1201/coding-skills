package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bi on 6/11/19.
 * https://leetcode.com/problems/find-and-replace-pattern/
 */
public class FindAndReplacePattern {
    public static void main(String[] args) {
        System.out.println(findAndReplacePattern(new String[] {"abc","deq","mee","aqq","dkd","ccc"}, "abb"));
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();

        for (String word: words) {
            char[] cWords = word.toCharArray();
            char[] cPattern = pattern.toCharArray();

            if (cWords.length != cPattern.length) {
                continue;
            }

            char[] wordToPattern = new char[26];
            char[] patternToWord = new char[26];
            boolean isMatch = true;

            for (int i = 0; i < cWords.length; i++) {
                int w = cWords[i] - 'a';
                int p = cPattern[i] - 'a';

                // Store to wordToPattern if not existing otherwise break if not equal
                if (wordToPattern[w] != '\u0000') {
                    if (wordToPattern[w] != cPattern[i]) {
                        isMatch = false;
                        break;
                    }
                } else {
                    wordToPattern[w] = cPattern[i];
                }

                // Store to patternToWord if not existing otherwise break if not equal
                if (patternToWord[p] != '\u0000') {
                    if (patternToWord[p] != cWords[i]) {
                        isMatch = false;
                        break;
                    }
                } else {
                    patternToWord[p] = cWords[i];
                }
            }

            if (isMatch) {
                res.add(word);
            }
        }

        return res;
    }
}
