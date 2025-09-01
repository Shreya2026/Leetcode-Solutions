//Optimal (Tabulation → Bottom-Up DP)
//Time: O(m*n)
//Space: O(M*n)
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // base cases
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],  // replace
                                Math.min(dp[i - 1][j],        // delete
                                         dp[i][j - 1]));      // insert
                }
            }
        }
        return dp[m][n];
    }
}



//Brute Force (Recursion)
//We try all possibilities for each mismatch:
/*
class Solution {
    private int solve(String s1, String s2, int i, int j) {
        // if one string is empty, cost = other string length
        if (i == s1.length()) return s2.length() - j;
        if (j == s2.length()) return s1.length() - i;

        if (s1.charAt(i) == s2.charAt(j)) {
            return solve(s1, s2, i + 1, j + 1); // no operation
        } else {
            // try insert, delete, replace
            int insert = 1 + solve(s1, s2, i, j + 1);
            int delete = 1 + solve(s1, s2, i + 1, j);
            int replace = 1 + solve(s1, s2, i + 1, j + 1);
            return Math.min(insert, Math.min(delete, replace));
        }
    }

    public int minDistance(String word1, String word2) {
        return solve(word1, word2, 0, 0);
    }
}
Time: O(3^(m+n)) (each mismatch branches 3 ways)
Space: O(m+n) recursion depth
*/

//Better (Recursion + Memoization → Top-Down DP)
//We cache overlapping subproblems with dp[i][j].
/*
class Solution {
    private int solve(String s1, String s2, int i, int j, int[][] dp) {
        if (i == s1.length()) return s2.length() - j;
        if (j == s2.length()) return s1.length() - i;
        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = solve(s1, s2, i + 1, j + 1, dp);
        } else {
            int insert = 1 + solve(s1, s2, i, j + 1, dp);
            int delete = 1 + solve(s1, s2, i + 1, j, dp);
            int replace = 1 + solve(s1, s2, i + 1, j + 1, dp);
            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(word1, word2, 0, 0, dp);
    }
}
Time: O(m*n)
Space: O(m*n) + O(m+n) recursion
*/

//Space Optimized (2 Rows → 1D Array)
//Only the previous row is needed.
/*
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] prev = new int[n + 1], curr = new int[n + 1];

        for (int j = 0; j <= n; j++) prev[j] = j;

        for (int i = 1; i <= m; i++) {
            curr[0] = i;
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = 1 + Math.min(prev[j - 1], 
                                Math.min(prev[j], curr[j - 1]));
                }
            }
            prev = curr.clone();
        }
        return prev[n];
    }
}
Time: O(m*n)
Space: O(n)
*/
