package crackingthecodinginterview.TreeAndGraph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Bi on 10/2/18.
 */
public class ListOfDepths {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.insertion(null, null, 20);
        root = TreeUtils.insertion(root, 16);
        root = TreeUtils.insertion(root, 24);
        root = TreeUtils.insertion(root, 30);
        root = TreeUtils.insertion(root, 12);
        root = TreeUtils.insertion(root, 8);
        root = TreeUtils.insertion(root, 2);
        root = TreeUtils.insertion(root, 17);
        root = TreeUtils.insertion(root, 27);
        TreeUtils.travesalTree(root);
        System.out.println("");

        List<LinkedList<TreeNode>> lists = generateListOfDepths(root);
        for (LinkedList<TreeNode> list: lists) {
            Iterator<TreeNode> i = list.iterator();

            while (i.hasNext()) {
                System.out.print(i.next().val + " ");
            }

            System.out.println();
        }

        System.out.println("===========");

        List<LinkedList<TreeNode>> lists2 = generateListOfDepthsBFS(root);
        for (LinkedList<TreeNode> list: lists2) {
            Iterator<TreeNode> i = list.iterator();

            while (i.hasNext()) {
                System.out.print(i.next().val + " ");
            }

            System.out.println();
        }
    }

    public static ArrayList<LinkedList<TreeNode>> generateListOfDepths(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        generateListOfDepths(root, lists, 0);
        return lists;
    }

    public static void generateListOfDepths(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> list;
        if (lists.size() == level) { // No LinkedList is created at this level
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);

        generateListOfDepths(root.left, lists, level + 1);
        generateListOfDepths(root.right, lists, level + 1);
    }

    public static ArrayList<LinkedList<TreeNode>> generateListOfDepthsBFS(TreeNode root) {
        if (root == null) {
            return null;
        }

        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();

        LinkedList<TreeNode> current = new LinkedList<>();

        current.add(root);

        while (current.size() > 0) {
            result.add(current);

            LinkedList<TreeNode> parents = current;

            current = new LinkedList<>();

            Iterator<TreeNode> i = parents.iterator();
            while (i.hasNext()) {
                TreeNode parent = i.next();
                if (parent.left != null) {
                    current.add(parent.left);
                }

                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }


        return result;
    }
}
