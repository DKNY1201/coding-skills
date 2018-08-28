package Dojo.Array.LinkedListAndTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Bi on 8/23/18.
 */
public class IsBinarySearchTree {
    public static void main(String[] args) {
        HashMap<Integer, Integer[]> map = new HashMap<>();
        map.put(0, new Integer[] {1,2});
        map.put(1, new Integer[] {3,4});
        map.put(2, new Integer[] {5,6});

        TreeNode root1 = generateBinaryTree(map, 0);

        HashMap<Integer, Integer[]> map2 = new HashMap<>();
        map2.put(24, new Integer[] {12,40});
        map2.put(12, new Integer[] {6,19});
        map2.put(40, new Integer[] {30,50});

        TreeNode root2 = generateBinaryTree(map2, 24);

        travesalTree(root1);
        System.out.println("");
        travesalTree(root2);
        System.out.println("");

        System.out.println(isBinaryTree(root1, null, null));
        System.out.println(isBinaryTree(root2, null, null));

        System.out.println(isBinaryTree2(root1));
        System.out.println(isBinaryTree2(root2));
    }

    public static boolean isBinaryTree(TreeNode node, Integer lower_limit, Integer upper_limit) {
        if (lower_limit != null && node.val < lower_limit) {
            return false;
        }

        if (upper_limit != null && node.val > upper_limit) {
            return false;
        }

        boolean is_bst_left = true;
        boolean is_bst_right = true;

        if (node.left != null) {
            is_bst_left = isBinaryTree(node.left, lower_limit, node.val);
        }

        if (is_bst_left && node.right != null) {
            is_bst_right = isBinaryTree(node.right, node.val, upper_limit);
        }

        return is_bst_left && is_bst_right;
    }

    public static boolean isBinaryTree2(TreeNode node) {
        List<Integer> list = getListOfBinaryTree(node);

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    public static void travesalTree(TreeNode root) {
        if (root == null) {
            return;
        }

        travesalTree(root.left);
        System.out.print(root.val + " ");
        travesalTree(root.right);
    }

    public static List<Integer> getListOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        return getListOfBinaryTree(root, list);
    }

    public static List<Integer> getListOfBinaryTree(TreeNode root, List<Integer> list) {
        if (root == null) {
            return null;
        }

        getListOfBinaryTree(root.left, list);
        list.add(root.val);
        getListOfBinaryTree(root.right, list);
        return list;
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
