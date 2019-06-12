package String;

import java.util.Arrays;

/**
 * Created by Bi on 6/11/19.
 * https://leetcode.com/problems/orderly-queue/
 */
public class OrderlyQueue {
    public static void main(String[] args) {
        System.out.println(orderlyQueue("cba", 1));
        System.out.println(orderlyQueue("baaca", 3));
        System.out.println(orderlyQueue("tk", 1));
    }

    public static String orderlyQueue(String S, int K) {
        // K > 1 so we can swap any 2 adjacent elements so we can perform bubble sort
        if (K > 1) {
            char[] chars = S.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }

        // If K = 1 we generate all rotations and select smallest one
        String minStr = S;

        for (int i = 0; i < S.length(); i++) {
            String temp = S.substring(i);
            temp += S.substring(0, i);
            if (temp.compareTo(minStr) < 0) {
                minStr = temp;
            }
        }

        return minStr;
    }
}
