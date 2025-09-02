//Optimal (Space Optimized DP, O(1) Memory)
//Time: O(n)
//Space: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int hold = -prices[0]; // buying on day 0
        int sold = 0;          // just sold today
        int rest = 0;          // cooldown or doing nothing

        for (int i = 1; i < n; i++) {
            int prevSold = sold;

            sold = hold + prices[i];          // sell today
            hold = Math.max(hold, rest - prices[i]); // buy today or keep holding
            rest = Math.max(rest, prevSold);  // cooldown or continue resting
        }

        return Math.max(sold, rest); // can't end with holding
    }
}



//Brute Force (Recursion)

/*
class Solution {
    public int maxProfit(int[] prices) {
        return dfs(prices, 0, true);
    }

    private int dfs(int[] prices, int idx, boolean canBuy) {
        if (idx >= prices.length) return 0;

        if (canBuy) {
            // Buy or Skip
            int buy = -prices[idx] + dfs(prices, idx + 1, false);
            int skip = dfs(prices, idx + 1, true);
            return Math.max(buy, skip);
        } else {
            // Sell or Skip
            int sell = prices[idx] + dfs(prices, idx + 2, true); // cooldown after selling
            int skip = dfs(prices, idx + 1, false);
            return Math.max(sell, skip);
        }
    }
}
Time: O(2^n)
Space: O(n) recursion
*/

//Better (DP with Memoization / Tabulation)
//Define dp[idx][canBuy] = max profit starting from day idx with option to buy or not.
//If canBuy:
//dp[i][1] = max(-prices[i] + dp[i+1][0], dp[i+1][1])

//If canSell:
//dp[i][0] = max(prices[i] + dp[i+2][1], dp[i+1][0])
/*
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2]; // +2 for handling cooldown

        for (int i = n - 1; i >= 0; i--) {
            dp[i][1] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
            dp[i][0] = Math.max(prices[i] + dp[i + 2][1], dp[i + 1][0]);
        }

        return dp[0][1];
    }
}
Time: O(n)
Space: O(n)
*/