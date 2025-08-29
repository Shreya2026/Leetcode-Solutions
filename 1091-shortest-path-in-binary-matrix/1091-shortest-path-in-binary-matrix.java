import java.util.*;

public class Solution {
    // 8 possible directions
    private static final int[][] directions = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1},
        {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // If start or end is blocked
        if (grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;

        // BFS queue: {x, y, distance}
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        grid[0][0] = 1; // mark visited

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1], dist = curr[2];

            // If reached destination
            if (x == n-1 && y == n-1) return dist;

            // Explore all directions
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny, dist + 1});
                    grid[nx][ny] = 1; // mark visited
                }
            }
        }
        return -1;
    }
}


//Time: O(N^2) → each cell visited at most once.
//Space: O(N^2) → for queue + visited marking.