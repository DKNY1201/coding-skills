package crackingthecodinginterview;

import java.util.Hashtable;

/**
 * Created by Bi on 7/28/18.
 */
public class NumberOfDifferentPairs {
    public static void main(String[] args) {
        System.out.println(numberOfDifferentPairs(new int[] {1,7,5,9,2,12,3}, 2));
        System.out.println(numberOfDifferentPairs(new int[] {1,3,8,5}, 2));
        System.out.println(numberOfDifferentPairs(new int[] {3,1,0,-1,2,55,5,7,9,8,4}, 4));
        System.out.println(numberOfDifferentPairs2(new int[] {1,7,5,9,2,12,3}, 2));
        System.out.println(numberOfDifferentPairs2(new int[] {1,3,8,5}, 2));
        System.out.println(numberOfDifferentPairs2(new int[] {3,1,0,-1,2,55,5,7,9,8,4}, 4));
    }

    public static int numberOfDifferentPairs(int[] arr, int k) {
        int result = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            int cur = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (Math.abs(cur - arr[j]) == k) {
                    result++;
                }
            }
        }

        return result;
    }

    public static int numberOfDifferentPairs2(int[] arr, int k) {
        Hashtable<Integer, Integer> table = new Hashtable<>();
        int result = 0;

        for (int i: arr) {
            table.put(i, 0);
        }

        for (int i: arr) {
            if (table.containsKey(i + k) && table.get(i + k) == 0) {
                result++;
            }

            if (table.containsKey(i - k) && table.get(i - k) == 0) {
                result++;
            }

            table.put(i, 1);
        }

        return result;
    }
}
