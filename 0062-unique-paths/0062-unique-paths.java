class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0) dp[i][j]=1;
                else{
                    int up=(i>0)?dp[i-1][j]:0;
                    int left=(j>0)?dp[i][j-1]:0;
                    dp[i][j]=up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }
}

//brute-recursion
/*
Time Complexity: O(2^(m+n)) 
Space Complexity: O(m+n) recursion
class Solution {
    public int uniquePaths(int m, int n) {
        return solve(m - 1, n - 1);
    }

    private int solve(int i, int j) {
        if (i == 0 && j == 0) return 1;  // reached start
        if (i < 0 || j < 0) return 0;    // out of bounds
        
        int up = solve(i - 1, j);
        int left = solve(i, j - 1);

        return up + left;
    }
}
*/

//Better (Memoization – Top Down DP)
/*
Time Complexity: O(m*n)
Space Complexity: O(m*n)
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(m - 1, n - 1, dp);
    }

    private int solve(int i, int j, int[][] dp) {
        if (i == 0 && j == 0) return 1;
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int up = solve(i - 1, j, dp);
        int left = solve(i, j - 1, dp);

        return dp[i][j] = up + left;
    }
}
*/