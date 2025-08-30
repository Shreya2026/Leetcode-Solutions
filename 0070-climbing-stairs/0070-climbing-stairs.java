//Space Optimised--
//Time Complexity: O(n)
//Space Complexity: O(1) → Best solution.
class Solution {
    public int climbStairs(int n) {
        if(n<=1) return 1;
        int prev2=1,prev1=1;
        int curr=0;
        for(int i=2;i<=n;i++){
            curr=prev1+prev2;
            prev2=prev1;
            prev1=curr;
        }
        return curr;
    }
    
}

/*
Time Complexity: O(2^n) (exponential, because each call branches into two).
Space Complexity: O(n) (recursion stack).
class Solution {
    public int climbStairs(int n) {
        if (n <= 1) return 1; // base case
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
*/

//better - top down memoization
/*
Time Complexity: O(n)
Space Complexity: O(n) (dp + recursion stack).
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return solve(n, dp);
    }

    private int solve(int n, int[] dp) {
        if (n <= 1) return 1;
        if (dp[n] != 0) return dp[n];
        dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
        return dp[n];
    }
}
*/

//optimal-tabulation bottom up
/*
Time Complexity: O(n)
Space Complexity: O(n)
class Solution {
    public int climbStairs(int n) {
        if (n <= 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
*/