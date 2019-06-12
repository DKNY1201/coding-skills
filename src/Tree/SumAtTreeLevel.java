package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Bi on 6/11/19.
 * https://start.interviewing.io/interview/0LTTr0v5NKrD/replay
 */
public class SumAtTreeLevel {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(11);
        TreeNode node6 = new TreeNode(13);
        TreeNode node7 = new TreeNode(14);
        TreeNode node8 = new TreeNode(5);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node3.left = node7;
        node5.left = node8;

        System.out.println(sumAtTreeLevel(root, 3, 1));
        System.out.println(sumAtTreeLevelIter(root, 4));
    }

    /**
     * Recursive solution
     *
     * @param root
     * @param lvl
     * @param curLvl
     * @return
     */
    public static int sumAtTreeLevel(TreeNode root, int lvl, int curLvl) {
        if (root == null) return 0;
        if (curLvl == lvl) return root.val;

        return sumAtTreeLevel(root.left, lvl, curLvl + 1) + sumAtTreeLevel(root.right, lvl, curLvl + 1);
    }

    public static int sumAtTreeLevelIter(TreeNode root, int lvl) {
        root.lvl = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int total = 0;

        while (!queue.isEmpty()) {
            TreeNode curNode = queue.remove();

            if (curNode.lvl == lvl) {
                total += curNode.val;
            } else if (curNode.lvl < lvl) {
                if (curNode.left != null) {
                    curNode.left.lvl = curNode.lvl + 1;
                    queue.add(curNode.left);
                }

                if (curNode.right != null) {
                    curNode.right.lvl = curNode.lvl + 1;
                    queue.add(curNode.right);
                }
            }
        }

        return total;
    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public int lvl;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
