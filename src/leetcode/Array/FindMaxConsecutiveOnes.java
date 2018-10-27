package leetcode.Array;

/**
 * Created by Bi on 10/24/18.
 * https://leetcode.com/problems/max-consecutive-ones/description/
 */
public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[] {1,1,0,1,1,1}));
        System.out.println(findMaxConsecutiveOnes(new int[] {1,0,1,1,0,1}));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;

        for (int i: nums) {
            count = i == 0 ? 0 : count + 1;
            if (count > max) max = count;
        }

        return max;
    }
}
