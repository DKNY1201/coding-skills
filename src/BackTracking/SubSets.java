package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bi on 5/19/19.
 */
public class SubSets {
    public static void main(String[] args) {
        subsets(new int[] {1,2,3});
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums.length == 0) {
            return res;
        }

        helper(nums, res, new ArrayList<>(), 0);

        return res;
    }

    public static void helper(int[] nums, List<List<Integer>> res, List<Integer> temp, int start) {
        res.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            // Add current one to temp list
            temp.add(nums[i]);
            // Generate all subsets start with items in 'temp' list
            helper(nums, res, temp, start + 1);
            // Remove current one to add next one to result list
            temp.remove(temp.size() - 1);
        }
    }
}
