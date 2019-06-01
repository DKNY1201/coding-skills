package Greedy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Bi on 6/1/19.
 */
public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] w = new int[]{1,2,6,8,4};
        int[] v = new int[]{50,40,30,32,12};
        System.out.println(fractionalKnapsack(w,v,10));
    }

    /**
     *  This function only works with fraction is integer. Need to make some small change to work with double
     *
     * @param w - list weights of items
     * @param v - list values if items
     * @param W - limit weight that total weigh can't exceed
     * @return maximum values can get that satisfy problem requirements
     */
    public static int fractionalKnapsack(int[] w, int[] v, int W) {
        if (w.length != v.length || W <= 0) return 0;

        int len = w.length;
        int[] valueOverWeightFraction = new int[len];
        // Map of fraction and weights
        HashMap<Integer, Integer> map = new HashMap<>();

        // Populate values for ratio list and map
        for (int i = 0; i < len; i++) {
            valueOverWeightFraction[i] = v[i] / w[i];
            map.put(valueOverWeightFraction[i], w[i]);
        }

        Arrays.sort(valueOverWeightFraction);
        int maxVal = 0;
        int totalW = 0;

        // Add full value to maxVal if total weight + current weight still under limit weight
        // Add a part of value to maxVal if total weight + current weight over limit weight
        // Stop when total weight over limit
        for (int i = len - 1; i >= 0; i--) {
            int currentW = map.get(valueOverWeightFraction[i]);

            if (totalW + currentW > W) {
                int remain = W - totalW;
                totalW += remain;
                maxVal += remain * valueOverWeightFraction[i];
            } else {
                totalW += currentW;
                maxVal += currentW * valueOverWeightFraction[i];
            }

            if (totalW >= W) {
                break;
            }
        }

        return maxVal;
    }
}
