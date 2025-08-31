//Optimal (Tabulation – Bottom Up)
//Time: O(n * target)
//Space: O(n * target)
class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int num:nums){
            total+=num;
        }
        if(total%2!=0) return false;

        int target = total / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n][target + 1];

        // Base cases
        for (int i = 0; i < n; i++) dp[i][0] = true;
        if (nums[0] <= target) dp[0][nums[0]] = true;

        for(int i=1;i<n;i++){
            for(int t=1;t<=target;t++){
                boolean notTake = dp[i - 1][t];
                boolean take = false;
                if (nums[i] <= t) take = dp[i - 1][t - nums[i]];
                dp[i][t] = take || notTake;
            }
        }
        return dp[n-1][target];
    }
}


//Brute Force (Recursion)
/*
class Solution {
    public boolean subsetSum(int[] arr, int target) {
        return helper(arr, arr.length - 1, target);
    }

    private boolean helper(int[] arr, int i, int target) {
        // base cases
        if (target == 0) return true;   // subset found
        if (i < 0) return false;        // no elements left

        // not take
        boolean notTake = helper(arr, i - 1, target);

        // take (only if arr[i] <= target)
        boolean take = false;
        if (arr[i] <= target) {
            take = helper(arr, i - 1, target - arr[i]);
        }

        return take || notTake;
    }
}
TC: O(2^n)
SC: O(n) (recursion stack)
*/

//DP (Top-Down Memoization)
/*
import java.util.*;
class Solution {
    Boolean[][] dp;

    public boolean subsetSum(int[] arr, int target) {
        int n = arr.length;
        dp = new Boolean[n][target + 1];
        return helper(arr, n - 1, target);
    }

    private boolean helper(int[] arr, int i, int target) {
        if (target == 0) return true;
        if (i < 0) return false;

        if (dp[i][target] != null) return dp[i][target];

        boolean notTake = helper(arr, i - 1, target);
        boolean take = false;
        if (arr[i] <= target) {
            take = helper(arr, i - 1, target - arr[i]);
        }

        return dp[i][target] = take || notTake;
    }
}
TC: O(n × target)
SC: O(n × target) + O(n) recursion stack
*/

//Space Optimization (Optional but Nice)
/*
class Solution {
    public boolean subsetSum(int[] arr, int target) {
        boolean[] prev = new boolean[target + 1];
        prev[0] = true;

        if (arr[0] <= target) prev[arr[0]] = true;

        for (int i = 1; i < arr.length; i++) {
            boolean[] cur = new boolean[target + 1];
            cur[0] = true;
            for (int sum = 1; sum <= target; sum++) {
                boolean notTake = prev[sum];
                boolean take = false;
                if (arr[i] <= sum) take = prev[sum - arr[i]];
                cur[sum] = take || notTake;
            }
            prev = cur;
        }
        return prev[target];
    }
}
TC: O(n × target)
SC: O(target)
*/