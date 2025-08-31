//Optimal (Tabulation – Bottom Up DP)
// Time: O(n^2)
// Space: O(n^2)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[][] dp=new int[n][n];
        
        //base case
        for(int j=0;j<n;j++) dp[n-1][j]=matrix[n-1][j];

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int down = matrix[i][j] + dp[i + 1][j];
                int left = matrix[i][j] + (j > 0 ? dp[i + 1][j - 1] : (int)1e9);
                int right = matrix[i][j] + (j < n - 1 ? dp[i + 1][j + 1] : (int)1e9);

                dp[i][j]=Math.min(down,Math.min(left,right));
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) ans = Math.min(ans, dp[0][j]);
        return ans;
    }
}

//BRUTE FORCE - RECURSION-TLE
/*
class Solution {
    private int dfs(int[][] matrix, int i, int j) {
        int n = matrix.length;
        if (j < 0 || j >= n) return (int)1e9; // invalid
        if (i == n - 1) return matrix[i][j];

        int down = matrix[i][j] + dfs(matrix, i + 1, j);
        int left = matrix[i][j] + dfs(matrix, i + 1, j - 1);
        int right = matrix[i][j] + dfs(matrix, i + 1, j + 1);

        return Math.min(down, Math.min(left, right));
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dfs(matrix, 0, j));
        }
        return min;
    }
}
Time: O(3^n) → exponential
Space: O(n) recursion stack
*/

//BETTER-MEMOIZATION
/*
class Solution {
    private int dfs(int[][] matrix, int i, int j, int[][] dp) {
        int n = matrix.length;
        if (j < 0 || j >= n) return (int)1e9;
        if (i == n - 1) return matrix[i][j];
        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        int down = matrix[i][j] + dfs(matrix, i + 1, j, dp);
        int left = matrix[i][j] + dfs(matrix, i + 1, j - 1, dp);
        int right = matrix[i][j] + dfs(matrix, i + 1, j + 1, dp);

        return dp[i][j] = Math.min(down, Math.min(left, right));
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dfs(matrix, 0, j, dp));
        }
        return min;
    }
}
 Time: O(n^2)
 Space: O(n^2) + O(n) recursion
*/