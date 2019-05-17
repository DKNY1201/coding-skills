package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bi on 5/17/19.
 */
public class ArrayPermutation {
    public static void main(String[] args) {
        List<List<Integer>> permutaion1 = permute(new int[] {1, 2, 3});
        printLists(permutaion1);

        List<List<Integer>> permutaion2 = permute(new int[] {});
        printLists(permutaion2);

        List<List<Integer>> permutaion3 = permute(new int[] {1});
        printLists(permutaion3);

        List<List<Integer>> permutaion4 = permute(new int[] {1,2,3,4,5});
        printLists(permutaion4);
    }

    public static void printLists(List<List<Integer>> lists) {
        System.out.println("Starting print...");
        for (List<Integer> list: lists) {
            for (int item: list) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        List<Integer> chosen = new ArrayList<>();
        List<Integer> remain = new ArrayList<>();

        for (int num: nums) {
            remain.add(num);
        }

        return permuteHelper(chosen, remain, res);
    }

    /**
     *
     * chosen: numbers were chosen to be a part of final permutation
     * remain: numbers remain
     *
     * T(n): O(n!)
     * S(n): O(n)
     */
    public static List<List<Integer>> permuteHelper(List<Integer> chosen, List<Integer> remain, List<List<Integer>> res) {
        if (remain.size() == 0) {
            res.add(new ArrayList<>(chosen));
        } else {
            for (int i = 0; i < remain.size(); i++) {
                // Choose
                int item = remain.get(i);
                remain.remove(i);
                chosen.add(item);

                // Explore
                permuteHelper(chosen, remain, res);

                // Backtrack
                remain.add(i, item);
                chosen.remove(chosen.size() - 1);
            }
        }

        return res;
    }
}
