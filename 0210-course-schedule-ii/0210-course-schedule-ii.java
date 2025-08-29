import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course);
        }

        // Step 2: Calculate indegree
        int[] indegree = new int[numCourses];
        for (int u = 0; u < numCourses; u++) {
            for (int v : adj.get(u)) {
                indegree[v]++;
            }
        }

        // Step 3: Queue for indegree = 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        // Step 4: Topological Order
        int[] order = new int[numCourses];
        int idx = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            order[idx++] = node;

            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        // Step 5: If cycle exists → return []
        if (idx != numCourses) return new int[0];

        return order;
    }
}
