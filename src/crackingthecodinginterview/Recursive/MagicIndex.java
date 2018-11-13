package crackingthecodinginterview.Recursive;

/**
 * Created by Bi on 11/12/18.
 */
public class MagicIndex {
    public static void main(String[] args) {
        System.out.println(magicIndex(new int[] {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13}));
        System.out.println(magicIndexDupsAllow(new int[] {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13}));
        System.out.println(magicIndexDupsAllow(new int[] {-10, -5, 0, 1, 2, 3, 4, 8, 9, 12, 13}));
    }

    public static int magicIndex(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        return magicIndexHelper(arr, 0, arr.length - 1);
    }

    public static int magicIndexHelper(int[] arr, int l, int r) {
        if (l > r) return -1;
        int m = (l + r) / 2;
        if (arr[m] == m) return m;
        else if (arr[m] < m) return magicIndexHelper(arr, m + 1, r);
        return magicIndexHelper(arr, l, m - 1);
    }

    public static int magicIndexDupsAllow(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        return magicIndexDupsAllowHelper(arr, 0, arr.length - 1);
    }

    public static int magicIndexDupsAllowHelper(int[] arr, int l, int r) {
        if (l > r) return -1;

        int m = (l + r) / 2;
        if (arr[m] == m) return m;

        int lIdx = magicIndexDupsAllowHelper(arr, l, Math.min(arr[m], m - 1));
        if (lIdx != -1) return lIdx;
        return magicIndexDupsAllowHelper(arr, Math.max(arr[m], m + 1), r);
    }
}
