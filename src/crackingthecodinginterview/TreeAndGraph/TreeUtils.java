package crackingthecodinginterview.TreeAndGraph;

import java.util.HashMap;

/**
 * Created by Bi on 9/2/18.
 */
public class TreeUtils {
    public static void travesalTree(TreeNode root) {
        if (root == null) {
            return;
        }

        travesalTree(root.left);
        System.out.print(root.val + " ");
        travesalTree(root.right);
    }

    public static void traversalTreeInOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        traversalTreeInOrder(root.left);
        traversalTreeInOrder(root.right);
    }

    public static int getSize(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return getSize(root.left) + 1 + getSize(root.right);
    }

    public static TreeNode insertion(TreeNode root, int val) {
        return insertion(null, root, val);
    }

    public static TreeNode insertion(TreeNode parent, TreeNode root, int val) {
        if (root == null) {
            TreeNode newNode = new TreeNode(val);
            newNode.parent = parent;
            return newNode;
        }

        if (root.val <= val) {
            root.right = insertion(root, root.right, val);
        } else {
            root.left = insertion(root, root.left, val);
        }

        root.parent = parent;

        return root;
    }

    public static TreeNode generateBinaryTree(HashMap<Integer, Integer[]> map, int rootVal) {
        TreeNode root = new TreeNode(rootVal);

        HashMap<Integer, TreeNode> mapTree = new HashMap<>();
        mapTree.put(rootVal, root);

        for (int key: map.keySet()) {
            Integer[] vals = map.get(key);
            mapTree.put(vals[0], new TreeNode(vals[0]));
            mapTree.put(vals[1], new TreeNode(vals[1]));
        }

        for (int key: map.keySet()) {
            Integer[] vals = map.get(key);

            mapTree.get(key).left = mapTree.get(vals[0]);
            mapTree.get(key).right = mapTree.get(vals[1]);
        }

        return root;
    }
}
