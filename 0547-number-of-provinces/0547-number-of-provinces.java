//DFS SOLUTION
//Time Complexity: O(n²) (since we may traverse the whole matrix).
//Space Complexity: O(n) (visited array + recursion stack).

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(isConnected, visited, i);
                provinces++;
            }
        }
        return provinces;
    }

    private void dfs(int[][] isConnected,boolean[] visited,int city){
        visited[city]=true;
        for(int j=0;j<isConnected.length;j++){
            if (isConnected[city][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j);
        }
    }
    }
}



/*
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int city = queue.poll();
                    visited[city] = true;
                    for (int j = 0; j < n; j++) {
                        if (isConnected[city][j] == 1 && !visited[j]) {
                            queue.offer(j);
                        }
                    }
                }
                provinces++;
            }
        }
        return provinces;
    }
}*/

//DO LEETCODE200 NOW