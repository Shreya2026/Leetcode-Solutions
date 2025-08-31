//Optimal (Tabulation – DP)
//We build bottom-up using dp[i][j] = length of LPS in substring s[i..j].
//Time: O(n^2)
//Space: O(n^2)
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // base case: single chars are palindromes
        for (int i = 0; i < n; i++) dp[i][i] = 1;

        // check substrings of increasing length
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + (i+1 <= j-1 ? dp[i+1][j-1] : 0);
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        return dp[0][n-1];
    }
}


//Brute Force (Recursion)
//We try all possibilities: If s[i] == s[j], include them → 2 + solve(i+1, j-1).Otherwise, try skipping one character → max(solve(i+1, j), solve(i, j-1)).
/*
class Solution {
    public int longestPalindromeSubseq(String s) {
        return solve(s, 0, s.length()-1);
    }

    private int solve(String s, int i, int j) {
        if (i > j) return 0;
        if (i == j) return 1;

        if (s.charAt(i) == s.charAt(j)) {
            return 2 + solve(s, i+1, j-1);
        } else {
            return Math.max(solve(s, i+1, j), solve(s, i, j-1));
        }
    }
}
Time: O(2^n) (exponential).
Space: O(n) recursion depth.
*/

// Better (Recursion + Memoization)
//We cache results in dp[i][j] to avoid recomputation.
/*
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        Integer[][] dp = new Integer[n][n];
        return solve(s, 0, n-1, dp);
    }

    private int solve(String s, int i, int j, Integer[][] dp) {
        if (i > j) return 0;
        if (i == j) return 1;

        if (dp[i][j] != null) return dp[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 2 + solve(s, i+1, j-1, dp);
        } else {
            return dp[i][j] = Math.max(solve(s, i+1, j, dp), solve(s, i, j-1, dp));
        }
    }
}
Time: O(n^2) (all pairs i,j solved once).
Space: O(n^2) DP + O(n) recursion stack.
*/



//Most Optimal (Space Optimized – 1D)
//Since dp[i][j] only depends on dp[i+1][j-1], dp[i+1][j], dp[i][j-1], we can compress to 1D arrays.
/*
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[] prev = new int[n], curr = new int[n];

        for (int i = n-1; i >= 0; i--) {
            curr[i] = 1; // single char
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    curr[j] = 2 + prev[j-1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j-1]);
                }
            }
            prev = curr.clone();
        }

        return prev[n-1];
    }
}
Time: O(n^2)
Space: O(n)
*/