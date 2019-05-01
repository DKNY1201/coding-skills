package DynamicPrograming;

import java.util.HashMap;

/**
 * Created by Bi on 4/30/19.
 */
public class NumOfSubArrayAddUpToK {
    public static void main(String[] args) {
        System.out.println(numOfSubArrayAddUpToK(new int[] {2, 4, 6, 10}, 16));
        System.out.println(numOfSubArrayAddUpToK(new int[] {}, 16));
        System.out.println(numOfSubArrayAddUpToK(new int[] {1,2,3}, 0));
        System.out.println(numOfSubArrayAddUpToK(new int[] {3,2,7, 8,10,4,6}, 14));

        System.out.println("=========");

        System.out.println(numOfSubArrayAddUpToK(new int[] {2, 4, 6, 10}, 16));
        System.out.println(numOfSubArrayAddUpToK(new int[] {}, 16));
        System.out.println(numOfSubArrayAddUpToK(new int[] {1,2,3}, 0));
        System.out.println(numOfSubArrayAddUpToK(new int[] {3,2,7, 8,10,4,6}, 14));
    }

    public static int numOfSubArrayAddUpToK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }

        return recursive(nums, k, nums.length - 1);
    }

    /**
     * @Input:
     * nums: array of number
     * total: total that sub array will add up to
     * i: current element we will examine
     */
    public static int recursive(int[] nums, int total, int i) {
        // base case
        if (total == 0) {
            return 1;
        }

        if (i == 0) {
            if (nums[i] == total) return 1;
            else return 0;
        }

        // recursive case
        if (nums[i] > total) {
            return recursive(nums, total, i - 1);
        }

        return recursive(nums, total, i - 1) + recursive(nums, total - nums[i], i - 1);
    }

    /**
     * @Input:
     * nums: array of number
     * total: total that sub array will add up to
     * i: current element we will examine
     */
    public static int memoize(int[] nums, int total, int i, HashMap<String, Integer> memo) {
        String key = total + ":" + i;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // base case
        if (total == 0) {
            return 1;
        }

        if (i == 0) {
            if (nums[i] == total) return 1;
            else return 0;
        }

        int val = 0;
        // recursive case
        if (nums[i] > total) {
            val = recursive(nums, total, i - 1);
        } else {
            val = recursive(nums, total, i - 1) + recursive(nums, total - nums[i], i - 1);
        }

        memo.put(key, val);

        return val;
    }
}
