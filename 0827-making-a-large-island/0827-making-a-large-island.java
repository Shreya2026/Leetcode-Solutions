class Solution {
    int n;
    int[][] grid;
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        n = grid.length;

        Map<Integer, Integer> areaMap = new HashMap<>();
        int islandId = 2; // start from 2 to avoid confusion with 0/1
        int maxArea = 0;

        // Step 1: Label islands
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(i, j, islandId);
                    areaMap.put(islandId, area);
                    maxArea = Math.max(maxArea, area);
                    islandId++;
                }
            }
        }

        // Step 2: Try flipping each 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> seen = new HashSet<>();
                    int newArea = 1;

                    for (int d = 0; d < 4; d++) {
                        int ni = i + dr[d];
                        int nj = j + dc[d];

                        if (ni >= 0 && nj >= 0 && ni < n && nj < n) {
                            int id = grid[ni][nj];
                            if (id > 1 && seen.add(id)) {
                                newArea += areaMap.get(id);
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, newArea);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int r, int c, int id) {
        if (r < 0 || c < 0 || r >= n || c >= n || grid[r][c] != 1)
            return 0;

        grid[r][c] = id;
        int area = 1;

        for (int d = 0; d < 4; d++) {
            area += dfs(r + dr[d], c + dc[d], id);
        }
        return area;
    }
}


/*
Time Complexity: O(n²)
(Each cell visited constant number of times)

Space Complexity: O(n²)
(DFS recursion + hashmap)
*/