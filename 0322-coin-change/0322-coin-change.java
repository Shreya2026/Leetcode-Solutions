//OPTIMAL TABULATION
//Time: O(N * amount)
//Space: O(amount)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, (int)1e9);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return dp[amount]==(int)1e9?-1:dp[amount];
    }
}

//Brute Force (Recursion – Try All Choices)-TLE
/*
class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans = solve(coins, amount);
        return ans == (int)1e9 ? -1 : ans; // if impossible
    }

    private int solve(int[] coins, int target) {
        if (target == 0) return 0;
        if (target < 0) return (int)1e9;  // invalid case

        int min = (int)1e9;
        for (int coin : coins) {
            min = Math.min(min, 1 + solve(coins, target - coin));
        }
        return min;
    }
}
*/

//Better (Recursion + Memoization – Top Down)
//Time: O(N * amount)
//Space: O(amount) + recursion stack
/*
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int ans = solve(coins, amount, dp);
        return ans == (int)1e9 ? -1 : ans;
    }

    private int solve(int[] coins, int target, int[] dp) {
        if (target == 0) return 0;
        if (target < 0) return (int)1e9;
        if (dp[target] != -1) return dp[target];

        int min = (int)1e9;
        for (int coin : coins) {
            min = Math.min(min, 1 + solve(coins, target - coin, dp));
        }
        return dp[target] = min;
    }
}
*/

