package crackingthecodinginterview.TreeAndGraph;

/**
 * Created by Bi on 10/4/18.
 */
public class IsBST {
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
        System.out.println(TreeUtils.getSize(root));
        System.out.println(isBST(root));
        System.out.println(isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    // Solution 1
    static int index = 0;
    public static void copyTreeToArray(TreeNode root, int[] arr) {
        if (root == null) {
            return;
        }

        copyTreeToArray(root.left, arr);
        arr[index++] = root.val;
        copyTreeToArray(root.right, arr);
    }

    public static boolean isBST(TreeNode root) {
        int[] arr = new int[TreeUtils.getSize(root)];
        copyTreeToArray(root, arr);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }

        return true;
    }

    // Solution 2. MIN MAX
    public static boolean isValidBST(TreeNode root, int min, int max) {
        if (root == null) return true;

        if (min != Integer.MIN_VALUE && root.val < min || max != Integer.MAX_VALUE && root.val >= max) {
            return false;
        }

        if (!isValidBST(root.left, min, root.val) || !isValidBST(root.right, root.val, max)) {
            return false;
        }

        return true;
    }
}
