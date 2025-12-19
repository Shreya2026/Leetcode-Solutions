class Solution {
    static final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] r : roads) {
            graph[r[0]].add(new int[]{r[1], r[2]});
            graph[r[1]].add(new int[]{r[0], r[2]});
        }

        long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new long[]{0, 0}); // {distance, node}

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int node = (int) cur[1];

            if (d > dist[node]) continue;

            for (int[] edge : graph[node]) {
                int next = edge[0];
                long wt = edge[1];
                long newDist = d + wt;

                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    ways[next] = ways[node];
                    pq.offer(new long[]{newDist, next});
                } else if (newDist == dist[next]) {
                    ways[next] = (ways[next] + ways[node]) % MOD;
                }
            }
        }

        return (int) (ways[n - 1] % MOD);
    }
}


/*
Time Complexity: O(E log V)

Space Complexity: O(V + E)
*/