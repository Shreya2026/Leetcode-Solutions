class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        // {time, row, col}
        pq.offer(new int[]{grid[0][0], 0, 0});

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0], r = cur[1], c = cur[2];

            if (visited[r][c]) continue;
            visited[r][c] = true;

            if (r == n - 1 && c == n - 1)
                return time;

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc]) {
                    int newTime = Math.max(time, grid[nr][nc]);
                    pq.offer(new int[]{newTime, nr, nc});
                }
            }
        }
        return -1;
    }
}


/*
Time Complexity: O(n² log n²) ≈ O(n² log n)

Space Complexity: O(n²) (visited + heap)
*/