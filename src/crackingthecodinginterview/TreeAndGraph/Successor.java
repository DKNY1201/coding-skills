package crackingthecodinginterview.TreeAndGraph;

/**
 * Created by Bi on 10/7/18.
 */
public class Successor {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.insertion(null, 20);
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

        System.out.println(findNextNodeInOrder(root.left.left).val);
        System.out.println(findNextNodeInOrder(root.left.right).val);
        System.out.println(findNextNodeInOrder(root).val);
        System.out.println(findNextNodeInOrder(root.right.right));
    }

    public static TreeNode findNextNodeInOrder(TreeNode n) {
        // If n.right != null, return left most node in the right subtree
        if (n.right != null) {
            return findLeftMostNode(n.right);
        } else {
            TreeNode temp = n;
            TreeNode p = temp.parent;

            // Find the node that never traverse though
            while(p != null && p.right == temp) {
                // Go up
                temp = p;
                p = p.parent;
            }

            return p;
        }
    }

    public static TreeNode findLeftMostNode(TreeNode n) {
        while (n.left != null) {
            n = n.left;
        }

        return n;
    }
}
