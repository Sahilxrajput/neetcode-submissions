class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        // Edge cases: target + totalSum must be even and non-negative
        if (totalSum < Math.abs(target) || (target + totalSum) % 2 != 0) {
            return 0;
        }

        int s1 = (target + totalSum) / 2;
        
        // 1D DP array for 0/1 Knapsack
        int[] dp = new int[s1 + 1];
        dp[0] = 1; // 1 way to get sum 0 (empty subset)

        for (int num : nums) {
            for (int j = s1; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[s1];
    }
}