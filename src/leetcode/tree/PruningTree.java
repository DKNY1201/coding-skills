package leetcode.tree;

/**
 * Created by Bi on 10/23/18.
 * https://leetcode.com/problems/binary-tree-pruning/
 */
public class PruningTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.left.left.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        TreeUtils.travesalTree(root);
        System.out.println("");

        TreeUtils.travesalTree(pruningTree(root));
    }

    public static TreeNode pruningTree(TreeNode root) {
        if (root == null) return null;

        if (isZeroTree(root.left)) root.left = null;
        else pruningTree(root.left);

        if (isZeroTree(root.right)) root.right = null;
        else pruningTree(root.right);

        return root;
    }

    public static boolean isZeroTree(TreeNode root) {
        if (root == null) return true;
        return root.val == 0 && isZeroTree(root.left) && isZeroTree(root.right);
    }
}
