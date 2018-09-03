package crackingthecodinginterview.StringAndArray;

/**
 * Created by Bi on 9/2/18.
 */
public class CheckPermutation {
    public static void main(String[] args) {
        System.out.println(checkPermutation("dog", "god"));
        System.out.println(checkPermutation("maharishi", "uit"));
        System.out.println(checkPermutation("race", "care"));
        System.out.println(checkPermutation("panama", "panana"));
        System.out.println(checkPermutation("conquydo11", "conquydo12"));
        System.out.println(checkPermutation("conquydo11", "con1quy1do"));
    }

    // Work for 128 character in ASCII table
    public static boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] store = new int[128];

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        for (int i = 0; i < chars1.length; i++) {
            store[chars1[i]]++;
        }

        for (int i = 0; i < chars2.length; i++) {
            store[chars2[i]]--;
        }

        for (int i = 0; i < 128; i++) {
            if (store[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
