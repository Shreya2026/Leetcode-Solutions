class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //step 1:build adjacency list
        List<List<Integer>> adj=new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        
        // Step 2: Fill graph & indegree
        for(int[] pre:prerequisites){
            int course=pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course);
            indegree[course]++;
        } 
         // Step 3: Queue for all indegree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
        
        int count = 0;
        // Step 4: BFS
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            
            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }
        
        // Step 5: If all processed, no cycle
        return count == numCourses;
    }
}