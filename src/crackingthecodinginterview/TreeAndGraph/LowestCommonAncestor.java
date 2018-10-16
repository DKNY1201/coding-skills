package crackingthecodinginterview.TreeAndGraph;

import java.util.Stack;

/**
 * Created by Bi on 10/15/18.
 */
public class LowestCommonAncestor {
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
        System.out.println(lowestCommonAncestor(root, root.left.left.left, root.left.right).val);
        System.out.println("");
        System.out.println(lowestCommonAncestor2(root, root.left.left.left, root.left.right).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!isCover(root, p) || !isCover(root, q)) {
            return null;
        }

        return lowestCommonAncestorHelper(root, p, q);
    }

    public static TreeNode lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        boolean isPInLeft = isCover(root.left, p);
        boolean isQInLeft = isCover(root.left, q);

        if (isPInLeft != isQInLeft) {
            return root;
        }

        TreeNode next = isPInLeft ? root.left : root.right;

        return lowestCommonAncestor(next, p, q);
    }

    public static boolean isCover(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }

        if (root == p) {
            return true;
        }

        return isCover(root.left, p) || isCover(root.right, p);
    }

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pathToP = findPathToX(root, p);
        Stack<TreeNode> pathToQ = findPathToX(root, q);

        TreeNode lastEqualNode = null;
        while (!pathToP.isEmpty() && !pathToQ.isEmpty()) {
            if (pathToP.peek() == pathToQ.peek()) {
                lastEqualNode = pathToP.pop();
                pathToQ.pop();
            } else {
                break;
            }
        }

        return lastEqualNode;
    }


    public static Stack<TreeNode> findPathToX(TreeNode root, TreeNode x) {
        if (root == null) {
            return null;
        }

        if (root == x) {
            Stack<TreeNode> s = new Stack<>();
            s.add(x);
            return s;
        }

        Stack<TreeNode> l = findPathToX(root.left, x);
        if (l != null) {
            l.add(root);
            return l;
        }

        Stack<TreeNode> r = findPathToX(root.right, x);
        if (r != null) {
            r.add(root);
            return r;
        }
        return null;
    }
}
