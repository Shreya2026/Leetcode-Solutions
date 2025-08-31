//Approach 3: Tabulation (Bottom-Up DP)
//Time: O(n*m)
//Space: O(m)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n+1][m+1];

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}


//Approach 1: Brute Force (Recursion)
/*
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return helper(text1, text2, text1.length()-1, text2.length()-1);
    }

    private int helper(String s1, String s2, int i, int j) {
        if (i < 0 || j < 0) return 0;

        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + helper(s1, s2, i-1, j-1);
        } else {
            return Math.max(helper(s1, s2, i-1, j), helper(s1, s2, i, j-1));
        }
    }
}
Time: O(2^(n+m))
Space: O(n+m) (recursion stack)
*/

// Approach 2: Recursion + Memoization (Top-Down DP)
/*
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(text1, text2, n-1, m-1, dp);
    }

    private int helper(String s1, String s2, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + helper(s1, s2, i-1, j-1, dp);
        } else {
            return dp[i][j] = Math.max(helper(s1, s2, i-1, j, dp), helper(s1, s2, i, j-1, dp));
        }
    }
}
Time: O(nm)
Space: O(nm) + O(n+m) (stack)
*/

// Approach 4: Space Optimization
/*
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    curr[j] = 1 + prev[j-1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j-1]);
                }
            }
            prev = curr.clone();
        }
        return prev[m];
    }
}
Time: O(n*m)
Space: O(m)
*/