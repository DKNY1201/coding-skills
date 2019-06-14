package BackTracking;

import java.util.HashSet;

/**
 * Created by Bi on 6/13/19.
 * https://leetcode.com/problems/letter-tile-possibilities/
 */
public class LetterTilePossibilities {
    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB"));
        System.out.println(numTilePossibilities("AABB"));
        System.out.println(numTilePossibilities("AAABBC"));
        System.out.println(numTilePossibilities("ABC"));
    }

    public static int numTilePossibilities(String tiles) {
        char[] tileChars = tiles.toCharArray();
        if (tileChars.length == 0 || tileChars.length == 1) return tileChars.length;
        HashSet<String> uniqueStrs = new HashSet<>();

        permutate(tileChars, tileChars.length - 1, uniqueStrs);

        return uniqueStrs.size();
    }

    public static void permutate(char[] tiles, int i, HashSet<String> uniqueStrs) {
        // Base case - only have one char so add that char to uniqueStrs
        if (i == 0) {
            uniqueStrs.add(String.valueOf(tiles[i]));
            return;
        }

        permutate(tiles, i - 1, uniqueStrs);
        HashSet<String> curRoundUniqueStrs = new HashSet<>();

        for (String s: uniqueStrs) {
            // For each letter we generate new letter by concatenate with current tile letter at every index
            for (int j = 0; j <= s.length(); j++) {
                curRoundUniqueStrs.add(s.substring(0, j) + tiles[i] + s.substring(j));
            }
        }
        // Remember to add current tile letter
        curRoundUniqueStrs.add(String.valueOf(tiles[i]));

        uniqueStrs.addAll(curRoundUniqueStrs);
    }
}
