//Optimal (Space Optimized DP, O(1) Memory)
//Time: O(n)
//Space: O(1)
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int hold = -prices[0];
        int cash = 0;

        for (int i = 1; i < prices.length; i++) {
            hold = Math.max(hold, cash - prices[i]);          // buy or hold
            cash = Math.max(cash, hold + prices[i] - fee);    // sell or skip
        }

        return cash;
    }
}


//Brute Force (Recursion)
/*
class Solution {
    public int maxProfit(int[] prices, int fee) {
        return dfs(prices, fee, 0, true);
    }

    private int dfs(int[] prices, int fee, int idx, boolean canBuy) {
        if (idx == prices.length) return 0;

        if (canBuy) {
            int buy = -prices[idx] + dfs(prices, fee, idx + 1, false);
            int skip = dfs(prices, fee, idx + 1, true);
            return Math.max(buy, skip);
        } else {
            int sell = prices[idx] - fee + dfs(prices, fee, idx + 1, true);
            int skip = dfs(prices, fee, idx + 1, false);
            return Math.max(sell, skip);
        }
    }
}
Time: O(2^n)
Space: O(n) recursion
*/

//Better (DP with Memoization / Tabulation)
/*
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][1] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
            dp[i][0] = Math.max(prices[i] - fee + dp[i + 1][1], dp[i + 1][0]);
        }

        return dp[0][1];
    }
}
Time: O(n)
Space: O(n)
*/