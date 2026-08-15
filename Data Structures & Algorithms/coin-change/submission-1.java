class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int INF = 1_000_000_000;

        int[][] dp = new int[n][amount + 1];

        // Base case: ind = 0
        for (int target = 0; target <= amount; target++) {
            if (target % coins[0] == 0)
                dp[0][target] = target / coins[0];
            else
                dp[0][target] = INF;
        }

        // Remaining states
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= amount; target++) {
                // Don't pick
                int unpick = dp[ind - 1][target];

                // Pick
                int pick = INF;

                if (target >= coins[ind]) {
                    pick = 1 + dp[ind][target - coins[ind]];
                }

                dp[ind][target] = Math.min(pick, unpick);
            }
        }

        return dp[n - 1][amount] >= INF ? -1 : dp[n - 1][amount];
    }
}