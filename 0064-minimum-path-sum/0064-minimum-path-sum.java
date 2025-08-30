class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0) dp[i][j]=grid[0][0];
                else{
                    int up=(i>0)?dp[i-1][j]:Integer.MAX_VALUE;
                    int left=(j>0)?dp[i][j-1]:Integer.MAX_VALUE;
                    dp[i][j]=grid[i][j]+Math.min(up,left);
                }
            }
        }
        return dp[m-1][n-1];
    }
}

//Better (Top-Down DP → Memoization)
/*
 Time: O(mn)
 Space: O(mn) + recursion stack
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row, -1);
        return dfs(m-1, n-1, grid, dp);
    }
    
    private int dfs(int i, int j, int[][] grid, int[][] dp) {
        if(i == 0 && j == 0) return grid[0][0];
        if(i < 0 || j < 0) return Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        
        int up = dfs(i-1, j, grid, dp);
        int left = dfs(i, j-1, grid, dp);
        
        return dp[i][j] = grid[i][j] + Math.min(up, left);
    }
}
*/