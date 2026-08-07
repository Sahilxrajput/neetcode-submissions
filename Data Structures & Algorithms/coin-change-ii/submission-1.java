class Solution {

    private int knapsack(int ind, int amount, int[] coins, int[][] dp) {
        if (amount == 0) return 1;

        if (ind == 0) {
            return (amount % coins[0] == 0) ? 1 : 0;
        }

        if (dp[ind][amount] != -1) 
            return dp[ind][amount];

        int unpick = knapsack(ind - 1, amount, coins, dp);

        int pick = 0;
        if (amount >= coins[ind]) {
            pick = knapsack(ind, amount - coins[ind], coins, dp);
        }

        return dp[ind][amount] = pick + unpick;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return knapsack(n - 1, amount, coins, dp);
    }
}