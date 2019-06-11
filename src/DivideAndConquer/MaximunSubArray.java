package DivideAndConquer;

/**
 * Created by Bi on 6/11/19.
 */
public class MaximunSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-1, 0, -2}));
    }

    /**
     * Divide and conquer
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return helper(nums, 0, nums.length - 1);
    }

    public static int helper(int[] nums, int l, int r) {
        if (l >= r) {
            return nums[l];
        }

        int m = (l + r) / 2;
        // Find left maximum sub array doesn't contain mid element
        int lMaxSubArr = helper(nums, l, m - 1);
        // Find right maximum sub array doesn't contain mid element
        int rMaxSubArr = helper(nums, m + 1, r);
        // Find maximum sub array contains mid element
        int lMax = nums[m];
        int rMax = nums[m + 1];
        int temp = 0;

        for (int i = m; i >= l; i--) {
            temp += nums[i];
            if (temp > lMax) {
                lMax = temp;
            }
        }

        temp = 0;

        for (int i = m + 1; i <= r; i++) {
            temp += nums[i];
            if (temp > rMax) {
                rMax = temp;
            }
        }
        // Return max value of those three, does not include rMax if less than 0
        return Math.max(Math.max(lMaxSubArr, rMaxSubArr), lMax + (rMax > 0 ? rMax : 0));
    }

    /**
     * Kadane algorithms: maxSubArray(i) = Max(maxSubArray(i - 1), nums[i])
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int max = nums[0], maxSubArrayPre = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = maxSubArrayPre + nums[i];
            // Kadane algorithms
            maxSubArrayPre = Math.max(temp, nums[i]);
            if (maxSubArrayPre > max) {
                max = maxSubArrayPre;
            }
        }

        return max;
    }

    /**
     * Brute force
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }
}
