package leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Bi on 9/2/18.
 */
public class GenerateLeaves {
    public static void main(String[] args) {
        HashMap<Integer, Integer[]> mapping1 = new HashMap<Integer, Integer[]>();
        Integer[] childrenA = {1, 2};
        Integer[] childrenB = {3, 4};
        Integer[] childrenC = {5, 6};
        mapping1.put(0, childrenA);
        mapping1.put(1, childrenB);
        mapping1.put(2, childrenC);

        TreeNode head1 = TreeUtils.generateBinaryTree(mapping1, 0);
//        TreeUtils.travesalTree(head1);

        List<Integer> leaves1= generateLeaves(head1);

        for (int i = 0; i < leaves1.size(); i++) {
            System.out.print(leaves1.get(i) + " ");
        }
    }

    public static List<Integer> generateLeaves(TreeNode root) {
        if (root.left == null && root.right == null) {
            List<Integer> re = new ArrayList<>();
            re.add(root.val);
            return re;
        }

        List<Integer> res = new ArrayList<>();

        if (root.left != null) {
            res.addAll(generateLeaves(root.left));
        }

        if (root.right != null) {
            res.addAll(generateLeaves(root.right));
        }

        return res;
    }
}

