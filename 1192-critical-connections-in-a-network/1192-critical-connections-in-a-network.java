class Solution {
    private int time = 0;
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (List<Integer> c : connections) {
            graph[c.get(0)].add(c.get(1));
            graph[c.get(1)].add(c.get(0));
        }

        int[] disc = new int[n];
        int[] low = new int[n];
        Arrays.fill(disc, -1);

        dfs(0, -1, graph, disc, low);
        return result;
    }

    private void dfs(int u, int parent, List<Integer>[] graph, int[] disc, int[] low) {
        disc[u] = low[u] = time++;

        for (int v : graph[u]) {
            if (v == parent) continue;

            if (disc[v] == -1) {
                dfs(v, u, graph, disc, low);
                low[u] = Math.min(low[u], low[v]);

                // Bridge condition
                if (low[v] > disc[u]) {
                    result.add(Arrays.asList(u, v));
                }
            } else {
                // Back edge
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}


/*
Time Complexity: O(n + e)

Space Complexity: O(n + e)
(graph + recursion stack)
*/