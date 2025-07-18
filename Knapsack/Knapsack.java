import java.util.*;

class Knapsack {

    int maximumValue(int maximumWeight, List<Item> items) {
        int n = items.size();
        int[][] dp = new int[n + 1][maximumWeight + 1];

        for (int i = 1; i <= n; i++) {
            Item current = items.get(i - 1);

            for (int w = 0; w <= maximumWeight; w++) {

                if (current.weight > w) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(
                        dp[i - 1][w],
                        current.value + dp[i - 1][w - current.weight]
                    );
                }
            }
        }

        return dp[n][maximumWeight];
    }

}
