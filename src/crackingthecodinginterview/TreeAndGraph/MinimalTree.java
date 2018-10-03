package crackingthecodinginterview.TreeAndGraph;

/**
 * Created by Bi on 10/2/18.
 */
public class MinimalTree {
    public static void main(String[] args) {
        TreeNode root = generateMinimalTree(new int[] {0,1,2,6,9,10,12,14,16});
        TreeUtils.traversalTreeInOrder(root);
    }

    public static TreeNode generateMinimalTree(int[] sortedArr) {
        return generateMinimalTree(sortedArr, 0, sortedArr.length - 1);
    }

    public static TreeNode generateMinimalTree(int[] arr, int l, int r) {
        if (l > r) {
            return null;
        }

        int m = (l + r) / 2;

        TreeNode n = new TreeNode(arr[m]);

        n.left = generateMinimalTree(arr, l, m - 1);
        n.right = generateMinimalTree(arr, m + 1, r);

        return n;
    }
}
