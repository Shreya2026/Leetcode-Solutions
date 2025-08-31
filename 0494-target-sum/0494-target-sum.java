class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int num : nums) total += num;

        if ((target + total) % 2 != 0 || Math.abs(target) > total) return 0;

        int sum = (target + total) / 2;
        int n = nums.length;

        int[][] dp = new int[n][sum + 1];

        // base case
        if (nums[0] == 0) dp[0][0] = 2;  // +0, -0
        else dp[0][0] = 1;

        if (nums[0] != 0 && nums[0] <= sum) dp[0][nums[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int s = 0; s <= sum; s++) {
                int notTake = dp[i - 1][s];
                int take = 0;
                if (nums[i] <= s) take = dp[i - 1][s - nums[i]];
                dp[i][s] = take + notTake;
            }
        }
        return dp[n - 1][sum];
    }
}


//DP Solution (Subset Sum Count)----Recursive + Memoization
/*
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int num : nums) total += num;

        // (target + total) must be even & non-negative
        if ((target + total) % 2 != 0 || Math.abs(target) > total) return 0;

        int sum = (target + total) / 2;
        int n = nums.length;

        Integer[][] dp = new Integer[n][sum + 1];
        return countSubsets(n - 1, sum, nums, dp);
    }

    private int countSubsets(int i, int target, int[] nums, Integer[][] dp) {
        if (i == 0) {
            if (target == 0 && nums[0] == 0) return 2; // +0, -0
            if (target == 0 || target == nums[0]) return 1;
            return 0;
        }

        if (dp[i][target] != null) return dp[i][target];

        int notTake = countSubsets(i - 1, target, nums, dp);
        int take = 0;
        if (nums[i] <= target) {
            take = countSubsets(i - 1, target - nums[i], nums, dp);
        }

        return dp[i][target] = notTake + take;
    }
}
*/

//Space optimised
/*
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int num : nums) total += num;

        if ((target + total) % 2 != 0 || Math.abs(target) > total) return 0;

        int sum = (target + total) / 2;
        int[] dp = new int[sum + 1];

        if (nums[0] == 0) dp[0] = 2; 
        else dp[0] = 1;

        if (nums[0] != 0 && nums[0] <= sum) dp[nums[0]] = 1;

        for (int i = 1; i < nums.length; i++) {
            int[] cur = new int[sum + 1];
            for (int s = 0; s <= sum; s++) {
                int notTake = dp[s];
                int take = 0;
                if (nums[i] <= s) take = dp[s - nums[i]];
                cur[s] = take + notTake;
            }
            dp = cur;
        }
        return dp[sum];
    }
}
*/