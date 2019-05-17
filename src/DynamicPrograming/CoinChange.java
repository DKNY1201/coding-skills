package DynamicPrograming;

/**
 * Created by Bi on 5/7/19.
 */
public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5}, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int[] map = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            int min = -1;
            for (int coin: coins) {
                int temp = i - coin;
                if (coin <= i && map[temp] != -1) {
                    min = min == -1 ? map[temp] + 1 : Math.min(map[temp] + 1, min);
                }
            }
            map[i] = min;
        }

        return map[amount];
    }
}
