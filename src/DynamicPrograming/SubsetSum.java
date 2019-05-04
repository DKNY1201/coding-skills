package DynamicPrograming;

import java.util.HashSet;

/**
 * Created by Bi on 5/3/19.
 */
public class SubsetSum {
    public static void main(String[] args) {
        boolean res1 = subsetSum(new int[] {3, 34, 4, 12, 5, 2}, 9);
        boolean res2 = subsetSum(new int[] {3, 34, 8, 12, 5, 2}, 9);
        System.out.println(res1);
        System.out.println(res2);
    }

    /**
     *
     * @param nums: Array of integer
     * @param k: total
     * @return whether there is any subset of nums that has sum equal to k
     */
    public static boolean subsetSum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
//        return recursive(nums, k, nums.length - 1);
//        return memoize(nums, k, nums.length - 1, new HashSet<>());
        return bottomUp(nums, k);
    }

    public static boolean recursive(int[] nums, int k, int i) {
        // Base case
        if (i < 0) {
            return false;
        }

        // After minus some value that should be included in the subset, k will equal to 0
        // When k = 0, the is an empty subset will satisfy the condition
        if (k == 0) {
            return true;
        }

        if (nums[i] > k) {
            return recursive(nums, k , i - 1);
        }

        return recursive(nums, k - nums[i] , i - 1) || recursive(nums, k , i - 1);
    }

    public static boolean memoize(int[] nums, int k, int i, HashSet<String> map) {
        String key = k + ":" + i;

        if (map.contains(key)) {
            return true;
        }

        // Base case
        if (i < 0) {
            return false;
        }

        // After minus some value that should be included in the subset, k will equal to 0
        // When k = 0, the is an empty subset will satisfy the condition
        if (k == 0) {
            return true;
        }

        boolean res;

        if (nums[i] > k) {
            res = recursive(nums, k , i - 1);
        } else {
            res = recursive(nums, k - nums[i] , i - 1) || recursive(nums, k , i - 1);
        }

        map.add(key);

        return res;
    }

    public static boolean bottomUp(int[] nums, int k) {
        boolean[][] table = new boolean[nums.length][k + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= k; j++) {
                if (nums[i] == j) {
                    table[i][j] = true;
                } else if (nums[i] > j) {
                    // If we are examining on the first row we should return false
                    table[i][j] = i > 0 ? table[i - 1][j] : false;
                } else {
                    table[i][j] = i > 0 ? table[i - 1][j] || table[i - 1][j - nums[i]] : false;
                }
            }
        }

        return table[table.length - 1][table[0].length - 1];
    }
}
