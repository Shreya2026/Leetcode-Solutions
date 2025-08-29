//\U0001f539 Complexity

//Time: O(V + E) → process each node & edge once.
//Space: O(V + E) for reverse graph + queue.

import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        
        // Step 1: Build reverse graph
        List<List<Integer>> revGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) revGraph.add(new ArrayList<>());
        
        int[] indegree = new int[n];  // indegree in reverse graph
        
        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                revGraph.get(v).add(u);  // reverse edge
                indegree[u]++;           // original u had outgoing edge → indegree in reversed
            }
        }
        
        // Step 2: Queue for nodes with indegree 0 (terminal nodes)
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
        
        // Step 3: Kahn’s Algorithm on reverse graph
        boolean[] safe = new boolean[n];
        while (!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true; // node is safe
            
            for (int nei : revGraph.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }
        
        // Step 4: Collect safe nodes
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) ans.add(i);
        }
        
        return ans;
    }
}
