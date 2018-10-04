package crackingthecodinginterview.TreeAndGraph;

/**
 * Created by Bi on 10/3/18.
 */
public class CheckBalance {
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
        root = TreeUtils.insertion(root, 22);
        root = TreeUtils.insertion(root, 14);
        root = TreeUtils.insertion(root, 18);
        TreeUtils.travesalTree(root);
        System.out.println("");
        System.out.println("checkBalance: " + checkBalance(root));
        System.out.println("isBalance: " + isBalance(root));
    }

    public static boolean checkBalance(TreeNode root) {
        return checkBalanceRes(root).truthy;
    }

    public static Result checkBalanceRes(TreeNode root) {
        if (root == null) {
            return new Result(true, 0);
        }

        Result l = checkBalanceRes(root.left);
        Result r = checkBalanceRes(root.right);

        if (!l.truthy || !r.truthy) {
            return new Result(false, -1);
        }

        boolean truthy = Math.abs(l.height - r.height) <= 1;
        int height = (l.height > r.height ? l.height : r.height) + 1;

        return new Result(truthy, height);
    }

    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return (getHeight(root.left) > getHeight(root.right) ? getHeight(root.left) : getHeight(root.right)) + 1;
    }

    public static boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }

        int lHeight = getHeight(root.left);
        int rHeight = getHeight(root.right);

        if (Math.abs(lHeight - rHeight) > 1) {
            return false;
        }

        return isBalance(root.left) && isBalance(root.right);
    }
}

class Result {
    public boolean truthy;
    public int height;

    public Result(boolean truthy, int height) {
        this.truthy = truthy;
        this.height = height;
    }
}
