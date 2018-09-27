package datastructure;

/**
 * Created by Bi on 9/23/18.
 */
public class BST {
    public static void main(String[] args) {
        TreeNode root = insertion(null, 20);
        root = insertion(root, 16);
        root = insertion(root, 24);
        root = insertion(root, 30);
        root = insertion(root, 12);
        root = insertion(root, 8);
        root = insertion(root, 2);
        root = insertion(root, 17);
        root = insertion(root, 27);
        traverse(root);
        System.out.println("");
        System.out.println(search(root, 17));
        System.out.println(search(root, 18));
    }

    public static void traverse(TreeNode root) {
        if (root != null) {
            traverse(root.left);
            System.out.print(root.val + " ");
            traverse(root.right);
        }
    }

    public static TreeNode insertion(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val <= val) {
            root.right = insertion(root.right, val);
        } else {
            root.left = insertion(root.left, val);
        }

        return root;
    }

    public static boolean search(TreeNode root, int val) {
        if (root == null) {
            return false;
        }

        if (root.val == val) {
            return true;
        }

        if (root.val < val) {
            return search(root.right, val);
        } else  {
            return search(root.left, val);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}