import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Step 1: Build adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        // Step 2: Min-heap for Dijkstra (time, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});

        // Step 3: Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Step 4: Dijkstra
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], node = curr[1];

            if (time > dist[node]) continue; // Skip outdated entries

            if (!graph.containsKey(node)) continue;
            for (int[] nei : graph.get(node)) {
                int v = nei[0], w = nei[1];
                if (dist[node] + w < dist[v]) {
                    dist[v] = dist[node] + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        // Step 5: Find maximum time
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}
