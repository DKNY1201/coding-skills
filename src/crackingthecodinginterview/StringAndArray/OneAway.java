package crackingthecodinginterview.StringAndArray;

/**
 * Created by Bi on 8/3/18.
 */
public class OneAway {
    public static void main(String[] args) {
        System.out.println(oneAway("apple", "appee"));
        System.out.println(oneAway("apple", "aple"));
        System.out.println(oneAway("monkey", "monkeys"));
        System.out.println(oneAway("monkey", "monkyas"));
        System.out.println(oneAway("monkey", "monks"));
        System.out.println("=======================");
        System.out.println(oneAwayCombine("apple", "appee"));
        System.out.println(oneAwayCombine("apple", "aple"));
        System.out.println(oneAwayCombine("monkey", "monkeys"));
        System.out.println(oneAwayCombine("monkey", "monkyas"));
        System.out.println(oneAwayCombine("monkey", "monks"));
    }

    public static boolean oneAway(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }

        if (s.length() == t.length()) {
            return oneAwayEqual(s, t);
        }

        return oneAwayDiff(s, t);
    }

    public static boolean oneAwayEqual(String s, String t) {
        boolean oneDiff = false;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != tChars[i]) {
                if (oneDiff) {
                    return false;
                }

                oneDiff = true;
            }
        }

        return true;
    }

    public static boolean oneAwayDiff(String s, String t) {
        String str1 = s.length() < t.length() ? s : t;
        String str2 = s.length() < t.length() ? t : s;

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int i = 0, j = 0;

        while (i < chars1.length && j < chars2.length) {
            if (chars1[i] != chars2[j]) {
                if (i != j) {
                    return false;
                }
                j++;
                continue;
            }
            i++; j++;
        }

        return true;
    }

    public static boolean oneAwayCombine(String s, String t) {
        String str1 = s.length() < t.length() ? s : t;
        String str2 = s.length() < t.length() ? t : s;

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int i = 0, j = 0;

        boolean oneDif = false;
        while (i < chars1.length && j < chars2.length) {
            if (chars1[i] != chars2[j]) {
                if (oneDif) {
                    return false;
                }
                oneDif = true;

                if (chars1.length == chars2.length) {
                    i++;
                }

                j++;
                continue;
            }
            i++; j++;
        }

        return true;
    }
}
