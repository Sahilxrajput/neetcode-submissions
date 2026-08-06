class Solution {
    int backtrack(int i, int[] nums, int currentSum, int target, int totalSum, Integer[][] dp) {
        if (i == nums.length) {
            return currentSum == target ? 1 : 0;
        }

        // Shift index by totalSum to avoid negative array indices
        if (dp[i][currentSum + totalSum] != null) {
            return dp[i][currentSum + totalSum];
        }

        int add = backtrack(i + 1, nums, currentSum + nums[i], target, totalSum, dp);
        int sub = backtrack(i + 1, nums, currentSum - nums[i], target, totalSum, dp);

        return dp[i][currentSum + totalSum] = add + sub;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        if (Math.abs(target) > totalSum)
            return 0;

        Integer[][] dp = new Integer[nums.length][2 * totalSum + 1];

        return backtrack(0, nums, 0, target, totalSum, dp);
    }
}