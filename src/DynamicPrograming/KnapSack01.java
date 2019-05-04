package DynamicPrograming;

import java.util.HashMap;

/**
 * Created by Bi on 5/2/19.
 */
public class KnapSack01 {
    public static void main(String[] args) {
        int res = knapSack01(new int[] {5, 4, 6, 3}, new int[] {10, 40, 30, 50}, 10);
        int res1 = knapSack01(new int[] {1, 3, 4, 5}, new int[] {1, 4, 5, 7}, 7);
        System.out.println(res);
        System.out.println(res1);
    }

    public static int knapSack01(int[] w, int[] v, int total) {
//        return recursive(w, v, total, w.length - 1);
        return memoize(w, v, total, w.length - 1, new HashMap<String, Integer>());
//        return bottomUp(w, v, total);
    }

    public static int recursive(int[] w, int[] v, int total, int i) {
        // Base case
        if (i == 0) {
            if (total < w[i]) return 0;
            return v[i];
        }

        // Recursive case
        if (total < w[i]) return recursive(w, v, total, i - 1);

        return Math.max(recursive(w, v, total, i - 1), v[i] + recursive(w, v, total - w[i], i - 1));
    }

    public static int memoize(int[] w, int[] v, int total, int i, HashMap<String, Integer> map) {
        String key = total + ":" + i;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        // Base case
        if (i == 0) {
            if (total < w[i]) return 0;
            return v[i];
        }

        // Recursive case
        int res;

        if (total < w[i]){
            res = recursive(w, v, total, i - 1);
        }

        res = Math.max(recursive(w, v, total, i - 1), v[i] + recursive(w, v, total - w[i], i - 1));
        map.put(key, res);

        return res;
    }

    public static int bottomUp(int[] w, int[] v, int total) {
        int[][] table = new int[w.length + 1][total + 1];

        for (int i = 1; i <= w.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (w[i - 1] > j) {
                    table[i][j] = table[i - 1][j];
                } else {
                    table[i][j] = Math.max(v[i - 1] + table[i - 1][j - w[i - 1]], table[i - 1][j]);
                }
            }
        }

        return table[w.length][total];
    }
}
