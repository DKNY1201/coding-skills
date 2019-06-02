package Array;

/**
 * Created by Bi on 6/1/19.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{7,2,9,4,3,8,6,10,1};
        int[] sortedArr = mergeSort(nums);
        for (int num: sortedArr) {
            System.out.print(num + " ");
        }
    }

    public static int[] mergeSort(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums;
        }

        return helper(nums, 0, nums.length - 1);
    }

    public static int[] helper(int[] nums, int l, int r) {
        // base case
        if (l >= r) {
            return new int[]{nums[l]};
        }

        int m = (l + r) / 2;
        int[] leftSortedArr = helper(nums, l, m);
        int[] rightSortedArr = helper(nums, m + 1, r);
        int[] sortedArr = merge(leftSortedArr, rightSortedArr);

        return sortedArr;
    }

    public static int[] merge(int[] leftArr, int[] rightArr) {
        int[] res = new int[leftArr.length + rightArr.length];
        int i = 0, j = 0, k = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] < rightArr[j]) {
                res[k++] = leftArr[i++];
            } else {
                res[k++] = rightArr[j++];
            }
        }

        while (i < leftArr.length) {
            res[k++] = leftArr[i++];
        }

        while (j < rightArr.length) {
            res[k++] = rightArr[j++];
        }

        return res;
    }
}
