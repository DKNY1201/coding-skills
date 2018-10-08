package crackingthecodinginterview.TreeAndGraph;

/**
 * Created by Bi on 10/7/18.
 */
public class MaximunBinaryTree {
    public static void main(String[] args) {
        int[] nums = new int[] {3,2,1,6,0,5};
        TreeNode node = constructMaximumBinaryTree(nums);
        TreeUtils.travesalTree(node);
        System.out.println("");
        TreeUtils.traversalTreeInOrder(node);
        System.out.println("");
        System.out.println(node.right.val);
        System.out.println("");
//        System.out.println(node.right.left.val);
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums, int l, int r) {
        if (l == r) {
            return new TreeNode(nums[l]);
        } else if (l > r) {
            return null;
        }

        int i = findMaxIdx(nums, l, r);

        TreeNode n = new TreeNode(nums[i]);
        n.left = constructMaximumBinaryTree(nums, l, i - 1);
        n.right = constructMaximumBinaryTree(nums, i + 1, r);

        return n;
    }

    public static int findMaxIdx(int[] nums, int l, int r) {
        if (nums == null || nums.length == 0 || l > r) {
            return -1;
        }
        int maxIdx = 0;
        int max = Integer.MIN_VALUE;

        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }

        return maxIdx;
    }
}
