class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] f : flights) {
            graph[f[0]].add(new int[]{f[1], f[2]});
        }

        // dist[node][stops]
        int[][] dist = new int[n][k + 2];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        // {cost, city, stops}
        pq.offer(new int[]{0, src, 0});
        dist[src][0] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], city = cur[1], stops = cur[2];

            if (city == dst) return cost;
            if (stops > k) continue;

            for (int[] nei : graph[city]) {
                int next = nei[0], price = nei[1];
                int newCost = cost + price;

                if (newCost < dist[next][stops + 1]) {
                    dist[next][stops + 1] = newCost;
                    pq.offer(new int[]{newCost, next, stops + 1});
                }
            }
        }
        return -1;
    }
}


/*
Time Complexity:
O(E log (V × K))

Space Complexity:
O(V × K + E)
*/