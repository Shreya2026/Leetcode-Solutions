// Optimal (Tabulation + Space Optimization)
//Time: O(n * amount)
//Space: O(amount)
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        
        // Base: amount = 0 → 1 way (pick nothing)
        for (int i = 0; i <= n; i++) dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int t = 0; t <= amount; t++) {
                int notTake = dp[i - 1][t];
                int take = 0;
                if (coins[i - 1] <= t) take = dp[i][t - coins[i - 1]];
                dp[i][t] = take + notTake;
            }
        }
        return dp[n][amount];
    }
}




//Brute Force (Recursion)
/*
class Solution {
    public int change(int amount, int[] coins) {
        return dfs(0, amount, coins);
    }

    private int dfs(int i, int target, int[] coins) {
        if (target == 0) return 1;      // one valid way
        if (i == coins.length) return 0; // no coins left

        int notTake = dfs(i + 1, target, coins);
        int take = 0;
        if (coins[i] <= target) take = dfs(i, target - coins[i], coins);

        return take + notTake;
    }
}

Time Complexity: O(2^n) worst case
Space: O(n) (recursion stack)
*/

//Better (Memoization)
/*
class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length][amount + 1];
        return dfs(0, amount, coins, dp);
    }

    private int dfs(int i, int target, int[] coins, Integer[][] dp) {
        if (target == 0) return 1;
        if (i == coins.length) return 0;
        if (dp[i][target] != null) return dp[i][target];

        int notTake = dfs(i + 1, target, coins, dp);
        int take = 0;
        if (coins[i] <= target) take = dfs(i, target - coins[i], coins, dp);

        return dp[i][target] = take + notTake;
    }
}

Time: O(n * amount)
Space: O(n * amount) + O(n) recursion
*/

//Space Optimized (1D DP) – Best
/*
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // one way to make 0

        for (int coin : coins) {
            for (int t = coin; t <= amount; t++) {
                dp[t] += dp[t - coin];
            }
        }
        return dp[amount];
    }
}
Complexity: O(n * amount)
Space: O(amount) (Optimal)
*/
