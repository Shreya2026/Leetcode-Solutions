class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Step 1: Flood-fill from boundary
        for (int i = 0; i < rows; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, cols - 1);
        }
        for (int j = 0; j < cols; j++) {
            dfs(grid, 0, j);
            dfs(grid, rows - 1, j);
        }
        
        // Step 2: Count remaining land cells
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0; // mark visited
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}


/*
import java.util.*;

class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        // Step 1: Add boundary lands to queue
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 1) { q.add(new int[]{i, 0}); grid[i][0] = 0; }
            if (grid[i][cols - 1] == 1) { q.add(new int[]{i, cols - 1}); grid[i][cols - 1] = 0; }
        }
        for (int j = 0; j < cols; j++) {
            if (grid[0][j] == 1) { q.add(new int[]{0, j}); grid[0][j] = 0; }
            if (grid[rows - 1][j] == 1) { q.add(new int[]{rows - 1, j}); grid[rows - 1][j] = 0; }
        }
        
        // Step 2: BFS to flood-fill boundary connected lands
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            for (int[] d : dirs) {
                int ni = cell[0] + d[0];
                int nj = cell[1] + d[1];
                if (ni >= 0 && nj >= 0 && ni < rows && nj < cols && grid[ni][nj] == 1) {
                    grid[ni][nj] = 0;
                    q.add(new int[]{ni, nj});
                }
            }
        }
        
        // Step 3: Count enclaves
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) count++;
            }
        }
        return count;
    }
}
*/
