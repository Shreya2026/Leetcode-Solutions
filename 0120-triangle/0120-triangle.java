//OPTIMAL-TABULATION-BOTTOM UP
//Time: O(n^2)
//Space: O(n^2)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int j=0;j<n;j++){
            dp[n-1][j]=triangle.get(n-1).get(j);
        }

        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int diag = triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(down, diag);
            }
        }
        return dp[0][0];
    }
}

//BRUTE FORCE
/*
Time: O(2^n)
Space: O(n) (recursion stack)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return solve(0, 0, triangle);
    }
    private int solve(int i, int j, List<List<Integer>> triangle) {
        // Base: last row
        if (i == triangle.size() - 1) return triangle.get(i).get(j);

        int down = triangle.get(i).get(j) + solve(i+1, j, triangle);
        int diag = triangle.get(i).get(j) + solve(i+1, j+1, triangle);

        return Math.min(down, diag);
    }
}
*/

//BETTER - MEMOIZATION-TOP DOWN
/*
Time: O(n^2)
Space: O(n^2) + recursion stack
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];
        return solve(0, 0, triangle, dp);
    }
    private int solve(int i, int j, List<List<Integer>> triangle, Integer[][] dp) {
        if (i == triangle.size() - 1) return triangle.get(i).get(j);
        if (dp[i][j] != null) return dp[i][j];

        int down = triangle.get(i).get(j) + solve(i+1, j, triangle, dp);
        int diag = triangle.get(i).get(j) + solve(i+1, j+1, triangle, dp);

        return dp[i][j] = Math.min(down, diag);
    }
}
*/

//Super Optimal (Space Optimized)
/*
Time: O(n^2)
Space: O(n)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        // Base: last row
        for (int j = 0; j < n; j++) {
            dp[j] = triangle.get(n-1).get(j);
        }

        // From bottom-1 to top
        for (int i = n-2; i >= 0; i--) {
            int[] temp = new int[n];
            for (int j = 0; j <= i; j++) {
                int down = triangle.get(i).get(j) + dp[j];
                int diag = triangle.get(i).get(j) + dp[j+1];
                temp[j] = Math.min(down, diag);
            }
            dp = temp;
        }

        return dp[0];
    }
}
*/