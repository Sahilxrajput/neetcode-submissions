class Solution {
    private int fn(int ind, int amount, int[] coins, Integer[][] dp) {
        if (ind == 0) {
            if (amount % coins[0] == 0)
                return amount / coins[0];

            return (int) 1e9;
        }

        if (dp[ind][amount] != null)
            return dp[ind][amount];

        int pick = (int) 1e9;

        if (amount >= coins[ind]) {
            pick = 1 + fn(ind, amount - coins[ind], coins, dp);
        }

        int unpick = fn(ind - 1, amount, coins, dp);

        return dp[ind][amount] = Math.min(pick, unpick);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Integer[][] dp = new Integer[n][amount+1];

        int ans = fn(n-1, amount, coins, dp);
        return ans >= (int)1e9 ? -1 : ans;
    }
}
