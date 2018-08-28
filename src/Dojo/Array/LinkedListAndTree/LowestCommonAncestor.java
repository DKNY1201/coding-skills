package Dojo.Array.LinkedListAndTree;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Bi on 8/27/18.
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        HashMap<Integer, Integer[]> mapping1 = new HashMap<Integer, Integer[]>();
        Integer[] childrenA = {1, 2};
        Integer[] childrenB = {3, 4};
        Integer[] childrenC = {5, 6};
        mapping1.put(0, childrenA);
        mapping1.put(1, childrenB);
        mapping1.put(2, childrenC);

        TreeNode head1 = generateBinaryTree(mapping1, 0);

        // This tree is:
        // head1 = 0
        //        / \
        //       1   2
        //      /\   /\
        //     3  4 5  6


        HashMap<Integer, Integer[]> mapping2 = new HashMap<Integer, Integer[]>();
        Integer[] childrenD = {1, 4};
        Integer[] childrenE = {3, 8};
        Integer[] childrenF = {9, 2};
        Integer[] childrenG = {6, 7};
        mapping2.put(5, childrenD);
        mapping2.put(1, childrenE);
        mapping2.put(4, childrenF);
        mapping2.put(3, childrenG);

        TreeNode head2 = generateBinaryTree(mapping2, 5);


        System.out.println(findLowestCommonNode(head1, 1, 5).val); //should return 0
        System.out.println(findLowestCommonNode(head1, 3, 1).val); //should return 1
        System.out.println(findLowestCommonNode(head1, 1, 4).val); //should return 1
        System.out.println(findLowestCommonNode(head1, 0, 5).val); //should return 0
        System.out.println(findLowestCommonNode(head2, 4, 7).val); //should return 5
        System.out.println(findLowestCommonNode(head2, 3, 3).val); //should return 3
        System.out.println(findLowestCommonNode(head2, 8, 7).val); //should return 1
        System.out.println(findLowestCommonNode(head2, 3, 0)); //should return null (0 does not exist in the tree)


    }

    public static TreeNode findLowestCommonNode(TreeNode root, int x, int y) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> pathToX = pathToN(root, x);
        Stack<TreeNode> pathToY = pathToN(root, y);

        if (pathToX == null || pathToY == null) {
            return null;
        }

        TreeNode prevNode = null;
        while (!pathToX.isEmpty() && !pathToY.isEmpty()) {
            if (pathToX.peek().val != pathToY.peek().val) {
                return prevNode;
            }
            prevNode = pathToX.pop();
            pathToY.pop();
        }

        return prevNode;
    }


    public static Stack<TreeNode> pathToN(TreeNode root, int n) {
        if (root == null) return null;
        if (root.val == n) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            return stack;
        }

        Stack<TreeNode> left_path_to_n = pathToN(root.left, n);
        if (left_path_to_n != null) {
            left_path_to_n.push(root);
            return left_path_to_n;
        }

        Stack<TreeNode> right_path_to_n = pathToN(root.right, n);
        if (right_path_to_n != null) {
            right_path_to_n.push(root);
            return right_path_to_n;
        }

        return null;
    }

    public static void printStack(Stack<TreeNode> stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().val + " ");
        }
        System.out.println("");
    }

    public static void travesalTree(TreeNode root) {
        if (root == null) {
            return;
        }

        travesalTree(root.left);
        System.out.print(root.val + " ");
        travesalTree(root.right);
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
