package BackTracking;

/**
 * Created by Bi on 1/15/19.
 */
public class PrintSubSets {
    public static void main(String[] args) {
        printAllSubSets(new int[] {1,2,3});
    }

    public static void printAllSubSets(int[] nums) {
        helper(nums, new int[nums.length], 0);
    }

    public static void helper(int[] nums, int[] subset, int idx) {
        if (idx == nums.length) {
            printSet(subset);
            return;
        }

        subset[idx] = -1;
        helper(nums, subset, idx + 1);
        subset[idx] = nums[idx];
        helper(nums, subset, idx + 1);
    }

    public static void printSet(int[] set) {
        for (int n: set) {
            if (n != -1) {
                System.out.print(n + " ");
            }
        }
        System.out.println("");
    }
}
