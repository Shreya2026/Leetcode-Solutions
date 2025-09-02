//Better – DP Memoization
//TC: O(n·2) = O(n)
//SC: O(n·2) = O(n)
class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] dp = new Integer[prices.length][2];
        return helper(prices, 0, 0, dp);
    }

    private int helper(int[] prices, int i, int holding, Integer[][] dp) {
        if (i == prices.length) return 0;
        if (dp[i][holding] != null) return dp[i][holding];

        int skip = helper(prices, i + 1, holding, dp);
        if (holding == 1) {
            // sell
            int sell = prices[i] + helper(prices, i + 1, 0, dp);
            return dp[i][holding] = Math.max(skip, sell);
        } else {
            // buy
            int buy = -prices[i] + helper(prices, i + 1, 1, dp);
            return dp[i][holding] = Math.max(skip, buy);
        }
    }
}


/*
Brute Force (Exponential Recursion)

Try all possibilities: on each day, either

buy → then sell later,

skip the day.

class Solution {
    public int maxProfit(int[] prices) {
        return helper(prices, 0, false);
    }

    private int helper(int[] prices, int i, boolean holding) {
        if (i == prices.length) return 0;

        int skip = helper(prices, i + 1, holding);

        if (holding) {
            // sell
            int sell = prices[i] + helper(prices, i + 1, false);
            return Math.max(skip, sell);
        } else {
            // buy
            int buy = -prices[i] + helper(prices, i + 1, true);
            return Math.max(skip, buy);
        }
    }
}


⏱ TC: O(2ⁿ)
\U0001f4e6 SC: O(n) recursion stack*/

/*
Optimal – Greedy

We can notice: Every upward slope can be profit.
So whenever prices[i] > prices[i-1], add (prices[i] - prices[i-1]) to profit.

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}


⏱ TC: O(n)
\U0001f4e6 SC: O(1)*/