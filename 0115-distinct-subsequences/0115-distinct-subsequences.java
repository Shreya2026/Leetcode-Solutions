//Optimal (Tabulation – 2D DP)
//Time: O(m × n)
//Space: O(m × n)
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        long[][] dp = new long[m + 1][n + 1];

        // Base case: empty t can always be formed
        for (int i = 0; i <= m; i++) dp[i][n] = 1;

        // Fill bottom-up
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                long notTake = dp[i + 1][j];
                long take = 0;
                if (s.charAt(i) == t.charAt(j)) {
                    take = dp[i + 1][j + 1];
                }
                dp[i][j] = take + notTake;
            }
        }

        return (int) dp[0][0];
    }
}



//Brute Force (Recursion → Exponential)
//We try all subsequences of s and check if it matches t.
/*
class Solution {
    public int numDistinct(String s, String t) {
        return helper(s, t, 0, 0);
    }

    private int helper(String s, String t, int i, int j) {
        // If t is fully matched
        if (j == t.length()) return 1;
        // If s is exhausted but t still left
        if (i == s.length()) return 0;

        // Choice: skip s[i]
        int notTake = helper(s, t, i + 1, j);

        // Choice: take s[i] if matches
        int take = 0;
        if (s.charAt(i) == t.charAt(j)) {
            take = helper(s, t, i + 1, j + 1);
        }

        return take + notTake;
    }
}
Time: O(2^m) (exponential)
Space: O(m+n) recursion depth
*/

// Better (Recursion + Memoization → DP)
//We use a DP table dp[i][j] = number of subsequences of s[i:] that match t[j:].
/*
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(s, t, 0, 0, dp);
    }

    private int helper(String s, String t, int i, int j, int[][] dp) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int notTake = helper(s, t, i + 1, j, dp);
        int take = 0;
        if (s.charAt(i) == t.charAt(j)) {
            take = helper(s, t, i + 1, j + 1, dp);
        }

        return dp[i][j] = take + notTake;
    }
}
Time: O(m × n)
Space: O(m × n)
*/

//Space Optimized (1D DP)
//Since we only need the next row, we can reduce space to O(n):
/*
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        long[] dp = new long[n + 1];
        dp[n] = 1; // base case

        for (int i = m - 1; i >= 0; i--) {
            long[] next = dp.clone(); // copy previous row
            for (int j = n - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[j] = next[j] + next[j + 1];
                } else {
                    dp[j] = next[j];
                }
            }
        }
        return (int) dp[0];
    }
}
Time: O(m × n)
Space: O(n)
*/