package leetcode.Array;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Bi on 11/2/18.
 * https://leetcode.com/problems/3sum/description/
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> three = threeSum(nums);

        for (int i = 0; i < three.size(); i++) {
            for (int j = 0; j < three.get(i).size(); j++) {
                System.out.print(three.get(i).get(j) + " ");
            }

            System.out.println("");
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int l = i + 1;
                int r = nums.length - 1;

                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));

                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;

                        l++; r--;
                    } else if (sum > 0) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }

        return res;
    }

    public static int[] getUniqueSortedArr(int[] nums) {
        Arrays.sort(nums);

        Stack<Integer> s = new Stack<>();
        s.push(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (s.peek() != nums[i]) {
                s.push(nums[i]);
            }
        }

        int[] res = new int[s.size()];
        int idx = s.size() - 1;

        while (!s.isEmpty()) {
            res[idx--] = s.pop();
        }

        return res;
    }
}
