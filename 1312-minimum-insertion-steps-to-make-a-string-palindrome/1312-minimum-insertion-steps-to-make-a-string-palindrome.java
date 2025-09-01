//OPTIMAL-TABULATION
//Find LCS(s, reverse(s)) = LPS.
//Answer = n - LPS.
//Time: O(n^2)
//Space: O(n^2) (can be reduced to O(n) with rolling arrays)
class Solution {
    public int minInsertions(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i-1) == rev.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        int lps = dp[n][n];
        return n - lps;
    }
}


//BRUTE
/*
Time: O(2^n) (exponential, since many overlapping subproblems)
Space: O(n) (recursion stack)
class Solution {
    public int minInsertions(String s) {
        return helper(s, 0, s.length() - 1);
    }

    private int helper(String s, int i, int j) {
        if (i >= j) return 0;  // single char or empty is palindrome
        if (s.charAt(i) == s.charAt(j)) 
            return helper(s, i + 1, j - 1);
        else 
            return 1 + Math.min(helper(s, i + 1, j), helper(s, i, j - 1));
    }
}
*/

//BETTER
//Time: O(n^2)
//Space: O(n^2) (DP table)
/*
class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(s, 0, n - 1, dp);
    }

    private int helper(String s, int i, int j, int[][] dp) {
        if (i >= j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        
        if (s.charAt(i) == s.charAt(j))
            return dp[i][j] = helper(s, i + 1, j - 1, dp);
        else
            return dp[i][j] = 1 + Math.min(helper(s, i + 1, j, dp),
                                          helper(s, i, j - 1, dp));
    }
}
*/